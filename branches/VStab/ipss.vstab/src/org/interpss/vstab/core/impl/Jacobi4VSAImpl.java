package org.interpss.vstab.core.impl;

import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.EigenDecomposition;
import org.apache.commons.math.linear.EigenDecompositionImpl;
import org.apache.commons.math.linear.LUDecomposition;
import org.apache.commons.math.linear.LUDecompositionImpl;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.util.MathUtils;
import org.interpss.vstab.core.Jacobi4VSA;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.JacobianMatrixType;
import com.interpss.core.net.Bus;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

public class Jacobi4VSAImpl implements Jacobi4VSA {
    protected RealMatrix fullJacobi;
    protected RealMatrix reducedJacobi;
    protected RealMatrix subJptheta;
    protected RealMatrix subJpv;
    protected RealMatrix subJqtheta;
    protected RealMatrix subJqv;
    protected RealMatrix RightEigenVectorMatrix;
    protected RealMatrix LeftEigenVectorMatrix;
    protected RealMatrix eigenValueDiagMatrix;
    private IPSSMsgHub msg;
   
    public Jacobi4VSAImpl(AclfNetwork net){
      initialize(net);
    }
    
    public Jacobi4VSAImpl() {
		// TODO Auto-generated constructor stub
	}

	private void initialize(AclfNetwork net){
    	SparseEqnMatrix2x2 S=net.formJMatrix(JacobianMatrixType.FULL_POLAR_COORDINATE, msg);
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
		    subJptheta = new Array2DRowRealMatrix(n,n);
		    subJpv = new Array2DRowRealMatrix(n,m);
		    subJqtheta = new Array2DRowRealMatrix(m,n);
		    subJqv=  new Array2DRowRealMatrix(m,m);
		    fullJacobi =new Array2DRowRealMatrix (n+m,n+m);   // Jacobi matrix in classical format.   

		  try{    
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
		               
		                        subJptheta.setEntry(m1, n1, dPdVang);// n-1*n-1 ,suitable of PQ & PV bus
		                  
		                        if(!aclfBusj.isGenPV()){
		                        	subJpv.setEntry(m1,nPQ,dPdVmag); //n-1*m
		                           } //end of this -if
		                  
		                         // matrix element corresponding to PQ bus 
		                         if(!aclfBusi.isGenPV() ){
		                        	 subJqtheta.setEntry(mPQ,n1,dQdVang);  // m*n-1
			                             if(!aclfBusj.isGenPV()){
			                            	 subJqv.setEntry(mPQ,nPQ,dQdVmag);//m*m
			                               } 
			                        }
		                   }// end of if-busj
		                 
			             }//end of for busj
		            
			        }//end  if-busi
		   
				 }  //end of for busi

			   fullJacobi.setSubMatrix(subJptheta.getData(), 0, 0);
			   fullJacobi.setSubMatrix(subJqtheta.getData(),0,n);
			   fullJacobi.setSubMatrix(subJqtheta.getData(),n,0);
			   fullJacobi.setSubMatrix(subJqv.getData(),n,n);  
			   fullJacobi=fullJacobi.scalarMultiply(-1);
			   // the sign of sparseMatrix is opposite to usual, so here  its sign is changed by default .
		  }catch(Exception e){ 
			 e.printStackTrace();
		  }
	      			   
	 }//end this method

	@Override
	public RealMatrix getFullJacobi() {
		if(this.fullJacobi==null){
		msg.sendErrorMsg("the full jacobi is null ,not properly load here");
		return null;
		}
		return this.fullJacobi;
	}
	@Override
	public RealMatrix getReducedJacobi() {
        LUDecomposition ludcp=new LUDecompositionImpl(subJptheta);
        
        if (ludcp.getSolver().isNonSingular()){
        	reducedJacobi=subJqv.subtract(subJqtheta.multiply(
        			ludcp.getSolver().getInverse()).multiply(subJpv));
        	return reducedJacobi;
        }
        return null;
	}

	public RealMatrix getSubJptheta() {
		if(this.subJptheta==null){
			msg.sendErrorMsg("the sub P-Theta jacobi is null ,not properly load here");
			return null;
			}
			return this.subJptheta;
		
	}

	@Override
	public RealMatrix getSubJpv() {
		if(this.subJpv==null){
			msg.sendErrorMsg("the sub P-V jacobi is null ,not properly load here");
			return null;
			}
			return this.subJpv;
		
	}
	


	public RealMatrix getSubJqtheta() {
		if(this.subJqtheta==null){
			msg.sendErrorMsg("the sub Q-Theta jacobi is null ,not properly load here");
			return null;
			}
			return this.subJqtheta;
		
	}
	

	@Override
	public RealMatrix getSubJqv() {
		if(this.subJqv==null){
			msg.sendErrorMsg("the sub Q-V jacobi is null ,not properly load here");
			return null;
			}
			return this.subJqv;
		
	}

	@Override
	public void setEigValues(RealMatrix eigValueMatrix) {
		this.eigenValueDiagMatrix=eigValueMatrix;
		
	}
	@Override
	public RealMatrix getEigValues() {
		return this.eigenValueDiagMatrix;
	}

	@Override
	public void setFullJacobi(RealMatrix fullJacobi) {
		this.fullJacobi=fullJacobi;
		//set the right eigen vector matrix
		EigenDecomposition eigDcp  =new EigenDecompositionImpl(fullJacobi.transpose(),MathUtils.SAFE_MIN);
		setLeftEigVctrMatrix(eigDcp.getV().transpose());
		// set the right eigen vector matrix 
		eigDcp  =new EigenDecompositionImpl(fullJacobi,MathUtils.SAFE_MIN);
		setRightEigVctrMatrix(eigDcp.getV());
		// save the eigen value diagonal matrix 
		setEigValues(eigDcp.getD());
	}

	@Override
	public void setReducedJacobi(RealMatrix reducedJacobi) {
		this.reducedJacobi=reducedJacobi;
		EigenDecomposition eigDcp  =new EigenDecompositionImpl(reducedJacobi.transpose(),MathUtils.SAFE_MIN);
		setLeftEigVctrMatrix(eigDcp.getV().transpose());
		
		eigDcp  =new EigenDecompositionImpl(reducedJacobi,MathUtils.SAFE_MIN);
		setRightEigVctrMatrix(eigDcp.getV());
		
		setEigValues(eigDcp.getD());
		
	}

	@Override
	public void setSubJpv(RealMatrix Jpv) {
		this.subJpv=Jpv;
		
	}

	@Override
	public void setSubJqv(RealMatrix Jqv) {
		this.subJqv=Jqv;
		
	}

	@Override
	public RealMatrix getLeftEigVctrMatrix() {
		return this.LeftEigenVectorMatrix;
	}

	@Override
	public RealMatrix getRightEigVctrMatrix() {
		return this.RightEigenVectorMatrix;
	}

	@Override
	public void setLeftEigVctrMatrix(RealMatrix newLeftEigVctrMatrix) {
		this.LeftEigenVectorMatrix=newLeftEigVctrMatrix;
		
	}

	@Override
	public void setRightEigVctrMatrix(RealMatrix newRightEigVctrMatrix) {
		this.RightEigenVectorMatrix=newRightEigVctrMatrix;
		
	}


	
	
	
}
