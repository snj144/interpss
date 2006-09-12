package org.interpss.editor.jgraph.cells;

import java.awt.Font;



public class AnnotateLabelCell extends LabelCell {
 
	public static String _fontName = "Arial Narrow";
	public static int    _fontStyle = Font.PLAIN;
	public static int    _fontSize = 10;	
	public static int    _width = 50;
	public static int    _height = 40;

	/**
	* 	Constructor
	*
	* @param userObject user defined object assciated with this cell
	*/
	public AnnotateLabelCell (Object parent, Object userObject) {
		super(parent, userObject);
	}
	public Font getFont() {
		return new Font(this._fontName, this._fontStyle, this._fontSize);
	}
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
}
