package org.interpss.vstab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.math.complex.Complex;
import org.ieee.pes.odm.pss.model.ODMModelParser;
import Jama.Matrix;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Matrix_xy;

import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.JacobianMatrixType;

import com.interpss.core.net.Bus;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

import org.interpss.vstab.GenDataReader;


public class CriticalPoint {
	protected AclfNetwork net=null;
	protected List<Integer> loadBusList=null;
	protected ODMModelParser parser=null;
	protected Matrix jacobi=null;
	protected Matrix Jcr=null;
	protected Matrix dirP=null;
	protected Matrix dirQ=null;
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
	
	public void calCriticalPower(AclfNetwork net,List<Integer> loadList,Matrix dirLP,Matrix dirLQ ){
		
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
		LoadEquivAlgorithm algo =new LoadEquivAlgorithm(this.net,this.loadBusList);
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
	private Matrix getJacobiMatrix (){
		 SparseEqnMatrix2x2 sparseM = 
		        net.formJMatrix(JacobianMatrixType.FULL_POLAR_COORDINATE, SpringAppContext.getIpssMsgHub());
		 // get sortIndex
		 int[] sortNumberToMatrixIndex = new int[net.getNoBus()+1];
		 int[] sortPQNumberToMatrixIndex = new int[net.getNoBus()+1];
		 // get the number of non-swing buses and PQ buses
       int n = 0;  //non-swing
       int m = 0;  //PQ
       int mPQ=0,nPQ=0;
    for (Bus bus : net.getBusList()) {
        AclfBus aclfBus = (AclfBus)bus;
        if (!aclfBus.isSwing()) {
            sortNumberToMatrixIndex[bus.getSortNumber()] = n++;  // your matrix index range [0 ... n-1)
            if (!aclfBus.isGenPV()) {
                sortPQNumberToMatrixIndex[bus.getSortNumber()] = m++;  // PQ submatrix index range [0 ... m-1)    
            }
        }
        
    }
    //initialize of the conventional NR jacobi matrix
    
    Matrix H = new Matrix(n,n);
    Matrix N = new Matrix(n,m);
    Matrix K = new Matrix(m,n);
    Matrix L=  new Matrix(m,m);
    Matrix Jnr =new Matrix (n+m,n+m);
    
    
    //int index=0;  index for Matrix rows 
      
  for (Bus busi : net.getBusList()) {
       AclfBus aclfBusi = (AclfBus)busi;
       if (!aclfBusi.isSwing()) {
      	 
             for (Bus busj : net.getBusList()) {
                 AclfBus aclfBusj = (AclfBus)busj;
                 
                 if (!aclfBusj.isSwing()) {
        
                     int i = busi.getSortNumber();
                     int j = busj.getSortNumber();
                     Matrix_xy elem = sparseM.getElement(i, j);
              
                       
	               // the following variant is chosen like PQ bus, but it is also suitable for PV bus
	                  double dPdVang = elem.xx;
	                  double dPdVmag = elem.xy;
	                  double dQdVang = elem.yx;
	                  double dQdVmag = elem.yy;
	                   
	                    int m1 = sortNumberToMatrixIndex[i];
                       int n1 = sortNumberToMatrixIndex[j];
                  
                        if (!aclfBusi.isGenPV()) { 
                         mPQ = sortPQNumberToMatrixIndex[i]; // JUST FOR PQ sort 
                          }
                        if (!aclfBusj.isGenPV()) {
                         nPQ = sortPQNumberToMatrixIndex[j]; // JUST FOR PQ sort
                          }
               
                         H.set(m1, n1, dPdVang);// n-1*n-1 ,suitable of PQ & PV bus
                  
                        if(!aclfBusj.isGenPV()){
                           N.set(m1,nPQ,dPdVmag); //n-1*m
                           } //end of this -if
                  
                         // matrix element corresponding to PQ bus 
                         if(!aclfBusi.isGenPV() ){
           	             	 K.set(mPQ,n1,dQdVang);  // m*n-1
	                             if(!aclfBusj.isGenPV()){
	                                L.set(mPQ,nPQ,dQdVmag);//m*m
	                               } 
	                        }
                   }// end of if-busj
                 
	             }//end of for busj
            
	        }//end  if-busi
   
		 }  //end of for busi

	   Jnr.setMatrix(0,n-1,0,n-1,H);
	   Jnr.setMatrix(0,n-1,n,n+m-1,N);
	   Jnr.setMatrix(n,n+m-1,0,n-1,K);
	   Jnr.setMatrix(n,n+m-1,n,n+m-1,L);
	   return Jnr.uminus(); // sparseMatrix 的符号与常见的Jnr相反，为正号。因此此处需变号；
	 
	 }//end this method
	private double getMinEigValue(){
		 this.jacobi=this.getJacobiMatrix();
	     Matrix Diag  =jacobi.eig().getD();
		 // search the zero eigen value and its index 
		 double eig_Min = Math.abs(Diag.get(0, 0));
		 int col =0;
		 for (int i=1;i<Diag.getColumnDimension();i++){
		    if (eig_Min > Math.abs(Diag.get(i, i))) { 
		       eig_Min =Math.abs(Diag.get(i, i)); 
		       col =i;
		    } //end of if
		 } //end of for    
		return this.minEigValue=Diag.get(col, col);
	}
	public boolean isReachCritical(){
		this.minEigValue=getMinEigValue();
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
