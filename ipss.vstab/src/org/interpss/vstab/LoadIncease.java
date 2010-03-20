package org.interpss.vstab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Jama.Matrix;

import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;
// ¿¼ÂÇ DataReader ,GenDispatch ,LoadIncrease have a super class
// named Data ;
// loadP0 loadQ0;genPmax, genP0; net;
public class LoadIncease { 
    // connect to loadIncPatten , to get how the net is to be Inceased  
    private Matrix LoadP0;
    private Matrix incLoadP;
    private Matrix LoadQ0;
    private Matrix incLoadQ;
    private Matrix dirP;
    private Matrix dirQ;
    private double lambda;
    private AclfNetwork net;
    private  List<Integer> incLoadBusList = new ArrayList<Integer>();
    private  HashMap<Integer,Double> loadBusMap = new HashMap<Integer,Double> ();
    public LoadIncease(AclfNetwork net, List<Integer> incLoadBusList,Double lambda){
    	this.net=net;
    	this.incLoadBusList=incLoadBusList;
    	this.lambda=lambda;
    }
	public void incLoad(){
		
		// P=P0+Lambda* dirp ;
		this.incLoadP=this.LoadP0.plus(this.dirP.times(this.lambda));
		// Q=Q0+Lambda*dirQ;
		this.incLoadQ=this.LoadQ0.plus(this.dirQ.times(this.lambda));
		// save the P Q to the net ;
		
		//return 
		
	}
	public void initIncDirection(){
		int NumOfLoadBus =this.getLoadP0().getRowDimension();
		Matrix dirpq =new Matrix(2*NumOfLoadBus,1); //  m should be (NumofBusX2)
		dirpq.setMatrix(0, NumOfLoadBus-1, 0, 0,this.getLoadP0());
		dirpq.setMatrix(NumOfLoadBus, 2*NumOfLoadBus-1, 0, 0,this.getLoadQ0());
		dirpq.times(1/dirpq.normF());
		this.dirP =dirpq.getMatrix(0, NumOfLoadBus-1, 0, 0);
		this.dirQ =dirpq.getMatrix(NumOfLoadBus, 2*NumOfLoadBus-1, 0, 0);
	}
	public void setPQDirection(Matrix dirp,Matrix dirq){
		// set dirp ,dirq
		this.dirP=dirp;
		this.dirQ=dirp;
	}
	public void setPDirection (Matrix dirp){
		this.dirP=dirp;
	}
	public Matrix getLoadP0(){
		return this.LoadP0;
	}
	public void setLoadP0(Matrix originLoadP){
		this.LoadP0=originLoadP;
	}
	public Matrix getLoadQ0(){
		return this.LoadQ0;
	}
	public void setLoadQ0(Matrix originLoadQ){
		this.LoadP0=originLoadQ;
	}
	public Matrix getIncLoadP(){
		incLoad();
		return incLoadP;
	}
	public Matrix getIncLoadQ(){
		incLoad();
		return incLoadQ;
	}
	
	public double getSumOfIncLoadP(){
		return new MatrixCalc().sumOfElement(incLoadP);
	}

	
	public  List<Integer> IncreaseSpecLoads(final int[] LoadBusIdx) throws IOException, Exception{
		/*
		 * 1. get the to-be-increased load bus index from input ;
		 * 2. compare it with the load data got from ODM ;
		 * 3. return the incLoadBusList ;
		 */
	    int idx=0;
		for(int i:LoadBusIdx){
				  
				 if(loadBusMap.get(i)!=null){
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
          Iterator<Entry<Integer, Double>> it =loadBusMap.entrySet().iterator();
          while(it.hasNext()){
        	  Map.Entry<Integer, Double> entry =(Map.Entry<Integer,Double>)it.next();
        	  incLoadBusList.add(entry.getKey());
          }
          return this.incLoadBusList;
          
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
