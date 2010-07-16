package org.interpss.sample.grid;

import org.gridgain.grid.Grid;
import org.interpss.PluginSpringAppContext;
import org.interpss.custom.IpssFileAdapter;
import org.interpss.display.AclfOutFunc;
import org.interpss.gridgain.GridRunner;
import org.interpss.gridgain.msg.RemoteMessageTable;
import org.interpss.gridgain.util.GridUtil;
import org.interpss.sample.grid.impl.GridHelper;
import org.interpss.sample.grid.impl.MyAclfSingleJobTaskImpl;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.simu.SimuContext;

/**
 * This example assumes that at least one remote Gridgain 2.1.1 agent is running in the LAN. A simple
 * loadflow case will be distributed to a gridgain agent (randomly selected), and the loadflow 
 * calculation is done at the remote gridgain agent. The loadflow results will be sent back to the 
 * local Java program and print out.  
 *
 */
public class GridUCTE2000WinterOffPeakCase {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringAppContext.setAppContext(Constants.SpringConfigPath_Plugin);
		
		// init grid computing env
		Grid grid = GridHelper.initGridEnv();
    	if (grid != null) {
    		// randomly select a remote grid node 
	    	MyAclfSingleJobTaskImpl.RemoteNodeId = GridUtil.getAnyRemoteNodeId();

	    	try {
				IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("ieee");
				SimuContext simuCtx = adapter.load("testData/UCTE_2000_WinterOffPeak.ieee");
				AclfNetwork adjNet = simuCtx.getAclfNet();
	    		adjNet.setId("SampleNetId");
	    		
	    		// sent the adjNet object to a remote grid node for loadflow calculation
	    		// the custom class MyAclfSingleJobTaskImpl will be used to perform the simulation
        		RemoteMessageTable result = new GridRunner(grid).executeTask(MyAclfSingleJobTaskImpl.class, adjNet, 0);
        		
        		// de-serialized the returning results
        		adjNet = CoreObjectFactory.createAclfNetwork(result.getSerializedAclfNet());

        		// output simulation results
        		System.out.println(AclfOutFunc.loadFlowSummary(adjNet));
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
		
		System.out.println("Stop InterPSS Grid env ...");
		GridUtil.stopDefaultGrid();		
	}
}
