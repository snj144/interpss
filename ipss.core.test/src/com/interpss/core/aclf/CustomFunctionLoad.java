 /*
  * @(#)CustomFunctionLoad.java   
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

package com.interpss.core.aclf;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.util.MemoryJavaCompiler;
import com.interpss.core.aclf.impl.BaseAclfBusImpl;

public class CustomFunctionLoad extends BaseAclfBusImpl {
	private double loadP = 1.6, loadQ = 0.8, 
			constP = 0.3, constI = 0.4, constZ = 0.3;
	
	public boolean isLoad() {
		return true; 
	}
	
	public double getLoadP() {
		double v = getParentAclfBus().getVoltageMag();
		return loadP*(constP + constI*v) ;	
	}
	
	public double getLoadQ() {
		double v = getParentAclfBus().getVoltageMag();
		return loadQ*(constP + constI*v) ;	
	}

	// put const Z part as an impedance
	public Complex getShuntY() {
		return new Complex(loadP*constZ,loadQ*constZ).conjugate();	
	}
	
	public static CustomFunctionLoad createObject() {
		String code = 
			"package com.interpss.core.aclf;" +
			"import org.apache.commons.math.complex.Complex;" +
			"import com.interpss.core.aclf.impl.BaseAclfBusImpl;" +
			"public class CustomFunctionLoad extends BaseAclfBusImpl {" +
			"	private double loadP = 1.6, loadQ = 0.8, constP = 0.3, constI = 0.4, constZ = 0.3;" +
			"	public boolean isLoad() { return true;	}" +
			"	public double getLoadP() { double v = getParentAclfBus().getVoltageMag(); return loadP*(constP + constI*v);	}" +
			"	public double getLoadQ() {double v = getParentAclfBus().getVoltageMag(); return loadQ*(constP + constI*v);}" +
			"	public Complex getShuntY() {return new Complex(loadP*constZ,loadQ*constZ).conjugate();}" +
			"}";	
		return (CustomFunctionLoad)MemoryJavaCompiler.javac( 
				"com/interpss/core/aclf/CustomFunctionLoad", code);
	}
}
