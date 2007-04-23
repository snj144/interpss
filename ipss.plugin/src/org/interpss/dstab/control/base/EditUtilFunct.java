package org.interpss.dstab.control.base;

import java.util.Vector;

import javax.swing.JTextField;

import com.interpss.common.ui.SwingInputVerifyUtil;
import com.interpss.common.util.Num2Str;

public class EditUtilFunct {

	public static void setTextFiled(JTextField textField, double data, String format) {
		textField.setText(Num2Str.toStr(data, format));
	}
	
	public static void saveTextField(BaseControllerData data, JTextField textField, String dataName, Vector<String> errMsg) throws Exception {
		double max = data.getMaxValue(dataName);
		double min = data.getMinValue(dataName);
		double x = SwingInputVerifyUtil.getDouble(textField);
		if (SwingInputVerifyUtil.within(textField, min, max, errMsg, 
					dataName + "(" + x + ") is out of the range [" + max + "," + min + "]"))
			data.setValue(dataName, x);
	}
	
	public static boolean checkDataRange(Object input, BaseControllerData data, String dataName) throws Exception {
		double x = SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input);
		return !data.isOutRange(dataName, x);
	}
}
