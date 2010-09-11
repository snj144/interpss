package org.interpss.opf.dc;

import com.interpss.opf.OpfNetwork;

public interface DCOPF {
	
	
	public void loadOpfNetData(OpfNetwork opfNet);
	
	public void runDCOPF();
	
	public double[] getOptimGen();

	public double[] getBusAngle();

	public double getMinTVC();
	
    public double getMinF();
	
	public double[] getAllMultipliers();
	
	public double[] getBindingInequMultipliers();
	
	public double[] getEquMultipliers();
	
	public double[] getInequMultipliers();
	
	public void printInputData();
	
	public void printOutputSolution();
	
	

}
