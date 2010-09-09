package org.interpss.vstab;

import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.RealMatrix;
import org.interpss.vstab.core.MatrixCalc;
public class Test {

	/**
	 * @param args
	 */
//	class worm{
//		private worm next;
//		private char c;
//		public worm(int i,char x){
//			System.out.println("Worm constructor :"+ i);
//			c=x;
//			if(--i>0)
//				next=new worm(i,(char)(x+1));
//				
//		}
//	}
	private  static int testReturn(){
		int c=1;
		if (c==1) return 1;
		return 20;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		DataConverter dataConv=new DataConverter();
//		AclfNetwork net = dataConv.Converter4InterPSS("testdata/bpa/009bpa.DAT", "bpa");
////        System.out.print(net.getBusList().toString());
//		
//        Matrix P=new DataReader(dataConv.getParser()).getGenPmax();
//        P.print(3, 3);
//		 System.out.print(Integer.parseInt("30"));
		 double [][] m={{1,2},{2,4}};
		 RealMatrix a =new Array2DRowRealMatrix(m);
		 RealMatrix b =new Array2DRowRealMatrix().createMatrix(2, 2);
         double eig=MatrixCalc.getEigValueMin(a);
         //System.out.print(eig);
//	     worm w= new Test().new worm(4,'a');
//	     System.out.print(w);
          int c=testReturn();
          System.out.print(c);

	}

}
