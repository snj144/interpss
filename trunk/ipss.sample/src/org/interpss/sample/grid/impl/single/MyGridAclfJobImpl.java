package org.interpss.sample.grid.impl.single;

import java.io.Serializable;

import org.interpss.gridgain.job.GridAclfJob;
import org.interpss.gridgain.msg.RemoteMessageTable;
import org.interpss.gridgain.result.RemoteResultFactory;

import com.interpss.common.SpringAppContext;
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
		RemoteMessageTable outRemoteResult = new RemoteMessageTable();
		try {
			/*
			 * de-serialize the job object
			 */
			AclfNetwork net = CoreObjectFactory.createAclfNetwork();
			net = (AclfAdjNetwork)net.deserialize(inRemoteMsg.getStudyCaseNetworkModel());
			
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
			RemoteResultFactory.createHandler(MyGridAclfJobImpl.class)
						.saveRemoteResult(outRemoteResult, caseId, getGrid().getLocalNode().getId().toString(), 
								algo, getSession());  // Loadflow results stored in the algo object

			// an example to send some results back to the master node
			outRemoteResult.put("MyKey", "MyValue");
		} catch (Exception e) {
			outRemoteResult.put(RemoteMessageTable.KEY_bRsp_ReturnStatus, Boolean.FALSE);
			outRemoteResult.addReturnMessage(e.toString());
		}
		return outRemoteResult;
	}
}
