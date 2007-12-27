 /*
  * @(#)DStabSimuGridOutputHandler.java   
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

package org.interpss.core.grid.gridgain.util;

import java.util.Hashtable;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IpssMessage;
import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.datatype.DStabSimuAction;
import com.interpss.dstab.util.AbstractSimuOutputHandler;
import com.interpss.dstab.util.DStabOutSymbol;

/**
 * DStab simulation result messages are re-sent to the master node
 */

public class DStabSimuGridOutputHandler extends AbstractSimuOutputHandler {
	/**
	 * IPSSGridMsgHubImpl, a message router which routes message to the master node
	 */
	private IPSSMsgHub msgHub = null;
	private String gridRunCaseId = "";
	
	public DStabSimuGridOutputHandler(IPSSMsgHub msgHub, String caseId) {
		this.msgHub = msgHub;
		this.gridRunCaseId = caseId;
	}
	
	/**
	 * DStab simulation messages are re-send to the node
	 */
	@Override
	public boolean onMsgEventStatus(IpssMessage event) {
		DStabSimuAction e = (DStabSimuAction)event;
		try {
			if (e.getType() == DStabSimuAction.PlotStepMachineStates) {
			   	Hashtable<String, Object> machStates = e.getHashtableData();
				String machId = (String)machStates.get(DStabOutSymbol.OUT_SYMBOL_MACH_ID);
				if (!this.isOutputFilter() || this.getOutputVarIdList().contains("Machine - " + machId)) {
					e.getHashtableData().put(Constants.GridToken_CaseId, gridRunCaseId);
					msgHub.sendMsg(event);
				}
		   }
		   else if (e.getType() == DStabSimuAction.PlotStepBusStates) {
			   	Hashtable<String, Object> busStates = e.getHashtableData();
				String busId = (String)busStates.get(DStabOutSymbol.OUT_SYMBOL_BUS_ID);
				if (!this.isOutputFilter()  || this.getOutputVarIdList().contains("Bus - " + busId)) {
					e.getHashtableData().put(Constants.GridToken_CaseId, gridRunCaseId);
					msgHub.sendMsg(event);
				}				
		   }
		   else if (e.getType() == DStabSimuAction.PlotStepScriptDynamicBusDeviceStates) {
			   	Hashtable<String, Object> deviceStates = e.getHashtableData();
				String deviceId = (String)deviceStates.get(DStabOutSymbol.OUT_SYMBOL_BUS_DEVICE_ID);
				if (!this.isOutputFilter()  || this.getOutputVarIdList().contains(deviceId)) {
					e.getHashtableData().put(Constants.GridToken_CaseId, gridRunCaseId);
					msgHub.sendMsg(event);
				}
		   }
		} catch (Exception ex) {
			IpssLogger.logErr(ex);
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("InterPSS DB Access Error", 
					ex.toString() + "\n Please contact InterPSS support");
			return false;
		}
	   return true;
	}
}
