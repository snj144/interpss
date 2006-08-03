package com.interpss.editor.coreframework;

import java.applet.Applet;
import java.util.Hashtable;
import java.util.Map;
import java.util.MissingResourceException;

import javax.swing.JOptionPane;


import com.interpss.editor.resources.Translator;
import com.interpss.editor.util.Utilities;

/**
 * While JGraphpad gets most of its parameters from the properties file, some
 * other parameters can be given at the session time. Those parameters can only
 * be strings and they should be passed as argument for the main class, either
 * when invoking JGraphpad as a standalone application, as an applet or via
 * webstart.
 * 
 * You can even gain full control of JGraphpad during the session by providing a
 * new properties file as an argument!
 * 
 * @author rvalyi
 */
public class GPSessionParameters {

	/**
	 * This is where we store every sort of session parameters
	 */
	private Map sessionParameters;

	/**
	 * This is a static map providing the appropriate key for command line
	 * arguments
	 */
	public static Map paramCommands;

	private Applet applet;

	public static final String DEFAULT_PROPERTIES_FILE = "com.interpss.editor.resources.Graphpad";

	// session parameters:

	public static final String HOSTNAME = "hostName";

	public static final String HOSTPORT = "hostPort";

	public static final String PROTOCOL = "protocol";

	public static final String DOWNLOADPATH = "downloadPath";

	public static final String UPLOADPATH = "uploadPath";

	public static final String UPLOADFILE = "uploadFile";

	public static final String MAPFILE = "mapFile";

	public static final String VIEWPATH = "viewpath";

	public static final String CUSTOMCONFIG = "customConfig";

	// command line for the session parameters:

	public static final String HOSTNAME_SHORT = "-h";

	public static final String HOSTPORT_SHORT = "-p";

	public static final String PROTOCOL_SHORT = "-t";

	public static final String DOWNLOADPATH_SHORT = "-d";

	public static final String UPLOADPATH_SHORT = "-u";

	public static final String UPLOADFILE_SHORT = "-f";

	public static final String MAPFILE_SHORT = "-m";

	public static final String VIEWPATH_SHORT = "-v";

	public static final String CUSTOMCONFIG_SHORT = "-c";

	static {
		paramCommands = new Hashtable(10);
		paramCommands.put(HOSTNAME_SHORT, HOSTNAME);
		paramCommands.put(HOSTPORT_SHORT, HOSTPORT);
		paramCommands.put(PROTOCOL_SHORT, PROTOCOL);
		paramCommands.put(DOWNLOADPATH_SHORT, DOWNLOADPATH);
		paramCommands.put(UPLOADPATH_SHORT, UPLOADPATH);
		paramCommands.put(UPLOADFILE_SHORT, UPLOADFILE);
		paramCommands.put(MAPFILE_SHORT, MAPFILE);
		paramCommands.put(VIEWPATH_SHORT, VIEWPATH);
		paramCommands.put(CUSTOMCONFIG_SHORT, CUSTOMCONFIG);
	}

	public GPSessionParameters() {
		this(null, null);
	}

	public GPSessionParameters(Map map) {
		this(null, null);
	}

	public GPSessionParameters(Applet applet) {
		this(null, applet);
	}

	public GPSessionParameters(Map map, Applet applet) {
		if (map == null)
			map = new Hashtable(10);
		sessionParameters = map;
		Translator.pushBundle(DEFAULT_PROPERTIES_FILE);// the minimal
														// configuration of
														// JGraphpad
		this.applet = applet;
		String[] values;
		// translations if any:
		values = Utilities.tokenize(Translator.getString("TranslationsPath"));
		for (int i = 0; i < values.length; i++) {
			try {
				Translator.pushBundle(values[i]);
			} catch (MissingResourceException ex) {
				System.out.print(ex);
			}
		}
		// plugin properties if any:
		values = Utilities.tokenize(Translator
				.getString("PluginPropertiesPath"));
		for (int i = 0; i < values.length; i++) {
			try {
				Translator.pushBundle(values[i]);
			} catch (MissingResourceException ex) {
				System.out.print(ex);
			}
		}
	}

	public void setParamWithCommand(String command, String value) {
		String key = (String) paramCommands.get(command);
		setParam(key, value);
	}

	public void setParam(String key, String value) {
		sessionParameters.put(key, value);
		if (key.equals(CUSTOMCONFIG)) {
			Translator.pushBundle(value);
		}
	}

	/**
	 * Try to get the parameter from the applet if any. If not, then it looks if
	 * there is one in the session parameters map. Finally, if it's not defined
	 * and if we allow it, then we ask the user to enter the parameter.
	 * 
	 * @param key
	 * @param askIfNone
	 * @return
	 */
	public String getParam(String key, boolean askIfNone) {
		String value;
		if (isApplet()) {
			value = applet.getParameter(key);
			if (value != null)
				return value;
		}
		Object object = sessionParameters.get(key);
		if (object != null) {
			return (String) object;
		}
		if (askIfNone) {
			return JOptionPane.showInputDialog(null,

			"le message\n et la suite",

			"le titre",

			JOptionPane.QUESTION_MESSAGE);
		}
		return null;
	}

	public Map getSessionParameters() {
		return sessionParameters;
	}

	public void setSessionParameters(Map sessionParameters) {
		this.sessionParameters = sessionParameters;
	}

	public Applet getApplet() {
		return applet;
	}

	public void setApplet(Applet applet) {
		this.applet = applet;
	}

	public boolean isApplet() {
		return (applet != null);
	}
}
