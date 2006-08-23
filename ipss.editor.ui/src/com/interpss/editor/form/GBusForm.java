package com.interpss.editor.form;

/**
*  A JavaBean class for Graphic Bus form data
*/

import com.interpss.common.util.XmlUtil;
import com.interpss.editor.data.acsc.AcscBusData;
import com.interpss.editor.data.dist.DistBusData;
import com.interpss.editor.data.dstab.DStabBusData;
import com.interpss.editor.form.base.BaseBusForm;
import com.interpss.editor.jgraph.ui.form.IGBusForm;
import com.interpss.editor.jgraph.ui.form.IGNetForm;
import com.interpss.editor.jgraph.ui.form.IUserData;

public class GBusForm extends BaseBusForm implements IGBusForm, java.io.Serializable {
	private static final long serialVersionUID = 1;

	// constants
	public static byte
			H_Orientation = 1,
			V_Orientation = 2;
	
	private String busLabel = null;
	private String annotateLabel = null;

	/**
	*	Default constructor
	*/
    public GBusForm() {
    }	

    /**
	*	Constructor
	*
	* @param id bus id
	*/
    public GBusForm(String id, String appType) {
        setAppType(appType);
		if (appType.equals(IGNetForm.AppType_Distribution))
			distBusData = new DistBusData();
		else {
    		acscBusData =  new AcscBusData();
    		dStabBusData =  new DStabBusData();
    		rebuildRelation();
		}	
        setId(id);
	}	    
    
    public void rebuildRelation() {
		if (dStabBusData != null)
			dStabBusData.setAcscBusData(acscBusData);
    }
    
    public Object clone() {
		XmlUtil.ToolKid = XmlUtil.TOOL_JDK;
		String xml = XmlUtil.toXmlString(this);
		GBusForm form = (GBusForm)XmlUtil.toObject(xml);
		form.rebuildRelation();
		return form;
    }

	/**
	*	Get the display string
	*
	* @return the display string
	*/
	public String getLabel(String type) {
		if (IUserData.BUS_LABEL.equals(type))
			return getBusLabel();
		else if (IUserData.BUS_ANNOTATE_LABEL.equals(type))
			return getAnnotateLabel();
		else
			return "Wrong label type: " + type;
	}
	
	private DStabBusData dStabBusData = null;
	public DStabBusData getDStabBusData() { return this.dStabBusData; }
	public void setDStabBusData(DStabBusData form) { this.dStabBusData = form; } 
	
	private AcscBusData acscBusData = null;
	public AcscBusData getAcscBusData() { return this.acscBusData; }
	public void setAcscBusData(AcscBusData form) { this.acscBusData = form; } 
	
	private DistBusData distBusData = null;
	public DistBusData getDistBusData() { return this.distBusData; }
	public void setDistBusData(DistBusData form) { this.distBusData = form; } 

	/* if the branch is in newly created status */
	private boolean newState = true;
	public boolean isNewState() { return this.newState; }
	public void setNewState(boolean b) { this.newState = b; } 
	
	/* bus cell graph orientation */
	private byte orientation = V_Orientation;
	public byte getOrientation() { return this.orientation; }
	public void setOrientation(byte b) { this.orientation = b; }

	/**
	 * @return Returns the annotateLabel.
	 */
	public String getAnnotateLabel() {
		if (annotateLabel == null)
			return "Annotate\nLabel";
		return annotateLabel;
	}

	/**
	 * @param annotateLabel The annotateLabel to set.
	 */
	public void setAnnotateLabel(String annotateLabel) {
		this.annotateLabel = annotateLabel;
	}

	/**
	 * @return Returns the busLabel.
	 */
	public String getBusLabel() {
		if (busLabel == null)
			busLabel = getName();
		return busLabel;
	}

	/**
	 * @param busLabel The busLabel to set.
	 */
	public void setBusLabel(String busLabel) {
		this.busLabel = busLabel;
	} 
	
	// do not remove : for old file format
	public String getDisplayStr() {
		return getLabel(IUserData.BUS_LABEL);
	}
}