package edu.scut;

import java.io.BufferedOutputStream;
import java.io.IOException;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import org.apache.commons.math.complex.Complex;
import org.interpss.display.AclfOutFunc;
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
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.JacobianMatrixType;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.impl.CustomLoadBusAdapter;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.net.Bus;
import com.interpss.core.sparse.SparseEqnMatrix2x2;


public class ClosestLimit {
	
	public static final String xls4data = "GD_SZ_Orgshunt.xls";//"GD_SZ_Orgshunt.xls" ;SZEQ0924.xls//"psseExample.xls"; //
    public static  int NumofNetBus;
	public static Matrix V4net= new Matrix(NumofNetBus,1);
	static Matrix oldV4net=new Matrix(NumofNetBus,1);

    
	public static void main(String[] args) throws Exception, Throwable {
		//AclfAdjNetwork net =CoreObjectFactory.createAclfAdjNetwork();
		
		IPSSMsgHub msg= new IPSSMsgHubImpl();
		msg.addMsgListener(new StdoutMsgListener(TextMessage.TYPE_WARN));
		IpssLogger.getLogger().setLevel(Level.WARNING);
		AclfNetwork objnet=CoreObjectFactory.createAclfAdjNetwork();
	
		//objnet = Converter.Converter4InterPSS("ieee118.ieee","ieeecdf");  //ieee30.ieee
         
		 //objnet=Converter.Converter4InterPSS("testdata/psse/PSSE_GuideSample.raw", "psse");
		 objnet=Converter.Converter4InterPSS("GD_OrgShunt.raw", "psse");//SZEQ0924_2_3Trans_eq.raw
		// Matrix[] dirpq= LoadIncPatten.IncreaseByZone(Net, "FJ");
		 Matrix[] dirpq;
		 //dirpq= LoadIncPatten.IncreaseSpecLoad(list);
		 /*
		  * LoadIncPatten return DirPQ
		  * DirPQ[0]-->Matrix busList
		  * DirPQ[1]-->Matrix dirP
		  * DirPQ[2]-->Matrix dirQ
		  */
		 int []LoadBusIndex =new int[]{10363};//{10104,10107};//{153,203,205,3005,3007,3008};
//		 int[] zones =new int[]{9};
//		 dirpq= LoadIncPatten.IncreaseByZone(objnet, zones);
//		 dirpq= LoadIncPatten.IncreaseAllNet(objnet);
		 dirpq= LoadIncPatten.IncreaseSpecLoad(LoadBusIndex);
		 Matrix dirp= dirpq[1];
		 Matrix dirq= dirpq[2];
		
		 // get busNumberList 
		 Matrix busNumList =dirpq[0];
		 //List busNum =MyMatrix.Matrix2List(busNumList);
		 List<Integer> buslist=BusNum2Index(objnet,busNumList); // all in Matrix format
		 print(buslist.toString());
		 // run getClosestLimit
		 getClosestLimit( objnet,buslist,dirp,dirq);
        
	}
	

	public  static void getClosestLimit(AclfNetwork net,List<Integer> buslist,Matrix dirP0,Matrix dirQ0 ) throws Exception, Throwable{  
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
			  NumofNetBus =net.getBusList().size();

			  
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
			 double  lambda =0,
			         delta=0,
			         lambdaMin=0,
			         lambdaMax=99; //初始化步长变化量
			 
			// double  DimFactor=1; // 与网络大小相关的，步长控制的因子，在eigMin 决定步长除使用；
		     // define tempt variants	 
			 double v=1,p=1,q=1,G=0,B = 0;//tan; // tan for slop
			 
			 double Length=0;
			 
             double  eigValueMin =0,
                        eigValue =0; // initialize by an enough large number; 
			 // define the tolerance
			 double tolofEigValue=0.001, //1*e-4
			        tolofDir=0.005,
			        tolofLambda=0.001;//*e-4
			 boolean flag4Bisection =false; // flag for critical point, default is false 
		         // change it to true when getting the critical point 
			 boolean flag4NR=false; // false for Beq, true for NR;
			 boolean flag4Beq=true;
			 boolean CustomLoad4AllPQ=false;
			 boolean LFConverged4LastStep=true;
			 final int count4CLimit=10,
	                  count4PVLimit=15; // set the max limit for finding CL ;
			 int findCLtimes =0;  // count for ClosestLimit

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
//			   shunt =objbus.getShuntY();  // 此处考虑了原有的节点自身带的并联导纳
//			   shuntYg.set(id, 0, shunt.getReal()); 
//			   shuntYb.set(id, 0, shunt.getImaginary()); 
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
			 shuntList.add(shunt);
			 LoadQList.add(q);
			 }

		 
		 // get the initial GenP0 
		 
