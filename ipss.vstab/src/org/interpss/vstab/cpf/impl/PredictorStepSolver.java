package org.interpss.vstab.cpf.impl;
import java.util.Iterator;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.RealVector;
import org.interpss.vstab.cpf.AbstractStepSolver;

import com.interpss.common.datatype.Vector_xy;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;


public class PredictorStepSolver extends AbstractStepSolver{
	protected boolean isCrossMPP=false;
	private final double DEFAULT_STEP_SIZE=0.3;
	private double stepSize=DEFAULT_STEP_SIZE;
	private CpfHelper cpfHelper=null;
	private ArrayRealVector deltaX_Lambda=null;
	
	public PredictorStepSolver(AclfNetwork net,IPSSMsgHub msg) {
		super(net, msg);
		cpfHelper=new CpfHelper(net,msg);
	}
    
    private boolean calDeltaPredResult() throws InterpssException{
    
   	this.augmentedJacobi=cpfHelper.formAugmJacobiMatrix();

     //  3. set the [B] elements(right-hand side of Jacobian matrix) to [0,+-1] ,
     //   only the element corresponding to Continuous parameter is set to +1,or -1, depending on the slope of continuous parameter
   	
    int contPara=getSortNumofContParam();
    int contParaSign=getContParaSign();  
    augmentedJacobi.setBi(new Complex(1*contParaSign,0),contPara);

     // 4. solve Jau*[dx,dLamda]T=[0,+-1]
     
    if (!augmentedJacobi.luMatrixAndSolveEqn(this.tolerance, msg)) {
    	return false;
    }
    
	// 5. save tangent vector result to DeltaX_Lamba
 
    saveDeltaRslt2Vctr();
    
    return true;
    }
    

    public boolean isCrossMaxPwrPnt() {
    	// only sign of Lambda is used for judgment.
    	if(this.sortNumofContParam!=this.net.getNoBus()+1) {
    		if(deltaX_Lambda.getEntry(deltaX_Lambda.getDimension())<0)
    			return this.isCrossMPP=true;
    	}
    	return this.isCrossMPP=false;
    }
    private int getContParaSign() {
    	if(isCrossMaxPwrPnt()) {
    		return  +1;
    	}
    	else return -1;
    }
    private void saveDeltaRslt2Vctr() {
    	this.deltaX_Lambda=new ArrayRealVector(this.augmentedJacobi.getDimension()-1); // swing bus is included
    	int i=0;
    	for (Iterator localIterator = this.net.getBusList().iterator(); localIterator.hasNext(); ) { Bus b = (Bus)localIterator.next();
            AclfBus bus = (AclfBus)b;
            i=b.getSortNumber();
            Vector_xy dv=this.augmentedJacobi.getBVect_xy(i);   
            this.deltaX_Lambda.setEntry(2*1-2, dv.x);
            this.deltaX_Lambda.setEntry(2*i-1, dv.y);
        }
    	i=this.augmentedJacobi.getDimension()-1; // lambda index 
    	double deltaL=this.augmentedJacobi.getBVect_xy(i).x;
        this.deltaX_Lambda.setEntry(i, deltaL);
    }

}
