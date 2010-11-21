package org.interpss.facts;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.common.datatype.Vector_xy;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.impl.DefaultNrSolver;
import com.interpss.core.net.Bus;
import com.interpss.core.sparse.SparseEqnMatrix2x2;


public class SVCConstV {
	
    private static class CustomNrSolver extends DefaultNrSolver {
     private double vi;
     private double thetai;
     private double vsh;
     private double thetash;
     private double gsh;
     private double bsh;
     
     private String busID;
     
     private double vc; // Control object
     
        public CustomNrSolver(AclfNetwork net, String busID, double vc) {
            super(net);
            this.busID = busID;
            AclfBus busi = this.getAclfNet().getAclfBus(busID);
            vi = busi.getVoltageMag();
            thetai = busi.getVoltageAng();
            vsh = 1.0;
            thetash = 0.0;
            gsh = 0.0;
            bsh = 0.1;
            this.vc = vc;
        }
        
        @Override
        public SparseEqnMatrix2x2 formJMatrix(IPSSMsgHub msg) {
            SparseEqnMatrix2x2 lfEqn = this.getAclfNet().formJMatrix(1, msg);
            Bus bus = this.getAclfNet().getBus(busID);
            int i = bus.getSortNumber();
            int n = this.getAclfNet().getNoBus();
            
            // Update A part of the extended Jacobian
            Matrix_xy m = new Matrix_xy();
            m.xx = (2 * vsh * gsh - vi * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash))); // dPeq/dVsh
            m.xy = -vi * vsh * (gsh * Math.sin(thetai - thetash) + bsh * Math.cos(thetai - thetash)); // dPeq/dthetash
            m.yx = 0.0; // dFSVC/dVsh
            m.yy = 0.0; // dFSVC/dthetash
            lfEqn.setAij(m, n + 1, n + 1);
            
            // Update B part of the extended Jacobian
            m = new Matrix_xy();
            m.xx = -vsh * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash)) * vi; // dPeq/dVi
/**********************************************************************************************************************
I guess in your original load flow algorithm, the Jacobian elements related to voltage magnitudes must be multiplied by the magnitude to make the expression more neat, while make the fast decoupled PQ method possible, thus in the additional equations, those derivatives of Vi should also multiply Vi. Am I right?
**********************************************************************************************************************
*/
            m.xy = vi * vsh * (gsh * Math.sin(thetai - thetash) + bsh * Math.cos(thetai - thetash)); // dPeq/dthetai
            m.yx = 1.0 * vi; // dFSVC/dVi
            m.yy = 0.0; // dFSVC/dthetai
            lfEqn.setAij(m, n + 1, i); // TODO
/**********************************************************************************************************************
I am a bit confused. Shall I use setAij(m, n+1, i) or setAij(m, i, n+1)?
**********************************************************************************************************************
*/
            m.xy = vi * vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.sin(thetai - thetash)) * vi; // dPeq/dVi            
            // Update C part of the extended Jacobian
            m = new Matrix_xy();
            m.xx = vi * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash)); // dPi/dVsh
            m.xy = vi * vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash)); // dPi/dthetash
            m.yx = vi * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash)); // dQi/dVsh
            m.yy = -vi * vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash)); // dQi/dthetash
            lfEqn.setAij(m, i, n + 1); // TODO
            // Update D part of the extended Jacobian
            m = lfEqn.getElement(i, i);
            m.xx -= (2 * vi * gsh - vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))) * vi; // dPi/dVi
            m.xy -= vi * vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash)); // dPi/dthetai
            m.yx += (2 * vi * bsh + vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))) * vi; // dQi/dVi
            m.yy += vi * vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash)); // dQi/dthetai
            lfEqn.setAij(m, i, i);
            return lfEqn;
            
        }
        
        @Override
        public void setPowerMismatch(SparseEqnMatrix2x2 lfEqn) {
            super.setPowerMismatch(lfEqn);
            Vector_xy b = new Vector_xy();
            // dPeq
            b.x = (vsh * vsh * gsh - vi * vsh * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash)));
            // dVi
            b.y = (vi - vc);
            int n = this.getAclfNet().getNoBus();
            lfEqn.setBi(b, n + 1);
            System.out.println("dpeq=" + b.x + ", dvi=" + b.y);
            Bus bus = this.getAclfNet().getBus(busID);
            int i = bus.getSortNumber();
            b = lfEqn.getBVect_xy(i);
            b.x -= (vi * gsh - vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))); // dFpi/Vi
            b.y += (vi * gsh + vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))); // dFqi/Vi
/**********************************************************************************************************************
Because of similar reason, here the influenced power flow equations should be divided by Vi to compensate the multiply of Vi in Jacobian.
**********************************************************************************************************************
*/
            lfEqn.setBi(b, i);
            System.out.println("dpi=" + b.x + ", dqi=" + b.y);
            System.out.println("Hello!");
        }
        @Override
        public void updateBusVoltage(SparseEqnMatrix2x2 lfEqn) {
            super.updateBusVoltage(lfEqn);
            int n = this.getAclfNet().getNoBus();
            vsh -= lfEqn.getBVect_xy(n + 1).x;
            thetash -= lfEqn.getBVect_xy(n + 1).y;
            System.out.println("vsh: " + vsh + ", thetash: " + thetash);
            Bus bus = this.getAclfNet().getBus(busID);
            int i = bus.getSortNumber();
            vi -= lfEqn.getBVect_xy(i).x;
            thetai -= lfEqn.getBVect_xy(i).y;
            System.out.println("vi: " + vi + ", thetai: " + thetai);
/**********************************************************************************************************************
This is the most inconclusive part. I don't know if the x is be added or subtracted by dx to get the updated value.
Furthermore, to my understanding, the line super.updateBusVoltage(lfEqn) should already update the vi and thetai, since they are not additional variables, but if I do not update them "manually", the variables will always be the same.
**********************************************************************************************************************
*/
        }
    }
    private double vc;  // Fixed voltage
    private AclfNetwork net;    // Power network
    private String busID;   // Location of the SVC
    public double getVc() {
        return vc;
    }
    public AclfNetwork getNet() {
        return net;
    }
    public SVCConstV(double vc, AclfNetwork net, String busID) {
        this.vc = vc;
        this.net = net;
        this.busID = busID;
    }
    
    // Customize the loadflow algorithm to realize the control objective
    public void createLoadflowAlgorithm(IPSSMsgHub msg) {
        // create a Loadflow algo object
        LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(msg);
        
        // set algo NR solver to the CustomNrSolver
        algo.setNrSolver(new CustomNrSolver(net, busID, vc));
        // run Loadflow
        net.accept(algo);
        
        System.out.println("Solve the load flow with SVC successfully at " + busID + "!");
    }
}
