package custom.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.io.IpssFileAdapterBase;

public class FileAdapter_PTIFormat extends IpssFileAdapterBase {

	/**
	 * Load the data in the data file, specified by the filepath, into the SimuContext object. An AclfAdjNetwork
	 * object will be created to hold the data for loadflow analysis.
	 * 
	 * @param simuCtx the SimuContext object
	 * @param filepath full path path of the input file
	 * @param msg the SessionMsg object
	 */
	@Override
	public void load(final SimuContext simuCtx, final String filepath, final IPSSMsgHub msg) throws Exception{
		final File file = new File(filepath);
		final InputStream stream = new FileInputStream(file);
		final BufferedReader din = new BufferedReader(new InputStreamReader(stream));
		
		// load the loadflow data into the AclfAdjNetwork object
		final AclfAdjNetwork adjNet = loadFile(din, msg);
  		// System.out.println(adjNet.net2String());

		// set the simuContext object
  		simuCtx.setNetType(SimuCtxType.ACLF_ADJ_NETWORK_LITERAL);
  		simuCtx.setAclfAdjNet(adjNet);
  		simuCtx.setName(filepath.substring(filepath.lastIndexOf(File.separatorChar)+1));
  		simuCtx.setDesc("This project is created by input file " + filepath);
	}
	
