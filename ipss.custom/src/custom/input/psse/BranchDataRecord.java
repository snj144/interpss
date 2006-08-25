package custom.input.psse;

import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfBranchExt;
import com.interpss.core.aclf.LineAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;

public class BranchDataRecord {
	/** 
	 * Process branch record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static void processLine(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msg) throws Exception {
/*
		I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
*/
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
		int I  = new Integer(st.nextToken().trim()).intValue();
		int J  = new Integer(st.nextToken().trim()).intValue();
		String CKT  = PSSEUtilFunc.trimQuote(st.nextToken());
		double R = new Double(st.nextToken().trim()).doubleValue();
		double X = new Double(st.nextToken().trim()).doubleValue();
		double B = new Double(st.nextToken().trim()).doubleValue();
		double RATEA = new Double(st.nextToken().trim()).doubleValue();
		double RATEB = new Double(st.nextToken().trim()).doubleValue();
		double RATEC = new Double(st.nextToken().trim()).doubleValue();
		double GI = new Double(st.nextToken().trim()).doubleValue();
		double BI = new Double(st.nextToken().trim()).doubleValue();
		double GJ = new Double(st.nextToken().trim()).doubleValue();
		double BJ = new Double(st.nextToken().trim()).doubleValue();
		int ST  = new Integer(st.nextToken().trim()).intValue();
		double LEN = new Double(st.nextToken().trim()).doubleValue();

		int    O1 = 0, O2 = 0, O3 = 0, O4 = 0;
		double F1 = 0.0, F2 = 0.0, F3 = 0.0, F4 = 0.0;

		if (st.hasMoreTokens()) {
			O1 = new Integer(st.nextToken().trim()).intValue();
			F1 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O2 = new Integer(st.nextToken().trim()).intValue();
			F2 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O3 = new Integer(st.nextToken().trim()).intValue();
			F3 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O4 = new Integer(st.nextToken().trim()).intValue();
			F4 = new Double(st.nextToken().trim()).doubleValue();
		}		
		IpssLogger.getLogger().info("Branch data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().info("From Bus number, To Bus Number, Circuit id:" + I + ", " + J + ", " + CKT);
		IpssLogger.getLogger().info("R, X, B:" + R + ", " + X + ", " + B);
		IpssLogger.getLogger().info("RATEA, RATEB, RATEC:" + RATEA + ", " + RATEB + ", " + RATEC);
		IpssLogger.getLogger().info("GI, BI, GJ, BJ, ST, LEN:" + GI + ", " + BI + ", " + GJ + ", " + BJ + ", " + ST+ ", " + LEN);
		IpssLogger.getLogger().info("O1, F1, O2, F2, O3, F3, O4, F4:" + O1 + ", " + F1 + ", " + O2 + ", " + F2  + ", " + O3 + ", " + F3 + ", " + O4 + ", " + F4);
		
		boolean fromMetered = true;
		if (J < 0) {
			fromMetered = false;
			J = -J;
		}
    	// create an AclfBranch object
		// also we need to use AclfBranchExt to hold the extra rating fields
      	final AclfBranchExt bra = CoreObjectFactory.createAclfBranchExt(CKT, adjNet);
      	bra.setStatus(ST==1);
      	bra.setRatingMva1(RATEA);
      	bra.setRatingMva2(RATEA);
      	bra.setRatingMva3(RATEB);
      	bra.setFromShuntY(new Complex(GI,BI));
      	bra.setToShuntY(new Complex(GJ,BJ));
      	
      	// add the object into the network container
      	if (J < 0) {
      		// do something???? 
      		J = -J;
      	}
      	adjNet.addBranch(bra, new Integer(I).toString(), new Integer(J).toString());
      	
       	bra.setBranchCode(AclfBranchCode.LINE_LITERAL);
   		final LineAdapter line = (LineAdapter)bra.adapt(LineAdapter.class);
       	line.getAclfBranch().setZ(new Complex(R,X), msg);
       	// Unit is PU, no need to enter baseV
       	line.setHShuntY(new Complex(0.0,0.5*B), UnitType.PU, 1.0, adjNet.getBaseKva()); 
	}			

	/** 
	 * Process xformer adjustment record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static void processXfr(
				AclfAdjNetwork adjNet, 
				String lineStr,
				String lineStr2,
				String lineStr3,
				String lineStr4,
				String lineStr5,
				int lineNo, 
				IPSSMsgHub msgHub) throws Exception {
/*
	Three-winding:
	I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
	R1-2,X1-2,SBASE1-2,R2-3,X2-3,SBASE2-3,R3-1,X3-1,SBASE3-1,VMSTAR,ANSTAR
	WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
	WINDV2,NOMV2,ANG2,RATA2,RATB2,RATC2
	WINDV3,NOMV3,ANG3,RATA3,RATB3,RATC3

	Two-winding:
	I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
	R1-2,X1-2,SBASE1-2
	WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
	WINDV2,NOMV2
*/
  		StringTokenizer st = new StringTokenizer(lineStr, ",");

		int I = new Integer(st.nextToken().trim()).intValue();
		int J = new Integer(st.nextToken().trim()).intValue();
		int K = new Integer(st.nextToken().trim()).intValue();
		String CKT  = PSSEUtilFunc.trimQuote(st.nextToken());
		int CW = new Integer(st.nextToken().trim()).intValue();
		int CZ = new Integer(st.nextToken().trim()).intValue();
		int CM = new Integer(st.nextToken().trim()).intValue();
		double MAG1 = new Double(st.nextToken()).doubleValue();
		double MAG2 = new Double(st.nextToken()).doubleValue();
		int NMETR = new Integer(st.nextToken().trim()).intValue();
		String NAME = PSSEUtilFunc.trimQuote(st.nextToken());
		int STAT = new Integer(st.nextToken().trim()).intValue();

		int    O1 = 0, O2 = 0, O3 = 0, O4 = 0;
		double F1 = 0.0, F2 = 0.0, F3 = 0.0, F4 = 0.0;

		if (st.hasMoreTokens()) {
			O1 = new Integer(st.nextToken().trim()).intValue();
			F1 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O2 = new Integer(st.nextToken().trim()).intValue();
			F2 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O3 = new Integer(st.nextToken().trim()).intValue();
			F3 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O4 = new Integer(st.nextToken().trim()).intValue();
			F4 = new Double(st.nextToken().trim()).doubleValue();
		}
		
		IpssLogger.getLogger().info("Xfr data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().info("I, J, K, Circuit id:" + I + ", " + J + ", "  + K + ", " + CKT);
		IpssLogger.getLogger().info("CW, CZ, CM, MAG1, MAG2, NMETR, NAME, STAT:" + CW + ", " + CZ + ", " 
				+ CM + ", " + MAG1 + ", " + MAG2 + ", " + NMETR + ", " + NAME + ", " + STAT);
		IpssLogger.getLogger().info("O1, F1, O2, F2, O3, F3, O4, F4:" + O1 + ", " + F1 + ", " + O2 + ", " + F2  + ", " + O3 + ", " + F3 + ", " + O4 + ", " + F4);
		
		if (!PSSEUtilFunc.is3WXfr(lineStr2)) {
			
		}
		else {
			
		}
	}			
}