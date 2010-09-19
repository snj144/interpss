package org.interpss.opf.dc;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.net.Bus;
import com.interpss.opf.OpfGenBus;
import com.interpss.opf.OpfNetwork;
import com.interpss.opf.common.IOpfGenBusVisitor;

public class OpfQuadProgAlgorithmImpl implements OpfQuadProgAlgorithm {
    protected final OpfNetwork DEFAULT_OPF_NETWORK=null;
	protected OpfNetwork opfnet=DEFAULT_OPF_NETWORK;
	
	protected final boolean DEFAULT_OPFDATA_LOADED=false;
    protected boolean opfNetDataLoaded=DEFAULT_OPFDATA_LOADED;
    
	protected final boolean DEFAULT_OPFDATA_CHECKED=false;
    protected boolean opfNetDataChecked=DEFAULT_OPFDATA_CHECKED;
    
    protected final double DEFAULT_ANGLE_PENN_COEFF=0;
    protected double _anglePennCoeff=DEFAULT_ANGLE_PENN_COEFF;
    
    protected static final IPSSMsgHub MSG_HUB_EDEFAULT = null;
    protected IPSSMsgHub msg = MSG_HUB_EDEFAULT;
    
	private int numOfBus=0;
	private int numOfGen=0;
	private int numOfBranch=0;
	
    // OPF result
	private double[] optimX=null;
    private double[] busAngle=null;
    
    protected QuadProgCalculator qpc=null;
    
    public OpfQuadProgAlgorithmImpl(OpfNetwork opfNet, IPSSMsgHub msgHub){
    	if(opfNet!=null){
    	this.opfnet=opfNet;
    	opfNetDataLoaded=true;
    	}
    	this.msg=msgHub;
    }

	@Override
	public boolean isOPFDataChecked() {
		return this.opfNetDataChecked;
	}

	@Override
	public void runDCOPF() {
		qpc= new QuadProgCalculator();
		qpc.setNetwork(opfnet);
		qpc.solveQP();
		saveOPFResult();
		
	}
	@Override
	public void setOpfNetwork(OpfNetwork opfNet) {
		this.opfnet=opfNet;
		
	}
	
	@Override
	public OpfNetwork getOpfNetwork() {
		if(opfnet==null){
			System.out.print("Error: no OpfNetwork data loaded yet,please check it!");
			System.exit(1);
		}
		return this.opfnet;
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

	
  private void saveOPFResult() {
	this.optimX=getQuadProgCalulator().getOptimX();
	this.busAngle=new double[this.opfnet.getNoActiveBus()-1];
	for(int k=getNumOfGen();k<getNumOfGen()+this.opfnet.getNoActiveBus()-1;k++){
		this.busAngle[k-getNumOfGen()]=optimX[k]; // voltAngle in radians
	}
	int genIndex=0;
	for(Bus b:this.opfnet.getBusList()){
		if(opfnet.isOpfGenBus(b)){
			((AclfBus) b).setGenP(optimX[genIndex]);
			genIndex++;
		}
	}
	int nonSwingBusIndex=0;
	for(Bus b:this.opfnet.getBusList()){
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
  private int getNumOfGen(){
	  this.numOfGen=0;
	  for(Bus b:opfnet.getBusList()){
		  AclfBus acbus=(AclfBus) b;
		  if(acbus.isGen()){
			  this.numOfGen++;
		  }
	  }
	  return this.numOfGen;
  }

}
