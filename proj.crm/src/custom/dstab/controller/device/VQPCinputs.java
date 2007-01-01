package custom.dstab.controller.device;

import com.interpss.dstab.controller.device.IControlDevice;
import com.interpss.dstab.controller.block.DelayControlBlock;
import com.interpss.dstab.controller.block.IControlBlock;



/**
 * Implementation Notes:
 * 
 *   input: 
 *      u[0] - Vref
 *      u[1] - Vt
 *      u[2] - Qt
 *      u[3] - Qt2
 *      u[4] - Pt
 * 
 *   output: 
 *      y[0] - Vc
 *      y[1] - vRef
 *      
 * @author RonO
 *
 */
public class VQPCinputs implements IControlDevice {
	private double[] u = new double[5];
        private double[] x = new double[4];
        private double[] y = new double[2];
        private DelayControlBlock UgMeas = null;
        private DelayControlBlock QgMeas = null;
        private DelayControlBlock QcMeas = null;
        private DelayControlBlock PgMeas = null;
        private double vRef = 0.0;
        
        /*
         * How to use a form to get parameters into this block?
         */
        private double TR = 0.020, KIR = -0.05, KCC=0.03, KIA=0.00;
                
        
	/**
    * This method receives vector u[0 1 2 3 4] from calling class
    * and shall initialise the required states by this knowledge 
    * 
    * @param u0 controller initial values Vc0 Vt Qt Qt2 Pt
	*/
	public boolean initState(double[] u0) {
            
            // must initialise from inputs in this device
            // u[0] - Vc0, u[1] - Vt, u[2] - Qt, u[3] - Qt2, u[4] - Pt
            UgMeas = new DelayControlBlock(1, TR);
            if (!(UgMeas.initState(u[1]))) return false;
            QgMeas = new DelayControlBlock(1, TR);
            if (!(QgMeas.initState(u[2]))) return false;
            QcMeas = new DelayControlBlock(1, TR);
            if (!(QcMeas.initState(u[3]))) return false;
            PgMeas = new DelayControlBlock(1, TR);
            if (!(PgMeas.initState(u[4]))) return false;
            
            vRef = u[0] + (UgMeas.getU0()-QgMeas.getU0()*KIR
                           -(QgMeas.getU0()+QcMeas.getU0())*KCC
                           -PgMeas.getU0()*KIA);
            
            // set the vRef in the calling class from getU0
            
            return true;
        }
	
	/**
    * This method called by the upstream controller block/device for initialization
    * purpose. It has to called called after the initState method() called.
    */
        
	public double[] getU0() {
            //u[0] = Vref, u[1] = Ug, u[2] = Qg, u[3] = Qc, u[4] - Pg
            u[0] = vRef;
            u[1] = UgMeas.getU0();
            u[2] = QgMeas.getU0();
            u[3] = QcMeas.getU0();
            u[4] = PgMeas.getU0();
	return u;
	}

	public void eulerStep1(double[] u, double dt) {
            UgMeas.eulerStep1(u[1], dt);
            QgMeas.eulerStep1(u[2], dt);
            QcMeas.eulerStep1(u[3], dt);
            PgMeas.eulerStep1(u[4], dt);
	}

	public void eulerStep2(double[] u, double dt) {
            UgMeas.eulerStep2(u[1], dt);
            QgMeas.eulerStep2(u[2], dt);
            QcMeas.eulerStep2(u[3], dt);
            PgMeas.eulerStep2(u[4], dt);
	}
        
        
        public double[] getY(double[] u) {
            // y[0] - Vc, y[1] - vRef
            vRef = u[0];
            y[0] = vRef + QgMeas.getY(u[2])*KIR
                        + (QgMeas.getY(u[2])+QcMeas.getY(u[3]))*KCC
                        + PgMeas.getY(u[4])*KIA
                        - UgMeas.getY(u[1]);
            y[1] = vRef;
	return y;
	}

	/**
	 * return state variable for testing purpose.
	 */
	public double[] getStateX() {
            // x[0] = UgMeasState, x[1] = QgMeasState, x[2]=QcMeasState, x[3] = PgMeasState
            x[0] = UgMeas.getStateX();
            x[1] = QgMeas.getStateX();
            x[2] = QcMeas.getStateX();
            x[3] = PgMeas.getStateX();
        return x;
	}
}
