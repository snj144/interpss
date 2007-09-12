package org.interpss.core.ms_case;

import org.interpss.core.ms_case.aclf.AbstractAclfStudyCaseRunner;
import org.interpss.core.ms_case.aclf.AclfStudyCaseUtilFunc;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.ms_case.StudyCase;
import com.interpss.core.ms_case.result.AclfBusResult;

public class TestAclfStudyCaseRunner extends AbstractAclfStudyCaseRunner {
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
		try {
			int index = studyCase.getCaseNumber()-1;
			
			String busId = "1";
			AclfBusResult r = (AclfBusResult)baseCase.getBusResult(busId);
			AclfStudyCaseUtilFunc.increaseBusLoad(r, pFactorList[index], qFactorList[index]);
			IpssLogger.getLogger().info("Study Case generted - " + baseCase.getId() + ", # " + studyCase.getCaseNumber());
		} catch (InterpssException e) {
			SpringAppContext.getIpssMsgHub().sendErrorMsg(e.toString());
			return false;
		}
		return true;
	}			
}
