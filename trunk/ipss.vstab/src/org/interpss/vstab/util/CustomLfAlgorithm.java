package org.interpss.vstab.util;

import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.DecompositionSolver;
import org.apache.commons.math.linear.LUDecompositionImpl;
import org.apache.commons.math.linear.RealMatrix;
import org.interpss.vstab.cpf.CPFAlgorithm;
import org.interpss.vstab.cpf.impl.CorrectorStepSolver;
import com.interpss.common.datatype.Vector_xy;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.Number2String;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.INrSolver;
import com.interpss.core.algorithm.impl.DefaultNrSolver;
import com.interpss.core.common.visitor.IAclfNetBVisitor;
import com.interpss.core.datatype.Mismatch;
import com.interpss.core.sparse.SparseEqnMatrix2x2;
import com.interpss.spring.CoreCommonSpringCtx;

public class CustomLfAlgorithm implements IAclfNetBVisitor{
	private final double Default_Max_Iteration=20;
	private double maxIteration=Default_Max_Iteration;
	private double tolerance=1e-6;
	AclfNetwork net=null;
	INrSolver Solver=null;
	
    /**
     * customized Load Flow for CPFAlgorithm, used in the corrector step;
     * @param cpf
     */
	public CustomLfAlgorithm(CPFAlgorithm cpf){
    	Solver=cpf.getCorrStepSolver();
    	net=cpf.getAclfNet();
    }
	
	/**
	 * Default NR solver is used until it is set to another;
	 * @param net
	 */
	public CustomLfAlgorithm(AclfNetwork net){
		this.net=net;
    	Solver=new DefaultNrSolver(net);

    }
    public CustomLfAlgorithm() {
		
	}

	public INrSolver getSolver() {
		return Solver;
	}
	public void setSolver(INrSolver nrSolver) {
		this.Solver = nrSolver;
	}
	public AclfNetwork getAclfNet() {
		
		return net;
	}

	public void setAclfNet(AclfNetwork net) {
		this.net = net;
	}
	
	public double getMaxIteration() {
		return maxIteration;
	}
	public void setMaxIteration(double maxIteration) {
		this.maxIteration = maxIteration;
	}
	public double getTolerance() {
		return tolerance;
	}
	public void setTolerance(double tolearance) {
		this.tolerance = tolearance;
	}
	public AclfNetwork getNet() {
		return net;
	}
	public void setNet(AclfNetwork net) {
		this.net = net;
	}
	public double getDefault_Max_Iteration() {
		return Default_Max_Iteration;
	}
	public IPSSMsgHub getMsg(){
		return CoreCommonSpringCtx.getIpssMsgHub();
	}
	public boolean loadflow(){
	    INrSolver solver =getSolver();
	    
	    getAclfNet().setLfConverged(false);
	    for (int itcnt = 0; itcnt <= getMaxIteration(); ++itcnt) {
	      Mismatch misBuf = getAclfNet().maxMismatch(AclfMethod.NR);
	      getMsg().sendStatusMsg("NR Itr: " + Number2String.toStr(itcnt) + 
	        "   " + misBuf.toString());

	      if (misBuf.largeThan(10000000000.0D)) {
	        getMsg().sendStatusMsg("Load Flow Diverges !");
	        return false; }
	      if (misBuf.lessThan(getTolerance())){
	        getAclfNet().setLfConverged(true);
	        getMsg().sendStatusMsg("Load Flow Converged !");
	        return true;
	      }


	      if (!(nrStep(solver)))
	        return false;
	    }
	    getMsg().sendStatusMsg("Load Flow dose not Converge !");
	    return false;
	  }
	public boolean nrStep(INrSolver solver){
		SparseEqnMatrix2x2 lfEqn=solver.formJMatrix(getMsg());
		solver.setPowerMismatch(lfEqn);
		if(solveEqnByCommonMath(lfEqn)){
			solver.updateBusVoltage(lfEqn);
			return true;
		}
		else	
		return false;
		
	}
	private boolean solveEqnByCommonMath(SparseEqnMatrix2x2 lfEqn) {//// customized solver,different from default LU decomposition;
		double[][] A=VstabFuncOut.SparseMatrix2Ary(lfEqn);
		double[]   b=new double[lfEqn.getDimension()];
		
		for(int i=0;i<lfEqn.getDimension()/2;i++) { // index 1-N
				   b[2*i]=lfEqn.getBVect_xy(i+1).x;
				   b[2*i+1]=lfEqn.getBVect_xy(i+1).y;
		 }
		RealMatrix J=new  Array2DRowRealMatrix(A);
		DecompositionSolver lu=new LUDecompositionImpl(J).getSolver();
		if(lu.isNonSingular()){
		  double[] dxdL =lu.solve(b);
		  for(int i=0;i<lfEqn.getDimension()/2;i++) { // index 1-N
			Vector_xy v=new Vector_xy(dxdL[2*i],dxdL[2*i+1]);
			lfEqn.setBi(v, i+1);
		  }
		  return true;
		}
		else{
			getMsg().sendErrorMsg("Error: solver is singular");
            return false;
		}
	 }

	@Override
	public boolean visit(AclfNetwork net) {
        setAclfNet(net);
		return loadflow();
	}
		
}

