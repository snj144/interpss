 /*
  * @(#) ISONE_CompreResult.java   
  *
  * Copyright (C) 2008 www.interpss.org
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
  * @Date 02/15/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.core.adapter.pwd;

import static org.junit.Assert.assertTrue;

import java.util.logging.Level;

import org.apache.commons.math3.complex.Complex;
import org.ieee.odm.common.ODMLogger;
import org.interpss.CorePluginTestSetup;
import org.interpss.IpssCorePlugin;
import org.interpss.display.AclfOutFunc;
import org.interpss.display.DclfOutFunc;
import org.interpss.numeric.datatype.Unit.UnitType;
import org.interpss.numeric.sparse.base.SparseEquation.SolverType;
import org.junit.Test;

import com.interpss.CoreObjectFactory;
import com.interpss.core.DclfObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.adpter.AclfSwingBus;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.core.net.RefBusType;
import com.interpss.pssl.plugin.IpssAdapter;
import com.interpss.pssl.plugin.IpssAdapter.PsseVersion;

public class SixBus_DclfPsXfr_pwd extends CorePluginTestSetup {
	//@Test
	public void aclf() throws Exception {
		IpssCorePlugin.init();
        IpssCorePlugin.setSparseEqnSolver(SolverType.Native);
		ODMLogger.getLogger().setLevel(Level.WARNING);

		AclfNetwork net = IpssAdapter.importAclfNet("testData/psse/v30/SixBus_2WPsXfr.raw")
					.setFormat(IpssAdapter.FileFormat.PSSE)
					.setPsseVersion(PsseVersion.PSSE_30)
					.load(true, "output/odm.xml")
					.getAclfNet();
  		//System.out.println(net.net2String());

	  	net.accept(CoreObjectFactory.createLfAlgoVisitor());
	  	
  		assertTrue(net.isLfConverged());
  		
		System.out.println(AclfOutFunc.loadFlowSummary(net));
  		AclfSwingBus swing = net.getAclfBus("Bus1").toSwingBus();
  		Complex p = swing.getGenResults(UnitType.PU);
  		assertTrue(Math.abs(p.getReal()-3.1032)<0.0001);
  		assertTrue(Math.abs(p.getImaginary()-0.5212)<0.0001);	   		
 	}
	
	@Test
	public void dclf() throws Exception {
		IpssCorePlugin.init();
        //IpssCorePlugin.setSparseEqnSolver(SolverType.Native);
		ODMLogger.getLogger().setLevel(Level.WARNING);

		AclfNetwork net = IpssAdapter.importAclfNet("testData/pwd/SixBus_2WPsXfr.aux")
					.setFormat(IpssAdapter.FileFormat.PWD)
					.load(true, "output/odm.xml")
					.getAclfNet();
  		//System.out.println(net.net2String());

		DclfAlgorithm algo = DclfObjectFactory.createDclfAlgorithm(net);
		algo.calculateDclf();

		System.out.println(DclfOutFunc.dclfResults(algo, false));

		algo.destroy();			
	}
	
	@Test
	public void dclf_WithXfrZAdjusted() throws Exception {
		IpssCorePlugin.init();
        //IpssCorePlugin.setSparseEqnSolver(SolverType.Native);
		ODMLogger.getLogger().setLevel(Level.WARNING);

		AclfNetwork net = IpssAdapter.importAclfNet("testData/pwd/SixBus_2WPsXfr.aux")
					.setFormat(IpssAdapter.FileFormat.PWD)
					.load(true, "output/odm.xml")
					.getAclfNet();
  		//System.out.println(net.net2String());
 		
		
		/*xfr 1->3
		  r=0.00024, x=0.03039
		*/
		net.getAclfBranch("Bus1->Bus3(1 )").setZ(new Complex(0.00024, 0.03039));

		
		DclfAlgorithm algo = DclfObjectFactory.createDclfAlgorithm(net);
		algo.calculateDclf();

		System.out.println(DclfOutFunc.dclfResults(algo, false));

		algo.destroy();			
	}
	
}

