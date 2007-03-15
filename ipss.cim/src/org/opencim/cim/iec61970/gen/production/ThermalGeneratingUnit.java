/**
 * <copyright>
 * </copyright>
 *
 * $Id: ThermalGeneratingUnit.java,v 1.1 2007/03/02 14:01:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.eclipse.emf.common.util.EList;

import org.opencim.datatype.real.CostPerHeatUnit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thermal Generating Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A generating unit whose prime mover could be a steam turbine, combustion turbine, or diesel engine.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getOMCost <em>OM Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getEmmissionAccounts <em>Emmission Accounts</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getEmissionCurves <em>Emission Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getFossilFuels <em>Fossil Fuels</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getFuelAllocationSchedules <em>Fuel Allocation Schedules</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getHeatInputCurve <em>Heat Input Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getHeatRateCurve <em>Heat Rate Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getIncrementalHeatRateCurve <em>Incremental Heat Rate Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getShutdownCurve <em>Shutdown Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getStartupModel <em>Startup Model</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMemberOf_CAESPlant <em>Member Of CAES Plant</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMembmerOf_CogenerationPlant <em>Membmer Of Cogeneration Plant</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMemberOf_CombinedCyclePlant <em>Member Of Combined Cycle Plant</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getThermalGeneratingUnit()
 * @generated
 */
public interface ThermalGeneratingUnit extends GeneratingUnit {
	/**
	 * Returns the value of the '<em><b>OM Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Operating and maintenance cost for the thermal unit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>OM Cost</em>' attribute.
	 * @see #setOMCost(CostPerHeatUnit)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getThermalGeneratingUnit_OMCost()
	 * @generated
	 */
	CostPerHeatUnit getOMCost();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getOMCost <em>OM Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>OM Cost</em>' attribute.
	 * @see #getOMCost()
	 * @generated
	 */
	void setOMCost(CostPerHeatUnit value);

	/**
	 * Returns the value of the '<em><b>Emmission Accounts</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.EmissionAccount}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may have one or more emission allowance accounts
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Emmission Accounts</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getThermalGeneratingUnit_EmmissionAccounts()
	 * @generated
	 */
	EList getEmmissionAccounts();

	/**
	 * Returns the value of the '<em><b>Emission Curves</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.EmissionCurve}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may have  one or more emission curves
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Emission Curves</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getThermalGeneratingUnit_EmissionCurves()
	 * @generated
	 */
	EList getEmissionCurves();

	/**
	 * Returns the value of the '<em><b>Fossil Fuels</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.FossilFuel}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.FossilFuel#getThermalGeneratingUnit <em>Thermal Generating Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may have one or more fossil fuels
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fossil Fuels</em>' reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getThermalGeneratingUnit_FossilFuels()
	 * @see org.opencim.cim.iec61970.gen.production.FossilFuel#getThermalGeneratingUnit
	 * @generated
	 */
	EList getFossilFuels();

	/**
	 * Returns the value of the '<em><b>Fuel Allocation Schedules</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may have one or more fuel allocation schedules
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fuel Allocation Schedules</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getThermalGeneratingUnit_FuelAllocationSchedules()
	 * @generated
	 */
	EList getFuelAllocationSchedules();

	/**
	 * Returns the value of the '<em><b>Heat Input Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may have a heat input curve
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Heat Input Curve</em>' containment reference.
	 * @see #setHeatInputCurve(HeatInputCurve)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getThermalGeneratingUnit_HeatInputCurve()
	 * @generated
	 */
	HeatInputCurve getHeatInputCurve();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getHeatInputCurve <em>Heat Input Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heat Input Curve</em>' containment reference.
	 * @see #getHeatInputCurve()
	 * @generated
	 */
	void setHeatInputCurve(HeatInputCurve value);

	/**
	 * Returns the value of the '<em><b>Heat Rate Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may have a heat rate curve
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Heat Rate Curve</em>' containment reference.
	 * @see #setHeatRateCurve(HeatRateCurve)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getThermalGeneratingUnit_HeatRateCurve()
	 * @generated
	 */
	HeatRateCurve getHeatRateCurve();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getHeatRateCurve <em>Heat Rate Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heat Rate Curve</em>' containment reference.
	 * @see #getHeatRateCurve()
	 * @generated
	 */
	void setHeatRateCurve(HeatRateCurve value);

