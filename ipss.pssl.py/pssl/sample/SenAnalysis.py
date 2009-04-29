from java.util.logging                import Level;

from com.interpss.common.util         import IpssLogger;
from com.interpss.pssl.simu           import IpssAclf, IpssPTrading;
from com.interpss.pssl.plugin         import IpssAdapter;

from com.interpss.core.dclf           import SenAnalysisType;

dir(IpssAclf);

# set log level

IpssAclf.setLogLevel(Level.WARNING);

# load a data in IEEE common format and create an AclfNetwork object

aclfNet = IpssAdapter.importAclfNet("sampleData/ieee14.ieee")  \
			.setFormat(IpssAdapter.FileFormat.IEEECommonFormat)    \
			.load();

# create a DClfAlgorithm and perform sensitivity analysis for the injection
# and withdraw buses.			

dclfAlgo = IpssPTrading.createDclfAlgorithm(aclfNet)           \
			.setSenAnalysisType(SenAnalysisType.PANGLE)        \
			.setInjectionBusNo(2).withdrawBusNo(14)            \
			.runSenAnalysis();			
			
# output PTDF for the branch No2->No14			

print "Power Transfer Distribution Factor: ",                  \
      IpssPTrading.wrapAlgorithm(dclfAlgo)                     \
			.setInjectionBusNo(2).withdrawBusNo(14)            \
			.setBranchFromBusNo(4).toBusNo(7)                  \
			.getPowerTransferDistFactor();			