 /*
  * @(#)AbstractAclfStudyCaseRunner.java   
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

import com.interpss.core.aclf.AclfBus;

public class AclfStudyCaseUtilFunc {
	public static void increaseBusLoadConstPF(AclfBusResult busResult, double dP) {
		AclfBus bus = (AclfBus)busResult.getBus();
		double dQ = busResult.load.getReal() == 0.0 ? 0.0 : dP * busResult.load.getImaginary() / busResult.load.getReal(); 
		bus.setLoadP(busResult.load.getReal() + dP);
		bus.setLoadQ(busResult.load.getImaginary() + dQ);		
	}
	
	public static void increaseBusLoad(AclfBusResult busResult, double pFactor, double qFactor) {
		AclfBus bus = (AclfBus)busResult.getBus();
		bus.setLoadP(busResult.load.getReal()*pFactor);
		bus.setLoadQ(busResult.load.getImaginary()*qFactor);		
	}

	public static void increaseBusGenConstPF(AclfBusResult busResult, double dP) {
		AclfBus bus = (AclfBus)busResult.getBus();
		dP = dP * 0.5;
		if (bus.isGenPV()) {
			bus.setGenP(busResult.gen.getReal() + dP);
		}
		else if (bus.isGenPQ()) {
			bus.setGenP(busResult.gen.getReal() + dP);
			double dQ = busResult.gen.getReal() == 0.0 ? 0.0 : dP * busResult.gen.getImaginary() / busResult.gen.getReal(); 
			bus.setGenQ(busResult.gen.getImaginary() + dQ);
		}		
	}
}
