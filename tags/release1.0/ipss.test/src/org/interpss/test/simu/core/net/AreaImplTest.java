 /*
  * @(#)AreaImplTest.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.test.simu.core.net;

import org.interpss.test.simu.TestBaseAppCtx;

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
