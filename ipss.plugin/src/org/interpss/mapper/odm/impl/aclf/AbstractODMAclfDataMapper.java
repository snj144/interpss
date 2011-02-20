/*
 * @(#)AbstractODMAclfDataMapper.java   
 *
 * Copyright (C) 2008 www.interpss.org
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
 * @Date 02/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.mapper.odm.impl.aclf;

import javax.xml.bind.JAXBElement;

import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.NetworkCategoryEnumType;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.ieee.odm.schema.PSXfr3WBranchXmlType;
import org.ieee.odm.schema.PSXfrBranchXmlType;
import org.ieee.odm.schema.Xfr3WBranchXmlType;
import org.ieee.odm.schema.XfrBranchXmlType;
import org.interpss.mapper.odm.AbstractODMSimuCtxDataMapper;
import org.interpss.mapper.odm.ODMXmlHelper;

import com.interpss.common.exp.InterpssException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Branch;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

public abstract class AbstractODMAclfDataMapper<Tfrom> extends AbstractODMSimuCtxDataMapper<Tfrom> {
	public AbstractODMAclfDataMapper(IPSSMsgHub msg) {
		super(msg);
	}
	
	/**
	 * map into store in the ODM parser into simuCtx object
	 * 
	 * @param p ODM parser object, representing a ODM xml file
	 * @param simuCtx
	 */
	@Override
	public boolean map2Model(Tfrom p, SimuContext simuCtx) {
		boolean noError = true;
		AclfModelParser parser = (AclfModelParser)p;
		if (parser.getStudyCase().getNetworkCategory() == NetworkCategoryEnumType.TRANSMISSION ) {
			LoadflowNetXmlType xmlNet = parser.getAclfNet();
			simuCtx.setNetType(SimuCtxType.ACLF_NETWORK);
			try {
				AclfNetwork adjNet = CoreObjectFactory.createAclfNetwork();
				mapAclfNetworkData(adjNet, xmlNet);
				simuCtx.setAclfNet(adjNet);

				for (JAXBElement<? extends BusXmlType> bus : xmlNet.getBusList().getBus()) {
					LoadflowBusXmlType busRec = (LoadflowBusXmlType) bus.getValue();
					mapAclfBusData(busRec, adjNet);
				}

				for (JAXBElement<? extends BaseBranchXmlType> b : xmlNet.getBranchList().getBranch()) {
					BaseBranchXmlType xmlBranch = b.getValue();
					Branch branch = null;
					if (xmlBranch instanceof PSXfr3WBranchXmlType || xmlBranch instanceof Xfr3WBranchXmlType)
						branch = CoreObjectFactory.createAclf3WXformer();
					else
						branch = CoreObjectFactory.createAclfBranch();
					mapAclfBranchData(xmlBranch, branch, adjNet);
				}
			} catch (InterpssException e) {
				e.printStackTrace();
				IpssLogger.getLogger().severe(e.toString());
				noError = false;
			}
		} else {
			IpssLogger.getLogger().severe(
							"Error: currently only Transmission NetworkType has been implemented");
			return false;
		}
		
		OriginalDataFormatEnumType ofmt = parser.getStudyCase().getContentInfo().getOriginalDataFormat();
		simuCtx.getNetwork().setOriginalDataFormat(ODMXmlHelper.map(ofmt));		
		return noError;
	}

	/**
	 * Map the network info only
	 * 
	 * @param xmlNet
	 * @return
	 */
	public void mapAclfNetworkData(AclfNetwork net, LoadflowNetXmlType xmlNet) {
		mapNetworkData(net, xmlNet);
	}
	
	/**
	 * Map a bus record
	 * 
	 * @param busRec
	 * @param adjNet
	 * @return
	 * @throws Exception
	 */
	public AclfBus mapAclfBusData(LoadflowBusXmlType busRec, AclfNetwork adjNet) throws InterpssException {
		AclfBus aclfBus = CoreObjectFactory.createAclfBus(busRec.getId(), adjNet);
		//adjNet.addBus(aclfBus);
		mapBaseBusData(busRec, aclfBus, adjNet);

		AclfBusDataHelper helper = new AclfBusDataHelper(adjNet, aclfBus);
		helper.setAclfBusData(busRec);
		
		return aclfBus;
	}
	
	/**
	 * 
	 * @param xmlBranch
	 * @param adjNet
	 * @param msg
	 * @throws Exception
	 */
	public void mapAclfBranchData(BaseBranchXmlType xmlBranch, Branch branch, AclfNetwork adjNet) throws InterpssException {
		setAclfBranchData((BranchXmlType)xmlBranch, branch, adjNet);
		AclfBranchDataHelper helper = new AclfBranchDataHelper(adjNet, branch);
		if (xmlBranch instanceof LineBranchXmlType) {
			LineBranchXmlType branchRec = (LineBranchXmlType) xmlBranch;
			helper.setLineBranchData(branchRec);
		}
		else if (xmlBranch instanceof PSXfr3WBranchXmlType) {
			PSXfr3WBranchXmlType branchRec = (PSXfr3WBranchXmlType) xmlBranch;
			helper.setPsXfr3WBranchData(branchRec);
		}		
		else if (xmlBranch instanceof Xfr3WBranchXmlType) {
			Xfr3WBranchXmlType branchRec = (Xfr3WBranchXmlType) xmlBranch;
			helper.setXfr3WBranchData(branchRec);
		}
		else if (xmlBranch instanceof PSXfrBranchXmlType) {
			PSXfrBranchXmlType branchRec = (PSXfrBranchXmlType) xmlBranch;
			helper.setPsXfrBranchData(branchRec);
		}		
		else if (xmlBranch instanceof XfrBranchXmlType) {
			XfrBranchXmlType branchRec = (XfrBranchXmlType) xmlBranch;
			helper.setXfrBranchData(branchRec);
		}
	}
	
	private void setAclfBranchData(BranchXmlType branchRec, Branch branch, AclfNetwork adjNet) throws InterpssException {
		mapBaseBranchRec(branchRec, branch, adjNet);		
		if (branch instanceof AclfBranch) {
			AclfBranch aclfBranch = (AclfBranch)branch;
			if (branchRec.getRatingLimit() != null && branchRec.getRatingLimit().getMva() != null) {
				double factor = 1.0;
				if (branchRec.getRatingLimit().getMva().getUnit() == ApparentPowerUnitType.PU)
					factor = adjNet.getBaseKva() * 0.001;
				else if (branchRec.getRatingLimit().getMva().getUnit() == ApparentPowerUnitType.KVA)
					factor = 0.001;
				aclfBranch.setRatingMva1(branchRec.getRatingLimit().getMva().getRating1() * factor);
				if (branchRec.getRatingLimit().getMva().getRating2() != null)
					aclfBranch.setRatingMva2(branchRec.getRatingLimit().getMva().getRating2() * factor);
				if (branchRec.getRatingLimit().getMva().getRating3() != null)
					aclfBranch.setRatingMva3(branchRec.getRatingLimit().getMva().getRating3() * factor);
				//if (branchRec.getRatingLimit().getMva().getRating4())
				//	aclfBranch.setRatingMva4(branchRec.getRatingLimit().getMva().getRating3() * factor);
			}
		}
	}
}