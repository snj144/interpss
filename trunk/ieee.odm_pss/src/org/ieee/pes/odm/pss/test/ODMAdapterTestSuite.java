package org.ieee.pes.odm.pss.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	IEEECDF_ODMTest.class,
	UCTE_ODMTest.class
})
public class ODMAdapterTestSuite {
}