		 id=0;
		 Matrix GenP0=new Matrix(NumofNetBus,1);
		 for (Bus bus:net.getBusList()){
		    	 objbus =(AclfBus) bus;
		    	  if(objbus.isGenPV()||objbus.isGenPQ()){
		    		  p=objbus.getGenP();
		    		  if (p>0) GenP0.set(id, 0, objbus.getGenP());
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
		   //1.3 send the load increase direction to dirP and dirQ;
		   dirP=dirP0.copy();
		   dirQ=dirQ0.copy();
		   print("dirP0");
		   dirP.print(3, 3);
		   print("dirQ0");
		   dirQ.print(3, 3);
		   
	 // ………………………………get the closest limit …………………………………………………………       
        do{	  
		   findCLtimes++;
		   print( "------> findCLtimes= "+findCLtimes);
		 
		  // 每次求PVlimit 需重新初始化增长步长
		   lambda =1;
		   if(findCLtimes<2) lambda=2;
		   delta=0.5;
			
		  // 重置判据
		   eigValueMin=99999; //should be big enough 
		   eigValue=0;
		   lastV=busV0.copy(); // 平启动
		   lambdaMin=0;
		   lambdaMax=99;
			 //重新定义标志：
		   flag4Bisection =false;   // flag for bisection search method ; 
		   LFConverged4LastStep=true;
		   flag4NR=false;
		   flag4Beq=true;

//…………………………………… 2 Calculate the critical condition of a certain direction
		   
		   int count2 =0;
           loop2:// 第2层循环标志
           
        	   do{
					  // 迭代次数标志
					   count2++;
				       print("loop2 count =  "+count2);
				       print("      delta = "+delta);
				       print("     lambda = "+lambda);
					  // 2.1increase load power in the dirP and dirQ   
				       busP =busP0.plus(dirP.times(lambda)); // increase by lambda 
				       busQ= busQ0.plus(dirQ.times(lambda));
				       print("load p");
				       busP.print(3, 3);
				       print("load q");
				       busQ.print(3, 3);
				        
				       deltaP=dirP.times(lambda);
				       sumofPinc =MyMatrix.sumOfElement(deltaP); // sum of increase-power;
				      
				       
		 // 3----------dispatch the load increment to GENs that still have power margin;

//				      net= GenDispatch.GenDispatch(net,GenP0, sumofPinc);
				       
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
							   print("load flow with NR converged ");
							  // print(AclfOutFunc.loadFlowSummary(net));
							}
							else {flag4NR=false; LFConverged4LastStep=false;}
					   }
					        
					   if (flag4NR==false){	
						   print("lf with NR NOT converged ,call LFbyCustomLoad");
						   //LFbyCustomLoad(net,LFConverged4LastStep);
						   LFbyCustomLoad(net,buslist);
						   //LFbyBeq(net,buslist,shuntList,LoadQList);
						   CustomLoad4AllPQ=true;
						   LFConverged4LastStep=net.isLfConverged();
						   print("converged ?"+net.isLfConverged());
						   
						   if(net.isLfConverged())flag4Beq=true;
						   else flag4Beq=false;
				    }
		     
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
					     FileRnW.writeFile(net.net2String(),"testCustomLoad.txt");
				        if(CustomLoad4AllPQ==true){
				            id=0;
				            for(Bus bus:net.getBusList()){
				        	   objbus=(AclfBus)bus;
							   Complex y0=new Complex(shuntYg4net.get(id, 0),shuntYb4net.get(id, 0));
							   objbus.setShuntY(y0);
							   objbus.setLoadQ(LoadQList.get(id));
							   id++;
				            }
				        }
				        else{
					        for(int idx:buslist){
								objbus =(AclfBus) net.getBusList().get(idx);
								id =buslist.indexOf(idx);
								Complex y0=new Complex(shuntYg.get(id, 0),shuntYb.get(id, 0));
								objbus.setShuntY(y0);
								objbus.setLoadQ(busQ.get(id, 0));
								objbus.setLoadP(busP.get(id, 0));
							}
				        }
				       // print("compeleting transforming the Load to " +
				        	//	"normal type for computing Jacobi");
						}

				//……………………………  get jacobi Matrix and eig value………………………………………
					     
					
					 if( flag4Beq==false){
						 eigValue =9999 ;
					     lambdaMax=lambda;
					     lambda=(lambdaMax+lambdaMin)/2;
					     flag4Bisection=true;
					 }
					 
					 else{
						 print("computing Jacobi Matrix after changing Load to Normal Type");
					      SparseEqnMatrix2x2 S = 
							        net.formJMatrix(JacobianMatrixType.FULL_POLAR_COORDINATE, msg);
					      jacobi =ClosestLimit.getJacobiMatrix(net,S,0); //last parameter for return type ;
					                                        // 1 for L sub matrix 
					                                        // the rest for full jacobi matrix 
					      
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
					     print("---->the weakest bus idx="+buslist.get(weakbusIdx));
					     double eigVofL=ClosestLimit.getEigMin(L,1);
					     double minDiagEleofL=MyMatrix.getMinAbs(MyMatrix.getDiag(L));
					     print("eig valut of L ="+eigVofL);
					     print("----->the ABS min element of L ="+minDiagEleofL);
					    //Matrix eigValue =TestALL.getEigValues(jacobi);
					   // MyMatrix.Diag2Excel(eigValue, xls4data+"Jacobi_Diag_output2.xls");
		 //  set eig>0 ,so as to let the lambda less in the next step ;
					   
						if (Math.abs(eigValue)<tolofEigValue) {  //1*e-4 ;
					       print("eig small enough for PV nose");
					       oldP=busP.copy();
				           oldQ=busQ.copy();
					       Length=lambda;
					       Jcr=jacobi.copy(); // update the Jacobi for getting the Left Vector 
 	                      //and new direction once getting the PV limit;
					       break loop2;
						   }
						else if(flag4Bisection==false){ // eigValueMin save the miniment during the iteration ;
                               //eigValue<0&&
							  // save the network load flow result ;
							  // oldP=busP.copy();
					          // oldQ=busQ.copy();
					          // oldV=busV.copy(); // save to initialize the next step Load Admittance Model
					          // Jcr=jacobi.copy();
					           //lambdaMin=lambda;
					           Length=lambda; // save the length from P0 to Pcr; 
					           lambdaMin=lambda;
					           System.out.println("last step eigValueMin ="+eigValueMin+"new eigValueMin ="+eigValue+"\n"+
					        		   "new lambdaMin ="+lambdaMin);
					           // update the eigValueMin
							   eigValueMin=eigValue;
					         // calculate step length for next step…………………………………………
					           if(NumofNetBus<50) {
					        	   if (eigValueMin>-1) delta =2;
					               else if (eigValueMin>-0.5) delta =1;
					               else if (eigValueMin>-0.3) delta =0.5;
					               else if (eigValueMin>-0.1) delta =0.1;
					               else if (eigValueMin>-0.01) delta =0.05;
					               else delta =0.02;  
					           }
					           
					           else if (NumofNetBus<200){
					        	      if (eigValueMin>-0.01)  delta =0.1;
							          else if (eigValueMin>-0.05) delta =0.3;
							          else if (eigValueMin>-0.1) delta =0.5;
							          else if (eigValueMin>-0.5) delta =0.8;
							          else delta =1;
					           }
					          else  {//if(n>100)
					        	      if (eigValueMin>-0.01)  delta =0.5;
					                  else if (eigValueMin>-0.05) delta =0.5;
					                  else if (eigValueMin>-0.1) delta =0.3;
					                 // else if (eigMin>-0.01) delta =0.02;
					                  else delta =0.5;
					           }
					           // increase load by adding delta to  lambda ;
					           lambda +=delta;

					       }
					       else{ //eigValueMin>0 ,have reached to lower part of the PV curve
					    	   if(eigValue<0){ //&&eigValue>eigValueMin//注意此处定义eigValueMin为小于0 ,且不断逼近0；
					    		   System.out.println("old Lambda Min="+lambdaMin+"   new is "+lambda); 
					    		   lambdaMin=lambda;
					    		   eigValueMin=eigValue;
					    	   }
					    	   else {
					    		   System.out.println("old Lambda MAX="+lambdaMax+"new is "+lambda); 
					    		   lambdaMax=lambda; //
					    	   }
					    	   
					    	   lambda=(lambdaMax+lambdaMin)/2;
					    	   Length=lambda;  //update the Length;
					    	 
					    	   flag4Bisection=true;
					    	   System.out.println("<-----using Bisection Search Method---->");
					    	   
					            }
						   oldP=busP.copy();
				    	   oldQ=busQ.copy();
				    	   oldV=busV.copy(); 
				    	   Jcr=jacobi.copy();
				    	 
					    //} //end of if eigValue<tolofEig
					 }// end of else -- flag4PVlimit==true;

					 if ((lambdaMax-lambdaMin)<tolofLambda) {
					     print("lambdaMax="+lambdaMax);
					     print("lambdaMin="+lambdaMin);
					     print("the lamdba is close enough");
					     Length=lambda;
					     Jcr=jacobi.copy(); // update the Jacobi for getting the Left Vector 
	                      //and new direction once getting the PV limit;
					     break loop2;
					  }
	 
			         print("-------------------------------------------------");
			               
	               
		  }while (count2<count4PVLimit);  // loop2-->for getting the PV limit 
		 
