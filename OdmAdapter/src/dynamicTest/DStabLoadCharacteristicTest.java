package dynamicTest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.ieee.odm.adapter.IODMAdapter;
import org.ieee.odm.adapter.bpa.BPAAdapter;
import org.ieee.odm.common.ODMException;
import org.ieee.odm.model.IODMModelParser;
import org.ieee.odm.model.dstab.DStabModelParser;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.DStabBusXmlType;
import org.ieee.odm.schema.NetworkXmlType;
import org.interpss.odm.converter.BPA.dynamic.BpaDynamicLoadCharacteristicRecord;
import org.junit.Test;

import util.StringUtil;


public class DStabLoadCharacteristicTest {
	@Test
	public void testCase1() throws ODMException{
		IODMAdapter adapter = new BPAAdapter();
		assertTrue(adapter.parseInputFile(IODMAdapter.NetType.DStabNet,
				new String[] { "testdata/IEEE90.DAT","testdata/ieee90.swi"},IODMModelParser.chineseEncoding));		
		DStabModelParser parser = (DStabModelParser)adapter.getModel();
		parser.stdout();
		
		String bpa="";
		ArrayList<String> loadCards=new ArrayList<String>();
		NetworkXmlType.BusList busList=parser.getDStabNet().getBusList();
		int busSize=busList.getBus().size();
		for(int i=0;i<busSize;i++){
			BusXmlType Bus = busList.getBus().get(i).getValue();
			DStabBusXmlType DStabBus=parser.getDStabBus(Bus.getId());
			if(DStabBus.getDynamicLoad()!=null){
				BpaDynamicLoadCharacteristicRecord bpaLoadRecord=new BpaDynamicLoadCharacteristicRecord(parser);
				bpaLoadRecord.setDynamicLoadCharacteristicData(bpa, DStabBus);
				loadCards.add(bpaLoadRecord.stdout());
//				System.out.println(bpaLoadRecord.stdout());
			}
		}
		//һ�������ھ�����ͬ��̬����ģ�͵ģ��Է���(Zone)������Կ�
		for(int i=0;i<loadCards.size();i++){
			String temp=loadCards.get(i).substring(15);
			StringBuffer New=new StringBuffer();
			int m=0;
			for(int j=i+1;j<loadCards.size();j++){
				if(loadCards.get(j).substring(15).equals(temp)){
					m++;
					loadCards.remove(j);
				}
			}
			if(m!=0){
				New=New.append(loadCards.get(i).substring(0, 2)).append(StringUtil.getSpace(14)).append(temp);
				loadCards.remove(i);
				loadCards.add(i, New.toString());
			}
		}
		//һ�������ھ�����ͬ��̬����ģ�͵ģ�������(Area)������Կ�
		for(int i=0;i<loadCards.size();i++){
			String temp=loadCards.get(i).substring(17);
			StringBuffer New=new StringBuffer();
			int m=0;
			for(int j=i+1;j<loadCards.size();j++){
				if(loadCards.get(j).substring(17).equals(temp)){
					m++;
					loadCards.remove(j);
				}
			}
			if(m!=0){
				New=New.append(loadCards.get(i).substring(0, 2)).append(StringUtil.getSpace(16)).append(temp);
				loadCards.remove(i);
				loadCards.add(i, New.toString());
			}
		}
		//���
		for(int i=loadCards.size()-1;i>=0;i--){
			System.out.println(loadCards.get(i));
		}
	}
}
