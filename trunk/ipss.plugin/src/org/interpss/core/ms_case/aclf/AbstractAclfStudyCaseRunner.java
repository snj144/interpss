 /*
  * @(#)AbstractAclfStudyCaseRunner.java   
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

package org.interpss.core.ms_case.aclf;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.ms_case.BusResult;
import com.interpss.core.ms_case.StudyCase;
import com.interpss.core.ms_case.impl.StudyCaseRunnerImpl;
import com.interpss.core.net.Bus;

public abstract class AbstractAclfStudyCaseRunner extends StudyCaseRunnerImpl {
	public boolean runCase(StudyCase studyCase) {
		AclfNetwork aclfNet = (AclfNetwork)studyCase.getParent().getNetwork();
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(aclfNet);
		algo.loadflow(SpringAppContext.getIpssMsgHub());
		
		return aclfNet.isLfConverged();
	}			


	public boolean saveCase(StudyCase studyCase) {
		AclfNetwork aclfNet = (AclfNetwork)studyCase.getParent().getNetwork();
		AclfNetworkResult rNet = new AclfNetworkResult(aclfNet);
		studyCase.setNetResult(rNet);
		rNet.converged = aclfNet.isLfConverged();
		for (Bus b : aclfNet.getBusList()) {
			AclfBus bus = (AclfBus)b;
			AclfBusResult r = new AclfBusResult(bus);
			studyCase.getBusResultList().add(r);
			r.load = bus.getLoad();
			r.gen = bus.powerIntoNet().add(r.load);
			r.voltage = bus.getVoltage();
		}
		
		String str = "StudyCase: " + studyCase.getCaseNumber() + ", " + studyCase.getName() + 
					(rNet.converged? "  LF converged":"  LF diverged") + 
					"," + studyCase.getDesc() + "\n";
		for (BusResult r : studyCase.getBusResultList()) {
			AclfBusResult result = (AclfBusResult)r;
			str += result.toString() + "\n";
		}
		IpssLogger.getLogger().info(str);
		
		return true;
	}		
	
	public boolean resetCaseData(StudyCase studyCase) {
		if (studyCase.getParent().getNetwork() instanceof AclfAdjNetwork ) {
			AclfAdjNetwork aclfNet = (AclfAdjNetwork)studyCase.getParent().getNetwork();
			aclfNet.activateAllAdjust(SpringAppContext.getIpssMsgHub());
			aclfNet.initializeBusVoltage();
		}
		else {
			AclfNetwork aclfNet = (AclfNetwork)studyCase.getParent().getNetwork();
			aclfNet.initializeBusVoltage();
		}
		return true;
	}	
}
