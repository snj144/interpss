package org.interpss.sample.gml;

import java.util.List;

import org.graphdrawing.gml.GraphType;
import org.graphdrawing.gml.GraphmlType;
import org.interpss.custom.IpssFileAdapter;
import org.interpss.display.AclfOutFunc;
import org.interpss.spring.PluginSpringCtx;

import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.impl.IPSSMsgHubImpl;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algo.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.spring.CoreCommonSpringCtx;

public class IEEE14GmlImpl {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// InterPSS core simulation engine configuration
		CoreCommonSpringCtx.setAppContext(Constants.SpringConfigPath_Plugin);

    	// Build the base case network
		IpssFileAdapter adapter = PluginSpringCtx.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee14.ieee");
		AclfNetwork adjNet = simuCtx.getAclfNet();
		
		// load the Gml file
		GraphmlType gml = GmlHelper.load("testData/gml/sample_001.gml");
		
		// retrieve all Graph objects, there may be more than one graphs
		List<GraphType> glist = GmlHelper.getGraphObjects(gml);
		
		for (GraphType graph : glist) {
			// for each graph object, create a sub network
			AclfNetwork subNet = GmlHelper.createSubNet(adjNet, graph);

			// Define LF algorithm for the sub network 
			IPSSMsgHub msg = new IPSSMsgHubImpl();
		  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(subNet);
		  	algo.setNonDivergent(true);
		  	//algo.setLfMethod(AclfMethod.PQ);
		  	
		  	// perform loadflow to the sub network
		  	algo.loadflow();
		  	System.out.println(AclfOutFunc.loadFlowSummary(subNet));
		}
	}
}
