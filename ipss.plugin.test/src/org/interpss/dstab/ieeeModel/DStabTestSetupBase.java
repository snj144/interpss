 /*
  * @(#)TestSetupBase.java   
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.dstab.ieeeModel;

import java.util.logging.Level;

import org.apache.commons.math.complex.Complex;
import org.interpss.PluginTestSetup;
import org.interpss.dstab.output.DatabaseSimuOutputHandler;
import org.interpss.editor.jgraph.ui.IIpssGraphModel;
import org.interpss.editor.jgraph.ui.form.IGFormContainer;
import org.interpss.editor.mapper.EditorJGraphDataMapper;
import org.interpss.editor.util.IOUtilFunc;
import org.jgraph.JGraph;

import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.fault.AcscBusFault;
import com.interpss.core.acsc.fault.SimpleFaultCode;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.devent.DynamicEvent;
import com.interpss.dstab.devent.DynamicEventType;
import com.interpss.dstab.mach.Machine;
import com.interpss.simu.SimuContext;
import com.interpss.spring.CoreCommonSpringCtx;

public class DStabTestSetupBase extends PluginTestSetup{
	
	protected IPSSMsgHub msg;

	public DStabTestSetupBase() { 
		msg = CoreCommonSpringCtx.getIpssMsgHub();
		IpssLogger.getLogger().setLevel(Level.WARNING);
 	}

	public void loadCaseData(String filename, SimuContext simuCtx) {
		JGraph graph = IOUtilFunc.loadIpssGraphFile(filename);
		IGFormContainer gFormContainer = ((IIpssGraphModel)graph.getModel()).getGFormContainer();
		EditorJGraphDataMapper mapper = new EditorJGraphDataMapper(msg);
		mapper.map2Model(gFormContainer, simuCtx);
	}
	
	public DynamicSimuAlgorithm createDStabAlgo(DStabilityNetwork net) {
		DynamicSimuAlgorithm algo = DStabObjectFactory.createDynamicSimuAlgorithm(net, 
				new DatabaseSimuOutputHandler(), msg);
		algo.setSimuStepSec(0.002);
		algo.setTotalSimuTimeSec(10.0);
		
		Machine mach = net.getMachine("Mach@0003");
		algo.setRefMachine(mach);	
		return algo;
	}
	
	public void addDynamicEventData(DStabilityNetwork net) {
		// define a bus fault event
		DynamicEvent event1 = DStabObjectFactory.createDEvent("BusFault3P@0003", "Bus Fault 3P@0003", 
				DynamicEventType.BUS_FAULT, net, msg);
		event1.setStartTimeSec(1.0);
		event1.setDurationSec(0.1);
		
		DStabBus faultBus = net.getDStabBus("0003");
		AcscBusFault fault = CoreObjectFactory.createAcscBusFault("Bus Fault 3P@0003" );
  		fault.setAcscBus(faultBus);
		fault.setFaultCode(SimpleFaultCode.GROUND_3P);
		fault.setZLGFault(Constants.SmallScZ);
		fault.setZLLFault(new Complex(0.0, 0.0));
		event1.setBusFault(fault);		
	}	
}

