package org.interpss.vstab.cpf;

import com.interpss.common.msg.IPSSMsgHub;

public interface CPFAlgorithm {
	public static final String copyright = "Copyright www.interpss.org 2005-2010";

	public abstract int getMaxIterations();

	public abstract void setMaxIterations(int paramInt);
	
    public void setLoadIncPatten();
    
    public void setGenDispPatten();
    
    public abstract IPSSMsgHub getMsgHub();

    public abstract void setMsgHub(IPSSMsgHub paramIPSSMsgHub);
    
    public boolean runCPF();
    
    public abstract double getTolerance(byte paramByte, double paramDouble);

    public abstract void setTolerance(double paramDouble1, byte paramByte, double paramDouble2);

}
