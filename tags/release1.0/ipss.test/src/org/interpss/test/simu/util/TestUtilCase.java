 /*
  * @(#)TestUtilCase.java   
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

package org.interpss.test.simu.util;

import org.interpss.editor.data.aclf.AclfBusData;
import org.interpss.test.simu.TestBaseAppCtx;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.IpssEvent;
import com.interpss.common.util.XmlUtil;

public class TestUtilCase extends TestBaseAppCtx {
	public void testXmlUtilCase1() {
		XmlUtil.ToolKid = XmlUtil.TOOL_CASTOR;
		
		AclfBusData data = new AclfBusData();
		data.setShuntB(1.0);
		data.setShuntG(2.0);
		
		String str = XmlUtil.toXmlString(data);
		System.out.println(str);
		
		data = (AclfBusData)XmlUtil.toObject(str, AclfBusData.class);
		assertTrue(data.getShuntB() == 1.0);
		assertTrue(data.getShuntG() == 2.0);
	}

	public void testStdoutEventListenerCase() {
		
		IpssEvent event = new IpssEvent(new String("test event"));
		SpringAppContext.SpringAppCtx.publishEvent(event);
	}
}
