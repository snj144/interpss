package custom.dstab.controller.device;

import com.interpss.dstab.controller.device.IControlDevice;
import com.interpss.common.datatype.LimitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.dstab.controller.block.DelayControlBlock;
import com.interpss.dstab.controller.block.FilterControlBlock;
import com.interpss.dstab.controller.block.IControlBlock;
import com.interpss.dstab.mach.Machine;


/**
 * Implementation Notes:
 * 
 *   input: 
 *      u[0] - Vf
 *      u[1] - Ifd
 *      
 * 
 *   output: 
 *      y[0] - Efd
 *      y[1] - Ifd0
 *      
 * @author R Oosterwijk - from MZhou device template
 *
 */
public class RotatingExciter2LL implements IControlDevice {
	private double[] u = new double[2];
	private double[] y = new double[2];
        private double[] x = new double[2];
        private double Efd = 0.0, Vf = 0.0, Ifd = 0.0, Ifd0 = 0.0;
        private double V1 = 0.0, V2 = 0.0;
        private DelayControlBlock tran = null;
        private DelayControlBlock subtran = null;
        private LimitType vLimit = null;
        
        /**
      * How to program a form to apply parameters to this device?
      */
        double Kvf=0.75, K1=4, K2=2.9, KIf=1.9, T1=0.011, T2=0.9;
        double V3max=12.0, V3min=-2.0, Vfdmax=7.0, Vfdmin=0.0;
        
        
        
        

	/**
    * This method receives vector y[0] from calling class
    * and shall initialise the required states by knowledge 
    * of its own outputs.
    * 
    * @param y0 controller output initial values
	*/
	public boolean initState(double[] y0) {
	
            Efd = y[0];
            Ifd0 = y[1];
            
            vLimit = new LimitType(Vfdmax, Vfdmin);
            subtran = new DelayControlBlock(K2, T2);
            if (!(subtran.initState(Efd-(Ifd0*KIf)))) {return false;}
            if ((subtran.getU0()-Ifd0*KIf) > Vfdmax) { return false;}
            if ((subtran.getU0()-Ifd0*KIf) < Vfdmin) { return false;}
            tran = new DelayControlBlock(IControlBlock.Type_Limit, K1, T1, V3max, V3min);
            if (!(tran.initState(subtran.getU0()))) {return false;}
            
            return true;
        }
	
	/**
    * This method called by the upstream controller block/device for initialization
    * purpose. It has to called called after the initState method() called.
    */
        
	public double[] getU0() {
            //    u[0] = Vf   u[1] = Ifd
            u[0] = tran.getU0() - Efd*Kvf;
            u[1] = Ifd0;
            
		return u;
	}

	public void eulerStep1(double[] u, double dt) {
		//  diff eqn implementation step 1
	V1 = u[0] - Efd*Kvf;
        tran.eulerStep1(V1, dt);
        V2 = calculateV2();
        subtran.eulerStep1(V2, dt);
        
	}

	public void eulerStep2(double[] u, double dt) {
		// TODO diff eqn implementation needed
	V1 = u[0] - Efd*Kvf;
        tran.eulerStep2(V1, dt);
        V2 = calculateV2();
        subtran.eulerStep2(V2, dt);
        
	}
        
        private double calculateV2() { return tran.getY(); }

	public double[] getY(double[] u) {
		// u[0] = Vf   u[1] = Ifd
                // y[0] = Efd  y[1] = Ifd0
            y[0] = vLimit.limit(tran.getY());
            y[1] = Ifd0;
		return y;
	}

	/**
	 * return state variable for testing purpose.
	 */
	public double[] getStateX() {
            x[0] = subtran.getStateX();
            x[1] = tran.getStateX();
            return x;
	}
}
