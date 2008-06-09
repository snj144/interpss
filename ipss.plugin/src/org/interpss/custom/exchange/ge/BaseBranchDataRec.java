package org.interpss.custom.exchange.ge;

import java.util.StringTokenizer;

import com.interpss.ext.ge.aclf.GeBaseBranch;

public class BaseBranchDataRec extends BranchHeaderRec {
	public int st, ar, z, nst, ohms;
	public String d_in, d_out, /* yymmdd */ projid;
	public double[] r_mvaAry = new double[8];
	public int[] oAry = new int[8];
	public double[] pAry = new double[8];

	public void setRMvaAry1_4(StringTokenizer st) {
		if (st.hasMoreElements())
			this.r_mvaAry[0] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.r_mvaAry[1] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.r_mvaAry[2] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.r_mvaAry[3] = new Double(st.nextToken()).doubleValue();
	}

	public void setDates(StringTokenizer st) {
		if (st.hasMoreElements())
			this.d_in = st.nextToken();
		if (st.hasMoreElements())
			this.d_out = st.nextToken();
		if (st.hasMoreElements())
			this.projid = st.nextToken();
	}

	public void setRMvaAry5_8(StringTokenizer st) {
		if (st.hasMoreElements())
			this.r_mvaAry[4] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.r_mvaAry[5] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.r_mvaAry[6] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.r_mvaAry[7] = new Double(st.nextToken()).doubleValue();
	}
		
	public void setOwnerAry(StringTokenizer st) {
		if (st.hasMoreElements())
			this.oAry[0] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.pAry[0] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.oAry[1] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.pAry[1] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.oAry[2] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.pAry[2] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.oAry[3] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.pAry[3] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.oAry[4] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.pAry[4] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.oAry[5] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.pAry[5] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.oAry[6] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.pAry[6] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.oAry[7] = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.pAry[7] = new Double(st.nextToken()).doubleValue();
	}
	
	public void setBaseBranchData(GeBaseBranch bra) {
		bra.setInSevice(this.st == 1);
		bra.setNormalInService(this.nst == 1);
		bra.setGeAreaNo(this.ar);
		bra.setGeZoneNo(this.z);
		bra.setOhmicUnit(this.ohms == 1);
		for (int i = 0; i < 8; i++) {
			bra.getMvaRatingAry().add(i, r_mvaAry[i]);
			bra.getOwnerNumberAry().add(i, oAry[i]);
			bra.getPartiFactorAry().add(i, pAry[i]);
		}		
	}
	
	public String toString() {
		String str = super.toString();
		str += "st, ar, z, nst, ohms: " + st + ar + ", " + z + ", " + nst + ", " + ohms + "\n";
		str += "r1_mva, r2_mva, r3_mva, r4_mva, r5_mva, r6_mva, r7_mva, r8_mva: " + r_mvaAry[0] + ", " + r_mvaAry[1] + ", " + 
		                r_mvaAry[2] + ", " + r_mvaAry[3] + ", " + r_mvaAry[4] + ", " + r_mvaAry[5] + ", " + r_mvaAry[6] + ", " + r_mvaAry[7] + "\n";
		str += "d_in, d_out, projid: " + d_in + ", " + d_out + ", " + projid + "\n";
		str += "o1, o2, o3, o4, o5, o6, o7, o8: " + oAry[0] + ", " + oAry[1] + ", " + oAry[2] + ", " + 
						oAry[3] + ", " + oAry[4] + ", " + oAry[5] + ", " + oAry[6] + ", " + oAry[7] + "\n";
		str += "p1, p2, p3, p4, p5, p6, p7, p8: " + pAry[0] + ", " + pAry[1] + ", " + pAry[2] + ", " + pAry[3] + ", " + 
						pAry[4] + ", " + pAry[5] + ", " + pAry[6] + ", " + pAry[7] + "\n";
		return str;
	}	
}
