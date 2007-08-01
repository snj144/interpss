package org.interpss;

import org.interpss.core.ms_case.MultiCaseStudyTest;
import org.interpss.dstab.control.cml.block.DelayControlBlockTests;
import org.interpss.dstab.control.cml.block.FilterControlBlockTests;
import org.interpss.dstab.control.cml.block.IntegrationControlBlockTests;
import org.interpss.dstab.control.cml.block.PIControlBlockTests;
import org.interpss.dstab.control.cml.block.WashoutControlBlockTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	DelayControlBlockTests.class,
	FilterControlBlockTests.class,
	IntegrationControlBlockTests.class,
	PIControlBlockTests.class,
	WashoutControlBlockTests.class,
	
	MultiCaseStudyTest.class
})
public class PluginTestSuite {
}
