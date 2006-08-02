package com.interpss.editor.refData;

import java.util.ArrayList;
import java.util.List;

public class LoadSchedule {
	private int id;
	private String name;
	private int points;
	private String period_unit;
	private List itemList;
	
	public LoadSchedule() {
		itemList = new ArrayList();
	}
	
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the points.
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * @param points The points to set.
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	/**
	 * @return Returns the itemList.
	 */
	public List getItemList() {
		return itemList;
	}
	/**
	 * @param itemList The itemList to set.
	 */
	public void setItemList(List itemList) {
		this.itemList = itemList;
	}

	/**
	 * @return Returns the period_unit.
	 */
	public String getPeriod_unit() {
		return period_unit;
	}

	/**
	 * @param period_unit The period_unit to set.
	 */
	public void setPeriod_unit(String period_unit) {
		this.period_unit = period_unit;
	}

	/**
	 * @return Returns the id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}
}
