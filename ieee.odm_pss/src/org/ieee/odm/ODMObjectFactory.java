package org.ieee.odm;

import org.ieee.odm.common.ODMThrowableAdvice;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.springframework.aop.framework.ProxyFactory;

public class ODMObjectFactory {
	public static AclfModelParser createAclfModelParser() {
		AclfModelParser parser = new AclfModelParser();
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(parser);
		pf.addAdvice(new ODMThrowableAdvice());
		return (AclfModelParser)pf.getProxy();		
	}
}
