package org.interpss.custom.exchange.ge;

import java.util.StringTokenizer;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.ge.aclf.GeAclfBus;
import com.interpss.ext.ge.aclf.GeAclfNetwork;
import com.interpss.ext.ge.aclf.GeLoad;

public class LoadDataRec extends BaseBusDataRec {
	public int st, nst, owner;
	public double p, q, ip, iq, g, b;
			
	public LoadDataRec(String lineStr, GEDataRec.VersionNo version) {
		//System.out.println("load data->" + lineStr);
/*
	<bus> <"name"> <bkv> <"id"> <"long id"> : <st> <p> <q> <ip> <iq> <g> <b> /
	<ar> <z> <d_in> <d_out> <proj id> <nst> <owner>

       2 "P-2     " 380.00 "1 " "        "  :  1  868.096    0.000    0.000    0.000    0.000    0.000   1  201   400101   391231   0 0   1
 */		
		String str1 = lineStr.substring(0, lineStr.indexOf(':')),
        	   str2 = lineStr.substring(lineStr.indexOf(':')+1);

		setHeaderData(str1);
		
		StringTokenizer st = new StringTokenizer(str2);
		if (st.hasMoreElements())
			this.st = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreElements())
			this.p = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.q = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.ip = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.iq = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.g = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.b = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.ar = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.z = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.d_in = st.nextToken();
		if (st.hasMoreElements())
			this.d_out = st.nextToken();
		if (st.hasMoreElements())
			this.projId = st.nextToken();
		if (st.hasMoreElements())
			this.nst = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.owner = new Integer(st.nextToken()).intValue();
	}
	
	public void setLoad(GeAclfNetwork net, IPSSMsgHub msg) throws Exception {
		String id = new Integer(this.number).toString();
		GeAclfBus  bus = (GeAclfBus)net.getBus(id);
		if (bus == null) {
			msg.sendErrorMsg("Bus cannot be found, bus number: " + id);
			throw new Exception("Bus cannot be found");
		}
		
		GeLoad load = ExtensionObjectFactory.createGeLoad(id, longId);
		bus.getLoadList().add(load);
		load.setGeAreaNo(this.ar);
		load.setGeZoneNo(this.z);
		load.setOwner(this.owner);
		// <st> Load status 1 =	in service; 0 =	out of service
		load.setInSevice(this.st == 1);
		// <nst> Normal load status 1=in service; 0=out of service
		load.setNormalInService(this.nst == 1);
		load.setIp(this.ip);
		load.setIq(this.iq);
		load.setP(this.p);
		load.setQ(this.q);
		load.setB(this.b);
		load.setG(this.g);
		/*
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
*/		
	}
		
	public String toString() {
		String str = super.toString();
		str += "st, nst, owner, d_in, d_out, proj id: " + st + ", " + nst + ", " + owner + ", " + d_in + ", " + d_out + ", " + projId + "\n";
		str += "p, q, ip, iq, g, b: " + p + ", " + q + ", " + ip + ", " + iq + ", " + g + ", " + b + "\n";
		return str;
	}
	
}
