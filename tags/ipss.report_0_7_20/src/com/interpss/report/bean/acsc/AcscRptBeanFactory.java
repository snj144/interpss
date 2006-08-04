package com.interpss.report.bean.acsc;

import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.report.mapper.SimuCtxReportMapper;
import com.interpss.simu.SimuContext;

public class AcscRptBeanFactory {
	/*
	 * Fault summary breport
	 * ====================
	 */
	public static RptFaultSummaryBean createBusFaultSummarySampleBean() {
		RptFaultSummaryBean bean = new RptFaultSummaryBean();
		bean.setType(1);
		bean.setBusId("0001");
		bean.setBusName("Bus-1");
		bean.setFaultType("Ground_3P");
		bean.setFaultAmpspu("0.1+j5.0");
		bean.setFaultAmps("300+j30000");
		return bean;
	}
	
	public static RptFaultSummaryBean[] createFaultSummarySampleBeanList() {
		RptFaultSummaryBean[] list = new RptFaultSummaryBean[1];
		list[0] = createBusFaultSummarySampleBean();
		return list;
	}

	public static JRBeanArrayDataSource getFaultSummarySampleDataSource() {
		return new JRBeanArrayDataSource(createFaultSummarySampleBeanList());
	}
	
	public static JRBeanArrayDataSource getFaultSummaryDataSource(IAppSimuContext appSimuCtx, SimuCtxReportMapper mapper) {
		RptFaultSummaryBean bean = new RptFaultSummaryBean();	
		mapper.mapping(appSimuCtx, bean, RptFaultSummaryBean.class);
		return new JRBeanArrayDataSource(new Object[] {bean});
	}
	
	public static JRBeanArrayDataSource getFaultSummaryDataSource(SimuContext simuCtx) {
		RptFaultSummaryBean bean = new RptFaultSummaryBean();	
		SimuCtxReportMapper mapper = new SimuCtxReportMapper(simuCtx.getMsgHub());
		mapper.mapping(simuCtx, bean, RptFaultSummaryBean.class);
		return new JRBeanArrayDataSource(new Object[] {bean});
	}

	/*
	 * Fault Bus/Branch Volt and Amps breport
	 * ========================================
	 */
	public static RptAcscVoltAmpsBean createAcscBusSampleBean() {
		RptAcscVoltAmpsBean bean = new RptAcscVoltAmpsBean();
		bean.setRecType(1);
		bean.setBusName("Bus-1");
		bean.setBusId("00001");
		bean.setBusFaultVoltpu("0.001");
		bean.setBusFaultVolt("0.001");
		bean.setBusContribAmpspu("0.001");
		bean.setBusContribAmps("0.001");
		return bean;
	}
	
	public static RptAcscVoltAmpsBean createAcscBranchSampleBean() {
		RptAcscVoltAmpsBean bean = new RptAcscVoltAmpsBean();
		bean.setRecType(2);
		bean.setBranchId("0001->0002");
		bean.setBranchName("Bus-1->Bus-2");
		bean.setBranchFaultAmpspu("0.001");
		bean.setBranchFaultAmps("0.001");		
		return bean;
	}
	
	public static RptAcscVoltAmpsBean createAcscBus012SampleBean() {
		RptAcscVoltAmpsBean bean = new RptAcscVoltAmpsBean();
		bean.setRecType(10);
		bean.setBusId("00001");
		bean.setBusName("Bus-1");
		bean.setBusFaultVoltpu("0.001");
		bean.setBusFaultVolt("0.001");
		bean.setBusFaultVolt0pu("0.001");
		bean.setBusFaultVolt0("0.001");
		bean.setBusFaultVolt2pu("0.001");
		bean.setBusFaultVolt2("0.001");
		bean.setBusContribAmpspu("0.001");
		bean.setBusContribAmps("0.001");
		return bean;
	}

