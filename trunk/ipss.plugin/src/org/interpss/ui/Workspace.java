/*
 * @(#)Workspace.java   
 *
 * Copyright (C) 2006 www.interpss.com
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
 * @Date 08/15/2007
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.ui;

public class Workspace {
	public static enum Type {
		User, Sample
	};

	private static Type curType = Type.User;

	public static Type getCurrentType() {
		return curType;
	}

	public static void setCurrentType(Type curType) {
		Workspace.curType = curType;
	}
}