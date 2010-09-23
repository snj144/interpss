package org.interpss.opf.dc.util;

import com.interpss.core.net.Bus;
import com.interpss.opf.OpfGenBus;
import com.interpss.opf.OpfNetwork;

public class OpfOutFunc {
	public static String opfResultSummary(OpfNetwork opfnet) {
		 double minTVC=0;
		 double minTotalCost=0;
		 final StringBuffer str = new StringBuffer("\n\n");
		 str.append("           ---DCOPF SOLUTION RESULT SUMMARY---            \n");
		 str.append("----------------------------------------------------\n");
		 str.append("busID    isOpfGen     optimGen(PU)   optimAngle(RAD) \n");
		 str.append("----------------------------------------------------\n");
		 
		 for(Bus b:opfnet.getBusList()) {
			 str.append(b.getId());
			 if(opfnet.isOpfGenBus(b)){
				 OpfGenBus opfBus=(OpfGenBus) b;
				 
				 str.append(String.format("%10s","True"));
				 str.append(String.format("%14.3f",opfBus.getGenP()));
				 minTVC+=opfBus.getCoeffA()*opfBus.getGenP()+opfBus.getCoeffB()*Math.pow(opfBus.getGenP(), 2);
				 minTotalCost=minTVC+opfBus.getFixedCost();	
			 }
			 else str.append(String.format("%10s","False"));
			 str.append(String.format("%17.2f",((OpfGenBus)b).getVoltageAng()));	
			 str.append("\n");
		 }
		 
		 str.append("----------------------------------------------------\n\n");
		 str.append(String.format("Minimun Total Variable Cost: %6.3f",minTVC)+"\n");
		 str.append(String.format("Minimun Total Cost: %6.3f",minTotalCost)+"\n");
		 return str.toString();
	}
}
