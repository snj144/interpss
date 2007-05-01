package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.coreframework.IpssAbstractActionDefault;

import com.interpss.common.util.IpssJavaCompiler;
import com.interpss.common.util.IpssLogger;

public class ToolsDebugJavaCompile extends IpssAbstractActionDefault {
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		IpssLogger.getLogger().info("Tools | Degug | Java Compile");
		IpssJavaCompiler.test();
	}
}
