 /*
  * @(#)AclfStudyCaseUtilFunc.java   
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
  * @Date 09/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.core.ms_case.aclf;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.ms_case.StudyCase;
import com.interpss.core.ms_case.result.AclfBusResult;
import com.interpss.core.ms_case.result.AclfNetworkResult;
import com.interpss.core.ms_case.result.BranchResult;
import com.interpss.core.ms_case.result.BusResult;
import com.interpss.core.net.Bus;

public class AclfStudyCaseUtilFunc {
	/**
	 * Increase load of the AclfBus, referenced by the BusResult object by dP using constant power factor 
	 * 
	 * @param busResult AclfBusResult object
	 * @param dP delta P
	 */
	public static void increaseBusLoadConstPF(AclfBusResult busResult, double dP) {
		AclfBus bus = (AclfBus)busResult.getBus();
		double dQ = busResult.getLoad().getReal() == 0.0 ? 0.0 : dP * busResult.getLoad().getImaginary() / busResult.getLoad().getReal(); 
		bus.setLoadP(busResult.getLoad().getReal() + dP);
		bus.setLoadQ(busResult.getLoad().getImaginary() + dQ);		
	}
	
	/**
	 * Increase load of the AclfBus, referenced by the BusResult object by P = P * pFactor, Q = Q * qFactor 
	 * 
	 * @param busResult AclfBusResult object
	 * @param pFactor P factor
	 * @param qFactor Q factor
	 */
	public static void increaseBusLoad(AclfBusResult busResult, double pFactor, double qFactor) {
		AclfBus bus = (AclfBus)busResult.getBus();
		bus.setLoadP(busResult.getLoad().getReal()*pFactor);
		bus.setLoadQ(busResult.getLoad().getImaginary()*qFactor);		
	}

	/**
	 * Increase gen of the AclfBus, referenced by the BusResult object by dP using constant power factor 
	 * 
	 * @param busResult AclfBusResult object
	 * @param dP delta P
	 */
	public static void increaseBusGenConstPF(AclfBusResult busResult, double dP) {
		AclfBus bus = (AclfBus)busResult.getBus();
		dP = dP * 0.5;
		if (bus.isGenPV()) {
			bus.setGenP(busResult.getGen().getReal() + dP);
		}
		else if (bus.isGenPQ()) {
			bus.setGenP(busResult.getGen().getReal() + dP);
			double dQ = busResult.getGen().getReal() == 0.0 ? 0.0 : dP * busResult.getGen().getImaginary() / busResult.getGen().getReal(); 
			bus.setGenQ(busResult.getGen().getImaginary() + dQ);
		}		
	}
	
	/**
	 * Set the AclfNetworkResult object to the StudyCase object
	 * 
	 * @param studyCase
	 * @param rnet
	 */
	public static void setAclfNetResult2StudyCase(StudyCase studyCase, AclfNetworkResult rnet) {
		studyCase.setNetResult(rnet);
		AclfNetwork net = (AclfNetwork)studyCase.getParent().getNetwork();
		for (BusResult rbus : rnet.getBusResultList()) {
			rbus.setBus(net.getBus(rbus.getBusId()));
		}
		for (BranchResult rbus : rnet.getBranchResultList()) {
			rbus.setBranch(net.getBranch(rbus.getBranchId()));
		}
	}

	/**
	 * Create an AclfNetworkResult object based on the AclfNetwork object contained by studyCase
	 * 
	 * @param studyCase
	 * @return
	 */
	public static AclfNetworkResult createAclfNetResult(StudyCase studyCase) {
		AclfNetwork net = (AclfNetwork)studyCase.getParent().getNetwork();
		return createAclfNetResult(net, studyCase);
	}

	/**
	 * Create an AclfNetworkResult object based on the AclfNetwork object

	 * @param uid Grid node UUDI
	 * @param net
	 * @return
	 */
	public static AclfNetworkResult createAclfNetResult(String uid, AclfNetwork net) {
		AclfNetworkResult rnet = createAclfNetResult(net, null);
		rnet.setUid(uid);
		return rnet;
	}

	private static AclfNetworkResult createAclfNetResult(AclfNetwork net, StudyCase studyCase) {
		AclfNetworkResult rnet = CoreObjectFactory.createAclfNetworkResult(net.getId());
		if (studyCase != null)
			studyCase.setNetResult(rnet);
		rnet.setCaseNumber(net.getSortNumber());
		rnet.setLfConverged(net.isLfConverged());
		for (Bus b : net.getBusList()) {
			AclfBus bus = (AclfBus)b;
			// when studyCase == null, it indicates calculation is at a remote place. We do 
			// not need to link ResultBus with AclfBus
			AclfBusResult rbus = CoreObjectFactory.createAclfBusResult(bus, studyCase!=null);
			rnet.getBusResultList().add(rbus);
			rbus.setLoad(bus.getLoad());
			rbus.setGen(bus.powerIntoNet().add(rbus.getLoad()));
			rbus.setVoltage(bus.getVoltage());
		}
		return rnet;
	}
}
