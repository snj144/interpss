package org.interpss.custom.exchange.psse;

import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfNetwork;

public class PSSEMultiTermDCLineDataRec {
	public PSSEMultiTermDCLineDataRec(String lineStr, VersionNo version) {
	}
	
	public void processMultiTerminalDCLine(
			AclfNetwork adjNet, 
			IPSSMsgHub msg) throws Exception {
		msg.sendWarnMsg("Voltage Source Converter DC Line record has not been implemented");	
	}	
}
