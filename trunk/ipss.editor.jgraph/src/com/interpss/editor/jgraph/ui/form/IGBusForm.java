package com.interpss.editor.jgraph.ui.form;

/**
 * Bus form interface. A bus form object is a placeholder for bus data
 */

public interface IGBusForm extends IUserData {
	public static final byte
			H_Orientation = 1,
			V_Orientation = 2;

	/**
	 * Get bus orientation
	 * 
	 * @return
	 */
	byte getOrientation();
	
	/**
	 * Set bus orientation
	 * 
	 * @param b
	 */
	void setOrientation(byte b);
	
	/**
	 * Set Bus annotation label
	 * 
	 * @param l
	 */
	void setAnnotateLabel(String l);
	
}