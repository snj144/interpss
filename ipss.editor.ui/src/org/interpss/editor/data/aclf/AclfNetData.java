package org.interpss.editor.data.aclf;

import com.interpss.common.rec.BaseDataBean;

/**
*	AclfNetForm class for storing aclf network data.
*/

public class AclfNetData extends BaseDataBean {
    private boolean hasAdjustment = false;
    public boolean isHasAdjustment() { return this.hasAdjustment; }
    public void setHasAdjustment(boolean b) { this.hasAdjustment = b; }
}