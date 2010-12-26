 /*
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.sample.aclf;

import org.interpss.display.AclfOutFunc;
import org.interpss.numeric.datatype.Matrix_xy;
import org.interpss.numeric.datatype.Vector_xy;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.impl.DefaultNrSolver;
import com.interpss.core.sparse.dep.SparseEqnMatrix2x2;
import com.interpss.pssl.simu.IpssAclf;
import com.interpss.simu.util.sample.SampleCases;


public class CustomNRMethod {
	/**
	 * Define a custom NR solver 
	 *
	 */
	static class CustomNrSolver extends DefaultNrSolver {
		public CustomNrSolver(AclfNetwork net) {
			super(net);
		}

		/**
		 * formJMatrix method is called at the beginning of each NR iteration
		 */
		@Override
		public SparseEqnMatrix2x2 formJMatrix() {
			// create network J-matrix with one extra-dimension
			SparseEqnMatrix2x2 lfEqn = getAclfNet().formJMatrix(1);
			
			// create a 2x2 matrix element
			Matrix_xy m = new Matrix_xy();
			m.xx = 2.0;
			m.xy = 0.0;
			m.yx = 0.0;
			m.yy = 2.0;
			
			// set the matrix element to J-matrix
			int n = getAclfNet().getNoBus();
			lfEqn.setAij(m, n+1, n+1);
			
			return lfEqn;
		}

		// this is dummy variable for setting the extra mismatch field
		private double mis = 1.0;
		
		/**
		 * setPowerMismatch method is called at the beginning of each NR iteration
		 */
		@Override
		public void setPowerMismatch(SparseEqnMatrix2x2 lfEqn) {
			// calculate bus power mismatch. The mismatch stored on 
			// the right-hand side of the sparse eqn
			super.setPowerMismatch(lfEqn);
			
			// define a 2x1 vector
			Vector_xy b = new Vector_xy();
			b.x = mis;
			b.y = mis;
			
			// set the vector to the right-hand side of the sparse eqn
			int n = getAclfNet().getNoBus();
			lfEqn.setBi(b, n+1);
		}
		
		/**
		 * updateBusVoltage method is called at at the end of each NR iteration, after the 
		 * sparse eqn has been solved. The results of the sparse eqn solution is stored in the
		 * sparse eqn.
		 */
		@Override
		public void updateBusVoltage(SparseEqnMatrix2x2 lfEqn) {
			// update the bus voltage using the solution results store in the sparse eqn
			super.updateBusVoltage(lfEqn);
			
			// the solution result of the extra variable defined is stored at B(n+1)  
			int n = getAclfNet().getNoBus();
			System.out.println("mis: " + this.mis + "  ---> " + lfEqn.getBVect_xy(n+1));
			
			// reduce the dummy variable so that the loadflow can converge  
			this.mis *= 0.1;
		}
	}
	
	public static void main(String args[]) {
		// set session message to Warning level
		IPSSMsgHub msg = IpssAclf.getMsgHub();
		
		// create a sample 5-bus system for Loadflow 
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net);
		//System.out.println(net.net2String());

		// create a Loadflow algo object
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm();

	  	// set algo NR solver to the CustomNrSolver
	  	algo.setNrSolver(new CustomNrSolver(net));

	  	// run Loadflow
	  	net.accept(algo);
	  	
	  	// output loadflow calculation results
	  	System.out.println(AclfOutFunc.loadFlowSummary(net));
	}	
}
