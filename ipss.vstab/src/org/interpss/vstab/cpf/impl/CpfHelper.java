package org.interpss.vstab.cpf.impl;
/**
 * This is a helper class to conduct internal operations of Continuous Power Flow(CPF),
 * including prediction, correction and automatic step size control.
 */

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;
import com.interpss.core.sparse.SparseEqnMatrix2x2;
import com.interpss.core.sparse.impl.SparseEqnMatrix2x2Impl;

public class CpfHelper {
	private RealVector operatingLFResult=null;
	private RealVector predResult=null;
	private RealVector corrResult=null;
	private double stepSize=0;
	private Complex busLoadIncDir=null;
	private RealVector loadIncDirVector=null;
	private IPSSMsgHub msg=null;
	
	private AclfNetwork net=null;
    
	public CpfHelper(AclfNetwork _net){
		this.net=_net;
	}
    public RealVector getPredictedResult(double stepLength){
    	 //1. get the jacobian matrix (Swing bus is included in jacobi,so the dimension(N) equals to total number of buses, and index is 1 to N )
    	SparseEqnMatrix2x2 jacobi=this.net.formJMatrix(this.msg);
    	
    	
    	/*
    	 *  2. augment the Jacobi with the differentiation of load flow equation 
    	 *  to Lamda(the load  increase index) 
    	 */
    	
    	int n=jacobi.getDimension()/2;
    	jacobi.increaseDimension(); //2n->2n+2
        for(Bus b:this.net.getBusList()) {
        	Matrix_xy m=jacobi.getElement(b.getSortNumber(), n+1);
        	
        }

  
        for(int i=1;i<=net.getNoActiveBus();i++) {
        	//for the df/dLambda, the result is influenced by load increase patten
            
        }
    	
    	// 3. solve Jau*[dx,dLamda]T=[0,+-1]
    	
    	/* 4. get the predicted result by solving the following:
    	   new[x,Lambda]=lastsetp[x,Lambda]+stepLength*[dx,dLambda]
    	*/
		return predResult;
    
    }
    
    public RealVector getCorrectedResult(){
    	/*
    	 * 1. augment the traditional power flow equation with continuous parameter equation
    	 * 2. solve the augmented equation:[f(x,lambda),xl-xl_fixed]T=0
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
	
    
    
}
