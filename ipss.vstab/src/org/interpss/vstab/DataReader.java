package org.interpss.vstab;


import java.util.HashMap;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.pes.odm.pss.model.ODMModelParser;

import com.interpss.core.aclf.AclfNetwork;



public class DataReader {
	protected ODMModelParser parser;
	protected PSSNetworkXmlType baseCaseNetwork;
	protected HashMap<Integer,Double> genPmax;
    protected AclfNetwork net;
	protected double baseMvar;
	public void setODMParser(ODMModelParser parser){
		this.parser=parser;
	}
	public double getBaseMvar(){
		return baseMvar;
	}
	
	public DataReader(ODMModelParser parser){
		this.parser=parser;
		this.baseCaseNetwork=this.parser.getBaseCase();
		baseMvar=this.parser.getBaseCase().getBasePower().getValue();
	}
	public DataReader(AclfNetwork acNet){
		this.net=acNet;
		this.baseMvar=acNet.getBaseKva()/100.0;
	}
	

}
