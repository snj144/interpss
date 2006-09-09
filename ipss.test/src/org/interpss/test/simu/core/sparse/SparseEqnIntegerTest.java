/*
 * Created on Mar 16, 2005
 *
 */
package org.interpss.test.simu.core.sparse;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.interpss.test.simu.TestBaseAppCtx;

import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algorithm.BusArrangeRule;
import com.interpss.core.algorithm.NetworkAlgorithm;
import com.interpss.core.net.NetPackage;
import com.interpss.core.net.Network;
import com.interpss.core.sparse.SparseEqnInteger;
import com.interpss.core.sparse.impl.SparseEqnIntegerImpl;

/**
 * @author mzhou
 *
 */
public class SparseEqnIntegerTest extends TestBaseAppCtx {
  	private ResourceSet resourceSet = null;

  	public SparseEqnIntegerTest() {
  		super();
  		
	  	this.resourceSet = new ResourceSetImpl();
	  	// the following registeration only needed for stand-alone applicaiton.
	  	this.resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
	  			"net", new XMIResourceFactoryImpl()); 	
	  	NetPackage packageInstance = NetPackage.eINSTANCE;
  	}
  	
	public void testBegin() {
 		System.out.println("\n\nBegin com.interpss.core.sparse.test.SparseEqnIntegerTest ...");
	}
	
	public void testArrangeRowNoT1() {
	  	Network net = loadNetwork("testData/testBusArrange.net");
  		assertEquals(true, (net.getBusList().size() == 9 && net.getBranchList().size() == 8));

  		NetworkAlgorithm netAlgo = CoreObjectFactory.createNetworkAlgorithm(net);
  		netAlgo.arrangeBusNumber(BusArrangeRule.TINNEY1_LITERAL, SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
  		
  		assertEquals(true, net.getBus("A").getSortNumber() == 1);
  		assertEquals(true, net.getBus("E").getSortNumber() == 6);
  		assertEquals(true, net.getBus("G").getSortNumber() == 9);
  		System.out.println("Bus no arrangement Tinney1, sucessful");
  	}

	public void testArrangeRowNoT2() {
	  	Network net = loadNetwork("testData/testBusArrange.net");
  		assertEquals(true, (net.getBusList().size() == 9 && net.getBranchList().size() == 8));

  		NetworkAlgorithm netAlgo = CoreObjectFactory.createNetworkAlgorithm(net);
  		netAlgo.arrangeBusNumber(BusArrangeRule.TINNEY2_LITERAL, SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
  		
  		assertEquals(true, net.getBus("A").getSortNumber() == 1);
  		assertEquals(true, net.getBus("E").getSortNumber() == 7);
  		assertEquals(true, net.getBus("G").getSortNumber() == 8);
  		
  		System.out.println("Bus no arrangement Tinney2, sucessful");
  	}

	public void testArrangeRowNoT3() {
	  	Network net = loadNetwork("testData/testBusArrange.net");
  		assertEquals(true, (net.getBusList().size() == 9 && net.getBranchList().size() == 8));

  		NetworkAlgorithm netAlgo = CoreObjectFactory.createNetworkAlgorithm(net);
  		netAlgo.arrangeBusNumber(BusArrangeRule.TINNEY3_LITERAL, SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());

  		assertEquals(true, net.getBus("A").getSortNumber() == 1);
  		assertEquals(true, net.getBus("E").getSortNumber() == 5);
  		assertEquals(true, net.getBus("G").getSortNumber() == 9);

  		System.out.println("Bus no arrangement Tinney3, sucessful");
  	}

	public void testSetAij() {
		SparseEqnIntegerImpl eqn = createSampleEqn();
		eqn.setAij(10, 2, 3);
		SparseEqnIntegerImpl.IntAii aii = eqn.getElem(2);
		assertTrue(eqn.getAij(aii,3).aij==10);
		assertTrue(eqn.getAij(aii,3).j==3);
	}

	public void testTotalElements() {
		SparseEqnInteger eqn = createSampleEqn();
		//System.out.println("total elements: " + eqn.totalElements());
		assertTrue(eqn.getTotalElements()==6);
	}

	public void testEnd() {
 		System.out.println("End com.interpss.core.sparse.test.SparseEqnIntegerTest");
	}

	private SparseEqnIntegerImpl createSampleEqn() {
		SparseEqnIntegerImpl eqn = new SparseEqnIntegerImpl();
		eqn.setDimension(3);
		eqn.setAij(1, 1, 1);
		eqn.setAij(1, 2, 2);
		eqn.setAij(1, 3, 3);

		eqn.setAij(1, 1, 2);
		eqn.setAij(1, 2, 3);
		eqn.setAij(1, 3, 2);
		return eqn;
	}
	
	private Network loadNetwork(String filename) {
	  	String path = new File(filename).getAbsolutePath();
  		//System.out.println("path: " + path);
	  	URI fileURI = URI.createFileURI(path);
	  	Resource netRe = this.resourceSet.getResource(fileURI, true);
	  	Network net = (Network)netRe.getContents().get(0);
  		System.out.println("\nNetwork object loaded, xml file path: " + path);
  		return net;
	}	
}
