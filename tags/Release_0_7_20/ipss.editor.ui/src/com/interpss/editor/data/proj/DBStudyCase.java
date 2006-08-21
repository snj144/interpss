package com.interpss.editor.data.proj;

import com.interpss.common.util.XmlUtil;

/**
	For persisting CaseData to the StudyCase table
*/

public class DBStudyCase {
	private int caseId = 0;
	private int projDbId = 0;
	private String caseName = "";
	private String caseType = "";
	private String dataXmlString = "";
	
    public DBStudyCase() {}

	/**
	 * @return the caseId
	 */
	public int getCaseId() {
		return caseId;
	}

	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}


	/**
	 * @return the projDbId
	 */
	public int getProjDbId() {
		return projDbId;
	}

	/**
	 * @param projDbId the projDbId to set
	 */
	public void setProjDbId(int projDbId) {
		this.projDbId = projDbId;
	}
	
	/**
	 * @return the caseType
	 */
	public String getCaseName() {
		return caseName;
	}

	/**
	 * @param caseType the caseType to set
	 */
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	
	/**
	 * @return the caseType
	 */
	public String getCaseType() {
		return caseType;
	}

	/**
	 * @param caseType the caseType to set
	 */
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	/**
	 * @return the dataXmlString
	 */
	public String getDataXmlString() {
		return dataXmlString;
	}

	/**
	 * @param dataXmlString the dataXmlString to set
	 */
	public void setDataXmlString(String dataXmlString) {
		this.dataXmlString = dataXmlString;
	}

	public static DBStudyCase createDBStudyCase(CaseData data) {
		DBStudyCase c = new DBStudyCase();
		c.setCaseId(data.getCaseDbId());
		c.setProjDbId(data.getProjDbId());
		c.setCaseName(data.getCaseName());
		c.setCaseType(data.getCaseType());
		c.setDataXmlString(data.toString());
		return c; 
	}
	
	public CaseData getCaseData() {
		CaseData aCase = (CaseData)XmlUtil.toObject(this.dataXmlString, CaseData.class);
		// case db id may be changed
		aCase.setCaseDbId(getCaseId());
		return aCase;
	}
}