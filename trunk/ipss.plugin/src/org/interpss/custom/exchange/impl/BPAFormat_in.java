/*
 * Created on 2006-4-8
 * 
 */
package org.interpss.custom.exchange.impl;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;

public class BPAFormat_in {
    public static AclfNetwork loadFile(java.io.BufferedReader din, String filename, IPSSMsgHub msg) throws Exception {
    	AclfNetwork  adjNet = CoreObjectFactory.createAclfAdjNetwork();
    	adjNet.setAllowParallelBranch(false);

		// TODO ...    	return adjNet;
    	return adjNet;
    }
}
