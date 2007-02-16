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

package org.interpss.editor.util;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLClassLoader;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.controller.annotate.AbstractAnnotateController;
import com.sun.tools.javac.Main;

public class JavaCompiler {
	public static boolean javac(String classpath, String filename, String classDir) {
		String[] c_args = new String[] {"-classpath", classpath, "-d", classDir, filename};
		StringWriter strWriter = new StringWriter();
		PrintWriter out = new PrintWriter(strWriter);
		int errorCode = Main.compile(c_args, out);
		if (errorCode == 0) {
			SpringAppContext.getIpssMsgHub().sendStatusMsg(filename + " compilted successfully");
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
		
		 // The dir contains the compiled classes.
	    File classesDir = new File(classdir);
	    try {
	    	URLClassLoader loader = new URLClassLoader(new URL[] { classesDir.toURI().toURL()});
		    Class klass = loader.loadClass(classname);
		    AbstractAnnotateController h = (AbstractAnnotateController) klass.newInstance();
		    System.out.println(h.toString());
	    } catch (Exception e) {
	    	IpssLogger.logErr(e);
	    }		
	}	
}
