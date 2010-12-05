package org.interpss.test.facts;

import org.ieee.odm.adapter.IODMAdapter;
import org.ieee.odm.adapter.ieeecdf.IeeeCDFAdapter;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.interpss.spring.PluginSpringCtx;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;


// Active power digraph of InterPSS network model
public class IPSSActivePowerDigraph {

	private String networkName;
	private AclfNetwork net;
	private DirectedWeightedMultigraph<String, DefaultWeightedEdge> pDigraph;	// Active power digraph
	
	// Constructor, build the network model
	public IPSSActivePowerDigraph(String networkName) throws Exception {
		IODMAdapter adapter = new IeeeCDFAdapter(IpssLogger.getLogger());
		adapter.parseInputFile("testdata/ieee_cdf/Ieee14.ieee");
		
//		this.net = CoreObjectFactory.createAclfNetwork();
		AclfNetwork net = PluginSpringCtx
		.getOdm2AclfMapper()
		.map2Model((AclfModelParser)adapter.getModel())
		.getAclfNet();
	}

	// Get the active power digraph
	public DirectedWeightedMultigraph<String, DefaultWeightedEdge> getpDigraph() {
		// Initialize the digraph
		pDigraph = new DirectedWeightedMultigraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		// 1. Add all the nodes
		for (Bus thisBus : net.getBusList())
			pDigraph.addVertex(thisBus.getId());
		// 2. Add all the edges
		for (Branch thisBranch : net.getBranchList()) {
			String fromId = thisBranch.getFromBusId();
			String toId = thisBranch.getToBusId();
//			double pij = thisBranch.get
		}
		return pDigraph;
	}

	public static void main(String[] args) throws Exception {
//		IPSSActivePowerDigraph apd = new IPSSActivePowerDigraph("testdata/ieee_cdf/Ieee14.ieee");
		IODMAdapter adapter = new IeeeCDFAdapter(IpssLogger.getLogger());
		adapter.parseInputFile("testdata/ieee_cdf/Ieee14.ieee");
		
		AclfNetwork net = PluginSpringCtx
				.getOdm2AclfMapper()
				.map2Model((AclfModelParser)adapter.getModel())
				.getAclfNet();
	}

}