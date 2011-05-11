/*
 * @(#)GovernorDataHelper.java   
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

package org.interpss.mapper.odm.impl.dstab;

import org.ieee.odm.schema.GovHydroTurbineXmlType;
import org.ieee.odm.schema.GovSimpleTypeXmlType;
import org.ieee.odm.schema.GovSteamNRXmlType;
import org.ieee.odm.schema.GovSteamTCSRXmlType;
import org.ieee.odm.schema.GovSteamTDSRXmlType;
import org.ieee.odm.schema.GovernorModelXmlType;
import org.interpss.dstab.control.gov.GovernorObjectFactory;
import org.interpss.dstab.control.gov.ieee.hturbine.IeeeHTurbineGovernor;
import org.interpss.dstab.control.gov.ieee.steamNR.IeeeSteamNRGovernor;
import org.interpss.dstab.control.gov.ieee.steamTCSR.IeeeSteamTCSRGovernor;
import org.interpss.dstab.control.gov.ieee.steamTDSR.IeeeSteamTDSRGovernor;
import org.interpss.dstab.control.gov.simple.SimpleGovernor;

import com.interpss.common.exp.InterpssException;
import com.interpss.dstab.mach.Machine;



public class GovernorDataHelper {
	private Machine mach = null;

	public GovernorDataHelper(Machine mach) {
		this.mach = mach;
	}
	
	/**
	 * create the gov model and add to its parent machine object
	 * 
	 * @param govXmlRec ODM governor model record
	 */
	public void createGovernor(GovernorModelXmlType govXmlRec) throws InterpssException  {
		if (govXmlRec instanceof GovSimpleTypeXmlType) {
			GovSimpleTypeXmlType govXml = (GovSimpleTypeXmlType)govXmlRec;
			SimpleGovernor gov = GovernorObjectFactory.createSimpleGovernor(mach.getId()+"_Gov", govXml.getName(), mach);
			gov.getData().setK(govXml.getK());
			gov.getData().setT1(govXml.getT1().getValue());
			gov.getData().setPmax(govXml.getPmax());
			gov.getData().setPmin(govXml.getPmin());
		}
		else if (govXmlRec instanceof GovSteamNRXmlType) {
			GovSteamNRXmlType govXml = (GovSteamNRXmlType)govXmlRec;
			IeeeSteamNRGovernor gov = GovernorObjectFactory.createIeeeSteamNRGovernor(mach.getId()+"_Gov", govXml.getName(), mach);
			gov.getData().setK(govXml.getK());
			gov.getData().setT1(govXml.getT1().getValue());
			gov.getData().setT2(govXml.getT2().getValue());
			gov.getData().setT3(govXml.getT3().getValue());
			gov.getData().setPmax(govXml.getPMAX());
			gov.getData().setPmin(govXml.getPMIN());
			gov.getData().setPup(govXml.getPup());
			gov.getData().setPdown(govXml.getPdown());
			gov.getData().setTch(govXml.getTCH().getValue());
		}
		else if (govXmlRec instanceof GovSteamTCSRXmlType) {
			GovSteamTCSRXmlType govXml = (GovSteamTCSRXmlType)govXmlRec;
			IeeeSteamTCSRGovernor gov = GovernorObjectFactory.createIeeeSteamTCSRGovernor(mach.getId()+"_Gov", govXml.getName(), mach);
			gov.getData().setK(govXml.getK());
			gov.getData().setT1(govXml.getT1().getValue());
			gov.getData().setT2(govXml.getT2().getValue());
			gov.getData().setT3(govXml.getT3().getValue());
			gov.getData().setPmax(govXml.getPMAX());
			gov.getData().setPmin(govXml.getPMIN());
			gov.getData().setPup(govXml.getPup());
			gov.getData().setPdown(govXml.getPdown());
			gov.getData().setTch(govXml.getTCH().getValue());
			gov.getData().setTrh(govXml.getTRH().getValue());
			gov.getData().setTco(govXml.getTCO().getValue());
			gov.getData().setFhp(govXml.getFCH());
			gov.getData().setFip(govXml.getFIP());
			gov.getData().setFlp(govXml.getFLP());
		}
		else if (govXmlRec instanceof GovSteamTDSRXmlType) {
			GovSteamTDSRXmlType govXml = (GovSteamTDSRXmlType)govXmlRec;
			IeeeSteamTDSRGovernor gov = GovernorObjectFactory.createIeeeSteamTDSRGovernor(mach.getId()+"_Gov", govXml.getName(), mach);
			gov.getData().setK(govXml.getK());
			gov.getData().setT1(govXml.getT1().getValue());
			gov.getData().setT2(govXml.getT2().getValue());
			gov.getData().setT3(govXml.getT3().getValue());
			gov.getData().setPmax(govXml.getPMAX());
			gov.getData().setPmin(govXml.getPMIN());
			gov.getData().setPup(govXml.getPup());
			gov.getData().setPdown(govXml.getPdown());
			gov.getData().setTch(govXml.getTCH().getValue());
			gov.getData().setTrh1(govXml.getTRH1().getValue());
			gov.getData().setTrh2(govXml.getTRH2().getValue());			
			gov.getData().setTco(govXml.getTCO().getValue());
			gov.getData().setFhp(govXml.getFHP());
			gov.getData().setFip(govXml.getFIP());
			gov.getData().setFlp(govXml.getFLP());
		}
		else if (govXmlRec instanceof GovHydroTurbineXmlType) {
			GovHydroTurbineXmlType govXml = (GovHydroTurbineXmlType)govXmlRec;
			IeeeHTurbineGovernor gov = GovernorObjectFactory.createIeeeHTurbineGovernor(mach.getId()+"_Gov", govXml.getName(), mach);						
			gov.getData().setK(govXml.getK());
			gov.getData().setT1(govXml.getT1().getValue());
			gov.getData().setT2(govXml.getT2().getValue());
			gov.getData().setT3(govXml.getT3().getValue());
			gov.getData().setPmax(govXml.getPMAX());
			gov.getData().setPmin(govXml.getPMIN());			
			gov.getData().setTw(govXml.getTWhalf().getValue());			
		}
		else {
			throw new InterpssException("Governor type invalid or not implemented, type " + govXmlRec.getClass().getSimpleName());
		}
		
	}
}