 /*
  * @(#)ZBusSample.java   
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
  * @Date 10/15/2010
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.sample.aclf;

import java.util.logging.Level;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.ComplexFunc;
import com.interpss.common.datatype.Constants;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.sparse.dep.SparseEqnComplex;
import com.interpss.pssl.simu.IpssAclf;
import com.interpss.simu.util.sample.SampleCases;
import com.interpss.spring.CoreCommonSpringCtx;


public class ZBusSample {
	public static void main(String args[]) throws InterpssException {
		CoreCommonSpringCtx.setAppContext(Constants.SpringConfigPath_Plugin);
		
		// set session message to Warning level
		IPSSMsgHub msg = IpssAclf.getMsgHub();
		IpssLogger.getLogger().setLevel(Level.WARNING);
		
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net);

		// bus number is arranged during the process to minimize the fill-ins 
		SparseEqnComplex eqn = net.formYMatrix();
		
		// assume swing connect to the ground
		AclfBus swing = net.getAclfBus("5");
		int busNo = swing.getSortNumber();
		eqn.setAij(new Complex(0.0, 1.0e10), busNo, busNo);
		
		// calculate zii of bus "1"
		AclfBus bus1 = net.getAclfBus("1");
		busNo = bus1.getSortNumber();
		eqn.setB2Unit(busNo);
		
		eqn.luMatrixAndSolveEqn(1.0e-20);
		Complex z = eqn.getBi(busNo);
		System.out.println("Zii: " + ComplexFunc.toString(z));  

		// calculate zii of bus "2"
		AclfBus bus2 = net.getAclfBus("2");
		busNo = bus2.getSortNumber();
		eqn.setB2Unit(busNo);
		
		// Y-matrix already LUed, so no need to LU again
		eqn.solveEqn();
		z = eqn.getBi(busNo);
		System.out.println("Zii: " + ComplexFunc.toString(z));  
	}	
}
