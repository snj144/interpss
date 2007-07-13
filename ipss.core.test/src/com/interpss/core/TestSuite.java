package com.interpss.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.interpss.core.net.AreaImplTest;
import com.interpss.core.net.BranchImplTest;
import com.interpss.core.net.BusImplTest;
import com.interpss.core.net.NetRuleTest;

@RunWith(Suite.class)
@SuiteClasses({
	AreaImplTest.class,
	BranchImplTest.class,
	BusImplTest.class,
	NetRuleTest.class
})
public class TestSuite {
}
