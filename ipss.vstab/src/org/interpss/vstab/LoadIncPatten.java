package org.interpss.vstab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap.*;
import java.util.Map.Entry;

import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;

import Jama.Matrix;
import edu.scut.ClosestLimit;

public class LoadIncPatten {
    // Enum specLoads , specZones, wholeNet
	private   int NumberofloadBus=0;
	private  HashMap<Integer,Double> loadBusHM = new HashMap<Integer,Double> ();
	private  List<Integer> incLoadBusList = new ArrayList<Integer>();

	
	public  List<Integer> IncreaseSpecLoads(final int[] LoadBusIdx) throws IOException, Exception{
		/*
		 * 1. get the to-be-increased load bus index from input ;
		 * 2. compare it with the load data got from ODM ;
		 * 3. return the incLoadBusList ;
		 */
	    int idx=0;
		for(int i:LoadBusIdx){
				  
				 if(loadBusHM.get(i)!=null){
					 incLoadBusList.add(i);
				 }
				 else{
					 System.out.println("The input bus index-"+ i +"-is not corresponding to a Load Bus!\n" +
					 		" Will not be added to the incLoadBusList.");
				 }
			  }
         return incLoadBusList;
		
	}	
	/*
	 * IncreaseByZone--> a zone limit by the assigned zoneNumber ;
	 */
	
    public List<Integer> IncreaseSpecZones(AclfNetwork net,int[] zoneNumber){
    	
    /*
     *  get the list by BusID of the buses belonging to "Zone¡°, use the first IncreaseSpecLoad() method 
     */
    int j=0;
    for(Bus bus:net.getBusList()){
        for(int  i:zoneNumber){
    	if(bus.getZone().getNumber()==i) incLoadBusList.add(j);
        }
        j++;
    }
    return incLoadBusList;
    }
    /*
     * IncreaseAllNet -->only increase the Constant P load without a Gen ,Like genPV, genPQ,or even Swing
     */
    public  List<Integer> IncreaseNet() throws IOException, Exception{  // all load bus increase ;
          Iterator<Entry<Integer, Double>> it =loadBusHM.entrySet().iterator();
          while(it.hasNext()){
        	  Map.Entry<Integer, Double> entry =(Map.Entry<Integer,Double>)it.next();
        	  incLoadBusList.add(entry.getKey());
          }
          return this.incLoadBusList;
          
	}
    
    public static Matrix[] getNorm(Matrix dirp, Matrix dirq){
		/*
		 * normalization ---two steps
		 * 1. Normalization each bus load p and q ,eg. (0.8 ,0.6)
		 * 2. Normalization all the Matrix made by normalized all load bus p and q ;
		 */
    	int Numofbus =dirp.getRowDimension();
		Matrix dirpq =new Matrix(2*Numofbus,1); //  m should be (NumofBusX2)
		dirpq.setMatrix(0, Numofbus-1, 0, 0,dirp);
		dirpq.setMatrix(Numofbus, 2*Numofbus-1, 0, 0,dirq);
		dirpq.arrayTimesEquals(new Matrix(2*Numofbus,1,1/dirpq.normF()));
		dirp =dirpq.getMatrix(0, Numofbus-1, 0, 0);
		dirq =dirpq.getMatrix(Numofbus, 2*Numofbus-1, 0, 0);
		Matrix[] pq =new Matrix[2];
		pq[0]=dirp;
		pq[1]=dirq;
		return pq;
	
    }
    public static int[] List2Array(List<Integer> L){
       int length =L.size();
       int[] temp =new int[length];
      // temp=new int[length];
       Iterator<Integer> iter =L.iterator();
       int i =0;
       while(iter.hasNext()){
    	temp[i]=(int)iter.next();
    	i++;
       }
       return temp;
    }

}
