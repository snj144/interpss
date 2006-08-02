package com.interpss.editor.form;

import java.util.TreeSet;

import com.interpss.editor.data.acsc.AcscNetData;
import com.interpss.editor.data.dist.DistNetData;
import com.interpss.editor.data.dstab.DStabNetData;
import com.interpss.editor.form.base.BaseNetForm;
import com.interpss.editor.jgraph.ui.form.IGNetForm;
import com.interpss.editor.jgraph.ui.form.IUserData;

public class GNetForm extends BaseNetForm implements IGNetForm, java.io.Serializable {
	private static final long serialVersionUID = 1;
	
    private String  netType = NetType_AclfNetwork;   		
	private String  appType = AppType_Transmission;  		 
	
	/**
	*	Default constructor
	*/
    public GNetForm() {
    }	

	/**
	*	Constructor
	*
	* @param id net id
	*/
    public GNetForm(String id) {
        setId(id);
    	distNetData = new DistNetData();
    	acscNetData = new AcscNetData();
    	dStabNetData = new DStabNetData();
        rebuildRelation();
    }	    

    public void rebuildRelation() {
		if (dStabNetData != null)
			dStabNetData.setAcscNetData(acscNetData);
    }
    
	/**
	*	Get the display string
	*
	* @return the display string
	*/
	public String getLabel(String type) {
		if (IUserData.NET_LABEL.equals(type))
			return getId();
		else if (IUserData.NET_ANNOTATE_LABEL.equals(type))
			return "Network Annotate Str";
		else
			return "Wrong label type: " + type;
	}
	
	public String getAppType() { return this.appType; }
	public void setAppType(String str) { this.appType = str; }
	
    public String getNetType() { return this.netType; }
    public void setNetType(String netType) { this.netType = netType; }
    
	private AcscNetData acscNetData = null;
	public AcscNetData getAcscNetData() { return this.acscNetData; }
	public void setAcscNetData(AcscNetData form) { this.acscNetData = form; } 
	
	private DStabNetData dStabNetData = null;
	public DStabNetData getDStabNetData() { return this.dStabNetData; }
	public void setDStabNetData(DStabNetData form) { this.dStabNetData = form; } 

	private DistNetData distNetData = null;
	public DistNetData getDistNetData() { return this.distNetData; }
	public void setDistNetData(DistNetData form) { this.distNetData = form; } 
	
	/* if the branch is in newly created status */
	private boolean newState = true;
	public boolean isNewState() { return this.newState; }
	public void setNewState(boolean b) { this.newState = b; } 

	/* user entered base voltage list */
	private TreeSet baseVoltList = new TreeSet();
	public TreeSet getBaseVoltList() { return this.baseVoltList; }
	public void setBaseVoltList(TreeSet vect) { this.baseVoltList = vect; } 
   
   /* generatr next bus number */
	private int nextBusNumber = 0;
	public int getNextBusNumber() { return this.nextBusNumber; }
	public void setNextBusNumber(int n) { this.nextBusNumber = n; } 

   /* generatr next branch number */
	private int nextBranchNumber = 0;
	public int getNextBranchNumber() { return this.nextBranchNumber; }
	public void setNextBranchNumber(int n) { this.nextBranchNumber = n; } 
	
	// do not remove : for old file format
	public String getDisplayStr() {
		return getLabel(IUserData.NET_LABEL);
	}
}