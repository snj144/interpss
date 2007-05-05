package org.interpss.editor.ui;

import java.util.Hashtable;
import java.util.List;

import com.interpss.dstab.DStabilityNetwork;

public interface IScriptTool {
	/**
	 * 
	 * 
	 * @param textDialog
	 * @param nameList
	 * @param valueList
	 */
	public void outDStabResult2TextDialog(			   
			IOutputTextDialog textDialog,   // out text dialog
			List<String> nameList,          // variable name list
			List<Hashtable<String, String>> valueList);  // var value list);
	/**
	 * 
	 * @param net
	 * @throws Exception
	 */
	public void initDStabOutputScripting(DStabilityNetwork net) throws Exception;

	/**
	 * 
	 * @param net
	 * @param stateTable
	 * @return
	 */
	public boolean machStatesDStabOutputScripting(DStabilityNetwork net, Hashtable stateTable);

	/**
	 * 
	 * @param net
	 * @param varTable
	 * @return
	 */
	public boolean busVariablesDStabOutputScripting(DStabilityNetwork net, Hashtable varTable);

	/**
	 * 
	 * @param net
	 * @param stateTable
	 * @return
	 */
	public boolean busDeviceStatesDStabOutputScripting(DStabilityNetwork net, Hashtable stateTable);

	/**
	 * 
	 * @throws Exception
	 */
	public void endOfSimuStepDStabOutputScripting() throws Exception;

	/**
	 * 
	 * @throws Exception
	 */
	public void closeDStabOutputScripting() throws Exception;
}
