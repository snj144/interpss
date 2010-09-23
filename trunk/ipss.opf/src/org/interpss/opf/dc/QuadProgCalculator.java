/*
 * @(#)QuadProgCalculator.java   
 *
 * Copyright (C) 2006-2010 www.interpss.org
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
 * @Author Tony Huang, Mike Zhou
 * @Version 1.0
 * @Date 09/15/2010
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.opf.dc;

/**
 * This is an implementation of DC-OPF using the Quad Programming optimization algorithm.
 * It depends on the OpfNetworkHelper class to feed Opf net info into the algorithm.
 * 
 */

import org.interpss.opf.dc.util.Apache2ColtAdapter;

import quadprogj.QuadProgJ;

import com.interpss.core.aclf.AclfBus;
import com.interpss.core.net.Bus;
import com.interpss.opf.OpfNetwork;

public class QuadProgCalculator {
    // OPF result
	private double[] optimX=null;
	
	public void runDCOPF(OpfNetwork opfNet) {
		solveQP(opfNet);
		saveOPFResult(opfNet);
	}
	
	private void solveQP(OpfNetwork net) {
		OpfNetworkHelper helper = new OpfNetworkHelper(net);
		helper.formBusIndexTable();
		
//			System.out.println("G:"+Apache2Colt.trans(G));
//			System.out.println("A:"+Apache2Colt.trans(A));
//			System.out.println("ceq:"+Apache2Colt.trans(Ceq));
//			System.out.println("beq:"+Apache2Colt.trans(beq));
//			System.out.println("Ciq:"+Apache2Colt.trans(Ciq));
//			System.out.println("biq:"+Apache2Colt.trans(biq));
			
		//Apache2Colt is temporally used to change matrix format from a Apache to a Colt ;
		 Apache2ColtAdapter Apache2Colt = new Apache2ColtAdapter();
		 QuadProgJ qpj = new QuadProgJ(
				Apache2Colt.trans(helper.formG()),
				Apache2Colt.trans(helper.formA()),
				Apache2Colt.trans(helper.formCeq()),
				Apache2Colt.trans(helper.formBeq()),
				Apache2Colt.trans(helper.formCiq()),
				Apache2Colt.trans(helper.formBiq()));
		
		// NOTE FOR THE SOLUTION STRUCTURE x* = qpj.getMinX()
	    // x* = (p_{G1}...p_{GI}, delta_2...delta_K) for fixed demand
		optimX=qpj.getMinX();
	}
	
	private void saveOPFResult(OpfNetwork net) {
			double[] busAngle=null;

			busAngle=new double[net.getNoActiveBus()-1];
			int noOfGen = net.getNoOfGen();
			for(int k=noOfGen;k<noOfGen+net.getNoActiveBus()-1;k++){
				busAngle[k-noOfGen]=this.optimX[k]; // voltAngle in radians
			}
			int genIndex=0;
			for(Bus b:net.getBusList()){
				if(net.isOpfGenBus(b)){
					((AclfBus) b).setGenP(optimX[genIndex]);
					genIndex++;
				}
			}
			int nonSwingBusIndex=0;
			for(Bus b: net.getBusList()){
				AclfBus acbus=(AclfBus) b;
				if(!acbus.isSwing()){
					acbus.setVoltageAng(busAngle[nonSwingBusIndex]);
					nonSwingBusIndex++;
				}
			}
	  }
}
