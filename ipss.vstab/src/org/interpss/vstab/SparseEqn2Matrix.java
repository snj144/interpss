package org.interpss.vstab;

import Jama.Matrix;

import com.interpss.common.SpringAppContext;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;
import com.interpss.core.sparse.SparseEqnDouble;

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
