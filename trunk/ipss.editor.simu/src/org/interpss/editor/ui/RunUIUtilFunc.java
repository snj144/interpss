 /*
  * @(#)RunUtilFunc.java   
  *
  * Copyright (C) 2006-2007 www.interpss.org
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
  * @Date 12/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.editor.ui;

import java.util.Set;
import java.util.TreeSet;

import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;

public class RunUIUtilFunc  {
	public static enum NetIdTypeEnum {LoadBus, GenBus, AllBus, LineBranch, XfrBranch, AllBranch}
	
	public static Set<String> getIdArray(AclfNetwork net, NetIdTypeEnum type) {
		Set<String> set = new TreeSet<String>();
		if (type == NetIdTypeEnum.AllBus || type == NetIdTypeEnum.GenBus || type == NetIdTypeEnum.LoadBus)
			for (Bus bus : net.getBusList()) {
				AclfBus aclfBus = (AclfBus)bus;
				if (type == NetIdTypeEnum.GenBus) {
					if (aclfBus.isGen()) 
						set.add(bus.getId());
				}	
				else if (type == NetIdTypeEnum.LoadBus) {
					if (aclfBus.isLoad())
						set.add(bus.getId());
				}
				else
					set.add(bus.getId());
			}
		else if (type == NetIdTypeEnum.AllBranch || type == NetIdTypeEnum.LineBranch || type == NetIdTypeEnum.XfrBranch)
			for (Branch bra : net.getBranchList()) {
				AclfBranch aclfBra = (AclfBranch)bra;
				if (type == NetIdTypeEnum.LineBranch) {
					if (aclfBra.isLine()) 
						set.add(bra.getId());
				}
				else if (type == NetIdTypeEnum.XfrBranch) {
					if (aclfBra.isXfr())
						set.add(bra.getId());
				}
				else
					set.add(bra.getId());
			}
		return set;
	}	
}