	/**
	 * Returns the value of the '<em><b>Incremental Heat Rate Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may have an incremental heat rate curve
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Incremental Heat Rate Curve</em>' containment reference.
	 * @see #setIncrementalHeatRateCurve(IncrementalHeatRateCurve)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getThermalGeneratingUnit_IncrementalHeatRateCurve()
	 * @generated
	 */
	IncrementalHeatRateCurve getIncrementalHeatRateCurve();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getIncrementalHeatRateCurve <em>Incremental Heat Rate Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incremental Heat Rate Curve</em>' containment reference.
	 * @see #getIncrementalHeatRateCurve()
	 * @generated
	 */
	void setIncrementalHeatRateCurve(IncrementalHeatRateCurve value);

	/**
	 * Returns the value of the '<em><b>Shutdown Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may have a shutdown curve
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shutdown Curve</em>' containment reference.
	 * @see #setShutdownCurve(ShutdownCurve)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getThermalGeneratingUnit_ShutdownCurve()
	 * @generated
	 */
	ShutdownCurve getShutdownCurve();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getShutdownCurve <em>Shutdown Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shutdown Curve</em>' containment reference.
	 * @see #getShutdownCurve()
	 * @generated
	 */
	void setShutdownCurve(ShutdownCurve value);

	/**
	 * Returns the value of the '<em><b>Startup Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may have a startup model
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Startup Model</em>' containment reference.
	 * @see #setStartupModel(StartupModel)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getThermalGeneratingUnit_StartupModel()
	 * @generated
	 */
	StartupModel getStartupModel();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getStartupModel <em>Startup Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Model</em>' containment reference.
	 * @see #getStartupModel()
	 * @generated
	 */
	void setStartupModel(StartupModel value);

	/**
	 * Returns the value of the '<em><b>Member Of CAES Plant</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.CAESPlant#getContain_ThermalGeneratingUnit <em>Contain Thermal Generating Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may be a member of a compressed air energy storage plant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Member Of CAES Plant</em>' reference.
	 * @see #setMemberOf_CAESPlant(CAESPlant)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getThermalGeneratingUnit_MemberOf_CAESPlant()
	 * @see org.opencim.cim.iec61970.gen.production.CAESPlant#getContain_ThermalGeneratingUnit
	 * @generated
	 */
	CAESPlant getMemberOf_CAESPlant();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMemberOf_CAESPlant <em>Member Of CAES Plant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member Of CAES Plant</em>' reference.
	 * @see #getMemberOf_CAESPlant()
	 * @generated
	 */
	void setMemberOf_CAESPlant(CAESPlant value);

	/**
	 * Returns the value of the '<em><b>Membmer Of Cogeneration Plant</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.CogenerationPlant#getContain_ThermalGeneratingUnits <em>Contain Thermal Generating Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may be a member of a cogeneration plant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Membmer Of Cogeneration Plant</em>' reference.
	 * @see #setMembmerOf_CogenerationPlant(CogenerationPlant)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getThermalGeneratingUnit_MembmerOf_CogenerationPlant()
	 * @see org.opencim.cim.iec61970.gen.production.CogenerationPlant#getContain_ThermalGeneratingUnits
	 * @generated
	 */
	CogenerationPlant getMembmerOf_CogenerationPlant();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMembmerOf_CogenerationPlant <em>Membmer Of Cogeneration Plant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Membmer Of Cogeneration Plant</em>' reference.
	 * @see #getMembmerOf_CogenerationPlant()
	 * @generated
	 */
	void setMembmerOf_CogenerationPlant(CogenerationPlant value);

	/**
	 * Returns the value of the '<em><b>Member Of Combined Cycle Plant</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.CombinedCyclePlant#getContain_ThermalGeneratingUnits <em>Contain Thermal Generating Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A thermal generating unit may be a member of a combined cycle plant
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Member Of Combined Cycle Plant</em>' reference.
	 * @see #setMemberOf_CombinedCyclePlant(CombinedCyclePlant)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getThermalGeneratingUnit_MemberOf_CombinedCyclePlant()
	 * @see org.opencim.cim.iec61970.gen.production.CombinedCyclePlant#getContain_ThermalGeneratingUnits
	 * @generated
	 */
	CombinedCyclePlant getMemberOf_CombinedCyclePlant();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.ThermalGeneratingUnit#getMemberOf_CombinedCyclePlant <em>Member Of Combined Cycle Plant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member Of Combined Cycle Plant</em>' reference.
	 * @see #getMemberOf_CombinedCyclePlant()
	 * @generated
	 */
	void setMemberOf_CombinedCyclePlant(CombinedCyclePlant value);

} // ThermalGeneratingUnit