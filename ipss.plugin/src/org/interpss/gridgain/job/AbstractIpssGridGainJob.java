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

package org.interpss.gridgain.job;

/**
 * An abstract Grid job class, which should be extended by all GridJob implementation  
 */

import java.io.Serializable;
import java.util.Hashtable;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJobAdapter;
import org.gridgain.grid.GridTaskSession;
import org.gridgain.grid.resources.GridInstanceResource;
import org.gridgain.grid.resources.GridTaskSessionResource;
import org.interpss.gridgain.util.IPSSGridMsgHubImpl;

import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.TextMessage;
import com.interpss.simu.SimuObjectFactory;

public abstract class AbstractIpssGridGainJob extends GridJobAdapter<String> {
	private static final long serialVersionUID = 1;

	/** Grid task session will be injected. */
	@GridTaskSessionResource
	private GridTaskSession session = null;

	@GridInstanceResource
	private Grid grid = null;

	private static IPSSMsgHub msgHub = null;

	private Hashtable<String, Serializable> resultTable = null;
	
	/**
	 * Constructor
	 * 
	 * @param modelStr the string object sent to this job node 
	 */
	public AbstractIpssGridGainJob(String modelStr) {
		super(modelStr);
		this.resultTable = new Hashtable<String, Serializable>();
	}

	/**
	 * get the message object for sending msg to the msater node
	 * 
	 * @return
	 */
	protected IPSSMsgHub getMsgHub() {
		if (msgHub == null) {
			String masterNodeId = (String) session
					.getAttribute(Constants.GridToken_MasterNodeId);
			boolean debug = ((Boolean) session
					.getAttribute(Constants.GridToken_RemoteNodeDebug))
					.booleanValue();
			if (debug)
				msgHub = new IPSSGridMsgHubImpl(grid, masterNodeId,
						TextMessage.TYPE_DEBUG);
			else
				msgHub = new IPSSGridMsgHubImpl(grid, masterNodeId,
						TextMessage.TYPE_INFO);
		}
		return msgHub;
	}

	protected GridTaskSession getSession() {
		return session;
	}

	protected Grid getGrid() {
		return grid;
	}

	protected void initEMFPackage() {
		SimuObjectFactory.initEMFPackage();
	}

	@Override
	public Serializable execute() throws GridException {
		// init EMF env for EMF object serialization/deserialization
		initEMFPackage();
		// call the method to perform the actual computation
		return performGridJob(getArgument());
	}

	/**
	 * The implemented by the concrete class to perform the actual computation at the remote node
	 * 
	 * @param modelStr model object string
	 * @return string object returning back to the master node
	 */
	protected abstract Serializable performGridJob(String modelStr);
	
	protected Hashtable<String, Serializable> getResultTable() {
		return resultTable;
	}
}
