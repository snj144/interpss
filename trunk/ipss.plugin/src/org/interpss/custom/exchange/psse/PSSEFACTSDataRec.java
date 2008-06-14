package org.interpss.custom.exchange.psse;

import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclfadj.AclfAdjNetwork;

public class PSSEFACTSDataRec {
	public PSSEFACTSDataRec(String lineStr, VersionNo version) {
	}
	
	public void processFACTS(
			AclfAdjNetwork adjNet, 
			IPSSMsgHub msg) throws Exception {
		msg.sendWarnMsg("FACTS data record has not been implemented");	
	}	
}
