 /*
  * @(#)ScriptJavacUtilFunc.java   
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
  * @Date 02/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.editor.ui.util;

import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.IGraphicEditor;

import com.interpss.common.util.IpssJavaCompiler;
import com.interpss.common.util.MemoryJavaCompiler;

public class ScriptJavacUtilFunc {
	public static String CMLTempPackageName = "dsl/temp/";
	public static String CMLControllerPackageName = "dsl/controller/";
	public static String CMLDynamicBusControllerPackageName = "dsl/device/";
	
	public static String Tag_Classname = "<classname>";
	public static String Tag_BaseClassname = "<baseClassname>";
	public static String Tal_ClassnameLine = "public class <classname> extends <baseClassname> {";

	// CML contrller specific tags
	public static String Tag_ControllerDescBegin_Code = "package dsl.controller;\n import java.lang.reflect.Field;\n import com.interpss.dstab.controller.annotate.*;\n import com.interpss.dstab.controller.block.*;\n import com.interpss.dstab.mach.Controller;\n";
	public static String Tag_ControllerFieldDescEnd_Code = "public AnController getAnController() {\n return (AnController)getClass().getAnnotation(AnController.class);  }\n public double getDoubleField(String fieldName) throws Exception {\n Field field = getClass().getField(fieldName);\n return ((Double)field.get(this)).doubleValue();   }\n public Controller getControllerField(Field field) throws Exception {\n return (Controller)field.get(this);    }\n }";

	public static String Tag_ControllerDescBegin = "<ControllerDescriptionBegin>";
	public static String Tag_ControllerDescEnd = "<ControllerDescriptionEnd>";
	public static String Tag_ControllerFieldDescBegin = "<ControllerFieldDescriptionBegin>";
	public static String Tag_ControllerFieldDescEnd = "<ControllerFieldDescriptionEnd>";

	/**
	 * Parse CML controller template Java Code by substituting tags.
	 * 
	 * @param javacode java code (Strng)
	 * @param classname class name
	 * @param baseClassname base class name
	 * @return pared java code string
	 */
	public static String parseCMLTag(String javacode, String classname, String baseClassname) {
    	javacode = javacode.replaceFirst(Tag_ControllerDescBegin, Tag_ControllerDescBegin_Code);
    	javacode = javacode.replaceFirst(Tag_ControllerDescEnd, "");
    	javacode = javacode.replaceFirst(Tag_ControllerFieldDescBegin, Tal_ClassnameLine);
    	javacode = javacode.replaceFirst(Tag_ControllerFieldDescEnd, Tag_ControllerFieldDescEnd_Code);
		javacode = javacode.replaceFirst(Tag_Classname, classname);
		javacode = javacode.replaceFirst(Tag_BaseClassname, baseClassname);
		return javacode;
	}

	/**
	 * check java code syntex error by creating a temp class and compiling.
	 * 
	 * @param javaCode java code to be checked
	 * @return false if compile fails
	 */
	public static boolean checkJavaCode(String javaCode) {
		return checkJavaCode(javaCode, "");
	}
	
	/**
	 * Before saving java code, the code is saved as temp file and compiled to check any syntax error
	 * 
	 * @param baseClassname, base class name (AbstractExciter, AbstractGovernor ...)
	 * @return false if there is compiling error
	 */
	public static boolean checkJavaCode(String javaCode, String baseClassname) {
    	IGraphicEditor editor = GraphSpringAppContext.getIpssGraphicEditor();
		String javacode = ScriptJavacUtilFunc.parseCMLTag(javaCode, "CheckCode", baseClassname);
		String filename = IpssJavaCompiler.createJavaFilename("CheckCode", 
								ScriptJavacUtilFunc.CMLTempPackageName, editor.getRootDir());
		GUIFileUtil.writeText2FileAbsolutePath(filename, javacode);	
		MemoryJavaCompiler.javac(CMLTempPackageName+"CheckCode", javacode);
		return true;
	}
}
