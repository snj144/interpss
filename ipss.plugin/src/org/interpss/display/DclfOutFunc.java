package org.interpss.display;

import com.interpss.common.datatype.Constants;
import com.interpss.common.util.Number2String;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.core.net.Bus;
import com.interpss.core.net.Network;


public class DclfOutFunc {
	public static String dclfResults(Network net, DclfAlgorithm algo) {
		String str = "BudId          VoltAng(deg)\n";
		str += "=================================\n";
		for (Bus bus : net.getBusList()) {
			int n = bus.getSortNumber();
			double angle = algo.getB1PAngleMatrix().getBi(n);
			str += Number2String.toFixLengthStr(8, bus.getId())
					+ "        "
					+ Number2String.toStr(angle * Constants.RtoD) + "\n";
		}
		return str;
	}
}