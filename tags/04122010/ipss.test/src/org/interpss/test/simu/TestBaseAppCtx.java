 /*
  * @(#)TestBaseAppCtx.java   
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

package org.interpss.test.simu;

import org.interpss.test.TestConstants;

import junit.framework.TestCase;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Complex3x1;
import org.interpss.editor.EditorSpringAppContext;

public class TestBaseAppCtx extends TestCase {
	public TestBaseAppCtx() {
		if (SpringAppContext.SpringAppCtx == null) {
			SpringAppContext.SpringAppCtxConfigXmlFile = TestConstants.SpringConfigXmlFile;
			EditorSpringAppContext.springAppContextSetup();
		}
	}
	

	public static boolean compare(Complex3x1 iPU_012,
			double zeroRe, double zeroIm,
			double oneRe,  double oneIm,
			double twoRe,  double twoIm) {
		boolean b = true;

		if (Math.abs(iPU_012.a_0.getReal()-zeroRe) > 0.001) b = false;
		if (Math.abs(iPU_012.a_0.getImaginary()-zeroIm) > 0.001) b = false;
		if (Math.abs(iPU_012.b_1.getReal()-oneRe) > 0.001)  b = false;
		if (Math.abs(iPU_012.b_1.getImaginary()-oneIm) > 0.001)  b = false;
		if (Math.abs(iPU_012.c_2.getReal()-twoRe) > 0.001)  b = false;
		if (Math.abs(iPU_012.c_2.getImaginary()-twoIm) > 0.001)  b = false;

		if (!b) {
			System.out.println("SC current: " + iPU_012.toString());
		}

		return b;
	}	
}
