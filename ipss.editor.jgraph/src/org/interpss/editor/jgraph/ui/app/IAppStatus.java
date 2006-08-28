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