package org.interpss.ed.unit;

public abstract class CostFuncAdapter implements IGenCostFunc {
	protected int curveOrder = 0;
	protected double fuelCost = 0.0;
	protected double pmax, pmin;
	protected double maxIhr, minIhr;

	public void setFuelCost(double c) {
		this.fuelCost = c;
	}
	
	public void setPLimit(double max, double min) {
		this.pmax = max;
		this.pmin = min;
	}
	
	public void setIhrLimit(double max, double min) {
		this.maxIhr = max;
		this.minIhr = min;
	}
	
	public String toString() {
		String str = "";
		str += "curveOrder, fuelCost, pmax, pmin, maxIhr, minIhr: " + 
				curveOrder + ", " + fuelCost + ", " + pmax + ", " + pmin + ", " + maxIhr + ", " + minIhr + "\n"; 
		return str;
	}
}
