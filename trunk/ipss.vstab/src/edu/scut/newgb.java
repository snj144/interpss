package edu.scut;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.apache.commons.math.complex.Complex;
import org.interpss.display.AclfOutFunc;
import org.interpss.mapper.IEEEODMMapper;


import Jama.Matrix;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IPSSMsgHubImpl;
import com.interpss.common.msg.StdoutMsgListener;
import com.interpss.common.msg.TextMessage;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;

import com.interpss.core.aclf.AclfBus;

import com.interpss.core.aclf.AclfNetwork;

import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import org.ieee.pes.odm.pss.adapter.ieeecdf.IeeeCDFAdapter;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;

public class newgb {
  
   public static void loadflow(AclfNetwork net,IPSSMsgHub msg){
 
    
		
		// create the default loadflow algorithm
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		// use the loadflow algorithm to perform loadflow calculation
		algo.loadflow(msg);
	    System.out.println(AclfOutFunc.loadFlowSummary(net));
   }
   
	 
	public static void main(String[] args) {
		AclfNetwork net =CoreObjectFactory.createAclfNetwork();
		
		IPSSMsgHub msg= new IPSSMsgHubImpl();
		msg.addMsgListener(new StdoutMsgListener(TextMessage.TYPE_WARN));
		IpssLogger.getLogger().setLevel(Level.WARNING);
		
		AclfNetwork objnet = ConvertIEEEtoInterPSS(net ,"ieee14.ieee",msg);  //ieee30.ieee
		// (List) index for the power-increase load buses 
		
		List<Integer> busL =Arrays.asList(10,11);
		List<Integer> buslist =new ArrayList<Integer>(busL);
		
		// specify the load increase direction 
		 
		Matrix dirp = ones(2,1).times(0.8); // Dimensions should be matched with buslist
		Matrix dirq = ones(2,1).times(0.6);

		callIndexModel(objnet,buslist,dirp,dirq);
	
        //loadflow(msg);
	}
	
