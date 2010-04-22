package org.interpss.vstab;

import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;

public interface SensitiveAnalysis {

	public double getLoadGenSensetive(AclfBus Loadi,AclfBus Genj);
	public double getLoadLineSensetive(AclfBus  Loadi,AclfBranch Linej);
	public double  getBusVQsensetive(AclfBus busi);
}
