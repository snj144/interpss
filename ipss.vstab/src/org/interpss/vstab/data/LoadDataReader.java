package org.interpss.vstab.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.odm.model.ODMModelParser;
import org.interpss.vstab.data.DataReader;
import org.apache.commons.math.linear.*;

import com.interpss.common.datatype.UnitType;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.common.IAclfBusVisitor;

public class LoadDataReader extends DataReader {

	protected HashMap<Integer,Double> hmPLoad0;
	protected HashMap<Integer,Double> hmQLoad0;
	protected RealVector rvPLoad0;
	protected RealVector rvQLoad0;
	
//	private RealVector incLoadP0=null;
//	private RealVector incLoadQ0=null;
	private BusRecordXmlType[] busArray;
	private BusRecordXmlType bus;
	private AclfBus acBus;
	private double loadP;
	private double loadQ;
	protected static int numOfActiveLoad=0;
	
	public LoadDataReader(AclfNetwork acNet) {
		super(acNet);
		readLoadFromNet();
		
	}
	public LoadDataReader(ODMModelParser parser){
		super(parser);
		readLoadFromODM();
	}
	private void readLoadFromODM(){
		
		this.baseCaseNetwork=this.jODMParser.getBaseCase();
		busArray=baseCaseNetwork.getBusList().getBusArray();
		
		this.hmPLoad0=new HashMap<Integer,Double>(busArray.length);
		this.hmQLoad0=new HashMap<Integer,Double>(busArray.length);
		this.rvPLoad0=new ArrayRealVector(this.getNumOfActiveLoad());
		this.rvQLoad0=new ArrayRealVector(this.getNumOfActiveLoad());
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
				hmPLoad0.put(i, loadP);
				hmQLoad0.put(i, loadQ);
			}
		}	
	}
	public void readLoadFromNet(){
		
		this.hmPLoad0=new HashMap<Integer,Double>(this.net.getNoActiveBus());
		this.hmQLoad0=new HashMap<Integer,Double>(this.net.getNoActiveBus());
		int j=0;
		for(int i=0;i<this.net.getNoActiveBus();i++){
			acBus=(AclfBus) net.getBusList().get(i);
			if(acBus.isConstPLoad()){//only consider constant load now ;
				loadP=acBus.getLoadP();
				loadQ=acBus.getLoadQ();
				hmPLoad0.put(i, loadP);
				hmQLoad0.put(i, loadQ);
			    rvPLoad0.setEntry(j,loadP);
			    rvQLoad0.setEntry(j,loadQ);
			    j++;
			}
			
		}
	}
	public HashMap<Integer, Double> getHMPLoad0(){
		return this.hmPLoad0;
	}
	public HashMap<Integer, Double> getHMQLoad0(){
		return this.hmQLoad0;
	}
	public RealVector getPLoad0(){
		return this.rvPLoad0;
	}
	public RealVector getQLoad0(){
		return this.rvQLoad0;
	}
	public  int getNumOfActiveLoad(){
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
