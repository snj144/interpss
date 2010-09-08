package org.interpss.vstab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.interpss.vstab.algorithm.EquivLoadAlgorithm;
import org.interpss.vstab.core.MatrixCalc;
import org.interpss.vstab.data.GenDataReader;
import org.interpss.vstab.genDispatch.GenDispatch;
import org.interpss.vstab.loadIncease.LoadIncease;

import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;


public class CriticalPoint {
	protected AclfNetwork net=null;
	protected List<Integer> loadBusList=null;
	protected AclfModelParser parser=null;
	protected RealMatrix jacobi=null;
	protected RealMatrix Jcr=null;
	protected RealVector dirP=null;
	protected RealVector dirQ=null;
	private  List<Complex> shuntY0List=new ArrayList<Complex>();
	private  List<Complex> lastConvergedVoltage=new ArrayList<Complex>();
	private final double DEFAULT_EIGVALUE=99;
	private double tolOfEigVlaue=0.001D;
	private double eigValue=DEFAULT_EIGVALUE;
	private double minEigValue=DEFAULT_EIGVALUE;
	private double lambda=0;
	private double maxLambda=99;
	private double minLambda=0;
	private final double tolOfDeltaLambda=0.0005D;
	protected double crLenghth=0;
	private double stepLength=0;
	private final double MAX_STEP_LENGTH=0.5;
	private final double MIN_STEP_LENGTH=0.005;
	private final double MAX_INTERATION=20;
	private boolean reachCritical =false;
	private boolean flagOfBisection =false;
	private int iter=0;
	
	public void calCriticalPower(AclfNetwork net,List<Integer> loadList,RealVector dirLP,RealVector dirLQ ){
		
		// 0 . initialize variants 
		
		// 1. LoadIncease(AclfNetwork net, List<Integer> incLoadBusList,Double lambda)
		//  incLoad 
		//  genDispatch 
		// 2. run  LoadEquivAlgorithm(AclfNetwork net,List<Integer> loadBusList)
		// 3. turn the load back to constP type ;
		// 4. calculate jacobi and check if the net get to the critical condition
		// 5. if step 4 get the Critical Point , finish and exit ;
		//    otherwise , cal the step length ,go back to step1 ;
		
	//-----------------------------------------------------------------------------
		// 0 . define and initialize variants 
		HashMap<Integer,Double> genP0=null;
		HashMap<Integer,Double> genPmax=null;
		double sumOfIncLoadP=0;
		
		this.net=net;
		this.loadBusList=loadList;
		this.lambda=0;
		this.dirP=dirLP;
		this.dirQ=dirLQ;
		GenDataReader genData =new GenDataReader(this.parser);
		genP0=genData.getGenP0();
		genPmax=genData.genPmax;
		
		// save shuntY0;
		saveOriginShuntY();
		
		iter=0;
		do{
		iter++;
		// 1. LoadIncease(AclfNetwork net, List<Integer> incLoadBusList,Double lambda)
		//  incLoad 
		LoadIncease loadInc=new LoadIncease(this.net, this.loadBusList,lambda);
		loadInc.incLoad();
		sumOfIncLoadP=loadInc.getSumOfIncLoadP();
		
		//  genDispatch 
		GenDispatch dispGen =new GenDispatch(net ,genP0,genPmax);
		dispGen.genDispatch(net, sumOfIncLoadP);
		
		//2.1 initialize with the last converged network condition if last step diverged;
		if(!net.isLfConverged()) initWithLastConvg();
		
		//2.2 run  LoadEquivAlgorithm(AclfNetwork net,List<Integer> loadBusList)
		EquivLoadAlgorithm algo =new EquivLoadAlgorithm(this.net,this.loadBusList);
		algo.run();
		
		if(net.isLfConverged()){ 
		//  save the net work condition
			saveNetCondition();
		
		// 3. turn the load back to constP type ;
		   turnEquivLoad2ConstP();
		
		// 4. calculate jacobi and check if the net get to the critical condition
		   if(this.isReachCritical()){
			  this.crLenghth=this.lambda;
			  this.Jcr=this.jacobi;
			  System.out.println("Already reach the critical point ! ");
			  break;
		      }
		   else { 
			  if(this.flagOfBisection==false){
				this.stepLength=getStepLength();
				this.lambda+=this.stepLength;
			  }
			  else bisectionSearch();
		   }
		}
		else{
		  System.out.println("Not converged with lambda =  "
					  +this.lambda+" !\n");
		  bisectionSearch();
		}
		
		/*
		 * 5. if step 4 get the Critical Point , finish and exit ;
		 *  otherwise , cal the step length ,go back to step1 ;
		 */
		}while(iter<this.MAX_INTERATION);
	}
		   

