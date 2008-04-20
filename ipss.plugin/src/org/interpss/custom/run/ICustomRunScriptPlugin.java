package org.interpss.custom.run;

import com.interpss.common.custom.IpssCustomAdapter;
import com.interpss.simu.SimuContext;

public interface ICustomRunScriptPlugin extends IpssCustomAdapter {
	/**
	 * Run the scripts using custom plugin
	 * 
	 * @param scripts run scripts, a string representing an XML document
	 * @param simuCtx the SimuContext object
	 * @return
	 */
	boolean runCase(String scripts, SimuContext simuCtx);
}
