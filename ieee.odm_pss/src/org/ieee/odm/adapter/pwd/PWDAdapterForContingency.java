package org.ieee.odm.adapter.pwd;

import java.util.ArrayList;
import java.util.List;

import org.ieee.odm.adapter.AbstractODMAdapter;
import org.ieee.odm.adapter.IFileReader;
import org.ieee.odm.adapter.pwd.PowerWorldAdapter.NVPair;
import org.ieee.odm.adapter.pwd.impl.ContingencyDataProcessor;
import org.ieee.odm.adapter.pwd.impl.PWDHelper;
import org.ieee.odm.common.ODMLogger;
import org.ieee.odm.model.IODMModelParser;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.model.modify.NetModificationHelper;
import org.ieee.odm.schema.BranchChangeRecSetXmlType;
import org.ieee.odm.schema.BranchChangeRecXmlType;
import org.ieee.odm.schema.NetModificationXmlType;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
 /**
  * PWD contingency data adapter
  * 
  * @version 0.1  09/01/2012
  * @author Tony Huang
  * 
  */
public class PWDAdapterForContingency extends AbstractODMAdapter{
	public enum ContingencyType{BRANCH,SERIES_CAPACITOR,DC_LINE_CHANGE,DC_LINE_SETPOINT,PHSXFR_SETPOINT,THREEW_XFR};
	
	private List<NVPair> inputNvPairs;
	private enum RecType{CONTINGENCY,CTG_OPTIONS,GLOBALCONTINGENCYACTIONS,UNSUPPORTED};
	
	
	public PWDAdapterForContingency(){
		super();
		this.inputNvPairs = new ArrayList<NVPair>();
	}
	
	
	
	@Override
	protected IODMModelParser parseInputFile(IFileReader din, String encoding) {
		String str=""; 
		final String CONTINGENCY_Token="CONTINGENCY";
		final String CTG_OPTIONS_Token="CTG_OPTIONS";
		final String GLOBAL_CTG_ACTION_Token="GLOBALCONTINGENCYACTIONS";
		
		RecType recType=null;
		
		AclfModelParser parser=new AclfModelParser(encoding);
		parser.setLFTransInfo(OriginalDataFormatEnumType.POWER_WORLD);
		
		//create contingency data processor
		
		//TODO In fact you don't know what kind of contingency the data defined until you get the CTGElement Part
		
		/*Now we know the contingency data we got is branch status change(most changed to OPEN, some CLOSE)
		 * so we can defined the exact type  contingency processor before the processing;
		 */
		ContingencyDataProcessor ctgProc=new ContingencyDataProcessor(inputNvPairs,parser);
		

		try {
			do{
				str=din.readLine();
				if (str != null && str.startsWith("DATA")) {
					if(getDataType(str).equals(CONTINGENCY_Token)){
						recType=RecType.CONTINGENCY;
					}
					else if(getDataType(str).equals(CTG_OPTIONS_Token))
						recType=RecType.CTG_OPTIONS;
					else if(getDataType(str).equals(GLOBAL_CTG_ACTION_Token))
						recType=RecType.GLOBALCONTINGENCYACTIONS;
					else recType=RecType.UNSUPPORTED;
					
					// parse Field Names
					PWDHelper.parseFieldNames(str, inputNvPairs);
					
				} 
				else if (str.trim().startsWith("//"))
					ODMLogger.getLogger().fine("comments:" + str);
				else if (str.trim().startsWith("{"))
					ODMLogger.getLogger().info(recType.toString() + " type data begins");
				else if (str.trim().startsWith("}")) 
					ODMLogger.getLogger().info(recType.toString() + " type data ends");
				
				// start processing record data
				else if (!str.trim().isEmpty()&&recType==RecType.CONTINGENCY) {
					ctgProc.processContingencyData(str);
					
				}
				
			}while(str!=null);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	
		return parser;
	}

	
	
	@Override
	protected IODMModelParser parseInputFile(NetType type, IFileReader[] din, String encoding) {
		ODMLogger.getLogger().severe("Method not implemented");
		return null;
	}
	private String getDataType(String str){
		int indexOfLeftParenthesis=str.indexOf("(");
		int indexOfFirstComma=str.indexOf(",");
		String dataType=str.substring(indexOfLeftParenthesis+1, indexOfFirstComma).trim();
		
		return dataType;
		
	}
}
