package org.interpss.vstab.Impl;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.LUDecompositionImpl;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;
import org.interpss.vstab.SensitiveAnalysis;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;

public class SensitiveAnalysisImpl implements SensitiveAnalysis {
    protected double busVQSens;
    protected double loadGenSens;
    protected double loadLineSens;
    protected RealVector vectorOfSensDeg;
    private RealMatrix JLFreduced;
    private RealMatrix invJlfr;
	private AclfNetwork net;
	private IPSSMsgHub msg;
	private Hashtable <String ,Bus> PQBusLookUpTable;
	private List<Bus> PQBusList;
	
	public SensitiveAnalysisImpl(AclfNetwork net){
		this.net=net;
	}
	public double getBusVQsensetive(String busID) {
		Bus b =this.PQBusLookUpTable.get(busID);
		int idx=this.PQBusList.indexOf(b);
		return this.busVQSens=getBusVQsensetive(idx);
	}
	public double getBusVQsensetive(int PQBusIDX) {
		
		// search the senseDeg of busi using index in VectorOfSensDeg;
		this.busVQSens=this.getSensDegVector().getEntry(PQBusIDX);
		return this.busVQSens;
	}
	// 张伯明 -高等电力网络分析 p204 潮流灵敏度矩阵
	public double getLoadGenSensetive(AclfBus Loadi, AclfBus Genj) {
		// TODO Auto-generated method stub
		return this.loadGenSens;
	}
	public double getLoadLineSensetive(AclfBus Loadi, AclfBranch Linej) {
		// TODO Auto-generated method stub
		return this.loadLineSens;
	}
    private void invJlfr(){
    	if(this.net==null){
    		msg.sendErrorMsg("net is null ,need to initialize SensitiveAnalysisImpl with a AclfNetwork first");
    	}
    	else{
    	this.JLFreduced=new Jacobi4VSAImpl(net).getReducedJacobi();
    	this.invJlfr=new LUDecompositionImpl(this.JLFreduced).getSolver().getInverse();
    	}
    }
    private RealVector getSensDegVector(){
    	invJlfr();
    	int row=this.invJlfr.getRowDimension();
    	this.vectorOfSensDeg=new ArrayRealVector(row);
    	try{
    	for(int i=0;i<row;i++){
    		this.vectorOfSensDeg.setEntry(i, this.invJlfr.getEntry(i, i));
    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return this.vectorOfSensDeg;
    	
    }
    private void makePQBusLookUpTable(){
    	if(this.net==null){
    		msg.sendErrorMsg("net is null ,need to initialize SensitiveAnalysisImpl with a AclfNetwork first");
    	    return ;
    	}
    	else{
    	  this.PQBusLookUpTable=new Hashtable<String ,Bus>(this.net.getNoBus());
    	  for(Iterator busIt=this.net.getBusList().iterator(); busIt.hasNext();){
    		AclfBus b=(AclfBus) busIt.next();
    		if(!b.isGenPV()&&!b.isSwing()){
    			this.PQBusLookUpTable.put(b.getId(), b);
    			this.PQBusList.add(b);
    		}
    	  }
       }
    	
    	
    }

}
