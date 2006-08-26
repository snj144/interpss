package org.interpss.editor.graph;

import org.apache.commons.math.complex.Complex;
import org.interpss.editor.form.base.BaseBranchForm;
import org.jgraph.JGraph;

import com.interpss.common.datatype.Complex3x1;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Num2Str;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.CapacitorBusAdapter;
import com.interpss.core.aclf.GenBusAdapter;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.editor.jgraph.cells.AnnotateLabelCell;
import com.interpss.editor.jgraph.cells.BranchEdge;
import com.interpss.editor.jgraph.cells.BusCell;
import com.interpss.editor.jgraph.ui.form.IGBranchForm;
import com.interpss.editor.jgraph.ui.form.IGBusForm;
import com.interpss.simu.SimuContext;

public class GraphSimuUtilFunc {
	public static final String LABEL_ACT_CLEAR = "ClearLabel";
	
	public static final String LABEL_ACT_ACLF  = "AclfResult";

	public static final String LABEL_ACT_ACSC_POSITIVE  = "AcscResultPositive";
	public static final String LABEL_ACT_ACSC_NEGATIVE  = "AcscResultNeagtive";
	public static final String LABEL_ACT_ACSC_ZERO      = "AcscResultZero";
	
	public static void refreshCellLabel(SimuContext simuCtx, JGraph graph, String action) {
		double baseKva = 0.0;
		if (!LABEL_ACT_CLEAR.equals(action))
			baseKva = simuCtx.getNetwork().getBaseKva();
		
		Object[] cells = graph.getDescendants(graph.getRoots());
		for (int i = 0; i < cells.length; i++ ) {
			if (cells[i] instanceof BusCell) {
				BusCell cell = (BusCell)cells[i];
				
				AnnotateLabelCell annotateLabel = cell.get_labelAnnotate();				

				// for old format
				/*
				annotateLabel = (AnnotateLabelCell)GraphCellFactory.createLabelCell(cell, true);
				cell.insertLabelAnnotate(graph);
				*/
				
				IGBusForm form = (IGBusForm)cell.getUserObject();
				if (LABEL_ACT_CLEAR.equals(action))
					form.setAnnotateLabel("");
				else if (LABEL_ACT_ACLF.equals(action)) {
					AclfBus bus = (AclfBus)simuCtx.getAclfNet().getBus(form.getId());
					GenBusAdapter genBus = (GenBusAdapter)bus.adapt(GenBusAdapter.class);
					Complex busPQ = genBus.getGenResults(UnitType.PU, baseKva).subtract(genBus.getLoadResults(UnitType.PU, baseKva));
					if ( bus.isCapacitor() ) {
						CapacitorBusAdapter cap = (CapacitorBusAdapter)bus.adapt(CapacitorBusAdapter.class);
						busPQ = busPQ.add(new Complex(0.0, cap.getQResults(bus.getVoltageMag(), UnitType.PU, baseKva)));				
					}					
					String v = Num2Str.toStr("0.000", bus.getVoltageMag(UnitType.PU));
					String ang = Num2Str.toStr("0.0", bus.getVoltageAng(UnitType.Deg));
					String p = Num2Str.toStr("0.00",busPQ.getReal());
					String q = Num2Str.toStr("0.00",busPQ.getImaginary());
					form.setAnnotateLabel(v+"(" + ang +")\n" + p + "+j" + q);
				}	
				else if (LABEL_ACT_ACSC_POSITIVE.equals(action) ||
						 LABEL_ACT_ACSC_NEGATIVE.equals(action) ||
						 LABEL_ACT_ACSC_ZERO.equals(action)) {
					SimpleFaultNetwork faultNet = simuCtx.getAcscFaultNet();
					AcscBus bus = (AcscBus)simuCtx.getAclfNet().getBus(form.getId());
					AcscBusFault fBus = (AcscBusFault)faultNet.getFaultList().get(0);
					if (fBus != null) {
						double vpu = fBus.getFaultResult().getFaultVoltage_012(bus.getSortNumber()).b_1.abs();
						if (LABEL_ACT_ACSC_NEGATIVE.equals(action))
							vpu = fBus.getFaultResult().getFaultVoltage_012(bus.getSortNumber()).c_2.abs();
						else if (LABEL_ACT_ACSC_ZERO.equals(action))
							vpu = fBus.getFaultResult().getFaultVoltage_012(bus.getSortNumber()).a_0.abs();
						String vpuStr = Num2Str.toStr("0.000", vpu );
						String vVoltStr = Num2Str.toStr("0.0", vpu*bus.getBaseVoltage());
						form.setAnnotateLabel(vVoltStr+" V\n(" + vpuStr +")");
					}
				}
				graph.setSelectionCell(annotateLabel);
				graph.clearSelection();				
			}
			else if (cells[i] instanceof BranchEdge) {
				BranchEdge edge = (BranchEdge)cells[i];
				String fromLabel = "";
				String toLabel = "";
				IGBranchForm form = (IGBranchForm)edge.getUserObject();
				if (LABEL_ACT_ACLF.equals(action)) {
					AclfBranch branch = (AclfBranch)simuCtx.getAclfNet().getBranch(form.getFromId(), form.getToId());
					/*
					 * branch.setSortNumber(0); comment out by Mike. Do not know why we need this here.
					 */
					Complex from_pq  = branch.powerFrom2To(UnitType.PU, baseKva);
					Complex to_pq  = branch.powerTo2From(UnitType.PU, baseKva);
					String from_p = Num2Str.toStr("0.00",from_pq.getReal());
					String from_q = Num2Str.toStr("0.00",from_pq.getImaginary());
					String to_p = Num2Str.toStr("0.00",to_pq.getReal());
					String to_q = Num2Str.toStr("0.00",to_pq.getImaginary());
					fromLabel = from_p + "+j" + from_q;
					toLabel = to_p + "+j" + to_q;
				}
				else if (LABEL_ACT_ACSC_POSITIVE.equals(action) ||
						 LABEL_ACT_ACSC_NEGATIVE.equals(action) ||
						 LABEL_ACT_ACSC_ZERO.equals(action)) {
					SimpleFaultNetwork faultNet = simuCtx.getAcscFaultNet();
					AcscBusFault fBus = (AcscBusFault)faultNet.getFaultList().get(0);
					AcscBranch branch = (AcscBranch)faultNet.getBranch(form.getFromId(), form.getToId());
					if (fBus != null) {
						try {
							Complex3x1 ampFrom2To = fBus.getFaultResult().branchScAmpFrom2To(branch);
							Complex3x1 ampTo2From = fBus.getFaultResult().branchScAmpTo2From(branch);
							String iFromPu = "";
							String iFromAmps = "";
							String iToPu = "";
							String iToAmps = "";
							if (LABEL_ACT_ACSC_POSITIVE.equals(action)) {
								iFromPu = Num2Str.toStr("0.00", ampFrom2To.b_1.abs());
								iToPu = Num2Str.toStr("0.00", ampTo2From.b_1.abs());
								iFromAmps = Num2Str.toStr("0", UnitType.iConversion(
										ampFrom2To.b_1.abs(), branch.getFromBus().getBaseVoltage(), baseKva, UnitType.PU, UnitType.Amp ));
								iToAmps = Num2Str.toStr("0", UnitType.iConversion(
										ampTo2From.b_1.abs(), branch.getToBus().getBaseVoltage(), baseKva, UnitType.PU, UnitType.Amp ));
							}
							else if (LABEL_ACT_ACSC_NEGATIVE.equals(action)) {
								iFromPu = Num2Str.toStr("0.00", ampFrom2To.c_2.abs());
								iToPu = Num2Str.toStr("0.00", ampTo2From.c_2.abs());
								iFromAmps = Num2Str.toStr("0", UnitType.iConversion(
										ampFrom2To.c_2.abs(), branch.getFromBus().getBaseVoltage(), baseKva, UnitType.PU, UnitType.Amp ));
								iToAmps = Num2Str.toStr("0", UnitType.iConversion(
										ampTo2From.c_2.abs(), branch.getToBus().getBaseVoltage(), baseKva, UnitType.PU, UnitType.Amp ));
							}
							else if (LABEL_ACT_ACSC_ZERO.equals(action)) {
								iFromPu = Num2Str.toStr("0.00", ampFrom2To.a_0.abs());
								iToPu = Num2Str.toStr("0.00", ampTo2From.a_0.abs());
								iFromAmps = Num2Str.toStr("0", UnitType.iConversion(
										ampFrom2To.a_0.abs(), branch.getFromBus().getBaseVoltage(), baseKva, UnitType.PU, UnitType.Amp ));
								iToAmps = Num2Str.toStr("0", UnitType.iConversion(
										ampTo2From.a_0.abs(), branch.getToBus().getBaseVoltage(), baseKva, UnitType.PU, UnitType.Amp ));
							}
							fromLabel = iFromAmps + " Amps(" + iFromPu+ " pu)";
							toLabel = iToAmps + " Amps(" + iToPu+ " pu)";
						} catch (Exception e) {
							IpssLogger.logErr(e);
						}
					}
				}

				// TODO: hacking to increase performance
				BaseBranchForm.XmlBinding = false;		
				edge.setExtraLabels(graph, fromLabel, toLabel);
				BaseBranchForm.XmlBinding = true;
			}
		}

	}	
}
