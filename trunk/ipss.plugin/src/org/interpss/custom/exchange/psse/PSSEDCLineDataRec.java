package org.interpss.custom.exchange.psse;

import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclfadj.AclfAdjNetwork;

public class PSSEDCLineDataRec {
	public PSSEDCLineDataRec(String lineStr1,
			String lineStr2,
			String lineStr3,
			 VersionNo version ) {
		
		/*  		
  		StringTokenizer st = new StringTokenizer(lineStr1);

		int I  = new Integer(st.nextToken()).intValue();
		int MDC  = new Integer(st.nextToken()).intValue();
		double RDC = new Double(st.nextToken()).doubleValue();
		double SETVL = new Double(st.nextToken()).doubleValue();
		double VSCHD = new Double(st.nextToken()).doubleValue();
		double VCMOD = new Double(st.nextToken()).doubleValue();
		double RCOMP = new Double(st.nextToken()).doubleValue();
		double DELTI = new Double(st.nextToken()).doubleValue();
		String METER = st.nextToken();

		IpssLogger.getLogger().info("DC Line data Line1:" + (lineNo-2) + "-->" + lineStr1);

  		st = new StringTokenizer(lineStr2);
  		int IPR = new Integer(st.nextToken()).intValue();
		int NBR = new Integer(st.nextToken()).intValue();
		double ALFMAX = new Double(st.nextToken()).doubleValue();
		double ALFMN = new Double(st.nextToken()).doubleValue();
		double RCR = new Double(st.nextToken()).doubleValue();
		double XCR = new Double(st.nextToken()).doubleValue();
		double EBASR = new Double(st.nextToken()).doubleValue();
		double TRR = new Double(st.nextToken()).doubleValue();
		double TAPR = new Double(st.nextToken()).doubleValue();
		double TPMXR = new Double(st.nextToken()).doubleValue();
		double TPMNR = new Double(st.nextToken()).doubleValue();
		double TSTPR = new Double(st.nextToken()).doubleValue();

		IpssLogger.getLogger().info("DC Line data Line2:" + (lineNo-1) + "-->" + lineStr2);

  		st = new StringTokenizer(lineStr3);
		IPR = new Integer(st.nextToken()).intValue();
		NBR = new Integer(st.nextToken()).intValue();
		double ALFMAX = new Double(st.nextToken()).doubleValue();
		double ALFMN = new Double(st.nextToken()).doubleValue();
		double RCR = new Double(st.nextToken()).doubleValue();
		double XCR = new Double(st.nextToken()).doubleValue();
		double EBASR = new Double(st.nextToken()).doubleValue();
		double TRR = new Double(st.nextToken()).doubleValue();
		double TAPR = new Double(st.nextToken()).doubleValue();
		double TPMXR = new Double(st.nextToken()).doubleValue();
		double TPMNR = new Double(st.nextToken()).doubleValue();
		double TSTPR = new Double(st.nextToken()).doubleValue();

		IpssLogger.getLogger().info("DC Line data Line3:" + lineNo + "-->" + lineStr3);
*/		
		
	}
	
	public void processDCLine(
			AclfAdjNetwork adjNet, 
			IPSSMsgHub msg) throws Exception {
		msg.sendWarnMsg("Voltage Source Converter DC Line record has not been implemented");	
	}	
}
