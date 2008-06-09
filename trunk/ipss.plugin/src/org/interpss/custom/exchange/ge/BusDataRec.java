package org.interpss.custom.exchange.ge;

import java.util.StringTokenizer;

import com.interpss.common.datatype.Constants;
import com.interpss.ext.ge.aclf.GeAclfBus;

public class BusDataRec extends BusHeaderRec {
			public int ty, owner;
			public String name;
			public double vs_pu, vt_pu, an_deg, vma, vmi;
			public int level, stisol, islnum;
			public double latitude, longitude;

	public BusDataRec(String lineStr, GEDataRec.VersionNo version) {
/*
<number> <"name"> <kV> : <ty> <vs> <vt> <an> <ar> <z> <vma> <vmi> <d_in> <d_out> <projid> <level> <owner> <stisol> <latitude> <longitude> <islnum>
 
bus data  [    5]             ty  vsched   volt     angle   ar zone  vmax   vmin   date_in date_out pid L own
       1 "P-1     " 380.00  :  0 1.04000 1.040000  -5.00000   1  201 4.0000 0.4000   400101   391231   0 0   1
 */
		//System.out.println("bus data(1)->" + lineStr.substring(0, lineStr.indexOf(':')));
		//System.out.println("bus data(2)->" + lineStr.substring(lineStr.indexOf(':')+1));

		String str1 = lineStr.substring(0, lineStr.indexOf(':')),
		       str2 = lineStr.substring(lineStr.indexOf(':')+1);
		
		setHeaderData(str1);
		
		StringTokenizer st = new StringTokenizer(str2);
		if (st.hasMoreElements())
			this.ty = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.vs_pu = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.vt_pu  = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.an_deg  = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.ar = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.z  = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.vma  = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.vmi = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.d_in = st.nextToken();
		if (st.hasMoreElements())
			this.d_out = st.nextToken();
		if (st.hasMoreElements())
			this.projId = st.nextToken();
		if (st.hasMoreElements())
			this.level = new Integer(st.nextToken()).intValue();;
		if (st.hasMoreElements())
			this.owner  = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.stisol  = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.latitude  = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.longitude  = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.islnum  = new Integer(st.nextToken()).intValue();
	}
	
	public void setAclfBus(GeAclfBus bus) {
		bus.setId(new Integer(this.number).toString());
		bus.setName(name);
		bus.setBaseVoltage(bkv*1000.0);
/*
	<ty> Bus type {0,1,2,-2}
		0 = swing bus (voltage magnitude and phase fixed)
		1 = load bus (unconstrained voltage angle and magnitude)
		2 = generator bus (voltage control [terminal or remote] within generator limits)
		-2 = generator bus with unlimited reactive power limits
 */		
		bus.setGeBusType(ty);
		bus.setGeAreaNo(ar);
		bus.setGeZoneNo(z);
		bus.setGeOwnerNo(owner);
		bus.setVoltage(vs_pu, an_deg*Constants.DtoR);
		bus.setVSpecPU(vt_pu);
		bus.setVUpperLimitPU(vma);
		bus.setVLowerLimitPU(vmi);
	}
	
	public String toString() {
		String str = super.toString();
		str += "number, name, ty, ar, z, owner: " + number + ", " + name + ", " + ty + ", " + ar + ", " + z + ", " + owner + "\n";
		str += "base_kV, vs_pu, vt_pu, an_deg, vma, vmi: " + bkv + ", " + vs_pu + ", " + vt_pu + ", " + an_deg + ", " + vma + ", " + vmi + "\n";
		str += "level, stisol, islnum, latitude, longitude: " + level + ", " + stisol + ", " + islnum + ", " + latitude + ", " + longitude + "\n";
		return str;
	}
}
