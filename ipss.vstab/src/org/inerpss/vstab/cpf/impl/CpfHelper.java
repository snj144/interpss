package org.inerpss.vstab.cpf.impl;
/**
 * This is a helper class to conduct internal operations of Continuous Power Flow(CPF),
 * including prediction, correction and automatic step size control.
 */

import org.apache.commons.math.linear.RealMatrix;

import com.interpss.core.aclf.AclfNetwork;

public class CpfHelper {
	private RealMatrix operatingLFResult=null;
	private RealMatrix predResult=null;
	private RealMatrix corrResult=null;
	private double stepSize=0;
	
	private AclfNetwork net=null;
    
	public CpfHelper(AclfNetwork _net){
		this.net=_net;
	}
    public RealMatrix getPredictedResult(double stepLength){
    	 //1. get the jacobian matrix 
    	
    	// 2. augment the Jacobi with the differentiation of load flow equation to Lamda(the load ang generation increase index) 
        
    	
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
