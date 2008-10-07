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

public class PSSEBusDataRec {
	public int i, ide, area = 1, zone = 1, owner = 1;
	public String name;
	public double baseKv, gl = 0.0, bl = 0.0, vm = 1.0, va = 0.0;

	/*
	 * BusData Format: I, ’NAME’, BASKV, IDE, GL, BL, AREA, ZONE, VM, VA, OWNER
	 */
	public PSSEBusDataRec(String lineStr, VersionNo version) {
		StringTokenizer st;
		if (version == VersionNo.Old) {
			// old verdion: 80001 'TOMKE ' 220.00 1 0.00 0.00 703 1 1.0784
			// -38.614 1 /* [TOMKENJC A014] */
			st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr), "'");
			i = new Integer(st.nextToken().trim()).intValue();
			name = st.nextToken().trim();
			st = new StringTokenizer(st.nextToken());
		} else {
			st = new StringTokenizer(lineStr, ",");
			i = new Integer(st.nextToken().trim()).intValue();
			name = st.nextToken().trim();
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
		final AclfBus bus = CoreObjectFactory.createAclfBus(iStr, this.area, this.zone, 
				new Integer(this.owner).toString(), adjNet);
      	bus.setName(this.name);
    	bus.setBaseVoltage(this.baseKv, UnitType.kV);
    	double factor = 1000.0/adjNet.getBaseKva();  // for transfer G+jB to PU on system base 
    	bus.setShuntY(new Complex(this.gl*factor,this.bl*factor));
      	
    	// add the bus object into the network container
    	//adjNet.addBus(bus);

    	// set input data to the bus object
      	if ( this.ide == 3 ) {
      		// Swing bus
   		 	bus.setGenCode(AclfGenCode.SWING);
    		bus.setLoadCode(AclfLoadCode.NON_LOAD);
  			final SwingBusAdapter gen = (SwingBusAdapter)bus.adapt(SwingBusAdapter.class);
  			gen.setVoltMag(this.vm, UnitType.PU);
  			gen.setVoltAng(this.va, UnitType.Deg);
    	}
    	else if ( this.ide == 2 ) {
    		// Gen bus, we first set it to a PQ bus. It will be adjusted in the 
    		// Generator data section.
    		bus.setGenCode(AclfGenCode.GEN_PV);
    		bus.setLoadCode(AclfLoadCode.NON_LOAD);
    	}
    	else if ( this.ide == 1 ) {
    		// Non-gen load bus
   		 	bus.setGenCode(AclfGenCode.NON_GEN);
    		bus.setLoadCode(AclfLoadCode.NON_LOAD);
    	}
    	else {
    		// Isolated bus, an isolated bus will not participate in Loadflow calculaiton
    		bus.setGenCode(AclfGenCode.NON_GEN);
    		bus.setLoadCode(AclfLoadCode.NON_LOAD);
    		bus.setStatus(false);
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
