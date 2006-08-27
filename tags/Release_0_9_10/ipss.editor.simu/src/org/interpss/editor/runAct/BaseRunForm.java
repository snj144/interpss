package org.interpss.editor.runAct;

import com.interpss.common.util.XmlUtil;

public class BaseRunForm {
	public BaseRunForm() {}
	
 	public String toString() {
		return XmlUtil.toXmlString(this);
	}   
}