package com.interpss.opf.gen;

import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.impl.AclfBusImpl;
import com.interpss.core.aclf.adpter.impl.GenBusAdapterImpl;

public class GenBus4OPFImpl extends AclfBusImpl implements
		GenBus4OPF {
	private double capLowerLimit; //generator capacity lower limit
	private double capUpperLimit;//generator capacity upper limit
	private double coeffientA;   // cost of generator(i)=ai*Pgi^2+bi*Pg; 
	private double coeffientB;
	private double fixCost;
	private AclfBus aclfBus;
	


	public GenBus4OPFImpl() {
		// TODO Auto-generated constructor stub
	}
	public GenBus4OPFImpl(String busID) {
		this.setId(busID);
	}
	@Override
	public double getCapLowerLimit() {

		return this.capLowerLimit;
	}

	@Override
	public double getCapUpperLimit() {
		return this.capUpperLimit;
	}

	@Override
	public double getCoeffA() {

		return this.coeffientA;
	}

	@Override
	public double getCoeffB() {
		return this.coeffientB;
	}

	@Override
	public void setCapLowerLimit(double newCapLowerLimit) {
		this.capLowerLimit = newCapLowerLimit;

	}

	@Override
	public void setCapUpperLimit(double newCapUpperLimit) {
		this.capUpperLimit = newCapUpperLimit;

	}

	@Override
	public void setCoeffA(double coefficientA) {
		this.coeffientA = coefficientA;

	}

	@Override
	public void setCoeffB(double coefficientB) {
		this.coeffientB = coefficientB;

	}

	@Override
	public double getFixCost() {
		return this.fixCost;
	}

	@Override
	public void setFixCost(double newFixCost) {
		this.fixCost = newFixCost;

	}


}
