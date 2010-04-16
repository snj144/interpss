package org.interpss.vstab;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.RealVector;

import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;

public class LoadIncPattenImpl implements LoadIncPatten {
//	LoadIncCode ldIncCode ;
    protected  RealVector dirP;
    protected  RealVector dirQ;
    
	public   void incLoadByBus(AclfNetwork net,final List<Integer> incLoadBusList){
		/*
		 * 1. get the to-be-increased load bus index from input ;
		 * 3. return the incLoadBusList ;
		 */
	    dirP=new ArrayRealVector();
		int idx=0;
		for(int i:incLoadBusList){
				  
				 if(){
					 incLoadBusList.add(i);
				 }
				 else{
					 System.out.println("The input bus index-"+ i +"-is not corresponding to a Load Bus!\n" +
					 		" Will not be added to the incLoadBusList.");
				 }
			  }
		
	}	
	/*
	 * IncreaseByZone--> a zone limit by the assigned zoneNumber ;
	 */
	
    public void incLoadByZone(AclfNetwork net,List<Integer> zoneNumber){
    	
    /*
     *  get the list by BusID of the buses belonging to "Zone¡°, use the first IncreaseSpecLoad() method 
     */
    	
    int j=0;
    for(Bus bus:net.getBusList()){
    	AclfBus acbus=(AclfBus) bus;
        for(int  i:zoneNumber){
    	  if(bus.getZone().getNumber()==i&& acbus.isLoad() ) incLoadBusList.add(j);
        }
        j++;
    }
   
    }
    /*
     * IncreaseAllNet -->only increase the Constant P load without a Gen ,Like genPV, genPQ,or even Swing
     */
    public void incLoadByNet() throws IOException, Exception{  // all load bus increase ;
          Iterator<Entry<Integer, Double>> it =loadPMap.entrySet().iterator();
          while(it.hasNext()){
        	  Map.Entry<Integer, Double> entry =(Map.Entry<Integer,Double>)it.next();
        	  incLoadBusList.add(entry.getKey());
          }

          
	}
}
