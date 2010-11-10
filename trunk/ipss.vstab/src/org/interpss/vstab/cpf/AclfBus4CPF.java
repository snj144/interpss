package org.interpss.vstab.cpf;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.Vector_xy;
import com.interpss.core.aclf.AclfBus;

public interface AclfBus4CPF extends AclfBus{
	
	public void setLoadIncDir(Complex newLoadIncDir);
	
	public void setLoadIncDir(Vector_xy newLoadDirV_xy);
	
	public Complex getLoadIncDir();
	
	public Vector_xy getLoadIncDirV_xy();
	
	public void setLoadPIncDir(double dirOfLoadP);
	
	public double getLoadPIncDir();
	
	public void setLoadQIncDir(double dirOfLoadQ);
	
	public double getLoadQIncDir();
	

}
