package org.interpss.opf.dc;

import com.interpss.core.net.Bus;
import com.interpss.opf.OpfNetwork;

public class OpfFuncOut {
	public static String opfResultSummary(OpfNetwork opfnet) {
		 final StringBuffer str = new StringBuffer("");
		 str.append("           ---DCOPF SOLUTION RESULT SUMMARY---            \n");
		 str.append("busID    isOpfGen     optimGen   optimBusAngle \n");
		 str.append("-----------------------------------------------\n");
		 for(Bus b:opfnet.getBusList()) {
			 str.append(b.getId());
			 if(opfnet.isOpfGenBus(b))str.append(   "Ture"   );
			 else str.append(   "False"   );
			 
			 
		 }
		 return str.toString();
	}
//	public static String opfSolutionSummary(OpfQuadProgAlgorithm opfAlgo) {
//		
//	}

}
