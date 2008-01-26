 /*
  * @(#)InterPSS.java   
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
  * @Date 01/30/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.interpss.editor.GEditor;
import org.interpss.gridgain.util.IpssGridGainUtil;

import com.interpss.common.util.IpssLogger;

public class InterPSS {
	private final static String OptStr = "-opt";
	private final static String GOptStr = "-g";
	private final static String OptHelpStr = "help";
	private final static String OptCmdLineStr = "cmdline";
	private final static String OptEditorStr = "editor";
	private final static String Parm_GridGain = "gridgain";

	private static AppParameters appParameters;

	/*
	 * Main method for creating a JGraphpad in an application deployed either
	 * offline, either via webstart
	 */
	public static void main(String[] args) {
		// parse cmd line parameters
		parseCmdLineParameters(args);

		if (OptHelpStr.equals(appParameters.getParamLowerCase(OptStr))) {
			System.out.println(getHelpInfo());
			return;
		}

		IpssLogger.initLogger("log/log.properties");
		IpssLogger.getLogger().info(
				"\n============================================\n"
				+ "*           Starting InterPSS              *\n"
				+ "============================================");

		// try to start the grid engine
		if (appParameters.getParam(GOptStr) != null
				&& Parm_GridGain.equals(appParameters.getParamLowerCase(GOptStr))) {
			IpssGridGainUtil.startDefaultGrid();
		}

		// load properties from property files
		if (!AppConfig.loadAppProperties()) {
			// we need to do something to inform the user
			System.err
					.println("System configuration has problems, please see the log file for details");
			if (OptEditorStr.equals(appParameters.getParamLowerCase(OptStr)))
				JOptionPane
						.showMessageDialog(
								new JFrame(),
								"Your configuration has problems which prevent the GraphicEditor to start. Please see the log file in the log dir for details",
								"Configuration Error",
								JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (OptEditorStr.equals(appParameters.getParamLowerCase(OptStr))) {
			IpssLogger.getLogger()
					.info("Start InterPSS in graphic editor mode");
			GEditor.init(args);
			IpssLogger.getLogger().info(
					"\n============================================\n"
					+ "*              InterPSS Stared             *\n"
					+ "============================================");
		} else if (OptCmdLineStr.equals(appParameters.getParamLowerCase(OptStr))) {
			IpssLogger.getLogger().info("run InterPSS in cmd line mode");
		}
	}

	private static void parseCmdLineParameters(String[] args) {
		// we set up the app parameters
		appParameters = new AppParameters();
		for (int i = 0; i < args.length; i = i + 2) {
			if (args[i].indexOf("-") < 0) {// simple precaution in case
											// arguments aren't well formed
				i = i - 1;
				continue;
			}
			appParameters.setParam(args[i], args[i + 1]);
		}

		// put default value if not specified by the user
		if (appParameters.getParam(OptStr) == null)
			appParameters.setParam(OptStr, OptEditorStr);
	}

	private static String getHelpInfo() {
		return "java org.interpss.InterPSS [-opt Help|CmdLine|Editor] [-g GridGain]\n"
				+ "  "	+ OptStr + " "	+ OptHelpStr + " for help info\n"
				+ "  "	+ OptStr + " "	+ OptCmdLineStr	+ " running InterPSS in cmd line mode\n"
				+ "  "	+ OptStr + " "	+ OptEditorStr	+ " default, running InterPSS in graphic editor mode\n";
	}
}
