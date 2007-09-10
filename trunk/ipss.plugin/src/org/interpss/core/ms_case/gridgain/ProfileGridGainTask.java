package org.interpss.core.ms_case.gridgain;

import java.util.Collection;
import java.util.logging.Level;

import org.eclipse.emf.ecore.EObject;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJob;
import org.interpss.core.grid.gridgain.IpssGridGainTask;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.ms_case.GridMultiStudyCase;

public class ProfileGridGainTask extends IpssGridGainTask {
	private static final long serialVersionUID = 1;
	
	@Override
	protected Collection<? extends GridJob> split(int gridSize, EObject model) throws GridException {
		IpssLogger.getLogger().setLevel(Level.WARNING);
		
		GridMultiStudyCase gridMCase = (GridMultiStudyCase)model;
/*		
		List<GridJob> jobs = new ArrayList<GridJob>(24);

		for (int i = 1; i <= 24; i++ ) {
			// create study case i
			int caseNumber = i;
			CoreObjectFactory.createStudyCase("StudyCase"+i, "Case" + i, caseNumber, gridMCase);
			gridMCase.getNetwork().setSortNumber(caseNumber);
			
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			SerializeEMFObjectUtil.saveModel(gridMCase.getNetwork(), outStream);
			String modelStr = outStream.toString();
			
            jobs.add(new GridJobAdapter<String>(modelStr) {
            	private static final long serialVersionUID = 1;
                public Serializable execute() {
                	// This is necessary to init for EMF 
                	CorePackage corePackage = CorePackage.eINSTANCE;
                	String modelStr = getArgument();
                	//System.out.println(modelStr);
            		AclfNetwork net = (AclfNetwork)SerializeEMFObjectUtil.loadModel(modelStr);
            		
            		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
            		algo.loadflow(SpringAppContext.getIpssMsgHub());
            		
            		String str = "Net case number - " + net.getSortNumber(); 
            		System.out.println(str);
            		return str;
                }
            });
		}
*/
        return gridMCase.getGridJobs();
     }
}

