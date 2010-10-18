package org.interpss.odm.opf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.ieee.odm.ODMObjectFactory;
import org.ieee.odm.model.opf.OpfModelParser;
import org.interpss.BaseTestSetup;
import org.interpss.mapper.odm.impl.ODMOpfDataMapperImpl;

import com.interpss.opf.OpfNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
public class ODM2OpfMapperTest extends BaseTestSetup {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("testdata/opf/opf_3bus_test.xml");
		OpfModelParser parser = ODMObjectFactory.createOpfModelParser();
		if (parser.parse(new FileInputStream(file))) {
			//System.out.println(parser.toXmlDoc(false));
			ODMOpfDataMapperImpl opfMapper =new ODMOpfDataMapperImpl();
			SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.OPF_NET, msg);
			opfMapper.odm2SimuCtxMapping(parser, simuCtx);
			OpfNetwork opfnet=simuCtx.getOpfNet();
			System.out.print(opfnet.net2String());
		}
	}

}
