package org.interpss.sample.grid.impl;

import java.io.Serializable;

import org.interpss.gridgain.job.GridAclfJob;
import org.interpss.gridgain.msg.RemoteMessageTable;
import org.interpss.gridgain.result.RemoteResultFactory;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.adj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;

/**
 * This is the place where actual loadflow is implemented. This class will be
 * executed in the remote grid node. The input and output are communicated through
 * the RemoteMessageTable object 
 * 
 * @author mzhou
 */

public class MyGridAclfJobImpl extends GridAclfJob {
	private static final long serialVersionUID = 1;

	public MyGridAclfJobImpl(RemoteMessageTable inRemoteMsg) {
		super(inRemoteMsg);
	}
	
	@Override
	protected Serializable performGridJob(RemoteMessageTable inRemoteMsg) {
		/*
		 * de-serialize the job object
		 */
		AclfNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(
					inRemoteMsg.getStudyCaseNetworkModel());
		net.rebuildLookupTable();
		
		/*
		 * Perform Loadflow calculation. One can do anyting to the AclfNetwork object
		 * here. Loadflow is just used as an example.
		 */
		LoadflowAlgorithm algo = CoreObjectFactory
					.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
		algo.loadflow();
 
		/*
		 * Save results into the RemoteResult table, which will be sent to the master node
		 */
		String caseId = inRemoteMsg.getStudyCaseId();
		RemoteMessageTable outRemoteResult = new RemoteMessageTable();
		RemoteResultFactory.createHandler(MyGridAclfJobImpl.class)
					.saveRemoteResult(outRemoteResult, caseId, getGrid().getLocalNode().getId().toString(), 
							algo, getSession());  // Loadflow results stored in the algo object 
		return outRemoteResult;
	}
}
