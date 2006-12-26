package custom.dstab.controller.device;

import com.interpss.dstab.controller.device.IControlDevice;


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
 *
 */
public class PQLoadAngleLimiter implements IControlDevice {
	private double[] u = new double[3];
	private double[] y = new double[2];
 
	public boolean initState(double[] y0) {
		//TODO: RO makes some assumptions
            /* This area receives vector y[0 1] from calling class
             * and shall initialise the required states by knowledge 
             * of its own outputs
             */
            boolean success = true;
            if (success) return true;
            else return false;
	}
	
	/**
	 * This method called after the initState called.
	 */
        //TODO: RO makes some assumptions
        /*
         *this method called by originating controller?
         *receives nothing - at the moment
         *can be used for setting initial states for cases where inputs are
         *required for setting
         */
        
	public double[] getU0() {
            /* should this method receive parameters, to tell the controller
             * which machine and bus it should get data from?
             *
             * then e.g. can getMachine().getQbus() to use for setting states
             */
                       
		return u;
	}

	public void eulerStep1(double[] u, double dt) {
		// TODO diff eqn implementation needed
	/* RO assumes we create the math step 1. 
         * presumably the ControlBlock extensions could be used
         */	
	}

	public void eulerStep2(double[] u, double dt) {
		// TODO diff eqn implementation needed
	/* RO assumes we create the math step 2
         */	
	}

	public double[] getY(double[] u) {
		// need more impl
            /* TODO: RO: For flexibility, sometimes it would make sense
             * to send the u from calling class, other times to get the 
             * u from this class.
             * Is it expected to send an empty set of u, or data of net/mach/bus
             * to allow this method to calculate its own inputs?
             */
		return y;
	}

	/**
	 * return state variable for testing purpose.
	 */
	public double[] getStateX() {

		return null;
	}
}
