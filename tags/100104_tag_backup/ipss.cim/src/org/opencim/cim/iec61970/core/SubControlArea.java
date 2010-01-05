/**
 * <copyright>
 * </copyright>
 *
 * $Id: SubControlArea.java,v 1.2 2007/03/04 17:58:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Control Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An area defined for the purpose of tracking interchange with surrounding areas via tie points; may or may not serve as a control area.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.SubControlArea#getSubstations <em>Substations</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.SubControlArea#getGeneratingUnits <em>Generating Units</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getSubControlArea()
 * @generated
 */
public interface SubControlArea extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Substations</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.Substation}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.Substation#getSubControlArea <em>Sub Control Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A SubControlArea may contain one or more Substations.
	 * The association is used in the naming hierarchy.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Substations</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getSubControlArea_Substations()
	 * @see org.opencim.cim.iec61970.core.Substation#getSubControlArea
	 * @generated
	 */
	EList getSubstations();

	/**
	 * Returns the value of the '<em><b>Generating Units</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.GeneratingUnit}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSubControlArea <em>Sub Control Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A GeneratingUnit injects energy into a SubControlArea.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Generating Units</em>' reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getSubControlArea_GeneratingUnits()
	 * @see org.opencim.cim.iec61970.gen.production.GeneratingUnit#getSubControlArea
	 * @generated
	 */
	EList getGeneratingUnits();

} // SubControlArea