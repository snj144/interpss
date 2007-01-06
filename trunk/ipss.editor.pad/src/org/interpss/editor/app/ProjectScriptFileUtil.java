package org.interpss.editor.app;

import java.io.File;

import org.interpss.editor.coreframework.IpssEditorDocument;
import org.interpss.editor.coreframework.IpssTextDocument;
import org.interpss.editor.coreframework.IpssTextFile;
import org.interpss.editor.doc.IpssProjectItem;

import com.interpss.common.SpringAppContext;

public class ProjectScriptFileUtil {
	public static String DStabPlotScriptFilename = "DStabPlotScripts.js";
	
	public static IpssTextFile getDStabPlotScriptFile(IpssEditorDocument doc) {
		IpssProjectItem item = doc.getGraphpad().getCurrentProjectItem();
		String filename = item.getFileNameNoExt()+DStabPlotScriptFilename;
		String filepath = item.getProject().getProjectPath() + System.getProperty("file.separator") + filename;
		File file = new File(filepath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				SpringAppContext.getIpssMsgHub().sendErrorMsg("Cannot create DStab Plot Scripting file: " + filepath);
				return null;
			}
			IpssTextFile ipssFile = new IpssTextFile(filepath);
			IpssTextDocument d = new IpssTextDocument(null, item.getProject(), filename, ipssFile);
			item.addDocument(d, 0);			
		}
		return new IpssTextFile(filepath);
	}
}
