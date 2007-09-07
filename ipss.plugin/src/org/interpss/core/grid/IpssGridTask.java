package org.interpss.core.grid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJob;
import org.gridgain.grid.GridJobAdapter;
import org.gridgain.grid.GridJobResult;
import org.gridgain.grid.GridTaskSplitAdapter;

import com.interpss.core.aclf.AclfNetwork;
import com.interpss.simu.io.SerializeEMFObjectUtil;

public class IpssGridTask extends GridTaskSplitAdapter<String> {
	private static final long serialVersionUID = 1;

	@Override
	protected Collection<? extends GridJob> split(int gridSize, String model) throws GridException {
		int cnt = 2;
		List<GridJob> jobs = new ArrayList<GridJob>(cnt);

        for (int i = 0; i < cnt; i++) {
            // Every job gets its own word as an argument.
            jobs.add(new GridJobAdapter<String>(model) {
            	private static final long serialVersionUID = 1;
                public Serializable execute() {
                	String modelStr = getArgument();
                	System.out.println(modelStr);
            		AclfNetwork net = (AclfNetwork)SerializeEMFObjectUtil.loadModel(modelStr);
            		System.out.println("NetID - " + net.getId());
            		return null;
                }
            });
        }

        return jobs;
     }

	@Override
	public Object reduce(List<GridJobResult> results) throws GridException {
		// TODO Auto-generated method stub
		return null;
	}

}
