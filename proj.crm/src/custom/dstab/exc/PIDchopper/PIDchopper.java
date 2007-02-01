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

package custom.dstab.exc.PIDchopper;

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
import com.interpss.dstab.controller.block.PIControlBlock;
import com.interpss.dstab.controller.block.IntegrationControlBlock;
import com.interpss.dstab.controller.block.IControlBlock;
import com.interpss.dstab.mach.DynamicMachine;
import com.interpss.dstab.mach.Machine;


public class PIDchopper extends AbstractExciter {
    // Step-1: Define controller variables
    // ===================================
    
    private double vRef = 0.0;
    
    private PIControlBlock pi1 = null;
    private IntegrationControlBlock d1 = null;
    private DelayControlBlock UgMeasure = null;
    private LimitType vLimit = null;

    
    // Step-2: Initialization
    // ======================
    
    /**
     *  Init the controller states
     *
     *  @param msg the SessionMsg object
     */
    public boolean initStates(DStabBus abus, Machine mach, IPSSMsgHub msg) {
        double vt = abus.getVoltage().abs() / mach.getVMultiFactor();

        pi1 = new PIControlBlock(IControlBlock.Type_NonWindup,
               getData().getKp(), getData().getKi(),
               getData().getVrmax(), getData().getVrmin());
        if (!pi1.initState(mach.getEfd()/vt)) {
            msg.sendErrorMsg("Initialisation error: Efd exceeds limit");
            return false; }
        d1 = new IntegrationControlBlock(1.0);
        if (!d1.initState(vt)) {
            msg.sendErrorMsg("Initialisation error: D-part");
            return false; }
        UgMeasure = new DelayControlBlock(1, getData().getTr());
        if (!(UgMeasure.initState(vt))) {
            msg.sendErrorMsg("Initialisation Error Voltage feedback");
            return false;  }
        
        vRef = vt;
             
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
            
            final double vt = abus.getVoltage().abs() / mach.getVMultiFactor();
            UgMeasure.eulerStep1(vt, dt);
            UgMeasure.eulerStep1(vt, dt);
            final double ud = calculateUd(abus, mach);
            d1.eulerStep1(ud, dt);
            d1.eulerStep2(ud, dt);
            final double uerr = calculateUerr(abus, mach);
            pi1.eulerStep1(uerr, dt);
            pi1.eulerStep2(uerr, dt);
            
            return true;
        } else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
            // TODO: TBImpl, currently only Euler method has been implemented
            return false;
        } else
            throw new InvalidInputException("UN5000Exciter.nextStep(), invalid method");
    }
    
    
    private double calculateUg(DStabBus bus, Machine mach) {
        final double vt = bus.getVoltage().abs() / mach.getVMultiFactor();
        return UgMeasure.getY();
    }
    
    private double calculateUd(DStabBus bus, Machine mach) {
        return (calculateUg(bus, mach)-d1.getStateX())*getData().getKb()/(getData().getKb()*getData().getTb());
    }
   
    private double calculatePSS(DStabBus abus, Machine mach) {
        return mach.hasStabilizer()? mach.getStabilizer().getOutput(abus, mach) : 0.0;
    }
    
    private double calculateUerr(DStabBus abus, Machine mach) {
        final double udout = (calculateUg(abus, mach)-d1.getStateX())*(1.0 + getData().getKb());
        double vpss = calculatePSS(abus, mach);
        return vRef - udout + vpss;
    }
    
    // Step-5: Define Controller output (Efd)
    // =====================================
    
    public double getOutput(DStabBus abus, Machine mach) {
        final double vt = abus.getVoltage().abs() / mach.getVMultiFactor();
        return pi1.getY()*vt;
    }
    
    // Step-6: Defined Controller display variables
    // ============================================
        
    
    public Hashtable getStates(DStabBus abus, Machine mach, Object ref) {
        Hashtable table = super.getStates(abus, ref);
        // Efd already added to the output symbol list, you can add more output variables as follows:
        table.put("vPSS", Num2Str.toStr("0.0000", calculatePSS(abus, mach)));
        return table;
    }
    
    /*
     *  There is no need to make any change beyond this point
     */
    
    // UI Editor panel
    private static NBPIDchopperEditPanel _editPanel = new NBPIDchopperEditPanel();
    
    /**
     * Default Constructor
     *
     */
    public PIDchopper() {
        this("excId", "excName", "InterPSS");
    }
    
    /**
     * Constructor
     *
     * @param id excitor id
     * @param name excitor name
     */
    public PIDchopper(String id, String name, String caty) {
        super(id, name, caty);
        // _data is defined in the parent class. However init it here is a MUST
        _data = new PIDchopperData();
    }
    
    /**
     * Get the excitor data
     *
     * @return the data object
     */
    public PIDchopperData getData() {
        return (PIDchopperData)_data;
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
        return pi1.getStateX();
    }
    
    /**
     * Set the voltage ref point
     */
    public void setRefPoint(double x) {
	vRef = x;
    }     

    
    
}
