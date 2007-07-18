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
	public final static String OutDStabResultClassName = "ipss/tools/OutDStabResult2TextDialog";
	public final static String DStabOutputScriptingClassName = "ipss/tools/DStabOutputScripting";
	
	public final static String CheckCodeTempPackageName = "temp/";
	public final static String CheckCodeClassname = "CheckCode";
	
	public final static String CMLControllerPackageName = "dsl/controller/";
	public final static String CMLDynamicBusControllerPackageName = "dsl/device/";
	public final static String AclfScriptingPackageName = "script/aclf";
	public final static String AcscScriptingPackageName = "script/acsc";
	
	public final static String Tag_Package = "<package>";
	public final static String Tag_Classname = "<classname>";
	public final static String Tag_BaseClassname = "<baseClassname>";
	public static String Tal_ClassnameLine = "public class <classname> extends <baseClassname> {";

	/*
	 *  the Begin_Code and End_Code have to be current, since in the testing situation, the fields are not 
	 *  set from the configuration file
	 */
	// CML contrller specific tags
	public static String Tag_ControllerDescBegin_Code = "package dsl.controller;\n import java.lang.reflect.Field;\n import com.interpss.dstab.controller.annotate.*;\n import com.interpss.dstab.controller.block.*;\n import com.interpss.dstab.controller.block.adapt.*;\n import org.interpss.dstab.control.cml.block.*;\n import org.interpss.dstab.control.cml.func.*;\n import com.interpss.dstab.mach.Controller;\n import com.interpss.common.func.*;\n import com.interpss.common.datatype.*;\n";
	public static String Tag_ControllerFieldDescEnd_Code = "public AnController getAnController() {\n return (AnController)getClass().getAnnotation(AnController.class);  }\npublic Field getField(String fieldName) throws Exception {\n return getClass().getField(fieldName);   }\n public Object getFieldObject(Field field) throws Exception {\n return field.get(this);    }\n}";

	public static String Tag_ControllerDescBegin = "<ControllerDescriptionBegin>";
	public static String Tag_ControllerDescEnd = "<ControllerDescriptionEnd>";
	public static String Tag_ControllerFieldDescBegin = "<ControllerFieldDescriptionBegin>";
	public static String Tag_ControllerFieldDescEnd = "<ControllerFieldDescriptionEnd>";

	// DStab output scripting specific tags
	public static String Tag_DStabOutScriptDescBegin_Code = "package ipss.tools; \n	import org.interpss.dstab.script.AnDStabOutputScripting; \n import org.interpss.dstab.script.IDStabOutputScripting;\n";
	public static String Tag_DStabOutScriptDescEnd_Code = "public class DStabOutputScripting implements IDStabOutputScripting {\n public AnDStabOutputScripting getAnOutputScripting() { \n return (AnDStabOutputScripting)getClass().getAnnotation(AnDStabOutputScripting.class);  } \n}";
	public static String Tag_DStabOutScriptDescBegin = "<DStabOutScriptDescriptionBegin>";
	public static String Tag_DStabOutScriptDescEnd = "<DStabOutScriptDescriptionEnd>";
	
	public static String Tag_AclfScript_Begin_Code = "package <package>; \n import org.apache.commons.math.complex.Complex;\n import com.interpss.common.datatype.*;\n import com.interpss.common.util.MemoryJavaCompiler;\n import com.interpss.core.aclf.*;\n import com.interpss.core.aclf.impl.*;\n public class <classname> extends <baseClassname>";
	public static String Tag_AclfScriptBus_Begin = "<AclfBusScriptingClassname>";
	public final static String Tag_AclfScriptBus_Baseclass = "BaseAclfBusImpl";
	public static String Tag_AclfScriptBranch_Begin = "<AclfBranchScriptingClassname>";
	public final static String Tag_AclfScriptBranch_Baseclass = "BaseAclfBranchImpl";
	
	public static String Tag_AcscScript_Begin_Code = "package <package>; \n import org.apache.commons.math.complex.Complex;\n import com.interpss.common.datatype.*;\n import com.interpss.common.util.MemoryJavaCompiler;\n import com.interpss.core.aclf.*;\n import com.interpss.core.aclf.impl.*;\n import com.interpss.core.acsc.*;\n import com.interpss.core.acsc.impl.*;\n public class <classname> extends <baseClassname>";
	public static String Tag_AcscScriptBus_Begin = "<AcscBusScriptingClassname>";
	public final static String Tag_AcscScriptBus_Baseclass = "BaseAcscBusImpl";
	public static String Tag_AcscScriptBranch_Begin = "<AcscBranchScriptingClassname>";
	public final static String Tag_AcscScriptBranch_Baseclass = "BaseAcscBranchImpl";

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
	 * Before saving java code, the code is saved as temp file and compiled to check any syntax error
	 * 
	 * @param baseClassname, base class name (AbstractExciter, AbstractGovernor ...)
	 * @return false if there is compiling error
	 */
	public static boolean checkJavaCode(String javacode, String packageName) {
    	IGraphicEditor editor = GraphSpringAppContext.getIpssGraphicEditor();
		String filename = IpssJavaCompiler.createJavaFilename(CheckCodeClassname, 
								ScriptJavacUtilFunc.CheckCodeTempPackageName, editor.getRootDir());
		GUIFileUtil.writeText2FileAbsolutePath(filename, javacode);	
		if (!packageName.endsWith("/"))
			packageName += "/";
		Object obj = MemoryJavaCompiler.javac(packageName+CheckCodeClassname, javacode);
		return obj != null;
	}

	/**
	 * create scripting object classname foldername/projectname/id
	 * 
	 * @param id
	 * @return
	 */
	public static String createScriptingClassname(String id) {
    	IGraphicEditor editor = GraphSpringAppContext.getIpssGraphicEditor();
		String	folderName = editor.getCurrentProjectFolder();
		String	projName = editor.getCurrentProjectName();
		return IpssJavaCompiler.createClassName(id, folderName, projName);
	}
	
	/**
	 * 
	 * @param javacode
	 * @param elemId
	 * @param baseClassname
	 * @param beginTag
	 * @return
	 */
	public static String parseAclfJavaCode(String javacode, 
			                 String classname, String baseClassname, String beginTag) {
		String str = ScriptJavacUtilFunc.Tag_AclfScript_Begin_Code.replaceFirst(
				ScriptJavacUtilFunc.Tag_Package, 
				ScriptJavacUtilFunc.AclfScriptingPackageName.replaceAll("/", "."));
		str = str.replaceFirst(ScriptJavacUtilFunc.Tag_BaseClassname, baseClassname);
		str = str.replaceFirst(ScriptJavacUtilFunc.Tag_Classname, classname);
		return javacode.replaceFirst(beginTag, str);		
	}

	/**
	 * 
	 * 
	 * @param javacode
	 * @param elemId
	 * @param baseClassname
	 * @param beginTag
	 * @return
	 */
	public static String parseAcscJavaCode(String javacode, 
            				String classname, String baseClassname, String beginTag) {
		String str = ScriptJavacUtilFunc.Tag_AcscScript_Begin_Code.replaceFirst(
				ScriptJavacUtilFunc.Tag_Package, 
				ScriptJavacUtilFunc.AcscScriptingPackageName.replaceAll("/", "."));
		str = str.replaceFirst(ScriptJavacUtilFunc.Tag_BaseClassname, baseClassname);
		str = str.replaceFirst(ScriptJavacUtilFunc.Tag_Classname, classname);
		return javacode.replaceFirst(beginTag, str);		
}
}
