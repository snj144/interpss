 /*
  * @(#)AppConfig.java   
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.editor;

/**
*	Application configuration info
*
*/

import java.sql.SQLException;

import org.interpss.editor.data.proj.ProjData;
import org.interpss.editor.report.IpssRptViewer;
import org.interpss.editor.resources.Translator;
import org.interpss.editor.ui.util.CoreScriptUtilFunc;
import org.interpss.editor.ui.util.DStabScriptUtilFunc;
import org.interpss.editor.ui.util.IpssFileFilter;

import com.interpss.common.SpringAppContext;
import com.interpss.common.io.DBManager;
import com.interpss.common.util.IpssJavaCompiler;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.StringUtil;
import com.interpss.common.util.XmlUtil;

public class AppConfig {
	/**
	*	Set app configuration parameters
	*/
	public static void setConfigConstants() {
//		IpssModel.ProjIdLabel_Loc_x = 350;
//		IpssModel.ProjIdLabel_Loc_y = 5;
//		IpssModel.ProjIdLabelWidth = 200;
//		IpssModel.ProjIdLabelHeight = 30;		
//		
//		BusCell.DefaultBusWidth = 5;
//		BusCell.DefaultBusHeight = 40;
//		BusCell.BusLabelOffset = 5;
//
//		/*
//		 * set the default label BorderColor and BackgroundColor 
//		 */
//		BusCell.BorderColor = Color.white;
//		BusCell.BackgroundColor = Color.gray;
//		
//		AbstractBranchView.Pos_Offset = 15;		
//		
//		LabelCell.DefaultLabelWidth = 50;
//		LabelCell.DefaultLabelHeight = 20;
//		LabelCell.BackgroundColor = Color.white;

		XmlUtil.XmlPIChars = 40;	
		
		ProjData.NewProjName = "UnSaved";
	}
	
	public static boolean loadAppProperties() {
		IpssLogger.initLogger("log/log.properties");
		IpssLogger.getLogger().info("\n============================================\n" +
				                    "*           Ipss GEditor Started           *\n" +
				                    "============================================");	
		
		boolean ok = true;
		try {
			String baseDir = StringUtil.getInstallLocation();
			if (baseDir == null) {
				return false;
			}
			IpssLogger.getLogger().info("Base Dir: " + baseDir);
			
//			FileChooserConfig.CurrentProjDir = baseDir + Translator.getString("Project.File.Location");
//			FileChooserConfig.setCustomFileExts(appProps);
			
			DBManager.SQLMAP_CONFIG_PATH = Translator.getString("Sqlmap.Config.Path");
			DBManager.SQLMAP_SAMPLE_CONFIG_PATH = Translator.getString("Sqlmap.Sample.Config.Path");
			DBManager.DB_SCHEMA_VERSION = Translator.getString("IpssDb.shema.version");
			IpssLogger.getLogger().info("DBManager.SQLMAP_CONFIG_PATH:" + DBManager.SQLMAP_CONFIG_PATH );
			IpssLogger.getLogger().info("DBManager.SQLMAP_SAMPLE_CONFIG_PATH:" + DBManager.SQLMAP_SAMPLE_CONFIG_PATH );
			try {
				DBManager.getSqlMapIpss().getDataSource().getConnection();
				DBManager.getSqlMapSample().getDataSource().getConnection();
			} catch (SQLException e) {
				IpssLogger.logErr(e);
				ok = false;
			}
			
			SpringAppContext.SpringAppCtxConfigXmlFile = Translator.getString("springframework.config.xmlfile");
			GEditor.Pty_UserWorkspace = Translator.getString("WorkSpace.Location");
			GEditor.Pty_SampleWorkspace = Translator.getString("WorkSpace.Location.Sample");
			
			IpssRptViewer.REPORT_DEFAULT_DIR = baseDir + Translator.getString("Report.File.Location");
			IpssRptViewer.REPORT_EXT 	= Translator.getString("ReportFileExtension");
			IpssRptViewer.REPORT_DESC	= Translator.getString("Report.File.Desc");
			
			IpssFileFilter.OUTPUT_DEFAULT_DIR = baseDir + Translator.getString("Output.Default.Location");
			
			
			IpssJavaCompiler.JavaSrcDir = Translator.getString("Java.Compile.JavaSrcDir");
			IpssJavaCompiler.JavaClassDir = Translator.getString("Java.Compile.JavaClassDir");
			IpssJavaCompiler.JavaLibPath = Translator.getString("Java.Compile.JavaLibPath");
			IpssJavaCompiler.ClassnameToken = Translator.getString("Java.Compile.ClassnameToken");
			IpssJavaCompiler.JavaClasspath = Translator.getString("Java.Compile.JavaClasspath");

			DStabScriptUtilFunc.Tag_ControllerDescBegin = Translator.getString("Java.Compile.CMLController.Tag.ContDesc.Begin");
			DStabScriptUtilFunc.Tag_ControllerDescEnd = Translator.getString("Java.Compile.CMLController.Tag.ContrDesc.End");
			DStabScriptUtilFunc.Tag_ControllerFieldDescBegin = Translator.getString("Java.Compile.CMLController.Tag.FieldDesc.Begin");
			DStabScriptUtilFunc.Tag_ControllerFieldDescEnd = Translator.getString("Java.Compile.CMLController.Tag.FieldDesc.End");

			DStabScriptUtilFunc.Tag_ControllerDescBegin_Code = Translator.getString("Java.Compile.CMLController.Tag.ContDesc.Begin.Code");
			DStabScriptUtilFunc.Tag_ControllerFieldDescEnd_Code = Translator.getString("Java.Compile.CMLController.Tag.FieldDesc.End.Code");

			CoreScriptUtilFunc.Tag_AclfScript_Begin_Code = Translator.getString("Java.Compile.AclfScripting.Tag.AclfScript_Begin_Code");
			CoreScriptUtilFunc.Tag_AclfScriptBus_Begin = Translator.getString("Java.Compile.AclfScripting.Tag.AclfScriptBus_Begin");
			CoreScriptUtilFunc.Tag_AclfScriptBranch_Begin = Translator.getString("Java.Compile.AclfScripting.Tag.AclfScriptBranch_Begin");
			
			CoreScriptUtilFunc.Tag_AcscScript_Begin_Code = Translator.getString("Java.Compile.AcscScripting.Tag.AcscScript_Begin_Code");
			CoreScriptUtilFunc.Tag_AcscScriptBus_Begin = Translator.getString("Java.Compile.AcscScripting.Tag.AcscScriptBus_Begin");
			CoreScriptUtilFunc.Tag_AcscScriptBranch_Begin = Translator.getString("Java.Compile.AcscScripting.Tag.AcscScriptBranch_Begin");
		} catch (Exception e) {
			IpssLogger.logErr(e);
			ok = false;
		}
		
		return ok;
	}	
}