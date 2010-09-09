package org.interpss.vstab.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.linear.ArrayRealVector;
import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;

public class EquivLoadAlgorithm {
	private AclfNetwork net;
	private List<Integer> loadBusList;
	public  EquivLoadAlgorithm(AclfNetwork net,List<Integer> loadBusList){
		this.net=net;
		this.loadBusList=loadBusList;
	}
	public  void run(){
		
		 double Vmag=1,
		        v2=1,
		        b=0;
                
		 double DeltaQ=99;        
		 final double tolofDQ =0.001;
		             
		 int size=loadBusList.size();
		 int iteration=0;
		 final int MAX_ITERATION=15;
		 
		 ArrayRealVector deltaQ=new ArrayRealVector(size),
		        Qcal=new ArrayRealVector(size),
		        Qset=new ArrayRealVector(size),
		        vPQ =new ArrayRealVector(size),
		         Beq=new ArrayRealVector(size);
		 List<Complex> shuntYList=getShuntYList ();
		 
		 LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
		 algo.setLfMethod(AclfMethod.NR);//NR_STEP
		 algo.setMaxIterations(10);
		 algo.setInitBusVoltage(false);
		 int id =0;
		 for (int idx:loadBusList) {
              // print(" bus id "+idx+1);
			 AclfBus aclfBus=(AclfBus) net.getBusList().get(idx); 
			        Complex c = shuntYList.get(idx);
//			        print(" shunt b0 = "+c.getImaginary());
			        Vmag=aclfBus.getVoltageMag();
			        //vPQ.set(id, 0, Vmag);
			        v2= Vmag * Vmag;
//			        print(" v = "+Vmag+" \nv2= "+v2);
			        double q=aclfBus.getLoadQ();
			        Qset.setEntry(id, q);
			     // calculate equiv B
			        b = q/ v2;
			        Beq.setEntry(id,  b);
//			        print(" b = "+b);
			        // add B to the bus shunt Y
			        c = c.add(new Complex(0.0, -b));
			        // change load code to custom load again
			        aclfBus.setShuntY(c);
			        aclfBus.setLoadQ(0);
			        id++;
			            
			   }
	 do{
		 algo.loadflow();		     
	     id=0;
		 for (int idx1:loadBusList) {
              // print(" bus id "+idx+1);
			 AclfBus acbus=(AclfBus) net.getBusList().get(idx1);
			      // we switch constant P load to custom load implementation  
			         Complex c = shuntYList.get(idx1);
			        // calculate equiv B
			        Vmag=acbus.getVoltageMag();
			        vPQ.setEntry(id,  Vmag);
			        v2= Vmag * Vmag;
//			        print(" v = "+acbus.getVoltageMag()+"v2= "+v2);
			        b=Beq.getEntry(id);
			        double cal_q =v2*b;
			        Qcal.setEntry(id,  cal_q);
//			        delta_q=Qset.get(id, 0)-cal_q;
//			        deltaQ.set(id, 0, delta_q);
			        b=Qset.getEntry(id)/v2;
//			        print(" next b = "+b);
			        Beq.setEntry(id, b);
			        // add B to the bus shunt Y
			        c = c.add(new Complex(0.0, -b));
			        // change load code to custom load again
			        acbus.setShuntY(c);
			        id++;
			  
		 } 
		 
		     
		    deltaQ=Qset.subtract(Qcal);
	        DeltaQ=deltaQ.getLInfNorm();
	     
	        System.out.println("DeltaQ = "+DeltaQ);
		    iteration++;
		    
	      if((!net.isLfConverged())||(DeltaQ>tolofDQ && iteration>MAX_ITERATION-1)){
				 net.setLfConverged(false); 
				 System.out.println("load flow by Beq not converged");
				 break;
		  }
	      else if(DeltaQ<tolofDQ ){//
		  System.out.println("load flow by Beq converged with-- "
				  +iteration +"-- iteration");                           
		  net.setLfConverged(true);
		  break;
		  } 

	 }while(iteration<=MAX_ITERATION); // end of while
		 	
	}


	private List<Complex> getShuntYList(){
		List<Complex> shuntYList=new ArrayList<Complex> ();
		for(int idx :this.loadBusList){
			AclfBus acbus=(AclfBus)this.net.getBusList().get(idx);
			shuntYList.add(acbus.getShuntY());
		}
		return shuntYList;
		
	}

}
