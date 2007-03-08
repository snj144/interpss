/**
 * <copyright>
 * </copyright>
 *
 * $Id: CombinedCyclePlant.java,v 1.1 2007/03/02 14:01:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.datatype.real.ActivePower;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Combined Cycle Plant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A set of combustion turbines and steam turbines where the exhaust heat from the combustion turbines is recovered to make steam for the steam turbines, resulting in greater overall plant efficiency
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.CombinedCyclePlant#getCombCyclePlantRating <em>Comb Cycle Plant Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.CombinedCyclePlant#getContain_ThermalGeneratingUnits <em>Contain Thermal Generating Units</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCombinedCyclePlant()
 * @model
 * @generated
 */
public interface CombinedCyclePlant extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Comb Cycle Plant Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The combined cycle plant's output rating, in MW
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Comb Cycle Plant Rating</em>' attribute.
	 * @see #setCombCyclePlantRating(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCombinedCyclePlant_CombCyclePlantRating()
	 * @model dataType="org.opencim.cim.iec61970.domain.ActivePower"
	 * @generated
	 */
	ActivePower getCombCyclePlantRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.CombinedCyclePlant#getCombCyclePlantRating <em>Comb Cycle Plant Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comb Cycle Plant Rating</em>' attribute.
	 * @see #getCombCyclePlantRating()
	 * @generated
	 */
	void setCombCyclePlantRating(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Contain Thermal Generating Units</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMemberOf_CombinedCyclePlant <em>Member Of Combined Cycle Plant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may be a member of a combined cycle plant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Contain Thermal Generating Units</em>' reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getCombinedCyclePlant_Contain_ThermalGeneratingUnits()
	 * @see org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMemberOf_CombinedCyclePlant
	 * @model type="org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit" opposite="MemberOf_CombinedCyclePlant"
	 * @generated
	 */
	EList getContain_ThermalGeneratingUnits();

} // CombinedCyclePlant