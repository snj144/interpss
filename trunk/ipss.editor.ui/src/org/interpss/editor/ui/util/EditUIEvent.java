package org.interpss.editor.ui.util;

/**
 * NetDataChange event.
 * 
 * @author  Mike Zhou
 * @version 1.00 06/20/05
 */

public class EditUIEvent {
	public static final int 
			UnDefined = 0,
			BusCodeChanged = 1;
	
	public int eventType = UnDefined;
	
	public EditUIEvent(int type) {
		this.eventType = type;
	}
}