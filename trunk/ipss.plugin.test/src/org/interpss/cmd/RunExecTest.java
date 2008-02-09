package org.interpss.cmd;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.junit.Test;

import com.interpss.common.util.IpssJavaExec;

public class RunExecTest  extends BaseTestSetup {
	@Test
	public void runExec() throws Exception {
    	String ipssRootDir = "c:/eclipse/GEditor/";
    	String[] args = {
            	ipssRootDir+"bin/ipssCmd.bat", 
            	"-in", ipssRootDir+"sample_ws/custom/ieee14.ipssdat",
    		    "-out", ipssRootDir+"output/ieee14.out"};
    	assertTrue(IpssJavaExec.exec(args));
    }		
}
