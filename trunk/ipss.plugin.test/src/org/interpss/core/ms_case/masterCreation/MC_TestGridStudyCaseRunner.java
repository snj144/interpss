package org.interpss.core.ms_case.masterCreation;

import org.interpss.core.grid.gridgain.IpssGridGainUtil;

import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.ms_case.GridMultiStudyCase;
import com.interpss.core.ms_case.impl.AbstractGridStudyCaseRunner;
import com.interpss.core.ms_case.result.AclfNetworkResult;

public class MC_TestGridStudyCaseRunner extends AbstractGridStudyCaseRunner {
	@Override
	public boolean gridRunCase() {
		try {
			// get the containing GridMultiStudyCase object
			GridMultiStudyCase gridMCase = (GridMultiStudyCase)this.eContainer;
			Object[] results = (Object[])
				IpssGridGainUtil.performGridTask("Test Custom IpssGrid Task impl ", gridMCase);
			for (Object obj : results) {
				String modelStr = (String)obj;
				//System.out.println((String)obj);
				AclfNetworkResult rnet = (AclfNetworkResult)SerializeEMFObjectUtil.loadModel(modelStr);
				if (!rnet.isLfConverged())
					return false;
			}
			return true;
		} catch (Exception e) {
			IpssLogger.getLogger().severe(e.toString());
			return false;
		}
	}
}
