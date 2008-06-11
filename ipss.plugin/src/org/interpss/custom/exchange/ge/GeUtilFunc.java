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

import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.LoadBusAdapter;
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
import com.interpss.ext.ge.aclf.GeGenerator;
import com.interpss.ext.ge.aclf.GeLoad;
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
			GeAclfBus geBus = (GeAclfBus) bus;
			geBus.setArea(net.getArea(geBus.getGeAreaNo()));
			geBus.setZone(net.getZone(geBus.getGeZoneNo()));
			geBus.setOwner(net.getOwner(geBus.getGeOwnerNo()));

			double cp_p=0.0, cp_q=0.0, ci_p=0.0, ci_q=0.0, cz_p=0.0, cz_q=0.0; 
			for (GeLoad load : geBus.getLoadList()) {
				if (load.isInSevice()) {
					cp_p += load.getP();
					cp_q += load.getQ();
					ci_p += load.getIp();
					ci_q += load.getIq();
					cz_p += load.getG();
					cz_q += load.getB();
				}
			}
			if ((cp_p != 0.0 || cp_q != 0.0) && (ci_p==0.0 && ci_q ==0.0 && cz_p==0.0 && cz_q ==0.0) ) {
				geBus.setLoadCode(AclfLoadCode.CONST_P);
	  			final LoadBusAdapter load = (LoadBusAdapter)bus.adapt(LoadBusAdapter.class);
	  			load.setLoad(new Complex(cp_p, cp_q), UnitType.mVA, net.getBaseKva());
	  		}
			else if ((ci_p != 0.0 || ci_q != 0.0) && (cp_p==0.0 && cp_q ==0.0 && cz_p==0.0 && cz_q ==0.0) ) {
				geBus.setLoadCode(AclfLoadCode.CONST_I);
	  			final LoadBusAdapter load = (LoadBusAdapter)bus.adapt(LoadBusAdapter.class);
	  			load.setLoad(new Complex(ci_p, ci_q), UnitType.mVA, net.getBaseKva());
	  		}
			else if ((cz_p != 0.0 || cz_q != 0.0) && (ci_p==0.0 && ci_q ==0.0 && cp_p==0.0 && cp_q ==0.0) ) {
				geBus.setLoadCode(AclfLoadCode.CONST_Z);
	  			final LoadBusAdapter load = (LoadBusAdapter)bus.adapt(LoadBusAdapter.class);
	  			load.setLoad(new Complex(cz_p, cz_q), UnitType.mVA, net.getBaseKva());
	  		}
			else if ((cp_p != 0.0 || cp_q != 0.0 || ci_p!= 0.0 || ci_q != 0.0 || cz_p != 0.0 || cz_q !=0.0)) {
				// TODO functional load
			}
			else {
				geBus.setLoadCode(AclfLoadCode.NON_LOAD);
			}
			
			for (GeGenerator gen : geBus.getGenList()) {
				
			}
			
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
	
	public static void setOwnerAry(StringTokenizer st, int[] oAry, double[] pAry) {
		if (st.hasMoreElements())
			oAry[0] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			pAry[0] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			oAry[1] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			pAry[1] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			oAry[2] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			pAry[2] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			oAry[3] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			pAry[3] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			oAry[4] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			pAry[4] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			oAry[5] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			pAry[5] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			oAry[6] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			pAry[6] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			oAry[7] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			pAry[7] = new Double(st.nextToken()).doubleValue();
	}	
	
	public static void setDates(StringTokenizer st, String d_in, String d_out, String projId) {
		if (st.hasMoreElements())
			d_in = st.nextToken();
		if (st.hasMoreElements())
			d_out = st.nextToken();
		if (st.hasMoreElements())
			projId = st.nextToken();
	}	
}
