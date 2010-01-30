package org.interpss.vstab;

import java.util.Arrays;
import java.util.List;

import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;

import Jama.Matrix;

public class ClosestCriticalPoint extends CriticalPoint {
 
 private Matrix closestCriticalP=null;
 private Matrix closestCriticalQ=null;
 private Matrix worstDirP=null;
 private Matrix worstDirQ=null;
 private Matrix leftVector=null;
 
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
 public Matrix getClosestCriticalP(){
	 return this.closestCriticalP;
	 
 }
 public Matrix getClosestCriticalQ(){
	 return this.closestCriticalQ;
 }
 private void calNewDir(AclfNetwork net,Matrix lVector, List<Integer>buslist){
		
		/*
		 * get the new dirP and dirQ for next step
		 * return dirP,dirQ,dirPQ in unit form 
		 */
		int busNum=buslist.size();
		
		// initialize the dirP and dirQ
		this.dirP=new Matrix(busNum,1);
		this.dirQ=new Matrix(busNum,1);
		Matrix dirpq= new Matrix(2*busNum,1);
		
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
 	 
 	 double p_dir =lVector.get(np, 0);
 	 double q_dir =lVector.get(nq, 0);
 	 
 	 this.dirP.set(id, 0, p_dir);
 	 this.dirQ.set(id, 0, q_dir);
 	 
    }// end of for
  
    dirpq.setMatrix(0, busNum-1, 0, 0,dirP);
    
    dirpq.setMatrix(busNum, 2*busNum-1, 0, 0, dirQ);
    dirpq =dirpq.times(1/dirpq.normF());
    this.dirP =dirpq.getMatrix(0, busNum-1, 0, 0);
    this.dirQ =dirpq.getMatrix(busNum, 2*busNum-1, 0, 0);
	
 } //end this getNewDir method 
    private Matrix getLeftVector(){
    	  Matrix Vector=jacobi.transpose().eig().getV();
	      Matrix Diag  =jacobi.transpose().eig().getD();
	      // search the zero eigen value and its index 
	      double eig_val =Math.abs(Diag.get(0, 0));
	      int col =0;
	      
	      for (int i=1;i<Diag.getColumnDimension();i++){
	    	  if (eig_val >Math.abs(Diag.get(i, i))) {
	    	   eig_val =Math.abs(Diag.get(i, i));
	    	   col = i;
	    	   } //end of if
	        } //end of for

	      // then find out the corresponding eigen vector leftVector
	      
	      int[]objcol={col}; // set the vector corresponding to zero eigen vector
	      Matrix leftVector =Vector.getMatrix(
	    		  0, Vector.getRowDimension()-1, objcol);
	      return leftVector;
	      
	 }
    
	private Matrix getDirP(){
		return this.dirP;
	}
	private Matrix getDirQ(){
		return this.dirQ;
	}
}
