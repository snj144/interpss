 /*
  * @(#)CommonFuncTest.java   
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
  * @Date 07/15/2007
  * 
  *   Revision History
  *   ================
  *
  */
package com.interpss.simu;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

import com.interpss.BaseTestSetup;
import com.interpss.common.SpringAppContext;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.util.sample.SampleCases;


public class SerializeEMFObjectTest extends BaseTestSetup {
	@Test
	public void sampleTest() {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		assertTrue(SerializeEMFObjectUtil.saveModel(net, outStream));
		//System.out.println("Byte Array Length: " + outStream.toByteArray().length);
		//System.out.println(outStream);
		
		net = (AclfNetwork)SerializeEMFObjectUtil.loadModel(outStream.toString());
		//System.out.println(net.net2String());

		assertTrue(net.getBusList().size() == 5);
		assertTrue(net.getBranchList().size() == 5);
	}
}
