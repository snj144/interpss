package dev;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.StdoutMsgListener;
import com.interpss.common.msg.TextMessage;

public class TestAdapter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IPSSMsgHub msg = null;
		try {
			msg = new IPSSMsgHub();
			msg.addMsgListener(new StdoutMsgListener(TextMessage.TYPE_STATUS));
 		} catch (Exception e) {
 			e.printStackTrace();
		}
	}

}
