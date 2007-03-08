 /*
  * @(#)CIMLogger.java   
  *
  * Copyright (C) 2007 www.opencim.org
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
  * @Date 03/04/2007
  * 
  *   Revision History
  *   ================
  *
  */

/**
 * A logging class, which is a wrapper around the java.util.logging.Logg class. 
 */

package org.opencim.datatype;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CIMLogger {
	/**
	 * The Logger object should be set by the system which uses this lib
	 */
	public static Logger cimLogger = null; 
	public static String cimLoggerName = "OpenCIM.Logger"; 
	
	public static Logger getLogger() {
		if (cimLogger == null) {
			// if Logger is not inited, create a default logger
			final LogManager logMgr = LogManager.getLogManager();
			cimLogger = Logger.getLogger(cimLoggerName);
			cimLogger.setLevel(Level.INFO);
			logMgr.addLogger(cimLogger);			
		}
		return cimLogger;
	}
}
