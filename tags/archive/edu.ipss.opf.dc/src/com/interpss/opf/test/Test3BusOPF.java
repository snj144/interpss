package com.interpss.opf.test;

import static org.junit.Assert.assertEquals;

import org.apache.commons.math.complex.Complex;
import org.junit.Test;

import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.opf.core.DCOPFImpl;
import com.interpss.opf.gen.GenBus4OPF;
import com.interpss.opf.gen.GenBus4OPFImpl;

public class Test3BusOPF {

	/**
	 * @param args
	 */
	@Test
	public void testNetwork(){
		// TODO Auto-generated method stub
        AclfNetwork net=create3BusNetwork();
        GenBus4OPF acbus2=(GenBus4OPF) net.getBus("Bus2");
        //AclfBranch bra1=(AclfBranch) net.getBranchList().get(0);//getBranch("Branch1");
        AclfBranch bra1=(AclfBranch) net.getBranch("Bus1->Bus2(Branch1)");
       // System.out.print("nobus"+net.getNoBus());
        assertEquals(0.00612, acbus2.getCoeffB(), 0);
        assertEquals(0.20,bra1.getZ().getImaginary(),0); //0.20
	}
	@Test
	public void testDCOPF(){
		AclfNetwork net=create3BusNetwork();
		DCOPFImpl opf =new DCOPFImpl();
		opf.setNetwork(net);
		opf.setAnglePenaltyCoeff(2);
		opf.initialize();
		// testG
		assertEquals(0.00463*2, opf.getU().getEntry(0, 0), 0);
		
//		System.out.print(opf.getAngleDiffWeightMatrix().toString());
		assertEquals(2*opf.getAnglePenaltyCoeff()*2, opf.getWrr().getEntry(0, 0), 0);
		
		//test A;
		assertEquals(10.694, opf.getA().getEntry(0), 0);
		//test Ceq
		System.out.print(opf.getCeq().transpose().toString());
		assertEquals(1, opf.getCeq().getEntry(1,1), 0);
		assertEquals(5, opf.getCeq().getEntry(3,0), 0);
		
		//Test Beq
		assertEquals(1.3266, opf.getBeq().getEntry(0), 0); //1.3602
		//test Ciq 
		//System.out.print(opf.getCiq().transpose().toString());
		assertEquals(1, opf.getCiq().getEntry(0,6), 0);
		//test biq
		assertEquals(-0.55, opf.getBiq().getEntry(2), 0); //biq(0)=0.55 ,ratedMva1 of branch3 ,
		
		
		
	}
	@Test
	public void test3BusDCOPF(){
		AclfNetwork net=create3BusNetwork();
		DCOPFImpl opf =new DCOPFImpl(net,1);
		System.out.print(opf.getOptimGen()[0]+"," +opf.getOptimGen()[1]+","+opf.getOptimGen()[2]);
	}
	private  AclfNetwork create3BusNetwork(){
		AclfNetwork net =CoreObjectFactory.createAclfNetwork();
		
		
		//create bus1;
		//GenData

		//ID	atNode	FCost	a	b	capL	capU	initMoney
		//1	    1  142.735	10.694	0.00463	20	200	    10000
		  
		GenBus4OPF bus1=new GenBus4OPFImpl();//(GenBus4OPF) CoreObjectFactory.createAclfBus("Bus1");
		
		//GenBus4OPF genBus1 =new GenBus4OPFImpl(bus1) ;
		bus1.setBaseVoltage(10, UnitType.kV);
		bus1.setId("Bus1");
		bus1.setAttributes("Bus 1", "");
		bus1.setLoadCode(AclfLoadCode.CONST_P);
		bus1.setLoadP(1.3266);
		bus1.setGenCode(AclfGenCode.SWING);
		bus1.setCapLowerLimit(0.2);//in pu
		bus1.setCapUpperLimit(2);
		bus1.setCoeffA(10.694);
		bus1.setCoeffB(0.00463);
		bus1.setFixCost(142.735);
		net.addBus(bus1);
		
		//bus2
		//2	2	218.335	18.1	0.00612	10	150	10000
		  
		GenBus4OPF bus2=new GenBus4OPFImpl();//(GenBus4OPF) CoreObjectFactory.createAclfBus("Bus2");
		bus2.setId("Bus2");
		bus2.setAttributes("Bus 2", "");
		bus2.setBaseVoltage(10, UnitType.kV);
		bus2.setLoadCode(AclfLoadCode.CONST_P);
		bus2.setLoadP(0.4422);
		bus2.setGenCode(AclfGenCode.GEN_PV);
		//GenBus4OPF genBus2 =new GenBus4OPFImpl(bus2) ;
		bus2.setCapLowerLimit(0.1);
		bus2.setCapUpperLimit(1.50);
		bus2.setCoeffA(18.1);
		bus2.setCoeffB(0.00612);
		bus2.setFixCost(218.335);
		net.addBus(bus2);//genBus2
		
		//bus3
		//3	3	118.821	37.8896	0.01433	5	20	10000
		GenBus4OPF bus3=new GenBus4OPFImpl();//(GenBus4OPF) CoreObjectFactory.createAclfBus("Bus3");
		bus3.setId("Bus3");
		bus3.setBaseVoltage(10, UnitType.kV);
		bus3.setAttributes("Bus 3", "");
		bus3.setLoadCode(AclfLoadCode.CONST_P);
		bus3.setLoadP(0.4422);
		bus3.setGenCode(AclfGenCode.GEN_PV);
//		GenBus4OPF genBus3 =new GenBus4OPFImpl(bus3) ;
		bus3.setCapLowerLimit(0.05);
		bus3.setCapUpperLimit(0.2);//in pu
		bus3.setCoeffA(37.8896);
		bus3.setCoeffB(0.01433);
		bus3.setFixCost(118.821);
		net.addBus(bus3);
		
		//Create Branches
		/*
		 * //From	To	lineCap	reactance
          1	2	55	0.20
          1	3	55	0.40
          2	3	55	0.25

		 */
		AclfBranch bra1=CoreObjectFactory.createAclfBranch("Branch1", net);
		bra1.setFromBus(bus1);
		bra1.setToBus(bus2);
		bra1.setZ(new Complex(0,0.20));
		bra1.setRatingMva1(0.55);
		net.addBranch(bra1, "Bus1", "Bus2");
		
		//branch2
		AclfBranch bra2=CoreObjectFactory.createAclfBranch("Branch2", net);
		bra2.setFromBus(bus1);
		bra2.setToBus(bus3);
		bra2.setZ(new Complex(0,0.4));
		bra2.setRatingMva1(0.55);
		net.addBranch(bra2, "Bus1", "Bus3");
		
		AclfBranch bra3=CoreObjectFactory.createAclfBranch("Branch3", net);
		bra3.setFromBus(bus2);
		bra3.setToBus(bus3);
		bra3.setZ(new Complex(0,0.25));
		bra3.setRatingMva1(0.55);
		net.addBranch(bra3, "Bus2", "Bus3");
		
		return net;
		
		
	}

}
