/*
 * @(#)PSSEAdapter.java   
 *
 * Copyright (C) 2006-2008 www.interpss.org
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
 * @Author Stephen Hau, Mike Zhou
 * @Version 1.0
 * @Date 02/11/2008
 * 
 *   Revision History
 *   ================
 *
 */
package org.ieee.pes.odm.pss.adapter.psse;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AdjustmentDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PhaseShiftXfrDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StudyCaseXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransformerDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZXmlType;
import org.ieee.pes.odm.pss.adapter.AbstractODMAdapter;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;

public class PSSEAdapter extends AbstractODMAdapter{
	public final static String Token_CaseDesc = "Case Description";     
	public final static String Token_CaseId = "Case ID";				

	private static final String Token_Id = "No";
	
	public PSSEAdapter(Logger logger) {
		super(logger);
	}
	protected IEEEODMPSSModelParser parseInputFile(
			final java.io.BufferedReader din) throws Exception {
		IEEEODMPSSModelParser parser = new IEEEODMPSSModelParser();
		parser.getStudyCase().setSchemaVersion(
				StudyCaseXmlType.SchemaVersion.V_1_00_DEV);
		parser.getStudyCase().setOriginalFormat(
				StudyCaseXmlType.OriginalFormat.PSS_E);
		parser.getStudyCase().setAdapterProviderName("www.interpss.org");
		parser.getStudyCase().setAdapterProviderVersion("1.00");

		parser.getStudyCase().setAnalysisCategory(
				StudyCaseXmlType.AnalysisCategory.LOADFLOW);
		parser.getStudyCase().setNetworkCategory(
				StudyCaseXmlType.NetworkCategory.TRANSMISSION);

		PSSNetworkXmlType baseCaseNet = parser.getBaseCase();
		// no space is allowed for ID field
		baseCaseNet.setId("Base_Case_from_PSS_E_format");

		//read header info
		int i=0; 
		String sAry[]= new String[5];
		do {			
			String str = din.readLine();
			sAry[++i]= str;				
		} while (i<3);
		processHeaderData(sAry[1],sAry[2],sAry[3],baseCaseNet);	

        String str ;         
        int j=1, type=1,  n=0;
        do{
        	str = din.readLine();
        	if (str != null){
        		try {	         	 
        			if (str.startsWith("0")){
        				type =++j;
        			}else {
        				if (type==1){
        					processBusData(str, parser.addNewBaseCaseBus());
        				}
        				else if(type==2){
        					processLoadData(str,baseCaseNet);
        				}
        				else if(type==3){
        					processGenData(str, baseCaseNet);        			 
        				}
        				else if(type==4){
        					processLineData(str, parser.addNewBaseCaseBranch()); 
        				}
        				else if(type==5){        			   
        					do{         			    	 
        						sAry[++n]=str;
        						if (n<4)
        							str=din.readLine();
        					}while (n<4);
        					n=0;
        					processXformerData(sAry[1],sAry[2],sAry[3],sAry[4],
        			    		 parser.addNewBaseCaseBranch(),baseCaseNet);
        			   
        				} else if(type==6){
        					processAreaInterchangeData(str,baseCaseNet); 
        				}else if(type==13){
        					processZoneData(str,baseCaseNet); 
        				}else if(type==14){
        					processInterAreaTransferData(str,baseCaseNet); 
        				}else if(type==15){
        					processOwnerData(str,baseCaseNet); 
        				}
        			}
        		}catch (final Exception e){
					this.logErr(e.toString());
        		}
             }
        }	while (str != null);
                 
   	   return parser;
	}
	
	
	private  boolean processHeaderData(final String str,final String str2,final String str3,
			final PSSNetworkXmlType baseCaseNet) throws Exception {
		// parse the input data line
		//line 1 at here we have "0, 100.00 "		
		/*
		 * String[0] indicator
		 * String[1] baseKav
		 * String[2] comments
		 * String[3] comments
		 */
		final String[] strAry = getHeaderDataFields(str,str2,str3);
		if (strAry == null)
			return false;
		
		final double baseMva = new Double(strAry[1]).doubleValue();
	    getLogger().fine("BaseKva: "  + baseMva);
	    baseCaseNet.setBasePower(baseMva);
		baseCaseNet.setBasePowerUnit(PSSNetworkXmlType.BasePowerUnit.MVA);	
		
		NameValuePairListXmlType nvList = baseCaseNet.addNewNvPairList();
		
		final String desc = strAry[2];// The 2nd line is treated as description
		ODMData2XmlHelper.addNVPair(nvList, Token_CaseDesc, desc);     
	   
	    // the 3rd line is treated as the network id and network name		
		final String caseId= strAry[3];
		ODMData2XmlHelper.addNVPair(nvList, Token_CaseId, caseId);				
		getLogger().fine("Case Description, caseId: " + desc + ", "+ caseId);		
		
        return true;
	}
        
	
	private void processBusData(final String str,final BusRecordXmlType busRec)throws Exception {
		// parse the input data line
		final String[] strAry = getBusDataFields(str);	    
		//Format: I, NAME BASKV, IDE, GL, BL, AREA, ZONE, VM, VA, OWNER
		final String busId = Token_Id+strAry[0];
			// XML requires id start with a char
		getLogger().fine("Bus data loaded, id: " + busId);
		busRec.setId(busId);	
		
		final String busName = strAry[1];
		busRec.setName(busName);
		double baseKv = new Double(strAry[2]).doubleValue();
		if (baseKv == 0.0) {
			this.logErr("Error: base kv = 0.0");
			baseKv = 1.0;
		}
		
		final String owner=strAry[10];
		ODMData2XmlHelper.addOwner(busRec, owner, 1.0);
		
		ODMData2XmlHelper.setVoltageData(busRec.addNewBaseVoltage(), baseKv, VoltageXmlType.Unit.KV);

		LoadflowBusDataXmlType busData = busRec.addNewLoadflowBusData();
	
		// bus type identifier IDE
		final int IDE = new Integer(strAry[3]).intValue();
		if (IDE ==3){//Swing bus
			busData.addNewGenData().setCode(LoadflowBusDataXmlType.GenData.Code.SWING);
		}
		else if (IDE==2){// PV bus
			busData.addNewGenData().setCode(LoadflowBusDataXmlType.GenData.Code.PV);
		}else if (IDE==1){//Non-Gen Load Bus
			busData.addNewLoadData().setCode(LoadflowBusDataXmlType.LoadData.Code.CONST_P);

		}else // Isolated bus
		     {throw new Exception("bus"+busId+"is an isolated bus ");
		}
		
		//GL BL
		final double gPU = new Double(strAry[4]).doubleValue();
		final double bPU = new Double(strAry[5]).doubleValue();
		if (gPU != 0.0 || bPU != 0.0) {
			ODMData2XmlHelper.setYData(busData.addNewShuntY(), gPU, bPU,
					YXmlType.Unit.PU);
		}
		//area zone	
		final int areaNo = new Integer(strAry[6]).intValue();
		final int zoneNo = new Integer(strAry[7]).intValue();
		busRec.setArea(areaNo);
		busRec.setZone(zoneNo);		

		// vm voltage, p.u. [F] *
		//va angle, degrees [F] *
		final double vpu = new Double(strAry[8]).doubleValue();
		final double angDeg = new Double(strAry[9]).doubleValue();
		ODMData2XmlHelper.setVoltageData(busData.addNewVoltage(), vpu,
				VoltageXmlType.Unit.PU);

		ODMData2XmlHelper.setAngleData(busData.addNewAngle(), angDeg,
				AngleXmlType.Unit.DEG);				
	}
			
		
	private  void processLoadData(final String str,final PSSNetworkXmlType baseCaseNet) {
		// I, ID, STATUS, AREA, ZONE, PL, QL, IP, IQ, YP, YQ, OWNER
		final String[] strAry = getLoadDataFields(str);

	    final String busId = Token_Id+strAry[0];
	    //to test if there is a responding bus in the bus data record
		BusRecordXmlType busRec = ODMData2XmlHelper.getBusRecord(busId, baseCaseNet);
	    if (busRec == null){
	    	this.logErr("Bus"+ busId+ "is not found in the network");
	    	return;
	    }

	    LoadflowBusDataXmlType lfData = busRec.getLoadflowBusData();
	    if (lfData.getLoadData() == null) {  // there may be multiple load records on a bus
	    	lfData.addNewLoadData();
	    	lfData.getLoadData().setCode(LoadflowBusDataXmlType.LoadData.Code.FUNCTION_LOAD);
	    	lfData.getLoadData().addNewFuncLoadList();
	    }
	    
	    LoadflowBusDataXmlType.LoadData.FuncLoadList.FuncLoad funcLoad = lfData.getLoadData().getFuncLoadList().addNewFuncLoad(); 
	    //loadId is used to distinguish multiple loads at one bus
	    final String loadId =strAry[1];
		funcLoad.setId(loadId);
		
		//set owner and it's factor
		final String owner =strAry[11];
		ODMData2XmlHelper.addOwner(funcLoad, owner, 1.0);
		    
	    //Constant-P load
		final double CPloadMw = new Double(strAry[5]).doubleValue();
		final double CQloadMvar = new Double(strAry[6]).doubleValue();
		//Constant-I load
		final double CIloadMw = new Double(strAry[7]).doubleValue();
		final double CIloadMvar = new Double(strAry[8]).doubleValue();
		//Constant-Y load
		final double CYloadMw = new Double(strAry[9]).doubleValue();
		final double CYloadMvar = new Double(strAry[10]).doubleValue();

		if (CPloadMw!=0.0 || CQloadMvar!=0.0 )
	    	ODMData2XmlHelper.setPowerData(funcLoad.addNewConstPLoad(),
	    			CPloadMw, CQloadMvar, PowerXmlType.Unit.MVA);

	    if (CIloadMw!=0.0 || CIloadMvar!=0.0)
	    	ODMData2XmlHelper.setPowerData(funcLoad.addNewConstILoad(),
	    			CIloadMw, CIloadMvar, PowerXmlType.Unit.MVA);
	   
	    if (CYloadMw!=0.0 || CYloadMvar!=0.0)
	    	ODMData2XmlHelper.setPowerData(funcLoad.addNewConstZLoad(),
	    			CYloadMw, CYloadMvar, PowerXmlType.Unit.MVA);
	}
	
