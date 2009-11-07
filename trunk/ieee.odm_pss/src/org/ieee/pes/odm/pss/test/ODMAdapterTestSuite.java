package org.ieee.pes.odm.pss.test;

import org.ieee.pes.odm.pss.test.bpa.BPA_ODMTest;
import org.ieee.pes.odm.pss.test.ge.GE_ODMTest;
import org.ieee.pes.odm.pss.test.ieeecdf.IEEECDF_ODMTest;
import org.ieee.pes.odm.pss.test.psse.PSSEV26_ODMTest;
import org.ieee.pes.odm.pss.test.psse.PSSEV30_GuideSampleTest;
import org.ieee.pes.odm.pss.test.psse.PSSEV30_NEISO_ODMTest;
import org.ieee.pes.odm.pss.test.psse.PSSEV30_ODMTest;
import org.ieee.pes.odm.pss.test.psse.PSSEV30_SegmentTest;
import org.ieee.pes.odm.pss.test.ucte.UCTE_ODMTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	FuncTestCase.class,
	
	IEEECDF_ODMTest.class,
	
	UCTE_ODMTest.class,
	
	BPA_ODMTest.class,
	
	GE_ODMTest.class,
	
	PSSEV30_ODMTest.class,
	PSSEV30_NEISO_ODMTest.class,
	PSSEV26_ODMTest.class,
	PSSEV30_GuideSampleTest.class,
	PSSEV30_SegmentTest.class
})
public class ODMAdapterTestSuite {
}
