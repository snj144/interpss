package com.interpss.dstab.control.common.ui;

/**
	Swing input data validation util functions
*/

public class InputVerifyUtil {
	/**
	*	Check if the JTextField input is empty
	*
	* @param input the JTextField object
	* @return true or false
	*/
	public static boolean isEmptyStr(final javax.swing.JTextField input) {
		return  "".equals(input.getText().trim());
	}

	/**
	*	Check if the JComboBox selection is empty
	*
	* @param input the JComboBox object
	* @return true or false
	*/
	public static boolean isEmptyStr(final javax.swing.JComboBox input) {
		final String str = (String)input.getSelectedItem();
		return  "".equals(str.trim());
	}

	/**
	*	Check if the JTextField input is larger than x
	*
	* @param input the JTextField object
	* @param x parameter x
	* @return true or false
	*/
	public static boolean largeThan(final javax.swing.JTextField input, final double x) throws Exception {
		final double d = new Double(input.getText()).doubleValue();
		if ( d > x ) {
			return true;
		} 
		return false;
	}
	
	/**
	*	Check if the JTextField input is larger than x
	*
	* @param input the JTextField object
	* @param x parameter x
	* @return true or false
	*/
	public static boolean within(final javax.swing.JTextField input, final double low, final double high) throws Exception {
		final double d = new Double(input.getText()).doubleValue();
		if ( (d >= low) && (d <= high) ) {
			return true;
		} 
		return false;
	}

   /**
	*	Check if the JTextField input is larger than x
	*
	* @param input the JTextField object
	* @param x parameter x
	* @return true or false
	*/
	public static boolean largeThan(final javax.swing.JTextField input, final int x) throws Exception {
		final int d = new Integer(input.getText()).intValue();
		if ( d > x ) {
			return true;
		} 
		return false;
	}

	/**
	*	Check if the JComboBox input is larger than x
	*
	* @param input the JComboBox object
	* @param x parameter x
	* @return true or false
	*/
	public static boolean largeThan(final javax.swing.JComboBox input, final double x) throws Exception {
		final double d = new Double((String)(input.getSelectedItem())).doubleValue();
		if ( d > x ) {
			return true;
		} 
		return false;
	}

	/**
	*	Check if the JTextField input is larger or equal than x
	*
	* @param input the JTextField object
	* @param x parameter x
	* @return true or false
	*/
	public static boolean largeEqualThan(final javax.swing.JTextField input, final double x) throws Exception {
		final double d = new Double(input.getText()).doubleValue();
		if ( d >= x ) {
			return true;
		} 
		return false;
	}

	/**
	*	Get double from the JTextField input
	*
	* @param input the JTextField object
	* @return the double number
	*/
	public static double getDouble(final javax.swing.JTextField input) throws Exception {
		return new Double(input.getText()).doubleValue();
	}

	/**
	*	Get double from the input
	*
	* @param input the object, has to be instanceOf Double
	* @return the double number
	*/
	public static double getDouble(final Object input) {
		return ((Double)(input)).doubleValue();
	}

	/**
	*	Get double from the JComboBox input
	*
	* @param input the JComboBox object
	* @return the double number
	*/
	public static double getDouble(final javax.swing.JComboBox input) throws Exception {
		return new Double((String)(input.getSelectedItem())).doubleValue();
	}

	/**
	*	Get int from the JTextField input
	*
	* @param input the JTextField object
	* @return the int number
	*/
	public static int getInt(final javax.swing.JTextField input) throws Exception {
		return new Integer(input.getText()).intValue();
	}
}