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

import static com.interpss.common.util.IpssLogger.ipssLogger;

import javax.xml.bind.JAXBElement;

import org.ieee.odm.model.opf.OpfModelParser;
import org.ieee.odm.schema.ActivePowerLimitXmlType;
import org.ieee.odm.schema.ActivePowerUnitType;
import org.ieee.odm.schema.AnalysisCategoryEnumType;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BaseOpfNetworkXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.ConstraintsXmlType;
import org.ieee.odm.schema.CostModelEnumType;
import org.ieee.odm.schema.IncCostXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.NetworkCategoryEnumType;
import org.ieee.odm.schema.OpfDclfGenBusXmlType;
import org.ieee.odm.schema.OpfDclfNetworkXmlType;
import org.ieee.odm.schema.OpfGenBusXmlType;
import org.ieee.odm.schema.OpfGenOperatingModeEnumType;
import org.ieee.odm.schema.OpfNetworkEnumType;
import org.ieee.odm.schema.OpfNetworkXmlType;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.ieee.odm.schema.PieceWiseLinearModelXmlType;
import org.ieee.odm.schema.QuadraticModelXmlType;
import org.ieee.odm.schema.ReactivePowerLimitXmlType;
import org.ieee.odm.schema.StairStepXmlType;
import org.ieee.odm.schema.VoltageLimitXmlType;
import org.interpss.mapper.odm.ODMAclfNetMapper;
import org.interpss.mapper.odm.ODMHelper;
import org.interpss.mapper.odm.impl.aclf.AbstractODMAclfParserMapper;
import org.interpss.mapper.odm.impl.aclf.AclfBusDataHelper;
import org.interpss.numeric.datatype.LimitType;
import org.interpss.numeric.datatype.Point;

import com.interpss.OpfObjectFactory;
import com.interpss.common.exp.InterpssException;
import com.interpss.core.common.curve.CommonCurveFactory;
import com.interpss.core.common.curve.NumericCurveModel;
import com.interpss.core.common.curve.PieceWiseCurve;
import com.interpss.core.common.curve.QuadraticCurve;
import com.interpss.core.common.curve.impl.PieceWiseCurveImpl;
import com.interpss.opf.BaseOpfNetwork;
import com.interpss.opf.Constraint;
import com.interpss.opf.IncrementalCost;
import com.interpss.opf.OpfBranch;
import com.interpss.opf.OpfBus;
import com.interpss.opf.OpfFactory;
import com.interpss.opf.OpfGenBus;
import com.interpss.opf.OpfGenOperatingMode;
import com.interpss.opf.OpfNetwork;
import com.interpss.opf.dclf.DclfOpfBranch;
import com.interpss.opf.dclf.DclfOpfBus;
import com.interpss.opf.dclf.DclfOpfGenBus;
import com.interpss.opf.dclf.DclfOpfNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

/**
 * abstract mapper implementation to map ODM to InterPSS object model for Opf
 * 
 * @author mzhou
 *
 * @param <Tfrom>
 */
public abstract class AbstractODMOpfDataMapper <Tfrom> extends AbstractODMAclfParserMapper<Tfrom> {
	/**
	 * constructor
	 * 
	 */
	public AbstractODMOpfDataMapper() {
	}
	
