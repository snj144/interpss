package org.interpss;

import org.interpss.core.gridgain.GridGainFuncTest;
import org.interpss.core.gridgain.aclf.Bus1824AclfGridGainFuncTest;
import org.interpss.core.gridgain.aclf.Sample5BusAclfTest;
import org.interpss.core.ms_case.GridGain_DC_MultiCaseStudyTest;
import org.interpss.core.ms_case.GridGain_MC_InLineCalssTest;
import org.interpss.core.ms_case.GridGain_MC_MultiCaseStudyTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	GridGainFuncTest.class,
	Sample5BusAclfTest.class,
	Bus1824AclfGridGainFuncTest.class,
	GridGain_MC_MultiCaseStudyTest.class,
	GridGain_MC_InLineCalssTest.class,
	GridGain_DC_MultiCaseStudyTest.class,
})
public class GirdTestSuite {
}
