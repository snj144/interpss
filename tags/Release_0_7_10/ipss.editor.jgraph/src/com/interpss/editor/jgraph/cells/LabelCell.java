package com.interpss.editor.jgraph.cells;

import java.awt.Font;
import java.awt.geom.Rectangle2D;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgraph.JGraph;
import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;

import com.interpss.editor.resources.Translator;

public class LabelCell extends DefaultGraphCell implements IIpssGraphCell{

	private boolean _multiLined = true;

	public static String _fontName = "Arial";
	public static int    _fontStyle = Font.PLAIN;
	public static int    _fontSize = 12;	
	private static int    _width = 50;
	private static int    _height = 20;
	
	private static final long serialVersionUID = 1;

	private Object _parentCell = null;
	/**
	* 	Constructor
	*
	* @param userObject user defined object assciated with this cell
	*/
	public LabelCell (Object parent, Object userObject) {
		super(userObject);
		this._parentCell = parent;
	}


    
//    public LabelCell(Object userObject, boolean multiLined) {
//      super(userObject);
//      this._multiLined = multiLined;
//    }

	/**
	*	Get the parent object
	*
	* @return the parent object
	*/
	public Object getParentCell() {
		return this._parentCell;
	}
	
	/**
	*	Get the parent object
	*
	* @return the parent object
	*/
	public void setParentCell(Object cell) {
		this._parentCell = cell;
	}
    
	public Font getFont() {
		return new Font(this._fontName, this._fontStyle, this._fontSize);
	}
	
	public boolean isMultiLined() {
		return _multiLined;
	}

	public void setMultiLined(boolean multiLined) {
	      this._multiLined = multiLined;
	}
	
//	public AttributeMap getAttributeMap(Rectangle2D bounds) {
//		// Create a Map that holds the attributes for the Vertex
//		AttributeMap attributeMap = new AttributeMap();
//
//		// Default Size for the new Vertex
//		Dimension size = new Dimension(width, height);
//		
//		// Add a Bounds Attribute to the Map
//		GraphConstants.setBounds(map, new Rectangle(point, size));
//
//		GraphConstants.setOpaque(map, false);
//		
//		// set Label Font Mike 12/25/05
//		GraphConstants.setFont(map, getFont());
//
//		return map;
//	}
	
	public void setWidth(int _width) {
		this._width = _width;
	}

	public int getWidth() {
		return _width;
	}

	public void setHeight(int _height) {
		this._height = _height;
	}

	public int getHeight() {
		return _height;
	}

	public AttributeMap getAttributeMap(JGraph graph,Rectangle2D bounds) {
		AttributeMap attributeMap = new AttributeMap();
		
		double scale = graph.getScale();
		bounds.setRect(bounds.getX()/scale, bounds.getY()/scale, bounds.getWidth()/scale, bounds.getHeight()/scale);

		GraphConstants.setBounds(attributeMap, bounds);
		GraphConstants.setOpaque(attributeMap, true);
		GraphConstants.setInset(attributeMap, 40);
		//GraphConstants.setBorderColor(attributeMap, Color.black);
		String fontName = Translator.getString("FontName");
		GraphConstants.setFont(attributeMap, getFont());
		return attributeMap;
	}
	
	
	/**
	* 	Insert this cell into the graph object on the point
	*
	* @param graph the graph object
	* @param point the left upper conner point
	* @param width the label width
	* @param height the label height
	*/
	public void insert(JGraph graph,Rectangle2D bounds) {
		List toInsert = new LinkedList();
		// view attributes creation:
		AttributeMap attributeMap = getAttributeMap(graph,bounds);
		// insertion of the cell:
		Map viewMap = new Hashtable();
		viewMap.put(this, attributeMap);
		toInsert.add(this);

		// Insert the Vertex and its Attributes (can also use model)
		graph.getModel().insert(toInsert.toArray(),
				viewMap, null, null, null);
		
	}

}