	   //………… get PQcr……………… 
		  PQcr.setMatrix(0, n-1,0,0, busP);
		  PQcr.setMatrix(n, 2*n-1,0,0, busQ);
	   //.返回PQcr与 PQ0的距离
		  print("————critical point power ————");
		  PQcr.print(3, 3);
		  print("————critical point Voltage ————");
		  oldV.print(3, 3);
		  print("the Length from PQ0 to PQcr: "+df.format(Length));
	    
		
//………………………………3.  get the next step power increase direction…………………………………………

    
        Matrix norm =getLvector(Jcr);
        //print("Lvector:");  
        //norm.print(3, 3);
		Matrix unitNorm =norm.times(1/norm.normF());
	  //unitNorm.print(unitNorm.getColumnDimension(), 3);
		
		List<Matrix> NewDir =getNewDir(net,unitNorm,buslist); 
		
		Matrix dirP2 = NewDir.get(0);
		Matrix dirQ2 = NewDir.get(1);
		
		// get the direction of this step with pq  as a whole
		dirpq.setMatrix(0, n-1, 0, 0,dirP);
		dirpq.setMatrix(n, 2*n-1, 0, 0,dirQ);
		// 确保一直处于增加状态
		Matrix dirpq2 =NewDir.get(2); // new direction for pq
		Matrix theta = dirpq2.transpose().times(dirpq);
		double  cos =theta.get(0, 0);
		print("cos = "+cos);
		if (cos<0){     // make the new direction to be on the right side .
			dirP2=dirP2.uminus();
			dirQ2=dirQ2.uminus();
			dirpq2=dirpq2.uminus();
		}
		
		
		print("the new dirP");
		dirP2.print(dirP2.getColumnDimension(), 3);
		
