package edu.scut;

import java.io.IOException;


	import java.text.DecimalFormat;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Iterator;
	import java.util.List;
	import java.util.logging.Level;
	import org.apache.commons.math.complex.Complex;
import org.interpss.display.AclfOutFunc;
import org.interpss.display.impl.AclfOut_PSSE.Format;

	import Jama.Matrix;

import com.interpss.common.SpringAppContext;
	import com.interpss.common.datatype.Matrix_xy;
	import com.interpss.common.datatype.UnitType;
	import com.interpss.common.msg.IPSSMsgHub;
	import com.interpss.common.msg.IPSSMsgHubImpl;
	import com.interpss.common.msg.StdoutMsgListener;
	import com.interpss.common.msg.TextMessage;
	import com.interpss.common.util.IpssLogger;
	import com.interpss.core.CoreObjectFactory;
	import com.interpss.core.aclf.AclfBus;
	import com.interpss.core.aclf.JacobianMatrixType;
	import com.interpss.core.aclf.SwingBusAdapter;
	import com.interpss.core.aclf.AclfNetwork;
	import com.interpss.core.algorithm.AclfMethod;
	import com.interpss.core.algorithm.LoadflowAlgorithm;
	import com.interpss.core.net.Bus;
import com.interpss.core.sparse.SparseEqnMatrix2x2;
	
	public class PVlimitv3 {
	 
	    private static void lfByStep(AclfNetwork net,IPSSMsgHub msg){
	    	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net,msg);
	    	//algo.setInitBusVoltage(true); 
	    	
	    	//algo.setTolerance(0.001);//tolerance
	    
	    	//algo.setLfMethod(AclfMethod.NR_STEP);
	    	//algo.loadflow(msg);
	    	algo.setLfMethod(AclfMethod.NR);
	    	algo.setMaxIterations(2);
	    	algo.loadflow();
	    }
		 
	    private static void lfWithNR(AclfNetwork net,IPSSMsgHub msg){
	        /*
	         *create the default loadflow algorithm with NR method
	         */
			LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net,msg);
		    algo.setLfMethod(AclfMethod.NR);
		    algo.loadflow();
			// print(AclfOutFunc.loadFlowSummary(net));
	    }
	    
		public static void main(String[] args) throws IOException {
			//AclfAdjNetwork net =CoreObjectFactory.createAclfAdjNetwork();
			
			IPSSMsgHub msg= new IPSSMsgHubImpl();
			msg.addMsgListener(new StdoutMsgListener(TextMessage.TYPE_WARN));
			IpssLogger.getLogger().setLevel(Level.WARNING);
			AclfNetwork objnet=CoreObjectFactory.createAclfAdjNetwork();
	        objnet = Converter.Converter4InterPSS("GD_OrgShunt.raw", "psse");  //ieee30.ieee   ,testdata/ieeecdf/Ieee14Bus.ieee
	        //"SZEQ0924_2_3Trans_eq.raw", "psse"
	        //"GD_OrgShunt.raw"
	        //"ieee118.ieee","ieeecdf"
	        //"ieee30.ieee"
	        //"009ieee.dat", "ieeecdf"
			//objnet =ieee9_lf.set9busnetwork(msg);
			
			//objnet =  Bus5_FL.set5busnetworkdata( msg);
			
			// (List) index for the power-increase load buses 
			//LimitType qlimt =new LimitType(0.8,-0.2);
			
			
//			List<Integer> buslist =(List<Integer>) new ArrayList<Integer>();
//			for(int id=0;id<objnet.getBusList().size();id++){
//				 AclfBus objbus =(AclfBus) objnet.getBusList().get(id);
//				if(objbus.isLoad()&&!objbus.isGenPV()&&!objbus.isSwing()){
//				buslist.add(id);
//				}
//			}
			
			
			
		    List<Integer> buslist =Arrays.asList(362); // need perfect for NO 29,30 bus  
			
			
			int Numofbus =buslist.size();
			// specify the load increase direction 
			
			 // ---for ieee14
			
			 // 14 double[] Pele={0.863056758,0.98025918,0.996688066,0.978549785,0.830907177,0.87149663,0.840571035,0.889287802,0.967279624,0.918792635,0.948045106};
			 // double[] Qele={0.505106951,0.19771682,-0.081319738,0.206010481,0.556411056,0.490401493,0.541701334,0.457348013,0.253712688,0.39474054,0.318135942}; 
			
			// -----for ieee30
			
			//  double[] Pele={0.863056758,0.894427191,0.978549785,0.98025918,0.902201176,0.707106781,0.945372982,0.830907177,0.968277324,0.956532496,0.889287802,0.840571035,0.96265094,0.941517478,0.95292578,0.842271401,0.894427191,0.792285327,0.83570548,0.936329178,0.984312582};
			//   double[] Qele={0.505106951,0.447213595,0.206010481,0.19771682,0.431315474,0.707106781,0.325990683,0.556411056,0.249878019,0.291625761,0.457348013,0.541701334,0.270745577,0.33696415,0.303203657,0.539053696,0.447213595,0.610150769,0.549177887,0.351123442,0.176433387};
			 
		    // double[] Pele={0.792285327,0.83570548,0.936329178,0.984312582}; // bus24,26,29,30 in ieee30
			 //double[] Qele={0.610150769,0.549177887,0.351123442,0.176433387};
			
			// double[] Pele={} //for ieee009
			// double[] Qele{}	
			   
			Matrix dirp = new Matrix(Numofbus,1);
			Matrix dirq = new Matrix(Numofbus,1);
			dirp = ones(Numofbus,1).times(0.999); // Dimensions should be matched with buslist
			dirq = ones(Numofbus,1).times(0.052);
			//dirp.set(0, 0, 0.7022);
			//dirp.set(1, 0, 0.5415);
			// dirp= new Matrix(Pele,Pele.length);
			// dirq= new Matrix(Qele,Qele.length);
			
			// Normalization of the direction dirp and dirq
			Matrix dirpq =new Matrix(2*Numofbus,1);
			dirpq.setMatrix(0, Numofbus-1, 0, 0,dirp);
			dirpq.setMatrix(Numofbus, 2*Numofbus-1, 0, 0,dirq);
			dirpq.arrayTimesEquals(new Matrix(2*Numofbus,1,1/dirpq.normF()));
			dirp =dirpq.getMatrix(0, Numofbus-1, 0, 0);
			dirq =dirpq.getMatrix(Numofbus, 2*Numofbus-1, 0, 0);
			
			getLimit( objnet,buslist,dirp,dirq);
		
	        //loadflow(msg);
		}
		

		public  static void getLimit(AclfNetwork net,List<Integer> buslist,Matrix dirP0,Matrix dirQ0 ) throws IOException{  
			 /*
		     * 1. buslist: save the to-be-increased buses index 
		     * 
		     * 2. dirp and dirq: are together to define the load increase direction
		     * 
		     * 3. how to work :three loops to get the closestLimit (loop1,2,3)
		     * 
		     * 4. details for three loops:
		     * (1) relation: loop1{ loop2[ loop3 ] }
		     * (2) functions: 
		     *     loop1 --- get closestLimit  
		     *     loop2 --- get PV limit
		     *     loop3 --- "Equivalent Shunt Admittance Model" for power flow near the PV limit
		     * 
		     */
				
			// be care:  bus buslist =( bus num -1）;
				 IPSSMsgHub msg = new IPSSMsgHubImpl();
		
			// get the total bus number	 
				  int n = buslist.size();
				  
		    // get the direction of pq as a whole ;
				  int NumofNetBus =net.getBusList().size();

				  
		    //  initialize  the necessary bus INFO  (bus v ,p q )
				 
				 Matrix  busV= new Matrix(n,1), // for all this class
				     
				        busV0= new Matrix(n,1), 
				        lastV= new Matrix(n,1), // for loop3
				         oldV =new Matrix(n,1), // for loop2
				         busP= new Matrix(n,1),
				         busQ= new Matrix(n,1),
				        busP0= new Matrix(n,1),
				        busQ0= new Matrix(n,1), 
		               deltaP= new Matrix(n,1),
				         oldP= new Matrix(n,1),
				         oldQ= new Matrix(n,1),
				         Pact= new Matrix(n,1),
				         Qact= new Matrix(n,1),
				            b= new Matrix(n,1),
				         lastb=new Matrix(n,1),
				     
				      shuntYg= new Matrix(n,1),
				      shuntYb= new Matrix(n,1),
				      shuntYb4net=new Matrix(NumofNetBus,1),
				      shuntYg4net=new Matrix(NumofNetBus,1),
				         dirP= new Matrix(n,1),
				         dirQ= new Matrix(n,1),
				        dirpq= new Matrix(2*n,1),
				          PQ0= new Matrix(2*n,1), 
					     PQcr= new Matrix(2*n,1),
				    delta_dir= new Matrix(2*n,1),
				       deltaV= new Matrix(n,1),
				     busV4net= new Matrix(NumofNetBus,2),
				        V4net= new Matrix(NumofNetBus,1),
				      oldV4net=new Matrix(NumofNetBus,1),
				        DV4net=new Matrix(NumofNetBus,1),
				        P4net= new Matrix(NumofNetBus,1),
				        Q4net= new Matrix(NumofNetBus,1),
				       PQ4net= new Matrix(NumofNetBus,2),
				      PQ04net= new Matrix(NumofNetBus,2),
				 // initialize jacobi and Jcr (save the critical point condition);
				       jacobi=null,Jcr = null;

				 double  DeltaV=0;
				 double  sumofPinc =0;
				 double  sumofGenP=0,
				         sumofGenP0;
				 


				 
				 //初始化步长
				 double  lambda =2,
				         delta=0,
				         lambdaMin=0,
				         lambdaMax=99; //初始化步长变化量
				 
				// double  DimFactor=1; // 与网络大小相关的，步长控制的因子，在eigMin 决定步长除使用；
			     // define tempt variants	 
				 double v=1,p=1,q=1,G=0,B = 0;//tan; // tan for slop
				 
				 double Length=0;
				 
	             double  eigValueMin =999,
	                        eigValue =0; // initialize by an enough large number; 
				 // define the tolerance
				 double tolofEigValue=0.0001, //1*e-4
				        tolofDir=0.0001,
				        tolofV=0.0005,//1*e-3
				        tolofLambda=0.0001;//*e-4
				 boolean flag4PVlimit =false; // flag for critical point, default is false 
			         // change it to true when getting the critical point 
				 boolean flag4NR=false; // false for Beq, true for NR;
				 boolean flag4Beq=true;
				 boolean CustomLoad4AllPQ=false;
				 boolean LFConverged4LastStep=true;
				 boolean flag4Bisection=false;
				 final int count4CLimit=10,
		                  count4PVLimit=10; // set the max limit for finding CL ;
				 int count =0;  // count for ClosestLimit

				 int id=0;    // id for bus Index
				 AclfBus  objbus=null;
				 Complex shunt =null;
				 List<Complex> shuntList=new ArrayList<Complex>();
				 List<Double> LoadQList=new ArrayList<Double>();
				 // 输出格式控制
			     DecimalFormat df  = new DecimalFormat("#0.000");
			     
				 print(" number of power-increase load bus =" + n +"\n");

	//……………………………………1 获得初始的运行情况……………………………………………………………………
			 for (int idx:buslist) {
	               // print(" bus id "+idx+1);
				   objbus=(AclfBus) net.getBusList().get(idx);
				   id = buslist.indexOf(idx);  
				  // 1.1.循环搜索 节点电压 arraylist  busV 导纳负荷初值 储存在g0,b0
				   v =objbus.getVoltageMag();
				   p =objbus.getLoadP();
				   q =objbus.getLoadQ();
				   busV0.set(id,0,v);
				   busP0.set(id,0,p);
				   busQ0.set(id,0,q);

			    //1.2. get the equivalent admittance 
				   shunt =objbus.getShuntY();  // 此处考虑了原有的节点自身带的并联导纳
				   shuntYg.set(id, 0, shunt.getReal()); 
				   shuntYb.set(id, 0, shunt.getImaginary()); 
		     }
			 
			  // get the p 、q for the whole net
			 id=0;
			
			 for(Bus bus:net.getBusList()){
	        	 objbus=(AclfBus) bus;
	        	 p =objbus.getLoadP();
				 q =objbus.getLoadQ();
				 P4net.set(id, 0, p);
				 Q4net.set(id, 0, q);
				 shunt =objbus.getShuntY(); 
				// shuntYb4net.set(id, 0, shunt.getImaginary()); 
				 //shuntYg4net.set(id, 0, shunt.getReal());
				 shunt =objbus.getShuntY(); 
				 shuntList.add(shunt);
				 LoadQList.add(q);
				 id++;
			 }
			 
			 // get the initial GenP0 
			 
			 id=0;
			 Matrix GenP0=new Matrix(NumofNetBus,1);
			 for (Bus bus:net.getBusList()){
			    	 objbus =(AclfBus) bus;
			    	  if(objbus.isGenPV()||objbus.isGenPQ()){
			    		  double P=objbus.getGenP();
			    		  if (P>0) GenP0.set(id, 0, objbus.getGenP());
			    		  else     GenP0.set(id, 0,0);  // GenP0数组 维数与发电机 母线数目一致
			    		  id++;
			    	  }
			  }
			   // get the sum of GenP0;
		       sumofGenP0=MyMatrix.sumOfElement(GenP0);
		       print("sumofGenP0= "+sumofGenP0);
		     
			   print("loadP0");
			   busP0.print(3, 3);
			   print("loadQ0");
			   busQ0.print(3, 3);
//			   //1.3 send the load increase direction to dirP and dirQ;
			   dirP=dirP0.copy();
			   dirQ=dirQ0.copy();
//			   print("dirP0");
//			   dirP.print(3, 3);
//			   print("dirQ0");
//			   dirQ.print(3, 3);
			   loop:   
			   do{
					  // 迭代次数标志
					   count++;
				       print("loop2 count =  "+count);
				       print("      delta = "+delta);
				       print("     lambda = "+lambda);
					  // 2.1increase load power in the dirP and dirQ   
				       busP =busP0.plus(dirP.times(lambda)); // increase by lambda 
				       busQ= busQ0.plus(dirQ.times(lambda));
				      /*print("load p");
				       busP.print(3, 3);
				       print("load q");
				       busQ.print(3, 3);
				       deltaP=dirP.times(lambda);
				       sumofPinc =MyMatrix.sumOfElement(deltaP); // sum of increase-power;
				       */
				       
		 // 3----------dispatch the load increment to GENs that still have power margin;

				     //  net= GenDispatch.GenDispatch(net,GenP0, sumofPinc);
				       
		 // -------Save the load increasement to the net 
				       
				       Iterator<Integer> it = buslist.iterator();
				        while(it.hasNext()) {
						     int idx=it.next();
						     objbus =(AclfBus) net.getBusList().get(idx);
				    	     id = buslist.indexOf(idx);
				    	     p=busP.get(id, 0);
				    	     q=busQ.get(id, 0);
				    	     objbus.setLoadQ(q);
				    	     objbus.setLoadP(p);
				    	     LoadQList.set(idx, q);
				        }
				        
				      
				        id =0;
				        
				       if(flag4NR==true){
							lfWithNR(net,msg);
						    if(net.isLfConverged()==true){
							   print("lf with NR converged ");
							   flag4NR=false;
							  // print(AclfOutFunc.loadFlowSummary(net));
							}
							else {flag4NR=false; LFConverged4LastStep=false;}
					   }
					        
					   if (flag4NR==false){	
						   print("lf with NR NOT converged ,call LFbyCustomLoad");
//						   ClosestLimit.LFbyCustomLoad(net,LFConverged4LastStep);
						   ClosestLimit.LFbyCustomLoad(net,buslist);
						   //ClosestLimit.Beq(net,buslist,shuntList,LoadQList);
						   //ClosestLimit.LFbyBeq(net,buslist,shuntList,LoadQList);
						   CustomLoad4AllPQ=true;
						   LFConverged4LastStep=net.isLfConverged();
						   print("converged ?"+net.isLfConverged());
						   
						   if(net.isLfConverged())flag4Beq=true;
						   else flag4Beq=false;
				    }
		              //System.out.println(AclfOutFunc.lfResultsBusStyle(net));
//		              System.out.println(AclfOutFunc.loadFlowSummary(net));
		                //System.out.println(net.net2String());
					 if(flag4NR==true||flag4Beq==true){
				     // get the load flow result 
				        for (int idx:buslist) {
							  AclfBus bus=(AclfBus) net.getBusList().get(idx);
							  id = buslist.indexOf(idx);
							  v =bus.getVoltageMag();
							    
		                      busV.set(id, 0, v);  
		                      p=bus.getLoadP();
		                      q=bus.getLoadQ();
		                      //Pact.set(id, 0, p);
		                      //Qact.set(id, 0, q);

					         }
					 }

				        
				        		
					// 2.5 把负荷等效回P+jQ形式，使得网络参数YMatrix与负荷等效前一致,考查当前极限点Jacobi 的情况
						if(flag4NR==false&&flag4Beq==true){

				        if(CustomLoad4AllPQ==true){
				            id=0;
				            for(Bus bus:net.getBusList()){
				        	   objbus=(AclfBus)bus;
							   Complex y0=new Complex(shuntYg4net.get(id, 0),shuntYb4net.get(id, 0));
							   objbus.setShuntY(y0);
							   id++;
				            }
				      
					        for(int idx:buslist){
								objbus =(AclfBus) net.getBusList().get(idx);
								id =buslist.indexOf(idx);
								objbus.setLoadQ(busQ.get(id, 0));	
							}
				       
				            print("<----compeleting transforming the Load to " +
				        		"normal type for computing Jacobi------->");
				           // print(net.net2String());
				        }
					}
					  // print("Pact");
					  //printMatrix(Pact);
				//……………………………  get jacobi Matrix and eig value………………………………………
					     
					
					 if( flag4Beq==false){
						 eigValue =9999 ;
					     lambdaMax=lambda;
					     lambda=(lambdaMax+lambdaMin)/2;
					     flag4Bisection=true;
					 }
					 
					 else{
						 print("computing Jacobi Matrix");
					      SparseEqnMatrix2x2 S = 
							        net.formJMatrix(JacobianMatrixType.FULL_POLAR_COORDINATE, msg);
					      jacobi =ClosestLimit.getJacobiMatrix(net,S,0); //last parameter for return type ;
					                                        // 1 for L sub matrix 
					                                        // the rest for full jacobi matrix 
					      //jacobi.print(3, 3);
					   // MyMatrix.Diag2Excel(jacobi, xls4data+"Jacobi_Diag_output1113.xls");
					   // print("----start writing jacobi to file-----");
					   // MyMatrix.Matrix2File(jacobi, "Jacobi_test_1113.txt");
					   // MyMatrix.Matrix2File(S, "Sparse_Jacobi.txt");
					   // print("----end of writing jacobi to file-----");
					   // break;
			   //     get the minimal eig value————by getEigMin
					     eigValue=ClosestLimit.getEigMin(jacobi,1);  // 0 --abs;1 --real ;2--col ;
					    // if(eigValue<0.1) flag4NR=false;
					     print(" the real jacobi miniment eig value="+eigValue);
					     print("computing L Matrix and its miniment eig value");
					     Matrix L=ClosestLimit.getJacobiMatrix(net,S,1);
					     int weakbusIdx =ClosestLimit.getWeakestBusIdx(L, buslist, net);
					     print("weakbus idx="+buslist.get(weakbusIdx));
					     double eigVofL=ClosestLimit.getEigMin(L,1);
					     double minDiagEleofL=MyMatrix.getMinAbs(MyMatrix.getDiag(L));
					     print("eig valut of L ="+eigVofL);
					     print("real min diag element of L ="+minDiagEleofL);
					    //Matrix eigValue =TestALL.getEigValues(jacobi);
					   // MyMatrix.Diag2Excel(eigValue, xls4data+"Jacobi_Diag_output2.xls");
		 //  set eig>0 ,so as to let the lambda less in the next step ;
					   
						if (Math.abs(eigValue)<tolofEigValue) {  //1*e-4 ;
					       print("eig small enough for PV nose");
					       Length=lambda;
					       break loop;
						   }
						else if(eigValue<0&&flag4Bisection==false){ // eigValueMin save the miniment during the iteration ;

							  // save the network load flow result ;
							   oldP=busP.copy();
					           oldQ=busQ.copy();
					     lastV=oldV=busV.copy(); // save to initialize the next step Load Admittance Model
					           Jcr=jacobi.copy();
					           //lambdaMin=lambda;
					           Length=lambda; // save the length from P0 to Pcr; 
					           lambdaMin=lambda;
					           System.out.println("last step eigValueMin ="+eigValueMin+"lambdaMin ="+lambdaMin);
					           // update the eigValueMin
							   eigValueMin=eigValue;
					         // calculate step length for next step…………………………………………
					           if(NumofNetBus<50) {
					        	   //if (eigValueMin>-1) delta =2;
					                if (eigValueMin>-0.01) delta =0.05;
					               else if (eigValueMin>-0.1) delta =0.1;
					               else if (eigValueMin>-0.5) delta =0.1;
					               //else if (eigValueMin>-0.01) delta =0.05;
					               else delta =0.1;  
					           }
					           
					           else if (NumofNetBus<200){
					        	      if (eigValueMin>-0.01)  delta =0.1;
							          else if (eigValueMin>-0.05) delta =0.3;
							          else if (eigValueMin>-0.1) delta =0.5;
							             else if (eigValueMin>-0.5) delta =0.8;
							          else delta =1;
					           }
					          else  {//if(n>100)
					        	      if (eigValueMin>-0.01)  delta =0.1;
					             else if (eigValueMin>-0.05) delta =0.3;
					             else if (eigValueMin>-0.1) delta =0.8;
					            // else if (eigMin>-0.01) delta =0.02;
					             else delta =1;
					           }
					           // increase load by adding delta to  lambda ;
					           lambda +=delta;

					       }
					       else{ //eigValueMin>0 ,have reached to lower part of the PV curve
					    	   if(eigValue<eigValueMin){
					    		   lambdaMin=lambda;eigValueMin=eigValue;
					    	   }
					    	   else lambdaMax=lambda; //
					    	   lambda=(lambdaMax+lambdaMin)/2;
					    	   
					    	   flag4Bisection=true;
					    	   
					            }
					    //} //end of if eigValue<tolofEig
					 }// end of else -- flag4PVlimit==true;

					 if ((lambdaMax-lambdaMin)<tolofLambda) {
					     print("lambdaMax="+lambdaMax);
					     print("lambdaMin="+lambdaMin);
					     print("the lamdba is close enough");
					     break loop;
					  }
					 
						
					 
			         print("-------------------------------------------------");
			         System.gc();
				  }while (count<count4PVLimit);  // loop2-->for getting the PV limit 
			 
		   //………… get PQcr……………… 
			  PQcr.setMatrix(0, n-1,0,0, oldP);
			  PQcr.setMatrix(n, 2*n-1,0,0, oldQ);
		   //.返回PQcr与 PQ0的距离
			  print("————critical point————");
//			  PQcr.print(3, 3);
			  
			  print("the Length from PQ0 to PQcr: "+df.format(Length));

			  
	}  //-------------end of getLimit-----------------------
		
		
		
		
		/*
		 * 发电机有功分配：(分区域平衡功率增长)
		 * 1. get the gen margin of every generator PGi,and calculate the total PG
		 * 
		 * 2. under the condition now ,get the increment of total net active power PLk , if PLk>PG, 
		 * set every generator to Gmaxi and turn next , else turn to next step directly
		 * 
		  
		 * 3. get the sum GEN and Load of every area ,
		 * PGarea[a] = sum of PGi (i belongs to a) ,
		 * PLarea[a] = sum of PLi (i belongs to a) 
		 * COMPARISION : Carea[a] =PGarea[a]-PLarea[a]
		 * 
		 * 4. if Carea[a]>0, dispatch the load increment PLk in proportion to their GEN margin among 
		 * the GEN in this area , 
		 *  else , make the GENs in araa a to meet their GENmax ,and calculate the power shortage again
		 *  Pdefi=sum of Carea[a](a is only Carea[a]<0) , supply Pdefi by the near area GENs
		 *  
		 *  Pgi =Pgi0+ PLarea * PGi/PG
		 * 
		
		*/
		
		
		private static Matrix getJacobiMatrix (AclfNetwork net,SparseEqnMatrix2x2 S){

			 // get sortIndex
			 int[] sortNumberToMatrixIndex = new int[net.getNoBus()+1];
			 int[] sortPQNumberToMatrixIndex = new int[net.getNoBus()+1];
			 // get the number of non-swing buses and PQ buses
	        int n = 0;  //non-swing
	        int m = 0;  //PQ
	        int mPQ=0,nPQ=0;
	     for (Bus bus : net.getBusList()) {
	         AclfBus aclfBus = (AclfBus)bus;
	         if (!aclfBus.isSwing()) {
	             sortNumberToMatrixIndex[bus.getSortNumber()] = n++;  // your matrix index range [0 ... n-1)
	             if (!aclfBus.isGenPV()) {
	                 sortPQNumberToMatrixIndex[bus.getSortNumber()] = m++;  // PQ submatrix index range [0 ... m-1)
	             
	             }
	         }
	         
	     }
	    // print("n=" +n+"  m="+m +"\n");
	   
	     
	     //initialize of the conventional NR jacobi matrix
	     
	     Matrix H = new Matrix(n,n);
	     Matrix N = new Matrix(n,m);
	     Matrix K = new Matrix(m,n);
	     Matrix L=  new Matrix(m,m);
	     Matrix Jnr =new Matrix (n+m,n+m);
	     
	     
	     //int index=0;  index for Matrix rows 
	       
	   for (Bus busi : net.getBusList()) {
	        AclfBus aclfBusi = (AclfBus)busi;
	        if (!aclfBusi.isSwing()) {
	       	 
	              for (Bus busj : net.getBusList()) {
	                  AclfBus aclfBusj = (AclfBus)busj;
	                  
	                  if (!aclfBusj.isSwing()) {
	         
	                      int i = busi.getSortNumber();
	                      int j = busj.getSortNumber();
	                      Matrix_xy elem = S.getElement(i, j);
	               
	                        
		               // the following variant is chosen like PQ bus, but it is also suitable for PV bus
		                  double dPdVang = elem.xx;
		                  double dPdVmag = elem.xy;
		                  double dQdVang = elem.yx;
		                  double dQdVmag = elem.yy;
		                   
		                    int m1 = sortNumberToMatrixIndex[i];
	                        int n1 = sortNumberToMatrixIndex[j];
	                   
	                         if (!aclfBusi.isGenPV()) { 
	                          mPQ = sortPQNumberToMatrixIndex[i]; // JUST FOR PQ sort 
	                           }
	                         if (!aclfBusj.isGenPV()) {
	                          nPQ = sortPQNumberToMatrixIndex[j]; // JUST FOR PQ sort
	                           }
	                
	                          H.set(m1, n1, dPdVang);// n-1*n-1 ,suitable of PQ & PV bus
	                   
	                         if(!aclfBusj.isGenPV()){
	                            N.set(m1,nPQ,dPdVmag); //n-1*m
	                            } //end of this -if
	                   
	                          // matrix element corresponding to PQ bus 
	                          if(!aclfBusi.isGenPV() ){
	            	             	 K.set(mPQ,n1,dQdVang);  // m*n-1
		                             if(!aclfBusj.isGenPV()){
		                                L.set(mPQ,nPQ,dQdVmag);//m*m
		                               } 
		                        }
	                    }// end of if-busj
	                  
		             }//end of for busj
	             
		        }//end  if-busi
	    
			 }  //end of for busi
	 
		   Jnr.setMatrix(0,n-1,0,n-1,H);
		   Jnr.setMatrix(0,n-1,n,n+m-1,N);
		   Jnr.setMatrix(n,n+m-1,0,n-1,K);
		   Jnr.setMatrix(n,n+m-1,n,n+m-1,L);
		   return Jnr.uminus(); // sparseMatrix 的符号与常见的Jnr相反，为正号。因此此处需变号；
		 
		 }//end this method
		
		
		
		 private static Matrix getLvector(Matrix jacobi){
			 
		      Matrix Vector=jacobi.transpose().eig().getV();
		      Matrix Diag  =jacobi.transpose().eig().getD();
		      // search the zero eigen value and its index 
		      double eig_val = Diag.get(0, 0);
		      int col =0;
		      
		      for (int i=1;i<Diag.getColumnDimension();i++){
		    	  if (eig_val < Diag.get(i, i)) {
		    	   eig_val =Diag.get(i, i);
		    	   col = i;
		    	   } //end of if
		        } //end of for
		      print("eig value min"+eig_val);
		      //print("the col is   "+col);
		  
		      // then find out the corresponding eigen vector leftVector
		      
		      int[]objcol={col}; // set the vector corresponding to zero eigen vector
		      Matrix leftVector =Vector.getMatrix(
		    		  0, Vector.getRowDimension()-1, objcol);
		      return leftVector;
		      
		 }
		  private static int getWeakestBusIdx(int col,List<Integer>buslist,AclfNetwork net){
			  int index=0;
			  
				int[] sortIndex = new int[net.getNoBus()+1];
				int[] sortPQIndex = new int[net.getNoBus()+1];
				 // get the number of non-swing buses and PQ buses
		        int n = 0;  //non-swing
		        int m = 0;  //PQ

		     for (Bus bus : net.getBusList()) {
		         AclfBus aclfBus = (AclfBus)bus;
		             sortIndex[aclfBus.getSortNumber()] = n++;  // your matrix index range [0 ... n)
		             if (!aclfBus.isGenPV()&&!aclfBus.isSwing()) {
		                 sortPQIndex[aclfBus.getSortNumber()] = m++;  // your matrix index range [0 ... m-1)
		             }
		         
		     }	//end of for
			  
		     for(int idx:buslist){  // all buses in buslist are PQ bus.
		    	 int id=buslist.indexOf(idx);
		    	 AclfBus thisbus = (AclfBus) net.getBusList().get(idx);
		    	 if (sortIndex[thisbus.getSortNumber()]==col||sortPQIndex[thisbus.getSortNumber()]+n-1==col){
		    		 index =id;
		    	 }
		     }
		     
			  return index;
		  }
			 
			 private static List<Matrix> getNewDir(AclfNetwork net,Matrix lVector, List<Integer>buslist){
					
					/*
					 * get the new dirP and dirQ for next step
					 * return dirP,dirQ,dirPQ in unit form 
					 */
					int busNum=buslist.size();
					
					// initialize the dirP and dirQ
					Matrix dirP=new Matrix(busNum,1);
					Matrix dirQ=new Matrix(busNum,1);
					Matrix dirpq= new Matrix(2*busNum,1);
					
					// get sortIndex
					int[] sortIndex = new int[net.getNoBus()+1];
					int[] sortPQIndex = new int[net.getNoBus()+1];
					 // get the number of non-swing buses and PQ buses
			        int n = 0;  //non-swing
			        int m = 0;  //PQ

			     for (Bus bus : net.getBusList()) {
			         AclfBus aclfBus = (AclfBus)bus;
			         if (!aclfBus.isSwing()) {
			             sortIndex[aclfBus.getSortNumber()] = n++;  // your matrix index range [0 ... n)
			              if (!aclfBus.isGenPV()) {
			                  sortPQIndex[aclfBus.getSortNumber()] = m++;  // your matrix index range [0 ... m-1)
			              }
			         }
			     }	//end of for
			    // print("n for PQ & PV="+n);
			     //print("m for PQ="+m);
			     
			     
			     for(int idx:buslist){  // all buses in buslist are PQ bus.
			    	 int id=buslist.indexOf(idx);
			    	 AclfBus thisbus = (AclfBus) net.getBusList().get(idx);
			    	 int np =sortIndex[thisbus.getSortNumber()];
			    	 int nq =sortPQIndex[thisbus.getSortNumber()]+n; // n here is the total bus number
			    	
			    	// print("idx="+idx);
			    	 //print("np="+np);
			    	 //print("nq="+nq);
			    	 
			    	 double p_dir =lVector.get(np, 0);
			    	 double q_dir =lVector.get(nq, 0);
			    	 
			    	 dirP.set(id, 0, p_dir);
			    	 dirQ.set(id, 0, q_dir);
			    	 
			      }// end of for
			     
			     dirpq.setMatrix(0, busNum-1, 0, 0,dirP);
			     dirpq.setMatrix(busNum, 2*busNum-1, 0, 0, dirQ);
			     
			     dirpq =dirpq.times(1/dirpq.normF());
			     
			     dirP =dirpq.getMatrix(0, busNum-1, 0, 0);
			     dirQ =dirpq.getMatrix(busNum, 2*busNum-1, 0, 0);
			     
			     List<Matrix> newdir = Arrays.asList(dirP,dirQ,dirpq);
			     
				 return newdir;	
					
			} //end this getNewDir method 
			 public static void LFbyBeq(AclfNetwork net,List<Integer> buslist,List<Complex> shuntList,List<Double> LoadQList) throws IOException{
				 
				 Matrix DV4net;
				 double DeltaV=99;
				// double LastDeltaV=99;
				 double Vmag;
				 double tol =0.003;
				 int MaxIteration=0;
				 IPSSMsgHub msg= new IPSSMsgHubImpl();
				 int NumofNetBus=net.getNoBus();
				 Matrix V4net=new Matrix(NumofNetBus,1);
				 Matrix oldV4net=new Matrix(NumofNetBus,1);
				 LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
				 LoadflowAlgorithm algo2 = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
				 LoadflowAlgorithm algo3 = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
				 algo.setLfMethod(AclfMethod.PQ_PSTEP);
				 algo2.setLfMethod(AclfMethod.PQ_QSTEP);
				 algo3.setLfMethod(AclfMethod.NR);//NR_STEP
				 algo3.setMaxIterations(20);
				// algo.setInitBusVoltage(false);
				// algo.loadflow();
				 algo3.setInitBusVoltage(true);
				 ClosestLimit.initBusVoltage(net);
//				 algo3.loadflow();
//				 algo3.setInitBusVoltage(false);
				 //print("load flow misMatch="+algo.getLfMethod().);
				 
			 while(MaxIteration<30){
				 //LastDeltaV=DeltaV;
				// algo.setMaxIterations(1);
				// algo.setInitBusVoltage(false);
				 //algo.setTolerance(0.00001, UnitType.PU, net.getBaseKva()); 

				 for (int idx:buslist) {
		               // print(" bus id "+idx+1);
					 AclfBus aclfBus=(AclfBus) net.getBusList().get(idx);
					   if (aclfBus.isConstPLoad()) {
					      // we switch constant P load to custom load implementation  
					        Complex c = (Complex) shuntList.get(idx);
					        // calculate equiv B
					        
					        double v2 = aclfBus.getVoltageMag() * aclfBus.getVoltageMag();
					        print(" v = "+aclfBus.getVoltageMag()+"v2= "+v2);
					        double b = (Double)LoadQList.get(idx) / v2;
					        print(" b = "+b);
					        // add B to the bus shunt Y
					        c = c.add(new Complex(0.0, -b));
					        // change load code to custom load again
					        aclfBus.setShuntY(c);
					        aclfBus.setLoadQ(0);
					            
					   }
					   
				 } 

				 //algo.loadflow();
				 //algo2.loadflow();
				 //algo2.loadflow();
//				 if (MaxIteration>=3){algo3.loadflow();algo3.loadflow();}
//				 else{
//				 algo.loadflow();
//				 algo2.loadflow();
//				 }
				 algo3.loadflow();
				 print("converged?"+net.isLfConverged());
		          int id=0;
			      for(Bus bus:net.getBusList()){
			        AclfBus thisbus=(AclfBus) bus;
			        Vmag=thisbus.getVoltageMag();
			        
			        V4net.set(id, 0, Vmag);
			        id++;
			       }
			        DV4net=V4net.minus(oldV4net);
			        //DeltaV=DV4net.normF();
			        DeltaV=MyMatrix.maxAbs(DV4net);
			        print("max delta v="+DeltaV);
			        oldV4net=V4net.copy();
				    MaxIteration++;
				    
				 if(DeltaV<tol){System.out.println("load flow by Beq converged with-- "+MaxIteration +"-- iteration");
				 //DeltaV<tol
				  //System.out.println(net.net2String());
				// System.out.println(AclfOutFunc.lfResultsBusStyle(net));
//				  algo.setInitBusVoltage(false);
//				  algo.setLfMethod(AclfMethod.NR);
//				  algo.setMaxIterations(20);
//				  algo.loadflow();
				  System.out.println("------->load flow after Beq converged<----------");
				  print("computing Jacobi Matrix");                                                   
				  SparseEqnMatrix2x2 S =                                                           
					        net.formJMatrix(JacobianMatrixType.FULL_POLAR_COORDINATE, msg);            
				  Matrix jacobi =ClosestLimit.getJacobiMatrix(net,S,0);  
				 // jacobi.print(3,3);
				  double  eigValue=ClosestLimit.getEigMin(jacobi,1);  // 0 --abs;1 --real ;2--col ;         
				  print(" the Beq jacobi miniment eig value="+eigValue);                           

				  //System.out.println(net.net2String());
				  //System.out.println(AclfOutFunc.lfResultsBusStyle(net));
				  FileRnW.writeFile(net.net2String(), "E:/workspace/test_IEEE118.txt");
				  net.setLfConverged(true);
				  break;
				  } 
				 if(DeltaV>99||(DeltaV>1&&MaxIteration>25)){
					 net.setLfConverged(false); 
					 System.out.println("load flow by Beq not converged");
					 break;
				 }
				 
			   } 
			 
			 }
			 private static void initBusVoltage(AclfNetwork net,Matrix busV4net){
				    int id=0;
			        for( Bus b : net.getBusList()) {
			            AclfBus bus = (AclfBus)b;
					      double Vmag=busV4net.get(id, 0);
			        	  double Vang=busV4net.get(id, 1);
			            
			            if ( bus.isSwing() ) {
			                SwingBusAdapter swing = (SwingBusAdapter)bus.getAdapter(SwingBusAdapter.class);
			                bus.setVoltage( swing.getVoltMag(UnitType.PU), swing.getVoltAng(UnitType.Rad) );
			            }    
			            else if ( bus.isGenPV() ) {
			                //PVBusAdapter pv = (PVBusAdapter)bus.getAdapter(PVBusAdapter.class);
			                bus.setVoltage(Vmag,Vang);//pv.getVoltMag(UnitType.PU), 0.0
			            }    
			            else
			                bus.setVoltage(Vmag,Vang );// 1.0, 0.0
			            id++;
			        }
			 }


		   static void print(String s){
			   System.out.println(s);
		   }
		   
		   
		   
		    static double maxAbs(Matrix a){
			   // 

			  double max =0;
			  for  (int i =0; i< a.getRowDimension();i++){
				   for (int j =0;j< a.getColumnDimension();j++){
					   if (Math.abs(a.get(i, j))>max) max=Math.abs(a.get(i, j));
				    }
			  }
			   return max;
		   } //end of max method
		   
		   
		   static double min(Matrix a){
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
		  
		 private static double sumOfElement(Matrix m){
			 double sum=0;
			    for (int i= 0;i<m.getRowDimension();i++){
					 
					 for (int j= 0;j<m.getColumnDimension();j++){
						 sum+=m.get(i, j);
					   }
			     }
			 return sum;
		 }
		   
		 private  static Matrix ones(int n,int m ){
		    	  Matrix a =new Matrix (n,m);
				     for (int i= 0;i<n;i++){
						 
						 for (int j= 0;j<m;j++){
							 a.set(i, j, 1);
						   }
				     }
				   return a;
			     }  // end of this method
		    
		   static void printMatrix(Matrix m){
			   
				 for (int i= 0;i<m.getRowDimension();i++){
					 
					 for (int j= 0;j<m.getColumnDimension();j++){
						 System.out.print(m.get(i, j)+"  ");
					 } 
					 System.out.print("\n");
				 }  // end of for i
			}  // end of printMatrix
  } // end of PVlimit2
		    


