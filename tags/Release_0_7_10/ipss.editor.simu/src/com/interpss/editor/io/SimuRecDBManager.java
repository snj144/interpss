package com.interpss.editor.io;

import java.sql.SQLException;
import java.util.List;

import com.interpss.common.SpringAppContext;
import com.interpss.common.exp.InterpssRuntimeException;
import com.interpss.common.io.DBManager;
import com.interpss.common.io.IProjectDataManager;
import com.interpss.common.io.ISimuRecManager;
import com.interpss.common.rec.IpssDBCase;
import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.util.DStabSimuDBRecord;

public class SimuRecDBManager implements ISimuRecManager {
	/**
	 * Get SimuRecord list for the case, record type and element id
	 * 
	 * @param caseId
	 * @param recType
	 * @param elemId
	 * @return
	 */
	public List getSimuRecList(int caseId, String recType, String elemId, int appType) {
		try {
			if (appType == IProjectDataManager.CaseType_DStabSimuRec) {
				int typeid = getRecTypeId(recType, appType);
				DStabSimuDBRecord aRec = new DStabSimuDBRecord();
				aRec.setCaseId(caseId);
				aRec.setRecTypeId(typeid);
				aRec.setElemIdStr(elemId);
				List list = DBManager.getSqlMap().queryForList("selectDStabSimuRecordList", aRec);
				return list;
			}
		} catch (SQLException e) {
			IpssLogger.logErr(e);
		}		
		throw new InterpssRuntimeException("Cannot getSimuRecList, see log file for details");
	}

	/**
	 * Get elem id str list for the case, record type
	 * 
	 * @param caseId
	 * @param recType
	 * @return
	 */
	public List getElemIdStrList(int caseId, String recType, int appType) {
		try {
			if (appType == IProjectDataManager.CaseType_DStabSimuRec) {
				int typeid = getRecTypeId(recType, appType);
				DStabSimuDBRecord aRec = new DStabSimuDBRecord();
				aRec.setCaseId(caseId);
				aRec.setRecTypeId(typeid);
				List list = DBManager.getSqlMap().queryForList("selectDStabElemIdStrList", aRec);
				return list;
			}
		} catch (SQLException e) {
			IpssLogger.logErr(e);
		}		
		throw new InterpssRuntimeException("Cannot getSimuRecList, see log file for details");
	}
	
	/**
	 * Get SimuRecord for the rec id
	 * 
	 * @param id
	 * @return
	 */
	public Object getSimuRec(int id, int appType) {
		try {
			if (appType == IProjectDataManager.CaseType_DStabSimuRec) {
				return DBManager.getSqlMap().queryForObject("selectDStabSimuRecord", new Integer(id));
			}
		} catch (SQLException e) {
			IpssLogger.logErr(e);
		}		
		throw new InterpssRuntimeException("Cannot getSimuRec, see log file for details");
	}

	/**
     * Perform db action for the SimuRecord table
     * 
     * @param action insert and update implemented
     * @param aRec
     */
	public void dbActionSimuRec(int action, Object aRec, int appType) {
		try {
			if (appType == IProjectDataManager.CaseType_DStabSimuRec) {
				switch (action) {
					case DBManager.SQL_ACTION_INSERT : {
						DBManager.getSqlMap().insert("insertDStabSimuRecord", aRec);
						return;
					}
					case DBManager.SQL_ACTION_UPDATE : {
						DBManager.getSqlMap().update("updateDStabSimuRecord", aRec);
						return;
					}
				}				
			}
		} catch (SQLException e) {
			IpssLogger.logErr(e);
		}		
		throw new InterpssRuntimeException("Cannot dbActionSimuRec, see log file for details");
	}

	/**
	 * Delete all simu record of case id in the SimuRecord Table
	 * 
	 * @param caseId
	 */
	public void deleteAllSimuRec(int caseId, int appType) {
		try {
			if (appType == IProjectDataManager.CaseType_DStabSimuRec) {
				DBManager.getSqlMap().delete("deleteDStabSimuRecord", new Integer(caseId));
				return;
			}
		} catch (SQLException e) {
			IpssLogger.logErr(e);
		}		
		throw new InterpssRuntimeException("Cannot deleteSimuRec, see log file for details");
	}

	/**
	 * Delete all simu record for projDbId in the SimuRecord Table
	 * 
	 * @param projId
	 */
	public void deleteAllSimuRecForProject(int projId, int appType) {
		try {
			if (appType == IProjectDataManager.CaseType_DStabSimuRec) {
				List caseList = DBManager.getSqlMap().queryForList("selectIpssCaseForProject", projId);
				for (int i=0; i < caseList.size(); i++) {
					IpssDBCase aCase = (IpssDBCase)caseList.get(i);
					ISimuRecManager simuRecMgr = SpringAppContext.getSimuRecManager();
					simuRecMgr.deleteAllSimuRec(aCase.getCaseDbId(), IProjectDataManager.CaseType_DStabSimuRec);
				}
				return;
			}
		} catch (SQLException e) {
			IpssLogger.logErr(e);
		}		
		throw new InterpssRuntimeException("Cannot deleteSimuRec, see log file for details");
	}
	
	/**
	 * Get the record type id for the record type
	 * 
	 * @param recType
	 * @return the record type id
	 */
	public int getRecTypeId(String recType, int appType) {
		try {
			if (appType == IProjectDataManager.CaseType_DStabSimuRec) {
				Integer id = (Integer)DBManager.getSqlMap().queryForObject("selectRecordType", recType);
		   		if (id != null) {
					return id.intValue();
		   		}
			}
    		return -1;
		} catch (SQLException e) {
			IpssLogger.logErr(e);
		}		
		throw new InterpssRuntimeException("Cannot getRecTypeId, see log file for details");
	}
}