package com.interpss;


import org.junit.BeforeClass;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.TestUtilFunc;

public class BaseTestSetup {
	@BeforeClass
	public static void setSpringAppCtx() {
		if (SpringAppContext.SpringAppCtx == null) {
			String xmlFile = TestUtilFunc.Simu_SpringConfigXmlFile;
			// Set the SpringAppContext to all ApplicationContextAware objects.
			SpringAppContext.SpringAppCtx = new FileSystemXmlApplicationContext(xmlFile);
		}
	}
}

