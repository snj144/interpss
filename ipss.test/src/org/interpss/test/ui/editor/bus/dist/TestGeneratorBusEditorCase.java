 /*
  * @(#)TestGeneratorBusEditorCase.java   
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.test.ui.editor.bus.dist;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.dist.DistBusData;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.ui.edit.NBBusEditDialog;
import org.interpss.test.ui.TestUIBase;
import org.interpss.test.ui.TestUI_UtilFunc;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;


public class TestGeneratorBusEditorCase extends TestUIBase {
	public void testGeneratorCase() {
		System.out.println("TestDistBusEditorCase testGeneratorCase begin");
		
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		DistBusData data = form.getDistBusData();
		data.setBusCode(DistBusData.BusCode_Generator);		
		
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		JComboBox pfUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "pfUnitComboBox");
		pfUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(pfUnitComboBox, "PU"); // "PU", "%"

		JComboBox ratedKWUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "ratedKWUnitComboBox");
		ratedKWUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(ratedKWUnitComboBox, "Mva"); // "Mva", "MW", "Kva", "KW"

		JComboBox ratedVUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "ratedVUnitComboBox");
		ratedVUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(ratedVUnitComboBox, "PU"); // PU | Volt | KV

		TestUI_UtilFunc.setTextField(finder, busEditor, "ratedKWTextField", "100.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "ratedVTextField", "1.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "pfTextField", "0.8");
		TestUI_UtilFunc.setTextField(finder, busEditor, "loadingTextField", "90.0");
		
	    TestUI_UtilFunc.setZTable_XR_3Points(finder, busEditor, "zTable");

		TestUI_UtilFunc.setSolidGrounding(finder, busEditor);
	    
	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
		
		data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_Generator));		
		assertTrue(data.getBusRating() == 100.0);		
		assertTrue(data.getRatedVolt() == 1.0);		
		assertTrue(data.getPFactor() == 0.8);		
		assertTrue(data.getLoading() == 90.0);	
		assertTrue(data.getPFactorUnit().equals("PU"));
		assertTrue(data.getBusRatingUnit().equals("Mva"));
		assertTrue(data.getRatedVoltUnit().equals("PU"));
		TestUI_UtilFunc.checkBusZ_XR_3Points(data);
		TestUI_UtilFunc.checkSolidGrounding(data);
		
		// launch the editor again
		busEditor.init(netContainer, form);
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_Generator));		
		assertTrue(data.getBusRating() == 100.0);		
		assertTrue(data.getRatedVolt() == 1.0);		
		assertTrue(data.getPFactor() == 0.8);		
		assertTrue(data.getLoading() == 90.0);	
		assertTrue(data.getPFactorUnit().equals("PU"));
		assertTrue(data.getBusRatingUnit().equals("Mva"));
		assertTrue(data.getRatedVoltUnit().equals("PU"));
		TestUI_UtilFunc.checkBusZ_XR_3Points(data);
		TestUI_UtilFunc.checkSolidGrounding(data);

		// launch the editor again
		busEditor.init(netContainer, form);

		pfUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "pfUnitComboBox");
		pfUnitComboBox.setSelectedIndex(1);
		TestUI_UtilFunc.checkComboBoxSelection(pfUnitComboBox, "%"); // "PU", "%"

		ratedKWUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "ratedKWUnitComboBox");
		ratedKWUnitComboBox.setSelectedIndex(1);
		TestUI_UtilFunc.checkComboBoxSelection(ratedKWUnitComboBox, "MW"); // "Mva", "MW", "Kva", "KW"

		ratedVUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "ratedVUnitComboBox");
		ratedVUnitComboBox.setSelectedIndex(1);
		TestUI_UtilFunc.checkComboBoxSelection(ratedVUnitComboBox, "Volt"); // PU | Volt | KV

	    TestUI_UtilFunc.setZTable_XoverR_3Points(finder, busEditor, "zTable");

	    TestUI_UtilFunc.setUnGrounding(finder, busEditor);
		
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_Generator));		
		assertTrue(data.getPFactorUnit().equals("%"));
		assertTrue(data.getBusRatingUnit().equals("MW"));
		assertTrue(data.getRatedVoltUnit().equals("Volt"));
		TestUI_UtilFunc.checkUnGrounding(data);
		TestUI_UtilFunc.checkBusZ_XoverR_3Points(data);

		// launch the editor again
		busEditor.init(netContainer, form);

		ratedKWUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "ratedKWUnitComboBox");
		ratedKWUnitComboBox.setSelectedIndex(2);
		TestUI_UtilFunc.checkComboBoxSelection(ratedKWUnitComboBox, "Kva"); // "Mva", "MW", "Kva", "KW"

		ratedVUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "ratedVUnitComboBox");
		ratedVUnitComboBox.setSelectedIndex(2);
		TestUI_UtilFunc.checkComboBoxSelection(ratedVUnitComboBox, "KV"); // PU | Volt | KV

		TestUI_UtilFunc.setZGrounding(finder, busEditor);
		
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_Generator));		
		assertTrue(data.getBusRatingUnit().equals("Kva"));
		assertTrue(data.getRatedVoltUnit().equals("KV"));
		TestUI_UtilFunc.checkZGrounding(data);

		// launch the editor again
		busEditor.init(netContainer, form);

		ratedKWUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "ratedKWUnitComboBox");
		ratedKWUnitComboBox.setSelectedIndex(3);
		TestUI_UtilFunc.checkComboBoxSelection(ratedKWUnitComboBox, "KW"); // "Mva", "MW", "Kva", "KW"

		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_Generator));		
		assertTrue(data.getBusRatingUnit().equals("KW"));

		System.out.println("TestDistBusEditorCase testGeneratorCase end");
	}
}

