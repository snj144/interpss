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

package org.interpss.core.grid.gridgain;

import java.util.Hashtable;

import org.eclipse.emf.ecore.EObject;
import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridFactory;

import com.interpss.common.ui.SerializeEMFObjectUtil;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.ms_case.GridMultiStudyCase;
import com.interpss.core.ms_case.result.GridAclfNetResult;

public class IpssGridGainUtil {
	private static Hashtable<String,String> nodeNameLookupTable = new Hashtable<String,String>();
	
	/**
	 * Perform grid computing on the model object.
	 * 
	 * @param desc a description string
	 * @param model an EMF model object
	 * @return a list of result objects
	 * @throws GridException
	 */
    public static Object[] performGridTask(String desc, EObject model) throws GridException {
        GridFactory.start();
        Object[] objList = null;
        try {
            Grid grid = GridFactory.getGrid();
            IpssLogger.getLogger().info("Begin to excute IpssGridTask " + desc + " ...");
           	if (model instanceof GridMultiStudyCase)
           		// IpssGridGainTask is designed to process the GridMultiStudyCase model
           		objList = (Object[])grid.execute(IpssGridGainTask.class.getName(), model).get();
            IpssLogger.getLogger().info("End to excute IpssGridTask " + desc );
        }
        finally {
            GridFactory.stop(true);
        }
        return objList;
    }
    
    /**
     * From Grid node UDDI string to Logical node name lookup
     * 
     * @param uid
     * @return
     */
    public static String nodeNameLookup(String uid) {
    	String name = nodeNameLookupTable.get(uid); 
    	if (name == null) {
    		int cnt = nodeNameLookupTable.size();
    		name = "Logical Node - " + (cnt+1);
    		nodeNameLookupTable.put(uid, name);
    	}
    	return name;
    }
    
	public static String serializeAclfResult(String uid, AclfNetwork net) {
		GridAclfNetResult rnet = CoreObjectFactory.createGridAclfNetResult(uid);
		rnet.setLfConverged(net.isLfConverged());
		rnet.setCaseNumber(net.getSortNumber());
		return SerializeEMFObjectUtil.saveModel(rnet);
	}    
}
