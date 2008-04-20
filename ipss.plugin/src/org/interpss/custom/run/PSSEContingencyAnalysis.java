package org.interpss.custom.run;

import com.interpss.common.util.IpssLogger;
import com.interpss.simu.SimuContext;


public class PSSEContingencyAnalysis extends CustomRunScriptPluginBase {

	@Override
	public boolean runCase(String scripts, SimuContext simuCtx) {
		IpssLogger.getLogger().info("Run custom scripts with plugin: PSSEContingencyAnalysis");
		return true;
	}
}
