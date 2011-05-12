package org.interpss.core.gridgain;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridFactory;
import org.interpss.core.grid.gridgain.IpssGridGainUtil;
import org.interpss.core.ms_case.aclf.AclfStudyCaseUtilFunc;

import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.ms_case.GridMultiStudyCase;
import com.interpss.core.ms_case.StudyCase;
import com.interpss.core.ms_case.StudyCaseCreationType;
import com.interpss.core.ms_case.impl.AbstractGridStudyCaseRunner;
import com.interpss.core.ms_case.result.AclfNetworkResult;

public class SampleGridStudyCaseRunner extends AbstractGridStudyCaseRunner {
	@Override
	public boolean gridRunCase() {
		try {
			// get the containing GridMultiStudyCase object
			GridMultiStudyCase gridMCase = (GridMultiStudyCase)this.eContainer;
	       	GridFactory.start();
        	Object[] results;
	        try {
	        	Grid grid = GridFactory.getGrid();
	        	results = (Object[])IpssGridGainUtil.performGridTask(grid, "Test Custom IpssGrid Task impl ", gridMCase, 0);
	        }
	        finally {
	        	GridFactory.stop(true);
	        }

			boolean converged = true;
			for (Object obj : results) {
				String modelStr = (String)obj;
				//System.out.println((String)obj);
				AclfNetworkResult rnet = (AclfNetworkResult)SerializeEMFObjectUtil.loadModel(modelStr);

				// transfer result to StudyCase, use case number for object correlation
				int caseNumber = rnet.getCaseNumber();
				StudyCase studyCase;
				if (gridMCase.getCaseCreationType() == StudyCaseCreationType.MASTER_NODE_CREATION)
					studyCase = gridMCase.getStudyCase(caseNumber);
				else
					// in the case of distributed
					studyCase = CoreObjectFactory.createStudyCase("StudyCase"+caseNumber, "Case"+caseNumber, caseNumber, gridMCase);
					
				// reference relationship between AclfNetwork and AclfNetworkResult will also build
				AclfStudyCaseUtilFunc.setAclfNetResult2StudyCase(studyCase, rnet);

				if (!rnet.isLfConverged())
					converged = false;
			}
			return converged;
		} catch (Exception e) {
			IpssLogger.getLogger().severe(e.toString());
			return false;
		}
	}
}