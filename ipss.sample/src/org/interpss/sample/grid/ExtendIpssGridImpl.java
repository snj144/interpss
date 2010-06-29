package org.interpss.sample.grid;

import java.io.Serializable;
import java.util.UUID;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridMessageListener;
import org.interpss.display.AclfOutFunc;
import org.interpss.gridgain.GridRunner;
import org.interpss.gridgain.util.GridUtil;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IPSSMsgHubImpl;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.ext.gridgain.RemoteMessageTable;
import com.interpss.simu.util.sample.SampleCases;

/**
 * This example assumes that at least one remote Gridgain 2.1.1 agent is running in the LAN. A simple
 * loadflow case will be distributed to a gridgain agent (randomly selected), and the loadflow 
 * calculation is done at the remote gridgain agent. The loadflow results will be sent back to the 
 * local Java program and print out.  
 *
 */
public class ExtendIpssGridImpl {
	public static String GridGainHome = "c:/Program Files (x86)/gridgain-2.1.1";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IPSSMsgHub msg = new IPSSMsgHubImpl();
		
		// init grid computing env
		Grid grid = initGridEnv();
    	if (grid != null) {
    		// randomly select a remote grid node 
	    	MyAclfSingleJobTaskImpl.RemoteNodeId = GridUtil.getAnyRemoteNodeId();

	    	// input data and create InterPSS Aclf net object
    		AclfAdjNetwork adjNet = CoreObjectFactory.createAclfAdjNetwork();
    		SampleCases.load_LF_5BusSystem(adjNet, msg);
    		adjNet.setId("SampleNetId");
    		
	    	try {
	    		// sent the adjNet object to a remote grid node for loadflow calculation
	    		// the custom class MyAclfSingleJobTaskImpl will be used to perform the simulation
        		RemoteMessageTable result = new GridRunner(grid).executeTask(MyAclfSingleJobTaskImpl.class, adjNet, 0);
        		
        		// de-serialized the returning results
        		adjNet = (AclfAdjNetwork) SerializeEMFObjectUtil.loadModel(result.getSerializedAclfNet());
        		adjNet.rebuildLookupTable();
    		} catch (GridException e) {
    			e.printStackTrace();
    		}

    		// output simulaiton results
    		System.out.println(AclfOutFunc.loadFlowSummary(adjNet));
    	}
		
		System.out.println("Stop InterPSS Grid env ...");
		GridUtil.stopDefaultGrid();		
	}

	private static Grid initGridEnv() {
		// start interpss grid env
		GridUtil.startDefaultGrid(GridGainHome);
		if (!GridUtil.isGridEnabled()) {
			System.out.println("Cannot start grid env");
			return null;
		}
		
		if (GridUtil.getDefaultGrid().getAllNodes().size() <= 1) {
			System.out.println("Please start a least one Gridgain agent for the test");
			return null;
		}

		// set interpss grid env 
		Grid grid = GridUtil.getDefaultGrid();
		GridRunner.MasterNodeId = grid.getLocalNode().getId().toString();
		GridRunner.RemoteNodeDebug = false;

		// make sure Grid env is setup properly
		String[] list = GridUtil.gridNodeNameList(grid, false);
		if ( list.length <= 0) {
			System.out.println("InterPSS grid env is not started properly");
			return null;
		}
		
		// set remote message listener, so that message from remote note are printed out
    	grid.addMessageListener(new GridMessageListener() {
    		public void onMessage(UUID arg0, Serializable arg1) {
    			System.out.println(arg1);
    		}        		
    	});

    	System.out.println("InterPSS Grid Env started successfully");
    	return grid;
	}
}
