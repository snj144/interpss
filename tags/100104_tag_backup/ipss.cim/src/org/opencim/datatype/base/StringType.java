 /*
  * @(#)StringType.java   
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

package org.opencim.datatype.base;

public class StringType {
	private String value = "";
	
	public StringType(String value) {
			// may in format (String), we need to get rid of ( and )
		if (value.startsWith("(") && value.endsWith(")")) {
			int n1 = value.indexOf('(');
			int n2 = value.indexOf(')');
			this.value = value.substring(n1+1, n2);
		}	
		else
			this.value = value;
	}
	
	public String toString() {
		return "(" + value + ")";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
