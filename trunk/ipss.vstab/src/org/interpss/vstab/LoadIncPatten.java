package org.interpss.vstab;

import java.util.List;

import com.interpss.core.aclf.AclfNetwork;

public interface LoadIncPatten {

	public void incLoadByBus(final List<Integer> incLoadBusList);
	public void incLoadByZone(final List<Integer> incZoneList);
	public void incLoadByNet();
}
