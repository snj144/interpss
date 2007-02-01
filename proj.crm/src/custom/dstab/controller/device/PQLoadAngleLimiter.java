package custom.dstab.controller.device;

import com.interpss.dstab.controller.device.IControlDevice;
import com.interpss.dstab.controller.block.DelayControlBlock;
import com.interpss.dstab.controller.block.IControlBlock;
import com.interpss.common.func.LookupTable;


/**
 * Implementation Notes:
 * 
 *   input: 
 *      u[0] - Qt
 *      u[1] - Vt
 *      u[2] - Pt
 * 
 *   output: 
 *      y[0] - PQLim_sup
 *      y[1] - PQLim_out

 * @author mzhou
 * modified Ron O
 *
 */
public class PQLoadAngleLimiter implements IControlDevice {
	private double[] u = new double[3];
	private double[] y = new double[2];
        private double[] x = new double[6];
        private DelayControlBlock QgMeas = null;
        private DelayControlBlock VgMeas = null;
        private DelayControlBlock PgMeas = null;
        private LookupTable QPLookup = null;
        private DelayControlBlock filt = null;
        private LookupTable GRLookup = null;
        private double v1 = 0.0;
        
        /*
         * How to use a form to get parameters into this block?
         */
        private double TR = 0.020, KPQ = 0.5;
        private double P0 = 0, P25 = 0.25, P50 = 0.50, P75 = 0.75, P100 = 1.0;
        private double Q0 = -0.40, Q25 = -0.35, Q50 = -0.30, Q75 = -0.25, Q100 = -0.20;
        private double G0 = 1.0, G25 = 1.0, G50 = 1.0, G75 = 1.0, G100 = 1.0;
        
        
	/**
    * This method receives vector u[0 1 2] from calling class
    * and shall initialise the required states by this knowledge 
    * 
    * @param u0 controller initial values
	*/
	public boolean initState(double[] u0) {
            
            // must initialise from inputs in this device
            // u[0] = Qt  u[1] = Vt  u[2] = Pt
            QgMeas = new DelayControlBlock(1, TR);
            if (!(QgMeas.initState(u[0]))) return false;
            VgMeas = new DelayControlBlock(1, TR);
            if (!(VgMeas.initState(u[1]))) return false;
            PgMeas = new DelayControlBlock(1, TR);
            if (!(PgMeas.initState(u[2]))) return false;
            
            QPLookup = new LookupTable(LookupTable.TypeLinearLine);
            QPLookup.addPoint(new LookupTable.Point(P0, Q0));
            QPLookup.addPoint(new LookupTable.Point(P25, Q25));
            QPLookup.addPoint(new LookupTable.Point(P50, Q50));
            QPLookup.addPoint(new LookupTable.Point(P75, Q75));
            QPLookup.addPoint(new LookupTable.Point(P100, Q100));
            QPLookup.addPoint(new LookupTable.Point(5.0, Q100));
            
            filt = new DelayControlBlock(1.0, 1.0);
            v1 = VgMeas.getU0()*VgMeas.getU0()*QPLookup.getY(PgMeas.getU0());
            if (!(filt.initState(v1))) return false;
            
            GRLookup = new LookupTable(LookupTable.TypeLinearLine);
            GRLookup.addPoint(new LookupTable.Point(P0, G0));
            GRLookup.addPoint(new LookupTable.Point(P25, G25));
            GRLookup.addPoint(new LookupTable.Point(P50, G50));
            GRLookup.addPoint(new LookupTable.Point(P75, G75));
            GRLookup.addPoint(new LookupTable.Point(P100, G100));
            GRLookup.addPoint(new LookupTable.Point(5.0, G100));
            
            return true;
        }
	
	/**
    * This method called by the upstream controller block/device for initialization
    * purpose. It has to called called after the initState method() called.
    */
        
	public double[] getU0() {
            u[0]=QgMeas.getU0();
            u[1]=VgMeas.getU0();
            u[2]=PgMeas.getU0();
	return u;
	}

	public void eulerStep1(double[] u, double dt) {
            QgMeas.eulerStep1(u[0], dt);
            VgMeas.eulerStep1(u[1], dt);
            PgMeas.eulerStep1(u[2], dt);
            v1 = calculateV1(u);
            filt.eulerStep1(v1, dt);
	}

	public void eulerStep2(double[] u, double dt) {
            QgMeas.eulerStep2(u[0], dt);
            VgMeas.eulerStep2(u[1], dt);
            PgMeas.eulerStep2(u[2], dt);
            v1 = calculateV1(u);
            filt.eulerStep2(v1, dt);
	}
        
        private double calculateV1(double[] u) {
            return VgMeas.getY()*VgMeas.getY()*QPLookup.getY(PgMeas.getY());
        }
        

	public double[] getY(double[] u) {
            // u[0] = Qt  u[1] = Vt  u[2] = Pt
            // y[0] = PQLim_sup  y[1] = PQLim_out
            y[0] = filt.getStateX()-QgMeas.getStateX();
            y[1] = y[0]*GRLookup.getY(PgMeas.getStateX())*KPQ;
            
	return y;
	}

	/**
	 * return state variable for testing purpose.
	 */
	public double[] getStateX() {
            // x[0] = QgMeasState, x[1] = VgMeasState, x[2]=PgMeasState,
            // x[3] = filtState, x[4] = QPLookupY, x[5] = GRLookupY
            x[0] = QgMeas.getStateX();
            x[1] = VgMeas.getStateX();
            x[2] = PgMeas.getStateX();
            x[3] = filt.getStateX();
            x[4] = QPLookup.getY(PgMeas.getStateX());
            x[5] = GRLookup.getY(PgMeas.getStateX());
        return x;
	}
}
