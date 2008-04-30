 /*
  * @(#)GEFormat_in.java   
  *
  * Copyright (C) 2006-2008 www.interpss.org
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
  * @Date 05/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.custom.exchange.impl;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;

public class GEFormat_in {
    public static AclfAdjNetwork loadFile(java.io.BufferedReader din, String filename, IPSSMsgHub msg) throws Exception {
    	AclfAdjNetwork  adjNet = CoreObjectFactory.createAclfAdjNetwork();
    	adjNet.setAllowParallelBranch(false);

  		String lineStr = null;
  		int lineNo = 0;
  		try {
      		do {
      			lineStr = din.readLine();
      			if (lineStr != null) {
      				lineNo++;
      				System.out.println(lineStr);
      			}
    		} while (lineStr != null);
  		} catch (Exception e) {
    		throw new Exception("GE data input error, line no " + lineNo + ", " + e.toString());
  		}

  		return adjNet;
    }
}