	public static RptAcscVoltAmpsBean createAcscBusABCSampleBean() {
		RptAcscVoltAmpsBean bean = new RptAcscVoltAmpsBean();
		bean.setRecType(11);
		bean.setBusId("00001");
		bean.setBusName("Bus-1");
		bean.setBusFaultVoltApu("0.001");
		bean.setBusFaultVoltA("0.001");
		bean.setBusFaultVoltBpu("0.001");
		bean.setBusFaultVoltB("0.001");
		bean.setBusFaultVoltCpu("0.001");
		bean.setBusFaultVoltC("0.001");
		bean.setBusContribAmpspu("0.001");
		bean.setBusContribAmps("0.001");
		return bean;
	}

	public static RptAcscVoltAmpsBean createAcscBranch012SampleBean() {
		RptAcscVoltAmpsBean bean = new RptAcscVoltAmpsBean();
		bean.setRecType(12);
		bean.setBranchId("0001->0002");
		bean.setBranchName("Bus-1->Bus-2");
		bean.setBranchFaultAmpspu("0.001");
		bean.setBranchFaultAmps("0.001");		
		bean.setBranchFaultAmps0pu("0.001");
		bean.setBranchFaultAmps0("0.001");		
		bean.setBranchFaultAmps2pu("0.001");
		bean.setBranchFaultAmps2("0.001");		
		return bean;
	}

	public static RptAcscVoltAmpsBean createAcscBranchABCSampleBean() {
		RptAcscVoltAmpsBean bean = new RptAcscVoltAmpsBean();
		bean.setRecType(13);
		bean.setBranchId("0001->0002");
		bean.setBranchName("Bus-1->Bus-2");
		bean.setBranchFaultAmpsApu("0.001");
		bean.setBranchFaultAmpsA("0.001");		
		bean.setBranchFaultAmpsBpu("0.001");
		bean.setBranchFaultAmpsB("0.001");		
		bean.setBranchFaultAmpsCpu("0.001");
		bean.setBranchFaultAmpsC("0.001");		
		return bean;
	}


	public static RptAcscVoltAmpsBean[] createAcscVoltAmps3PSampleBeanList() {
		RptAcscVoltAmpsBean[] list = new RptAcscVoltAmpsBean[6];
		list[0] = createAcscBusSampleBean();
		list[1] = createAcscBusSampleBean();
		list[2] = createAcscBusSampleBean();
		list[3]  = createAcscBranchSampleBean();
		list[4] = createAcscBranchSampleBean();
		list[5] = createAcscBranchSampleBean();
		return list;
	}

	public static RptAcscVoltAmpsBean[] createAcscVoltAmpsNSSampleBeanList() {
		RptAcscVoltAmpsBean[] list = new RptAcscVoltAmpsBean[12];
		list[0] = createAcscBus012SampleBean();
		list[1] = createAcscBus012SampleBean();
		list[2] = createAcscBus012SampleBean();

		list[3] = createAcscBusABCSampleBean();
		list[4] = createAcscBusABCSampleBean();
		list[5] = createAcscBusABCSampleBean();

		list[6] = createAcscBranch012SampleBean();
		list[7] = createAcscBranch012SampleBean();
		list[8] = createAcscBranch012SampleBean();

		list[9] = createAcscBranchABCSampleBean();
		list[10] = createAcscBranchABCSampleBean();
		list[11] = createAcscBranchABCSampleBean();

		return list;
	}

	public static JRBeanArrayDataSource getAcscVoltAmps3PSampleDataSource() {
		return new JRBeanArrayDataSource(createAcscVoltAmps3PSampleBeanList());
	}
	
	public static JRBeanArrayDataSource getAcscVoltAmpsNSSampleDataSource() {
		return new JRBeanArrayDataSource(createAcscVoltAmpsNSSampleBeanList());
	}

	public static JRBeanArrayDataSource getAcscVoltAmpsDataSource(SimuContext simuCtx) {
		SimuCtxReportMapper mapper = new SimuCtxReportMapper(simuCtx.getMsgHub());
		Object[] beans = mapper.mappingMultiObject(simuCtx, RptAcscVoltAmpsBean.class, null);
		if (beans.length > 0)
			return new JRBeanArrayDataSource(beans);
		else 
			return null;
	}
}
