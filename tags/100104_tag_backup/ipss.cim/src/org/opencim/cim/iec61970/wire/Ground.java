/**
 * <copyright>
 * </copyright>
 *
 * $Id: Ground.java,v 1.1 2007/03/02 14:01:02 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.opencim.cim.iec61970.core.ConductingEquipment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ground</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A common point for connecting grounded conducting equipment such as shunt capacitors. The power system model can have more than one ground. The typeName indicates the type of ground, e.g., mesh, earth rod. It is recommended to use GroundDisconnector instead of Ground class when applying CIM. In case of grounding a shunt compensator use Compensator of type SHUNT.
 * <!-- end-model-doc -->
 *
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getGround()
 * @generated
 */
public interface Ground extends ConductingEquipment {
} // Ground