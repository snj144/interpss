package org.interpss.editor.data.aclf;

/**
*	AclfAdjBranchForm class for storing aclf branch adjustment data.
*/

public class AclfAdjBranchData  extends AclfBranchData {
	public static final int TapControlType_Voltage = 1;
	public static final int TapControlType_MvarFlow = 2;
	
    private boolean hasTapVControl = false;
    private int     tapVControlType = TapControlType_Voltage;
    private String  vcBusId = "";
    private double  vcVSpec = 1.0d;
    private String  vcVSpecUnit = "PU";
    private boolean isVCBusOnFromSide = true;
    private boolean isVCTapOnFromSide = true;
    private double  vcTapMax = 1.1d;
    private double  vcTapMin = 0.9d;
    private String  vcTapUnit = "PU";
    private double  vcStep = 0;

    private boolean hasPSXfrPControl = false;
    private double  pcPSpec = 0d;
    private String  pcPSpecUnit = "PU";
    private boolean pcOnFromSide = true;
    private boolean flowFrom2To = true;
    private double  pcAngMax = 10.0d;
    private double  pcAngMin = 0d;
    private String  pcAngUnit = "Deg";

    public String getVcBusId() { return this.vcBusId; }
    public void setVcBusId(String value) { this.vcBusId = value; }

    public String getVcVSpecUnit() { return this.vcVSpecUnit; }
    public void setVcVSpecUnit(String value) { this.vcVSpecUnit = value;}

    public String getPcTapUnit() { return this.vcTapUnit; }
    public void setPcTapUnit(String value) { this.vcTapUnit = value;}

    public String getPcPSpecUnit() { return this.pcPSpecUnit; }
    public void setPcPSpecUnit(String value) { this.pcPSpecUnit = value; }

    public String getPcAngUnit() { return this.pcAngUnit; }
    public void setPcAngUnit(String value) { this.pcAngUnit = value; }

    public boolean isHasTapVControl() { return this.hasTapVControl; }
    public void setHasTapVControl(boolean hasTapVControl) { this.hasTapVControl = hasTapVControl; }

    public int  getTapVControlType() { return this.tapVControlType; }
    public void setTapVControlType(int type) { this.tapVControlType = type; }

    public boolean isHasPSXfrPControl() { return this.hasPSXfrPControl; }
    public void setHasPSXfrPControl(boolean hasPSXfrPControl) { this.hasPSXfrPControl = hasPSXfrPControl;   }

    public boolean isVCTapOnFromSide() { return this.isVCTapOnFromSide; }
    public void setVCTapOnFromSide(boolean isControlTapFromSide) { this.isVCTapOnFromSide = isControlTapFromSide;   }

    public boolean isVCBusOnFromSide() { return this.isVCBusOnFromSide; }
    public void setVCBusOnFromSide(boolean isVCBusFromSide) { this.isVCBusOnFromSide = isVCBusFromSide; }
    public boolean isMvarSpecOnFromSide() { return this.isVCBusOnFromSide; }
    public void setMvarSpecOnFromSide(boolean isVCBusFromSide) { this.isVCBusOnFromSide = isVCBusFromSide; }

    public boolean isPcOnFromSide() { return this.pcOnFromSide; }
    public void setPcOnFromSide(boolean isPCOnFromSide) { this.pcOnFromSide = isPCOnFromSide;  }

    public boolean isFlowFrom2To() { return this.flowFrom2To; }
    public void setFlowFrom2To(boolean isFlowFrom2To) { this.flowFrom2To = isFlowFrom2To;  }

    public double getVcVSpec() { return this.vcVSpec; }
    public void setVcVSpec(double vCMagValue) { this.vcVSpec = vCMagValue; }
    public double getMvarFlowSpec() { return this.vcVSpec; }
    public void setMvarFlowSpec(double vCMagValue) { this.vcVSpec = vCMagValue; }

    public double getVcTapMax() { return this.vcTapMax;     }
    public void setVcTapMax(double x) { this.vcTapMax = x;     }

    public double getVcTapMin() { return this.vcTapMin;     }
    public void setVcTapMin(double vcTapMin) { this.vcTapMin = vcTapMin;     }

    public double getPcPSpec() { return this.pcPSpec;     }
    public void setPcPSpec(double pCMagValue) { this.pcPSpec = pCMagValue;     }

    public double getPcAngMax() { return this.pcAngMax;     }
    public void setPcAngMax(double angMax) { this.pcAngMax = angMax;     }

    public double getPcAngMin() { return this.pcAngMin;     }
    public void setPcAngMin(double angMin) { this.pcAngMin = angMin;     }

    public double getVcStep() { return this.vcStep;     }
    public void setVcStep(double step) { this.vcStep = step;     }
}