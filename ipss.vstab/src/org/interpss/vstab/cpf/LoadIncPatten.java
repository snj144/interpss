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
	private  Hashtable<String ,Bus > incBusTbl=null;
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
					addBusByArea(a);	
				}
			}
			else {
				_msg.sendErrorMsg("LoadIncPtn is by AREA, but inceaseObjList is not Area type, not consistent with ptn");
			}
			
		if(ptn==LoadIncPtn.ZONE) {
			if((!increaseObjList.isEmpty())&(increaseObjList.get(0) instanceof Zone)) {
				for(Area a:(List<Area>)increaseObjList) {
					addBusByArea(a);	
				}
			}
			else {
				_msg.sendErrorMsg("LoadIncPtn is by ZONE, but inceaseObjList is not ZONE type, not consistent with ptn");
			}
		}
		if(ptn==LoadIncPtn.BUS) {
			if((increaseObjList!=null)&(increaseObjList.get(0) instanceof Bus)) {
				if((this.incBusList!=null)&(!this.incBusList.isEmpty())) {
					for(Bus b:(List<Bus>)increaseObjList) {
						if(!this.incBusTbl.containsValue(b)){
							this.incBusList.add(b);
							this.incBusTbl.put(b.getId(), b);
						}
					}
				}
				else {
					this.incBusList=increaseObjList;
				}
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
	private void addBusByArea(Area a) {
		for(Bus b:_net.getBusList()) {
			if(b.getArea()==a) {
				if (this.incBusTbl.containsKey(b.getId())){
					_msg.sendWarnMsg("Bus "+b.getId()+"is already in incBusList");
				}
				else {
					this.incBusList.add(b);
					this.incBusTbl.put(b.getId(), b);
				}
			}
				
		}
	}
	private void addBusByZone(Zone z) {
		for(Bus b:_net.getBusList()) {
			if(b.getZone()==z) {
				if (this.incBusTbl.containsKey(b.getId())){
					_msg.sendWarnMsg("Bus "+b.getId()+"is already in incBusList");
				}
				else {
					this.incBusList.add(b);
					this.incBusTbl.put(b.getId(), b);
				}
			}
				
		}
	}
	public Hashtable<String,Bus> getIncBusTbl() {
		return this.incBusTbl;
	}


}