	private  void processGenData(final String str,final PSSNetworkXmlType baseCaseNet) {
		
		//I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4
		
		// parse the input data line
	    final String[] strAry = getGenDataFields(str);
		final String busId = Token_Id+strAry[0];
		// get the responding-bus data with busId
		BusRecordXmlType busRec = ODMData2XmlHelper.getBusRecord(busId, baseCaseNet);
		if (busRec==null){
        	this.logErr("Error: Bus not found in the network, bus number: " + busId);
        	return;
        }
				
	    if (busRec.getLoadflowBusData().getGenData().getContributeGenList() == null) {  // there may be multiple constribute gen records on a bus
	    	busRec.getLoadflowBusData().getGenData().addNewContributeGenList();
	    }
	    
	    LoadflowBusDataXmlType.GenData genData = busRec.getLoadflowBusData().getGenData(); 
	    LoadflowBusDataXmlType.GenData.ContributeGenList.ContributeGen contriGen = 
	    		genData.getContributeGenList().addNewContributeGen();
		
		// genId is used to distinguish multiple generations at one bus		
		final String genId = strAry[1];
		contriGen.setId(genId);
		
		final double genMw = new Double(strAry[2]).doubleValue();
		final double genMvar = new Double(strAry[3]).doubleValue();
		ODMData2XmlHelper.setPowerData(contriGen.getGen().getPower(), genMw, genMvar, PowerXmlType.Unit.MVA);
		
		// Desired volts (pu) (This is desired remote voltage if this bus is controlling another bus.)
		// Maximum MVAR  
		// Minimum MVAR  
      	final double vSpecPu = new Double(strAry[6]).doubleValue();
		final double max = new Double(strAry[4]).doubleValue();
		final double min = new Double(strAry[5]).doubleValue();
		
		//Remote controlled bus number
		final String reBusId = Token_Id+strAry[7];
		
		if (max != 0.0 || min != 0.0) {
			if ( genData.getCode() == LoadflowBusDataXmlType.GenData.Code.PQ) {
				/*
				contriGen.addNewVGenLimit();
				ODMData2XmlHelper.setLimitData(contriGen.getVGenLimit()
						.addNewVLimit(), max, min);
				contriGen.getVGenLimit().setVLimitUnit(
						LoadflowBusDataXmlType.GenData.ContributeGenList.ContributeGen..VGenLimit.VLimitUnit.PU);
						*/
			} 
			else if (genData.getCode() == LoadflowBusDataXmlType.GenData.Code.PV) {
				/*
				busData.getGenData().addNewQGenLimit();
				ODMData2XmlHelper.setLimitData(busData.getGenData().getQGenLimit()
						.addNewQLimit(), max, min);
				busData
						.getGenData()
						.getQGenLimit()
						.setQLimitUnit(
								LoadflowBusDataXmlType.GenData.QGenLimit.QLimitUnit.MVAR);
				if (reBusId != null && !reBusId.equals("0")
						&& !reBusId.equals(ODMData2XmlHelper.getBusRecord(busId, baseCaseNet).getId())) {
					busData.getGenData().addNewDesiredRemoteVoltage();
					ODMData2XmlHelper.setVoltageData(busData.getGenData()
							.getDesiredRemoteVoltage().addNewDesiredVoltage(),
							vSpecPu, VoltageXmlType.Unit.PU);
					busData.getGenData().getDesiredRemoteVoltage()
							.addNewRemoteBus();
					busData.getGenData().getDesiredRemoteVoltage()
							.getRemoteBus().setIdRef(reBusId);
				}
				*/
			}
		}
    }
	
