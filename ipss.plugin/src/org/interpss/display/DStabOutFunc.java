package org.interpss.display;

import java.util.Hashtable;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.Number2String;
import com.interpss.core.aclf.CapacitorBusAdapter;
import com.interpss.core.aclf.GenBusAdapter;
import com.interpss.core.net.Bus;
import com.interpss.core.util.outfunc.AclfOut;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.mach.MachineType;
import com.interpss.dstab.util.DStabOutSymbol;

public class DStabOutFunc {
	public static String getStateTitleStr() {
		String str = 
			"Time      MachId       Angle        Speed          Pe           Pm        Voltage        E/Eq1        Efd        Vs(pss)\n" +
		    "-----   ----------   ----------   ----------   ----------   ----------   ----------   ----------   ----------   ----------";
		return str;
	}

	@SuppressWarnings("unchecked")
	public static String getStateStr(Hashtable<String, Object> table) throws Exception {
		boolean strFmt = true;
		if (table.get(DStabOutSymbol.OUT_SYMBOL_TIME) instanceof Double) 
			strFmt = false;
		
		String str = "";
		double time = strFmt? new Double((String)table.get(DStabOutSymbol.OUT_SYMBOL_TIME)).doubleValue() : ((Double)table.get(DStabOutSymbol.OUT_SYMBOL_TIME)).doubleValue();
		str += Number2String.toStr("00.000", time) + " ";
		
		str += Number2String.toStr(10, (String)table.get(DStabOutSymbol.OUT_SYMBOL_MACH_ID)) + "   ";

		double angle = strFmt? new Double((String)table.get(DStabOutSymbol.OUT_SYMBOL_MACH_ANG)).doubleValue() : ((Double)table.get(DStabOutSymbol.OUT_SYMBOL_MACH_ANG)).doubleValue();
		str += Number2String.toStr(10, Number2String.toStr("0.00", angle)) + "   ";

		double speed = strFmt? new Double((String)table.get(DStabOutSymbol.OUT_SYMBOL_MACH_SPEED)).doubleValue() : ((Double)table.get(DStabOutSymbol.OUT_SYMBOL_MACH_SPEED)).doubleValue();
		str += Number2String.toStr(10, Number2String.toStr("0.0000", speed)) + "   ";
		
		double pe = strFmt? new Double((String)table.get(DStabOutSymbol.OUT_SYMBOL_MACH_PE)).doubleValue() : ((Double)table.get(DStabOutSymbol.OUT_SYMBOL_MACH_PE)).doubleValue();
		str += Number2String.toStr(10, Number2String.toStr("0.0000", pe)) + "   ";
		
		double pm = strFmt? new Double((String)table.get(DStabOutSymbol.OUT_SYMBOL_MACH_PM)).doubleValue() : ((Double)table.get(DStabOutSymbol.OUT_SYMBOL_MACH_PM)).doubleValue();
		str += Number2String.toStr(10, Number2String.toStr("0.0000", pm)) + "   ";
		
		double volt = strFmt? new Double((String)table.get(DStabOutSymbol.OUT_SYMBOL_BUS_VMAG)).doubleValue() : ((Double)table.get(DStabOutSymbol.OUT_SYMBOL_BUS_VMAG)).doubleValue();
		str += Number2String.toStr(10, Number2String.toStr("0.0000", volt)) + "   ";
		
		if (table.get(DStabOutSymbol.OUT_SYMBOL_MACH_E) != null) {
			double e = strFmt? new Double((String)table.get(DStabOutSymbol.OUT_SYMBOL_MACH_E)).doubleValue() : ((Double)table.get(DStabOutSymbol.OUT_SYMBOL_MACH_E)).doubleValue();
			str += Number2String.toStr(10, Number2String.toStr("0.0000", e)) + "   ";
		}	
		else if (table.get(DStabOutSymbol.OUT_SYMBOL_MACH_EQ1) != null) {
			double eq1 = strFmt? new Double((String)table.get(DStabOutSymbol.OUT_SYMBOL_MACH_EQ1)).doubleValue() : ((Double)table.get(DStabOutSymbol.OUT_SYMBOL_MACH_EQ1)).doubleValue();
			str += Number2String.toStr(10, Number2String.toStr("0.0000", eq1)) + "   ";
		}
		else 
			str += "     -       ";

		if (table.get(Constants.ExciterStateToken) != null) {
			Hashtable<String, Object> excStatess = 	(Hashtable<String, Object>)table.get(Constants.ExciterStateToken);
			double efd = strFmt? new Double((String)excStatess.get(DStabOutSymbol.OUT_SYMBOL_EXC_EFD)).doubleValue() : 
				                 ((Double)excStatess.get(DStabOutSymbol.OUT_SYMBOL_EXC_EFD)).doubleValue();
			str += Number2String.toStr(10, Number2String.toStr("0.0000", efd)) + "   ";
		}	
		else 
			str += "     -       ";

		if (table.get(Constants.StabilizerStateToken) != null) {
			Hashtable<String, Object> pssStatess = 	(Hashtable<String, Object>)table.get(Constants.StabilizerStateToken);
			double pssVs = strFmt? new Double((String)pssStatess.get(DStabOutSymbol.OUT_SYMBOL_PSS_VS)).doubleValue() : 
				                  ((Double)pssStatess.get(DStabOutSymbol.OUT_SYMBOL_PSS_VS)).doubleValue();
			str += Number2String.toStr(10, Number2String.toStr("0.0000", pssVs)) + "   ";
		}	
		else 
			str += "     -       ";

		str += "\n";
		return str;
	}
	
