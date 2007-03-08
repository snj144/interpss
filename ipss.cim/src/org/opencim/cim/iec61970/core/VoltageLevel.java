/**
 * <copyright>
 * </copyright>
 *
 * $Id: VoltageLevel.java,v 1.2 2007/03/04 17:58:09 mzhou Exp $
 */
package org.opencim.cim.iec61970.core;

import org.eclipse.emf.common.util.EList;

import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Voltage Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A collection of equipment at one common system voltage forming a switchgear. The equipment typically consist of breakers, busbars, instrumentation, control, regulationand protection devices as well as assemblies of all these.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.VoltageLevel#getHighVoltageLimit <em>High Voltage Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.VoltageLevel#getLowVoltageLimit <em>Low Voltage Limit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.VoltageLevel#getSubstation <em>Substation</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.VoltageLevel#getBays <em>Bays</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.VoltageLevel#getBaseVoltage <em>Base Voltage</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.core.CorePackage#getVoltageLevel()
 * @model
 * @generated
 */
public interface VoltageLevel extends EquipmentContainer {
	/**
	 * Returns the value of the '<em><b>High Voltage Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The bus bar's high voltage limit in kV
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>High Voltage Limit</em>' attribute.
	 * @see #setHighVoltageLimit(Voltage)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getVoltageLevel_HighVoltageLimit()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getHighVoltageLimit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.VoltageLevel#getHighVoltageLimit <em>High Voltage Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>High Voltage Limit</em>' attribute.
	 * @see #getHighVoltageLimit()
	 * @generated
	 */
	void setHighVoltageLimit(Voltage value);

	/**
	 * Returns the value of the '<em><b>Low Voltage Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The bus bar's low voltage limit in kV
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Low Voltage Limit</em>' attribute.
	 * @see #setLowVoltageLimit(Voltage)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getVoltageLevel_LowVoltageLimit()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getLowVoltageLimit();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.VoltageLevel#getLowVoltageLimit <em>Low Voltage Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Low Voltage Limit</em>' attribute.
	 * @see #getLowVoltageLimit()
	 * @generated
	 */
	void setLowVoltageLimit(Voltage value);

	/**
	 * Returns the value of the '<em><b>Substation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.Substation#getVoltageLevels <em>Voltage Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The association is used in the naming hierarchy.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Substation</em>' container reference.
	 * @see #setSubstation(Substation)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getVoltageLevel_Substation()
	 * @see org.opencim.cim.iec61970.core.Substation#getVoltageLevels
	 * @model opposite="VoltageLevels" required="true"
	 * @generated
	 */
	Substation getSubstation();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.VoltageLevel#getSubstation <em>Substation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Substation</em>' container reference.
	 * @see #getSubstation()
	 * @generated
	 */
	void setSubstation(Substation value);

	/**
	 * Returns the value of the '<em><b>Bays</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.Bay}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.Bay#getVoltageLevel <em>Voltage Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The association is used in the naming hierarchy.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bays</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.core.CorePackage#getVoltageLevel_Bays()
	 * @see org.opencim.cim.iec61970.core.Bay#getVoltageLevel
	 * @model type="org.opencim.cim.iec61970.core.Bay" opposite="VoltageLevel" containment="true"
	 * @generated
	 */
	EList getBays();

	/**
	 * Returns the value of the '<em><b>Base Voltage</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.BaseVoltage#getVoltageLevel <em>Voltage Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Voltage</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Voltage</em>' reference.
	 * @see #setBaseVoltage(BaseVoltage)
	 * @see org.opencim.cim.iec61970.core.CorePackage#getVoltageLevel_BaseVoltage()
	 * @see org.opencim.cim.iec61970.core.BaseVoltage#getVoltageLevel
	 * @model opposite="VoltageLevel" required="true"
	 * @generated
	 */
	BaseVoltage getBaseVoltage();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.core.VoltageLevel#getBaseVoltage <em>Base Voltage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Voltage</em>' reference.
	 * @see #getBaseVoltage()
	 * @generated
	 */
	void setBaseVoltage(BaseVoltage value);

} // VoltageLevel