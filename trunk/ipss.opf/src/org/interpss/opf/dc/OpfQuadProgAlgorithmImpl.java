package org.interpss.opf.dc;

import com.interpss.core.aclf.AclfBus;
import com.interpss.core.net.Bus;
import com.interpss.opf.OpfNetwork;

public class OpfQuadProgAlgorithmImpl implements OpfQuadProgAlgorithm {
    protected final OpfNetwork DEFAULT_OPF_NETWORK=null;
	//protected OpfNetwork opfnet=DEFAULT_OPF_NETWORK;
	
	protected final boolean DEFAULT_OPFDATA_LOADED=false;
    protected boolean opfNetDataLoaded=DEFAULT_OPFDATA_LOADED;
    
	protected final boolean DEFAULT_OPFDATA_CHECKED=false;
    protected boolean opfNetDataChecked=DEFAULT_OPFDATA_CHECKED;
    
    protected final double DEFAULT_ANGLE_PENN_COEFF=0;
    protected double _anglePennCoeff=DEFAULT_ANGLE_PENN_COEFF;
    
    // OPF result
	private double[] optimX=null;
    private double[] busAngle=null;
    
    protected QuadProgCalculator qpc=null;
    
    public OpfQuadProgAlgorithmImpl(){
    }

	@Override
	public boolean isOPFDataChecked() {
		return this.opfNetDataChecked;
	}

	@Override
	public void runDCOPF(OpfNetwork opfNet) {
		qpc= new QuadProgCalculator();
		qpc.setNetwork(opfNet);
		qpc.solveQP();
		saveOPFResult(opfNet);
		
	}
	
	@Override
	public boolean isOPFNetDataLoaded() {
		return this.opfNetDataLoaded;
	}
	
	@Override
	public void setAnglePennCoeff(double anglePennCoeff) {
		this._anglePennCoeff=anglePennCoeff;
		
	}
	@Override
	public double getAnglePennCoeff() {
		return this._anglePennCoeff;
	}

	
  private void saveOPFResult(OpfNetwork opfnet) {
	this.optimX=getQuadProgCalulator().getOptimX();
	this.busAngle=new double[opfnet.getNoActiveBus()-1];
	int noOfGen = getNumOfGen(opfnet);
	for(int k=noOfGen;k<noOfGen+opfnet.getNoActiveBus()-1;k++){
		this.busAngle[k-noOfGen]=optimX[k]; // voltAngle in radians
	}
	int genIndex=0;
	for(Bus b:opfnet.getBusList()){
		if(opfnet.isOpfGenBus(b)){
			((AclfBus) b).setGenP(optimX[genIndex]);
			genIndex++;
		}
	}
	int nonSwingBusIndex=0;
	for(Bus b: opfnet.getBusList()){
		AclfBus acbus=(AclfBus) b;
		if(!acbus.isSwing()){
			acbus.setVoltageAng(this.busAngle[nonSwingBusIndex]);
			nonSwingBusIndex++;
		}
	}
	
}
  public QuadProgCalculator getQuadProgCalulator(){
	  return this.qpc;
	  
  }
  private int getNumOfGen(OpfNetwork opfnet){
	  int numOfGen=0;
	  for(Bus b:opfnet.getBusList()){
		  AclfBus acbus=(AclfBus) b;
		  if(acbus.isGen()){
			  numOfGen++;
		  }
	  }
	  return numOfGen;
  }

}
