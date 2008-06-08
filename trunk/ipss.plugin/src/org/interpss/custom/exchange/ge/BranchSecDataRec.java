package org.interpss.custom.exchange.ge;

import java.util.StringTokenizer;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.ge.aclf.GeAclfBranch;
import com.interpss.ext.ge.aclf.GeAclfNetwork;
import com.interpss.ext.ge.aclf.GeBranchSection;


public class BranchSecDataRec extends BaseBranchDataRec {
	public int st;
	public double r, x, b;
	public double[] r_mvaAry = new double[8];
	public double al, l_info, gi, tf, tt;
	public int ar, z, nst, type, ohms;   //Type of line 0=normal line
	public String d_in, d_out, /* yymmdd */ projid;
	public int[] oAry = new int[8];
	public double[] pAry = new double[8];

	/*
<f bus> <"f name"> <f bkv> <t bus> <"t name"> <t bkv> <"ck"> <sec> <"long id">: <st> <r> <x> <b> <r1> <r2> <r3> <r4> <al> <l> <ar> <z> <gi> <tf> <tt> /
<d_in> <d_out> <proj id> <nst> <type> <r5> <r6> <r7> <r8> <o1> <p1> <o2> <p2> <o3> <p3> <o4> <p4> <o5> <p5> <o6> <p6> <o7> <p7> <o8> <p8> <ohms>
	 
      1 "P-1     " 380.00       2 "P-2     " 380.00 "1 "  1 "        " :  1 0.00000 0.02348 0.00000    0.0    0.0    0.0    0.0 1.000    1.0 /
  1 201 0.0000 0.000 1.000   400101   391231   0 1  0    0.0    0.0    0.0    0.0   1 1.000   0 1.000   0 1.000   0 1.000   0 0.000   0 0.000   0 0.000   0 0.000  0
	 */
	public BranchSecDataRec(String lineStr, GEDataRec.VersionNo version) {
		//System.out.println("branch sec->" + lineStr);

		String str1 = lineStr.substring(0, lineStr.indexOf(':')),
	           str2 = lineStr.substring(lineStr.indexOf(':')+1);
		
		this.setHeaderData(str1);
			
		StringTokenizer st = new StringTokenizer(str2);
		if (st.hasMoreElements())
			this.st = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.r = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.x = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.b = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.r_mvaAry[0] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.r_mvaAry[1] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.r_mvaAry[2] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.r_mvaAry[3] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.al = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.l_info = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.ar = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.z = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.gi = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.tf = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.tt = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.d_in = st.nextToken();
		if (st.hasMoreElements())
			this.d_out = st.nextToken();
		if (st.hasMoreElements())
			this.projid = st.nextToken();
		if (st.hasMoreElements())
			this.nst = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.type = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.r_mvaAry[4] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.r_mvaAry[5] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.r_mvaAry[6] = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.r_mvaAry[7] = new Double(st.nextToken()).doubleValue();
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
		if (st.hasMoreElements())
			this.ohms =	new Integer(st.nextToken()).intValue();	
	}
	
	public void setBranchSection(GeAclfNetwork net, IPSSMsgHub msg) throws Exception {
		GeAclfBranch  branch = null;
		if (this.sec == 1) {
			// first section
			branch = ExtensionObjectFactory.createGeAclfBranch();
			net.addBranch(branch, new Integer(this.f_bus).toString(), new Integer(this.t_bus).toString(), this.ck);
		}
		else {
			branch = (GeAclfBranch)net.getBranch(new Integer(this.f_bus).toString(), new Integer(this.t_bus).toString(), this.ck);
			if (branch == null) {
				msg.sendErrorMsg("Branch section data error, branch cannot be found, fromBus, toBus: " + f_bus + ", " + t_bus);
				throw new Exception("Branch cannot be found");
			}
		}
		
		GeBranchSection braSec = ExtensionObjectFactory.createGeBranchSection();
		braSec.setInSevice(this.st == 1);
		braSec.setNormalInService(this.nst == 1);
		braSec.setGeAreaNo(this.ar);
		braSec.setGeZoneNo(this.z);
		braSec.setOhmicUnit(this.ohms == 1);
		braSec.setType(this.type);
		braSec.setR(this.r);
		braSec.setX(this.x);
		braSec.setB(this.b);
		braSec.setLossFactor(this.al);
		braSec.setGi(this.gi);
		braSec.setFromTap(this.tf);
		braSec.setToTap(this.tt);
		for (int i = 0; i < 8; i++) {
			braSec.getMvaRatingAry().add(i, r_mvaAry[i]);
			braSec.getOwnerNumberAry().add(i, oAry[i]);
			braSec.getPartiFactorAry().add(i, pAry[i]);
		}
	}
	
	public String toString() {
		String str = super.toString();
		str += "st, r, x, b: " + st + ", " + r + ", " + x + ", " + b + "\n";
		str += "r1_mva, r2_mva, r3_mva, r4_mva, r5_mva, r6_mva, r7_mva, r8_mva: " + r_mvaAry[0] + ", " + r_mvaAry[1] + ", " + 
		                r_mvaAry[2] + ", " + r_mvaAry[3] + ", " + r_mvaAry[4] + ", " + r_mvaAry[5] + ", " + r_mvaAry[6] + ", " + r_mvaAry[7] + "\n";
		str += "al, l_info, gi, tf, tt: " + al + ", " + l_info + ", " + gi + ", " + tf + ", " + tt + "\n";
		str += "ar, z, nst, type, ohms: " + ar + ", " + z + ", " + nst + ", " + type + ", " + ohms + "\n";
		str += "d_in, d_out, projid: " + d_in + ", " + d_out + ", " + projid + "\n";
		str += "o1, o2, o3, o4, o5, o6, o7, o8: " + oAry[0] + ", " + oAry[1] + ", " + oAry[2] + ", " + 
						oAry[3] + ", " + oAry[4] + ", " + oAry[5] + ", " + oAry[6] + ", " + oAry[7] + "\n";
		str += "p1, p2, p3, p4, p5, p6, p7, p8: " + pAry[0] + ", " + pAry[1] + ", " + pAry[2] + ", " + pAry[3] + ", " + 
						pAry[4] + ", " + pAry[5] + ", " + pAry[6] + ", " + pAry[7] + "\n";
		return str;
	}	
}
