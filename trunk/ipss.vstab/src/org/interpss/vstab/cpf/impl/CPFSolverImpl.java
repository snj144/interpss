package org.interpss.vstab.cpf.impl;

import org.interpss.vstab.cpf.CPFSolver;
import org.interpss.vstab.cpf.GenDispPattern;
import org.interpss.vstab.cpf.LoadIncPattern;

import com.interpss.core.aclf.AclfNetwork;

public class CPFSolverImpl implements CPFSolver{
    protected AclfNetwork net=null;
    protected LoadIncPattern _loadIncPtn=null;
    protected GenDispPattern _genDispPtn=null;
    private boolean cpfConverged=false;
    
    
	public CPFSolverImpl() {
		
	}
	public CPFSolverImpl(AclfNetwork acNetWork, LoadIncPattern loadIncPtn, GenDispPattern genDispPtn) {
		this.net=acNetWork;
		this._loadIncPtn=loadIncPtn;
		this._genDispPtn=genDispPtn;
	}
	@Override
	public boolean isCPFConverged() {
		
		return cpfConverged;
	}

	@Override
	public boolean solveCPF() {
		// TODO Auto-generated method stub
		return false;
	}

}
