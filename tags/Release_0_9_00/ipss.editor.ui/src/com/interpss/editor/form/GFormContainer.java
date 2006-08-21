package com.interpss.editor.form;

/**
*	A JavaBean: for storing form objects for Graphic Editor
*    Delete bus not implemented yet, bus id (number will not work)
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.NetUtilFunc;
import com.interpss.common.util.Num2Str;
import com.interpss.common.util.XmlUtil;
import com.interpss.editor.data.aclf.AclfBusData;
import com.interpss.editor.data.dist.DistBusData;
import com.interpss.editor.data.proj.ProjData;
import com.interpss.editor.form.base.BaseFormContainer;
import com.interpss.editor.jgraph.ui.data.IProjectData;
import com.interpss.editor.jgraph.ui.form.IGBranchForm;
import com.interpss.editor.jgraph.ui.form.IGBusForm;
import com.interpss.editor.jgraph.ui.form.IGFormContainer;
import com.interpss.editor.jgraph.ui.form.IGNetForm;

public class GFormContainer extends BaseFormContainer implements IGFormContainer {
	private GNetForm gNetForm = null;

	public GFormContainer() {
    	this.gNetForm = new GNetForm("undefined");
		setBusFormList(new ArrayList());
		setBranchFormList(new ArrayList());
		IpssLogger.getLogger().info("GFormContainer constructed");
	}	

	/** 
	* 	Reset the NetContainer to empty
	*/
	public void reset() {
		super.reset();
		getGNetForm().setId("");
		getGNetForm().setNewState(true);
		getGNetForm().setNextBusNumber(0);
		getGNetForm().setNextBranchNumber(0);
		getGNetForm().getBaseVoltList().clear();
	}

	public void rebuildRelation() {
		getGNetForm().rebuildRelation();
		for (int i = 0; i < getBusFormList().size(); i++) {
			((GBusForm)getBusFormList().get(i)).rebuildRelation();
		}
		for (int i = 0; i < getBranchFormList().size(); i++) {
			((GBranchForm)getBranchFormList().get(i)).rebuildRelation();
		}
	}
	
	public IGNetForm getGNetForm() { return this.gNetForm;	}
	public void setGNetForm(IGNetForm netForm) { this.gNetForm = (GNetForm)netForm;	}
	
	public Object xml2Object(String xmlStr, Class klass) {
		if (klass == IGBusForm.class) { 
			GBusForm form = (GBusForm)XmlUtil.toObject(xmlStr, GBusForm.class);
			form.setNewState(false);
			return form;
		}	
		else if (klass == IGBranchForm.class) { 
			GBranchForm form = (GBranchForm)XmlUtil.toObject(xmlStr, GBranchForm.class);
			form.setNewState(false);
			return form;
		}
		else if (klass == IGNetForm.class) { 
			GNetForm form = (GNetForm)XmlUtil.toObject(xmlStr, GNetForm.class);
			form.setNewState(false);
			return form;
		}
		else if (klass == IProjectData.class) 
			return XmlUtil.toObject(xmlStr, ProjData.class);
		return null;
	}
	
	/** 
	* 	Check the NetContainer form data
	*		- Rule-1: at least two buses and a branch in the net
	*
	* @return false if there are problems
	*/
	public Vector checkData(IPSSMsgHub msg) {
		IpssLogger.getLogger().info("GFormContainer.checkData() called");
		boolean ok = true;
		Vector errMsg = new Vector();
		if (gNetForm.isNewState()) {
			errMsg.add("The current case is not defined yet");
			ok = false;
		}
		else if (getBusFormList().size() == 0 && getBranchFormList().size() == 0) { 
			errMsg.add("The current network is empty");
			ok = false;
		}	
		else if (getBusFormList().size() < 2 || getBranchFormList().size() < 1) { 
			errMsg.add("Buses < 2 and/or branches < 1");
			ok = false;
		}	
	
		if (!ok) {
       		msg.sendErrorMsg(errMsg.toString());
		}
		if (ok)
			return null;
		else
			return errMsg;
	}
	

	/** 
	* 	Add a user entered base voltage value into the Base Voltage List
	*
	* @param volt the base voltage to add
	*/
	public void addBaseVolt(double volt) {
		String str = Num2Str.toStr(volt, "#0.00");
		Iterator itr = getGNetForm().getBaseVoltList().iterator();
		while (itr.hasNext()) {
			String v = (String)(itr.next());
			if (str.equals(v))
				return;
		}		
		getGNetForm().getBaseVoltList().add(str);		
	}
	
	/** 
	* 	Get the user entered base voltage array
	*
	* @return the base voltage array
	*/
	public Object[] getBaseVoltArray() {
		return getGNetForm().getBaseVoltList().toArray();
	}
	
	/** 
	 * 	Get distrition bus name into an array
	 *
	* @param type bus type (AllBus, UtilityBus ...)
	 * @return the bus id array
	 */
	 public Object[] getDistBusNameArray(String type) {
		 Vector vect = new Vector();
		 for ( int i = 0; i < getBusFormList().size(); i++ ) {
		  GBusForm form = (GBusForm)getBusFormList().get(i);
			 if (type == DistBusData.BusCode_AllBus)
			  vect.add(form.getName());
		  else if (type.equals(form.getDistBusData().getBusCode()))
			  vect.add(form.getName());
	   }   
		 return vect.toArray();
	 }

   /** 
	* 	Get distribution bus ids into an array
	*
   * @param type bus type (AllBus, UtilityBus ...)
	* @return the bus id array
	*/
	public Object[] getDistBusIdArray(String type) {
		Vector vect = new Vector();
		for ( int i = 0; i < getBusFormList().size(); i++ ) {
	         GBusForm form = (GBusForm)getBusFormList().get(i);
				if (type.equals(DistBusData.BusCode_AllBus))
	             vect.add(form.getId());
	         else if (type.equals(form.getDistBusData()))
	             vect.add(form.getId());
		}   
		return vect.toArray();
	}
   
	/** 
	* 	Get transmission bus name(id) into an array
	*
    * @param type bus type (AllBus, UtilityBus ...)
	* @return the bus name(id) array
	*/
	public Object[] getTransBusNameIdArray(String genType) {
		Vector vect = new Vector();
		for ( int i = 0; i < getBusFormList().size(); i++ ) {
	        GBusForm form = (GBusForm)getBusFormList().get(i);
            if (genType.equals(form.getAcscBusData().getGenCode()))
            	vect.add(NetUtilFunc.createBusDisplayNameId(form.getName(), form.getId()));
		}   
		return vect.toArray();
	}

	   
	/** 
	* 	Get machine ids into an array
	*
	* @return the machine id array
	*/
	public Object[] getMachIdArray() {
		Vector vect = new Vector();
		for ( int i = 0; i < getBusFormList().size(); i++ ) {
	        GBusForm form = (GBusForm)getBusFormList().get(i);
	        if (form.getDStabBusData().isMachineBus()) {
	        	String machId = Constants.MachIdToken + form.getId();
	        	vect.add(machId);
	        }
		}   
		return vect.toArray();
	}
	
	/** 
	* 	Get machine ids into an array
	*
	* @return the machine id array
	*/
	public String getMachIdLargestInertia() {
		String id = "";
		double x = 0.0;
		for ( int i = 0; i < getBusFormList().size(); i++ ) {
	        GBusForm form = (GBusForm)getBusFormList().get(i);
	        if (form.getDStabBusData().isMachineBus()) {
	        	if (form.getDStabBusData().getMachData().getInertia() > x) {
	        		x = form.getDStabBusData().getMachData().getInertia();
		        	id = Constants.MachIdToken + form.getId();
	        	}
	        }
		}   
		return id;
	}
	
	/** 
	* 	Get transmission targeted TapVControl bus name(id) into an array. The bus could not be a Swing, PV or PQ bus
	*
	* @return the bus name(id) array
	*/
	public Object[] getTargetVCBusNameIdArray() {
		Vector vect = new Vector();
		for ( int i = 0; i < getBusFormList().size(); i++ ) {
	        GBusForm form = (GBusForm)getBusFormList().get(i);
            if (!form.getAcscBusData().getGenCode().equals(AclfBusData.GenCode_Swing) &&
            	!form.getAcscBusData().getGenCode().equals(AclfBusData.GenCode_PV) &&
				!form.getAcscBusData().getGenCode().equals(AclfBusData.GenCode_PQ))
            	vect.add(NetUtilFunc.createBusDisplayNameId(form.getName(), form.getId()));
		}   
		return vect.toArray();
	}
	
	/** 
	* 	Get distribution branch name into an array
	*
   * @param type branch type (AllBranch, FeederBranch ...)
	* @return the branch bus name array
	*/
	public Object[] getDistBranchBusNameArray(String type) {
		Vector vect = new Vector();
		for ( int i = 0; i < getBranchFormList().size(); i++ ) {
          GBranchForm form = (GBranchForm)getBranchFormList().get(i);
          if (type.equals(IGBranchForm.DistBranchCode_AllBranch))
            vect.add(form.getDefaultName());
          else if (type.equals(form.getDistBranchData().getBranchCode()))
            vect.add(form.getDefaultName());
        }   
		return vect.toArray();
	}

   /** 
	* 	Get distribution branch number into an array
	*
   * @param type branch type (AllBranch, FeederBranch ...)
	* @return the branch number array
	*/
	public Object[] getDistBranchNoArray(String type) {
		Vector vect = new Vector();
		for ( int i = 0; i < getBranchFormList().size(); i++ ) {
          GBranchForm form = (GBranchForm)getBranchFormList().get(i);
          if (type.equals(IGBranchForm.DistBranchCode_AllBranch))
            vect.add(form.getBranchNumber());
          else if (type.equals(form.getDistBranchData().getBranchCode()))
            vect.add(form.getBranchNumber());
      }   
		return vect.toArray();
	}

   /** 
	* 	Get distribution branch ids into an array
	*
   * @param type branch type (AllBranch, FeederBranch ...)
	* @return the branch id array
	*/
	public Object[] getDistBranchIdArray(String type) {
		Vector vect = new Vector();
		for ( int i = 0; i < getBranchFormList().size(); i++ ) {
          GBranchForm form = (GBranchForm)getBranchFormList().get(i);
          if (type.equals(IGBranchForm.DistBranchCode_AllBranch))
            vect.add(form.getId());
          else if (type.equals(form.getDistBranchData().getBranchCode()))
            vect.add(form.getId());
        }   
		return vect.toArray();
	}

   /**
	*	Get the default bus id, "0001", "0002" ...
	*
	* @return the generated bus id
	*/
	public String getDefaultBusId() {
		int n = gNetForm.getNextBusNumber();
      if (n == 0) {
          n = getBusFormList().size()+1;
      }    
		gNetForm.setNextBusNumber(n+1);
		return formatIdNumber(new Integer(n).toString());
	}
	
   /**
	*	Get the default branch id, "0001", "0002" ...
	*
	* @return the generated bus id
	*/
	public String getDefaultBranchId() {
		int n = gNetForm.getNextBranchNumber();
      if (n == 0) {
          n = getBranchFormList().size()+1;
      }    
		gNetForm.setNextBranchNumber(n+1);
		return formatIdNumber(new Integer(n).toString());
   }
   
	/**
	*	Init the NetForm object to the specified netType and appType
	*
	* @param netType the network type string
	* @param appType the application type string
	*/	
	public void initGNetForm(String netType, String appType) {
		if (appType.equals(IGNetForm.AppType_Distribution))
			InitDataUtil.initScData_DistNet(gNetForm);
		else {
			if (netType.equals(IGNetForm.NetType_DStabilityNet))
				InitDataUtil.initScData_DStabNet(gNetForm);
			else
				InitDataUtil.initScData_AcscNet(gNetForm);
		}	
	}

	/**
	*	Create a BusForm object with the default bus id and add the object to the bus list
	*
	* @return the created BusForm object
	*/	
	public IGBusForm createGBusForm() {
		GBusForm form = new GBusForm(getDefaultBusId(), gNetForm.getAppType());
		form.setName("Bus-"+ new Integer(form.getId()).toString());
		form.setNewState(true);
		if ( gNetForm.getAppType().equals(IGNetForm.AppType_Distribution))
			InitDataUtil.initScData_DistBus(gNetForm.getDistNetData(), form);
		else {
			if (gNetForm.getNetType().equals(IGNetForm.NetType_DStabilityNet)) 
				InitDataUtil.initScData_DStabBus(gNetForm.getDStabNetData(), form);
			else
				InitDataUtil.initScData_AcscBus(gNetForm.getAcscNetData(), form);
		}	
		getBusFormList().add(form);
		return form;
	}

	/**
	*	Make a copy of the form and add the object to the bus list with the default id
	*
	* @param form the bus form object to be copied
	* @return the created BusForm object
	*/	
	public IGBusForm createGBusForm(IGBusForm form) {
		IGBusForm newForm = (IGBusForm)form.clone();
		newForm.setId(getDefaultBusId());
		form.setName("Bus-"+ new Integer(form.getId()).toString());
		getBusFormList().add(newForm);
		return newForm;
	}

	/**
	*	Create a BranchForm object and add the object to the branch list
	*
	* @return the created BranchForm object
	*/	
	public IGBranchForm createGBranchForm() {
		GBranchForm form = new GBranchForm("branchid", gNetForm.getAppType());
		form.setNewState(true);
		form.setBranchNumber(getDefaultBranchId());
		if ( gNetForm.getAppType().equals(IGNetForm.AppType_Distribution))
			InitDataUtil.initScData_DistBranch(gNetForm.getDistNetData(), form);
		else {
			if (gNetForm.getNetType().equals(IGNetForm.NetType_DStabilityNet)) 
				InitDataUtil.initScData_DStabBranch(form);
			else
				InitDataUtil.initScData_AcscBranch(form);
		}	
		getBranchFormList().add(form);
		return form;
	}
	
	/**
	*	Make a copy of the form and add the object to the branch list
	*
	* @param form the branch form object to be copied
	* @return the created BranchForm object
	*/	
	public IGBranchForm createGBranchForm(IGBranchForm form) {
		IGBranchForm newForm = (IGBranchForm)form.clone();
		newForm.setId("branchid");
		newForm.setBranchNumber(getDefaultBranchId());
		getBranchFormList().add(newForm);
		return newForm;
	}

	/**
	*	Convert the net to a string for display purpose, including bus and branch
	*
	* @return the string representation
	*/
	public String toString() {
		StringBuffer xml = new StringBuffer();
		xml.append(XmlUtil.toXmlString(getGNetForm()));
		for (int i = 0; i < getBusFormList().size(); i++) {
			xml.append(XmlUtil.toXmlString(getBusFormList().get(i)));
		}
		for (int i = 0; i < getBranchFormList().size(); i++) {
			xml.append(XmlUtil.toXmlString(getBranchFormList().get(i)));
		}
		return xml.toString();
	}
}