/*
 * Created on Mar 11, 2005
 *
 */
package com.interpss.test.unit.db;

import com.interpss.editor.refData.LoadSchedule;
import com.interpss.editor.refData.LoadScheduleRefData;
import com.interpss.test.unit.TestBaseAppCtx;

public class RefDataDBTest extends TestBaseAppCtx {
	
	public void testRefData() {
		System.out.println("\nBegin RefDataDBTest.testRefData");

		LoadScheduleRefData refData = LoadScheduleRefData.getRefDataFromDB();
		//System.out.println(refData.toString());
			
		assertTrue(refData.getScheduleList().size() == 2);

	    LoadSchedule s1 = (LoadSchedule)refData.getScheduleList().get(0);
	    assertTrue(s1.getName().equals("SampleLoadSchedule-1"));
	    assertTrue(s1.getItemList().size() == 24);

	    LoadSchedule s2 = (LoadSchedule)refData.getScheduleList().get(1);
	    assertTrue(s2.getName().equals("SampleLoadSchedule-2"));
	    assertTrue(s2.getItemList().size() == 24);

		System.out.println("\nEnd RefDataDBTest.testRefData");
	}
}
