package com.interpss.editor.data.dstab;

import com.interpss.common.rec.BaseDataBean;
import com.interpss.editor.data.acsc.AcscBranchData;

public class DStabBranchData extends BaseDataBean {
	private AcscBranchData acscBranchData = null;
	public AcscBranchData getAcscBranchData() { return acscBranchData; }
	public void setAcscBranchData(AcscBranchData data) { acscBranchData = data; }
}
