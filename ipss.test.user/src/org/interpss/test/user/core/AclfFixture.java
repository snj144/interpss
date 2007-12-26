 /*
  * @(#)AclfFixture.java   
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

package org.interpss.test.user.core;

import org.interpss.display.AclfOutFunc;
import org.interpss.test.user.IpssFixture;

import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreSpringAppContext;
import com.interpss.core.aclf.CapacitorBusAdapter;
import com.interpss.core.aclf.GenBusAdapter;
import com.interpss.core.aclf.LoadBusAdapter;
import com.interpss.core.aclf.PSXfrAdapter;
import com.interpss.core.aclf.XfrAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.AclfMethod;

public class AclfFixture extends IpssFixture {
	private double tolerance = 0.0001;
	private String lfMethod = "NR";
	private int    maxIterations = 20;
	private double gsAccelerator = 1.0;

	/*
	 * ActionFixture functions
	 */

	public void runAcLoadFlow() {
		simuCtx.setLoadflowAlgorithm(CoreSpringAppContext.getLoadflowAlgorithm());
		AclfAdjNetwork net = simuCtx.getAclfAdjNet();
		simuCtx.getLoadflowAlgorithm().setTolerance(tolerance, UnitType.PU, net.getBaseKva());
		simuCtx.getLoadflowAlgorithm().setMaxIterations(maxIterations);
		simuCtx.getLoadflowAlgorithm().setLfMethod(lfMethod.equals("NR")? AclfMethod.NR :
	  		(lfMethod.equals("PQ")? AclfMethod.PQ : AclfMethod.GS));
	  	if (lfMethod.equals("GS"))
	  		simuCtx.getLoadflowAlgorithm().setGsAccFactor(gsAccelerator);
	  	simuCtx.getLoadflowAlgorithm().loadflow(msg);		
	}

	public void setTolerance(double x) {
		tolerance = x;
	}
	
	public void setLfMethod(String s) throws Exception {
		if (!lfMethod.equals("NR") && lfMethod.equals("PQ") & lfMethod.equals("GS"))
			throw new Exception("Wrong loadflow mehtod (NR, PQ, GS), method entered: " + s);
		lfMethod = s;
	}

	public void setMaxIterations(int n) {
		maxIterations = n;
	}

	public void setGsAccelerator(double x) {
		gsAccelerator = x;
	}

	public boolean lfConverged() {
		return simuCtx.getAclfNet().isLfConverged();
	}
	
	public void outputAclfResults() {
		System.out.println(AclfOutFunc.lfResultsBusStyle(simuCtx.getAclfNet()));
	}
	
	public void outputAclfDebugInfo() {
		System.out.println(simuCtx.getAclfNet().net2String());
	}
	
	/*
	 * Bus ColumnFixture functions
	 */

	public double busVoltage() throws Exception {
		return formatDouble(getBus().getVoltageMag());
	}

	public double busAngle() throws Exception {
		return formatDouble(getBus().getVoltageAng(UnitType.Deg));
	}

	public double busPIntoNet() throws Exception {
		return formatDouble(getBus().powerIntoNet().getReal());
	}

	public double busQIntoNet() throws Exception {
		return formatDouble(getBus().powerIntoNet().getImaginary());
	}
	
	public double busLoadP() throws Exception {
  		LoadBusAdapter loadBus = (LoadBusAdapter)getBus().adapt(LoadBusAdapter.class);
		return formatDouble(loadBus.getLoadResults().getReal());
	}

	public double busLoadQ() throws Exception {
  		LoadBusAdapter loadBus = (LoadBusAdapter)getBus().adapt(LoadBusAdapter.class);
		return formatDouble(loadBus.getLoadResults().getImaginary());
	}

	public double busGenP() throws Exception {
  		GenBusAdapter genBus = (GenBusAdapter)getBus().adapt(GenBusAdapter.class);
		return formatDouble(genBus.getGenResults().getReal());
	}

	public double busGenQ() throws Exception {
  		GenBusAdapter genBus = (GenBusAdapter)getBus().adapt(GenBusAdapter.class);
		return formatDouble(genBus.getGenResults().getImaginary());
	}

	public double busCapacitorQ() throws Exception {
  		CapacitorBusAdapter capBus = (CapacitorBusAdapter)getBus().adapt(CapacitorBusAdapter.class);
		return formatDouble(capBus.getQResults(getBus().getVoltageMag(), UnitType.PU, simuCtx.getAclfNet().getBaseKva()));
	}

	/*
	 * Branch ColumnFixture functions
	 */

	public double branchFrom2ToP() throws Exception {
		return formatDouble(getBranch().powerFrom2To(UnitType.PU, simuCtx.getAclfNet().getBaseKva()).getReal());
	}

	public double branchFrom2ToQ() throws Exception {
		return formatDouble(getBranch().powerFrom2To(UnitType.PU, simuCtx.getAclfNet().getBaseKva()).getImaginary());
	}

	public double branchTo2FromP() throws Exception {
		return formatDouble(getBranch().powerTo2From(UnitType.PU, simuCtx.getAclfNet().getBaseKva()).getReal());
	}

	public double branchTo2FromQ() throws Exception {
		return formatDouble(getBranch().powerTo2From(UnitType.PU, simuCtx.getAclfNet().getBaseKva()).getImaginary());
	}

	public double branchPsXfrAngDeg() throws Exception {
		PSXfrAdapter xfr = (PSXfrAdapter)getBranch().adapt(PSXfrAdapter.class);
		return formatDouble(xfr.getFromAngle(UnitType.Deg));
	}

	public double branchXfrFromTurnRatio() throws Exception {
		XfrAdapter xfr = (XfrAdapter)getBranch().adapt(XfrAdapter.class);
		return formatDouble(xfr.getFromTurnRatio());
	}

	public double branchXfrToTurnRatio() throws Exception {
		XfrAdapter xfr = (XfrAdapter)getBranch().adapt(XfrAdapter.class);
		return formatDouble(xfr.getToTurnRatio());
	}
}
