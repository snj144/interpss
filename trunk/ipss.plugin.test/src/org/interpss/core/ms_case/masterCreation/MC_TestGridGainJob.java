package org.interpss.core.ms_case.masterCreation;

import java.io.Serializable;
import java.util.UUID;

import org.gridgain.grid.GridTaskSession;
import org.gridgain.grid.resources.GridLocalNodeIdResource;
import org.gridgain.grid.resources.GridTaskSessionResource;
import org.interpss.core.grid.gridgain.AbstractIpssGridGainJob;
import org.interpss.core.grid.gridgain.IpssGridGainUtil;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.ms_case.GridMultiStudyCase;
import com.interpss.core.ms_case.StudyCaseCreationType;

public class MC_TestGridGainJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;
	
	@GridLocalNodeIdResource
	private UUID nodeId;
	
    /** Grid task session will be injected. */
    @GridTaskSessionResource
    private GridTaskSession ses = null;
    
	//private GridMultiStudyCase gridMultiStudyCase = null;	

	public MC_TestGridGainJob(String model) {
		super(model);
	}
	
    public Serializable execute() {
    	initEMFPackage();

		if ((StudyCaseCreationType)ses.getAttribute("creationType") == StudyCaseCreationType.DISTRIBUTED_CREATION) {
			GridMultiStudyCase gridMCase = (GridMultiStudyCase)SerializeEMFObjectUtil.loadModel((String)ses.getAttribute("model"));
    		System.out.println("--->" + ses.getAttribute("model"));
		}
    	
    	// de-serialized the model to a AclfNetwork object 
    	String modelStr = getArgument();
		AclfNetwork net = (AclfNetwork)SerializeEMFObjectUtil.loadModel(modelStr);
		 
		// perform loadflow calculation
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		algo.loadflow(SpringAppContext.getIpssMsgHub());
		
		return IpssGridGainUtil.serializeGridAclfResult(nodeId.toString(), net);
    }

}
