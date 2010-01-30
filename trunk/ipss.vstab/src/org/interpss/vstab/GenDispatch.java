package org.interpss.vstab;

import java.util.HashMap;

import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;

import Jama.Matrix;
public class GenDispatch {

    private int numofGen;
    private double baseMvar;
    private HashMap<Integer,Double> genPmax; //=new Matrix(numofGen,2);
    private HashMap<Integer,Double> genP0;
    private AclfNetwork net;

    
	public  void genDispatch(AclfNetwork net,double sumofPinc)  {
		/*
		 * 1.run power flow first,get the result ,here the gen P AND Q are needed
		 * 2.get the gen power reserve  .
		 * 3.generation dispatch according to the proportion of gen RESERVE of each gen.
		 */
		System.out.println("-- starting gen dispatch-- ");
//		PQmax.print(2, 3);
		double sumofDgenP=0;
		Matrix DgenP=new Matrix(numofGen,1);
		//Matrix DgenQ=new Matrix(numofGen,1);                                                   
		AclfBus objbus =null ;
		int j=0;
		for(int i:this.genPmax.keySet()){
	    	 objbus =(AclfBus) net.getBusList().get(i);
	    	  // System.out.println(objbus.getId());
	    	  // System.out.println("pmax="+PQmax.get(i, 0)+"  genP="+objbus.getGenP());
			    double deltaP=genPmax.get(i)-objbus.getGenP();
		        if (deltaP<=0){
		            objbus.setGenP(genPmax.get(i));  
		            DgenP.set(j, 0, 0);
		        }
		        else {DgenP.set(j, 0, deltaP) ;}
		        j++;
		   
	     }  
      
		sumofDgenP=new MatrixCalc().sumOfElement(DgenP);
		j=0;
		for(int i:this.genPmax.keySet()){
			objbus =(AclfBus) net.getBusList().get(i);
	        	double DPi=DgenP.get(j, 0)/sumofDgenP*sumofPinc;
	        	//System.out.println("DP="+DP+" DP "+i+" ="+DPi);
	        	//System.out.println(GenP0.get(i, 0));
	        	if (DgenP.get(j, 0)>0) { objbus.setGenP(genP0.get(i)+DPi);}
	        	j++;
	        
	     }
		System.out.println("--end gen dispatch--");
//		return net;
   }


	public GenDispatch(AclfNetwork net,HashMap<Integer,Double> genP0,HashMap<Integer,Double> genPmax) {
		this.genP0=genP0;
		this.genPmax=genPmax;
		this.net =net;
	}
}
