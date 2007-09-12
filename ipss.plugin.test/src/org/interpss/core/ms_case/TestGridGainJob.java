package org.interpss.core.ms_case;

import java.io.Serializable;
import java.util.UUID;

import org.gridgain.grid.resources.GridLocalNodeIdResource;
import org.interpss.core.grid.gridgain.AbstractIpssGridGainJob;
import org.interpss.core.grid.gridgain.IpssGridGainUtil;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;

public class TestGridGainJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;
	
	@GridLocalNodeIdResource
	private UUID nodeId;
	
	//private GridMultiStudyCase gridMultiStudyCase = null;	

	public TestGridGainJob(String model) {
		super(model);
	}
	
    public Serializable execute() {
    	initEMFPackage();
    	// de-serialized the model to a AclfNetwork object 
    	String modelStr = getArgument();
		AclfNetwork net = (AclfNetwork)SerializeEMFObjectUtil.loadModel(modelStr);
		 
		// perform loadflow calculation
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		algo.loadflow(SpringAppContext.getIpssMsgHub());
		
		return IpssGridGainUtil.serializeGridAclfResult(nodeId.toString(), net);
    }

}
