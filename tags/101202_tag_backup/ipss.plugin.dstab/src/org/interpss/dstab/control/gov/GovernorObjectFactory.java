/*
 * @(#)GovernorObjectFactory.java   
 *
 * Copyright (C) 2008-2010 www.interpss.org
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
 * @Date 08/15/2010
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.dstab.control.gov;

import org.interpss.dstab.control.gov.ieee.hturbine.IeeeHTurbineGovernor;
import org.interpss.dstab.control.gov.ieee.ieeeST1.IeeeST1Governor;
import org.interpss.dstab.control.gov.ieee.ieeeST2.IeeeST2Governor;
import org.interpss.dstab.control.gov.ieee.steamNR.IeeeSteamNRGovernor;
import org.interpss.dstab.control.gov.ieee.steamTCSR.IeeeSteamTCSRGovernor;
import org.interpss.dstab.control.gov.ieee.steamTDSR.IeeeSteamTDSRGovernor;
import org.interpss.dstab.control.gov.simple.SimpleGovernor;

import com.interpss.dstab.mach.Machine;

public class GovernorObjectFactory {
	public static SimpleGovernor createSimpleGovernor(String id, String name, Machine machine) {
		SimpleGovernor gov = new SimpleGovernor(id, name, "InterPSS");
		gov.setMachine(machine); 
		return gov;
  	}
	public static IeeeHTurbineGovernor createIeeeHTurbineGovernor(String id, String name, Machine machine) {
		IeeeHTurbineGovernor gov = new IeeeHTurbineGovernor(id, name, "InterPSS");
		gov.setMachine(machine); 
		return gov;
  	}
	public static IeeeST1Governor createIeeeST1Governor(String id, String name, Machine machine) {
		IeeeST1Governor gov = new IeeeST1Governor(id, name, "InterPSS");
		gov.setMachine(machine); 
		return gov;
  	}
	public static IeeeST2Governor createIeeeST2Governor(String id, String name, Machine machine) {
		IeeeST2Governor gov = new IeeeST2Governor(id, name, "InterPSS");
		gov.setMachine(machine); 
		return gov;
  	}
	public static IeeeSteamNRGovernor createIeeeSteamNRGovernor(String id, String name, Machine machine) {
		IeeeSteamNRGovernor gov = new IeeeSteamNRGovernor(id, name, "InterPSS");
		gov.setMachine(machine); 
		return gov;
  	}
	public static IeeeSteamTCSRGovernor createIeeeSteamTCSRGovernor(String id, String name, Machine machine) {
		IeeeSteamTCSRGovernor gov = new IeeeSteamTCSRGovernor(id, name, "InterPSS");
		gov.setMachine(machine); 
		return gov;
  	}
	public static IeeeSteamTDSRGovernor createIeeeSteamTDSRGovernor(String id, String name, Machine machine) {
		IeeeSteamTDSRGovernor gov = new IeeeSteamTDSRGovernor(id, name, "InterPSS");
		gov.setMachine(machine); 
		return gov;
  	}
}