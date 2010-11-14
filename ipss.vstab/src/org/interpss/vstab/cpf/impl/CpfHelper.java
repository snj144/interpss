package org.interpss.vstab.cpf.impl;
/**
 * This is a helper class to conduct internal operations of Continuous Power Flow(CPF),
 * including prediction, correction and automatic step size control.
 */

import java.util.Hashtable;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;
import org.interpss.vstab.cpf.AclfBus4CPF;
import org.interpss.vstab.cpf.LoadIncPatten;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;
import com.interpss.core.sparse.SparseEqnMatrix2x2;
import com.interpss.core.sparse.impl.SparseEqnMatrix2x2Impl;

public class CpfHelper {
	private RealVector operatingLFResult=null;
	private RealVector oldResult=null;
	private RealVector predResult=null;
	private RealVector deltaX_Lambda=null;
	private RealVector corrResult=null;
	private double stepSize=0;
	private Complex busLoadIncDir=null;
	private RealVector loadIncDirVector=null;
	private final int DEFAULT_CONT_PARA_SORTNUM=0;
	private int contParaSortNum=DEFAULT_CONT_PARA_SORTNUM;
	private int iterationCount=0;
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
    private void calDeltaPredResult(){
    /**
   	  * 1. get the jacobian matrix (Swing bus is included in jacobi,so the dimension(N) equals to total number of buses, and index is 1 to N )
   	  */
   	SparseEqnMatrix2x2 jacobi=this.net.formJMatrix(this.msg);
   	
   	
   	/**
   	 *  2. augment the Jacobi with the differentiation of load flow equation 
   	 *  to Lamda(the load  increase index) 
   	 */
   	
   	int n=jacobi.getDimension()/2; //n=num of bus
   	
   	jacobi.increaseDimension(); //2n->2n+2
   	Hashtable<String, Bus> incLdBusTbl=ldIncPtn.getIncLoadBusTbl();
       for(Bus b:this.net.getBusList()) {
       	if(incLdBusTbl.containsValue(b)) {
       		AclfBus4CPF bus=(AclfBus4CPF) b;
       		Matrix_xy m=new Matrix_xy();
       		if(bus.isActive()) {
       			m.xx=-bus.getLoadPIncDir();
       			m.yx=-bus.getLoadQIncDir();
       		}
       		jacobi.setAij(m,b.getSortNumber(), n+1);
       	}
       	
       }
       Matrix_xy ek=new Matrix_xy();
       ek.xx=1;
       ek.yy=1;
       jacobi.setAij(ek, n+1, n+1);
       
       
 
   	
   	/**
   	 * 3. set the [B] elements(right-hand side of Jacobian matrix) to [0,+-1] ,
   	 * only the element corresponding to Continuous parameter is set to 1
   	 */
       
    /**
     * 4. solve Jau*[dx,dLamda]T=[0,+-1]
     */
       
    }
    
    public RealVector getDeltaPreResult() {
    	
    	return deltaX_Lambda;
    }
    
    public RealVector getCorrectedResult(){
    	/*
    	 * 1. augment the traditional power flow equation with continuous parameter equation
    	 * 2. solve the augmented equation set:[f(x,lambda),xl-xl_fixed]T=0
    	 */  
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
    private void findContParameter() {
    	if(this.iterationCount==0) {
    		this.contParaSortNum=this.net.getNoBus()+1;
    	}
    	else {
    		
    	}
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
    
    
}
