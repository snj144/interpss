package com.interpss.workbench;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class IpssAppWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public IpssAppWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new IpssAppActionBarAdvisor(configurer);
    }
    
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(900, 600));
        configurer.setShowCoolBar(true);
        configurer.setShowStatusLine(true);
    }
    
    public void postWindowOpen() {
    	//getMsgConsole().println("Hellow");
    }
}
