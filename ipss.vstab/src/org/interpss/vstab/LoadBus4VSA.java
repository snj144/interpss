package org.interpss.vstab;

import com.interpss.core.aclf.AclfBus;

public interface LoadBus4VSA extends AclfBus{
	public abstract double getActiveLoadDirection();
    public abstract double getReactiveLoadDirection();  
    
    public abstract void setActiveLoadDirection(double newActiveLoadDir );
    public abstract void setReactiveLoadDirection(double newReactiveLoadDir);
}
