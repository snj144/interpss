package org.interpss.core.grid.gridgain;

import java.util.EventListener;
import java.util.List;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridNode;

import com.interpss.common.exp.InterpssRuntimeException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IpssMessage;
import com.interpss.common.msg.TextMessage;

public class IPSSGridMsgHubImpl implements IPSSMsgHub {
	private Grid grid = null;
	private GridNode masterNode = null;
	
	private byte level = TextMessage.TYPE_INFO;
	
	public IPSSGridMsgHubImpl(Grid grid, byte level) {
		this.grid = grid;
    	this.masterNode = grid.getLocalNode();
    	this.level = level;
	}
	
	@Override
	public void sendDebugMsg(String msg) {
		if (this.level <= TextMessage.TYPE_DEBUG)
			sendMessage("Debug",  msg);
	}

	@Override
	public void sendErrorMsg(String msg) {
		if (this.level <= TextMessage.TYPE_ERROR)
			sendMessage("Error",  msg);
	}

	@Override
	public void sendInfoMsg(String msg) {
		if (this.level <= TextMessage.TYPE_INFO)
			sendMessage("Info",  msg);
	}

	@Override
	public void sendMsg(IpssMessage msg) {
		sendMessage("IpssMessage",  msg.toString());
	}

	@Override
	public void sendStatusMsg(String msg) {
		if (this.level <= TextMessage.TYPE_STATUS)
			sendMessage("Status",  msg);
	}

	@Override
	public void sendWarnMsg(String msg) {
		if (this.level <= TextMessage.TYPE_WARN)
			sendMessage("Warn",  msg);
	}

	@Override
	public void setMsgListeners(List<EventListener> list) {
		throw new InterpssRuntimeException("IPSSGridMsgHubImpl.setMsgListeners() not implemented");
	}

	@Override
	public void addMsgListener(EventListener listener) {
		throw new InterpssRuntimeException("IPSSGridMsgHubImpl.addMsgListener() not implemented");
	}

	@Override
	public void removeMsgListener(EventListener listener) {
		throw new InterpssRuntimeException("IPSSGridMsgHubImpl.removeMsgListener() not implemented");
	}

	private void sendMessage(String type, String msg) {
    	try {
    		this.grid.sendMessage(masterNode, "[RemoteMsg]"+type+": " + msg);
    		System.out.println(type+": " + msg);
    	} catch (GridException e) {
    		e.printStackTrace();
    	}
	}
}
