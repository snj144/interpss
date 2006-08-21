package com.interpss.editor.form.base;

import com.interpss.common.util.XmlUtil;

/**
*	BaseBusForm class for storing bus data.
*/

public class BaseBusForm extends BaseForm {
    public BaseBusForm() { this(""); }	
    public BaseBusForm(String id) { setId(id); }	

    private double  baseVoltage = 1000d;
    private String  baseVoltUnit = "Volt";  // "Volt", "KV"
    
    public String getBaseVoltUnit() { return this.baseVoltUnit; }
    public void setBaseVoltUnit(String n) { this.baseVoltUnit = n; }        
      
    public double getBaseVoltage() { return this.baseVoltage; }
    public void setBaseVoltage(double value) { this.baseVoltage = value; }
    
	/**
	*	Convert the object to a string representation
	*
	* @return the string representation
	*/
	public String toString() {
		return XmlUtil.toXmlString(this);
	}    
}