package com.interpss.editor.coreframework;

/**
 * 	Factory class for creating Branch, Bus and Network editor
 */

import java.awt.Dialog;

import javax.swing.JDialog;


import com.interpss.common.SpringAppContext;
import com.interpss.editor.form.GBranchForm;
import com.interpss.editor.form.GBusForm;
import com.interpss.editor.jgraph.cells.BranchEdge;
import com.interpss.editor.jgraph.cells.BusCell;
import com.interpss.editor.ui.edit.NBBranchEditDialog;
import com.interpss.editor.ui.edit.NBBusEditDialog;
import com.interpss.editor.ui.edit.NBProjectEditDialog;

public class CellEditorFactory {
	public final static byte EditorType_Normal = 0,
			EditorType_FindDistObject = 1, EditorType_FindTransObject = 2;

	/**
	 * Create a cell editor according to the cell type
	 * 
	 * @param cell
	 *            the cell object, null object for create network editor
	 * @param graph
	 *            the IpssGraph object
	 * @return the created cell editor
	 */
	public static Dialog getEditorDialog(java.awt.Frame parentFrame,
			Object obj, GPDocument doc, byte type) {
		JDialog dialog = null;
		switch (type) {
		case EditorType_Normal:
			if ((obj instanceof BusCell) || (obj instanceof GBusForm)) {
				NBBusEditDialog busEditor = new NBBusEditDialog(parentFrame,
						SpringAppContext.getIpssMsgHub());

				if (obj instanceof BusCell) {
					// This is called when a new bus is added
					GBusForm form = (GBusForm) (((BusCell) obj).getUserObject());

					busEditor.init(doc.getGFormContainer(), form);
				} else if (obj instanceof GBusForm) {
					// This is called when editing an existng bus
					busEditor.init(doc.getGFormContainer(), obj);
				}
				return busEditor;
			} else if ((obj instanceof BranchEdge)
					|| (obj instanceof GBranchForm)) {
				NBBranchEditDialog branchEditor = new NBBranchEditDialog(
						parentFrame, SpringAppContext.getIpssMsgHub());
				if (obj instanceof BranchEdge) {
					GBranchForm form = (GBranchForm) (((BranchEdge) obj)
							.getUserObject());
					branchEditor.init(doc.getGFormContainer(), form);
				} else if (obj instanceof GBranchForm) {
					branchEditor.init(doc.getGFormContainer(), obj);
				}
				return branchEditor;
			} else if (obj == null) { // this is the case of NetEditor
				NBProjectEditDialog netEditor = new NBProjectEditDialog(
						parentFrame, SpringAppContext.getIpssMsgHub());
				netEditor.init(doc.getGFormContainer(), doc.getProjData());
				return netEditor;
			}
			break;
/*			
		case EditorType_FindDistObject:
			NBSearchElementDialog findObjDialog = new NBSearchElementDialog(parentFrame);
			findObjDialog.init(doc.getGFormContainer(), null);
			return findObjDialog;
		default:
			dialog = new JDialog(UIConfig.getRootFrame(), "Programming error");
			dialog.pack();
			dialog.setVisible(true);
*/			
		}
		return dialog;

	}

	public static Dialog getEditorDialog(java.awt.Frame parentFrame,
			Object obj, GPDocument doc) {

		return getEditorDialog(parentFrame, obj, doc, EditorType_Normal);
	}
}