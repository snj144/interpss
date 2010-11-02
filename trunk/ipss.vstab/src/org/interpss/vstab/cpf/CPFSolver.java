package org.interpss.vstab.cpf;

import org.apache.commons.math.linear.RealMatrix;

public interface CPFSolver {
	
	public RealMatrix getPredictedResult();
	
	public RealMatrix getCorrectedResult();
	
	public Boolean isCPFConverged();
	
	

}
