package com.interpss.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.interpss.core.aclf.AclfSampleTest;
import com.interpss.core.aclf.CustomAclfBusTest;
import com.interpss.core.aclf.CustomFuncLoadTest;
import com.interpss.core.aclfAdj.AreaControlTest;
import com.interpss.core.acsc.AcscSampleTest;
import com.interpss.core.net.AreaImplTest;
import com.interpss.core.net.BranchImplTest;
import com.interpss.core.net.BusImplTest;
import com.interpss.core.net.NetRuleTest;
import com.interpss.core.sparse.SparseEqnComplexTest;
import com.interpss.core.sparse.SparseEqnDoubleTest;
import com.interpss.core.sparse.SparseEqnMatrix2x2Test;

@RunWith(Suite.class)
@SuiteClasses({
	AreaImplTest.class,
	BranchImplTest.class,
	BusImplTest.class,
	NetRuleTest.class,

	SparseEqnComplexTest.class,
	SparseEqnDoubleTest.class,
	SparseEqnMatrix2x2Test.class,

	AclfSampleTest.class,
	CustomAclfBusTest.class,
	CustomFuncLoadTest.class,
	
	AreaControlTest.class,
	
	AcscSampleTest.class
})
public class CoreTestSuite {
}
