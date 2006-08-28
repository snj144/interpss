package ipss.custom.psse.aclf;

import ipss.custom.exchange.psse.OwnerRec;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.util.XmlUtil;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.impl.RegulateGeneratorImpl;

public class PSSEGen extends RegulateGeneratorImpl {
	private double 		pGen = 0.0;    		// in pu
	private double 		qGen = 0.0;			// in pu
	private LimitType 	pLimit = null;		// in pu
	private LimitType 	qLimit = null;		// in pu
	private double 		vSpec = 0.0;		// in pu
	private String 		vControlBusId = "0";
	private double 		mvaBase = 0.0;		// in Mva
	private Complex 	zGen = new Complex(0.0,0.0);	// in pu on the MvaBase
	private Complex 	zXfr = new Complex(0.0,0.0);	// in pu
	private double  	xfrTap = 0.0;					// in pu
	private double  	contribFactor = 0.0;  // in pu
	private OwnerRec[]  ownerList = new OwnerRec[4];
	
	/**
	 * @return the contribFactor
	 */
	public double getContribFactor() {
		return contribFactor;
	}
	/**
	 * @param contribFactor the contribFactor to set
	 */
	public void setContribFactor(double contribFactor) {
		this.contribFactor = contribFactor;
	}
	/**
	 * @return the mvaBase
	 */
	public double getMvaBase() {
		return mvaBase;
	}
	/**
	 * @param mvaBase the mvaBase to set
	 */
	public void setMvaBase(double mvaBase) {
		this.mvaBase = mvaBase;
	}
	/**
	 * @return the pGen
	 */
	public double getPGen() {
		return pGen;
	}
	/**
	 * @param gen the pGen to set
	 */
	public void setPGen(double gen) {
		pGen = gen;
	}
	/**
	 * @return the pLimit
	 */
	public LimitType getPLimit() {
		return pLimit;
	}
	/**
	 * @param limit the pLimit to set
	 */
	public void setPLimit(LimitType limit) {
		pLimit = limit;
	}
	/**
	 * @return the qGen
	 */
	public double getQGen() {
		return qGen;
	}
	/**
	 * @param gen the qGen to set
	 */
	public void setQGen(double gen) {
		qGen = gen;
	}
	/**
	 * @return the qLimit
	 */
	public LimitType getQLimit() {
		return qLimit;
	}
	/**
	 * @param limit the qLimit to set
	 */
	public void setQLimit(LimitType limit) {
		qLimit = limit;
	}
	/**
	 * @return the vControlBusId
	 */
	public String getVControlBusId() {
		return vControlBusId;
	}
	/**
	 * @param controlBusId the vControlBusId to set
	 */
	public void setVControlBusId(String controlBusId) {
		vControlBusId = controlBusId;
	}
	/**
	 * @return the vSpec
	 */
	public double getVSpec() {
		return vSpec;
	}
	/**
	 * @param spec the vSpec to set
	 */
	public void setVSpec(double spec) {
		vSpec = spec;
	}
	/**
	 * @return the xfrTap
	 */
	public double getXfrTap() {
		return xfrTap;
	}
	/**
	 * @param xfrTap the xfrTap to set
	 */
	public void setXfrTap(double xfrTap) {
		this.xfrTap = xfrTap;
	}
	/**
	 * @return the zGen
	 */
	public Complex getZGen() {
		return zGen;
	}
	/**
	 * @param gen the zGen to set
	 */
	public void setZGen(Complex gen) {
		zGen = gen;
	}
	/**
	 * @return the zXfr
	 */
	public Complex getZXfr() {
		return zXfr;
	}
	/**
	 * @param xfr the zXfr to set
	 */
	public void setZXfr(Complex xfr) {
		zXfr = xfr;
	}
	
	public OwnerRec getOwnerRec(int i) {
		if (ownerList[i] == null)
			ownerList[i] = new OwnerRec();
		return ownerList[i];
	}
	
	public String toString() {
		return XmlUtil.toXmlString(this);
	}
}
