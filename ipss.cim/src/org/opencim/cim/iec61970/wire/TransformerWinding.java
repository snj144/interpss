/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransformerWinding.java,v 1.2 2007/03/08 00:05:30 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.ConductingEquipment;

import org.opencim.cim.iec61970.domain.WindingConnection;
import org.opencim.cim.iec61970.domain.WindingType;

import org.opencim.datatype.real.ApparentPower;
import org.opencim.datatype.real.Conductance;
import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.Susceptance;
import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformer Winding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A winding is associated with each defined terminal of a transformer (or phase shifter).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getB <em>B</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getInsulationKV <em>Insulation KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getConnectionType <em>Connection Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getEmergencyMVA <em>Emergency MVA</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getG <em>G</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getGrounded <em>Grounded</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getR <em>R</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getR0 <em>R0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getRatedKV <em>Rated KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getRatedMVA <em>Rated MVA</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getRground <em>Rground</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getShortTermMVA <em>Short Term MVA</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getWindingType <em>Winding Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getX <em>X</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getX0 <em>X0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getXground <em>Xground</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getPowerTransformer <em>Power Transformer</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getTapChangers <em>Tap Changers</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getFrom_WindingTests <em>From Winding Tests</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.TransformerWinding#getTo_WindingTest <em>To Winding Test</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding()
 * @generated
 */
public interface TransformerWinding extends ConductingEquipment {
	/**
	 * Returns the value of the '<em><b>B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Magnetizing branch susceptance (B mag).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>B</em>' attribute.
	 * @see #setB(Susceptance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_B()
	 * @generated
	 */
	Susceptance getB();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getB <em>B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>B</em>' attribute.
	 * @see #getB()
	 * @generated
	 */
	void setB(Susceptance value);

	/**
	 * Returns the value of the '<em><b>Insulation KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Basic insulation level voltage rating
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Insulation KV</em>' attribute.
	 * @see #setInsulationKV(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_InsulationKV()
	 * @generated
	 */
	Voltage getInsulationKV();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getInsulationKV <em>Insulation KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Insulation KV</em>' attribute.
	 * @see #getInsulationKV()
	 * @generated
	 */
	void setInsulationKV(Voltage value);

	/**
	 * Returns the value of the '<em><b>Connection Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.WindingConnection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of connection of the winding (e.g. Delta, Wye, zigzag)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connection Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.WindingConnection
	 * @see #setConnectionType(WindingConnection)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_ConnectionType()
	 * @generated
	 */
	WindingConnection getConnectionType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getConnectionType <em>Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.WindingConnection
	 * @see #getConnectionType()
	 * @generated
	 */
	void setConnectionType(WindingConnection value);

	/**
	 * Returns the value of the '<em><b>Emergency MVA</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MVA that the winding can carry  under emergency conditions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Emergency MVA</em>' attribute.
	 * @see #setEmergencyMVA(ApparentPower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_EmergencyMVA()
	 * @generated
	 */
	ApparentPower getEmergencyMVA();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getEmergencyMVA <em>Emergency MVA</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Emergency MVA</em>' attribute.
	 * @see #getEmergencyMVA()
	 * @generated
	 */
	void setEmergencyMVA(ApparentPower value);

	/**
	 * Returns the value of the '<em><b>G</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Magnetizing branch conductance (G mag).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>G</em>' attribute.
	 * @see #setG(Conductance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_G()
	 * @generated
	 */
	Conductance getG();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getG <em>G</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>G</em>' attribute.
	 * @see #getG()
	 * @generated
	 */
	void setG(Conductance value);

	/**
	 * Returns the value of the '<em><b>Grounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Set if the winding is grounded.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Grounded</em>' attribute.
	 * @see #setGrounded(Boolean)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_Grounded()
	 * @generated
	 */
	Boolean getGrounded();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getGrounded <em>Grounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grounded</em>' attribute.
	 * @see #getGrounded()
	 * @generated
	 */
	void setGrounded(Boolean value);

	/**
	 * Returns the value of the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Positive sequence series resistance of the winding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>R</em>' attribute.
	 * @see #setR(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_R()
	 * @generated
	 */
	Resistance getR();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getR <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>R</em>' attribute.
	 * @see #getR()
	 * @generated
	 */
	void setR(Resistance value);

	/**
	 * Returns the value of the '<em><b>R0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Zero sequence series resistance of the winding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>R0</em>' attribute.
	 * @see #setR0(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_R0()
	 * @generated
	 */
	Resistance getR0();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getR0 <em>R0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>R0</em>' attribute.
	 * @see #getR0()
	 * @generated
	 */
	void setR0(Resistance value);

	/**
	 * Returns the value of the '<em><b>Rated KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The rated voltage (phase-to-ground) of the winding, usually the same as the neutral voltage.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rated KV</em>' attribute.
	 * @see #setRatedKV(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_RatedKV()
	 * @generated
	 */
	Voltage getRatedKV();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getRatedKV <em>Rated KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rated KV</em>' attribute.
	 * @see #getRatedKV()
	 * @generated
	 */
	void setRatedKV(Voltage value);

