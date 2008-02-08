package org.interpss.custom.exchange.ucte;

import java.util.ArrayList;
import java.util.List;

import com.interpss.core.aclfadj.impl.AclfAdjNetworkImpl;

public class UCTENetwork extends AclfAdjNetworkImpl {
	public static class ExchangePower {
		String fromIsoId, toIsoId;
		double exPower;
		String comment;
		
		public ExchangePower(String fromIsoId, String toIsoId, double exPower, String comment) {
			this.fromIsoId = fromIsoId;
			this.toIsoId = toIsoId;
			this.exPower = exPower;
			this.comment = comment;
		}
	}
	
	private List<ExchangePower> exPowerList = new ArrayList<ExchangePower>(); 

	public UCTENetwork(String id, String name) {
		super.setId(id);
		super.setName(name);
	}

	public void addExchangePower(ExchangePower exPower) {
		exPowerList.add(exPower);
	}
	
	public List<ExchangePower> getExchangePowerList() {
		return this.exPowerList;
	}
}
