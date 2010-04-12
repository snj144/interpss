package edu.scut.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import Jama.Matrix;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IPSSMsgHubImpl;
import com.interpss.common.msg.StdoutMsgListener;
import com.interpss.common.msg.TextMessage;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;

import edu.scut.newgb;

public class NewgbTest {
	public static void main(String[] args) {
		AclfNetwork net =CoreObjectFactory.createAclfNetwork();
		
		IPSSMsgHub msg= new IPSSMsgHubImpl();
		msg.addMsgListener(new StdoutMsgListener(TextMessage.TYPE_WARN));
		IpssLogger.getLogger().setLevel(Level.WARNING);
		
		AclfNetwork objnet = newgb.ConvertIEEEtoInterPSS(net ,"testdata/ieee14.ieee",msg);  //ieee30.ieee
		// (List) index for the power-increase load buses 
		
		List<Integer> busL =Arrays.asList(10,11);
		List<Integer> buslist =new ArrayList<Integer>(busL);
		int Numofbus=buslist.size();
		
		// specify the load increase direction 
		 
		Matrix dirp = newgb.ones(Numofbus,1).times(0.8); // Dimensions should be matched with buslist
		Matrix dirq = newgb.ones(Numofbus,1).times(0.6);

		newgb.callIndexModel(objnet,buslist,dirp,dirq);
	
        //loadflow(msg);
	}
}
