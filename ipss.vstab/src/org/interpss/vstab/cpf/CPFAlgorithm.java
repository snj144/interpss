package org.interpss.vstab.cpf;



import org.interpss.vstab.cpf.CpfStopCriteria.AnalysisStopCriteria;

import com.interpss.common.msg.IPSSMsgHub;

public interface CPFAlgorithm {
	public static final String copyright = "Copyright www.interpss.org 2005-2010";

	public  int getMaxIterations();
	
	public  void setMaxIterations(int paramInt);
	
	public  void setAnalysisCode(AnalysisStopCriteria stopCriteria);
	
	public  AnalysisStopCriteria getAnalysisCode();
	
	
    public void setLoadIncPatten(LoadIncPatten loadIncPtn);
    public LoadIncPatten getLoadIncPatten();
    
    public void setGenDispPatten(GenDispPatten genDispPtn);
    public GenDispPatten getGenDispPatten();
    
    public  IPSSMsgHub getMsgHub();
    
    public void setMsgHub(IPSSMsgHub paramIPSSMsgHub);
    
    public boolean runCPF();
    
    public double getTolerance();
    
    public  double getTolerance(byte unit);

    public  void setTolerance(double tol, byte unit);

}
