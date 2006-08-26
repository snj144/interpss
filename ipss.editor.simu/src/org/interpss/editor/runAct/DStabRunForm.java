package org.interpss.editor.runAct;

import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.data.proj.AclfCaseData;
import org.interpss.editor.data.proj.DStabCaseData;
import org.interpss.editor.data.proj.ProjData;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;

import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.util.IDStabSimuOutputHandler;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.simu.SimuContext;

public class DStabRunForm extends BaseRunForm {
	private int dbSimuCaseId = 0;
	
	public DStabRunForm() {}

	private AclfCaseData aclfCaseData = null;

	private DStabCaseData dStabCaseData = null;
	
	/**
	 * @return the dStabCaseData
	 */
	public DStabCaseData getDStabCaseData() {
		return dStabCaseData;
	}

	/**
	 * @param stabCaseData the dStabCaseData to set
	 */
	public void setDStabCaseData(DStabCaseData stabCaseData) {
		dStabCaseData = stabCaseData;
	}

	/**
	 * 
	 * @param dstabNet
	 * @param msg
	 * @return case id
	 */
	public void runDStab(SimuContext simuCtx, IPSSMsgHub msg) {
		simuCtx.getDStabilityNet().removeAllDEvent();
		
  		IpssMapper mapper = SimuAppSpringAppContext.getRunForm2AlgorithmMapper();
  		mapper.mapping(this, simuCtx.getDynSimuAlgorithm(), DynamicSimuAlgorithm.class);

		if (!simuCtx.getDynSimuAlgorithm().checkData(msg)) {
			IpssLogger.getLogger().warning("DStab simulation data checking failed");
			return;
		}

		// dstab net data changed in the mapping process
		if (!simuCtx.getDStabilityNet().checkData(msg)) {
			IpssLogger.getLogger().warning("DStab network data checking failed");
			return;
		}
		
		LoadflowAlgorithm aclfAlgo = simuCtx.getDynSimuAlgorithm().getAclfAlgorithm();
		aclfAlgo.loadflow(msg);
	  	if (getAclfCaseData().getShowSummary()) {
	  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Loadflow Analysis Info");
	  		dialog.display(simuCtx.getDStabilityNet());
	  	}
	  	if (!simuCtx.getDStabilityNet().isLfConverged()) {
	  		msg.sendWarnMsg("Loadflow diverges, please make sure that loadflow converges before runing the transient stability simulation");
	  		return;
	  	}

	  	// set up output and run the simulation
		IDStabSimuOutputHandler handler = simuCtx.getDynSimuAlgorithm().getSimuOutputHandler();
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		ProjData projData = (ProjData)appSimuCtx.getProjData();
		// to avoid conflict with StudyCase name, we add " SimuRecord" to the SimuRecord case.
		handler.init(projData.getProjectDbId(), projData.getDStabCaseName()+" SimuRecord");
		setDbSimuCaseId(handler.getCaseId());
		simuCtx.getDynSimuAlgorithm().setSimuOutputHandler(handler);

	  	if (simuCtx.getDynSimuAlgorithm().initialization(msg)) {
			simuCtx.getDynSimuAlgorithm().performSimulation(msg);
		}
	}
	
	/**
	 * @return Returns the dbSimuCaseId.
	 */
	public int getDbSimuCaseId() {
		return dbSimuCaseId;
	}
	/**
	 * @param dbSimuCaseId The dbSimuCaseId to set.
	 */
	public void setDbSimuCaseId(int dbSimuCaseId) {
		this.dbSimuCaseId = dbSimuCaseId;
	}
	/**
	 * @return the aclfCaseData
	 */
	public AclfCaseData getAclfCaseData() {
		if (aclfCaseData == null)
			aclfCaseData = new AclfCaseData();
		return aclfCaseData;
	}
	/**
	 * @param aclfCaseData the aclfCaseData to set
	 */
	public void setAclfCaseData(AclfCaseData aclfCaseData) {
		this.aclfCaseData = aclfCaseData;
	}
}