package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;
import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.LineAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.psse.aclf.PSSEAclfLine;
import com.interpss.simu.pssl.IpssAclf;

public class PSSELineDataRec {
	/*
	 * BranchData
	 * I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
	 */
	public int i, j, status;
	private String ckt;
	private double r, x, b, ratea, rateb, ratec, gi, bi, gj, bj, len; 
	private int o1 = 0, o2 = 0, o3 = 0, o4 = 0;
	private double f1 = 0.0, f2 = 0.0, f3 = 0.0, f4 = 0.0;

	public PSSELineDataRec(String lineStr, VersionNo version) {
		StringTokenizer st;
		if (version == VersionNo.Old) {
			// 79831 82157 1 0.000200 0.000500 0.00000 0 0 0 0.0000 0.000
			// 0.0 0.0 0.0 0.0 0 0.000 86 1.00 /* [KENORASP_PS2_1 A ] */
			st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr));
		} else {
			st = new StringTokenizer(lineStr, ",");
		}
		i = new Integer(st.nextToken().trim()).intValue();
		j = new Integer(st.nextToken().trim()).intValue();
		ckt = PSSE2IpssUtilFunc.trimQuote(st.nextToken()).trim();
		r = new Double(st.nextToken().trim()).doubleValue();
		x = new Double(st.nextToken().trim()).doubleValue();
		b = new Double(st.nextToken().trim()).doubleValue();
		ratea = new Double(st.nextToken().trim()).doubleValue();
		rateb = new Double(st.nextToken().trim()).doubleValue();
		ratec = new Double(st.nextToken().trim()).doubleValue();
		gi = new Double(st.nextToken().trim()).doubleValue();
		bi = new Double(st.nextToken().trim()).doubleValue();
		gj = new Double(st.nextToken().trim()).doubleValue();
		bj = new Double(st.nextToken().trim()).doubleValue();
		status = new Integer(st.nextToken().trim()).intValue();
		len = new Double(st.nextToken().trim()).doubleValue();

		if (st.hasMoreTokens())
			o1 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f1 = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			o2 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f2 = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			o3 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f3 = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			o4 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f4 = new Double(st.nextToken().trim()).doubleValue();
	}
	
	/** 
	 * Process branch record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public void processLine(
				AclfAdjNetwork adjNet, 
				IPSSMsgHub msg) throws Exception {
/*
		I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
*/
		boolean fromMetered = true;
		if (this.j < 0) {
			fromMetered = false;
			this.j = -this.j;
		}
    	// create an AclfBranch object
		String iStr = new Integer(this.i).toString();
		String jStr = new Integer(this.j).toString();
      	final PSSEAclfLine bra = ExtensionObjectFactory.createPSSEAclfLine(this.ckt);
      	adjNet.addBranch(bra, iStr, jStr);
      	
      	Complex z = new Complex(this.r,this.x);
      	if (z.abs() > PSSEDataRec.ZeroImpedenc) {
      		IpssAclf.wrapAclfBranch(bra, adjNet)
      					.setStatus(this.status==1)
      					.setBranchCode(AclfBranchCode.LINE)
      					.setZ(z, UnitType.PU)
      					.setShuntY(new Complex(0.0,this.b), UnitType.PU) 
      					.setRatingMva1(this.ratea)
          				.setRatingMva2(this.rateb)
          				.setRatingMva3(this.ratec)
          				.setFromShuntY(new Complex(this.gi,this.bi))
          				.setToShuntY(new Complex(this.gj,this.bj));

      		bra.setFromMetered(fromMetered);
    		bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o1, this.f1));
    		bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o2, this.f2));
    		bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o3, this.f3));
    		bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o4, this.f4));
      	}
      	else {
      		IpssAclf.wrapAclfBranch(bra, adjNet)
						.setStatus(this.status==1)
						.setBranchCode(AclfBranchCode.ZERO_IMPEDENCE)
						.setZ(z, UnitType.PU);
      	}
	}		
	
	public String toString() {
		String str = "";
		str += "From Bus number, To Bus Number, Circuit id:" + i + ", " + j + ", " + ckt + "\n";
		str += "R, X, B:" + r + ", " + x + ", " + b + "\n";
		str += "RATEA, RATEB, RATEC:" + ratea + ", " + rateb + ", " + ratec + "\n";
		str += "GI, BI, GJ, BJ, ST, LEN:" 
				+ gi + ", " + bi + ", " + gj + ", " + bj + ", " + status + ", " + len + "\n";
		str += "O1, F1, O2, F2, O3, F3, O4, F4:" + 
				o1 + ", " + f1 + ", " + o2 + ", " + f2  + ", " + o3 + ", " + f3 + ", " + o4 + ", " + f4 + "\n";
		return str;
	}
}
