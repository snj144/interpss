package org.interpss.custom.run;

import org.interpss.schema.InterPSSXmlType;
import org.interpss.schema.RunStudyCaseXmlType.AnalysisRunType.Enum;

import com.interpss.common.msg.IPSSMsgHub;

public abstract class CustomRunScriptPluginBase implements ICustomRunScriptPlugin {
	@Override
	public InterPSSXmlType createIpssXmlDocument(Enum type, String scripts, IPSSMsgHub msg) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InterPSSXmlType createIpssXmlDocument(String scripts, IPSSMsgHub msg) {
		throw new UnsupportedOperationException();
	}

	private String name;
	private String desc;
	
	@Override
	public String getDescription() {
		return this.desc;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void setDescription(String s) {
		this.desc = s;
	}

	public void setName(String s) {
		this.name = s;
	}
}
