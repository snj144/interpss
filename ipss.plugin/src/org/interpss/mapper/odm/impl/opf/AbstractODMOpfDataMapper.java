/*
 * @(#)AbstractODMOpfDataMapper.java   
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

package org.interpss.mapper.odm.impl.opf;

import javax.xml.bind.JAXBElement;

import org.ieee.odm.model.opf.OpfModelParser;
import org.ieee.odm.schema.AnalysisCategoryEnumType;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.NetworkCategoryEnumType;
import org.ieee.odm.schema.OpfGenBusXmlType;
import org.ieee.odm.schema.OpfNetworkXmlType;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.interpss.mapper.odm.ODMXmlHelper;
import org.interpss.mapper.odm.impl.aclf.AbstractODMAclfDataMapper;
import org.interpss.mapper.odm.impl.aclf.AclfBusDataHelper;
import org.interpss.numeric.datatype.LimitType;

import com.interpss.common.exp.InterpssException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.opf.OpfGenBus;
import com.interpss.opf.OpfNetwork;
import com.interpss.opf.OpfObjectFactory;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;


public abstract class AbstractODMOpfDataMapper <Tfrom> extends AbstractODMAclfDataMapper<Tfrom> {
	public AbstractODMOpfDataMapper(IPSSMsgHub msg) {
		super(msg);
	}
	
	/**
	 * transfer info stored in the parser object into simuCtx object
	 * 
	 * @param p an ODM parser object, representing an ODM xml file
	 * @param simuCtx
	 * @return
	 */
	@Override
	public boolean map2Model(Tfrom p, SimuContext simuCtx) {
		boolean noError = true;
		
		OpfModelParser parser = (OpfModelParser) p;
		
		if (parser.getOpfNet().getNetworkCategory() == NetworkCategoryEnumType.TRANSMISSION
				&& parser.getAclfNet().getAnalysisCategory() == AnalysisCategoryEnumType.OPF) {
			OpfNetworkXmlType xmlNet = parser.getOpfNet();
			simuCtx.setNetType(SimuCtxType.OPF_NET);
			try {
				OpfNetwork opfNet = mapNetworkData(xmlNet);
				simuCtx.setOpfNet(opfNet);

				for (JAXBElement<? extends BusXmlType> bus : xmlNet.getBusList().getBus()) {
					if (bus.getValue() instanceof OpfGenBusXmlType) {
						OpfGenBusXmlType busRec = (OpfGenBusXmlType) bus.getValue();
						mapGenBusData(busRec, opfNet);
					} 
					else {
						LoadflowBusXmlType busRec = (LoadflowBusXmlType) bus.getValue();
						mapAclfBusData(busRec, opfNet);
					}
				}

				for (JAXBElement<? extends BaseBranchXmlType> b : xmlNet.getBranchList().getBranch()) {
					AclfBranch aclfBranch = CoreObjectFactory.createAclfBranch();
					mapAclfBranchData(b.getValue(), aclfBranch, opfNet);
				}
			} catch (InterpssException e) {
				e.printStackTrace();
				IpssLogger.getLogger().severe(e.toString());
				noError = false;
			}
		} 
		else {
			IpssLogger.getLogger().severe( "Error: wrong Transmission NetworkType and/or ApplicationType");
			noError = false;
		}
		
		if (parser.getStudyCase().getContentInfo() != null) {
			OriginalDataFormatEnumType ofmt = parser.getStudyCase().getContentInfo().getOriginalDataFormat();
			simuCtx.getNetwork().setOriginalDataFormat(ODMXmlHelper.map(ofmt));		
		} 
		else {
			IpssLogger.getLogger().severe( "Error: StudyCase.ContentInfo were not entered");
			noError = false;
		}
		return noError;
	}
	
	private OpfNetwork mapNetworkData(OpfNetworkXmlType xmlNet) throws InterpssException {
		OpfNetwork opfNet = OpfObjectFactory.createOpfNetwork();
		mapAclfNetworkData(opfNet, xmlNet);
		opfNet.setAnglePenaltyFactor(xmlNet.getAnglePenaltyFactor());	
		return opfNet;
	}

	/**
	 * Map a bus record
	 * 
	 * @param busRec
	 * @param adjNet
	 * @return
	 * @throws Exception
	 */
	public OpfGenBus mapGenBusData(OpfGenBusXmlType busRec, OpfNetwork net) throws InterpssException {
		OpfGenBus opfGenBus = OpfObjectFactory.createOpfGenBus(busRec.getId());
		net.addBus(opfGenBus);
		mapBaseBusData(busRec, opfGenBus, net);

		AclfBusDataHelper helper = new AclfBusDataHelper(net, opfGenBus);
		helper.setAclfBusData(busRec);
		
		/*
    		<pss:coeffA>37.8896</pss:coeffA>
    		<pss:coeffB>0.01433</pss:coeffB>
    		<pss:capacityLimit max="0.2" min="0.05" unit="PU"></pss:capacityLimit>
    		<pss:fixedCost>118.821</pss:fixedCost>  
    	*/
		opfGenBus.setCoeffA(busRec.getCoeffA());
		opfGenBus.setCoeffB(busRec.getCoeffB());
		opfGenBus.setFixedCost(busRec.getFixedCost());
		String unit=busRec.getCapacityLimit().getUnit().value();
		if(unit.equalsIgnoreCase("PU")) {// model mappering consistence, all are converted to MVA unit;
			double factor=net.getBaseKva()*0.001;
		    opfGenBus.setCapacityLimit(new LimitType(busRec.getCapacityLimit().getMax()*factor, 
				              busRec.getCapacityLimit().getMin()*factor));
		}
		else {   //the default unit is MVA
			opfGenBus.setCapacityLimit(new LimitType(busRec.getCapacityLimit().getMax(), busRec.getCapacityLimit().getMin()));
		}
		return opfGenBus;
	}
}