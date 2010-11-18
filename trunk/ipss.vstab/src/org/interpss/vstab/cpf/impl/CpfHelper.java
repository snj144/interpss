package org.interpss.vstab.cpf.impl;
/**
 * This is a helper class to conduct internal operations of Continuous Power Flow(CPF),
 * including prediction, correction and automatic step size control.
 */

import java.util.Hashtable;
import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.RealVector;
import java.util.Iterator;
import org.interpss.vstab.cpf.AclfBus4CPF;
import org.interpss.vstab.cpf.LoadIncPatten;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.common.datatype.Vector_xy;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.common.visitor.IAclfBusVisitor;
import com.interpss.core.net.Bus;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

public class CpfHelper {
	private SparseEqnMatrix2x2 lfEqn=null;
	private RealVector operatingLFResult=null;
	private RealVector oldResult=null;
	private RealVector predResult=null;
	private RealVector deltaX_Lambda=null;
	private RealVector corrResult=null;
	private double DEFAULT_CPF_STEPSIZE=0.2;
	private double stepSize=DEFAULT_CPF_STEPSIZE;
	private Complex busLoadIncDir=null;
	private RealVector loadIncDirVector=null;
	
	private final int DEFAULT_CONT_PARA_SORTNUM=0;
	private int contParaSortNum=DEFAULT_CONT_PARA_SORTNUM;
	private final boolean DEFAULT_CROSS_MPP=false;
    private boolean crossMaxPwrPnt=DEFAULT_CROSS_MPP;
    
	private int iterationCount=0;
	private double DEFAULT_CPFSOLVER_TOLEARNCE=9.95e-21;
	private double tolerance=DEFAULT_CPFSOLVER_TOLEARNCE;
	private IPSSMsgHub msg=null;
	private AclfNetwork net=null;
	
	private LoadIncPatten ldIncPtn=null;
	
    
	public CpfHelper(AclfNetwork net, IPSSMsgHub msg){
		this.net=net;
		this.msg=msg;
	}
	public void setLoadIncPtn(LoadIncPatten loadIncPtn) {
		if(loadIncPtn!=null) { 
			this.ldIncPtn=loadIncPtn;
		}
		else {
			this.msg.sendErrorMsg("The input LoadIncPatten is Null, please check and define it properly first");
		}
		
	}
	
	/**
	 * get the predicted result by solving the following equation:
	   new[x,Lambda]=lastsetp[x,Lambda]+stepLength*LambdaSign*[dx,dLambda]
	   @param stepLength, lamdaSign
	   @return result of prediction step
	*/
    public RealVector getPredictedResult(double stepLength, int lamdaSign){
    	 return this.predResult=this.oldResult.add(this.getDeltaPreResult().mapMultiply(stepLength*lamdaSign));
    	 
    }
    private boolean calDeltaPredResult() throws InterpssException{
    
   	// 1. get the jacobian matrix (Swing bus is included in jacobi,so the dimension(N) equals to total number of buses, and index is 1 to N )
   	  
   	lfEqn=this.net.formJMatrix(this.msg);
   	 	
   	//2. augment the Jacobi with the differentiation of load flow equation 
   	// to Lamda(the load  increase index) 
   	
   	int n=lfEqn.getDimension()/2; //n=num of bus
   	
   	lfEqn.increaseDimension(); //2n->2n+2
   	Hashtable<String, Bus> incLdBusTbl=ldIncPtn.getIncLoadBusTbl();
       for(Bus b:this.net.getBusList()) {
       	if(incLdBusTbl.containsValue(b)) {
       		AclfBus4CPF bus=(AclfBus4CPF) b;
       		Matrix_xy m=new Matrix_xy();
       		if(bus.isActive()) {
       			m.xx=-bus.getLoadPIncDir();
       			m.yx=-bus.getLoadQIncDir();
       		}
       		lfEqn.setAij(m,b.getSortNumber(), n+1);
       	}
       	
       }
       Matrix_xy ek=new Matrix_xy();
       ek.xx=1;
       ek.yy=1;
       lfEqn.setAij(ek, n+1, n+1);

     //  3. set the [B] elements(right-hand side of Jacobian matrix) to [0,+-1] ,
     //   only the element corresponding to Continuous parameter is set to +1,or -1, depending on the slope of continuous parameter
   	
    int contPara=getContParameter();
    int contParaSign=getContParaSign();  
    lfEqn.setBi(new Complex(1*contParaSign,0),contPara);

     // 4. solve Jau*[dx,dLamda]T=[0,+-1]
     
    if (!lfEqn.luMatrixAndSolveEqn(this.tolerance, msg)) {
    	return false;
    }
    
	// 5. save tangent vector result to DeltaX_Lamba
 
    saveDeltaRslt2Vctr();
    return true;
    }
    
