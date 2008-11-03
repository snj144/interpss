package com.interpss.workbench;

import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class IpssMsgConsole extends MessageConsole {
	private MessageConsoleStream msgStream;

	public IpssMsgConsole() {
		super("Message Console", null);
		this.msgStream = newMessageStream();
	}
	
	public void println(String s) {
		this.msgStream.println(s);
	}
}
