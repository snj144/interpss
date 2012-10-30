/*
  * @(#)TopologyProcesor.java   
  *
  * Copyright (C) 2006-2012 www.interpss.org
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
  * @Date 10/30/2012
  * 
  *   Revision History
  *   ================
  *
  */
package org.interpss.algo;

import java.util.ArrayList;
import java.util.List;

import com.interpss.common.exp.InterpssException;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;

/**
 * 
 * @author mzhou
 *
 */
public class TopologyProcesor {
	AclfNetwork aclfNet = null;
	
	public TopologyProcesor(AclfNetwork net) {
		this.aclfNet = net;
	}
	
	/**
	 * Starting from the Breaker branch identified by branchId, find all breakers in 
	 * the substation, plus the connecting Line/Xfr/PsXfr
	 * 
	 * @param branchId
	 * @return
	 * @exception
	 */
	public List<String> findBranchInSubStation(String branchId) throws InterpssException {
		List<String> branchIdList = new ArrayList<String>();
		
		AclfBranch branch = this.aclfNet.getAclfBranch(branchId);
		
		if (branch.getBranchCode() != AclfBranchCode.BREAKER)
			throw new InterpssException("The starting branch to findBranchInSubstation should be Breaker, "
					+ branchId + "[" + branch.getBranchCode() + "]");
		
		if (!branch.isActive())
			throw new InterpssException("The starting branch to findBranchInSubstation() is inactive, "
					+ branchId + "[" + branch.getBranchCode() + "]");

		// first the branchId is added to the list
		branchIdList.add(branchId);
	
		// recursively search the from bus side
		searchBranchInSubstation(branch, branch.getFromAclfBus(), branchIdList);
		
		// recursively search the to bus side
		searchBranchInSubstation(branch, branch.getToAclfBus(), branchIdList);
		
		return branchIdList;
	}
	
	private void searchBranchInSubstation(AclfBranch refBranch, Bus refBus, List<String> branchIdList) {
		for (Branch branch : refBus.getBranchList()) {
			if (!branch.getId().equals(refBranch.getId()) &&
					branch.isActive() &&
					!branch.isGroundBranch()) {
				branchIdList.add(branch.getId());
				AclfBranch aclfBra = (AclfBranch)branch;
				if (aclfBra.getBranchCode() == AclfBranchCode.BREAKER)
					searchBranchInSubstation(aclfBra, aclfBra.getOppositeBus(refBus), branchIdList);
			}
		}
	}
}
