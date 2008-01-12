/*
 * @(#)EditorJGraphDataMapper.java   
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

package org.interpss.editor.mapper;

import java.util.Vector;

import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.jgraph.ui.form.IGNetForm;
import org.interpss.mapper.editor.AclfFormDataMapperImpl;
import org.interpss.mapper.editor.AcscFormDataMapperImpl;
import org.interpss.mapper.editor.DStabFormDataMapperImpl;
import org.interpss.mapper.editor.DistFormDataMapperImpl;

import com.interpss.common.SpringAppContext;
import com.interpss.common.exp.InvalidParameterException;
import com.interpss.common.mapper.AbstractMapper;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuContext;

/**
 * Map editor data NetContainer to a DistNetwork object for simulation purpose.
 */

public class EditorJGraphDataMapper extends AbstractMapper {

	public EditorJGraphDataMapper() {
	}

	/**
	 * mat the GFormContainer object to a SimuContext object
	 * 
	 * @param simuCtx
	 *            a SimuNetwork object
	 * @param fContainer
	 *            a GFormContainer object containing form data
	 */
	public boolean mapping(Object fromObj, Object toObj, Class<?> klass) {
		if (klass == GFormContainer.class) {
			GFormContainer gFormContainer = (GFormContainer) fromObj;
			SimuContext simuCtx = (SimuContext) toObj;

			// check if current case data is dirty and mapping to SimuContext
			// object if necessary.
			// Currently only project in graph mode needs the mapping
			Vector errMsg = gFormContainer.checkData(SpringAppContext
					.getIpssMsgHub());
			if (errMsg != null) {
				SpringAppContext.getEditorDialogUtil().showMsgDialog(
						"Network data error", errMsg);
				return false;
			}

			SpringAppContext
					.getIpssMsgHub()
					.sendStatusMsg(
							"SimuContext data is dirty, map editor date from GFormContainer to simuCtx");
			Object net = createMappingObject(gFormContainer,
					GFormContainer.class);
			if (gFormContainer.getGNetForm().getAppType().equals(
					IGNetForm.AppType_Distribution)) {
				simuCtx.setNetwork(net, SimuCtxType.DISTRIBUTE_NET);
			} else {
				if (gFormContainer.getGNetForm().getNetType().equals(
						IGNetForm.NetType_DStabilityNet)) {
					simuCtx.setNetwork(net, SimuCtxType.DSTABILITY_NET);
				} else if (gFormContainer.getGNetForm().getNetType().equals(
						IGNetForm.NetType_AclfNetwork)
						|| gFormContainer.getGNetForm().getNetType().equals(
								IGNetForm.NetType_AclfAdjNetwork)) {
					simuCtx.setNetwork(net, SimuCtxType.ACLF_ADJ_NETWORK);
				} else if (gFormContainer.getGNetForm().getNetType().equals(
						IGNetForm.NetType_AcscNetwork)) {
					simuCtx.setNetwork(net, SimuCtxType.ACSC_FAULT_NET);
				}
			}
			SpringAppContext.getIpssMsgHub().sendStatusMsg(
					"Editor date mapped to simuCtx");

			if (simuCtx.getNetType() == SimuCtxType.ACLF_NETWORK) {
				if (!simuCtx.checkData()) {
					SpringAppContext.getEditorDialogUtil().showMsgDialog(
							"Network Loadflow Data Error",
							"Please see the message list for details");
					return false;
				}
			} else if (simuCtx.getNetType() == SimuCtxType.ACLF_ADJ_NETWORK) {
				if (!simuCtx.checkData()) {
					SpringAppContext.getEditorDialogUtil().showMsgDialog(
							"Network Loadflow Data Error",
							"Please see the message list for details");
					return false;
				}
			} else if (simuCtx.getNetType() == SimuCtxType.ACSC_FAULT_NET) {
				if (!simuCtx.checkData()) {
					SpringAppContext.getEditorDialogUtil().showMsgDialog(
							"Network Ac Short Circuit Data Error",
							"Please see the message list for details");
					return false;
				}
			} else if (simuCtx.getNetType() == SimuCtxType.DSTABILITY_NET) {
				if (!simuCtx.checkData()) {
					SpringAppContext.getEditorDialogUtil().showMsgDialog(
							"Transient stabiliry Data Error",
							"Please see the message list for details");
					return false;
				}
			}
			simuCtx.getNetwork().setDataChecked(false);
		}
		return true;
	}

	private Object createMappingObject(Object editNet, Class klass) {
		if (klass == GFormContainer.class) {
			IGNetForm netForm = ((GFormContainer) editNet).getGNetForm();
			if (netForm.getAppType().equals(IGNetForm.AppType_Distribution)) {
				return DistFormDataMapperImpl.mapEditNet2DistNet(
						(GFormContainer) editNet, this.msg);
			} else if (netForm.getAppType().equals(
					IGNetForm.AppType_Transmission)) {
				if (netForm.getNetType()
						.equals(IGNetForm.NetType_DStabilityNet)) {
					return DStabFormDataMapperImpl.mapEditNet2DStabNet(
							(GFormContainer) editNet, this.msg);
				} else if (netForm.getNetType().equals(
						IGNetForm.NetType_AcscNetwork)) {
					return AcscFormDataMapperImpl.mapEditNet2AcscNet(
							(GFormContainer) editNet, this.msg);
				} else if (netForm.getNetType().equals(
						IGNetForm.NetType_AclfNetwork)
						|| netForm.getNetType().equals(
								IGNetForm.NetType_AclfAdjNetwork)) {
					return AclfFormDataMapperImpl.mapEditNet2AclfNet(
							(GFormContainer) editNet, this.msg);
				}
			}
		}
		throw new InvalidParameterException("Invalid class inpur: " + klass);
	}
}