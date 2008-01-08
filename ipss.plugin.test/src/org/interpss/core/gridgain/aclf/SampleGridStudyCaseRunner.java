package org.interpss.core.gridgain.aclf;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridFactory;
import org.interpss.core.grid.gridgain.IpssGridGainUtil;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.ms_case.GridMultiStudyCase;
import com.interpss.core.ms_case.impl.AbstractGridStudyCaseRunner;

public class SampleGridStudyCaseRunner extends AbstractGridStudyCaseRunner {
	@Override
	public boolean gridRunCase() {
		try {
			// get the containing GridMultiStudyCase object
			GridMultiStudyCase gridMCase = (GridMultiStudyCase)this.eContainer;
	       	GridFactory.start();
        	Object[] results;
	        try {
	        	Grid grid = GridFactory.getGrid();
	        	results = (Object[])IpssGridGainUtil.performGridTask(grid, "Test Custom IpssGrid Task impl ", gridMCase, 0);
	        }
	        finally {
	        	GridFactory.stop(true);
	        }

			boolean converged = true;
			for (Object obj : results) {
				String modelStr = (String)obj;
				//System.out.println((String)obj);
			}
			return converged;
		} catch (Exception e) {
			IpssLogger.getLogger().severe(e.toString());
			return false;
		}
	}
}
