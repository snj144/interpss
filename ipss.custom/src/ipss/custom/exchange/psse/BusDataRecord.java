package ipss.custom.exchange.psse;

import ipss.custom.psse.aclf.PSSEGen;
import ipss.custom.psse.aclf.PSSELoad;

import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.XmlUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.datatype.FuncLoad;

public class BusDataRecord {
	/** 
	 * Process bus record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static void processBus(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msg) throws Exception {
/*
		Format: I, ’NAME’, BASKV, IDE, GL, BL, AREA, ZONE, VM, VA, OWNER
*/
  		StringTokenizer st = new StringTokenizer(lineStr,",");
    	int I = new Integer(st.nextToken().trim()).intValue();
    	String NAME = PSSEUtilFunc.trimQuote(st.nextToken());
		double BASKV = new Double(st.nextToken().trim()).doubleValue();
		int IDE = new Integer(st.nextToken().trim()).intValue();
		double GL = new Double(st.nextToken().trim()).doubleValue();
		double BL = new Double(st.nextToken().trim()).doubleValue();
		int AREA = new Integer(st.nextToken().trim()).intValue();
		int ZONE = new Integer(st.nextToken().trim()).intValue();
		double VM = new Double(st.nextToken().trim()).doubleValue();
		double VA = new Double(st.nextToken().trim()).doubleValue();
		int OWNER = new Integer(st.nextToken().trim()).intValue();
		
		IpssLogger.getLogger().fine("Bus data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("Bus number, type, name:" + I + ", " + IDE + ", '" + NAME + "'");
		IpssLogger.getLogger().fine("Area, Zone:" + AREA + ", " + ZONE);
		IpssLogger.getLogger().fine("baseKV, Vm, Va:" + BASKV + ", " + VM + ", " + VA);
		IpssLogger.getLogger().fine("Pl, Ql, OWNER:" + GL + ", " + BL + ", " + OWNER);

		String iStr = new Integer(I).toString();
		final AclfBus bus = CoreObjectFactory.createAclfBus(iStr, AREA, ZONE, OWNER, adjNet);
      	bus.setName(NAME);
    	bus.setBaseVoltage(BASKV, UnitType.kV);
    	double factor = 1000.0/adjNet.getBaseKva();  // for transfer G+jB to PU on system base 
    	bus.setShuntY(new Complex(GL*factor,BL*factor));
      	
    	// add the bus object into the network container
    	adjNet.addBus(bus);

    	// set input data to the bus object
      	if ( IDE == 3 ) {
      		// Swing bus
   		 	bus.setGenCode(AclfGenCode.SWING_LITERAL);
    		bus.setLoadCode(AclfLoadCode.NON_LOAD_LITERAL);
  			final SwingBusAdapter gen = (SwingBusAdapter)bus.adapt(SwingBusAdapter.class);
  			gen.setVoltMag(VM, UnitType.PU);
  			gen.setVoltAng(VA, UnitType.Deg);
    	}
    	else if ( IDE == 2 ) {
    		// Gen bus, we first set it to a PQ bus. It will be adjusted in the 
    		// Generator data section.
    		bus.setGenCode(AclfGenCode.GEN_PV_LITERAL);
    		bus.setLoadCode(AclfLoadCode.NON_LOAD_LITERAL);
    	}
    	else if ( IDE == 1 ) {
    		// Non-gen load bus
   		 	bus.setGenCode(AclfGenCode.NON_GEN_LITERAL);
    		bus.setLoadCode(AclfLoadCode.NON_LOAD_LITERAL);
    	}
    	else {
    		// Isolated bus, an isolated bus will not participate in Loadflow calculaiton
    		bus.setGenCode(AclfGenCode.NON_GEN_LITERAL);
    		bus.setLoadCode(AclfLoadCode.NON_LOAD_LITERAL);
    		bus.setStatus(false);
    	}
	}			
	
