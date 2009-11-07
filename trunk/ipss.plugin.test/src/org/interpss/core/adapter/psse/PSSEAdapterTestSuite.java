package org.interpss.core.adapter.psse;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	CR_UserTestCases.class,
	RecLevelTestCases.class,
	
	EQ0907_TestCases.class,
})
public class PSSEAdapterTestSuite {
}
