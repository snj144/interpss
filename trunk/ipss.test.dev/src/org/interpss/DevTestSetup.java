 /*
  * @(#)BaseTestSetup.java   
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

package org.interpss;

import java.util.logging.Level;

import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.spring.CoreCommonSpringCtx;

public class DevTestSetup {
	protected static IPSSMsgHub msg;

	@BeforeClass
	public static void setSpringAppCtx() {
		if (CoreCommonSpringCtx.SpringAppCtx == null) {
			CoreCommonSpringCtx.SpringAppCtx = new ClassPathXmlApplicationContext(
					new String[] {
							"org/interpss/spring/PluginSpringCtx.xml",
							"com/interpss/spring/SimuCtxSpringCtx.xml"});
			msg = CoreCommonSpringCtx.getIpssMsgHub();
			IpssLogger.getLogger().setLevel(Level.INFO);
		}
	}
}

