 /*
  * @(#)CostFuncPiecewizeIncremental.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 06/16/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.ed.unit;

public class CostFuncPiecewizeIncremental extends CostFuncAdapter {
	private double minPut = 0.0;
	private double[] ihrMwPointAry, ihrCostAry;

	public CostFuncPiecewizeIncremental(int order) {
		this.curveOrder = order;
		this.ihrMwPointAry = new double[order+1];
		this.ihrCostAry = new double[order+1];
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
	
	public double inverserIhr(double unitIhr) throws Exception  {
		if ( unitIhr >= maxIhr)
			return pmax;
		if ( unitIhr <= minIhr)
			return pmin;
		
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
	
	public String toString() {
		String str = super.toString();
		str += "ihrMwPointAry, ihrCostAry : "; 
		for (int i = 0; i <= curveOrder; i++)
			str += ihrMwPointAry[i] + ", " + ihrCostAry[i] + ", "; 
		str += "\n"; 
		str += "minPut: " + minPut + "\n";
		return str;
	}	
}
