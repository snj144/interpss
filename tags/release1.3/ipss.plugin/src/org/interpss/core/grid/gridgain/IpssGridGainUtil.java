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
import org.gridgain.grid.GridFactoryState;
import org.gridgain.grid.GridNode;
import org.gridgain.grid.GridTaskTimeoutException;
import org.interpss.core.grid.gridgain.aclf.IpssAclfNetGridGainTask;
import org.interpss.core.ms_case.IpssMultiStudyCaseGridGainTask;
import org.interpss.core.ms_case.aclf.AclfStudyCaseUtilFunc;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.ms_case.GridMultiStudyCase;
import com.interpss.core.ms_case.result.AclfNetworkResult;

/**
 *   For IpssMultiStudyCaseGridGainTask implementation
 *    - Each study case has a unique caseNumber 
 *      When a EMF model, a Network object, is sent to a remote location, by creating a
 *          GridGainJob extends AbstractIpssGridGainJob, net.sortNumber = caseNumber
 *    - The result NetworkResult.caseNumber = net.sortNumber before returning to the Master node
 *    - Result net is set back to the StudyCase using caseNumber correlation.     

 *   For IpssAclfNetGridGainTask implementation
 *    - An AclfNetwork or AclfAdjNetwork is sent to a remote grid node 
 *    - Result is the same net with Loadflow calculation results     
 */

public class IpssGridGainUtil {
	private static final String Token_MasterNode = "Master Grid Node";
	private static final String Token_RemoteNode = "Logical Node";

	// hold node name to node id lookup info
	private static Hashtable<String,String> nodeNameLookupTable = new Hashtable<String,String>();

	private static Grid defaultGrid = null;
   	private static boolean gridEnabled = false;

	/**
	 * Perform grid computing on the model object.
	 * 
	 * @param desc a description string
	 * @param model an EMF model object
	 * @return result object or a list of result objects, 
	 * @throws GridException
	 */
    public static Object performGridTask(Grid grid, String desc, EObject model, long timeout) throws GridException {
        Object result = null;
       	IpssLogger.getLogger().info("Begin to excute IpssGridTask " + desc + " ...");
       	IpssLogger.getLogger().info("Number of Grid Nodes: " + grid.getAllNodes().size());
       	try {
       		if (model instanceof GridMultiStudyCase)
           		// IpssMultiStudyCaseGridGainTask is designed to process the GridMultiStudyCase model
           		// return a list of results object, for example AclfNetworkResult objects in serialized 
           		// fromat (String) in no particular order
           		result = grid.execute(IpssMultiStudyCaseGridGainTask.class.getName(), model, timeout).get();
           	else if (model instanceof AclfNetwork || model instanceof AclfAdjNetwork)
           		// IpssAclfNetGridGainTask is designed to process the AclfAdjNetwork model
           		// return an AclfAdjNetork object in 
           		result = grid.execute(IpssAclfNetGridGainTask.class.getName(), model, timeout).get();
           	IpssLogger.getLogger().info("End to excute IpssGridTask " + desc );
       	} catch (GridTaskTimeoutException e) {
       		IpssLogger.logErr(e);
       		throw new GridException("Grid computing timeout, please check the state of remote grid node(s)");
       	}
        return result;
    }

    /**
     * Start the Grid and create the default grid object
     */
   	public static void startDefaultGrid() {
		IpssLogger.getLogger().info("Start GridGain env ...");
       	try {
       		GridFactory.start();
           	defaultGrid = GridFactory.getGrid();
            String[] list = gridNodeNameList(defaultGrid, true); 
            if (list.length > 0) {
               	gridEnabled = true;
    			IpssLogger.getLogger().info("Grid Computing env has been setup properly");
    			IpssLogger.getLogger().info("# of Grid node = " + list.length);
            }
       	} catch (NoClassDefFoundError ex) {
       		IpssLogger.getLogger().severe(ex.toString());
       		SpringAppContext.getEditorDialogUtil().showWarnMsgDialog("Warnnig", "Grid Computing env has not been set up properly, Please include GridGain library");
       	} catch (GridException e) {
           	gridEnabled = false;
			IpssLogger.getLogger().info("Grid Computing env has not been set up properly");
			SpringAppContext.getEditorDialogUtil().showWarnMsgDialog("Warnnig", "Cannot start Grid computation environment");
       	}       	
    }
    
   	/**
   	 * Stop the Grid 
   	 */
   	public static void stopDaultGrid() {
   		if (GridFactory.getState() == GridFactoryState.STARTED) {
   			GridFactory.stop(true);
   		}
    }

   	/**
   	 * Re-discover grid nodes and refresh the node list
   	 * 
   	 * @return refreshed grid object
   	 */
   	public static Grid freshDefaultGrid() {
       	defaultGrid = GridFactory.getGrid();
       	nodeNameLookupTable.clear();
        String[] list = gridNodeNameList(defaultGrid, true); 
        if (list.length > 0) {
           	gridEnabled = true;
			IpssLogger.getLogger().info("Grid Computing env has been setup properly");
			IpssLogger.getLogger().info("# of Grid node = " + list.length);
        }
   		return defaultGrid;
   	}

   	/**
   	 * Get the default grid object
   	 * 
   	 * @return the object
   	 */
   	public static Grid getDefaultGrid() {
   		return defaultGrid;
   	}
   	
   	/**
   	 * Check if the grid env is ready 
   	 * 
   	 * @return true or false
   	 */
   	public static boolean isGridEnabled() {
   		return gridEnabled;
   	}
   	
    /**
     * From Grid node name to node UDDI string lookup
     * 
     * @param name
     * @return grid node UUDI string, or null if not found
     */
    public static String nodeIdLookup(String name) {
    	for (String id : nodeNameLookupTable.keySet()) {
    		if (nodeNameLookupTable.get(id).equals(name))
    			return id;
    	}
    	return null;
    }

    /**
     * From Grid node UDDI string to remote Logical node name lookup. If no name existing
     * a new name Logical Node-<Node Cnt> will be assigned to the grid node
     * 
     * @param uid
     * @return node name
     */
    public static String nodeNameLookup(String uid) {
    	String name = nodeNameLookupTable.get(uid); 
    	if (name == null) {
    		int cnt = nodeNameLookupTable.size();
    		name = Token_RemoteNode + " - " + (cnt+1);
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
     * Get all remote grid node name, except the local node
     * 
     * @return the grid node name list
     */
    public static String[] getRemoteGridNodeNameList() {
    	return gridNodeNameList(getDefaultGrid(), true);
    }

    /**
     * Get all grid node name

     * @param gird the Grid object
     * @param remote include/exclude local grid node 
     * @return the grid node name list
     */
    public static String[] gridNodeNameList(Grid grid, boolean remote) {
        String[] nameList = null;
        String localId = grid.getLocalNode().getId().toString();
        Vector<String> vct = new Vector<String>();
        if (!remote)
        	vct.add(Token_MasterNode);
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
        return nameList;
    }
}
