package com.interpss.editor.project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


import com.interpss.editor.SimuAppSpringAppContext;
import com.interpss.editor.coreframework.GPGraphpad;
import com.interpss.editor.doc.IpssProject;
import com.interpss.editor.util.Utilities;
import com.interpss.editor.resources.Translator;
import com.interpss.editor.util.NamedInputStream;

public class IpssNewCustomDialog extends javax.swing.JDialog {
	private JLabel dirLabel;

	private JPanel browsePanel;

	private JPanel selectpanel;

	private JLabel nameLabel;

	private JPanel mainPanel;

	private JPanel buttonPanel;

	private IpssMessagePanel messagePanel;

	private JButton cancelButton;

	private JButton okButton;

	private JButton browseButton;

	private JTextField dirTextField;

	private JTextField nameTextField;

	private String docName;

	private String filepath;

	private String srcFileName;

	protected GPGraphpad graphpad;

	private Frame parentFrame;

	private boolean isCancelExit;

	public IpssNewCustomDialog(GPGraphpad graphpad, String title) {
//		super(graphpad.getFrame(), title, true);
		super(graphpad.getFrame(), "New Project", true);

		this.graphpad = graphpad;
		this.parentFrame = graphpad.getFrame();

		setResizable(false);

		// initLocalData();
		initGuiComponents();
		initListeners();
		// setFontValue(initialFont);
		setBrowsePanelVisable();
		updateState();

	}

	protected void initListeners() {

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				setCancelExit(true);
				setVisible(false);
			}
		});

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				setCancelExit(false);
				setVisible(false);
			}
		});

		browseButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				selectFile();
				
			}
		});

		nameTextField.addCaretListener(new CaretListener() {
			public void caretUpdate(final CaretEvent e) {
				updateState();
			}
		});

	}

	protected void setBrowsePanelVisable() {
	}

	protected void initGuiComponents() {

		getContentPane().setLayout(
				new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		messagePanel = new IpssMessagePanel();
		getContentPane().add(messagePanel);
		messagePanel.setPreferredSize(new Dimension(0, 30));

		messagePanel.setBorder(new EmptyBorder(0, 5, 0, 0));
//		messagePanel.getMessageLabel().setPreferredSize(new Dimension(0, 30));

		getContentPane().add(Box.createVerticalStrut(10));

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(new EmptyBorder(0, 5, 0, 5));
		getContentPane().add(mainPanel);

		mainPanel.add(Box.createVerticalStrut(10));

		selectpanel = new JPanel();
		mainPanel.add(selectpanel);
		final GridLayout gridLayout = new GridLayout(0, 1);
		selectpanel.setLayout(gridLayout);
		selectpanel.setBorder(new TitledBorder(null, "Import Contexts",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		browsePanel = new JPanel();
		selectpanel.add(browsePanel);
		browsePanel.setLayout(new BorderLayout());

		dirTextField = new JTextField();
		dirTextField.setEditable(false);
		dirTextField.setFocusAccelerator('f');
		browsePanel.add(dirTextField);

		dirLabel = new JLabel();
		dirLabel.setDisplayedMnemonic(KeyEvent.VK_F);
		browsePanel.add(dirLabel, BorderLayout.WEST);
		dirLabel.setText("File:  ");

		browseButton = new JButton();

		browseButton.setMnemonic('B');
		browseButton.setText("Browse...");
		browsePanel.add(browseButton, BorderLayout.EAST);

		final JPanel panel = new JPanel();
		mainPanel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout());

		nameLabel = new JLabel();
		panel.add(nameLabel, BorderLayout.WEST);
		nameLabel.setDisplayedMnemonic(KeyEvent.VK_G);
		nameLabel.setText("Custom Project Name:");

		nameTextField = new JTextField();
		panel.add(nameTextField, BorderLayout.CENTER);

		nameTextField.setFocusAccelerator('p');

		buttonPanel = new JPanel();
		getContentPane().add(buttonPanel);

		okButton = new JButton();

		okButton.setMnemonic('O');
		buttonPanel.add(okButton);
		okButton.setText("OK");

		cancelButton = new JButton();

		buttonPanel.add(cancelButton);
		cancelButton.setMnemonic('C');
		cancelButton.setText("Cancel");

		// selectpanel.setVisible(false);
	}

	public void setDocName(String docName) {
		this.docName = docName;

		if (docName != null) {
			nameTextField.setText(Utilities.getFileName(docName));
		}
	}

	public String getDocName() {
		return docName;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}

	public String getSrcFileName() {
		return srcFileName;
	}

	public void setCancelExit(boolean isCancelExit) {
		this.isCancelExit = isCancelExit;
	}

	public boolean isCancelExit() {
		return isCancelExit;
	}

	public void init(IpssProject project, String aDocName) {
		setFilepath(project.getProjectPath());
		setDocName(aDocName);
		// pack the form and display
		pack();
		setLocationRelativeTo(parentFrame);
		setSize(new Dimension(611, 190));
		setVisible(true);
	}

	public void showMessage(String messageInfo, boolean isError) {
		messagePanel.showMessage(messageInfo, isError);

		if (isError) {
			okButton.setEnabled(false);
			return;
		} else
			setOKActable();
	}

	private void setOKActable() {
		if ((dirTextField.getText() != null)
				&& (dirTextField.getText().length() > 0)) {
			okButton.setEnabled(true);
		} else {
			okButton.setEnabled(false);
		}

	}

	public void showMessage(String messageInfo) {
		showMessage(messageInfo, false);
	}

	public void showError(String messageInfo) {
		showMessage(messageInfo, true);
	}

	public String getFileName() {
		return Utilities.getFilePathName(getFilepath(), nameTextField.getText()+ "." +Utilities.getFileExt(getSrcFileName()));
			//	+ Translator.getString("CustomDataFileExtension"));
	}

	public void updateState() {
		if (nameTextField.getText().equals("")) {
			showError(Translator.getString("CustomDialog.Name.Error"));
			return;
		}
		String filePathName = getFileName();
		try {
			java.io.File myFile = new java.io.File(filePathName);
			if (myFile.exists()) {

				showError(Translator.getString("CustomDialog.File.Exists"));
				return;
			}
			// else myFilePath.mkdir();
		} catch (Exception e) {
			showError("Create custom data file error:" + e.getMessage());
			return;
		}

		showMessage(Translator.getString("CustomDialog.OK"));
		// showMessage(filePathName);
	}

	public void selectFile() {
		try {
//			NamedInputStream in = com.interpss.editor.util.Utilities.provideInput(
//					Translator.getString("CustomDataFileExtension"), Translator
//							.getString("CustomDataFileExtensionDescription"));
			
			List adapterList = 	SimuAppSpringAppContext.getCustomFileAdapterList();
			NamedInputStream in = com.interpss.editor.util.Utilities.provideInput(adapterList);
			if (in != null) {
				this.setSrcFileName(in.getName());
				dirTextField.setText(in.getName());
				setOKActable();
				if (this.getSrcFileName() == null) {
					showError("Can't open the selected custom data file.");
					return;
				}
			}
		} catch (Exception ex) {
			showError(ex.toString());
			ex.printStackTrace();
		}
	}

}
