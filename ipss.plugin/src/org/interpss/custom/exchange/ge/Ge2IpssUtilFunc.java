 /*
  * @(#)Ge2IpssUtilFunc.java   
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

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.LineAdapter;
import com.interpss.core.aclf.LoadBusAdapter;
import com.interpss.core.aclf.PQBusAdapter;
import com.interpss.core.aclf.PSXfrAdapter;
import com.interpss.core.aclf.PVBusAdapter;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclf.XfrAdapter;
import com.interpss.core.aclfadj.FlowControlType;
import com.interpss.core.aclfadj.FunctionLoad;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.RemoteQBus;
import com.interpss.core.aclfadj.RemoteQControlType;
import com.interpss.core.aclfadj.TapControl;
import com.interpss.core.net.Area;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.core.net.Owner;
import com.interpss.core.net.Zone;
import com.interpss.ext.ge.aclf.GeAclfBranch;
import com.interpss.ext.ge.aclf.GeAclfBus;
import com.interpss.ext.ge.aclf.GeAclfNetwork;
import com.interpss.ext.ge.aclf.GeAclfXformer;
import com.interpss.ext.ge.aclf.GeArea;
import com.interpss.ext.ge.aclf.GeBranchSection;
import com.interpss.ext.ge.aclf.GeControlledShunt;
import com.interpss.ext.ge.aclf.GeGenerator;
import com.interpss.ext.ge.aclf.GeLoad;
import com.interpss.ext.ge.aclf.GeOwner;
import com.interpss.ext.ge.aclf.GeShunt;
import com.interpss.ext.ge.aclf.GeZone;

public class Ge2IpssUtilFunc {

	/**
	 * Transfer data from GE data model to InterPSS data model
	 * 
	 * @param net
	 * @param msg
	 * @return
	 */
	public static boolean transferData(GeAclfNetwork net, IPSSMsgHub msg) {
		boolean dataError = false;
		
		setNetData(net);
		
		// transfer bus data
		for (Bus bus : net.getBusList()) {
			GeAclfBus geBus = (GeAclfBus) bus;
			geBus.setArea(net.getArea(geBus.getGeAreaNo()));
			geBus.setZone(net.getZone(geBus.getGeZoneNo()));
			geBus.setOwner(net.getOwner(geBus.getGeOwnerNo()));

			setBusLoadData(geBus, net.getBaseKva(), net);
			
			if (!setBusGenData(geBus, net.getBaseKva(), net, msg))
				dataError = true;
			
			if (!setBusShuntData(geBus, net.getBaseKva(), net, msg))
				dataError = true;
		}

		// transfer branch data
		for (Branch bra : net.getBranchList()) {
			if (bra instanceof GeAclfBranch) {
				GeAclfBranch geBra = (GeAclfBranch) bra;
				if (!setBranchData(geBra, net.getBaseKva(), msg))
					dataError = true;

				if (!setBranchSectionShuntData(geBra, net.getBaseKva(), net, msg))
					dataError = true;
			}
			else if (bra instanceof GeAclfXformer) {
				GeAclfXformer geXfr = (GeAclfXformer) bra;
				if (!setXfrData(geXfr, net.getBaseKva(), net, msg))
					dataError = true;
			}
		}

		for (Bus bus : net.getBusList()) {
			if (bus.nActiveBranchConnected() == 0)
				bus.setStatus(false);
		}
		return !dataError;
	}

	private static void setNetData(GeAclfNetwork net) {
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
	}
	
	private static void setBusLoadData(GeAclfBus geBus, double baseKva, GeAclfNetwork net) {
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
  			final LoadBusAdapter load = (LoadBusAdapter)geBus.adapt(LoadBusAdapter.class);
  			load.setLoad(new Complex(cp_p, cp_q), UnitType.mVA, baseKva);
  		}
		else if ((ci_p != 0.0 || ci_q != 0.0) && (cp_p==0.0 && cp_q ==0.0 && cz_p==0.0 && cz_q ==0.0) ) {
			geBus.setLoadCode(AclfLoadCode.CONST_I);
  			final LoadBusAdapter load = (LoadBusAdapter)geBus.adapt(LoadBusAdapter.class);
  			load.setLoad(new Complex(ci_p, ci_q), UnitType.mVA, baseKva);
  		}
		else if ((cz_p != 0.0 || cz_q != 0.0) && (ci_p==0.0 && ci_q ==0.0 && cp_p==0.0 && cp_q ==0.0) ) {
			geBus.setLoadCode(AclfLoadCode.CONST_Z);
  			final LoadBusAdapter load = (LoadBusAdapter)geBus.adapt(LoadBusAdapter.class);
  			load.setLoad(new Complex(cz_p, cz_q), UnitType.mVA, baseKva);
  		}
		else if ((cp_p != 0.0 || cp_q != 0.0 || ci_p!= 0.0 || ci_q != 0.0 || cz_p != 0.0 || cz_q !=0.0)) {
			FunctionLoad fload = CoreObjectFactory.createFunctionLoad(net, geBus.getId());
			double loadP0 = cp_p + ci_p + cz_p;
			double loadQ0 = cp_q + ci_q + cz_q;
			fload.getP().setLoad0(loadP0, UnitType.mVA, baseKva);
			fload.getQ().setLoad0(loadQ0, UnitType.mVA, baseKva);
			if (loadP0 != 0.0) {
				fload.getP().setA(cp_p/loadP0, UnitType.PU);
				fload.getP().setB(ci_p/loadP0, UnitType.PU);
			}
			if (loadQ0 != 0.0) {
				fload.getQ().setA(cp_q/loadQ0, UnitType.PU);
				fload.getQ().setB(ci_q/loadQ0, UnitType.PU);
			}
		}
		else {
			geBus.setLoadCode(AclfLoadCode.NON_LOAD);
		}
	}

	private static boolean setBusGenData(GeAclfBus geBus, double baseKva, GeAclfNetwork net, IPSSMsgHub msg) {
		boolean dataError = false;
		
		// transfer gen data
		int regBusNumber = -1;
		double pgen = 0.0, qgen = 0.0, qmax = 0.0, qmin = 0.0;
		for (GeGenerator gen : geBus.getGenList()) {
/*
			st ---no--     reg_name       prf  qrf  ar zone   pgen   pmax   pmin   qgen   qmax   qmin   mbase cmp_r cmp_x gen_r gen_x
			1     101 "NORTH-G1"  16.00  1.00 0.50  1    1  523.44  550.0   0.0  110.8  999.0 -999.0  750.00 0.000 0.872 0.000 0.200
				
*/
			if (gen.isInSevice()) {
				if (regBusNumber == -1)
					regBusNumber = gen.getRegBusNumber();
				else {
					if (regBusNumber != gen.getRegBusNumber()) {
						dataError = true;
						msg.sendErrorMsg("Generator reg number is worng, regBus: " + gen.getRegBusNumber());
					}
				}
			
				pgen += gen.getPMw();
				qgen += gen.getQMvar();
				qmax += gen.getQMvarMax();
				qmin += gen.getQMvarMin();
			}
		}
/*			<ty> Bus type {0,1,2,-2}
			0 = swing bus (voltage magnitude and phase fixed)
			1 = load bus (unconstrained voltage angle and magnitude)
			2 = generator bus (voltage control [terminal or remote] within generator limits)
			-2 = generator bus with unlimited reactive power limits
*/			
		switch (geBus.getGeBusType()) {
			case 0 : {
				geBus.setGenCode(AclfGenCode.SWING);
	  			final SwingBusAdapter gen = (SwingBusAdapter)geBus.adapt(SwingBusAdapter.class);
	  			double mag = geBus.getVSpecPU(), ang = geBus.getVoltageAng(); 
	  			// setVoltMag() also changes VoltAng, so we need first buffer the values
	  			gen.setVoltMag(mag, UnitType.PU);
	  			gen.setVoltAng(ang, UnitType.Rad);					
			} break;
			case 1 : {
				geBus.setGenCode(AclfGenCode.GEN_PQ);
	   			final PQBusAdapter gen = (PQBusAdapter)geBus.adapt(PQBusAdapter.class);
	    		gen.setGen(new Complex(pgen, qgen), UnitType.mVA, net.getBaseKva());
	    	} break;
			case 2 : {
	  			if (regBusNumber == -1) {
					geBus.setGenCode(AclfGenCode.NON_GEN);
	  			}
	  			else if (regBusNumber == new Integer(geBus.getId()).intValue()) {
  					// PV Bus limit control
					geBus.setGenCode(AclfGenCode.GEN_PV);
		  			final PVBusAdapter gen = (PVBusAdapter)geBus.adapt(PVBusAdapter.class);
		  			gen.setGenP(pgen, UnitType.mW, net.getBaseKva());
		  			gen.setVoltMag(geBus.getVSpecPU(), UnitType.PU);

		  			final PVBusLimit pvLimit = CoreObjectFactory.createPVBusLimit(net, geBus.getId());
  			  		pvLimit.setQLimit(new LimitType(qmax, qmin), UnitType.mVar, net.getBaseKva());		  				
	  			}
	  			else {
  					// Remote Q  Bus control, we need to change this bus to a GPQ bus so that its Q could be adjusted
					geBus.setGenCode(AclfGenCode.GEN_PQ);
					String reBusId = new Integer(regBusNumber).toString();
  			  		final RemoteQBus reQ1 = CoreObjectFactory.createRemoteQBus(net, geBus.getId(), 
  			  				RemoteQControlType.BUS_VOLTAGE, reBusId);
  			  		reQ1.setQLimit(new LimitType(qmax, qmin), UnitType.mVar, net.getBaseKva());
  			  		reQ1.setVSpecified(geBus.getVSpecPU());						
	  			}
	  		} break;
			case -2 : {
				geBus.setGenCode(AclfGenCode.GEN_PV);
	  			final PVBusAdapter gen = (PVBusAdapter)geBus.adapt(PVBusAdapter.class);
	  			gen.setGenP(pgen, UnitType.mW, net.getBaseKva());
	  			gen.setVoltMag(geBus.getVSpecPU(), UnitType.PU);
	  		} break;
		}
		return !dataError;
	}

	private static boolean setBusShuntData(GeAclfBus geBus, double baseKva, GeAclfNetwork net, IPSSMsgHub msg) {
		boolean dataError = false;
    	double factor = 1000.0/baseKva;  // for transfer G+jB from MVA to PU on system base 
		GeShunt shunt = geBus.getShunt();
		if (shunt != null && shunt.isInSevice()) 
		   	geBus.setShuntY(new Complex(shunt.getG()*factor,shunt.getB()*factor));
		
		GeControlledShunt cshunt = geBus.getControlledShunt();
		if (cshunt != null && cshunt.isInSevice()) {
			if (cshunt.getType() == 0) {
				// fixed b
			   	geBus.setShuntY(new Complex(cshunt.getG(),cshunt.getB()));  // g,b is in pu
			} else {
				dataError = true;
				msg.sendErrorMsg("Controlled shunt type not supported, type="+cshunt.getType());
			}
		}
		return !dataError;
	}

	private static boolean setBranchSectionShuntData(GeAclfBranch geLine, double baseKva, GeAclfNetwork net, IPSSMsgHub msg) {
		boolean dataError = false;
		
    	double factor = 1000.0/baseKva;  // for transfer G+jB from MVA to PU on system base 
		for (GeBranchSection sec : geLine.getBranchSecList()) {
			for(GeShunt shunt : sec.getShuntList()) {
				if (shunt.isInSevice()) {
					if (shunt.getId().startsWith("f")) {
				    	geLine.setFromShuntY(new Complex(shunt.getG()*factor,shunt.getB()*factor));
					}
					else {
				    	geLine.setToShuntY(new Complex(shunt.getG()*factor,shunt.getB()*factor));
					}
				}
			}
		}
		return !dataError;
	}

	private static boolean setBranchData(GeAclfBranch geBra, double baseKva, IPSSMsgHub msg) {
		boolean dataError = false;
		/*
			st resist   react   charge   rate1   
	    	1 0.01000 0.05000  0.00000  600.0  
		*/			
		if (geBra.getBranchSecList().size() > 1) {
			dataError = true;
			msg.sendErrorMsg("sec.getType() != 0, Function not implmented yet");
		}
		
		GeBranchSection sec = geBra.getBranchSecList().get(0);
		if (sec.getType() != 0) {
			dataError = true;
			msg.sendErrorMsg("sec.getType() != 0, Function not implmented yet");
		}
		if (sec.isOhmicUnit()) {
			dataError = true;
			msg.sendErrorMsg("sec.isOhmicUnti == true, Function not implmented yet");
		}
			
	   	geBra.setStatus(sec.isInSevice());
	   	if (geBra.getFromAclfBus().getBaseVoltage() == geBra.getToAclfBus().getBaseVoltage()) {
	   		geBra.setBranchCode(AclfBranchCode.LINE);
			final LineAdapter line = (LineAdapter)geBra.adapt(LineAdapter.class);
		   	line.getAclfBranch().setZ(new Complex(sec.getR(),sec.getX()), msg);
		   	line.setHShuntY(new Complex(0.0,0.5*sec.getB()), UnitType.PU, 1.0, baseKva); // Unit is PU, no need to enter baseV
		   	line.setMvaRating1(sec.getMvaRatingAry().get(0));
		   	line.setMvaRating2(sec.getMvaRatingAry().get(1));
		   	line.setMvaRating3(sec.getMvaRatingAry().get(2));
	   	}
	   	else {
	    	geBra.setBranchCode(AclfBranchCode.XFORMER);
			final XfrAdapter xfr = (XfrAdapter)geBra.adapt(XfrAdapter.class);
	    	xfr.getAclfBranch().setZ(new Complex(sec.getR(),sec.getX()), msg);
	    	xfr.setFromTurnRatio(1.0+sec.getFromTap(), UnitType.PU);
	    	xfr.setToTurnRatio(1.0+sec.getToTap(), UnitType.PU); 
	    	geBra.getFromAclfBus().setShuntY(new Complex(0.5*sec.getGi(), 0.0));
	    	geBra.getToAclfBus().setShuntY(new Complex(0.5*sec.getGi(), 0.0));
	   	}

    	return !dataError;
	}
	
	private static boolean setXfrData(GeAclfXformer geXfr, double baseKva, GeAclfNetwork net, IPSSMsgHub msg) {
		boolean dataError = false;
		
		/*
		st ty --no---    reg_name          zt         int                           tert               
		 1  1   -1      "        " 000.00   0   -1      "        " 000.00   -1      "        " 000.00  
		ar zone  tbase   ps_r    ps_x    pt_r    pt_x    ts_r    ts_x
		 1    1  600.0 0.00000 0.10000 0.00000 0.00000 0.00000 0.00000 /
		vnomp>  vnoms>  vnomt   anglp> gmag>   bmag>    r1>      r2     r3     r4> aloss> 
		230.00  16.00   0.00    0.0    0.00000 0.00000  600.0    0.0    0.0    0.0 0.000  
		tmax   tmin>  vtmax  vtmin  stepp>  tapp   tapfp> tapfs> tapft
		1.5000 0.5100 1.5000 0.5100 0.00000 1.0000 1.0000 1.0000 1.0000
		 */
		
		// adjust xfr parameters for base MVA
		double factor = baseKva / (geXfr.getBaseMvaPrim2Secd()*1000.0);
    	double r = geXfr.getRPrim2Secd()*factor,
    		   x = geXfr.getXPrim2Secd()*factor,
    		   g = geXfr.getGmagPU()/factor,
    		   b = geXfr.getBmagPU()/factor,
    		   fromRatio = geXfr.getFixedTapPrim(),
    		   toRatio = geXfr.getFixedTapSecd();

    	if (geXfr.getFromAclfBus().getBaseVoltage() != geXfr.getNominalKvPrim()*1000.0 || 
				geXfr.getToAclfBus().getBaseVoltage() != geXfr.getNominalKvSecd()*1000.0	) {
				// all xfr data are on nominal voltage. They have to be adjusted 
			dataError = true;
			msg.sendErrorMsg("adjust xfr parameters, Function not implmented yet");
		}

    	geXfr.setBranchCode(AclfBranchCode.XFORMER);
		final XfrAdapter xfr = (XfrAdapter)geXfr.adapt(XfrAdapter.class);
    	xfr.getAclfBranch().setZ(new Complex(r, x), msg);
    	xfr.setFromTurnRatio(fromRatio, UnitType.PU);
    	xfr.setToTurnRatio(toRatio, UnitType.PU); 
    	geXfr.getFromAclfBus().setShuntY(new Complex(0.5*g, 0.5*b));
    	geXfr.getToAclfBus().setShuntY(new Complex(0.5*g, 0.5*b));
    	
    	if (geXfr.getPhaseAngleDegPrim() != 0.0 || geXfr.getPhaseAngleDegSecd() != 0.0) {
    		// PhaseShifting transformer branch
    		IpssLogger.getLogger().info("Branch " + geXfr.getId() + " is a PsXfr" );
    	 	geXfr.setBranchCode(AclfBranchCode.PS_XFORMER);
    		final PSXfrAdapter psXfr = (PSXfrAdapter)geXfr.adapt(PSXfrAdapter.class);
    		psXfr.setFromAngle(geXfr.getPhaseAngleDegPrim()*Constants.DtoR);
    		psXfr.setToAngle(geXfr.getPhaseAngleDegSecd()*Constants.DtoR);
		}
		
		if (geXfr.getType() == 2 || geXfr.getType() == 12) {
			// tap voltage control
			String controlBusId = new Integer(geXfr.getAdjBusNumber()).toString();
			final TapControl tapv = CoreObjectFactory.createTapVControlBusVoltage(
      				net, geXfr.getId(), controlBusId, FlowControlType.RANGE_CONTROL);
      		tapv.setTapLimit(new LimitType(geXfr.getTapAngMax(),geXfr.getTapAngMin()));
      		tapv.setControlRange(new LimitType(geXfr.getVmax(), geXfr.getVmin()));
      		tapv.setVSpecified(1.0);
      		tapv.setTapStepSize(geXfr.getAdjTapAngStep());
      		// we use from side tap to control
      		tapv.setControlOnFromSide(true);
      		tapv.setMeteredOnFromSide(true);
      		net.addTapControl(tapv, controlBusId);   
		}
		else if (geXfr.getType() == 4 || geXfr.getType() == 14) {
			// ps-xfr angle power control
			dataError = true;
			msg.sendErrorMsg("geXfr.getType() != 4, 14, Function not implmented yet");
/*
			final PSXfrPControl ps = CoreObjectFactory.createPSXfrPControl(adjNet, xfr.getId(), FlowControlType.RANGE_CONTROL);
      		ps.setAngLimit(new LimitType(xfr.getRmLimit().getMax()*Constants.DtoR, 
      									 xfr.getRmLimit().getMin()*Constants.DtoR));
      		double baseMva = adjNet.getBaseKva() * 0.001;
      		ps.setControlRange(new LimitType(xfr.getVmLimit().getMax()/baseMva, xfr.getVmLimit().getMin()/baseMva));
      		// we use from side angle to control
      		ps.setControlOnFromSide(true);
      		ps.setMeteredOnFromSide(xfr.isControlOnFromSide());
      		ps.setFlowFrom2To(true);
      		if (xfr.getControlMode() == -3)
      			ps.setStatus(false);
  			adjNet.addPSXfrPControl(ps, xfr.getId());
 */ 			   
		}
		else if (geXfr.getType() != 1 && geXfr.getType() != 11) {
			dataError = true;
			msg.sendErrorMsg("geXfr.getType() == " + geXfr.getType() + ", Function not implmented yet");
		}
		
		return !dataError;
	}
	
	/*
	 *   Utility functions
	 */
	public static GeAclfBus getBus(int busNo, GeAclfNetwork net, IPSSMsgHub msg) throws Exception { 			
		String id = new Integer(busNo).toString();
		GeAclfBus  bus = (GeAclfBus)net.getBus(id);
		if (bus == null) {
			msg.sendErrorMsg("Bus cannot be found, bus number: " + id);
			throw new Exception("Bus cannot be found");
		}
		return bus;
	}
	
	public static GeAclfBranch getBranch(int fBusNo, int tBusNo, String ck, GeAclfNetwork net, IPSSMsgHub msg) throws Exception { 			
		GeAclfBranch branch = (GeAclfBranch)net.getBranch(new Integer(fBusNo).toString(), new Integer(tBusNo).toString(), ck);
		if (branch == null) {
			msg.sendErrorMsg("Branch section data error, branch cannot be found, fromBus, toBus: " + fBusNo + ", " + tBusNo);
			throw new Exception("Branch cannot be found");
		}
		return branch;
	}
	
	public static GeBranchSection getBranchSection(int fBusNo, int tBusNo, String ck, int secNo, GeAclfNetwork net, IPSSMsgHub msg) throws Exception { 			
		GeAclfBranch branch = getBranch(fBusNo, tBusNo, ck, net, msg);
		GeBranchSection sec = branch.getBranchSection(secNo);
		if (sec == null) {
			msg.sendErrorMsg("Branch section data error, branch section cannot be found, section: " + secNo);
			throw new Exception("Branch section cannot be found");
		}
		return sec;
	}
}
