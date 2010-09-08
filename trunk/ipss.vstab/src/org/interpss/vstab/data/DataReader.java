package org.interpss.vstab.data;


import java.util.HashMap;

import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.model.jaxb.JaxbODMModelParser;
import org.ieee.odm.schema.LoadflowNetXmlType;

import com.interpss.core.aclf.AclfNetwork;



public class DataReader {
	protected JaxbODMModelParser jODMParser;
	protected AclfModelParser odmParser;
	protected LoadflowNetXmlType baseCaseNetwork;
	protected HashMap<Integer,Double> genPmax;
    protected AclfNetwork net;
	protected double baseMvar;
	public void setODMParser(AclfModelParser parser){
		this.odmParser=parser;
	}
	public double getBaseMvar(){
		return baseMvar;
	}
	
	public DataReader(AclfModelParser parser){
		this.odmParser=parser;
		this.baseCaseNetwork=this.jODMParser.getAclfBaseCase();
		baseMvar=this.jODMParser.getAclfBaseCase().getBasePower().getValue();
	}
	public DataReader(AclfNetwork acNet){
		this.net=acNet;
		this.baseMvar=acNet.getBaseKva()/100.0;
	}
	

}
