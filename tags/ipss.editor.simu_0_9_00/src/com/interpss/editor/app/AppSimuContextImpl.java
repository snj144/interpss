package com.interpss.editor.app;

/**
	A Facede for for all application related info
*/

import java.util.List;
import java.util.Vector;

import javax.swing.JPopupMenu;

import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.XmlUtil;
import com.interpss.editor.SimuAppSpringAppContext;
import com.interpss.editor.chart.ChartManager;
import com.interpss.editor.data.acsc.AcscFaultData;
import com.interpss.editor.data.proj.AclfCaseData;
import com.interpss.editor.data.proj.AcscCaseData;
import com.interpss.editor.data.proj.CaseData;
import com.interpss.editor.data.proj.DStabCaseData;
import com.interpss.editor.data.proj.ProjData;
import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.editor.jgraph.ui.data.IProjectData;
import com.interpss.editor.runAct.AcscRunForm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuSpringAppContext;

public class AppSimuContextImpl implements IAppSimuContext {
	
	// Project info - loaded when loading a project
	private IProjectData projData = null;

	// Simulation info - mapped when run a project
	private SimuContext simuCtx = null;
	private boolean simuCtxDataDirty = false;
	private boolean lfConverged = false;
	private boolean scCalculated = false;
	
	// track the last run type
	private int lastRunType = 0;   //  SimuRunWorker.RUN_TYPE_ACLF, RUN_TYPE_ACSC, RUN_TYPE_DSTAB;
	
	public AppSimuContextImpl() {
		this.simuCtxDataDirty = true;
	}
	
	public void reset() {
		getProjData().setToNewProject();
  		this.lfConverged = false;
  		this.scCalculated = false;
  		this.simuCtxDataDirty = true;
  		SimuAppSpringAppContext.getDStabRunForm().setDbSimuCaseId(0);
	}
	
	public Object getSimuCtx() { 
    	if (this.simuCtx == null)
    		this.simuCtx = SimuSpringAppContext.getSimuContext();
		return this.simuCtx; 
	}
	
	public void setSimuCtx(Object ctx) { 
		this.simuCtx = (SimuContext)ctx; 
	}
	
	/* current project info, including projname ... */

	public IProjectData getProjData() { 
    	if (this.projData == null)
    		this.projData = SimuAppSpringAppContext.getProjectData();
		return this.projData; 
	}
	public void setProjData(IProjectData info) {
		this.projData = info;
	}
	
	/* For Acsc calculation, also for reporting */
	public boolean isLfConverged() {return this.lfConverged;}
	public void setLfConverged(boolean b) {this.lfConverged = b;}

	/* Trace appCtx modification status */
	public boolean isSimuNetDataDirty() {return this.simuCtxDataDirty;}
	public void setSimuNetDataDirty(boolean b) {this.simuCtxDataDirty = b;}

	/**
	 * Check if the current AcscRunForm has a non-symmetric fault
	 * 
	 * @return
	 */
	public boolean isNonSymmetricFault() {
		AcscRunForm form = SimuAppSpringAppContext.getAcscRunForm();
		if (form.getAcscCaseData() != null)
			return !form.getAcscCaseData().getFaultData().getCategory()
			        .equals(AcscFaultData.FaultCaty_3P);
		else 
			return false;
	}
	
	// Case info functions
   	// ===================
   	
	public String getCurrentCaseName(String caseType) {
		return getCurrentCaseData(caseType).getCaseName();
		
	}
	
	public CaseData getCurrentCaseData(String caseType) {
		ProjData aProjData = (ProjData)getProjData();
		String casename = caseType.equals(CaseData.CaseType_Aclf)? aProjData.getAclfCaseName() :
					(caseType.equals(CaseData.CaseType_Acsc)? aProjData.getAcscCaseName() :
						aProjData.getDStabCaseName());
		return getCaseData(casename, caseType);
	}
	
	/**
	 * Get an array of case data object for the case type
	 * 
	 * @param caseType case type
	 * @return case data array of type Object[]
	 */
	public Object[] getCasenameArray(String caseType) {
	    Vector vect = new Vector();
	    List caseList = getProjData().getCaseList();
	    for (int i = 0; i < caseList.size(); i++) {
	         CaseData caseData = (CaseData)caseList.get(i);
	         if (caseData != null)
	        	 if (caseData.getCaseType().equals(caseType))
	        		 vect.add(0, caseData.getCaseName());
	    }
	    
	    if ( vect.size() == 0 ) {
	     	  String name = "Aclf Analysis Case";
	      	  if (caseType.equals(CaseData.CaseType_Acsc))
			      name = "Acsc Analysis Case";
	      	  else if (caseType.equals(CaseData.CaseType_DStab))
				  name = "Transient Stability Case";
	          createCaseData(name, caseType);
	          vect.add(new String(name));
	    }    
		return vect.toArray();
	}
   
