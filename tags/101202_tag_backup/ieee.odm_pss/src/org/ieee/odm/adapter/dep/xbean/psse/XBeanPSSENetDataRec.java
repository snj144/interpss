package org.ieee.odm.adapter.dep.xbean.psse;

import java.util.StringTokenizer;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ActivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BaseRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetAreaXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetZoneXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.XformerZTableXmlType;
import org.ieee.odm.adapter.psse.PsseVersion;
import org.ieee.odm.model.dep.xbean.XBeanDataSetter;
import org.ieee.odm.model.dep.xbean.XBeanODMModelParser;
import org.ieee.odm.model.dep.xbean.XBeanParserHelper;


public class XBeanPSSENetDataRec {
	static public class HeaderRec {
		public static void procLineString(String lineStr, int lineNo, PsseVersion version, final PSSNetworkXmlType baseCaseNet) {
			if (lineNo == 1) {
				StringTokenizer st = new StringTokenizer(lineStr, ",");
				int indicator = new Integer(st.nextToken().trim()).intValue();
				// at here we have "100.00 / PSS/E-29.0 THU, JUN 20 2002 14:19"
				st = new StringTokenizer(st.nextToken(), "/");
				double baseMva = new Double(st.nextToken().trim()).doubleValue();
				
				XBeanDataSetter.setPowerMva(baseCaseNet.addNewBasePower(), baseMva);
				
				NameValuePairListXmlType nvList = baseCaseNet.addNewNvPairList();
				XBeanParserHelper.addNVPair(nvList, "CaseIndicator", new Integer(indicator).toString());
			}
			else if (lineNo == 2) {
				// The 2nd line is treated as description
				baseCaseNet.setDesc(lineStr);
			}
			else {
				// the 3rd line is treated as the network id and network name
				baseCaseNet.setName(lineStr);
			}
		}			
	}

	/*
	 * Area Data I,ISW,PDES,PTOL,'ARNAM'
	 */
	public static void processAreaRec(String lineStr, PsseVersion version, final PSSNetworkXmlType baseCaseNet) {
		StringTokenizer st = new StringTokenizer(lineStr, ",");
		int i = new Integer(st.nextToken().trim()).intValue();
		int isw = new Integer(st.nextToken().trim()).intValue();
		double pdes = new Double(st.nextToken().trim()).doubleValue();
		double ptol = new Double(st.nextToken().trim()).doubleValue();
		String arnam = st.nextToken().trim();

/*
		I,  ISW,     PDES,      PTOL, 'ARNAM'
	    1,    0,     0.000,     1.000,'NEPEX       '

*/
		if (baseCaseNet.getAreaList() == null)
			baseCaseNet.addNewAreaList();
		NetAreaXmlType area = baseCaseNet.getAreaList().addNewArea();
		area.setId(new Integer(i).toString());
		area.setNumber(i);
		area.setName(arnam);

		if (isw > 0) {
			area.addNewSwingBusId().setIdRef(XBeanODMModelParser.BusIdPreFix+isw);
			XBeanDataSetter.setActivePower(area.addNewDesiredExchangePower(), pdes, ActivePowerUnitType.MW);
			XBeanDataSetter.setActivePower(area.addNewExchangeErrTolerance(), ptol, ActivePowerUnitType.MW);			
		}
	}

	/*
	 * ZoneData Format: I, ’ZONAME’
	 */
	public static void processZoneRec(String lineStr, PsseVersion version, final PSSNetworkXmlType baseCaseNet) {
		StringTokenizer st = new StringTokenizer(lineStr, ",");
		int	i = new Integer(st.nextToken().trim()).intValue();
		String name = st.nextToken().trim();

		/*
		 * Format: I, ’ZONAME’
		 */
		if (baseCaseNet.getLossZoneList() == null)
			baseCaseNet.addNewLossZoneList();
		NetZoneXmlType zone = baseCaseNet.getLossZoneList().addNewLossZone();
		zone.setId(new Integer(i).toString());
		zone.setNumber(i);
		zone.setName(name);		
	}

	/*
	 * InterareaTransfer format: ARFROM, ARTO, TRID, PTRAN
	 */
	public static void processInterareaTransferRec(String lineStr, PsseVersion version, final PSSNetworkXmlType baseCaseNet) {
		StringTokenizer st = new StringTokenizer(lineStr, ",");
		int	arfrom = new Integer(st.nextToken().trim()).intValue();
		int	arto = new Integer(st.nextToken().trim()).intValue();
		String	trid = st.nextToken().trim();
		double	ptran = new Double(st.nextToken().trim()).doubleValue();

		/*
			 * format: ARFROM, ARTO, TRID, PTRAN

			ARFROM "From area" number (1 through the maximum number of areas at the 
					current size level; see Table P-1).
			ARTO "To area" number (1 through the maximum number of areas at the current 
					size level; see Table P-1).
			TRID Single-character (0 through 9 or A through Z) upper case interarea transfer identifier
					used to distinguish among multiple transfers between areas ARFROM and
					ARTO. TRID = ’1’ by default.
			PTRAN MW comprising this transfer. A positive PTRAN indicates that area ARFROM is
					selling to area ARTO. PTRAN = 0.0 by default.
					
				- FromAreaNo_ToAreaNo_TRID is unique					 
		*/
		if (baseCaseNet.getInterchangeList() == null)
			baseCaseNet.addNewInterchangeList();
		PSSNetworkXmlType.InterchangeList.Interchange.AreaTransfer transfer = baseCaseNet.getInterchangeList().addNewInterchange().addNewAreaTransfer();
		
		transfer.setFromArea(arfrom);
		transfer.setToArea(arto);
		transfer.setId(trid);
		transfer.setAmountMW(ptran);
	}

	/*
	 * Owner format : I, ’OWNAME’
	 */
	public static void processOwnerRec(String lineStr, PsseVersion version, final PSSNetworkXmlType baseCaseNet) {
		StringTokenizer st = new StringTokenizer(lineStr, ",");
		int	i = new Integer(st.nextToken().trim()).intValue();
		String name = st.nextToken().trim();

		/*
		 * format : I, ’OWNAME’
		 */
		if (baseCaseNet.getOwnerList() == null)
			baseCaseNet.addNewOwnerList();
		BaseRecordXmlType.OwnerList.Owner owner = baseCaseNet.getOwnerList().addNewOwner();
		owner.setId(new Integer(i).toString());
		owner.setNumber(i);
		owner.setName(name);			
	}

	public static void processXfrZTableRec(String lineStr, PsseVersion version, final PSSNetworkXmlType baseCaseNet) {
		StringTokenizer st = new StringTokenizer(lineStr, ",");
		int	i = new Integer(st.nextToken().trim()).intValue();
		double[] t = new double[11], f = new double[11];
		int cnt = 0;
		while(st.hasMoreTokens()) {
			t[cnt] = new Double(st.nextToken().trim()).doubleValue();
			f[cnt++] = new Double(st.nextToken().trim()).doubleValue();
		}

		/*
		 * format V30: I, T1, F1, T2, F2, T3, F3, ... T11, F11
		 */
		if (baseCaseNet.getXfrZTable() == null)
			baseCaseNet.addNewXfrZTable();
		XformerZTableXmlType.XformerZTableItem item = baseCaseNet.getXfrZTable().addNewXformerZTableItem();
		item.setNumber(i);
		for (int n = 0; n < cnt; n++) {
			XformerZTableXmlType.XformerZTableItem.Lookup lookup = item.addNewLookup();
			lookup.setTurnRatioShiftAngle(t[n]);
			lookup.setScaleFactor(f[n]);
		}
	}
}
