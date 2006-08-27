/*
 * Created on Mar 11, 2005
 *
 */
package org.interpss.test.unit.db;

import java.util.Hashtable;
import java.util.List;

import org.interpss.test.unit.TestBaseAppCtx;

import com.interpss.common.SpringAppContext;
import com.interpss.common.io.DBManager;
import com.interpss.common.io.IProjectDataManager;
import com.interpss.common.io.ISimuRecManager;
import com.interpss.common.rec.IpssDBCase;
import com.interpss.common.util.StringUtil;
import com.interpss.dstab.util.DStabOutFunc;
import com.interpss.dstab.util.DStabSimuDBRecord;

public class SimuRecDBTest extends TestBaseAppCtx {
	
	public void testSimuCase() {
		System.out.println("\nBegin SimuRecDBTest.testSimuCase");

		IProjectDataManager projDataMgr = SpringAppContext.getProjectDataDBManager();
		
		// The SimuCase is already in the DB
		IpssDBCase aCase = (IpssDBCase)projDataMgr.dbActionIpssCase(
				DBManager.SQL_ACTION_SELECT, 1, "CaseName");
		assertTrue(aCase.getCaseDbId() == 1);

		// The SimuCase is already in the DB
		aCase = (IpssDBCase)projDataMgr.dbActionIpssCase(
				DBManager.SQL_ACTION_SELECT, 100, "CaseName");
		assertTrue(aCase.getCaseDbId() == 0);

		// The SimuCase is already in the DB
		aCase = (IpssDBCase)projDataMgr.dbActionIpssCase(
				DBManager.SQL_ACTION_SELECT, 2, "CaseName1");
		if (aCase.getCaseDbId() != -1)
			projDataMgr.dbActionIpssCase(DBManager.SQL_ACTION_DELETE, 2, "CaseName1");
		
		aCase = (IpssDBCase)projDataMgr.dbActionIpssCase(
				DBManager.SQL_ACTION_INSERT, 2, "CaseName1");
		assertTrue(aCase.getCaseDbId() > 0);
		
		System.out.println("\nEnd SimuRecDBTest.testSimuCase");
	}
	
