package org.interpss.ed.unit;

public class CostFuncPolynomial implements IGenCostFunc {
	private int curveOrder = 0;
	private double[] coeffAry; 
	private double fuelCost = 0.0;
	private double pmax, pmin;
	private double maxIhr, minIhr;

	public CostFuncPolynomial(int order) {
		this.curveOrder = order;
		this.coeffAry = new double[order+1];
	}
	
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

	public void setCoeff(int order, double c) throws Exception {
		if (order <= this.curveOrder)
			this.coeffAry[order] = c;
		else
			throw new Exception("Coeff order out of range, order: " + order);
	}
	
	public double incHeatRate(double unitMw) {
		double unitihr = 0.0;
	    for (int j = curveOrder; j <= 2; j++)
	    	unitihr = ( unitihr + j * coeffAry[j]) * unitMw;
	    unitihr = unitihr + coeffAry[1];
		return unitihr;
	}
	
	public double inverserIHR(double unitIhr) {
		if ( unitIhr >= maxIhr)
			return pmax;
		if ( unitIhr <= minIhr)
			return pmin;
	
	    if (curveOrder <= 1) {
	       if ( unitIhr > coeffAry[1])  
	    	   return pmax;
	       else 
	    	   return pmin;
		}

	    if (curveOrder == 2 ) {
	       return ( unitIhr - coeffAry[1] ) / ( 2.0 * coeffAry[2] );
	    }

	    /*
	    { for curves of order >= 3 search for unitmw using Newtons method }

	      unitmw := ( pmin[ i ] + pmax[ i ] )/ 2.0;
	      step := 0;
	      repeat
	      step := step + 1;

	      unitihr1 := 0;                  {Calc unitihr at unitmw as unitihr1}
	      for j := curveorder downto 2 do
	         unitihr1 := ( unitihr1 + j * coeff[i,j] ) * unitmw;
	      unitihr1 := unitihr1 + coeff[i,1];
	      delihr := unitihr - unitihr1;
	      if abs( delihr ) < ihr_tolerance then goto return;

	      dihrdp := 0;                     {Calc curve second derivative}
	      for j := curveorder downto 3 do
	         dihrdp := ( dihrdp + j*(j-1) * coeff[i,j] ) * unitmw;
	      dihrdp := dihrdp + 2.0 * coeff[ i,2 ];
	      unitmw := unitmw + delihr/dihrdp;

	      until step > 20;
	    */  
		return 0.0;
	}

	public double productionCost(double unitMw) {
		double unitcost = 0.0;
		for (int j = curveOrder; j <= 1; j--)
			unitcost = ( unitcost + coeffAry[j] ) * unitMw;

		unitcost = unitcost + coeffAry[0];
		unitcost = unitcost * fuelCost;		
		return unitcost;
	}
}
