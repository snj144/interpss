package com.interpss.tools;

import com.interpss.common.SpringAppContext;
import com.interpss.common.io.DBManager;
import com.interpss.editor.EditorSpringAppContext;
import com.interpss.editor.io.ProjectDataDBManager;

public class DbUtility {

	public static void main(String[] args) {
		SpringAppContext.SpringAppCtxConfigXmlFile = "c:/eclipse/GEditor/properties/springConfig/editorAppContext.xml";
		EditorSpringAppContext.springAppContextSetup();

		DBManager.SQLMAP_CONFIG_PATH="sqlMapConfig/SqlMapConfig.xml";

		deleteProject(47);
	}

	public static void deleteProject(int projDbId) {
		try {
			ProjectDataDBManager.deleteDbProject(projDbId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
