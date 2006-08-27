package org.interpss.editor.data.aclf;

/**
*	AclfAdjBusForm class for storing aclf bus adjustment data.
*/

public class AclfAdjBusData extends AclfBusData {
	public static final int ReQControlType_Voltage = 1;
	public static final int ReQControlType_MvarFlow = 2;
	
    private double  loadP_PPct = 0d;
    private double  loadP_IPct = 0d;
    private double  loadQ_PPct = 0d;
    private double  loadQ_IPct = 0d;
    
    private boolean hasLimitControl = false;
    private double  maxVoltMag = 1.1d;
    private double  minVoltMag = 0.9d;
    private double  maxGenQ = 0d;
    private double  minGenQ = 0d;

    private boolean hasRemoteVControl = false;
    private int     reQControlType = ReQControlType_Voltage;
    private String  remoteControlBusId = "";
    private boolean flowFrom2To = true;
    private boolean mvarControlOnFromSide = true;
    
    public double getLoadP_PPct() { return this.loadP_PPct; }
    public void setLoadP_PPct(double loadPPPct) { this.loadP_PPct = loadPPPct;}

    public double getLoadP_IPct() { return this.loadP_IPct; }
    public void setLoadP_IPct(double loadPIPct) { this.loadP_IPct = loadPIPct; }

    public double getLoadQ_PPct() { return this.loadQ_PPct; }
    public void setLoadQ_PPct(double loadQPPct) { this.loadQ_PPct = loadQPPct; }

    public double getLoadQ_IPct() { return this.loadQ_IPct; }
    public void setLoadQ_IPct(double loadQIPct) { this.loadQ_IPct = loadQIPct; }

    public String getRemoteControlBusId() { return this.remoteControlBusId; }
    public void setRemoteControlBusId(String remoteControlBusId) { this.remoteControlBusId = remoteControlBusId;   }
    public String getRemoteControlBranchId() { return this.remoteControlBusId; }
    public void setRemoteControlBranchId(String id) { this.remoteControlBusId = id;   }

    public double getMinGenQ() { return this.minGenQ;  }
    public void setMinGenQ(double value) { this.minGenQ = value; }

    public double getMaxGenQ() { return this.maxGenQ; }
    public void setMaxGenQ(double value) { this.maxGenQ = value; }

    public double getMinVoltMag() { return this.minVoltMag; }
    public void setMinVoltMag(double value) { this.minVoltMag = value; }

    public double getMaxVoltMag() { return this.maxVoltMag; }
    public void setMaxVoltMag(double value) { this.maxVoltMag = value; }

    public boolean isHasRemoteVControl() { return this.hasRemoteVControl; }
    public void setHasRemoteVControl(boolean hasRemoteVControl) { this.hasRemoteVControl = hasRemoteVControl; }

    public int getReQControlType() { return this.reQControlType; }
    public void setReQControlType(int n) { this.reQControlType = n; }

    public boolean isHasLimitControl() { return this.hasLimitControl; }
    public void setHasLimitControl(boolean hasLimitControl) { this.hasLimitControl = hasLimitControl; }

    public boolean isFlowFrom2To() { return this.flowFrom2To; }
    public void setFlowFrom2To(boolean b) { this.flowFrom2To = b; }

    public boolean isMvarControlOnFromSide() { return this.mvarControlOnFromSide; }
    public void setMvarControlOnFromSide(boolean b) { this.mvarControlOnFromSide = b; }
}