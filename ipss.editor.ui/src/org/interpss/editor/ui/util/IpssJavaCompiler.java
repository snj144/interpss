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

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.StringTokenizer;

import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.IGraphicEditor;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.controller.annotate.AbstractAnnotateController;
import com.sun.tools.javac.Main;

public class IpssJavaCompiler {
	public static String JavaSrcDir = "java/src/";
	public static String JavaClassDir = "java/classes/";
	public static String JavaLibPath = "C:/eclipse/InterpssDev/ipss.lib/lib/";

	public static String CMLControllerPath = "dsl/controller/";
	
	public static String ClassnameToken = "-|.|@";
	public static String JavaClasspath = "ipss/ipss_core.jar;eclipse/org.eclipse.emf_2.2.0.jar;eclipse/org.eclipse.emf.common_2.2.0.jar;eclipse/org.eclipse.emf.ecore_2.2.0.jar;eclipse/org.eclipse.emf.ecore.xmi_2.2.0.jar";
	public static String ClassnameLine = "public class <classname> extends <baseClassname> {";

	public static String CMLControllerTag_ContDescBegin = "<ControllerDescriptionBegin>";
	public static String CMLControllerTag_ContrDescEnd = "<ControllerDescriptionEnd>";
	public static String CMLControllerTag_FieldDescBegin = "<ControllerFieldDescriptionBegin>";
	public static String CMLControllerTag_FieldDescEnd = "<ControllerFieldDescriptionEnd>";

	public static String CMLControllerTag_ContDescBegin_Code = "package dsl.controller;\n import java.lang.reflect.Field;\n import com.interpss.dstab.controller.annotate.*;\n import com.interpss.dstab.controller.block.*;\n import com.interpss.dstab.mach.Controller;\n";
	public static String CMLControllerTag_FieldDescEnd_Code = "public AnController getAnController() {\n return (AnController)getClass().getAnnotation(AnController.class);  }\n public double getDoubleField(String fieldName) throws Exception {\n Field field = getClass().getField(fieldName);\n return ((Double)field.get(this)).doubleValue();   }\n public Controller getControllerField(Field field) throws Exception {\n return (Controller)field.get(this);    }\n }";
	
	/**
	 * Compile java code
	 * 
	 * @param classpath compile lib classpath
	 * @param filename java code file name
	 * @param classDir
	 * @return
	 */
	public static boolean javac(String classpath, String filename, String classDir) {
		String[] c_args = new String[] {"-classpath", classpath, "-d", classDir, filename};
		StringWriter strWriter = new StringWriter();
		PrintWriter out = new PrintWriter(strWriter);
		int errorCode = Main.compile(c_args, out);
		if (errorCode == 0) {
			SpringAppContext.getIpssMsgHub().sendStatusMsg(filename + " compilted successfully");
			SpringAppContext.getIpssMsgHub().sendStatusMsg("Class written to the dir: " + classDir);
			//System.out.println(filename + " compilted successfully");
		}
		else {
			SpringAppContext.getIpssMsgHub().sendErrorMsg(strWriter.toString());
			//System.out.println(strWriter.toString());
			return false;
		}
		return true;
	}

	/**
	 * create a Java object from classname in classdir
	 * 
	 * @param classdir
	 * @param classname
	 * @return
	 */
	public static Object createObject(String classdir, String classname) {
		 // The dir contains the compiled classes.
	    File classesDir = new File(classdir);
	    try {
	    	URLClassLoader loader = new URLClassLoader(new URL[] { classesDir.toURI().toURL()});
		    Class klass = loader.loadClass(classname);
		    return klass.newInstance();
	    } catch (Exception e) {
	    	IpssLogger.logErr(e);
	    }	
	    return null;
	}
	
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
	public static String createCMLControllerJavaFilename(String classname) {
    	IGraphicEditor editor = GraphSpringAppContext.getIpssGraphicEditor();
    	String str = (JavaSrcDir+CMLControllerPath).replace('/', System.getProperty("file.separator").charAt(0));
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
	public static String parseCMLControllerTag(String javacode, String classname, String baseClassname) {
    	javacode = javacode.replaceFirst(CMLControllerTag_ContDescBegin, CMLControllerTag_ContDescBegin_Code);
    	javacode = javacode.replaceFirst(CMLControllerTag_ContrDescEnd, "");
    	javacode = javacode.replaceFirst(CMLControllerTag_FieldDescBegin, getClassnameLine(classname, baseClassname));
    	javacode = javacode.replaceFirst(CMLControllerTag_FieldDescEnd, CMLControllerTag_FieldDescEnd_Code);
		return javacode;
	}
	
	/**
	 * Compile CML controller java source file
	 * 
	 * @param filename
	 */
	public static boolean compileCMLControllerJavaCode(String filename) {
		return IpssJavaCompiler.javac(getCMLControllerClassPath(), filename, JavaClassDir);  		
	}

	/**
	 * create a CML controller object using the classname class file
	 * 
	 * @param classname
	 * @return
	 */
    public static AbstractAnnotateController createCMLControllerObject(String classname) {
    	return (AbstractAnnotateController)createObject(JavaClassDir, CMLControllerPath.replace('/', '.')+classname);
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
	
	// The following code is for testing purpose
	
	/**
	 * This method is for testing purpose
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		test();
	}	

	public static void test() {
		String libpath = "C:/eclipse/InterpssDev/ipss.lib/lib/";
		String srcpath = "java/src/";
		String filename = "test/CustomAnnotateExciter.java";
		String classname = "test.CustomAnnotateExciter";
		String classdir = "java/classes/";
		String classpath = libpath+"ipss/ipss_core.jar;" +
        					libpath+"eclipse/org.eclipse.emf_2.2.0.jar;" + 
        					libpath+"eclipse/org.eclipse.emf.common_2.2.0.jar;" +
        					libpath+"eclipse/org.eclipse.emf.ecore_2.2.0.jar;" +
        					libpath+"eclipse/org.eclipse.emf.ecore.xmi_2.2.0.jar";
		javac(classpath, srcpath+filename, classdir);
		
	    AbstractAnnotateController h = (AbstractAnnotateController)createObject(classdir, classname);
	    System.out.println(h.toString());
	}	
}
