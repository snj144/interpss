package org.interpss.vstab;

import java.util.List;

import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.EigenDecomposition;
import org.apache.commons.math.linear.RealVector;

import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;

public class ClosestCriticalPoint extends CriticalPoint {
 
 private RealVector closestCriticalP=null;
 private RealVector closestCriticalQ=null;
 private RealVector worstDirP=null;
 private RealVector worstDirQ=null;
 private RealVector leftVector=null;
 
 private void calCCP(){
	 /*
	  * 1. initialize a dir 
	  * 2. get the critical condition with the load increasing in such dir ;
	  * 3. cal the left vector corresponding to the zero eig value ,and make it
	  * as the new dir ;
	  * 4. compare the old and new dir ,find out get the CCP or not ?
	  * 5. if step4 is true ,get the CCP ;otherwise , get back to step2
	  */
	 
 }
 public RealVector getClosestCriticalP(){
	 return this.closestCriticalP;
	 
 }
 public RealVector getClosestCriticalQ(){
	 return this.closestCriticalQ;
 }
 private void calNewDir(AclfNetwork net,RealVector lVector, List<Integer>buslist){
		
		/*
		 * get the new dirP and dirQ for next step
		 * return dirP,dirQ,dirPQ in unit form 
		 */
		int busNum=buslist.size();
		
		// initialize the dirP and dirQ
		this.dirP=new ArrayRealVector(busNum);
		this.dirQ=new ArrayRealVector(busNum);
		RealVector dirpq= new ArrayRealVector(2*busNum);
		
		// get sortIndex
		int[] sortIndex = new int[net.getNoBus()+1];
		int[] sortPQIndex = new int[net.getNoBus()+1];
		 // get the number of non-swing buses and PQ buses
     int n = 0;  //non-swing
     int m = 0;  //PQ

  for (Bus bus : net.getBusList()) {
      AclfBus aclfBus = (AclfBus)bus;
      if (!aclfBus.isSwing()) {
          sortIndex[aclfBus.getSortNumber()] = n++;  // your matrix index range [0 ... n)
           if (!aclfBus.isGenPV()&&!aclfBus.isSwing()) {
               sortPQIndex[aclfBus.getSortNumber()] = m++;  // your matrix index range [0 ... m-1)
           }
      }
  }	//end of for
//  print("n for PQ & PV="+n);
//  print("m for PQ="+m);
 
  for(int idx:buslist){  // all buses in buslist are PQ bus.
 	 int id=buslist.indexOf(idx);
 	 AclfBus thisbus = (AclfBus) net.getBusList().get(idx);
 	 int np =sortIndex[thisbus.getSortNumber()];
 	 int nq =sortPQIndex[thisbus.getSortNumber()]+n; // n here is the total bus number
 	// print("idx="+idx);
 	// print("is load="+thisbus.isGenPV());
 	// print("nq="+nq);
 	 
 	 double p_dir =lVector.getEntry(np);
 	 double q_dir =lVector.getEntry(nq);
 	 
 	 this.dirP.setEntry(id,  p_dir);
 	 this.dirQ.setEntry(id,  q_dir);
 	 
    }// end of for
  
  // the following is for normalization
//    dirpq.setMatrix(0, busNum-1, 0, 0,dirP);
//    dirpq.setMatrix(busNum, 2*busNum-1, 0, 0, dirQ);
//    dirpq =dirpq.times(1/dirpq.normF());
//    this.dirP =dirpq.getMatrix(0, busNum-1, 0, 0);
//    this.dirQ =dirpq.getMatrix(busNum, 2*busNum-1, 0, 0);
	
 } //end this getNewDir method 
    private RealVector getLeftVector(){
		 double eig_Min =99;// chosen by ramdom ,just make sure it is large enough
		 int col =0;
		 double[] realEigenValues=null;
		 EigenDecomposition eigDcp=null;
		 /*
		  * get the EigenDecomposition eigDcp
		  */
		 
	    // search the minimum eigen value and its index 
			 try{
			     eigDcp  =(EigenDecomposition)jacobi;
			     realEigenValues=eigDcp.getRealEigenvalues();
			     
				 // search the zero eigen value and its index 
				 eig_Min = Math.abs(realEigenValues[0]);

				 for (int i=1;i<realEigenValues.length;i++){
				    if (eig_Min > Math.abs(realEigenValues[i])) { 
				       eig_Min =Math.abs(realEigenValues[i]); 
				       col =i;
				    } //end of if
				 } //end of for
				 }catch(Exception e){
					 e.printStackTrace();
				 }

	      // then find out the corresponding eigen vector leftVector
	      
	      int[]objcol={col}; // set the vector corresponding to zero eigen vector
	      RealVector leftVector=eigDcp.getEigenvector(col);
	      return leftVector;
	      
	 }
    
	private RealVector getDirP(){
		return this.dirP;
	}
	private RealVector getDirQ(){
		return this.dirQ;
	}
}
