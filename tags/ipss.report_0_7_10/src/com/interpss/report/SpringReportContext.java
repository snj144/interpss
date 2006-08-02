package com.interpss.report;

import com.interpss.common.datatype.Constants;
import com.interpss.common.SpringAppContext;

public class SpringReportContext extends SpringAppContext {
	/**
	 * Get the AclfSummaryReport(singleton) from the SpringReportContext.
	 *  
	 * @return the IIpssReport object
	 */
	public static IIpssReport getAclfSummaryReport() {
		return (IIpssReport)SpringAppCtx.getBean(Constants.SID_AclfSummaryReport);
	}    

	/**
	 * Get the AclfBusStyleReport(singleton) from the SpringReportContext.
	 *  
	 * @return the IIpssReport object
	 */
	public static IIpssReport getAclfBusStyleReport() {
		return (IIpssReport)SpringAppCtx.getBean(Constants.SID_AclfBusStyleReport);
	}    
	
	/**
	 * Get the AcscFaultReport(singleton) from the SpringReportContext.
	 *  
	 * @return the IIpssReport object
	 */
	public static IIpssReport getAcscFaultReport() {
		return (IIpssReport)SpringAppCtx.getBean(Constants.SID_AcscFaultReport);
	} 	
}