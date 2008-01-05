package org.interpss.display;

/**
 * Text out dstab simulation action handler for processing dstab output events. This is mainly for 
 * debug purpose 
 */

import java.util.Hashtable;

import com.interpss.common.msg.IpssMessage;
import com.interpss.dstab.datatype.DStabSimuAction;
import com.interpss.dstab.util.AbstractSimuOutputHandler;

public class TextSimuOutputHandler extends AbstractSimuOutputHandler {
	public TextSimuOutputHandler() {
	}
	
	public void onMsgEvent(IpssMessage event) {
		// Plot step outout message processing
		DStabSimuAction e = (DStabSimuAction)event;
	    if (e.getType() == DStabSimuAction.PlotStepMachineStates) {
	    	Hashtable<String, Object> machStates = e.getHashtableData();
			try {
				System.out.print(DStabOutFunc.getStateStr(machStates));
			} catch (Exception exp) {
				exp.printStackTrace();
			}
	    }
	    else if (e.getType() == DStabSimuAction.PlotStepBusStates) {
		   	//Hashtable<String, Object> busVariables = e.getHashtableData();
	    }
	    else if (e.getType() == DStabSimuAction.PlotStepScriptDynamicBusDeviceStates) {
		   	//Hashtable<String, Double> scriptVariables = e.getHashtableData();
	    }

		// Simulaiton time step outout message processing
	    if (e.getType() == DStabSimuAction.TimeStepMachineStates) {
		   	//Hashtable<String, Object> machStates = e.getHashtableData();
	    }
	    else if (e.getType() == DStabSimuAction.TimeStepBusStates) {
		   	//Hashtable<String, Object> busVariables = e.getHashtableData();
	    }
	    else if (e.getType() == DStabSimuAction.TimeStepScriptDynamicBusDeviceStates) {
		   	//Hashtable<String, Object> scriptVariables = e.getHashtableData();
	    }
	}
	
	@Override
	public boolean onMsgEventStatus(IpssMessage e) {
		onMsgEvent(e);
		return true;		
	}	
}