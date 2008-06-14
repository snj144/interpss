 /*
  * @(#)PSSELoadDataRec.java   
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

package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;
import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.psse.aclf.PSSEAclfLoad;

public class PSSELoadDataRec {
	private int i, status, area = 1, zone = 1, owner = 1;
	private String id;
	private double pl = 0.0, ql = 0.0, ip = 0.0, iq = 0.0, yp = 0.0, yq = 0.0;


	/*
	 * LoadData I, ID, STATUS, AREA, ZONE, PL, QL, IP, IQ, YP, YQ, OWNER
	 */	
	public PSSELoadDataRec(String lineStr, VersionNo version) {
		StringTokenizer st;
		if (version == VersionNo.Old) {
			// 74611 '99' 1 702 181 1.106 0.258 0.000 0.000 0.000 0.000 1 /*
			// [STA_204 999 ] */
			st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr), "'");
			i = new Integer(st.nextToken().trim()).intValue();
			id = st.nextToken();
			st = new StringTokenizer(st.nextToken());
		} else {
			st = new StringTokenizer(lineStr, ",");
			i = new Integer(st.nextToken().trim()).intValue();
			id = st.nextToken();
		}
		status = new Integer(st.nextToken().trim()).intValue();
		area = new Integer(st.nextToken().trim()).intValue();
		zone = new Integer(st.nextToken().trim()).intValue();
		pl = new Double(st.nextToken().trim()).doubleValue();
		ql = new Double(st.nextToken().trim()).doubleValue();
		ip = new Double(st.nextToken().trim()).doubleValue();
		iq = new Double(st.nextToken().trim()).doubleValue();
		yp = new Double(st.nextToken().trim()).doubleValue();
		yq = new Double(st.nextToken().trim()).doubleValue();
		owner = new Integer(st.nextToken().trim()).intValue();
	}
	
	/** 
	 * Process load data record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param msgHub the message hub object
	 */
	public void processLoad(
				AclfAdjNetwork adjNet, 
				IPSSMsgHub msg) throws Exception {
/*
		I, ID, STATUS, AREA, ZONE, PL, QL, IP, IQ, YP, YQ, OWNER
*/		
		String iStr = new Integer(this.i).toString();
		AclfBus bus = adjNet.getAclfBus(iStr);
		if (bus == null) {
			throw new Exception ("Bus not found in the network, bus number: " + this.i);
		}
		
		PSSEAclfLoad load = ExtensionObjectFactory.createPSSEAclfLoad();
		load.setId(this.id);
		load.setName("Load:" + this.id + "(" + this.i + ")");
		load.setDesc("PSSE Load " + this.id + " at Bus " + this.i);
		load.setStatus(this.status==1);
		load.setAreaNo(this.area);
		load.setZoneNo(this.zone);
		load.setOwnerNo(this.owner);
		
		double baseMva = adjNet.getBaseKva() / 1000.0;
		load.setConstPLoad(new Complex(this.pl/baseMva,this.ql/baseMva));
		load.setConstILoad(new Complex(this.ip/baseMva,this.iq/baseMva));
		load.setConstZLoad(new Complex(this.yp/baseMva,this.yq/baseMva));

		bus.getRegDeviceList().add(load);
	}			

	public String toString() {
		String str = "";
		str += "Bus number, id, status, area, zone:" + 
				i + ", " + id + ", " + status + ", " + area + ", " + zone + "\n";
		str += "PL, QL, IP, iQ, YP, YQ, OWNER:" 
				+ pl + ", " + ql + ", " + ip + ", " + iq + ", " + yp + ", " + yq + ", " + owner + "\n";
		return str;
	}
}
