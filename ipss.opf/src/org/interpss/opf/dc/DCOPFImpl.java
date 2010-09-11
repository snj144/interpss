package org.interpss.opf.dc;
import java.util.ArrayList;
import java.util.Hashtable;


import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.*;
import com.interpss.core.aclf.impl.AclfBusImpl;
import com.interpss.core.algorithm.BusArrangeRule;
import com.interpss.core.algorithm.NetworkAlgorithm;
import com.interpss.core.common.IAclfBusVisitor;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.opf.OpfGenBus;
import com.interpss.opf.OpfNetwork;
import com.interpss.opf.OpfObjectFactory;
import com.interpss.opf.common.IOpfGenBusVisitor;

import org.interpss.opf.dc.Apache2ColtAdapter;


import org.apache.commons.math.linear.*;

import quadprogj.QuadProgJ;

public class DCOPFImpl implements DCOPF {
	// network
	private OpfNetwork net=null;
	// attributes of network

	private int numOfBus=0;
	private int numOfGen=0;
	private int numOfBranch=0;
	private RealMatrix B; // BUS Admittance
	
    // OPF result
	private double[] optimX=null;
	private double[] optimGen=null;
    private double[] busAngle=null;
	

	// attributes for DC-OPF;
    public final static double DEFAULT_AnglePenCoff=1;
	private double anglePenCoeff=DEFAULT_AnglePenCoff;
	private double minTVC=0;// minTVC = SUM (Ai*PGi + Bi*PGi^2)
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
	private ArrayRealVector b_Pmin;
	private ArrayRealVector b_Pmax;
	
	// used for store the bus and bus index relationship
	private Hashtable<String,Integer> busIndexTable;
	
	// QuadProgJ 
	QuadProgJ qpj= null;

	// used for transform apache matrix to colt;
	private Apache2ColtAdapter Apache2Colt=new Apache2ColtAdapter();
	

