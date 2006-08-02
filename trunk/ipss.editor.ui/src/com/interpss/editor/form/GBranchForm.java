package com.interpss.editor.form;

/**
	A JavaBean class for Graphic Branch form data
*/

import com.interpss.common.util.XmlUtil;
import com.interpss.editor.data.acsc.AcscBranchData;
import com.interpss.editor.data.dist.DistBranchData;
import com.interpss.editor.data.dstab.DStabBranchData;
import com.interpss.editor.form.base.BaseBranchForm;
import com.interpss.editor.jgraph.ui.form.IGBranchForm;
import com.interpss.editor.jgraph.ui.form.IGNetForm;
import com.interpss.editor.jgraph.ui.form.IUserData;

public class GBranchForm extends BaseBranchForm implements IGBranchForm, java.io.Serializable {
	private static final long serialVersionUID = 1;

	/**
	*	Default constructor
	*/
    public GBranchForm() {
    }	

	/**
	*	Constructor
	*
	* @param id branch id
	*/
    public GBranchForm(String id, String appType) {
        setAppType(appType);
		if (appType.equals(IGNetForm.AppType_Distribution))
			distBranchData = new DistBranchData();
		else {
    		acscBranchData =  new AcscBranchData();
    		dstabBranchData =  new DStabBranchData();
    		dstabBranchData.setAcscBranchData(acscBranchData);
		}	
        setId(id);
    }	    

    public void rebuildRelation() {
		if (dstabBranchData != null)
			dstabBranchData.setAcscBranchData(acscBranchData);
    }
    
	/*
	*	Clone the current branch object
	*
	* @return the clone
	*/
    public Object clone() {
		String xml = XmlUtil.toXmlString(this);
		GBranchForm form = (GBranchForm)XmlUtil.toObject(xml);
		form.rebuildRelation();
		return form;
    }
    
	/**
	*	Get the display string
	*
	* @return the display string
	*/
	public String getLabel(String type) {
		if (IUserData.BRANCH_LABEL.equals(type))
			return getName();
		else if (IUserData.BRANCH_SOURCE_LABEL.equals(type))
			return "1.005\n1.2+j0.8";
		else if (IUserData.BRANCH_TARGET_LABEL.equals(type))
			return "1.005\n1.2+j0.8";
		else
			return "Wrong label type: " + type;
	}

	private DStabBranchData dstabBranchData = null;
	public DStabBranchData getDStabBranchData() { return this.dstabBranchData; }
	public void setDStabBranchData(DStabBranchData form) { this.dstabBranchData = form; } 

	private AcscBranchData acscBranchData = null;
	public AcscBranchData getAcscBranchData() { return this.acscBranchData; }
	public void setAcscBranchData(AcscBranchData form) { this.acscBranchData = form; } 
	
	private DistBranchData distBranchData = null;
	public DistBranchData getDistBranchData() { return this.distBranchData; }
	public void setDistBranchData(DistBranchData form) { this.distBranchData = form; } 
	
	/* if the branch is in newly created status */
	private boolean newState = true;
	public boolean isNewState() { return this.newState; }
	public void setNewState(boolean b) { this.newState = b; } 
	
	public String getTransBranchLfCode() {
		return getAcscBranchData().getLfCode();
	}
	
	public String getDistBranchCode() {
		return getDistBranchData().getBranchCode();
	}
	
	// do not remove : for old file format
	public String getDisplayStr() {
		return getLabel(IUserData.BRANCH_LABEL);
	}
	
	/**
	 * Get the from(source) node label
	 */
	public String getSourceLabel() {
		return "1.2+j0.7";
	}
	
	/**
	 * Get the to(traget) node label
	 */	
	public String getTargetLabel() {
		return "1.2+j0.7";
	}	
}