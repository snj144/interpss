package org.interpss.sample.grid;

import org.gridgain.grid.Grid;
import org.interpss.display.AclfOutFunc;
import org.interpss.gridgain.GridRunner;
import org.interpss.gridgain.msg.RemoteMessageTable;
import org.interpss.gridgain.util.GridUtil;
import org.interpss.sample.grid.impl.GridHelper;
import org.interpss.sample.grid.impl.MyAclfSingleJobTaskImpl;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IPSSMsgHubImpl;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.adj.AclfAdjNetwork;
import com.interpss.simu.util.sample.SampleCases;

/**
 * This example assumes that at least one remote Gridgain 2.1.1 agent is running in the LAN. A simple
 * loadflow case will be distributed to a gridgain agent (randomly selected), and the loadflow 
 * calculation is done at the remote gridgain agent. The loadflow results will be sent back to the 
 * local Java program and print out.  
 *
 */
public class ExtendIpssGridImpl {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IPSSMsgHub msg = new IPSSMsgHubImpl();
		
		// init grid computing env
		Grid grid = GridHelper.initGridEnv();
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
        		adjNet = CoreObjectFactory.createAclfAdjNetwork(result.getSerializedAclfNet());
        		
        		// print out the user-defined returning result
        		System.out.println("MyKey = " + result.get("MyKey").toString());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}

    		// output simulaiton results
    		System.out.println(AclfOutFunc.loadFlowSummary(adjNet));
    	}
		
		System.out.println("Stop InterPSS Grid env ...");
		GridUtil.stopDefaultGrid();		
	}
}
