 /*
  * @(#)LoadSchedule.java   
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

package org.interpss.editor.refData;

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
