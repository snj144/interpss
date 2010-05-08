package org.interpss.vstab.loadIncease.impl;

import java.util.HashMap;
import java.util.List;
import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.RealVector;
import org.interpss.vstab.loadIncease.LoadIncPatten;
import org.interpss.vstab.data.LoadDataReader;

import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;

public class LoadIncPattenImpl implements LoadIncPatten {
//	LoadIncCode ldIncCode ;
    protected  RealVector dirP;
    protected  RealVector dirQ;
    protected LoadDataReader ldr;
    private List<Integer> incLoadList;
    private AclfNetwork objnet;
    
    public LoadIncPattenImpl(AclfNetwork net){
    	this.objnet=net;
    	this.ldr=new LoadDataReader(objnet);
    }
	public   void incLoadByBus(final List<Integer> incLoadBusList){
		/*
		 * 1. get the to-be-increased load bus index from input ;
		 * 3. return the incLoadBusList ;
		 */
		try{
		ldr=new LoadDataReader(objnet);
		int numOfActiveLoad =ldr.getNumOfActiveLoad();
		HashMap<Integer ,Double> hmLoadP=ldr.getHMPLoad0();
		HashMap<Integer ,Double> hmLoadQ=ldr.getHMQLoad0();
		dirP=new ArrayRealVector(numOfActiveLoad,0);
		dirQ=new ArrayRealVector(numOfActiveLoad,0);
		  for(int i:incLoadBusList){
				  if(hmLoadP.get(i)!=null) {
					  dirP.setEntry(i, hmLoadP.get(i));
					  dirQ.setEntry(i, hmLoadQ.get(i)); 
				 }
				 else{
					 System.out.println("The input bus index-"+ i +"-is not corresponding to a Load Bus!\n" );
					 		
				 }
			  }
		  }catch(Exception e){
			e.printStackTrace();
		}
		
	}	
	/*
	 * IncreaseByZone--> a zone limit by the assigned zoneNumber ;
	 */
	
    public void incLoadByZone(List<Integer> zoneNumber){
    	
    /*
     *  get the list by BusID of the buses belonging to "Zone¡°, use the first IncreaseSpecLoad() method 
     */
    	
    int j=0;
    try{
    for(Bus bus:objnet.getBusList()){
    	AclfBus acbus=(AclfBus) bus;
        for(int  i:zoneNumber){
    	  if(bus.getZone().getNumber()==i&& acbus.isLoad() ) incLoadList.add(j);
        }
        j++;
    }
    }catch(Exception e){
    	e.printStackTrace();
    }
    incLoadByBus(incLoadList);
    }
    /*
     * IncreaseAllNet -->only increase the Constant P load without a Gen ,Like genPV, genPQ,or even Swing
     */


	public void incLoadByNet() {
		dirP=ldr.getPLoad0();
		dirQ=ldr.getQLoad0();
  
	}
}
