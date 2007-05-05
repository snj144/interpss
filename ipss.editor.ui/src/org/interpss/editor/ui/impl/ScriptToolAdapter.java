package org.interpss.editor.ui.impl;

import java.util.Hashtable;
import java.util.List;

import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.IScriptTool;

import com.interpss.common.exp.InterpssRuntimeException;
import com.interpss.dstab.DStabilityNetwork;

public class ScriptToolAdapter implements IScriptTool {

	public boolean busDeviceStatesDStabOutputScripting(DStabilityNetwork net, Hashtable stateTable) {
		throw new InterpssRuntimeException("ScriptToolAdapter.busDeviceStatesDStabOutputScripting() needs to be impled");
	}

	public boolean busVariablesDStabOutputScripting(DStabilityNetwork net, Hashtable varTable) {
		throw new InterpssRuntimeException("ScriptToolAdapter.OutDStabResult2TextDialog() needs to be impled");
	}

	public void closeDStabOutputScripting() throws Exception {
		throw new InterpssRuntimeException("ScriptToolAdapter.busVariablesDStabOutputScripting() needs to be impled");
	}

	public void endOfSimuStepDStabOutputScripting() throws Exception {
		throw new InterpssRuntimeException("ScriptToolAdapter.endOfSimuStepDStabOutputScripting() needs to be impled");
	}

	public void initDStabOutputScripting(DStabilityNetwork net) throws Exception {
		throw new InterpssRuntimeException("ScriptToolAdapter.initDStabOutputScripting() needs to be impled");
	}

	public boolean machStatesDStabOutputScripting(DStabilityNetwork net, Hashtable stateTable) {
		throw new InterpssRuntimeException("ScriptToolAdapter.machStatesDStabOutputScripting() needs to be impled");
	}

	public void outDStabResult2TextDialog(IOutputTextDialog textDialog,
			List<String> nameList, List<Hashtable<String, String>> valueList) {
		throw new InterpssRuntimeException("ScriptToolAdapter.OutDStabResult2TextDialog() needs to be impled");
	}
}
