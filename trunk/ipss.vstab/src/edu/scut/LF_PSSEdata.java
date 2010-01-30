package com.interpss.tony.lf;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class LF_PSSEdata {
	 static int count;
   public static void main(String arg[]) throws IOException{
   // IPSSMsgHub msg=null ;  
	   IPSSMsgHub msg = new IPSSMsgHubImpl();
	//AclfNetwork objNet=Converter.Converter4InterPSS("ieee30.ieee", "ieeecdf");
	AclfNetwork Net=Converter.Converter4InterPSS("EQ0907.raw", "psse");
	AclfBus bus=(AclfBus) Net.getBusList().get(0);
	Vstab.print(bus.getName()+""+bus.getLoadP());
	
	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(Net,msg);
	algo.setLfMethod(AclfMethod.PQ);
	algo.setMaxIterations(20);
	algo.loadflow();

	//algo.setLfMethod(AclfMethod.NR);
	//algo.setMaxIterations(30);
	//algo.loadflow();
	Vstab.print("load flow :-->"+algo.loadflow());
	File outF = new File("E:/workspace/LF_PSSE02.DAT"); 
	FileOutputStream outfile = new FileOutputStream(outF);
	OutputStream out = new BufferedOutputStream(outfile);
	String temp =AclfOutFunc.loadFlowSummary(Net);
	out.write(temp.getBytes());
	out.flush();			
	out.close();
	
   }

}
