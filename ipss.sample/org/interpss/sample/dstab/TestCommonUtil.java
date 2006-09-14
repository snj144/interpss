 /*
  * @(#)TestCommonUtil.java   
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.sample.dstab;

import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.jgraph.ui.IIpssGraphModel;
import org.interpss.editor.jgraph.ui.form.IGFormContainer;
import org.interpss.editor.mapper.EditorJGraphDataMapper;
import org.interpss.editor.util.IOUtilFunc;
import org.jgraph.JGraph;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.simu.SimuContext;

public class TestCommonUtil extends TestSetupBase {
	public static void loadCaseData(String filename, SimuContext simuCtx, IPSSMsgHub msg) {
		JGraph graph = IOUtilFunc.loadIpssGraphFile(filename);
		IGFormContainer gFormContainer = ((IIpssGraphModel)graph.getModel()).getGFormContainer();
		EditorJGraphDataMapper mapper = new EditorJGraphDataMapper();
		mapper.setMsg(msg);
		mapper.mapping(gFormContainer, simuCtx, GFormContainer.class);
	}
}
