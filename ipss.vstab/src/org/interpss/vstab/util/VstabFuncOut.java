package org.interpss.vstab.util;

import org.apache.commons.math.linear.RealVector;

import Jama.Matrix;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

public class VstabFuncOut {
	
   public static void printJmatix(SparseEqnMatrix2x2 m) {
	   Matrix a=new Matrix(SparseMatrix2Ary(m));
	   a.print(2, 3);
	   
   }public static void printRealVector(RealVector v) {
	   String s="";
	   for(double elem:v.toArray()) {
		   s=s+elem+"/n";
	   }
	   System.out.print(s);
   }
   
   public static double[][] SparseMatrix2Ary(SparseEqnMatrix2x2 m){
	   System.out.println("Demension:"+m.getDimension());
	   double[][] mAry=new double[m.getDimension()][m.getDimension()];
	   for(int i=0;i<m.getDimension()/2;i++) {
		   for(int j=0;j<m.getDimension()/2;j++) {
			   Matrix_xy mxy=m.getElement(i, j);
			   mAry[2 * i - 1][2 * j - 1]=mxy.xx;
			   mAry[2 * i - 1][2 * j]=mxy.xy;
			   mAry[2 * i ][2 * j-1]=mxy.yx;
			   mAry[2 * i ][2 * j]=mxy.yy;
		   }
	   }
	   return mAry;
	   
   }
}
