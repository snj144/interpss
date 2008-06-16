package org.interpss.ed.unit;

public interface IGenCostFunc {

	/**
     *  Routine to return unit incremental heat rate given unit output in MW
     * @param unitMw unit mw
     * @return unit incremental heat rate
	 */
	public double incHeatRate(double unitMw);
	
	/**
     * Routine to return unit MW given unit incremental heat rate
     * @param unitIhr unit inc heat rate
     * @param unit MW stored in unitmw
    */
	public double inverserIHR(double unitIhr);
	
	/**
	 * Routine to return unit production cost given unit output in mw
	 * 
	 * @param unitMw nit mw
	 * @return unit production cost
	 */
	public double productionCost(double unitMw); 
}
