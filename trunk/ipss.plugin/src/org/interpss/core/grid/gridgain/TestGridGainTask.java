 /*
  * @(#)IpssGridGainTask.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.core.grid.gridgain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJob;
import org.gridgain.grid.GridJobAdapter;

import com.interpss.core.CorePackage;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.simu.io.SerializeEMFObjectUtil;

public class TestGridGainTask extends AbstractIpssGridGainTask {
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
                	// This is necessary to init for EMF 
                	CorePackage corePackage = CorePackage.eINSTANCE;
                	String modelStr = getArgument();
                	//System.out.println(modelStr);
            		AclfNetwork net = (AclfNetwork)SerializeEMFObjectUtil.loadModel(modelStr);
            		System.out.println("NetID - " + net.getId());
            		return "NetID - " + net.getId();
                }
            });
        }

        return jobs;
     }
}
