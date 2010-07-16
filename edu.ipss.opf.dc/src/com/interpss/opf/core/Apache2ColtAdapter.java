package com.interpss.opf.core;

import java.util.List;

import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.ArrayRealVector;

import cern.colt.matrix.DoubleMatrix1D;
import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.impl.DenseDoubleMatrix1D;
import cern.colt.matrix.impl.DenseDoubleMatrix2D;

public class Apache2ColtAdapter {
	
	/*
	 *   // Input for QuadProgJ ,the DCOPFJ format;
  private DoubleMatrix2D G;
  private DoubleMatrix1D a;
  private DoubleMatrix2D Ceq;
  private DoubleMatrix1D beq;
  private DoubleMatrix2D Ciq;
  private DoubleMatrix1D biq;
	 */
	// Input for QuadProgJ , defined in the DCOPFImpl;
	/*
	private Array2DRowRealMatrix G; // G={U 0;0 Wrr}
	private ArrayRealVector A; //
	private Array2DRowRealMatrix Ceq;
	private ArrayRealVector beq;
	private Array2DRowRealMatrix Ciq;
	private ArrayRealVector biq;
	*/
	
	
	private DoubleMatrix2D colt2DMatrix;
	private DoubleMatrix1D colt1DMatrix;
	
	public DoubleMatrix2D trans(Array2DRowRealMatrix param2DMatrix){
		int row =param2DMatrix.getRowDimension();
		int col=param2DMatrix.getColumnDimension();
		colt2DMatrix=new DenseDoubleMatrix2D(row,col);
		colt2DMatrix.assign(param2DMatrix.getData());
		return colt2DMatrix;
		
	}
	public DoubleMatrix1D trans(ArrayRealVector paramRealVector){
		colt1DMatrix =new DenseDoubleMatrix1D(paramRealVector.getDimension());
		colt1DMatrix.assign(paramRealVector.toArray());
		return colt1DMatrix;
		
	}

}
