/*
 * @(#)ExciterDataHelper.java   
 *
 * Copyright (C) 2008-2010 www.interpss.org
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
 * @Date 08/15/2010
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.mapper.odm.impl.dstab;

import org.ieee.odm.schema.ExcIEEE1968Type1SXmlType;
import org.ieee.odm.schema.ExcIEEE1968Type1XmlType;
import org.ieee.odm.schema.ExcIEEE1968Type2XmlType;
import org.ieee.odm.schema.ExcIEEE1968Type3XmlType;
import org.ieee.odm.schema.ExcIEEE1968Type4XmlType;
import org.ieee.odm.schema.ExcSimpleTypeXmlType;
import org.ieee.odm.schema.ExciterModelXmlType;
import org.interpss.dstab.control.exc.ExciterObjectFactory;
import org.interpss.dstab.control.exc.ieee.y1968.type1.Ieee1968Type1Exciter;
import org.interpss.dstab.control.exc.ieee.y1968.type1s.Ieee1968Type1sExciter;
import org.interpss.dstab.control.exc.ieee.y1968.type2.Ieee1968Type2Exciter;
import org.interpss.dstab.control.exc.ieee.y1968.type3.Ieee1968Type3Exciter;
import org.interpss.dstab.control.exc.ieee.y1968.type4.Ieee1968Type4Exciter;
import org.interpss.dstab.control.exc.simple.SimpleExciter;

import com.interpss.common.exp.InterpssException;
import com.interpss.dstab.mach.Machine;

public class ExciterDataHelper {
	private Machine mach = null;
	
	public ExciterDataHelper(Machine mach) {
		this.mach = mach;
	}

	/**
	 * create the exc model and add to its parent machine object
	 * 
	 * @param excXmlRec ODM exciter model record
	 */
	public void createExciter(ExciterModelXmlType excXmlRec) throws InterpssException {
		if (excXmlRec instanceof ExcSimpleTypeXmlType) {
			ExcSimpleTypeXmlType excXml = (ExcSimpleTypeXmlType)excXmlRec;
			SimpleExciter exc = ExciterObjectFactory.createSimpleExciter(mach.getId()+"_Exc", excXml.getName(), mach);
			exc.getData().setKa(excXml.getKa());
			exc.getData().setTa(excXml.getTa().getValue());
			exc.getData().setVrmax(excXml.getVrmax());
			exc.getData().setVrmin(excXml.getVrmin());
		}
		else if (excXmlRec instanceof ExcIEEE1968Type1XmlType){
			ExcIEEE1968Type1XmlType excXml =(ExcIEEE1968Type1XmlType) excXmlRec;
			Ieee1968Type1Exciter exc=ExciterObjectFactory.createIeee1968Type1Exciter(mach.getId()+"_Exc", excXml.getName(), mach);			
			exc.getData().setTa(excXml.getTA().getValue());
			exc.getData().setKa(excXml.getKA());
			exc.getData().setTe(excXml.getTE().getValue());
			exc.getData().setKe(excXml.getKE());
			exc.getData().setKf(excXml.getKF());			
			exc.getData().setTf(excXml.getTF().getValue());
			exc.getData().setE1(excXml.getE1());
			exc.getData().setSeE1(excXml.getSE1());
			exc.getData().setE2(excXml.getE2());
			exc.getData().setSeE2(excXml.getSE2());
			exc.getData().setVrmax(excXml.getVRMAX());
			exc.getData().setVrmin(excXml.getVRMIN());	
		}
		else if (excXmlRec instanceof ExcIEEE1968Type1SXmlType){
			ExcIEEE1968Type1SXmlType excXml =(ExcIEEE1968Type1SXmlType) excXmlRec;
			Ieee1968Type1sExciter exc=ExciterObjectFactory.createIeee1968Type1sExciter(mach.getId()+"_Exc", excXml.getName(), mach);			
			exc.getData().setTa(excXml.getTa().getValue());
			exc.getData().setKa(excXml.getKa());			
			exc.getData().setKp(excXml.getKP());
			exc.getData().setKf(excXml.getKF());			
			exc.getData().setTf(excXml.getTF().getValue());						
			exc.getData().setVrmin(excXml.getVrmin());	
		}	
		else if (excXmlRec instanceof ExcIEEE1968Type2XmlType){
			ExcIEEE1968Type2XmlType excXml =(ExcIEEE1968Type2XmlType) excXmlRec;
			Ieee1968Type2Exciter exc=ExciterObjectFactory.createIeee1968Type2Exciter(mach.getId()+"_Exc", excXml.getName(), mach);			
			exc.getData().setTa(excXml.getTa().getValue());
			exc.getData().setKa(excXml.getKa());
			exc.getData().setVrmax(excXml.getVrmax());
			exc.getData().setVrmin(excXml.getVrmin());
			exc.getData().setTe(excXml.getTE().getValue());
			exc.getData().setKe(excXml.getKE());
			exc.getData().setE1(excXml.getE1());
			exc.getData().setSeE1(excXml.getSE1());
			exc.getData().setE2(excXml.getE2());
			exc.getData().setSeE2(excXml.getSE2());			
			exc.getData().setKf(excXml.getKF());			
			exc.getData().setTf1(excXml.getTF1().getValue());	
			exc.getData().setTf2(excXml.getTF2().getValue());					
		}	
		else if (excXmlRec instanceof ExcIEEE1968Type3XmlType){
			ExcIEEE1968Type3XmlType excXml =(ExcIEEE1968Type3XmlType) excXmlRec;
			Ieee1968Type3Exciter exc=ExciterObjectFactory.createIeee1968Type3Exciter(mach.getId()+"_Exc", excXml.getName(), mach);			
			exc.getData().setTa(excXml.getTa().getValue());
			exc.getData().setKa(excXml.getKa());
			exc.getData().setVrmax(excXml.getVrmax());
			exc.getData().setVrmin(excXml.getVrmin());
			exc.getData().setTe(excXml.getTE().getValue());
			exc.getData().setKe(excXml.getKE());
			exc.getData().setKp(excXml.getKP());
			exc.getData().setKi(excXml.getKI());
			exc.getData().setKf(excXml.getKF());			
			exc.getData().setTf(excXml.getTF().getValue());	
			exc.getData().setVbmax(excXml.getVBMAX());					
		}
		else if (excXmlRec instanceof ExcIEEE1968Type4XmlType){
			ExcIEEE1968Type4XmlType excXml =(ExcIEEE1968Type4XmlType) excXmlRec;
			Ieee1968Type4Exciter exc=ExciterObjectFactory.createIeee1968Type4Exciter(mach.getId()+"_Exc", excXml.getName(), mach);			
			exc.getData().setTrh(excXml.getTRH().getValue());
			exc.getData().setKv(excXml.getKV());
			exc.getData().setVrmax(excXml.getVrmax());
			exc.getData().setVrmin(excXml.getVrmin());
			exc.getData().setTe(excXml.getTE().getValue());
			exc.getData().setKe(excXml.getKE());
			exc.getData().setE1(excXml.getE1());
			exc.getData().setSeE1(excXml.getSE1());
			exc.getData().setE2(excXml.getE2());
			exc.getData().setSeE2(excXml.getSE2());			
			exc.getData().setKf(excXml.getKF());			
			exc.getData().setTf(excXml.getTF().getValue());	
								
		}
		{
			throw new InterpssException("Exciter type invalid or not implemented, type " + excXmlRec.getClass().getSimpleName());
		}
	}
}