package org.interpss.vstab.cpf.impl;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.common.datatype.Vector_xy;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.impl.DefaultNrSolver;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

public class PredictorStepSolver extends DefaultNrSolver {
	private double zeroMismatch=0;
	private Vector_xy bAug=null;
	protected int DEFAULT_CONTPARA_SORTNUM=0;
	protected int sortNumOfContPara=DEFAULT_CONTPARA_SORTNUM;
	private double valOfContPara=0;
	private double fixedValOfContPara=0;
	

	public PredictorStepSolver(AclfNetwork net) {
		super(net);
	}
	@Override
	public SparseEqnMatrix2x2 formJMatrix(IPSSMsgHub msg) {
		SparseEqnMatrix2x2 lfEqn = getAclfNet().formJMatrix(1, msg);
		
		// create a 2x2 matrix element
		Matrix_xy m = new Matrix_xy();
		m.xx = 1.0;
		m.xy = 0.0;
		m.yx = 0.0;
		m.yy = 1.0;
		// add the matrix_xy element to J-matrix
		int n = getAclfNet().getNoBus();
		lfEqn.setAij(m, n+1, this.getSortNumOfContPara());
		return lfEqn;
	}
	@Override
	public void setPowerMismatch(SparseEqnMatrix2x2 lfEqn) {
		// calculate bus power mismatch. The mismatch stored on 
		// the right-hand side of the sparse eqn
		super.setPowerMismatch(lfEqn);
		
		// define a 2x1 vector
		Vector_xy b = new Vector_xy();
		b.x = this.valOfContPara-this.getFixedValOfContPara();
		b.y = zeroMismatch;
		
		// set the vector to the right-hand side of the sparse eqn
		int n = getAclfNet().getNoBus();
		lfEqn.setBi(b, n+1);
	}
	@Override
	public void updateBusVoltage(SparseEqnMatrix2x2 lfEqn) {
		// update the bus voltage using the solution results store in the sparse eqn
		super.updateBusVoltage(lfEqn);
		
		// the solution result of the extra variable defined is stored at B(n+1)  
		int n = getAclfNet().getNoBus();
		bAug=lfEqn.getBVect_xy(n+1);
		// update the value of continuation parameter
		this.valOfContPara-=bAug.x;

	}
	public int getSortNumOfContPara() {
		return sortNumOfContPara;
	}
	public void setSortNumOfContPara(int sortNumOfContPara) {
		sortNumOfContPara = sortNumOfContPara;
	}
	public double getFixedValOfContPara() {
		return fixedValOfContPara;
	}
	public void setFixedValOfContPara(double fixedValOfContPara) {
		this.fixedValOfContPara = fixedValOfContPara;
	}
	public void setContinueParameter(int sortNumOfContPara,double fixedValOfContPara ) {
		this.sortNumOfContPara = sortNumOfContPara;
		this.fixedValOfContPara=fixedValOfContPara;
	}

}
