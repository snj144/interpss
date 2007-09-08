package org.interpss.core.ms_case.aclf;

import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.ms_case.impl.NetworkResultImpl;

public class AclfNetworkResult extends NetworkResultImpl {
	public boolean converged = false;

	public AclfNetworkResult(AclfNetwork net) {
		this.setNetwork(net);
	}
}
