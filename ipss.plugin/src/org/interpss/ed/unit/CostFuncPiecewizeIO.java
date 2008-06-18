 /*
  * @(#)CostFuncPiecewizeIO.java   
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

public class CostFuncPiecewizeIO  extends CostFuncAdapter {
	private double[] ioMwPointAry, ioCostAry;

	public CostFuncPiecewizeIO(int order) {
		this.curveOrder = order;
		this.ioMwPointAry = new double[order+1];
		this.ioCostAry = new double[order+1];
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
	
	public double inverserIhr(double unitIhr) throws Exception {
		if ( unitIhr >= maxIhr)
			return pmax;
		if ( unitIhr <= minIhr)
			return pmin;
		
		if ( unitIhr >= maxIhr)
			return pmax;
		if ( unitIhr <= minIhr)
			return pmin;
		
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
	
	public String toString() {
		String str = super.toString();
		str += "ioMwPointAry, ioCostAry : "; 
		for (int i = 0; i <= curveOrder; i++)
			str += ioMwPointAry[i] + ", " + ioCostAry[i] + ", "; 
		str += "\n"; 
		return str;
	}	
}
