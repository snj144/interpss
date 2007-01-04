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

package custom.dstab.exc.st5b;

/*
 * Controller diff eqn implementation class
 */

import java.util.Hashtable;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.Num2Str;
import com.interpss.core.net.Network;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.controller.AbstractExciter;
import com.interpss.dstab.controller.block.DelayControlBlock;
import com.interpss.dstab.controller.block.FilterControlBlock;
import com.interpss.dstab.controller.block.IControlBlock;
import com.interpss.dstab.mach.DynamicMachine;
import com.interpss.dstab.mach.Machine;


public class st5bExciter extends AbstractExciter {
    // Step-1: Define controller variables
    // ===================================
    
    private double vRef = 0.0, Vc = 0.0, Xadu = 0.0, Ifd = 0.0, vt = 0.0, vWindup = 0.0;
    private double pt = 0.0, qt = 0.0, Uf = 0.0, v3lim = 0.0;
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
    private LimitType vrLimit = null;
    // blocks for the input conditioning
    private DelayControlBlock UgMeas = null;
    private DelayControlBlock QgMeas = null;
    private DelayControlBlock PgMeas = null;
    // blocks for the rotating exciter
    private DelayControlBlock excSub = null;
    private DelayControlBlock excTran = null;
    private LimitType v3Limit = null;
    private LimitType vfdLimit = null;

    
    // Step-2: Initialization
    // ======================
    
