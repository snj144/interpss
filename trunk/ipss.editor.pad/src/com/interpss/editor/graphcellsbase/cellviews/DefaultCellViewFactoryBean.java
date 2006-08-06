package com.interpss.editor.graphcellsbase.cellviews;

import java.util.ArrayList;

import org.jgraph.graph.DefaultCellViewFactory;
import org.jgraph.graph.EdgeView;
import org.jgraph.graph.VertexView;

import com.interpss.editor.jgraph.cells.AnnotateLabelCell;
import com.interpss.editor.jgraph.cells.BranchEdge;
import com.interpss.editor.jgraph.cells.BusCell;
import com.interpss.editor.jgraph.cells.LabelCell;
import com.interpss.editor.jgraph.cells.NetLabelCell;
import com.interpss.editor.jgraph.cells.SimpleLabelCell;



/**
 * A default view factory for a JGraph. This simple factory associate a given
 * cell class to a cell view. This is a javabean, just parameter it correctly in
 * order it meets your requirements (else subclass it or subclass
 * DefaultCellViewFactory). You can also recover the gpConfiguration of that
 * javabean via an XML file via XMLEncoder/XMLDecoder.
 * 
 * @author rvalyi, license of this file: LGPL as stated by the Free Software
 *         Foundation
 */
public class DefaultCellViewFactoryBean extends DefaultCellViewFactory {

    private ArrayList viewIndirections;
    private ArrayList edgeIndirections;
    
    public DefaultCellViewFactoryBean() {
		ArrayList vect = new ArrayList(4);
		ViewIndirection indir1 = new ViewIndirection();
		indir1.setCellClass(NetLabelCell.class);
		indir1.setViewClass(JGraphLabelView.class);
		vect.add(indir1);
		ViewIndirection indir2 = new ViewIndirection();
		indir2.setCellClass(LabelCell.class);
		indir2.setViewClass(JGraphLabelView.class);
		vect.add(indir2);
		ViewIndirection indir3 = new ViewIndirection();
		indir3.setCellClass(AnnotateLabelCell.class);
		indir3.setViewClass(JGraphLabelView.class);
		vect.add(indir3);
		ViewIndirection indir4 = new ViewIndirection();
		indir4.setCellClass(BusCell.class);
		indir4.setViewClass(JGraphBusView.class);
		vect.add(indir4);
		ViewIndirection indir5 = new ViewIndirection();
		indir4.setCellClass(SimpleLabelCell.class);
		indir4.setViewClass(JGraphMultilineView.class);
		vect.add(indir5);
		setViewIndirections(vect);
		
		
		ArrayList evect = new ArrayList(1);
		ViewIndirection eindir1 = new ViewIndirection();
		eindir1.setCellClass(BranchEdge.class);
		eindir1.setViewClass(JGraphBranchEdgeView.class);
		evect.add(eindir1);
		setEdgeIndirections(evect);
    }

    public static class ViewIndirection {
        private Class cellClass;

        private Class viewClass;

        public Class getCellClass() {
            return cellClass;
        }

        public void setCellClass(Class cellClass) {
            this.cellClass = cellClass;
        }

        public Class getViewClass() {
            return viewClass;
        }

        public void setViewClass(Class viewClass) {
            this.viewClass = viewClass;
        }
    }

    protected VertexView createVertexView(Object v) {
        VertexView view = null;
        try {
            for (int i = 0; i < viewIndirections.size(); i++) {
                ViewIndirection indirection = (ViewIndirection) viewIndirections
                        .get(i);
                if (v.getClass() == indirection.cellClass) {
                    view = (VertexView) indirection.viewClass.newInstance();
                    view.setCell(v);
                    return view;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.createVertexView(v);
    }
    
	protected EdgeView createEdgeView(Object v) {
		EdgeView view = null;
        try {
            for (int i = 0; i < edgeIndirections.size(); i++) {
            	ViewIndirection indirection = (ViewIndirection) edgeIndirections
                        .get(i);
                if (v.getClass() == indirection.cellClass) {
                    view = (EdgeView) indirection.viewClass.newInstance();
                    view.setCell(v);
                    return view;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.createEdgeView(v);
	}
	
    public ArrayList getViewIndirections() {
        return viewIndirections;
    }

    public void setViewIndirections(ArrayList viewIndirections) {
        this.viewIndirections = viewIndirections;
    }
    
    public ArrayList getEdgeIndirections() {
        return edgeIndirections;
    }
    public void setEdgeIndirections(ArrayList edgeIndirections) {
        this.edgeIndirections = edgeIndirections;
    }

}
