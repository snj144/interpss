/*
 * Created on 2006-4-8
 * 
 */
package org.interpss.custom.exchange;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.interpss.custom.exchange.impl.PSATFormat_in;

import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.io.IpssFileAdapterBase;

public class FileAdpater_PSATFormat  extends IpssFileAdapterBase {
	/**
	 * Load the data in the data file, specified by the filepath, into the SimuContext object. An AclfAdjNetwork
	 * object will be created to hold the data for loadflow analysis.
	 * 
	 * @param simuCtx the SimuContext object
	 * @param filepath full path path of the input file
	 * @param msg the SessionMsg object
	 */
	public void load(SimuContext simuCtx, String filepath, IPSSMsgHub msg) throws Exception {
		File file = new File(filepath);
		InputStream stream = new FileInputStream(file);
		BufferedReader din = new BufferedReader(new InputStreamReader(stream));
		
		AclfAdjNetwork adjNet = PSATFormat_in.loadFile(din, msg);
  		//System.out.println(adjNet.net2String());
  		
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
	public SimuContext load(String filepath, IPSSMsgHub msg) throws Exception {
  		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.NOT_DEFINED, msg);
  		load(simuCtx, filepath, msg);
  		return simuCtx;
	}
	
	/**
	 * This method is currently not implemented, since the loadflow results are not going to write
	 * back to a data file.
	 */
	public boolean save(String filepath, SimuContext net, IPSSMsgHub msg) throws Exception {
		throw new InvalidOperationException("FileAdapter_PSATFormat.save not implemented");
	}
}
