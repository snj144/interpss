package org.interpss.vstab;

import java.util.ArrayList;
import java.util.List;

import com.interpss.core.aclf.AclfNetwork;

import Jama.Matrix;
// ¿¼ÂÇ DataReader ,GenDispatch ,LoadIncrease have a super class
// named Data ;
// loadP0 loadQ0;genPmax, genP0; net;
public class LoadIncease { 
    // connect to loadIncPatten , to get how the net is to be Inceased  
    private Matrix LoadP0;
    private Matrix incLoadP;
    private Matrix LoadQ0;
    private Matrix incLoadQ;
    private Matrix dirP;
    private Matrix dirQ;
    private double lambda;
    private AclfNetwork net;
    private  List<Integer> incLoadBusList = new ArrayList<Integer>();
    public LoadIncease(AclfNetwork net, List<Integer> incLoadBusList,Double lambda){
    	this.net=net;
    	this.incLoadBusList=incLoadBusList;
    	this.lambda=lambda;
    }
	public void incLoad(){
		
		// P=P0+Lambda* dirp ;
		this.incLoadP=this.LoadP0.plus(this.dirP.times(this.lambda));
		// Q=Q0+Lambda*dirQ;
		this.incLoadQ=this.LoadQ0.plus(this.dirQ.times(this.lambda));
		// save the P Q to the net ;
		
		//return 
		
	}
	public void initIncDirection(){
		int NumOfLoadBus =this.getLoadP0().getRowDimension();
		Matrix dirpq =new Matrix(2*NumOfLoadBus,1); //  m should be (NumofBusX2)
		dirpq.setMatrix(0, NumOfLoadBus-1, 0, 0,this.getLoadP0());
		dirpq.setMatrix(NumOfLoadBus, 2*NumOfLoadBus-1, 0, 0,this.getLoadQ0());
		dirpq.times(1/dirpq.normF());
		this.dirP =dirpq.getMatrix(0, NumOfLoadBus-1, 0, 0);
		this.dirQ =dirpq.getMatrix(NumOfLoadBus, 2*NumOfLoadBus-1, 0, 0);
	}
	public void setPQDirection(Matrix dirp,Matrix dirq){
		// set dirp ,dirq
		this.dirP=dirp;
		this.dirQ=dirp;
	}
	public void setPDirection (Matrix dirp){
		this.dirP=dirp;
	}
	public Matrix getLoadP0(){
		return this.LoadP0;
	}
	public void setLoadP0(Matrix originLoadP){
		this.LoadP0=originLoadP;
	}
	public Matrix getLoadQ0(){
		return this.LoadQ0;
	}
	public void setLoadQ0(Matrix originLoadQ){
		this.LoadP0=originLoadQ;
	}
	public Matrix getIncLoadP(){
		incLoad();
		return incLoadP;
	}
	public Matrix getIncLoadQ(){
		incLoad();
		return incLoadQ;
	}
	
	public double getSumOfIncLoadP(){
		return new MatrixCalc().sumOfElement(incLoadP);
	}
	
}
