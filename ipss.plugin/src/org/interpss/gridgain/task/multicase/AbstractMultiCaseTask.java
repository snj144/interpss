/*
 * @(#)AbstractMultiCaseTask.java   
 *
 * Copyright (C) 2008 www.interpss.org
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
 * @Date 01/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.gridgain.task.multicase;

/**
 *  An abstract GridTask for implement multiple study cases. 
 */

import java.util.List;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJobResult;
import org.gridgain.grid.GridTaskSession;
import org.gridgain.grid.GridTaskSplitAdapter;
import org.gridgain.grid.resources.GridTaskSessionResource;

import com.interpss.simu.multicase.MultiStudyCase;

public abstract class AbstractMultiCaseTask extends
		GridTaskSplitAdapter<MultiStudyCase> {
	private static final long serialVersionUID = 1;

	/** Grid task session will be injected. */
	@GridTaskSessionResource
	private GridTaskSession session = null;

	// Master node id
	public static String MasterNodeId = "";

	protected GridTaskSession getSession() {
		return this.session;
	}

	/**
	 * Multiple study case, return a String array
	 */
	@Override
	public Object reduce(List<GridJobResult> results) throws GridException {
		Object[] objList = new Object[results.size()];
		int cnt = 0;
		for (GridJobResult result : results) {
			objList[cnt++] = result.getData();
		}
		return objList;
	}
}
