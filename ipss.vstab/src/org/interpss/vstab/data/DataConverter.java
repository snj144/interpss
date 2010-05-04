package org.interpss.vstab.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.bpa.BPAAdapter;
import org.ieee.odm.adapter.ieeecdf.JaxbIeeeCDFAdapter;
import org.ieee.odm.adapter.psse.v30.PSSEV30Adapter;
import org.ieee.odm.model.ODMModelParser;
import org.interpss.mapper.IEEEODMMapper;

import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class DataConverter {
	   private final static String Token_IEEECDF 	= "ieeecdf";
	   private final static String Token_PSSE 	= "psse";
	   private final static String Token_BPA 	= "bpa";
	   public org.ieee.odm.model.ODMModelParser parser;
	  
	   
	   
   public  AclfNetwork Converter4InterPSS( String InPutFile,String type){
	    AclfNetwork net=null;
	    IPSSMsgHub msg=null ;
	    //0. determine the proper Adapter for Converter with the input infromation 
	    IODMPSSAdapter adapter=null;
	    IpssMapper mapper =null;
		LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");;
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
	   
	    try{
	    	if (Token_IEEECDF.equalsIgnoreCase(type)){
	    		logger.info("Input file is of format IEEE Common Data Format");
	    		adapter=new IeeeCDFAdapter(logger);
	    	}
	    	else if (Token_PSSE.equalsIgnoreCase(type)){
	    		logger.info("Input file is of format PSSE V30 Format");
	    		adapter=new PSSEV30Adapter(logger);
	    		
	    	}
	    	else if (Token_BPA.equalsIgnoreCase(type)){
	    		logger.info("Input file is of format BPA Format");
	    		adapter=new BPAAdapter(logger);
	    	}
	    	else {
	    		logger.severe("Error: Unsupported input file data, " + type);
				System.err.println("Error: Unsupported input file data, " + type);
				System.exit(0);
	    	}
	    
		  // 1. Convert input data  to intermediary XML file
	   
			if (!adapter.parseInputFile(InPutFile)) {
				logger.severe("Error: model parsing error, " + adapter.errMessage());
				System.err.println("Error: model parsing error, " + adapter.errMessage());
			}
			// convert the model to a XML document string
			String xmlStr = adapter.getModel().toXmlDoc(true);
			// modify the XML output to validate the result
			String str1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><pss:PSSStudyCase xmlns:pss=\"http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1\" " +
			 "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ";
			String str2 = "<?xml version=\"1.0\" encoding=\"GB2312\"?><pss:PSSStudyCase xmlns:pss=\"http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1\" " +
			 "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "+
			 "xsi:schemaLocation=\"http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1 ./schema/ODM_StudyCase.xsd\" ";
			xmlStr = xmlStr.replace(str1, str2);
			// output the XML document to the output file
			FileOutputStream outfile = null;
			outfile = new FileOutputStream("intermediary.xml");
			OutputStream out = new BufferedOutputStream(outfile);
			out.write(xmlStr.getBytes());
			out.flush();			
			out.close();
		}
		catch(Exception e){
			System.err.println(e.toString());
			e.printStackTrace();
		}
		// 2. Convert intermediary XML file to InterPSS model
		try{
			InputStream in = new BufferedInputStream(new FileInputStream("intermediary.xml"));
			this.parser = new ODMModelParser(in);
			//IEEEODMMapper mapper = new IEEEODMMapper();
			mapper = new IEEEODMMapper();
			SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_NETWORK, msg);
			mapper.mapping(parser, simuCtx, SimuContext.class);
			net = simuCtx.getAclfNet();
		}
		catch(Exception e){
			System.err.println(e.toString());
			e.printStackTrace();
		}
		return net;
	}
   public ODMModelParser getParser(){
	   return this.parser;
   }

}
   
   