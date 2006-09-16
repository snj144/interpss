package org.interpss.editor.swing.tabbedpane;

import javax.swing.Icon;

import org.interpss.editor.resources.ImageLoader;
import org.interpss.editor.resources.Translator;


public class CloseTabPaneIpssUI extends CloseTabPaneEclipseUI {

	public CloseTabPaneIpssUI() {
		super();
		setMaxEnabled(false);
	}
	
	protected Icon getCloseIcon() {
		return ImageLoader.getImageIcon(Translator.getString("TabPaneUI.Close.Icon"));
	}
	 
	protected Icon getCloseOverIcon() {
		return ImageLoader.getImageIcon(Translator.getString("TabPaneUI.CloseHot.Icon"));
	}
}
