package org.interpss.sample.dstab;

import java.io.File;

import org.interpss.editor.form.GFormContainer;
import org.jgraph.JGraph;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.editor.jgraph.ui.IIpssGraphModel;
import com.interpss.editor.jgraph.ui.form.IGFormContainer;
import com.interpss.editor.mapper.EditorJGraphDataMapper;
import com.interpss.editor.util.IOUtilFunc;
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
