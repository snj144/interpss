package org.interpss.editor.graphcellsbase.cellviews;

import java.util.ArrayList;

import org.interpss.editor.jgraph.cells.AnnotateLabelCell;
import org.interpss.editor.jgraph.cells.BranchEdge;
import org.interpss.editor.jgraph.cells.BusCell;
import org.interpss.editor.jgraph.cells.LabelCell;
import org.interpss.editor.jgraph.cells.SimpleLabelCell;
import org.jgraph.graph.DefaultCellViewFactory;
import org.jgraph.graph.EdgeView;
import org.jgraph.graph.VertexView;




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
		ArrayList vect = new ArrayList();
		vect.add(new ViewIndirection(LabelCell.class,JGraphLabelView.class));
		vect.add(new ViewIndirection(AnnotateLabelCell.class,JGraphLabelView.class));
		vect.add(new ViewIndirection(BusCell.class,JGraphBusView.class));
		vect.add(new ViewIndirection(SimpleLabelCell.class,JGraphMultilineView.class));
		setViewIndirections(vect);
		
		
		ArrayList evect = new ArrayList();
		vect.add(new ViewIndirection(BranchEdge.class,JGraphBranchEdgeView.class));
		setEdgeIndirections(evect);
    }

    public static class ViewIndirection {
        private Class cellClass;

        private Class viewClass;

        
        public ViewIndirection(Class cellClass, Class viewClass) {
			this.cellClass = cellClass;
			this.viewClass = viewClass;
		}

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
