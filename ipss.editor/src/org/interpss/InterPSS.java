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

import org.interpss.cmd.CmdLineRunner;
import org.interpss.editor.GEditor;
import org.interpss.gridgain.util.IpssGridGainUtil;

import com.interpss.common.util.IpssLogger;

public class InterPSS {
	private final static String OptStr = "-o";
	private final static String GOptStr = "-g";
	private final static String InOptStr = "-in";
	private final static String RunOptStr = "-run";
	private final static String OutOptStr = "-out";
	private final static String POptStr = "-p";
	
	private final static String OptHelpStr = "help";
	private final static String OptCmdLineStr = "cmd";
	private final static String OptEditorStr = "editor";

	public final static String RunDclfStr = "dclf";
	public final static String RunAclfStr = "aclf";
	public final static String RunAcscStr = "acsc";
	public final static String RunDStabStr = "dstab";

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
			CmdLineRunner.cmdLineRun("", "", "");
		}
	}

	private static void parseCmdLineParameters(String[] args) {
		// we set up the app parameters
		appParameters = new AppParameters();
		for (int i = 0; i < args.length; i = i + 2) {
			// simple precaution in case arguments aren't well formed
			if (args[i].indexOf("-") < 0) {
				i = i - 1;
				continue;
			}
			appParameters.setParam(args[i], args[i + 1]);
		}

		// put default value if not specified by the user
		if (appParameters.getParam(OptStr) == null)
			appParameters.setParam(OptStr, OptCmdLineStr);
	}

	private static String getHelpInfo() {
		return "java org.interpss.InterPSS [-o editor|help|cmd] [-in <input file>] [-run dclf|aclf|scsc|dstab] [-out <output file>] [-p <properties file>] [-g gridgain] \n"
				+ "  "	+ OptStr + " "	+ OptHelpStr + " for help info\n"
				+ "  "	+ OptStr + " "	+ OptCmdLineStr	+ " defaul, running InterPSS in cmd line mode\n"
				+ "  "	+ OptStr + " "	+ OptEditorStr	+ " running InterPSS in graphic editor mode\n"
				+ "  "	+ GOptStr + " "	+ Parm_GridGain	+ " running InterPSS in grid computing mode\n"
				+ "  "	+ InOptStr + " "	+ " simulation result input file, its extension will used to determine file loading adapter\n"
				+ "  "	+ RunOptStr + " "	+ " to override InterPSS default run type, which is determined by the network object type. \n"
				+ "  "	+ OutOptStr + " "	+ " simulation result output file\n"
				+ "  "	+ POptStr + " "	+ " properties file for configuting the run\n";
	}
}
