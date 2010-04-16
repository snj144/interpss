package org.interpss.vstab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFGenCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFGenCodeEnumType.Enum;
import org.ieee.pes.odm.pss.model.ODMModelParser;

public class GenDataReader extends DataReader {
//	private ODMModelParser parser;
//	protected PSSNetworkXmlType baseCaseNetwork;
	protected HashMap<Integer,Double> genPmax;
	protected HashMap<Integer,Double> genP0;
	protected final double DEFAULT_BASE_MVAR =100;
	protected double baseMvar=DEFAULT_BASE_MVAR;
	protected int numofGen=0;
	private final double DEFAULT_GENP_MAX=9999;
	protected List<Integer> genBusList=new ArrayList<Integer>();
	protected BusRecordXmlType[] busArray;
	private BusRecordXmlType bus;
	
	
	public HashMap<Integer,Double> getGenPmax(){
		getGenData();
		this.numofGen=this.getNumofGen();
		this.baseMvar=this.baseCaseNetwork.getBasePower().getValue();
		busArray=baseCaseNetwork.getBusList().getBusArray();
		this.genPmax=new HashMap<Integer, Double>(this.numofGen);
		int j=0;
		for(int busIndex=0;busIndex<this.numofGen;busIndex++){
			int genBusIdx=this.getGenBusList().get(busIndex);
			bus=busArray[genBusIdx];
			double pmax=(bus.getLoadflowData().getGenData().getEquivGen()
					.getPLimit()!= null)?bus.getLoadflowData().getGenData().getEquivGen()
			.getPLimit().getMax():DEFAULT_GENP_MAX;
		    pmax/=this.baseMvar;
			genPmax.put(genBusIdx, pmax);
			j++;
	        }
	   
		return genPmax;
	}

	public void getGenData(){
		this.baseCaseNetwork=this.parser.getBaseCase();
		busArray=baseCaseNetwork.getBusList().getBusArray();
		this.numofGen=0;
//		System.out.println("get num of gen");
		for(int i=0;i<busArray.length;i++){
			bus=busArray[i];
			System.out.print("i="+i);
			// 如果XML里面没有Gen的信息，将会出错；
			if(bus.getLoadflowData()!=null)
			  if(bus.getLoadflowData().getGenData()!=null){
				  Enum type =bus.getLoadflowData().getGenData().getEquivGen().getCode();
			    if(type.equals(LFGenCodeEnumType.PV)){//  ||type.equals(LFGenCodeEnumType.PQ) PQ generator ;
				   double genp0=bus.getLoadflowData().getGenData().getEquivGen().getPower().getRe();
			       this.numofGen++;
				   this.genBusList.add(i);
				   this.genP0.put(i, genp0);
				   
			    }
			}
			
		}
		
	}
	public int getNumofGen(){
		return this.numofGen;
	}
	public List<Integer> getGenBusList(){
		return this.genBusList;
	}
	public HashMap<Integer,Double> getGenP0(){
		getGenData();
		return this.genP0;
	}
	public void setODMParser(ODMModelParser parser){
		this.parser=parser;
	}
	public GenDataReader(ODMModelParser parser){
		super(parser);
	}
	
	
}
