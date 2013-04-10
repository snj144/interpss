/*
 * @(#) XfrZTableCorrectionHelper.java   
 *
 * Copyright (C) 2008 www.interpss.org
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
 * @Date 04/01/2013
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.mapper.odm.impl.aclf;

import org.ieee.odm.schema.XformerZTableXmlType;

import com.interpss.common.exp.InterpssException;

/**
 * Xfr Z Table correction helper
 * 
 * @author mzhou
 *
 */
public class XfrZTableCorrectionHelper {
	private XformerZTableXmlType.XformerZTableItem itemList = null;
	
	/**
	 * constructor
	 * 
	 * @param item
	 */
	public XfrZTableCorrectionHelper(XformerZTableXmlType.XformerZTableItem item) {
		this.itemList = item;
	}

	public boolean isPsXfrSAngleBased() {
		int last = this.itemList.getLookup().size() - 1;
		return itemList.getLookup().get(0).getTurnRatioShiftAngle() < 0.5 ||
				itemList.getLookup().get(last).getTurnRatioShiftAngle() > 2.0;
	}
	
	public double calFactor(double t_ang) throws InterpssException {
		if (this.itemList.getLookup().size() > 2) {
			int last = this.itemList.getLookup().size() - 1;
			for (int cnt = 0; cnt < last; cnt++) {
				XformerZTableXmlType.XformerZTableItem.Lookup 
					ti = this.itemList.getLookup().get(cnt),
					ti_1 = this.itemList.getLookup().get(cnt+1);
				if (ti.getTurnRatioShiftAngle() <= t_ang && ti_1.getTurnRatioShiftAngle() > t_ang) {
					double t1 = ti.getTurnRatioShiftAngle(),
						   t2 = ti_1.getTurnRatioShiftAngle(),
						   x1 = ti.getScaleFactor(),
						   x2 = ti_1.getScaleFactor();	
					if (t2 <= t1)
						throw new InterpssException("Error in Xfr Z Table correction factor definition t[i+1] <= t[i]");
					return x1 + (x2 - x1) * (t_ang - t1) / (t2 - t1);
				}
			}
			throw new InterpssException("Cannot find Xfr Z Table correction factor");
		}
		else
			throw new InterpssException("Xfr Z correction table entries < 2");
	}
}