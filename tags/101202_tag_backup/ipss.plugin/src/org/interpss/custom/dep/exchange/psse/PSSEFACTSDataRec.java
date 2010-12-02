package org.interpss.custom.dep.exchange.psse;

import org.interpss.custom.dep.exchange.psse.PSSEDataRec.VersionNo;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfNetwork;

public class PSSEFACTSDataRec {
	public PSSEFACTSDataRec(String lineStr, VersionNo version) {
	}
	
	public void processFACTS(
			AclfNetwork adjNet, 
			IPSSMsgHub msg) throws Exception {
		msg.sendWarnMsg("FACTS data record has not been implemented");	
	}	
}
