package org.interpss.vstab.cpf.impl;

import org.interpss.vstab.cpf.CPFAlgorithm;
import org.interpss.vstab.cpf.CPFSolver;
import org.interpss.vstab.cpf.CpfStopCriteria;
import org.interpss.vstab.cpf.GenDispPattern;
import org.interpss.vstab.cpf.LoadIncPattern;
import org.interpss.vstab.cpf.CpfStopCriteria.AnalysisStopCriteria;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.common.visitor.IAclfBranchVisitor;
import com.interpss.core.common.visitor.IAclfBusVisitor;

public class CPFAlgorithmImpl implements CPFAlgorithm{
	
    protected int maxInterations;
    protected IPSSMsgHub msg=null;
    protected double tolerance;
    protected AclfNetwork net=null;
    protected LambdaParam lambda=null;
    protected AnalysisStopCriteria stopCriteria=null;
    protected GenDispPattern genDispPtn=null;
    protected LoadIncPattern loadIncPtn=null;
    protected CPFSolver cpfSolver=null;
    private boolean violation=false;
   
    public CPFAlgorithmImpl() {
    	
    }
    

	@Override
	public int getMaxIterations() {
		
		return this.maxInterations;
	}

	@Override
	public IPSSMsgHub getMsgHub() {
		return this.msg;
	}

	@Override
	public double getTolerance(byte unit) {
		if(unit==UnitType.mVA) {
			return this.tolerance*this.net.getBaseKva()/1000;
		}
		else if(unit==UnitType.PU) {
			return this.tolerance;
		}
		else {
			getMsgHub().sendErrorMsg("unit parameter must be either UnitType.mVA or PU");
			return 0;
		}
		
	}
	@Override
	public void setTolerance(double tol, byte unit) {
		if(unit==UnitType.mVA) {
			this.tolerance=tol/this.net.getBaseKva()*1000;
		}
		else if(unit==UnitType.PU) {
			this.tolerance=tol;
		}
		else {
			getMsgHub().sendErrorMsg("unit parameter must be either UnitType.mVA or PU");
		}
		
	}

	@Override
	public boolean runCPF() {
		cpfSolver.solveCPF();
		return cpfSolver.isCPFConverged();
	}

	@Override
	public void setAnalysisStopCriteria(AnalysisStopCriteria newStopCriteria) {
		this.stopCriteria=newStopCriteria;
		
	}

	@Override
	public void setGenDispPattern(GenDispPattern newGenDispPtn) {
		this.genDispPtn=newGenDispPtn;
		
	}

	@Override
	public void setLoadIncPattern(LoadIncPattern newLoadIncPtn) {
		this.loadIncPtn=newLoadIncPtn;
		
	}

	@Override
	public void setMaxIterations(int maxIter) {
		this.maxInterations=maxIter;
		
	}

	@Override
	public void setMsgHub(IPSSMsgHub paramIPSSMsgHub) {
		this.msg=paramIPSSMsgHub;
		
	}

	@Override
	public AnalysisStopCriteria getAnalysisStopCriteria() {
		return this.stopCriteria;
	}

	@Override
	public GenDispPattern getGenDispPatten() {
		return this.genDispPtn;
		
	}

	@Override
	public LoadIncPattern getLoadIncPatten() {
		return this.loadIncPtn;
		
	}

	@Override
	public double getTolerance() {
		
		return this.tolerance;
	}
	public AclfNetwork getAclfNet() {
		return net;
	}
	/**
	 * @param net the net to set
	 */
	public void setAclfNet(AclfNetwork net) {
		this.net = net;
	}
	@Override
	public boolean isAnyViolation() {
	          violation=false;
		
		this.getAclfNet().forEachAclfBranch(new IAclfBranchVisitor() {

			@Override
			public void visit(AclfBranch bra) {
				// to do judgment of any violation in any branch
				
			}
			
		});
		this.getAclfNet().forEachAclfBus(new IAclfBusVisitor() {

			@Override
			public void visit(AclfBus bus) {
				// to do judgment of any violation in any bus
				
			}
			
		});
		return false;
		
	}


	@Override
	public LambdaParam getLambdaParam() {
		
		return lambda;
	}


	@Override
	public void setLambda(LambdaParam newLambda) {
		this.lambda=newLambda;
		
	}
	
	


}
