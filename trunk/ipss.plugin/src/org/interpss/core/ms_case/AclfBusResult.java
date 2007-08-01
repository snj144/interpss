package org.interpss.core.ms_case;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.ComplexFunc;
import com.interpss.common.util.Number2String;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.ms_case.impl.BusResultImpl;

public class AclfBusResult extends BusResultImpl {
	public Complex load, gen, voltage;
	
	public AclfBusResult(AclfBus bus) {
		this.setBus(bus);
	}

	public String toString() {
		return "busid, voltage, gen, load: " + this.getBus().getId() + ", " + 
					Number2String.toStr(voltage.abs()) + ", " +
			 		ComplexFunc.toString(gen) + ", "  + ComplexFunc.toString(load);
	}
}
