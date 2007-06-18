 /*
  * @(#)FilterNthOrderBlock.java   
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
  * @Date 10/30/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.dstab.measure;

import org.interpss.dstab.control.cml.block.DelayControlBlock;
import org.interpss.dstab.control.cml.block.WashoutControlBlock;

import com.interpss.common.datatype.Constants;
import com.interpss.dstab.controller.block.adapt.ControlBlock1stOrderAdapter;


public class BusFreqMeasurementImpl extends ControlBlock1stOrderAdapter {
	private double baseFreq = 0.0;
	private double angle0 = 0.0;
	private double tf = 0.0;
	private double tw = 0.0;
	
	private WashoutControlBlock washoutBlock = null;
	private DelayControlBlock delayBlock = null;
	
	public BusFreqMeasurementImpl(double tf, double tw ) {
		this.tf = tf;
		this.tw = tw;
	}
	
	/**
	 * 
	 * @param u0 bus angle at time = 0.0, in Rad
	 */
	public boolean initStateU0(double u0) {
		// this.baseFreq has to be set by calling the setParameter method
		double kWashout = 1.0 / (2.0 * Constants.Pai * this.baseFreq * tf);   // 1.0 / 2*Pai*f0 / Tf
		this.washoutBlock = new WashoutControlBlock(kWashout, tf);
		this.delayBlock = new DelayControlBlock(1.0, tw);
		
		this.angle0 = u0;
		this.washoutBlock.initStateU0(0.0);
		this.delayBlock.initStateU0(1.0);
		
		return true;
	}
	
	public void eulerStep1(double u, double dt) {
		double u2 = 1.0 + this.washoutBlock.getY();
		this.delayBlock.eulerStep1(u2, dt);

		double u1 = u - this.angle0;
		this.washoutBlock.eulerStep1(u1, dt);
	}
	
	public void eulerStep2(double u, double dt) {
		double u2 = 1.0 + this.washoutBlock.getY();
		this.delayBlock.eulerStep2(u2, dt);

		double u1 = u - this.angle0;
		this.washoutBlock.eulerStep2(u1, dt);
	}
	
	public double getY() {
		return this.delayBlock.getY();
	}

	/**
	 * Set certain parameter
	 * 
	 * @param name parameter name
	 * @param value parameter value
	 */
	public void setParameter(String name, double value) {
		if (name.equals(Constants.NetBaseFreqToken))
			this.baseFreq = value;
	}
	
	public String toString() {
		String str = "tf, tw: " + tf + ", "  + tw;
		return str;
	}

	public double getTf() {
		return tf;
	}

	public void setTf(double tf) {
		this.tf = tf;
	}

	public double getTw() {
		return tw;
	}

	public void setTw(double tw) {
		this.tw = tw;
	}	
}
