package org.interpss.vstab;

import java.util.List;

import com.interpss.core.aclf.AclfNetwork;

public interface LoadIncPatten {

	public void incLoadByBus(AclfNetwork net,final List<Integer> incLoadBusList);
	public void incLoadByZone(AclfNetwork net,final List<Integer> incZoneList);
	public void incLoadByNet(AclfNetwork net);
}
