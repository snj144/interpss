 /*
  * @(#)IpssInternalFormat_in.java   
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

package org.interpss.custom.exchange.impl;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.simu.pssl.IpssAclf;

public class IpssInternalFormat_in {
    public static AclfAdjNetwork loadFile(final java.io.BufferedReader din, final IPSSMsgHub msg) throws Exception {
    	IpssAclf.setMsgHub(msg);
    	
    	// create a AclfAdjNetwork object to hold the loadflow data
    	final AclfAdjNetwork  adjNet = CoreObjectFactory.createAclfAdjNetwork();
    	adjNet.setAllowParallelBranch(true);
    	
    	// process loadflow data line-by-line
      	String str = din.readLine();
      	if (!str.startsWith("AclfNetInfo")) {
			throw new Exception("The file line in input file is not AclfNetInfo, <" + str + ">");
		}  

      	do {
          	str = din.readLine();   //kvaBase
          	if (!str.startsWith("EndOfFile")) {
            	str = din.readLine();
            	if (str ==  null || str.equals(""))
            		; // do nothing
            	else if (str.startsWith("BusInfoNoBaseV")) {
              		do {
                		str = din.readLine();
                		if (!str.startsWith("end")) {
							loadBusInfoNoBaseV(str, adjNet);
                		//msgHub.sendInfoMsg("Bus Loaded: " + String.valueOf(++cnt));
						}
              		} while (!str.startsWith("end"));
            	}
            	else if (str.startsWith("BusInfo")) {
              		do {
                		str = din.readLine();
                		if (!str.startsWith("end")) {
							loadBusInfo(str, adjNet);
                		//msgHub.sendInfoMsg("Bus Loaded: " + String.valueOf(++cnt));
						}
              		} while (!str.startsWith("end"));
            	}
            	else if (str.startsWith("SwingBusInfo")) {
              		do {
                		str = din.readLine();
                		if (!str.startsWith("end")) {
							loadSwingBusInfo(str, adjNet);
                		//msgHub.sendInfoMsg("SwingBus Loaded: " + String.valueOf(++cnt));
						}
              		} while (!str.startsWith("end"));
            	}
            	else if (str.startsWith("PVBusInfo")) {
              		do {
                		str = din.readLine();
                		if (!str.startsWith("end")) {
							loadPVBusInfo(str, adjNet);
                		//msgHub.sendInfoMsg("PVBus Loaded: " + String.valueOf(++cnt));
						}
              		} while (!str.startsWith("end"));
            	}
            	else if (str.startsWith("PQBusInfo")) {
              		do {
                		str = din.readLine();
                		if (!str.startsWith("end")) {
							loadPQBusInfo(str, adjNet);
                		//msgHub.sendInfoMsg("PQBus Loaded: " + String.valueOf(++cnt));
						}
              		} while (!str.startsWith("end"));
            	}
            	else if (str.startsWith("CapacitorBusInfo")) {
              		do {
                		str = din.readLine();
                		if (!str.startsWith("end")) {
							loadCapacitorBusInfo(str, adjNet);
                		//msgHub.sendInfoMsg("Capacitor Loaded: " + String.valueOf(++cnt));
						}
              		} while (!str.startsWith("end"));
            	}
            	else if (str.startsWith("BranchInfo")){
              		do {
                		str = din.readLine();
                		if (!str.startsWith("end")) {
							loadBranchInfo(str, adjNet, msg);
                		//msgHub.sendInfoMsg("Branch Loaded: " + String.valueOf(++cnt));
						}
              		} while (!str.startsWith("end"));
            	}
            	else if (str.startsWith("XformerInfo")){
              		do {
                		str = din.readLine();
                		if (!str.startsWith("end")) {
							loadXformerInfo(str, adjNet);
                		//msgHub.sendInfoMsg("Xfr Loaded: " + String.valueOf(++cnt));
						}
              		} while (!str.startsWith("end"));
            	}
           	  }
        	} while (str != null && !str.startsWith("EndOfFile"));
      	return adjNet;
    }

    public static void loadBusInfo(final String str, final AclfNetwork net) {
      	// MsgHub.sendInfoMsg("Bus: " + str);
      	final java.util.StringTokenizer st =
         		new java.util.StringTokenizer(str);
      	String id = null;
      	double vBase=0.0, vAct=0.0, ang=0.0, pg=0.0,
             qg=0.0, pl=0.0, ql=0.0;
      	while (st.hasMoreTokens()) {
        	id    = st.nextToken().trim();
        	vBase = new Double(st.nextToken()).doubleValue();
        	vAct  = new Double(st.nextToken()).doubleValue();
        	ang   = new Double(st.nextToken()).doubleValue();
        	pg    = new Double(st.nextToken()).doubleValue();
        	qg    = new Double(st.nextToken()).doubleValue();
        	pl    = new Double(st.nextToken()).doubleValue();
        	if (!st.hasMoreTokens()) {
        		System.out.println("--->" + str);
        	}
        	ql    = new Double(st.nextToken()).doubleValue();
        	if (st.hasMoreTokens()) {
				throw new InvalidInputException("AclfDataFile.loadBusInfo, BusInfo str wrong");
			}
      	}

    	if ( ( pg != 0.0 ) || ( qg != 0.0 ) ) {
    		IpssAclf.addAclfBus(id, "Bus-"+id, net)
						.setBaseVoltage(vBase, UnitType.Volt)
						.setGenCode(AclfGenCode.GEN_PQ)
						.setGen(new Complex(pg,qg), UnitType.mVA)
						.setLoadCode(AclfLoadCode.CONST_P)
						.setLoad(new Complex(pl,ql), UnitType.mVA)
						.setInitVoltage(vAct, ang);
    	}
    	else if ( ( pl != 0.0 ) || ( ql != 0.0 ) ) {
     		IpssAclf.addAclfBus(id, "Bus-"+id, net)
     					.setBaseVoltage(vBase, UnitType.Volt)
     					.setLoadCode(AclfLoadCode.CONST_P)
     					.setLoad(new Complex(pl,ql), UnitType.mVA)    		 
     					.setInitVoltage(vAct, ang);
    	}
    	else {
      		IpssAclf.addAclfBus(id, "Bus-"+id, net)
						.setBaseVoltage(vBase, UnitType.Volt)
      					.setInitVoltage(vAct, ang);
    	}
    }

    public static void loadBusInfoNoBaseV(final String str, final AclfNetwork net) throws Exception {
      	// MsgHub.sendInfoMsg("Bus: " + str);
      	final java.util.StringTokenizer st = new java.util.StringTokenizer(str);
      	String id = null;
      	double vBase=0.0, vAct=0.0, ang=0.0, pg=0.0,
             qg=0.0, pl=0.0, ql=0.0;
      	while (st.hasMoreTokens()) {
        	id    = st.nextToken().trim();
        	vBase = 10000; //new Double(st.nextToken()).doubleValue();
        	vAct  = new Double(st.nextToken()).doubleValue();
        	ang   = new Double(st.nextToken()).doubleValue();
        	pg    = new Double(st.nextToken()).doubleValue();
        	qg    = new Double(st.nextToken()).doubleValue();
        	pl    = new Double(st.nextToken()).doubleValue();
        	ql    = new Double(st.nextToken()).doubleValue();
        	if (st.hasMoreTokens()) {
				throw new InvalidInputException("AclfDataFile.loadBusInfoNoBaseV, BusInfo str wrong");
			}
      	}
    	if ( ( pg != 0.0 ) || ( qg != 0.0 ) ) {
    		IpssAclf.addAclfBus(id, "Bus-"+id, net)
						.setBaseVoltage(vBase, UnitType.Volt)
						.setGenCode(AclfGenCode.GEN_PQ)
						.setGen(new Complex(pg,qg), UnitType.mVA)
						.setLoadCode(AclfLoadCode.CONST_P)
						.setLoad(new Complex(pl,ql), UnitType.mVA)
						.setInitVoltage(vAct, ang);
    	}
    	else if ( ( pl != 0.0 ) || ( ql != 0.0 ) ) {
     		IpssAclf.addAclfBus(id, "Bus-"+id, net)
     					.setBaseVoltage(vBase, UnitType.Volt)
     					.setLoadCode(AclfLoadCode.CONST_P)
     					.setLoad(new Complex(pl,ql), UnitType.mVA)    		 
     					.setInitVoltage(vAct, ang);
    	}
    	else {
      		IpssAclf.addAclfBus(id, "Bus-"+id, net)
						.setBaseVoltage(vBase, UnitType.Volt)
      					.setInitVoltage(vAct, ang);
    	}
    }

    public static void loadSwingBusInfo(final String str, final AclfNetwork net) {
      	// MsgHub.sendInfoMsg("SwingBus: " + str);
      	final java.util.StringTokenizer st =
         		new java.util.StringTokenizer(str);
      	String id = null;
      	while (st.hasMoreTokens()) {
        	id    = st.nextToken().trim();
        	if (st.hasMoreTokens()) {
				throw new InvalidInputException("AclfDataFile.loadSwingBusInfo_1, SwingBusInfo str wrong");
			}
      	}

      	try {
          	AclfBus bus = (AclfBus)net.getBus(id);
      		IpssAclf.getAclfBus(id, net)
      					.setGenCode(AclfGenCode.SWING)
      					.setVoltageSpec(bus.getVoltageMag(), UnitType.PU, bus.getVoltageAng(UnitType.Rad), UnitType.Rad);
      	} catch (Exception e) {
			throw new InvalidInputException("AclfDataFile.loadSwingBusInfo_2, Swing bus:" + id + " is not in the system" );
      	}
    }

    public static void loadPVBusInfo(final String str, final AclfAdjNetwork adjNet) {
      	// MsgHub.sendInfoMsg("PVBus: " + str);
      	final java.util.StringTokenizer st = new java.util.StringTokenizer(str);
      	String id = null;
    	double v=0.0, qmax=0.0, qmin=0.0;
      	while (st.hasMoreTokens()) {
        	id   = st.nextToken().trim();
        	v    = new Double(st.nextToken()).doubleValue();
        	qmin = new Double(st.nextToken()).doubleValue();
        	qmax = new Double(st.nextToken()).doubleValue();
        	if (st.hasMoreTokens()) {
				throw new InvalidInputException("AclfDataFile.loadPVBusInfo_1, PVBusInfo str wrong");
			}
      	}

      	try {
          	AclfBus bus = adjNet.getAclfBus(id);
      		IpssAclf.getAclfBus(id, adjNet)
      					.setGenCode(AclfGenCode.GEN_PV)
      					.setGenP_VMag(bus.getGenP(), UnitType.PU, v, UnitType.PU);
    		IpssAclf.addPVBusLimit(id, adjNet)
						.setVSpecified(v, UnitType.PU)
						.setQLimit(qmax, qmin, UnitType.mVA);
      	} catch (Exception e) {
      		IpssLogger.getLogger().info(str);
			throw new InvalidInputException("AclfDataFile.loadPVBusInfo_2, PV bus:" + id + " is not in the system" );
      	}
    }

    public static void loadPQBusInfo(final String str, final AclfAdjNetwork adjNet) {
        // do nothing. loadBusInfo already done loading info
    }

    public static void loadCapacitorBusInfo(final String str, final AclfAdjNetwork adjNet) {
      	// MsgHub.sendInfoMsg("CapacitorBus: " + str);
      	final java.util.StringTokenizer st = 	new java.util.StringTokenizer(str);
      	String id = null;
		double b=0.0;
      	while (st.hasMoreTokens()) {
        	id   = st.nextToken().trim();
        	b    = new Double(st.nextToken()).doubleValue();
        	if (st.hasMoreTokens()) {
				throw new InvalidInputException("AclfDataFile.loadCapacitorBusInfo_1, CapacitorBusInfo str wrong");
			}
      	}

      	try {
      		IpssAclf.getAclfBus(id, adjNet)
      					.setGenCode(AclfGenCode.CAPACITOR)
      					.setCapacitorQ(b, UnitType.PU);
      	} catch (Exception e) {
			throw new InvalidInputException("AclfDataFile.loadCapacitorBusInfo_2, Capacitor bus:" + id + " is not in the system" );
      	}
    }

    public static void loadBranchInfo(final String str, final AclfNetwork net, final IPSSMsgHub msgHub) 
	       throws Exception {
      	// MsgHub.sendInfoMsg("Branch: " + str);
      	final java.util.StringTokenizer st =
         			new java.util.StringTokenizer(str);
      	String fid=null, tid=null;
    	 		double r=0.0, x=0.0, b=0.0;
      	while (st.hasMoreTokens()) {
        	fid = st.nextToken().trim();
        	tid = st.nextToken().trim();
        	r   = new Double(st.nextToken()).doubleValue();
        	x   = new Double(st.nextToken()).doubleValue();
        	b   = new Double(st.nextToken()).doubleValue();
        	if (st.hasMoreTokens()) {
				throw new InvalidInputException("AclfDataFile.loadBranchInfo_1, BranchInfo str wrong");
			}
      	}
      	
		IpssAclf.addAclfBranch(fid, tid, net)
					.setBranchCode(AclfBranchCode.LINE)
					.setZ(new Complex(r,x), UnitType.PU)
					.setShuntB(b*2.0, UnitType.PU);      	
    }

    public static void loadXformerInfo(final String str, final AclfNetwork net) {
      	// MsgHub.sendInfoMsg("Xformer: " + str);
      	final java.util.StringTokenizer st =
         		new java.util.StringTokenizer(str);
      	String fid=null, tid=null;
    	String cirNo="1";
      	double t=0.0;
      	while (st.hasMoreTokens()) {
        	fid = st.nextToken().trim();
        	tid = st.nextToken().trim();
        	cirNo = st.nextToken();
        	t     = new Double(st.nextToken()).doubleValue();
        	if (st.hasMoreTokens()) {
				throw new InvalidInputException("AclfDataFile.loadXformerInfo_1, XformerInfo str wrong");
			}
      	}

    	try {
    		if (!net.hasBranch(fid, tid, cirNo)) {
    			String tmp = tid;
    			tid = fid;
    			fid = tmp;
    		}
    		IpssAclf.getAclfBranch(fid, tid, cirNo, net)
						.setBranchCode(AclfBranchCode.XFORMER)
						.setTurnRatio(t, 1.0, UnitType.PU);
      	} catch (Exception e) {
			throw new InvalidInputException("AclfDataFile.loadXformerInfo_1, Xformar branch:" + fid + "->" + tid + " is not in the system" );
      	}
    }
}