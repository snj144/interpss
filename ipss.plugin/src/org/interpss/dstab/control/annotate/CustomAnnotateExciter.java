package org.interpss.dstab.control.annotate;

import java.lang.reflect.Field;

import com.interpss.dstab.controller.annotate.*;
import com.interpss.dstab.controller.block.*;
import com.interpss.dstab.mach.Controller;
// do not modify any code above this point

// User custom code begin 
// Define controller annotation here
@AnController(
        input="pss.vs - mach.vt",
        output="this.delayBlock.y",
        refPoint="this.delayBlock.u0 - pss.vs + mach.vt",
        display= {"str.Efd, this.delayBlock.y"})
// User custom code end
        
// Your custom class has to extend the AbstractAnnotateController class         
public class CustomAnnotateExciter extends AbstractAnnotateController {

	// User custom code begin
	// Define controller parameters, fields and field annotation here 
	public double k = 50.0, t = 0.05, vmax = 10.0, vmin = 0.0;
    @AnControllerField(
            type= "type.ControlBlock",
            input="this.refPoint + pss.vs - mach.vt",
            parameter={"type.Limit", "this.k", "this.t", "this.vmax", "this.vmin"},
            y0="mach.efd"	)
    DelayControlBlock delayBlock;
    // User custom code end
    
// do not modify any code below this point     
    public AnController getAnController() {
    	return (AnController)getClass().getAnnotation(AnController.class);  }
    public double getDoubleField(String fieldName) throws Exception {
    	Field field = getClass().getField(fieldName);
    	return ((Double)field.get(this)).doubleValue();   }
    public Controller getControllerField(Field field) throws Exception {
    	return (Controller)field.get(this);    }
}