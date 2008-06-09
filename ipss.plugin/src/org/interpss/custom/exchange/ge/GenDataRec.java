package org.interpss.custom.exchange.ge;

import java.util.StringTokenizer;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.ge.aclf.GeAclfBus;
import com.interpss.ext.ge.aclf.GeAclfNetwork;
import com.interpss.ext.ge.aclf.GeGenerator;

public class GenDataRec extends BusHeaderRec {
	public int st, igregBus, nst; 
	public String igregName, hName, tName;
	public double igregBkv, prf, qrf, pgen, pmax, pmin, qgen, qmax, qmin;
	public double mbase, rcomp, xcomp, zgenr, zgenx, hBus, hBkv, tBus;
	public int tBkv, rtr, xtr, gtap;
	public int o1, p1, o2, p2, o3, p3, o4, p4, o5, p5, o6, p6, o7, p7, o8, p8;
	public int govFlag, agcFlag, dispatchFlag, baseloadFlag, airTemp, turbineType, qtab, pmax2;

	public GenDataRec(String lineStr, GEDataRec.VersionNo version) {
		//System.out.println("gen data->" + lineStr);
/*
   <bus> <"name"> <bkv> <"id"> <"long id"> : <st> <igreg bus> <"igreg name"> /
   <igreg bkv> <prf> <qrf> <ar> <z> <pgen> <pmax> <pmin> <qgen> <qmax> <qmin> /
   <mbase> <rcomp> <xcomp> <zgenr> <zgenx> <h bus> <"h name"> <h bkv> <t bus> /
   <"t name"> <t bkv> <d_in> <d_out> <projid> <snt> <rtr> <xtr> <gtap> /
   <o1> <p1> <o2> <p2> <o3> <p3> <o4> <p4> <o5> <p5> <o6> <p6> <o7> <p7> <o8> <p8> 
   <gov_flag> <agc_flag> <dispatch_flag> <baseload_flag> <air_temp> / <turbine_type> <qtab> <pmax2>
   
   1000 "A-5     " 380.00 "1 " "        " :  
   1    1000 "A-5     " 380.00  0.00 1.00  10  354  261.40  625.2    0.0    
   0.0 3000.0 -3000.0 100.0000 0.000 0.000 0.000 1.000
   -1 "        "   0.00      -1 "        "   0.00    400101   391231   0 0
   0.0000 0.0000 1.0000   1 1.000   0 0.000   0 0.000   0 0.000    0 0.000    0 0.000    0 0.000    0 0.000 
 */		
		String str1 = lineStr.substring(0, lineStr.indexOf(':')),
	           str2 = lineStr.substring(lineStr.indexOf(':')+1);
	
		setHeaderData(str1);

		StringTokenizer st = new StringTokenizer(str2, "\"");
		// <st> <igreg bus>
		String s1 = st.nextToken();
		StringTokenizer st1 = new StringTokenizer(s1);
		
		if (st.hasMoreElements()) 
			this.igregName = st.nextToken();
		
		// <igreg bkv> <prf> <qrf> <ar> <z> <pgen> <pmax> <pmin> <qgen> <qmax> <qmin> <mbase> <rcomp> <xcomp> <zgenr> <zgenx> <h bus> 
		if (st.hasMoreElements()) {
			String s2 = st.nextToken();
			st1 = new StringTokenizer(s2);
		}
		
		if (st.hasMoreElements()) 
			this.hName = st.nextToken();
		
		// <h bkv> <t bus>
		if (st.hasMoreElements()) {
			String s3 = st.nextToken();
			st1 = new StringTokenizer(s3);
		}
		
		if (st.hasMoreElements()) 
			this.tName = st.nextToken();
		
		// <t bkv> <d_in> <d_out> <projid> <snt> <rtr> <xtr> <gtap> /
		//   <o1> <p1> <o2> <p2> <o3> <p3> <o4> <p4> <o5> <p5> <o6> <p6> <o7> <p7> <o8> <p8> 
		//   <gov_flag> <agc_flag> <dispatch_flag> <baseload_flag> <air_temp> <turbine_type> <qtab> <pmax2>
		if (st.hasMoreElements()) {
			String s4 = st.nextToken();
			st1 = new StringTokenizer(s4);
		}
	}

	public void setGen(GeAclfNetwork net, IPSSMsgHub msg) throws Exception {
		String id = new Integer(this.number).toString();
		GeAclfBus  bus = (GeAclfBus)net.getBus(id);
		if (bus == null) {
			msg.sendErrorMsg("Bus cannot be found, bus number: " + id);
			throw new Exception("Bus cannot be found");
		}
		
		GeGenerator gen = ExtensionObjectFactory.createGeGenerator(id, longId);
		bus.getGenList().add(gen);
		gen.setGeAreaNo(this.ar);
		gen.setGeZoneNo(this.z);
		// <st> Load status 1 =	in service; 0 =	out of service
		gen.setInSevice(this.st == 1);
		// <nst> Normal load status 1=in service; 0=out of service
		gen.setNormalInService(this.nst == 1);		
		/*
*/		
	}	
	public String toString() {
		String str = super.toString();
		return str;
	}
	
}
