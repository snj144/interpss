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

import org.interpss.editor.data.proj.DclfCaseData;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.simu.ISimuCaseRunner;
import com.interpss.simu.SimuContext;

public class DclfRunForm extends BaseRunForm implements ISimuCaseRunner {
	public DclfRunForm() {
	}

	private DclfCaseData dclfCaseData;

	public DclfCaseData getDclfCaseData() {
		return this.dclfCaseData;
	}

	public void setDclfCaseData(DclfCaseData acase) {
		this.dclfCaseData = acase;
	}

	@Override
	public boolean runCase(SimuContext simuCtx, IPSSMsgHub msg) {
		return true;
	}

	public void displaySummaryResult(SimuContext simuCtx) {
		// TODO Auto-generated method stub
		
	}
}