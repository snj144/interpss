 /*
  * @(#)BaseTestSetup.java   
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
  * @Date 07/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss;

import java.util.logging.Level;

import org.interpss.editor.jgraph.ui.IIpssGraphModel;
import org.interpss.editor.jgraph.ui.form.IGFormContainer;
import org.interpss.editor.mapper.EditorJGraphDataMapper;
import org.interpss.editor.util.IOUtilFunc;
import org.jgraph.JGraph;
import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.interpss.common.CoreCommonSpringCtx;
import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.pssl.simu.IpssAclf;
import com.interpss.simu.SimuContext;

public class BaseTestSetup {
	protected static IPSSMsgHub msg;

	public void loadCaseData(String filename, SimuContext simuCtx) {
		JGraph graph = IOUtilFunc.loadIpssGraphFile(filename);
		IGFormContainer gFormContainer = ((IIpssGraphModel)graph.getModel()).getGFormContainer();
		EditorJGraphDataMapper mapper = new EditorJGraphDataMapper(msg);
		mapper.map2Model(gFormContainer, simuCtx);
	}

	@BeforeClass
	public static void setSpringAppCtx() {
		if (CoreCommonSpringCtx.SpringAppCtx == null) {
			/*
			TestUtilFunc.Simu_SpringConfigXmlFile = <springConfig File Location> + "springConfig/test/simuContext.xml";
			TestUtilFunc.Plugin_SpringConfigXmlFile = <springConfig File Location> + "/springConfig/test/pluginContext.xml";
			*/
			//String xmlFile = TestUtilFunc.Plugin_SpringConfigXmlFile;
			// Set the SpringAppContext to all ApplicationContextAware objects.
			//SpringAppContext.SpringAppCtx = new FileSystemXmlApplicationContext(xmlFile);
			CoreCommonSpringCtx.SpringAppCtx = new ClassPathXmlApplicationContext(Constants.SpringConfigPath_PluginTest);
			msg = CoreCommonSpringCtx.getIpssMsgHub();
			IpssLogger.getLogger().setLevel(Level.INFO);
		}
		IpssAclf.setMsgHub(msg);
	}
}

