package com.interpss.report;

import net.sf.jasperreports.engine.JasperPrint;

public class IpssReportFactory {
	public static final String RPT_TYPE_ACLFSUMMARY  = "AclfSummary";
	public static final String RPT_TYPE_ACLFBUSSTYLE = "AclfBusStyle";
	public static final String RPT_TYPE_ACSCFAULT    = "AcscFault";

	public static JasperPrint createReport(String rptType, String version) {
		if (RPT_TYPE_ACLFSUMMARY.equals(rptType))
			return SpringReportContext.getAclfSummaryReport().createReport(version);
		else if (RPT_TYPE_ACLFBUSSTYLE.equals(rptType))
			return SpringReportContext.getAclfBusStyleReport().createReport(version);
		else if (RPT_TYPE_ACSCFAULT.equals(rptType))
			return SpringReportContext.getAcscFaultReport().createReport(version);
		else
			return null;
	}	
}
