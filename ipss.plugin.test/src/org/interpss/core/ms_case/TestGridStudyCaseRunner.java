package org.interpss.core.ms_case;

import org.interpss.core.grid.gridgain.IpssGridGainUtil;

import com.interpss.common.ui.SerializeEMFObjectUtil;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.ms_case.GridMultiStudyCase;
import com.interpss.core.ms_case.impl.AbstractGridStudyCaseRunner;
import com.interpss.core.ms_case.result.GridAclfNetResult;

public class TestGridStudyCaseRunner extends AbstractGridStudyCaseRunner {
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
				GridAclfNetResult rnet = (GridAclfNetResult)SerializeEMFObjectUtil.loadModel(modelStr);
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
