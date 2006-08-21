package com.interpss.test.user;

import java.util.logging.Level;

import org.jgraph.JGraph;

import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.NetUtilFunc;
import com.interpss.common.util.Num2Str;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.editor.EditorSpringAppContext;
import com.interpss.editor.SimuAppSpringAppContext;
import com.interpss.editor.form.GFormContainer;
import com.interpss.editor.jgraph.ui.IIpssGraphModel;
import com.interpss.editor.jgraph.ui.form.IGFormContainer;
import com.interpss.editor.util.IOUtilFunc;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuSpringAppContext;
import com.interpss.simu.io.IpssFileAdapter;

import fit.ColumnFixture;

public class IpssFixture extends ColumnFixture {
	protected static SimuContext simuCtx = null;
	protected static IPSSMsgHub    msg;
	
	// ActionFixture
	private String filename = "C:/eclipse/GEditor/projects/samples/ieee_format/ieee14.ieee";
	private String adapterClass = "default";
	
	// ColumnFixture
	public static String busId;
	public static String branchFromBusId;
	public static String branchToBusId;
	public static int branchCircuitNumber = 1;
	
	public IpssFixture() {
		if (SpringAppContext.SpringAppCtx == null) {
			SpringAppContext.SpringAppCtxConfigXmlFile = "properties/springConfig/editorAppContext.xml";
			EditorSpringAppContext.springAppContextSetup();
		}
			
 		IpssLogger.getLogger().setLevel(Level.WARNING);	
		try {
			if (simuCtx == null) {
				msg = SpringAppContext.getIpssMsgHub();
		  		simuCtx = SimuSpringAppContext.getSimuContext();
			}
 		} catch (Exception e) {
 			IpssLogger.logErr(e);
		}
 	}
	
	/*
	 * ActionFixture functions
	 */
	
	public void loadCaseData() {
		IpssFileAdapter adapter = null;
		try {
			if (!adapterClass.equals("default")) {
				Class c = Class.forName(adapterClass);
				adapter = (IpssFileAdapter)c.newInstance();
			}

			if (adapter != null) {
				adapter.load(simuCtx, filename, msg);
			}	
			else {
				JGraph graph = IOUtilFunc.loadIpssGraphFile(filename);
				IGFormContainer gFormContainer = ((IIpssGraphModel)graph.getModel()).getGFormContainer();
				IpssMapper mapper = SimuAppSpringAppContext.getEditorJGraphDataMapper();
				mapper.mapping(gFormContainer, simuCtx, GFormContainer.class);
			}
		} catch (Exception e) {
      		IpssLogger.logErr(e);
			msg.sendErrorMsg(e.toString());
      	}
	}
	
	public void setFilePathName(String name) {
		filename = name;
	}
	
	public void setFileAdapterClass(String klass) {
		adapterClass = klass;
	}
	
	public int noOfBuses() {
		return simuCtx.getNetwork().getNoBus();
	}

	public int noOfBranches() {
		return simuCtx.getNetwork().getNoBranch();
	}

	/*
	 * Utility functions
	 */
	
	protected double formatDouble(double x) {
		return new Double(Num2Str.toStr(x)).doubleValue();
	}

	protected AclfBus getBus() throws Exception {
		AclfBus bus = simuCtx.getAclfNet().getAclfBus(busId);
		if (bus == null)
			throw new Exception("Bus not found, busId: " + busId);
		return bus;
	}

	protected AclfBranch getBranch() throws Exception {
		AclfBranch branch = (AclfBranch)simuCtx.getAclfNet().getBranch(branchFromBusId, branchToBusId, branchCircuitNumber);
		if (branch == null)
			throw new Exception("Branch not found, fromId, toId: " + branchFromBusId + ", " + branchToBusId);
		return branch;
	}	

	protected String getBranchId() {
		return NetUtilFunc.formBranchID(branchFromBusId, branchToBusId, 1);
	}

	public void setBaseKva(double kva) {
		simuCtx.getNetwork().setBaseKva(kva);
	}
}
