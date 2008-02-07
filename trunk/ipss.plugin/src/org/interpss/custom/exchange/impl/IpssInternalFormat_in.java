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

import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.CapacitorBusAdapter;
import com.interpss.core.aclf.LineAdapter;
import com.interpss.core.aclf.LoadBusAdapter;
import com.interpss.core.aclf.PQBusAdapter;
import com.interpss.core.aclf.PVBusAdapter;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.PVBusLimit;

public class IpssInternalFormat_in {
    public static AclfAdjNetwork loadFile(final java.io.BufferedReader din, final IPSSMsgHub msg) throws Exception {
    	// create a AclfAdjNetwork object to hold the loadflow data
    	final AclfAdjNetwork  adjNet = CoreObjectFactory.createAclfAdjNetwork();
    	adjNet.setAllowParallelBranch(true);
    	
    	// process loadflow data line-by-line
      	String str = din.readLine();
      	if (!str.equals("AclfNetInfo")) {
			throw new Exception("The file line in input file is not AclfNetInfo, <" + str + ">");
		}  

      	do {
          	str = din.readLine();   //kvaBase
          	if (str.compareTo("EndOfFile") != 0) {
            	str = din.readLine();
            	if (str.compareTo("BusInfo") == 0) {
              		do {
                		str = din.readLine();
                		if (str.compareTo("end") != 0) {
							loadBusInfo(str, adjNet);
                		//msgHub.sendInfoMsg("Bus Loaded: " + String.valueOf(++cnt));
						}
              		} while (str.compareTo("end") != 0);
            	}

            	if (str.compareTo("BusInfoNoBaseV") == 0) {
              		do {
                		str = din.readLine();
                		if (str.compareTo("end") != 0) {
							loadBusInfoNoBaseV(str, adjNet);
                		//msgHub.sendInfoMsg("Bus Loaded: " + String.valueOf(++cnt));
						}
              		} while (str.compareTo("end") != 0);
            	}
            	else if (str.compareTo("SwingBusInfo") == 0) {
              		do {
                		str = din.readLine();
                		if (str.compareTo("end") != 0) {
							loadSwingBusInfo(str, adjNet);
                		//msgHub.sendInfoMsg("SwingBus Loaded: " + String.valueOf(++cnt));
						}
              		} while (str.compareTo("end") != 0);
            	}
            	else if (str.compareTo("PVBusInfo") == 0) {
              		do {
                		str = din.readLine();
                		if (str.compareTo("end") != 0) {
							loadPVBusInfo(str, adjNet);
                		//msgHub.sendInfoMsg("PVBus Loaded: " + String.valueOf(++cnt));
						}
              		} while (str.compareTo("end") != 0);
            	}
            	else if (str.compareTo("PQBusInfo") == 0) {
              		do {
                		str = din.readLine();
                		if (str.compareTo("end") != 0) {
							loadPQBusInfo(str, adjNet);
                		//msgHub.sendInfoMsg("PQBus Loaded: " + String.valueOf(++cnt));
						}
              		} while (str.compareTo("end") != 0);
            	}
            	else if (str.compareTo("CapacitorBusInfo") == 0) {
              		do {
                		str = din.readLine();
                		if (str.compareTo("end") != 0) {
							loadCapacitorBusInfo(str, adjNet);
                		//msgHub.sendInfoMsg("Capacitor Loaded: " + String.valueOf(++cnt));
						}
              		} while (str.compareTo("end") != 0);
            	}
            	else if (str.compareTo("BranchInfo")  == 0){
              		do {
                		str = din.readLine();
                		if (str.compareTo("end") != 0) {
							loadBranchInfo(str, adjNet, msg);
                		//msgHub.sendInfoMsg("Branch Loaded: " + String.valueOf(++cnt));
						}
              		} while (str.compareTo("end") != 0);
            	}
            	else if (str.compareTo("XformerInfo")  == 0){
              		do {
                		str = din.readLine();
                		if (str.compareTo("end") != 0) {
							loadXformerInfo(str, adjNet);
                		//msgHub.sendInfoMsg("Xfr Loaded: " + String.valueOf(++cnt));
						}
              		} while (str.compareTo("end") != 0);
            	}
           	  }
        	} while (str.compareTo("EndOfFile") != 0);
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
        	id    = st.nextToken();
        	vBase = new Double(st.nextToken()).doubleValue();
        	vAct  = new Double(st.nextToken()).doubleValue();
        	ang   = new Double(st.nextToken()).doubleValue();
        	pg    = new Double(st.nextToken()).doubleValue();
        	qg    = new Double(st.nextToken()).doubleValue();
        	pl    = new Double(st.nextToken()).doubleValue();
        	ql    = new Double(st.nextToken()).doubleValue();
        	if (st.hasMoreTokens()) {
				throw new InvalidInputException("AclfDataFile.loadBusInfo, BusInfo str wrong");
			}
      	}

