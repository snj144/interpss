package org.interpss.sample.gml;

import org.graphdrawing.gml.EdgeType;
import org.graphdrawing.gml.GraphType;
import org.graphdrawing.gml.GraphmlType;
import org.graphdrawing.gml.NodeType;
import org.interpss.PluginSpringAppContext;
import org.interpss.custom.IpssFileAdapter;
import org.interpss.display.AclfOutFunc;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IPSSMsgHubImpl;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;

public class IEEE14GmlImpl {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// InterPSS core simulation engine configuration
		SpringAppContext.setAppContext(Constants.SpringConfigPath_Plugin);

    	/*
    	 * step-1 Build the base case
    	 */
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee14.ieee");
		AclfNetwork adjNet = simuCtx.getAclfNet();
		
		GraphmlType gml = GmlHelper.load("testData/gml/sample_001.gml");
		for (Object obj : gml.getGraphOrData()) {
			if (obj instanceof GraphType) {
				// for each graph object, create a AclfNetwork object
				GraphType graph = (GraphType)obj;
				for ( Object o : graph.getDataOrNodeOrEdge()) {
					if (o instanceof NodeType) {
						NodeType node = (NodeType)o;
						System.out.println("Node: " + node.getId());
					}
					else if (o instanceof EdgeType) {
						EdgeType edge = (EdgeType)o;
						System.out.println("Edge: " + edge.getSource() + "->" + edge.getTarget());
					}
				}
			}
		}
    		
		/*
		 * step-2 Define LF algorithm
		 */
		IPSSMsgHub msg = new IPSSMsgHubImpl();
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(adjNet, msg);
	  	algo.setNonDivergent(true);
	  	//algo.setLfMethod(AclfMethod.PQ);
	  	
	  	algo.loadflow();
	  	System.out.println(AclfOutFunc.loadFlowSummary(adjNet));
	}
}
