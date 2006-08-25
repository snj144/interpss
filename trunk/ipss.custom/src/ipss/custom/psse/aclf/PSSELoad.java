package ipss.custom.psse.aclf;

import com.interpss.core.aclfadj.impl.RegulateLoadImpl;
import com.interpss.core.datatype.FuncLoad;

public class PSSELoad extends RegulateLoadImpl {

	private int areaNo = 0;
	private int zoneNo = 0;
	private FuncLoad pLoad = null;   // in pu
	private FuncLoad qLoad = null;   // in pu
	/**
	 * @return the areaNo
	 */
	public int getAreaNo() {
		return areaNo;
	}
	/**
	 * @param areaNo the areaNo to set
	 */
	public void setAreaNo(int areaNo) {
		this.areaNo = areaNo;
	}
	/**
	 * @return the pLoad
	 */
	public FuncLoad getPLoad() {
		return pLoad;
	}
	/**
	 * @param load the pLoad to set
	 */
	public void setPLoad(FuncLoad load) {
		pLoad = load;
	}
	/**
	 * @return the qLoad
	 */
	public FuncLoad getQLoad() {
		return qLoad;
	}
	/**
	 * @param load the qLoad to set
	 */
	public void setQLoad(FuncLoad load) {
		qLoad = load;
	}
	/**
	 * @return the zoneNo
	 */
	public int getZoneNo() {
		return zoneNo;
	}
	/**
	 * @param zoneNo the zoneNo to set
	 */
	public void setZoneNo(int zoneNo) {
		this.zoneNo = zoneNo;
	}
}
