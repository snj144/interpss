 /*
  * @(#)IGenCostFunc.java   
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

/*
 *  CurveOrder concept : a + bx + cx^2, order = 2 
 * 
 */

public interface IGenCostFunc {

	/**
     *  Routine to return unit incremental heat rate given unit output in MW
     *  
     * @param unitMw unit mw
     * @return unit incremental heat rate
	 */
	public double incHeatRate(double unitMw);
	
	/**
     * Routine to return unit MW given unit incremental heat rate
     * 
     * @param unitIhr unit inc heat rate
     * @param unit MW stored in unitmw
    */
	public double inverserIhr(double unitIhr) throws Exception;
	
	/**
	 * Routine to return unit production cost given unit output in mw
	 * 
	 * @param unitMw nit mw
	 * @return unit production cost
	 */
	public double productionCost(double unitMw); 
}