	/**
	 * transfer info stored in the parser object into simuCtx object
	 * 
	 * @param p an ODM parser object, representing an ODM xml file
	 * @param simuCtx
	 * @return
	 */
	@Override public boolean map2Model(Tfrom p, SimuContext simuCtx) {
		boolean noError = true;
		
		OpfModelParser parser = (OpfModelParser) p;
		
		if (parser.getStudyCase().getNetworkCategory() == NetworkCategoryEnumType.TRANSMISSION
				&& parser.getStudyCase().getAnalysisCategory() == AnalysisCategoryEnumType.OPF) {
			BaseOpfNetworkXmlType xmlNet = parser.getOpfNet();
			simuCtx.setNetType(SimuCtxType.OPF_NET);
			try {
				BaseOpfNetwork opfNet = null;
				if (xmlNet.getOpfNetType() == OpfNetworkEnumType.SIMPLE_DCLF) 
					opfNet = mapDclfOpfNetData((OpfDclfNetworkXmlType)xmlNet);
				else 
					opfNet = mapOpfNetData((OpfNetworkXmlType)xmlNet);
				simuCtx.setOpfNet(opfNet);

				ODMAclfNetMapper aclfNetMapper = new ODMAclfNetMapper();
				for (JAXBElement<? extends BusXmlType> bus : xmlNet.getBusList().getBus()) {
					if (bus.getValue() instanceof OpfDclfGenBusXmlType) {
						if (xmlNet.getOpfNetType() == OpfNetworkEnumType.SIMPLE_DCLF) {
							OpfDclfGenBusXmlType opfDclfGen = (OpfDclfGenBusXmlType) bus.getValue();
							mapDclfOpfGenBusData(opfDclfGen, (DclfOpfNetwork)opfNet);
						}
						else {
							OpfGenBusXmlType opfGen = (OpfGenBusXmlType) bus.getValue();
							mapOpfGenBusData(opfGen, (OpfNetwork)opfNet);
						}
					} 
					else {
						LoadflowBusXmlType busRec = (LoadflowBusXmlType) bus.getValue();
						if (xmlNet.getOpfNetType() == OpfNetworkEnumType.SIMPLE_DCLF) {
							DclfOpfBus opfDclfBus = OpfObjectFactory.createDclfOpfBus(busRec.getId(), (DclfOpfNetwork)opfNet);
							aclfNetMapper.mapAclfBusData(busRec, opfDclfBus, opfNet);
						}
						else {
							OpfBus opfBus = OpfObjectFactory.createOpfBus(busRec.getId(), (OpfNetwork)opfNet);
							aclfNetMapper.mapAclfBusData(busRec, opfBus, opfNet);
						}
					}
				}

				for (JAXBElement<? extends BaseBranchXmlType> b : xmlNet.getBranchList().getBranch()) {
					if (xmlNet.getOpfNetType() == OpfNetworkEnumType.SIMPLE_DCLF) {
						DclfOpfBranch opfDclfBranch = OpfObjectFactory.createDclfOpfBranch();
						aclfNetMapper.mapAclfBranchData(b.getValue(), opfDclfBranch, (DclfOpfNetwork)opfNet);
					}
					else {
						OpfBranch opfBranch = OpfObjectFactory.createOpfBranch();
						aclfNetMapper.mapAclfBranchData(b.getValue(), opfBranch, (DclfOpfNetwork)opfNet);
					}
				}
			} catch (InterpssException e) {
				e.printStackTrace();
				ipssLogger.severe(e.toString());
				noError = false;
			}
		} 
		else {
			ipssLogger.severe( "Error: wrong Transmission NetworkType and/or ApplicationType");
			noError = false;
		}
		
		if (parser.getStudyCase().getContentInfo() != null) {
			OriginalDataFormatEnumType ofmt = parser.getStudyCase().getContentInfo().getOriginalDataFormat();
			simuCtx.getNetwork().setOriginalDataFormat(ODMHelper.map(ofmt));		
		} 
		else {
			ipssLogger.severe( "Error: StudyCase.ContentInfo were not entered");
			noError = false;
		}
		return noError;
	}
	
	/*
	 *    OPF model mapper
	 *    ================
	 */
	private OpfNetwork mapOpfNetData(OpfNetworkXmlType xmlNet) throws InterpssException {
		OpfNetwork opfNet = OpfObjectFactory.createOpfNetwork();
		new ODMAclfNetMapper().mapAclfNetworkData(opfNet, xmlNet);
		
		// mapping details
		opfNet.setAnglePenaltyFactor(xmlNet.getAnglePenaltyFactor());	
		
		return opfNet;
	}

