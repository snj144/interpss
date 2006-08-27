package org.interpss.editor.data.acsc;

import com.interpss.common.rec.BaseDataBean;
import com.interpss.common.util.NetUtilFunc;

public class AcscFaultData extends BaseDataBean {
	public static final String FaultCaty_3P = "3P";
	public static final String FaultCaty_LG = "LG";
	public static final String FaultCaty_LL = "LL";
	public static final String FaultCaty_LLG = "LLG";
	public static final String FaultCaty_All = "All";
	
	public static final String FaultType_Bus = "Bus";
	public static final String FaultType_Branch = "Branch";
	
  	protected String type = FaultType_Bus;  
  	public String getType() { return this.type; }
  	public void setType(String faultType) { this.type = faultType; }

  	protected String busBranchNameId = "";
  	public String getBusBranchNameId() { return this.busBranchNameId; }
  	public void setBusBranchNameId(String id) { this.busBranchNameId = id; }
  	public String getBusBranchId() { return NetUtilFunc.getBusIdFromDisplayNameId(this.busBranchNameId); }
  	public String getBusId() { return NetUtilFunc.getBusIdFromDisplayNameId(this.busBranchNameId); }
  	public String getBranchId() { return NetUtilFunc.getBranchIdFromDisplayNameId(this.busBranchNameId); }

	protected double distance = 0; // distance in %
    public double getDistance() { return this.distance; }
    public void setDistance(double d) { this.distance = d; }

  	protected String category = FaultCaty_3P;   
  	public String getCategory() { return this.category;  }
  	public void setCategory(String faultCategory) { this.category = faultCategory; }

	protected double LG_R = 0.0;
    public double getLG_R() { return this.LG_R; }
    public void setLG_R(double fault_LG_R) { this.LG_R = fault_LG_R; }

	protected double LG_X = 0.0;
    public double getLG_X() { return this.LG_X; }
    public void setLG_X(double fault_LG_X) { this.LG_X = fault_LG_X; }

	protected double LL_R = 0.0;
    public double getLL_R() { return this.LL_R; }
    public void setLL_R(double fault_LL_R) { this.LL_R = fault_LL_R; }

	protected double LL_X = 0.0;
    public double getLL_X() { return this.LL_X; }
    public void setLL_X(double fault_LL_X) { this.LL_X = fault_LL_X; }
}