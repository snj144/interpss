 /*
  * @(#)DStabCaseData.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.editor.data.proj;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.interpss.editor.data.dstab.DStabDEventData;

import com.interpss.common.rec.BaseDataBean;
import com.interpss.common.util.IpssLogger;

public class DStabCaseData extends BaseDataBean {
	public static final String Method_ModifiedEuler = "Modified Euler";
	public static final String Method_RungeKutta = "Runge Kutta";
	
	public static final String StaticLoad_Const_Z = "Const-Z";
	public static final String StaticLoad_Const_P = "Const-P";	
	
	private String simuMethod = Method_ModifiedEuler;
	private double totalSimuTime = 0.0;
	private double simuStep = 0.0;
	private boolean disableDynamicEvent = false;
	private boolean absoluteMachValue = false;
	private String refMachId = "";
	private int netEqnItrNoEvent = 3;
	private int netEqnItrWithEvent = 5;
	private String staticLoadType = StaticLoad_Const_Z;
	// when const_P load, voltage lower than the SwitchVolt, change to const Z 
	private double staticLoadSwitchVolt = 0.65;
	private double staticLoadSwitchDeadZone = 0.05;
	private List dEventList = new ArrayList();
	
	public DStabCaseData() {
		
	}
	/**
	 * @return Returns the simuMethod.
	 */
	public String getSimuMethod() {
		return simuMethod;
	}
	/**
	 * @param simuMethod The simuMethod to set.
	 */
	public void setSimuMethod(String simuMethod) {
		this.simuMethod = simuMethod;
	}
	/**
	 * @return Returns the simuStep.
	 */
	public double getSimuStep() {
		return simuStep;
	}
	/**
	 * @param simuStep The simuStep to set.
	 */
	public void setSimuStep(double simuStep) {
		this.simuStep = simuStep;
	}
	/**
	 * @return Returns the totalSimuTime.
	 */
	public double getTotalSimuTime() {
		return totalSimuTime;
	}
	/**
	 * @param totalSimuTime The totalSimuTime to set.
	 */
	public void setTotalSimuTime(double totalSimuTime) {
		this.totalSimuTime = totalSimuTime;
	}

	public List getDEventList() {return this.dEventList;}
	public void setDEventList(List list) {this.dEventList = list;}
	
	/**
	 * @return Returns the dEventData.
	 */
	public DStabDEventData getDEventData(String eventName) {
		List eventList = getDEventList();
		for (int i = 0; i < getDEventList().size(); i++) {
			DStabDEventData eventData = (DStabDEventData)eventList.get(i);
			if (eventData != null)
				if (eventName.equals(eventData.getEventName())) {
					IpssLogger.getLogger().info("DEventData found, event name: " + eventName);
					return eventData;
				}    
		}
		IpssLogger.getLogger().info("DEventData not found, event name: " + eventName);
	    return null;
	}
	
	/**
	 * Get the first event in the EventList. Create a new Event if the eventList is empty
	 * 
	 * @return an evnet object
	 */
	public DStabDEventData getAnyEventData() {
		List eventList = getDEventList();
		if (eventList.size() == 0)
			addDEventData(new DStabDEventData());
		return (DStabDEventData)eventList.get(0);
	}

	public boolean addDEventData(DStabDEventData eventData) {
		if (getDEventData(eventData.getEventName()) == null) {
			getDEventList().add(eventData);
			return true;
		}
		//TODO: DialogUtil.showMsgDialog("Warning", "Event with the same name already exists, event name :" + eventData.getEventName());
		return false;
	}

	public boolean removeDEventData(DStabDEventData eventData) {
		if (getDEventData(eventData.getEventName()) != null) {
			getDEventList().remove(eventData);
			return true;
		}
		//TODO: DialogUtil.showMsgDialog("Warning", "Event does not exists, event name :" + eventData.getEventName());
		return false;
	}
	
	public Object[] getEventNameArray() {
	    Vector vect = new Vector();
		List eventList = getDEventList();
		if (getDEventList().size() > 0)
			for (int i = 0; i < getDEventList().size(); i++) {
				DStabDEventData eventData = (DStabDEventData)eventList.get(i);
				vect.add(eventData.getEventName());
			}
		else
			vect.add("");
		return vect.toArray();
	}
	/**
	 * @return Returns the staticLoadSwitchVolt.
	 */
	public double getStaticLoadSwitchVolt() {
		return staticLoadSwitchVolt;
	}
	/**
	 * @param staticLoadSwitchVolt The staticLoadSwitchVolt to set.
	 */
	public void setStaticLoadSwitchVolt(double staticLoadSwitchVolt) {
		this.staticLoadSwitchVolt = staticLoadSwitchVolt;
	}
	/**
	 * @return Returns the staticLoadType.
	 */
	public String getStaticLoadType() {
		return staticLoadType;
	}
	/**
	 * @param staticLoadType The staticLoadType to set.
	 */
	public void setStaticLoadType(String staticLoadType) {
		this.staticLoadType = staticLoadType;
	}
	/**
	 * @return Returns the netEqnItrNoEvent.
	 */
	public int getNetEqnItrNoEvent() {
		return netEqnItrNoEvent;
	}
	/**
	 * @param netEqnItrNoEvent The netEqnItrNoEvent to set.
	 */
	public void setNetEqnItrNoEvent(int netEqnItrNoEvent) {
		this.netEqnItrNoEvent = netEqnItrNoEvent;
	}
	/**
	 * @return Returns the netEqnItrWithEvent.
	 */
	public int getNetEqnItrWithEvent() {
		return netEqnItrWithEvent;
	}
	/**
	 * @param netEqnItrWithEvent The netEqnItrWithEvent to set.
	 */
	public void setNetEqnItrWithEvent(int netEqnItrWithEvent) {
		this.netEqnItrWithEvent = netEqnItrWithEvent;
	}
	/**
	 * @return Returns the staticLoadSwitchDeadZone.
	 */
	public double getStaticLoadSwitchDeadZone() {
		return staticLoadSwitchDeadZone;
	}
	/**
	 * @param staticLoadSwitchDeadZone The staticLoadSwitchDeadZone to set.
	 */
	public void setStaticLoadSwitchDeadZone(double staticLoadSwitchDeadZone) {
		this.staticLoadSwitchDeadZone = staticLoadSwitchDeadZone;
	}
	/**
	 * @return Returns the disableDynamicEvent.
	 */
	public boolean getDisableDynamicEvent() {
		return disableDynamicEvent;
	}
	/**
	 * @param disableDynamicEvent The disableDynamicEvent to set.
	 */
	public void setDisableDynamicEvent(boolean disableDynamicEvent) {
		this.disableDynamicEvent = disableDynamicEvent;
	}
	/**
	 * @return the absoluteMachValue
	 */
	public boolean isAbsoluteMachValue() {
		return absoluteMachValue;
	}
	/**
	 * @param absoluteMachValue the absoluteMachValue to set
	 */
	public void setAbsoluteMachValue(boolean absoluteMachValue) {
		this.absoluteMachValue = absoluteMachValue;
	}
	/**
	 * @return the refMachId
	 */
	public String getRefMachId() {
		return refMachId;
	}
	/**
	 * @param refMachId the refMachId to set
	 */
	public void setRefMachId(String refMachId) {
		this.refMachId = refMachId;
	}
}