package com.interpss.editor.project;

import javax.swing.ImageIcon;

import org.interpss.editor.SimuAppSpringAppContext;

import com.interpss.editor.coreframework.GPDocument;
import com.interpss.editor.coreframework.IpssCustomDocument;
import com.interpss.editor.coreframework.IpssReportDocument;
import com.interpss.editor.coreframework.IpssTextDocument;
import com.interpss.editor.resources.ImageLoader;
import com.interpss.editor.resources.Translator;
import com.interpss.editor.util.Utilities;

public class IpssIconFactory {

	public static final ImageIcon ICON_GRAPH = ImageLoader
			.getImageIcon(Translator.getString("Project.Graph")),
			ICON_CUS = ImageLoader.getImageIcon(Translator
					.getString("Project.CUS")), ICON_ROOT = ImageLoader
					.getImageIcon(Translator.getString("Project.Root")),
			ICON_PROJECT = ImageLoader.getImageIcon(Translator
					.getString("Project.Project")), ICON_TEXT = ImageLoader
					.getImageIcon(Translator.getString("Project.Text")), ICON_REPORT = ImageLoader
					.getImageIcon(Translator.getString("Project.Report"));

	public static ImageIcon getIconbyFileName(String filename) {
		if (filename.endsWith("ipss"))
			return ICON_GRAPH;
		// if (filename.endsWith("ipssdat"))
		if (Utilities.haveExt(SimuAppSpringAppContext
				.getCustomFileAdapterList(), com.interpss.editor.util.Utilities
				.getFileExt(filename)))
			return ICON_CUS;
		if (filename.endsWith("txt"))
			return ICON_TEXT;
		if (filename.endsWith("ipssrpt"))
			return ICON_REPORT;

		return null;
	}

	public static ImageIcon getIconbyClass(Object o) {
		if (o instanceof GPDocument)
			return ICON_GRAPH;
		if (o instanceof IpssCustomDocument)
			return ICON_CUS;
		if (o instanceof IpssTextDocument)
			return ICON_TEXT;
		if (o instanceof IpssReportDocument)
			return ICON_REPORT;
		
		return null;
	}
}
