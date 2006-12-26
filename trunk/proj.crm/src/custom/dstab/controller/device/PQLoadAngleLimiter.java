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

	/**
    * This method receives vector y[0 1] from calling class
    * and shall initialise the required states by knowledge 
    * of its own outputs.
    * 
    * @param y0 controller output initial values
	*/
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
    * This method called by the upstream controller block/device for initialization
    * purpose. It has to called called after the initState method() called.
    */
        
	public double[] getU0() {
            /* should this method receive parameters, to tell the controller
             * which machine and bus it should get data from?
             *
             * then e.g. can getMachine().getQbus() to use for setting states
             * 
             * Mike: I think controller block and device should be atomic. Their parameters, inputs 
             * are depending the Machine, Bus or even Network object. However, they should know 
             * how to "behavior" themsleves.
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
             * 
             * Mike: u should always coming from outside
             * 
             * Is it expected to send an empty set of u, or data of net/mach/bus
             * to allow this method to calculate its own inputs?
             * 
             * For delay block, y totally depend on the state variable, so u is empty
             * For washout block, y = f(x, u), so we need pass u in
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
