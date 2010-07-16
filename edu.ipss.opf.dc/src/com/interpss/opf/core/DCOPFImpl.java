package com.interpss.opf.core;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.*;
import com.interpss.core.aclf.impl.AclfBusImpl;
import com.interpss.core.algorithm.BusArrangeRule;
import com.interpss.core.algorithm.NetworkAlgorithm;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.opf.gen.GenBus4OPF;

import org.apache.commons.math.linear.*;

import quadprogj.QuadProgJ;

public class DCOPFImpl implements DCOPF {
	// network
	private AclfNetwork net;
	private AclfBus acbus;
	private AclfBranch branch;
	private CoreObjectFactory factory = new CoreObjectFactory();

	// attributes of network

	private int numOfBus;
	private int numOfGen;
	private int numOfLoad;
	private int numOfBranch;
	private RealMatrix B; // BUS Admittance
	
    // OPF result
	private double[] optimX;
	private double[] optimGen;
    private double[] busAngle;
	

	// re-sequence bus sortNumber to Index according to original order;
	private int[] sortNumber2OriginIdx;
	private List<Integer> sortNum2OrgIdx_List = null;

	// attributes for DC-OPF;
	private double anglePenCoeff;
	private double minTVC;// minTVC = SUM (Ai*PGi + Bi*PGi^2)
	private Array2DRowRealMatrix U; // cost matrix composed by coefficient 2*bi
	private Array2DRowRealMatrix angleDiffWeight; // angel difference weight
													// matrix
	private Array2DRowRealMatrix Wrr; // reduced angle difference weight matrix
										// ;

	// Input for QuadProgJ
	private Array2DRowRealMatrix G; // G={U 0;0 Wrr}
	private ArrayRealVector A; //
	private Array2DRowRealMatrix Ceq;
	private ArrayRealVector beq;
	private Array2DRowRealMatrix Ciq;
	private ArrayRealVector biq;

	// used for create inequality constraint
	private ArrayRealVector bt;
	private ArrayRealVector bPL;
	private ArrayRealVector bPU;
	
	// used for store the bus and bus index relationship
	private Hashtable<String,Integer> busIndexTable;
	

	// used for transform apache matrix to colt;
	private Apache2ColtAdapter Apache2Colt=new Apache2ColtAdapter();

