package org.interpss.facts;

import com.interpss.common.datatype.Vector_xy;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.impl.DefaultNrSolver;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

public class SVCNrSolver extends DefaultNrSolver {

	private SVCConstVControl[] svcConstVAry = null;
	private SVCConstQControl[] svcConstQAry = null;
	
    public SVCNrSolver(AclfNetwork net, SVCConstVControl[] svcConstVAry, SVCConstQControl[] svcConstQAry) {
        super(net);
        this.svcConstVAry = svcConstVAry;
        this.svcConstQAry = svcConstQAry;
    }
    
    @Override
    public SparseEqnMatrix2x2 formJMatrix() {
    	int svcConstVLength = 0, svcConstQLength = 0;
    	if (svcConstVAry != null)
    		svcConstVLength = svcConstVAry.length;
    	if (svcConstQAry != null)
    		svcConstQLength = svcConstQAry.length;
        SparseEqnMatrix2x2 lfEqn = this.getAclfNet().formJMatrix(svcConstVLength + svcConstQLength);
//        System.out.println(lfEqn.toString());

        if (svcConstVAry != null) {
            for (SVCConstVControl svc : svcConstVAry) {
                int i = svc.getBus().getSortNumber();
                int n = svc.getPosition();
                
                lfEqn.setAij(svc.getJnn(), n, n);
                lfEqn.setAij(svc.getJni(), n, i);
                lfEqn.setAij(svc.getJin(), i, n);
                lfEqn.addToAij(svc.getJii(), i, i);
            }
        }

        if (svcConstQAry != null) {
            for (SVCConstQControl svc : svcConstQAry) {
                int i = svc.getBus().getSortNumber();
                int n = svc.getPosition();
                
                lfEqn.setAij(svc.getJnn(), n, n);
                lfEqn.setAij(svc.getJni(), n, i);
                lfEqn.setAij(svc.getJin(), i, n);
                lfEqn.addToAij(svc.getJii(), i, i);
            }
        }
//        System.out.println(lfEqn.toString());
        return lfEqn;
    }
    
    @Override
    public void setPowerMismatch(SparseEqnMatrix2x2 lfEqn) {
        super.setPowerMismatch(lfEqn);

        if (svcConstVAry != null) {
            for (SVCConstVControl svc : svcConstVAry) {
                int i = svc.getBus().getSortNumber();
                int n = svc.getPosition();
                
                Vector_xy bi = svc.getBi();
                lfEqn.addToBi(bi,i);

                lfEqn.setBi(svc.getBn(), n);
//                System.out.println(lfEqn.toString());
//                System.out.println(svc.getBus().mismatch(AclfMethod.NR).getReal() + " " + svc.getBus().mismatch(AclfMethod.NR).getImaginary());
            }
        }

        if (svcConstQAry != null) {
            for (SVCConstQControl svc : svcConstQAry) {
                int i = svc.getBus().getSortNumber();
                int n = svc.getPosition();
                
                Vector_xy bi = svc.getBi();
                lfEqn.addToBi(bi,i);

                lfEqn.setBi(svc.getBn(), n);
//                System.out.println(lfEqn.toString());
//                System.out.println(svc.getBus().mismatch(AclfMethod.NR).getReal() + " " + svc.getBus().mismatch(AclfMethod.NR).getImaginary());
            }
        }
    }
    
    @Override
    public void updateBusVoltage(SparseEqnMatrix2x2 lfEqn) {
        super.updateBusVoltage(lfEqn);

        if (svcConstVAry != null) {
            for (SVCConstVControl svc : svcConstVAry) 
            	svc.update(lfEqn);
        }
        
        if (svcConstQAry != null) {
            for (SVCConstQControl svc : svcConstQAry) 
            	svc.update(lfEqn);
        }
    }
}