package org.interpss.gridgain;

import com.interpss.core.aclf.AclfNetwork;
import com.interpss.simu.multicase.MultiStudyCase;

public interface IMultiCaseResultHandler {
	/**
	 * Save remote simulation results into the result table
	 * 
	 * @param resultTable
	 * @param net
	 */
	public void saveAclfResult(RmoteGridNodeResult resultTable, AclfNetwork net);
	
	/**
	 * Transfer the results save to the resultTable to the multi study case container
	 * 
	 * @param mCaseContainer
	 * @param resultTable
	 */
	public void transferAclfResult(MultiStudyCase mCaseContainer, RmoteGridNodeResult resultTable);
}
