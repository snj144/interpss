package org.ieee.odm.model.acsc;

import org.ieee.odm.model.BaseJaxbHelper;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.schema.NetworkXmlType;
import org.ieee.odm.schema.ShortCircuitNetXmlType;

/**
 * A Xml parser for the IEEE DOM schema. 
 */

public class AcscModelParser extends AclfModelParser {	

	/**
	 * Default Constructor 
	 * 
	 */
	public AcscModelParser() {
		super();
	}	
	
	/**
	 * get the base case object of type DStabNetXmlType
	 * 
	 * @return
	 */
	public ShortCircuitNetXmlType getAcscNet() {
		return (ShortCircuitNetXmlType)getBaseCase();
	}
	
	/**
	 * create the base case object of type ShortCircuitNetXmlType
	 */
	@Override
	public NetworkXmlType createBaseCase() {
		if (getStudyCase().getBaseCase() == null) {
			ShortCircuitNetXmlType baseCase = this.getFactory().createShortCircuitNetXmlType();
			baseCase.setBusList(this.getFactory().createNetworkXmlTypeBusList());
			baseCase.setBranchList(this.getFactory().createNetworkXmlTypeBranchList());
			getStudyCase().setBaseCase(BaseJaxbHelper.network(baseCase));
		}
		return getStudyCase().getBaseCase().getValue();
	}
}
