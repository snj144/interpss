package org.interpss.opf.dc;

import com.interpss.opf.OpfNetwork;

public class OpfQuadProgAlgorithmImpl implements OpfQuadProgAlgorithm {
    protected final OpfNetwork DEFAULT_OPF_NETWORK=null;
	protected OpfNetwork opfnet=DEFAULT_OPF_NETWORK;
	protected final boolean DEFAULT_OPFDATA_LOADED=false;
    protected boolean opfNetDataLoaded=DEFAULT_OPFDATA_LOADED;
    protected final double DEFAULT_ANGLE_PENN_COEFF=0;
    protected double _anglePennCoeff=DEFAULT_ANGLE_PENN_COEFF;

	@Override
	public boolean isOPFDataChecked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void runDCOPF() {
		// TODO Auto-generated method stub
		
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

}
