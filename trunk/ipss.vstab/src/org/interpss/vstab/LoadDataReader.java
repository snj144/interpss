package org.interpss.vstab;

import java.util.HashMap;
import java.util.List;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;

import Jama.Matrix;

public class LoadDataReader extends DataReader {
//	protected HashMap<Integer,Double> loadP0;
//	protected HashMap<Integer,Double> loadQ0;
	private   Matrix incLoadP0=null;
	private   Matrix incLoadQ0=null;
	private BusRecordXmlType[] busArray;
	private BusRecordXmlType bus;
	
	private void getIncLoadPQ(List<Integer> busList){
		int numofBus =busList.size();
		this.incLoadP0=new Matrix(numofBus,1);
//		this.parser=new DataConverter().getParser();
		this.baseCaseNetwork=parser.getBaseCase();
		this.baseMvar=this.baseCaseNetwork.getBasePower().getValue();
		busArray=baseCaseNetwork.getBusList().getBusArray();
		for(int i=0;i<numofBus;i++){
			bus=busArray[busList.get(i)];
			double loadP=bus.getLoadflowData().getLoadData().getEquivLoad()
			.getConstPLoad().getRe()/this.baseMvar;
			double loadQ=bus.getLoadflowData().getLoadData().getEquivLoad()
			.getConstPLoad().getIm()/this.baseMvar;
			incLoadP0.set(i, 0, loadP);
			incLoadQ0.set(i, 1, loadQ);
		}
		
	}
	public Matrix getIncLoadP0(List<Integer> busList){
		getIncLoadPQ(busList);
		return this.incLoadP0;
	}
	public Matrix getIncLoadQ0(List<Integer> busList){
		getIncLoadPQ(busList);
		return this.incLoadQ0;
	}

}
