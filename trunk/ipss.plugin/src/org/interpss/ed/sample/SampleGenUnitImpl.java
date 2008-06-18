package org.interpss.ed.sample;

import org.interpss.ed.IEDGenUnit;
import org.interpss.ed.costf.AbstractCostFunc;
import org.interpss.ed.costf.CostFuncPolynomial;

public class SampleGenUnitImpl implements IEDGenUnit {
	public CostFuncType costFuncType;
	public AbstractCostFunc costFunc = null;
	public String name;
	public double p, penFactor;
	public double pmax, pmin, fuelcost, ihrmax, ihrmin;

	public SampleGenUnitImpl(CostFuncType costFuncType) {
		this.costFuncType = costFuncType;
	}
	
	@Override
	public CostFuncType getCostFuncType() {
		return this.costFuncType;
	}

	@Override
	public double getFuelCost() {
		return this.fuelcost;
	}

	@Override
	public double getIhrmax() {
		return this.ihrmax;
	}

	@Override
	public double getIhrmin() {
		return this.ihrmin;
	}

	@Override
	public double getIOCost(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getIOMwPoint(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getP() {
		return this.p;
	}

	@Override
	public double getPenaltyFactor() {
		return this.penFactor;
	}

	@Override
	public double getPmax() {
		return this.pmax;
	}

	@Override
	public double getPmin() {
		return this.pmin;
	}

	@Override
	public double incHeatRate(double unitMw) {
		return this.costFunc.incHeatRate(unitMw);
	}

	@Override
	public double inverserIhr(double unitIhr) throws Exception {
		return this.costFunc.inverserIhr(unitIhr, this.pmax, this.pmin);
	}

	@Override
	public double productionCost(double unitMw) {
		return this.costFunc.productionCost(unitMw);
	}

	@Override
	public void setP(double p) {
		this.p = p;
		
	}

	@Override
	public void setPenaltyFactor(double p) {
		this.penFactor = p;
	}

	public static IEDGenUnit[] createEDC1() {
/*
	FILE EDC1.DAT ------  TEST FILE WITH POLYNOMIAL CURVES , NO LOSSES
	------------------------------------------------------------------
	3  POLY  2  NOLOSS
	UNIT1  100.0  200.0  1.0 [name, low MW limit, high MW limit, fuel cost] 
	100.0
	1.0
	1.0
	UNIT2  50.0  150.0  1.0
	100.0
	1.0
	1.0
	UNIT3  200.0  450.0  1.0
	10.0
	1.0
	1.0
 */
		int ngen = 3;
		CostFuncType type = CostFuncType.Polynomial;
		
		IEDGenUnit[] genAry = new SampleGenUnitImpl[ngen];
		genAry[0] = new SampleGenUnitImpl(type);
		try {
			SampleGenUnitImpl gen = (SampleGenUnitImpl)genAry[0];
			gen.costFunc = new CostFuncPolynomial(2);
			gen.name = "UNIT1";
			gen.pmin = 100.0;
			gen.pmax = 200.0;
			gen.fuelcost = 1.0;
			CostFuncPolynomial cfunc = (CostFuncPolynomial)gen.costFunc;
			cfunc.setCoeff(0, 100.0);
			cfunc.setCoeff(1, 1.0);
			cfunc.setCoeff(2, 1.0);
			
			genAry[1] = new SampleGenUnitImpl(type);
			gen = (SampleGenUnitImpl)genAry[1];
			gen.costFunc = new CostFuncPolynomial(2);
			gen.name = "UNIT2";
			gen.pmin = 50.0;
			gen.pmax = 150.0;
			gen.fuelcost = 1.0;
			cfunc = (CostFuncPolynomial)gen.costFunc;
			cfunc.setCoeff(0, 100.0);
			cfunc.setCoeff(1, 1.0);
			cfunc.setCoeff(2, 1.0);
			
			genAry[2] = new SampleGenUnitImpl(type);
			gen = (SampleGenUnitImpl)genAry[2];
			gen.costFunc = new CostFuncPolynomial(2);
			gen.name = "UNIT3";
			gen.pmin = 200.0;
			gen.pmax = 450.0;
			gen.fuelcost = 1.0;
			cfunc = (CostFuncPolynomial)gen.costFunc;
			cfunc.setCoeff(0, 10.0);
			cfunc.setCoeff(1, 1.0);
			cfunc.setCoeff(2, 1.0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return genAry;
	}
	
	public String toString() {
		String str = "";
		str += "costFuncType: " + costFuncType + "\n";
		str += "costFunc: " + costFunc.toString() + "\n";
		str += "name, p, penFactor: " + name + ", " + p + ", " + penFactor + "\n";
		str += "pmax, pmin, fuelcost, ihrmax, ihrmin: " + 
				pmax + ", " + pmin + ", " + fuelcost + ", " + ihrmax + ", " + ihrmin + "\n";
		return str;
	}
}
