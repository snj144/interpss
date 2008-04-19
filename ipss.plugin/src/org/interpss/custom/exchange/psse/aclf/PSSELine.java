 /*
  * @(#)PSSELine.java   
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

package org.interpss.custom.exchange.psse.aclf;

import java.util.ArrayList;
import java.util.List;

import org.interpss.custom.exchange.psse.datarec.OwnerRec;

import com.interpss.core.aclf.impl.AclfBranchExtImpl;

public class PSSELine extends AclfBranchExtImpl {
	private static class BusRec {
		public String budId;
		public String busName;
		public BusRec(String id, String name) {
			this.budId = id; this.busName = name;
		}
	}

	public class MultiSecLineGroup {
		
		private List<BusRec> busList = new ArrayList<BusRec>();
		
		public MultiSecLineGroup() {
		}
		
		public void addBusRec(BusRec rec) {
			this.busList.add(rec);
		}
	}	
	
	private double length = 0.0;
	private OwnerRec[]  ownerList = new OwnerRec[4];
	private MultiSecLineGroup mSecLineGroup = new MultiSecLineGroup();
	
	public PSSELine(String cirId) {
      	setCircuitNumber(cirId);
	}
	
	public OwnerRec getOwnerRec(int i) {
		if (ownerList[i] == null)
			ownerList[i] = new OwnerRec();
		return ownerList[i];
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}
	
	public MultiSecLineGroup getMSecLineGroup() {
		return this.mSecLineGroup;
	}
	
	public void addDummyBus(String id, String name) {
		BusRec rec = new BusRec(id, name);
		this.mSecLineGroup.addBusRec(rec);
	}

	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		result.append("MultiSecLineGroup: " + mSecLineGroup);
		return result.toString();
	}
}
