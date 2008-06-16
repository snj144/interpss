package org.interpss.ed.unit;

public class CostFuncPiecewizeIO implements IGenCostFunc {
	private int curveOrder = 0;
	private double fuelCost = 0.0;
	private double[] ioMwPointAry, ioCostAry;

	public CostFuncPiecewizeIO(int order) {
		this.curveOrder = order;
		this.ioMwPointAry = new double[order+1];
		this.ioCostAry = new double[order+1];
	}
	
	public void setFuelCost(double c) {
		this.fuelCost = c;
	}
	
	public void setIoMwPoint(int order, double c) throws Exception {
		if (order <= this.curveOrder)
			this.ioMwPointAry[order] = c;
		else
			throw new Exception("IoMwPoint order out of range, order: " + order);
	}
	
	public void setIoCost(int order, double c) throws Exception {
		if (order <= this.curveOrder)
			this.ioCostAry[order] = c;
		else
			throw new Exception("IoCost order out of range, order: " + order);
	}
	
	public double incHeatRate(double unitMw) {
		double unitihr = 0.0;
	    int j = 0;
	    do {
	      j++;
	    } while ( ioMwPointAry[j] <= unitMw && j < curveOrder);

	    unitihr = (ioCostAry[j] - ioCostAry[j-1] ) /
	                          ( ioMwPointAry[j] - ioMwPointAry[j-1] );
	    return unitihr;
	}
	
	public double inverserIHR(double unitIhr) {
		int j = 0;
		double segmentihr = 0.0;
		do {
	    	j++;
	    	if ( j == curveOrder )
	    		return ioMwPointAry[j];
	    	segmentihr =(ioCostAry[j] - ioCostAry[j-1]) /
	                           (ioMwPointAry[j] - ioMwPointAry[j-1]);
	    } while ( segmentihr < unitIhr);

	    return ioMwPointAry[j-1];
	}

	public double productionCost(double unitMw) {
		double unitcost = 0.0;
		for ( int j = 1; j <= curveOrder; j++) {
			if (ioMwPointAry[j] > unitMw) {
	            double partmw = (unitMw-ioMwPointAry[j-1] ) /
	                              (ioMwPointAry[j]-ioMwPointAry[j-1] );
	            unitcost = ioCostAry[j-1] +
	                             ( ioCostAry[j]-ioCostAry[j-1] ) * partmw;
	            return unitcost * fuelCost;
			}
	        
			if ( j == curveOrder)  //  {Unit is at or above pmax}
	            return ioCostAry[j] * fuelCost;
		}		
		return unitcost;
	}
}