		print("the new dirQ");
		dirQ2.print(dirQ2.getColumnDimension(), 3);
	   /*
		print("------new dirP");
		printMatrix(dirP2);
		print("………………old dirP");
		printMatrix(dirP);
		print("------new dirQ");
		printMatrix(dirQ2);
		print("------old dirQ");
		printMatrix(dirQ);
		*/
		// 定义收敛的条件 ：最近两次的增长方向接近程度满足要求
		//以方向差的模来定义
		delta_dir =dirpq2.minus(dirpq);
		
		//DecimalFormat df  = new DecimalFormat("##.0000");
	    // System.out.println("4位小数："+df3.format(sd));
        print("norm of delta_dir=  "+df.format(delta_dir.normF()));
		
	   if(delta_dir.normF()>tolofDir){////(lastL-Length)>tolofLength
		   // pass the new dir
			dirP =dirP2.copy();
			dirQ =dirQ2.copy();


		    oldP =busP0;
			oldQ =busQ0;
			oldV =busV0;
			oldV4net=MyMatrix.ones(NumofNetBus, 1);
			print("get back to normal operation condition");
		 }
	   else {
		   print("got the ClosetLimit having two steps near enough, with —— "+findCLtimes+" ——times");
		   break;
	   }
		print("====================================================================================================");
	 }while(findCLtimes<count4CLimit);//count4CLimit=10
	 
	 print("get the closest limit");