	private void saveNetCondition(){
		for (Bus b :this.net.getBusList()){
			AclfBus acbus= (AclfBus) b;
			this.lastConvergedVoltage.add(acbus.getVoltage());
		}
	}
	private void saveOriginShuntY(){
		 for (int idx:this.loadBusList) {
			 AclfBus   acbus=(AclfBus) net.getBusList().get(idx);
			 this.shuntY0List.add(acbus.getShuntY());
		 }
	}
	private void turnEquivLoad2ConstP(){
        for(int idx:this.loadBusList){
     	   AclfBus acbus=(AclfBus)this.net.getBusList().get(idx);   
		   acbus.setShuntY(this.shuntY0List.get(idx));
         }
	}
	private void initWithLastConvg(){
		int idx=0;
        for( Bus b : net.getBusList()) {
            AclfBus bus = (AclfBus)b;
//		      double Vmag=this.lastConvergedVoltage.get(idx).abs();
        	  Complex v=this.lastConvergedVoltage.get(idx);
            
            if ( bus.isSwing() ) {
                return ;
            }    
            else if ( bus.isGenPV() ) {
//                PVBusAdapter pv = (PVBusAdapter)bus.getAdapter(PVBusAdapter.class);
//                pv.setVoltMag(Vmag);
                bus.setVoltage(v);
            }    
            else
                bus.setVoltage(v);// 1.0, 0.0
            idx++;
        }
		
	}
	

	public boolean isReachCritical(){
		this.minEigValue=MatrixCalc.getEigValueMin(jacobi);
		// use abs(minEigValue) as a identifier for critical point;
		if (Math.abs(this.minEigValue)<this.tolOfEigVlaue) setReachCritical(true);
		else if(this.maxLambda-this.minLambda<this.tolOfDeltaLambda) setReachCritical(true);
		else setReachCritical(false);
		return this.reachCritical;
	}
	public void setReachCritical(boolean value){
		this.reachCritical=value;
	}
	private double getStepLength(){
        if(this.net.getNoActiveBus()<50) {
     	   //if (eigValueMin>-1) delta =2;
             if (minEigValue>-0.01) stepLength =0.05;
            else if (minEigValue>-0.1) stepLength =0.3;
            else if (minEigValue>-0.5) stepLength =0.5;
            //else if (eigValueMin>-0.01) delta =0.05;
            else stepLength =0.5;  
        }
        
        else if (this.net.getNoActiveBus()<200){
     	          if (minEigValue>-0.01)  stepLength =0.1;
		          else if (minEigValue>-0.05) stepLength =0.2;
		          else if (minEigValue>-0.1) stepLength =0.3;
		          else if (minEigValue>-0.5) stepLength =0.5;
		          else stepLength =this.MAX_STEP_LENGTH;
        }
       else  {//if(n>100)
     	      if (minEigValue>-0.01)  stepLength =0.1;
              else if (minEigValue>-0.05) stepLength =0.2;
              else if (minEigValue>-0.1) stepLength =0.3;
              else stepLength =this.MAX_STEP_LENGTH;
        }
        return stepLength;
	}
	private void bisectionSearch(){
 	   if(this.net.isLfConverged()&&!this.isReachCritical()){
		   minLambda=lambda;
		   minEigValue=eigValue;
	   }
	   else maxLambda=lambda; 
	   lambda=(maxLambda+minLambda)/2;
	   
	   flagOfBisection=true;
	}

}
