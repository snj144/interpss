package org.ieee.odm;

import org.ieee.odm.bpa.BPA_ODMTest;
import org.ieee.odm.ge.GE_ODMTest;
import org.ieee.odm.ieeecdf.IEEECDF_ODMTest;
import org.ieee.odm.psse.PSSEV26_ODMTest;
import org.ieee.odm.psse.PSSEV30_GuideSampleTest;
import org.ieee.odm.psse.PSSEV30_NEISO_ODMTest;
import org.ieee.odm.psse.PSSEV30_ODMTest;
import org.ieee.odm.psse.PSSEV30_SegmentTest;
import org.ieee.odm.ucte.JaxbUCTE_ODMTest;
import org.ieee.odm.ucte.UCTE_ODMTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	FuncTestCase.class,
	
	IEEECDF_ODMTest.class,
	
	JaxbUCTE_ODMTest.class,
	UCTE_ODMTest.class,
	
	BPA_ODMTest.class,
	
	GE_ODMTest.class,
	
	org.ieee.odm.psse.old.PSSEV30_ODMTest.class,
	org.ieee.odm.psse.old.PSSEV30_NEISO_ODMTest.class,
	org.ieee.odm.psse.old.PSSEV26_ODMTest.class,
	org.ieee.odm.psse.old.PSSEV30_GuideSampleTest.class,
	org.ieee.odm.psse.old.PSSEV30_SegmentTest.class,

	PSSEV30_ODMTest.class,
	PSSEV30_NEISO_ODMTest.class,
	PSSEV26_ODMTest.class,
	PSSEV30_GuideSampleTest.class,
	PSSEV30_SegmentTest.class
})
public class ODMAdapterTestSuite {
}
