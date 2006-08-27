package org.interpss.editor.data.acsc;

import org.interpss.editor.data.aclf.AclfNetData;

/**
*	AcscNetForm class for storing acsc network data.
*/

public class AcscNetData extends AclfNetData {
    private boolean hasAclfData = false;

    public boolean isHasAclfData() { return this.hasAclfData; }
    public void setHasAclfData(boolean hasAclfData) { this.hasAclfData = hasAclfData; }
}