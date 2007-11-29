package org.interpss.custom.script.dstab.z;

import java.util.Hashtable;

import org.apache.commons.math.complex.Complex;
import org.interpss.custom.script.aclf.indgen.InductionGeneratorData;
import org.interpss.custom.script.aclf.indgen.NBInductionGenEditPanel;
import org.interpss.custom.script.dstab.AbstractDynamicBusDeviceScriptEditing;

import com.interpss.common.datatype.ComplexFunc;
import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.net.Network;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.mach.Machine;

public class SampleConstantZ extends AbstractDynamicBusDeviceScriptEditing {
	public SampleConstantZ() {
		setData(new InductionGeneratorData());
		setEditPanel(new NBInductionGenEditPanel());
	}
/*
	public SampleConstantZ(String name, String desc) {
		super(name, desc);
		setData(new SampleConstantZData());
		setEditPanel(new NBSampleConstantZEditPanel());
	}
*/	
    /**
     * Get the data
     *
     * @return the data object
     */
    public SampleConstantZData getData() {
        return (SampleConstantZData)super.getData();
    }
    
	   private Complex z1;

	   /**
	    * Init the device using the input object
	    * 
	    * @param abus the bus object
	    * @param net the network object
	    * @param msg the MessageHub object
	    * @return false if there is anything wrong 
	    */
	   public boolean initStates(DStabBus abus, Network net, IPSSMsgHub msg) {
	      super.initStates(abus, net, msg);
	      // half of the total load on the bus is treated as static load
	      // the other half is model as a Bus Device
	      Complex load = new Complex(getData().getP()*0.5, getData().getQ()*0.5);
	      Complex cload = load.conjugate();
	      this.z1 = ComplexFunc.div(abus.getVoltageMag()*abus.getVoltageMag(), cload);
	      abus.setZ1(z1);
	      return true;
	   }

	   /**
	    * Solve a step of ODE
	    * 
	    * @param dt time step
	    * @param method ODE solution method
	    * @param abus the bus object
	    * @param net the network object
	    * @param msg the MessageHub object
	    * @return false if there is anything wrong 
	    */
	   public boolean nextStep(double dt, DynamicSimuMethods method, Network net, IPSSMsgHub msg) {
	      // do nothing
	      return true;
	   }

	   /**
	    * Get the device output object, normally the inject cuerrent into the network 
	    * 
	    * @param abus the bus object
	    */
	   public Object getOutputObject() {
	      // half of the load is treated as an injection current
	      Complex i = getDStabBus().getVoltage().divide(this.z1);
	      return new Complex(-i.getReal(), -i.getImaginary());
	   }

	   /**
	    * Get the device states 
	    * 
	    * @param abus the bus object
	    * @refMach the ref machine object
	    */
	   public Hashtable getStates(Object refMach) {
	      DStabBus abus = getDStabBus();
	      Hashtable<String, Double> hashtable = new java.util.Hashtable<String, Double>();
	      hashtable.put("Bus Voltage Msg", new Double(abus.getVoltageMag()));
	      double refAngle = 0.0;
	      if (refMach != null) {
	          refAngle = ((Machine)refMach).getAngle();
	      }
	      hashtable.put("Bus Voltage Ang (deg)", 
		               new Double((abus.getVoltageAng()-refAngle)*Constants.RtoD));
	      return hashtable;
	   }

	   /**
	    * update device attributes
	    * 
	    */
	   public boolean updateAttributes(boolean netChange)  {
	      return true;
	   }
	}
