package org.interpss.vstab.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.apache.commons.math.linear.RealVector;
import com.interpss.common.datatype.Matrix_xy;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

public class VstabFuncOut {
	/**
	 * 
	 * @param m
	 * @param width width of column;
	 * @param d the number of digits after the decimal
	 */
   public static void printJmatix(SparseEqnMatrix2x2 m,int width,int d) {
	   double[][] temp=SparseMatrix2Ary(m);
	   StringBuffer sb=new StringBuffer();
	   DecimalFormat format = new DecimalFormat();
	   format.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
	   format.setMinimumIntegerDigits(1);
	   format.setMaximumFractionDigits(d);
	   format.setMinimumFractionDigits(d);
	   sb.append("/n");
	   for(int i=0;i<temp.length;i++) {
		   for(int j=0;j<temp[0].length;j++) {
			   String s=format.format(temp[i][j]);
			   sb.append(s);
			   int padding = Math.max(1,width-s.length()); // At _least_ 1 space
	           for (int k = 0; k < padding; k++) sb.append(" ");
	           
	            
		   }
		   sb.append("/n");
	   }
	   sb.append("/n");
	   System.out.print(sb);
	   


	   
   }
   public static void printRealVector(RealVector v) {
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
