/*
 * Created on Apr 6, 2005
 *
 */
package org.interpss.editor;

import org.interpss.editor.doc.IpssCustomDocument;
import org.interpss.editor.doc.IpssDocFactory;
import org.interpss.editor.doc.IpssDocument;
import org.interpss.editor.doc.IpssGraphicDocument;
import org.interpss.editor.doc.IpssReportDocument;
import org.interpss.editor.doc.IpssTextDocument;
import org.interpss.editor.doc.IpssXmlDocument;
import org.interpss.editor.ws.IpssProject;
import org.interpss.editor.ws.IpssProjectFolder;
import org.interpss.editor.ws.IpssProjectItem;
import org.interpss.editor.ws.IpssProjectItemGroup;
import org.interpss.editor.ws.IpssWorkSpace;
import org.interpss.editor.ws.IpssWsFactory;

/**
 * @author mzhou
 *
 */
public class WsDocObjectFactory {
	/**
	 * Create a Project Item. It always has a parent Project or ProjectItemGroup and an associated ipss document
	 * 
	 * @param proj the parent project object
	 * @param doc the associated document
	 * @return
	 */
	public static IpssProjectItem createIpssProjectItem(IpssProject proj, IpssDocument doc) {
		IpssProjectItem item = IpssWsFactory.eINSTANCE.createIpssProjectItem();
		proj.getWsItemList().add(item);
		item.setIpssDoc(doc);
		return item;
	}

	/**
	 * Create a Project Item. It always has a parent Project or ProjectItemGroup and an associated ipss document
	 * 
	 * @param itemGroup the parent project item group object
	 * @param doc the associated document
	 * @return
	 */
	public static IpssProjectItem createIpssProjectItem(IpssProjectItemGroup itemGroup, IpssDocument doc) {
		IpssProjectItem item = IpssWsFactory.eINSTANCE.createIpssProjectItem();
		itemGroup.getWsItemList().add(item);
		item.setIpssDoc(doc);
		return item;
	}
	
	/**
	 * Create a Project Item Group. It always has a parent Project
	 * 
	 * @param proj the parent project object
	 * @param doc the associated document
	 * @return
	 */
	public static IpssProjectItemGroup createIpssProjectItemGroup(IpssProject proj) {
		IpssProjectItemGroup itemGroup = IpssWsFactory.eINSTANCE.createIpssProjectItemGroup();
		proj.getWsItemList().add(itemGroup);
		return itemGroup;
	}	
	/**
	 * Create a Project. It always has a parent Folder and an associated ipss document
	 * 
	 * @param folder the parent folder object
	 * @param doc the associated document
	 * @return
	 */	
	public static IpssProject createIpssProject(IpssProjectFolder folder, IpssDocument doc) {
		IpssProject proj = IpssWsFactory.eINSTANCE.createIpssProject();
		folder.getWsItemList().add(proj);
		proj.setIpssDoc(doc);
		return proj;
	}

	/**
	 * Create a Project Folder. It always has a parent Workspace
	 * 
	 * @param ws the parent Workspace object
	 * @return
	 */
	public static IpssProjectFolder createIpssProjectFolder(IpssWorkSpace ws) {
		IpssProjectFolder folder = IpssWsFactory.eINSTANCE.createIpssProjectFolder();
		ws.getWsItemList().add(folder);
		return folder;
	}

	/**
	 * create a Workspace object. At anytime, there should be only one WS object
	 * 
	 * @return
	 */
	public static IpssWorkSpace createIpssWorkSpace() {
		return IpssWsFactory.eINSTANCE.createIpssWorkSpace();
	}

	/**
	 * create a custom document. It is always associated with a Project object
	 * 
	 * @param proj the associated Project object
	 * @return
	 */
	public static IpssCustomDocument createIpssCustomDocument(IpssProject proj) {
		IpssCustomDocument doc = IpssDocFactory.eINSTANCE.createIpssCustomDocument();
		doc.setWsItem(proj);
		return doc;
	}
	
	/**
	 * create a graphic document (GPDocument). It is always associated with a Project object
	 * 
	 * @param proj the associated Project object
	 * @return
	 */
	public static IpssGraphicDocument createIpssGraphicDocument(IpssProject proj) {
		IpssGraphicDocument doc = IpssDocFactory.eINSTANCE.createIpssGraphicDocument();
		doc.setWsItem(proj);
		return doc;
	}	
	
	/**
	 * create a Report document. It is always associated with a Project item object
	 * 
	 * @param proj the associated Project item object
	 * @return
	 */
	public static IpssReportDocument createIpssCustomDocument(IpssProjectItem item) {
		IpssReportDocument doc = IpssDocFactory.eINSTANCE.createIpssReportDocument();
		doc.setWsItem(item);
		return doc;
	}	

	/**
	 * create a Text document. It is always associated with a Project item object
	 * 
	 * @param proj the associated Project item object
	 * @return
	 */
	public static IpssTextDocument createIpssTextDocument(IpssProjectItem item) {
		IpssTextDocument doc = IpssDocFactory.eINSTANCE.createIpssTextDocument();
		doc.setWsItem(item);
		return doc;
	}	
	
	/**
	 * create a Xml document. It is always associated with a Project item object
	 * 
	 * @param proj the associated Project item object
	 * @return
	 */
	public static IpssXmlDocument createIpssXmlDocument(IpssProjectItem item) {
		IpssXmlDocument doc = IpssDocFactory.eINSTANCE.createIpssXmlDocument();
		doc.setWsItem(item);
		return doc;
	}	
}