	private  void processLineData(final String str,
			final BranchRecordXmlType branchRec) {
		// parse the input data line	
		final String[] strAry = getLineDataFields(str);		
		final String fid = strAry[0];
		final String tid = strAry[1];
		getLogger().fine("Branch data loaded, from-id, to-id: " + fid + ", " + tid);
		branchRec.addNewFromBus().setIdRef(fid);
		branchRec.addNewToBus().setIdRef(tid);	
		
		final String cirId = strAry[2];
		branchRec.setCircuitId(cirId);
		branchRec.setId(ODMData2XmlHelper.formBranchId(fid, tid, cirId));
		
		LoadflowBranchDataXmlType branchData=branchRec.addNewLoadflowBranchData();	
		
        //      Branch resistance R, per unit  *
		//      Branch reactance X, per unit  * No zero impedance lines
		//    	Line charging B, per unit  * (total line charging, +B), Xfr B is negative
		final double rpu = new Double(strAry[3]).doubleValue();
		final double xpu = new Double(strAry[4]).doubleValue();
		final double bpu = new Double(strAry[5]).doubleValue();
		
		if (rpu!=0 ||xpu!=0|| bpu!=0){
		ODMData2XmlHelper.setLineData(branchData, rpu, xpu,	ZXmlType.Unit.PU, 0.0, bpu, YXmlType.Unit.PU);
		}
		
		//      Line MVA rating No 1 
		//    	Line MVA rating No 2 
		//      Line MVA rating No 3
		final double rating1Mvar = new Double(strAry[6]).doubleValue();
		final double rating2Mvar = new Double(strAry[7]).doubleValue();
		final double rating3Mvar = new Double(strAry[8]).doubleValue();
		
		ODMData2XmlHelper.setBranchRatingLimitData(branchData,
				rating1Mvar, rating2Mvar, rating3Mvar,
				LoadflowBranchDataXmlType.RatingLimit.MvaRatingUnit.MVA, 0.0,
				null);
		//From side shuntY
		final double GI= new Double(strAry[9]).doubleValue();
		final double BI= new Double(strAry[10]).doubleValue();
		//To side shuntY
		final double GJ= new Double(strAry[11]).doubleValue();
		final double BJ= new Double(strAry[12]).doubleValue();
       if(GI!=0.0)  { branchData.getLineData().addNewFromShuntY().setG(GI);}
	   if (BI!=0.0) { branchData.getLineData().getFromShuntY().setB(BI);}
	   if(GJ!=0.0)  {branchData.getLineData().addNewToShuntY().setG(GJ);}
	   if(BJ!=0.0)  {branchData.getLineData().getToShuntY().setB(BJ);}
 
		
	}
   
