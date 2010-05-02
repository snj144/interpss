 /*
  * @(#)BranchHeaderRec.java   
  *
  * Copyright (C) 2006-2008 www.interpss.org
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
  * @Date 06/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.odm.adapter.ge.xbean.impl;

import java.util.StringTokenizer;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.odm.model.ModelStringUtil;
import org.ieee.odm.model.xbean.XBeanParserHelper;
import org.ieee.odm.model.xbean.XBeanODMModelParser;

public class BranchHeaderRec {
	public int f_bus, t_bus, sec;
	public String f_name, t_name, ck, long_id;
	public double f_bkv, t_bkv;

	/*
       <f bus> <"f name"> <f bkv> <t bus> <"t name"> <t bkv> <"ck"> <sec> <"long id">
	 */
	public void setBranchHeaderData(String headerStr) {
		StringTokenizer st = new StringTokenizer(headerStr, "\"");
		// 1 "P-1     " 380.00       2 "P-2     " 380.00 "1 "  1 "        "
		this.f_bus = new Integer(st.nextToken().trim()).intValue();
		this.f_name = st.nextToken();
		
		String s = st.nextToken();
		StringTokenizer st1 = new StringTokenizer(s);
		this.f_bkv = new Double(st1.nextToken()).doubleValue();
		this.t_bus = new Integer(st1.nextToken().trim()).intValue();
		
		this.t_name = st.nextToken();
		this.t_bkv = new Double(st.nextToken()).doubleValue();
		this.ck = st.nextToken();
		if (st.hasMoreElements()) {
			String s1 = st.nextToken().trim();
			if (!s1.equals(""))
				this.sec = new Integer(s1).intValue();
		}
		if (st.hasMoreElements()) {
			this.long_id = st.nextToken();
		}
	}
	
	public BranchRecordXmlType createBranch(final PSSNetworkXmlType baseCaseNet) {
		final String fid = XBeanODMModelParser.BusIdPreFix + f_bus;
		final String tid = XBeanODMModelParser.BusIdPreFix + t_bus;
		BranchRecordXmlType branchRec = XBeanParserHelper.findBranchRecord(fid, tid, ck, baseCaseNet);
		if (branchRec == null) {
			branchRec = baseCaseNet.getBranchList().addNewBranch();	

			branchRec.addNewFromBus().setIdRef(fid);
			branchRec.addNewToBus().setIdRef(tid);
			branchRec.setCircuitId(ck.replace(' ', '_'));
			branchRec.setId(ModelStringUtil.formBranchId(fid, tid, ck));
			branchRec.setName(f_name + "-" + t_name + "_" + ck);
		}
		return branchRec;
	}
}
