package org.interpss.editor.jgraph.ui.impl.data;

/**
	Current user project info
*/

import java.util.ArrayList;
import java.util.List;

import org.interpss.editor.jgraph.ui.data.IProjectData;

import com.interpss.common.util.StringUtil;
import com.interpss.common.util.XmlUtil;

public class DummyProjData implements IProjectData {
	public static String NewProjName = "UnSaved";

	private int projectDbId = 0;
	private String projectName = NewProjName;
	private String description = "";
	private String filepath = null;
	private String workspacePath = null;
	private boolean dirty = false;
	private List caseList = new ArrayList();

	/* current case name */
	private String aclfCaseName = null;
	private String acscCaseName = null;
	private String dStabCaseName = null;

	public DummyProjData() {}

	public int getProjectDbId() {return this.projectDbId;}
	public void setProjectDbId(int id) {this.projectDbId = id; }
	
	public String getProjectName() {return this.projectName;}
	public void setProjectName(String str) {this.projectName = str;}

	public String getDescription() {return this.description;}
	public void setDescription(String str) {this.description = str;}

	public String getFilepath() {return this.filepath;}
	public String getFilename() {return StringUtil.getFileName(this.filepath);}
	public void setFilepath(String str) {this.filepath = str;}

	public boolean isDirty() {return this.dirty;}
	public void setDirty(boolean b) {
		this.dirty = b; 
	}

	public List getCaseList() {return this.caseList;}
	public void setCaseList(List list) {this.caseList = list;}

	// logic functions

	/**
	*	Check if the current case is a new case
	*
	* @return true if is a new case 
	*/
	public boolean isNewProject() { return this.filepath == null; }
	
	/**
	* 	Set the current case to a new case
	*/
	public void setToNewProject() {
		this.projectName = NewProjName;
		this.description = "";
		this.filepath = null;
		this.caseList = new ArrayList();
	}

	/**
	 * @return Returns the aclfCaseName.
	 */
	public String getAclfCaseName() {
		return aclfCaseName;
	}

	/**
	 * @param aclfCaseName The aclfCaseName to set.
	 */
	public void setAclfCaseName(String aclfCaseName) {
		this.aclfCaseName = aclfCaseName;
	}

	/**
	 * @return Returns the acscCaseName.
	 */
	public String getAcscCaseName() {
		return acscCaseName;
	}

	/**
	 * @param acscCaseName The acscCaseName to set.
	 */
	public void setAcscCaseName(String name) {
		this.acscCaseName = name;
	}

	/**
	 * @return Returns the dstabCaseName.
	 */
	public String getDStabCaseName() {
		return dStabCaseName;
	}

	/**
	 * @param dstabCaseName The dstabCaseName to set.
	 */
	public void setDStabCaseName(String name) {
		this.dStabCaseName = name;
	}
	
    public String toString() {
		return XmlUtil.toXmlString(this);
	}

	/**
	 * @return the workspacePath
	 */
	public String getWorkspacePath() {
		return workspacePath;
	}

	/**
	 * @param workspacePath the workspacePath to set
	 */
	public void setWorkspacePath(String workspacePath) {
		this.workspacePath = workspacePath;
	}		
	
	public String getDbSchemaVersion() {
		return "1.00.00";
	}

	public void setDbSchemaVersion(String v) {
	}
}