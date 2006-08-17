package com.interpss.editor.chart;

import java.awt.event.ActionEvent;
import java.util.Hashtable;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;

import org.apache.commons.math.complex.Complex;

import com.interpss.chart.dist.LoadScheduleChart;
import com.interpss.chart.dstab.SimpleOneStateChart;
import com.interpss.common.SpringAppContext;
import com.interpss.common.io.IProjectDataManager;
import com.interpss.common.io.ISimuRecManager;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Num2Str;
import com.interpss.common.util.StringUtil;
import com.interpss.dist.DistBus;
import com.interpss.dist.DistNetwork;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.util.DStabOutFunc;
import com.interpss.dstab.util.DStabSimuDBRecord;
import com.interpss.editor.SimuAppSpringAppContext;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.cells.BusCell;
import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.editor.jgraph.ui.form.IGBusForm;
import com.interpss.editor.ui.IOutputTextDialog;
import com.interpss.editor.ui.UISpringAppContext;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

public class ChartManager {
	public static void addPopupMenuAction(JPopupMenu menu, final Object cell) {
		menu.addSeparator();

		if (cell instanceof BusCell) { 
			final IGBusForm bus = ((BusCell)cell).getBusForm();
			IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
			SimuContext simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
			if (simuCtx.getNetType() == SimuCtxType.DISTRIBUTE_NET_LITERAL &&
					simuCtx.getDistNet().getLoadNetData().getSchedulePoints() > 0 &&
					appSimuCtx.isLfConverged()) {
				menu.add(new AbstractAction("Plot Load Curve") {
					public void actionPerformed(ActionEvent e) {
						ChartManager.chartBusLoadCurve(bus.getId());
					}
				});
			}
			else if (simuCtx.getNetType() == SimuCtxType.DSTABILITY_NET_LITERAL) {
				int caseId = SimuAppSpringAppContext.getDStabRunForm().getDbSimuCaseId();
				if (caseId > 0 ) {
					DStabBus dstabBus = simuCtx.getDStabilityNet().getDStabBus(bus.getId());
					if (dstabBus.getMachine() != null) {
					    addMachItem2ActionList(menu, dstabBus.getMachine(), caseId, 
					    		simuCtx.getDStabilityNet().getFrequency(), simuCtx.getDStabilityNet().getBaseKva());
					    addControllerItem2ActionList(menu, dstabBus.getMachine(), caseId, "Exciter", 
					    		ISimuRecManager.REC_TYPE_DStabExcStates, DStabSimuDBRecord.EXCITER_ID_EXT, 
					    		simuCtx.getDStabilityNet().getBaseKva());
					    addControllerItem2ActionList(menu, dstabBus.getMachine(), caseId, "Governor", 
					    		ISimuRecManager.REC_TYPE_DStabGovStates, DStabSimuDBRecord.GOVERNER_ID_EXT, 
					    		simuCtx.getDStabilityNet().getBaseKva());
					    addControllerItem2ActionList(menu, dstabBus.getMachine(), caseId, "Stabilizer", 
					    		ISimuRecManager.REC_TYPE_DStabPssStates, DStabSimuDBRecord.STABILIZER_ID_EXT, 
					    		simuCtx.getDStabilityNet().getBaseKva());
					}
					else {
					    addBusItem2ActionList(menu, dstabBus.getId(), caseId);
					}
				}
			}
		}	
	}
	
	//===========================================
	//  DStab Plot Functions
	//===========================================

    private static void addMachItem2ActionList(JPopupMenu menu, final Machine mach, final int caseId, double baseFreq, double baseKva) {
		JMenu machStateMenu = new JMenu("Machine State");
		menu.add(machStateMenu);
		Object[] stateList = getStatesNameList(caseId, mach.getId(), ISimuRecManager.REC_TYPE_DStabMachineStates);
		for (int i = 0; i < stateList.length; i++) {
			final String yLabel = (String)stateList[i];
			final String yDataLabel = getMachDataLabel(mach, yLabel, baseFreq, baseKva);
			machStateMenu.add(new AbstractAction("Plot Machine State - " + yLabel) {
				public void actionPerformed(ActionEvent e) {
				    plotStateCurve(caseId, mach.getId(), yLabel, yDataLabel, ISimuRecManager.REC_TYPE_DStabMachineStates);
				}
			});
		}
		machStateMenu.add(new AbstractAction("Machine State Table Output") {
			ISimuRecManager simuRecManager = SpringAppContext.getSimuRecManager();
			public void actionPerformed(ActionEvent e) {
	    		List machRecList = simuRecManager.getSimuRecList(caseId, 
	    				ISimuRecManager.REC_TYPE_DStabMachineStates, mach.getId(), IProjectDataManager.CaseType_DStabSimuRec);
				if (machRecList.size() > 0) {
					IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
					if (appSimuCtx.isSimuNetDataDirty()) {
						SpringAppContext.getIpssMsgHub().sendWarnMsg("The SimuNetwork object is dirty. You may want to re-run the analysis");
					}
			  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Machine State Output");
			  		dialog.display(machRecList);
				}
			}
		});    	
    }
    
