package org.interpss.vstab.cpf.impl;

import org.interpss.vstab.cpf.CPFAlgorithm;
import org.interpss.vstab.util.VstabFuncOut;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.common.datatype.Vector_xy;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.impl.DefaultNrSolver;
import com.interpss.core.common.visitor.IAclfBusVisitor;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

public class CorrectorStepSolver extends DefaultNrSolver {
	private final Vector_xy zeroMismatch=new Vector_xy(0,0);
	private double valOfContPara=0;
	private LambdaParam lambda=null;
    private CPFAlgorithm cpf=null;
    CpfHelper cpfHelper=null;
    
	public CorrectorStepSolver(CPFAlgorithm cpfAlgo) {
		super(cpfAlgo.getAclfNet());
		cpf=cpfAlgo;
		this.lambda=cpfAlgo.getLambdaParam();
		cpfHelper=new CpfHelper(getAclfNet(), cpf.getMsgHub());
		cpfHelper.setSortNumOfContParam(cpfAlgo.getSortNumOfContParam());
	}
	@Override
	public SparseEqnMatrix2x2 formJMatrix(IPSSMsgHub msg) {
		System.out.println("cpf sortNum="+cpf.getSortNumOfContParam());
		System.out.println("cpfHelper sortNum="+cpfHelper.getSortNumOfContParam());
		SparseEqnMatrix2x2 lfEqn=cpfHelper.formAugmJacobiMatrix();
		
//		SparseEqnMatrix2x2 lfEqn = getAclfNet().formJMatrix(1, msg);
//		
//		// create a 2x2 matrix element
//		Matrix_xy m = new Matrix_xy();
//		
//		m.xx = 1.0;
//		m.xy = 0.0;
//		m.yx = 0.0;
//		m.yy = 0.0;
//		// add the matrix_xy element to J-matrix
//		int n = getAclfNet().getNoBus();
//		lfEqn.setAij(m, n+1, cpf.getSortNumOfContParam());
//		// try to avoid a(n+1,n+1)=0 when other attributes but lambda is chosen as continuation parameter
//		m.xx=0;
//		m.yy=1;
//	    lfEqn.setAij(m, n+1,lambda.getPosition());
//
//
		VstabFuncOut.printJmatix(lfEqn, 5, 2);
		return lfEqn;
	}
	@Override
	public void setPowerMismatch(SparseEqnMatrix2x2 lfEqn) {
		// calculate bus power mismatch. The mismatch stored on 
		// the right-hand side of the sparse eqn
		super.setPowerMismatch(lfEqn);
		
//		// define a 2x1 vector
//		Vector_xy b = new Vector_xy();
//		b.x = this.getFixedValOfContPara()-this.getValOfContParam();
//		b.y = zeroMismatch;
//		
//		// set the vector to the right-hand side of the sparse eqn
//		int n = getAclfNet().getNoBus();
		lfEqn.setBi(zeroMismatch, this.getAclfNet().getNoBus()+1); // explicitly set B(n+1) to Zero
	}

	@Override
	public void updateBusVoltage(SparseEqnMatrix2x2 lfEqn) {
		// update the bus voltage using the solution results store in the sparse eqn
		super.updateBusVoltage(lfEqn);
		
		// the solution result of the extra variable defined is stored at B(n+1)  
        lambda.update(lfEqn);// is any factor needed for update?

	}
	
	
	private double getFixedValOfContPara() {
		return cpf.getFixedValOfContPara();	
	}

	private double getValOfContParam() {
		if(cpf.getSortNumOfContParam()==lambda.getPosition()) {
			return lambda.getVal();
		}
		else {
			final long sortNum=cpf.getSortNumOfContParam();
			this.getAclfNet().forEachAclfBus(new IAclfBusVisitor() {

				@Override
				public void visit(AclfBus bus) {
					if(bus.getSortNumber()==sortNum) {
						valOfContPara=bus.getVoltageMag();
					}
					
				}
				
			});
			return valOfContPara;
			
		}
		
	}
	

}
