package org.ieee.odm.pwd;

import static org.junit.Assert.assertTrue;

import org.ieee.odm.adapter.pwd.impl.PWDDataParser;
import org.ieee.odm.common.ODMException;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.junit.Test;

import org.ieee.odm.adapter.pwd.impl.PWDDataParser;

public class PwdParserTest {
	@Test
	public void test() throws ODMException {
		PWDDataParser parser = new PWDDataParser(new AclfModelParser());
		
		parser.parseMetadata("A, B, C, A:1, D");
		
		parser.parseData("1, 2, C, 4, 5");

		//System.out.println(parser.toString());
		
		assertTrue(parser.getDouble("A") == 1.0);
		assertTrue(parser.getString("C").equals("C"));
		assertTrue(parser.exist("A:1"));
		assertTrue(!parser.exist("A:2"));
	}

	@Test
	public void multi_line_test() throws ODMException {
		PWDDataParser parser = new PWDDataParser(new AclfModelParser());
		
		parser.parseMetadata("A, B, C");
		parser.parseMetadata("A:1, D");
		
		// parseData() return false, since more data is expected
		assertTrue(parser.parseData("1, 2") == false);

		assertTrue(parser.parseData("C, 4, 5") == true);

		//System.out.println(parser.toString());
		
		assertTrue(parser.getDouble("A") == 1.0);
		assertTrue(parser.getString("C").equals("C"));
		assertTrue(parser.exist("A:1"));
		assertTrue(!parser.exist("A:2"));
	}
}
