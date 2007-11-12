 /*
  * @(#)IpssGridGainUtil.java   
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

import org.interpss.core.ms_case.aclf.AclfStudyCaseUtilFunc;

import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.AclfAdjustAlgorithm;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.ms_case.result.AclfNetworkResult;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;

public class IpssGridUtilFunc {
    /**
     * Transfer AclfNetwork result to an AclfNetworkResult object and serialize the result object to a String
     * 
     * @param uid grid node UUID string 
     * @param net the AclfNetwork object
     * @return serialized AclfNetworkResult string
     */
    public static String serializeGridAclfResult(String uid, AclfNetwork net) {
		AclfNetworkResult rnet = AclfStudyCaseUtilFunc.createAclfNetResult(uid, net);
		return SerializeEMFObjectUtil.saveModel(rnet);
	} 
    
    /**
     * Serialize the Aclf Algorithm object
     * 
     * @param algo
     * @return
     */
    public static String serializeAclfAlgorithm(LoadflowAlgorithm algo) {
		AclfNetwork net = algo.getAclfNetwork();
		algo.setAclfNetwork(null);
		AclfAdjustAlgorithm adjAlgo = algo.getAdjAlgorithm();
		algo.setAdjAlgorithm(null);
		String algoStr = SerializeEMFObjectUtil.saveModel(algo);
		algo.setAclfNetwork(net);
		algo.setAdjAlgorithm(adjAlgo);
		return algoStr;
    }
    
    /**
     * Serialize the DStab algorithm object
     * 
     * @param algo
     * @return
     */
    public static String serializeDStabAlgorithm(DynamicSimuAlgorithm algo) {
		DStabilityNetwork net = algo.getDStabNet();
		algo.setDStabNet(null);
		LoadflowAlgorithm lfAlgo = algo.getAclfAlgorithm();
		algo.setAclfAlgorithm(null);
		algo.setDynamicEventHandler(null);
		algo.getDEventList().clear();
		algo.setScriptOutputHandler(null);
		algo.setSimuOutputHandler(null);
		String algoStr = SerializeEMFObjectUtil.saveModel(algo);
        algo.setAclfAlgorithm(lfAlgo);
        algo.setDStabNet(net);
        return algoStr;
    }
}
