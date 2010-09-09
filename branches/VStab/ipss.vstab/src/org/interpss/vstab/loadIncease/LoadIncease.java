package org.interpss.vstab.loadIncease;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math.linear.RealVector;
import com.interpss.core.aclf.AclfNetwork;
// ¿¼ÂÇ DataReader ,GenDispatch ,LoadIncrease have a super class
// named Data ;
// loadP0 loadQ0;genPmax, genP0; net;
public class LoadIncease { 
    // connect to loadIncPatten , to get how the net is to be Inceased  
    protected static RealVector LoadP0;
    protected static RealVector incLoadP;
    protected static RealVector LoadQ0;
    protected static RealVector incLoadQ;
    protected static RealVector dirP;
    protected static RealVector dirQ;
    protected static double loadIncIndex;
    protected static AclfNetwork net;
    
    protected static List<Integer> incLoadBusList = new ArrayList<Integer>();
    protected static List<Integer> incZoneList = new ArrayList<Integer>();
    protected static List<Integer> incOwnerList = new ArrayList<Integer>();
    
    protected static HashMap<Integer,Double> loadPMap = new HashMap<Integer,Double> ();
    protected static HashMap<Integer,Double> loadQMap = new HashMap<Integer,Double> ();
    
    public static LoadIncCode incPatten;
    
    public LoadIncease(AclfNetwork net, List<Integer> incLoadBusList,Double newLoadIncIndex){
    	LoadIncease.net=net;
    	LoadIncease.incLoadBusList=incLoadBusList;
    	LoadIncease.loadIncIndex=newLoadIncIndex;
    }
	public static void incLoad(){
		
		// P=P0+Lambda* dirp ;
		incLoadP=LoadP0.add((dirP.mapMultiply(loadIncIndex)));
		// Q=Q0+Lambda*dirQ;
	   incLoadQ=LoadQ0.add((dirQ.mapMultiply(loadIncIndex)));
		// save the P Q to the net ;
		
		//return 
		
	}
	/**
	 * increase load with original power factor by "newLambda" times
	 * @param newLambda
	 */
	public static void incLoad(double newLambda){
		incLoadP.mapMultiplyToSelf(newLambda);
		incLoadQ.mapMultiplyToSelf(newLambda);
	}
	/**
	 * 
	 * @param incDir_P
	 * @param incDir_Q
	 * @param incLength
	 */
	public static void incLoad(RealVector incDir_P,RealVector incDir_Q,double incLength){
		dirP=incDir_P;
		dirQ=incDir_Q;
		loadIncIndex=incLength;
		incLoad(); // call incLoad to increase LOAD ;
	}
    public static int[] List2Array(List<Integer> L){
        int length =L.size();
        int[] temp =new int[length];
       // temp=new int[length];
        Iterator<Integer> iter =L.iterator();
        int i =0;
        while(iter.hasNext()){
     	temp[i]=iter.next();
     	i++;
        }
        return temp;
     }
	public void setDirPQ(RealVector newDir_P,RealVector newDir_Q){
		// set dirp ,dirq
		LoadIncease.dirP=newDir_P;
		LoadIncease.dirQ=newDir_P;
	}
	public void setDirP (RealVector newDir_P){
		LoadIncease.dirP=newDir_P;
	}
	public RealVector getLoadP0(){
		return LoadIncease.LoadP0;
	}
	public void setLoadP0(RealVector LoadP0){
		LoadIncease.LoadP0=LoadP0;
	}
	public RealVector getLoadQ0(){
		return LoadIncease.LoadQ0;
	}
	public void setLoadQ0(RealVector LoadQ0){
		LoadIncease.LoadP0=LoadQ0;
	}
	public RealVector getIncLoadP(){
		return incLoadP;
	}
	public RealVector getIncLoadQ(){
		return incLoadQ;
	}
	public double getSumOfIncLoadP() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
