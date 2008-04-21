package org.interpss.custom.run;

import org.interpss.schema.InterPSSXmlType;

import com.interpss.common.custom.IpssCustomAdapter;
import com.interpss.common.msg.IPSSMsgHub;

public interface ICustomRunScriptPlugin extends IpssCustomAdapter {
	/**
	 * create an InterPSS Xml document for the script running
	 * 
	 * @param scripts run scripts, a string representing an XML document
	 * @param msg Ipss msg object
	 * @return null if there is any error
	 */
	InterPSSXmlType createIpssXmlDocument(String scripts, IPSSMsgHub msg);
}
