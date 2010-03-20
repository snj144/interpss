package org.interpss.vstab;

import org.apache.commons.math.linear.*;
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		DataConverter dataConv=new DataConverter();
//		AclfNetwork net = dataConv.Converter4InterPSS("testdata/bpa/009bpa.DAT", "bpa");
////        System.out.print(net.getBusList().toString());
//		
//        Matrix P=new DataReader(dataConv.getParser()).getGenPmax();
//        P.print(3, 3);
//		 System.out.print(Integer.parseInt("30"));
		 double [][] m={{1,2},{2,3}};
		 RealMatrix a =new Array2DRowRealMatrix(m);
		 RealMatrix b =new Array2DRowRealMatrix().createMatrix(2, 2);
		 b.setEntry(1, 1, 3);
		 System.out.print(b);
	

	}

}
