package com.interpss.editor.ui;

import com.interpss.editor.ui.util.EditUIEvent;

/**
 * Interface for implementing UIEvent listener.
 * 
 * @author  Mike Zhou
 * @version 1.00 06/20/05
 */

public interface IEditUIEventListener extends java.util.EventListener {

  /**
   * On net data change event method.
	* 
   */
   public void onEvent(EditUIEvent e);
}