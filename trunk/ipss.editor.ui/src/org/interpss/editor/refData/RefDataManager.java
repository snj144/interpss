package org.interpss.editor.refData;

import com.interpss.common.io.IRefDataManager;
import com.interpss.common.util.XmlUtil;

public class RefDataManager implements IRefDataManager {
	private LoadScheduleRefData loadScheduleRefData;
	
	/**
	 * Load schedule ref data from the ref database
	 * 
	 * @param conMgr
	 */
	public void loadAllRefData() {
		setRefDataObject(LoadScheduleRefData.getRefDataFromDB(), IRefDataManager.REFDATA_LoadSchedule);
	}
	
	/**
	 * @return Returns the loadScheduleRefData.
	 */
	public Object getRefDataObject(int type) {
		if (type == IRefDataManager.REFDATA_LoadSchedule)
			return loadScheduleRefData;
		else 
			return null;
	}

	/**
	 * @param loadScheduleRefData The loadScheduleRefData to set.
	 */
	public void setRefDataObject(Object obj, int type) {
		if (type == IRefDataManager.REFDATA_LoadSchedule)
			this.loadScheduleRefData = (LoadScheduleRefData)obj;
	}
	
    public String toString() {
		return XmlUtil.toXmlString(this);
	}		
}