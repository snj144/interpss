 /*
  * @(#)UCTEBus.java   
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
  * @Date 02/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.custom.exchange.ucte;

import com.interpss.core.aclf.impl.AclfBusImpl;

public class UCTEBus extends AclfBusImpl {
	private int ucteStatus;
	private double 	minGenMW, maxGenMW, 
			staticPrimaryControl, normalPoewrPrimaryControl,
			scMVA3P, x_rRatio;
	private String isoId, powerPlanType;
	
	public UCTEBus(String id, String name, String isoId) {
		super();
		setId(id);
      	setName(name);
      	setIsoId(isoId);
	}
	
	public int getUcteStatus() {
		return this.ucteStatus;
	}
	public void setUcteStatus(int status) {
		this.ucteStatus = status;
	}
	public double getMinGenMW() {
		return this.minGenMW;
	}
	public void setMinGenMW(double minGenMW) {
		this.minGenMW = minGenMW;
	}
	public double getMaxGenMW() {
		return this.maxGenMW;
	}
	public void setMaxGenMW(double maxGenMW) {
		this.maxGenMW = maxGenMW;
	}
	public double getStaticPrimaryControl() {
		return this.staticPrimaryControl;
	}
	public void setStaticPrimaryControl(double staticPrimaryControl) {
		this.staticPrimaryControl = staticPrimaryControl;
	}
	public double getNormalPoewrPrimaryControl() {
		return this.normalPoewrPrimaryControl;
	}
	public void setNormalPoewrPrimaryControl(double normalPoewrPrimaryControl) {
		this.normalPoewrPrimaryControl = normalPoewrPrimaryControl;
	}
	public double getScMVA3P() {
		return this.scMVA3P;
	}
	public void setScMVA3P(double scMVA3P) {
		this.scMVA3P = scMVA3P;
	}
	public double getX_rRatio() {
		return this.x_rRatio;
	}
	public void setX_rRatio(double ratio) {
		this.x_rRatio = ratio;
	}

	public String getPowerPlanType() {
		return this.powerPlanType;
	}

	public void setPowerPlanType(String powerPlanType) {
		this.powerPlanType = powerPlanType;
	}

	public String getIsoId() {
		return this.isoId;
	}

	public void setIsoId(String isoId) {
		this.isoId = isoId;
	}	
}