    private static void addControllerItem2ActionList(JPopupMenu menu, final Machine mach, 
    		final int caseId, String name, final String recType, final String idExt, double baseKva) {
		JMenu excStateMenu = new JMenu(name + " State");
		menu.add(excStateMenu);
		Object[] stateList = getStatesNameList(caseId, mach.getId()+idExt, recType);
		for (int i = 0; i < stateList.length; i++) {
			final String yLabel = (String)stateList[i];
			String str = "";
			if (recType.equals(ISimuRecManager.REC_TYPE_DStabExcStates))
				str = getExcDataLabel(mach, yLabel);
			else if (recType.equals(ISimuRecManager.REC_TYPE_DStabGovStates))
				str = getGovDataLabel(mach, yLabel, baseKva);
			else if (recType.equals(ISimuRecManager.REC_TYPE_DStabPssStates))
				str = getPssDataLabel(mach, yLabel);
			final String yDataLabel = str;
			excStateMenu.add(new AbstractAction("Plot " + name + " State - " + yLabel) {
				public void actionPerformed(ActionEvent e) {
				    plotStateCurve(caseId, mach.getId()+idExt, yLabel, yDataLabel, recType);
				}
			});
		}		
    }
    
/*
	public static final String OUT_SYMBOL_MACH_ID 		= "MachId";
	public static final String OUT_SYMBOL_MACH_ANG 		= "Mach Ang";
	public static final String OUT_SYMBOL_MACH_SPEED 	= "Mach Speed";
	public static final String OUT_SYMBOL_MACH_PE 		= "Mach Pe";
	public static final String OUT_SYMBOL_MACH_PM 		= "Mach Pm";
	public static final String OUT_SYMBOL_MACH_Q 		= "Mach Q";
	public static final String OUT_SYMBOL_MACH_E 		= "Mach E";
	public static final String OUT_SYMBOL_MACH_EQ1 		= "Mach Eq1";
	public static final String OUT_SYMBOL_MACH_EQ11 	= "Mach Eq11";
	public static final String OUT_SYMBOL_MACH_ED1 		= "Mach Ed1";
	public static final String OUT_SYMBOL_MACH_ED11 	= "Mach Ed11";
*/    
    private static String getMachDataLabel(Machine mach, String state, double baseFreq, double baseKva) {
    	String id = "Machine Id:" + mach.getId() + ", ";
    	String ratedV = Num2Str.toStr("0.0",mach.getRatedVoltage());
    	String rating = Num2Str.toStr("0.0",mach.getRating()*baseKva/1000.0);
    	String rpm = Num2Str.toStr((int)(2.0*baseFreq*60.0/mach.getPoles()));
    	String baseV = Num2Str.toStr("0.0",mach.getBus().getBaseVoltage());
    	if (state.equals(DStabOutFunc.OUT_SYMBOL_MACH_ANG)) 
    		return id + "(Unit:Rad)";
    	else if (state.equals(DStabOutFunc.OUT_SYMBOL_MACH_SPEED))
    		return id + "(Unit:PU, RPM:" + rpm + ")";
    	else if (state.equals(DStabOutFunc.OUT_SYMBOL_MACH_PE))
    		return id + "(Unit:PU, Rating:" + rating + " mva)";
    	else if (state.equals(DStabOutFunc.OUT_SYMBOL_MACH_PM))
    		return id + "(Unit:PU, Rating:" + rating + " mva)";
    	else if (state.equals(DStabOutFunc.OUT_SYMBOL_MACH_Q ))
    		return id + "(Unit:PU, Rating:" + rating + " mva)";
    	else if (state.equals(DStabOutFunc.OUT_SYMBOL_MACH_E))
    		return id + "(Unit:PU, Voltage Base:" + ratedV +" Volts)";
    	else if (state.equals(DStabOutFunc.OUT_SYMBOL_MACH_EQ1))
    		return id + "(Unit:PU, Voltage Base:" + ratedV +" Volts)";
    	else if (state.equals(DStabOutFunc.OUT_SYMBOL_MACH_EQ11))
    		return id + "(Unit:PU, Voltage Base:" + ratedV +" Volts)";
    	else if (state.equals(DStabOutFunc.OUT_SYMBOL_MACH_ED1))
    		return id + "(Unit:PU, Voltage Base:" + ratedV +" Volts)";
    	else if (state.equals(DStabOutFunc.OUT_SYMBOL_MACH_ED11))
    		return id + "(Unit:PU, Voltage Base:" + ratedV +" Volts)";
    	else if (state.equals(DStabOutFunc.OUT_SYMBOL_BUS_VMAG))
    		return id + "(Unit:PU, Voltage Base:" + baseV +" Volts)";
    	else if (state.equals(DStabOutFunc.OUT_SYMBOL_BUS_VANG))
    		return id + "(Unit:Rad)";
    	else
    		return "unknown";
    }

