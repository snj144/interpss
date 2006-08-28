package ipss.custom.exchange;

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

import ipss.custom.exchange.psse.BranchDataRecord;
import ipss.custom.exchange.psse.BusDataRecord;
import ipss.custom.exchange.psse.DCLintDataRecord;
import ipss.custom.exchange.psse.NetDataRecord;
import ipss.custom.exchange.psse.PSSEUtilFunc;
import ipss.custom.exchange.psse.SwitchedShuntDataRecord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

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
      		boolean dcLineMTProcessed = false;
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
      						if (PSSEUtilFunc.is3WXfr(lineStr)) {
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
      						DCLintDataRecord.processDCLine(adjNet, lineStr, lineStr2, lineStr3, lineNo, msgHub);
						}	 
      				}
      				else if (!vscDcLineProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							vscDcLineProcessed = true;
						else {
      						DCLintDataRecord.processVscDCLine(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!switchedShuntProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							 switchedShuntProcessed = true;
						else {
							SwitchedShuntDataRecord.processSwitchedShunt(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!xfrZCorrectionProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							xfrZCorrectionProcessed = true;
						else {
							BranchDataRecord.processXfrZCorrectionTable(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!dcLineMTProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							dcLineMTProcessed = true;
						else {
							DCLintDataRecord.processMultiTerminalDCLine(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!multiSectionLineGroupProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							multiSectionLineGroupProcessed = true;
						else {
							NetDataRecord.processMultiSectionLineGroup(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!zoneProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							zoneProcessed = true;
						else {
							NetDataRecord.processZone(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!interareaTransferProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							interareaTransferProcessed = true;
						else {
							NetDataRecord.processInterareaTransfer(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!ownerProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							ownerProcessed = true;
						else {
							NetDataRecord.processOwner(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!factsProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr))
							factsProcessed = true;
						else {
							SwitchedShuntDataRecord.processFACTS(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				
      			}
    		} while (lineStr != null);
  		} catch (Exception e) {
    		throw new Exception("AclfDataFile.in" + e.toString());
  		}
  		return adjNet;
	}
}