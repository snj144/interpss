 /*
  * @(#)ControlledShuntDataRec.java   
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

public class ControlledShuntDataRec {
			public int number;
			public String name;
			public double base_kV, vs_pu, vt_pu, an_deg, vma, vmi;
			public int ty, ar, z, owner;
			public String d_in, d_out;   // yymmdd
			public String projid_info;
			public int level_info;
			public int stisol_future;
			public double latitude_info, longitude_info;
			public int islnum_future;

	public ControlledShuntDataRec(String lineStr, GEDataRec.VersionNo version) {
	}
}
