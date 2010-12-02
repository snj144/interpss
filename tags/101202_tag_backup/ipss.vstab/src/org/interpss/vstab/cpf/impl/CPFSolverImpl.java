package org.interpss.vstab.cpf.impl;

import org.interpss.vstab.cpf.CPFAlgorithm;
import org.interpss.vstab.cpf.CPFSolver;
import org.interpss.vstab.cpf.GenDispPattern;
import org.interpss.vstab.cpf.LoadIncPattern;
import org.interpss.vstab.cpf.CpfStopCriteria.AnalysisStopCriteria;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.IAclfBranch;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.common.visitor.IAclfBranchVisitor;
import com.interpss.core.common.visitor.IAclfBusVisitor;

public class CPFSolverImpl implements CPFSolver{
    private AclfNetwork net=null;
    private IPSSMsgHub msg=null;
    protected LoadIncPattern _loadIncPtn=null;
    protected GenDispPattern _genDispPtn=null;
    private boolean cpfConverged=false;
    private boolean isCpfStop=false;
	private final int DEFAULT_CONT_PARA_SORTNUM=0;
	private int contParaSortNum=DEFAULT_CONT_PARA_SORTNUM;
	private double fixedValueOfContPara=0;
	private LambdaParam lambda=null;
	CPFAlgorithm cpfAlgo=null;
    private CorrectorStepSolver corrStepSolver;
    private PredictorStepSolver predStepSolver;
    
	public CPFSolverImpl() {
		
	}
	public CPFSolverImpl(CPFAlgorithm cpf, IPSSMsgHub msg) {
		cpfAlgo=cpf;
		this.net=cpfAlgo.getAclfNet();
		lambda=cpfAlgo.getLambdaParam();
		this.corrStepSolver=cpf.getCorrStepSolver();
		this.predStepSolver=cpf.getPreStepSolver();
		
	}

	@Override
	public boolean isCPFConverged() {
		
		return cpfConverged;
	}
	public void setCpfConverged(boolean convg) {
		this.cpfConverged=convg;
	}

	@Override
	public boolean solveCPF() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean correctorStep() {
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(msg);
		algo.setNrSolver(corrStepSolver);
		if(!net.accept(algo)) {
			return false;
		}
		return true;
	       

	}
	@Override
	public boolean predictorStep() {
		
		return true;
	}
	private boolean isCpfStop() {
		if(this.cpfAlgo.getAnalysisStopCriteria()==AnalysisStopCriteria.FULL_CUREVE) {
			if(this.lambda.getVal()<0.1) return this.isCpfStop=true;
		}
		else if(this.cpfAlgo.getAnalysisStopCriteria()==AnalysisStopCriteria.MAX_POWER_POINT) {
			if(this.predStepSolver.isCrossMPP) return isCpfStop=true;
		}
		else{ if(cpfAlgo.isAnyViolation()) return isCpfStop=true;
		}
		return isCpfStop=false;
		
	}

	
	
	

}
