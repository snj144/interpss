package org.interpss.vstab.cpf.impl;
/**
 * This is a helper class to conduct internal operations of Continuous Power Flow(CPF),
 * including prediction, correction and automatic step size control.
 */

import org.apache.commons.math.linear.RealMatrix;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.sparse.SparseEqnMatrix2x2;
import com.interpss.core.sparse.impl.SparseEqnMatrix2x2Impl;

public class CpfHelper {
	private RealMatrix operatingLFResult=null;
	private RealMatrix predResult=null;
	private RealMatrix corrResult=null;
	private double stepSize=0;
	private IPSSMsgHub msg=null;
	
	private AclfNetwork net=null;
    
	public CpfHelper(AclfNetwork _net){
		this.net=_net;
	}
    public RealMatrix getPredictedResult(double stepLength){
    	 //1. get the jacobian matrix (Swing bus is included in jacobi,so the dimension(N) equals to total number of buses, and index is 1 to N )
    	SparseEqnMatrix2x2 jacobi=this.net.formJMatrix(this.msg);
    	
    	/*
    	 *  2. augment the Jacobi with the differentiation of load flow equation 
    	 *  to Lamda(the load  increase index) 
    	 */
        int n= jacobi.getDimension();
        SparseEqnMatrix2x2 jacobiPlus=new SparseEqnMatrix2x2Impl(n+1);
        for(int i=1;i<n+1;i++) {
        	for(int j=1;j<n+1;i++) {
        		Matrix_xy aij=jacobi.getElement(i, j);
        		jacobiPlus.setAij(aij, i, j);
        	}
        }
        for(int i=1;i<n+1;i++) {
        	//for the df/dLambda, the result is influenced by load increase patten
            
        }
    	
    	// 3. solve Jau*[dx,dLamda]T=[0,+-1]
    	
    	/* 4. get the predicted result by solving the following:
    	   new[x,Lambda]=lastsetp[x,Lambda]+stepLength*[dx,dLambda]
    	*/
		return predResult;
    
    }
    
    public RealMatrix getCorrectedResult(){
    	/*
    	 * 1. augment the traditional power flow equation with continuous parameter equation
    	 * 2. solve the augmented equation:[f(x,lambda),xl-xl_fixed]T=0
    	 */  
    	return corrResult;
    	
    }
    
    public double getOptimStep(){
    	
    	return stepSize;
    	
    }
    
    
}
