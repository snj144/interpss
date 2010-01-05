/**
 * <copyright>
 * </copyright>
 *
 * $Id: EmissionAccount.java,v 1.1 2007/03/02 14:01:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.opencim.cim.iec61970.domain.EmissionType;
import org.opencim.cim.iec61970.domain.EmissionValueSource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Emission Account</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Accounts for tracking emissions usage and credits for thermal generating units. A unit may have zero or more emission accounts, and will typically have one for tracking usage and one for tracking credits.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.EmissionAccount#getEmissionType <em>Emission Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.EmissionAccount#getEmissionValueSource <em>Emission Value Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getEmissionAccount()
 * @generated
 */
public interface EmissionAccount extends AccountBalance {
	/**
	 * Returns the value of the '<em><b>Emission Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.EmissionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of emission, for example sulfur dioxide (SO2). The y1AxisUnits of the curve contains the unit of measure (e.g. kg) and the emissionType is the type of emission (e.g. sulfer dioxide).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Emission Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.EmissionType
	 * @see #setEmissionType(EmissionType)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getEmissionAccount_EmissionType()
	 * @generated
	 */
	EmissionType getEmissionType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.EmissionAccount#getEmissionType <em>Emission Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Emission Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.EmissionType
	 * @see #getEmissionType()
	 * @generated
	 */
	void setEmissionType(EmissionType value);

	/**
	 * Returns the value of the '<em><b>Emission Value Source</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.EmissionValueSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source of the emission value: Measured or Calculated
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Emission Value Source</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.EmissionValueSource
	 * @see #setEmissionValueSource(EmissionValueSource)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getEmissionAccount_EmissionValueSource()
	 * @generated
	 */
	EmissionValueSource getEmissionValueSource();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.EmissionAccount#getEmissionValueSource <em>Emission Value Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Emission Value Source</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.EmissionValueSource
	 * @see #getEmissionValueSource()
	 * @generated
	 */
	void setEmissionValueSource(EmissionValueSource value);

} // EmissionAccount