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

package com.interpss.common;

import org.junit.BeforeClass;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.TestUtilFunc;

public class BaseTestSetup {
	@BeforeClass
	public static void setSpringAppCtx() {
		if (SpringAppContext.SpringAppCtx == null) {
			String xmlFile = TestUtilFunc.Common_SpringConfigXmlFile;
			// Set the SpringAppContext to all ApplicationContextAware objects.
			SpringAppContext.SpringAppCtx = new FileSystemXmlApplicationContext(xmlFile);
		}
	}
}
