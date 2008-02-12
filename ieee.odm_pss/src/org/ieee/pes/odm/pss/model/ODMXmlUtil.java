package org.ieee.pes.odm.pss.model;

import org.ieee.cmte.psace.oss.odm.pss.schema.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.NameValuePairXmlType;

public class ODMXmlUtil {
	public static void addNVPair(NameValuePairListXmlType nvList, String name, String value) {
    	NameValuePairXmlType nvPair = nvList.addNewNvPair();
    	nvPair.setName(name);
    	nvPair.setValue(value);
	}

	public static String formBranchId(String fromId, String toId, String cirId) {
		return fromId + "_" + toId + "_" + cirId;
	}
}
