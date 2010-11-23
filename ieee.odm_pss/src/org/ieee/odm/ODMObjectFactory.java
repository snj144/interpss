package org.ieee.odm;

import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.model.acsc.AcscModelParser;
import org.ieee.odm.model.dc.DcSystemModelParser;
import org.ieee.odm.model.dstab.DStabModelParser;
import org.ieee.odm.model.opf.OpfModelParser;

public class ODMObjectFactory {
	public static AclfModelParser createAclfModelParser() {
		AclfModelParser parser = new AclfModelParser();
		return parser;
	}

	public static DcSystemModelParser createDcSystemModelParser() {
		DcSystemModelParser parser = new DcSystemModelParser();
		return parser;
	}

	public static OpfModelParser createOpfModelParser() {
		OpfModelParser parser = new OpfModelParser();
		return parser;
	}

	public static DStabModelParser createDStabModelParser() {
		DStabModelParser parser = new DStabModelParser();
		return parser;
	}
	
	public static AcscModelParser createAcscModelParser() {
		AcscModelParser parser = new AcscModelParser();
		return parser;
	}
}
