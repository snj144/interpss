package com.interpss.editor.ui.util;

/**
*	A JavaBean: BaseFormContainer class for storing network data
*/

import java.util.EventListener;

import com.interpss.editor.ui.IEditUIEventListener;

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