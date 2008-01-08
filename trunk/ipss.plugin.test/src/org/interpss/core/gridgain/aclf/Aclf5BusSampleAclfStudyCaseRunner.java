package org.interpss.core.gridgain.aclf;

import org.interpss.core.ms_case.aclf.AbstractAclfStudyCaseRunner;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.ms_case.StudyCase;

public class Aclf5BusSampleAclfStudyCaseRunner extends AbstractAclfStudyCaseRunner {
	private double[] pFactorList = {
			0.3, 0.3, 0.3, 0.3, 1.0, 1.0,
			1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
			1.0, 1.0, 1.4, 1.3, 1.3, 1.0,
			1.0, 1.0, 0.2, 0.2, 0.2, 0.1
			};
	private double[] qFactorList = {
			0.2, 0.2, 0.2, 0.2, 0.3, 1.0,
			1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
			1.0, 1.0, 1.0, 1.2, 1.2, 1.2,
			1.0, 1.0, 1.0, 0.1, 0.1, 0.1
			};
	private StudyCase baseCase = null;
	
	public boolean generateCaseData(StudyCase studyCase) {
		if (baseCase == null) {
			baseCase = studyCase.getParent().getStudyCase(Constants.BaseStudyCaseName);
			IpssLogger.getLogger().info("Base Study Case created - " + baseCase.getId());
		}
			int index = studyCase.getCaseNumber()-1;
			
		String busId = "1";
		IpssLogger.getLogger().info("Study Case generted - " + baseCase.getId() + ", # " + studyCase.getCaseNumber());
		return true;
	}			
}
