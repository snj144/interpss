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
import ipss.custom.psse.aclf.PSSEGen;
import ipss.custom.psse.aclf.PSSELoad;
import ipss.custom.psse.aclf.PSSEXformer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.PVBusAdapter;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.FunctionLoad;
import com.interpss.core.aclfadj.PSXfrPControl;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.RemoteQBus;
import com.interpss.core.aclfadj.RemoteQControlType;
import com.interpss.core.aclfadj.TapControl;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
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

		processPSSEDataAfterLoad(adjNet, msg);
		
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
	
	private void processPSSEDataAfterLoad(AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		for( Iterator itr = adjNet.getBusList().iterator(); itr.hasNext();) {
			AclfBus bus = (AclfBus)itr.next();

			double loadPSum = 0.0, loadQSum = 0.0;
			boolean isFuncLoad = false;
			double constP_P = 0.0, constP_Q = 0.0;
			double constI_P = 0.0, constI_Q = 0.0;

			String remoteBusId = null;
			double genPSum = 0.0, genQSum = 0.0, vSpec = 0.0;
			double genQmax = 0.0, genQmin = 0.0;
			
			if (bus.getRegDeviceList().size() > 0) {
				for( Iterator itrReg = bus.getRegDeviceList().iterator(); itrReg.hasNext();) {
					Object obj = itrReg.next();
					if (obj instanceof PSSELoad) {
						PSSELoad load = (PSSELoad)obj;
						loadPSum += load.getConstPLoad().getReal() + load.getConstILoad().getReal() +load.getConstZLoad().getReal(); 
						loadQSum += load.getConstPLoad().getImaginary() + load.getConstILoad().getImaginary() +load.getConstZLoad().getImaginary(); 
						constP_P += load.getConstPLoad().getReal(); 
						constI_P += load.getConstILoad().getReal(); 
						constP_Q += load.getConstPLoad().getImaginary(); 
						constI_Q += load.getConstILoad().getImaginary();
						if (load.getConstILoad().getReal() != 0.0 ||
							load.getConstZLoad().getReal() != 0.0 ||
							load.getConstILoad().getImaginary() != 0.0 ||
							load.getConstILoad().getImaginary() != 0.0)
							isFuncLoad = true;
					}
					else if (obj instanceof PSSEGen) {
						PSSEGen gen = (PSSEGen)obj;
						genPSum += gen.getPGen();
						genQSum += gen.getQGen();
						if (vSpec == 0.0)
							vSpec = gen.getVSpec();
						else if (vSpec != gen.getVSpec()) {
							msg.sendErrorMsg("Inconsistance Gen VSpec at Bus " + bus.getId());
						}
						if (remoteBusId == null)
							remoteBusId = gen.getVControlBusId();
						else if (!remoteBusId.equals(gen.getVControlBusId())) {
							msg.sendErrorMsg("Inconsistance Gen IREG at Bus " + bus.getId());
						}
						genQmax += gen.getQLimit().getMax();
						genQmin += gen.getQLimit().getMin();
					}
				}
			}
			
			if (genPSum != 0.0 || vSpec != 0.0) {
				if (bus.getGenCode() == AclfGenCode.SWING_LITERAL) {
		  			final SwingBusAdapter gen = (SwingBusAdapter)bus.adapt(SwingBusAdapter.class);
		  			gen.setVoltMag(vSpec, UnitType.PU);
				}
				else if (bus.getGenCode() == AclfGenCode.GEN_PV_LITERAL) {
		  			final PVBusAdapter gen = (PVBusAdapter)bus.adapt(PVBusAdapter.class);
		  			gen.setGenP(genPSum, UnitType.PU, adjNet.getBaseKva());
		  			gen.setVoltMag(vSpec, UnitType.PU);
					if (remoteBusId.equals("0")) {
						// PVLimit
	  					IpssLogger.getLogger().fine("Bus is a PVLimitBus, id: " + bus.getId());
	  			  		final PVBusLimit pvLimit = CoreObjectFactory.createPVBusLimit(adjNet, bus.getId());
	  			  		pvLimit.setQLimit(new LimitType(genQmax, genQmin), UnitType.PU, adjNet.getBaseKva());
					}
					else {
						// remote bus voltage
	  					IpssLogger.getLogger().fine("Bus is a RemoteQBus, id: " + bus.getId());
	  			  		final RemoteQBus reQ1 = CoreObjectFactory.createRemoteQBus(adjNet, bus.getId(), 
	  			  				RemoteQControlType.BUS_VOLTAGE_LITERAL, remoteBusId);
	  			  		reQ1.setQLimit(new LimitType(genQmax, genQmin), UnitType.PU, adjNet.getBaseKva());
	  			  		reQ1.setVSpecified(vSpec);
	  			  	}
				}
				else {
					msg.sendErrorMsg("Generator data error, Bus IDE != 2 at Bus " + bus.getId());
				}
			}
			
			if (loadPSum != 0.0 || loadQSum != 0.0 || isFuncLoad ) {
				bus.setLoadCode(AclfLoadCode.CONST_P_LITERAL);
				bus.setLoadP(loadPSum);
				bus.setLoadQ(loadQSum);
				if (isFuncLoad) {
			  		FunctionLoad fload = CoreObjectFactory.createFunctionLoad(adjNet, bus.getId());
			  		fload.getP().setA(constP_P/loadPSum);
			  		fload.getP().setB(constI_P/loadPSum);
			  		fload.getQ().setA(constP_Q/loadQSum);
			  		fload.getQ().setB(constI_Q/loadQSum);					
				}
			}
			
		}
 /*
		RMA, RMI The upper and lower limits, respectively, of either:
			• Off-nominal turns ratio in pu of winding one bus base voltage when |COD|
				is 1 or 2 and CW is 1; RMA = 1.1 and RMI = 0.9 by default.
			• Actual winding one voltage in kV when |COD| is 1 or 2 and CW is 2. No
				default is allowed.
			• Phase shift angle in degrees when |COD| is 3. No default is allowed.
			• Not used when |COD| is 0 or 4; RMA = 1.1 and RMI = 0.9 by default.

		VMA, VMI The upper and lower limits, respectively, of either:
			• Voltage at the controlled bus (bus |CONT|) in pu when |COD| is 1.
				VMA = 1.1 and VMI = 0.9 by default.
			• Reactive power flow into the transformer at the winding one bus end in
				Mvar when |COD| is 2. No default is allowed.
			• Active power flow into the transformer at the winding one bus end in MW
				when |COD| is 3. No default is allowed.
			• Not used when |COD| is 0 or 4; VMA = 1.1 and VMI = 0.9 by default.
*/
		for( Iterator itr = adjNet.getBranchList().iterator(); itr.hasNext();) {
			Object obj = itr.next();
			if (obj instanceof PSSEXformer) {
				PSSEXformer xfr = (PSSEXformer)obj;
	          	if (xfr.getControlMode() == 1 || xfr.getControlMode() == -1) {
	          		// ±1 for voltage control; a negative control mode suppresses the automatic adjustment of this
	          		// transformer.
	          		/*
					The tap ratio of each transformer is adjusted to hold a voltage
					magnitude between the limits VMIN to VMAX.
	          		 */
	          		IpssLogger.getLogger().info("Xfr " + xfr.getFromAclfBus().getId() + "->" + xfr.getToAclfBus().getId() + " has voltage control");
	          		final TapControl tapv = CoreObjectFactory.createTapVControlBusVoltage(
	          				adjNet, xfr.getId(), xfr.getContBusId());
	          		tapv.setTapLimit(xfr.getRmLimit());
	          		// TODO: set vmLimit
	          		tapv.setVSpecified(1.0);
	          		tapv.setTapStepSize((xfr.getRmLimit().getMax()-xfr.getRmLimit().getMin())/xfr.getAdjSteps());
	          		tapv.setControlOnFromSide(xfr.getControlOnFromSide());
	          		if (xfr.getControlMode() == -1)
	          			tapv.setStatus(false);
	          		adjNet.addTapControl(tapv, xfr.getContBusId());   
	          	}
	          	else if (xfr.getControlMode() == 2 || xfr.getControlMode() == -2) {
	          		// ±2 for reactive power flow control; 
	          		/*
					The tap ratio is adjusted to hold the Mvar on the tap side of the transformer between the limits
					VMIN-VMAX.	        
	          		 */
	          		IpssLogger.getLogger().info("Xfr " + xfr.getFromAclfBus().getId() + "->" + xfr.getToAclfBus().getId() + " has reactive power flow control");
	          		final TapControl tapv = CoreObjectFactory.createTapVControlMvarFlow(adjNet, xfr.getId());
	          		tapv.setTapLimit(xfr.getRmLimit());
	          		// TODO: set vmLimit
	          		tapv.setTapStepSize((xfr.getRmLimit().getMax()-xfr.getRmLimit().getMin())/xfr.getAdjSteps());
	          		tapv.setControlOnFromSide(xfr.getControlOnFromSide());
	          		if (xfr.getControlMode() == -1)
	          			tapv.setStatus(false);
	          		adjNet.addTapControl(tapv, xfr.getContBusId());   
	          	}
	          	else if (xfr.getControlMode() == 3 || xfr.getControlMode() == -3) {
	          		// ±3 for active power flow control;
	          		/*
					The phase-shift angle of each phase shifter is adjusted, as necessary, to keep the real power flow
					through the phase shifter between the limits VMAX and VMIN.
	          		 */
	          		IpssLogger.getLogger().info("PSXfr " + xfr.getFromAclfBus().getId() + "->" + xfr.getToAclfBus().getId() + " has active power control");
	          		final PSXfrPControl ps = CoreObjectFactory.createPSXfrPControl(adjNet, xfr.getId());
	          		ps.setAngLimit(new LimitType(xfr.getRmLimit().getMax()*Constants.DtoR, 
	          									 xfr.getRmLimit().getMin()*Constants.DtoR));
	          		// TODO: set vmLimit
	          		ps.setControlOnFromSide(xfr.getControlOnFromSide());
	          		if (xfr.getControlMode() == -1)
	          			ps.setStatus(false);
          			adjNet.addPSXfrPControl(ps, xfr.getId());   
	          	}
	          	else if (xfr.getControlMode() == 4 || xfr.getControlMode() == -4) {
	          		// ±4 for control of a dc line quantity.
	          		msg.sendWarnMsg("Xfr " + xfr.getFromAclfBus().getId() + "->" + xfr.getToAclfBus().getId() + " has control of a dc line capacity");
	          	}
			}
		}
	}
}