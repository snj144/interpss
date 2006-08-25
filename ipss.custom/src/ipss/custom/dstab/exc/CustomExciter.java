package ipss.custom.dstab.exc;



import java.util.Hashtable;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.Num2Str;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.control.exc.AbstractExciter;
import com.interpss.dstab.mach.Machine;

public class CustomExciter extends AbstractExciter {
	// state vriables
	double _Vref = 0.0, _X1 = 0.0;
	LimitType _Limit = null; 
	
	// UI Editor panel
	private static NBCustomExciterEditPanel _editPanel = new NBCustomExciterEditPanel();
	
	/**
	 * Default Constructor
	 *
	 */
	public CustomExciter() {
		this("excId", "excName", "InterPSS"); 
	}
	
	/**
	 * Constructor
	 * 
	 * @param id excitor id
	 * @param name excitor name
	 */
	public CustomExciter(String id, String name, String caty) {
		super(id, name, caty);
		// _data is defined in the parent class. However init it here is a MUST
		_data = new CustomExciterData();
	}
	
	/**
	 * Get the excitor data 
	 * 
	 * @return the data object
	 */
	public CustomExciterData getData() {
		return (CustomExciterData)_data;
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	public boolean initStates(IPSSMsgHub msg) {
		_Limit = new LimitType(getData().getVrmax(), getData().getVrmin()); 
		Machine mach = getMachine();
		_X1 = mach.getEfd();
		double vt = mach.getBus().getVoltage().abs() / mach.getVMultiFactor();
		_Vref = (_X1 + getData().getKa()*vt) / getData().getKa();
		return true;
	}
	
	private double cal_dX1_dt(double X1) {
		Machine mach = getMachine();
		double vt = mach.getBus().getVoltage().abs() / mach.getVMultiFactor();
		double vpss = mach.hasStabilizer()? mach.getStabilizer().getOutput() : 0.0;
		return ( getData().getKa() * ( _Vref + vpss - vt ) - X1) / getData().getTa();
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
			 //     Step-1 : x(1) = x(0) + dx_dt(1) * dt
			double dX1_dt = cal_dX1_dt(_X1);
			double X1 = _X1 + dX1_dt * dt;

			 //     Step-2 : x(2) = x(0) + 0.5 * (dx_dt(2) + dx_dt(1)) * dt
			_X1 += _X1 + 0.5 * ( cal_dX1_dt(X1) + dX1_dt ) * dt;
		}
		else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
			// TODO: TBImpl
		}
		else 
			throw new InvalidInputException("SimpleExciter.nextStep(), invalid method");
	}

	/**
	 * Get controller states for display purpose
	 * 
	 * @return hashtable of the states
	 */
	public Hashtable getStates(Object ref) {
		Hashtable table = new Hashtable();
		table.put("Efd", Num2Str.toStr("0.0000", _Limit.limit(_X1)));
		return table;
	}
	
	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */
	public double getOutput() {
		return _Limit.limit(_X1);
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

