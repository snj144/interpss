package org.interpss.opf.dc;

import com.interpss.opf.OpfNetwork;

public interface OpfQuadProgAlgorithm {
	
	public void runDCOPF();
	
	public boolean isOPFDataChecked();
	
	public void setAnglePennCoeff(double anglePennCoeff);
	
	public double getAnglePennCoeff();
	
	public OpfNetwork getOpfNetwork();
	
	public void setOpfNetwork(OpfNetwork opfNet);
	
	public boolean isOPFNetDataLoaded();

}
