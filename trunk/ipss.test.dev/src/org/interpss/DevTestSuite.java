package org.interpss;

import org.interpss.acsc.odm.Acsc_5BusTest;
import org.interpss.opf.odm.OpfSample_3BusTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	//Acsc
	Acsc_5BusTest.class,
	
	// OPF
	OpfSample_3BusTest.class
})
public class DevTestSuite {
}
