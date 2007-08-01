package org.interpss.core.ms_case;

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
	public static void increaseBusLoadConstPF(AclfBusResult busResult, double dP) {
		AclfBus bus = (AclfBus)busResult.getBus();
		double dQ = busResult.load.getReal() == 0.0 ? 0.0 : dP * busResult.load.getImaginary() / busResult.load.getReal(); 
		bus.setLoadP(busResult.load.getReal() + dP);
		bus.setLoadQ(busResult.load.getImaginary() + dQ);		
	}
	
	public static void increaseBusGenConstPF(AclfBusResult busResult, double dP) {
		AclfBus bus = (AclfBus)busResult.getBus();
		dP = dP * 0.5;
		if (bus.isGenPV()) {
			bus.setGenP(busResult.gen.getReal() + dP);
		}
		else if (bus.isGenPQ()) {
			bus.setGenP(busResult.gen.getReal() + dP);
			double dQ = busResult.gen.getReal() == 0.0 ? 0.0 : dP * busResult.gen.getImaginary() / busResult.gen.getReal(); 
			bus.setGenQ(busResult.gen.getImaginary() + dQ);
		}		
	}

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
