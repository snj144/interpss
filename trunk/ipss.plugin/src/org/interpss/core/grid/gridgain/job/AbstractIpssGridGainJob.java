 /*
  * @(#)AbstractIpssGridGainJob.java   
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

package org.interpss.core.grid.gridgain.job;

/**
 * An abstract Grid job class, which should be extended by all GridJob implementation  
 */

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridJobAdapter;
import org.gridgain.grid.GridTaskSession;
import org.gridgain.grid.resources.GridInstanceResource;
import org.gridgain.grid.resources.GridTaskSessionResource;
import org.interpss.core.grid.gridgain.task.IpssGridGainTask;
import org.interpss.core.grid.gridgain.util.IPSSGridMsgHubImpl;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.TextMessage;
import com.interpss.core.CorePackage;
import com.interpss.core.ms_case.MStudyCasePackage;
import com.interpss.dstab.DstabPackage;

public abstract class AbstractIpssGridGainJob extends GridJobAdapter<String> {
	private static final long serialVersionUID = 1;
	
    /** Grid task session will be injected. */
    @GridTaskSessionResource
    private GridTaskSession session = null;
    
    @GridInstanceResource
    private Grid grid = null;
    
    private static IPSSMsgHub msgHub = null;
    private static CorePackage corePackage = null;
    private static MStudyCasePackage msCasePackage = null;
    private static DstabPackage dstabPackage = null;
    
	public AbstractIpssGridGainJob(String arg) {
		super(arg);
	}

	public IPSSMsgHub getMsgHub() {
		if (msgHub == null) {
			String masterNodeId = (String)session.getAttribute(IpssGridGainTask.Token_MasterNodeId);
			msgHub = new IPSSGridMsgHubImpl(grid, masterNodeId, TextMessage.TYPE_INFO);
		}
		return msgHub;
	}
	
    public GridTaskSession getSession() {
    	return session;
    }

    public Grid getGrid() {
    	return grid;
    }
    
    public void initEMFPackage() {
    	if (corePackage == null)
    		corePackage = CorePackage.eINSTANCE;
    	if (msCasePackage == null)
    		msCasePackage = MStudyCasePackage.eINSTANCE;
    	if (dstabPackage == null)
    		dstabPackage = DstabPackage.eINSTANCE;
	}
}
