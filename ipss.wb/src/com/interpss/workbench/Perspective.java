package com.interpss.workbench;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;


public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		 layout.setEditorAreaVisible(true);
		layout.addView("org.eclipse.ui.navigator.ProjectExplorer", IPageLayout.LEFT, .50f, layout.getEditorArea());
		
//		String editorArea = layout.getEditorArea();
//		layout.setEditorAreaVisible(false);
//		layout.setFixed(true);
//		
//		layout.addStandaloneView("org.eclipse.ui.navigator.ProjectExplorer",  true /* show title */, IPageLayout.LEFT, 1.0f, editorArea);
	}
}
