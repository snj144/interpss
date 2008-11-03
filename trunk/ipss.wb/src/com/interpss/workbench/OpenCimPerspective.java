package com.interpss.workbench;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;


public class OpenCimPerspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		
		layout.addView("org.eclipse.ui.navigator.ProjectExplorer", IPageLayout.LEFT, .30f, layout.getEditorArea());
		
//		String editorArea = layout.getEditorArea();
//		layout.setEditorAreaVisible(false);
//		layout.setFixed(true);
//		
//		layout.addStandaloneView("org.eclipse.ui.navigator.ProjectExplorer",  true /* show title */, IPageLayout.LEFT, 1.0f, editorArea);
		
		// add Ipss message console to the perspective 
	    layout.addView(IConsoleConstants.ID_CONSOLE_VIEW, IPageLayout.BOTTOM, 0.70f, layout.getEditorArea());
	}
	
    public static IpssMsgConsole getMsgConsole() {
    	IConsole[] clist = ConsolePlugin.getDefault().getConsoleManager().getConsoles();
    	for (IConsole c : clist) {
    		if (c instanceof IpssMsgConsole) {
    			return (IpssMsgConsole)c;
    		}
    	}
    	return null;
    }	
}
