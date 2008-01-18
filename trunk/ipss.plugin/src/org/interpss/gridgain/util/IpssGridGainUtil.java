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

package org.interpss.gridgain.util;

import java.util.Hashtable;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;
import org.gridgain.grid.Grid;
import org.gridgain.grid.GridConfigurationAdapter;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridFactory;
import org.gridgain.grid.GridFactoryState;
import org.gridgain.grid.GridNode;
import org.gridgain.grid.GridTaskTimeoutException;
import org.gridgain.grid.spi.topology.basic.GridBasicTopologySpi;
import org.interpss.gridgain.task.assignJob.AssignJob2NodeAclfTask;
import org.interpss.gridgain.task.assignJob.AssignJob2NodeDStabTask;
import org.interpss.gridgain.task.multicase.MultiCaseAclfTask;
import org.interpss.gridgain.task.multicase.MultiCaseDStabTask;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.multicase.MultiStudyCase;

/**
 *   For IpssMultiStudyCaseGridGainTask implementation
 *    - Each study case has a unique caseNumber 
 *      When a EMF model, a Network object, is sent to a remote location, by creating a
 *          GridGainJob extends AbstractIpssGridGainJob, net.sortNumber = caseNumber
 *    - The result NetworkResult.caseNumber = net.sortNumber before returning to the Master node
 *    - Result net is set back to the StudyCase using caseNumber correlation.     

 *   For AssignJob2NodeTask implementation
 */

public class IpssGridGainUtil {
	// Master node id
	public static String MasterNodeId = "";	
	public static boolean RemoteNodeDebug = false;	
	
	// hold node name to node id lookup info
	private static Hashtable<String, String> nodeNameLookupTable = new Hashtable<String, String>();

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
	public static Object performGridTask(Grid grid, String desc, EObject model,
			long timeout) throws GridException {
		IpssLogger.getLogger().info(
				"Begin to excute IpssGridTask " + desc + " ...");
		IpssLogger.getLogger().info(
				"Number of Grid Nodes: " + grid.getAllNodes().size());
		try {
			// Single Aclf Case
			if (model instanceof AclfNetwork || model instanceof AclfAdjNetwork
					|| model instanceof LoadflowAlgorithm)
				return grid.execute(AssignJob2NodeAclfTask.class.getName(),
						model, timeout).get();
			// Single DStab case
			else if (model instanceof DStabilityNetwork
					|| model instanceof DynamicSimuAlgorithm)
				return grid.execute(AssignJob2NodeDStabTask.class.getName(),
						model, timeout).get();
			else if (model instanceof MultiStudyCase) {
				// Multiple Aclf Cases
				if (((MultiStudyCase) model).getNetType() == SimuCtxType.ACLF_ADJ_NETWORK
						|| ((MultiStudyCase) model).getNetType() == SimuCtxType.ACLF_NETWORK)
					return grid.execute(MultiCaseAclfTask.class.getName(),
							model, timeout).get();
				// Multiple DStab cases
				else if (((MultiStudyCase) model).getNetType() == SimuCtxType.DSTABILITY_NET)
					return grid.execute(MultiCaseDStabTask.class.getName(),
							model, timeout).get();
			}
		} catch (GridTaskTimeoutException e) {
			IpssLogger.logErr(e);
			throw new GridException(
					"Grid computing timeout, please check the state of remote grid node(s)");
		}
		return null;
	}

	/**
	 * Start the Grid and create the default grid object
	 */
	public static void startDefaultGrid() {
		IpssLogger.getLogger().info("Start GridGain env ...");
		try {
			GridBasicTopologySpi topSpi = new GridBasicTopologySpi();
			// Exclude local node from topology.
			topSpi.setLocalNode(false);
			GridConfigurationAdapter cfg = new GridConfigurationAdapter();
			// Override default topology SPI.
			cfg.setTopologySpi(topSpi);
			// Start grid.
			GridFactory.start(cfg);			

			defaultGrid = GridFactory.getGrid();
			String[] list = gridNodeNameList(defaultGrid, true);
			if (list.length > 0) {
				gridEnabled = true;
				IpssLogger.getLogger().info(
						"Grid Computing env has been setup properly");
				IpssLogger.getLogger().info("# of Grid node = " + list.length);
			}
		} catch (NoClassDefFoundError ex) {
			IpssLogger.getLogger().severe(ex.toString());
			SpringAppContext
					.getEditorDialogUtil()
					.showWarnMsgDialog(
							"Warnnig",
							"Grid Computing env has not been set up properly, Please include GridGain library");
		} catch (GridException e) {
			gridEnabled = false;
			IpssLogger.getLogger().info(
					"Grid Computing env has not been set up properly");
			SpringAppContext.getEditorDialogUtil().showWarnMsgDialog("Warnnig",
					"Cannot start Grid computation environment");
		}
	}

	/**
	 * Stop the Grid 
	 */
	public static void stopDefaultGrid() {
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
			IpssLogger.getLogger().info(
					"Grid Computing env has been setup properly");
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
	 * get a remote grid node UDDI string
	 * 
	 * @return grid node UUDI string, or null if not found
	 */
	public static String getAnyRemoteNodeId() {
		for (String id : nodeNameLookupTable.keySet())
			return id;
		return null;
	}

	/**
	 * From Grid node UDDI string to remote Logical node name lookup. If no name existing
	 * a new name Logical Node-<Node Cnt> will be assigned to the grid node
	 * 
	 * @param uid grid node UUID string
	 * @return node name 
	 */
	public static String nodeNameLookup(String uid) {
		String name = nodeNameLookupTable.get(uid);
		if (name == null) {
			int cnt = nodeNameLookupTable.size();
			name = Constants.GridToken_RemoteNode + " - " + (cnt + 1);
			nodeNameLookupTable.put(uid, name);
		}
		return name;
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
			vct.add(Constants.GridToken_MasterNode);
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
