package org.interpss.core.grid.gridgain.aclf;

import java.io.Serializable;

import org.gridgain.grid.GridException;
import org.interpss.core.grid.gridgain.AbstractIpssGridGainJob;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;

public class AclfNetGridGainJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;
	
	public AclfNetGridGainJob(String model) {
		super(model);
	}
	
    public Serializable execute() throws GridException {
    	initEMFPackage();

		// de-serialized the model to a AclfNetwork object 
		String modelStr = getArgument();
		AclfNetwork net = (AclfNetwork)SerializeEMFObjectUtil.loadModel(modelStr);
		 
		// perform loadflow calculation
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		algo.loadflow(SpringAppContext.getIpssMsgHub());
		
		return SerializeEMFObjectUtil.saveModel(net);
    }

}
