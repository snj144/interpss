/**
 * <copyright>
 * </copyright>
 *
 * $Id: HydroGeneratingUnit.java,v 1.1 2007/03/02 14:01:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hydro Generating Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A generating unit whose prime mover is a hydraulic turbine (e.g., Francis, Pelton, Kaplan)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit#getHydroUnitWaterCost <em>Hydro Unit Water Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit#getHydroGeneratingEfficiencyCurves <em>Hydro Generating Efficiency Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit#getPenstockLossCurve <em>Penstock Loss Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit#getTailbayLossCurve <em>Tailbay Loss Curve</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroGeneratingUnit()
 * @model
 * @generated
 */
public interface HydroGeneratingUnit extends GeneratingUnit {
	/**
	 * Returns the value of the '<em><b>Hydro Unit Water Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The equivalent cost of water that drives the hydro turbine, expressed as (dollars/hour) per (cubic meters/second)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hydro Unit Water Cost</em>' attribute.
	 * @see #setHydroUnitWaterCost(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroGeneratingUnit_HydroUnitWaterCost()
	 * @model
	 * @generated
	 */
	Float getHydroUnitWaterCost();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit#getHydroUnitWaterCost <em>Hydro Unit Water Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hydro Unit Water Cost</em>' attribute.
	 * @see #getHydroUnitWaterCost()
	 * @generated
	 */
	void setHydroUnitWaterCost(Float value);

	/**
	 * Returns the value of the '<em><b>Hydro Generating Efficiency Curves</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.HydroGeneratingEfficiencyCurve}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A hydro generating unit has an efficiency curve
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hydro Generating Efficiency Curves</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroGeneratingUnit_HydroGeneratingEfficiencyCurves()
	 * @model type="org.opencim.cim.iec61970.gen.production.HydroGeneratingEfficiencyCurve" containment="true"
	 * @generated
	 */
	EList getHydroGeneratingEfficiencyCurves();

	/**
	 * Returns the value of the '<em><b>Penstock Loss Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A hydro generating unit has a penstock loss curve
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Penstock Loss Curve</em>' containment reference.
	 * @see #setPenstockLossCurve(PenstockLossCurve)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroGeneratingUnit_PenstockLossCurve()
	 * @model containment="true"
	 * @generated
	 */
	PenstockLossCurve getPenstockLossCurve();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.HydroGeneratingUnit#getPenstockLossCurve <em>Penstock Loss Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Penstock Loss Curve</em>' containment reference.
	 * @see #getPenstockLossCurve()
	 * @generated
	 */
	void setPenstockLossCurve(PenstockLossCurve value);

	/**
	 * Returns the value of the '<em><b>Tailbay Loss Curve</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.TailbayLossCurve}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A hydro generating unit has a tailbay loss curve
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tailbay Loss Curve</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getHydroGeneratingUnit_TailbayLossCurve()
	 * @model type="org.opencim.cim.iec61970.gen.production.TailbayLossCurve" containment="true"
	 * @generated
	 */
	EList getTailbayLossCurve();

} // HydroGeneratingUnit