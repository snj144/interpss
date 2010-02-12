package org.interpss.dstab.mach;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	Eq1Ed1MachineTest.class,
	EConstMachineTest.class,
	Eq1MachineCaseTest.class,
	MachineSaturationTest.class,
	RoundRotorMachineTest.class,
	SalientPoleMachineTest.class,
})
public class DStabMachTestSuite {
}
