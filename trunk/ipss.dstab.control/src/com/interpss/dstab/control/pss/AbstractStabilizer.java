/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An abatrct class for implementation of a stabilizer model
 *
 * $Id$
 */

package com.interpss.dstab.control.pss;

import java.util.Hashtable;

import com.interpss.dstab.control.common.AbstractController;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.dstab.util.DStabOutFunc;

public abstract class AbstractStabilizer extends AbstractController {
	
	/**
	 * Constructor
	 * 
	 * @param id pss id
	 * @param name pss name
	 */	
	public AbstractStabilizer(final String id, final String name, final String caty) {
		super(id, name, caty, ControllerType.STABILIZER_LITERAL);
	}
	
	
	/**
	 * Get controller states for display purpose
	 * 
	 * @return hashtable of the states
	 */	
	@Override
	public Hashtable getStates(Object ref) {
		final Hashtable table = new Hashtable();
		table.put(DStabOutFunc.OUT_SYMBOL_PSS_VS, new Double(getOutput()));
		return table;
	}	
}
