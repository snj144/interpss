package org.interpss.core.grid.gridgain.dstab;

import java.io.Serializable;

import org.gridgain.grid.GridException;
import org.interpss.core.grid.gridgain.AbstractIpssGridGainJob;

import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.dstab.DStabilityNetwork;

public class DStabNetGridGainJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;
	
	public DStabNetGridGainJob(String model) {
		super(model);
	}
	
    public Serializable execute() throws GridException {
    	initEMFPackage();

		// de-serialized the model to a DSatbilityNetwork object 
		String modelStr = getArgument();
		DStabilityNetwork net = (DStabilityNetwork)SerializeEMFObjectUtil.loadModel(modelStr);
		
		return null;
    }

}
