package org.interpss.vstab;

import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.RealMatrix;
import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Matrix_xy;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;
import com.interpss.core.sparse.SparseEqnDouble;
import com.interpss.core.sparse.SparseEqnMatrix2x2;
/*
 * still some problem for this conversation ,
 * cau'z the dimension and index of complex matrix is not so clear 
 *
 */
public class SparseEqnMatrix2RealMatrix {
	/**
	 * 
	 * @param net
	 * @param objSparseDoubleMatrix
	 * @return
	 */
	public static RealMatrix SparseEqnDouble2Matrix(AclfNetwork net,SparseEqnDouble objSparseDoubleMatrix){
	int i=0;
	int j=0;
	int m=objSparseDoubleMatrix.getDimension();
	RealMatrix B1=new Array2DRowRealMatrix(m,m);
    for(Bus bi:net.getBusList()){
    	AclfBus acbusi=(AclfBus)bi;
    	
    	if(!acbusi.isSwing()){
    		
    	 for(Bus bj:net.getBusList()){
    		AclfBus acbusj=(AclfBus)bj;
    		if(!acbusj.isSwing()){
//    			int col=bj.getSortNumber();
    			B1.setEntry(i, j,net.formB1Matrix(SpringAppContext.getIpssMsgHub()).getAij(i, j) );
    			
    			j++;
    		}	
    	}
    	i++;
     }
    }
    return B1;
	}
	
	static RealMatrix getJacobiMatrix (AclfNetwork net,SparseEqnMatrix2x2 S,int returnType){

		 // get sortIndex
		int[] sortNumberToMatrixIndex = new int[net.getNoBus()+1];
		int[] sortPQNumberToMatrixIndex = new int[net.getNoBus()+1];
		 // get the number of non-swing buses and PQ buses
       int n = 0;  //record  for non-swing ,that is both PV and PQ 
       int m = 0;  // record only for PQ 
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
   // print("n=" +n+"  m="+m +"\n");
    //initialize of the conventional NR jacobi matrix
    RealMatrix H = new Array2DRowRealMatrix(n,n);
    RealMatrix N = new Array2DRowRealMatrix(n,m);
    RealMatrix K = new Array2DRowRealMatrix(m,n);
    RealMatrix L=  new Array2DRowRealMatrix(m,m);
    RealMatrix Jnr =new Array2DRowRealMatrix (n+m,n+m);   // Jacobi matrix in classical format.   
    //int index=0;  index for Matrix rows 
      
  for (Bus busi : net.getBusList()) {
       AclfBus aclfBusi = (AclfBus)busi;
       if (!aclfBusi.isSwing()) {
             for (Bus busj : net.getBusList()) {
                 AclfBus aclfBusj = (AclfBus)busj;             
                 if (!aclfBusj.isSwing()) {        
                     int i = busi.getSortNumber();
                     int j = busj.getSortNumber();
                     Matrix_xy elem = S.getElement(i, j);

	               // the following variant is chosen like PQ bus, but it is also suitable for PV bus
	                  double dPdVang = elem.xx;
	                  double dPdVmag = elem.xy;
	                  double dQdVang = elem.yx;
	                  double dQdVmag = elem.yy;
	                   
	                    int m1 = sortNumberToMatrixIndex[i];  // get the bus Index in the net 
                       int n1 = sortNumberToMatrixIndex[j];
                  
                        if (!aclfBusi.isGenPV()) { 
                       	// print("pq bus :"+aclfBusi.getId());
                         mPQ = sortPQNumberToMatrixIndex[i]; // JUST FOR PQ sort 
                          }
                        if (!aclfBusj.isGenPV()) {
                         nPQ = sortPQNumberToMatrixIndex[j]; // JUST FOR PQ sort
                          }
               
                         H.setEntry(m1, n1, dPdVang);// n-1*n-1 ,suitable of PQ & PV bus
                  
                        if(!aclfBusj.isGenPV()){
                           N.setEntry(m1,nPQ,dPdVmag); //n-1*m
                           } //end of this -if
                  
                         // matrix element corresponding to PQ bus 
                         if(!aclfBusi.isGenPV() ){
           	             	 K.setEntry(mPQ,n1,dQdVang);  // m*n-1
	                             if(!aclfBusj.isGenPV()){
	                                L.setEntry(mPQ,nPQ,dQdVmag);//m*m
	                               } 
	                        }
                   }// end of if-busj
                 
	             }//end of for busj
            
	        }//end  if-busi
   
		 }  //end of for busi

	   Jnr.setSubMatrix(H.getData(), 0, 0);
	   Jnr.setSubMatrix(N.getData(),0,n);
	   Jnr.setSubMatrix(K.getData(),n,0);
	   Jnr.setSubMatrix(L.getData(),n,n);
	   if (returnType==1) return L;// return the L sub-matrix for the study of Q-V relationship
	   
	   else return Jnr.scalarMultiply(-1); 
	   // the sign of sparseMatrix is opposite to usual, so here  its sign is changed by default .
	 
	 }//end this method
	
}
