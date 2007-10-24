package org.interpss.core.gridgain.aclf;

import org.interpss.core.ms_case.aclf.AbstractAclfStudyCaseRunner;

import com.interpss.common.datatype.Constants;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.ms_case.StudyCase;

public class Ieee14BusAclfStudyCaseRunner extends AbstractAclfStudyCaseRunner {
	private StudyCase baseCase = null;
	
	public boolean generateCaseData(StudyCase studyCase) {
		if (baseCase == null) {
			baseCase = studyCase.getParent().getStudyCase(Constants.BaseStudyCaseName);
			IpssLogger.getLogger().info("Base Study Case created - " + baseCase.getId());
		}

		int index = studyCase.getCaseNumber()-1;
		// doing nothing
		IpssLogger.getLogger().info("Study Case generted - " + baseCase.getId() + ", # " + index);

		return true;
	}			
}