	/**
	 * Returns the value of the '<em><b>Rated MVA</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The normal MVA rating for the winding
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rated MVA</em>' attribute.
	 * @see #setRatedMVA(ApparentPower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_RatedMVA()
	 * @generated
	 */
	ApparentPower getRatedMVA();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getRatedMVA <em>Rated MVA</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rated MVA</em>' attribute.
	 * @see #getRatedMVA()
	 * @generated
	 */
	void setRatedMVA(ApparentPower value);

	/**
	 * Returns the value of the '<em><b>Rground</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Ground resistance path through connected grounding transformer.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rground</em>' attribute.
	 * @see #setRground(Resistance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_Rground()
	 * @generated
	 */
	Resistance getRground();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getRground <em>Rground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rground</em>' attribute.
	 * @see #getRground()
	 * @generated
	 */
	void setRground(Resistance value);

	/**
	 * Returns the value of the '<em><b>Short Term MVA</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * MVA that the winding can carry for a short period of time.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Short Term MVA</em>' attribute.
	 * @see #setShortTermMVA(ApparentPower)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_ShortTermMVA()
	 * @generated
	 */
	ApparentPower getShortTermMVA();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getShortTermMVA <em>Short Term MVA</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Short Term MVA</em>' attribute.
	 * @see #getShortTermMVA()
	 * @generated
	 */
	void setShortTermMVA(ApparentPower value);

	/**
	 * Returns the value of the '<em><b>Winding Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.WindingType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of winding, i.e., Primary, Secondary, Tertiary, Quaternary.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Winding Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.WindingType
	 * @see #setWindingType(WindingType)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_WindingType()
	 * @generated
	 */
	WindingType getWindingType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getWindingType <em>Winding Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Winding Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.WindingType
	 * @see #getWindingType()
	 * @generated
	 */
	void setWindingType(WindingType value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Positive sequence series reactance of the winding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_X()
	 * @generated
	 */
	Reactance getX();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(Reactance value);

	/**
	 * Returns the value of the '<em><b>X0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Zero sequence series reactance of the winding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>X0</em>' attribute.
	 * @see #setX0(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_X0()
	 * @generated
	 */
	Reactance getX0();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getX0 <em>X0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X0</em>' attribute.
	 * @see #getX0()
	 * @generated
	 */
	void setX0(Reactance value);

	/**
	 * Returns the value of the '<em><b>Xground</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Ground reactance path through connected grounding transformer.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Xground</em>' attribute.
	 * @see #setXground(Reactance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_Xground()
	 * @generated
	 */
	Reactance getXground();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getXground <em>Xground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xground</em>' attribute.
	 * @see #getXground()
	 * @generated
	 */
	void setXground(Reactance value);

	/**
	 * Returns the value of the '<em><b>Power Transformer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getTransformerWindings <em>Transformer Windings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A transformer has windings
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Power Transformer</em>' reference.
	 * @see #setPowerTransformer(PowerTransformer)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_PowerTransformer()
	 * @see org.opencim.cim.iec61970.wire.PowerTransformer#getTransformerWindings
	 * @generated
	 */
	PowerTransformer getPowerTransformer();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getPowerTransformer <em>Power Transformer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Power Transformer</em>' reference.
	 * @see #getPowerTransformer()
	 * @generated
	 */
	void setPowerTransformer(PowerTransformer value);

	/**
	 * Returns the value of the '<em><b>Tap Changers</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.TapChanger}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A transformer winding may have tap changers, separately for voltage and phase angle
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tap Changers</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_TapChangers()
	 * @generated
	 */
	EList getTapChangers();

	/**
	 * Returns the value of the '<em><b>From Winding Tests</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.WindingTest}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.WindingTest#getFrom_TransformerWinding <em>From Transformer Winding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The winding from which the test was conducted
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>From Winding Tests</em>' reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_From_WindingTests()
	 * @see org.opencim.cim.iec61970.wire.WindingTest#getFrom_TransformerWinding
	 * @generated
	 */
	EList getFrom_WindingTests();

	/**
	 * Returns the value of the '<em><b>To Winding Test</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.WindingTest#getTo_TransformeWindings <em>To Transforme Windings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The winding to which the test was conducted
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>To Winding Test</em>' reference.
	 * @see #setTo_WindingTest(WindingTest)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getTransformerWinding_To_WindingTest()
	 * @see org.opencim.cim.iec61970.wire.WindingTest#getTo_TransformeWindings
	 * @generated
	 */
	WindingTest getTo_WindingTest();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getTo_WindingTest <em>To Winding Test</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Winding Test</em>' reference.
	 * @see #getTo_WindingTest()
	 * @generated
	 */
	void setTo_WindingTest(WindingTest value);

} // TransformerWinding