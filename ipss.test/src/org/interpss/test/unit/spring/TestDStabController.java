package org.interpss.test.unit.spring;

import java.util.List;

import org.interpss.test.unit.TestBaseAppCtx;

import com.interpss.common.datatype.Constants;
import com.interpss.simu.SimuSpringAppContext;
import com.interpss.simu.util.SimuSpringAppCtxUtil;

public class TestDStabController extends TestBaseAppCtx {
	public void testSimuControllerList() {
		System.out.println("\nBegin TestDStabController.testSimuControllerList");
		
		List excList = SimuSpringAppContext.getControllerList(Constants.SID_ExciterList);
		assertTrue(excList.size() > 0);
		assertTrue(SimuSpringAppCtxUtil.getExciter("Simple Exciter") != null);
		
		List govList = SimuSpringAppContext.getControllerList(Constants.SID_GovernorList);
		assertTrue(govList.size() > 0);
		assertTrue(SimuSpringAppCtxUtil.getGovernor("Simple Governor") != null);

		List pssList = SimuSpringAppContext.getControllerList(Constants.SID_StabilizerList);
		assertTrue(pssList.size() > 0);
		assertTrue(SimuSpringAppCtxUtil.getStabilizer("Simple Stabilizer") != null);

		System.out.println("\nEnd TestDStabController.testSimuControllerList");
	}
}
