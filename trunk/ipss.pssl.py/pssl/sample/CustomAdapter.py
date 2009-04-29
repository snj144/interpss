from com.interpss.pssl.simu           import IpssAclf;
from com.interpss.pssl.plugin         import IpssAdapter;
from com.interpss.pssl.plugin         import IpssUtil;

from com.interpss.common.datatype    import UnitType;
from com.interpss.core.algorithm     import AclfMethod;

aclfNet = IpssAdapter.importAclfNet("sampleData/ieee14.ieee")  \
			.setFormat(IpssAdapter.FileFormat.Custom)              \
			.setClassname("org.interpss.custom.exchange.FileAdapter_IeeeCommonFormat") \
			.load();
 				
IpssAclf.createLoadflowAlgorithm(aclfNet)           \
  			.setLfMethod(AclfMethod.NR)             \
  			.setTolerance(0.0001, UnitType.PU)      \
  			.runLoadflow(); 				
  			
print IpssUtil.outputAclfNet(aclfNet)                 \
            .setFormat(IpssUtil.Format.IEEEBusStype)  \
            .toString();

