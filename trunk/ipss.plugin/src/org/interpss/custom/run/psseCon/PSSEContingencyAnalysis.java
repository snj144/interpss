package org.interpss.custom.run.psseCon;

import org.interpss.custom.run.CustomRunScriptPluginBase;
import org.interpss.schema.AclfAlgorithmXmlType;
import org.interpss.schema.InterPSSXmlType;
import org.interpss.schema.RunStudyCaseXmlType;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.StringUtil;


public class PSSEContingencyAnalysis extends CustomRunScriptPluginBase {
	@Override
	public InterPSSXmlType createIpssXmlDocument(String scripts, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Run custom scripts with plugin: PSSEContingencyAnalysis");
		String[] strAry = StringUtil.strToken2Array(scripts, System.getProperty("line.separator"));
		//for(String s : strAry) System.out.println(s);
		
		InterPSSXmlType ipssXmlDoc = null;
		try {
			ipssXmlDoc = ContingencyFileParser.parseControlFile(strAry);
			createAclfRunXmlScriots(ipssXmlDoc);
		} catch (Exception e) {
			msg.sendErrorMsg(e.toString());
			return null;
		}
		
		return ipssXmlDoc;
	}

	private boolean createAclfRunXmlScriots(InterPSSXmlType ipssXmlDoc) {
		// grid computing settings
		RunStudyCaseXmlType.GridRun gridRun = ipssXmlDoc.getRunStudyCase().addNewGridRun();
		gridRun.setEnableGridRun(true);
		gridRun.setRemoteJobCreation(true);
		RunStudyCaseXmlType.GridRun.AclfOption opt = gridRun.addNewAclfOption();
		opt.setReturnStudyCase(RunStudyCaseXmlType.GridRun.AclfOption.ReturnStudyCase.DIVERGED_CASE);
		
		// default Aclf Algorithm settings
		AclfAlgorithmXmlType algo = ipssXmlDoc.getRunStudyCase().getRunAclfStudyCase().addNewDefaultAclfAlgorithm();
		algo.setLfMethod(AclfAlgorithmXmlType.LfMethod.NR);
		algo.setMaxIterations(20);
		algo.setTolerance(0.0001);
		algo.setAdjustChangeStep(true);
		return true;
	}
}
