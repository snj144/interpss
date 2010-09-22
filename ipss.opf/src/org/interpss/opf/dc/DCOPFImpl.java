package org.interpss.opf.dc;
import com.interpss.opf.OpfNetwork;

public class DCOPFImpl implements DCOPF {
	// network
	
	protected OpfNetwork opfnet=null;
	protected QuadProgCalculator qpc=null;
	// attributes for DC-OPF;
    protected final static double DEFAULT_AnglePenCoff=1;
	protected double anglePenCoeff=DEFAULT_AnglePenCoff;

	
	public DCOPFImpl(OpfNetwork opfNet) {
		this.opfnet=opfNet;
		this.anglePenCoeff=opfNet.getAnglePenaltyFactor();
//		solveDCOPF();

	}
    // constructor for creating A new instance of DCOPF
	public DCOPFImpl() {
		
	}
    
	
	@Override
	public void loadOpfNetData(OpfNetwork opfNet) {
		this.setNetwork(opfNet);
		
	}
	private void setNetwork(OpfNetwork opfNet) {
		this.opfnet=opfNet;
		
	}

	@Override
	public void runDCOPF() {
		
		
	}
}
