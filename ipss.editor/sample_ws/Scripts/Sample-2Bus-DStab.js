/*
	This sample uses JavaScript to programmically build a 3-Bus
        Transient Stability simulation.
*/

var loader = new Object();
function getObjectName() { return 'loader';}

// import InterPSS core library
var IpssLibImport = JavaImporter(
            com.interpss.core,
            com.interpss.common.datatype,
            com.interpss.core.aclf,
            com.interpss.dstab,
            com.interpss.dstab.mach,
            org.interpss.dstab.control.exc.simple,
            com.interpss.simu,
            org.apache.commons.math.complex);

with (IpssLibImport) {
   // all network data scripts have to implement the load method
   loader.load = function(simuCtx, msg) { 
	// Create a DStabNetwork object 
	var net = DStabObjectFactory.createDStabilityNetwork();
	net.setAllowParallelBranch(true);

	// Create area and zone objects
	var area = CoreObjectFactory.createArea(1, net);
	var zone = CoreObjectFactory.createZone(1, net);
		
	var bus1 = DStabObjectFactory.createDStabBus('LT', net);
	bus1.setName('LT Bus');
	bus1.setArea(area);
	bus1.setZone(zone);
	bus1.setBaseVoltage(24000.0);
	bus1.setGenCode(AclfGenCode.GEN_PQ);
	var pqBus = bus1.adapt('PQBusAdapter');
	pqBus.setGen(new Complex(22.2*0.9, 22.2*0.436), UnitType.PU, net.getBaseKva());
	bus1.setLoadCode(AclfLoadCode.NON_LOAD);
		
	var bus2 = DStabObjectFactory.createDStabBus('HT', net);
	bus2.setName('HT Bus');
	bus2.setArea(area);
	bus2.setZone(zone);
	bus2.setBaseVoltage(500000.0);
	bus2.setGenCode(AclfGenCode.CAPACITOR);
	var capBus = bus2.adapt('CapacitorBusAdapter');
	capBus.setQ(4.0, UnitType.PU, net.getBaseKva());
	bus2.setLoadCode(AclfLoadCode.CONST_P);
	var loadBus = bus2.adapt('LoadBusAdapter');
	loadBus.setLoad(new Complex(10.0, 8.0), UnitType.PU, net.getBaseKva());
        
	var bus3 = DStabObjectFactory.createDStabBus('InfBus', net);
	bus3.setName('Inititive Bus');
	bus3.setArea(area);
	bus3.setZone(zone);
	bus3.setBaseVoltage(500000.0);
	bus3.setGenCode(AclfGenCode.SWING);
	var swing = bus3.adapt('SwingBusAdapter');
	swing.setVoltMag(0.90081, UnitType.PU);
	swing.setVoltAng(0.0, UnitType.Deg);
	bus3.setLoadCode(AclfLoadCode.NON_LOAD);

	var branch1 = DStabObjectFactory.createDStabBranch('LT', 'HT', net);
	branch1.setName('Branch1');
	branch1.setArea(area);
	branch1.setZone(zone);
	branch1.setBranchCode(AclfBranchCode.XFORMER);
	var xfr = branch1.adapt('XfrAdapter');	
	xfr.setZ(new Complex(0.0, 0.15/22.2), UnitType.PU, 1.0, 1.0, msg);  
			// when z unit = PU, base volt and base Kva are not needed
		
	var branch2 = DStabObjectFactory.createDStabBranch('HT', 'InfBus', net);
	branch2.setName('Branch2');
	branch2.setArea(area);
	branch2.setZone(zone);
	branch2.setBranchCode(AclfBranchCode.LINE);
	var line2 = branch2.adapt('LineAdapter');
	line2.setZ(new Complex(0.0, 0.5/22.2), UnitType.PU, 1.0, 1.0, msg);

	var branch3 = DStabObjectFactory.createDStabBranch('HT', 'InfBus', net);
	branch3.setName('Branch1');
	branch3.setArea(area);
	branch3.setZone(zone);
	branch3.setBranchCode(AclfBranchCode.LINE);
	var line3 = branch3.adapt('LineAdapter');			
	line3.setZ(new Complex(0.0, 0.93/22.2), UnitType.PU, 1.0, 1.0, msg);

	// create and define the first machine object
        // machine id should follow 'Mach@BusId' convertion.
	var mach1 = DStabObjectFactory.createMachine('Mach@LT', 'Mach1', MachineType.EQ1_MODEL, net, 'LT');

	// set gen data
	mach1.setRating(2220, 'Mva', net.getBaseKva());
	mach1.setRatedVoltage(24000.0);
	mach1.setMultiFactors(bus1);
	mach1.setH(3.5);
	mach1.setPoles(2);
	mach1.setXd(1.81);
	mach1.setXq(1.76);
	mach1.setXl(0.14);
	mach1.setRa(0.0);
	mach1.setXd1(0.30);
	mach1.setTd01(8.0);
	mach1.setSliner(2.0);  // no saturation
	mach1.setS100(1.0);
	mach1.setS120(1.0);
		
        // add exciter
	var exc1 = new SimpleExciter('LT', 'Exc1', 'InterPSS');
	exc1.getData().setKa(50.0);
	exc1.getData().setTa(0.05);
	exc1.getData().setVrmax(10.0);
	exc1.getData().setVrmin(0.0);
	mach1.addExciter(exc1);

	// create and define a machine object on Gen2
	var mach2 = DStabObjectFactory.createInfiniteMachine('Mach@InfBus', 'Mach2', net, 'InfBus');

        // set the simuContext object
        simuCtx.setNetType(SimuCtxType.DSTABILITY_NET);
        simuCtx.setDStabilityNet(net);
        simuCtx.setName("DStab 2-Bus Scripting Network");
        simuCtx.setDesc("An DStab network created by scripting");
   }
}