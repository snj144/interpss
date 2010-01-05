 /*
  * @(#)Seconds.java   
  *
  * Copyright (C) 2007 www.opencim.org
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
  * @Date 03/04/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.opencim.datatype.real;

import org.opencim.datatype.Units;
import org.opencim.datatype.base.AnInitConstructor;
import org.opencim.datatype.base.DoubleType;

public class Seconds extends DoubleType {
	public Seconds(double value) {
		super(value, Units.Seconds);
	}

	@AnInitConstructor
	public Seconds(String str) {
		super(str);
	}
}
