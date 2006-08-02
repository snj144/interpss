/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An abatrct class for implementation of a governor model
 *
 * $Id$
 */

package com.interpss.dstab.control.gov;

import java.util.Hashtable;

import com.interpss.dstab.control.common.AbstractController;
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
	public AbstractGovernor(final String id, final String name) {
		super(id, name, ControllerType.GOVERNOR_LITERAL);
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
