package dev;

import psat.FileAdpater_PSATFormat;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.StdoutMsgListener;
import com.interpss.common.msg.TextMessage;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.util.outfunc.AclfOut;
import com.interpss.simu.SimuContext;
import com.interpss.simu.io.IpssFileAdapter;

public class TestAdapter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IPSSMsgHub msg = null;
		try {
			msg = new IPSSMsgHub();
			msg.addMsgListener(new StdoutMsgListener(TextMessage.TYPE_STATUS));

			IpssFileAdapter adapter = new FileAdpater_PSATFormat();
			SimuContext simuCtx = adapter.load("testData/d_test_mdl.psat", msg);
			
		  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(simuCtx.getAclfAdjNet());

		  	// use the loadflow algorithm to perform loadflow calculation
		  	algo.loadflow(msg);
		  	
		  	// output loadflow calculation results
		  	System.out.println(AclfOut.loadFlowSummary(simuCtx.getAclfAdjNet()));
 		} catch (Exception e) {
 			e.printStackTrace();
		}
	}

}
