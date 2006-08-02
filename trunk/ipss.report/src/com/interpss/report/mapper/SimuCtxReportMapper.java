package com.interpss.report.mapper;

import java.util.Map;

import com.interpss.common.mapper.AbstractMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclfadj.FunctionLoad;
import com.interpss.core.aclfadj.PQBusLimit;
import com.interpss.core.aclfadj.PSXfrPControl;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.RemoteQBus;
import com.interpss.core.aclfadj.TapControl;
import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.report.bean.RptMainTitleBean;
import com.interpss.report.bean.aclf.RptAclfBusStyleBean;
import com.interpss.report.bean.aclf.RptAclfMaxMismatchBean;
import com.interpss.report.bean.aclf.RptAclfSummaryBusBean;
import com.interpss.report.bean.acsc.RptAcscVoltAmpsBean;
import com.interpss.report.bean.acsc.RptFaultSummaryBean;
import com.interpss.report.mapper.impl.AclfResultMapperImpl;
import com.interpss.report.mapper.impl.AcscResultMapperImpl;
import com.interpss.report.mapper.impl.MasterfResultMapperImpl;
import com.interpss.simu.SimuContext;

/**
*	Mapper to map SimuContext result to a list of report beans.
*/

public class SimuCtxReportMapper extends AbstractMapper {

	/**
	 * Constructor
	 * 
	 * @param msg
	 */
	public SimuCtxReportMapper(IPSSMsgHub msg) {
		setMsg(msg);
	}

	/**
	 * map a SimuNetwork object to an aclf report bean object
	 * 
	 * @param fromObj an AppSimuContext object
	 * @param toObj a report bean object
	 * @param kclass class type of the toObj 
	 */	
	public boolean mapping(Object fromObj, Object toObj, Class klass) {
		IAppSimuContext appSimuCtx = null;
		SimuContext simuCtx = null;
		if (fromObj instanceof IAppSimuContext) {
			appSimuCtx = (IAppSimuContext)fromObj;
			simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
		}
		else if (fromObj instanceof SimuContext) {
			simuCtx = (SimuContext)fromObj;
		}
		
		if (klass == RptAclfMaxMismatchBean.class) {
			AclfResultMapperImpl.mapAclfMaxMismatch(simuCtx.getAclfNet(), (RptAclfMaxMismatchBean)toObj);
			return true;
		}
		if (klass == RptFaultSummaryBean.class) {
			AcscResultMapperImpl.mapAcscFaultSummary(simuCtx.getAcscFaultNet(), (RptFaultSummaryBean)toObj);
			return true;
		}
		else if (klass == RptMainTitleBean.class) {
			MasterfResultMapperImpl.mapMasterTitleBean(appSimuCtx, (RptMainTitleBean)toObj);
			return true;
		}
		throw new UnsupportedOperationException();
		
	}
	
	/**
	 *	Map SimuContext result to a list of report beans.
	 *
	 * @param fromObj an AppSimuContext object
	 * @param kclass report bean class
	 * @param a set of attributes
	 */
	public Object[] mappingMultiObject(Object fromObj, Class klass, Map parameters) {
		SimuContext simuCtx = null;
		if (fromObj instanceof IAppSimuContext) {
			IAppSimuContext appSimuCtx = (IAppSimuContext)fromObj;
			simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
		}
		else if (fromObj instanceof SimuContext) {
			simuCtx = (SimuContext)fromObj;
		}
		
		if (klass == RptAclfSummaryBusBean.class) {
			return AclfResultMapperImpl.createAclfSummaryBusBeanArray(simuCtx.getAclfNet());
		}
		else if (klass == RptAclfBusStyleBean.class) {
			return AclfResultMapperImpl.createAclfBusStyleBeanArray(simuCtx.getAclfNet());
		}
		else if (klass == PVBusLimit.class) {
			return AclfResultMapperImpl.createPVBusLimitBeanArray(simuCtx.getAclfAdjNet());
		}
		else if (klass == PQBusLimit.class) {
			return AclfResultMapperImpl.createPQBusLimitBeanArray(simuCtx.getAclfAdjNet());
		}
		else if (klass == FunctionLoad.class) {
			return AclfResultMapperImpl.createFunctionLoadBeanArray(simuCtx.getAclfAdjNet());
		}
		else if (klass == PSXfrPControl.class) {
			return AclfResultMapperImpl.createPSXfrPControlBeanArray(simuCtx.getAclfAdjNet());
		}
		else if (klass == RemoteQBus.class) {
			return AclfResultMapperImpl.createRemoteQBusBeanArray(simuCtx.getAclfAdjNet());
		}
		else if (klass == TapControl.class) {
			return AclfResultMapperImpl.createTapVControlBeanArray(simuCtx.getAclfAdjNet());
		}
		
		else if (klass == RptAcscVoltAmpsBean.class) {
			return AcscResultMapperImpl.createAcscVoltAmpsBeanArray(simuCtx.getAcscFaultNet());
		}
		throw new UnsupportedOperationException();
	}	
}