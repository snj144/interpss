package org.ieee.odm.model.aclf;

import java.util.List;

import org.ieee.odm.common.NumericUtil;
import org.ieee.odm.model.IODMModelParser;
import org.ieee.odm.model.base.BaseJaxbHelper;
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.LFGenCodeEnumType;
import org.ieee.odm.schema.LFLoadCodeEnumType;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.PSXfrBranchXmlType;
import org.ieee.odm.schema.XfrBranchXmlType;

public class AclfModelComparator {
	/**
	 * compare bus objects: b1 and b2. The error is store in the msgList
	 * 
	 * @param base
	 * @param bus
	 * @param msgList
	 */
	public static void compare(LoadflowBusXmlType base, LoadflowBusXmlType bus, List<String> msgList, 
			                   String baseStr, String format) {
		String id = base.getId() + ", " + base.getName().trim();
		
		if (base.getBaseVoltage().getValue() != bus.getBaseVoltage().getValue())
			msgList.add("\nBus base voltage not equal: " + id + ", " + base.getBaseVoltage().getValue() + baseStr);
/*
                <genData>
                    <equivGen code="PV">
                        <power unit="MVA" im="0.0" re="3570.0"/>
                        <desiredVoltage unit="PU" value="1.049"/>
                        <qLimit unit="MVAR" active="false" min="0.0" max="880.8"/>
                    </equivGen>
                </genData>
*/
		if (base.getGenData() != null && bus.getGenData() != null) {
			if (base.getGenData().getEquivGen().getCode() != bus.getGenData().getEquivGen().getCode())
				msgList.add("\nBus EquivGen code not equal: " + id + ", " + 
						base.getGenData().getEquivGen().getCode() + baseStr + 
						"  " + bus.getGenData().getEquivGen().getCode() + format);
			if (base.getGenData().getEquivGen().getCode() == LFGenCodeEnumType.PV) {
				if (!NumericUtil.equals(base.getGenData().getEquivGen().getPower().getRe(), bus.getGenData().getEquivGen().getPower().getRe()))
					msgList.add("\nBus EquivGen power not equal: " + id + " " + base.getGenData().getEquivGen().getCode() 
							+ "   " + BaseJaxbHelper.toStr(base.getGenData().getEquivGen().getPower()) + baseStr
							+ "   " + BaseJaxbHelper.toStr(bus.getGenData().getEquivGen().getPower()) + format);
				if (!NumericUtil.equals(base.getGenData().getEquivGen().getDesiredVoltage(), 
						                bus.getGenData().getEquivGen().getDesiredVoltage()))
					msgList.add("\nBus EquivGen desiredVoltage not equal: " + id + " " + base.getGenData().getEquivGen().getCode() 
							+ "   " + BaseJaxbHelper.toStr(base.getGenData().getEquivGen().getDesiredVoltage()) + baseStr
							+ "   " + BaseJaxbHelper.toStr(bus.getGenData().getEquivGen().getDesiredVoltage()) + format);
			}
			else if (base.getGenData().getEquivGen().getCode() == LFGenCodeEnumType.PQ) {
				if (!NumericUtil.equals(base.getGenData().getEquivGen().getPower(), bus.getGenData().getEquivGen().getPower()))
					msgList.add("\nBus EquivGen power not equal: " + id + " " + base.getGenData().getEquivGen().getCode()
							+ "   " + BaseJaxbHelper.toStr(base.getGenData().getEquivGen().getPower()) + baseStr
							+ "   " + BaseJaxbHelper.toStr(bus.getGenData().getEquivGen().getPower()) + format);
			}
			else if (base.getGenData().getEquivGen().getCode() == LFGenCodeEnumType.SWING) {
				if (!NumericUtil.equals(base.getGenData().getEquivGen().getDesiredVoltage(), 
		                bus.getGenData().getEquivGen().getDesiredVoltage()))
					msgList.add("\nBus EquivGen desiredVoltage not equal: " + id + " " + base.getGenData().getEquivGen().getCode()
							+ "   " + BaseJaxbHelper.toStr(base.getGenData().getEquivGen().getDesiredVoltage()) + baseStr
							+ "   " + BaseJaxbHelper.toStr(bus.getGenData().getEquivGen().getDesiredVoltage()) + format);
			}
		}
		else if (base.getGenData() == null && bus.getGenData() != null 
						&& bus.getGenData().getEquivGen().getCode() != LFGenCodeEnumType.NONE_GEN ||
				 base.getGenData() != null && bus.getGenData() == null 
				 		&& base.getGenData().getEquivGen().getCode() != LFGenCodeEnumType.NONE_GEN) {
			msgList.add("\nBus EquivGen model not equal: " + id + ", " + 
					base.getGenData().getEquivGen().getCode() + baseStr + 
					"  " + bus.getGenData().getEquivGen().getCode() + format);
		}	
			
/*
                <loadData>
                    <equivLoad code="CONST_P">
                        <constPLoad unit="MVA" im="442.6" re="700.0"/>
                    </equivLoad>
                </loadData>
*/
		if (base.getLoadData() != null && bus.getLoadData() != null) {
			if (base.getLoadData().getEquivLoad().getCode() != bus.getLoadData().getEquivLoad().getCode())
				msgList.add("\nBus EquivLoad code not equal: " + id + ", " + 
						base.getLoadData().getEquivLoad().getCode() + baseStr + 
						"  " + bus.getLoadData().getEquivLoad().getCode() + format);
			if (!NumericUtil.equals(base.getLoadData().getEquivLoad().getConstPLoad(), bus.getLoadData().getEquivLoad().getConstPLoad()))
					msgList.add("\nBus EquivLoad constP not equal: " + id 
							+ "   " + BaseJaxbHelper.toStr(base.getLoadData().getEquivLoad().getConstPLoad()) + baseStr
							+ "   " + BaseJaxbHelper.toStr(bus.getLoadData().getEquivLoad().getConstPLoad()) + format);
		}
		else if (base.getLoadData() == null && bus.getLoadData() != null 
						&& bus.getLoadData().getEquivLoad().getCode() != LFLoadCodeEnumType.NONE_LOAD ||
				 base.getLoadData() != null && bus.getLoadData() == null 
				 		&& base.getLoadData().getEquivLoad().getCode() != LFLoadCodeEnumType.NONE_LOAD) {
			msgList.add("\nBus EquivLoad model not equal: " + id + ", " + 
					base.getLoadData().getEquivLoad().getCode() + baseStr + 
					"  " + bus.getLoadData().getEquivLoad().getCode() + format);
		}
		
/*
                <shuntY unit="PU" im="-1.4" re="5.3"/>
*/
		if (base.getShuntY() != null && bus.getShuntY() != null) {
			if (!NumericUtil.equals(base.getShuntY(), bus.getShuntY()))
				msgList.add("\nBus ShuntY not equal: " + id 
						+ "   " + BaseJaxbHelper.toStr(base.getShuntY()) + baseStr
						+ "   " + BaseJaxbHelper.toStr(bus.getShuntY()) + format);
		}
		else if (base.getShuntY() == null && bus.getShuntY() != null ||
				 base.getShuntY() != null && bus.getShuntY() == null) {
			msgList.add("\nBus ShuntY model not equal: " + id);
		}
		
	}

