/**
 * <copyright>
 * </copyright>
 *
 * $Id: HydroPump.java,v 1.1 2007/03/02 14:01:07 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.datatype.real.ActivePower;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hydro Pump</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A synchronous motor-driven pump, typically associated with a pumped storage plant
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPump#getPumpDischAtMaxHead <em>Pump Disch At Max Head</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPump#getPumpDischAtMinHead <em>Pump Disch At Min Head</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPump#getPumpPowerAtMaxHead <em>Pump Power At Max Head</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPump#getPumpPowerAtMinHead <em>Pump Power At Min Head</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroPump#getHydroPumpOpSchedule <em>Hydro Pump Op Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPump()
 * @generated
 */
public interface HydroPump extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Pump Disch At Max Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The pumping discharge (m3/sec) under maximum head conditions, usually at full gate
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pump Disch At Max Head</em>' attribute.
	 * @see #setPumpDischAtMaxHead(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPump_PumpDischAtMaxHead()
	 * @generated
	 */
	Float getPumpDischAtMaxHead();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPump#getPumpDischAtMaxHead <em>Pump Disch At Max Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pump Disch At Max Head</em>' attribute.
	 * @see #getPumpDischAtMaxHead()
	 * @generated
	 */
	void setPumpDischAtMaxHead(Float value);

	/**
	 * Returns the value of the '<em><b>Pump Disch At Min Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The pumping discharge (m3/sec) under minimum head conditions, usually at full gate
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pump Disch At Min Head</em>' attribute.
	 * @see #setPumpDischAtMinHead(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPump_PumpDischAtMinHead()
	 * @generated
	 */
	Float getPumpDischAtMinHead();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPump#getPumpDischAtMinHead <em>Pump Disch At Min Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pump Disch At Min Head</em>' attribute.
	 * @see #getPumpDischAtMinHead()
	 * @generated
	 */
	void setPumpDischAtMinHead(Float value);

	/**
	 * Returns the value of the '<em><b>Pump Power At Max Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The pumping power (MW) under maximum head conditions, usually at full gate
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pump Power At Max Head</em>' attribute.
	 * @see #setPumpPowerAtMaxHead(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPump_PumpPowerAtMaxHead()
	 * @generated
	 */
	ActivePower getPumpPowerAtMaxHead();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPump#getPumpPowerAtMaxHead <em>Pump Power At Max Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pump Power At Max Head</em>' attribute.
	 * @see #getPumpPowerAtMaxHead()
	 * @generated
	 */
	void setPumpPowerAtMaxHead(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Pump Power At Min Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The pumping power (MW) under minimum head conditions, usually at full gate.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pump Power At Min Head</em>' attribute.
	 * @see #setPumpPowerAtMinHead(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPump_PumpPowerAtMinHead()
	 * @generated
	 */
	ActivePower getPumpPowerAtMinHead();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPump#getPumpPowerAtMinHead <em>Pump Power At Min Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pump Power At Min Head</em>' attribute.
	 * @see #getPumpPowerAtMinHead()
	 * @generated
	 */
	void setPumpPowerAtMinHead(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Hydro Pump Op Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The hydro pump has a pumping schedule over time, indicating when pumping is to occur.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hydro Pump Op Schedule</em>' containment reference.
	 * @see #setHydroPumpOpSchedule(HydroPumpOpSchedule)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroPump_HydroPumpOpSchedule()
	 * @generated
	 */
	HydroPumpOpSchedule getHydroPumpOpSchedule();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroPump#getHydroPumpOpSchedule <em>Hydro Pump Op Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hydro Pump Op Schedule</em>' containment reference.
	 * @see #getHydroPumpOpSchedule()
	 * @generated
	 */
	void setHydroPumpOpSchedule(HydroPumpOpSchedule value);

} // HydroPump