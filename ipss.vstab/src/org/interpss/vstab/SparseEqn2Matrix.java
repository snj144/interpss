package org.interpss.vstab;

import Jama.Matrix;

public class SparseEqn2Matrix {
	public Matrix SparseEqnDouble2Matrix(AclfNetwork net,SparseEqnDouble objSparseDoubleMatrix){
	int i=0;
	int j=0;
	int m=objSparseDoubleMatrix.getDimension();
	Matrix B1=new Matrix(m,m);
    for(Bus bi:net.getBusList()){
    	AclfBus acbusi=(AclfBus)bi;
    	
    	if(!acbusi.isSwing()){
    		
    	 for(Bus bj:net.getBusList()){
    		AclfBus acbusj=(AclfBus)bj;
    		if(!acbusj.isSwing()){
//    			int col=bj.getSortNumber();
    			B1.set(i, j,net.formB1Matrix(SpringAppContext.getIpssMsgHub()).getAij(i, j) );
    			
    			j++;
    		}	
    	}
    	i++;
     }
    }
    return B1;
	}
	
}
