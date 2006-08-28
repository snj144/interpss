/*
 * Created on Mar 11, 2005
 *
 */
package org.interpss.test.unit.db;

import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.data.proj.ProjData;
import org.interpss.test.unit.TestBaseAppCtx;

import com.interpss.common.SpringAppContext;
import com.interpss.common.io.DBManager;
import com.interpss.common.io.IProjectDataManager;

public class ProjectDBTest extends TestBaseAppCtx {
	
	public void testProject() {
		System.out.println("\nBegin ProjectDBTest.testProject");

		IProjectDataManager projManager = SpringAppContext.getProjectDataDBManager();
		
		String name = "MyProjectName";
		String file = "MyFilePath";

		// The SimuCase is already in the DB
		ProjData projData = new ProjData();
		projData.setProjectName(name);
		projData.setWorkspacePath(file);
		projData.setFilepath(file);
		
		// insert a new project
		projData = (ProjData)projManager.dbActionProject(DBManager.SQL_ACTION_INSERT , projData);
		assertTrue(projData.getProjectDbId() > 0);

		int id = projData.getProjectDbId();
		projData.setProjectDbId(0);
		projData = (ProjData)projManager.dbActionProject(DBManager.SQL_ACTION_SELECT, projData);
		//System.out.println(projData.toString());
		assertTrue(projData.getProjectDbId() == id);
		
		projData.setProjectName("xxxx");
		projData.setFilepath("xxxx");
		projData = (ProjData)projManager.dbActionProject(DBManager.SQL_ACTION_SELECT, projData);
		//System.out.println(projData.toString());
		assertTrue(projData.getProjectName().equals(name));
		assertTrue(projData.getFilepath().equals(file));

		projData.setProjectName("newName");
		projData.setDescription("newDesc");
		projData.setFilepath("newFile");
		projData = (ProjData)projManager.dbActionProject(DBManager.SQL_ACTION_UPDATE, projData);
		//System.out.println(projData.toString());
		assertTrue(projData.getProjectName().equals("newName"));
		assertTrue(projData.getFilepath().equals("newFile"));

		projManager.dbActionProject(DBManager.SQL_ACTION_DELETE, projData);

		System.out.println("\nEnd ProjectDBTest.testProject");
	}

	public void testStudyCase() {
		System.out.println("\nBegin ProjectDBTest.testStudyCase");

		IProjectDataManager projManager = SpringAppContext.getProjectDataDBManager();
		
		String name = "MyProjectName";
		String file = "MyFilePath";

		// The SimuCase is already in the DB
		ProjData projData = new ProjData();
		projData.setProjectName(name);
		projData.setWorkspacePath(file);
		projData.setFilepath(file);
		
		// insert a new project
		projData = (ProjData)projManager.dbActionProject(DBManager.SQL_ACTION_INSERT , projData);
		assertTrue(projData.getProjectDbId() > 0);

		// Study case
		
		CaseData aclfCase = new CaseData();
		aclfCase.setCaseName("AclfCaseName");
		aclfCase.setProjDbId(projData.getProjectDbId());
		aclfCase.setCaseType(CaseData.CaseType_Aclf);

		CaseData acscCase = new CaseData();
		acscCase.setCaseName("AcscCaseName");
		acscCase.setProjDbId(projData.getProjectDbId());
		acscCase.setCaseType(CaseData.CaseType_Acsc);

		CaseData dstabCase = new CaseData();
		dstabCase.setCaseName("DStabCaseName");
		dstabCase.setProjDbId(projData.getProjectDbId());
		dstabCase.setCaseType(CaseData.CaseType_DStab);

		projData.getCaseList().add(aclfCase);
		projData.getCaseList().add(acscCase);
		projData.getCaseList().add(dstabCase);

		projData = (ProjData)projManager.dbActionProject(DBManager.SQL_ACTION_UPDATE, projData);
		System.out.println(projData);

		assertTrue(projData.getCaseList().size() == 3);
		
		projData = (ProjData)projManager.dbActionProject(DBManager.SQL_ACTION_UPDATE, projData);
		assertTrue(projData.getCaseList().size() == 3);

		dstabCase = new CaseData();
		dstabCase.setCaseName("DStabCaseName-1");
		dstabCase.setProjDbId(projData.getProjectDbId());
		dstabCase.setCaseType(CaseData.CaseType_DStab);
		projData.getCaseList().add(dstabCase);
		
		projData = (ProjData)projManager.dbActionProject(DBManager.SQL_ACTION_UPDATE, projData);
		assertTrue(projData.getCaseList().size() == 4);

		projManager.dbActionProject(DBManager.SQL_ACTION_DELETE, projData);
		
		System.out.println("\nEnd ProjectDBTest.testStudyCase");
	}
}
