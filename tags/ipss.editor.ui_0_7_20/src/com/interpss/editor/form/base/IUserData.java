package com.interpss.editor.form.base;

/**
*	UserData interface for the getUserObject() method of a graph cell
*/

public interface IUserData {
	public static final String NET_LABEL           = "NetLabel";
	public static final String NET_ANNOTATE_LABEL  = "NetAnnotateLabel";
	public static final String BUS_LABEL           = "BusLabel";
	public static final String BUS_ANNOTATE_LABEL  = "BusAnnotateLabel";
	public static final String BRANCH_LABEL        = "BranchLabel";
	public static final String BRANCH_SOURCE_LABEL = "BranchSourceLabel";
	public static final String BRANCH_TARGET_LABEL = "BranchTargetLabel";
	/**
	*	Get a string for cell display purpose
	*/
	public String getLabel(String type);
	
	/**
	*	Check if the object is newly created
	*/
	public boolean isNewState();
}