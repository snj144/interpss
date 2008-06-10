 /*
  * @(#)ShuntDataRec.java   
  *
  * Copyright (C) 2006-2008 www.interpss.org
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
  * @Date 06/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.custom.exchange.ge;

public class ShuntDataRec {
	public int fbus; 
	public String fname, id, tname, ck, longId, rname; 
	public double fbkv, tbus, tbkv, sec;
	public double st, ar, z, g, b, d_in, d_out, projId, nst;
	public double o1, p1, o2, p2, o3, p3, o4, p4, regBus, rkv;
			
	public ShuntDataRec(String lineStr, GEDataRec.VersionNo version) {
		System.out.println("shunt data->" + lineStr);
	}
}
