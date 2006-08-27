/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An abatrct class for implementation of an excitor model
 *
 * $Id$
 */
package org.interpss.dstab.control.exc;

import java.util.Hashtable;

import org.interpss.dstab.control.common.AbstractController;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.dstab.util.DStabOutFunc;

public abstract class AbstractExciter extends AbstractController {
	
	/**
	 * Constructor
	 * 
	 * @param id excitor id
	 * @param name excitor name
	 */
	public AbstractExciter(final String id, final String name, final String caty) {
		super(id, name, caty, ControllerType.EXCITER_LITERAL);
	}

	/**
	 * Get controller states for display purpose
	 * 
	 * @param ref, a reference object for output. May not be used
	 * @return hashtable of the states
	 */
	@Override
	public Hashtable getStates(Object ref) {
		final Hashtable<String,Double> table = new Hashtable<String,Double>();
		table.put(DStabOutFunc.OUT_SYMBOL_EXC_EFD, new Double(getOutput()));
		return table;
	}
} 

