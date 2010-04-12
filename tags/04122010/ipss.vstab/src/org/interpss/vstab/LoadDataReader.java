package org.interpss.vstab;

import java.util.HashMap;
import java.util.List;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.apache.commons.math.linear.*;

import com.interpss.common.datatype.UnitType;

public class LoadDataReader extends DataReader {
	protected HashMap<Integer,Double> constPLoad0;
	protected HashMap<Integer,Double> constQLoad0;
//	private RealVector incLoadP0=null;
//	private RealVector incLoadQ0=null;
	private BusRecordXmlType[] busArray;
	private BusRecordXmlType bus;
	
	private void ReadLoadInfo(){
		this.baseCaseNetwork=parser.getBaseCase();
		busArray=baseCaseNetwork.getBusList().getBusArray();
		
		this.constPLoad0=new HashMap<Integer,Double>(busArray.length);
		this.constQLoad0=new HashMap<Integer,Double>(busArray.length);
//		this.parser=new DataConverter().getParser();
		
		this.baseMvar=this.baseCaseNetwork.getBasePower().getValue();
		for(int i=0;i<busArray.length;i++){
			bus=busArray[i];
			if(bus.getLoadflowData().getLoadData()!=null){
				double loadP=bus.getLoadflowData().getLoadData().getEquivLoad()
				.getConstPLoad().getRe();
				double loadQ=bus.getLoadflowData().getLoadData().getEquivLoad()
				.getConstPLoad().getIm();
				if(bus.getLoadflowData().getLoadData().getEquivLoad()
						.getConstPLoad().getUnit().equals(UnitType.mVA)){// consider the unit type 
					loadP/=super.getBaseMvar(); 
					loadQ/=super.getBaseMvar();
				}
				constPLoad0.put(i, loadP);
				constQLoad0.put(i, loadQ);
			}
		}	
	}
	public HashMap<Integer, Double> getConstPLoad(){
		return this.constPLoad0;
	}
	public HashMap<Integer, Double> getConstQLoad(){
		return this.constQLoad0;
	}

}
