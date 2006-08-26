package org.interpss.editor.data.dstab;

import org.interpss.editor.data.acsc.AcscBranchData;

import com.interpss.common.rec.BaseDataBean;

public class DStabBranchData extends BaseDataBean {
	private AcscBranchData acscBranchData = null;
	public AcscBranchData getAcscBranchData() { return acscBranchData; }
	public void setAcscBranchData(AcscBranchData data) { acscBranchData = data; }
}