	private  void processXformerData(final String str,final String str2,final String str3,
			final String str4,final BranchRecordXmlType branchRec, PSSNetworkXmlType baseCaseNet) throws Exception{
		 final String[] strAry = getXformerDataFields(str,str2,str3,str4);
		
		 //from ID ,to ID		
		final String fid = strAry[0];
		final String tid = strAry[1];
		getLogger().fine("Branch data loaded, from-id, to-id: " + fid + ", " + tid);
		branchRec.addNewFromBus().setIdRef(fid);
		branchRec.addNewToBus().setIdRef(tid);
		final String cirId = "1";
		branchRec.setCircuitId(cirId);		
		
		branchRec.setId(ODMData2XmlHelper.formBranchId(fid, tid, cirId));
		branchRec.addNewLoadflowBranchData();
		
		//get r x b
		final int CZ = new Integer(strAry[5]).intValue();	
		
		double rpu1_2 = new Double(strAry[20]).doubleValue();
	    double xpu1_2 = new Double(strAry[21]).doubleValue();
	   
		final double SBASE1_2 = new Double(strAry[22]).doubleValue();

		//r x value in p.u based on system base quantities

		//r x value in P.U based on a specified base and winding bus base voltage
		/* CZ=3 for transformer load loss in watts and impedance magnitude 
		in pu on a specified base MVA and winding bus base	voltage.	
            */	
		//CM=1  for complex admittance in pu on system base quantities
		double factor = baseCaseNet.getBasePower() / SBASE1_2 / 1000.0;
		double rpu = 0.0;
		double xpu = 0.0;
		if(CZ==1){
			rpu = rpu1_2;
			xpu = xpu1_2;
		}else if(CZ==2){
			rpu = rpu1_2*factor;
			xpu = xpu1_2*factor;
		}else {
			this.logErr("CZ=3 needs to be implemented");
			return;
		}
		
	 	final int CM =new Integer(strAry[6]).intValue();
        final double MAG1 = new Double(strAry[7]).doubleValue();
        final double MAG2 = new Double(strAry[8]).doubleValue();	
        double gpu =0.0, bpu= 0.0;
        
       if (CM ==1){
    	   gpu = MAG1;
    	   bpu = MAG2;
       }else {
    	   this.logErr("MAG1 AND MAG2 NEEDS TO BE IMPLEMENTED WHEN CM!=1");
    	   return;
       }	
		//SET XFORMER R X G B 
       ODMData2XmlHelper.setXformerData(branchRec.getLoadflowBranchData(),
			       rpu, xpu, ZXmlType.Unit.PU, gpu, bpu, 0.0, 0.0,	YXmlType.Unit.PU);		
		
		int CW = new Integer(strAry[4]).intValue();
		double WINDV1 = new Double(strAry[23]).doubleValue();
		double WINDV2 = new Double(strAry[38]).doubleValue();
        //from side ratio and to bus side ratio
		double f_ratio = 1.0, t_ratio=1.0;
		BusRecordXmlType fromBusRec = ODMData2XmlHelper.getBusRecord(fid, baseCaseNet);
		BusRecordXmlType toBusRec = ODMData2XmlHelper.getBusRecord(tid, baseCaseNet);	
		// The winding one off-nominal turns ratio in pu of winding one bus base voltage when CW is 1;
		if (CW==1){
        	f_ratio = WINDV1;
        	t_ratio = WINDV2;
		}
		//WINDV1 is the actual winding one 	voltage in kV when CW is 2
		if (CW==2){
		   final double systemBaseV =fromBusRec.getBaseVoltage().getVoltage();
			f_ratio = WINDV1*1000.0 / systemBaseV;
       		t_ratio = WINDV2*1000.0 /systemBaseV;
		}
		branchRec.getLoadflowBranchData().getXformerData()
		.setFromTurnRatio(f_ratio);
		branchRec.getLoadflowBranchData().getXformerData()
		.setFromTurnRatio(t_ratio);
		
		//     MVA rating No 1 
		//    MVA rating No 2
		//    	  Line MVA rating No 3 
		final double rating1Mvar = new Double(strAry[26]).doubleValue();
		final double rating2Mvar = new Double(strAry[27]).doubleValue();
		final double rating3Mvar = new Double(strAry[28]).doubleValue();
		ODMData2XmlHelper.setBranchRatingLimitData(branchRec.getLoadflowBranchData(),
				rating1Mvar, rating2Mvar, rating3Mvar,
				LoadflowBranchDataXmlType.RatingLimit.MvaRatingUnit.MVA, 0.0,
				null);
		
		final double NOMV1 = new Double(strAry[23]).doubleValue();
		final double NOMV2 = new Double(strAry[38]).doubleValue();

		//set rating limit data
		double fromRatedV,toRatedV;		
		if (NOMV1==0){
			fromRatedV =fromBusRec.getBaseVoltage().getVoltage();
		}
		else {	fromRatedV = NOMV1;		}
		if (NOMV2==0){
			toRatedV =toBusRec.getBaseVoltage().getVoltage();
		}
		else { toRatedV = NOMV2;     	}
		
		VoltageXmlType.Unit.Enum vUnit =fromBusRec.getBaseVoltage().getUnit();
		if(NOMV1==0 && NOMV2==0){vUnit=VoltageXmlType.Unit.KV;}
		ODMData2XmlHelper.setXfrRatingData(branchRec.getLoadflowBranchData().getXformerData(),
				fromRatedV, toRatedV, vUnit);	
		
		
		
		double ANG1 = new Double(strAry[25]).intValue();
		final int COD = new Integer(strAry[29]).intValue();
		
		int CONT = new Integer(strAry[30]).intValue();
		double RMA = new Double(strAry[31]).intValue();
  		double RMI = new Double(strAry[32]).intValue();
  		double VMA = new Double(strAry[33]).intValue();
  		double VMI = new Double(strAry[34]).intValue();
  		int NTP = new Integer(strAry[35]).intValue();
  		//int TAB = new Integer(strAry[36]).intValue();
     	//	double CR = new Double(strAry[37]).intValue();
  		//double CX = new Double(strAry[38]).intValue();
  		
  		if (ANG1 != 0.0 || COD == 3 || COD == -3){
   			ODMData2XmlHelper.setPhaseShiftXfrData(branchRec
					.getLoadflowBranchData(), rpu, xpu, ZXmlType.Unit.PU,
					0.0, bpu, 0.0, 0.0, YXmlType.Unit.PU);
			branchRec.getLoadflowBranchData().getPhaseShiftXfrData()
					.setFromTurnRatio(f_ratio);
			ODMData2XmlHelper.setAngleData(branchRec.getLoadflowBranchData()
					.getPhaseShiftXfrData().addNewFromAngle(), ANG1,
					AngleXmlType.Unit.DEG);
  			 }
  		
  		//COD=1,voltage control
		String controlBusId = "";
		boolean controlSide =false;
		boolean onFromSide = false;
		double stepSize = 0.0, maxTapAng = 0.0, minTapAng = 0.0, maxVoltPQ = 0.0, minVoltPQ = 0.0;
		
		if (Math.abs(COD) >0 && Math.abs(COD) <4){
			/*
			If CONT is entered as a positive number, or a quoted extended bus name, the ratio is
			adjusted as if bus CONT is on the winding two or winding three side of the
			transformer; if CONT is entered as a negative number, or a quoted extended
			bus name with a minus sign preceding the first character, the ratio is adjusted
			as if bus |CONT| is on the winding one side of the transformer.
	      	 */
          	 
          	if (CONT <0) {
          		CONT = -CONT;
          		onFromSide = true;
          	}
			controlBusId = new Integer(CONT).toString();

          	controlSide = onFromSide;

			//       Step size 
			stepSize = NTP;
            
			/*Off-nominal turns ratio in pu of winding one bus base voltage when |COD|
             is 1 or 2 and CW is 1; RMA = 1.1 and RMI = 0.9 by default.
               Actual winding one voltage in kV when |COD| is 1 or 2 and CW is 2. No
               default is allowed.
               Phase shift angle in degrees when |COD| is 3. No default is allowed.
			*/
			maxTapAng = RMA;
			minTapAng = RMI;
			/*
			 Voltage at the controlled bus (bus |CONT|) in pu when |COD| is 1.
                 Reactive power flow into the transformer at the winding one bus end in
                 Mvar when |COD| is 2. No default is allowed.
                 Active power flow into the transformer at the winding one bus end in MW
               when |COD| is 3. No default is allowed.
			*/

			maxVoltPQ = VMA;
			minVoltPQ = VMI;
		}
		

  		if (Math.abs(COD) ==1 || Math.abs(COD)==2 ) {	
			TransformerDataXmlType.TapAdjustment tapAdj = branchRec.getLoadflowBranchData().getXformerData()
						.addNewTapAdjustment();
	        ODMData2XmlHelper.setLimitData(tapAdj.addNewTapLimit(), maxTapAng,
			minTapAng);
	        tapAdj.setTapAdjStepSize(stepSize);
	        tapAdj.setTapAdjOnFromSide(onFromSide);
  			//voltage control
	        if (Math.abs(COD) ==1){
	    		TransformerDataXmlType.TapAdjustment.VoltageAdjData voltTapAdj = tapAdj.addNewVoltageAdjData();
	    		voltTapAdj.addNewAdjVoltageBus().setIdRef(controlBusId);
	    		voltTapAdj.setAdjBusLocation(controlSide == false ? 
	    				TransformerDataXmlType.TapAdjustment.VoltageAdjData.AdjBusLocation.NEAR_TO_BUS
	    					:  TransformerDataXmlType.TapAdjustment.VoltageAdjData.AdjBusLocation.NEAR_FROM_BUS );
		
	    		voltTapAdj.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
	    		ODMData2XmlHelper.setLimitData(voltTapAdj.addNewDesiredRange(),
	    										maxVoltPQ, minVoltPQ);
	        	
	        }
	        //MVAR control
  		    if (Math.abs(COD)  == 2){
				TransformerDataXmlType.TapAdjustment.MvarFlowAdjData mvarTapAdj = tapAdj.addNewMvarFlowAdjData();
				ODMData2XmlHelper.setLimitData(mvarTapAdj.addNewDesiredRange(),
									maxVoltPQ, minVoltPQ);
				mvarTapAdj.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
				mvarTapAdj.setMvarMeasuredOnFormSide(onFromSide);
  		    }
  		}
  		    // MW control      phase shifter
  		else if (Math.abs(COD)  == 3){
  			PhaseShiftXfrDataXmlType.AngleAdjustment angAdj = branchRec
				.getLoadflowBranchData().getPhaseShiftXfrData()
				.addNewAngleAdjustment();
  			ODMData2XmlHelper.setLimitData(angAdj.addNewAngleDegLimit(), maxTapAng,
				minTapAng);
  			ODMData2XmlHelper.setLimitData(angAdj.addNewDesiredRange(), maxVoltPQ,
				minVoltPQ);
  			angAdj.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
  			angAdj.setDesiredMeasuredOnFromSide(onFromSide);
  		}
	}
  		
  			
	private  void processAreaInterchangeData(final String str,
			final PSSNetworkXmlType baseCaseNet) {
		final String[] strAry = getInterAreaTransferDataFields(str);
		//     Area number , no zeros! *
		final int no = new Integer(strAry[0]).intValue();
		//       Alternate swing bus name [A]
		final String alSwingBusName = strAry[1];

		//        Area interchange export, MW [F] (+ = out) *
		//        Area interchange tolerance, MW [F] *
		final double mw = new Double(strAry[2]).doubleValue();
		final double err = new Double(strAry[3]).doubleValue();
    
		PSSNetworkXmlType.InterchangeList.Interchange.IeeeCDFInterchange interchange =
		baseCaseNet.addNewInterchangeList().addNewInterchange().addNewIeeeCDFInterchange();
	
		interchange.setAreaNumber(no);

		interchange.setAlternateSwingBusName(alSwingBusName);
		ODMData2XmlHelper.setPowerData(interchange.addNewInterchangePower(), mw, 0.0, PowerXmlType.Unit.MVA);
		interchange.setInterchangeErrTolerance(err);
	
	}
	
