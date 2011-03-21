package org.interpss.opf.dc;

import java.util.Hashtable;

public interface DCOPFSolver {
	
	
	public boolean isDCOPFSolved();
	
    public boolean solveDCOPF();
     
 	public Hashtable<String, Double> getBusEqMultiplier();
 	
	public Hashtable<String, Double> getGenBusIneqMultiplier();
	
	public Hashtable<String, Double> getBranchIneqMultiplier();
	
	public double getMinF();
	
	
}