    /*
	public static final String OUT_SYMBOL_EXC_EFD 		= "Exciter Efd";
*/    
    private static String getExcDataLabel(Machine mach, String state) {
    	String id = "Machine Id:" + mach.getId() + ", ";
    	String ratedV = Num2Str.toStr("0.0",mach.getRatedVoltage());
    	if (state.equals(DStabOutFunc.OUT_SYMBOL_EXC_EFD))
    		return id + "(Unit:PU, Voltage Base:" + ratedV +" Volts)";
    	else
    		return "unknown";
    }

    /*
	public static final String OUT_SYMBOL_GOV_PM 		= "Governor Pm";
*/    
    private static String getGovDataLabel(Machine mach, String state, double baseKva) {
    	String id = "Machine Id:" + mach.getId() + ", ";
    	String rating = Num2Str.toStr("0.0",mach.getRating()*baseKva/1000.0);
    	if (state.equals(DStabOutFunc.OUT_SYMBOL_GOV_PM))
    		return id + "(Unit:PU, Rating:" + rating + " mva)";
    	else
    		return "unknown";
    }

    /*
	public static final String OUT_SYMBOL_PSS_VS 		= "PSS Vs";
*/    
    private static String getPssDataLabel(Machine mach, String state) {
    	String id = "Machine Id:" + mach.getId() + ", ";
    	String ratedV = Num2Str.toStr("0.0",mach.getRatedVoltage());
    	if (state.equals(DStabOutFunc.OUT_SYMBOL_PSS_VS))
    		return id + "(Unit:PU, Voltage Base:" + ratedV +" Volts)";
    	else
    		return "unknown";
    }

    /*
	public static final String OUT_SYMBOL_BUS_VMAG 		= "Bus Volt Mag";
	public static final String OUT_SYMBOL_BUS_VANG 		= "Bus Volt Ang";
	public static final String OUT_SYMBOL_BUS_PLOAD 	= "Bus Load P";
	public static final String OUT_SYMBOL_BUS_QLOAD 	= "Bus Load Q";
*/    
    private static String getBusDataLabel(Machine mach, String state) {
    	return "xxxxxx";
    	
    }

    private static void addBusItem2ActionList(JPopupMenu menu, final String busId, final int caseId) {
		JMenu busStateMenu = new JMenu("Bus Variable");
		menu.add(busStateMenu);
		Object[] stateList = getStatesNameList(caseId, busId, ISimuRecManager.REC_TYPE_DStabBusStates);
		for (int i = 0; i < stateList.length; i++) {
			final String yLabel = (String)stateList[i];
			final String yDataLabel = "xxxx";
			busStateMenu.add(new AbstractAction("Plot Bus Variable - " + yLabel) {
				public void actionPerformed(ActionEvent e) {
				    plotStateCurve(caseId, busId, yLabel, yDataLabel, ISimuRecManager.REC_TYPE_DStabBusStates);
				}
			});
		}
	}
    
