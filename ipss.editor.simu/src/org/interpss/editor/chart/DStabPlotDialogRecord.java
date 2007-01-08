package org.interpss.editor.chart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.interpss.common.SpringAppContext;
import com.interpss.common.io.IProjectDataManager;
import com.interpss.common.io.ISimuRecManager;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Num2Str;
import com.interpss.common.util.StringUtil;
import com.interpss.dstab.util.DStabSimuDBRecord;

/**
 * Utility class for translate plot dialog selection strings to plot records
 * 
 * @author mzhou
 *
 */
public class DStabPlotDialogRecord {
	public static final double TimeErrorTolerance = 0.0000001;
	
	public String elemId;
	public String stateName;
	public String recType;
	
	/**
	 * Parse plot dialog selection string, format: stateName(elemId)
	 * 
	 * @param str
	 * @return
	 */
    public static DStabPlotDialogRecord parseStateSelection(String str) {
    	DStabPlotDialogRecord rec = new DStabPlotDialogRecord();
		rec.elemId = str.substring(str.indexOf("(")+1, str.indexOf(")"));
		rec.stateName = str.substring(0, str.indexOf("("));
		String type;
		if (rec.elemId.startsWith("Mach@"))
			type = 	ISimuRecManager.REC_TYPE_DStabMachineStates;
		else
			type = 	ISimuRecManager.REC_TYPE_DStabBusStates;
		rec.recType = type;
    	return rec;
    }	
        
    /**
     * Translate the selection str set to a state name list: Time, Machine Angle ....
     * 
     * @param strList
     * @return
     */
    public static List<String> getStateNameList(Object[] strList) {
		List<String> nameList = new ArrayList<String>();
    	nameList.add("Time");
		for (Object strObj : strList) {
   	    	nameList.add(DStabPlotDialogRecord.parseStateSelection((String)strObj).stateName);
		}
		return nameList;
    }    
    
    /**
     * Accroding to the selection str set, retrieve data from the DB and create the value list
     *    [<Time, 0.00>, <Machine Angle, 50.0> ....]
     *    [<Time, 0.01>, <Machine Angle, 50.0> ....]
     * 
     * @param caseId
     * @param strList
     * @return
     */
    public static List<Hashtable<String,String>> createValueList(int caseId, Object[] strList) {
        // find <elemId, recType> set. elemId may be duplicated in the selectin strList
    	Map<String,String> map = new HashMap<String,String>();
    	for (Object strObj : strList) {
   	    	DStabPlotDialogRecord rec = DStabPlotDialogRecord.parseStateSelection((String)strObj);
       	    if (!map.containsKey(rec.elemId))
       	    	map.put(rec.elemId, rec.recType);
    	}
    	
    	// create elemId[], recType[]
    	Object[] objList = map.keySet().toArray();
    	String[] elemIdList = new String[objList.length];
    	String[] recTypeList = new String[objList.length];
    	int cnt = 0;
    	for (Object obj: objList) {
    		elemIdList[cnt] = (String)obj;
    		recTypeList[cnt++] = map.get((String)obj);
    	}
    	
    	// retrieve rec from DB
		ISimuRecManager simuRecManager = SpringAppContext.getSimuRecManager();
		List<DStabSimuDBRecord> elemRecList = null;
		try {
			elemRecList = simuRecManager.getSimuRecList(caseId,	recTypeList, elemIdList, IProjectDataManager.CaseType_DStabSimuRec);
		} catch (Exception ex) {
			IpssLogger.logErr(ex);
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Error to GetSimuRecList from DB", 
					ex.toString() + "\n Please contact InterPSS support");
		}

		// find time array from the elemRecList, there may be multiple sets
		List<Double> timeList = new ArrayList<Double>();
		double time = 0.0;
		for (DStabSimuDBRecord rec : elemRecList) {
			if (rec.getSimuTime() > time) {
				time = rec.getSimuTime();
				timeList.add(new Double(time));
			}
		}
		
		// create the valueList
		List<Hashtable<String,String>> valueList = new ArrayList<Hashtable<String,String>>();
		for (Double tPoint : timeList) {
			Hashtable<String,String> row = new Hashtable<String,String>();
			double t = tPoint.doubleValue();
			row.put("Time", Num2Str.toStr(t,"00.000"));
    		for (Object strObj : strList) {
   				String stateName = DStabPlotDialogRecord.parseStateSelection((String)strObj).stateName;
       			for (DStabSimuDBRecord rec : elemRecList) {
       				if (Math.abs(rec.getSimuTime()-t) < TimeErrorTolerance) {
       					Hashtable table = StringUtil.parseStr2Hashtable(rec.getSimuRec());
       					row.put(stateName, (String)(table.get(stateName)));
       				}
       			}
    		}
    		valueList.add(row);
		}
		return valueList;
    }
}
