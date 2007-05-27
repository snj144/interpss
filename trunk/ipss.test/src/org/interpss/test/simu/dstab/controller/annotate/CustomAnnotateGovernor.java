package org.interpss.test.simu.dstab.controller.annotate;

import java.lang.reflect.Field;

import org.interpss.dstab.control.cml.block.DelayControlBlock;
import org.interpss.dstab.control.cml.block.GainBlock;

import com.interpss.common.func.CMLFieldType;
import com.interpss.dstab.controller.annotate.AnController;
import com.interpss.dstab.controller.annotate.AnControllerField;
import com.interpss.dstab.controller.annotate.AnnotateGovernor;

// User custom code begin 
// Define controller annotation here
@AnController(
        input="mach.speed - 1.0",
        output="this.gainBlock.y",
        refPoint="this.gainBlock.u0 + this.delayBlock.y",
        display= {"str.Pm, this.output", "str.GovState, this.delayBlock.state"})
// User custom code end
        
// Your custom class has to extend the AbstractAnnotateController class         
public class CustomAnnotateGovernor extends AnnotateGovernor {

	// User custom code begin
	// Define controller parameters, fields and field annotation here 
	public double ka = 10.0, ta = 0.5;
    @AnControllerField(
            type= CMLFieldType.ControlBlock,
            input="mach.speed - 1.0",
            parameter={"type.NoLimit", "this.ka", "this.ta"},
            y0="this.refPoint - this.gainBlock.u0"	)
    DelayControlBlock delayBlock;
	
    public double ks = 1.0, pmax = 1.2, pmin = 0.0;
    @AnControllerField(
            type= CMLFieldType.StaticBlock,
            input="this.refPoint - this.delayBlock.y",
            parameter={"type.Limit", "this.ks", "this.pmax", "this.pmin"},
            y0="mach.pm"	)
    GainBlock gainBlock;
    // User custom code end
    
// do not modify any code below this point     
    public AnController getAnController() {
    	return (AnController)getClass().getAnnotation(AnController.class);  }
    public Field getField(String fieldName) throws Exception {
    	return getClass().getField(fieldName);   }
    public Object getFieldObject(Field field) throws Exception {
    	return field.get(this);    }

}