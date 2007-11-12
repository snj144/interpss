package org.interpss.core.grid.gridgain.aclf;

import java.io.Serializable;

import org.gridgain.grid.GridException;
import org.interpss.core.grid.gridgain.AbstractIpssGridGainJob;
import org.interpss.core.grid.gridgain.dstab.IpssDStabGridGainTask;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.AlgorithmFactory;
import com.interpss.core.algorithm.LoadflowAlgorithm;

public class AclfNetGridGainJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;
	
	public AclfNetGridGainJob(String model) {
		super(model);
	}
	
	/**
	 * Deserialize the AclfNetwork/AclfAdjNetwork object and optional LoadflowAlgorithm object. Then 
	 * perform Loadflow and send the results back to the master node
	 */
    public Serializable execute() throws GridException {
    	// init EMF 
    	initEMFPackage();

		// de-serialized the model to a AclfNetwork object 
		String modelStr = getArgument();
		AclfNetwork net = null;
		Object obj = SerializeEMFObjectUtil.loadModel(modelStr);
		if (obj instanceof AclfNetwork)
			net = (AclfNetwork)obj;
		else if (obj instanceof AclfAdjNetwork)
			net = (AclfAdjNetwork)obj;
		 
		// get serialized algo string from the task session
		String algoStr = (String)getSession().getAttribute(IpssDStabGridGainTask.Token_AclfAlgo+net.getId());
		LoadflowAlgorithm algo;
		if (algoStr != null) {
			// set algo attributes. These attributes are not serialized
			algo = (LoadflowAlgorithm)SerializeEMFObjectUtil.loadModel(algoStr);
	  		if (net instanceof AclfAdjNetwork) {
	  			algo.setAdjAlgorithm(AlgorithmFactory.eINSTANCE.createAclfAdjustAlgorithm());
	  			algo.setAclfAdjNetwork((AclfAdjNetwork)net);
	  		}
	  		else {
	  			algo.setAclfNetwork(net);
	  		}
    	}
		else {
			// this is more for testing purpose
			algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		}

		// perform loadflow calculation
		algo.loadflow(SpringAppContext.getIpssMsgHub());
		
		// send the calculated Aclf object back to the master node
		return SerializeEMFObjectUtil.saveModel(net);
    }
}
