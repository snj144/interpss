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


public class DStabScriptUtilFunc {
	public final static String OutDStabResultClassName = "ipss/tools/OutDStabResult2TextDialog";
	public final static String DStabOutputScriptingClassName = "ipss/tools/DStabOutputScripting";
	
	public final static String CMLControllerPackageName = "dsl/controller/";
	public final static String CMLDynamicBusControllerPackageName = "dsl/device/";
	
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
    	javacode = javacode.replaceFirst(Tag_ControllerFieldDescBegin, ScriptJavacUtilFunc.Tal_ClassnameLine);
    	javacode = javacode.replaceFirst(Tag_ControllerFieldDescEnd, Tag_ControllerFieldDescEnd_Code);
		javacode = javacode.replaceFirst(ScriptJavacUtilFunc.Tag_Classname, classname);
		javacode = javacode.replaceFirst(ScriptJavacUtilFunc.Tag_BaseClassname, baseClassname);
		return javacode;
	}
}
