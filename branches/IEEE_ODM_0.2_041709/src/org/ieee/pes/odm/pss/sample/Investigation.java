 /*
  * @(#)CreateSimpleNetwork.java   
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
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 02/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.pes.odm.pss.sample;

import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.ieee.pes.odm.pss.adapter.IODMPSSAdapter;
import org.ieee.pes.odm.pss.adapter.ieeecdf.IeeeCDFAdapter;

public class Investigation {
	public static void main(String[] args) {
		final LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		
		IODMPSSAdapter adapter = new IeeeCDFAdapter(logger);
		assertTrue(adapter.parseXmlFile("testdata/ieeecdf/UCTE_2002_Summer.CF"));
		assertTrue(adapter.parseXmlFile("testdata/ieeecdf/UCTE_2002_Winter_Offpeak.CF"));
		assertTrue(adapter.parseXmlFile("testdata/ieeecdf/UCTE_2002_Winter_peak.CF"));
	}
}
