/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An implementation of the Simple excitor model
 *
 * $Id$
 */
package org.interpss.dstab.control.exc.ieee.y1968.type1s;

import java.lang.reflect.Field;

import com.interpss.common.func.CMLFieldType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.controller.annotate.AnController;
import com.interpss.dstab.controller.annotate.AnControllerField;
import com.interpss.dstab.controller.annotate.AnnotateExciter;
import com.interpss.dstab.controller.block.DelayControlBlock;
import com.interpss.dstab.mach.Machine;

@AnController(
        input="pss.vs - mach.vt",
        output="this.delayBlock.y",
        refPoint="this.delayBlock.u0 - pss.vs + mach.vt",
        display= {"str.Efd, this.output", "str.ExciterState, this.delayBlock.state"})
public class Ieee1968Type1sExciter extends AnnotateExciter {
	public double k = 50.0, t = 0.05, vmax = 10.0, vmin = 0.0;
    @AnControllerField(
            type= CMLFieldType.ControlBlock,
            input="this.refPoint + pss.vs - mach.vt",
            parameter={"type.Limit", "this.k", "this.t", "this.vmax", "this.vmin"},
            y0="mach.efd"	)
    DelayControlBlock delayBlock;
 	
    // UI Editor panel
    private static NBIeee1968Type1sEditPanel _editPanel = new NBIeee1968Type1sEditPanel();
    
    /**
     * Default Constructor
     *
     */
    public Ieee1968Type1sExciter() {
        this("excId", "excName", "InterPSS");
    }
    
    /**
     * Constructor
     *
     * @param id excitor id
     * @param name excitor name
     */
    public Ieee1968Type1sExciter(String id, String name, String caty) {
        super(id, name, caty);
        // _data is defined in the parent class. However init it here is a MUST
        _data = new Ieee1968Type1sExciterData();
    }
    
    /**
     * Get the excitor data
     *
     * @return the data object
     */
    public Ieee1968Type1sExciterData getData() {
        return (Ieee1968Type1sExciterData)_data;
    }
    
    /**
     *  Init the controller states
     *
     *  @param msg the SessionMsg object
     */
    public boolean initStates(DStabBus bus, Machine mach, IPSSMsgHub msg) {
        this.k = getData().getKa();
        this.t = getData().getTa();
        this.vmax = getData().getVrmax();
        this.vmin = getData().getVrmin();
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

