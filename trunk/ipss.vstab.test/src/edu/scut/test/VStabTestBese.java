package edu.scut.test;

import java.util.logging.Level;

import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;

public class VStabTestBese {
	protected static IPSSMsgHub msg;

	@BeforeClass
	public static void init() {
		SpringAppContext.SpringAppCtx = new ClassPathXmlApplicationContext(Constants.SpringConfigPath_PluginTest);
		msg = SpringAppContext.getIpssMsgHub();
		IpssLogger.getLogger().setLevel(Level.INFO);
	}
}
