package org.interpss.editor.data.aclf;

import com.interpss.common.rec.BaseDataBean;

/**
*	AclfBusForm class for storing aclf bus data.
*/


public class AclfBusData extends BaseDataBean{
	public static final String 
			GenCode_PQ = "PQ",
			GenCode_PV = "PV",
			GenCode_Swing = "Swing",
			GenCode_Capacitor = "Capacitor",
			GenCode_NonGen = "NonGen",
			
			LoadCode_ConstP = "ConstantP",
			LoadCode_ConstI = "ConstantI",
			LoadCode_ConstZ = "ConstantZ",
			LoadCode_FuncLoad = "FuncLoad",
			LoadCode_NonLoad = "NonLoad";
	
    private String  genCode = GenCode_NonGen;  
    private double  voltageAng = 0d;
    private String  voltageAngUnit = "Deg";
    private double  voltageMag = 1.0d;       // VoltgeMsg is used to hold PV-VSpec, ReQVolt-VSpec and ReQMvarFlow-MvarSpec 
    private String  voltageMagUnit = "PU";   // PU | %

    private double  capQ = 0d;
    private String  capQUnit = "PU";

    private double  genP = 0d;
    private double  genQ = 0d;
    private String  genUnit = "PU";

    private String  loadCode = LoadCode_NonLoad;  // ConstantP | ConstantI | ConstantZ
    private double  loadP = 0d;
    private double  loadQ = 0d;
    private String  loadUnit = "PU";

    private double  shuntG = 0d;
    private double  shuntB = 0d;
    private String  shuntYUnit = "PU";

    public double getCapQ() { return this.capQ; }
    public void setCapQ(double value) { this.capQ = value; }

    public String getCapQUnit() { return this.capQUnit; }
    public void setCapQUnit(String value) { this.capQUnit = value; }

    public double getGenP() { return  this.genP;   }
    public void setGenP(double value) { this.genP = value; }

    public double getGenQ() { return this.genQ; }
    public void setGenQ(double value) { this.genQ = value; }

    public String getGenUnit() { return this.genUnit; }
    public void setGenUnit(String value) { this.genUnit = value; }

    public String getGenCode() { return this.genCode;  }
    public void setGenCode(String value) { this.genCode = value; }

    public double getLoadP() { return this.loadP; }
    public void setLoadP(double value) { this.loadP = value; }

    public double getLoadQ() { return this.loadQ; }
    public void setLoadQ(double value) { this.loadQ = value; }

    public String getLoadUnit() { return this.loadUnit; }
    public void setLoadUnit(String value) { this.loadUnit = value; }

    public String getLoadCode() { return  this.loadCode; }
    public void setLoadCode(String value) { this.loadCode = value; }

    public double getVoltageAng() { return this.voltageAng; }
    public void setVoltageAng(double value) { this.voltageAng = value;  }

    public void setVoltageAngUnit(String value) { this.voltageAngUnit = value; }
    public String getVoltageAngUnit() {  return this.voltageAngUnit; }

    public double getVoltageMag() { return this.voltageMag; }
    public void setVoltageMag(double value) { this.voltageMag = value; }

    public String getVoltageMagUnit() { return this.voltageMagUnit; }
    public void setVoltageMagUnit(String value) { this.voltageMagUnit = value; }
	/**
	 * @return Returns the shuntB.
	 */
	public double getShuntB() {
		return shuntB;
	}
	/**
	 * @param shuntB The shuntB to set.
	 */
	public void setShuntB(double shuntB) {
		this.shuntB = shuntB;
	}
	/**
	 * @return Returns the shuntG.
	 */
	public double getShuntG() {
		return shuntG;
	}
	/**
	 * @param shuntG The shuntG to set.
	 */
	public void setShuntG(double shuntG) {
		this.shuntG = shuntG;
	}
	/**
	 * @return Returns the shuntYUnit.
	 */
	public String getShuntYUnit() {
		return shuntYUnit;
	}
	/**
	 * @param shuntYUnit The shuntYUnit to set.
	 */
	public void setShuntYUnit(String shuntYUnit) {
		this.shuntYUnit = shuntYUnit;
	}
	
	public boolean isLoad() {
	    return !getLoadCode().equals(LoadCode_NonLoad) && 
	    		(getLoadP() != 0.0 || getLoadQ() != 0.0);
	}
}