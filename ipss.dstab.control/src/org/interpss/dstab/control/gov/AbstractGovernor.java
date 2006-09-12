 /*
  * @(#)AbstractGovernor.java   
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

package org.interpss.dstab.control.gov;

import java.util.Hashtable;

import org.interpss.dstab.control.common.AbstractController;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.dstab.util.DStabOutFunc;

public abstract class AbstractGovernor extends AbstractController {
	public static final int DroopMode = 1;
	public static final int IsochMode = 2;
	
	/**
	 * Constructor
	 * 
	 * @param id governor id
	 * @param name governor name
	 */	
	public AbstractGovernor(final String id, final String name, final String caty) {
		super(id, name, caty, ControllerType.GOVERNOR_LITERAL);
	}

	/**
	 * Get controller states for display purpose
	 * 
	 * @return hashtable of the states
	 */	
	@Override
	public Hashtable getStates(Object ref) {
		final Hashtable table = new Hashtable();
		table.put(DStabOutFunc.OUT_SYMBOL_GOV_PM, new Double(getOutput()));
		return table;
	}
} 
