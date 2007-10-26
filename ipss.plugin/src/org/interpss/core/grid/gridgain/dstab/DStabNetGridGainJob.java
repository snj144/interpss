package org.interpss.core.grid.gridgain.dstab;

import java.io.Serializable;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridTaskSession;
import org.gridgain.grid.resources.GridInstanceResource;
import org.gridgain.grid.resources.GridTaskSessionResource;
import org.interpss.core.grid.gridgain.AbstractIpssGridGainJob;
import org.interpss.core.grid.gridgain.IPSSGridMsgHubImpl;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.TextMessage;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;

public class DStabNetGridGainJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;
	
    /** Grid task session will be injected. */
    @GridTaskSessionResource
    private GridTaskSession session = null;
    
    @GridInstanceResource
    private Grid grid = null;
    
    private IPSSMsgHub msgHub = null;
    
	public DStabNetGridGainJob(String model) {
		super(model);
	}
	
    public Serializable execute() throws GridException {
    	initEMFPackage();

		if (this.msgHub == null)
			this.msgHub = new IPSSGridMsgHubImpl(grid, TextMessage.TYPE_INFO);

		// de-serialized the model to a DSatbilityNetwork object 
		String modelStr = getArgument();
		DStabilityNetwork net = (DStabilityNetwork)SerializeEMFObjectUtil.loadModel(modelStr);
/*		
		DynamicSimuAlgorithm algo = DStabObjectFactory.createDynamicSimuAlgorithm(net, msgHub);
		algo.setSimuStepSec(0.002);
		algo.setTotalSimuTimeSec(10.0);
		
//		addDynamicEventData(net);
		
		LoadflowAlgorithm aclfAlgo = algo.getAclfAlgorithm();
		aclfAlgo.loadflow(msgHub);
		
		if (algo.initialization(msgHub)) {
			msgHub.sendStatusMsg("Running DStab simulation ...");
			algo.performSimulation(msgHub);
		}
*/		
		return null;
    }

}