	private  void processZoneData(final String str,
			final PSSNetworkXmlType baseCaseNet){
		final String[] strAry =getZoneDataFields(str);
		final String zoneId = strAry[0];
		final String zoneName = strAry[1];
		NameValuePairListXmlType nvList = baseCaseNet.getNvPairList();
		ODMData2XmlHelper.addNVPair(nvList, "zoneId", zoneId);
		ODMData2XmlHelper.addNVPair(nvList, "zoneName", zoneName);		
	}
	
	
	private  void processInterAreaTransferData(final String str,
			final PSSNetworkXmlType baseCaseNet) {
		final String[] strAry = getInterAreaTransferDataFields(str);
		
	}
	
	private  void processOwnerData(final String str,
			final PSSNetworkXmlType baseCaseNet) {
		final String[] strAry = getOwnerDataFields(str);
		final String ownerId = strAry[0];
		final String ownerName = strAry[1];
		NameValuePairListXmlType nvList = baseCaseNet.getNvPairList();
		ODMData2XmlHelper.addNVPair(nvList, "ownerName", ownerName);
		ODMData2XmlHelper.addNVPair(nvList, "ownerId", ownerId);
	}
		
	/*
	 * String[0] indicator
	 * String[1] baseKav
	 * String[2] comments
	 * String[3] comments
	 */
	private  String[] getHeaderDataFields(final String lineStr, final String lineStr2,
							final String lineStr3)	throws Exception{
		final String[] strAry = new String[4];	
		StringTokenizer st = new StringTokenizer(lineStr, ",");
		
		strAry[0] = st.nextToken();  			   
		int indicator = new Integer(strAry[0]).intValue();
		if (indicator !=0){
			this.logErr("Error: Only base case can be process");
			return null;
		}

		strAry[1]=st.nextToken().trim();  			   
		
		if (lineStr2!= null){
			strAry[2] = lineStr2;
		}else {strAry[2] =""; }
		if (lineStr3!= null){
			strAry[3] = lineStr3;
		}else {strAry[3] =""; }
  				
		return strAry;
	}
	
