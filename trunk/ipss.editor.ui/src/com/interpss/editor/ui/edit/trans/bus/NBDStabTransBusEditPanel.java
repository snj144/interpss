package com.interpss.editor.ui.edit.trans.bus;
  
/**
 *
 */
import java.util.Vector;

import javax.swing.JDialog;

import com.interpss.common.util.IpssLogger;
import com.interpss.editor.data.dstab.DStabMachData;
import com.interpss.editor.form.GBusForm;
import com.interpss.editor.form.GFormContainer;
import com.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import com.interpss.editor.ui.IEditUIEventListener;
import com.interpss.editor.ui.edit.trans.dstab.NBExciterPanel;
import com.interpss.editor.ui.edit.trans.dstab.NBGovernorPanel;
import com.interpss.editor.ui.edit.trans.dstab.NBMachinePanel;
import com.interpss.editor.ui.edit.trans.dstab.NBStabilizerPanel;
import com.interpss.editor.ui.util.EditUIEvent;
 
public class NBDStabTransBusEditPanel extends javax.swing.JPanel implements IFormDataPanel, IEditUIEventListener {
	private static final long serialVersionUID = 1;
	private JDialog parent = null;

    private GFormContainer _netContainer = null;
    private GBusForm _form = null;
    
    private NBAclfTransBusEditPanel _aclfTransBusEditPanel = new NBAclfTransBusEditPanel();
    private NBMachinePanel          _machPanel = new NBMachinePanel();
    private NBExciterPanel          _excPanel = new NBExciterPanel();
    private NBGovernorPanel         _govPanel = new NBGovernorPanel();
    private NBStabilizerPanel       _pssPanel = new NBStabilizerPanel();

	public void initPanel(JDialog aParent) {
		parent = aParent;
		
		_aclfTransBusEditPanel.initPanel(aParent);
		_aclfTransBusEditPanel.getEditUIEventContainer().addEditUIEventListener(this);
		
		_machPanel.initPanel(this);
		_excPanel.initPanel(this, parent);
		_govPanel.initPanel(parent);
		_pssPanel.initPanel(parent);
	}
    
	public void init(Object netContainer, Object form) {
		IpssLogger.getLogger().info("DStabTransBusEditPanel init() called");
		_netContainer = (GFormContainer)netContainer;
		_form = (GBusForm)form;
		
	    dstabTabbedPane.setEnabledAt(0, true);
	    aclfInfoEditPanel.add(_aclfTransBusEditPanel);
		_aclfTransBusEditPanel.init(_netContainer, _form);
	    
	    machInfoEditPanel.add(_machPanel);
		_machPanel.init(_netContainer, _form);

	    excInfoEditPanel.add(_excPanel);
		_excPanel.init(_netContainer, _form.getDStabBusData());

	    govInfoEditPanel.add(_govPanel);
		_govPanel.init(_netContainer, _form.getDStabBusData());

	    pssInfoEditPanel.add(_pssPanel);
		_pssPanel.init(_netContainer, _form.getDStabBusData().getMachData());

		setMachTabbedPaneEnabled(false);
		setExcTabbedPaneEnabled(false);
		setGovTabbedPaneEnabled(false);
		setPssTabbedPaneEnabled(false);
	}
	
	public void onEvent(EditUIEvent e) {
		if (e.eventType == EditUIEvent.BusCodeChanged) {
			setTabbedPanel();
		}
	}
	
	private void setTabbedPanel() {
    	if (_form.getDStabBusData().isMachineBus()) {
			if (!dstabTabbedPane.isEnabledAt(1)) {
				setMachTabbedPaneEnabled(true);
		    	_machPanel.getDStabBusData().setMachData(new DStabMachData());
			}
	    	_machPanel.setForm2Editor();

    		setExcTabbedPaneEnabled(false);
			setPssTabbedPaneEnabled(false);
    		setGovTabbedPaneEnabled(false);
	    	if (!_form.getDStabBusData().getMachData().getType().equals(DStabMachData.MachType_InfiniteBus) &&
		    	!_form.getDStabBusData().getMachData().getType().equals(DStabMachData.MachType_EConst)	) {
				if (_form.getDStabBusData().getMachData().getHasExc()) { 
		    		setExcTabbedPaneEnabled(true);
		    		// _excPanel.setForm2Editor() enable or disable the PSS panel
		    		/*
			    	if (_form.getDStabBusData().getMachData().getHasPss()) {  
				    	_pssPanel.setForm2Editor();
						setPssTabbedPaneEnabled(true);
			    	}	
			    	*/
		    	}	
		    	
		    	if (_form.getDStabBusData().getMachData().getHasGov()) { 
		    		setGovTabbedPaneEnabled(true);
		    	}
	    	}
	    }
    	else {
			setMachTabbedPaneEnabled(false);
	    	setExcTabbedPaneEnabled(false);
			setPssTabbedPaneEnabled(false);
	    	setGovTabbedPaneEnabled(false);
    	}
	}
	
