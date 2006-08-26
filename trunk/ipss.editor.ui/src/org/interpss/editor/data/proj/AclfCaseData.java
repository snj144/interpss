package org.interpss.editor.data.proj;

import com.interpss.common.rec.BaseDataBean;

public class AclfCaseData extends BaseDataBean {
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
}