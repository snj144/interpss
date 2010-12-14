package org.interpss.vstab.cpf;


public interface CPFSolver {

	public boolean solveCPF();
	
	public boolean isCPFConverged();
	public void setCpfConverged(boolean convg);
	
	public boolean predictorStep();
	
	public boolean correctorStep();

}
