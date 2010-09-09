package org.interpss.vstab.core.impl;

import org.interpss.vstab.core.GenBus4VSA;

import com.interpss.core.aclf.impl.AclfBusImpl;

public class GenBus4VSAImpl extends AclfBusImpl implements GenBus4VSA{
	protected  double activeGenDirection ;
	protected  double genDispatchFactor ;
	public double getGenDispatchFactor() {
		
		return this.genDispatchFactor;
	}
	public void setGenDispatchFactor(double newGenDispatchFactor) {
		this.genDispatchFactor=newGenDispatchFactor;
		
	}
	public double getActiveGenDirection() {
		// TODO Auto-generated method stub
		return this.activeGenDirection;
	}
	public void setActiveGenDirection(double newActiveGenDir) {
		this.activeGenDirection=newActiveGenDir;
		
	}
}
