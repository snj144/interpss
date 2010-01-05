package ipss.tools;

import org.interpss.editor.EditorSpringAppContext;
import org.interpss.editor.io.ProjectDataDBManager;

import com.interpss.common.SpringAppContext;
import com.interpss.common.io.DBManager;

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
