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
		// TODO Auto-generated method stub
		return false;
	}
	
	public double[] getU0() {
		return u;
	}

	public void eulerStep1(double[] u, double dt) {
		// TODO diff eqn implementation needed
		
	}

	public void eulerStep2(double[] u, double dt) {
		// TODO diff eqn implementation needed
		
	}

	public double[] getY(double[] u) {
		return y;
	}

	/**
	 * return state variable for testing purpose.
	 */
	public double[] getStateX() {

		return null;
	}
}
