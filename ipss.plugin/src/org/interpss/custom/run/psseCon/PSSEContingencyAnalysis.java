package org.interpss.custom.run.psseCon;

import org.interpss.custom.run.CustomRunScriptPluginBase;
import org.interpss.schema.InterPSSXmlType;

import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.StringUtil;
import com.interpss.simu.SimuContext;


public class PSSEContingencyAnalysis extends CustomRunScriptPluginBase {

	@Override
	public boolean runCase(String scripts, SimuContext simuCtx) {
		IpssLogger.getLogger().info("Run custom scripts with plugin: PSSEContingencyAnalysis");
		String[] strAry = StringUtil.strToken2Array(scripts, System.getProperty("line.separator"));
		//for(String s : strAry) System.out.println(s);
		
		InterPSSXmlType ipssXmlDoc = null;
		try {
			ipssXmlDoc = ContingencyFileParser.parseControlFile(strAry);
		} catch (Exception e) {
			IpssLogger.getLogger().severe(e.toString());
			return false;
		}
		System.out.println(ipssXmlDoc.toString());
		
		return true;
	}
}