	public OpfGenBus mapOpfGenBusData(OpfGenBusXmlType busRec, OpfNetwork net) throws InterpssException {
		OpfGenBus opfGenBus = OpfObjectFactory.createOpfGenBus(busRec.getId(), net);
		mapBaseBusData(busRec, opfGenBus, net);

		AclfBusDataHelper helper = new AclfBusDataHelper(net, opfGenBus);
		helper.setAclfBusData(busRec);
		

		OpfGenOperatingModeEnumType genMode = busRec.getOperatingMode();
		if (genMode.equals(OpfGenOperatingModeEnumType.PV_GENERATOR)){
			opfGenBus.setOperatingMode(OpfGenOperatingMode.PV_GENERATOR);
			
		}else if(genMode.equals(OpfGenOperatingModeEnumType.PUMPING)) {
			opfGenBus.setOperatingMode(OpfGenOperatingMode.PUMPING);
			
		}else if(genMode.equals(OpfGenOperatingModeEnumType.PQ_GENERATOR)) {
			opfGenBus.setOperatingMode(OpfGenOperatingMode.PQ_GENERATOR);
		}else {
			// synchronized condensor
			opfGenBus.setOperatingMode(OpfGenOperatingMode.SYCHRONOUS_COMPENSATOR);
		}
		
		// set gen incremental cost model
		IncCostXmlType incCostRec = busRec.getIncCost();
		CostModelEnumType costModelRec = incCostRec.getCostModel();
		IncrementalCost inc = OpfFactory.eINSTANCE.createIncrementalCost();
		if (costModelRec.equals(CostModelEnumType.PIECE_WISE_LINEAR_MODEL)){
			inc.setCostModel(NumericCurveModel.PIECE_WISE);
			if (busRec.getIncCost().getPieceWiseLinearModel()!=null){
				PieceWiseLinearModelXmlType pw = busRec.getIncCost().getPieceWiseLinearModel();
				PieceWiseCurve pwIpss = CommonCurveFactory.eINSTANCE.createPieceWiseCurve();
				for (StairStepXmlType stair : pw.getStairStep()){
					double price = stair.getPrice().getValue();
					double mw = stair.getAmount().getValue();
					Point costPoint = new Point();
					// point in format of: (mw, price)
					costPoint.x = mw;
					costPoint.y = price;		
					pwIpss.getPoints().add(costPoint);					
				}
				inc.setPieceWiseCurve(pwIpss);				
				
			}else{
				ipssLogger.severe("Can not find a piece-wise cost model for bus: "+ opfGenBus.getId());
			}

		}else {
			inc.setCostModel(NumericCurveModel.QUADRATIC);
			if (busRec.getIncCost().getQuadraticModel()!=null){
				QuadraticModelXmlType quaXml = busRec.getIncCost().getQuadraticModel();
				QuadraticCurve quaIpss = CommonCurveFactory.eINSTANCE.createQuadraticCurve();
				double sqrCoeff = quaXml.getSqrCoeff();
				double linCoeff = quaXml.getLinCoeff();
				double constCoeff = quaXml.getConstCoeff();
				// quadratic function in the form of: C = Ax^2+Bx+C;
				quaIpss.setA(sqrCoeff);
				quaIpss.setB(linCoeff);
				quaIpss.setC(constCoeff);				
				inc.setQuadraticCurve(quaIpss);
			}else{
				ipssLogger.severe("Can not find a quadratic cost model for bus: "+ opfGenBus.getId());
			}			
		}
		opfGenBus.setIncCost(inc);
		
		// set constraints
		ConstraintsXmlType ctrtXml = busRec.getConstraints();
		Constraint ctrtIpss = opfGenBus.getConstraints();
		double factor=net.getBaseKva()*0.001;
		if(ctrtXml.getActivePowerLimit()!=null){			
			ActivePowerLimitXmlType pLmt = ctrtXml.getActivePowerLimit();			
			double pmax = pLmt.getMax();
			double pmin = pLmt.getMin();
			String unit= pLmt.getUnit().toString();
			if(unit.equals("PU")){				
				ctrtIpss.setPLimit( new LimitType(pmax*factor, pmin*factor));
			}else { // mva
			    ctrtIpss.setPLimit( new LimitType(pmax, pmin));
			}			
		}else if(ctrtXml.getReactivePowerLimit()!=null){
			ReactivePowerLimitXmlType qLmt = ctrtXml.getReactivePowerLimit();
			double qmax = qLmt.getMax();
			double qmin = qLmt.getMin();
			String unit = qLmt.getUnit().toString();
			if(unit.equals("PU")){
				ctrtIpss.setQLimit(new LimitType(qmax*factor, qmin*factor));
			}else{
				ctrtIpss.setQLimit(new LimitType(qmax, qmin));
			}
			
		}else if(ctrtXml.getVolLimit()!=null){
			VoltageLimitXmlType vLmt = ctrtXml.getVolLimit();
			double vmax = vLmt.getMax();
			double vmin = vLmt.getMin();
			String unit = vLmt.getUnit().toString();
			if(unit.equals("PU")){
				ctrtIpss.setVLimit(new LimitType(vmax*factor, vmin*factor));
			}else {
				ctrtIpss.setVLimit(new LimitType(vmax, vmin));
			}
			
		}
		
		return opfGenBus;
	}
	
	/*
	 *    DCLF OPF model mapper
	 *    =====================
	 */
	
	private DclfOpfNetwork mapDclfOpfNetData(OpfDclfNetworkXmlType xmlNet) throws InterpssException {
		DclfOpfNetwork opfNet = OpfObjectFactory.createDclfOpfNetwork();
		new ODMAclfNetMapper().mapAclfNetworkData(opfNet, xmlNet);
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
	public DclfOpfGenBus mapDclfOpfGenBusData(OpfDclfGenBusXmlType busRec, DclfOpfNetwork net) throws InterpssException {
		DclfOpfGenBus opfGenBus = OpfObjectFactory.createDclfOpfGenBus(busRec.getId(), net);
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