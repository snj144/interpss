 /*
  * @(#)Ieee1968Type3Exciter.java   
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
  * @Date 04/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.dstab.control.exc.ieee.y1968.type3;

import java.lang.reflect.Field;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.func.CMLFieldType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.controller.annotate.AnController;
import com.interpss.dstab.controller.annotate.AnControllerField;
import com.interpss.dstab.controller.annotate.AnnotateExciter;
import com.interpss.dstab.controller.block.DelayControlBlock;
import com.interpss.dstab.controller.block.IStaticBlock;
import com.interpss.dstab.controller.block.StaticBlockAdapter;
import com.interpss.dstab.controller.block.WashoutControlBlock;
import com.interpss.dstab.mach.Machine;

@AnController(
		   input="this.refPoint - mach.vt + pss.vs - this.washoutBlock.y",
		   output="this.delayBlock.y",
		   refPoint="this.kaDelayBlock.u0 - pss.vs + mach.vt + this.washoutBlock.y",
		   display= {})
public class Ieee1968Type3Exciter extends AnnotateExciter {
	   public double ka = 50.0, ta = 0.05, vrmax = 10.0, vrmin = 0.0;
	   @AnControllerField(
	      type= CMLFieldType.ControlBlock,
	      input="this.refPoint + pss.vs - mach.vt - this.washoutBlock.y",
	      parameter={"type.NonWindup", "this.ka", "this.ta", "this.vrmax", "this.vrmin"},
	      y0="this.customBlock.u0"	)
	   DelayControlBlock kaDelayBlock;

	   public double kp = 2.0, ki = 1.0, vbmax = 10.0;
	   @AnControllerField(
	      type= CMLFieldType.StaticBlock,
	      input= "this.kaDelayBlock.y", 
	      y0="this.delayBlock.u0"    )
	   public IStaticBlock customBlock = new StaticBlockAdapter() {
	      private LimitType limit = new LimitType(vbmax, 0.0);
	      private boolean A_gt_1 = false;
	      private double u = 0.0;
	                  
	      public boolean initStateY0(double y0) {
	         if ( y0 > vbmax || y0 < 0.0) {
	            getMsgHub().sendWarnMsg("CustomBlock init problem: y0 > vbmax or y0 < 0.0");
	            return false;
	         }
	         double x = calFunc();
	         if ( this.A_gt_1 && y0 != 0.0 ) {
	            getMsgHub().sendWarnMsg("CustomBlock init problem: A > 1 and y0 != 0.0");
	            return false;         
	         }
	         this.u = y0 - x;
	         return true;
	      }

	      public double getU0() {
	         return this.u;
	      }

	      public void eulerStep1(double u, double dt) {
	         this.u = u;
	      }

	      public void eulerStep2(double u, double dt) {
	         this.u = u;
	      }
	 
	      public double getY() {
	         double x = calFunc();
	         if ( this.A_gt_1 )
	           return 0.0;
	         else {
	           return this.limit.limit(this.u + x);
	         }
	      }

	      private double calFunc() {
	         Machine mach = getMachine();
	         DStabBus dbus = mach.getDStabBus();

	         // calculate Ve
	         double vt = mach.getVdq(dbus).abs();
	         double it = mach.getIdq(dbus).abs();
	         double ve = new Complex(kp*vt, ki*it).abs();

	         // calculate sqrt( 1 - A )
	         double xad = mach.getMachData().getXd() - mach.getMachData().getXl();
	         double ifd = mach.calculateIfd(dbus);
	         double a = 0.78 * xad * ifd * ifd / ve;
	         if (a > 1.0) {
	            //System.out.println("ve, xad, ifd, a: " + ve + ", " + xad + ", " + ifd + ", " + a);
	            this.A_gt_1 = true;
	 				return 0.0;
	         }
	         else {
	            this.A_gt_1 = false;
	            return ve * Math.sqrt(1.0 - a);
	         }
	      }
	   };

	   public double ke1 = 1.0 /* ke1 = 1/Ke  */, te_ke = 0.1 /* te_ke = Te/Ke */;
	   @AnControllerField(
	      type= CMLFieldType.ControlBlock,
	      input="this.customBlock.y",
	      parameter={"type.NoLimit", "this.ke1", "this.te_ke"},
	      y0="mach.efd"	)
	   DelayControlBlock delayBlock;


	   public double kf = 1.0, tf = 0.05;
	   @AnControllerField(
	      type= CMLFieldType.ControlBlock,
	      input="this.delayBlock.y",
	      parameter={"type.NoLimit", "this.kf", "this.tf"},
	      feedback = true	)
	   WashoutControlBlock washoutBlock;

    // UI Editor panel
    private static NBIeee1968Type3EditPanel _editPanel = new NBIeee1968Type3EditPanel();
    
    /**
     * Default Constructor
     *
     */
    public Ieee1968Type3Exciter() {
        this("excId", "excName", "InterPSS");
    }
    
    /**
     * Constructor
     *
     * @param id excitor id
     * @param name excitor name
     */
    public Ieee1968Type3Exciter(String id, String name, String caty) {
        super(id, name, caty);
        // _data is defined in the parent class. However init it here is a MUST
        _data = new Ieee1968Type3ExciterData();
    }
    
    /**
     * Get the excitor data
     *
     * @return the data object
     */
    public Ieee1968Type3ExciterData getData() {
        return (Ieee1968Type3ExciterData)_data;
    }
    
    /**
     *  Init the controller states
     *
     *  @param msg the SessionMsg object
     */
    public boolean initStates(DStabBus bus, Machine mach, IPSSMsgHub msg) {
        this.ka = getData().getKa();
        this.ta = getData().getTa();
        this.vrmax = getData().getVrmax();
        this.vrmin = getData().getVrmin();
		this.ke1 = 1.0/getData().getKe();
		this.te_ke = getData().getTe() / getData().getKe();
		this.kp = getData().getKp();
		this.ki = getData().getKi();
		this.vbmax = getData().getVbmax();
		this.kf = getData().getKf();
		this.tf = getData().getTf();
        return super.initStates(bus, mach, msg);
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
 
    public AnController getAnController() {
    	return (AnController)getClass().getAnnotation(AnController.class);  }
    public Field getField(String fieldName) throws Exception {
    	return getClass().getField(fieldName);   }
    public Object getFieldObject(Field field) throws Exception {
    	return field.get(this);    }
} // SimpleExciter

