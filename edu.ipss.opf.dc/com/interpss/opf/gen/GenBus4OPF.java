package com.interpss.opf.gen;

import com.interpss.core.aclf.AclfBus;

public interface GenBus4OPF extends AclfBus {
	public void setCoeffA(double coefficientA);

	public double getCoeffA();

	public void setCoeffB(double coefficientB);

	public double getCoeffB();

	public void setCapLowerLimit(double capLowerLimit);

	public double getCapLowerLimit();

	public void setCapUpperLimit(double capUpperLimit);

	public double getCapUpperLimit();

	public void setFixCost(double newFixCost);

	public double getFixCost();
	


}
