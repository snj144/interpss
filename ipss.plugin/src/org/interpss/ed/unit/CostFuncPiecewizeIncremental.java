package org.interpss.ed.unit;

public class CostFuncPiecewizeIncremental implements IGenCostFunc {
	private int curveOrder = 0;
	private double fuelCost = 0.0, minPut = 0.0;
	private double[] ihrMwPointAry, ihrCostAry;

	public CostFuncPiecewizeIncremental(int order) {
		this.curveOrder = order;
		this.ihrMwPointAry = new double[order+1];
		this.ihrCostAry = new double[order+1];
	}
	
	public void setFuelCost(double c) {
		this.fuelCost = c;
	}
	
	public void setMinPut(double c) {
		this.minPut = c;
	}	
	
	public void setIhrMwPoint(int order, double c) throws Exception {
		if (order <= this.curveOrder)
			this.ihrMwPointAry[order] = c;
		else
			throw new Exception("IhrMwPoint order out of range, order: " + order);
	}
	
	public void setIhrCost(int order, double c) throws Exception {
		if (order <= this.curveOrder)
			this.ihrCostAry[order] = c;
		else
			throw new Exception("IhrCost order out of range, order: " + order);
	}
	
	public double incHeatRate(double unitMw) {
		double unitihr = 0.0;
	    int  j = 0;
	    do {
	      j++;
	    } while (ihrMwPointAry[j] <= unitMw && j < this.curveOrder);

	    double partmw = (unitMw - ihrMwPointAry[j-1] )/
	                       (ihrMwPointAry[j] - ihrMwPointAry[j-1] );
	    unitihr = ihrCostAry[j-1] + ( ihrCostAry[j] - ihrCostAry[j-1] ) * partmw;
		return unitihr;
	}
	
	public double inverserIHR(double unitIhr) {
		double unitmw = 0.0;
		int j = 0 ;
	    do {
	      j++;
	    } while (ihrCostAry[j] <= unitIhr && j < curveOrder);

	    double partihr = ( unitIhr - ihrCostAry[j-1] )/
	                          ( ihrCostAry[j] - ihrCostAry[j-1] );
	    unitmw = ihrMwPointAry[j-1] +
	                    ( ihrMwPointAry[j] - ihrMwPointAry[j-1] ) * partihr;
		return unitmw;
	}

	public double productionCost(double unitMw) {
		double unitcost = 0.0;
	    unitcost = minPut * fuelCost;
	    for (int j = 1; j <= curveOrder; j++) {
	    	if (unitMw > ihrMwPointAry[j] && j < curveOrder ) { // Calculate area under complete segment
	            double segmentcost =  ( (ihrCostAry[j] + ihrCostAry[j-1] )/2.0 ) *
	                            ( ihrMwPointAry[j] - ihrMwPointAry[j-1] ) * fuelCost;
	            unitcost += segmentcost;
	    	}
	    	else { // {Calculate area under partial segment}
	            double partmw = (unitMw - ihrMwPointAry[j-1] )/
	                            (ihrMwPointAry[j] - ihrMwPointAry[j-1] );
	            double unitihr = ihrCostAry[j-1] + ( ihrCostAry[j] - ihrCostAry[j-1] ) * partmw;
	            double segmentcost =  ( (unitihr + ihrCostAry[j-1])/ 2.0 ) *
	                             ( unitMw - ihrMwPointAry[j-1] ) * fuelCost;
	            unitcost += segmentcost;
	    	}
	    }
	    return unitcost;
	}
}
