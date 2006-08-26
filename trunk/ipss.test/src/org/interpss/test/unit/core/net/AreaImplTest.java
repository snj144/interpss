/*
 * Created on Mar 11, 2005
 *
 */
package org.interpss.test.unit.core.net;

import org.interpss.test.unit.TestBaseAppCtx;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.net.Area;
import com.interpss.core.net.Network;
import com.interpss.core.net.Zone;

/**
 * @author mzhou
 *
 */
public class AreaImplTest extends TestBaseAppCtx {
  	
	public void testBegin() {
 		System.out.println("\n\nBegin com.interpss.core.net.test.AreaImplTest ...");
	}
	
	public void testGetZone() {
	  	Network net = CoreObjectFactory.createNetwork();
	  	
	  	Area area1 = CoreObjectFactory.createArea(1, net);
	  	Zone zone1 = CoreObjectFactory.createZone(1, net);
	  	
	  	net.getZoneList().add(zone1);
	  	net.getAreaList().add(area1);
	  	
	  	assertTrue(net.getArea(1) != null);
	  	assertTrue(net.getZone(1) != null);
	}

	public void testEnd() {
 		System.out.println("End com.interpss.core.net.test.AreaImplTest");
	}
}
