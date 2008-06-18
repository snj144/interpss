package org.interpss.ed.costf;

public abstract class AbstractCostFunc {
	protected int curveOrder = 0;
	protected double fuelCost = 0.0;
	protected double maxIhr, minIhr;

	public abstract double incHeatRate(double unitMw);
	public abstract double inverserIhr(double unitIhr, double pmax, double pmin) throws Exception;
	public abstract double productionCost(double unitMw);
	
	public void setFuelCost(double c) {
		this.fuelCost = c;
	}
	
	public double getIhrmax() {
		return this.maxIhr;
	}

	public double getIhrmin() {
		return this.minIhr;
	}

	public void setIhrLimit(double max, double min) {
		this.maxIhr = max;
		this.minIhr = min;
	}
	
	public String toString() {
		String str = "";
		str += "curveOrder, fuelCost, maxIhr, minIhr: " + 
				curveOrder + ", " + fuelCost + ", " + maxIhr + ", " + minIhr + "\n"; 
		return str;
	}
}
