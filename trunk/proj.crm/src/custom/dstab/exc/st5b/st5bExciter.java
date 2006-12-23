 /*
  * @(#)CalculationException.java   
  *
  * Copyright (C) 2006 www.interpss.com
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
  * @Author Ron Oosterwijk
  * @Version 1.0
  * @Date Dec 2006
  * 
  *   Revision History
  *   ================
  *
  */

package custom.dstab.exc.ieee.st5b;

/*
 * Controller diff eqn implementation class
 */

import com.interpss.dstab.controller.block.DelayControlBlock;
import com.interpss.dstab.controller.block.FilterControlBlock;
import com.interpss.dstab.controller.block.IControlBlock;
import com.interpss.dstab.util.DStabOutFunc;
import java.util.Hashtable;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.Num2Str;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.controller.AbstractExciter;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.mach.DynamicMachine;


public class st5bExciter extends AbstractExciter {
    // Step-1: Define controller variables
    // ===================================
    
    private double vRef = 0.0, Vc = 0.0, Xadu = 0.0, Ifd = 0.0, vt = 0.0, vWindup = 0.0;
    private boolean uelOn = false, oelOn = false;
    private boolean withD = true, withI = true,
                    withUD = true, withOD = true,
                    withUI = true, withOI = true,
                    withGCU = true;
    private FilterControlBlock tgr1 = null;
    private FilterControlBlock tgr2 = null;
    private FilterControlBlock tgru1 = null;
    private FilterControlBlock tgru2 = null;
    private FilterControlBlock tgro1 = null;
    private FilterControlBlock tgro2 = null;
    private DelayControlBlock gcu = null;
    private LimitType vLimit = null;

    
    // Step-2: Initialization
    // ======================
    
    /**
     *  Init the controller states
     *
     *  @param msg the SessionMsg object
     */
    public boolean initStates(IPSSMsgHub msg) {
        vt = getMachine().getMachineBus().getVoltage().abs() / getMachine().getVMultiFactor();
        Xadu = getMachine().getMachData().getXd() 
                          - getMachine().getMachData().getXl();
        Ifd = ((DynamicMachine)getMachine()).calculateIfd() *Xadu;
        // Ifd is converted to excitation standard rotor base

        double cpd = Ifd*getData().getKc();
        
        gcu = new DelayControlBlock(1, getData().getT1());
        if (!gcu.initState(getMachine().getEfd())) {
            msg.sendErrorMsg("Initialisation error: Efd exceeds limit");
            return false; }
        
        vLimit = new LimitType(getData().getVrmax(), getData().getVrmin());
        
        double tgrRatio = 1.0, tgruRatio = 1.0, tgroRatio = 1.0;
        if (!(getData().getTb1()==0)) 
            tgrRatio = getData().getTb1()/getData().getTc1();
        if (!(getData().getTub1()==0)) 
            tgruRatio = getData().getTub1()/getData().getTuc1();
        if (!(getData().getTob1()==0)) 
            tgroRatio = getData().getTob1()/getData().getToc1();
        
        tgr1 = new FilterControlBlock(IControlBlock.Type_NonWindup,
               1, getData().getTc1(), getData().getTb1(),
               getData().getVrmax()/getData().getKr(), getData().getVrmin()/getData().getKr());
        if (!tgr1.initState((gcu.getU0()-cpd)/getData().getKr()*(1-1/tgrRatio))) {
            msg.sendErrorMsg("Initialisation error: init exceeds limit");
            return false; }
        tgru1 = new FilterControlBlock(IControlBlock.Type_NonWindup,
               1, getData().getTuc1(), getData().getTub1(),
               getData().getVrmax()/getData().getKr(), getData().getVrmin()/getData().getKr());
        if (!tgru1.initState((gcu.getU0()-cpd)/getData().getKr()*(1-1/tgruRatio))) {
            msg.sendErrorMsg("Initialisation error: init exceeds limit");
            return false; }
        tgro1 = new FilterControlBlock(IControlBlock.Type_NonWindup,
               1, getData().getToc1(), getData().getTob1(),
               getData().getVrmax()/getData().getKr(), getData().getVrmin()/getData().getKr());
        if (!tgro1.initState((gcu.getU0()-cpd)/getData().getKr()*(1-1/tgroRatio))) {
            msg.sendErrorMsg("Initialisation error: init exceeds limit");
            return false; }
        
        double dgrRatio = 1.0, dgruRatio = 1.0, dgroRatio = 1.0;
        if (!(getData().getTb2()==0)) 
            dgrRatio = getData().getTc2()/getData().getTb2();
        if (!(getData().getTub2()==0)) 
            dgruRatio = getData().getTuc2()/getData().getTub2();
        if (!(getData().getTob2()==0)) 
            dgroRatio = getData().getToc2()/getData().getTob2();
        
        
        tgr2 = new FilterControlBlock(IControlBlock.Type_NonWindup,
               1, getData().getTc2(), getData().getTb2(),
               getData().getVrmax()/getData().getKr()*tgrRatio,
               getData().getVrmin()/getData().getKr()*tgrRatio);
        if (!tgr2.initState(tgr1.getU0()*(1-dgrRatio))) {
            msg.sendErrorMsg("Initialisation error: init exceeds limit");
            return false; }
        tgru2 = new FilterControlBlock(IControlBlock.Type_NonWindup,
               1, getData().getTuc2(), getData().getTub2(),
               getData().getVrmax()/getData().getKr()*tgruRatio,
               getData().getVrmin()/getData().getKr()*tgruRatio);
        if (!tgru2.initState(tgru1.getU0()*(1-dgruRatio))) {
            msg.sendErrorMsg("Initialisation error: init exceeds limit");
            return false; }
        tgro2 = new FilterControlBlock(IControlBlock.Type_NonWindup,
               1, getData().getToc2(), getData().getTob2(),
               getData().getVrmax()/getData().getKr()*tgroRatio,
               getData().getVrmin()/getData().getKr()*tgroRatio);
        if (!tgro2.initState(tgro1.getU0()*(1-dgroRatio))) {
            msg.sendErrorMsg("Initialisation error: init exceeds limit");
            return false; }
        
        Vc = tgr2.getU0();
        if (getData().getTb1()==0)
            withI = false;
        if (getData().getTub1()==0)
            withUI = false;
        if (getData().getTob1()==0)
            withOI = false;
        if (getData().getTb2()==0)
            withD = false;
        if (getData().getTub2()==0)
            withUD = false;
        if (getData().getTob2()==0)
            withOD = false;
        if (getData().getT1()==0)
            withGCU = false;
        
        return true;
    }
    