	public DCOPFImpl(AclfNetwork net ,double anglePenaltyCoeff) {
		this.setNetwork(net);
		this.setAnglePenaltyCoeff(anglePenaltyCoeff);
		solveDCOPF();

	}
    // constructor for creating A new instance of DCOPF
	public DCOPFImpl() {
		
	}
    public void initialize(){
    	this.numOfBranch=this.net.getNoBranch();
		this.numOfBus=this.net.getNoBus();
		this.numOfGen=this.getNumOfGen();
		formBusIndexTable();
		formG();
		formA();
		formCeq();
		formBeq();
		formCiq();
		formBiq();
    }
	public void solveDCOPF() {
	
		initialize();
		System.out.println("G:"+Apache2Colt.trans(G));
		System.out.println("A:"+Apache2Colt.trans(A));
		System.out.println("ceq:"+Apache2Colt.trans(Ceq));
		System.out.println("beq:"+Apache2Colt.trans(beq));
		System.out.println("Ciq:"+Apache2Colt.trans(Ciq));
		System.out.println("biq:"+Apache2Colt.trans(biq));
		//Apache2Colt is temporally used to change matrix format from a Apache to a Colt ;
		QuadProgJ qpj = new QuadProgJ(Apache2Colt.trans(G),
				Apache2Colt.trans(A),
				Apache2Colt.trans(Ceq),
				Apache2Colt.trans(beq),
				Apache2Colt.trans(Ciq),
				Apache2Colt.trans(biq));
		
		// NOTE FOR THE SOLUTION STRUCTURE x* = qpj.getMinX()
	    // x* = (p_{G1}...p_{GI}, delta_2...delta_K) for fixed demand
		this.optimX=qpj.getMinX();
		saveOPFResult();
		
	}
    private void saveOPFResult() {
    	this.optimGen=new double[this.getNumOfGen()];
    	this.busAngle=new double[this.numOfBus-1];
    	this.minTVC=0;
		for(int i=0;i<this.getNumOfGen();i++){
			this.optimGen[i]=getOptimX()[i];
			
			}
		for(int k=this.numOfGen;k<this.numOfGen+this.numOfBus-1;k++){
			this.busAngle[k-this.numOfGen]=getOptimX()[k]; // voltAngle in radians
		}
		int genIndex=0;
		for(Bus b:this.net.getBusList()){
			AclfBus acbus=(AclfBus) b;
			if(acbus.isGen()){
				acbus.setGenP(this.optimGen[genIndex]);
				genIndex++;
			}
		}
		int nonSwingBusIndex=0;
		for(Bus b:this.net.getBusList()){
			AclfBus acbus=(AclfBus) b;
			if(!acbus.isSwing()){
				acbus.setVoltageAng(this.busAngle[nonSwingBusIndex]);
				nonSwingBusIndex++;
			}
		}
		for(Bus b:this.net.getBusList()){
			AclfBus acbus=(AclfBus) b;
			if(acbus.isGen()&&GenBus4OPF.class.isInstance(acbus)){
				
				GenBus4OPF genOPF =(GenBus4OPF) acbus;
				System.out.println(genOPF.getId());
				this.minTVC=this.minTVC+genOPF.getCoeffA()*genOPF.getGenP()
				+genOPF.getCoeffB()*Math.pow(genOPF.getGenP(), 2);		
			}
		}
		
	}
    public double[] getOptimX(){
    	return this.optimX;
    }
	public Array2DRowRealMatrix getG(){
    	return this.G;
    }
	public Array2DRowRealMatrix getU() {
		return this.U;
	}
	public ArrayRealVector getA() {
		return this.A;
	}
	public Array2DRowRealMatrix getCeq() {
		return this.Ceq;
	}
	public ArrayRealVector getBeq() {
		return this.beq;
	}
	public Array2DRowRealMatrix getCiq() {
		return this.Ciq;
	}
	public ArrayRealVector getBiq() {
		return this.biq;
	}
	public void setAnglePenaltyCoeff(double anglePenaltyCoeff){
		this.anglePenCoeff=anglePenaltyCoeff;
	}
	public double getAnglePenaltyCoeff(){
		return this.anglePenCoeff;
	}
    
	@Override
	public double getMinTVC() {
	
		return this.minTVC;
	}

	@Override
	public double[] getBusAngle() {
		return this.busAngle;
	}

	@Override
	public double[] getOptimGen() {
		return this.optimGen;
	}

	public void setNetwork(AclfNetwork aNet) {
		this.net = aNet;
		this.numOfBus=this.net.getNoBus();
		this.numOfBranch=this.net.getNoBranch();
		this.numOfGen=this.getNumOfGen();
		System.out.println(this.numOfGen);
	}

	public AclfNetwork getNetwork() {
		return this.net;
	}

