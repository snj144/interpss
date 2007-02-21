 /*
  * @(#)JavaCompiler.java   
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

import java.util.StringTokenizer;

import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.IGraphicEditor;

import com.interpss.common.util.IpssJavaCompiler;
import com.interpss.dstab.controller.annotate.AbstractAnnotateController;

public class CMLJavaCompiler extends IpssJavaCompiler {
	public static String PackageName = "dsl/controller/";
	
	public static String JavaClasspath = "ipss/ipss_core.jar;eclipse/org.eclipse.emf_2.2.0.jar;eclipse/org.eclipse.emf.common_2.2.0.jar;eclipse/org.eclipse.emf.ecore_2.2.0.jar;eclipse/org.eclipse.emf.ecore.xmi_2.2.0.jar";
	public static String ClassnameLine = "public class <classname> extends <baseClassname> {";

	public static String Tag_ContDescBegin = "<ControllerDescriptionBegin>";
	public static String Tag_ContrDescEnd = "<ControllerDescriptionEnd>";
	public static String Tag_FieldDescBegin = "<ControllerFieldDescriptionBegin>";
	public static String Tag_FieldDescEnd = "<ControllerFieldDescriptionEnd>";

	public static String Tag_ContDescBegin_Code = "package dsl.controller;\n import java.lang.reflect.Field;\n import com.interpss.dstab.controller.annotate.*;\n import com.interpss.dstab.controller.block.*;\n import com.interpss.dstab.mach.Controller;\n";
	public static String Tag_FieldDescEnd_Code = "public AnController getAnController() {\n return (AnController)getClass().getAnnotation(AnController.class);  }\n public double getDoubleField(String fieldName) throws Exception {\n Field field = getClass().getField(fieldName);\n return ((Double)field.get(this)).doubleValue();   }\n public Controller getControllerField(Field field) throws Exception {\n return (Controller)field.get(this);    }\n }";
	
	/**
	 * Create a classname, format: folderName_projectName_elemId
	 * 
	 * @param elemId
	 * @return
	 */
	public static String createClassName(String elemId) {
    	IGraphicEditor editor = GraphSpringAppContext.getIpssGraphicEditor();
    	String classname = editor.getCurrentProjectFolder() + "_" +
        editor.getCurrentProjectName() + "_" + elemId;
    	StringTokenizer st = new StringTokenizer(ClassnameToken, "|");
    	while (st.hasMoreTokens()) {
        	classname = classname.replace(st.nextToken().charAt(0), '_');
    	}
		return classname;
	}
	
	/**
	 * Create a CML controller java filename based on the classname
	 * 
	 * @param classname
	 * @return
	 */
	public static String createJavaFilename(String classname) {
    	IGraphicEditor editor = GraphSpringAppContext.getIpssGraphicEditor();
    	String str = (JavaSrcDir+PackageName).replace('/', System.getProperty("file.separator").charAt(0));
    	String filename = editor.getRootDir() + str + classname + ".java";		
    	return filename;
	}
	
	/**
	 * Parse CML controller template Java Code by substituting tags.
	 * 
	 * @param javacode
	 * @param classname
	 * @return
	 */
	public static String parseTag(String javacode, String classname, String baseClassname) {
    	javacode = javacode.replaceFirst(Tag_ContDescBegin, Tag_ContDescBegin_Code);
    	javacode = javacode.replaceFirst(Tag_ContrDescEnd, "");
    	javacode = javacode.replaceFirst(Tag_FieldDescBegin, getClassnameLine(classname, baseClassname));
    	javacode = javacode.replaceFirst(Tag_FieldDescEnd, Tag_FieldDescEnd_Code);
		return javacode;
	}
	
	/**
	 * Compile CML controller java source file
	 * 
	 * @param filename
	 */
	public static boolean compileJavaCode(String filename) {
		return CMLJavaCompiler.javac(getCMLControllerClassPath(), filename, JavaClassDir);  		
	}

	/**
	 * create a CML controller object using the classname class file
	 * 
	 * @param classname
	 * @return
	 */
    public static AbstractAnnotateController createObject(String classname) {
    	return (AbstractAnnotateController)createObject(JavaClassDir, PackageName.replace('/', '.')+classname);
    }

	public static String getCMLControllerClassPath() {  		
		StringTokenizer st = new StringTokenizer(JavaClasspath, ";");
		String str = "";
		while (st.hasMoreTokens()) {
			str += JavaLibPath + st.nextToken() + ";";
		}
		return str;
	}
    
	private static String getClassnameLine(String classname, String baseClassname) {
		String str = ClassnameLine.replaceAll("<classname>", classname);
		return str.replaceAll("<baseClassname>", baseClassname);
	}
}