	/** 
	 * Process load data record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static void processLoad(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msg) throws Exception {
/*
		I, ID, STATUS, AREA, ZONE, PL, QL, IP, IQ, YP, YQ, OWNER
*/		
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
		int I = new Integer(st.nextToken().trim()).intValue();
		String ID = PSSEUtilFunc.trimQuote(st.nextToken());
		int STATUS = new Integer(st.nextToken().trim()).intValue();
		int AREA = new Integer(st.nextToken().trim()).intValue();
		int ZONE = new Integer(st.nextToken().trim()).intValue();
		double PL = new Double(st.nextToken()).doubleValue();
		double QL = new Double(st.nextToken()).doubleValue();
		double IP = new Double(st.nextToken()).doubleValue();
		double IQ = new Double(st.nextToken()).doubleValue();
		double YP = new Double(st.nextToken()).doubleValue();
		double YQ = new Double(st.nextToken()).doubleValue();
		int OWNER = new Integer(st.nextToken().trim()).intValue();

		IpssLogger.getLogger().fine("Load data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("Bus number, id, status, area, zone:" + I + ", " + ID + ", " + STATUS + ", " + AREA + ", " + ZONE);
		IpssLogger.getLogger().fine("PL, QL, IP, iQ, YP, YQ, OWNER:" + PL + ", " + QL + ", " + IP + ", " + IQ + ", " + YP + ", " + YQ + ", " + OWNER);
		
		String iStr = new Integer(I).toString();
		AclfBus bus = adjNet.getAclfBus(iStr);
		if (bus == null) {
			throw new Exception ("Bus not found in the network, bus number: " + I);
		}
		
		PSSELoad load = new PSSELoad();
		load.setId(ID);
		load.setName("Load:" + ID + "(" + I + ")");
		load.setDesc("PSSE Load " + ID + " at Bus " + I);
		load.setStatus(STATUS==1);
		load.setAreaNo(ZONE);
		load.setZoneNo(ZONE);
		load.setOwnerNo(OWNER);
		
		load.setConstPLoad(new Complex(PL,QL));
		load.setConstILoad(new Complex(IP,IQ));
		load.setConstZLoad(new Complex(YP,YQ));

		bus.getRegDeviceList().add(load);
		
		IpssLogger.getLogger().fine("PSSELoad: " + XmlUtil.toXmlString(load));
	}			

	/** 
	 * Process generator record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static void processGen(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msg) throws Exception {
/*
		I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4

		The standard generator boundary condition is a specification of real power output at the
		high-voltage bus, bus k, and of voltage magnitude at some designated bus, not necessarily bus k.
*/		
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
		int I = new Integer(st.nextToken().trim()).intValue();
		String ID = PSSEUtilFunc.trimQuote(st.nextToken());
		double PG = new Double(st.nextToken().trim()).doubleValue();
		double QG = new Double(st.nextToken().trim()).doubleValue();
		double QT = new Double(st.nextToken().trim()).doubleValue();
		double QB = new Double(st.nextToken().trim()).doubleValue();
		double VS = new Double(st.nextToken().trim()).doubleValue();
		int IREG = new Integer(st.nextToken().trim()).intValue();
		double MBASE = new Double(st.nextToken().trim()).doubleValue();
		double ZR = new Double(st.nextToken().trim()).doubleValue();
		double ZX = new Double(st.nextToken().trim()).doubleValue();
		double RT = new Double(st.nextToken().trim()).doubleValue();
		double XT = new Double(st.nextToken().trim()).doubleValue();
		double GTAP = new Double(st.nextToken().trim()).doubleValue();
		int STAT = new Integer(st.nextToken().trim()).intValue();
		double RMPCT = new Double(st.nextToken().trim()).doubleValue();
		double PT = new Double(st.nextToken().trim()).doubleValue();
		double PB = new Double(st.nextToken().trim()).doubleValue();

