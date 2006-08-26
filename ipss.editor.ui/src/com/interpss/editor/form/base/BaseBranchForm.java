package com.interpss.editor.form.base;

import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.XmlUtil;

/**
*	BaseBranchForm class for storing branch data.
*/

public class BaseBranchForm  extends BaseForm {
	public static boolean XmlBinding = true;
	
	private String branchNumber = "0000";
    private String fromId = "";
    private String toId = "";
    private String fromBusName = "";
    private String toBusName = "";
    private int circuitNumber = 1;

    public BaseBranchForm() { this("");  }	
    public BaseBranchForm(String id) { setId(id); }	    
    
    public String getBranchNumber() { return this.branchNumber;    }
    public void setBranchNumber(String value) { this.branchNumber = value;    }

    public int getCircuitNumber() { return this.circuitNumber;    }
    public void setCircuitNumber(int value) { this.circuitNumber = value;    }

    public String getFromId() { return this.fromId;    }
    public void setFromId(String value) { this.fromId = value;    }

    public String getToId() { return this.toId;    }
    public void setToId(String value) { this.toId = value;    }

    public String getFromBusName() { return this.fromBusName;    }
    public void setFromBusName(String value) { this.fromBusName = value;    }

    public String getToBusName() { return this.toBusName;    }
    public void setToBusName(String value) { this.toBusName = value;    }
    
	/**
	*	Convert the object to a string representation
	*
	* @return the string representation
	*/
	public String toString() {
		if (XmlBinding)
			return XmlUtil.toXmlString(this);
		else {
			IpssLogger.getLogger().info("GBranchForm.XmlBinding is set off");
			return "";
		}
	} 
	
    public String getDefaultName() {
	    return getFromBusName() + "->" + getToBusName();
	}	
    
    public String getNameIdStr() {
    	String name = getName();
    	if (name.equals(""))
    		name = getFromBusName() + "->" + getToBusName();
    	return 	name + "(" + getId() + ")";
    }    
}