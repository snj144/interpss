package org.interpss.vstab.cpf;

import java.util.Hashtable;
import java.util.List;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IPSSMsgHubImpl;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;
import com.interpss.core.net.Area;
import com.interpss.core.net.Zone;

public class LoadIncPatten {

	protected List<Area> incAreaList=null;
	protected List<Zone> incZoneList=null;
	protected List<Bus> incBusList=null;
	private  Hashtable<String ,Bus > incLoadBusTbl=null;
	private  IPSSMsgHub _msg=null;
	private AclfNetwork _net=null;

	
	public enum LoadIncPtn{AREA,ZONE,BUS,CUSTOM_SPECIFIC};
	
	public LoadIncPatten(AclfNetwork net,IPSSMsgHub msg) {
		
		this._net=net;
		this._msg=msg;
	}
	
	public void defLoadIncPtn(LoadIncPtn ptn, AclfNetwork net,List increaseObjList){
		this._net=net;
		if(ptn==LoadIncPtn.AREA) {
			if((!increaseObjList.isEmpty())&(increaseObjList.get(0) instanceof Area)) {
				for(Area a:(List<Area>)increaseObjList) {
					addLdBus2ListByArea(a);	
				}
			}
			else {
				_msg.sendErrorMsg("LoadIncPtn is by AREA, but inceaseObjList is not Area type, not consistent with ptn");
			}
			
		if(ptn==LoadIncPtn.ZONE) {
			if((!increaseObjList.isEmpty())&(increaseObjList.get(0) instanceof Zone)) {
				for(Zone z:(List<Zone>)increaseObjList) {
					addLdBus2ListByZone(z);	
				}
			}
			else {
				_msg.sendErrorMsg("LoadIncPtn is by ZONE, but inceaseObjList is not ZONE type, not consistent with ptn");
			}
		}
		if(ptn==LoadIncPtn.BUS) {
			if((increaseObjList!=null)&(increaseObjList.get(0) instanceof Bus)) {
				addLoadBus2ListByBus((List<Bus>)increaseObjList);
			}
			else {
				_msg.sendErrorMsg("LoadIncPtn is by BUS, but inceaseObjList is not BUS type, not consistent with ptn");
			}
		}
			
		}
	}

	public List<Area> getIncAreaList() {
		return incAreaList;
	}
	public void setIncAreaList(List<Area> incAreaList) {
		this.incAreaList = incAreaList;
	}
	
	public List<Zone> getIncZoneList() {
		return incZoneList;
	}
	public void setIncZoneList(List<Zone> incZoneList) {
		this.incZoneList = incZoneList;
	}
	
	public void setIncBusList(List<Bus> incBusList) {
		this.incBusList = incBusList;
	}
	public List<Bus> getIncBusList() {
		return this.incBusList;
	}
	private void addLdBus2ListByArea(Area a) {
		for(Bus b:_net.getBusList()) {
			AclfBus bus=(AclfBus) b;
			if((b.getArea()==a)&bus.isLoad()) {
				if (this.incLoadBusTbl.containsKey(b.getId())){
					_msg.sendErrorMsg("Duplication Error,Bus "+b.getId()+"is already in incBusList");
				}
				else {
					this.incBusList.add(b);
					this.incLoadBusTbl.put(b.getId(), b);
				}
			}
				
		}
	}
	private void addLdBus2ListByZone(Zone z) {
		for(Bus b:_net.getBusList()) {
			
			AclfBus bus=(AclfBus) b;
			if(b.getZone()==z&bus.isLoad()) {
				if (this.incLoadBusTbl.containsKey(b.getId())){
					_msg.sendErrorMsg("Duplication Error,Bus "+b.getId()+"is already in incBusList");
				}
				else {
					this.incBusList.add(b);
					this.incLoadBusTbl.put(b.getId(), b);
				}
			}
				
		}
	}
	private void addLoadBus2ListByBus(List<Bus> loadIncBusList) {
		if((this.incBusList!=null)&(!this.incBusList.isEmpty())) {
			for(Bus b:loadIncBusList) {
				if(!this.incLoadBusTbl.containsValue(b)){
					if(((AclfBus)b).isLoad()) {
					this.incBusList.add(b);
					this.incLoadBusTbl.put(b.getId(), b);
					}
					else {
						_msg.sendErrorMsg("Bus "+b.getId()+"is not a Load Bus");
					}
				}
				else {
					_msg.sendErrorMsg("Duplication Error,Bus "+b.getId()+"is already in incBusList");
				}
			}
		}
		else {
			this.incBusList=loadIncBusList;
			for(Bus b:loadIncBusList) {
				this.incLoadBusTbl.put(b.getId(),b);
			}
		}
	}
	
	public Hashtable<String,Bus> getIncLoadBusTbl() {
		return this.incLoadBusTbl;
	}


}
