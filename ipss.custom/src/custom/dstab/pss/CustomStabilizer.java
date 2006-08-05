/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package custom.dstab.pss;

import java.util.Hashtable;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.Num2Str;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.control.pss.AbstractStabilizer;

public class CustomStabilizer extends AbstractStabilizer {
	// state variables
	double 	_X1 = 0.0, _X2 = 0.0;
	LimitType _Limit = null;

	// UI Editor panel
	private static NBCustomStabilizerEditPanel _editPanel = new NBCustomStabilizerEditPanel();
	
	/**
	 * Default constructor
	 *
	 */
	public CustomStabilizer() {
		this("pssId", "pssName");
	}
	
	/**
	 * Constructor
	 * 
	 * @param id pss id
	 * @param name pss name
	 */	
	public CustomStabilizer(String id, String name) {
		super(id, name);
		// _data is defined in the parent class. However init it here is a MUST
		_data = new CustomStabilizerData();
	}
	
	/**
	 * Get the PSS data 
	 * 
	 * @return the data object
	 */
	public CustomStabilizerData getData() {
		return (CustomStabilizerData)_data;
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	public boolean initStates(IPSSMsgHub msg) {
		_Limit = new LimitType(getData().getVsmax(), getData().getVsmin());
		_X1 = 0.0;
		_X2 = 0.0;
		return true;
	}

	private double cal_dX1_dt(double X1) {
		double a = ( 1.0 - getData().getT1()/getData().getT2() );
		double dw = getMachine().getSpeed() - 1.0;
		double x = getData().getKs() * a * dw - X1;
		return x / getData().getT2();
	}

	private double cal_dX2_dt(double X1, double X2) {
		double a = ( 1.0 - getData().getT3()/getData().getT4() );
		double dw = getMachine().getSpeed() - 1.0;
		double x = a * ( getData().getKs() * dw * getData().getT1() / getData().getT2() + X1 ) - X2;
		return x / getData().getT4();
	}
	
	/**
	 * Perform one step d-eqn calculation
	 *  
	 * @param dt simulation time interval
	 * @param method d-eqn solution method
	 *  @param msg the SessionMsg object
	 */	
	public void nextStep(double dt, DynamicSimuMethods method, double baseFreq, IPSSMsgHub msg) {
		if (method == DynamicSimuMethods.MODIFIED_EULER_LITERAL) {
			// Step-1 : x(1) = x(0) + dx_dt(1) * dt
			double _dX1_dt = cal_dX1_dt(_X1);
			double _dX2_dt = cal_dX2_dt(_X1, _X2);
			double X1_1 = _X1 + _dX1_dt * dt;
			double X2_1 = _X2 + _dX2_dt * dt;

			// Step-2 : x(2) = x(1) + (dx_dt(2) - dx_dt(1)) * dt
			_X1 += _X1 + 0.5 * (cal_dX1_dt(X1_1) + _dX1_dt) * dt;
			_X2 += _X2 + 0.5 * (cal_dX2_dt(X1_1, X2_1) + _dX2_dt) * dt;
		}
		else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
			// TODO: TBImpl
		}
		else
			throw new InvalidInputException("SimplePSS.nextStep(), invalid method");
	}

	/**
	 * Get controller states for display purpose
	 * 
	 * @return hashtable of the states
	 */	
	public Hashtable getStates(Object ref) {
		Hashtable<String,String> table = new Hashtable<String,String>();
		table.put("PSS_Vs", Num2Str.toStr("0.0000", getOutput()));
		return table;
	}

	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */	
	public double getOutput() {
		double a = getData().getT3()/getData().getT4();
		double dw = getMachine().getSpeed() - 1.0;
		return _Limit.limit(getData().getKs()*dw*a*getData().getT1()/getData().getT2() + a*_X1 + _X2);
	}

	/**
	 * Get the editor panel for controller data editing
	 * 
	 * @return the editor panel object
	 */	
	public Object getEditPanel() {
		_editPanel.init(this);
		return _editPanel;
	}
} // SimpleExcAdapter
