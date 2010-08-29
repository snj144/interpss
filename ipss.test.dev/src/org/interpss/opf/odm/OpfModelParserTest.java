package org.interpss.opf.odm;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import org.ieee.odm.model.opf.*;
import org.ieee.odm.schema.OpfNetworkXmlType;
import org.junit.Test;
public class OpfModelParserTest {
	@Test
	public void testOpfModelParser()throws Exception{
	
	FileInputStream in =new FileInputStream("testdata/ieee_odm/opf_3bus_test.xml");
	OpfModelParser OpfParser = new OpfModelParser(in);//("testdata/opf_3bus_test.xml");
	System.out.println(OpfParser.toXmlDoc(false));	
	//OpfModelParser OpfParser = new OpfModelParser("testdata/opf_3bus_test.xml");
    OpfNetworkXmlType opfNet=OpfParser.getOpfNet();
    assertTrue(opfNet.getBusList().getBus().size()==3);
    assertTrue(opfNet.getAnglePenaltyFactor()==1);
    assertTrue(opfNet.getBranchList().getBranch().size()==3);
	
    }
}
