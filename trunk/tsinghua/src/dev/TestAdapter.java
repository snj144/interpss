package dev;

import org.interpss.custom.IpssFileAdapter;

import cn.edu.tsinghua.dps.adapter.aclf.FileAdpater_PSTMatlabFormat;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IPSSMsgHubImpl;
import com.interpss.common.msg.StdoutMsgListener;
import com.interpss.common.msg.TextMessage;
 
public class TestAdapter {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IPSSMsgHub msg = null;
		try {
			msg = new IPSSMsgHubImpl();
			msg.addMsgListener(new StdoutMsgListener(TextMessage.TYPE_STATUS));

			IpssFileAdapter adapter = new FileAdpater_PSTMatlabFormat();
			adapter.load("testData/data3m9b.m", msg);
 		} catch (Exception e) {
 			e.printStackTrace();
		}
	}

}