	public static String initConditionSummary(DynamicSimuAlgorithm algo ) {
		DStabilityNetwork net = algo.getDStabNet();
		StringBuffer str = new StringBuffer("");
	  	try {
		  	double baseKVA = net.getBaseKva();

		  	double refAng = 0.0;
		  	Machine refMach = algo.getRefMachine();
		  	if (refMach != null)
		  		refAng = refMach.getAngle() * Constants.RtoD;
		  	
			str.append( "\n                          Initial Condition Summary\n" );
			str.append( AclfOut.maxMismatchToString(net) + "\n");
			str.append( "     BusID     Volt(pu)     Angle(deg)   P(pu)     Q(pu)   Mach Model     PowerAng(deg)\n" );
			str.append( "  -------------------------------------------------------------------------------------\n" );

			for( Bus b : net.getBusList()) {
				DStabBus bus = (DStabBus)b;
				GenBusAdapter genBus = (GenBusAdapter)bus.adapt(GenBusAdapter.class);
				Complex busPQ = genBus.getGenResults(UnitType.PU, baseKVA);
				busPQ = busPQ.subtract(genBus.getLoadResults(UnitType.PU, baseKVA));
				if ( bus.isCapacitor() ) {
					CapacitorBusAdapter cap = (CapacitorBusAdapter)bus.adapt(CapacitorBusAdapter.class);
					busPQ = busPQ.add(new Complex(0.0, cap.getQResults(bus.getVoltageMag(), UnitType.PU, baseKVA)));				
				}
				str.append( Number2String.toStr(2, " ") );
				str.append( Number2String.toStr(-12, bus.getId() ) + "  ");
				str.append( Number2String.toStr("###0.000",bus.getVoltageMag(UnitType.PU)) + " ");
				str.append( Number2String.toStr("######0.0", (bus.getVoltageAng(UnitType.Deg))-refAng) + "  ");
				str.append( Number2String.toStr("####0.0000",busPQ.getReal()));
				str.append( Number2String.toStr("####0.0000",busPQ.getImaginary()) + "  ");
				if (bus.getMachine() != null) {
					Machine mach = bus.getMachine();
					str.append(machModelStr(mach) + "   ");
					str.append( Number2String.toStr("####0.0", mach.getAngle()*Constants.RtoD-refAng));
				}
				else if (bus.getScriptDynamicBusDevice() != null) {
					//Machine mach = bus.getMachine();
					str.append("Dyn Bus Device   " + " ");
				}
				/*
				else if (bus.getScriptDBusDevice() != null) {
					//Machine mach = bus.getMachine();
					str.append("Script Bus Device" + " ");
				}
				*/
				str.append("\n");
			}
	  	} catch (Exception emsg) {
	  		str.append(emsg.toString());
	  	}
		return str.toString();
	}
	
	private static String machModelStr(Machine mach) {
		if (mach.getMachType() == MachineType.ECONSTANT)
			return "     E-Constant";
		else if (mach.getMachType() == MachineType.EQ1_MODEL)
			return "      Eq1 Model";
		else if (mach.getMachType() == MachineType.EQ1_ED1_MODEL)
			return "  Eq1 Ed1 Model";
		else if (mach.getMachType() == MachineType.EQ11_ED11_SALIENT_POLE)
			return "E11 SalinetPole";
		else if (mach.getMachType() == MachineType.EQ11_ED11_ROUND_ROTOR)
			return " E11 RoundRotor";
		return "    Not Defined";
	}
}
