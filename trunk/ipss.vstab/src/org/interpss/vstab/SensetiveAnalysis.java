package org.interpss.vstab;

import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;

public interface SensetiveAnalysis {

	public double loadGenSensetive(AclfBus Loadi,AclfBus Genj);
	public double loadLineSensetive(AclfBus  Loadi,AclfBranch Linej);
	public double busVQsensetive(AclfBus busi);
}
