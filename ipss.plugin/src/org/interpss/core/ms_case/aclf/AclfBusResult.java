 /*
  * @(#)AclfBusResult.java   
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
  * @Date 09/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.core.ms_case.aclf;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.ComplexFunc;
import com.interpss.common.util.Number2String;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.ms_case.impl.BusResultImpl;

public class AclfBusResult extends BusResultImpl {
	public Complex load, gen, voltage;
	
	public AclfBusResult(AclfBus bus) {
		this.setBus(bus);
	}

	public String toString() {
		return "busid, voltage, gen, load: " + this.getBus().getId() + ", " + 
					Number2String.toStr(voltage.abs()) + ", " +
			 		ComplexFunc.toString(gen) + ", "  + ComplexFunc.toString(load);
	}
}
