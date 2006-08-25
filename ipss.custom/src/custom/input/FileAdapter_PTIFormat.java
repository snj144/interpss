package custom.input;

/*
 * PTI PSS/E File input adapter. The implementation is Based on 
 * PSS/E 29, published Oct 2002.
 * 
 * The following records are implemented
 * 
 * 		Case Identification
		Bus Data
		Gnerator Data
		Nontransformer Branch Data
		Transformer Data
		Area Interchange Data
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.io.IpssFileAdapterBase;

import custom.input.psse.BranchDataRecord;
import custom.input.psse.BusDataRecord;
import custom.input.psse.NetDataRecord;
import custom.input.psse.PSSEUtilFunc;

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
		throw new InvalidOperationException("FileAdapter_PTIFormat.save not implemented");
	}
	
	/** 
	 * Build an AclfAdjNetwork object from the input file stream in PTI format
	 *
	 * @param din input file stream
	 * @param msgHub the message hub object
	 */
	private AclfAdjNetwork loadFile(
				java.io.BufferedReader din, 
				IPSSMsgHub msgHub) throws Exception {
  		AclfAdjNetwork adjNet = CoreObjectFactory.createAclfAdjNetwork();
  		adjNet.setAllowParallelBranch(true);
  		String lineStr = null;
  		int lineNo = 0;
  		try {
      		boolean headerProcessed = false;
      		boolean busProcessed = false;
      		boolean loadProcessed = false;
      		boolean genProcessed = false;
      		boolean lineProcessed = false;
      		boolean xfrProcessed = false;
      		boolean areaInterProcessed = false;
      		boolean dcLine2TProcessed = false;
      		boolean vscDcLineProcessed = false;
      		boolean switchedShuntProcessed = false;
      		boolean xfrZCorrectionProcessed = false;
      		boolean scLineMTProcessed = false;
      		boolean multiSectionLineGroupProcessed = false;
      		boolean zoneProcessed = false;
      		boolean interareaTransferProcessed = false;
      		boolean ownerProcessed = false;
      		boolean factsProcessed = false;
      		do {
      			lineStr = din.readLine();
      			if (lineStr != null) {
      				lineNo++;
      				if (!headerProcessed) {
						if (lineNo == 3) 
      						headerProcessed = true;
						NetDataRecord.processHeader(adjNet, lineStr, lineNo, msgHub);
      				}
      				else if (!busProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							 busProcessed = true;
						else {
							BusDataRecord.processBus(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!loadProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							 loadProcessed = true;
						else {
							BusDataRecord.processLoad(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!genProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							 genProcessed = true;
						else {
							BusDataRecord.processGen(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!lineProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							 lineProcessed = true;
						else {
							BranchDataRecord.processLine(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!xfrProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							 xfrProcessed = true;
						else {
							int n = lineNo;
      						String lineStr2 = din.readLine();
      						String lineStr3 = din.readLine();
      						String lineStr4 = din.readLine();
      						lineNo++; lineNo++; lineNo++;
      						String lineStr5 = "";
      						if (PSSEUtilFunc.is3WXfr(lineStr2)) {
          						lineStr4 = din.readLine();
          						lineNo++;
      						}
							BranchDataRecord.processXfr(adjNet, lineStr, lineStr2, lineStr3, lineStr4, lineStr5, n, msgHub);
						}	 
      				}
      				else if (!areaInterProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							 areaInterProcessed = true;
						else {
							NetDataRecord.processAreaInterchange(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!dcLine2TProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							 dcLine2TProcessed = true;
						else {
      						String lineStr2 = din.readLine();
      						String lineStr3 = din.readLine();
      						lineNo++; lineNo++;
							//processDCLine(adjNet, lineStr, lineStr2, lineStr3, lineNo, msgHub);
						}	 
      				}
      				else if (!switchedShuntProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							 switchedShuntProcessed = true;
						else {
							//processSwitchedShunt(adjNet, lineStr, lineNo, msgHub);
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
	 * Process DC line record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	private void processDCLine(
				AclfAdjNetwork adjNet, 
				String lineStr1,
				String lineStr2,
				String lineStr3,
				int lineNo, 
				IPSSMsgHub msgHub) throws Exception {
/*
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

		IpssLogger.getLogger().info("DC Line data Line1:" + (lineNo-2) + "-->" + lineStr1);

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

		IpssLogger.getLogger().info("DC Line data Line2:" + (lineNo-1) + "-->" + lineStr2);

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

		IpssLogger.getLogger().info("DC Line data Line3:" + lineNo + "-->" + lineStr3);
	}			

	private void processSwitchedShunt(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msgHub) throws Exception {
/*
		I,MODSW,VSWHI,VSWLO,SWREM,BINIT,N1,B1,N2,B2...N8,B8
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

		IpssLogger.getLogger().info("Switched shunt data Line:" + lineNo + " " + lineStr);
	}			
}