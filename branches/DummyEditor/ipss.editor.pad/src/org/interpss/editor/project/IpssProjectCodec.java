package org.interpss.editor.project;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.filechooser.FileFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.interpss.editor.coreframework.GPGraphpad;
import org.interpss.editor.doc.IpssProject;
import org.interpss.editor.doc.IpssProjectItem;
import org.interpss.editor.doc.IpssProjectItemCollector;
import org.interpss.editor.resources.Translator;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class IpssProjectCodec {

	private static IpssProjectCodec _instance;

	/**
	 * file filter for this file format
	 */
	FileFilter fileFilter;

	/**
	 * accessory component. A checkbox for the zipped output or unzipped output
	 * 
	 */
	JComponent compZipSelect;

	/**
	 * a const value for the key at the properties hashtable
	 */
	public static final String COMPRESS_WITH_ZIP = "CompressWithZip";

	public static IpssProjectCodec getInstance(GPGraphpad pad) {
		if (null == _instance) {
			_instance = new IpssProjectCodec(pad);
		}
		return _instance;
	}

	protected IpssProjectCodec(GPGraphpad pad) {
		fileFilter = new FileFilter() {
			/**
			 * @see javax.swing.filechooser.FileFilter#accept(File)
			 */
			public boolean accept(File f) {
				if (f == null)
					return false;
				if (f.getName() == null)
					return false;
				if (f.getName().endsWith(".ipssp"))
					return true;
				if (f.isDirectory())
					return true;

				return false;
			}

			/**
			 * @see javax.swing.filechooser.FileFilter#getDescription()
			 */
			public String getDescription() {
				return Translator.getString("ProjectFileExtensionDescription");
			}
		};
		compZipSelect = new JCheckBox(Translator.getString("zipCompress"));
	}

	/**
	 * Writes the graph as XML file
	 */
	public void write(OutputStream out, IpssProject project) throws Exception {

		// don't try / catch this command
		// sothat we get error messages at the
		// frontend.
		// e.g. I you have not permissions to
		// write a file you should get an error message

		out = new BufferedOutputStream(out);
		out.write(toString(project).getBytes());
		out.flush();
		out.close();
	}

	//
	// Write
	//

	public String toString(IpssProject project) {

		StringBuffer xml = new StringBuffer();
		xml.append("<ipssp-1.0>\n");

		xml.append(outputItems(project, "\t"));

		xml.append("</ipssp-1.0>\n");
		return xml.toString();
	}

	public String outputItems(IpssProjectItemCollector itemCollector,
			String indent) {
		StringBuffer xml = new StringBuffer();

		IpssProjectItem[] projectItems = itemCollector.getAllProjectItems();

		if (projectItems == null)
			return "";
		xml.append(indent + "<items>\n");
		for (int i = 0; i < projectItems.length; i++) {
			xml.append(indent + outputItem(projectItems[i], indent));
		}
		xml.append(indent + "</items>\n");
		return xml.toString();
	}

	public String outputItem(IpssProjectItem item, String indent) {
		StringBuffer xml = new StringBuffer();
		xml.append(indent + "<item filename=\"" + item.getFileName()
				+ "\" projDbId =\"" + item.getProjDbId() + "\" status=\""
				+ item.getInit_Status() + "\">\n");

		if (item.getItemCount() > 0)
			xml.append(indent + outputItems(item, indent));

		xml.append(indent + "</item>\n");
		return xml.toString();
	}

	//
	// Read
	//

	public void read(InputStream in, IpssProject project) throws Exception {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// Create a DocumentBuilder
		DocumentBuilder db = dbf.newDocumentBuilder();
		// Parse the input file to get a Document object
		Document doc = db.parse(in);

		NodeList nodelist = doc.getDocumentElement().getChildNodes();

		parseItems(project, nodelist);
	}

	private void parseItems(IpssProjectItemCollector itemCollector,
			NodeList nodelist) {
		// Get the first child
		Node modelNode = null;
		for (int i = 0; i < nodelist.getLength(); i++) {
			Node node = nodelist.item(i);
			if (node.getNodeName().toLowerCase().equals("items")) {
				modelNode = node;
			}
		}
		if (modelNode!= null)
			parseItem(itemCollector, modelNode);
	}

	public void parseItem(IpssProjectItemCollector itemCollector, Node node) {
		for (int i = 0; i < node.getChildNodes().getLength(); i++) {
			Node child = node.getChildNodes().item(i);
			if (child.getNodeName().toLowerCase().equals("item")) {
				Node filename = child.getAttributes().getNamedItem("filename");
				Node projDbId = child.getAttributes().getNamedItem("projDbId");
				Node status = child.getAttributes().getNamedItem("status");
				if (filename != null) {
					IpssProjectItem item = itemCollector.addDocument(
							itemCollector.getProject().getProjectPath()
									+ System.getProperty("file.separator")
									+ filename.getNodeValue(), Integer
									.parseInt(projDbId.getNodeValue()), status
									.getNodeValue());
					parseItems(item, child.getChildNodes());
				}

			}
		}
	}

	// public void parseItem(IpssProjectItemCollector itemCollector, Node child)
	// {
	// if (child.getNodeName().toLowerCase().equals("item")) {
	// Node filename = child.getAttributes().getNamedItem("filename");
	// Node projDbId = child.getAttributes().getNamedItem("projDbId");
	// Node status = child.getAttributes().getNamedItem("status");
	// if (filename != null)
	// itemCollector.addDocument(itemCollector.getProject().getProjectPath()
	// + System.getProperty("file.separator")
	// + filename.getNodeValue(), Integer.parseInt(projDbId
	// .getNodeValue()), status.getNodeValue());
	// }
	// }
}
