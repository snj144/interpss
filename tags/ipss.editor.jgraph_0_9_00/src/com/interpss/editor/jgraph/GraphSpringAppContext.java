package com.interpss.editor.jgraph;


/**
* 	Factory class for creating Branch, Bus and Network editor
*/

import javax.swing.JDialog;

import org.jgraph.JGraph;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.util.IpssLogger;
import com.interpss.editor.jgraph.cells.BranchEdge;
import com.interpss.editor.jgraph.cells.BusCell;
import com.interpss.editor.jgraph.ui.IGraphicEditor;
import com.interpss.editor.jgraph.ui.IIpssGraphModel;
import com.interpss.editor.jgraph.ui.edit.IElemSearchDialog;
import com.interpss.editor.jgraph.ui.edit.IFormDataDialog;
import com.interpss.editor.jgraph.ui.form.IGBranchForm;
import com.interpss.editor.jgraph.ui.form.IGBusForm;
import com.interpss.editor.jgraph.ui.form.IGFormContainer;

public class GraphSpringAppContext extends SpringAppContext {
	public static int EditorType_FindDistObject = 1,
	 				  EditorType_FindTransObject = 2;
	/**
	 * Get a IpssGraph(prototype) from the SpringAppContext.
	 *  
	 * @return the IpssGraph object
	 */
	public static JGraph getIpssGraph() {
		return (JGraph)SpringAppCtx.getBean(Constants.SID_IpssGraph);
	}
	
	/**
	 * Get a GFormContainer(prototype) from the SpringAppContext.
	 *  
	 * @return the IpssGraph object
	 */
	public static IGFormContainer getEditorFormContainer() {
		return (IGFormContainer)SpringAppCtx.getBean(Constants.SID_EditorFormContainer);
	}
	
	/**
	 *	get a cell editor object(singleton) according to the cell type
	 *
	 * @param cell the cell object, null object for create network editor
	 * @param graph the IpssGraph object
	 * @return the created cell editor
	 */
	public static JDialog getEditorDialog(Object obj, JGraph graph) {
		IIpssGraphModel model = (IIpssGraphModel)graph.getModel();
		//	   String appType = model.getGFormContainer().getGNetForm().getAppType();
		if (obj instanceof BusCell) {
			//	    This is called when a new bus is added
			IFormDataDialog busEditor = getBusDataEditor();
			busEditor.init(model.getGFormContainer(), ((BusCell)obj).getUserObject());
			return (JDialog)busEditor;
		}
		else if (obj instanceof IGBusForm) {
			//	    This is called when editing an existng bus
			IFormDataDialog busEditor = getBusDataEditor();
			busEditor.init(model.getGFormContainer(), obj);
			return (JDialog)busEditor;
		}
		else if (obj instanceof BranchEdge) {
			IFormDataDialog branchEditor = getBranchDataEditor();
			branchEditor.init(model.getGFormContainer(), ((BranchEdge)obj).getUserObject());
			return (JDialog)branchEditor;
		}
		else if (obj instanceof IGBranchForm) {
			IFormDataDialog branchEditor = getBranchDataEditor();
			branchEditor.init(model.getGFormContainer(), obj);
			return (JDialog)branchEditor;
		}
		else if (obj == null) {  // this is the case of NetEditor
			IFormDataDialog netEditor = getProjectDataEditor();
			netEditor.init(model.getGFormContainer(), getIpssGraphicEditor().getCurrentAppSimuContext().getProjData());
			return (JDialog)netEditor;	
		}	
		else {
			IpssLogger.getLogger().severe("Programming error");
		}	
		return null;	
	}

	/**
	 *	get a search dialog object(singleton) according to the cell type
	 *
	 * @param type edtior type
	 * @param graph the IpssGraph object
	 * @return the created cell editor
	 */
	public static IElemSearchDialog getSearchDialog(int type, JGraph graph) {
		IIpssGraphModel model = (IIpssGraphModel)graph.getModel();
		if (type == EditorType_FindDistObject) {
			IFormDataDialog dialog = (IFormDataDialog)SpringAppCtx.getBean(Constants.SID_SearchElementDialog);
			dialog.init(model.getGFormContainer(), null);
			return (IElemSearchDialog)dialog;	
		}
		else {
			IpssLogger.getLogger().severe("Programming error");
		}	
	   return null;	
	}
	
	/**
	 * Get the IpssMainFrame(singleton) from the SpringAppContext.
	 *  
	 * @return the IpssMainFrame object
	 */
	public static IGraphicEditor getIpssGraphicEditor() {
		return (IGraphicEditor)SpringAppCtx.getBean(Constants.SID_IpssGraphicEditor);
	}
	
	/**
	 * Get the Project Date editor
	 *  
	 * @return the editor object
	 */
	public static IFormDataDialog getProjectDataEditor() {
		return (IFormDataDialog)SpringAppCtx.getBean(Constants.SID_ProjectDataEditor);
	}
	
	/**
	 * Get the Bus Date editor
	 *  
	 * @return the editor object
	 */
	public static IFormDataDialog getBusDataEditor() {
		return (IFormDataDialog)SpringAppCtx.getBean(Constants.SID_BusDataEditor);
	}

	/**
	 * Get the Branch Date editor
	 *  
	 * @return the editor object
	 */
	public static IFormDataDialog getBranchDataEditor() {
		return (IFormDataDialog)SpringAppCtx.getBean(Constants.SID_BranchDataEditor);
	}
}