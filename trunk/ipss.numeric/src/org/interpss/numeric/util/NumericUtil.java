package org.interpss.numeric.util;

public class NumericUtil {
	public static boolean equals(int x, int y) {
		return x == y;
	}

	public static boolean equals(double x, double y) {
		return Math.abs(x - y) < 1.0e-10;
	}
}
