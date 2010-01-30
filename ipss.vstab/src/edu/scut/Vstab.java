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

import Jama.Matrix;

public class Vstab {
  
   public static void loadflow(AclfNetwork net,IPSSMsgHub msg){
 
		// create the default loadflow algorithm
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		// use the loadflow algorithm to perform loadflow calculation
		algo.loadflow(msg);
	   // System.out.println(AclfOutFunc.loadFlowSummary(net));
   }
   
	 
	public static void main(String[] args) {
		AclfNetwork net =CoreObjectFactory.createAclfNetwork();
		
		IPSSMsgHub msg= new IPSSMsgHubImpl();
		msg.addMsgListener(new StdoutMsgListener(TextMessage.TYPE_WARN));
		IpssLogger.getLogger().setLevel(Level.WARNING);
		
		AclfNetwork objnet = ConvertIEEEtoInterPSS(net ,"ieee30.ieee",msg);  //ieee30.ieee
		// (List) index for the power-increase load buses 
		
		List<Integer> busL =Arrays.asList(15,16,17,18,19,20,28,29);
		List<Integer> buslist =new ArrayList<Integer>(busL);
		
		int Numofbus =buslist.size();
		// specify the load increase direction 
		
		
		 
		Matrix dirp = ones(Numofbus,1).times(0.8); // Dimensions should be matched with buslist
		Matrix dirq = ones(Numofbus,1).times(0.6);
		Matrix dirpq =new Matrix(2*Numofbus,1);
		dirpq.setMatrix(0, Numofbus-1, 0, 0,dirp);
		dirpq.setMatrix(Numofbus, 2*Numofbus-1, 0, 0,dirq);
		dirpq.arrayTimesEquals(new Matrix(2*Numofbus,1,1/dirpq.normF()));
		dirp =dirpq.getMatrix(0, Numofbus-1, 0, 0);
		dirq =dirpq.getMatrix(Numofbus, 2*Numofbus-1, 0, 0);

		getLimit(objnet,buslist,dirp,dirq);
	
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
	
	public  static void getLimit(AclfNetwork net,List<Integer> buslist,Matrix dir_p,Matrix dir_q ){  
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
			 
			 Matrix  busV= new Matrix(n,1),
			         busP= new Matrix(n,1),
			         busQ= new Matrix(n,1),
			        busP0= new Matrix(n,1),
			        busQ0= new Matrix(n,1),
			         oldP= new Matrix(n,1),
			         oldQ= new Matrix(n,1),
			            g= new Matrix(n,1),
			            b= new Matrix(n,1),
			           g0= new Matrix(n,1),
			           b0= new Matrix(n,1),
			        dir_g= new Matrix(n,1),
			        dir_b= new Matrix(n,1),
			      shuntYg= new Matrix(n,1),
			      shuntYb= new Matrix(n,1);
			 
			 // pv curve slope by the near two point;
			 Matrix  oldV =new Matrix(n,1);
			 Matrix  busV0 =new Matrix(n,1);
			 //Matrix  deltaV =new Matrix(n,1);
			
			// Matrix  deltaL =new Matrix(n,1);
			 Matrix  slope =new Matrix(n,1);
			 Matrix  scant =new Matrix(n,1); // get the scant by the two near piont in PV 
			 
			// boolean flag =false; // flag for critical point, default is false 
			                      // change it to true when getting the critical point 
			 // define the tolerance
			 double tol=0.001; //e-3
			 Matrix delta_dir =new Matrix(n,1); 
			 
			 //初始化步长
			 double  lambda =0.5,
			         delta=0.1; //初始化步长变化量
		     // define tempt variants	 
			 double v=1,v1=1,p=1,q=1,G,B,newq,newp,tan; // tan for slop
			 
			 boolean interpolation =false; // 插值
			 boolean flag =false; // flag for critical point, default is false 
		         // change it to true when getting the critical point 
			  
			 double findCLtimes =0;
			 
			

			 
			   // 0. 初始化负荷增长方向 ， P+jQ 形式方向增长转换成G+jB形式
			 
		        // 0. 对常规恒定功率因素，两者是一致的
		 
		        dir_g =dir_p.copy();
		        dir_b =dir_q.copy();
		        
		        // 1.4.2对恒定有功或无功，须特别考虑
		        
			 

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
				   
				// 负荷功率需重置为0
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
		 print("g0");
		 printMatrix(g0);
		 
		 
		    // save the normal operation point
		   busP0 =busP.copy();
		   busQ0 =busQ.copy();
		   busV0 =busV.copy();
		   
	 // ………………………………get the closest limit …………………………………………………………       
   do{	  
		   	 findCLtimes++;
		   	print( "………………findCLtimes"+findCLtimes);
		      	   
		 

//…………………………………… 2 Calculate the critical condition of a certain direction
			 //注意目前暂不考虑存在节点Q或P 为 恒定 情况 

		int count =0;
	
	    
        loop1:// 第一层循环标志
 do{
			  // 迭代次数标志
			    count++;
		    	print("    count =  "+count);
		    	
		// 第二层循环 loop2: 
			
		      //2.1 由循环增加导纳（此处为恒功率模型）
		
		     // increase load power in the dir_g and dir_b
		       print("   lambda = "+lambda);
		       g =g0.plus (dir_g.times(lambda)); // increase by lambda 
		       b= b0.minus(dir_b.times(lambda));//注意此处的减法运算，为导纳模型的特点
			  
		       print("g");
			   printMatrix(g);
			   
			    for (int id1: buslist){
			    	AclfBus object_bus=(AclfBus) net.getBusList().get(id1);
			    	int id = buslist.indexOf(id1);
			    	G = g.get(id,0)+shuntYg.get(id, 0);
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
					   print(" id is   "+id+  "  new v"+v1);
					   v= oldV.get(id, 0);
					   newp=G*v1*v1; // get the LF result p and q of this step 
					   newq=-B*v1*v1;
						
					   p=oldP.get(id, 0);//p of the last step
					   q=oldQ.get(id, 0);//q of the last step
					   tan =(v1-v)/(newp-p);  // get the slope, and save it in Matrix slope
					   
					   slope.set(id, 0, tan);
						// print("      tan = "+tan);
					   scant.set(id, 0, Math.abs(1/tan));  // 以斜率倒数为scant 元素
					   
			  // compare the last two step to see whether we get the critical point or not	   
					   if(newp<p||newq<q){
						    flag =true; // 出现功率减小，说明已经达到或越过PV nose ，则考虑回到前一步，并减小步长（相当于插值）。
						   
						    if (p-newp>0.001) {  //确保极限点的精度  ||q-newp>0.001

						         print(" bus   "+objbus.getId()+  "  load power less than before:"); 
						         print("new p+jq:    "+newp+"  +j*"+newq);
						         print("old p+jq:    " +p  +"  +j*"+q);
							     print("have to minize the step length ");
							     break; //get out of this for-loop 
						     }// end the inner if
						  else{
							print("bus :"+objbus.getName()+" get the critical point first");
							print("this step new v="+v1);
							print("this step new p="+ newp);
							print("this step new q="+ newq);
							print("last step old v="+ v);
							print("the critical p ="+ p);
							print("the critical q ="+ q);
							
							print("result:");
							
                           // printMatrix(oldP);
                           // printMatrix(oldQ);
                           // printMatrix(oldV);
							break loop1; // get the critical point and exit loop1 
						    }
				       } //end the outer if
					   
					   busP.set(id, 0, newp);
					   busQ.set(id, 0, newq);
					   busV.set(id, 0,  v1);
						
					print("bus  "+objbus.getId()+  "  load: p+jq    "+newp+"  +j*"+newq+"\n");
					
		         } // end of this for-loop
			    
			    if(flag ==false){ // 未达到极限点，保存新的功率和电压
			         oldP=busP.copy();
			         oldQ=busQ.copy();
			         oldV=busV.copy();
			     }
			    
	//………………………………2.3  计算下一步的步长改进量 …………………………………………
				  
			   // call the min(Matrix a) to the get the largest number ;
			   print( "and flag is :"+ flag);

			    
			     if(flag ==false&&interpolation==false ){  // 未达到pv nose, 以正常方式确定步长调整量
			        delta = min(scant); // scant 为 各负荷节点 V对P的 变化量的倒数最小值（即PV曲线斜率的倒数）
			        print("delta=" +delta);
			            if (delta> 1) delta =0.5;
			   
			            else if (delta>0.5) delta =0.1;
			            else delta =0.05;
			        }

			     if (flag==true){   // flag =true  get the PV near-nose 
			    	 
			    	 lambda=lambda-delta;   // the first time get pv nose ,then  back to where higher than the oldP  now in PV curve
			    	 delta =delta/2;// smallest step length;
			    	 interpolation=true;
		            }
			     // update the 
			       lambda +=delta;
			       
			       // 重新检验极限点
	               flag=false;
	               print("^……………………………………………………………………");
		
		      }while (count<20);  // for the while-loop;
		
		
		
		//返回Pcr与 P0的距离
		 double Length = oldP.minus(busP0).normF();
		print("the Length from P0 to Pcr: "+Length);
		
   // 2.5 把负荷等效回P+jQ形式，使得网络参数YMatrix与负荷等效前一致,考查当前极限点Jacobi 的情况
		
		for(int idx:buslist){
			AclfBus objbus =(AclfBus) net.getBusList().get(idx);
			int id =buslist.indexOf(idx);
			Complex y0=new Complex(shuntYg.get(id, 0),shuntYb.get(id, 0));
			objbus.setShuntY(y0);
			objbus.setLoadP(oldP.get(id, 0));
			objbus.setLoadQ(oldQ.get(id, 0));
			
		}
		
//………………………………3.  get the next step power increase direction…………………………………………
	    SparseEqnMatrix2x2 S = 
			        net.formJMatrix(JacobianMatrixType.FULL_POLAR_COORDINATE, msg);
	     Matrix jacobi =Sparse2Matrix(net,S);
	     
      //printMatrix(jacobi);
      // jacobi.print(jacobi.getColumnDimension(), 3);
      //jacobi.print(java.text.NumberFormat.INTEGER_FIELD, 4);
    
        Matrix norm =getLvector(jacobi);
        print("Lvector:");  
        norm.print(norm.getColumnDimension(), 3);
		Matrix unitNorm =norm.times(1/norm.normF());
	  //unitNorm.print(unitNorm.getColumnDimension(), 3);
		
		List<Matrix> NewDir =getNewDir(net,unitNorm,buslist); 
		
		dir_p =NewDir.get(0);
		dir_q =NewDir.get(1);
		
		if (dir_p.get(0, 0)<0){           // 确保一直处于增加状态
			dir_p =dir_p.uminus();
		}
		
		if(dir_q.get(0, 0)<0){
			dir_q =dir_q.uminus();
		}
		
		//print("the new dir_p");
		//printMatrix(dir_p);
		
		//print("the new dir_q");
		//printMatrix(dir_q);
		
		// 重新从busP0 、busQ0 状态开始负荷增长
		for(int idx:buslist){
			AclfBus objbus =(AclfBus) net.getBusList().get(idx);
			int id =buslist.indexOf(idx);
			objbus.setLoadP(busP0.get(id, 0));
			objbus.setLoadQ(busQ0.get(id, 0));
			
		}
	
		
		// 定义收敛的条件 ：最近两次的增长方向接近程度满足要求
		//以方向差的模来定义
		
		 // pass the new dir
		dir_g =dir_p.copy();
		dir_b =dir_q.copy();
		
		
		print("new dir_g");
		printMatrix(dir_p);
		print("dir_g");
		printMatrix(dir_g);
		delta_dir =dir_p.minus(dir_g);
		print("norm of delta_p"+delta_dir.normF());
		 

	   if(delta_dir.normF()>tol){
	
			oldP =busP0;
			oldQ =busQ0;
			oldV =busV0;
				
			 // 重新初始化增长步长
			 lambda =0.5;
			 //重新定义标志：
			 flag =false;
			 interpolation =false;
			print("change back to normal operation condition");
		 }
		 
	 }while(delta_dir.normF()>tol);//findCLtimes<10
	 
	 print("get the closest limit");
	 
		
    }
	
	/*
	private static void Back2PQtype(AclfNetwork net,List<Integer>buslist){
		
		
		for(int idx:buslist){
			AclfBus objbus =(AclfBus) net.getBusList().get(idx);
			int id =buslist.indexOf(idx);
			Complex y0=new Complex(shuntYg.get(id, 0),shuntYb.get(id, 0));
			objbus.setShuntY(y0);
			objbus.setLoadP(oldP.get(id, 0));
			objbus.setLoadQ(oldQ.get(id, 0));
			
		}
		
		
	}
	*/
	
	
	private static Matrix Sparse2Matrix (AclfNetwork net,SparseEqnMatrix2x2 S){

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
	   return Jnr;
	 
	 }//end this method
	
	
	
	 private static Matrix getLvector(Matrix jacobi){
		 
	      Matrix Vector=jacobi.eig().getV();
	      Matrix Diag  =jacobi.eig().getD();
	      // search the zero eigen value and its index 
	      double eig_val =Math.abs( Diag.get(0, 0));
	      int col =0;
	      
	      for (int i=1;i<Diag.getColumnDimension();i++){
	    	  if (eig_val > Math.abs(Diag.get(i, i)) ){
	    	   eig_val =Math.abs(Diag.get(i, i));
	    	   col = i;
	    	   } //end of if
	        } //end of for
	      print("eig value min"+eig_val);
	      // then find out the corresponding eigen vector leftVector
	      
	      int[]objcol={col}; // set the vector corresponding to zero eigen vector
	      Matrix leftVector =Vector.getMatrix(
	    		  0, Vector.getRowDimension()-1, objcol).uminus();
	      return leftVector;
	      
	 }
	
		 
		 private static List<Matrix> getNewDir(AclfNetwork net,Matrix lVector, List<Integer>buslist){
				
				/*
				 * get the new dirP and dirQ for next step
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
		        int mPQ=0,nPQ=0;
		     for (Bus bus : net.getBusList()) {
		         AclfBus aclfBus = (AclfBus)bus;
		             sortIndex[aclfBus.getSortNumber()] = n++;  // your matrix index range [0 ... n)
		             if (!aclfBus.isGenPV()&&!aclfBus.isSwing()) {
		                 sortPQIndex[aclfBus.getSortNumber()] = m++;  // your matrix index range [0 ... m-1)
		             }
		         
		     }	//end of for
				
		    
		     for(int idx:buslist){
		    	 int id=buslist.indexOf(idx);
		    	 AclfBus thisbus = (AclfBus) net.getBusList().get(idx);
		    	 int np =sortIndex[thisbus.getSortNumber()];
		    	 int nq =sortPQIndex[thisbus.getSortNumber()]+n-1; // n here is the total bus number
		    	 
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
		     
		     List<Matrix> newdir = Arrays.asList(dirP,dirQ);
			 return newdir;	
				
		} //end this getNewDir method 
		 


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
	   
	   
	 private  static Matrix ones(int n,int m ){
	    	  Matrix a =new Matrix (n,m);
			     for (int i= 0;i<n;i++){
					 
					 for (int j= 0;j<m;j++){
						 a.set(i, j, 1);
					   }
			     }
			   return a;
		     }  // end of this method
	    
	   private static void printMatrix(Matrix m){
		   
			 for (int i= 0;i<m.getRowDimension();i++){
				 
				 for (int j= 0;j<m.getColumnDimension();j++){
					 System.out.print(m.get(i, j)+"  ");
				 } 
				 System.out.print("\n");
			 }  // end of for i
		}  // end of printMatrix
	 } // end of newgb
	    
	  
	   
	


