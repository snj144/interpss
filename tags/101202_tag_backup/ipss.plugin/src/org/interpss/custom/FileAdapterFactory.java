package org.interpss.custom;

import org.interpss.custom.IpssFileAdapter.FileFormat;
import org.interpss.custom.IpssFileAdapter.PsseVersion;
import org.interpss.custom.dep.exchange.FileAdapter_GEFormat;
import org.interpss.custom.dep.exchange.FileAdapter_IeeeCommonFormat;
import org.interpss.custom.dep.exchange.FileAdapter_PTIFormat;
import org.interpss.custom.dep.exchange.FileAdapter_UCTEFormat;
import org.interpss.custom.dep.exchange.psse.PSSEDataRec;
import org.interpss.custom.dep.ieee_odm.FileAdapter_IEEEODM_Xml;

import com.interpss.common.msg.IPSSMsgHub;

public class FileAdapterFactory {
	public static IpssFileAdapter createAdapter(FileFormat format, PsseVersion psseVer, IPSSMsgHub msgHub) {
		if ( format == FileFormat.IEEECommonFormat ) {
			return new FileAdapter_IeeeCommonFormat(msgHub);
		}
		else if ( format == FileFormat.PSSE ) {
			PSSEDataRec.VersionNo ver = PSSEDataRec.VersionNo.PSS_E_30;
			if (psseVer == PsseVersion.PSSE_29)
				ver = PSSEDataRec.VersionNo.PSS_E_29;
			else if (psseVer == PsseVersion.PSSE_26)
				ver = PSSEDataRec.VersionNo.PSS_E_26;
			return new FileAdapter_PTIFormat(ver, msgHub);
		}
		else if ( format == FileFormat.GE_PSLF ) {
			return new FileAdapter_GEFormat(msgHub);
		}
		else if ( format == FileFormat.UCTE ) {
			return new FileAdapter_UCTEFormat(msgHub);
		}
		else if ( format == FileFormat.IEEE_ODM ) {
			return new FileAdapter_IEEEODM_Xml(msgHub);
		}
		/*
		else if ( format == FileFormat.Custom ) {
			Class<?> klass = Class.forName(this.classname);
			Constructor<?> constructor = klass.getConstructor();
			adapter = (IpssFileAdapter)constructor.newInstance();
		}
		*/
		else
			return null;
	}
}
