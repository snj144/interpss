package org.interpss.display;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.net.Bus;
import com.interpss.dist.DistBus;
import com.interpss.dist.DistBusAdapter;
import com.interpss.dist.DistNetwork;

public class DistOutFunc {
	public static String lfSummary(DistNetwork distNet, IPSSMsgHub msg) {
		StringBuffer str = new StringBuffer("");

		for (int i = 0; i < distNet.getLoadNetData().getSchedulePoints(); i++) {
			str.append("\n\n                      ==========================");
			str.append("\n                       Load Schedule Point: " + (i+1));
			str.append("\n                      ==========================");
			
			// set bus voltage
			distNet.setPointAclfNetData(i, msg);
			for( Bus b : distNet.getBusList()) {
  				DistBus distBus = (DistBus)b;
  				DistBusAdapter aBusApt = (DistBusAdapter)distBus.adapt(DistBusAdapter.class);
  				distBus.getAcscBus().setVoltage(aBusApt.getPointVoltage(i));
			}			
			
			str.append(AclfOutFunc.loadFlowSummary(distNet.getAclfNet()));
		}
			
		return str.toString();
	}
}
