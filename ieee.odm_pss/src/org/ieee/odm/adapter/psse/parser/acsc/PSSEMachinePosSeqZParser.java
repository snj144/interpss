package org.ieee.odm.adapter.psse.parser.acsc;

import java.util.StringTokenizer;

import org.ieee.odm.adapter.psse.BasePSSEAdapter.PsseVersion;
import org.ieee.odm.adapter.psse.parser.aclf.BasePSSEDataParser;
import org.ieee.odm.common.ODMException;

public class PSSEMachinePosSeqZParser extends BasePSSEDataParser {
	public PSSEMachinePosSeqZParser(PsseVersion ver) {
		super(ver);
	}
	
	@Override public String[] getMetadata() {
		
	/*
	 * PSS/E ver. 30-32 machine positive sequence data in pu on machine base
	 * And ZPOS is not necessarily the same as the generator impedance ZSORCE
	 * Once it is enter, it will used in switching studies and dynamic simulation
	 * 
	 * Format 
	 * I, ID, ZRPOS, ZXPOS
	 * 
	 */
		return new String[] {
				   //  0----------1----------2----------3
					 "I",        "ID",  "ZRPOS", "ZXPOS"            
				};	
		
	}
	
	@Override 
	public void parseFields(final String lineStr) throws ODMException {
		this.clearNVPairTableData();
		StringTokenizer st = new StringTokenizer(lineStr,",");
		for (int i = 0; i < 4; i++)
			setValue(i, st.nextToken().trim());
	}
   
}
