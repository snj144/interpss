package org.interpss.editor.data.proj;

/**
	Study case info
*/

import com.interpss.common.rec.IpssDBCase;

public class CaseData extends IpssDBCase {
	// Contants defined in the StudyCaseType table
	public static final String CaseType_Aclf  = "AclfStudyCase";
	public static final String CaseType_Acsc  = "AcscStudyCase";
	public static final String CaseType_DStab = "DStabStudyCase";
	
    public CaseData() {}

	/* case description */
	private String description = "";
	public String getDescription() {return this.description;}
	public void setDescription(String str) {this.description = str;}

	/* case type id */
	private String caseType = "";
	public String getCaseType() {return this.caseType;}
	public void setCaseType(String n) {this.caseType = n;}

	private AclfCaseData aclfCaseData = null;
	public AclfCaseData getAclfCaseData() { return this.aclfCaseData; }
	public void setAclfCaseData(AclfCaseData acase) {this.aclfCaseData = acase;}

	private AcscCaseData acscCaseData = null;
	public AcscCaseData getAcscCaseData() { return this.acscCaseData; }
	public void setAcscCaseData(AcscCaseData acase) {this.acscCaseData = acase;}

	private DStabCaseData dStabCaseData = null;
	public DStabCaseData getDStabCaseData() { return this.dStabCaseData; }
	public void setDStabCaseData(DStabCaseData acase) {this.dStabCaseData = acase;}
}