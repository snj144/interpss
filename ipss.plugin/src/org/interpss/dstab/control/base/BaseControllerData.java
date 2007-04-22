package org.interpss.dstab.control.base;

public abstract class BaseControllerData {
	private static String[][] parameters;

	protected void setParameters(String[][] p) {
		parameters = p;
	}
	
	private static double getParamValue(String s, int position) {
		for (String[] sAry : parameters) {
			if (s.equals(sAry[0])) {
				return new Double(sAry[position]).doubleValue();
			}
		}
		return 0.0;
	}

	public double getInitValue(String s) {
		return getParamValue(s, 1);
	}
	
	public double getMaxValue(String s) {
		return getParamValue(s, 2);
	}

	public double getMinValue(String s) {
		return getParamValue(s, 3);
	}
	
	public abstract void setValue(String name, double value);
}
