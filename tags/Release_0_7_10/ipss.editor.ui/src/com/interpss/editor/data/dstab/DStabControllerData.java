package com.interpss.editor.data.dstab;

import com.interpss.common.rec.BaseDataBean;

public class DStabControllerData extends BaseDataBean {
	private String typeName = "";
	private String className = "";   // this property is not used anymore	
	private String dataXmlStr = "";

	/**
	 * @return Returns the dataXmlStr.
	 */
	public String getDataXmlStr() {
		return dataXmlStr;
	}
	/**
	 * @param dataXmlStr The dataXmlStr to set.
	 */
	public void setDataXmlStr(String dataXmlStr) {
		this.dataXmlStr = dataXmlStr;
	}
	/**
	 * @return Returns the typeName.
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * @param typeName The typeName to set.
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * @return Returns the className.
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * @param className The className to set.
	 */
	public void setClassName(String className) {
		this.className = className;
	}
}
