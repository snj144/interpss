package org.interpss.test.simu.util;

import org.interpss.editor.data.aclf.AclfBusData;
import org.interpss.test.simu.TestBaseAppCtx;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.IpssEvent;
import com.interpss.common.util.XmlUtil;

public class TestUtilCase extends TestBaseAppCtx {
	public void testXmlUtilCase1() {
		XmlUtil.ToolKid = XmlUtil.TOOL_CASTOR;
		
		AclfBusData data = new AclfBusData();
		data.setShuntB(1.0);
		data.setShuntG(2.0);
		
		String str = XmlUtil.toXmlString(data);
		System.out.println(str);
		
		data = (AclfBusData)XmlUtil.toObject(str, AclfBusData.class);
		assertTrue(data.getShuntB() == 1.0);
		assertTrue(data.getShuntG() == 2.0);
	}

	public void testStdoutEventListenerCase() {
		
		IpssEvent event = new IpssEvent(new String("test event"));
		SpringAppContext.SpringAppCtx.publishEvent(event);
	}
}
