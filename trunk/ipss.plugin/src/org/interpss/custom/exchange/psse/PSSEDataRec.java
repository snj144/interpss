package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.AreaInterchangeController;
import com.interpss.core.net.Owner;
import com.interpss.core.net.Zone;


public class PSSEDataRec {
	public enum VersionNo {
		NotDefined, Old, PSS_E_29, PSS_E_30
	}

	static public class HeaderRec {
		private int indicator = 0;
		private double baseMva;

		public HeaderRec(String lineStr, int lineNo, VersionNo version) {
			if (lineNo == 1) {
				if (version == PSSEDataRec.VersionNo.Old) {
					// "0 100.0"
					StringTokenizer st = new StringTokenizer(lineStr);
					st.nextToken();
					baseMva = new Double(st.nextToken().trim()).doubleValue();
				} else {
					StringTokenizer st = new StringTokenizer(lineStr, ",");
					indicator = new Integer(st.nextToken()).intValue();
					// at here we have "100.00 / PSS/E-29.0 THU, JUN 20 2002 14:19"
					st = new StringTokenizer(st.nextToken(), "/");
					baseMva = new Double(st.nextToken().trim()).doubleValue();
				}
			}
		}
		
		/** 
		 * Process the first three header line records
		 *
		 * @param adjNet the AclfAdjNetwork object
		 * @param lineStr a input line string
		 * @param lineNo the line number
		 * @param msgHub the message hub object
		 */
		public boolean processHeader(
					AclfAdjNetwork adjNet, 
					String lineStr,
					int lineNo, 
					IPSSMsgHub msg) throws Exception {
			if (lineNo == 1) {
	    		adjNet.setBaseKva(baseMva*1000.0);
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
			return true;
		}			
	}

	/*
	 * AreaInterchangeData I,ISW,PDES,PTOL,'ARNAM'
	 */
	static public class AreaInterchangeRec {
		private int i, isw;
		private double pdes, ptol;
		private String arnam;

		public AreaInterchangeRec(String lineStr, VersionNo version) {
			StringTokenizer st = new StringTokenizer(lineStr, ",");
			i = new Integer(st.nextToken().trim()).intValue();
			isw = new Integer(st.nextToken().trim()).intValue();
			pdes = new Double(st.nextToken().trim()).doubleValue();
			ptol = new Double(st.nextToken().trim()).doubleValue();
			arnam = st.nextToken().trim();
		}
		
		/** 
		 * Process area interchange record lines
		 *
		 * @param adjNet the AclfAdjNetwork object
		 * @param msgHub the message hub object
		 */
		public void processAreaInterchange(
					AclfAdjNetwork adjNet, 
					IPSSMsgHub msgHub) throws Exception {
	/*
			I,ISW,PDES,PTOL,'ARNAM'
	*/
			AreaInterchangeController controller = CoreObjectFactory.createAreaInterchangeController(this.i, this.arnam, adjNet);
			AclfBus bus = adjNet.getAclfBus(new Integer(this.isw).toString());
			if (bus == null) {
				throw new Exception("Area interchange poewr controller, Swing bus not found, ISW: " + this.isw);
			}
			controller.setAclfBus(bus);
			controller.setPSpecOut(this.pdes, UnitType.mW, adjNet.getBaseKva());
			controller.setTolerance(this.ptol, UnitType.mW, adjNet.getBaseKva());
		}
		
		public String toString() {
			String str = "";
			str += "Area number, Swing Bus Number:" + i + ", " + isw + "\n";
			str += "Pspec, Perror, Name:" + pdes + ", " + ptol + ", "  + arnam + "\n";
			return str;
		}
	}

	/*
	 * ZoneData Format: I, ’ZONAME’
	 */
	static public class ZoneRec {
		private int i;
		private String name;

		public ZoneRec(String lineStr, VersionNo version) {
			StringTokenizer st = new StringTokenizer(lineStr, ",");
			i = new Integer(st.nextToken().trim()).intValue();
			name = st.nextToken().trim();
		}
		
		public void processZone(
				AclfAdjNetwork adjNet, 
				IPSSMsgHub msg) throws Exception {
			/*
			 * Format: I, ’ZONAME’
			 */
	      	Zone zone = CoreObjectFactory.createZone(i, adjNet);
			zone.setName(name);
		}		

		public String toString() {
			String str = "";
			str += "Zone number, name:" + i + ", " + name;
			return str;
		}
	}

	/*
	 * InterareaTransfer format: ARFROM, ARTO, TRID, PTRAN
	 */
	static public class InterareaTransferRec {
		private int arfrom, arto;
		private String trid;
		private double ptran;

		public InterareaTransferRec(String lineStr, VersionNo version) {
			StringTokenizer st = new StringTokenizer(lineStr, ",");
			arfrom = new Integer(st.nextToken().trim()).intValue();
			arto = new Integer(st.nextToken().trim()).intValue();
			trid = st.nextToken().trim();
			ptran = new Double(st.nextToken().trim()).doubleValue();
		}
		
		public void processInterareaTransfer(
				AclfAdjNetwork adjNet, 
				IPSSMsgHub msg) throws Exception {
			/*
			 * format: ARFROM, ARTO, TRID, PTRAN
			 */
			// TODO: data error checking to be implemented
		}		

		public String toString() {
			String str = "";
			str += "From area number, From area number, id, value:" + arfrom + ", " + arto  + ", " + trid  + ", " + ptran;
			return str;
		}
	}

	/*
	 * Owner format : I, ’OWNAME’
	 */
	static public class OwnerRec {
		private int i;
		private String name;

		public OwnerRec(String lineStr, VersionNo version) {
			StringTokenizer st = new StringTokenizer(lineStr, ",");
			i = new Integer(st.nextToken().trim()).intValue();
			name = st.nextToken().trim();
		}
	
		public void processOwner(
				AclfAdjNetwork adjNet, 
				IPSSMsgHub msg) throws Exception {
			/*
			 * format : I, ’OWNAME’
			 */
	      	Owner owner = CoreObjectFactory.createOwner(new Integer(i).toString(), adjNet);
			owner.setName(name);
		}

		public String toString() {
			String str = "";
			str += "Zone number, name:" + i + ", " + name;
			return str;
		}
	}
	
	public static void processXfrZCorrectionTable(
			AclfAdjNetwork adjNet, 
			String lineStr1,
			int lineNo, 
			IPSSMsgHub msg) throws Exception {
		msg.sendWarnMsg("Transformer Z correction table record has not been implemented");	
	}
}
