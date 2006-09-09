package org.interpss.test.simu;

import org.interpss.test.TestConstants;

import junit.framework.TestCase;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Complex3x1;
import org.interpss.editor.EditorSpringAppContext;

public class TestBaseAppCtx extends TestCase {
	public TestBaseAppCtx() {
		if (SpringAppContext.SpringAppCtx == null) {
			SpringAppContext.SpringAppCtxConfigXmlFile = TestConstants.SpringConfigXmlFile;
			EditorSpringAppContext.springAppContextSetup();
		}
	}
	

	public static boolean compare(Complex3x1 iPU_012,
			double zeroRe, double zeroIm,
			double oneRe,  double oneIm,
			double twoRe,  double twoIm) {
		boolean b = true;

		if (Math.abs(iPU_012.a_0.getReal()-zeroRe) > 0.001) b = false;
		if (Math.abs(iPU_012.a_0.getImaginary()-zeroIm) > 0.001) b = false;
		if (Math.abs(iPU_012.b_1.getReal()-oneRe) > 0.001)  b = false;
		if (Math.abs(iPU_012.b_1.getImaginary()-oneIm) > 0.001)  b = false;
		if (Math.abs(iPU_012.c_2.getReal()-twoRe) > 0.001)  b = false;
		if (Math.abs(iPU_012.c_2.getImaginary()-twoIm) > 0.001)  b = false;

		if (!b) {
			System.out.println("SC current: " + iPU_012.toString());
		}

		return b;
	}	
}
