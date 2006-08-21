package com.interpss.editor.ui.util;

/**
	Network data related manipulation util functions
*/
	
public class NetDataUtil {
	/**
	*	Calculate ratia x/y, if y == 0.0, return 0.0
	*
	* @param x parameter x
	* @param y parameter y
	* @return the ratio
	*/
	public static double ratio(double x, double y) {
		if ( y == 0.0 )
			return 0.0;
		else
			return x / y;	
	}

	/**
	*	Calculate value x * raito
	*
	* @param x parameter x
	* @param ratio parameter ratio
	* @return the value
	*/
	public static double calValue(double x, double ratio) {
		return x * ratio;
	}
}