 /*
  * @(#)FileUtility.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.editor.io;

import org.interpss.editor.SimuAppSpringAppCtxUtil;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;
import com.interpss.simu.SimuContext;
import com.interpss.simu.io.IpssFileAdapter;

public class FileUtility {
	public static boolean loadCustomFile(String filepath, SimuContext simuCtx) {
		IpssLogger.getLogger().info("Custom file path: " + filepath);

		String ext = filepath.substring(filepath.lastIndexOf('.')+1);
		IpssFileAdapter adapter = SimuAppSpringAppCtxUtil.getCustomFileAdapter(ext);
		if (adapter == null) {
			IpssLogger.getLogger().severe("Custom Input File Adapter not found, file : " + filepath);
			return false;
		}	

		try {
			adapter.load(simuCtx, filepath, simuCtx.getMsgHub());
		} catch (Exception e) {
			SpringAppContext.getEditorDialogUtil().showMsgDialog("Custom Data File Loading Error", e.toString());
			IpssLogger.logErr(e);
			return false;
		}

		if (!simuCtx.getAclfAdjNet().checkData(simuCtx.getMsgHub())) {
			SpringAppContext.getEditorDialogUtil().showMsgDialog("Network Loadflow Data Error", "Please see the message list for details");
			return false;
		}
		return true;
	}
}
