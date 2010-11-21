package org.interpss.facts;

import com.interpss.common.datatype.Vector_xy;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.impl.DefaultNrSolver;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

public class SVCNrSolver extends DefaultNrSolver {

	private SVCConstVControl[] svcAry = null;
	
    public SVCNrSolver(AclfNetwork net, SVCConstVControl[] svcAry) {
        super(net);
        this.svcAry = svcAry;
    }
    
    @Override
    public SparseEqnMatrix2x2 formJMatrix(IPSSMsgHub msg) {
        SparseEqnMatrix2x2 lfEqn = this.getAclfNet().formJMatrix(svcAry.length, msg);

        for (SVCConstVControl svc : svcAry) {
            int i = svc.getBus().getSortNumber();
            int n = svc.getPosition();
            
            lfEqn.setAij(svc.getJnn(), n, n);
            lfEqn.setAij(svc.getJni(), n, i);
            lfEqn.setAij(svc.getJin(), i, n);
            lfEqn.addToAij(svc.getJnn(), i, i);
        }
        return lfEqn;
    }
    
    @Override
    public void setPowerMismatch(SparseEqnMatrix2x2 lfEqn) {
        super.setPowerMismatch(lfEqn);

        for (SVCConstVControl svc : svcAry) {
            int i = svc.getBus().getSortNumber();
            int n = svc.getPosition();
            
            Vector_xy bi = svc.getBi();
            lfEqn.addToBi(bi,i);

            lfEqn.setBi(svc.getBn(), n);
        }
    }
    
    @Override
    public void updateBusVoltage(SparseEqnMatrix2x2 lfEqn) {
        super.updateBusVoltage(lfEqn);
        
        for (SVCConstVControl svc : svcAry) 
        	svc.update(lfEqn);
    }
}