	private  String[] getBusDataFields(final String lineStr) {
		final String[] strAry = new String[11];

		StringTokenizer st = new StringTokenizer(lineStr,",");
		//Format: I, NAME BASKV, IDE, GL, BL, AREA, ZONE, VM, VA, OWNER
        //I
		strAry[0]=st.nextToken().trim();
		//NAME
		strAry[1]=st.nextToken().trim();
		//BASKV
		strAry[2]=st.nextToken().trim();
		//IDE
		strAry[3]=st.nextToken().trim();
		
		strAry[4]=strAry[5]="0";//GL BL double
		strAry[6]=strAry[7]="1";//AREA ZONE 
		strAry[8]="1.0";//VM
		strAry[9]="0.0";//VA
		strAry[10]="1";//OWNER
		
		//GL
        if (st.hasMoreTokens())				
			
		strAry[4]=st.nextToken().trim();
		//BL
		strAry[5]=st.nextToken().trim();
		//AREA
		if (st.hasMoreTokens())				
		
			strAry[6]=st.nextToken().trim();
		//ZONE
		if (st.hasMoreTokens())				
			
			strAry[7]=st.nextToken().trim();
		//VM
		if (st.hasMoreTokens())				
			strAry[8]=st.nextToken().trim();
		//VA
		if (st.hasMoreTokens())				
			strAry[9]=st.nextToken().trim();
		//OWNER
		if (st.hasMoreTokens())				
			strAry[10]=st.nextToken().trim();  			

		return strAry;
	}
	
