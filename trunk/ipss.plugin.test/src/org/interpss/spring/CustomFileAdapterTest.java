 /*
  * @(#)TestCustomFileAdapter.java   
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

package org.interpss.spring;

import static org.junit.Assert.*;

import java.util.List;

import org.interpss.BaseTestSetup;
import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.junit.Test;

public class CustomFileAdapterTest extends BaseTestSetup {
	@Test
	public void testcustomFileAdapterList() {
		List list = SimuAppSpringAppContext.getCustomFileAdapterList();
		assertTrue(list.size() >= 5);
		assertTrue(SimuAppSpringAppCtxUtil.getCustomFileAdapter("m") != null);
		assertTrue(SimuAppSpringAppCtxUtil.getCustomFileAdapter("ieee") != null);
	}
}