    public RealVector getDeltaPreResult() {
    	
    	return deltaX_Lambda;
    }
    public boolean correctStep(){
    	/*
    	 * 1. augment the traditional power flow equation with continuous parameter equation
    	 * 2. solve the augmented equation set:[f(x,lambda),xl-xl_fixed]T=0
    	 */ 
    	
		return true;
    	
    }
    public RealVector getCorrectedResult(){
     
    	return corrResult;
    	
    }
    
    public double getOptimStep(){
    	
    	return stepSize;
    	
    }
    
    
	public Complex getLoadIncDirection(int BusSortNumber) {
		// To do
		
		return null;
		
		
	}
	public void setLoadIncDirVector(RealVector newLoadIncDirVector) {
		this.loadIncDirVector=newLoadIncDirVector;
		
	}
	public RealVector getLoadIncDirVector() {
		return this.loadIncDirVector;
	}
	
	public void genGovernorResponse() {
		// calculate Load-Gen Mismatch
		// distribute the mismatch according to governor Response
	}
	
	public void AGC() {
		// To do
	}
	
	public void increaseLoad(double lambda) {
		//To do
	}
	/**
	 * @return sortNumber of the continuous parameter
	 * 
	 */
    private int getContParameter() {
    	if(this.iterationCount==0) {
    		this.contParaSortNum=this.net.getNoBus()+1;
    	}
    	else {
    		// contPara=max(i){|deltaXi/Xi|,|deltaL/Lambda|}
    		int maxIdx=getVectorMaxIndex(this.deltaX_Lambda.ebeDivide(this.corrResult));
    		 // if Lambda is chosen the parameter, sort number of the corresponding continuation parameter  is set to be N+1;
    		if(maxIdx>this.net.getNoBus()*2-1) {
    			this.contParaSortNum=this.net.getNoBus()+1;
    		}
    		else {
    			// select the bus voltage parameter as Cont' Parameter, find the right Sort Number
    			//while considering the storage structure (Vector_xy) and sort number index (1,2, ^ ,N)
    			if(maxIdx%2==0) {
    				this.contParaSortNum=maxIdx/2+1; 
    			}
    			else {
    				this.contParaSortNum=(maxIdx+1)/2;
    			}
    		}
    		  
    		
    	}
		return contParaSortNum;
    }
    public int getIterationCount() {
    	return this.iterationCount;
    }
    public void updateIterationCount() {
    	this.iterationCount+=1;
    }
    public void setIterCountToZero() {
    	this.iterationCount=0;
    }
    private int getVectorMaxIndex(RealVector vector){
    	int maxIdx=0;
    	double max=Math.abs(vector.getEntry(0));
    	for(int i=1;i<vector.getDimension();i++) {
    		if(max<Math.abs(vector.getEntry(i))){
    			max=Math.abs(vector.getEntry(i));
    			maxIdx=i;
    		}	
    	}
    	return maxIdx;
    	
    }
    private int getContParaSign() {
    	if(isCrossMaxPwrPnt()) {
    		return  +1;
    	}
    	else return -1;
    }
    public boolean isCrossMaxPwrPnt() {
    	// only sign of Lambda is used for judgment.
    	if(this.contParaSortNum!=this.net.getNoBus()+1) {
    		if(deltaX_Lambda.getEntry(deltaX_Lambda.getDimension())<0)
    			return this.crossMaxPwrPnt=true;
    	}
    	return this.crossMaxPwrPnt=false;
    }
    private void updateBusVoltage(final SparseEqnMatrix2x2 lfEqn,final double step) {
    	this.net.forEachAclfBus(new IAclfBusVisitor() {

			public void visit(AclfBus bus) {
				if((!bus.isSwing())&(bus.isActive())) {
					Vector_xy dv=lfEqn.getBVect_xy(bus.getSortNumber());
					
					Complex v= bus.getVoltage(); 
				    double vang=bus.getVoltageAng()-step*dv.x;
				    double vmag=bus.getVoltageMag();
				    if(!bus.isGenPV()) {
					   vmag-=step*dv.y;
				     }
				 bus.setVoltage(vmag,vang);
			   }
		   }
    		
    	});
    }
    private void saveDeltaRslt2Vctr() {
    	this.deltaX_Lambda=new ArrayRealVector(lfEqn.getDimension()-1); // swing bus is included
    	int i=0;
    	for (Iterator localIterator = this.net.getBusList().iterator(); localIterator.hasNext(); ) { Bus b = (Bus)localIterator.next();
            AclfBus bus = (AclfBus)b;
            i=b.getSortNumber();
            Vector_xy dv=lfEqn.getBVect_xy(i);   
            this.deltaX_Lambda.setEntry(2*1-2, dv.x);
            this.deltaX_Lambda.setEntry(2*i-1, dv.y);
        }
    	i=lfEqn.getDimension()-1; // lambda index 
    	double deltaL=lfEqn.getBVect_xy(i).x;
        this.deltaX_Lambda.setEntry(i, deltaL);
    }
}
