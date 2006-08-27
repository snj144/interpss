package org.interpss.editor.data.dstab;

import org.interpss.editor.data.acsc.AcscNetData;

import com.interpss.common.rec.BaseDataBean;

public class DStabNetData extends BaseDataBean{
	private AcscNetData acscNetData = null;
	public AcscNetData getAcscNetData() { return acscNetData; }
	public void setAcscNetData(AcscNetData data) { acscNetData = data; }
}
