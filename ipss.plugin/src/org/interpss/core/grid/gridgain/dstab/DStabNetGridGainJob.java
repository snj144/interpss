package org.interpss.core.grid.gridgain.dstab;

import java.io.Serializable;

import org.gridgain.grid.GridException;
import org.interpss.core.grid.gridgain.AbstractIpssGridGainJob;
import org.interpss.core.grid.gridgain.util.DStabSimuGridOutputHandler;

import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.util.DynamicEventProcessor;
import com.interpss.dstab.util.IDStabSimuOutputHandler;

public class DStabNetGridGainJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;
	
	public DStabNetGridGainJob(String model) {
		super(model);
	}
	
    public Serializable execute() throws GridException {
    	initEMFPackage();

		// de-serialized the model to a DSatbilityNetwork object 
		String modelStr = getArgument();
		//System.out.println(modelStr);
		DStabilityNetwork net = (DStabilityNetwork)SerializeEMFObjectUtil.loadModel(modelStr);
	
		// get serialized algo string from the task session
		String algoStr = (String)getSession().getAttribute(IpssDStabGridGainTask.Token_DStabAlgo+net.getId());
		//System.out.println(algoStr);
		DynamicSimuAlgorithm algo;
		if (algoStr != null) {
			// set algo attributes. These attributes are not serialized
			algo = (DynamicSimuAlgorithm)SerializeEMFObjectUtil.loadModel(algoStr);
			
			algoStr = (String)getSession().getAttribute(IpssDStabGridGainTask.Token_AclfAlgo+net.getId());
			LoadflowAlgorithm lfAlgo = (LoadflowAlgorithm)SerializeEMFObjectUtil.loadModel(algoStr);
			algo.setAclfAlgorithm(lfAlgo);

			algo.setDynamicEventHandler(new DynamicEventProcessor(getMsgHub()));
			algo.setDStabNet(net);
    	}
		else {
			// this is more for testing purpose
			algo = DStabObjectFactory.createDynamicSimuAlgorithm(net, getMsgHub());
			algo.setSimuStepSec(0.01);
			algo.setTotalSimuTimeSec(10.0);
		}
		
		// set simulation result handler
		IDStabSimuOutputHandler handler = new DStabSimuGridOutputHandler(getMsgHub());
		algo.setSimuOutputHandler(handler);
		
		// perform load flow calculation
		LoadflowAlgorithm aclfAlgo = algo.getAclfAlgorithm();
		aclfAlgo.loadflow(getMsgHub());
		
		if (algo.initialization(getMsgHub())) {
			getMsgHub().sendStatusMsg("Running DStab simulation at remote node " + getGrid().getLocalNode());
			if (algo.performSimulation(getMsgHub()))
				return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
    }
}
