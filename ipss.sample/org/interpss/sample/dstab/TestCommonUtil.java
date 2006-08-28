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
