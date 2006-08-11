package com.interpss.report;

import net.sf.jasperreports.engine.JasperPrint;

public class IpssReportFactory {
	public static final String RPT_TYPE_ACLFSUMMARY  = "AclfSummary";
	public static final String RPT_TYPE_ACLFBUSSTYLE = "AclfBusStyle";
	public static final String RPT_TYPE_ACSC3PFAULT    = "Acsc3PFault";
	public static final String RPT_TYPE_ACSCNSFAULT    = "AcscNSFault";

	public static JasperPrint createReport(String rptType, String version) {
		if (RPT_TYPE_ACLFSUMMARY.equals(rptType))
			return SpringReportContext.getAclfSummaryReport().createReport(version);
		else if (RPT_TYPE_ACLFBUSSTYLE.equals(rptType))
			return SpringReportContext.getAclfBusStyleReport().createReport(version);
		else if (RPT_TYPE_ACSC3PFAULT.equals(rptType))
			return SpringReportContext.getAcsc3PFaultReport().createReport(version);
		else
			return null;
	}	
}
