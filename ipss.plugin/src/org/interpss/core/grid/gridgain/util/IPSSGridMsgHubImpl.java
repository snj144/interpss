 /*
  * @(#)IPSSGridMsgHubImpl.java   
  *
  * Copyright (C) 2007 www.interpss.org
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
  * @Date 10/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.core.grid.gridgain.util;

import java.util.EventListener;
import java.util.List;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridNode;

import com.interpss.common.exp.InterpssRuntimeException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IpssMessage;
import com.interpss.common.msg.SimuMessage;
import com.interpss.common.msg.TextMessage;
import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.datatype.DStabSimuAction;

/**
 * Grid InterPSS message hub implementation. Grid messages are sent to the master node for 
 * processing. 
 * 
 */
public class IPSSGridMsgHubImpl implements IPSSMsgHub {
	public static final String Token_RemoteMsg = "[RemoteMessage]";
	public static final String Token_DStabSimuMsg = Token_RemoteMsg+"DStabSimuAction:";
	public static final String Token_ProgressStatusMsg = Token_RemoteMsg+"ProgressStatus:";

	public static final String Token_ErrorMsg = Token_RemoteMsg+"ErrorMessage:";
	public static final String Token_WarnMsg = Token_RemoteMsg+"WarnMessage:";
	public static final String Token_StatusMsg = Token_RemoteMsg+"StatusMessage:";
	public static final String Token_InfoMsg = Token_RemoteMsg+"InfoMessage:";
	public static final String Token_DebugMsg = Token_RemoteMsg+"DebugMessage:";
	
	private Grid grid = null;
	private GridNode masterNode = null;
	
	private byte level = TextMessage.TYPE_INFO;
	
	/**
	 * Constructor
	 * 
	 * @param grid Gridgain grid object
	 * @param masterNodeId the master node id
	 * @param level logger level
	 */
	public IPSSGridMsgHubImpl(Grid grid, String masterNodeId, byte level) {
		this.grid = grid;
		for (GridNode node : grid.getAllNodes()) {
	    	if (node.getId().toString().equals(masterNodeId))
	    		this.masterNode = node;
		}
    	this.level = level;
	}
	
	/**
	 * Re-send remote IPSSMessage to the master node
	 */
	@Override
	public void sendMsg(IpssMessage msg) {
		if (msg instanceof DStabSimuAction) {
			DStabSimuAction simuMsg = (DStabSimuAction)msg;
			sendMessage(Token_DStabSimuMsg  + simuMsg.getType() + "|" + simuMsg.getHashtableData().toString());
		}
		else if (msg instanceof SimuMessage) {
			SimuMessage simuMsg = (SimuMessage)msg;
			if (simuMsg.getType() == SimuMessage.TYPE_PROGRESS_STATUS)
				sendMessage(Token_ProgressStatusMsg + simuMsg.getIntData());
			else
				IpssLogger.getLogger().info(msg.toString());
		}
		else {
			//sendMessage("IpssMessage",  msg.toString());
			IpssLogger.getLogger().info(msg.toString());
		}
	}

	@Override
	public void sendDebugMsg(String msg) {
		if (this.level <= TextMessage.TYPE_DEBUG) {
			sendMessage(Token_DebugMsg,  msg);
			System.out.println(msg);
		}
	}

	@Override
	public void sendErrorMsg(String msg) {
		if (this.level <= TextMessage.TYPE_ERROR) {
			sendMessage(Token_ErrorMsg,  msg);
			System.out.println(msg);
		}
	}

	@Override
	public void sendInfoMsg(String msg) {
		if (this.level <= TextMessage.TYPE_INFO) {
			sendMessage(Token_InfoMsg,  msg);
			System.out.println(msg);
		}
	}


	@Override
	public void sendStatusMsg(String msg) {
		if (this.level <= TextMessage.TYPE_STATUS) {
			sendMessage(Token_StatusMsg,  msg);
			System.out.println(msg);
		}
	}

	@Override
	public void sendWarnMsg(String msg) {
		if (this.level <= TextMessage.TYPE_WARN) {
			sendMessage(Token_WarnMsg,  msg);
			System.out.println(msg);
		}
	}

	@Override
	public void setMsgListeners(List<EventListener> list) {
		throw new InterpssRuntimeException("IPSSGridMsgHubImpl.setMsgListeners() not implemented");
	}

	@Override
	public void addMsgListener(EventListener listener) {
		throw new InterpssRuntimeException("IPSSGridMsgHubImpl.addMsgListener() not implemented");
	}

	@Override
	public void removeMsgListener(EventListener listener) {
		throw new InterpssRuntimeException("IPSSGridMsgHubImpl.removeMsgListener() not implemented");
	}

	private void sendMessage(String type, String msg) {
   		sendMessage(type + msg);
	}

	private void sendMessage(String msg) {
    	try {
    		this.grid.sendMessage(masterNode, msg);
    		//System.out.println(msg);
    	} catch (GridException e) {
    		e.printStackTrace();
    	}
	}
}
