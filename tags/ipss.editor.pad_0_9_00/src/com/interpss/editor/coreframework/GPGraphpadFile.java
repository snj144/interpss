package com.interpss.editor.coreframework;

import java.awt.geom.Point2D;
import java.beans.BeanInfo;
import java.beans.DefaultPersistenceDelegate;
import java.beans.Encoder;
import java.beans.ExceptionListener;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.Statement;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;

import org.jgraph.JGraph;
import org.jgraph.graph.AbstractCellView;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.DefaultGraphModel;
import org.jgraph.graph.DefaultPort;
import org.jgraph.graph.EdgeView;
import org.jgraph.graph.GraphLayoutCache;
import org.jgraph.graph.GraphModel;
import org.jgraph.graph.PortView;
import org.jgraph.graph.VertexView;

import com.interpss.editor.coreframework.jgraphsubclassers.GPGraphModel;
import com.interpss.editor.data.proj.ProjData;

public class GPGraphpadFile extends DefaultMutableTreeNode {
	protected Map map;

	public static final String GRAPH_LAYOUT_CACHE = "GraphLayoutCache";

	private ProjData projData = null;
	
	public GPGraphpadFile() {
		this(new GraphLayoutCache());
	}

	public GPGraphpadFile(GraphLayoutCache graphlayoutcache) {
		this(graphlayoutcache, new Hashtable());
	}

	public GPGraphpadFile(GraphLayoutCache graphlayoutcache, Map map) {
		super();
		this.map = map;
		map.put(GRAPH_LAYOUT_CACHE, graphlayoutcache);
	}

	public void setGraphLayoutCache(GraphLayoutCache graphlayoutcache) {
		map.put(GRAPH_LAYOUT_CACHE, graphlayoutcache);
	}

	public GraphLayoutCache getGraphLayoutCache() {
		GraphLayoutCache cache = (GraphLayoutCache) map.get(GRAPH_LAYOUT_CACHE);
		if (cache == null)
			cache = new GraphLayoutCache();
		return cache;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	/**
	 * Reads a GPGraphpadFile file
	 * 
	 * @param in
	 *            the input stream to read
	 * @return the graph that is read in
	 */
	public static GPGraphpadFile read(InputStream in) throws IOException {
		XMLDecoder reader = new XMLDecoder(in);
		Object decoded = reader.readObject();
		in.close();
		if (decoded instanceof GPGraphpadFile) {
			return (GPGraphpadFile) decoded;
		}
		if (decoded instanceof GraphLayoutCache) {
			return new GPGraphpadFile((GraphLayoutCache) decoded);
		}
		if (decoded instanceof JGraph) {
			return null;
		}
		if (decoded instanceof GraphModel) {
			return null;
		}
		System.err.print("Unrecognized file format! May you should use import...");
		return null;
	}

	/**
	 * Saves the current graph in a file. We use long-term bean persistence to
	 * save the program data. See
	 * http://java.sun.com/products/jfc/tsc/articles/persistence4/index.html for
	 * an overview.
	 * 
	 * @param out
	 *            the stream for saving
	 */
	public void saveFile(OutputStream out) {
		XMLEncoder encoder = new XMLEncoder(out);
		makeCellViewFieldsTransient(PortView.class);
		makeCellViewFieldsTransient(VertexView.class);
		makeCellViewFieldsTransient(EdgeView.class);

		configureEncoder(encoder);

		try {
			BeanInfo info = Introspector.getBeanInfo(JGraph.class);
			PropertyDescriptor[] propertyDescriptors = info
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; ++i) {
				PropertyDescriptor pd = propertyDescriptors[i];
				if (pd.getName().equals("marqueeHandler")) {
					pd.setValue("transient", Boolean.TRUE);
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}

		encoder.setExceptionListener(new ExceptionListener() {
			public void exceptionThrown(Exception ex) {
				ex.printStackTrace();
			}
		});

		encoder.setPersistenceDelegate(Point2D.Double.class,
				new DefaultPersistenceDelegate() {
					protected void initialize(Class type, Object oldInstance,
							Object newInstance, Encoder out) {
						super.initialize(type, oldInstance, newInstance, out);
						Point2D p = (Point2D) oldInstance;
						out.writeStatement(new Statement(oldInstance,
								"setLocation", new Object[] {
										new Double(p.getX()),
										new Double(p.getY()) }));
					}
				});

		encoder.writeObject(this.getGraphLayoutCache());
		encoder.close();
	}

	protected void configureEncoder(XMLEncoder encoder) {
		encoder.setPersistenceDelegate(DefaultGraphModel.class,
				new DefaultPersistenceDelegate(new String[] { "roots",
						"attributes" }));
		encoder.setPersistenceDelegate(GPGraphModel.class,
				new DefaultPersistenceDelegate(new String[] { "roots",
						"attributes" }));
		/*encoder.setPersistenceDelegate(GPGraph.class,
				new DefaultPersistenceDelegate(new String[] { "model",
						"graphLayoutCache" }));*/
		encoder.setPersistenceDelegate(JGraph.class,
				new DefaultPersistenceDelegate(new String[] { "model",
						"graphLayoutCache" }));
		encoder
				.setPersistenceDelegate(GraphLayoutCache.class,
						new DefaultPersistenceDelegate(new String[] { "model",
								"factory", "cellViews", "hiddenCellViews",
								"partial" }));
		encoder.setPersistenceDelegate(GPGraphpadFile.class,
				new DefaultPersistenceDelegate(new String[] { "map" }));

		encoder.setPersistenceDelegate(DefaultGraphCell.class,
				new DefaultPersistenceDelegate(new String[] { "userObject" }));
		encoder.setPersistenceDelegate(DefaultEdge.class,
				new DefaultPersistenceDelegate(new String[] { "userObject" }));
		encoder.setPersistenceDelegate(DefaultPort.class,
				new DefaultPersistenceDelegate(new String[] { "userObject" }));
		encoder.setPersistenceDelegate(AbstractCellView.class,
				new DefaultPersistenceDelegate(new String[] { "cell",
						"attributes" }));
		encoder.setPersistenceDelegate(ArrayList.class, encoder
				.getPersistenceDelegate(List.class));
	}

	public void makeCellViewFieldsTransient(Class clazz) {
		try {
			BeanInfo info = Introspector.getBeanInfo(clazz);
			PropertyDescriptor[] propertyDescriptors = info
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; ++i) {
				PropertyDescriptor pd = propertyDescriptors[i];
				if (!pd.getName().equals("cell")
						&& !pd.getName().equals("attributes")) {
					pd.setValue("transient", Boolean.TRUE);
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}
	public ProjData getProjData() { return this.projData; }
	public void setProjData(ProjData info) {
		this.projData = info;
	}
}
