package com.interpss.wb.opencim.xmlnavigator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;

public class XMLResourcePropertyTester extends PropertyTester {

	private static final String NAMESPACE = "namespace";

	private static final String XML_EXTENSION = "xml";

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (NAMESPACE.equals(property) && null != receiver && receiver instanceof IFile) {
			IFile resource = (IFile) receiver;

			if (resource.getType() == IFile.FILE && resource.getFileExtension().equalsIgnoreCase(XML_EXTENSION)) {

				return Helper.containOpenCIMNamespace(resource);
			}
		}
		return false;
	}
}