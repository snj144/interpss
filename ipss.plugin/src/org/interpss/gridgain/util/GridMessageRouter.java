/*
 * @(#)GridMessageRouter.java   
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

package org.interpss.gridgain.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import org.gridgain.grid.GridMessageListener;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.SimuMessage;
import com.interpss.common.util.StringUtil;
import com.interpss.dstab.datatype.DStabSimuAction;
import com.interpss.dstab.util.IDStabSimuDatabaseOutputHandler;
import com.interpss.dstab.util.IDStabSimuOutputHandler;

/*
 * During the simulation process, messages are sent from remote node to the
 * master node as a String starting with a msg type token. Depending on msg
 * type, the msg will be routed to appropriate msg handler to process
 * 
 */

public class GridMessageRouter implements GridMessageListener {
	/*
	 * regular msg handler
	 */
	private IPSSMsgHub msgHub = null;

	/*
	 * DStab simulation msg handler list
	 */
	private List<IDStabSimuOutputHandler> dstabOutputHandlerList = null;

	/**
	 * Default constructor
	 */
	public GridMessageRouter(IPSSMsgHub msg) {
		this.dstabOutputHandlerList = new ArrayList<IDStabSimuOutputHandler>();
		this.msgHub = msg;
	}

	/**
	 * Set DStab message handler
	 * 
	 * @param msg
	 */
	public void addDStabSimuDbOutputHandler(IDStabSimuOutputHandler handler) {
		this.dstabOutputHandlerList.add(handler);
	}

	@Override
	public void onMessage(UUID arg0, Serializable arg1) {
		String msgStr = (String) arg1;
		if (msgStr.startsWith(Constants.GridToken_DStabSimuMsg)) {
			// format: Token_DStabSimuMsg + simuMsg.getType() + "|" +
			// simuMsg.getHashtableData().toString());

			// debug: Token_DStabSimuMsg + " 1_" + simuMsg.getType() + "|" +
			// simuMsg.getHashtableData().toString());
			// System.out.println("DStab Msg Cnt: " +
			// msgStr.substring(IPSSGridMsgHubImpl.Token_DStabSimuMsg.length(),
			// msgStr.indexOf('_')));
			// String type = msgStr.substring(msgStr.indexOf('_')+1,
			// msgStr.indexOf('|'));

			String type = msgStr.substring(Constants.GridToken_DStabSimuMsg
					.length(), msgStr.indexOf('|'));
			String msg = msgStr.substring(msgStr.indexOf('|') + 1);
			Hashtable<String, String> states = StringUtil
					.parseStr2Hashtable(msg);
			/*
			 * if (states.get("BusId") != null &&
			 * states.get("BusId").equals("0001")) { System.out.println("DStab
			 * Msg : " + states.get("Time")); }
			 */
			DStabSimuAction event = new DStabSimuAction(new Byte(type)
					.byteValue(), states);
			// find dbCaseId
			String caseId = states.get(Constants.GridToken_CaseId);
			int dbCaseId = SpringAppContext.getSimuRecManager().getDBCaseId(caseId);
			// System.out.println("*******caseId, dbCaseId: " + caseId + ", " +
			// dbCaseId);

			for (IDStabSimuOutputHandler handler : dstabOutputHandlerList) {
				if (((IDStabSimuDatabaseOutputHandler) handler).getDBCaseId() == dbCaseId) {
					handler.onMsgEventStatus(event);
				}
			}
		} else if (msgStr.startsWith(Constants.GridToken_ProgressStatusMsg)) {
			String str = msgStr.substring(Constants.GridToken_ProgressStatusMsg
					.length());
			int percent = new Integer(str).intValue();
			if (this.msgHub != null)
				msgHub
						.sendMsg(new SimuMessage(
								SimuMessage.TYPE_PROGRESS_STATUS, new Integer(
										percent)));
			else
				System.out.println("percent = " + percent + "%");
		} else if (msgStr.startsWith(Constants.GridToken_ErrorMsg)) {
			if (this.msgHub != null)
				msgHub.sendErrorMsg(msgStr);
		} else if (msgStr.startsWith(Constants.GridToken_WarnMsg)) {
			if (this.msgHub != null)
				msgHub.sendWarnMsg(msgStr);
		} else if (msgStr.startsWith(Constants.GridToken_StatusMsg)) {
			if (this.msgHub != null)
				msgHub.sendStatusMsg(msgStr);
		} else if (msgStr.startsWith(Constants.GridToken_InfoMsg)) {
			if (this.msgHub != null)
				msgHub.sendInfoMsg(msgStr);
		} else if (msgStr.startsWith(Constants.GridToken_DebugMsg)) {
			if (this.msgHub != null)
				msgHub.sendDebugMsg(msgStr);
		} else
			System.out.println(arg1);
	}
}