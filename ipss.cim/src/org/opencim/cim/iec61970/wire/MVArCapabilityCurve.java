/**
 * <copyright>
 * </copyright>
 *
 * $Id: MVArCapabilityCurve.java,v 1.1 2007/03/02 14:01:02 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.CurveSchedule;

import org.opencim.datatype.real.Pressure;
import org.opencim.datatype.real.Temperature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MV Ar Capability Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Reactive power rating envelope versus the synchronous machine's active power, in both the generating and motoring modes. For each MW value there is a corresponding high and low MVAr limit  value. Typically there will be a separate curve for each coolant condition, such as hydrogen pressure.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.MVArCapabilityCurve#getCoolantTemperature <em>Coolant Temperature</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.MVArCapabilityCurve#getHydrogenPressure <em>Hydrogen Pressure</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.MVArCapabilityCurve#getSynchronousMachines <em>Synchronous Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getMVArCapabilityCurve()
 * @model
 * @generated
 */
public interface MVArCapabilityCurve extends CurveSchedule {
	/**
	 * Returns the value of the '<em><b>Coolant Temperature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The machine's coolant temperature in degrees Celsius (e.g., ambient air or stator circulating water)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Coolant Temperature</em>' attribute.
	 * @see #setCoolantTemperature(Temperature)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getMVArCapabilityCurve_CoolantTemperature()
	 * @model dataType="org.opencim.cim.iec61970.domain.Temperature"
	 * @generated
	 */
	Temperature getCoolantTemperature();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.MVArCapabilityCurve#getCoolantTemperature <em>Coolant Temperature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coolant Temperature</em>' attribute.
	 * @see #getCoolantTemperature()
	 * @generated
	 */
	void setCoolantTemperature(Temperature value);

	/**
	 * Returns the value of the '<em><b>Hydrogen Pressure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The hydrogen coolant pressure
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hydrogen Pressure</em>' attribute.
	 * @see #setHydrogenPressure(Pressure)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getMVArCapabilityCurve_HydrogenPressure()
	 * @model dataType="org.opencim.cim.iec61970.domain.Pressure"
	 * @generated
	 */
	Pressure getHydrogenPressure();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.MVArCapabilityCurve#getHydrogenPressure <em>Hydrogen Pressure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hydrogen Pressure</em>' attribute.
	 * @see #getHydrogenPressure()
	 * @generated
	 */
	void setHydrogenPressure(Pressure value);

	/**
	 * Returns the value of the '<em><b>Synchronous Machines</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.SynchronousMachine}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.SynchronousMachine#getMVArCapabilityCurves <em>MV Ar Capability Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synchronous Machines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synchronous Machines</em>' reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getMVArCapabilityCurve_SynchronousMachines()
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine#getMVArCapabilityCurves
	 * @model type="org.opencim.cim.iec61970.wire.SynchronousMachine" opposite="MVArCapabilityCurves" required="true"
	 * @generated
	 */
	EList getSynchronousMachines();

} // MVArCapabilityCurve