    /**
     *  Init the controller states
     *
     *  @param msg the SessionMsg object
     */
    public boolean initStates(DStabBus abus, Machine mach, IPSSMsgHub msg) {
        vt = abus.getVoltage().abs() / mach.getVMultiFactor();
        Xadu = mach.getMachData().getXd() - mach.getMachData().getXl();
        Ifd = ((DynamicMachine)mach).calculateIfd(abus) *Xadu;
        // Ifd is converted to excitation standard rotor base
        // used in rotating exciter and/or st5b controller
        double cpd = Ifd*getData().getKc();
        
        /*
         * This section implements the rotating exciter part
         */
        double efo = mach.getEfd();
        double ifda = Ifd*getData().getKif();
        vfdLimit = new LimitType(getData().getVfdmax(),getData().getVfdmin());
        efo = (efo > getData().getVfdmax())? getData().getVfdmax() : efo;
        efo = (efo < getData().getVfdmin())? getData().getVfdmin() : efo;
        excTran = new DelayControlBlock(getData().getK4(), getData().getT4());
        if (!(excTran.initState(efo+ifda))) {
            msg.sendErrorMsg("Initialisation error: exciter Tran");
            return false; }
        v3Limit = new LimitType(getData().getV3max(), getData().getV3min());
        double v3 = excTran.getU0();
        v3 = (v3 > getData().getV3max())? getData().getV3max() : v3;
        v3 = (v3 < getData().getV3min())? getData().getV3min() : v3;
        v3lim = v3;
        excSub = new DelayControlBlock(getData().getK3(), getData().getT3());
        if (!(excSub.initState(v3))) {
            msg.sendErrorMsg("Initialisation error: exciter Sub");
            return false; }
        Uf = excSub.getU0()+ efo*getData().getKvf();
        
        /*
         * this section implements the st5b regulator part
         */
        gcu = new DelayControlBlock(1, getData().getT1());
        if (!gcu.initState(Uf)) {
            msg.sendErrorMsg("Initialisation error: Uf ");
            return false; }
        
        vrLimit = new LimitType(getData().getVrmax(), getData().getVrmin());
        
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
        if (!(tgr1.initState(gcu.getU0()/getData().getKr()))) {
            msg.sendErrorMsg("Initialisation error: tgr1 init exceeds limit");
            return false; }
        tgru1 = new FilterControlBlock(IControlBlock.Type_NonWindup,
               1, getData().getTuc1(), getData().getTub1(),
               getData().getVrmax()/getData().getKr(), getData().getVrmin()/getData().getKr());
        if (!(tgru1.initState(gcu.getU0()/getData().getKr()))) {
            msg.sendErrorMsg("Initialisation error: tgru1 init exceeds limit");
            return false; }
        tgro1 = new FilterControlBlock(IControlBlock.Type_NonWindup,
               1, getData().getToc1(), getData().getTob1(),
               getData().getVrmax()/getData().getKr(), getData().getVrmin()/getData().getKr());
        if (!(tgro1.initState(gcu.getU0()/getData().getKr()))) {
            msg.sendErrorMsg("Initialisation error: tgro1 init exceeds limit");
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
        if (!tgr2.initState(tgr1.getU0())) {
            msg.sendErrorMsg("Initialisation error: tgr2 init exceeds limit");
            return false; }
        tgru2 = new FilterControlBlock(IControlBlock.Type_NonWindup,
               1, getData().getTuc2(), getData().getTub2(),
               getData().getVrmax()/getData().getKr()*tgruRatio,
               getData().getVrmin()/getData().getKr()*tgruRatio);
        if (!tgru2.initState(tgru1.getU0())) {
            msg.sendErrorMsg("Initialisation error: tgru2 init exceeds limit");
            return false; }
        tgro2 = new FilterControlBlock(IControlBlock.Type_NonWindup,
               1, getData().getToc2(), getData().getTob2(),
               getData().getVrmax()/getData().getKr()*tgroRatio,
               getData().getVrmin()/getData().getKr()*tgroRatio);
        if (!tgro2.initState(tgro1.getU0())) {
            msg.sendErrorMsg("Initialisation error: tgro2 init exceeds limit");
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
        
        /*
         * This section implements the input conditioning
         */
        
        UgMeas = new DelayControlBlock(1, getData().getTr());
        if (!UgMeas.initState(vt)) {
            msg.sendErrorMsg("Initialisation error: V measuring");
            return false; }
        QgMeas = new DelayControlBlock(1, getData().getTr());
        if (!QgMeas.initState(mach.getQBus())) {
            msg.sendErrorMsg("Initialisation error: Q measuring");
            return false; }
        PgMeas = new DelayControlBlock(1, getData().getTr());
        if (!PgMeas.initState(mach.getPe())) {
            msg.sendErrorMsg("Initialisation error: P measuring");
            return false; }
        
        vRef = Vc + UgMeas.getU0() - QgMeas.getU0()*getData().getKir() - PgMeas.getU0()*getData().getKia();

        
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
    public boolean nextStep(double dt, DynamicSimuMethods method, DStabBus abus, Machine mach, Network net, IPSSMsgHub msg) {
        if (method == DynamicSimuMethods.MODIFIED_EULER_LITERAL) {
            // inputs
            vt = abus.getVoltage().abs() / mach.getVMultiFactor();
            UgMeas.eulerStep1(vt, dt);
            UgMeas.eulerStep2(vt, dt);
            qt = mach.getQBus();
            QgMeas.eulerStep1(qt, dt);
            QgMeas.eulerStep2(qt, dt);
            pt = mach.getPe();
            PgMeas.eulerStep1(pt, dt);
            PgMeas.eulerStep2(pt, dt);
            // regulator
            Vc = calculateVerr(abus, mach);
            if (withD) {
                tgr2.eulerStep1(Vc, dt);
                tgr2.eulerStep2(Vc, dt); }
            if (withUD) {
                tgru2.eulerStep1(Vc, dt);
                tgru2.eulerStep2(Vc, dt); }
            if (withOD) {
                tgro2.eulerStep1(Vc, dt);
                tgro2.eulerStep2(Vc, dt); }
            
            final double v1 = calculateV1(abus, mach);
            if (withI) {
                tgr1.eulerStep1(v1, dt);
                tgr1.eulerStep2(v1, dt); }
            final double v1u = calculateV1u(abus, mach);
            if (withUI) {
                tgru1.eulerStep1(v1u, dt);
                tgru1.eulerStep2(v1u, dt); }
            final double v1o = calculateV1o(abus, mach);
            if (withOI) {
                tgro1.eulerStep1(v1o, dt);
                tgro1.eulerStep2(v1o, dt); }
                                   
            double Xadu = mach.getMachData().getXd() 
                          - mach.getMachData().getXl();
            Ifd = ((DynamicMachine)mach).calculateIfd(abus) *Xadu;
            
            
            final double v2 = calculateV2(abus, mach);
            if (withGCU){
                gcu.eulerStep1(v2, dt);
                gcu.eulerStep2(v2, dt);
                vWindup = findWindup();
            if (vWindup == 1) {
                    gcu.setDxDt(0.0);
                    gcu.setStateX(getData().getVrmax());  }                  
            if (vWindup == -1) {
                    gcu.setDxDt(0.0);
                    gcu.setStateX(getData().getVrmin());  }
            }
            // rotating exciter
            final double Uf = calculateUf();
            double ufi = Uf - mach.getEfd();
            excSub.eulerStep1(ufi, dt);
            excSub.eulerStep2(ufi, dt);
            final double v3 = calculateV3(mach);
            v3lim = v3Limit.limit(v3);
            excTran.eulerStep1(v3lim, dt);
            excTran.eulerStep2(v3lim, dt);
            
            return true;
        } else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
            // TODO: TBImpl, currently only Euler method has been implemented
            return false;
        } else
            throw new InvalidInputException("st5bExciter.nextStep(), invalid method");
    }
    
    
    
    private double calculateVerr(DStabBus abus, Machine mach) {
        double vpss = calculatePSS(abus, mach);
        double ug = UgMeas.getY(vt);
        double qgr = QgMeas.getY(qt)*getData().getKir();
        double pgr = PgMeas.getY(pt)*getData().getKia();
        return vRef - ug + qgr + pgr + vpss;
    }
    
    private double calculateVuel() {
        return -10.0;
    }
    private double calculateVoel() {
        return 10.0;
    }
    private double calculatePSS(DStabBus abus, Machine mach) {
        return mach.hasStabilizer()? mach.getStabilizer().getOutput(abus) : 0.0;
    }
    private double calculateV1(DStabBus abus, Machine mach) {
        return withD? tgr2.getY(calculateVerr(abus, mach)) : calculateVerr(abus, mach);
    }
    private double calculateV1u(DStabBus abus, Machine mach) {
        return withUD? tgru2.getY(calculateVerr(abus, mach)) : calculateVerr(abus, mach);
    }
    private double calculateV1o(DStabBus abus, Machine mach) {
        return withOD? tgro2.getY(calculateVerr(abus, mach)) : calculateVerr(abus, mach);
    }
    private double calculateVr1(DStabBus abus, Machine mach) {
        return withI? tgr1.getY(calculateV1(abus, mach)) : calculateV1(abus, mach);
    }
    private double calculateVru1(DStabBus abus, Machine mach) {
        return withUI? tgru1.getY(calculateV1u(abus, mach)) : calculateV1u(abus, mach);
    }
    private double calculateVro1(DStabBus abus, Machine mach) {
        return withOI? tgro1.getY(calculateV1o(abus, mach)) : calculateV1o(abus, mach);
    }
    
    private double calculateV2(DStabBus abus, Machine mach) {
        double hv = (Vc >= calculateVuel())? Vc : calculateVuel();
        double lv = (hv <= calculateVoel())? hv : calculateVoel();
        if (lv == Vc) { 
            return vrLimit.limit(calculateVr1(abus, mach)*getData().getKr()) - Ifd*getData().getKc();
        }else if (lv == calculateVuel()){
            return vrLimit.limit(calculateVru1(abus, mach)*getData().getKr()) - Ifd*getData().getKc();
        }else return vrLimit.limit(calculateVro1(abus, mach)*getData().getKr()) - Ifd*getData().getKc();
    }
    
    private double findWindup() {
        if (gcu.getStateX() > getData().getVrmax()) {
            return 1.0;
        }else if (gcu.getStateX() < getData().getVrmin()) {
            return -1.0;
        }else return 0.0;
    }
    
    private double calculateUf() {
        return gcu.getStateX();
    }
    private double calculateV3(Machine mach) {
        return excSub.getY(calculateUf()-(mach.getEfd()*getData().getKvf()));
    }
    
    
    // Step-5: Define Controller output (Efd)
    // =====================================
    
    public double getOutput(DStabBus abus, Machine mach) {
        double v4 = excTran.getY(v3lim)-Ifd*getData().getKif();
        return vfdLimit.limit(v4);
    }
    
    // Step-6: Defined Controller display variables
    // ============================================
        
    
    public Hashtable getStates(DStabBus abus, Machine mach, Object ref) {
        Hashtable table = super.getStates(abus, mach, ref);
        // Efd already added to the output symbol list, you can add more output variables as follows:
        table.put("vPSS", Num2Str.toStr("0.00000000", calculatePSS(abus, mach)));
        table.put("Ifd", Num2Str.toStr("0.00000000", Ifd));
        table.put("Vt", Num2Str.toStr("0.00000000", vt));
        table.put("Ug", Num2Str.toStr("0.00000000", UgMeas.getY(vt)));
        table.put("Pt", Num2Str.toStr("0.00000000", mach.getPe()));
        table.put("Pg", Num2Str.toStr("0.00000000", PgMeas.getY(mach.getPe())));
        table.put("Qt", Num2Str.toStr("0.00000000", mach.getQBus()));
        table.put("Qg", Num2Str.toStr("0.00000000", QgMeas.getY(mach.getQBus())));
        table.put("vRef", Num2Str.toStr("0.00000000", vRef));
        table.put("Vc", Num2Str.toStr("0.00000000", Vc));
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
    /**
     * Get the voltage ref point
     */
    public double getRefPoint() {
	return vRef;
    }

    
}
