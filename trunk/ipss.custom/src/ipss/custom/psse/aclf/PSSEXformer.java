package ipss.custom.psse.aclf;

import ipss.custom.exchange.psse.OwnerRec;

import com.interpss.core.aclf.impl.AclfBranchExtImpl;

public class PSSEXformer extends AclfBranchExtImpl {
	private int fladWinding = 1;
	private int flagZ = 1;
	private int flagMagnetizing = 1;
	private double magG = 0.0;
	private double magB = 0.0;
	private double mvaRating = 0.0;   // in mav
	private double fromRatedVoltage;  // in Volts
	private double toRatedVoltage;    // in Volts
	private int xfrTableIdNumber = 0;
	
	private OwnerRec[]  ownerList = new OwnerRec[4];
	
	public PSSEXformer(String cirId) {
      	setCircuitNumber(cirId);
	}
	
	public OwnerRec getOwnerRec(int i) {
		if (ownerList[i] == null)
			ownerList[i] = new OwnerRec();
		return ownerList[i];
	}

	/**
	 * @return the falgMagnetizing
	 */
	public int getFlagMagnetizing() {
		return flagMagnetizing;
	}

	/**
	 * @param falgMagnetizing the flagMagnetizing to set
	 */
	public void setFlagMagnetizing(int flagMagnetizing) {
		this.flagMagnetizing = flagMagnetizing;
	}

	/**
	 * @return the fladWinding
	 */
	public int getFladWinding() {
		return fladWinding;
	}

	/**
	 * @param fladWinding the fladWinding to set
	 */
	public void setFladWinding(int fladWinding) {
		this.fladWinding = fladWinding;
	}

	/**
	 * @return the flagZ
	 */
	public int getFlagZ() {
		return flagZ;
	}

	/**
	 * @param flagZ the flagZ to set
	 */
	public void setFlagZ(int flagZ) {
		this.flagZ = flagZ;
	}

	/**
	 * @return the magB
	 */
	public double getMagB() {
		return magB;
	}

	/**
	 * @param magB the magB to set
	 */
	public void setMagB(double magB) {
		this.magB = magB;
	}

	/**
	 * @return the magG
	 */
	public double getMagG() {
		return magG;
	}

	/**
	 * @param magG the magG to set
	 */
	public void setMagG(double magG) {
		this.magG = magG;
	}

	/**
	 * @return the fromRatedVoltage
	 */
	public double getFromRatedVoltage() {
		return fromRatedVoltage;
	}

	/**
	 * @param fromRatedVoltage the fromRatedVoltage to set
	 */
	public void setFromRatedVoltage(double fromRatedVoltage) {
		this.fromRatedVoltage = fromRatedVoltage;
	}

	/**
	 * @return the mvaRating
	 */
	public double getMvaRating() {
		return mvaRating;
	}

	/**
	 * @param mvaRating the mvaRating to set
	 */
	public void setMvaRating(double mvaRating) {
		this.mvaRating = mvaRating;
	}

	/**
	 * @return the toRatedVoltage
	 */
	public double getToRatedVoltage() {
		return toRatedVoltage;
	}

	/**
	 * @param toRatedVoltage the toRatedVoltage to set
	 */
	public void setToRatedVoltage(double toRatedVoltage) {
		this.toRatedVoltage = toRatedVoltage;
	}

	/**
	 * @return the xfrTableIdNumber
	 */
	public int getXfrTableIdNumber() {
		return xfrTableIdNumber;
	}

	/**
	 * @param xfrTableIdNumber the xfrTableIdNumber to set
	 */
	public void setXfrTableIdNumber(int xfrTableIdNumber) {
		this.xfrTableIdNumber = xfrTableIdNumber;
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		return result.toString();
	}	
}
