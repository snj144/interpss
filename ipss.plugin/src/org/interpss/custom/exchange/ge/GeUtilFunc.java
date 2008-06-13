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

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
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
import com.interpss.core.aclfadj.PVBusLimit;
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
import com.interpss.ext.ge.aclf.GeBranchSection;
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
		boolean dataError = false;
		
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
				dataError = true;
				msg.sendErrorMsg("Functional load, Function not implmented yet");
			}
			else {
				geBus.setLoadCode(AclfLoadCode.NON_LOAD);
			}
			
			// transfer gen data
			int regBusNumber = -1;
			double pgen = 0.0, qgen = 0.0, qmax = 0.0, qmin = 0.0;
			for (GeGenerator gen : geBus.getGenList()) {
/*
				st ---no--     reg_name       prf  qrf  ar zone   pgen   pmax   pmin   qgen   qmax   qmin   mbase cmp_r cmp_x gen_r gen_x
 				1     101 "NORTH-G1"  16.00  1.00 0.50  1    1  523.44  550.0   0.0  110.8  999.0 -999.0  750.00 0.000 0.872 0.000 0.200
 				
*/
				if (regBusNumber == -1)
					regBusNumber = gen.getRegBusNumber();
				else {
					if (regBusNumber != gen.getRegBusNumber()) {
						dataError = true;
						msg.sendErrorMsg("Generator reg number is worng, regBus: " + gen.getRegBusNumber());
					}
				}
				
				if (gen.isInSevice()) {
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
		  			gen.setVoltMag(geBus.getVSpecPU(), UnitType.PU);
		  			gen.setVoltAng(geBus.getVoltageAng(), UnitType.Rad);					
				} break;
				case 1 : {
					geBus.setGenCode(AclfGenCode.GEN_PQ);
		   			final PQBusAdapter gen = (PQBusAdapter)geBus.adapt(PQBusAdapter.class);
		    		gen.setGen(new Complex(pgen, qgen), UnitType.mVA, net.getBaseKva());
		    	} break;
				case 2 : {
					geBus.setGenCode(AclfGenCode.GEN_PV);
		  			final PVBusAdapter gen = (PVBusAdapter)geBus.adapt(PVBusAdapter.class);
		  			gen.setGenP(pgen, UnitType.mW, net.getBaseKva());
		  			gen.setVoltMag(geBus.getVSpecPU(), UnitType.PU);
		  			if (regBusNumber == new Integer(geBus.getId()).intValue()) {
	  					// PV Bus limit control
	  			  		final PVBusLimit pvLimit = CoreObjectFactory.createPVBusLimit(net, geBus.getId());
	  			  		pvLimit.setQLimit(new LimitType(qmax, qmin), UnitType.mVar, net.getBaseKva());		  				
		  			}
		  			else {
		  				dataError = true;
						msg.sendErrorMsg("geBus.getGeBusType() == 2, Function not implmented yet");
		  			}
		  		} break;
				case -2 : {
					geBus.setGenCode(AclfGenCode.GEN_PV);
		  			final PVBusAdapter gen = (PVBusAdapter)geBus.adapt(PVBusAdapter.class);
		  			gen.setGenP(pgen, UnitType.mW, net.getBaseKva());
		  			gen.setVoltMag(geBus.getVSpecPU(), UnitType.PU);
		  		} break;
			}
		}
		
		// transfer branch data
		for (Branch bra : net.getBranchList()) {
/*
			st resist   react   charge   rate1   
		    1 0.01000 0.05000  0.00000  600.0  
*/			
			if (bra instanceof GeAclfLine) {
				GeAclfLine geLine = (GeAclfLine) bra;
				
				double r = 0.0, x = 0.0, b = 0.0, r1 = 0.0, r2 = 0.0, r3 = 0.0;
				for (GeBranchSection sec : geLine.getBranchSecList()) {
					if (sec.isInSevice()) {
						r += sec.getR();
						x += sec.getX();
						b += sec.getB();
						r1 += sec.getMvaRatingAry().get(0);
						r2 += sec.getMvaRatingAry().get(1);
						r3 += sec.getMvaRatingAry().get(2);
					}
					
					if (sec.getType() != 0) {
						dataError = true;
						msg.sendErrorMsg("sec.getType() != 0, Function not implmented yet");
					}
					if (sec.isOhmicUnit()) {
						dataError = true;
						msg.sendErrorMsg("sec.isOhmicUnti == true, Function not implmented yet");
					}
				}
				
	        	geLine.setBranchCode(AclfBranchCode.LINE);
	    		final LineAdapter line = (LineAdapter)bra.adapt(LineAdapter.class);
	        	line.getAclfBranch().setZ(new Complex(r,x), msg);
	        	line.setHShuntY(new Complex(0.0,0.5*b), UnitType.PU, 1.0, net.getBaseKva()); // Unit is PU, no need to enter baseV
	        	line.setMvaRating1(r1);
	        	line.setMvaRating2(r2);
	        	line.setMvaRating3(r3);
			}
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
			else if (bra instanceof GeAclfXformer) {
				GeAclfXformer geXfr = (GeAclfXformer) bra;
				if (geXfr.getFromAclfBus().getBaseVoltage() != geXfr.getNominalKvPrim()*1000.0 || 
					geXfr.getToAclfBus().getBaseVoltage() != geXfr.getNominalKvSecd()*1000.0	) {
					// adjust xfr parameters
					dataError = true;
					msg.sendErrorMsg("adjust xfr parameters, Function not implmented yet");
				}
				
				double factor = net.getBaseKva() / (geXfr.getBaseMvaPrim2Secd()*1000.0);
	    	 	geXfr.setBranchCode(AclfBranchCode.XFORMER);
	    		final XfrAdapter xfr = (XfrAdapter)geXfr.adapt(XfrAdapter.class);
	        	xfr.getAclfBranch().setZ(new Complex(geXfr.getRPrim2Secd()*factor,geXfr.getXPrim2Secd()*factor), msg);
	        	xfr.setFromTurnRatio(geXfr.getFixedTapPrim(), UnitType.PU);
	        	xfr.setToTurnRatio(geXfr.getFixedTapSecd(), UnitType.PU); 
	        	geXfr.getFromAclfBus().setShuntY(new Complex(0.5*geXfr.getGmagPU()/factor, 0.5*geXfr.getBmagPU()/factor));
	        	geXfr.getToAclfBus().setShuntY(new Complex(0.5*geXfr.getGmagPU()/factor, 0.5*geXfr.getBmagPU()/factor));
	        	if (geXfr.getPhaseAngleDegPrim() != 0.0 || geXfr.getPhaseAngleDegSecd() != 0.0) {
	        		// PhaseShifting transformer branch
	        	 	geXfr.setBranchCode(AclfBranchCode.PS_XFORMER);
	        		final PSXfrAdapter psXfr = (PSXfrAdapter)bra.adapt(PSXfrAdapter.class);
	        		psXfr.setFromAngle(geXfr.getPhaseAngleDegPrim()*Constants.DtoR);
	        		psXfr.setToAngle(geXfr.getPhaseAngleDegSecd()*Constants.DtoR);
				}
				
				if (geXfr.getType() != 1) {
					dataError = true;
					msg.sendErrorMsg("geXfr.getType() != 1, Function not implmented yet");
				}
			}

		}
		
		return !dataError;
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
