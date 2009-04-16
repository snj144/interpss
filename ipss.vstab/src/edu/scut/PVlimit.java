package edu.scut;





import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import org.apache.commons.math.complex.Complex;


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


public class PVlimit {
	
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
			
			AclfNetwork objnet = Vstab.ConvertIEEEtoInterPSS(net ,"ieee30.ieee",msg);  //ieee30.ieee
			// (List) index for the power-increase load buses 
			
			List<Integer> busL =Arrays.asList(15,16,17,18,19,20); // need perfect for NO 29,30 bus  
			List<Integer> buslist =new ArrayList<Integer>(busL);
			
			int Numofbus =buslist.size();
			// specify the load increase direction 
			
			
			 
			Matrix dirp = new Matrix(Numofbus,1,1).times(0.8); // Dimensions should be matched with buslist
			Matrix dirq = new Matrix(Numofbus,1,1).times(0.6);
			// Normalization of the direction dirp and dirq
			Matrix dirpq =new Matrix(2*Numofbus,1);
			dirpq.setMatrix(0, Numofbus-1, 0, 0,dirp);
			dirpq.setMatrix(Numofbus, 2*Numofbus-1, 0, 0,dirq);
			dirpq.arrayTimesEquals(new Matrix(2*Numofbus,1,1/dirpq.normF()));
			dirp =dirpq.getMatrix(0, Numofbus-1, 0, 0);
			dirq =dirpq.getMatrix(Numofbus, 2*Numofbus-1, 0, 0);
			
			getPVLimit(objnet,buslist,dirp,dirq);
		
	       
		}
		
		
	
			

		public  static void getPVLimit(AclfNetwork net,List<Integer> buslist,Matrix dir_p,Matrix dir_q ){  
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
				  Vstab.print(" n =" + n +"\n");
				  
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

				 
				 //初始化步长
				 double  lambda =0.3,
				         delta=0.05; //初始化步长变化量
			     // define tempt variants	 
				 double v=1,v1=1,p=1,q=1,G,B,newq,newp,tan; // tan for slop
				 
				 boolean interpolation =false; // 插值
				 boolean flag =false; // flag for critical point, default is false 
			         // change it to true when getting the critical point 

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
					   Vstab.print("the bus of buslist"+idx+"is not a loadbus");
	                   buslist.remove(id);
				       }
				   
			     }    // end of for-loop 
			 Vstab.print("g0");
			 Vstab.printMatrix(g0);
			 
			 
			    // save the normal operation point
			   busP0 =busP.copy();
			   busQ0 =busQ.copy();
			   busV0 =busV.copy();
			   


			int count =0;
		
		    
	        loop1:// 第一层循环标志
	 do{
				  // 迭代次数标志
				    count++;
			    	Vstab.print("    count =  "+count);
			    	
			// 第二层循环 loop2: 
				
			      //2.1 由循环增加导纳（此处为恒功率模型）
			
			     // increase load power in the dir_g and dir_b
			       Vstab.print("   lambda = "+lambda);
			       g =g0.plus (dir_g.times(lambda)); // increase by lambda 
			       b= b0.minus(dir_b.times(lambda));//注意此处的减法运算，为导纳模型的特点
				  
			       Vstab.print("g");
				   Vstab.printMatrix(g);
				   Vstab.print("b");
				   Vstab.printMatrix(b);
				   
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
						   Vstab.print(" id is   "+id+  "  new v"+v1+"  new G"+G);
						   v= oldV.get(id, 0);
						   newp=G*v1*v1; // get the LF result p and q of this step 
						   newq=-B*v1*v1;
							
						   p=oldP.get(id, 0);//p of the last step
						   q=oldQ.get(id, 0);//q of the last step
						   tan =(v1-v)/(newp-p);  // get the slope, and save it in Matrix slope
						   
						   slope.set(id, 0, tan);
							// Vstab.print("      tan = "+tan);
						   scant.set(id, 0, Math.abs(1/tan));  // 以斜率倒数为scant 元素
						   
				  // compare the last two step to see whether we get the critical point or not	   
						   if(newp<p||newq<q){
							    flag =true; // 出现功率减小，说明已经达到或越过PV nose ，则考虑回到前一步，并减小步长（相当于插值）。
							   
							    if (p-newp>tol) {  //确保极限点的精度  ||q-newp>0.001

							         Vstab.print(" bus   "+objbus.getId()+  "  load power less than before:"); 
							         Vstab.print("new p+jq:    "+newp+"  +j*"+newq);
							         Vstab.print("old p+jq:    " +p  +"  +j*"+q);
								     Vstab.print("have to minize the step length ");
								     break; //get out of this for-loop 
							     }// end the inner if
							  else{
								Vstab.print("bus :"+objbus.getName()+" get the critical point first");
								Vstab.print("this step new v="+v1);
								Vstab.print("this step new p="+ newp);
								Vstab.print("this step new q="+ newq);
								Vstab.print("last step old v="+ v);
								Vstab.print("the critical p ="+ p);
								Vstab.print("the critical q ="+ q);
								
								Vstab.print("result:");
								
	                           // printMatrix(oldP);
	                           // printMatrix(oldQ);
	                           // printMatrix(oldV);
								break loop1; // get the critical point and exit loop1 
							    }
					       } //end the outer if
						   
						   busP.set(id, 0, newp);
						   busQ.set(id, 0, newq);
						   busV.set(id, 0,  v1);
							
						Vstab.print("bus  "+objbus.getId()+  "  load: p+jq    "+newp+"  +j*"+newq+"\n");
						
			         } // end of this for-loop
				    
				    if(flag ==false){ // 未达到极限点，保存新的功率和电压
				         oldP=busP.copy();
				         oldQ=busQ.copy();
				         oldV=busV.copy();
				     }
				    
		//………………………………2.3  计算下一步的步长改进量 …………………………………………
					  
				   // call the min(Matrix a) to the get the largest number ;
				   Vstab.print( "and flag is :"+ flag);

				    
				     if(flag ==false&&interpolation==false ){  // 未达到pv nose, 以正常方式确定步长调整量
				        delta = Vstab.min(scant); // scant 为 各负荷节点 V对P的 变化量的倒数最小值（即PV曲线斜率的倒数）
				        Vstab.print("delta=" +delta);
				            if (delta> 1) delta =0.5;
				            else if (delta>0.5) delta =0.1;
				            else delta =0.05;
				        }

				     if (flag==true){   // flag =true  get the PV near-nose 
				    	 
				    	 lambda=lambda-delta;   // the first time get pv nose ,then  back to where higher than the oldP  now in PV curve
				    	 delta =delta/2;// smallest step length;
				    	 if (delta<0.02) delta=0.02;
				    	 interpolation=true;
			            }
				     // update the 
				       lambda +=delta;
				       
				       // 重新检验极限点
		               flag=false;
		               Vstab.print("^……………………………………………………………………");
			
			      }while (count<20);  // for the while-loop;
              Vstab.print("get the pv limit");
	      }
}
