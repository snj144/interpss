package org.interpss.custom.run;

public abstract class CustomRunScriptPluginBase implements ICustomRunScriptPlugin {
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
