package com.interpss.editor.coreframework;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.interpss.editor.doc.IpssProject;
import com.interpss.editor.resources.Translator;

public class IpssCustomDocument extends IpssEditorDocument{
	
	/**
	 * Container for the graph so that you can scroll over the graph
	 */
	protected JScrollPane scrollPane;
	
	private static JTextArea mainTextArea;
	
	protected IpssCustomFile docFile;
	
	public IpssCustomDocument(GPGraphpad gp, IpssProject p, String name,IpssCustomFile file) {
		super();
		
		setDoubleBuffered(true);
		updateUI();
		
		this.setName(name);
		setGraphpad(gp);
		setProject(p);
		
		if (file != null) {
			setSimuAppContext(file.getSimuAppContext());
			this.docFile = file;
		} else {
//			this.docFile = new IpssCustomFile();
		}
		
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new BorderLayout());
		
		mainTextArea = new JTextArea();
		String fontName = Translator.getString("CustomDocument.FontName");
		int fontSize = Integer.parseInt(Translator.getString("CustomDocument.FontSize"));
		int fontStyle = Integer.parseInt(Translator.getString("CustomDocument.FontStyle"));
		
		mainTextArea.setFont(new Font(fontName, fontStyle, fontSize));
		mainTextArea.setEditable(false);
		
		scrollPane = new JScrollPane(mainTextArea);
		this.add(BorderLayout.CENTER, scrollPane);

//		mainTextArea = new JTextArea(UIConfig.MainTextArea_Row, UIConfig.MainTextArea_Col);
//		mainTextArea = new JTextArea();
//		mainTextArea.setEditable(false);
//		
//		scrollPane = new JScrollPane(mainTextArea);
//		
//		this.add(BorderLayout.CENTER, scrollPane);
		
//		mainTextArea.setText(file.getFilePathName());

	      if (file == null)
		        return;

	      File textfile = new File(file.getFilePathName());

	      FileReader reader = null;
	      try {
	        reader = new FileReader(textfile);
	        mainTextArea.read(reader, null);
	      } catch (IOException ex) {
	        JOptionPane.showMessageDialog(this.getGraphpad().getFrame(),
	            "File Not Found", "ERROR", JOptionPane.ERROR_MESSAGE);
	      } finally {
	        if (reader != null) {
	          try {
	            reader.close();
	          } catch (IOException x) {
	          }
	        }
	      }
	}
	
	// Mike
	public IpssCustomFile getDocFile() {
		return this.docFile;
	}
	
	public boolean isModified() {
		return this.docFile.isModified();
	}
	
	public void setModified(boolean dirty) {
		this.docFile.setModified(dirty);
	}
	
	/**
	 * return the main text area for text project
	 * 
	 * @return
	 */
	public static JTextArea getMainTextArea() {
		return mainTextArea;
	}
	
/////////////////////////
/////////////////////////
/////////////////////////
/////////////////////////
	public String getFrameTitle() {
//		return (this.getName() == null ? Translator.getString("NewGraph")
//				: this.getName())
//				+ (modified ? "*" : "");
		return "";
	}
	
	public boolean close(boolean showConfirmDialog){
		return true;
	}
}
