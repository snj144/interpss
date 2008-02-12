 /*
  * @(#)UCTENetwork.java   
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
  * @Date 02/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.custom.exchange.ucte;

import java.util.ArrayList;
import java.util.List;

import com.interpss.core.aclfadj.impl.AclfAdjNetworkImpl;

public class UCTENetwork extends AclfAdjNetworkImpl {
	public static class ExchangePower {
		String fromIsoId, toIsoId;
		double exPower;
		String comment;
		
		public ExchangePower(String fromIsoId, String toIsoId, double exPower, String comment) {
			this.fromIsoId = fromIsoId;
			this.toIsoId = toIsoId;
			this.exPower = exPower;
			this.comment = comment;
		}
	}
	
	private List<ExchangePower> exPowerList = new ArrayList<ExchangePower>(); 

	public UCTENetwork(String id, String name) {
		super.setId(id);
		super.setName(name);
	}

	public void addExchangePower(ExchangePower exPower) {
		exPowerList.add(exPower);
	}
	
	public List<ExchangePower> getExchangePowerList() {
		return this.exPowerList;
	}
}
