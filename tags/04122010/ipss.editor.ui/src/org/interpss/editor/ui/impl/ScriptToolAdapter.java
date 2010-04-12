package org.interpss.editor.ui.impl;

import java.util.Hashtable;
import java.util.List;

import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.IScriptTool;

import com.interpss.common.exp.InterpssRuntimeException;

public class ScriptToolAdapter implements IScriptTool {
	public void outDStabResult2TextDialog(IOutputTextDialog textDialog,
			List<String> nameList, List<Hashtable<String, String>> valueList) {
		throw new InterpssRuntimeException("ScriptToolAdapter.OutDStabResult2TextDialog() needs to be impled");
	}
}
