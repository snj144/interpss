 /*
  * @(#)IAppStatus.java   
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

package org.interpss.editor.jgraph.ui.app;

import javax.swing.JLabel;

public interface IAppStatus {
	public static long BusyIndicatorPeriod = 500;  // in ms
	
	/**
	 * Get the status label
	 * 
	 * @return
	 */
	JLabel getStatusLabel();

	/**
	 * Start the busy indicator
	 * 
	 * @param period busy indicator update period in ms
	 */
	void busyStart(long period, String statusLabel, String progressLabel);

	/**
	 * Stop the busy indicator.
	 */
	void busyStop(String statusLabel);

	/**
	 * Check if the busy indicator is active
	 * 
	 * @return
	 */
	boolean isBusy();

	/**
	 * Return the busy massage
	 * 
	 * @return
	 */
	String getBusyMsg();
	/**
	 * Return the busy massage
	 * 
	 * @return
	 */
	void setPosition(int p);
	
	/**
	 * Sets the message.
	 * @param message The message to set
	 */
	void setMessage(String message);
	
	/**
	 * Sets the scale.
	 * @param scale The scale to set
	 */
	void setScale(String scale);
}