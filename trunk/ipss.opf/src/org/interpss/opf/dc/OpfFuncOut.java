package org.interpss.opf.dc;

import com.interpss.core.net.Bus;
import com.interpss.opf.OpfGenBus;
import com.interpss.opf.OpfNetwork;

public class OpfFuncOut {
	public static String opfResultSummary(OpfNetwork opfnet) {
		 double minTVC=0;
		 double minTotalCost=0;
		 final StringBuffer str = new StringBuffer("");
		 str.append("           ---DCOPF SOLUTION RESULT SUMMARY---            \n");
		 str.append("busID    isOpfGen     optimGen(PU)   optimBusAngle \n");
		 str.append("----------------------------------------------------\n");
		 for(Bus b:opfnet.getBusList()) {
			 str.append(b.getId());
			 if(opfnet.isOpfGenBus(b)){
				 OpfGenBus opfBus=(OpfGenBus) b;
				 
				 str.append("   Ture      "   +opfBus.getGenP());
				 minTVC+=opfBus.getCoeffA()*opfBus.getGenP()+opfBus.getCoeffB()*Math.pow(opfBus.getGenP(), 2);
				 minTotalCost=minTVC+opfBus.getFixedCost();	
			 }
			 else str.append("     False                    ");
			 str.append(((OpfGenBus)b).getVoltageAng()+"\n");	 
		 }
		 str.append("Minimun Total Variable Cost: "+minTVC+"\n");
		 str.append("Minimun Total Cost: "+minTotalCost+"\n");
		 return str.toString();
	}
//	public static String opfSolutionSummary(OpfQuadProgAlgorithm opfAlgo) {
//		
//	}

}
