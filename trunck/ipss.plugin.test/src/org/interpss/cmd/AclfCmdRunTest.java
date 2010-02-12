package org.interpss.cmd;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.interpss.InterPSS;
import org.junit.Test;

import com.interpss.simu.SimuContext;

public class AclfCmdRunTest  extends BaseTestSetup {
	@Test
	public void runIEEE14Aclf() throws Exception {
		SimuContext simuCtx = (SimuContext)CmdLineRunner.cmdLineRun(
				"testData/ipssdata/Ieee14.ipssdat");
		assertTrue(simuCtx.getAclfAdjNet().isLfConverged());
	}			

	@Test
	public void runIEEE14Dclf() throws Exception {
		CmdLineRunner.cmdLineRun(
				"testData/ipssdata/Ieee14.ipssdat", 
				InterPSS.RunDclfStr,
				null,
				null);
	}			

//	@Test
	public void runIEEE14XmlControlFile() throws Exception {
		CmdLineRunner.cmdLineRun(
				"testData/ipssdata/Ieee14.ipssdat", 
				InterPSS.RunDclfStr,
				"testData/xml/RunSingleAclfCase.xml",
				null);
	}			
}
