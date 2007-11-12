package org.interpss.core.adapter;

import java.io.File;

import org.apache.xmlbeans.XmlException;
import org.interpss.mapper.runCase.Xml2AlgorithmMapperImpl;
import org.interpss.schema.InterPSSDocument;
import org.interpss.schema.InterPSSType;
import org.interpss.schema.RunAclfStudyCaseType;
import org.interpss.schema.UnitDataType;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.mapper.AbstractMapper;
import com.interpss.core.algorithm.LoadflowAlgorithm;

public class IpssXmlAdapter  extends AbstractMapper {
	private InterPSSType ipss = null;
	
	public IpssXmlAdapter(File xmlFile) throws Exception {
		InterPSSDocument ipssDoc = InterPSSDocument.Factory.parse(xmlFile);	
		this.ipss = ipssDoc.getInterPSS();		
	}
	
	public IpssXmlAdapter(String xmlString) throws XmlException {
		InterPSSDocument ipssDoc = InterPSSDocument.Factory.parse(xmlString);	
		this.ipss = ipssDoc.getInterPSS();		
	}

	public InterPSSType getRootElem() {
		return ipss;		
	}
	
	public RunAclfStudyCaseType[] getRunAclfStudyCaseList() {
		return ipss.getRunStudyCase().getRunAclfStudyCaseArray();		
	}
	
	public boolean mapping(Object fromObj, Object toObj, Class<?> klass) {
		if (klass == RunAclfStudyCaseType.class) {
		  	return Xml2AlgorithmMapperImpl.aclfCaseData2AlgoMapping(
		  			(RunAclfStudyCaseType)fromObj, (LoadflowAlgorithm)toObj);
		}
		return false;
	}
	
	
	public static byte mapXmlUnitType2IpssUnitType(UnitDataType.Enum type) {
		if (type == UnitDataType.PU)
			return UnitType.PU;
		else if (type == UnitDataType.PERCENT)
			return UnitType.Percent;
		else if (type == UnitDataType.KW)
			return UnitType.kW;
		else if (type == UnitDataType.K_VAR)
			return UnitType.kVar;
		else if (type == UnitDataType.KVA)
			return UnitType.kVA;
		else if (type == UnitDataType.MVA)
			return UnitType.mVA;
		else if (type == UnitDataType.MW)
			return UnitType.mW;
		else if (type == UnitDataType.M_VAR)
			return UnitType.mVar;
		return UnitType.NotDefined;
	}
}
