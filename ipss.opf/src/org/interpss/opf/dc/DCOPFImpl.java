package org.interpss.opf.dc;
import java.util.ArrayList;
import java.util.Hashtable;


import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.*;
import com.interpss.core.aclf.impl.AclfBusImpl;
import com.interpss.core.algorithm.BusArrangeRule;
import com.interpss.core.algorithm.NetworkAlgorithm;
import com.interpss.core.common.IAclfBusVisitor;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.opf.OpfGenBus;
import com.interpss.opf.OpfNetwork;
import com.interpss.opf.OpfObjectFactory;
import com.interpss.opf.common.IOpfGenBusVisitor;

import org.interpss.opf.dc.Apache2ColtAdapter;


import org.apache.commons.math.linear.*;

import quadprogj.QuadProgJ;

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
