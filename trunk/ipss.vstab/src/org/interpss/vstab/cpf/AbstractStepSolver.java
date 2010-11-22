package org.interpss.vstab.cpf;

import java.util.Hashtable;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

public class AbstractStepSolver {
	protected AclfNetwork net=null;
	protected int sortNumofContParam=0;
	protected IPSSMsgHub msg=null;
	protected SparseEqnMatrix2x2 augmentedJacobi=null;
	protected double DEFAULT_CPFSOLVER_TOLEARNCE=9.95e-21;
	protected double tolerance=DEFAULT_CPFSOLVER_TOLEARNCE;
	
	public AbstractStepSolver(AclfNetwork net,IPSSMsgHub msg) {
		this.net=net;
		this.msg=msg;
	}
	
	public double getTolerance() {
		return tolerance;
	}
	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}
	public AclfNetwork getAclfNetwork() {
		return net;
	}
	public void setAclfNetwork(AclfNetwork net) {
		this.net = net;
	}
	public int getSortNumofContParam() {
		return sortNumofContParam;
	}
	public void setSortNumofContParam(int sortNumofContParam) {
		this.sortNumofContParam = sortNumofContParam;
	}
	public IPSSMsgHub getMsg() {
		return msg;
	}
	public void setMsg(IPSSMsgHub msg) {
		this.msg = msg;
	}
	public SparseEqnMatrix2x2 getAugmentedJacobi() {
		return augmentedJacobi;
	}
	public void setAugmentedJacobi(SparseEqnMatrix2x2 augmentedLfEqn) {
		this.augmentedJacobi = augmentedLfEqn;
	}
	
	public boolean stepSolver() {
		 throw new UnsupportedOperationException();
	}
	

}
