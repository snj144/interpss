package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.editor.coreframework.IpssEditorDocument;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.editor.util.DocumentUtilFunc;
import org.interpss.schema.BranchChangeRecXmlType;
import org.interpss.schema.BusChangeRecXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.schema.RunStudyCaseXmlType.RunAclfStudyCase.AclfStudyCaseList.AclfStudyCase;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.core.net.Network;
import com.interpss.simu.SimuContext;


public class ToolsXmlGenN1 extends IpssAbstractActionDefault {
	private static final long serialVersionUID = 1;
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		IAppSimuContext project;
		try {
			project = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		} catch (Exception ex) {
			IpssLogger.logErr(ex);
			return;
		}		
		
		SimuContext simuCtx = (SimuContext)project.getSimuCtx();
		Network net = simuCtx.getNetwork();
		RunStudyCaseXmlType.RunAclfStudyCase.AclfStudyCaseList list = 
			RunStudyCaseXmlType.RunAclfStudyCase.AclfStudyCaseList.Factory.newInstance();
  		for (Branch bra : net.getBranchList()) {
  			AclfStudyCase studyCase = list.addNewAclfStudyCase();
  			String id = bra.getFromBus().getId()+"-"+bra.getToBus().getId()+"_"+bra.getCircuitNumber();
  			studyCase.setRecId("StudyCase_OpenBranch_"+id);
  			studyCase.setRecDesc("Open branch " + bra.getId());
  			ModificationXmlType mod = studyCase.addNewModification();
  			BranchChangeRecXmlType changeRec = mod.addNewBranchChangeRecList().addNewBranchChangeRec();
  			changeRec.setRecId("OpenBranch_"+id);
  			changeRec.setFromBusId(bra.getFromBus().getId());
  			changeRec.setToBusId(bra.getToBus().getId());
  			changeRec.setOffLine(true);
		}
  		
  		for (Bus bus : net.getBusList()) {
  			if (bus.isActive() && ((AclfBus)bus).isGen() && !((AclfBus)bus).isSwing()) {
  				AclfStudyCase studyCase = list.addNewAclfStudyCase();
  	  			studyCase.setRecId("StudyCase_GenOutage_"+bus.getId());
  	  			studyCase.setRecDesc("Generator outage at bus " + bus.getId());
  	  			ModificationXmlType mod = studyCase.addNewModification();
  	  			BusChangeRecXmlType changeRec = mod.addNewBusChangeRecList().addNewBusChangeRec();
  	  			changeRec.setRecId("GenOutage_"+bus.getId());
  	  			changeRec.setBusId(bus.getId());
  	  			changeRec.setGenOutage(true);
  			}
		}
  		
		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("N-1 Modification Xml Document");
		dialog.display(list.toString()
						.replaceAll("xmlns:sch", "xmlns:ipss")
						.replaceAll("<sch:", "<ipss:")
						.replaceAll("</sch:", "</ipss:"));  		
	}

	public void update() {
		IpssEditorDocument doc = getCurrentDocument();
		setEnabled(DocumentUtilFunc.isSimuDocument(doc));
	}
}