    /**
     * Get plot element (Machine, Bus) state name list
     * 
     * @param caseId simulation case id
     * @param elemId element id
     * @param recType element record type
     * @return a list of names
     */
    public static Object[] getStatesNameList(int caseId, String elemId, String recType) {
		ISimuRecManager simuRecManager = SpringAppContext.getSimuRecManager();
    	List elemRecList = simuRecManager.getSimuRecList(caseId, recType, elemId, IProjectDataManager.CaseType_DStabSimuRec);
		if (elemRecList.size() > 0) {
			DStabSimuDBRecord elemRec = (DStabSimuDBRecord)elemRecList.get(0);
			Hashtable elemStates = StringUtil.parseStr2Hashtable(elemRec.getSimuRec());
			elemStates.remove(DStabOutFunc.OUT_SYMBOL_TIME);
			if (recType.equals(ISimuRecManager.REC_TYPE_DStabMachineStates))
				elemStates.remove(DStabOutFunc.OUT_SYMBOL_MACH_ID);
			else if (recType.equals(ISimuRecManager.REC_TYPE_DStabBusStates))
				elemStates.remove("BusId");
			return elemStates.keySet().toArray();
		}
		return new Object[0];
    }	

    /**
     * Plot state curve
     * 
     * @param caseId simulation case id
     * @param elemId element id
     * @param recType element record type
     * @param yLabel state name
     */
    public static void plotStateCurve(int caseId, String elemId, String yLabel, String yDataLabel, String recType) {
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		if (appSimuCtx.isSimuNetDataDirty()) {
			SpringAppContext.getIpssMsgHub().sendWarnMsg(
					"The SimuNetwork object is dirty. Network data may have been modified. You may want to re-run the analysis.");
		}
		ISimuRecManager simuRecManager = SpringAppContext.getSimuRecManager();
		List elemRecList = simuRecManager.getSimuRecList(caseId,	recType, elemId, IProjectDataManager.CaseType_DStabSimuRec);
		IpssLogger.getLogger().info("CaseId, elemId, state, recType: " + caseId + ", " + elemId + ", " + yLabel + ", " + recType);
		IpssLogger.getLogger().info("Plot state: " + yLabel + ", # of records " + elemRecList.size());
		
		SimpleOneStateChart plot = null;
		if (recType.equals(ISimuRecManager.REC_TYPE_DStabMachineStates))
			plot = new SimpleOneStateChart("Machine State Curve Plot");
		else if (recType.equals(ISimuRecManager.REC_TYPE_DStabExcStates))
			plot = new SimpleOneStateChart("Exciter State Curve Plot");
		else if (recType.equals(ISimuRecManager.REC_TYPE_DStabGovStates))
			plot = new SimpleOneStateChart("Governor State Curve Plot");
		else if (recType.equals(ISimuRecManager.REC_TYPE_DStabPssStates))
			plot = new SimpleOneStateChart("Stabilizer State Curve Plot");
		else if (recType.equals(ISimuRecManager.REC_TYPE_DStabBusStates))
			plot = new SimpleOneStateChart("Bus Voltage State Curve Plot");

    	double[] xdata = new double[elemRecList.size()];
    	double[] ydata = new double[elemRecList.size()];
    	for (int i = 0; i < elemRecList.size(); i++) {
			DStabSimuDBRecord machRec = (DStabSimuDBRecord)elemRecList.get(i);
			xdata[i] = machRec.getSimuTime();
			Hashtable machStates = StringUtil.parseStr2Hashtable(machRec.getSimuRec());
    		ydata[i] = new Double((String)machStates.get(yLabel)).doubleValue();
    	}
    	plot.setPlotData(yLabel, yDataLabel, xdata, ydata);
		
    	plot.createChart();
    	plot.showChart();	    		
    }

    //===========================================
	//  Dist Plot Functions
	//===========================================

	private static void chartBusLoadCurve(String busid) {
    	LoadScheduleChart plot = new LoadScheduleChart("Bus Load Schedule");
    	
    	SimuContext simuCtx = (SimuContext)GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext().getSimuCtx();
    	DistNetwork distNet = simuCtx.getDistNet();
    	DistBus distBus = (DistBus)distNet.getBus(busid);
    	int size = distNet.getLoadNetData().getSchedulePoints();
    	double[] vdata = new double[size];
    	for (int i = 0; i < size; i++) {
    		vdata[i] = ((Complex)distBus.getLoadBusData().getPointVoltageList().get(i)).abs();
    	}
    	plot.setVoltageData("voltage", vdata);
    	
    	double[] pdata = new double[size];
    	double[] qdata = new double[size];
    	for (int i = 0; i < size; i++) {
    		pdata[i] = ((Complex)distBus.getLoadBusData().getLoadScheduleList().get(i)).getReal();
    		qdata[i] = ((Complex)distBus.getLoadBusData().getLoadScheduleList().get(i)).getImaginary();
    	}
    	plot.setPQData("Load P%", "Load Q%", pdata, qdata);

    	plot.createChart();
    	plot.showChart();		
	}    
}
