package custom.dstab.exc;



public class CustomExciterData {
	public CustomExciterData() {}

	private double ka = 10.0;
	private double ta = 0.05;
	private double vrmax = 10.0;
	private double vrmin = 0.0;
	/**
	 * @return Returns the ka.
	 */
	public double getKa() {
		return ka;
	}
	/**
	 * @param ka The ka to set.
	 */
	public void setKa(double ka) {
		this.ka = ka;
	}
	/**
	 * @return Returns the ta.
	 */
	public double getTa() {
		return ta;
	}
	/**
	 * @param ta The ta to set.
	 */
	public void setTa(double ta) {
		this.ta = ta;
	}
	/**
	 * @return Returns the vrmax.
	 */
	public double getVrmax() {
		return vrmax;
	}
	/**
	 * @param vrmax The vrmax to set.
	 */
	public void setVrmax(double vrmax) {
		this.vrmax = vrmax;
	}
	/**
	 * @return Returns the vrmin.
	 */
	public double getVrmin() {
		return vrmin;
	}
	/**
	 * @param vrmin The vrmin to set.
	 */
	public void setVrmin(double vrmin) {
		this.vrmin = vrmin;
	}
}

