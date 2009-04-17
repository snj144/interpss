/*
 * Created on 17 juin 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.interpss.editor.coreframework.actions.celltoolboxes;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

import javax.swing.JToggleButton;

import org.interpss.editor.coreframework.GPBarFactory;
import org.interpss.editor.coreframework.GPGraphpad;
import org.interpss.editor.coreframework.IpssAbstractGraphAction;
import org.jgraph.graph.GraphCell;


/**
 * @author Rapha�l Valyi
 * 
 * This is the super class of various java beans containing their own data for the
 * creation of a given graph cells once a button is pressed.
 * @see org.jgraph.pad.actions.celltoolboxes.AbstractDefaultVertexnPortsCreator
 * @see org.jgraph.pad.actions.celltoolboxes.AbstractDefaultEdgeCreator
 */
public abstract class AbstractCellCreator extends IpssAbstractGraphAction {
	
    private JToggleButton button ;
    
    public void setGraphpad(GPGraphpad graphpad) {
		this.graphpad = graphpad;
	}

	public void actionPerformed(ActionEvent e) {
	}

	public void update() {
		super.update();
		this.getButton().setEnabled(isEnabled());
	}

	public Component getToolComponent(String actionCommand) {
		GPBarFactory.fillToolbarButton(this.getButton(), getName(),
				actionCommand);
		return this.getButton();
	}
	
	/**
	 * We assume the user would like to freely override how the cell custom user
	 * object properties are created
	 * 
	 * @param cell
	 * @return null
	 */
	public Map getUserObjectProperties(GraphCell cell) {
		return null;//by default
	}


	/**
	 * usefull to use as a key for a cell model factory
	 */
	public String getModelType() {
		return "";
	}
	
	/**
	 * This hook allow to take a special action just after creating the cell
	 * For instance editing the cell.
	 * @param cell
	 */
	public void actionForCell(GraphCell cell) {
		//example:
		//graphpad.getCurrentGraph().startEditingAtCell(cell);
	}

    public JToggleButton getButton() {
    	if (button == null)
    	{
    		button = new JToggleButton();
    		
    		button.addItemListener(new ItemListener() {
    			public void itemStateChanged(final ItemEvent e) {
    				if (button.isSelected())
    					actionForButtonDown();
    				else
    					actionForButtonUp();
    			}
    		});
    	}
    		
        return button;
    }

    public void setButton(JToggleButton button) {
        this.button = button;
    }

    public void actionForButtonDown() {
    }
    public void actionForButtonUp() {
    }

}