	private  String[] getLoadDataFields(final String lineStr) {
		final String[] strAry = new String[12];
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
		/*
		I, ID, STATUS, AREA, ZONE, PL, QL, IP, IQ, YP, YQ, OWNER
		 */		
  		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		strAry[2]=st.nextToken().trim();
  		strAry[3]=st.nextToken().trim();
  		strAry[4]=st.nextToken().trim();
  		strAry[5]=st.nextToken().trim();
  		strAry[6]=st.nextToken().trim();
  		strAry[7]=st.nextToken().trim();
  		strAry[8]=st.nextToken().trim();
  		strAry[9]=st.nextToken().trim();
  		strAry[10]=st.nextToken().trim();
  		strAry[11]=st.nextToken().trim();

  		return strAry;
	}	
	
	
	private  String[] getGenDataFields(final String lineStr) {
		final String[] strAry = new String[26];		
		/*
		I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4

		The standard generator boundary condition is a specification of real power output at the
		high-voltage bus, bus k, and of voltage magnitude at some designated bus, not necessarily bus k.
        */		
		//I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		strAry[2]=st.nextToken().trim();
  		strAry[3]=st.nextToken().trim();
  		strAry[4]=st.nextToken().trim();
  		strAry[5]=st.nextToken().trim();
  		strAry[6]=st.nextToken().trim();
  		strAry[7]=st.nextToken().trim();
  		strAry[8]=st.nextToken().trim();
  		strAry[9]=st.nextToken().trim();
  		strAry[10]=st.nextToken().trim();
  		strAry[11]=st.nextToken().trim();
  		strAry[12]=st.nextToken().trim();
  		strAry[13]=st.nextToken().trim();
  		strAry[14]=st.nextToken().trim();
  		strAry[15]=st.nextToken().trim();
  		strAry[16]=st.nextToken().trim();
  		strAry[17]=st.nextToken().trim();

        //O1,F1,...,O4,F4
  		
		//   O1 = 0, O2 = 0, O3 = 0, O4 = 0;
		// F1 = 0.0, F2 = 0.0, F3 = 0.0, F4 = 0.0;
		strAry[18]="0";
  		strAry[19]="0";
  		strAry[20]="0";
  		strAry[21]="0";
		strAry[22]="0";
  		strAry[23]="0";
		strAry[24]="0";
  		strAry[25]="0";
		if (st.hasMoreTokens()) {
			strAry[18]=st.nextToken().trim();
	  		strAry[19]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[20]=st.nextToken().trim();
	  		strAry[21]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[22]=st.nextToken().trim();
	  		strAry[23]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[24]=st.nextToken().trim();
	  		strAry[25]=st.nextToken().trim();
		}
				
			

		return strAry;
	}
	
	private  String[] getLineDataFields(final String lineStr) {
		final String[] strAry = new String[23];

  		StringTokenizer st = new StringTokenizer(lineStr, ",");
		/*
		I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
        */

  		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		strAry[2]=st.nextToken().trim();
  		strAry[3]=st.nextToken().trim();
  		strAry[4]=st.nextToken().trim();
  		strAry[5]=st.nextToken().trim();
  		strAry[6]=st.nextToken().trim();
  		strAry[7]=st.nextToken().trim();
  		strAry[8]=st.nextToken().trim();
  		strAry[9]=st.nextToken().trim();
  		strAry[10]=st.nextToken().trim();
  		strAry[11]=st.nextToken().trim();
  		strAry[12]=st.nextToken().trim();
  		strAry[13]=st.nextToken().trim();
  		strAry[14]=st.nextToken().trim();

        //O1,F1,...,O4,F4
  		
		// O1 = 0, O2 = 0, O3 = 0, O4 = 0;
		// F1 = 0.0, F2 = 0.0, F3 = 0.0, F4 = 0.0;
		strAry[15]="0";
  		strAry[16]="0";
  		strAry[17]="0";
  		strAry[18]="0";
		strAry[19]="0";
  		strAry[20]="0";
		strAry[21]="0";
  		strAry[22]="0";
		if (st.hasMoreTokens()) {
			strAry[15]=st.nextToken().trim();
	  		strAry[16]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[17]=st.nextToken().trim();
	  		strAry[18]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[19]=st.nextToken().trim();
	  		strAry[20]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[21]=st.nextToken().trim();
	  		strAry[22]=st.nextToken().trim();
		}
				
		return strAry;
	
	}
	
