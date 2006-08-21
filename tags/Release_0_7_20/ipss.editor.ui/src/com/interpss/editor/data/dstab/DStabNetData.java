package com.interpss.editor.data.dstab;

import com.interpss.common.rec.BaseDataBean;
import com.interpss.editor.data.acsc.AcscNetData;

public class DStabNetData extends BaseDataBean{
	private AcscNetData acscNetData = null;
	public AcscNetData getAcscNetData() { return acscNetData; }
	public void setAcscNetData(AcscNetData data) { acscNetData = data; }
}
