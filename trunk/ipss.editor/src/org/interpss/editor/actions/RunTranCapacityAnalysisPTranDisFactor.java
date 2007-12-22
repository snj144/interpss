package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.editor.coreframework.IpssEditorDocument;
import org.interpss.editor.util.DocumentUtilFunc;
import org.interpss.editor.util.RunUtilFunc;

import com.interpss.common.datatype.SimuRunType;

public class RunTranCapacityAnalysisPTranDisFactor extends IpssAbstractActionDefault {
	private static final long serialVersionUID = 1;

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		RunUtilFunc.performRunAction(getCurrentDocument(), SimuRunType.PowerTransferDistFactor, graphpad);
	}

	@Override
	public void update() {
		IpssEditorDocument doc = getCurrentDocument();
		setEnabled(DocumentUtilFunc.isAclfDocument(doc) || DocumentUtilFunc.isDStabDocument(doc));
	}
}
