package com.interpss.editor.mapper.impl;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.net.Area;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.core.net.Network;
import com.interpss.core.net.Zone;
import com.interpss.editor.form.base.BaseBranchForm;
import com.interpss.editor.form.base.BaseBusForm;
import com.interpss.editor.form.base.BaseNetForm;

/**
 * Map functions for BaseNetForm, BaseBusForm, BaseBranchForm to/from Network, Bus, Branch simu objects
 */


public class BaseFormDataMapperImpl {
    /**
     * Set the BaseNetForm object info to the Network object
     * 
     * @param formNet the BaseNetForm object
     * @param net the Network object
     */
	public static void setBaseNetInfo(BaseNetForm formNet, Network net) {
		IpssLogger.getLogger().info("BaseFormDataMapperImpl.setBaseNetInfo() called");
		net.setId(formNet.getId());
		net.setDesc(formNet.getDescription());
		net.setBaseKva(formNet.getBaseKVA());
		net.setFrequency(formNet.getFreqHZ());
		net.setAllowParallelBranch(formNet.isAllowParallelBranch());
		net.setCheckElementDuplication(formNet.isCheckBusDuplication());
	}

	/**
	 * Set the BaseBusForm object info to the Bus object
	 * 
	 * @param formBus the BaseBusForm object
	 * @param bus the Bus object
	 * @param net the Network object contains the bus
	 */
	public static void setBaseBusInfo(BaseBusForm formBus, Bus bus, Network net) {
		bus.setId(formBus.getId());
		bus.setName(formBus.getName());
		bus.setStatus(formBus.getStatus());
	  	Area area = CoreObjectFactory.createArea(formBus.getArea(), net);
	  	Zone zone = CoreObjectFactory.createZone(formBus.getZone(), net);
	  	bus.setArea(area);
	  	bus.setZone(zone);
	  	bus.setBaseVoltage(formBus.getBaseVoltage(), UnitType.toUnit(formBus.getBaseVoltUnit()));
	}

	/**
	 * Set the BaseBranchForm object info to the Branch object
	 * 
	 * @param formBranch the BaseBranchForm object
	 * @param branch the Branch object
	 * @param net the Network object contains the bus
	 */
	public static void setBaseBranchInfo(BaseBranchForm formBranch, Branch branch, Network net) {
		branch.setName(formBranch.getName());
		branch.setStatus(formBranch.getStatus());
	  	Area area = CoreObjectFactory.createArea(formBranch.getArea(), net);
	  	Zone zone = CoreObjectFactory.createZone(formBranch.getZone(), net);
	  	branch.setArea(area);
	  	branch.setZone(zone);
	}
}