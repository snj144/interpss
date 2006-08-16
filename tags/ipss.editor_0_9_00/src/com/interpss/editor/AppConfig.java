package com.interpss.editor;

/**
*	Application configuration info
*
*/

import java.sql.SQLException;

import com.interpss.common.SpringAppContext;
import com.interpss.common.io.DBManager;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.XmlUtil;
import com.interpss.editor.data.proj.ProjData;
import com.interpss.editor.report.IpssRptViewer;
import com.interpss.editor.resources.Translator;
import com.interpss.editor.util.Utilities;

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
	
	// load user preference and config the app Mike 12/25/05
	public static boolean userPreConfiguration() {
		// To be implemented
		return true;
	}
	
	public static boolean loadAppProperties() {
		IpssLogger.initLogger("log/log.properties");
		IpssLogger.getLogger().info("\n============================================\n" +
				                    "*           Ipss GEditor Started           *\n" +
				                    "============================================");	
		
		boolean ok = true;
		try {
			String baseDir = Utilities.getInstallLocation();
			if (baseDir == null) {
				return false;
			}
			IpssLogger.getLogger().info("Base Dir: " + baseDir);
			
//			FileChooserConfig.CurrentProjDir = baseDir + Translator.getString("Project.File.Location");
//			FileChooserConfig.setCustomFileExts(appProps);
			
			DBManager.SQLMAP_CONFIG_PATH = Translator.getString("Sqlmap.Config.Path");
			try {
				DBManager.getSqlMap().getDataSource().getConnection();
			} catch (SQLException e) {
				IpssLogger.logErr(e);
				ok = false;
			}
			
			SpringAppContext.SpringAppCtxConfigXmlFile = Translator.getString("springframework.config.xmlfile");
//			GraphCellFactory.TAG_NetForm = Translator.getString("graphicfile.tag.netform");
//			GraphCellFactory.TAG_BusForm = Translator.getString("graphicfile.tag.busform");
			
			IpssRptViewer.REPORT_DEFAULT_DIR = baseDir + Translator.getString("Report.File.Location");
			IpssRptViewer.REPORT_EXT 	= Translator.getString("ReportFileExtension");
			IpssRptViewer.REPORT_DESC	= Translator.getString("Report.File.Desc");
		} catch (Exception e) {
			IpssLogger.logErr(e);
			ok = false;
		}
		
		return ok;
	}	
}