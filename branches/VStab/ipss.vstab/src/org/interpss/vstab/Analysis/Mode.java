package org.interpss.vstab.Analysis;

import org.apache.commons.math.linear.RealVector;

public class Mode {
     private double eigenValue;
     private RealVector rightVector;
     private RealVector leftVector;
	public void setEigenValue(double eigenValue) {
		this.eigenValue = eigenValue;
	}
	public double getEigenValue() {
		return eigenValue;
	}
	public void setRightVector(RealVector rightVector) {
		this.rightVector = rightVector;
	}
	public RealVector getRightVector() {
		return rightVector;
	}
	public void setLeftVector(RealVector leftVector) {
		this.leftVector = leftVector;
	}
	public RealVector getLeftVector() {
		return leftVector;
	}
     
}