	public void setMachTabbedPaneEnabled(boolean e) {
	    dstabTabbedPane.setEnabledAt(1, e);
	}

	public void setExcTabbedPaneEnabled(boolean e) {
	    dstabTabbedPane.setEnabledAt(2, e);
		if (e)
			_excPanel.setForm2Editor();
	}
	
	public void setGovTabbedPaneEnabled(boolean e) {
	    dstabTabbedPane.setEnabledAt(3, e);
		if (e)
			_govPanel.setForm2Editor();
	}

	public void setPssTabbedPaneEnabled(boolean e) {
	    dstabTabbedPane.setEnabledAt(4, e);
		if(e)
			_pssPanel.setForm2Editor();
	}

	public boolean setForm2Editor() {
		IpssLogger.getLogger().info("DStabTransBusEditPanel setForm2Editor() called");
    	_aclfTransBusEditPanel.setForm2Editor();
    	
    	// There is no need to do the following, since aclfTransBusEditPanel.setForm2Editor() fires
    	// an event to setup the TabbedPanel when Swing, PV or PQ bus is selected.
    	//setTabbedPanel();
    	
    	// set the select pane to an enabled pane
    	int selectIndex = dstabTabbedPane.getSelectedIndex();
	    while (selectIndex > 0 && !dstabTabbedPane.isEnabledAt(selectIndex)) {
	    	dstabTabbedPane.setSelectedIndex(--selectIndex);
	    	IpssLogger.getLogger().info("Set selected pane to " + selectIndex);
	    }
	    return true;
	}
    
    public boolean saveEditor2Form(Vector errMsg) throws Exception {
		IpssLogger.getLogger().info("DStabTransBusEditPanel saveEditor2Form() called");
		boolean ok = true;
		
    	if (!_aclfTransBusEditPanel.saveEditor2Form(errMsg))
    		ok = false;
	    
	    if (_form.getDStabBusData().isMachineBus()) {
	    	if (!_machPanel.saveEditor2Form(errMsg))
	    		ok = false;

	    	if (!_form.getDStabBusData().getMachData().getType().equals(DStabMachData.MachType_InfiniteBus) &&
	    		!_form.getDStabBusData().getMachData().getType().equals(DStabMachData.MachType_EConst)	) {
	    		if (_form.getDStabBusData().getMachData().getHasExc()) { 
		    		if (!_excPanel.saveEditor2Form(errMsg))
		    			ok = false;
			    	if (_form.getDStabBusData().getMachData().getHasPss())  
				    	if (!_pssPanel.saveEditor2Form(errMsg))
				    		ok = false;
		    	}

		    	if (_form.getDStabBusData().getMachData().getHasGov()) 
		    		if (!_govPanel.saveEditor2Form(errMsg))
		    			ok = false;
	    	}
	    }

    	return ok;
    }
    
    /** Creates new form AclfEditPanel */
    public NBDStabTransBusEditPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        dstabTabbedPane = new javax.swing.JTabbedPane();
        aclfInfoEditPanel = new javax.swing.JPanel();
        machInfoEditPanel = new javax.swing.JPanel();
        excInfoEditPanel = new javax.swing.JPanel();
        govInfoEditPanel = new javax.swing.JPanel();
        pssInfoEditPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        dstabTabbedPane.setName("dstabTabbedPane");
        aclfInfoEditPanel.setLayout(new java.awt.BorderLayout());

        dstabTabbedPane.addTab("Bus Info", aclfInfoEditPanel);

        machInfoEditPanel.setLayout(new java.awt.BorderLayout());

        dstabTabbedPane.addTab("Machin Info", machInfoEditPanel);

        excInfoEditPanel.setLayout(new java.awt.BorderLayout());

        dstabTabbedPane.addTab("Exciter Info", excInfoEditPanel);

        govInfoEditPanel.setLayout(new java.awt.BorderLayout());

        dstabTabbedPane.addTab("Governor Info", govInfoEditPanel);

        pssInfoEditPanel.setLayout(new java.awt.BorderLayout());

        dstabTabbedPane.addTab("PSS Info", pssInfoEditPanel);

        add(dstabTabbedPane, java.awt.BorderLayout.NORTH);

    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aclfInfoEditPanel;
    private javax.swing.JTabbedPane dstabTabbedPane;
    private javax.swing.JPanel excInfoEditPanel;
    private javax.swing.JPanel govInfoEditPanel;
    private javax.swing.JPanel machInfoEditPanel;
    private javax.swing.JPanel pssInfoEditPanel;
    // End of variables declaration//GEN-END:variables
}
