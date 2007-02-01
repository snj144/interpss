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
    
    private double vRef = 0.0, vt = 0.0, Xadu = 0.0, Ifd = 0.0;  /* general constants */
    private double Vc = 0.0, Vfd = 0.0;
    private boolean withGCU = true;     /* model gate controller delay */
    private boolean withIr = true;      /* model AVR regulator I-part */
    private boolean withDr = true;      /* model AVR regulator D-part */
    private boolean withIu = true;      /* model uel I-part */
    private boolean withDu = false;     /* model uel D-part, normally not in static */
    private boolean withIo = true;      /* model oel I-part */
    private boolean withDo = true;      /* model oel D-part */
    private boolean OELactive = false;
    private boolean UELactive = false;
    
    private boolean withTR = true;      /* non-zero measuring delays */
    
    LimitType vfdLimit = null;          /* rotating exciter final output limit */
    DelayControlBlock excTran = null;   /* rotating exciter transient block */
    DelayControlBlock excSub = null;    /* rotating exciter subtransient block */
    /* standard regulator */
    DelayControlBlock gcu = null;       /* regulator gcu block */
    LimitType vrLimit = null;           /* P-part limit */
    FilterControlBlock tgr1 = null;     /* I-part filter AVR */
    FilterControlBlock tgr2 = null;     /* D-part filter AVR */
    FilterControlBlock tgro1 = null;    /* I-part filter oel regulator */
    FilterControlBlock tgro2 = null;    /* D-part filter oel regulator */
    FilterControlBlock tgru1 = null;    /* I-part filter uel regulator */
    FilterControlBlock tgru2 = null;    /* D-part filter uel regulator */
    /* input conditioning */
    DelayControlBlock UgMeas = null;    /* Voltage measuring transducer */
    DelayControlBlock QgMeas = null;    /* VAr measuring transducer */
    DelayControlBlock PgMeas = null;    /* Power measuring transducer */

    
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
        /* Ifd is converted to excitation standard rotor base */
        
