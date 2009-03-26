/*
 * @(#)IpssAdapter.java   
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
 * @Date 05/01/2007
 * 
 *   Revision History
 *   ================
 *
 */
package org.interpss.pssl;

import org.interpss.display.AclfOutFunc;

import com.interpss.core.aclf.AclfNetwork;
import com.interpss.simu.pssl.BaseDSL;

public class IpssUtil extends BaseDSL {
	public static enum Format { LoadfloeSummary, IEEEBusStype };
	
	public static OutputAclfNetDSL outputAclfNet(AclfNetwork net) {
		return new OutputAclfNetDSL(net);
	}
	
	public static class OutputAclfNetDSL {
		private AclfNetwork net;
		private Format format;
		public OutputAclfNetDSL(AclfNetwork net) {
			this.net = net;
		}
		
		public OutputAclfNetDSL setFormat(Format format) { this.format = format; return this; }

		public String toString() { 
			if (this.format == Format.LoadfloeSummary) 
				return AclfOutFunc.loadFlowSummary(net);
			else if (this.format == Format.IEEEBusStype) 
				return AclfOutFunc.lfResultsBusStyle(net);
			return ""; 
		}
	}
}