//	 print(AclfOutFunc.loadFlowSummary(net));
	//
	 
	// print("load flow result"+AclfOutFunc.loadFlowSummary(net));
    }
	
	static double getEigMin(Matrix jacobi ,int type){
	/*
	 * notice: 
	 * 1) the eigenvalues are all negetive when it is stable ,
	 *  and the eigMin approaches zero while load increase .
	 * 2) return type : 0 ,abs(eigValueMin)
	 *                  1 ,real eigValueMin
	 *                  2, col corresponding for eigValueMin
	 *  
	 */
	      Matrix Diag  =jacobi.eig().getD();
	     // print("diag col dimension is "+Diag.getColumnDimension());
	      // search the zero eigen value and its index 
	      double eig_Min = Math.abs(Diag.get(0, 0));
	      int col =0;
	      double eig=0;
	      for (int i=1;i<Diag.getColumnDimension();i++){
	    	  if (eig_Min > Math.abs(Diag.get(i, i))) { 
	    	   eig_Min =Math.abs(Diag.get(i, i)); 
	    	   col =i;
	    	   } //end of if
	        } //end of for
	     // print("this step EigMin = "+eig_Min);
	    //  print("the col is "+ col);
	      print("the real min eig value is "+ Diag.get(col, col));
	      if (type==0) eig= eig_Min;
	      else if(type==1)eig= Diag.get(col, col);
	      else if(type==2)eig=col;
	      else print("error: the type must be either 0 , 1 and 2 ");
	      return eig;
	}
	
	
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
	
	
	static Matrix getJacobiMatrix (AclfNetwork net,SparseEqnMatrix2x2 S,int returnType){

		 // get sortIndex
		int[] sortNumberToMatrixIndex = new int[net.getNoBus()+1];
		int[] sortPQNumberToMatrixIndex = new int[net.getNoBus()+1];
		 // get the number of non-swing buses and PQ buses
        int n = 0;  //record  for non-swing ,that is both PV and PQ 
        int m = 0;  // record only for PQ 
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
     Matrix Jnr =new Matrix (n+m,n+m);   // Jacobi matrix in classical format.   
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
	                   
	                    int m1 = sortNumberToMatrixIndex[i];  // get the bus Index in the net 
                        int n1 = sortNumberToMatrixIndex[j];
                   
                         if (!aclfBusi.isGenPV()) { 
                        	// print("pq bus :"+aclfBusi.getId());
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
	   if (returnType==1) return L;
	   else return Jnr.uminus(); // by default return Jnr ;
	   // sparseMatrix 的符号与常见的Jnr相反，为正号。因此此处需变号；
	 
	 }//end this method
	
	
	
	
	 private static Matrix getLvector(Matrix jacobi){
		 
	      Matrix Vector=jacobi.transpose().eig().getV();
	      Matrix Diag  =jacobi.transpose().eig().getD();
	      // search the zero eigen value and its index 
	      double eig_val =Math.abs(Diag.get(0, 0));
	      int col =0;
	      
	      for (int i=1;i<Diag.getColumnDimension();i++){
	    	  if (eig_val >Math.abs(Diag.get(i, i))) {
	    	   eig_val =Math.abs(Diag.get(i, i));
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
	  public static int getWeakestBusIdx(Matrix L,List<Integer>buslist,AclfNetwork net){
		    int index=0;
		  
			//int[] sortIndex = new int[net.getNoBus()+1];
			int[] sortPQIndex = new int[net.getNoBus()+1];
			 // get the number of non-swing buses and PQ buses
	       // int n = 0;  //non-swing
	        int m = 0;  //PQ

	     for (Bus bus : net.getBusList()) {
	         AclfBus aclfBus = (AclfBus)bus;
	             //sortIndex[aclfBus.getSortNumber()] = n++;  // your matrix index range [0 ... n)
	             if (!aclfBus.isGenPV()&&!aclfBus.isSwing()) {
	                 sortPQIndex[aclfBus.getSortNumber()] = m++;  // your matrix index range [0 ... m-1)
	             }
	         
	     }	//end of for
		  int col =MyMatrix.getLMinIdx(L);
	     for(int idx:buslist){  // all buses in buslist are PQ bus.
	    	 int id=buslist.indexOf(idx);
	    	 AclfBus thisbus = (AclfBus) net.getBusList().get(idx);
	    	 if (sortPQIndex[thisbus.getSortNumber()]==col){
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
		              if (!aclfBus.isGenPV()&&!aclfBus.isSwing()) {
		                  sortPQIndex[aclfBus.getSortNumber()] = m++;  // your matrix index range [0 ... m-1)
		              }
		         }
		     }	//end of for
		   //  print("n for PQ & PV="+n);
		   //  print("m for PQ="+m);
		     
		     
		     for(int idx:buslist){  // all buses in buslist are PQ bus.
		    	 int id=buslist.indexOf(idx);
		    	 AclfBus thisbus = (AclfBus) net.getBusList().get(idx);
		    	 int np =sortIndex[thisbus.getSortNumber()];
		    	 
		    	 int nq =sortPQIndex[thisbus.getSortNumber()]+n; // n here is the total bus number
		    	// print("idx="+idx);
		    	// print("is load="+thisbus.isGenPV());
		    	// print("nq="+nq);
		    	 
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
		    private static void LFByStep(AclfNetwork net,IPSSMsgHub msg){
		    	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net,msg);
		    	//algo.setLfMethod(AclfMethod.NR_STEP);
		    	algo.setLfMethod(AclfMethod.NR);
		    	algo.setMaxIterations(1);
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
		    
		 public static void LFbyCustomLoad(AclfNetwork net,List<Integer> buslist){
			 
			 LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
			 algo.setLfMethod(AclfMethod.NR);
			 algo.setNonDivergent(false);
//			 algo.setMaxIterations(1);
////			 algo.setTolerance(0.0001, UnitType.PU, net.getBaseKva()); 
//    		 algo.setInitBusVoltage(true);
//			 algo.loadflow();
			 for (int idx:buslist) {
	               // print(" bus id "+idx+1);
				 AclfBus aclfBus=(AclfBus) net.getBusList().get(idx);
				   if (aclfBus.isConstPLoad()) {
				      // we switch constant P load to custom load implementation
				      aclfBus.setLoadCode(AclfLoadCode.CUSTOM_LOAD);
				      aclfBus.setCustomLoadBus(new CustomLoadBusAdapter() {
				         @Override
				         public double getLoadQ(AclfBus aclfBus) {
				             return 0.0;
				         }

				         @Override
				         public Complex getShuntY(AclfBus aclfBus) {
				            // first we use constP load to get the shuntY
				            aclfBus.setLoadCode(AclfLoadCode.CONST_P);
				            Complex c = aclfBus.getShuntY();
				            // calculate equiv B
				            double v2 = aclfBus.getVoltageMag() * aclfBus.getVoltageMag();
				            double b = aclfBus.getLoadQ() / v2;
				            // add B to the bus shunt Y
				            c = c.add(new Complex(0.0, -b));
				            // change load code to custom load again
				            aclfBus.setLoadCode(AclfLoadCode.CUSTOM_LOAD);
				            return c;
				         }
				      });
				   }
				}

				// then we run custom loadflow again.
				algo.setMaxIterations(30);
				algo.setInitBusVoltage(false);
				//algo.setTolerance(0.001);
				algo.loadflow();
				
		 }
		 public static void LFbyBeq(AclfNetwork net,List<Integer> buslist,List<Complex> shuntList,List<Double> LoadQList) throws IOException{
			 
			 Matrix DV4net;
			 double DeltaV=99;
			// double LastDeltaV=99;
			 double Vmag;
			 double tol =0.003;
			 final double  K=0.6;
			 int MaxIteration=0;
			 IPSSMsgHub msg= new IPSSMsgHubImpl();
			 NumofNetBus=net.getNoBus();
			 V4net=new Matrix(NumofNetBus,1);
			 oldV4net=new Matrix(NumofNetBus,1);
			 LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
			 LoadflowAlgorithm algo2 = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
			 LoadflowAlgorithm algo3 = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
			 algo.setLfMethod(AclfMethod.NR_STEP);
			 algo2.setLfMethod(AclfMethod.PQ_QSTEP);
			 algo3.setLfMethod(AclfMethod.NR);//NR_STEP
			 algo3.setMaxIterations(10);
			// algo.setInitBusVoltage(false);
			 algo.setInitBusVoltage(true);
			 algo.loadflow();
			
			 //initBusVoltage(net);
			// algo3.loadflow();
//			 algo3.setInitBusVoltage(false);
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
				        double b = K*(Double)LoadQList.get(idx) / v2;
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
//			 if (MaxIteration>=3){algo3.loadflow();algo3.loadflow();}
//			 else{
//			 algo.loadflow();
//			 algo2.loadflow();
//			 }
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
//			  algo.setInitBusVoltage(false);
//			  algo.setLfMethod(AclfMethod.NR);
//			  algo.setMaxIterations(20);
//			  algo.loadflow();
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
		public static void Beq(AclfNetwork net,List<Integer> buslist,List<Complex> shuntList,List<Double> LoadQList){
			
			 double DeltaV=99,
			// double LastDeltaV=99;
	                Vmag,
			        v2,
			        delta_b,
			        delta_q,
			        b;
			 double DeltaQ;        
			 double tol =0.003;
			 final double K =0.5;
			 int size=buslist.size();
			 int MaxIteration=0;
			 
			 Matrix DV4net,
			        deltaQ=new Matrix(size,1),
			        calQ=new Matrix(size,1),
			        setQ=new Matrix(size,1),
			        vPQ =new Matrix(size,1),
			         Beq=new Matrix(size,1);
			 IPSSMsgHub msg= new IPSSMsgHubImpl();
			 NumofNetBus=net.getNoBus();
			 
			 V4net=new Matrix(NumofNetBus,1);
			 oldV4net=new Matrix(NumofNetBus,1,1);
			 
			 LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
			 algo.setLfMethod(AclfMethod.NR);//NR_STEP
			 algo.setMaxIterations(2);
			 algo.setInitBusVoltage(false);
			 initBusVoltage(net);
//			 algo3.loadflow();
			 int id =0;
			 for (int idx:buslist) {
	               // print(" bus id "+idx+1);
				 AclfBus aclfBus=(AclfBus) net.getBusList().get(idx);
				   //if (aclfBus.isConstPLoad()) {
				      // we switch constant P load to custom load implementation  
				        Complex c = (Complex) shuntList.get(idx);
				        // calculate equiv B
				        Vmag=oldV4net.get(idx, 0);
				        v2= Vmag * Vmag;
				        print(" v = "+aclfBus.getVoltageMag()+"v2= "+v2);
				        double q=LoadQList.get(idx);
				        setQ.set(id,0, q);
				        b = (Double)LoadQList.get(idx) / v2;
				        Beq.set(id, 0, b);
				        print(" b = "+b);
				        // add B to the bus shunt Y
				        c = c.add(new Complex(0.0, -b));
				        // change load code to custom load again
				        aclfBus.setShuntY(c);
				        aclfBus.setLoadQ(0);
				        id++;
				            
				   }
		 while(MaxIteration<30){
			 algo.loadflow();
			// print("converged?"+net.isLfConverged());
//	         id=0;
//		     for(Bus bus:net.getBusList()){
//		        AclfBus thisbus=(AclfBus) bus;
//		        Vmag=thisbus.getVoltageMag();
//		        V4net.set(id, 0, Vmag);
//		        id++;
//		       }
		     
		     id=0;
			 for (int idx1:buslist) {
	               // print(" bus id "+idx+1);
				 AclfBus aclfBus1=(AclfBus) net.getBusList().get(idx1);
				      // we switch constant P load to custom load implementation  
				        Complex c = aclfBus1.getShuntY();
				        // calculate equiv B
				        Vmag=aclfBus1.getVoltageMag();
				        v2= Vmag * Vmag;
				        print(" v = "+aclfBus1.getVoltageMag()+"v2= "+v2);
				        b=Beq.get(id, 0);
				        double cal_q =v2*b;
				        delta_q=setQ.get(id, 0)-cal_q;
				        deltaQ.set(id, 0, delta_q);
				        
				        delta_b = K*delta_q / v2;  // K is acc Factor ;
				        Beq.set(id, 0, b+delta_b);
				        print(" delta_b = "+delta_b);
				        // add B to the bus shunt Y
				        c = c.add(new Complex(0.0, -delta_b));
				        // change load code to custom load again
				        aclfBus1.setShuntY(c);
				        id++;
				  
			 } 
			 
//		        DV4net=V4net.minus(oldV4net);
//		        //DeltaV=DV4net.normF();
//		        DeltaV=MyMatrix.maxAbs(DV4net);
//		        print("max delta v="+DeltaV);
//		        oldV4net=V4net.copy();
		        DeltaQ=MyMatrix.maxAbs(deltaQ);
		        print("DeltaQ = "+DeltaQ);
			    MaxIteration++;
			    
			 if(DeltaQ<tol){System.out.println("load flow by Beq converged with-- "+MaxIteration +"-- iteration");
			 //DeltaV<tol
			  //System.out.println(net.net2String());
			// System.out.println(AclfOutFunc.lfResultsBusStyle(net));
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
			  //FileRnW.writeFile(net.net2String(), "E:/workspace/test_IEEE118.txt");
			  net.setLfConverged(true);
			  break;
			  } 
			 if(DeltaV>99||(DeltaV>1&&MaxIteration>25)){
				 net.setLfConverged(false); 
				 System.out.println("load flow by Beq not converged");
				 break;
			 }
		 } // end of while
			 	
		}
		 
		public static void LFbyCustomLoad(AclfNetwork net,boolean LFConverged4LastStep){
			 LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
			 //algo.setLfMethod(AclfMethod.NR_STEP);
			 algo.setNonDivergent(false);
			// algo.loadflow();
			// algo.setMaxIterations(2);
			 //algo.setTolerance(0.0001, UnitType.PU, net.getBaseKva()); 
			 //
			 for (Bus bus:net.getBusList()) {
	               // print(" bus id "+idx+1);
				 AclfBus aclfBus=(AclfBus)bus;
				   if (aclfBus.isConstPLoad()) {
				      // we switch constant P load to custom load implementation
				      aclfBus.setLoadCode(AclfLoadCode.CUSTOM_LOAD);
				      aclfBus.setCustomLoadBus(new CustomLoadBusAdapter() {
				         @Override
				         public double getLoadQ(AclfBus aclfBus) {
				             return 0.0;
				         }

				         @Override
				         public Complex getShuntY(AclfBus aclfBus) {
				            // first we use constP load to get the shuntY
				            aclfBus.setLoadCode(AclfLoadCode.CONST_P);
				            Complex c = aclfBus.getShuntY();
				            // calculate equiv B
				            double v2 = aclfBus.getVoltageMag() * aclfBus.getVoltageMag();
				            double b = aclfBus.getLoadQ() / v2;
				            // add B to the bus shunt Y
				            c = c.add(new Complex(0.0, -b));
				            // change load code to custom load again
				            aclfBus.setLoadCode(AclfLoadCode.CUSTOM_LOAD);
				            return c;
				         }
				      });
				   }
				}

				// then we run custom loadflow again.
			    
			    algo.setLfMethod(AclfMethod.NR);
				algo.setMaxIterations(50);
//				if(LFConverged4LastStep==true)algo.setInitBusVoltage(false);
//				else algo.setInitBusVoltage(true);
				algo.setInitBusVoltage(true);
				algo.loadflow();
				System.out.println(" custom load flow  收敛 ?"+net.isLfConverged());
		 }
			 
		 
		 static void initBusVoltage(AclfNetwork net){
			
		        for( Bus b : net.getBusList()) {
		            AclfBus bus = (AclfBus)b;
				      double Vmag=1;
		        	  double Vang=0;
                      if ( bus.isConstPLoad() ) {
		                //PVBusAdapter pv = (PVBusAdapter)bus.getAdapter(PVBusAdapter.class);
		                bus.setVoltage(Vmag,Vang);//pv.getVoltMag(UnitType.PU), 0.0
		            }    

		        }
		 }


	   static void print(String s){
		   System.out.println(s);
	   }
	   public static List<Integer> BusNum2Index(AclfNetwork net ,Matrix MatrixofBusNum){
		   List<Integer> busList = new ArrayList<Integer>();
		   int NumberofloadBus =MatrixofBusNum.getRowDimension();
	       int k=0,count=0;
	       Matrix BusID =getBusID(net);
			for (int i=0;i<NumberofloadBus;i++){
				for(count=k;count<BusID.getRowDimension();count++){
					k++;  // 使得下次搜索时，内部从上次退出的地方开始。 
					      //----这是考虑到节点数据BUS NUMBER 是按顺序存储
					if(BusID.get(count, 0)==MatrixofBusNum.get(i,0)){
					  busList.add(count);
					  break;
				    }
			    }
		 }
			return busList ;
	   }
	   private static Matrix getBusID(AclfNetwork net){
		   int rows =net.getNoBus();
		   String prefix ="Bus";
		   Matrix BusID =new Matrix(rows,1);
		   int i =0;
	       for(Bus bus :net.getBusList()){
	     	      int ID =Integer.parseInt(bus.getId().substring(prefix.length()));
	     	      BusID.set(i, 0, ID);
	     	      i++;
	       }
	       return BusID;
	   }
	
} // end of ClosestLimit 
	    
	  
	   
	


