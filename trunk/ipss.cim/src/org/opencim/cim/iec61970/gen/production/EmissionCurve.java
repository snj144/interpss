/**
 * <copyright>
 * </copyright>
 *
 * $Id: EmissionCurve.java,v 1.1 2007/03/02 14:01:07 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.opencim.cim.iec61970.core.CurveSchedule;

import org.opencim.cim.iec61970.domain.EmissionType;

import org.opencim.datatype.real.Emission;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Emission Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Relationship between the unit's emission rate in units of mass per hour (Y-axis) and output in MW (X-axis) for a given type of emission. This curve applies when only one type of fuel is being burned.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.EmissionCurve#getEmissionContent <em>Emission Content</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.EmissionCurve#getEmissionType <em>Emission Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.EmissionCurve#getNetGrossMWFlag <em>Net Gross MW Flag</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getEmissionCurve()
 * @generated
 */
public interface EmissionCurve extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Emission Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The emission content per quantity of fuel burned
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Emission Content</em>' attribute.
	 * @see #setEmissionContent(Emission)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getEmissionCurve_EmissionContent()
	 * @generated
	 */
	Emission getEmissionContent();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.EmissionCurve#getEmissionContent <em>Emission Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Emission Content</em>' attribute.
	 * @see #getEmissionContent()
	 * @generated
	 */
	void setEmissionContent(Emission value);

	/**
	 * Returns the value of the '<em><b>Emission Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.EmissionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of emission, which also gives the production rate measurement unit. The y1AxisUnits of the curve contains the unit of measure (e.g. kg) and the emissionType is the type of emission (e.g. sulfer dioxide).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Emission Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.EmissionType
	 * @see #setEmissionType(EmissionType)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getEmissionCurve_EmissionType()
	 * @generated
	 */
	EmissionType getEmissionType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.EmissionCurve#getEmissionType <em>Emission Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Emission Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.EmissionType
	 * @see #getEmissionType()
	 * @generated
	 */
	void setEmissionType(EmissionType value);

	/**
	 * Returns the value of the '<em><b>Net Gross MW Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Flag is set to YES when output is expressed in net MW
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Net Gross MW Flag</em>' attribute.
	 * @see #setNetGrossMWFlag(Boolean)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getEmissionCurve_NetGrossMWFlag()
	 * @generated
	 */
	Boolean getNetGrossMWFlag();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.EmissionCurve#getNetGrossMWFlag <em>Net Gross MW Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net Gross MW Flag</em>' attribute.
	 * @see #getNetGrossMWFlag()
	 * @generated
	 */
	void setNetGrossMWFlag(Boolean value);

} // EmissionCurve