//        double cpd = Ifd*getData().getKc();     /* this would be used if a static exciter */
        
        /*
         * This section inits the rotating exciter part
         */
        double efo = mach.getEfd();
        if (efo > getData().getVfdmax()) {
            msg.sendErrorMsg("Machine Field Voltage exceeds limit");
            return false;        }
        if (efo < getData().getVfdmin()) {
            msg.sendErrorMsg("Machine Field Voltage exceeds limit");
            return false;        }
        vfdLimit = new LimitType(getData().getVfdmax(),getData().getVfdmin());
        double ifda = Ifd*getData().getKif();
        double vfda = efo * getData().getKvf();
        
        excTran = new DelayControlBlock(getData().getK4(), getData().getT4());
        if (!(excTran.initState(efo+ifda))) {
            msg.sendErrorMsg("Initialisation error: exciter Tran");
            return false; }
        
        excSub = new DelayControlBlock(IControlBlock.Type_Limit,
               getData().getK3(), getData().getT3(),
               getData().getV3max(), getData().getV3min());
        if (!(excSub.initState(excTran.getU0()))) {
            msg.sendErrorMsg("Initialisation error: exciter Sub");
            return false; }
        double Uf = excSub.getU0() + vfda;
        
        /*
         * this section inits the st5b AVR regulator part
         * Uf is the unmodified gcu output
         */
        
        withGCU = (!(getData().getT1() == 0.0));  // T1 not zero?
        withIr = (!(getData().getTb1() == 0.0));  // Tb1 not zero?
        withDr = (!(getData().getTb2() == 0.0));  // Tb2 not zero?
        //System.out.println("Has GCU block = " +withGCU +", Has AVR I-block = " +withIr +", Has AVR D-block = " +withDr);

        if (withGCU) {
        gcu = new DelayControlBlock(1, getData().getT1());
            if (!(gcu.initState(Uf))) {
                msg.sendErrorMsg("Initialisation error: GCU");
                return false;        }
            if (gcu.getU0() > getData().getVrmax()) {
                msg.sendErrorMsg("Initialisation error: Regulator output");
                return false;        }
            if (gcu.getU0() < getData().getVrmin()) {
                msg.sendErrorMsg("Initialisation error: Regulator output");
                return false;        }
        }
        
        /* static limit here used, should really be dynamic according to converter input voltage */
        vrLimit = new LimitType(getData().getVrmax(), getData().getVrmin());
        
        double vr1 = (withGCU)?   (gcu.getU0() / getData().getKr())
                                    : (Uf / getData().getKr());
        
        if (withIr) {
            tgr1 = new FilterControlBlock(IControlBlock.Type_NonWindup,
                   1, getData().getTc1(), getData().getTb1(),
                    getData().getVrmax() / getData().getKr(), 
                    getData().getVrmin() / getData().getKr());
            if(!(tgr1.initState(vr1))) {
                msg.sendErrorMsg("Initialisation Error AVR leadlag 1");
                return false;
            }
        }

        double vr2 = (withIr)? (tgr1.getU0()) : (vr1);
        double limitModifier = (withIr)? (getData().getTb1()/getData().getTc1()) : 1;
        
        if (withDr) {
            tgr2 = new FilterControlBlock(IControlBlock.Type_NonWindup,
                   1, getData().getTc2(), getData().getTb2(),
                    getData().getVrmax() / getData().getKr() * limitModifier, 
                    getData().getVrmin() / getData().getKr() * limitModifier);
            if(!(tgr2.initState(vr2))) {
                msg.sendErrorMsg("Initialisation Error AVR leadlag 2");
                return false;
            }
        }
        
        Vc = (withDr)? (tgr2.getU0()) : (vr2);
        
        /*
         * This section inits the input conditioning
         */
        
        withTR = (!(getData().getTr() == 0.0));  /* true if TR non-zero */
        
        if (withTR) {
            UgMeas = new DelayControlBlock(1, getData().getTr());
            if (!(UgMeas.initState(vt))) {
                msg.sendErrorMsg("Initialisation error Voltage measuring");
                return false;
            }
            QgMeas = new DelayControlBlock(1, getData().getTr());
            if (!(QgMeas.initState(mach.getQBus()))) {
                msg.sendErrorMsg("initialisation error VAr measuring");
                return false;
            }
            PgMeas = new DelayControlBlock(1, getData().getTr());
            if (!(PgMeas.initState(mach.getPe()))) {
                msg.sendErrorMsg("Initialisation error Pe measuring");
                return false;
            }
            
        } 
            
        
        vRef = Vc + vt 
               - (mach.getQBus() * getData().getKir())
               - (mach.getPe() * getData().getKia());
        
        
        //System.out.println("Vt = "+vt +", Ug = " +UgMeas.getU0());
        
        /*
         * This section inits the limiter regulators
         */
        withIu = (!(getData().getTub1() == 0.0));
        withDu = (!(getData().getTub2() == 0.0));
        withIo = (!(getData().getTob1() == 0.0));
        withDo = (!(getData().getTob2() == 0.0));
        double olimMod = (withIo)? (getData().getTob1()/getData().getToc1()) : 1;
        double ulimMod = (withIu)? (getData().getTub1()/getData().getTuc1()) : 1;
        
        double tgro2Y = Vc;
        if (withIo) {
            tgro2 = new FilterControlBlock(IControlBlock.Type_NonWindup,
                    1, getData().getToc2(), getData().getTob2(),
                    getData().getVrmax() / getData().getKr() * olimMod, 
                    getData().getVrmin() / getData().getKr() * olimMod);
            if (!(tgro2.initState(Vc/getData().getTob2()))) {
                msg.sendErrorMsg("Initialisation error tgro2");
                return false;        }
            tgro2Y = (Vc / getData().getTob2()) + (Vc * getData().getToc2());
        }
        
        double tgru2Y = Vc;
        if (withIu) {
            tgru2 = new FilterControlBlock(IControlBlock.Type_NonWindup,
                    1, getData().getTuc2(), getData().getTub2(),
                    getData().getVrmax() / getData().getKr() * ulimMod, 
                    getData().getVrmin() / getData().getKr() * ulimMod);
            if (!(tgru2.initState(Vc/getData().getTub2()))) {
                msg.sendErrorMsg("Initialisation error tgru2");
                return false;        }
            tgru2Y = (Vc / getData().getTub2()) + (Vc * getData().getTuc2());
        }
        
        if (withDo) {
            tgro1 = new FilterControlBlock(IControlBlock.Type_NonWindup,
                    1, getData().getToc1(), getData().getTob1(),
                    getData().getVrmax() / getData().getKr(), 
                    getData().getVrmin() / getData().getKr());
            if (!(tgro1.initState(tgro2Y/getData().getTob1()))) {
                msg.sendErrorMsg("Initialisation error tgro1");
                return false;        }
        }
        
        if (withDu) {
            tgru1 = new FilterControlBlock(IControlBlock.Type_NonWindup,
                    1, getData().getTuc1(), getData().getTub1(),
                    getData().getVrmax() / getData().getKr(), 
                    getData().getVrmin() / getData().getKr());
            if (!(tgru1.initState(tgru2Y/getData().getTub1()))) {
                msg.sendErrorMsg("Initialisation error tgru1");
                return false;        }
        }
        
        
        
        return true;    // Successfully completed init phase
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
            /* input conditioning */
            vt = abus.getVoltage().abs() / mach.getVMultiFactor();
            double qt = mach.getQBus();
            double pt = mach.getPe();
            
            if (withTR) {
                UgMeas.eulerStep1(vt, dt);
                UgMeas.eulerStep2(vt, dt);
                QgMeas.eulerStep1(qt, dt);
                QgMeas.eulerStep2(qt, dt);
                PgMeas.eulerStep1(pt, dt);
                PgMeas.eulerStep2(pt, dt);
            }
            final double ug = getUg(abus, mach);
            final double Qdroop = getQdroop(abus, mach);
            final double Pdroop = getPdroop(abus, mach);
            Vc = vRef - ug + Qdroop + Pdroop;
            
            
            /* regulators */
            
            double vin = Math.min(Math.max(Vc, calculateVuel()), calculateVoel())
                            + calculatePSS(abus, mach);
            
            OELactive = (vin > Vc);
            UELactive = (vin < Vc);
            
            if (withDr) {
                tgr2.eulerStep1(vin, dt);
                tgr2.eulerStep2(vin, dt);
            }
            
            if (withDo) {
                tgro2.eulerStep1(vin, dt);
                tgro2.eulerStep2(vin, dt);
            }
            
            if (withDu) {
                tgru2.eulerStep1(vin, dt);
                tgru2.eulerStep2(vin, dt);
            }
            
            double[] vr2 = getVr2(vin);     /* [AVR, OEL, UEL] d-part y values */
            
            if (withIr) {
                tgr1.eulerStep1(vr2[0], dt);
                tgr1.eulerStep2(vr2[0], dt);
            }
            
            if (withIo) {
                tgro1.eulerStep1(vr2[1], dt);
                tgro1.eulerStep2(vr2[1], dt);
            }
            
            if (withIu) {
                tgru1.eulerStep1(vr2[2], dt);
                tgru1.eulerStep2(vr2[2], dt);
            }
            
            double[] vr1 = getVr1(vr2);     /* order is [AVR, OEL, UEL] */
            /*
             * following code selects which regulator is active 
             * then multiplies by regulator gain, limited to Vrmax/min
             */
            double Uc = vrLimit.limit(
                        (UELactive)? vr1[2] : ((OELactive)? vr1[1] : vr1[0])
                        * getData().getKr());
            
            if (withGCU) {
                gcu.eulerStep1(Uc, dt);
                gcu.eulerStep2(Uc, dt);
            }
            
            double Uf = getUf(Uc);
            

            /* rotating exciter */
            
            double ufi = Uf - mach.getEfd()*getData().getKvf();
            excSub.eulerStep1(ufi, dt);
            excSub.eulerStep2(ufi, dt);
            final double v3 = calculateV3(ufi);
            excTran.eulerStep1(v3, dt);
            excTran.eulerStep2(v3, dt);
            final double v4 = calculateV4(v3);
            Ifd = ((DynamicMachine)mach).calculateIfd(abus) *Xadu;
            Vfd = v4 - Ifd * getData().getKif();
            
            return true;
        } else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
            // TODO: TBImpl, currently only Euler method has been implemented
            return false;
        } else
            throw new InvalidInputException("st5bExciter.nextStep(), invalid method");
    }
    
    
    
    private double getUg(DStabBus abus, Machine mach) {
        if (withTR) { return UgMeas.getY();
        } else return vt;
    }
    
    private double getQdroop(DStabBus abus, Machine mach) {
        if (withTR) { return QgMeas.getY() * getData().getKir();
        }else return mach.getQBus() * getData().getKir();
    }
    
    private double getPdroop(DStabBus abus, Machine mach) {
        if (withTR) { return PgMeas.getY() * getData().getKia();
        } else return mach.getPe() * getData().getKia();
    }
    
    private double calculateVuel() {
        return -100.0;
    }
    private double calculateVoel() {
        return 100.0;
    }
    private double calculatePSS(DStabBus abus, Machine mach) {
        return mach.hasStabilizer()? mach.getStabilizer().getOutput(abus) : 0.0;
    }
    private double[] getVr2(double vin) {
        double[] vr2y = new double[3];
        vr2y[0] = (withDr)? tgr2.getY() : vin;
        vr2y[1] = (withDo)? tgro2.getY() : vin;
        vr2y[2] = (withDu)? tgru2.getY() : vin;
        
        return vr2y;
    }
    
    private double[] getVr1(double[] vr2) {
        double[] vr1y = new double[3];
        vr1y[0] = (withIr)? tgr1.getY() : vr2[0];
        vr1y[1] = (withIo)? tgro1.getY() : vr2[1];
        vr1y[2] = (withIu)? tgru1.getY() : vr2[2];
        
        return vr1y;
    }
    
    private double getUf(double Uc) {
        return (withGCU)? gcu.getY() : Uc;
    }


    private double calculateV3(double ufi) {
        return excSub.getY();
    }
    private double calculateV4(double v3) {
        return excTran.getY();
    }
    
    // Step-5: Define Controller output (Efd)
    // =====================================
    
    public double getOutput(DStabBus abus, Machine mach) {
        double v4 = excTran.getStateX() - Ifd*getData().getKif();
        return vfdLimit.limit(v4);
    }
    
    // Step-6: Defined Controller display variables
    // ============================================
        
    
    public Hashtable getStates(DStabBus abus, Machine mach, Object ref) {
        Hashtable table = super.getStates(abus, mach, ref);
        // Efd already added to the output symbol list, you can add more output variables as follows:
        table.put("vRef", vRef);
        table.put("Pt", mach.getPe());
        table.put("Pdroop", getPdroop(abus, mach));
        table.put("Qt", mach.getQBus());
        table.put("Qdroop", getQdroop(abus, mach));
        table.put("Vt", abus.getVoltage().abs() / mach.getVMultiFactor());
        table.put("Ug", getUg(abus, mach));
        table.put("vPSS", calculatePSS(abus, mach));
        
        table.put("vr2", tgr2.getStateX());
        table.put("vr1", tgr1.getStateX());
        table.put("Vc", Vc);
        
        table.put("Ifd", Ifd);
        table.put("v4", excTran.getStateX());
        table.put("v3", excSub.getStateX());
        table.put("OEL", OELactive);
        table.put("UEL", UELactive);
        
        
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
        return excTran.getStateX();
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
