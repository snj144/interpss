package org.interpss.vstab.cpf.impl;

import org.interpss.vstab.cpf.CPFAlgorithm;
import org.interpss.vstab.cpf.CPFSolver;
import org.interpss.vstab.cpf.CpfStopCriteria.AnalysisStopCriteria;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algo.LoadflowAlgorithm;

public class CPFSolverImpl implements CPFSolver{


    private boolean isCpfStop=false;
	private LambdaParam lambda=null;
	private CPFAlgorithm cpfAlgo=null;
    private CorrectorStepSolver corrStepSolver;
    private PredictorStepSolver predStepSolver;
	private int sortNumOfContPara=0;
	private int iteration=0;
    
	public CPFSolverImpl(CPFAlgorithm cpf,LambdaParam newLambda) {
		this.cpfAlgo=cpf;
		this.lambda=newLambda;
		this.corrStepSolver=new CorrectorStepSolver(cpf);
		this.predStepSolver=new PredictorStepSolver(cpf);
		this.setSorNumofContParam(this.lambda.getPosition()); // by default;
		
	}


	@Override
	public boolean solveCPF() {
		this.iteration=0;
		while(this.iteration<cpfAlgo.getMaxIterations()){
		  this.predStepSolver.stepSolver();// run preStepSolver and update network buses' voltage with solved result;
		  LoadflowAlgorithm algo=CoreObjectFactory.createLoadflowAlgorithm();
		  algo.setTolerance(this.cpfAlgo.getPflowTolerance());
		  algo.setNrSolver(this.corrStepSolver);// corrector step solver is just a modified Newton-Raphson solver;
		
		  if(!this.cpfAlgo.getAclfNetwork().accept(algo)){
			  if(this.cpfAlgo.getStepSize()<1e-3){
				  IpssLogger.getLogger().severe("predictor step size="+this.cpfAlgo.getStepSize()+",  is small enough,yet convergance problems still remains!");
				return false;
			  }
			  this.predStepSolver.enableStepSizeControl(true);// step size control in the following step if corr-step is not converged!
			  IpssLogger.getLogger().warning("the previous Predictor step-size seems to be too large, need to be controlled");
		  }
		  else if(isCpfStopCriteriaMeet()){
			  IpssLogger.getLogger().info("one analysis Stop Criteria is meeted,CPF analysis end!");
		  }
		  
		}
		IpssLogger.getLogger().info("not converged within the max iteration!");
		return false;
	}



	@Override
	public boolean correctorStep() {
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm();
		algo.setNrSolver(corrStepSolver);
		if(!this.cpfAlgo.getAclfNetwork().accept(algo)) {
			return false;
		}
		return true;
	       

	}
	@Override
	public boolean predictorStep() {
		
		return true;
	}
	private boolean isCpfStopCriteriaMeet() {
		if(this.cpfAlgo.getAnalysisStopCriteria()==AnalysisStopCriteria.FULL_CUREVE) {
			if(this.lambda.getValue()<0.01&&this.iteration>5){
				IpssLogger.getLogger().info("full curve anlysis is finished!");
				return this.isCpfStop=true;
			}
		}
		else if(this.cpfAlgo.getAnalysisStopCriteria()==AnalysisStopCriteria.MAX_POWER_POINT) {
			if(this.predStepSolver.isCrossMPP) {
				IpssLogger.getLogger().info("PV nose is encountered, analysis ended!");
				return isCpfStop=true;
			}
		}
		else{ if(cpfAlgo.isAnyViolation()) {
			IpssLogger.getLogger().info("Analysis is ended because of violation!");
			return isCpfStop=true;
		}
		}
		return isCpfStop=false;
		
	}
	@Override
	public CorrectorStepSolver getCorrStepSolver() {
		
		return this.corrStepSolver;
	}
	@Override
	public LambdaParam getLambda() {
		
		return this.lambda;
	}
	@Override
	public PredictorStepSolver getPredStepSolver() {
		
		return this.predStepSolver;
	}

	@Override
	public int getSortNumOfContParam() {
		
		return this.sortNumOfContPara;
	}


	@Override
	public void setSorNumofContParam(int sortNum) {
		this.sortNumOfContPara=sortNum;
		
	}


	@Override
	public boolean isLmdaContParam() {
		return this.getSortNumOfContParam()==this.lambda.getPosition();
	}

	

}
