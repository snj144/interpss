package com.interpss.QA.rfile;

import java.util.ArrayList;
import java.util.List;

import com.interpss.core.aclf.AclfNetwork;


public abstract class Base_FileProcessor implements IFileProcessor {
	protected AclfNetwork net = null;
	protected boolean baseKvaProcessed = false,
	                busDataBegin = false;
	protected int totalBus = 0, busDataLineNo = 0;
	
	protected int busNo;
	protected String busId;
	protected double baseMva, busVoltage, busAngle, busP, busQ, shuntQ;
	
	protected List<String> errMsgList = new ArrayList<String>();
	
	public int getTotalBus() {
		return this.totalBus;
	}	
	
	public List<String> getErrMsgList() {
		return this.errMsgList;
	}
	
	protected void addErrMsg(String msg, String lineStr) {
		this.errMsgList.add("\n" + msg + "\n                                         ->" + lineStr);
		
	}
}
