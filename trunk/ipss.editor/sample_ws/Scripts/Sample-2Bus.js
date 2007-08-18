var loader = new Object();
function getObjectName() { return 'loader';}

// import InterPSS core library
var IpssLibImport = JavaImporter(
                      com.interpss.common.util,
                      com.interpss.core,
                      com.interpss.core.acsc,
                      com.interpss.common.datatype,
                      com.interpss.core.util.input,
                      com.interpss.simu);
with (IpssLibImport) {
   // all network data scripts have to implement the load method
   loader.load = function(simuCtx, msg) { 
      var acscNet = CoreObjectFactory.createSimpleFaultNetwork();
      acscNet.setId('ACSC 5-bus test system');
      acscNet.setBaseKva(100000.0);

      AcscInputUtilFunc.addScNonContributeBusTo(acscNet, '1', 'Bus-1', 13800, 1, 1);
      AcscInputUtilFunc.addScNonContributeBusTo(acscNet, '2', 'Bus-2', 13800, 1, 1);
      AcscInputUtilFunc.addScNonContributeBusTo(acscNet, '3', 'Bus-3', 13800, 1, 1);
      AcscInputUtilFunc.addScContributeBusTo(acscNet, '4', 'Bus-4', 13800, 1, 1, 0.0, .02, 0.0, .02, 0.0, .0e10, UnitType.PU, ScGroundType.GType_SolidGrounded, 0.0, 0.0, UnitType.PU);
      AcscInputUtilFunc.addScContributeBusTo(acscNet, '5', 'Bus-5', 13800, 1, 1, 0.0, .02, 0.0, .02, 0.0, .0e10, UnitType.PU, ScGroundType.GType_SolidGrounded, 0.0, 0.0, UnitType.PU);

      AcscInputUtilFunc.addAcscLineBranchTo(acscNet, '1', '2', 'Branch-1', 0.0, 0.25, 0.0, 0.7, UnitType.PU, msg);
      AcscInputUtilFunc.addAcscLineBranchTo(acscNet, '1', '3', 'Branch-2', 0.0, 0.35, 0.0, 0.1, UnitType.PU, msg);
      AcscInputUtilFunc.addAcscLineBranchTo(acscNet, '2', '3', 'Branch-3', 0.0, 0.3,  0.0, 0.75, UnitType.PU, msg);
      AcscInputUtilFunc.addAcscXformerBranchTo(acscNet, '4', '2', 'Branch-4', 0.0, 0.015, 0.0, 0.03, UnitType.PU, 
                           XfrConnectCode.WYE_UNGROUNDED, 0.0, 0.0, XfrConnectCode.DELTA, 0.0, 0.0, UnitType.Ohm, msg);
      AcscInputUtilFunc.addAcscXformerBranchTo(acscNet, '5', '3', 'Branch-5', 0.0, 0.03, 0.0, 0.03, UnitType.PU, 
                           XfrConnectCode.WYE_UNGROUNDED, 0.0, 0.0, XfrConnectCode.DELTA, 0.0, 0.0, UnitType.Ohm, msg);

      msg.sendStatusMsg('ACSC 5-bus test system loaded');

      // for debug, print the net object
      //msg.sendStatusMsg(net.net2String());

      // set the simuContext object
      simuCtx.setNetType(SimuCtxType.ACSC_FAULT_NET);
      simuCtx.setAcscFaultNet(acscNet);
      simuCtx.setName("Acsc 5-Bus Scripting Network");
      simuCtx.setDesc("An Acsc network created by scripting");
   }
}