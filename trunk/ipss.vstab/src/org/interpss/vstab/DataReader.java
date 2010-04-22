package org.interpss.vstab;


import java.util.HashMap;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.*;
import org.ieee.odm.model.ODMModelParser;
import org.ieee.odm.model.JaxbODMModelParser;
import org.ieee.odm.schema.PSSNetworkXmlType;

import com.interpss.core.aclf.AclfNetwork;



public class DataReader {
	protected JaxbODMModelParser jODMParser;
	protected ODMModelParser odmParser;
	protected PSSNetworkXmlType baseCaseNetwork;
	protected HashMap<Integer,Double> genPmax;
    protected AclfNetwork net;
	protected double baseMvar;
	public void setODMParser(ODMModelParser parser){
		this.odmParser=parser;
	}
	public double getBaseMvar(){
		return baseMvar;
	}
	
	public DataReader(ODMModelParser parser){
		this.odmParser=parser;
		this.baseCaseNetwork=this.jODMParser.getBaseCase();
		baseMvar=this.jODMParser.getBaseCase().getBasePower().getValue();
	}
	public DataReader(AclfNetwork acNet){
		this.net=acNet;
		this.baseMvar=acNet.getBaseKva()/100.0;
	}
	

}
