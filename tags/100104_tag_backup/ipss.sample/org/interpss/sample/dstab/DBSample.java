 /*
  * @(#)DBSample.java   
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

package org.interpss.sample.dstab;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.interpss.common.SpringAppContext;
import com.interpss.common.io.IProjectDataManager;
import com.interpss.common.io.ISimuRecManager;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.StringUtil;
import com.interpss.dstab.util.DStabOutSymbol;
import com.interpss.dstab.util.DStabSimuDBRecord;

public class DBSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int caseId = 3;
		String recType = ISimuRecManager.REC_TYPE_DStabExcStates;
		String elemId = "Mach0001_EXC";
		ISimuRecManager simuRecManager = SpringAppContext.getSimuRecManager();
		List elemRecList = new ArrayList();
		try {
			elemRecList = simuRecManager.getSimuRecList(caseId, recType, elemId, IProjectDataManager.CaseType_DStabSimuRec);
		} catch (Exception e) {
			IpssLogger.logErr(e);
		}
		System.out.println("# of Elements: " + elemRecList.size());
		
		if (elemRecList.size() > 0) {
			DStabSimuDBRecord elemRec = (DStabSimuDBRecord)elemRecList.get(0);
			Hashtable elemStates = StringUtil.parseStr2Hashtable(elemRec.getSimuRec());
			elemStates.remove(DStabOutSymbol.OUT_SYMBOL_TIME);
			if (recType.equals(ISimuRecManager.REC_TYPE_DStabMachineStates))
				elemStates.remove(DStabOutSymbol.OUT_SYMBOL_MACH_ID);
			else if (recType.equals(ISimuRecManager.REC_TYPE_DStabBusStates))
				elemStates.remove(DStabOutSymbol.OUT_SYMBOL_BUS_ID);
			System.out.println(elemStates.toString());
		}
	}

}
