package org.interpss.opf.dc;

import com.interpss.opf.OpfNetwork;

public interface OpfQuadProgAlgorithm {
	
	public void runDCOPF(OpfNetwork opfNet);
	
	public boolean isOPFDataChecked();
	
	public void setAnglePennCoeff(double anglePennCoeff);
	
	public double getAnglePennCoeff();
	
	public boolean isOPFNetDataLoaded();

}