	public static  AclfNetwork ConvertIEEEtoInterPSS(AclfNetwork net, String IEEEFile, IPSSMsgHub msg){
		
		// 1. Convert IEEE data format to intermediary XML file
		LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		try{
			IeeeCDFAdapter adapter = null;
			adapter = new IeeeCDFAdapter(logger);
			if (!adapter.parseXmlFile(IEEEFile)) {
				logger.severe("Error: model parsing error, " + adapter.errMessage());
				System.err.println("Error: model parsing error, " + adapter.errMessage());
			}
			// convert the model to a XML document string
			String xmlStr = adapter.getModel().toXmlDoc(true);
			// modify the XML output to validate the result
			String str1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><pss:PSSStudyCase xmlns:pss=\"http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1\" " +
			 "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ";
			String str2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><pss:PSSStudyCase xmlns:pss=\"http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1\" " +
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
			IEEEODMPSSModelParser parser = new IEEEODMPSSModelParser(new File("intermediary.xml"));
			IEEEODMMapper mapper = new IEEEODMMapper();
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
	
	public  static void callIndexModel(AclfNetwork net,List<Integer> buslist,Matrix dir_p,Matrix dir_q ){  
	    /*
	     * 1.call the load_increase_model by  the "buslist" type
	     * 
	     * 2.remember: the dir_p and dir_q here are then passed to dir_g and dir_b respectively
	     * as the p+jq=v^2*(g+jb), the ratio of p to q is the same as that of g to b
	     * and this ratio can be put as a way to express  direction 
	     * 
	     * 3. now this method is only suitable for direction without constP or constQ 
	     * further update will be made
	     */
			
		// be care:  bus buslist =( bus num -1）;
			 IPSSMsgHub msg = new IPSSMsgHubImpl();
	
		// get the total bus number	 
			  int n = buslist.size();
			  print(" n =" + n +"\n");
			  
	    //  initialize  the necessary bus INFO  (bus v ,p q )
			 
			 Matrix  busV= new Matrix(n,1);
			 Matrix  busP= new Matrix(n,1);
			 Matrix  busQ= new Matrix(n,1);
			 Matrix  g= new Matrix(n,1);
			 Matrix  b= new Matrix(n,1);
			 Matrix  g0= new Matrix(n,1);
			 Matrix  b0= new Matrix(n,1);
			 Matrix  dir_g= new Matrix(n,1);
			 Matrix  dir_b= new Matrix(n,1);
			 Matrix  shuntYg =new Matrix(n,1);
			 Matrix  shuntYb =new Matrix(n,1);
			 
			 // pv curve slope by the near two point;
			 //Matrix  oldV =new Matrix(n,1);
			 //Matrix  deltaV =new Matrix(n,1);
			 //Matrix  oldL =new Matrix(n,1);
			// Matrix  deltaL =new Matrix(n,1);
			 Matrix  slope =new Matrix(n,1);
			 Matrix  scant =new Matrix(n,1); // get the scant by the two near piont in PV 
			 
			 //初始化步长
			 double  lambda =1;
	
		     // define tempt variants	 
			 double v=1,v1=1,p=1,q=1,G,B,newq,newp,tan; // tan for slop
			 
			 // define the tolence
			 double tol=0.05;
			 
			 
//……………………………………1 获得初始的负荷导纳……………………………………………………………………
		 for (int idx:buslist) {
               // print(" bus id "+idx+1);
			   AclfBus objbus=(AclfBus) net.getBusList().get(idx);
			   int id = buslist.indexOf(idx);
			 // 1.1.循环搜索 节点电压 arraylist  busV 导纳负荷初值 储存在g0,b0
			   if (objbus.isLoad()){
				   v =objbus.getVoltageMag();
				   p =objbus.getLoadP();
				   q =objbus.getLoadQ();
				  
				   busV.set(id,0,v);
				   busP.set(id,0,p);
				   busQ.set(id,0,q);
				   
				// 负荷功率设为0
				   objbus.setLoadP(0);
				   objbus.setLoadQ(0);
			       
		   //1.2.get the equivalent admittance 
				  Complex shunt =objbus.getShuntY();  // 此处考虑了原有的节点自身带的并联导纳
				  shuntYg.set(id, 0, shunt.getReal()); 
				  shuntYb.set(id, 0, shunt.getImaginary()); 
			      G =p/(v*v);
			      B =-q/(v*v);
			      
			      g0.set(id, 0, G);
			      b0.set(id,0, B);
			  
			      //  equivalence taken effect, the  G+jB should be added to shuntY 
			      G+=shunt.getReal();
			      B+=shunt.getImaginary();
			      
			      objbus.setShuntY(new Complex(G,B));  // 
			      }
				  
			  // 1.3   对不是load bus 的不再后面的负荷等效中考虑
	                  
			   else {
				   print("the bus of buslist"+idx+"is not a loadbus");
                   buslist.remove(id);
			       }
			   
		     }    // end of for-loop 
		   
		    // 1.4P+jQ 形式方向增长转换成G+jB形式
		 
		        // 1.4.1 对常规恒定功率因素，两者是一致的
		        dir_g =dir_p.copy();
		        dir_b =dir_q.copy();
		        // 1.4.2对恒定有功或无功，须特别考虑
		        
		        
//…………………………………… 2 Calculate the critical condition
			 //注意目前暂不考虑存在节点Q或P 为 恒定 情况 
			
			
		int count =0;
		
	 do{
			  // 迭代次数标志
			    count++;
		    	print("    count =  "+count);
			
		      //2.1 由循环增加导纳（此处为恒功率模型）
		
		     // increase load power in the dir_g and dir_b
		       print("   lambda = "+lambda);
		       g =g0.plus(dir_g.times(lambda)); // increase by lambda 
		       b= b0.minus(dir_b.times(lambda));//注意此处的减法运算，为导纳模型的特点
			  
			    for (int id1: buslist){
			    	AclfBus object_bus=(AclfBus) net.getBusList().get(id1);
			    	int id = buslist.indexOf(id1);
			    	G =g.get(id,0)+shuntYg.get(id, 0);
				    B = b.get(id,0)+shuntYb.get(id, 0);  
				    object_bus.setShuntY(new Complex(G,B));
			      }  // end of for-loop
			   
			   //2.2 计算潮流
			      loadflow(net,msg);
			   
		       
			   //2.3.   得到每一次迭代后潮流的结果
			    for (int idx:buslist) {
					   AclfBus objbus=(AclfBus) net.getBusList().get(idx);
					   int id = buslist.indexOf(idx);
					   G =g.get(id,0);
					   B =b.get(id,0);
					   v1 =objbus.getVoltageMag();
						
						newp=G*v1*v1;
						newq=-B*v1*v1;
						
						tan =(v1-v)/(newp-p);  // get the slope, and save it in Matrix slope
						slope.set(id, 0, tan);
						// print("      tan = "+tan);
						scant.set(id, 0, Math.abs(1/tan));  // 以斜率倒数为scant 元素
						 
						if(newp<busP.get(id, 0)||newq<busQ.get(id, 0)){
							
							print("get the critical point");
							print("this step new v="+ v1);
							print("this step new p="+ newp);
							print("last step old v="+ busV.get(id, 0));
							print("last step oldp="+busP.get(id, 0));

							System.exit(1); // get the critical point and exit 
						   }
						
						 busP.set(id, 0, newp);
						 busQ.set(id, 0, newq);
						 busV.set(id, 0,  v1);
						 p =newp;
						 q =newq;
						 v=v1;
					print("bus  "+objbus.getId()+  "  load: p+jq    "+newp+"  +j*"+newq+"\n");
					
		         } // end of this for-loop

			    
	//………………………………3  计算下一步的改进量 …………………………………………
				  
			     // call the min(Matrix a) to the get the largest number ;
			        double delta = min(scant); // scant 为 各负荷节点 V对P的 变化量的倒数最大值（即PV曲线斜率的倒数）
			       print("delta=" +delta);
			       if (delta> 1) delta =1;
			     //  if (lambda<0.5&&lambda >0.1)
			       else if (delta>0.5) delta =0.5;
			       
			       lambda +=delta;
			       
      
			      // 4.判断结束的标志
			      
		      }while (count<15);  // for the while-loop;
		
			
		 }
	


	   private static void print(String s){
		   System.out.println(s);
	   }
	   
	   private static double max(Matrix a){
		   // 
		   int i =0;
		   int j =0;
		   double max =0;
		   if  ( i< a.getRowDimension()){
			   if (j< a.getColumnDimension()){
				   if (a.get(i, j)>max) max=a.get(i, j);
				   
				   j+=1;
				   
			   }
			   i+=1;
		   }
		   return max;
	   } //end of max method
	   
	   
	   private static double min(Matrix a){
		   // 
		   int i =0;
		   int j =0;
		   double min =99999;
		   if  ( i< a.getRowDimension()){
			   if (j< a.getColumnDimension()){
				   if (a.get(i, j)<min) min =a.get(i, j);
				   
				   j+=1;
				   
			   }
			   i+=1;
		   }
		   return min;
	   }  
	   
	   
	    private static Matrix ones(int n,int m ){
	    	  Matrix a =new Matrix (n,m);
			     for (int i= 0;i<n;i++){
					 
					 for (int j= 0;j<m;j++){
						 a.set(i, j, 1);
					   }
			     }
			   return a;
		     }  // end of this method
	    
	   private static void printMatrix(Matrix m){
		   
			 for (int i= 0;i<3;i++){
				 
				 for (int j= 0;j<2;j++){
					 System.out.print(m.get(i, j)+"  ");
				 } 
				 System.out.print("\n");
			 }  // end of for i
		}  // end of printMatrix
	 } // end of newgb
	    
	  
	   
	


