 /*
  * @(#)CaseData.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

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