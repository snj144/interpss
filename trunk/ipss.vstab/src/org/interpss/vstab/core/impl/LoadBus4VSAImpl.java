package org.interpss.vstab.core.impl;

import org.interpss.vstab.core.LoadBus4VSA;

import com.interpss.core.aclf.impl.AclfBusImpl;

public class LoadBus4VSAImpl extends AclfBusImpl implements LoadBus4VSA{
    protected  double activeLoadDirection ;
    protected  double reactiveLoadDirection ;
    
	public double getActiveLoadDirection() {
		return this.activeLoadDirection;
	}

	public double getReactiveLoadDirection() {
		return this.reactiveLoadDirection;
	}

	public void setActiveLoadDirection(double newActiveLoadDir) {
		this.activeLoadDirection=newActiveLoadDir;
		
	}

	public void setReactiveLoadDirection(double newReactiveLoadDir) {
		this.reactiveLoadDirection=newReactiveLoadDir;
		
	};

}
