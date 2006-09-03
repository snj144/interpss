package org.interpss.editor.jgraph.cells;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.interpss.editor.jgraph.ui.form.IGBusForm;
import org.jgraph.JGraph;
import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.DefaultPort;
import org.jgraph.graph.GraphConstants;



public class BusCell extends DefaultGraphCell implements IIpssGraphCell {
	private static final long serialVersionUID = 1;

	public static final String LABEL_POSITION_CENTER = "LabelPositionCenter";

	public static final String LABEL_POSITION_UP = "LabelPositionUp";

	public static final String LABEL_POSITION_LEFT = "LabelPositionLeft";

	public static final String LABEL_POSITION_RIGHT = "LabelPositionRight";

	public static final String LABEL_POSITION_DOWN = "LabelPositionDown";

	private LabelCell _label = null;

	private AnnotateLabelCell _labelAnnotate = null;

	// constants for configuration
	public static int DefaultBusWidth = 5, DefaultBusHeight = 40,
			BusLabelOffset = 5;

	// constants for configuration
	public static Color BorderColor = Color.white,
			BackgroundColor = Color.gray;

	/**
	 * Constructor
	 * 
	 * @param userObject
	 *            user defined object assciated with this cell
	 */
	public BusCell(Object userObject) {
		super(userObject);

		// // Add one Floating Port
		// add(new DefaultPort());

		// Add label
		this._label = new LabelCell(this, userObject);

		// modified by Mike 12/22/05
		this._labelAnnotate = new AnnotateLabelCell(this, userObject);
	}

	/**
	 * Get the bus form object
	 * 
	 * @return the bus form object
	 */
	public IGBusForm getBusForm() {
		return (IGBusForm) getUserObject();
	}

	/**
	 * Get the attached bus label
	 * 
	 * @return the label cell object
	 */
	public LabelCell getLabel() {
		return this._label;
	}

	/**
	 * Set the label attached to the bus
	 */
	public void setLabel(LabelCell label) {
		this._label = label;
	}

	public void set_labelAnnotate(AnnotateLabelCell _labelAnnotate) {
		this._labelAnnotate = _labelAnnotate;
	}

	public AnnotateLabelCell get_labelAnnotate() {
		return _labelAnnotate;
	}

	/**
	 * Rotate bus orientation
	 * 
	 * @param cell
	 *            the bus cell object
	 * @param graph
	 *            the graph object
	 */
	// public void rotate(Object cell, JGraph graph) {
	// getBusForm().setOrientation(isVertical()?
	// GBusForm.H_Orientation : GBusForm.V_Orientation);
	// GraphCellFactory.LastSelectedBusOrientation =
	// getBusForm().getOrientation();
	// CellView view = graph.getGraphLayoutCache().getMapping(cell, false);
	// ((AbstractBusView)view).rotateSetAttributes();
	// graph.clearSelection();
	// graph.getGraphLayoutCache().reload();
	// }
	/**
	 * Check if the bus is horizontal orientation
	 * 
	 * @return true or false
	 */
	public boolean isHorizontal() {
		return (getBusForm().getOrientation() == IGBusForm.H_Orientation);
	}

	/**
	 * Check if the bus is vertaion orientation
	 * 
	 * @return true or false
	 */
	public boolean isVertical() {
		return (getBusForm().getOrientation() == IGBusForm.V_Orientation);
	}

	/**
	 * Create bus attributes
	 * 
	 * @param point
	 *            the left conner point
	 * @return attributes map
	 */

	public AttributeMap getAttributeMap(JGraph graph, Rectangle2D bounds) {
		AttributeMap attributeMap = new AttributeMap();
		double scale = graph.getScale();
		if (getBusForm().getOrientation() == IGBusForm.V_Orientation)
			bounds.setRect(bounds.getX() / scale, bounds.getY() / scale,
					DefaultBusWidth, bounds.getHeight() / scale);
		else
			bounds.setRect(bounds.getX() / scale, bounds.getY() / scale, bounds
					.getWidth()
					/ scale, DefaultBusWidth);
		GraphConstants.setBounds(attributeMap, bounds);
		GraphConstants.setOpaque(attributeMap, true);
		GraphConstants.setInset(attributeMap, 40);
		GraphConstants.setBorderColor(attributeMap, BorderColor);
		GraphConstants.setBackground(attributeMap, BackgroundColor);
		
		return attributeMap;
	}

	/**
	 * Insert this bus into the graph object on the point with a LabelCell
	 * attached to the bus.
	 * 
	 * @param graph
	 *            the graph object
	 * @param point
	 *            the left upper conner point
	 * @param target
	 *            the target port
	 */
	public void insert(JGraph graph, Rectangle2D bounds) {

		List toInsert = new LinkedList();
		// view attributes creation:

		AttributeMap attributeMap = getAttributeMap(graph, bounds);
		// insertion of the cell:
		Map viewMap = new Hashtable();
		viewMap.put(this, attributeMap);
		toInsert.add(this);

		Object port = new DefaultPort();
		add((DefaultPort) port);
		toInsert.add(port);

		// Insert the Vertex and its Attributes (can also use model)
		graph.getModel().insert(toInsert.toArray(), viewMap, null, null, null);
		insertLabel(graph, bounds);
		insertLabelAnnotate(graph, bounds);

	}

	public void insertLabel(JGraph graph, Rectangle2D bounds) {
		// Insert the Label and its Attributes (can also use model)

		Rectangle2D labelbounds = GraphUtilFunc.getLabelPosition(graph.getScale(),
				new Dimension(this._label.getWidth(), this._label.getHeight()),
				bounds, BusLabelOffset, LABEL_POSITION_UP);
		// Mike 12/25/05
		this._label.insert(graph, labelbounds);
	}

	public void insertLabelAnnotate(JGraph graph, Rectangle2D bounds) {
		Rectangle2D labelbounds = GraphUtilFunc.getLabelPosition(graph.getScale(),
				new Dimension(this._labelAnnotate.getWidth(),
						this._labelAnnotate.getHeight()), bounds,
				BusLabelOffset, LABEL_POSITION_LEFT);
		labelbounds.setRect(labelbounds.getX(), labelbounds.getY()
				- DefaultBusHeight / 2, labelbounds.getWidth(), labelbounds
				.getHeight());
		this._labelAnnotate.insert(graph, labelbounds);
	}


//	public Object clone() {
//		BusCell c = (BusCell) super.clone();
//		c.set_labelAnnotate(new AnnotateLabelCell(c,c.getUserObject()));
//		c.setLabel(new LabelCell(c,c.getUserObject()));
//		return c;
//	}
	public String toString() {
		return "";
	}

}