	public void testSimuRecord() {
		System.out.println("\nBegin SimuRecDBTest.testSimuRecord");

		IProjectDataManager projDataMgr = SpringAppContext.getProjectDataDBManager();
		ISimuRecManager simuRecManager = SpringAppContext.getSimuRecManager();
		
		// The SimuCase is already in the DB
		IpssDBCase aCase = (IpssDBCase)projDataMgr.dbActionIpssCase(
				DBManager.SQL_ACTION_SELECT, 1, "CaseName");
//		assertTrue(aCase.getCaseDbId() == 1);

		simuRecManager.deleteAllSimuRec(aCase.getCaseDbId(), IProjectDataManager.CaseType_DStabSimuRec);
		
		int recTypeId = simuRecManager.getRecTypeId(ISimuRecManager.REC_TYPE_DStabMachineStates, IProjectDataManager.CaseType_DStabSimuRec);
		
		DStabSimuDBRecord aRec = new DStabSimuDBRecord();
	  	aRec.setRecTypeId(recTypeId);
	  	aRec.setCaseId(aCase.getCaseDbId());
	  	aRec.setElemIdStr("MachId");
	  	aRec.setSimuTime(0.0);
	  	aRec.setSimuRec("Something");
	  	simuRecManager.dbActionSimuRec(DBManager.SQL_ACTION_INSERT, aRec, IProjectDataManager.CaseType_DStabSimuRec);
		
	  	aRec.setSimuTime(0.1);
	  	simuRecManager.dbActionSimuRec(DBManager.SQL_ACTION_INSERT, aRec, IProjectDataManager.CaseType_DStabSimuRec);

	  	aRec.setSimuTime(0.2);
	  	simuRecManager.dbActionSimuRec(DBManager.SQL_ACTION_INSERT, aRec, IProjectDataManager.CaseType_DStabSimuRec);

	  	List list = simuRecManager.getSimuRecList(aCase.getCaseDbId(), ISimuRecManager.REC_TYPE_DStabMachineStates, aRec.getElemIdStr(), IProjectDataManager.CaseType_DStabSimuRec);
		assertTrue(list.size() == 3);
		
		aRec = (DStabSimuDBRecord)list.get(1);
		aRec.setSimuTime(1.0);
		aRec.setSimuRec("...");
		simuRecManager.dbActionSimuRec(DBManager.SQL_ACTION_UPDATE, aRec, IProjectDataManager.CaseType_DStabSimuRec);
		
		DStabSimuDBRecord rec = (DStabSimuDBRecord)simuRecManager.getSimuRec(aRec.getRecId(), IProjectDataManager.CaseType_DStabSimuRec);
		assertTrue(rec.getSimuTime() == 1.0);
		assertTrue(rec.getSimuRec().equals("..."));
		
	  	aRec.setElemIdStr("ExcId");
	  	aRec.setSimuTime(0.0);
	  	simuRecManager.dbActionSimuRec(DBManager.SQL_ACTION_INSERT, aRec, IProjectDataManager.CaseType_DStabSimuRec);

	  	aRec.setSimuTime(0.1);
	  	simuRecManager.dbActionSimuRec(DBManager.SQL_ACTION_INSERT, aRec, IProjectDataManager.CaseType_DStabSimuRec);

	  	list = simuRecManager.getSimuRecList(aCase.getCaseDbId(), ISimuRecManager.REC_TYPE_DStabMachineStates, aRec.getElemIdStr(), IProjectDataManager.CaseType_DStabSimuRec);
		assertTrue(list.size() == 2);

		simuRecManager.deleteAllSimuRec(aCase.getCaseDbId(), IProjectDataManager.CaseType_DStabSimuRec);
	  	list = simuRecManager.getSimuRecList(aCase.getCaseDbId(), ISimuRecManager.REC_TYPE_DStabMachineStates, "MachId", IProjectDataManager.CaseType_DStabSimuRec);
		assertTrue(list.size() == 0);
	  	list = simuRecManager.getSimuRecList(aCase.getCaseDbId(), ISimuRecManager.REC_TYPE_DStabMachineStates, "ExcId", IProjectDataManager.CaseType_DStabSimuRec);
		assertTrue(list.size() == 0);
		
		/*
		XmlUtil.ToolKid = XmlUtil.TOOL_JDK;
		rec = SimuRecDBManager.getDStabSimuRec(3124);
		System.out.println(rec.getSimuRec());
		System.out.println(((Hashtable)XmlUtil.toObject(rec.getSimuRec())).toString());
		*/
		System.out.println("\nEnd SimuRecDBTest.testSimuRecord");
	}	

	public void testHashtablePersistance() {
		System.out.println("\nBegin SimuRecDBTest.testSimuRecord");

		String str = "{Mach Speed=1.0000, Pe=1.667, Mach Ang=-1.5627423541251826, Time= 0.01, Pm=1.667, MachineId=Mach0001, Voltage=1.0030, Eq1=-10.0293}";
		Hashtable table = StringUtil.parseStr2Hashtable(new String(str));
		assertTrue(((String)table.get(DStabOutFunc.OUT_SYMBOL_MACH_SPEED)).equals("1.0000"));
		assertTrue(((String)table.get(DStabOutFunc.OUT_SYMBOL_MACH_ANG)).equals("-1.5627423541251826"));
		
		System.out.println("\nEnd SimuRecDBTest.testSimuRecord");
	}

	public void testTest() {
		/*
	  	List list = SimuRecDBManager.getElemIdStrList(3, SimuRecDBManager.REC_TYPE_DStabMachineStates);
		System.out.println(list);
		*/
	}
}
