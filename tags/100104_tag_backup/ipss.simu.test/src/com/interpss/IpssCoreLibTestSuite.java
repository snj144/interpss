 /*
  * @(#)CommonTestSuite.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 07/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package com.interpss;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.interpss.common.CommonFuncTest;
import com.interpss.common.ComplexFuncTest;
import com.interpss.core.aclf.AclfSampleTest;
import com.interpss.core.aclf.CustomAclfBranchTest;
import com.interpss.core.aclf.CustomAclfBusTest;
import com.interpss.core.aclf.CustomFuncLoadTest;
import com.interpss.core.aclfAdj.AreaControlTest;
import com.interpss.core.acsc.AcscSampleTest;
import com.interpss.core.acsc.CustomAcscBranchTest;
import com.interpss.core.acsc.CustomAcscBusTest;
import com.interpss.core.dclf.DclfSampleTest;
import com.interpss.core.net.AreaImplTest;
import com.interpss.core.net.BranchImplTest;
import com.interpss.core.net.BusImplTest;
import com.interpss.core.net.NetRuleTest;
import com.interpss.core.net.SwitchBreakModelTest;
import com.interpss.core.sample.BuildinSampleTest;
import com.interpss.core.sparse.SparseEqnComplexTest;
import com.interpss.core.sparse.SparseEqnDoubleTest;
import com.interpss.core.sparse.SparseEqnMatrix2x2Test;
import com.interpss.simu.SerializeEMFObjectTest;

@RunWith(Suite.class)
@SuiteClasses({
	// ipss.common
	CommonFuncTest.class,
	ComplexFuncTest.class,
	
	// ipss.core
	AreaImplTest.class,
	BranchImplTest.class,
	BusImplTest.class,
	NetRuleTest.class,
	SwitchBreakModelTest.class,

	SparseEqnComplexTest.class,
	SparseEqnDoubleTest.class,
	SparseEqnMatrix2x2Test.class,

	AclfSampleTest.class,
	CustomAclfBusTest.class,
	CustomFuncLoadTest.class,
	CustomAclfBranchTest.class,
	
	AreaControlTest.class,
	CustomAcscBusTest.class,
	CustomAcscBranchTest.class,
	
	AcscSampleTest.class,
	BuildinSampleTest.class,	

	DclfSampleTest.class,	
	
	// ipss.simu
	SerializeEMFObjectTest.class,	
})
public class IpssCoreLibTestSuite {
}
