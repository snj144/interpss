package org.interpss.test.path;

import org.intepss.path.CommunityDetection;
import org.intepss.path.IPSSActivePowerDigraph;
import org.interpss.IpssPlugin;
import org.interpss.PluginObjectFactory;
import org.interpss.custom.IpssFileAdapter;

import com.interpss.common.exp.InterpssException;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algo.LoadflowAlgorithm;

public class CommunityTestSZNormal {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws InterpssException 
	 */
	public static void main(String[] args) throws InterpssException, Exception {
		IpssPlugin.init();
		AclfNetwork net = PluginObjectFactory.getFileAdapter(IpssFileAdapter.FileFormat.PSSE, IpssFileAdapter.Version.PSSE_30).load("d:/work/data/SZEQ0924_2_3Trans_eq.raw").getAclfNet();
	    LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm();
		net.accept(algo);
		IPSSActivePowerDigraph apd = new IPSSActivePowerDigraph(net);
//		IPSSActivePowerDigraph apd = new IPSSActivePowerDigraph("testdata/ieee_cdf/ieee14.ieee");
		CommunityDetection cd = new CommunityDetection(apd.getpDigraph(), net);
//		cd.detectingCommunities();
		cd.detectingWeightedCommunities();
//		cd.detectingWeightedDirectedCommunities();
//		cd.saveCommunityResults("community_sz_weighted_normal.txt", cd.getResult());
//		cd.saveQResults("q_sz_weighted_normal.txt", cd.getqSet());
		cd.saveCommunityResults("community_sz_normal.txt", cd.getResult());
		cd.saveQResults("q_sz_normal.txt", cd.getqSet());
	}

}
