package com.interpss.editor.project;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.interpss.editor.resources.ImageLoader;
import com.interpss.editor.resources.Translator;

public class IpssMessagePanel extends JPanel{
	private JLabel messageLabel ;
	
	public IpssMessagePanel() {
		super();
		setLayout(new BorderLayout());

		add(getMessageLabel(), BorderLayout.NORTH);
	}

	public JLabel getMessageLabel() {
		if (messageLabel==null) messageLabel = new JLabel();
		return messageLabel;
	}

	public void showMessage(String messageInfo, boolean isError) {
		getMessageLabel().setText(messageInfo);

		if (isError) {
			getMessageLabel().setIcon(ImageLoader.getImageIcon(Translator
					.getString("Dialog.Error.Icon")));
			getMessageLabel().setForeground(Color.red);
		} else {
			getMessageLabel().setIcon(null);
			getMessageLabel().setForeground(Color.BLACK);
		}
	}
	
	public void showMessage(String messageInfo) {
		showMessage(messageInfo, false);
	}

	public void showError(String messageInfo) {
		showMessage(messageInfo, true);
	}

}
