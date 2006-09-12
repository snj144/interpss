package org.interpss.editor.jgraph.ui.edit;


/**
*	Common functions for Net, Bus and Branch editor to handle form data
*/

public interface IFormDataPanel {
	/**
	*	For performance reason, editor objects are static member of the 
	*   CellEditorFactory or other factory. This method is for init the editor for the form
	* 	object to be edtied
	*
	* @param container the Container object for the form object
	* @param form the form object to be edited
	*/
	void init(Object container, Object form);
	
	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
	boolean setForm2Editor();

	
	/**
	*	Save editor screen data to the form
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
	boolean saveEditor2Form(java.util.Vector errMsg) throws Exception;
}