package custom.input.psse;

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

import java.util.StringTokenizer;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.AreaInterchangeController;
import com.interpss.simu.io.IpssFileAdapterBase;

public class NetDataRecord extends IpssFileAdapterBase {
	/** 
	 * Process the first three header line records
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static void processHeader(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msg) throws Exception {
		IpssLogger.getLogger().fine("Header data Line:" + lineNo + " " + lineStr);
		if (lineNo == 1) {
  			StringTokenizer st = new StringTokenizer(lineStr, ",");
    		int indicator = new Integer(st.nextToken()).intValue();
    		if (indicator != 0) {
    			// we will implement this in the future.
    			throw new Exception("Only base case has been implmented");
    		}
    		
    		// at here we have "100.00 / PSS/E-29.0 THU, JUN 20 2002 14:19"
  			st = new StringTokenizer(st.nextToken());
    		double baseMVA = new Double(st.nextToken()).doubleValue();
			adjNet.setBaseKva(baseMVA*1000.0);
			
			// PSS/E do not have ground branch concept
			adjNet.setAllowGroundBranch(false);
			
			// PSS/E allow parallel branches
			adjNet.setAllowParallelBranch(true);
			
			// We check if there is any Bus number or branch duplication. Branch dupblication defined as
			// branches with same circuit id connected between the same from bus and to bus.
			adjNet.setCheckElementDuplication(true);

			// Base Frequency is not used in loadflow calculation, dedined as 60.0 Hz
			adjNet.setFrequency(60.0);
		}
		else if (lineNo == 2) {
			// The 2nd line is treated as description
			adjNet.setDesc(lineStr);
		}
		else {
			// the 3rd line is treated as the network id and network name
			adjNet.setId(lineStr);
			adjNet.setName(lineStr);
		}
	}			
	/** 
	 * Process area interchange record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static void processAreaInterchange(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msgHub) throws Exception {
/*
		I,ISW,PDES,PTOL,'ARNAM'
*/
  		StringTokenizer st = new StringTokenizer(lineStr, ",");

		int I = new Integer(st.nextToken().trim()).intValue();
		int ISW = new Integer(st.nextToken().trim()).intValue();
		double PDES = new Double(st.nextToken().trim()).doubleValue();
		double PTOL = new Double(st.nextToken().trim()).doubleValue();
		String ARNAM = PSSEUtilFunc.trimQuote(st.nextToken());

		IpssLogger.getLogger().info("Area interchange data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().info("Area number, Swing Bus Number:" + I + ", " + ISW);
		IpssLogger.getLogger().info("Pspec, Perror, Name:" + PDES + ", " + PTOL + ", "  + ARNAM);
		
		AreaInterchangeController controller = CoreObjectFactory.createAreaInterchangeController(I, ARNAM, adjNet);
		AclfBus bus = adjNet.getAclfBus(new Integer(ISW).toString());
		if (bus == null) {
			throw new Exception("Area interchange poewr controller, Swing bus not found, ISW: " + ISW);
		}
		controller.setAclfBus(bus);
		controller.setPSpecOut(PDES, UnitType.mW, adjNet.getBaseKva());
		controller.setTolerance(PTOL, UnitType.mW, adjNet.getBaseKva());
	}			
}