	/**
	 * Delete the case data by casename and case type
	 * 
	 * @param casename case name
	 * @param caseType case type
	 * @return if the case data delete, return true, else false
	 */
	public boolean deleteCaseData(String casename, String caseType) {
	   CaseData caseData = getCaseData(casename, caseType);
	   if (caseData != null) {
		   getProjData().getCaseList().remove(caseData);
		   return true;
	   }
	   return false;
   }

	/**
	 * Get the CaseData object by casename and case type
	 *  
	 * @param casename  case name
	 * @param caseType  case type
	 * @return the case data object
	 */
	public CaseData getCaseData(String casename, String caseType) {
       List caseList = getProjData().getCaseList();
       for (int i = 0; i < caseList.size(); i++) {
           CaseData caseData = (CaseData)caseList.get(i);
           if (caseData != null)
        	   if (casename.equals(caseData.getCaseName()) && caseData.getCaseType().equals(caseType)) {
        		   IpssLogger.getLogger().info("CaseInfo found, casename: " + casename);
        		   return caseData;
        	   }    
       }
       return null;
   }
   
   /**
    * Create a CaseData object with the casename and put into <*>RunForm. Since casename has to be unique in a project, if
    * a caseInfo object with the same casename found, return null.
    * 
    * @param casename the case name
    * @param caseType the case type
    * @return the created case, null the casename already exists
    */	
   public CaseData createCaseData(String casename, String caseType) {
   	   if (getCaseData(casename, caseType) == null) {
			CaseData caseData = new CaseData();
			caseData.setCaseName(casename);
			caseData.setCaseType(caseType);
			if (caseType.equals(CaseData.CaseType_Aclf)) {
		   		caseData.setAclfCaseData(new AclfCaseData());
		   		SimuAppSpringAppContext.getAclfRunForm().setAclfCaseData(caseData.getAclfCaseData());
			}   
			else if (caseType.equals(CaseData.CaseType_Acsc)) {
		   		caseData.setAcscCaseData(new AcscCaseData());
		   		SimuAppSpringAppContext.getAcscRunForm().setAcscCaseData(caseData.getAcscCaseData());
			}   
			else if (caseType.equals(CaseData.CaseType_DStab)) {
		   		caseData.setDStabCaseData(new DStabCaseData());
		   		caseData.setAclfCaseData(new AclfCaseData());
		   		SimuAppSpringAppContext.getDStabRunForm().setDStabCaseData(caseData.getDStabCaseData());
			}   
			else {
				IpssLogger.getLogger().severe("Wrong caseType");
				return null;
			}   
			List list = getProjData().getCaseList();
			list.add(caseData);
			IpssLogger.getLogger().info("CaseInfo created, casename: " + casename);
			return caseData;
   	   }
   	   else
   	   	   return null;
   	}
   	
	/**
	 * Get all popup menu actions for the cell
	 */
	public void addPopupMenuAction(JPopupMenu menu, final Object cell) {
		IpssLogger.getLogger().info("AppSimuContextImpl.addPopupMenuAction called");
		ChartManager.addPopupMenuAction(menu, cell);
	}
	
   /**
	*	Convert the net to a string for display purpose, including bus and branch
	*
	* @return the string representation
	*/
	public String toString() {
		return XmlUtil.toXmlString(this);
	}

	public void releaseResource() {
	}

	/**
	 * @return Returns the scCalculated.
	 */
	public boolean isScCalculated() {
		return scCalculated;
	}

	/**
	 * @param scCalculated The scCalculated to set.
	 */
	public void setScCalculated(boolean scCalculated) {
		this.scCalculated = scCalculated;
	}
	
	/**
	 * @return the lastRunType
	 */
	public int getLastRunType() {
		return lastRunType;
	}

	public boolean hasLastRun() {
		return lastRunType > 0;
	}
	
	/**
	 * @param lastRunType the lastRunType to set
	 */
	public void setLastRunType(int lastRunType) {
		this.lastRunType = lastRunType;
	}    
}