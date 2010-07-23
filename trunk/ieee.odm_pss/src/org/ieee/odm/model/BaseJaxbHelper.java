 /*
  * @(#)ContainerHelper.java   
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
  * @Date 02/11/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.odm.model;

import org.ieee.odm.schema.NameValuePairListXmlType;
import org.ieee.odm.schema.NameValuePairXmlType;
import org.ieee.odm.schema.ObjectFactory;

public class BaseJaxbHelper {
	/**
	 * add a name/value pair to the name/value pair List
	 * 
	 * @param nvList name/value pair list
	 * @param name name string
	 * @param value value string
	 */
	public static void addNVPair(NameValuePairListXmlType nvList, String name, 
					String value) {
    	NameValuePairXmlType nvPair = getFactory().createNameValuePairXmlType();
    	nvList.getNvPair().add(nvPair);
    	nvPair.setName(name);
    	nvPair.setValue(value);
	}
	
	private static ObjectFactory _factory = null;	
	public static ObjectFactory getFactory() {
		if (_factory == null)
			_factory = new ObjectFactory();
		return _factory;
	}	
}
