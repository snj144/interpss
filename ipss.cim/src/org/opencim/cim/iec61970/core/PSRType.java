/**
 * <copyright>
 * </copyright>
 *
 * $Id: PSRType.java,v 1.1 2007/03/02 14:01:08 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PSR Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Classifying instances of the same class, e.g. overhead and underground ACLineSegments. This classification mechanism is intended to provide flexibility outside the scope of this standard, i.e. provide customisation that is non standard.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.PSRType#getPowerSystemResource <em>Power System Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getPSRType()
 * @generated
 */
public interface PSRType extends Naming {
	/**
	 * Returns the value of the '<em><b>Power System Resource</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.PowerSystemResource}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.PowerSystemResource#getPSRType <em>PSR Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Power System Resource</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Power System Resource</em>' reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getPSRType_PowerSystemResource()
	 * @see org.opencim.cim.iec61970.core.PowerSystemResource#getPSRType
	 * @generated
	 */
	EList getPowerSystemResource();

} // PSRType