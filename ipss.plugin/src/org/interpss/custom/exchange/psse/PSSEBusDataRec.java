 /*
  * @(#)PSSEBusDataRec.java   
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

import java.security.InvalidParameterException;
import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;
import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.simu.dsl.IpssAclf;

public class PSSEBusDataRec {
	public int i, ide, area = 1, zone = 1, owner = 1;
	public String name;
	public double baseKv, gl = 0.0, bl = 0.0, vm = 1.0, va = 0.0;

	/*
	 * BusData Format: I, ’NAME’, BASKV, IDE, GL, BL, AREA, ZONE, VM, VA, OWNER
	 */
	public PSSEBusDataRec(String lineStr, VersionNo version) {
		try {
			StringTokenizer st;
			if (version == VersionNo.Old) {
				// old verdion: 80001 'TOMKE ' 220.00 1 0.00 0.00 703 1 1.0784
				// -38.614 1 /* [TOMKENJC A014] */
				st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr), "'");
				i = new Integer(st.nextToken().trim()).intValue();
				name = st.nextToken().trim();
				st = new StringTokenizer(st.nextToken());
			} else {
				// 101743,'TAU 9A,8    ',  13.8000,2,     0.000,     0.000, 101, 101,1.02610, -98.5705,   1
				// there might be ',' in the name field
				i = new Integer(lineStr.substring(0, lineStr.indexOf(',')).trim()).intValue();
		        st = new StringTokenizer(lineStr, "'");
		        st.nextToken();  
		        name = st.nextToken().trim();    
		        st = new StringTokenizer(st.nextToken(), ",");				
			}

			baseKv = new Double(st.nextToken().trim()).doubleValue();
			ide = new Integer(st.nextToken().trim()).intValue();
			if (st.hasMoreTokens())
				gl = new Double(st.nextToken().trim()).doubleValue();
			if (st.hasMoreTokens())
				bl = new Double(st.nextToken().trim()).doubleValue();
			if (st.hasMoreTokens())
				area = new Integer(st.nextToken().trim()).intValue();
			if (st.hasMoreTokens())
				zone = new Integer(st.nextToken().trim()).intValue();
			if (st.hasMoreTokens())
				vm = new Double(st.nextToken().trim()).doubleValue();
			if (st.hasMoreTokens())
				va = new Double(st.nextToken().trim()).doubleValue();
			if (st.hasMoreTokens())
				owner = new Integer(st.nextToken().trim()).intValue();
		} catch (Exception e) {
			System.err.println(lineStr + ", " + version);
			e.printStackTrace();
		}
	}
	
	/** 
	 * Process bus record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param msgHub the message hub object
	 */
	public void processBus(
				AclfAdjNetwork adjNet, 
				IPSSMsgHub msg) throws Exception {
/*
		Format: I,    ’NAME’,    BASKV, IDE,  GL,      BL,  AREA, ZONE, VM, VA, OWNER
*/
		String iStr = new Integer(this.i).toString();
    	double factor = 1000.0/adjNet.getBaseKva();  // for transfer G+jB to PU on system base 
    	if (this.baseKv <= 0.0) 
    		msg.sendWarnMsg("Base voltage = 0.0, at Bus " + iStr);

		AclfBus bus = IpssAclf.addAclfBus(iStr, this.name, adjNet)
				.setAreaNumber(this.area)
				.setZoneNumber(this.zone)
				.setBaseVoltage(this.baseKv, UnitType.kV)
				.setShuntY(new Complex(this.gl*factor,this.bl*factor), UnitType.PU)
				.getAclfBus();

    	// set input data to the bus object
      	if ( this.ide == 3 ) {
      		// Swing bus
      		IpssAclf.wrapAclfBus(bus, adjNet)
   		 		.setGenCode(AclfGenCode.SWING)
  				.setVoltageSpec(this.vm, UnitType.PU, this.va, UnitType.Deg);
    	}
    	else if ( this.ide == 2 ) {
    		// Gen bus, we first set it to a PQ bus. It will be adjusted in the 
    		// Generator data section.
      		IpssAclf.wrapAclfBus(bus, adjNet)
      			.setGenCode(AclfGenCode.GEN_PV);
    	}
    	else if ( this.ide == 1 ) {
    		// Non-gen load bus
    	}
    	else {
    		// Isolated bus, an isolated bus will not participate in Loadflow calculation
      		IpssAclf.wrapAclfBus(bus, adjNet)
      				.setStatus(false);
    	}
	}
	
	public String toString() {
		String str = "";
		str += "Bus number, type, name:" + i + ", " + ide + ", '" + name + "'" + "\n";
		str += "Area, Zone:" + this.area + ", " + this.zone + "\n";
		str += "baseKV, Vm, Va:" + baseKv + ", " + vm + ", " + va + "\n";
		str += "Pl, Ql, OWNER:" + gl + ", " + bl + ", " + owner + "\n";
		return str;
	}
}
