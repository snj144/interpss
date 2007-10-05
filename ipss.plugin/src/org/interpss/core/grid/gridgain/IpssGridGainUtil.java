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
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;
import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridFactory;
import org.gridgain.grid.GridNode;
import org.interpss.core.grid.gridgain.aclf.IpssAclfNetGridGainTask;
import org.interpss.core.ms_case.IpssMultiStudyCaseGridGainTask;
import org.interpss.core.ms_case.aclf.AclfStudyCaseUtilFunc;

import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.ms_case.GridMultiStudyCase;
import com.interpss.core.ms_case.result.AclfNetworkResult;

/*
 *    - Each study case has a unique caseNumber 
 *      When a EMF model, a Network object, is sent to a remote location, by creating a
 *          GridGainJob extends AbstractIpssGridGainJob, net.sortNumber = caseNumber
 *    - The result NetworkResult.caseNumber = net.sortNumber before returning to the Master node
 *    - Result net is set back to the StudyCase using caseNumber correlation.     
 */

public class IpssGridGainUtil {
	public static final String LocalGridNodeName = "Master Grid Noce";
	private static Hashtable<String,String> nodeNameLookupTable = new Hashtable<String,String>();
	
	/**
	 * Perform grid computing on the model object.
	 * 
	 * @param desc a description string
	 * @param model an EMF model object
	 * @return result object or a list of result objects, 
	 * @throws GridException
	 */
    public static Object performGridTask(String desc, EObject model) throws GridException {
        GridFactory.start();
        Object result = null;
        //try {
        Grid grid = GridFactory.getGrid();
            
        IpssLogger.getLogger().info("Begin to excute IpssGridTask " + desc + " ...");
        IpssLogger.getLogger().info("Number of Grid Nodes: " + grid.getAllNodes().size());
        if (model instanceof GridMultiStudyCase)
           	// IpssMultiStudyCaseGridGainTask is designed to process the GridMultiStudyCase model
          	// return a list of results object, for example AclfNetworkResult objects in serialized 
           	// fromat (String) in no particular order
           	result = grid.execute(IpssMultiStudyCaseGridGainTask.class.getName(), model).get();
        else if (model instanceof AclfNetwork || model instanceof AclfAdjNetwork)
        	// IpssAclfNetGridGainTask is designed to process the AclfAdjNetwork model
          	// return an AclfAdjNetork object in 
        	result = grid.execute(IpssAclfNetGridGainTask.class.getName(), model).get();
        IpssLogger.getLogger().info("End to excute IpssGridTask " + desc );
        //}
        //finally {
        GridFactory.stop(true);
        //}
        return result;
    }
    
    /**
     * From Grid node name to node UDDI string lookup
     * 
     * @param name
     * @return
     */
    public static String nodeIdLookup(String name) {
    	for (String id : nodeNameLookupTable.keySet()) {
    		if (nodeNameLookupTable.get(id).equals(name))
    			return id;
    	}
    	return null;
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
    		name = "Logical Node-" + (cnt+1);
    		nodeNameLookupTable.put(uid, name);
    	}
    	return name;
    }
    
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
     * Check if the GridGain could be started. 
     * 
     * @return
     */
    private static boolean gridLibLoaded = false;
    
    public static boolean isGridLibLoaded() throws NoClassDefFoundError {
        if (!gridLibLoaded) {
        	try {
            	GridFactory.start();
                GridFactory.getGrid();
                GridFactory.stop(true);
                gridLibLoaded = true;
            } catch (GridException e2) {
            	IpssLogger.logErr(e2);
            	return false;
            }
        }
    	return true;
    }
    
    /**
     * Get all grid node name
     * 
     * @return
     */
    public static String[] gridNodeNameList() {
        try {
        	GridFactory.start();
            String[] nameList = null;
            try {
                Grid grid = GridFactory.getGrid();
                String localId = grid.getLocalNode().getId().toString();
                Vector<String> vct = new Vector<String>();
            	vct.add(LocalGridNodeName);
                for (GridNode node : grid.getAllNodes()) {
                    if (!localId.equals(node.getId().toString())) {
                    	String name = nodeNameLookup(node.getId().toString());
                    	vct.add(name);
                    }
                }
                nameList = new String[vct.size()];
                int cnt = 0;
                for (String s : vct) {
                	nameList[cnt++] = s;
                }
            }
            finally {
                GridFactory.stop(true);
            }
            return nameList;
        } catch (GridException e) {
        	return null;
        }
    }
}
