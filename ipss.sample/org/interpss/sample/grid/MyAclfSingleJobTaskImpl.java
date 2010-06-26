
package org.interpss.sample.grid;

import org.interpss.gridgain.job.AbstractGridGainJob;
import org.interpss.gridgain.task.singleJob.AclfSingleJobTask;

import com.interpss.ext.gridgain.RemoteMessageTable;

public class MyAclfSingleJobTaskImpl extends AclfSingleJobTask {
	private static final long serialVersionUID = 1;
	
	@Override
	protected AbstractGridGainJob createJob(RemoteMessageTable remoteMsg) {
		// plugon the custom class MyGridAclfJobImpl, where loadflow is actually 
		// implemented
		return new MyGridAclfJobImpl(remoteMsg);
	}	
}