		int    O1 = 0, O2 = 0, O3 = 0, O4 = 0;
		double F1 = 0.0, F2 = 0.0, F3 = 0.0, F4 = 0.0;

		if (st.hasMoreTokens()) {
			O1 = new Integer(st.nextToken().trim()).intValue();
			F1 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O2 = new Integer(st.nextToken().trim()).intValue();
			F2 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O3 = new Integer(st.nextToken().trim()).intValue();
			F3 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O4 = new Integer(st.nextToken().trim()).intValue();
			F4 = new Double(st.nextToken().trim()).doubleValue();
		}

		IpssLogger.getLogger().fine("Gen data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("Bus number, GenId:" + I + ", " + ID);
		IpssLogger.getLogger().fine("PG, QG, Qmax, Qmin, Vspec:" + PG + ", " + QG + ", " + QT + ", " + QB + ", " + VS);
		IpssLogger.getLogger().fine("Ireg, MvaBase, Zr, Zx, Rt, Xt:" + IREG + ", " + MBASE + ", " + ZR + ", " + ZX + ", " + RT + ", " + XT);
		IpssLogger.getLogger().fine("Gtap, RegMar%, Pmax, Pmin:" + GTAP + ", " + STAT + ", " + RMPCT + ", " + PT + ", " + PB);
		IpssLogger.getLogger().fine("O1, F1, O2, F2, O3, F3, O4, F4:" + O1 + ", " + F1 + ", " + O2 + ", " + F2  + ", " + O3 + ", " + F3 + ", " + O4 + ", " + F4);
		
		String iStr = new Integer(I).toString();
		AclfBus bus = adjNet.getAclfBus(iStr);
		if (bus == null) {
			throw new Exception ("Bus not found in the network, bus number: " + I);
		}
		PSSEGen gen = new PSSEGen();
		gen.setId(ID);
		gen.setName("Gen:" + ID + "(" + I + ")");
		gen.setDesc("PSSE Generator " + ID + " at Bus " + I);
		gen.setStatus(STAT==1);

		gen.setPGen(UnitType.pConversion(PG, adjNet.getBaseKva(), UnitType.mW, UnitType.PU));
		gen.setQGen(UnitType.pConversion(QG, adjNet.getBaseKva(), UnitType.mVar, UnitType.PU));
		gen.setVSpec(VS);
		
		gen.setPLimit(new LimitType(UnitType.pConversion(PT, adjNet.getBaseKva(), UnitType.mW, UnitType.PU),
				                    UnitType.pConversion(PB, adjNet.getBaseKva(), UnitType.mW, UnitType.PU)));
		gen.setQLimit(new LimitType(UnitType.pConversion(QT, adjNet.getBaseKva(), UnitType.mVar, UnitType.PU),
                                    UnitType.pConversion(QB, adjNet.getBaseKva(), UnitType.mVar, UnitType.PU)));
		
		gen.setVControlBusId(new Integer(IREG).toString());
		
		gen.setMvaBase(MBASE);
		gen.setZGen(new Complex(ZR,ZX));
		gen.setZXfr(new Complex(RT,XT));
		gen.setXfrTap(GTAP);
		gen.setContribFactor(RMPCT*0.01);

		gen.getOwnerRec(0).setOwnerNumber(O1);
		gen.getOwnerRec(0).setOwnershipFactor(F1);
		gen.getOwnerRec(1).setOwnerNumber(O2);
		gen.getOwnerRec(1).setOwnershipFactor(F2);
		gen.getOwnerRec(2).setOwnerNumber(O3);
		gen.getOwnerRec(2).setOwnershipFactor(F3);
		gen.getOwnerRec(3).setOwnerNumber(O4);
		gen.getOwnerRec(3).setOwnershipFactor(F4);
		
		bus.getRegDeviceList().add(gen);
		
		IpssLogger.getLogger().fine("PSSEGen: " + XmlUtil.toXmlString(gen));	
	}			
}