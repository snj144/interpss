/*
 * @(#)DclfRunForm.java   
 *
 * Copyright (C) 2006 www.interpss.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @Author Mike Zhou
 * @Version 1.0
 * @Date 09/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.editor.runAct.ui;

import org.interpss.display.DclfOutFunc;
import org.interpss.editor.runAct.xml.XmlScriptDclfRun;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.schema.AreaTransferAnalysisXmlType;
import org.interpss.schema.DclfBranchSensitivityXmlType;
import org.interpss.schema.DclfStudyCaseXmlType;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.simu.ISimuCaseRunner;
import com.interpss.simu.SimuContext;

public class DclfRunForm extends BaseRunForm implements ISimuCaseRunner {
	public DclfRunForm() {
	}

//	private DclfCaseData dclfCaseData;
	private DclfBranchSensitivityXmlType tdFactor = null;;
	private AreaTransferAnalysisXmlType areaTransfer = null;;

	public void setXmlCaseData(DclfStudyCaseXmlType scase) {
		this.tdFactor = scase.getPTransferDistFactorArray(0);
		this.areaTransfer = scase.getAreaTransferAnalysisArray(0);
	}
	
	@Override
	public boolean runCase(SimuContext simuCtx, IPSSMsgHub msg) {
		DclfAlgorithm algo = CoreObjectFactory.createDclfAlgorithm(simuCtx.getAclfNet());
		simuCtx.setDclfAlgorithm(algo);
		if (!algo.checkCondition())
			return false;
		
		XmlScriptDclfRun.calPTDistFactor(tdFactor, algo, msg);

		displaySummaryResult(simuCtx);
		return true;
	}
	
	public void displaySummaryResult(SimuContext simuCtx) {
		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Sensitivity Analysis Results");
		String str = DclfOutFunc.pTransferDistFactorResults(tdFactor, simuCtx.getDclfAlgorithm());
		dialog.display(str);
	}	
}