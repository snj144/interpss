package ipss.tools;

import ipss.custom.exchange.FileAdapter_PTIFormat;

import org.interpss.editor.EditorSpringAppContext;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.StdoutMsgListener;
import com.interpss.common.msg.TextMessage;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.io.IpssFileAdapter;


public class TestAdapter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringAppContext.SpringAppCtxConfigXmlFile = 
			"c:/eclipse/interpss3.2/ipss.editor/properties/springConfig/editorAppContext.xml";
		EditorSpringAppContext.springAppContextSetup();
		
		IPSSMsgHub msg = null;
		try {
			msg = new IPSSMsgHub();
			msg.addMsgListener(new StdoutMsgListener(TextMessage.TYPE_STATUS));
			
			testPTIAdapter(msg);
 		} catch (Exception e) {
 			e.printStackTrace();
		}
 		System.exit(0);
	}

	public static void testPTIAdapter(IPSSMsgHub msg) throws Exception {
		IpssFileAdapter adapter = new FileAdapter_PTIFormat();
		SimuContext simuCtx = adapter.load("testData/psse_uguide_sample.psse", msg);

		AclfAdjNetwork net = simuCtx.getAclfAdjNet();

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(AclfMethod.NR_LITERAL);
	  	algo.loadflow(msg);
  		System.out.println(net.net2String());
	}	
}
