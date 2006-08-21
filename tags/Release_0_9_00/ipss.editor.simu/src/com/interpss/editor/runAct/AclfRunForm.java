package com.interpss.editor.runAct;

import java.util.Iterator;

import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dist.DistBus;
import com.interpss.dist.DistBusAdapter;
import com.interpss.dist.DistNetwork;
import com.interpss.editor.SimuAppSpringAppContext;
import com.interpss.editor.data.proj.AclfCaseData;
import com.interpss.editor.ui.IOutputTextDialog;
import com.interpss.editor.ui.UISpringAppContext;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

public class AclfRunForm extends BaseRunForm {
	public AclfRunForm() {}

	private AclfCaseData aclfCaseData;
	public AclfCaseData getAclfCaseData() {	return this.aclfCaseData; }
	public void setAclfCaseData(AclfCaseData acase) {this.aclfCaseData = acase;}
	
  	public boolean runLoadflow(SimuContext simuCtx) {
  		boolean converge = false;
  		if (simuCtx.getNetType() == SimuCtxType.DISTRIBUTE_NET_LITERAL) {
  			converge = runLoadflow(simuCtx.getDistNet(), simuCtx.getLoadflowAlgorithm(), simuCtx.getMsgHub());
  		}
  		else {
  			converge = runLoadflow(simuCtx.getAclfAdjNet(), simuCtx.getLoadflowAlgorithm(), simuCtx.getMsgHub());
  		}
  		return converge;
  	}
  	
  	private boolean runLoadflow(DistNetwork distNet, LoadflowAlgorithm algo, IPSSMsgHub msg) {
  		boolean converge = true;
  		if (distNet.getLoadNetData().getSchedulePoints() == 0) {
  			distNet.setNameplateAclfNetData(msg);
			converge = runLoadflow_internal(distNet.getAcscNet(), algo, msg);
		  	if (getAclfCaseData().getShowSummary()) {
		  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Loadflow Analysis Info");
		  		dialog.display(distNet.getAcscNet());
		  	}
		}
  		else {
  			double loss = 0.0;
  			for (int i = 0; i < distNet.getLoadNetData().getSchedulePoints(); i++) {
  				distNet.setPointAclfNetData(i, msg);
  				if (!runLoadflow_internal(distNet.getAcscNet(), algo, msg))
  					converge = false;
  				
  				for( Iterator itr = distNet.getBusList().iterator(); itr.hasNext();) {
  					DistBus distBus = (DistBus)itr.next();
  			  		DistBusAdapter aBusApt = (DistBusAdapter)distBus.adapt(DistBusAdapter.class);
  			  		aBusApt.setPointVoltage(distBus.getAcscBus().getVoltage(), i);
  				}
  			}
  			distNet.getLoadNetData().setTotalLossKwHr(loss);  		
		  	if (getAclfCaseData().getShowSummary()) {
		  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Distribution Loadflow Analysis Info");
		  		dialog.display(distNet);
		  		
		  	}
  		}
  		return converge; 
  	}
  	
  	private boolean runLoadflow(AclfAdjNetwork aclfAdjNet, LoadflowAlgorithm algo, IPSSMsgHub msg) {
  	  	boolean converge = runLoadflow_internal(aclfAdjNet, algo, msg);
	  	if (getAclfCaseData().getShowSummary()) {
	  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Distribution Loadflow Analysis Info");
	  		dialog.display(aclfAdjNet);
	  	}
  	  	return converge;
  	}
  	
  	private boolean runLoadflow_internal(AclfAdjNetwork aclfAdjNet, LoadflowAlgorithm algo, IPSSMsgHub msg) {
  		IpssMapper mapper = SimuAppSpringAppContext.getRunForm2AlgorithmMapper();
  		mapper.mapping(this, algo, LoadflowAlgorithm.class);

		algo.loadflow(msg);

	  	return aclfAdjNet.isLfConverged();
  	}
}