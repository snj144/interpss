package org.interpss.spring;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.interpss.common.datatype.Constants;

public class AnnotationTest {
	@Test
	public void testcustomFileAdapterList() {
		ApplicationContext SpringAppCtx = new ClassPathXmlApplicationContext("com/interpss/config/spring/InterPSSConfig.xml");
		
		assertTrue(SpringAppCtx.getBean(Constants.SID_IpssMsgHub) != null);
		//System.out.println(SpringAppCtx.getBeansOfType(IPSSMsgHub.class).toString());
	}
}
