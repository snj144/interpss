/*
 * @(#)OpfNetworkHelper.java   
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
 * This a helper class for creating matrix/vector info from the wrapped OpfNetwork object
 * to feed into the QuafProgCalculator for DC-OPF calculation
 */

import java.util.Hashtable;

import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.RealMatrix;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.opf.OpfGenBus;
import com.interpss.opf.OpfNetwork;

public class OpfNetworkHelper {
	private OpfNetwork opfNet = null;
	// used for storing the bus and bus index relationship
	private Hashtable<String,Integer> busIndexTable;

	
	public OpfNetworkHelper(OpfNetwork opfNet) {
		this.opfNet = opfNet;
	}
	
	// cost matrix composed by coefficient 2*bi	
	public Array2DRowRealMatrix formU() {
		int numOfGen = opfNet.getNoOfGen();
		Array2DRowRealMatrix U = new Array2DRowRealMatrix(numOfGen, numOfGen);
		int genIndex=0;
		try{
			for(Bus b: opfNet.getBusList()){
				if(opfNet.isOpfGenBus(b)){
					U.setEntry(genIndex, genIndex, 
							(opfNet.toOpfGenBus(b)).getCoeffB()*2);
					genIndex++;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			IpssLogger.getLogger().severe(e.toString());
		}
		return U;
	}

	// angel difference weight matrix	
	private Array2DRowRealMatrix formAngleDiffWeightMatrix() {
		int i = 0;
		int j = 0;
		double ADWij = 0;
		double ADWii = 0;
		int numOfBus = opfNet.getNoActiveBus();
		Array2DRowRealMatrix angleDiffWeight = new Array2DRowRealMatrix(numOfBus, numOfBus);

		for (Bus b : opfNet.getBusList()) {
			Bus busi = b;
			ADWij = 0;
			ADWii = 0;
			i = this.getBusIndex(b.getId());
			for (Branch bra : busi.getFromBranchList()) {
				Bus busj = bra.getToBus();
				j = this.getBusIndex(busj.getId());
				ADWij = -1;
				ADWii++;
				angleDiffWeight.setEntry(i, j, ADWij);
				angleDiffWeight.setEntry(j, i, ADWij);

			}
			angleDiffWeight.setEntry(i, i, busi.getBranchList().size());
		}
		
		return angleDiffWeight=(Array2DRowRealMatrix)angleDiffWeight.scalarMultiply(2*opfNet.getAnglePenaltyFactor());
	}
		
	// reduced angle difference weight matrix
	private Array2DRowRealMatrix formReducedADWMatrix() {
		Array2DRowRealMatrix angleDiffWeight = formAngleDiffWeightMatrix();
		int[] selectedRows = new int[angleDiffWeight.getRowDimension() - 1];
		try {
			selectedRows = this.getNonSwingBusRows();
		} catch (Exception e) {
			e.printStackTrace();
			IpssLogger.getLogger().severe(e.toString());
		}

		Array2DRowRealMatrix Wrr = (Array2DRowRealMatrix) angleDiffWeight.getSubMatrix(
				selectedRows, selectedRows);
		return Wrr;
	}

	// G={U 0;0 Wrr}
	public Array2DRowRealMatrix formG() {
		RealMatrix U_matrix = formU();;
		RealMatrix Wrr_matrix = formReducedADWMatrix();
		int Grows = U_matrix.getRowDimension() + Wrr_matrix.getRowDimension();
		int Gcols = Grows;
		
		Array2DRowRealMatrix G = new Array2DRowRealMatrix(Grows, Gcols);
		G.setSubMatrix(U_matrix.getData(), 0, 0);
		G.setSubMatrix(Wrr_matrix.getData(), U_matrix.getRowDimension(),
				U_matrix.getColumnDimension());
		return G;
	}

	public ArrayRealVector formA() {
		int numOfGen = opfNet.getNoOfGen(),
				numOfBus = opfNet.getNoActiveBus();
		ArrayRealVector A = new ArrayRealVector(numOfGen + numOfBus - 1);
		A.set(0, getGenCoeffAVector());
		return A;
	}
		
	private ArrayRealVector getGenCoeffAVector(){
		int numOfGen=opfNet.getNoOfGen();
		ArrayRealVector genFixCostVector =new ArrayRealVector(numOfGen);
        int i=0;
		// get the constraint data from network file ;
	      for (Bus bus:opfNet.getBusList()) {
	    	  if(opfNet.isOpfGenBus(bus)){
	    		  OpfGenBus genOPF= opfNet.toOpfGenBus(bus);
	    		  genFixCostVector.setEntry(i, genOPF.getCoeffA());
	  			i++;
	    	  }
	       }
		return genFixCostVector;
	}
		
	public Array2DRowRealMatrix formCeq() {
		int numOfBus=opfNet.getNoActiveBus();
		int numOfGen=opfNet.getNoOfGen();			
		Array2DRowRealMatrix CeqTranspose = new Array2DRowRealMatrix(
				numOfBus, numOfBus + numOfGen - 1);
		Array2DRowRealMatrix Ceq = new Array2DRowRealMatrix(numOfBus + numOfGen - 1, numOfBus);
		Array2DRowRealMatrix genBusAdjacent = new Array2DRowRealMatrix(	numOfBus, numOfGen);
		Array2DRowRealMatrix BrTranspose = new Array2DRowRealMatrix(
				numOfBus, numOfBus - 1); // reduced bus admittance
													// matrix

		int genCount = 0;
		for (Bus b : opfNet.getBusList()) {
			
			// set the elements in genBusAdjacent matrix to ONE if there is a
			// generator ;
			/*
			 * in the case of multi-gen ,all are treated as a union;
			 * not suitable for a case with multi-generators connected to one
			 * bus;
			 */
			if (opfNet.isOpfGenBus(b)) {
				genBusAdjacent.setEntry(this.getBusIndex(b.getId()), genCount, 1);
				genCount++;
			}
		}
		BrTranspose = (Array2DRowRealMatrix) this.getReducedBusAdmittance()
				.transpose();

		CeqTranspose.setSubMatrix(genBusAdjacent.getData(), 0, 0); // Ceq'={genBusAdjacent,BrTranspose}
		CeqTranspose.setSubMatrix(BrTranspose.scalarMultiply(-1).getData(), 0, numOfGen);
		Ceq = (Array2DRowRealMatrix) CeqTranspose.transpose();
		return Ceq;
	}

	public ArrayRealVector formBeq() {
		ArrayRealVector beq = new ArrayRealVector(opfNet.getNoActiveBus());
		int busIndex = 0;
		for (Bus b : opfNet.getBusList()) {
			AclfBus acbus = (AclfBus) b;
			busIndex = this.getBusIndex(acbus.getId());
			if (acbus.isLoad()) {
				beq.setEntry(busIndex, acbus.getLoadP());
			}
		}
		return beq;
	}

	public Array2DRowRealMatrix formCiq() {
    	int numOfBranch=opfNet.getNoActiveBranch();
		int numOfBus=opfNet.getNoActiveBus();
		int numOfGen=opfNet.getNoOfGen();
		Array2DRowRealMatrix braAdmDiag = new Array2DRowRealMatrix(
				numOfBranch, numOfBranch);
		Array2DRowRealMatrix braBusAdjacent = new Array2DRowRealMatrix(
				numOfBranch, numOfBus - 1);
		Array2DRowRealMatrix eyeGenP = new Array2DRowRealMatrix(numOfGen, numOfGen);
		Array2DRowRealMatrix CiqTranspose = new Array2DRowRealMatrix(
				numOfBranch * 2 + numOfGen * 2, numOfGen + numOfBus - 1);

		final double DEFAULT_BIJ = 10000; // 10000=1/0.0001 ,namely set the
											// line Xij minimum to be 0.0001;
		double bij = DEFAULT_BIJ;
		int braIndex = 0;
		int fromBusIndex = 0;
		int toBusIndex = 0;

		for (Branch bra : opfNet.getBranchList()) {
			AclfBranch aclfBra = (AclfBranch) bra;
			// create branch admittance matrix
			bij = (aclfBra.getZ().getImaginary() > 0.00001) ? 1 / aclfBra
					.getZ().getImaginary() : DEFAULT_BIJ; // in case x=0;
			braAdmDiag.setEntry(braIndex, braIndex, bij);

			// create branch-bus connected or adjacent matrix;
			if (!((AclfBus) bra.getFromBus()).isSwing()) {
				fromBusIndex = this.getBusIndex(bra.getFromBus().getId());
				fromBusIndex=(fromBusIndex<this.getSwingBusIndex())?fromBusIndex:fromBusIndex-1; // insure nonswing bus;
				braBusAdjacent.setEntry(braIndex, fromBusIndex, 1);
			}
			if (!((AclfBus) bra.getToBus()).isSwing()) {
				toBusIndex = this.getBusIndex(bra.getToBus().getId());
				toBusIndex=(toBusIndex<this.getSwingBusIndex())?toBusIndex:toBusIndex-1; 
				braBusAdjacent.setEntry(braIndex, toBusIndex, -1);
			}
			braIndex++;

		}
		int genIndex = 0;
		for (Bus bus : opfNet.getBusList()) {
			if (opfNet.isOpfGenBus(bus)) {
				eyeGenP.setEntry(genIndex, genIndex, 1);
				genIndex++;
			}
		}
		Array2DRowRealMatrix DAr = braAdmDiag.multiply(braBusAdjacent);
		// Ciq'={Ot,-braAdmDiag*braBusAdjacent;
		//     -Ot,braAdmDiag*braBusAdjacent;
		//      eyeGenP,Op;
		//      -eyeGenP,-Op}

		CiqTranspose.setSubMatrix(DAr.scalarMultiply(-1).getData(), 0, numOfGen);
		CiqTranspose.setSubMatrix(DAr.getData(), numOfBranch, numOfGen);
		CiqTranspose.setSubMatrix(eyeGenP.getData(), 2 * numOfBranch, 0);
		CiqTranspose.setSubMatrix(eyeGenP.scalarMultiply(-1).getData(), 2* numOfBranch + numOfGen, 0);
		// Ciq=CiqTranspose'
		return (Array2DRowRealMatrix) CiqTranspose.transpose();
	}

	public ArrayRealVector formBiq() {
    	int numOfBranch=opfNet.getNoActiveBranch();
		int numOfGen=opfNet.getNoOfGen();			
		ArrayRealVector biq = new ArrayRealVector(numOfBranch * 2 + numOfGen * 2);
		ArrayRealVector bt = formBranchMvaConstraint();
		ArrayRealVector b_Pmax = formGenInequConstraintPmax();
		ArrayRealVector b_Pmin = formGenInequConstraintPmin();
		biq.set(0, bt);
		biq.set(numOfBranch, bt);
		biq.set(numOfBranch * 2, b_Pmin);
		biq.set(numOfGen + numOfBranch * 2, b_Pmax);
		return biq;
	}

	// used for creating inequality constraint
	private ArrayRealVector formBranchMvaConstraint() {
    	int numOfBranch=opfNet.getNoActiveBranch();
		// bt corresponds to line thermal inequality constraints
		ArrayRealVector bt = new ArrayRealVector(numOfBranch); 
		double ratingMva1 = 0;
		double baseMVA=opfNet.getBaseKva()*0.001;
		int braIndex = 0;
		// form the bt;
		for (Branch bra : opfNet.getBranchList()) {
			AclfBranch acBranch = (AclfBranch) bra;
			ratingMva1 = acBranch.getRatingMva1()/baseMVA;
			bt.setEntry(braIndex, -ratingMva1);
			braIndex++;
		}
		return bt;
	}

	private ArrayRealVector formGenInequConstraintPmax() {
		int numOfGen=opfNet.getNoOfGen();			
		// including b_Pmin, b_Pmax;
		ArrayRealVector b_Pmax = new ArrayRealVector(numOfGen); // b_Pmax corresponds to generators' upper active power limit
        int i=0;
        double baseMVA=opfNet.getBaseKva()*0.001;
		// get the constraint data from network file ;
	    for (Bus bus:opfNet.getBusList()) {
	    	  if(opfNet.isOpfGenBus(bus)){
	    		OpfGenBus genOPF=opfNet.toOpfGenBus(bus);	
	  			b_Pmax.setEntry(i, -genOPF.getCapacityLimit().getMax()/baseMVA);
	  			i++;
	    	  }
			
		}
	    return b_Pmax;
	}

	private ArrayRealVector formGenInequConstraintPmin() {
		int numOfGen=opfNet.getNoOfGen();			
		// including b_Pmin, b_Pmax;
		ArrayRealVector b_Pmin = new ArrayRealVector(numOfGen); // b_Pmin corresponds to generators' lower active power limit
        int i=0;
        double baseMVA=opfNet.getBaseKva()*0.001;
		// get the constraint data from network file ;
	    for (Bus bus:opfNet.getBusList()) {
	    	  if(opfNet.isOpfGenBus(bus)){
	    		OpfGenBus genOPF=opfNet.toOpfGenBus(bus);	
	    		b_Pmin.setEntry(i, genOPF.getCapacityLimit().getMin()/baseMVA); //saved in inequal constraint vector in PU unit
	  			i++;
	    	  }
			
		}
	    return b_Pmin;
	}
		
	private Array2DRowRealMatrix getReducedBusAdmittance() {
		int numOfBus=opfNet.getNoActiveBus();

		// form the reduced bus admittance matrix by omitting the row
		// corresponding to the SWING bus ;
		// here B1 formed by InterPSS itself is under consideration to be reused
		// ;

		Array2DRowRealMatrix busAdmReduced = new Array2DRowRealMatrix(
				numOfBus - 1, numOfBus); // reduced bus admittance
													// matrix
		Array2DRowRealMatrix tempBusAdm = new Array2DRowRealMatrix(
				numOfBus, numOfBus);

		for (Bus b : opfNet.getBusList()) {
			AclfBus busi = (AclfBus) b;
			int i = this.getBusIndex(busi.getId());
			double Bij = 0;
			double Bii = 0;

			for (Branch bra : busi.getBranchList()) {
				Bus busj = bra.getToBus().equals(busi) ? bra.getFromBus() : bra
						.getToBus();
				AclfBranch aclfBranch = (AclfBranch) bra;
				int j = this.getBusIndex(busj.getId());
				Bij = 1.0 / aclfBranch.getZ().getImaginary();// aclfBranch.b1ft();
				tempBusAdm.setEntry(i, j, -Bij);
				Bii += Bij;
			}
			tempBusAdm.setEntry(i, i, Bii);
		}

		int[] selectedRows = this.getNonSwingBusRows();
		for (int index = 0; index < selectedRows.length; index++) {
			busAdmReduced.setRow(index, tempBusAdm.getRow(selectedRows[index]));
		}
		return busAdmReduced;
	}

	private int[] getNonSwingBusRows() {
		int[] NonSwingBusRows = new int[opfNet.getNoActiveBus() - 1];
		int idx = 0;

		for (int busIndex = 0; busIndex < opfNet.getNoActiveBus(); busIndex++) {
			Bus b = opfNet.getBusList().get(busIndex);
			AclfBus bus = (AclfBus) b;
			if (!bus.isSwing()) {
				// swingSortNum=bus.getSortNumber();
				NonSwingBusRows[idx] = busIndex;
				idx++;
			}
		}
		return NonSwingBusRows;
	}

	public void formBusIndexTable() {
		this.busIndexTable=new Hashtable<String, Integer>(opfNet.getNoBus()*2);
		for (int busIndex = 0; busIndex < opfNet.getNoBus(); busIndex++) {
			Bus b = opfNet.getBusList().get(busIndex);
			this.busIndexTable.put(b.getId(), busIndex);
		}
	}
		
	private int getBusIndex(String busId){
		return getBusIndexTable().get(busId);
	}
		
	private int getSwingBusIndex(){
			int swingBusIndex=0;
			for(Bus b:opfNet.getBusList()){
				if(((AclfBus)b).isSwing()){
					swingBusIndex=getBusIndexTable().get(b.getId());
					break;
				}
			}
			return swingBusIndex;
	}

	private Hashtable<String, Integer> getBusIndexTable(){
			return this.busIndexTable;
	}
}
