package ipss.custom.exchange.psse;

/*
 * PTI PSS/E File input adapter. The implementation is Based on 
 * PSS/E 29, published Oct 2002.
 * 
 * The following records are implemented
 * 
 * 		Case Identification
		Bus Data
		Gnerator Data
		Nontransformer Branch Data
		Transformer Data
		Area Interchange Data
 */

import java.util.StringTokenizer;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclfadj.AclfAdjNetwork;


public class DCLintDataRecord  {
	/** 
	 * Process DC line record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static void processDCLine(
				AclfAdjNetwork adjNet, 
				String lineStr1,
				String lineStr2,
				String lineStr3,
				int lineNo, 
				IPSSMsgHub msg) throws Exception {
		msg.sendWarnMsg("DC Line record has not been implemented");
		
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
		ALFMAX = new Double(st.nextToken()).doubleValue();
		ALFMN = new Double(st.nextToken()).doubleValue();
		RCR = new Double(st.nextToken()).doubleValue();
		XCR = new Double(st.nextToken()).doubleValue();
		EBASR = new Double(st.nextToken()).doubleValue();
		TRR = new Double(st.nextToken()).doubleValue();
		TAPR = new Double(st.nextToken()).doubleValue();
		TPMXR = new Double(st.nextToken()).doubleValue();
		TPMNR = new Double(st.nextToken()).doubleValue();
		TSTPR = new Double(st.nextToken()).doubleValue();

		IpssLogger.getLogger().info("DC Line data Line3:" + lineNo + "-->" + lineStr3);
	}			
	
	public static void processVscDCLine(
			AclfAdjNetwork adjNet, 
			String lineStr1,
			int lineNo, 
			IPSSMsgHub msg) throws Exception {
		msg.sendWarnMsg("Voltage Source Converter DC Line record has not been implemented");	
	}

	public static void processMultiTerminalDCLine(
			AclfAdjNetwork adjNet, 
			String lineStr1,
			int lineNo, 
			IPSSMsgHub msg) throws Exception {
		msg.sendWarnMsg("Voltage Source Converter DC Line record has not been implemented");	
	}
}