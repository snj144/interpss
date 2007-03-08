/**
 * <copyright>
 * </copyright>
 *
 * $Id: PowerTransformer.java,v 1.3 2007/03/08 00:05:30 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.Equipment;

import org.opencim.cim.iec61970.domain.TransformerCoolingType;
import org.opencim.cim.iec61970.domain.TransformerType;

import org.opencim.datatype.real.PerCent;
import org.opencim.datatype.real.Voltage;

import org.opencim.datatype.string.PhaseCode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power Transformer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An electrical device consisting of  two or more coupled windings, with or without a magnetic core, for introducing mutual coupling between electric circuits. Transformers can be used to control voltage and phase shift (MW flow). The typeName attribute indicates type of transformer.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.PowerTransformer#getBmagSat <em>Bmag Sat</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.PowerTransformer#getMagBaseKV <em>Mag Base KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.PowerTransformer#getMagSatFlux <em>Mag Sat Flux</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.PowerTransformer#getPhases <em>Phases</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.PowerTransformer#getTransfCoolingType <em>Transf Cooling Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.PowerTransformer#getTransformerType <em>Transformer Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.PowerTransformer#getHeatExchanger <em>Heat Exchanger</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.PowerTransformer#getTransformerWindings <em>Transformer Windings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getPowerTransformer()
 * @model
 * @generated
 */
public interface PowerTransformer extends Equipment {
	/**
	 * Returns the value of the '<em><b>Bmag Sat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Core shunt magnetizing susceptance in the saturation region, in per cent.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bmag Sat</em>' attribute.
	 * @see #setBmagSat(PerCent)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getPowerTransformer_BmagSat()
	 * @model dataType="org.opencim.cim.iec61970.domain.PerCent"
	 * @generated
	 */
	PerCent getBmagSat();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getBmagSat <em>Bmag Sat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bmag Sat</em>' attribute.
	 * @see #getBmagSat()
	 * @generated
	 */
	void setBmagSat(PerCent value);

	/**
	 * Returns the value of the '<em><b>Mag Base KV</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The reference voltage at which the magnetizing saturation measurements were made
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mag Base KV</em>' attribute.
	 * @see #setMagBaseKV(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getPowerTransformer_MagBaseKV()
	 * @model dataType="org.opencim.cim.iec61970.domain.Voltage"
	 * @generated
	 */
	Voltage getMagBaseKV();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getMagBaseKV <em>Mag Base KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mag Base KV</em>' attribute.
	 * @see #getMagBaseKV()
	 * @generated
	 */
	void setMagBaseKV(Voltage value);

	/**
	 * Returns the value of the '<em><b>Mag Sat Flux</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Core magnetizing saturation curve knee flux level.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mag Sat Flux</em>' attribute.
	 * @see #setMagSatFlux(PerCent)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getPowerTransformer_MagSatFlux()
	 * @model dataType="org.opencim.cim.iec61970.domain.PerCent"
	 * @generated
	 */
	PerCent getMagSatFlux();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getMagSatFlux <em>Mag Sat Flux</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mag Sat Flux</em>' attribute.
	 * @see #getMagSatFlux()
	 * @generated
	 */
	void setMagSatFlux(PerCent value);

	/**
	 * Returns the value of the '<em><b>Phases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Describes the phases carried by a power transformer. Possible values { ABCN , ABC, ABN, ACN, BCN, AB, AC, BC, AN, BN, CN, A, B, C, N }.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Phases</em>' attribute.
	 * @see #setPhases(PhaseCode)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getPowerTransformer_Phases()
	 * @model dataType="org.opencim.cim.iec61970.domain.PhaseCode"
	 * @generated
	 */
	PhaseCode getPhases();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getPhases <em>Phases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phases</em>' attribute.
	 * @see #getPhases()
	 * @generated
	 */
	void setPhases(PhaseCode value);

	/**
	 * Returns the value of the '<em><b>Transf Cooling Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.TransformerCoolingType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Type of transformer cooling
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Transf Cooling Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.TransformerCoolingType
	 * @see #setTransfCoolingType(TransformerCoolingType)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getPowerTransformer_TransfCoolingType()
	 * @model
	 * @generated
	 */
	TransformerCoolingType getTransfCoolingType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getTransfCoolingType <em>Transf Cooling Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transf Cooling Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.TransformerCoolingType
	 * @see #getTransfCoolingType()
	 * @generated
	 */
	void setTransfCoolingType(TransformerCoolingType value);

	/**
	 * Returns the value of the '<em><b>Transformer Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.TransformerType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformer Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformer Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.TransformerType
	 * @see #setTransformerType(TransformerType)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getPowerTransformer_TransformerType()
	 * @model
	 * @generated
	 */
	TransformerType getTransformerType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getTransformerType <em>Transformer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformer Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.TransformerType
	 * @see #getTransformerType()
	 * @generated
	 */
	void setTransformerType(TransformerType value);

	/**
	 * Returns the value of the '<em><b>Heat Exchanger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A transformer may have a heat exchanger
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Heat Exchanger</em>' containment reference.
	 * @see #setHeatExchanger(HeatExchanger)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getPowerTransformer_HeatExchanger()
	 * @model containment="true"
	 * @generated
	 */
	HeatExchanger getHeatExchanger();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.PowerTransformer#getHeatExchanger <em>Heat Exchanger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heat Exchanger</em>' containment reference.
	 * @see #getHeatExchanger()
	 * @generated
	 */
	void setHeatExchanger(HeatExchanger value);

	/**
	 * Returns the value of the '<em><b>Transformer Windings</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.TransformerWinding}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getPowerTransformer <em>Power Transformer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A transformer has windings
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Transformer Windings</em>' reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getPowerTransformer_TransformerWindings()
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getPowerTransformer
	 * @model type="org.opencim.cim.iec61970.wire.TransformerWinding" opposite="PowerTransformer" required="true"
	 * @generated
	 */
	EList getTransformerWindings();

} // PowerTransformer