    // Step-4: Code Diff-Eqn
    // =====================
    
    /**
     * Perform one step diff eqn calculation
     *
     * @param dt simulation time interval
     * @param method d-eqn solution method
     * @param msg the IPSSMsgHub object, for communication with the outside world
     */
    public boolean nextStep(double dt, DynamicSimuMethods method, double baseFreq, IPSSMsgHub msg) {
        if (method == DynamicSimuMethods.MODIFIED_EULER_LITERAL) {
            
            final double vErr = calculateVerr();
            if (withD) {
                tgr2.eulerStep1(vErr, dt);
                tgr2.eulerStep2(vErr, dt); }
            if (withUD) {
                tgru2.eulerStep1(vErr, dt);
                tgru2.eulerStep2(vErr, dt); }
            if (withOD) {
                tgro2.eulerStep1(vErr, dt);
                tgro2.eulerStep2(vErr, dt); }
            
            final double v1 = calculateV1();
            if (withI) {
                tgr1.eulerStep1(v1, dt);
                tgr1.eulerStep2(v1, dt); }
            final double v1u = calculateV1u();
            if (withUI) {
                tgru1.eulerStep1(v1u, dt);
                tgru1.eulerStep2(v1u, dt); }
            final double v1o = calculateV1o();
            if (withOI) {
                tgro1.eulerStep1(v1o, dt);
                tgro1.eulerStep2(v1o, dt); }
                                   
            double Xadu = getMachine().getMachData().getXd() 
                          - getMachine().getMachData().getXl();
            Ifd = ((DynamicMachine)getMachine()).calculateIfd() *Xadu;
            
            vt = getMachine().getMachineBus().getVoltage().abs() / getMachine().getVMultiFactor();
            final double v2 = calculateV2();
            if (withGCU){
                gcu.eulerStep1(v2, dt);
                gcu.eulerStep2(v2, dt);
                vWindup = findWindup();
            if (vWindup == 1) {
                    gcu.setDxDt(0.0);
                    gcu.setStateX(vt*getData().getVrmax());  }                  
            if (vWindup == -1) {
                    gcu.setDxDt(0.0);
                    gcu.setStateX(vt*getData().getVrmin());  }
            
            }
            
            
            
            
            
            return true;
        } else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
            // TODO: TBImpl, currently only Euler method has been implemented
            return false;
        } else
            throw new InvalidInputException("UN5000Exciter.nextStep(), invalid method");
    }
    
    
    
    private double calculateVerr() {
        return 0.0 + calculatePSS();
    }
    private double calculateVc() {
        return 0.0;
    }
    private double calculateVuel() {
        return 0.0;
    }
    private double calculateVoel() {
        return 0.0;
    }
    private double calculatePSS() {
        return getMachine().hasStabilizer()? getMachine().getStabilizer().getOutput() : 0.0;
    }
    private double calculateV1() {
        return withD? tgr2.getY(calculateVerr()) : calculateVerr();
    }
    private double calculateV1u() {
        return withUD? tgru2.getY(calculateVerr()) : calculateVerr();
    }
    private double calculateV1o() {
        return withOD? tgro2.getY(calculateVerr()) : calculateVerr();
    }
    private double calculateVr1() {
        return withI? tgr1.getY(calculateV1()) : calculateV1();
    }
    private double calculateVru1() {
        return withUI? tgru1.getY(calculateV1u()) : calculateV1u();
    }
    private double calculateVro1() {
        return withOI? tgro1.getY(calculateV1o()) : calculateV1o();
    }
    
    private double calculateV2() {
        double hv = (calculateVc() >= calculateVuel())? calculateVc() : calculateVuel();
        double lv = (hv <= calculateVoel())? hv : calculateVoel();
        if (lv == calculateVc()) { 
            return vLimit.limit(calculateVr1()*getData().getKr()) - Ifd*getData().getKc();
        }else if (lv == calculateVuel()){
            return vLimit.limit(calculateVru1()*getData().getKr()) - Ifd*getData().getKc();
        }else return vLimit.limit(calculateVro1()*getData().getKr()) - Ifd*getData().getKc();
    }
    
    private double findWindup() {
        if (gcu.getStateX() > getData().getVrmax()) {
            return 1.0;
        }else if (gcu.getStateX() < getData().getVrmin()) {
            return -1.0;
        }else return 0.0;
    }
    
    // Step-5: Define Controller output (Efd)
    // =====================================
    
    public double getOutput() {
        return gcu.getStateX();
    }
    
    // Step-6: Defined Controller display variables
    // ============================================
        
    
    public Hashtable getStates(Object ref) {
        Hashtable table = super.getStates(ref);
        // Efd already added to the output symbol list, you can add more output variables as follows:
        table.put("vPSS", Num2Str.toStr("0.0000", calculatePSS()));
        table.put("Ifd", Num2Str.toStr("0.0000", Ifd));
        return table;
    }
    
    /*
     *  There is no need to make any change beyond this point
     */
    
    // UI Editor panel
    private static NBst5bExciterEditPanel _editPanel = new NBst5bExciterEditPanel();
    
    /**
     * Default Constructor
     *
     */
    public st5bExciter() {
        this("excId", "excName", "InterPSS");
    }
    
    /**
     * Constructor
     *
     * @param id excitor id
     * @param name excitor name
     */
    public st5bExciter(String id, String name, String caty) {
        super(id, name, caty);
        // _data is defined in the parent class. However init it here is a MUST
        _data = new st5bExciterData();
    }
    
    /**
     * Get the excitor data
     *
     * @return the data object
     */
    public st5bExciterData getData() {
        return (st5bExciterData)_data;
    }
    
    /**
     * Get the editor panel for controller data editing
     *
     * @return the editor panel object
     */
    public Object getEditPanel() {
        _editPanel.init(this);
        return _editPanel;
    }
    
    /*
     * The following methods are for unit testing purpose.
     */
    
    /**
     * Get the ref voltage Vref, for testing purpose.
     *
     * @return Returns the vref.
     */
    public double getStateVref() {
        return vRef;
    }
    
    /**
     * Get state variable X, for testing purpose.
     *
     * @return Returns the x.
     */
    public double getStateX() {
        return gcu.getStateX();
    }
    
    /**
     * Set the voltage ref point
     */
    public void setRefPoint(double x) {
	vRef = x;
    }     
}
