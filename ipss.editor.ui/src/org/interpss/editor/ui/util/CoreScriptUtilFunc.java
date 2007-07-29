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


public class CoreScriptUtilFunc {
	public final static String AclfScriptingPackageName = "script/aclf";
	public final static String AcscScriptingPackageName = "script/acsc";
	public final static String RunCaseScriptingPackageName = "script/run_case";
	
	public static String Tag_AclfScript_Begin_Code = "package <package>; \n import org.apache.commons.math.complex.Complex;\n import com.interpss.common.datatype.*;\n import com.interpss.common.util.MemoryJavaCompiler;\n import com.interpss.core.aclf.*;\n import com.interpss.core.aclf.impl.*;\n public class <classname> extends <baseClassname>";
	public static String Tag_AclfScriptBus_Begin = "<AclfBusScriptingClassname>";
	public final static String Tag_AclfScriptBus_Baseclass = "BaseAclfBusImpl";
	public static String Tag_AclfScriptBranch_Begin = "<AclfBranchScriptingClassname>";
	public final static String Tag_AclfScriptBranch_Baseclass = "BaseAclfBranchImpl";
	
	public static String AclfBusTemplateFilename = "template/AclfBusScriptingTemplate.txt";
	public static String AclfBranchTemplateFilename = "template/AclfBranchScriptingTemplate.txt";

	public static String Tag_AcscScript_Begin_Code = "package <package>; \n import org.apache.commons.math.complex.Complex;\n import com.interpss.common.datatype.*;\n import com.interpss.common.util.MemoryJavaCompiler;\n import com.interpss.core.aclf.*;\n import com.interpss.core.aclf.impl.*;\n import com.interpss.core.acsc.*;\n import com.interpss.core.acsc.impl.*;\n public class <classname> extends <baseClassname>";
	public static String Tag_AcscScriptBus_Begin = "<AcscBusScriptingClassname>";
	public final static String Tag_AcscScriptBus_Baseclass = "BaseAcscBusImpl";
	public static String Tag_AcscScriptBranch_Begin = "<AcscBranchScriptingClassname>";
	public final static String Tag_AcscScriptBranch_Baseclass = "BaseAcscBranchImpl";

	public static String AcscBusTemplateFilename = "template/AcscBusScriptingTemplate.txt";
	public static String AcscBranchTemplateFilename = "template/AcscBranchScriptingTemplate.txt";
	
	public static String RunScriptsClass = "IpssRunScriptsClass";
	public static String RunScriptsTemplateFilename = "template/RunCaseScriptsTemplate.txt";

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
		String str = CoreScriptUtilFunc.Tag_AclfScript_Begin_Code.replaceFirst(
				ScriptJavacUtilFunc.Tag_Package, 
				CoreScriptUtilFunc.AclfScriptingPackageName.replaceAll("/", "."));
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
		String str = CoreScriptUtilFunc.Tag_AcscScript_Begin_Code.replaceFirst(
				ScriptJavacUtilFunc.Tag_Package, 
				CoreScriptUtilFunc.AcscScriptingPackageName.replaceAll("/", "."));
		str = str.replaceFirst(ScriptJavacUtilFunc.Tag_BaseClassname, baseClassname);
		str = str.replaceFirst(ScriptJavacUtilFunc.Tag_Classname, classname);
		return javacode.replaceFirst(beginTag, str);		
	}

	/**
	 * 
	 * 
	 * @param javacode
	 * @param classname
	 * @return
	 */
	public static String parseRunCaseJavaCode(String javacode,	String classname) {
		String str = javacode.replaceFirst(ScriptJavacUtilFunc.Tag_Package, 
				CoreScriptUtilFunc.RunCaseScriptingPackageName.replaceAll("/", "."));
		return str.replaceFirst(ScriptJavacUtilFunc.Tag_Classname, classname);		
	}
}
