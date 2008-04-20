package org.interpss.custom.run;

import com.interpss.common.util.IpssLogger;
import com.interpss.simu.SimuContext;


public class PSSEContingencyAnalysis implements IpssCustomRunScriptAdapter {

	@Override
	public boolean runCase(String scripts, SimuContext simuCtx) {
		IpssLogger.getLogger().info("Run custom scripts with plugin: PSSEContingencyAnalysis");
		return true;
	}

	private String name;
	private String desc;
	
	@Override
	public String getDescription() {
		return this.desc;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void setDescription(String s) {
		this.desc = s;
	}

	public void setName(String s) {
		this.name = s;
	}
}
