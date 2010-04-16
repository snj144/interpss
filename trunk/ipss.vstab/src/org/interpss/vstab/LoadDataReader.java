package org.interpss.vstab;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.pes.odm.pss.model.ODMModelParser;
import org.apache.commons.math.linear.*;

import com.interpss.common.datatype.UnitType;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.common.IAclfBusVisitor;

public class LoadDataReader extends DataReader {
	public LoadDataReader(AclfNetwork acNet) {
		super(acNet);
	}
	public LoadDataReader(ODMModelParser parser){
		super(parser);
	}
	protected HashMap<Integer,Double> constPLoad0;
	protected HashMap<Integer,Double> constQLoad0;
//	private RealVector incLoadP0=null;
//	private RealVector incLoadQ0=null;
	private BusRecordXmlType[] busArray;
	private BusRecordXmlType bus;
	private AclfBus acBus;
	private double loadP;
	private double loadQ;
	protected static int numOfActiveLoad=0;
	private void readLoadFromODM(){
		
		this.baseCaseNetwork=parser.getBaseCase();
		busArray=baseCaseNetwork.getBusList().getBusArray();
		
		this.constPLoad0=new HashMap<Integer,Double>(busArray.length);
		this.constQLoad0=new HashMap<Integer,Double>(busArray.length);
//		this.parser=new DataConverter().getParser();
		
		this.baseMvar=this.baseCaseNetwork.getBasePower().getValue();
		for(int i=0;i<busArray.length;i++){
			bus=busArray[i];
			if(bus.getLoadflowData().getLoadData()!=null){
				loadP=bus.getLoadflowData().getLoadData().getEquivLoad()
				.getConstPLoad().getRe();
				loadQ=bus.getLoadflowData().getLoadData().getEquivLoad()
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
	public void readLoadFromNet(){
		
		this.constPLoad0=new HashMap<Integer,Double>(this.net.getNoActiveBus());
		this.constQLoad0=new HashMap<Integer,Double>(this.net.getNoActiveBus());
		
		for(int i=0;i<this.net.getNoActiveBus();i++){
			acBus=(AclfBus) net.getBusList().get(i);
			if(acBus.isConstPLoad()){//only consider constant load now ;
				loadP=acBus.getLoadP();
				loadQ=acBus.getLoadQ();
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
	public static int getNumOfActiveLoad(AclfNetwork net){
		numOfActiveLoad=0;
		try{
		Iterator busIt=net.getBusList().iterator();
		AclfBus bus=(AclfBus) busIt.next();
		if(bus.isActive()&&bus.isLoad()){
			numOfActiveLoad++;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfActiveLoad;
	}

}
