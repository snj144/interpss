package org.interpss.custom.run.psseCon;

import org.interpss.custom.run.CustomRunScriptPluginBase;

import com.interpss.common.util.IpssLogger;
import com.interpss.simu.SimuContext;


public class PSSEContingencyAnalysis extends CustomRunScriptPluginBase {

	@Override
	public boolean runCase(String scripts, SimuContext simuCtx) {
		IpssLogger.getLogger().info("Run custom scripts with plugin: PSSEContingencyAnalysis");
		return true;
	}
	
	
}