	/**
	 * Create a SimuContext object and Load the data in the data file, specified by the filepath, into the object. 
	 * An AclfAdjNetwork object will be created to hold the data for loadflow analysis.
	 * 
	 * @param filepath full path path of the input file
	 * @param msg the SessionMsg object
	 * @return the created SimuContext object.
	 */
	@Override
	public SimuContext load(final String filepath, final IPSSMsgHub msg) throws Exception{
  		final SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.NOT_DEFINED_LITERAL, msg);
  		load(simuCtx, filepath, msg);
  		return simuCtx;
	}
	
	/**
	 * This method is currently not implemented, since the loadflow results are not going to write
	 * back to a data file.
	 */
	@Override
	public boolean save(final String filepath, final SimuContext net, final IPSSMsgHub msg) throws Exception{
		throw new InvalidOperationException("FileAdapter_IpssInternalFormat.save not implemented");
	}
	
	/** 
	 * Build an AclfAdjNetwork object from the input file stream in PTI format
	 *
	 * @param din input file stream
	 * @param msgHub the message hub object
	 */
	public static AclfAdjNetwork loadFile(
				java.io.BufferedReader din, 
				IPSSMsgHub msgHub) throws Exception {
  		AclfAdjNetwork adjNet = CoreObjectFactory.createAclfAdjNetwork();
  		adjNet.setAllowParallelBranch(true);
  		String lineStr = null;
  		int lineNo = 0;
  		try {
      		boolean headerProcessed = false;
      		boolean busProcessed = false;
      		boolean genProcessed = false;
      		boolean branchProcessed = false;
      		boolean xfrAdjProcessed = false;
      		boolean areaInterProcessed = false;
      		boolean dcLineProcessed = false;
      		boolean switchedShuntProcessed = false;
    		do {
      			lineStr = din.readLine();
      			if (lineStr != null) {
      				lineNo++;
      				if (!headerProcessed) {
						if (lineNo == 3) 
      						headerProcessed = true;
						processHeader(adjNet, lineStr, lineNo, msgHub);
      				}
      				else if (!busProcessed) {
						if (isEndRecLine(lineStr))
							 busProcessed = true;
						else {
							processBus(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!genProcessed) {
						if (isEndRecLine(lineStr))
							 genProcessed = true;
						else {
							processGen(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!branchProcessed) {
						if (isEndRecLine(lineStr))
							 branchProcessed = true;
						else {
							processBranch(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!xfrAdjProcessed) {
						if (isEndRecLine(lineStr))
							 xfrAdjProcessed = true;
						else {
							processXfrAdjust(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!areaInterProcessed) {
						if (isEndRecLine(lineStr))
							 areaInterProcessed = true;
						else {
							processAreaInterchange(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!dcLineProcessed) {
						if (isEndRecLine(lineStr))
							 dcLineProcessed = true;
						else {
      						String lineStr2 = din.readLine();
      						String lineStr3 = din.readLine();
      						lineNo++; lineNo++;
							processDCLine(adjNet, lineStr, lineStr2, lineStr3, lineNo, msgHub);
						}	 
      				}
      				else if (!switchedShuntProcessed) {
						if (isEndRecLine(lineStr))
							 switchedShuntProcessed = true;
						else {
							processSwitchedShunt(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      			}
    		} while (lineStr != null);
  		} catch (Exception e) {
    		throw new Exception("AclfDataFile.in" + e.toString());
  		}
  		return adjNet;
	}
	
	/** 
	 * Process the first three header lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	private static void processHeader(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msgHub) throws Exception {
		System.out.println("Header data Line:" + lineNo + " " + lineStr);
		if (lineNo == 1) {
  			StringTokenizer st = new StringTokenizer(lineStr);
    		int indicator = new Integer(st.nextToken()).intValue();
    		double baseMVA = new Double(st.nextToken()).doubleValue();
			adjNet.setBaseKva(baseMVA*1000.0);
		}
		else if (lineNo == 2) {
			// this line is treated as description
			adjNet.setDesc(lineStr);
		}
		else {
			// this line is treated as casename
			adjNet.setId(lineStr);
		}
	}			

	/** 
	 * Process bus record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	private static void processBus(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msgHub) throws Exception {
/*
		1 1   90.000   49.000    0.000    0.000   1 1.02691    6.5238 ' 1      ' 115.00   1
		I,IDE,PL,QL,GL,BL,IA,VM,VA,'NAME',BASKL,ZONE

 		I - Bus number (1 to 29997)
 		IDE - Bus type
        	1 - Load bus (no generation)
        	2 - Generator or plant bus
        	3 - Swing bus
        	4 - Islolated bus
 		PL - Load MW
 		QL - Load MVAR
 		GL - Shunt conductance, MW at 1.0 per unit voltage
 		BL - Shunt susceptance, MVAR at 1.0 per unit voltage. (- = reactor)
 		IA - Area number, 1-100
 		VM - Voltage magnitude, per unit
 		VA - Voltage angle, degrees
 		NAME - Bus name, 8 characters, must be enclosed in quotes
 		BASKV - Base voltage, KV
 		ZONE - Loss zone, 1-999
*/
  		StringTokenizer st = new StringTokenizer(lineStr.substring(0, lineStr.indexOf('\'')));
    	int I = new Integer(st.nextToken()).intValue();
    	int IDE = new Integer(st.nextToken()).intValue();
		double PL = new Double(st.nextToken()).doubleValue();
		double QL = new Double(st.nextToken()).doubleValue();
		double GL = new Double(st.nextToken()).doubleValue();
		double BL = new Double(st.nextToken()).doubleValue();
		int IA = new Integer(st.nextToken()).intValue();
		double VM = new Double(st.nextToken()).doubleValue();
		double VA = new Double(st.nextToken()).doubleValue();
		
		String NAME = lineStr.substring(lineStr.indexOf('\'')+1, lineStr.lastIndexOf('\''));

  		st = new StringTokenizer(lineStr.substring(lineStr.lastIndexOf('\'')+1));
		double BASKV = new Double(st.nextToken()).doubleValue();
		int ZONE = new Integer(st.nextToken()).intValue();

		/*
		System.out.println("Bus data Line:" + lineNo + " " + lineStr);
		System.out.println("Bus number, type, name:" + I + ", " + IDE + ", " + NAME);
		System.out.println("Area, Zone:" + AREA + ", " + ZONE);
		System.out.println("baseKV, Vm, Va:" + BASKV + ", " + VM + ", " + VA);
		System.out.println("Pl, Ql, Gl, Bl:" + PL + ", " + QL + ", " + GL + ", " + BL);
		*/
	}			
	
	/** 
	 * Process generator record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	private static void processGen(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msgHub) throws Exception {
/*
		I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB

		I - Bus number
		ID - Machine identifier (0-9, A-Z)
		PG - MW output
		QG - MVAR output
		QT - Max MVAR
		QB - Min MVAR
		VS - Voltage setpoint
		IREG - Remote controlled bus index (must be type 1), zero to control own
		 		voltage, and must be zero for gen at swing bus
		MBASE - Total MVA base of this machine (or machines), defaults to system
				MVA base.
		ZR,ZX - Machine impedance, pu on MBASE
		RT,XT - Step up transformer impedance, p.u. on MBASE
		GTAP - Step up transformer off nominal turns ratio
		STAT - Machine status, 1 in service, 0 out of service
		RMPCT - Percent of total VARS required to hold voltage at bus IREG
 				to come from bus I - for remote buses controlled by several generators
		PT - Max MW
		PB - Min MW
*/		
  		StringTokenizer st = new StringTokenizer(lineStr);
		int I = new Integer(st.nextToken()).intValue();
		String ID = st.nextToken();
		double PG = new Double(st.nextToken()).doubleValue();
		double QG = new Double(st.nextToken()).doubleValue();
		double QT = new Double(st.nextToken()).doubleValue();
		double QB = new Double(st.nextToken()).doubleValue();
		double VS = new Double(st.nextToken()).doubleValue();
		int IREG = new Integer(st.nextToken()).intValue();
		double MBASE = new Double(st.nextToken()).doubleValue();
		double ZR = new Double(st.nextToken()).doubleValue();
		double ZX = new Double(st.nextToken()).doubleValue();
		double RT = new Double(st.nextToken()).doubleValue();
		double XT = new Double(st.nextToken()).doubleValue();
		double GTAP = new Double(st.nextToken()).doubleValue();
		int STAT = new Integer(st.nextToken()).intValue();
		double RMPCT = new Double(st.nextToken()).doubleValue();
		double PT = new Double(st.nextToken()).doubleValue();
		double PB = new Double(st.nextToken()).doubleValue();

		System.out.println("Gen data Line:" + lineNo + " " + lineStr);
	}			
	
	/** 
	 * Process branch record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	private static void processBranch(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msgHub) throws Exception {
/*
		I,J,CKT,R,X,B,RATEA,RATEB,RATEC,RATIO,ANGLE,GI,BI,GJ,BJ,ST

		I - From bus number
		J - To bus number
		CKT - Circuit identifier (two character) not clear if integer or alpha
		R - Resistance, per unit
		X - Reactance, per unit
		B - Total line charging, per unit
		RATEA - MVA rating A
		RATEB, RATEC - Higher MVA ratings
		RATIO - Transformer off nominal turns ratio
		ANGLE - Transformer phase shift angle
		GI,BI - Line shunt complex admittance for shunt at from end (I) bus, pu.
		GJ,BJ - Line shunt complex admittance for shunt at to end (J) bus, pu.
		ST - Initial branch status, 1 - in service, 0 - out of service
*/
  		StringTokenizer st = new StringTokenizer(lineStr);
		int I  = new Integer(st.nextToken()).intValue();
		int J  = new Integer(st.nextToken()).intValue();
		int CKT  = new Integer(st.nextToken()).intValue();
		double R = new Double(st.nextToken()).doubleValue();
		double X = new Double(st.nextToken()).doubleValue();
		double B = new Double(st.nextToken()).doubleValue();
		double RATEA = new Double(st.nextToken()).doubleValue();
		double RATEB = new Double(st.nextToken()).doubleValue();
		double RATEC = new Double(st.nextToken()).doubleValue();
		double RATIO = new Double(st.nextToken()).doubleValue();
		double ANGLE = new Double(st.nextToken()).doubleValue();
		double GI = new Double(st.nextToken()).doubleValue();
		double BI = new Double(st.nextToken()).doubleValue();
		double GJ = new Double(st.nextToken()).doubleValue();
		double BJ = new Double(st.nextToken()).doubleValue();
		int ST  = new Integer(st.nextToken()).intValue();

		System.out.println("Branch data Line:" + lineNo + " " + lineStr);
	}			

	/** 
	 * Process xformer adjustment record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	private static void processXfrAdjust(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msgHub) throws Exception {
/*
		I,J,CKT,ICONT,RMA,RMI,VMA,VMI,STEP,TABLE

		I - From bus number
		J - To bus number
		CKT - Circuit number
		ICONT - Number of bus to control. If different from I or J, sign of ICONT
			 determines control. Positive sign, close to impedance (untapped) bus
			 of transformer. Negative sign, opposite.
		RMA - Upper limit of turns ratio or phase shift
		RMI - Lower limit of turns ratio or phase shift
		VMA - Upper limit of controlled volts, MW or MVAR
		VMI - Lower limit of controlled volts, MW or MVAR
		STEP - Turns ratio step increment
		TABLE - Zero, or number of a transformer impedance correction table 1-5
*/
  		StringTokenizer st = new StringTokenizer(lineStr);

		int I = new Integer(st.nextToken()).intValue();
		int J = new Integer(st.nextToken()).intValue();
		int CKT = new Integer(st.nextToken()).intValue();
		int ICONT = new Integer(st.nextToken()).intValue();
		double RMA = new Double(st.nextToken()).doubleValue();
		double RMI = new Double(st.nextToken()).doubleValue();
		double VMA = new Double(st.nextToken()).doubleValue();
		double VMI = new Double(st.nextToken()).doubleValue();
		double STEP = new Double(st.nextToken()).doubleValue();
		int TABLE = new Integer(st.nextToken()).intValue();

		System.out.println("Xfr Adj data Line:" + lineNo + " " + lineStr);
	}			
	
	/** 
	 * Process area interchange record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	private static void processAreaInterchange(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msgHub) throws Exception {
/*
		I,ISW,PDES,PTOL,'ARNAM'

		I - Area number (1-100)
		ISW - Area interchange slack bus number
		PDES - Desired net interchange, MW + = out.
		PTOL - Area interchange tolerance, MW
		ARNAM - Area name, 8 characters, enclosed in single quotes.				
*/
  		StringTokenizer st = new StringTokenizer(lineStr);

		int I = new Integer(st.nextToken()).intValue();
		int ISW = new Integer(st.nextToken()).intValue();
		double PDES = new Double(st.nextToken()).doubleValue();
		double PTOL = new Double(st.nextToken()).doubleValue();
		String ARNAM = lineStr.substring(lineStr.indexOf('\'')+1, lineStr.lastIndexOf('\''));				

		System.out.println("Area interchange data Line:" + lineNo + " " + lineStr);
	}			
	
	/** 
	 * Process DC line record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	private static void processDCLine(
				AclfAdjNetwork adjNet, 
				String lineStr1,
				String lineStr2,
				String lineStr3,
				int lineNo, 
				IPSSMsgHub msgHub) throws Exception {
/*
		Each DC line has three consecutive records

		I,MDC,RDC,SETVL,VSCHD,VCMOD,RCOMP,DELTI,METER
		IPR,NBR,ALFMAX,ALFMN,RCR,XCR,EBASR,TRR,TAPR,TPMXR,TPMNR,TSTPR
		IPI,NBI,GAMMX,GAMMN,RCI,XCI,EBASI,TRI,TAPI,TPMXI,TPMNI,TSTPI

		I - DC Line number
		MDC - Control mode 0 - blocked 1 - power 2 - current
		RDC - Resistance, ohms
		SETVL - Current or power demand
		VSCHD - Scheduled compunded DC voltage, KV
		VCMOD - Mode switch DC voltage, KV, switch to current control mode below this
		RCOMP - Compounding resistance, ohms
		DELTI - Current margin, per unit of desired current
		METER - Metered end code, R - rectifier I - Inverter
		IPR - Rectifier converter bus number
		NBR - Number of birdges is series rectifier
		ALFMAX - Maximum rectifier firing angle, degrees
		ALFMN - Minimum rectifier firing angle, degrees
		RCR - Rectifier commutating transformer resistance, per bridge, ohms
		XCR - Rectifier commutating transformer reactance, per bridge, ohms
		EBASR - Rectifier primary base AC volts, KV
		TRR - Rectifier transformer ratio
		TAPR - Rectifier tap setting
		TPMXR - Maximum rectifier tap setting
		TPMNR - Minimum rectifier tap setting
		TSTPR - Rectifier tap step

		Third record contains inverter quantities corresponding to rectifier
		quantities above.
*/
  		StringTokenizer st = new StringTokenizer(lineStr1);
		int I  = new Integer(st.nextToken()).intValue();
		int MDC  = new Integer(st.nextToken()).intValue();
		double RDC = new Double(st.nextToken()).doubleValue();
		double SETVL = new Double(st.nextToken()).doubleValue();
		double VSCHD = new Double(st.nextToken()).doubleValue();
		double VCMOD = new Double(st.nextToken()).doubleValue();
		double RCOMP = new Double(st.nextToken()).doubleValue();
		double DELTI = new Double(st.nextToken()).doubleValue();
		String METER = st.nextToken();

		System.out.println("DC Line data Line:" + (lineNo-2) + " " + lineStr1);

  		st = new StringTokenizer(lineStr2);
		int IPR = new Integer(st.nextToken()).intValue();
		int NBR = new Integer(st.nextToken()).intValue();
		double ALFMAX = new Double(st.nextToken()).doubleValue();
		double ALFMN = new Double(st.nextToken()).doubleValue();
		double RCR = new Double(st.nextToken()).doubleValue();
		double XCR = new Double(st.nextToken()).doubleValue();
		double EBASR = new Double(st.nextToken()).doubleValue();
		double TRR = new Double(st.nextToken()).doubleValue();
		double TAPR = new Double(st.nextToken()).doubleValue();
		double TPMXR = new Double(st.nextToken()).doubleValue();
		double TPMNR = new Double(st.nextToken()).doubleValue();
		double TSTPR = new Double(st.nextToken()).doubleValue();

		System.out.println("DC Line data Line:" + (lineNo-1) + " " + lineStr2);

  		st = new StringTokenizer(lineStr3);
		IPR = new Integer(st.nextToken()).intValue();
		NBR = new Integer(st.nextToken()).intValue();
		ALFMAX = new Double(st.nextToken()).doubleValue();
		ALFMN = new Double(st.nextToken()).doubleValue();
		RCR = new Double(st.nextToken()).doubleValue();
		XCR = new Double(st.nextToken()).doubleValue();
		EBASR = new Double(st.nextToken()).doubleValue();
		TRR = new Double(st.nextToken()).doubleValue();
		TAPR = new Double(st.nextToken()).doubleValue();
		TPMXR = new Double(st.nextToken()).doubleValue();
		TPMNR = new Double(st.nextToken()).doubleValue();
		TSTPR = new Double(st.nextToken()).doubleValue();

		System.out.println("DC Line data Line:" + lineNo + " " + lineStr3);
	}			

	private static void processSwitchedShunt(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msgHub) throws Exception {
/*
		I,MODSW,VSWHI,VSWLO,SWREM,BINIT,N1,B1,N2,B2...N8,B8

		I - Bus number
		MODSW - Mode 0 - fixed 1 - discrete 2 - continuous
		VSWHI - Desired voltage upper limit, per unit
		VSWLO - Desired voltage lower limit, per unit
		SWREM - Number of remote bus to control. 0 to control own bus.
		VDES - Desired voltage setpoint, per unit
		BINIT - Initial switched shunt admittance, MVAR at 1.0 per unit volts
		N1 - Number of steps for block 1, first 0 is end of blocks
		B1 - Admittance increment of block 1 in MVAR at 1.0 per unit volts.
		N2, B2, etc, as N1, B1
*/				
  		StringTokenizer st = new StringTokenizer(lineStr);

		int I = new Integer(st.nextToken()).intValue();
		int MODSW = new Integer(st.nextToken()).intValue();
		double VSWHI = new Double(st.nextToken()).doubleValue();
		double VSWLO = new Double(st.nextToken()).doubleValue();
		int SWREM  = new Integer(st.nextToken()).intValue();
		double VDES = new Double(st.nextToken()).doubleValue();
		double BINIT = new Double(st.nextToken()).doubleValue();
		int N1     = new Integer(st.nextToken()).intValue();
		double B1  = new Double(st.nextToken()).doubleValue();
		int N2     = st.hasMoreTokens()? new Integer(st.nextToken()).intValue() : 0;
		double B2  = st.hasMoreTokens()? new Double(st.nextToken()).doubleValue() : 0.0;
		int N3     = st.hasMoreTokens()? new Integer(st.nextToken()).intValue() : 0;
		double B3  = st.hasMoreTokens()? new Double(st.nextToken()).doubleValue() : 0.0;
		int N4     = st.hasMoreTokens()? new Integer(st.nextToken()).intValue() : 0;
		double B4  = st.hasMoreTokens()? new Double(st.nextToken()).doubleValue() : 0.0;
		int N5     = st.hasMoreTokens()? new Integer(st.nextToken()).intValue() : 0;
		double B5  = st.hasMoreTokens()? new Double(st.nextToken()).doubleValue() : 0.0;
		int N6     = st.hasMoreTokens()? new Integer(st.nextToken()).intValue() : 0;
		double B6  = st.hasMoreTokens()? new Double(st.nextToken()).doubleValue() : 0.0;
		int N7     = st.hasMoreTokens()? new Integer(st.nextToken()).intValue() : 0;
		double B7  = st.hasMoreTokens()? new Double(st.nextToken()).doubleValue() : 0.0;
		int N8     = st.hasMoreTokens()? new Integer(st.nextToken()).intValue() : 0;
		double B8  = st.hasMoreTokens()? new Double(st.nextToken()).doubleValue() : 0.0;

		System.out.println("Switched shunt data Line:" + lineNo + " " + lineStr);
	}			

	/**
	 * PTI use 0 to indicate end of a data set, Bus Data for example. This function checks
	 * if the input line is the end of record line
	 *
	 * @param str a input data line string
	 */
	private static boolean isEndRecLine(String str) {
		return ("0").equals(str.trim());
	}
}