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

package abb.custom.dstab.pss.ieee.ieee2b;

import java.util.Hashtable;

import com.interpss.dstab.controller.block.WashoutControlBlock;
import com.interpss.dstab.controller.block.DelayControlBlock;
import com.interpss.dstab.controller.block.FilterControlBlock;
import com.interpss.dstab.controller.block.IControlBlock;

import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.Num2Str;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.controller.AbstractStabilizer;

public class IEEE2B extends AbstractStabilizer {
    // declarations
    private DelayControlBlock dwMeasure = null;
    private DelayControlBlock PeMeasure = null;
    private WashoutControlBlock wash1 = null;
    private WashoutControlBlock wash2 = null;
    private WashoutControlBlock wash3 = null;
    private DelayControlBlock dpInt = null;
    private DelayControlBlock noT8 = null;
    private FilterControlBlock withT8 = null;
    private DelayControlBlock rtfilt2 = null;
    private DelayControlBlock rtfilt3 = null;
    private DelayControlBlock rtfilt4 = null;
    private DelayControlBlock rtfilt5 = null;
    private FilterControlBlock leadlag1 = null;
    private FilterControlBlock leadlag2 = null;
    private FilterControlBlock leadlag3 = null;
    
    /**
     *  Init the controller states
     *
     *  @param msg the SessionMsg object
     */
    public boolean initStates(IPSSMsgHub msg) {
        
        final double dw = getMachine().getSpeed() - 1.0;
        final double pe = getMachine().getPe();
        dwMeasure = new DelayControlBlock(1, 0.020);
        dwMeasure.initState(dw);
        PeMeasure = new DelayControlBlock(1, 0.020);
        PeMeasure.initState(pe);
        wash1 = new WashoutControlBlock(1, getData().getTw1());
        wash1.initState(dw);
        wash2 = new WashoutControlBlock(1, getData().getTw2());
        wash2.initState(0.0);
        wash3 = new WashoutControlBlock(1, getData().getTw3());
        wash3.initState(pe);
        dpInt = new DelayControlBlock(getData().getKs2(), getData().getT7());
        dpInt.initState(0.0);
        if (!(getData().getT8() == 0.0)) {
            withT8 = new FilterControlBlock(1, getData().getT8(), getData().getT9());
            withT8.initState(0.0);
        } else {noT8 = new DelayControlBlock(1, getData().getT9());
            noT8.initState(0.0);        }
        
        rtfilt2 = new DelayControlBlock(1, getData().getT9());
        rtfilt2.initState(0.0);
        rtfilt3 = new DelayControlBlock(1, getData().getT9());
        rtfilt3.initState(0.0);
        rtfilt4 = new DelayControlBlock(1, getData().getT9());
        rtfilt4.initState(0.0);
        rtfilt5 = new DelayControlBlock(1, getData().getT9());
        rtfilt5.initState(0.0);
        leadlag1 = new FilterControlBlock(getData().getKs1(), getData().getT1(), getData().getT2());
        leadlag1.initState(0.0);
        leadlag2 = new FilterControlBlock(1, getData().getT3(), getData().getT4());
        leadlag2.initState(0.0);
        leadlag3 = new FilterControlBlock(IControlBlock.Type_Limit,
               1, getData().getT10(), getData().getT11(),
               getData().getVsmax(), getData().getVsmin());
        leadlag3.initState(0.0);

        return true;
    }
    
        
    /**
     * Perform one step d-eqn calculation
     *
     * @param dt simulation time interval
     * @param method d-eqn solution method
     *  @param msg the SessionMsg object
     */
    public boolean nextStep(double dt, DynamicSimuMethods method, double baseFreq, IPSSMsgHub msg) {
        if (method == DynamicSimuMethods.MODIFIED_EULER_LITERAL) {
            final double dw = calculateDw();
            dwMeasure.eulerStep1(dw, dt);
            dwMeasure.eulerStep2(dw, dt);
            final double dww = calculateDww();
            wash1.eulerStep1(dww, dt);
            wash1.eulerStep2(dww, dt);
            final double w1 = calculateW1();
            wash2.eulerStep1(w1, dt);
            wash2.eulerStep2(w1, dt);
            final double pe = calculatePe();
            PeMeasure.eulerStep1(pe, dt);
            PeMeasure.eulerStep2(pe, dt);
            final double pef = calculatePef();
            wash3.eulerStep1(pef, dt);
            wash3.eulerStep2(pef, dt);
            final double w3 = calculateW3();
            dpInt.eulerStep1(w3, dt);
            dpInt.eulerStep2(w3, dt);
            final double rtin = calculateRtin();
            if (!(getData().getT8() == 0)) {
                withT8.eulerStep1(rtin, dt);
                withT8.eulerStep2(rtin, dt);
            }else {
                noT8.eulerStep1(rtin, dt);
                noT8.eulerStep2(rtin, dt);
            }
            final double rt1 = calculateRt1();
            rtfilt2.eulerStep1(rt1, dt);
            rtfilt2.eulerStep2(rt1, dt);
            final double rt2 = calculateRt2();
            rtfilt3.eulerStep1(rt2, dt);
            rtfilt3.eulerStep2(rt2, dt);
            final double rt3 = calculateRt3();
            rtfilt4.eulerStep1(rt3, dt);
            rtfilt4.eulerStep2(rt3, dt);
            final double rt4 = calculateRt4();
            rtfilt5.eulerStep1(rt4, dt);
            rtfilt5.eulerStep2(rt4, dt);
            
            final double pacc = calculateDPacc();
            leadlag1.eulerStep1(pacc, dt);
            leadlag1.eulerStep2(pacc, dt);
            final double LL1 = calculateLL1();
            leadlag2.eulerStep1(LL1, dt);
            leadlag2.eulerStep2(LL1, dt);
            final double LL2= calculateLL2();
            leadlag3.eulerStep1(LL2, dt);
            leadlag3.eulerStep2(LL2, dt);
            
            return true;
        } else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
            // TODO: TBImpl
            return false;
        } else
            throw new InvalidInputException("SimplePSS.nextStep(), invalid method");
    }
    
    
    /*
     * Some handy calculations
     *
     */
    
    private double calculateDw() {
        return getMachine().getSpeed() -1.0;    }
    private double calculateDww() {
        return dwMeasure.getY(calculateDw());    }
    private double calculateW1() {
        return wash1.getY(calculateDww());    }
    private double calculatePe() {
        return getMachine().getPe();    }
    private double calculatePef() {
        return PeMeasure.getY(calculatePe());    }
    private double calculateW3() {
        return wash3.getY(calculatePef());    }
    private double calculateRtin() {
        return wash2.getY(calculateW1())+(dpInt.getY(calculateW3())*getData().getKs3());
    }
    private double calculateRt1() {
        if (!(getData().getT8() == 0.0)) {
            return withT8.getY(calculateRtin());
        }else return noT8.getY(calculateRtin());
    }
    private double calculateRt2() {
        return rtfilt2.getY(calculateRt1());
    }
    private double calculateRt3() {
        return rtfilt3.getY(calculateRt2());
    }
    private double calculateRt4() {
        return rtfilt4.getY(calculateRt3());
    }
    private double calculateRt5() {
        return rtfilt5.getY(calculateRt4());
    }
    private double calculateDPacc() {
        return calculateRt5() - dpInt.getY(calculateW3());
    }
    private double calculateLL1() {
        return leadlag1.getY(calculateDPacc());
    }
    private double calculateLL2() {
        return leadlag2.getY(calculateLL1());
    }
    private double calculateLL3() {
        return leadlag3.getY(calculateLL2());
    }
    
    
    
    
    /**
     * Get controller states for display purpose
     *
     * @return hashtable of the states
     */
    public Hashtable getStates(Object ref) {
        Hashtable table = super.getStates(ref);
        //table.put("PSS_Vs", Num2Str.toStr("0.0000", getOutput()));
        return table;
    }
    
    /**
     * Get the controller output
     *
     * @return the output
     */
    public double getOutput() {
        final double out = calculateLL3();
        return out;
    }
    
    
    /*
     *  There is no need to make any change beyond this point
     */
    
    // UI Editor panel
    private static NBIEEE2BEditPanel _editPanel = new NBIEEE2BEditPanel();
    
    /**
     * Default constructor
     *
     */
    public IEEE2B() {
        this("pssId", "pssName", "InterPSS");
    }
    
    /**
     * Constructor
     *
     * @param id pss id
     * @param name pss name
     */
    public IEEE2B(String id, String name, String caty) {
        super(id, name, caty);
        // _data is defined in the parent class. However init it here is a MUST
        _data = new IEEE2BData();
    }
    
    /**
     * Get the PSS data
     *
     * @return the data object
     */
    public IEEE2BData getData() {
        return (IEEE2BData)_data;
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
    
    /**
     * Set the ref point
     */
    public void setRefPoint(double x) {
    }     
} // SimpleExcAdapter
