package ipss.custom.psse.aclf;

import ipss.custom.psse.OwnerRec;

import com.interpss.core.aclf.impl.AclfBranchExtImpl;

public class PSSELine extends AclfBranchExtImpl {
	private double length = 0.0;
	private OwnerRec[]  ownerList = new OwnerRec[4];
	
	public PSSELine(String cirId) {
      	setCircuitNumber(cirId);
	}
	
	public OwnerRec getOwnerRec(int i) {
		if (ownerList[i] == null)
			ownerList[i] = new OwnerRec();
		return ownerList[i];
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		return result.toString();
	}		
}