	/**
	 * compare aclf line objects: b1 and b2. The error is store in the msgList
	 * 
	 * @param base
	 * @param bra
	 * @param msgList
	 */
	public static void compare(BranchXmlType base, BranchXmlType bra, IODMModelParser baseParser, List<String> msgList, 
								String baseFormat, String format) {
		BusXmlType baseFromBus = baseParser.getBus(BaseJaxbHelper.getRecId(base.getFromBus()));
		BusXmlType BASEtoBus = baseParser.getBus(BaseJaxbHelper.getRecId(base.getToBus()));
		String braId = baseFromBus.getName().trim() + "->" + BASEtoBus.getName().trim() + "_" + base.getCircuitId();
		
		//
		// 	LineBranchXmlType
		//
		if (base instanceof LineBranchXmlType ) {
			LineBranchXmlType baseLine = (LineBranchXmlType)base;
			LineBranchXmlType line = (LineBranchXmlType)bra;
/*
	           <z unit="PU" im="0.0181" re="0.0014"/>
*/
			if (!NumericUtil.equals(baseLine.getZ(), line.getZ())) {
				msgList.add("\nLine Branch Z not equal: " + braId
						+ "   " + BaseJaxbHelper.toStr(baseLine.getZ()) + baseFormat
						+ "   " + BaseJaxbHelper.toStr(line.getZ()) + format);
			}
/*
            <totalShuntY unit="PU" im="0.11444" re="0.0"/>
*/
			if (!NumericUtil.equals(baseLine.getTotalShuntY(), line.getTotalShuntY())) {
				msgList.add("\nLine Branch TotalShuntY not equal: " + braId
						+ "   " + BaseJaxbHelper.toStr(baseLine.getTotalShuntY()) + baseFormat
						+ "   " + BaseJaxbHelper.toStr(line.getTotalShuntY()) + format);
			}
		}
		//
		// 	XfrBranchXmlType
		//

		if (base instanceof XfrBranchXmlType ) {
			XfrBranchXmlType baseXfr = (XfrBranchXmlType)base;
			XfrBranchXmlType xfr = (XfrBranchXmlType)bra;

/*
         	<z unit="PU" im="0.0066" re="8.0E-5"/>
*/
			if (!NumericUtil.equals(baseXfr.getZ(), xfr.getZ())) {
				msgList.add("\nXfr Branch Z not equal: " + braId
						+ "   " + BaseJaxbHelper.toStr(baseXfr.getZ()) + baseFormat
						+ "   " + BaseJaxbHelper.toStr(xfr.getZ()) + format);
			}
			
/*			
            <fromTurnRatio unit="PU" value="1.0"/>
            <toTurnRatio unit="PU" value="0.9524"/>
*/
			if (!NumericUtil.equals(baseXfr.getFromTurnRatio().getValue(), xfr.getFromTurnRatio().getValue(), 0.0001)) {
				msgList.add("\nXfr Branch fromTurnRatio not equal: " + braId
								+ "   [" + baseXfr.getFromTurnRatio().getValue() + "," + baseXfr.getToTurnRatio().getValue() + "] " + baseFormat
								+ "   [" + + xfr.getFromTurnRatio().getValue() + "," + xfr.getToTurnRatio().getValue() + "]");
			}
			if (!NumericUtil.equals(baseXfr.getToTurnRatio().getValue(), xfr.getToTurnRatio().getValue(), 0.0001)) {
				msgList.add("\nXfr Branch toTurnRatio not equal: " + braId
						+ "   [" + baseXfr.getFromTurnRatio().getValue() + "," + baseXfr.getToTurnRatio().getValue() + "] " + baseFormat
						+ "   [" + + xfr.getFromTurnRatio().getValue() + "," + xfr.getToTurnRatio().getValue() + "]"  + format);
			}
			
/*			
            <xfrInfo>
                <fromRatedVoltage unit="KV" value="26.0"/>
                <toRatedVoltage unit="KV" value="525.0"/>
            </xfrInfo>
*/
			
			if (base instanceof PSXfrBranchXmlType ) {
				
			}
		}
	}
}
