package org.interpss.vstab.cpf.impl;

import org.apache.commons.math.complex.Complex;
import org.interpss.vstab.cpf.AclfBus4CPF;

import com.interpss.common.datatype.Vector_xy;
import com.interpss.core.aclf.impl.AclfBusImpl;

public class AclfBus4CPFImpl extends AclfBusImpl implements AclfBus4CPF{
    private Complex loadIncDir=null; // new Complex(dirOfLoadP,dirOfloadQ)
    private Vector_xy loadIncDirV_xy=null;//v_xy.x=dirP,v_xy.y=dirQ
	
    @Override
	public Complex getLoadIncDir() {
		
		return this.loadIncDir;
	}

	@Override
	public Vector_xy getLoadIncDirV_xy() {
	
		return this.loadIncDirV_xy;
	}

	@Override
	public double getLoadPIncDir() {
		
		return this.loadIncDir.getReal();
	}

	@Override
	public double getLoadQIncDir() {
		
		return this.loadIncDir.getImaginary();
	}

	@Override
	public void setLoadIncDir(Complex newLoadIncDir) {
		this.loadIncDir=newLoadIncDir;
		this.loadIncDirV_xy.x=newLoadIncDir.getReal();
		this.loadIncDirV_xy.y=newLoadIncDir.getImaginary();
	}

	@Override
	public void setLoadIncDir(Vector_xy newLoadDirV_xy) {
		this.loadIncDirV_xy=newLoadDirV_xy;
		this.loadIncDir=new Complex(newLoadDirV_xy.x,newLoadDirV_xy.x);
		
	}

	@Override
	public void setLoadPIncDir(double dirOfLoadP) {
		Complex oldLdDir=this.getLoadIncDir();
		this.loadIncDir=new Complex(dirOfLoadP,oldLdDir.getImaginary());
		this.loadIncDirV_xy.x=dirOfLoadP;
		
	}

	@Override
	public void setLoadQIncDir(double dirOfLoadQ) {
		Complex oldLdDir=this.getLoadIncDir();
		this.loadIncDir=new Complex(oldLdDir.getReal(),dirOfLoadQ);
		this.loadIncDirV_xy.y=dirOfLoadQ;
		
	}

}