      	final AclfBus bus = CoreObjectFactory.createAclfBus(id);
    	bus.setBaseVoltage(vBase, UnitType.Volt);
    	bus.setVoltage(vAct, ang);
    	if ( ( pg != 0.0 ) || ( qg != 0.0 ) ) {
    		 bus.setGenCode(AclfGenCode.GEN_PQ);
    		 bus.setLoadCode(AclfLoadCode.CONST_P);
   			 final PQBusAdapter gen = (PQBusAdapter)bus.adapt(PQBusAdapter.class);
    		 gen.setGen(new Complex(pg,qg), UnitType.mVA, net.getBaseKva());
    		 gen.setLoad(new Complex(pl,ql), UnitType.mVA, net.getBaseKva());
    	}
    	else if ( ( pl != 0.0 ) || ( ql != 0.0 ) ) {
    		 bus.setGenCode(AclfGenCode.NON_GEN);
    		 //bus.setGen(new complex(pg,qg), UnitType.mVA, net.getBaseKva());
    		 bus.setLoadCode(AclfLoadCode.CONST_P);
   			 final LoadBusAdapter load = (LoadBusAdapter)bus.adapt(LoadBusAdapter.class);
    		 load.setLoad(new Complex(pl,ql), UnitType.mVA, net.getBaseKva());
    	}
    	else {
    		 bus.setGenCode(AclfGenCode.NON_GEN);
   			 final PQBusAdapter gen = (PQBusAdapter)bus.adapt(PQBusAdapter.class);
    		 gen.setGen(new Complex(0.0,0.0), UnitType.mVA, net.getBaseKva());
    		 bus.setLoadCode(AclfLoadCode.NON_LOAD);
    		 //bus.setLoad(new complex(0.0,0.0), UnitType.mVA, net.getBaseKva());
    	}
      	net.addBus(bus);
    }

    public static void loadBusInfoNoBaseV(final String str, final AclfNetwork net) throws Exception {
      	// MsgHub.sendInfoMsg("Bus: " + str);
      	final java.util.StringTokenizer st = new java.util.StringTokenizer(str);
      	String id = null;
      	double vBase=0.0, vAct=0.0, ang=0.0, pg=0.0,
             qg=0.0, pl=0.0, ql=0.0;
      	while (st.hasMoreTokens()) {
        	id    = st.nextToken();
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

      	final AclfBus bus = CoreObjectFactory.createAclfBus(id);
     	bus.setBaseVoltage(vBase, UnitType.Volt);
     	bus.setVoltage(vAct, ang);
     	if ( ( pg != 0.0 ) || ( qg != 0.0 ) ) {
    	 	bus.setGenCode(AclfGenCode.GEN_PQ);
    	 	bus.setLoadCode(AclfLoadCode.CONST_P);
  			final PQBusAdapter gen = (PQBusAdapter)bus.adapt(PQBusAdapter.class);
    	 	gen.setGen(new Complex(pg,qg), UnitType.mVA, net.getBaseKva());
    	 	gen.setLoad(new Complex(pl,ql), UnitType.mVA, net.getBaseKva());
     	}
     	else if ( ( pl != 0.0 ) || ( ql != 0.0 ) ) {
    	 	bus.setGenCode(AclfGenCode.NON_GEN);
    	 	//bus.setGen(new complex(pg,qg), UnitType.mVA, net.getBaseKva());
    	 	bus.setLoadCode(AclfLoadCode.CONST_P);
  			final LoadBusAdapter load = (LoadBusAdapter)bus.adapt(LoadBusAdapter.class);
    	 	load.setLoad(new Complex(pl,ql), UnitType.mVA, net.getBaseKva());
     	}
     	else {
    	 	bus.setGenCode(AclfGenCode.GEN_PQ);
  			final PQBusAdapter gen = (PQBusAdapter)bus.adapt(PQBusAdapter.class);
    	 	gen.setGen(new Complex(0.0,0.0), UnitType.mVA, net.getBaseKva());
    	 	bus.setLoadCode(AclfLoadCode.NON_LOAD);
    	 	//bus.setLoad(new complex(0.0,0.0), UnitType.mVA, net.getBaseKva());
     	}
    	net.addBus(bus);
    }

    public static void loadSwingBusInfo(final String str, final AclfNetwork net) {
      	// MsgHub.sendInfoMsg("SwingBus: " + str);
      	final java.util.StringTokenizer st =
         		new java.util.StringTokenizer(str);
      	String id = null;
      	while (st.hasMoreTokens()) {
        	id    = st.nextToken();
        	if (st.hasMoreTokens()) {
				throw new InvalidInputException("AclfDataFile.loadSwingBusInfo_1, SwingBusInfo str wrong");
			}
      	}

      	final AclfBus bus = (AclfBus)net.getBus(id);
      	if (bus != null ) {
        	bus.setGenCode(AclfGenCode.SWING);
			final SwingBusAdapter swing = (SwingBusAdapter)bus.adapt(SwingBusAdapter.class);
    		swing.setVoltMag(bus.getVoltageMag(), UnitType.PU);
    		swing.setVoltAng(bus.getVoltageAng(UnitType.Rad), UnitType.Rad);
      	} else {
			throw new InvalidInputException("AclfDataFile.loadSwingBusInfo_2, Swing bus:" + id + " is not in the system" );
		}
    }

    public static void loadPVBusInfo(final String str, final AclfAdjNetwork adjNet) {
      	// MsgHub.sendInfoMsg("PVBus: " + str);
      	final java.util.StringTokenizer st = new java.util.StringTokenizer(str);
      	String id = null;
    	double v=0.0, qmax=0.0, qmin=0.0;
      	while (st.hasMoreTokens()) {
        	id   = st.nextToken();
        	v    = new Double(st.nextToken()).doubleValue();
        	qmin = new Double(st.nextToken()).doubleValue();
        	qmax = new Double(st.nextToken()).doubleValue();
        	if (st.hasMoreTokens()) {
				throw new InvalidInputException("AclfDataFile.loadPVBusInfo_1, PVBusInfo str wrong");
			}
      	}

      	final AclfBus bus = adjNet.getAclfBus(id);
    	if (bus != null ) {
        	bus.setGenCode(AclfGenCode.GEN_PV);
      		final PVBusLimit pvLimit = CoreObjectFactory.createPVBusLimit(adjNet, id);
      		pvLimit.setVSpecified(v, UnitType.PU);
      		pvLimit.setQLimit(new LimitType(qmax,qmin), UnitType.mVA, adjNet.getBaseKva());
      		pvLimit.setStatus(true);
			final PVBusAdapter pv = (PVBusAdapter)bus.adapt(PVBusAdapter.class);
        	pv.setVoltMag(pvLimit.getVSpecified(UnitType.PU), UnitType.PU);
      	} else {
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
        	id   = st.nextToken();
        	b    = new Double(st.nextToken()).doubleValue();
        	if (st.hasMoreTokens()) {
				throw new InvalidInputException("AclfDataFile.loadCapacitorBusInfo_1, CapacitorBusInfo str wrong");
			}
      	}

      	final AclfBus bus = adjNet.getAclfBus(id);
    	if (bus != null) {
       	    bus.setGenCode(AclfGenCode.CAPACITOR);
			final CapacitorBusAdapter cap = (CapacitorBusAdapter)bus.adapt(CapacitorBusAdapter.class);
			cap.setQ(b, UnitType.PU, adjNet.getBaseKva());
    	} else {
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
        	fid = st.nextToken();
        	tid = st.nextToken();
        	r   = new Double(st.nextToken()).doubleValue();
        	x   = new Double(st.nextToken()).doubleValue();
        	b   = new Double(st.nextToken()).doubleValue();
        	if (st.hasMoreTokens()) {
				throw new InvalidInputException("AclfDataFile.loadBranchInfo_1, BranchInfo str wrong");
			}
      	}

      	final AclfBranch bra = CoreObjectFactory.createAclfBranch();
    	bra.setBranchCode(AclfBranchCode.LINE);
		final LineAdapter line = (LineAdapter)bra.adapt(LineAdapter.class);
    	
    	line.getAclfBranch().setZ(new Complex(r,x), msgHub);
    	line.setHShuntY(new Complex(0.0,Math.abs(b)), UnitType.PU, 1.0, net.getBaseKva()); // Unit is PU, no need to enter baseV
      	net.addBranch(bra, fid, tid);
    }

    public static void loadXformerInfo(final String str, final AclfNetwork net) {
      	// MsgHub.sendInfoMsg("Xformer: " + str);
      	final java.util.StringTokenizer st =
         		new java.util.StringTokenizer(str);
      	String fid=null, tid=null;
    	String cirNo="1";
      	double t=0.0;
      	while (st.hasMoreTokens()) {
        	fid = st.nextToken();
        	tid = st.nextToken();
        	cirNo = st.nextToken();
        	t     = new Double(st.nextToken()).doubleValue();
        	if (st.hasMoreTokens()) {
				throw new InvalidInputException("AclfDataFile.loadXformerInfo_1, XformerInfo str wrong");
			}
      	}

    	AclfBranch bra = (AclfBranch)net.getBranch(fid, tid, cirNo);
    	if (bra != null) {
    	 	bra.setBranchCode(AclfBranchCode.XFORMER);
        	bra.setFromTurnRatio( t );
        	bra.setToTurnRatio( 1.0 );
      	}
    	else {
    		bra = (AclfBranch)net.getBranch(tid, fid, cirNo);
        	if (bra != null) {
          	bra.setBranchCode(AclfBranchCode.XFORMER);
    			bra.setFromTurnRatio(1.0);
    			bra.setToTurnRatio(t);
        	} else {
				throw new InvalidInputException("AclfDataFile.loadXformerInfo_1, Xformar branch:" + fid + "->" + tid + " is not in the system" );
			}
       }
    }
}