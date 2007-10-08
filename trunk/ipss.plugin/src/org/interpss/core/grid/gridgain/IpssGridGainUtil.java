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
	
   	private static Grid defaultGrid = null;
   	private static boolean gridEnabled = false;

   	public static void startDaultGrid() {
		IpssLogger.getLogger().info("Start GridGain env ...");
       	try {
       		GridFactory.start();
           	defaultGrid = GridFactory.getGrid();
            String[] list = gridNodeNameList(defaultGrid); 
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
    
   	public static void stopDaultGrid() {
   		if (GridFactory.getState() == GridFactoryState.STARTED) {
   			GridFactory.stop(true);
   		}
    }

   	public static Grid getDefaultGrid() {
   		return defaultGrid;
   	}
   	
   	public static boolean isGridEnabled() {
   		return gridEnabled;
   	}
   	
   	/**
	 * run complete grid task on the model object.
	 * 
	 * @param desc a description string
	 * @param model an EMF model object
	 * @return result object or a list of result objects, 
	 * @throws GridException
	 */
    public static Object runGridTask(String desc, EObject model) throws GridException {
       	GridFactory.start();
        try {
        	Grid newGrid = GridFactory.getGrid();
            return performGridTask(newGrid, desc, model);
        }
        finally {
        	GridFactory.stop(true);
        }
    }
    
	/**
	 * Perform grid computing on the model object.
	 * 
	 * @param desc a description string
	 * @param model an EMF model object
	 * @return result object or a list of result objects, 
	 * @throws GridException
	 */
    public static Object performGridTask(Grid grid, String desc, EObject model) throws GridException {
        Object result = null;
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
     * Get all grid node name
     * 
     * @return
     */
    public static String[] gridNodeNameList() {
        try {
        	GridFactory.start();
            try {
                Grid grid = GridFactory.getGrid();
                return gridNodeNameList(grid);
            }
            finally {
                GridFactory.stop(true);
            }
        } catch (GridException e) {
        	return null;
        }
    }

    public static String[] getDefaultGridNodeNameList() {
    	return gridNodeNameList(getDefaultGrid());
    }

    public static String[] gridNodeNameList(Grid grid) {
        String[] nameList = null;
        String localId = grid.getLocalNode().getId().toString();
        Vector<String> vct = new Vector<String>();
      	//vct.add(LocalGridNodeName);
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
