package org.interpss.report.bean;

import com.interpss.common.util.XmlUtil;

public class RptBaseBean {
	public RptBaseBean() {
	}
	
    public String toString() {
		return XmlUtil.toXmlString(this);
	}	
}
