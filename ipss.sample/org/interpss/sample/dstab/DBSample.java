package org.interpss.sample.dstab;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.interpss.common.SpringAppContext;
import com.interpss.common.io.IProjectDataManager;
import com.interpss.common.io.ISimuRecManager;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.StringUtil;
import com.interpss.dstab.util.DStabOutFunc;
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
			elemStates.remove(DStabOutFunc.OUT_SYMBOL_TIME);
			if (recType.equals(ISimuRecManager.REC_TYPE_DStabMachineStates))
				elemStates.remove(DStabOutFunc.OUT_SYMBOL_MACH_ID);
			else if (recType.equals(ISimuRecManager.REC_TYPE_DStabBusStates))
				elemStates.remove("BusId");
			System.out.println(elemStates.toString());
		}
	}

}
