package com.interpss.editor.data.dist;

import java.util.ArrayList;
import java.util.List;

import com.interpss.common.exp.InvalidParameterException;
import com.interpss.common.rec.BaseDataBean;
import com.interpss.editor.data.common.ScPointData;

/**
*	DistNetForm class for storing distribution network data.
*/

public class DistNetData extends BaseDataBean {
	public static final String ScStd_ANSI = "ANSI"; 
	public static final String ScStd_Generic = "Generic"; 
	public static final String ScStd_IEC = "IEC"; 

	// multi-points SC analysis only applies to ANSI and IEC
	private String  scStd = ScStd_Generic;          // Generic | ANSI | IEC
	private int     scPoints = 0;
	private List    scPointList = new ArrayList();	// vector of ScPointForm objects

	// if loadSchedulePoints = 0, no load schedule analysis
	private int     loadSchedulePoints = 0;
	private double  loadSchedulePeriodLength = 1.0;
	private String  loadSchedulePeriodUnit = "Hour";
	private double  totalLossKwHr = 0.0;
	private List    lfStatusList = new ArrayList();
	
    public DistNetData() { }	
   
    // Additional functions
	// ====================
	public int getActiveScPoints() { 
		int n = 0;
		for (int i = 0; i < this.scPointList.size(); i++) {
    		ScPointData row = (ScPointData)this.scPointList.get(i);
    		if (row.getEnable()) n++;
    	}	
    	//System.out.println("NetForm active sc points: " + n);
		return n; 
	}

	public void setLfStatus(boolean status, int index) {
		if (getLfStatusList().size() > index)
			getLfStatusList().set(index, new Boolean(status));
		else
			getLfStatusList().add(index, new Boolean(status));
	}
	
	public boolean getLfStatus(int index) {
		if (getLfStatusList().get(index) != null)
			return ((Boolean)getLfStatusList().get(index)).booleanValue();
		else
			throw new InvalidParameterException("DistNetData.getLfStatus(), index: " + index);
	}

	public void setScStd(String s) { this.scStd = s; }
    public String getScStd() { return this.scStd; }

    public List getScPointList() { return this.scPointList; }
	public void setScPointList(List list) { this.scPointList = list; }

	/**
	 * @return Returns the ifStatusList.
	 */
	public List getLfStatusList() {
		return lfStatusList;
	}
	public void setLfStatusList(List list) {
		lfStatusList = list;
	}
	
	/**
	 * @return Returns the loadSchedulePeriodLength.
	 */
	public double getLoadSchedulePeriodLength() {
		return loadSchedulePeriodLength;
	}

	/**
	 * @param loadSchedulePeriodLength The loadSchedulePeriodLength to set.
	 */
	public void setLoadSchedulePeriodLength(double loadSchedulePeriodLength) {
		this.loadSchedulePeriodLength = loadSchedulePeriodLength;
	}

	/**
	 * @return Returns the loadSchedulePeriodUnit.
	 */
	public String getLoadSchedulePeriodUnit() {
		return loadSchedulePeriodUnit;
	}

	/**
	 * @param loadSchedulePeriodUnit The loadSchedulePeriodUnit to set.
	 */
	public void setLoadSchedulePeriodUnit(String loadSchedulePeriodUnit) {
		this.loadSchedulePeriodUnit = loadSchedulePeriodUnit;
	}

	/**
	 * @return Returns the loadSchedulePoints.
	 */
	public int getLoadSchedulePoints() {
		return loadSchedulePoints;
	}

	/**
	 * @param loadSchedulePoints The loadSchedulePoints to set.
	 */
	public void setLoadSchedulePoints(int loadSchedulePoints) {
		this.loadSchedulePoints = loadSchedulePoints;
	}

	/**
	 * @return Returns the scPoints.
	 */
	public int getScPoints() {
		return scPoints;
	}

	/**
	 * @param scPoints The scPoints to set.
	 */
	public void setScPoints(int scPoints) {
		this.scPoints = scPoints;
	}

	/**
	 * @return Returns the totalLossKwHr.
	 */
	public double getTotalLossKwHr() {
		return totalLossKwHr;
	}

	/**
	 * @param totalLossKwHr The totalLossKwHr to set.
	 */
	public void setTotalLossKwHr(double totalLossKwHr) {
		this.totalLossKwHr = totalLossKwHr;
	}
}