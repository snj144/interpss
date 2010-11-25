package org.interpss.vstab.cpf.impl;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

public class LambdaParam {
	/**
	 * A class about Lambda Parameter, the load (and may generation in the future) increase index
	 * mainly including the operations involving in the J-matrix
	 *  
	 *     n - The Lambda parameter position in the J-matrix
	 * 
	 * @author Tony Huang
	 *
	 */
	private int n;
	private double val=0;
    public LambdaParam(int position,double value) {
    	this.n=position;
    	val=value;
    	
    }
	/**
	 * @return the sortNumber
	 */
	public int getPosition() {
		return n;
	}
	/**
	 * @param n the n to set
	 */
	public void setPosition(int sortNum) {
		this.n = sortNum;
	}
	/**
	 * @return the value of Lambda Parameter
	 */
	public double getVal() {
		return val;
	}
	/**
	 * @param valOfLambdaParam the valOfLambdaParam to set
	 */
	public void setVal(double valOfLambdaParam) {
		this.val = valOfLambdaParam;
	}
	public void update(SparseEqnMatrix2x2 lfEqn) {
	    
		this.val+=lfEqn.getBVect_xy(n).x;
	}
	public void update(SparseEqnMatrix2x2 lfEqn, double stepSize) {
		System.out.println("lambda before update"+this.val);
		this.val+=stepSize*lfEqn.getBVect_xy(n).x;
		System.out.println("deltaL="+lfEqn.getBVect_xy(n).x+"   ,after update LAMBDA="+this.val);
	}
	
	
	
	
}
