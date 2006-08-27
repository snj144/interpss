package org.interpss.test.unit.spring;

import java.util.List;

import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.test.unit.TestBaseAppCtx;


public class TestCustomFileAdapter extends TestBaseAppCtx {
	public void testcustomFileAdapterList() {
		System.out.println("\nBegin TestCustomFileAdapter.testcustomFileAdapterList");
		
		List list = SimuAppSpringAppContext.getCustomFileAdapterList();
		assertTrue(list.size() == 4);
		assertTrue(SimuAppSpringAppCtxUtil.getCustomFileAdapter("m") != null);
		assertTrue(SimuAppSpringAppCtxUtil.getCustomFileAdapter("ieee") != null);
		
		System.out.println("\nEnd TestCustomFileAdapter.testcustomFileAdapterList");
	}
}