	public DCOPFImpl(OpfNetwork opfNet) {
		this.setNetwork(opfNet);
		this.setAnglePenaltyCoeff(opfNet.getAnglePenaltyFactor());
//		solveDCOPF();

	}
    // constructor for creating A new instance of DCOPF
	public DCOPFImpl() {
		
	}
    protected void initialize(){
    	if(this.net==null) {
    		System.out.println("Error: no OpfNetwork data is inputed yet, please check the data file and make sure load it first");
  	  		return;
    	}
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
    @Override
	public void runDCOPF() {
	
		initialize();
		System.out.println("G:"+Apache2Colt.trans(G));
		System.out.println("A:"+Apache2Colt.trans(A));
		System.out.println("ceq:"+Apache2Colt.trans(Ceq));
		System.out.println("beq:"+Apache2Colt.trans(beq));
		System.out.println("Ciq:"+Apache2Colt.trans(Ciq));
		System.out.println("biq:"+Apache2Colt.trans(biq));
		//Apache2Colt is temporally used to change matrix format from a Apache to a Colt ;
		qpj = new QuadProgJ(Apache2Colt.trans(G),
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
		
       this.net.forEachOpfGenBus(new IOpfGenBusVisitor(){
    	   public void visit(OpfGenBus opfgen) {
				minTVC+=opfgen.getCoeffA()*opfgen.getGenP()
				+opfgen.getCoeffB()*Math.pow(opfgen.getGenP(), 2);		
			}	
	   });
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

	public void setNetwork(OpfNetwork OpfNet) {
		this.net = OpfNet;
		this.numOfBus=this.net.getNoBus();
		this.numOfBranch=this.net.getNoBranch();
		this.numOfGen=this.getNumOfGen();
		System.out.println(this.numOfGen);
	}

	public OpfNetwork getNetwork() {
		return this.net;
	}

	private void formU() {
		this.U = new Array2DRowRealMatrix(this.getNumOfGen(),this.getNumOfGen());
		int genIndex=0;
		try{
		for(Bus b:this.getNetwork().getBusList()){
			if(net.isOpfGenBus(b)){
				this.U.setEntry(genIndex, genIndex, 
						(net.toOpfGenBus(b)).getCoeffB()*2);
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
	      for (Bus bus:this.net.getBusList()) {
	    	  if(net.isOpfGenBus(bus)){
	    		  OpfGenBus genOPF= net.toOpfGenBus(bus);
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
		OpfNetwork net = this.getNetwork();
		Array2DRowRealMatrix genBusAdjacent = new Array2DRowRealMatrix(
				this.numOfBus, this.numOfGen);
		Array2DRowRealMatrix BrTranspose = new Array2DRowRealMatrix(
				this.numOfBus, this.numOfBus - 1); // reduced bus admittance
													// matrix

		int genCount = 0;
		for (Bus b : net.getBusList()) {
			
			// set the elements in genBusAdjacent matrix to ONE if there is a
			// generator ;
			/*
			 * in the case of multi-gen ,all are treated as a union;
			 * not suitable for a case with multi-generators connected to one
			 * bus;
			 */
			if (net.isOpfGenBus(b)) {
				genBusAdjacent.setEntry(this.getBusIndex(b.getId()), genCount, 1);
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

		final double DEFAULT_BIJ = 10000; // 10000=1/0.0001 ,namely set the
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
		for (Bus bus : this.net.getBusList()) {
			if (net.isOpfGenBus(bus)) {
				eyeGenP.setEntry(genIndex, genIndex, 1);
				genIndex++;
			}
		}
		Array2DRowRealMatrix DAr = braAdmDiag.multiply(braBusAdjacent);
		// Ciq'={Ot,-braAdmDiag*braBusAdjacent;
		//     -Ot,braAdmDiag*braBusAdjacent;
		//      eyeGenP,Op;
		//      -eyeGenP,-Op}

		CiqTranspose.setSubMatrix(DAr.scalarMultiply(-1).getData(), 0,this.numOfGen);
		CiqTranspose.setSubMatrix(DAr.getData(), this.numOfBranch,this.numOfGen);
		CiqTranspose.setSubMatrix(eyeGenP.getData(), 2 * this.numOfBranch, 0);
		CiqTranspose.setSubMatrix(eyeGenP.scalarMultiply(-1).getData(), 2* this.numOfBranch + this.numOfGen, 0);
		// Ciq=CiqTranspose'
		this.Ciq = (Array2DRowRealMatrix) CiqTranspose.transpose();

	}

	private void formBiq() {
		this.biq = new ArrayRealVector(this.numOfBranch * 2 + this.numOfGen * 2);
		formBranchMvaConstraint();
		formGenInequConstraint();
		this.biq.set(0, this.getBt());
		this.biq.set(this.numOfBranch, this.getBt());
		this.biq.set(this.numOfBranch * 2, this.getBGenPmin());
		this.biq.set(this.numOfGen + this.numOfBranch * 2, this.getBGenPmax());

	}

	private ArrayRealVector getBt() {
		return this.bt;
	}

	private ArrayRealVector getBGenPmin() {
		return this.b_Pmin;
	}

	private ArrayRealVector getBGenPmax() {
		return this.b_Pmax;
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
		// including b_Pmin, b_Pmax;
		this.b_Pmin = new ArrayRealVector(this.numOfGen); // b_Pmin corresponds to generators' lower active power limit
		this.b_Pmax = new ArrayRealVector(this.numOfGen); // b_Pmax corresponds to generators' upper active power limit
        int i=0;
		// get the constraint data from network file ;
	    for (Bus bus:this.net.getBusList()) {
	    	  if(net.isOpfGenBus(bus)){
	    		OpfGenBus genOPF=net.toOpfGenBus(bus);	    		  
	    		b_Pmin.setEntry(i, genOPF.getCapacityLimit().getMin());
	  			b_Pmax.setEntry(i, -genOPF.getCapacityLimit().getMax());
	  			i++;
	    	  }
			
		}	
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
		for (int busIndex = 0; busIndex < net.getNoBus(); busIndex++) {
			Bus b = this.net.getBusList().get(busIndex);
			this.busIndexTable.put(b.getId(), busIndex);
		}

	}
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

	private Hashtable<String, Integer> getBusIndexTable(){
		return this.busIndexTable;
	}
	
    private int getNumOfGen(){
    	if(this.numOfGen==0) countNumofGen();
        return this.numOfGen;
    }
    private void setNumofGen(int _numOfGen) {
    	this.numOfGen=_numOfGen;
    }
    private void countNumofGen() {
    	int numOfGen=0;
    	for(Bus b:this.getNetwork().getBusList()){
    		if(this.net.isOpfGenBus(b)) numOfGen++;
    	}
    	setNumofGen(numOfGen);
    }
	@Override
	public double[] getAllMultipliers() {
		
		return qpj.getAllMultipliers();
	}
	@Override
	public double[] getBindingInequMultipliers() {
		return qpj.getBindingIneqMultipliers();
	}
	@Override
	public double[] getEquMultipliers() {
		return qpj.getEqMultipliers();
	}
	@Override
	public double[] getInequMultipliers() {
		return qpj.getIneqMultipiers();
	}
	@Override
	public double getMinF() {
				return qpj.getMinF();
	}
	@Override
	public void loadOpfNetData(OpfNetwork opfNet) {
		this.setNetwork(opfNet);
		
	}
	@Override
	public void printInputData() {
		qpj.printInputData();
		
	}
	@Override
	public void printOutputSolution() {
		qpj.printOutputSolution();
		
	}
}
