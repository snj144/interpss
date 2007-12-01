 /*
  * @(#)SampleLine.java   
  *
  * Copyright (C) 2006-2007 www.interpss.org
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
  * @Date 11/27/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.custom.script.aclf.line;

import org.apache.commons.math.complex.Complex;
import org.interpss.custom.script.aclf.AbstractAclfBranchScriptEditing;

import com.interpss.common.datatype.ComplexFunc;

// all AclfBus scripting plugin needs to extends AbstractAclfBranchScriptEditing
public class SampleLine extends AbstractAclfBranchScriptEditing {  
	/**
	 * Default constructor
	 */
	public SampleLine() {
		// set the plugin data object
		setData(new SampleLineData());
		// set the plugin editor Pandel
		setEditPanel(new NBSampleLineEditPanel());
	}

	/**
     * Get the data object
     *
     * @return the data object
     */
    public SampleLineData getData() {
        return (SampleLineData)super.getData();
    }
    
    /*
     *  BaseAclfBranch interface implementation
     */
    
    private Complex getZ() {
		return new Complex(getData().getR(), getData().getX()); 
    }

    private Complex getY() {
		return ComplexFunc.div(1.0, getZ());   
    }

	public double b11ft() {
	   	return -getY().getImaginary();
	}

	public double b11tf() {
		return b11ft();
	}

	public double b1ft() {
		return 1.0 / getData().getX();
	}

	public double b1tf() {
		return b1ft();
	}

	public Complex yff() {
	   Complex yff = ComplexFunc.add(getY(), new Complex(0.0, getData().getHB()));
	   return yff;
	}

	public Complex ytt() {
		return yff();
	}

	public Complex yft() {
	   return ComplexFunc.mul(-1.0, getY());
	}

	public Complex ytf() {
		return yft();
	}
}