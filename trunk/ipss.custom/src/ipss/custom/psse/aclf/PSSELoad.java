package ipss.custom.psse.aclf;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.util.XmlUtil;
import com.interpss.core.aclfadj.impl.RegulateLoadImpl;

public class PSSELoad extends RegulateLoadImpl {

	private int areaNo = 0;
	private int zoneNo = 0;
	private int ownerNo = 0;
	private Complex constPLoad = new Complex(0.0,0.0);   // in pu
	private Complex constILoad = new Complex(0.0,0.0);   // in pu
	private Complex constZLoad = new Complex(0.0,0.0);   // in pu

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
	
	public String toString() {
		return XmlUtil.toXmlString(this);
	}
	/**
	 * @return the constILoad
	 */
	public Complex getConstILoad() {
		return constILoad;
	}
	/**
	 * @param constILoad the constILoad to set
	 */
	public void setConstILoad(Complex constILoad) {
		this.constILoad = constILoad;
	}
	/**
	 * @return the constPLoad
	 */
	public Complex getConstPLoad() {
		return constPLoad;
	}
	/**
	 * @param constPLoad the constPLoad to set
	 */
	public void setConstPLoad(Complex constPLoad) {
		this.constPLoad = constPLoad;
	}
	/**
	 * @return the constZLoad
	 */
	public Complex getConstZLoad() {
		return constZLoad;
	}
	/**
	 * @param constZLoad the constZLoad to set
	 */
	public void setConstZLoad(Complex constZLoad) {
		this.constZLoad = constZLoad;
	}
}
