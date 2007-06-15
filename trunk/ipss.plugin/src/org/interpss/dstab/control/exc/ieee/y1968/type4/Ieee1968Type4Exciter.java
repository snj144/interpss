 /*
  * @(#)Ieee1968Type4Exciter.java   
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
package org.interpss.dstab.control.exc.ieee.y1968.type4;

import java.lang.reflect.Field;

import org.interpss.dstab.control.cml.block.DelayControlBlock;
import org.interpss.dstab.control.cml.block.IntegrationControlBlock;
import org.interpss.dstab.control.cml.block.WashoutControlBlock;
import org.interpss.dstab.control.cml.func.SeFunction;

import com.interpss.common.datatype.CMLFieldType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.controller.annotate.AnController;
import com.interpss.dstab.controller.annotate.AnControllerField;
import com.interpss.dstab.controller.annotate.AnFunctionField;
import com.interpss.dstab.controller.annotate.AnnotateExciter;
import com.interpss.dstab.controller.block.IControlBlock;
import com.interpss.dstab.controller.block.IStaticBlock;
import com.interpss.dstab.controller.block.adapt.ControlBlockAdapter;
import com.interpss.dstab.mach.Machine;

@AnController(
		   input="this.refPoint - mach.vt + pss.vs - this.washoutBlock.y",
		   output="this.delayBlock.y",
		   refPoint="this.customBlock.u0 - pss.vs + mach.vt + this.washoutBlock.y",
		   display= {})
public class Ieee1968Type4Exciter extends AnnotateExciter {
	   public double trh = 1.0, kv = 0.05, vrmax = 10.0, vrmin = 0.0;
	   @AnControllerField(
	      type= CMLFieldType.ControlBlock,
	      input="this.refPoint + pss.vs - mach.vt - this.washoutBlock.y",
	      y0="this.delayBlock.u0 + this.seFunc.y"	)
	   public IControlBlock customBlock = new ControlBlockAdapter() {
	       private IntegrationControlBlock block = new IntegrationControlBlock(
	                      IStaticBlock.Type.Limit, 1.0/trh, vrmax, vrmin);

	       public boolean initStateY0(double y0) {
	         return block.initStateY0(y0);
	       }
	       public double getU0(){
	         return 0.0;
	       }  
	       public void eulerStep1(double u, double dt){
	         block.eulerStep1(u, dt);
	       }
	       public void eulerStep2(double u, double dt){
	         block.eulerStep2(u, dt);
	       }
	       public double getY(){
		      double u = block.getU();
	         if ( u > kv )
	            return vrmax;
	         else if ( u < -kv )
	            return vrmin;
	         else
	            return block.getY();
	       }
	       public double getStateX() {
	           return block.getStateX();
	       }
	   };

	   public double ke1 = 1.0 /* ke1 = 1/Ke  */, te_ke = 0.1 /* te_ke = Te/Ke */;
	   @AnControllerField(
	      type= CMLFieldType.ControlBlock,
	      input="this.customBlock.y - this.seFunc.y",
	      parameter={"type.NoLimit", "this.ke1", "this.te_ke"},
	      y0="mach.efd"	)
	   DelayControlBlock delayBlock;

	   public double e1 = 3.1, seE1 = 0.33, e2 = 2.3, seE2 = 0.1;
	   @AnFunctionField(
	      input= {"this.delayBlock.y"},
	      parameter={"this.e1", "this.seE1", "this.e2", "this.seE2"}	)
	   SeFunction seFunc;

	   public double kf = 1.0, tf = 0.05, k = kf/tf;
	   @AnControllerField(
	      type= CMLFieldType.ControlBlock,
	      input="this.delayBlock.y",
	      parameter={"type.NoLimit", "this.k", "this.tf"},
	      feedback = true	)
	   WashoutControlBlock washoutBlock;

    // UI Editor panel
    private static NBIeee1968Type4EditPanel _editPanel = new NBIeee1968Type4EditPanel();
    
    /**
     * Default Constructor
     *
     */
    public Ieee1968Type4Exciter() {
        this("excId", "excName", "InterPSS");
    }
    
    /**
     * Constructor
     *
     * @param id excitor id
     * @param name excitor name
     */
    public Ieee1968Type4Exciter(String id, String name, String caty) {
        super(id, name, caty);
        // _data is defined in the parent class. However init it here is a MUST
        _data = new Ieee1968Type4ExciterData();
    }
    
    /**
     * Get the excitor data
     *
     * @return the data object
     */
    public Ieee1968Type4ExciterData getData() {
        return (Ieee1968Type4ExciterData)_data;
    }
    
    /**
     *  Init the controller states
     *
     *  @param msg the SessionMsg object
     */
    public boolean initStates(DStabBus bus, Machine mach, IPSSMsgHub msg) {
        this.trh = getData().getTrh();
        this.kv = getData().getKv();
        this.vrmax = getData().getVrmax();
        this.vrmin = getData().getVrmin();
		this.ke1 = 1.0/getData().getKe();
		this.te_ke = getData().getTe() / getData().getKe();
		this.e1 = getData().getE1();
		this.seE1 = getData().getSeE1();
		this.e2 = getData().getE2();
		this.seE2 = getData().getSeE2();
		this.k = getData().getKf() / getData().getTf();
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

