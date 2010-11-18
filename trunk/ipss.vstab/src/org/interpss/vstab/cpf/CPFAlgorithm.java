package org.interpss.vstab.cpf;



import org.interpss.vstab.cpf.CpfStopCriteria.AnalysisStopCriteria;

import com.interpss.common.msg.IPSSMsgHub;

public interface CPFAlgorithm {
	public static final String copyright = "Copyright www.interpss.org 2005-2010";

	public  int getMaxIterations();
	
	public  void setMaxIterations(int paramInt);
	
	public  void setAnalysisStopCriteria(AnalysisStopCriteria stopCriteria);
	
	public  AnalysisStopCriteria getAnalysisStopCriteria();
	
	
    public void setLoadIncPattern(LoadIncPattern loadIncPtn);
    public LoadIncPattern getLoadIncPatten();
    
    public void setGenDispPattern(GenDispPattern genDispPtn);
    public GenDispPattern getGenDispPatten();
    
    public  IPSSMsgHub getMsgHub();
    
    public void setMsgHub(IPSSMsgHub paramIPSSMsgHub);
    
    public boolean runCPF();
    
    public double getTolerance();
    
    public  double getTolerance(byte unit);

    public  void setTolerance(double tol, byte unit);

}
