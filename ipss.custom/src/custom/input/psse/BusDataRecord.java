package custom.input.psse;

import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;

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

		final AclfBus bus = CoreObjectFactory.createAclfBus(new Integer(I).toString(), AREA, ZONE, adjNet);
      	bus.setName(NAME);
      	bus.setOwner(OWNER);
    	bus.setBaseVoltage(BASKV, UnitType.kV);
    	double factor = 1000.0/adjNet.getBaseKva();  // for transfer G+jB PU on system base 
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
    		bus.setGenCode(AclfGenCode.GEN_PQ_LITERAL);
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

		IpssLogger.getLogger().info("Gen data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().info("Bus number, id, status, area, zone:" + I + ", " + ID + ", " + STATUS + ", " + AREA + ", " + ZONE);
		IpssLogger.getLogger().info("PL, QL, IP, iQ, YP, YQ, OWNER:" + PL + ", " + QL + ", " + IP + ", " + IQ + ", " + YP + ", " + YQ + ", " + OWNER);
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

		IpssLogger.getLogger().info("Gen data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().info("Bus number, GenId:" + I + ", " + ID);
		IpssLogger.getLogger().info("PG, QG, Qmax, Qmin, Vspec:" + PG + ", " + QG + ", " + QT + ", " + QB + ", " + VS);
		IpssLogger.getLogger().info("Ireg, MvaBase, Zr, Zx, Rt, Xt:" + IREG + ", " + MBASE + ", " + ZR + ", " + ZX + ", " + RT + ", " + XT);
		IpssLogger.getLogger().info("Gtap, RegMar%, Pmax, Pmin:" + GTAP + ", " + STAT + ", " + RMPCT + ", " + PT + ", " + PB);
		IpssLogger.getLogger().info("O1, F1, O2, F2, O3, F3, O4, F4:" + O1 + ", " + F1 + ", " + O2 + ", " + F2  + ", " + O3 + ", " + F3 + ", " + O4 + ", " + F4);
	}			
}