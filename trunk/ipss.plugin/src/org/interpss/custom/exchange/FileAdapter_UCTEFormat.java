 /*
  * @(#)FileAdapter_GE_PSLFFormat.java   
  *
  * Copyright (C) 2006 www.interpss.org
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.custom.exchange;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.StringUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.io.IpssFileAdapterBase;

public class FileAdapter_UCTEFormat extends IpssFileAdapterBase {
	private static final String Token_CommentBlock 		= "##C";
	private static final String Token_NodeBlock 		= "##N";
	private static final String Token_ISOCountryId 		= "##Z";
	private static final String Token_LineBlock			= "##L";
	private static final String Token_2WXfrBlock		= "##T";
	private static final String Token_2WXfrRegBlock 	= "##R";
	private static final String Token_EOF 				= "##TT";
	
	private enum RecType {Comment, Node, Line, Xfr2W, Xfr2WReg, Xfr2WDesc, ExPower, NotDefined};

	/**
	 * Load the data in the data file, specified by the filepath, into the SimuContext object. An AclfAdjNetwork
	 * object will be created to hold the data for loadflow analysis.
	 * 
	 * @param simuCtx the SimuContext object
	 * @param filepath full path path of the input file
	 * @param msg the SessionMsg object
	 */
	@Override
	public void load(final SimuContext simuCtx, final String filepath, final IPSSMsgHub msg) throws Exception{
		final File file = new File(filepath);
		final InputStream stream = new FileInputStream(file);
		final BufferedReader din = new BufferedReader(new InputStreamReader(stream));
		
		final AclfAdjNetwork adjNet = loadFile(din, msg);
  		// System.out.println(adjNet.net2String());
	  		
  		simuCtx.setNetType(SimuCtxType.ACLF_ADJ_NETWORK);
  		simuCtx.setAclfAdjNet(adjNet);
  		simuCtx.setName(filepath.substring(filepath.lastIndexOf(File.separatorChar)+1));
  		simuCtx.setDesc("This project is created by input file " + filepath);
	}
	
	/**
	 * Create a SimuContext object and Load the data in the data file, specified by the filepath, into the object. 
	 * An AclfAdjNetwork object will be created to hold the data for loadflow analysis.
	 * 
	 * @param filepath full path path of the input file
	 * @param msg the SessionMsg object
	 * @return the created SimuContext object.
	 */
	@Override
	public SimuContext load(final String filepath, final IPSSMsgHub msg) throws Exception{
  		final SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.NOT_DEFINED, msg);
  		load(simuCtx, filepath, msg);
  		return simuCtx;
	}
	
	/**
	 * This method is currently not implemented, since the loadflow results are not going to write
	 * back to a data file.
	 */
	@Override
	public boolean save(final String filepath, final SimuContext net, final IPSSMsgHub msg) throws Exception{
		throw new InvalidOperationException("FileAdapter_IeeeCommonFormat.save not implemented");
	}

    private static AclfAdjNetwork loadFile(final java.io.BufferedReader din, final IPSSMsgHub msg) throws Exception {
    	final AclfAdjNetwork  adjNet = CoreObjectFactory.createAclfAdjNetwork();
    	adjNet.setAllowParallelBranch(true);

      	String str;   
      	RecType recType = RecType.NotDefined;
    	do {
          	str = din.readLine();   
        	if (!str.trim().equals(Token_EOF)) {
        		String countryId = "";
    			try {
    				if (str.startsWith(Token_CommentBlock))
    					recType = RecType.Comment;
    				else if (str.startsWith(Token_NodeBlock))
    					recType = RecType.Node;
    				else if (str.startsWith(Token_ISOCountryId) && recType == RecType.Node)
    					countryId = "";
    				else if (str.startsWith(Token_LineBlock))
    					recType = RecType.Line;
    				else if (str.startsWith(Token_2WXfrBlock))
    					recType = RecType.Xfr2W;
    				else if (str.startsWith(Token_2WXfrRegBlock))
    					recType = RecType.Xfr2WReg;
    				else {
    					processRecord(str, recType, countryId, adjNet, msg);
    				}
    			} catch (final Exception e) {
    				IpssLogger.logErr(e);
    				msg.sendErrorMsg("Error Line: " + str + ", " + e.toString());
    			}
        	}
       	} while (!str.trim().equals(Token_EOF));

    	return adjNet;
    }

    private static boolean processRecord(String str, RecType recType, String countryId, AclfAdjNetwork  adjNet, final IPSSMsgHub msg) {
    	boolean noError = true;
    	if (recType == RecType.Comment) {
    	    if (!processCommentRecord(str, adjNet))
    	    	noError = false;
    	}
    	else if (recType == RecType.Node) {
    	    if (!processNodeRecord(str, countryId, adjNet, msg))
    	    	noError = false;
    	}
    	else if (recType == RecType.Line) {
    	    if (!processLineRecord(str, adjNet, msg))
    	    	noError = false;
    	}
    	else if (recType == RecType.Xfr2W) {
    	    if (!processXfr2WindingRecord(str, adjNet))
    	    	noError = false;
    	}
    	else if (recType == RecType.Xfr2WReg) {
    	    if (!processXfr2WRegulationRecord(str, adjNet))
    	    	noError = false;
    	}
    	else if (recType == RecType.Xfr2WDesc) {
    	    if (!processXfr2SpecialDescRecord(str, adjNet))
    	    	noError = false;
    	}
    	return noError;
    }

    private static boolean processCommentRecord(String str, AclfAdjNetwork  adjNet) {
		IpssLogger.getLogger().info("Comment: " + str);
    	return true;
    }

    private static boolean processNodeRecord(String str, String countryId, AclfAdjNetwork  adjNet, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Node Record: " + str);
		StringTokenizer st = new StringTokenizer(str);
		String id = st.nextToken();
		String name = st.nextToken();
		try {
			int status = new Integer(st.nextToken()).intValue();  // 0 real, 1 equivalent
			int nodeType = new Integer(st.nextToken()).intValue();  // 0 PQ, 1 QAng, 2 PV, 3 Swing
			double baseKv = new Double(st.nextToken()).doubleValue();  
			double pLoadMW = new Double(st.nextToken()).doubleValue();  
			double qLoadMvar = new Double(st.nextToken()).doubleValue();  
			double pGenMW = new Double(st.nextToken()).doubleValue();  
			double qGenMvar = new Double(st.nextToken()).doubleValue();
			
			// optional fields
			double 	minGenMW = StringUtil.getDouble(str, 66, 72), 
					maxGenMW = StringUtil.getDouble(str, 74, 80),
					minGenMVar = StringUtil.getDouble(str, 82, 88), 
					maxGenMVar = StringUtil.getDouble(str, 90, 96), 
					staticPrimaryControl = StringUtil.getDouble(str, 98, 102), 
					normalPoewrPrimaryControl = StringUtil.getDouble(str, 104, 110),
					scMVA3P = StringUtil.getDouble(str, 112, 118),
					x_rRatio = StringUtil.getDouble(str, 120, 126);
		} catch (Exception e) {
			IpssLogger.logErr(e);
			msg.sendErrorMsg("Error: " + str + ", " + e.toString());
			return false;
		}
		String powerPlanType = str.substring(127,128);
		
    	return true;
    }
    
    private static boolean processLineRecord(String str, AclfAdjNetwork  adjNet, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Line Record: " + str);
		StringTokenizer st = new StringTokenizer(str);
		String fromNodeId = st.nextToken();
		String toNodeId = st.nextToken();
		String orderCode = st.nextToken();
		try {
			int status = new Integer(st.nextToken()).intValue();  // 0 real, i equivalent
			double rOhm = new Double(st.nextToken()).doubleValue();  
			double xOhm = new Double(st.nextToken()).doubleValue();  
			double bMuS = new Double(st.nextToken()).doubleValue();  
			int currentLimit = new Integer(st.nextToken()).intValue();  
		} catch (Exception e) {
			IpssLogger.logErr(e);
			msg.sendErrorMsg("Error: " + str + ", " + e.toString());
			return false;
		}
		String elemName = str.substring(53,64);
    	return true;
    }
    
    private static boolean processXfr2WindingRecord(String str, AclfAdjNetwork  adjNet) {
		IpssLogger.getLogger().info("Xfr 2W Record: " + str);
    	return true;
    }
    
    private static boolean processXfr2WRegulationRecord(String str, AclfAdjNetwork  adjNet) {
		IpssLogger.getLogger().info("Xfr 2W Reg Record: " + str);
    	return true;
    }
    
    private static boolean processXfr2SpecialDescRecord(String str, AclfAdjNetwork  adjNet) {
		IpssLogger.getLogger().info("Xfr 2W Desc Record: " + str);
    	return true;
    }
}
