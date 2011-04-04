 /*
  * @(#)Data2ODMXml.java   
  *
  * Copyright (C) 2008-2011 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 04/01/2011
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.odm.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.ieee.odm.model.aclf.AclfModelComparator;
import org.ieee.odm.model.base.BaseJaxbHelper;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.StudyCaseXmlType;

/**
 * Compare a ODM model with the base ODM model
 * 
 * @author mzhou
 *
 */
public class ModelComparator {
	private StudyCaseXmlType baseStudyCase = null;
	
	public ModelComparator(StudyCaseXmlType scase) {
		this.baseStudyCase = scase;
	}
	
	/**
	 * compare the scase with the baseStudyCase and return a list of messages for the difference
	 * 
	 * @param scase
	 * @param busComp
	 * @param braComp
	 * @return
	 */
	public List<String> compareLoadflowModel(StudyCaseXmlType scase, 
				Comparator<BusXmlType> busComp, Comparator<BranchXmlType> braComp ) {
		List<String> strList = new ArrayList<String>();
		
		LoadflowNetXmlType baseNet = (LoadflowNetXmlType)this.baseStudyCase.getBaseCase().getValue();
		LoadflowNetXmlType net = (LoadflowNetXmlType)scase.getBaseCase().getValue();

		// compare number of net info
		if (baseNet.getBasePower().getValue() != net.getBasePower().getValue())
			strList.add("\nBaseMVA error: " + baseNet.getBasePower().getValue() + "(base), " +
					net.getBasePower().getValue());
		
		// compare number of bus info
		if (baseNet.getBusList().getBus().size() != net.getBusList().getBus().size())
			strList.add("\n# of Bus error: " + baseNet.getBusList().getBus().size() + "(base), " +
					net.getBusList().getBus().size());
		
		for (JAXBElement<? extends BusXmlType> b : baseNet.getBusList().getBus()) {
			BusXmlType psseBus = b.getValue();
			BusXmlType bpaBus = BaseJaxbHelper.getBus(net, psseBus, busComp);
			if (bpaBus == null)
				strList.add("\nBus not found: " + psseBus.getId() + ", " + psseBus.getName() + "(base)");
			else 
				AclfModelComparator.compare((LoadflowBusXmlType)psseBus, (LoadflowBusXmlType)bpaBus, strList);
		}
		
		// compare number of branch info
		if (baseNet.getBranchList().getBranch().size() != net.getBranchList().getBranch().size())
			strList.add("\n# of Branch error: " + baseNet.getBranchList().getBranch().size() + "(base), " +
					net.getBranchList().getBranch().size());
		
		for (JAXBElement<? extends BaseBranchXmlType> b : baseNet.getBranchList().getBranch()) {
			BranchXmlType psseBra = (BranchXmlType)b.getValue();
			BranchXmlType bpaBra = BaseJaxbHelper.getBranch(net, psseBra, braComp);
			if (bpaBra == null)
				strList.add("\nBranch not found: " + psseBra.getId() + "(base)");
			else
				AclfModelComparator.compare(psseBra, bpaBra, strList);
		}
		return strList;
	}
}
