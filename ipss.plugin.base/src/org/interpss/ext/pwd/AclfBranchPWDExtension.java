package org.interpss.ext.pwd;

import java.util.Hashtable;

/**
 *  AclfBranch extension for representing PowerWorld custom fields
 *  
 *  {CustomString:1=Sub3_230_L34B, CustomString=Line, SubStation=Sub3, EquimentName=L34B}
 * 
 * @author mzhou
 *
 */
public class AclfBranchPWDExtension extends Hashtable<String,String> {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Defined as "EquipmentType_SubstationName_EquipmentName�. Take Transformer_Sub1_T12 for example, 
	 * it refers to the transformer connected to substation Sub1 (where the �fromBus� is located) 
	 * with the equipment name of T12. 
	 * 
	 * @return
	 */
	public String getBranchOutageId() {
		return this.get("CustomString") + "_" + this.get("SubStation") + "_" + this.get("EquimentName");
	}

	/**
	 * to string function
	 */
	public String toString() {
		String str = "AclfBranchPWDExtension: " + super.toString();
		return str;
	}
}
