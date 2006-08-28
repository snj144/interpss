package ipss.custom.psse.aclf;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.util.XmlUtil;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.impl.RegulateLoadImpl;
import com.interpss.core.datatype.FuncLoad;
import com.interpss.core.net.Network;

public class PSSELoad extends RegulateLoadImpl {

	private int areaNo = 0;
	private int zoneNo = 0;
	private int ownerNo = 0;
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
	/**
	 * @return the ownerNo
	 */
	public int getOwnerNo() {
		return ownerNo;
	}
	/**
	 * @param ownerNo the ownerNo to set
	 */
	public void setOwnerNo(int ownerNo) {
		this.ownerNo = ownerNo;
	}
	

	/**
	 * Calculate load based on the bus voltage
	 * 
	 * @param obj load parent bus obj
	 * @param net Aclf net
	 * @return a Complex load object
	 */
	@Override
	public Object calculateAdjustment(Object obj, Network net) {
		AclfBus bus = (AclfBus)obj;
		return new Complex(getPLoad().getLoad(bus.getVoltageMag(), UnitType.PU, net.getBaseKva()), 
				           getQLoad().getLoad(bus.getVoltageMag(), UnitType.PU, net.getBaseKva()));
	}
	
	/**
	 * Check if load need to be recalculated
	 * 
	 * @param obj load parent bus obj
	 * @param net Aclf net
	 */
	@Override
	public boolean needAdjustment(Object obj, Network net) {
		// for constant P load pLoad.A = 1.0 and qLoad.A = 1.0
		return getPLoad().getA() == 1.0 && getQLoad().getA() == 0.0;
	}
	
	/** 
	 * performAdjusment method not needed.
	 */
	@Override
	public boolean performAdjusment(Object obj, Network net) {
		throw new InvalidOperationException("Programming error: call PSSELoad.performAdjustment()");
	}
	
	public String toString() {
		return XmlUtil.toXmlString(this);
	}
}
