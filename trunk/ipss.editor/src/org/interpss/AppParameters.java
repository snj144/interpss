package org.interpss;

import java.util.HashMap;
import java.util.Map;


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
public class AppParameters {

	/**
	 * This is where we store every sort of session parameters
	 */
	private Map<String, String> sessionParameters;

	public AppParameters() {
		sessionParameters = new HashMap<String, String>();
	}


	public void setParam(String key, String value) {
		sessionParameters.put(key, value);
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
	public String getParam(String key) {
		Object object = sessionParameters.get(key);
		if (object != null) {
			return (String) object;
		}
		return null;
	}

	public Map<String, String> getSessionParameters() {
		return sessionParameters;
	}
}