	private  String[] getXformerDataFields(final String lineStr,final String lineStr2,
			final String lineStr3,final String lineStr4 ) throws Exception {
		/*
		For 2W and 3W Xfr: I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,Name STAT,O1,F1,...,O4,F4
		 */
		
		final String[] strAry = new String[40];
		StringTokenizer st = new StringTokenizer(lineStr, ",");
 		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		strAry[2]=st.nextToken().trim();
  		strAry[3]=st.nextToken().trim();
  		strAry[4]=st.nextToken().trim();
  		strAry[5]=st.nextToken().trim();
  		strAry[6]=st.nextToken().trim();
  		strAry[7]=st.nextToken().trim();
  		strAry[8]=st.nextToken().trim();
  		strAry[9]=st.nextToken().trim();
  		strAry[10]=st.nextToken().trim();
  		strAry[11]=st.nextToken().trim();
  		
  		
        //O1,F1,...,O4,F4
  		
		// O1 = 0, O2 = 0, O3 = 0, O4 = 0;
		// F1 = 0.0, F2 = 0.0, F3 = 0.0, F4 = 0.0;
		strAry[12]="0";
  		strAry[13]="0";
  		strAry[14]="0";
  		strAry[15]="0";
		strAry[16]="0";
  		strAry[17]="0";
		strAry[18]="0";
  		strAry[19]="0";
		if (st.hasMoreTokens()) {
			strAry[12]=st.nextToken().trim();
	  		strAry[13]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[14]=st.nextToken().trim();
	  		strAry[15]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[16]=st.nextToken().trim();
	  		strAry[17]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[18]=st.nextToken().trim();
	  		strAry[19]=st.nextToken().trim();
		}
		
    	/*
   		format : R1-2,X1-2,SBASE1-2
	    */
		StringTokenizer st2 = new StringTokenizer(lineStr2, ",");
  		strAry[20]=st2.nextToken().trim();
  		strAry[21]=st2.nextToken().trim();
  		strAry[22]=st2.nextToken().trim();
		
    	/*
		format : WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
    	 */
  		StringTokenizer st3 = new StringTokenizer(lineStr3, ",");
  		strAry[23]=st3.nextToken().trim();
  		strAry[24]=st3.nextToken().trim();
  		strAry[25]=st3.nextToken().trim();
  		strAry[26]=st3.nextToken().trim();
  		strAry[27]=st3.nextToken().trim();
  		strAry[28]=st3.nextToken().trim();
  		strAry[29]=st3.nextToken().trim();
  		strAry[30]=st3.nextToken().trim();
  		strAry[31]=st3.nextToken().trim();
  		strAry[32]=st3.nextToken().trim();
  		strAry[33]=st3.nextToken().trim();
  		strAry[34]=st3.nextToken().trim();
  		strAry[35]=st3.nextToken().trim();
  		strAry[36]=st3.nextToken().trim();
  		strAry[37]=st3.nextToken().trim();
  		
  		/*
		format : WINDV2,NOMV2
  		 */
  		StringTokenizer st4 = new StringTokenizer(lineStr4, ",");
  		strAry[38]=st4.nextToken().trim();
  		strAry[39]=st4.nextToken().trim();
  		
		
		return strAry;
	}
	
	private  String[] getAreaInterchangeDataFields(final String lineStr) {
		final String[] strAry = new String[5];
		/*
		I,ISW,PDES,PTOL,'ARNAM'
        */
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
 		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		strAry[2]=st.nextToken().trim();
  		strAry[3]=st.nextToken().trim();
  		strAry[4]=st.nextToken().trim();
  		
  		return strAry;
	}
	
	//private static String[] getTwoTerminalDCLineDataFields(final String lineStr) {
		//final String[] strAry = new String[5];	
		//It will be implemented in the future
     // }
	//private static String[] getVSCDCLineDataFields(final String lineStr) {
		//final String[] strAry = new String[5];	
		//It will be implemented in the future
     //  }
	
	//private static String[] getSwitchedShuntDATAFields(final String lineStr) {
		//final String[] strAry = new String[5];	
		//It will be implemented in the future
     //  }
	//private static String[] getImpedenceCorrectionDATAFields(final String lineStr) {
		//final String[] strAry = new String[5];	
		//It will be implemented in the future
    //   }
	/*private static String[] getMultiTerminalDATAFields(final String lineStr) {
		//final String[] strAry = new String[5];	
		//It will be implemented in the future
       }
	private static String[] getMultiSectionLineDATAFields(final String lineStr) {
		//final String[] strAry = new String[5];	
		//It will be implemented in the future
      }*/ 
	private  String[] getZoneDataFields(final String lineStr) {
		final String[] strAry = new String[2];	
		/*
		 * Format: I, Name
		 */
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		return strAry;
       }
	private  String[] getInterAreaTransferDataFields(final String lineStr) {
		final String[] strAry = new String[5];	
		/*
		 * format: ARFROM, ARTO, TRID, PTRAN
		 */
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		strAry[3]=st.nextToken().trim();
  		strAry[4]=st.nextToken().trim();
  		return strAry;

       }
	private  String[] getOwnerDataFields(final String lineStr) {
		final String[] strAry = new String[2];	
		/*
		 * format : I, Name
		 */
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		return strAry;
	}
	//private  String[] getFactsDeviceDATAFields(final String lineStr) {
		//final String[] strAry = new String[5];	
		//It will be implemented in the future
      // 	}
}
