package org.interpss.editor.coreframework;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.interpss.editor.doc.IpssProject;
import org.interpss.editor.resources.Translator;


public class IpssTextDocument extends IpssEditorDocument{
	
	/**
	 * Container for the graph so that you can scroll over the graph
	 */
	protected JScrollPane scrollPane;
	
	private static JTextArea mainTextArea;
	
	protected IpssTextFile docFile;
	
	public IpssTextDocument(GPGraphpad gp, IpssProject p, String name,IpssTextFile file) {
		super();
		
		setDoubleBuffered(true);
		updateUI();
		
		this.setName(name);
		setGraphpad(gp);
		setProject(p);
		
		if (file != null) {
			this.docFile = file;
		} else {
			this.docFile = new IpssTextFile(name);
		}
		
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new BorderLayout());
		
		mainTextArea = new JTextArea();

		String fontName = Translator.getString("TextDocument.FontName");
		int fontSize = Integer.parseInt(Translator.getString("TextDocument.FontSize"));
		int fontStyle = Integer.parseInt(Translator.getString("TextDocument.FontStyle"));
		
		mainTextArea.setFont(new Font(fontName, fontStyle, fontSize));
//		mainTextArea.setEditable(false);
		
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

	      File textfile = new File(this.docFile.getFilePathName());

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
	      
			mainTextArea.getDocument().addDocumentListener(new DocumentListener(){
				
			    public void insertUpdate(DocumentEvent e)
			    {
			    	setModified(true);
			    }
			    public void removeUpdate(DocumentEvent e)
			    {
			    	setModified(true);
			    }
			    public void changedUpdate(DocumentEvent e)
			    {
			    	setModified(true);
			    }
				
			});
			
		//	setModified(false);
	}
	
	// Mike
	public IpssTextFile getDocFile() {
		return this.docFile;
	}
	
	public boolean isModified() {
		return this.docFile.isModified();
	}
	
	public void setModified(boolean dirty) {
		this.docFile.setModified(dirty);
		graphpad.refreshDocumentEditorPanel(this);
	}
	
	/**
	 * return the main text area for text project
	 * 
	 * @return
	 */
	public JTextArea getMainTextArea() {
		return mainTextArea;
	}
	
	public String getText() {
		return mainTextArea.getText();
	}

	public boolean close(boolean showConfirmDialog){
		// set default to save on close
		int r = JOptionPane.YES_OPTION;

		if (isModified()) {
			if (showConfirmDialog)
				r = JOptionPane.showConfirmDialog(getGraphpad().getFrame(), "'"
						+ getFileName() + "'"
						+ Translator.getString("TextSaveChangesDialog"),
						Translator.getString("Title"),
						JOptionPane.YES_NO_CANCEL_OPTION);

			// if yes, then save and close
			if (r == JOptionPane.YES_OPTION) {
				getGraphpad().getCommand("FileSave").actionPerformed(null);
				return true;
			}
			// if no, then don't save and just close
			else if (r == JOptionPane.NO_OPTION) {
				return true;
			}
			// all other conditions (cancel and dialog's 'X' button)
			// don't save and don't close
			else
				return false;
		}
		return true;
	}
}
