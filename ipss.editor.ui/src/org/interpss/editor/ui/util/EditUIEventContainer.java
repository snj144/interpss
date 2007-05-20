 /*
  * @(#)EditUIEventContainer.java   
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.editor.ui.util;

/**
*	A JavaBean: BaseFormContainer class for storing network data
*/

import java.util.EventListener;

import org.interpss.editor.ui.IEditUIEventListener;


public class EditUIEventContainer {
  	private java.util.Vector editUIEventListeners = new java.util.Vector();
  	
	/**
	*	Constructor
	*/
	public EditUIEventContainer() {
	}	
	
	/**
	   * Add a msg listener to the container.
		*
		* @param listener the listener to be added
	*/
	public void addEditUIEventListener (EventListener listener) {
		if (editUIEventListeners == null) {
			editUIEventListeners = new java.util.Vector();
	 	}
		editUIEventListeners.addElement(listener);
	}

	/**
	   * Remove a msg listener from the container.
		*
		* @param listener the listener to be removed
	*/
	public void removeEditUIEventListener (EventListener listener) {
	 	if (editUIEventListeners == null) {
		 	throw new java.util.NoSuchElementException("The Event listener has not been added yet");
	 	}
	 	editUIEventListeners.removeElement(listener);
	}

	public void fireEvent(EditUIEvent event) {
	 	for (int i = 0; i < editUIEventListeners.size(); i++ ) {
			Object listener = editUIEventListeners.elementAt(i);
			((IEditUIEventListener)listener).onEvent(event);
	 	}
	}
}