package org.interpss.vstab.core;

import com.interpss.core.aclf.AclfBus;

public interface GenBus4VSA extends AclfBus{
     public abstract double getActiveGenDirection();
     public abstract double getGenDispatchFactor();
	 public abstract void setActiveGenDirection(double newAcitveGenDir);
	 public abstract void setGenDispatchFactor( double newGenDispatchFactor);
}
