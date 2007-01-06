package org.interpss.editor.ui.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;

public class GUIFileUtil {
	/**
	 * Read to contents of the file (text file) into the textarea
	 * 
	 * @param filename
	 * @param textArea
	 * @return
	 */
	public static boolean readFile2Textarea(String filename, JTextArea textArea) {
		IpssLogger.getLogger().info("GUIFileUtil.readFile2Textarea() info from file: " + filename);
		File textfile = new File(filename);
	      FileReader reader = null;
	      try {
	    	  reader = new FileReader(textfile);
	    	  textArea.read(reader, null);
	    	  return true;
	      } catch (IOException ex) {
				SpringAppContext.getIpssMsgHub().sendErrorMsg("Cannot readt file: " + filename);
	      } finally {
	    	  if (reader != null) {
	    		  try {
	    			  reader.close();
	    		  } catch (IOException x) {
	  				SpringAppContext.getIpssMsgHub().sendErrorMsg("Cannot close file: " + filename);
	    		  }
	    	  }
	      }		
	      return false;
	}
	
	/**
	 * Write the contents of the textarea to the file
	 * 
	 * @param filename
	 * @param textArea
	 * @return
	 */
	public static boolean writeTextarea2File(String filename, JTextArea textArea) {
		IpssLogger.getLogger().info("GUIFileUtil.writeTextarea2File() info to file: " + filename);
		try {
			OutputStream out = new BufferedOutputStream(new FileOutputStream(filename));
			out.write(textArea.getText().getBytes());
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			SpringAppContext.getIpssMsgHub().sendErrorMsg("Cannot save to file: " + filename);
		}
		return false;
	}
}
