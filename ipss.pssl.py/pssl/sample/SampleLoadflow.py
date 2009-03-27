from com.interpss.pssl.simu              import IpssAclf;
from com.interpss.pssl.plugin            import IpssUtil;

from com.interpss.common.datatype        import UnitType;
from org.apache.commons.math.complex     import Complex;
from com.interpss.core.aclf              import AclfGenCode;
from com.interpss.core.aclf              import AclfLoadCode;
from com.interpss.core.aclf              import AclfBranchCode;
from com.interpss.core.algorithm         import AclfMethod;

aclfNet = IpssAclf.createAclfNetwork("Sample AclfNetwork")       \
            .setBaseKva(100000.0)                                \
            .getAclfNet(); 

IpssAclf.addAclfBus("Bus1", "name-Bus 1", aclfNet)               \
            .setBaseVoltage(4000.0)                              \
            .setGenCode(AclfGenCode.SWING)                       \
            .setVoltageSpec(1.0, UnitType.PU, 0.0, UnitType.Deg);
  		
IpssAclf.addAclfBus("Bus2", "name-Bus 2", aclfNet)               \
  			.setBaseVoltage(4000.0)                              \
  			.setLoadCode(AclfLoadCode.CONST_P)                   \
  			.setLoad(Complex(1.0, 0.8), UnitType.PU);
  		
IpssAclf.addAclfBranch("Bus1", "Bus2", aclfNet)                  \
			.setBranchCode(AclfBranchCode.LINE)                  \
			.setZ(Complex(0.05, 0.1), UnitType.PU);        
				
IpssAclf.createLoadflowAlgorithm(aclfNet)                        \
  			.setLfMethod(AclfMethod.NR)                          \
  			.setTolerance(0.0001, UnitType.PU)                   \
  			.runLoadflow();				

print IpssUtil.outputAclfNet(aclfNet)                    \
            .setFormat(IpssUtil.Format.LoadfloeSummary)  \
            .toString();

