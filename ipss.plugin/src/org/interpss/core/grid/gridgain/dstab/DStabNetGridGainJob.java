package org.interpss.core.grid.gridgain.dstab;

import java.io.Serializable;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridNode;
import org.gridgain.grid.GridTaskSession;
import org.gridgain.grid.resources.GridInstanceResource;
import org.gridgain.grid.resources.GridTaskSessionResource;
import org.interpss.core.grid.gridgain.AbstractIpssGridGainJob;

import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.dstab.DStabilityNetwork;

public class DStabNetGridGainJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;
	
    /** Grid task session will be injected. */
    @GridTaskSessionResource
    private GridTaskSession session = null;
    
    @GridInstanceResource
    private Grid grid = null;
    
	public DStabNetGridGainJob(String model) {
		super(model);
	}
	
    public Serializable execute() throws GridException {
    	initEMFPackage();

    	GridNode masterNode = grid.getLocalNode();
    	grid.sendMessage(masterNode, "Hello from Job");
    	
		// de-serialized the model to a DSatbilityNetwork object 
		String modelStr = getArgument();
		DStabilityNetwork net = (DStabilityNetwork)SerializeEMFObjectUtil.loadModel(modelStr);
/*		
		DynamicSimuAlgorithm algo = DStabObjectFactory.createDynamicSimuAlgorithm(net, msg);
		algo.setSimuStepSec(0.002);
		algo.setTotalSimuTimeSec(10.0);
		
		Machine mach = net.getMachine("Mach@0003");
		algo.setRefMachine(mach);	
		
		addDynamicEventData(net);
		
		LoadflowAlgorithm aclfAlgo = algo.getAclfAlgorithm();
		aclfAlgo.loadflow(msg);
*/		
		return null;
    }

}
