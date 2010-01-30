package org.interpss.vstab;


import java.util.HashMap;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.pes.odm.pss.model.ODMModelParser;



public class DataReader {
	protected ODMModelParser parser;
	protected PSSNetworkXmlType baseCaseNetwork;
	protected HashMap<Integer,Double> genPmax;

	protected double baseMvar;
	public void setODMParser(ODMModelParser parser){
		this.parser=parser;
	}
//	public DataReader(ODMModelParser parser){
//		this.parser=parser;
//		this.baseCaseNetwork=this.parser.getBaseCase();
//	}
	
	

}
