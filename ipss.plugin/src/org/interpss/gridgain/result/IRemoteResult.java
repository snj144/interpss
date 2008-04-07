 /*
  * @(#)IRemoteResult.java   
  *
  * Copyright (C) 2008 www.interpss.org
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
  * @Date 03/15/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.gridgain.result;

import org.gridgain.grid.GridTaskSession;
import org.interpss.gridgain.util.RemoteMessageTable;

import com.interpss.core.aclf.AclfNetwork;
import com.interpss.simu.multicase.MultiStudyCase;

public interface IRemoteResult {
	/**
	 * Save remote simulation results into the result table
	 * 
	 * @param resultTable
	 * @param net
	 */
	public void saveAclfResult(RemoteMessageTable resultTable, String caseId, String remoteId, AclfNetwork net, GridTaskSession session);
	
	/**
	 * Transfer the results save to the resultTable to the multi study case container
	 * 
	 * @param mCaseContainer
	 * @param resultTable
	 */
	public void transferAclfResult(MultiStudyCase mCaseContainer, RemoteMessageTable resultTable);
	
	/**
	 * Convert the contect of the multicase container to a String for display purpose. 
	 * 
	 * @param mCaseContainer
	 * @return
	 */
	public StringBuffer toString(MultiStudyCase mCaseContainer);	
}