	private void formU() {
		this.U = new Array2DRowRealMatrix(this.getNumOfGen(),this.getNumOfGen());
		int genIndex=0;
		try{
		for(Bus b:this.getNetwork().getBusList()){
			if(GenBus4OPF.class.isInstance(b)){
				this.U.setEntry(genIndex, genIndex, ((GenBus4OPF)b).getCoeffB()*2);
				genIndex++;
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	

	private void formAngleDiffWeightMatrix() {
		int i = 0;
		int j = 0;
		double ADWij = 0;
		double ADWii = 0;
		AclfNetwork aNet = this.getNetwork();
		this.numOfBus = aNet.getNoActiveBus();
		this.angleDiffWeight = new Array2DRowRealMatrix(this.numOfBus,
				this.numOfBus);

		for (Bus b : aNet.getBusList()) {
			Bus busi = b;
			ADWij = 0;
			ADWii = 0;
			i = this.getBusIndex(b.getId());
			for (Branch bra : busi.getFromBranchList()) {
				Bus busj = bra.getToBus();
				j = this.getBusIndex(busj.getId());
				ADWij = -1;
				ADWii++;
				this.angleDiffWeight.setEntry(i, j, ADWij);
				this.angleDiffWeight.setEntry(j, i, ADWij);

			}
			this.angleDiffWeight.setEntry(i, i, busi.getBranchList().size());
		}
		
		this.angleDiffWeight=(Array2DRowRealMatrix)this.angleDiffWeight.scalarMultiply(2*this.getAnglePenaltyCoeff());
	}
    public Array2DRowRealMatrix getAngleDiffWeightMatrix(){
    	return this.angleDiffWeight;
    }
	private void formReducedADWMatrix() {
		formAngleDiffWeightMatrix();
		int[] selectedRows = new int[this.angleDiffWeight.getRowDimension() - 1];
		try {
			selectedRows = this.getNonSwingBusRows();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.Wrr = (Array2DRowRealMatrix) this.angleDiffWeight.getSubMatrix(
				selectedRows, selectedRows);

	}

	public Array2DRowRealMatrix getWrr() {
		return this.Wrr;
	}


	private void formG() {
		formU();
		formReducedADWMatrix();
		RealMatrix U_matrix = this.getU();
		RealMatrix Wrr_matrix = this.getWrr();
		int Grows = U_matrix.getRowDimension() + Wrr_matrix.getRowDimension();
		int Gcols = Grows;
		
		this.G = new Array2DRowRealMatrix(Grows, Gcols);
		this.G.setSubMatrix(U_matrix.getData(), 0, 0);
		this.G.setSubMatrix(Wrr_matrix.getData(), U_matrix.getRowDimension(),
				U_matrix.getColumnDimension());

	}

	private void formA() {
		this.A = new ArrayRealVector(this.numOfGen + this.numOfBus - 1);
		this.A.set(0, getGenCoeffAVector());

	}
	private ArrayRealVector getGenCoeffAVector(){
		ArrayRealVector genFixCostVector =new ArrayRealVector(this.numOfGen);
        int i=0;
		// get the constraint data from network file ;
	      for (Bus b:this.net.getBusList()) {
	    	  AclfBus acBus= (AclfBus)b;
	    	  if(acBus.isGen()&&GenBus4OPF.class.isInstance(acBus)){
	    		  GenBus4OPF genOPF= (GenBus4OPF) acBus;
	    		  genFixCostVector.setEntry(i, genOPF.getCoeffA());
	  			i++;
	    	  }
	       }
		return genFixCostVector;
	}
	private void formCeq() {
		Array2DRowRealMatrix CeqTranspose = new Array2DRowRealMatrix(
				this.numOfBus, this.numOfBus + this.numOfGen - 1);
		Ceq = new Array2DRowRealMatrix(this.numOfBus + this.numOfGen - 1,
				this.numOfBus);
		AclfNetwork net = this.getNetwork();
		Array2DRowRealMatrix genBusAdjacent = new Array2DRowRealMatrix(
				this.numOfBus, this.numOfGen);
		Array2DRowRealMatrix BrTranspose = new Array2DRowRealMatrix(
				this.numOfBus, this.numOfBus - 1); // reduced bus admittance
													// matrix

		int genCount = 0;
		for (Bus b : net.getBusList()) {
			AclfBus busi = (AclfBus) b;
			// set the elements in genBusAdjacent matrix to ONE if there is a
			// generator ;
			/*
			 * in the case of multi-gen ,all are treated as a union;
			 * not suitable for a case with multi-generators connected to one
			 * bus;
			 */
			if (busi.isGen()) {
				genBusAdjacent.setEntry(this.getBusIndex(busi.getId()), genCount, 1);
				genCount++;
			}
		}
		BrTranspose = (Array2DRowRealMatrix) this.getReducedBusAdmittance()
				.transpose();

		CeqTranspose.setSubMatrix(genBusAdjacent.getData(), 0, 0); // Ceq'={genBusAdjacent,BrTranspose}
		CeqTranspose.setSubMatrix(BrTranspose.scalarMultiply(-1).getData(), 0, this.numOfGen);
		Ceq = (Array2DRowRealMatrix) CeqTranspose.transpose();

	}

	private void formBeq() {
		AclfNetwork net = this.getNetwork();
		this.beq = new ArrayRealVector(net.getNoActiveBus());
		int busIndex = 0;
		for (Bus b : net.getBusList()) {
			AclfBus acbus = (AclfBus) b;
			busIndex = this.getBusIndex(acbus.getId());
			if (acbus.isLoad()) {
				beq.setEntry(busIndex, acbus.getLoadP());
			}
		}

	}

	private void formCiq() {

		Array2DRowRealMatrix braAdmDiag = new Array2DRowRealMatrix(
				this.numOfBranch, this.numOfBranch);
		Array2DRowRealMatrix braBusAdjacent = new Array2DRowRealMatrix(
				this.numOfBranch, this.numOfBus - 1);
		Array2DRowRealMatrix eyeGenP = new Array2DRowRealMatrix(this.numOfGen,
				this.numOfGen);
		Array2DRowRealMatrix CiqTranspose = new Array2DRowRealMatrix(
				this.numOfBranch * 2 + this.numOfGen * 2, this.numOfGen
						+ this.numOfBus - 1);

		final double DEFAULT_BIJ = 10000; // 10000=1/0.0001 ,that is set the
											// line Xij minimum to be 0.0001;
		double bij = DEFAULT_BIJ;
		int braIndex = 0;
		int fromBusIndex = 0;
		int toBusIndex = 0;

		for (Branch bra : this.net.getBranchList()) {
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
		for (Bus b : this.net.getBusList()) {
			AclfBus acbus = (AclfBus) b;
			if (acbus.isGen()) {
				eyeGenP.setEntry(genIndex, genIndex, 1);
				genIndex++;
			}
		}
		Array2DRowRealMatrix DAr = braAdmDiag.multiply(braBusAdjacent);
		// Ciq'={Ot,-braAdmDiag*braBusAdjacent;
		//     -Ot,braAdmDiag*braBusAdjacent;
		//      eyeGenP,Op;
		//      -eyeGenP,-Op}

		CiqTranspose.setSubMatrix(DAr.scalarMultiply(-1).getData(), 0,
				this.numOfGen);
		CiqTranspose.setSubMatrix(DAr.getData(), this.numOfBranch,
				this.numOfGen);
		CiqTranspose.setSubMatrix(eyeGenP.getData(), 2 * this.numOfBranch, 0);
		CiqTranspose.setSubMatrix(eyeGenP.scalarMultiply(-1).getData(), 2
				* this.numOfBranch + this.numOfGen, 0);

		// Ciq=CiqTranspose'
		this.Ciq = (Array2DRowRealMatrix) CiqTranspose.transpose();

	}

	private void formBiq() {
		this.biq = new ArrayRealVector(this.numOfBranch * 2 + this.numOfGen * 2);

		formBranchMvaConstraint();
		formGenInequConstraint();
		this.biq.set(0, this.getBt());
		this.biq.set(this.numOfBranch, this.getBt());
		this.biq.set(this.numOfBranch * 2, this.getbPL());
		this.biq.set(this.numOfGen + this.numOfBranch * 2, this.getbPU());

	}

	private ArrayRealVector getBt() {
		return this.bt;
	}

	private ArrayRealVector getbPL() {
		return this.bPL;
	}

	private ArrayRealVector getbPU() {
		return this.bPU;
	}

	private void formBranchMvaConstraint() {
		// bt corresponds to line thermal inequality constraints
		this.bt = new ArrayRealVector(this.numOfBranch); 
		double ratingMva1 = 0;
		int braIndex = 0;
		// form the bt;
		for (Branch bra : this.getNetwork().getBranchList()) {
			AclfBranch acBranch = (AclfBranch) bra;
			ratingMva1 = acBranch.getRatingMva1();
			bt.setEntry(braIndex, -ratingMva1);
			braIndex++;
		}

	}

	private void formGenInequConstraint() {
		// including bPL, bPU;
		this.bPL = new ArrayRealVector(this.numOfGen); // bPL corresponds to
														// generators' lower
														// active power limit
		this.bPU = new ArrayRealVector(this.numOfGen); // bPU corresponds to
														// generators' upper
														// active power limit
         int i=0;
		// get the constraint data from network file ;
	      for (Bus b:this.net.getBusList()) {
	    	  AclfBus acBus= (AclfBus)b;
	    	  if(acBus.isGen()&&GenBus4OPF.class.isInstance(acBus)){
	    		  GenBus4OPF genOPF= (GenBus4OPF) acBus;
	    		  
	    		bPL.setEntry(i, genOPF.getCapLowerLimit());
	  			bPU.setEntry(i, -genOPF.getCapUpperLimit());
	  			i++;
	    	  }
			
		}
		// or from custom defined data ;
	
	}

	private Array2DRowRealMatrix getReducedBusAdmittance() {

		// form the reduced bus admittance matrix by omitting the row
		// corresponding to the SWING bus ;
		// here B1 formed by InterPSS itself is under consideration to be reused
		// ;

		Array2DRowRealMatrix busAdmReduced = new Array2DRowRealMatrix(
				this.numOfBus - 1, this.numOfBus); // reduced bus admittance
													// matrix
		Array2DRowRealMatrix tempBusAdm = new Array2DRowRealMatrix(
				this.numOfBus, this.numOfBus);

		for (Bus b : net.getBusList()) {
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
		int[] NonSwingBusRows = new int[net.getNoActiveBus() - 1];
		int idx = 0;

		for (int busIndex = 0; busIndex < net.getNoActiveBus(); busIndex++) {
			Bus b = this.net.getBusList().get(busIndex);
			AclfBus bus = (AclfBus) b;
			if (!bus.isSwing()) {
				// swingSortNum=bus.getSortNumber();
				NonSwingBusRows[idx] = busIndex;
				idx++;
			}
		}
		return NonSwingBusRows;
	}

	private void formBusIndexTable() {
		this.busIndexTable=new Hashtable<String, Integer>(net.getNoBus()*2);
//		this.sortNumber2OriginIdx = new int[net.getNoBus() + 1];
//		this.sortNum2OrgIdx_List = new ArrayList<Integer>(net.getNoBus() + 1);
		int idx = 0;

		for (int busIndex = 0; busIndex < net.getNoBus(); busIndex++) {
			Bus b = this.net.getBusList().get(busIndex);
//			this.sortNumber2OriginIdx[b.getSortNumber()] = busIndex;
//			this.sortNum2OrgIdx_List.add(b.getSortNumber(), busIndex);
			this.busIndexTable.put(b.getId(), busIndex);
		}

	}

//	public int[] getSortNumber2Index() {
//		return this.sortNumber2OriginIdx;
//	}
//
//	public List<Integer> getBusIndex() {
//		return this.sortNum2OrgIdx_List;
//	}
	private int getBusIndex(String busId){
		return getBusIndexTable().get(busId);
	}
	private int getSwingBusIndex(){
		int swingBusIndex=0;
		for(Bus b:this.net.getBusList()){
			if(((AclfBus)b).isSwing()){
				swingBusIndex=getBusIndexTable().get(b.getId());
				break;
			}
		}
		return swingBusIndex;
	}

	public Hashtable<String, Integer> getBusIndexTable(){
		return this.busIndexTable;
	}
	
    private int getNumOfGen(){
    	int numOfGen=0;
    	for(Bus b:this.getNetwork().getBusList()){
    		if(((AclfBus)b).isGen()) numOfGen++;
    	}
    	return numOfGen;
    }
}
