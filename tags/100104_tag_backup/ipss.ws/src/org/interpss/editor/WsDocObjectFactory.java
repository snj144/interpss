/*
 * Created on Apr 6, 2005
 *
 */
package org.interpss.editor;

import org.interpss.editor.doc.IpssCustomDocument;
import org.interpss.editor.doc.IpssDbDocument;
import org.interpss.editor.doc.IpssDocFactory;
import org.interpss.editor.doc.IpssDocumentItem;
import org.interpss.editor.doc.IpssEditableDocument;
import org.interpss.editor.doc.IpssEditorDocument;
import org.interpss.editor.doc.IpssGraphicDocument;
import org.interpss.editor.doc.IpssReportDocument;
import org.interpss.editor.doc.IpssTextDocument;
import org.interpss.editor.doc.IpssXmlDocument;
import org.interpss.editor.ws.IpssProject;
import org.interpss.editor.ws.IpssProjectFolder;
import org.interpss.editor.ws.IpssProjectItemGroup;
import org.interpss.editor.ws.IpssWorkSpace;
import org.interpss.editor.ws.IpssWsDbItem;
import org.interpss.editor.ws.IpssWsFactory;
import org.interpss.editor.ws.IpssWsFileItem;

/**
 * @author mzhou
 *
 */
public class WsDocObjectFactory {
	/**
	 * Create a WS File Item. It always has a parent Project or ProjectItemGroup and an associated ipss editable document
	 * 
	 * @param proj the parent project object
	 * @param doc the associated document
	 * @return
	 */
	public static IpssWsFileItem createIpssWsFileItem(IpssProject proj, IpssEditableDocument doc) {
		IpssWsFileItem item = IpssWsFactory.eINSTANCE.createIpssWsFileItem();
		proj.getWsItemList().add(item);
		item.setIpssDoc(doc);
		return item;
	}

	/**
	 * Create a WS File Item. It always has a parent Project or ProjectItemGroup and an associated ipss editor document
	 *  
	 * @param itemGroup the parent project item group object
	 * @param doc the associated document
	 * @return
	 */
	public static IpssWsFileItem createIpssWsFileItem(IpssProjectItemGroup itemGroup, IpssEditorDocument doc) {
		IpssWsFileItem item = IpssWsFactory.eINSTANCE.createIpssWsFileItem();
		itemGroup.getWsItemList().add(item);
		item.setIpssDoc(doc);
		return item;
	}
	
	/**
	 * Create a WS Db Item. It always has a parent ProjectItemGroup and an associated ipss Db document
	 * 
	 * @param itemGroup the parent project item group object
	 * @param doc the associated document
	 * @return
	 */
	public static IpssWsDbItem createIpssWsDbItem(IpssProjectItemGroup itemGroup, IpssDbDocument doc) {
		IpssWsDbItem item = IpssWsFactory.eINSTANCE.createIpssWsDbItem();
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
	public static IpssProject createIpssProject(IpssProjectFolder folder, IpssDocumentItem doc) {
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
	 * @param item the associated WS item object
	 * @return
	 */
	public static IpssReportDocument createIpssCustomDocument(IpssWsFileItem item) {
		IpssReportDocument doc = IpssDocFactory.eINSTANCE.createIpssReportDocument();
		doc.setWsItem(item);
		return doc;
	}	

	/**
	 * create a Text document. It is always associated with a Project item object
	 * 
	 * @param item the associated WS item object
	 * @return
	 */
	public static IpssTextDocument createIpssTextDocument(IpssWsFileItem item) {
		IpssTextDocument doc = IpssDocFactory.eINSTANCE.createIpssTextDocument();
		doc.setWsItem(item);
		return doc;
	}	
	
	/**
	 * create a Xml document. It is always associated with a Project item object
	 * 
	 * @param item the associated WS item object
	 * @return
	 */
	public static IpssXmlDocument createIpssXmlDocument(IpssWsFileItem item) {
		IpssXmlDocument doc = IpssDocFactory.eINSTANCE.createIpssXmlDocument();
		doc.setWsItem(item);
		return doc;
	}	

	/**
	 * create a report document. It is always associated with a Project item object
	 * 
	 * @param item the associated WS item object
	 * @return
	 */
	public static IpssReportDocument createIpssReportDocument(IpssWsFileItem item) {
		IpssReportDocument doc = IpssDocFactory.eINSTANCE.createIpssReportDocument();
		doc.setWsItem(item);
		return doc;
	}

	/**
	 * create a db document. It is always associated with a Project item object
	 * 
	 * @param item the associated WS item object
	 * @return
	 */
	public static IpssDbDocument createIpssDbDocument(IpssWsDbItem item) {
		IpssDbDocument doc = IpssDocFactory.eINSTANCE.createIpssDbDocument();
		doc.setWsItem(item);
		return doc;
	}
}
