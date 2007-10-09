package org.interpss.core.gridgain;

import java.io.Serializable;
import java.util.UUID;

import org.gridgain.grid.GridTaskSession;
import org.gridgain.grid.resources.GridLocalNodeIdResource;
import org.gridgain.grid.resources.GridTaskSessionResource;
import org.interpss.core.grid.gridgain.AbstractIpssGridGainJob;
import org.interpss.core.grid.gridgain.IpssGridGainUtil;
import org.interpss.core.ms_case.IpssMultiStudyCaseGridGainTask;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.ms_case.GridMultiStudyCase;
import com.interpss.core.ms_case.StudyCase;

public class SampleGridGainJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;
	
	@GridLocalNodeIdResource
	private UUID nodeId;
	
    /** Grid task session will be injected. */
    @GridTaskSessionResource
    private GridTaskSession ses = null;
    
	//private GridMultiStudyCase gridMultiStudyCase = null;	

	public SampleGridGainJob(String model) {
		super(model);
	}
	
    public Serializable execute() {
    	initEMFPackage();

		AclfNetwork net;
		if (((String)ses.getAttribute(IpssMultiStudyCaseGridGainTask.Token_CreationType)).equals("D")) {
			// de-serialize the base network
			AclfNetwork baseNet = (AclfNetwork)SerializeEMFObjectUtil.loadModel((String)ses.getAttribute(IpssMultiStudyCaseGridGainTask.Token_RefNetwork));
			// create a GridMultiStudyCase object with the base object
			GridMultiStudyCase gridMCase = CoreObjectFactory.createGridMultiStudyCase(baseNet);
			gridMCase.setCaseRunner(new SampleGridStudyCaseRunner());
			gridMCase.getGridStudyCaseRunner().setCaseRunner(new Aclf5BusSampleAclfStudyCaseRunner());

			// create base study case
			gridMCase.createBaseCase();
			
			// crate current study case, case number is sent from the GridTask
			int caseNumber = new Integer(getArgument()).intValue();
			StudyCase studyCase = CoreObjectFactory.createStudyCase("StudyCase"+caseNumber, "Case"+caseNumber, caseNumber, gridMCase);
			gridMCase.getNetwork().setSortNumber(caseNumber);
			gridMCase.getGridStudyCaseRunner().generateCaseData(studyCase);
			net = (AclfNetwork)gridMCase.getNetwork();
		}
		else {
			// de-serialized the model to a AclfNetwork object 
			String modelStr = getArgument();
			net = (AclfNetwork)SerializeEMFObjectUtil.loadModel(modelStr);
		}
		 
		// perform loadflow calculation
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		algo.loadflow(SpringAppContext.getIpssMsgHub());
		
		return IpssGridGainUtil.serializeGridAclfResult(nodeId.toString(), net);
    }

}
