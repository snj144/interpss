 /*
  * @(#)GeUtilFunc.java   
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

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.net.Area;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.core.net.Owner;
import com.interpss.core.net.Zone;
import com.interpss.ext.ge.aclf.GeAclfBus;
import com.interpss.ext.ge.aclf.GeAclfLine;
import com.interpss.ext.ge.aclf.GeAclfNetwork;
import com.interpss.ext.ge.aclf.GeAclfXformer;
import com.interpss.ext.ge.aclf.GeArea;
import com.interpss.ext.ge.aclf.GeOwner;
import com.interpss.ext.ge.aclf.GeZone;

public class GeUtilFunc {

	/**
	 * Transfer data from GE data model to InterPSS data model
	 * 
	 * @param net
	 * @param msg
	 * @return
	 */
	public static boolean transferData(GeAclfNetwork net, IPSSMsgHub msg) {
		for (GeArea area : net.getGeAreaList()) {
			Area a = CoreObjectFactory.createArea(area.getNumber(), net);
			a.setName(area.getName());
		}

		for (GeZone zone : net.getGeZoneList()) {
			Zone z = CoreObjectFactory.createZone(zone.getNumber(), net);
			z.setName(zone.getName());
		}
		
		for (GeOwner owner : net.getGeOwnerList()) {
			Owner o = CoreObjectFactory.createOwner(owner.getNumber(), net);
			o.setName(owner.getName());
		}
		
		// transfer bus data
		for (Bus bus : net.getBusList()) {
			GeAclfBus aclfBus = (GeAclfBus) bus;

		}
		
		// transfer branch data
		for (Branch bra : net.getBranchList()) {
			if (bra instanceof GeAclfLine) {
				GeAclfLine line = (GeAclfLine) bra;
			}
			else if (bra instanceof GeAclfXformer) {
				GeAclfXformer xfr = (GeAclfXformer) bra;
			}

		}
		return true;
	}
}
