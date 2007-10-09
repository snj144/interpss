 /*
  * @(#)AclfCaseData.java   
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

import com.interpss.common.rec.BaseDataBean;

public class AclfCaseData extends BaseDataBean {
	private static final long serialVersionUID = 1;

	public static final String Method_NR = "NR";
	public static final String Method_PQ = "PQ";
	public static final String Method_GS = "GS";
	
	/* aclf loadflow method */	
	private String method = Method_PQ;    // NR, PQ, GS
	public String getMethod() {return this.method;}
	public void setMethod(String s) {this.method = s;}
	
	/* if true, init all bus voltage to 1.0 before calculation */	
	private boolean initBusVolt = true;    
	public boolean getInitBusVolt() {return this.initBusVolt;}
	public void setInitBusVolt(boolean b) {this.initBusVolt = b;}
	
	/* loadflow cal tolerance */	
	private double tolerance = 0.0001d;    // pu
	public double getTolerance() {return this.tolerance;}
	public void setTolerance(double d) {this.tolerance = d;}
	
	/* loadflow cal tolerance */	
	private int maxIteration = 20;    
	public int getMaxIteration() {return this.maxIteration;}
	public void setMaxIteration(int n) {this.maxIteration = n;}

	/* GS acc factor */	
	private double accFactor = 1.0d;    
	public double getAccFactor() {return this.accFactor;}
	public void setAccFactor(double d) {this.accFactor = d;}

	/* if true, show aclf summary results */	
	private boolean showSummary = true;    
	public boolean getShowSummary() {return this.showSummary;}
	public void setShowSummary(boolean b) {this.showSummary = b;}

	/* if true, perform grid computing */	
	private boolean gridComputing = false;    
	public boolean isGridComputing() {return this.gridComputing;}
	public void setGridComputing(boolean b) {this.gridComputing = b;}

	/* grid node name */	
	private String gridNodeName = "";    
	public String getGridNodeName() {return this.gridNodeName;}
	public void setGridNodeName(String s) {this.gridNodeName = s;}

	/* if true, perform grid computing */	
	private double gridTimeout = 0.0;    
	public double getGridTimeout() {return this.gridTimeout;}
	public void setGridTimeout(double d) {this.gridTimeout = d;}
}