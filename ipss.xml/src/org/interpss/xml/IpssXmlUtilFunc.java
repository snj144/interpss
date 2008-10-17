package org.interpss.xml;

import org.interpss.schema.BaseRecordXmlType;
import org.interpss.schema.BranchRecXmlType;
import org.interpss.schema.BusRecXmlType;
import org.interpss.schema.InterPSSDocument;
import org.interpss.schema.UnitDataType;
import org.interpss.schema.DclfSensitivityXmlType.WithdrawBusList.WithdrawBus;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.NetUtilFunc;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.core.net.Network;

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

	/**
	 * Get the busRec in the net object
	 * 
	 * @param busRec
	 * @param net
	 * @return
	 */
	public static Bus getBus(BusRecXmlType busRec, Network net) {
		String busId = busRec.getBusId();
		Bus bus = net.getBus(busId);
		if (bus == null) {
			IpssLogger.getLogger().warning("Bus not found, busId: " + busId);
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog(
					"Error in Xml", "Bus not found, busId: " + busId);
		}
		return bus;
	}

	/**
	 * Get the braRec from the net object
	 * 
	 * @param braRec
	 * @param net
	 * @return
	 */
	public static Branch getBranch(BranchRecXmlType braRec, Network net) {
		String fromId = braRec.getFromBusId();
		String toId = braRec.getToBusId();
		String cirNo = braRec.getCircuitNumber();
		Branch branch = null;
		if (cirNo != null)
			branch = net.getBranch(fromId, toId, cirNo);
		else
			branch = net.getBranch(fromId, toId);

		if (branch == null && net.isSwitchBreakModel()) {
			// if switch/branch model, the bus id might be dummy bus id
			branch = net.getSwitchBreakBranch(fromId, null);
			if (branch == null)
				branch = net.getSwitchBreakBranch(toId, null);
			
			// check if branch cir no is correct
			if (branch != null && cirNo != null) {
				if (!cirNo.equals(branch.getCircuitNumber())) {
					branch = null;
					IpssLogger.getLogger().warning(
							"Branch with dummy bus found, but cir no mismatch, fromId, toId, cirNo: " 
							+ fromId + ", "	+ toId + ", " + cirNo);
				}
			}
		}
		
		if (branch == null) {
			IpssLogger.getLogger().warning(
					"Branch not found, fromId, toId, cirNo: " + fromId + ", "
							+ toId + ", " + cirNo);
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog(
					"Error in Xml",
					"Branch not found, fromId, toId, cirNo: " + fromId + ", "
							+ toId + ", " + cirNo);
		}
		return branch;
	}	
	
	/**
	 * Get record name list from the record list 
	 * 
	 * @param list
	 * @return
	 */
	public static String[] getRecNameArray(BaseRecordXmlType[] list) {
		String[] sAry = new String[list.length];
		int cnt = 0;
		for (BaseRecordXmlType scase : list) {
			sAry[cnt++] = scase.getRecName();
		}
		return sAry;
	}	
	
	/**
	 * Get recod by name from the record list
	 * 
	 * @param recName
	 * @param list
	 * @return
	 */
	public static BaseRecordXmlType getRecord(String recName, BaseRecordXmlType[] list) {
		for (BaseRecordXmlType scase : list) {
			if (scase.getRecName().equals(recName))
				return scase;
		}
		IpssLogger.getLogger().severe("Programming error, StudyCase cannot be found, recId: " + recName);
		return null;
	}

	/**
	 * map Xml unit type to InterPSS UnitType
	 * 
	 * @param type
	 * @return
	 */
	public static byte mapXmlUnitType2IpssUnitType(UnitDataType.Enum type) {
		if (type == UnitDataType.PU)
			return UnitType.PU;
		else if (type == UnitDataType.PERCENT)
			return UnitType.Percent;

		else if (type == UnitDataType.DEG)
			return UnitType.Deg;
		else if (type == UnitDataType.RAD)
			return UnitType.Rad;

		else if (type == UnitDataType.VOLT)
			return UnitType.Volt;
		else if (type == UnitDataType.K_V)
			return UnitType.kV;

		else if (type == UnitDataType.AMP)
			return UnitType.Amp;
		else if (type == UnitDataType.K_AMP)
			return UnitType.kAmp;
		else if (type == UnitDataType.MILLI_AMP)
			return UnitType.MilliAmp;

		else if (type == UnitDataType.WATT)
			return UnitType.Watt;
		else if (type == UnitDataType.KW)
			return UnitType.kW;
		else if (type == UnitDataType.M_W)
			return UnitType.mW;

		else if (type == UnitDataType.VAR)
			return UnitType.Var;
		else if (type == UnitDataType.K_VAR)
			return UnitType.kVar;
		else if (type == UnitDataType.M_VAR)
			return UnitType.mVar;

		else if (type == UnitDataType.VA)
			return UnitType.VA;
		else if (type == UnitDataType.KVA)
			return UnitType.kVA;
		else if (type == UnitDataType.M_VA)
			return UnitType.mVA;

		return UnitType.NotDefined;
	}
	
	/**
	 * Convert the xml doc to a xml document
	 * 
	 * @param xmlDoc
	 * @return
	 */
	public static String toXmlDocString(InterPSSDocument xmlDoc) {
		return xmlDoc.xmlText();
	}	
}
