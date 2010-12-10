package org.interpss.sample.net;

import java.util.logging.Level;
import org.interpss.IpssPlugin;
import org.interpss.PluginObjectFactory;
import org.interpss.custom.IpssFileAdapter;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.ActivePowerWalkDirectionEnum;
import com.interpss.core.algorithm.ActivePowerWalkThrough;
import com.interpss.core.common.visitor.IAclfNetBVisitor;
import com.interpss.core.common.visitor.IBranchBVisitor;
import com.interpss.core.common.visitor.IBusBVisitor;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;

public class IEEE14_WalkThrouhg {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// InterPSS core simulation engine configuration
		IpssPlugin.init(Level.WARNING);

    	/*
    	 * step-1 Build the base case
    	 */
		AclfNetwork net = PluginObjectFactory
				.getFileAdapter(IpssFileAdapter.FileFormat.IEEECDF)
				.load("testData/ieee14.ieee")
				.getAclfNet();
    		
		/*
		 * step-2 Define LF algorithm and run Loadflow
		 */
	  	IAclfNetBVisitor algo = CoreObjectFactory.createLfAlgoVisitor();;
	  	net.accept(algo);

  		ActivePowerWalkThrough walkAlgo = CoreObjectFactory.createActivePowerWalkThrough();
  		walkAlgo.setBusVisitor(new IBusBVisitor() {
			@Override
			public boolean visit(Bus bus) {
				System.out.println("\nBus: " + bus.getId() + " visited");
				return true;
			}
  		});
  		walkAlgo.setBranchVisitor(new IBranchBVisitor() {
			@Override
			public boolean visit(Branch branch) {
				System.out.println("Branch: " + branch.getId() + " visited");
				return true;
			}
  		});
  		
		System.out.println("Source to Load direction");
  		walkAlgo.setDirection(ActivePowerWalkDirectionEnum.SOURCE_TO_LOAD);
  		net.accept(walkAlgo);
  		
		System.out.println("\nLoad to Source direction");
  		walkAlgo.setDirection(ActivePowerWalkDirectionEnum.LOAD_TO_SOURCE);
  		net.accept(walkAlgo);
	}
}
