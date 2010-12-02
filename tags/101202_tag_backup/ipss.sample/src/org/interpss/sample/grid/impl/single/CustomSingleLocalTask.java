
package org.interpss.sample.grid.impl.single;

import org.interpss.gridgain.job.AbstractGridGainJob;
import org.interpss.gridgain.msg.RemoteMessageTable;
import org.interpss.gridgain.task.singleJob.AclfSingleJobTask;

public class CustomSingleLocalTask extends AclfSingleJobTask {
	private static final long serialVersionUID = 1;
	
	@Override
	protected AbstractGridGainJob createJob(RemoteMessageTable remoteMsg) {
		// plugin the custom class, where loadflow is actually 
		// implemented and run on the remote node
		return new CustomSingleRemoteJob(remoteMsg);
	}	
}
