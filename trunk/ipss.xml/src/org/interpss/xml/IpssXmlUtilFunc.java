package org.interpss.xml;

import org.interpss.schema.BranchRecXmlType;
import org.interpss.schema.DclfSensitivityXmlType.WithdrawBusList.WithdrawBus;

import com.interpss.common.util.NetUtilFunc;

public class IpssXmlUtilFunc {
	public static void setBranchRec(BranchRecXmlType braRec, String id) {
		braRec.setFromBusId(NetUtilFunc.findFromID(id));
		braRec.setToBusId(NetUtilFunc.findToID(id));
		braRec.setCircuitNumber(NetUtilFunc.findCirNo(id));
	}
	
	public static String getBranchId(BranchRecXmlType braRec) {
		if (braRec.getCircuitNumber() != null)
			return NetUtilFunc.formBranchId(braRec.getFromBusId(), 
					braRec.getToBusId(), braRec.getCircuitNumber());
		else
			return NetUtilFunc.formBranchId(braRec.getFromBusId(), 
					braRec.getToBusId());
	}
	
	public static String[] getBranchIdAry(BranchRecXmlType[] braRecList) {
		String[] sAry = new String[braRecList.length];
		int cnt = 0;
		for (BranchRecXmlType braRec : braRecList) {
			sAry[cnt++] = getBranchId(braRec);
		}
		return sAry;
	}
	
	public static String[] getWithdrawItemList(WithdrawBus[] list) {
		String[] sAry = new String[list.length];
		int cnt = 0;
		for (WithdrawBus bus : list) {
			sAry[cnt++] = bus.getBusId() + "(" + bus.getPercent() + "%)";
		}
		return sAry;
	}

}
