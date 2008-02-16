 /*
  * @(#)IEEECommonFormatTest.java   
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

package org.ieee.pes.odm.pss.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.ieee.pes.odm.pss.adapter.ieeecdf.IeeeCDFAdapter;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;
import org.junit.Test;


public class IEEECommonFormatTest {
	@Test
	public void testCase1() throws Exception {
		final LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		
		final File file = new File("testdata/ieeecdf/Ieee14Bus.ieee");
		final InputStream stream = new FileInputStream(file);
		final BufferedReader din = new BufferedReader(new InputStreamReader(stream));
		IEEEODMPSSModelParser parser = IeeeCDFAdapter.parseInputFile(din, logger);
		
		System.out.println(parser.toString());
	}
}

