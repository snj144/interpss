 /*
  * @(#)IpssGridGainUtil.java   
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
  * @Date 09/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.core.grid.gridgain;

import org.eclipse.emf.ecore.EObject;
import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridFactory;

import com.interpss.common.util.IpssLogger;

public class IpssGridGainUtil {
	/**
	 * 
	 * 
	 * @param desc a description string
	 * @param type gird task type for looking up 
	 * @param model
	 * @return
	 * @throws GridException
	 */
    public static Object[] performGridTask(String desc, EObject model) throws GridException {
        GridFactory.start();
        Object[] objList = null;
        try {
            Grid grid = GridFactory.getGrid();
            IpssLogger.getLogger().info("Begin to excute IpssGridTask " + desc + " ...");
           	objList = (Object[])grid.execute(IpssGridGainTask.class.getName(), model).get();
            IpssLogger.getLogger().info("End to excute IpssGridTask " + desc );
        }
        finally {
            GridFactory.stop(true);
        }
        return objList;
    }
}
