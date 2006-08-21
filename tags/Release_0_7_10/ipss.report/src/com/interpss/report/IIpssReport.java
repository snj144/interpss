package com.interpss.report;

import net.sf.jasperreports.engine.JasperPrint;

public interface IIpssReport {
	JasperPrint createReport(String version);
}
