package org.interpss.vstab.loadIncease;

import java.util.List;

public interface LoadIncPatten {

	public void incLoadByBus(final List<Integer> incLoadBusList);
	public void incLoadByZone(final List<Integer> incZoneList);
	public void incLoadByNet();
}
