 /*
  * @(#)IEEECDF_ODMTest.java   
  *
  * Copyright (C) 2008 www.interpss.org
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
  * @Author Stephen Hou
  * @Version 1.0
  * @Date 02/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.odm.test.ge;

import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFBranchCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFGenCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFLoadCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;
import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.ge.GE_PSLF_Adapter;
import org.ieee.odm.model.xbean.XBeanODMModelParser;
import org.ieee.odm.model.xbean.XBeanParserHelper;
import org.junit.Test;

public class GE_ODMTest { 
	@Test
	public void testCase1() throws Exception {
		final LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		
		IODMPSSAdapter adapter = new GE_PSLF_Adapter(logger);
		assertTrue(adapter.parseInputFile("testdata/ge/Sample18Bus.epc"));
		
		//System.out.println(adapter.getModel().toString());
		
		PSSNetworkXmlType baseCaseNet = ((XBeanODMModelParser)adapter.getModel()).getBaseCase();
		assertTrue(baseCaseNet.getBusList().getBusArray().length == 18);
		assertTrue(baseCaseNet.getBranchList().getBranchArray().length == 24);

		assertTrue(baseCaseNet.getBasePower().getValue() == 100.0);
		assertTrue(baseCaseNet.getBasePower().getUnit() == ApparentPowerUnitType.MVA);
		
		/*
		bus data  [   18]             ty  vsched   volt     angle   ar zone  vmax   vmin   date_in date_out pid L own
		       2 "NORTH-02" 230.00  :  1 0.95865 0.946417 -12.90653  1    1 1.0086 0.9086   400101   391231   0 0   0
		load data  [   7]           id   long_id_     st      mw      mvar    mw_i    mvar_i  mw_z      mvar_z ar zone  date_in date_out pid N own
		       2 "NORTH-02" 230.00 "1 " "        "  :  1    0.000    0.000    0.000    0.000  334.932    0.000  1    1   400101   391231   0 0   0
		*/
		BusRecordXmlType busRec = XBeanParserHelper.findBusRecord("Bus2", baseCaseNet);
		//System.out.println(busRec);
		assertTrue(busRec.getBaseVoltage().getValue() == 230.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.NONE_GEN);
		assertTrue(busRec.getLoadflowData().getLoadData() != null);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getCode() == LFLoadCodeEnumType.CONST_Z);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstZLoad().getRe() == 334.932);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstZLoad().getIm() == 0.0);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstZLoad().getUnit() == ApparentPowerUnitType.MVA);
		assertTrue(busRec.getLoadflowData().getShuntY() == null);

		/*
		bus data  [   18]             ty  vsched   volt     angle   ar zone  vmax   vmin   date_in date_out pid L own
     		 101 "NORTH-G1"  16.00  :  0 1.00000 1.000000  -0.00000  1    1 1.0500 0.9500   400101   391231   0 0   0
		generator data  [   4]     id   long_id_    st ---no--     reg_name       prf  qrf  ar zone   pgen   pmax   pmin   qgen   qmax   qmin   mbase cmp_r cmp_x gen_r gen_x           hbus                    tbus           date_in date_out pid N
    		101 "NORTH-G1"  16.00 "h1" "        " :  1     101 "NORTH-G1"  16.00  1.00 0.50  1    1  523.44  550.0   0.0  110.8  999.0 -999.0  750.00 0.000 0.872 0.000 0.200  -1      "       " 0.0   -1      "       " 0.0    400101   391231   0 0 /
 		0.0000 0.0000 0.0000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000
		*/
		busRec = XBeanParserHelper.findBusRecord("Bus101", baseCaseNet);
		//System.out.println(busRec);
		assertTrue(busRec.getBaseVoltage().getValue() == 16.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.SWING);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getDesiredVoltage().getValue() == 1.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getDesiredAngle().getValue() == 0.0);
		assertTrue(busRec.getLoadflowData().getLoadData() == null);
		assertTrue(busRec.getLoadflowData().getShuntY() == null);

		busRec = XBeanParserHelper.findBusRecord("Bus231", baseCaseNet);
		//System.out.println(busRec);
		assertTrue(busRec.getBaseVoltage().getValue() == 16.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getCode() == LFGenCodeEnumType.PV);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getDesiredVoltage().getValue() == 1.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getQLimit().getMax() == 250.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getQLimit().getMin() == -250.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getPLimit().getMax() == 600.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getPLimit().getMin() == 0.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getVoltageLimit().getMax() == 1.05);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getVoltageLimit().getMin() == 0.95);
		assertTrue(busRec.getLoadflowData().getLoadData() == null);
		assertTrue(busRec.getLoadflowData().getShuntY() == null);
		
		// Check Branch Data
		// =================
		
		/*
		branch data  [   18]                                 ck  se  long_id_    st resist   react   charge   rate1  rate2  rate3  rate4 aloss  lngth 
      		  1 "NORTH-01" 230.00       2 "NORTH-02" 230.00 "1 "  1 "        " :  1 0.01000 0.05000  0.00000  600.0    0.0    0.0    0.0 0.000    1.0 /
 	 	 1    1 0.0000 0.000 0.000   400101   391231   0 0  0    0.0    0.0    0.0    0.0   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000
		 */
		BranchRecordXmlType braRec = XBeanParserHelper.findBranchRecord("Bus1", "Bus2", "1_", baseCaseNet);
		LoadflowBranchDataXmlType branchData = XBeanParserHelper.getDefaultBranchData(braRec);
		
		assertTrue(branchData.getCode() == LFBranchCodeEnumType.LINE); 
		assertTrue(!branchData.getOffLine()); 
		assertTrue(branchData.getZ().getRe() == 0.01); 
		assertTrue(branchData.getZ().getIm() == 0.05); 
		assertTrue(branchData.getZ().getUnit() == ZUnitType.PU); 
		assertTrue(branchData.getBranchRatingLimit().getMva().getRating1() == 600.0); 

		braRec = XBeanParserHelper.findBranchRecord("Bus1", "Bus101", "1_", baseCaseNet);
		branchData = XBeanParserHelper.getDefaultBranchData(braRec);
		
		assertTrue(branchData.getCode() == LFBranchCodeEnumType.TRANSFORMER); 
		assertTrue(!branchData.getOffLine()); 
		assertTrue(branchData.getZ().getRe() == 0.0); 
		assertTrue(branchData.getZ().getIm() == 0.1); 
		assertTrue(branchData.getFromTurnRatio().getValue() == 1.0); 
		assertTrue(branchData.getToTurnRatio().getValue() == 1.0); 
	
		assertTrue(branchData.getXfrInfo().getRatedVoltage1().getValue() == 230.0); 
		assertTrue(branchData.getXfrInfo().getRatedVoltage2().getValue() == 16.0); 
		assertTrue(branchData.getXfrInfo().getRatedPower12().getValue() == 600.0); 
	}
}


