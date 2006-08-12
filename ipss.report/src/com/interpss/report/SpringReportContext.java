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
	 * Get the Acsc3PFaultReport(singleton) from the SpringReportContext.
	 *  
	 * @return the IIpssReport object
	 */
	public static IIpssReport getAcsc3PFaultReport() {
		return (IIpssReport)SpringAppCtx.getBean(Constants.SID_Acsc3PFaultReport);
	} 	

	/**
	 * Get the Acsc3PFaultReport(singleton) from the SpringReportContext.
	 *  
	 * @return the IIpssReport object
	 */
	public static IIpssReport getAcscNSFaultReport() {
		return (IIpssReport)SpringAppCtx.getBean(Constants.SID_AcscNSFaultReport);
	} 	
}