package ipss.custom.exchange.psse;

import java.util.StringTokenizer;

public class PSSEUtilFunc {

	/**
	 * PTI use 0 to indicate end of a data set, Bus Data for example. This function checks
	 * if the input line is the end of record line
	 *
	 * @param str a input data line string
	 */
	public static boolean isEndRecLine(String str) {
		return str.startsWith("0") || str.startsWith("/");
	}
	
	public static String trimQuote(String str) {
		return str.substring(1, str.length()-1);
	}
	
	public static boolean is3WXfr(String str) {
		// for 2W xfr, line1, K = 0
  		StringTokenizer st = new StringTokenizer(str, ",");
		st.nextToken();
		st.nextToken();
		int K = new Integer(st.nextToken().trim()).intValue();
		return K != 0;
	}
}
