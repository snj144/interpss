 /*
  * @(#)LoadScheduleItem.java   
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.editor.refData;

public class LoadScheduleItem {
	private int point;
	private double p_percent;
	private double q_percent;
	/**
	 * @return Returns the p_percent.
	 */
	public double getP_percent() {
		return p_percent;
	}
	/**
	 * @param p_percent The p_percent to set.
	 */
	public void setP_percent(double p_percent) {
		this.p_percent = p_percent;
	}
	/**
	 * @return Returns the q_percent.
	 */
	public double getQ_percent() {
		return q_percent;
	}
	/**
	 * @param q_percent The q_percent to set.
	 */
	public void setQ_percent(double q_percent) {
		this.q_percent = q_percent;
	}
	/**
	 * @return Returns the point.
	 */
	public int getPoint() {
		return point;
	}
	/**
	 * @param point The point to set.
	 */
	public void setPoint(int point) {
		this.point = point;
	}
}
