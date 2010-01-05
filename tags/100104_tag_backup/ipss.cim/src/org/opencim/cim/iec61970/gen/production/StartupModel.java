/**
 * <copyright>
 * </copyright>
 *
 * $Id: StartupModel.java,v 1.1 2007/03/02 14:01:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import java.util.Date;

import org.opencim.cim.iec61970.core.Naming;

import org.opencim.datatype.integer.Priority;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.CostPerEnergyUnit;
import org.opencim.datatype.real.CostPerHour;
import org.opencim.datatype.real.HeatPerHour;
import org.opencim.datatype.real.Hours;
import org.opencim.datatype.real.Money;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Startup Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Unit start up characteristics depending on how long the unit has been off line
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartupModel#getFixedMaintCost <em>Fixed Maint Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartupModel#getHotStandbyHeat <em>Hot Standby Heat</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartupModel#getIncrementalMaintCost <em>Incremental Maint Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartupModel#getMinimumDownTime <em>Minimum Down Time</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartupModel#getMinimumRunTime <em>Minimum Run Time</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartupModel#getRiskFactorCost <em>Risk Factor Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartupCost <em>Startup Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartupDate <em>Startup Date</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartupPriority <em>Startup Priority</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStbyAuxPowerMW <em>Stby Aux Power MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartIgnFuelCurve <em>Start Ign Fuel Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartMainFuelCurve <em>Start Main Fuel Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartRampCurve <em>Start Ramp Curve</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartupModel()
 * @generated
 */
public interface StartupModel extends Naming {
	/**
	 * Returns the value of the '<em><b>Fixed Maint Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fixed Maintenance Cost
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fixed Maint Cost</em>' attribute.
	 * @see #setFixedMaintCost(CostPerHour)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartupModel_FixedMaintCost()
	 * @generated
	 */
	CostPerHour getFixedMaintCost();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getFixedMaintCost <em>Fixed Maint Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed Maint Cost</em>' attribute.
	 * @see #getFixedMaintCost()
	 * @generated
	 */
	void setFixedMaintCost(CostPerHour value);

	/**
	 * Returns the value of the '<em><b>Hot Standby Heat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The amount of heat input per hour required for hot standby operation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hot Standby Heat</em>' attribute.
	 * @see #setHotStandbyHeat(HeatPerHour)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartupModel_HotStandbyHeat()
	 * @generated
	 */
	HeatPerHour getHotStandbyHeat();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getHotStandbyHeat <em>Hot Standby Heat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hot Standby Heat</em>' attribute.
	 * @see #getHotStandbyHeat()
	 * @generated
	 */
	void setHotStandbyHeat(HeatPerHour value);

	/**
	 * Returns the value of the '<em><b>Incremental Maint Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Incremental Maintenance Cost
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Incremental Maint Cost</em>' attribute.
	 * @see #setIncrementalMaintCost(CostPerEnergyUnit)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartupModel_IncrementalMaintCost()
	 * @generated
	 */
	CostPerEnergyUnit getIncrementalMaintCost();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getIncrementalMaintCost <em>Incremental Maint Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incremental Maint Cost</em>' attribute.
	 * @see #getIncrementalMaintCost()
	 * @generated
	 */
	void setIncrementalMaintCost(CostPerEnergyUnit value);

	/**
	 * Returns the value of the '<em><b>Minimum Down Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum number of hours the unit must be down before restart
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum Down Time</em>' attribute.
	 * @see #setMinimumDownTime(Hours)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartupModel_MinimumDownTime()
	 * @generated
	 */
	Hours getMinimumDownTime();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getMinimumDownTime <em>Minimum Down Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Down Time</em>' attribute.
	 * @see #getMinimumDownTime()
	 * @generated
	 */
	void setMinimumDownTime(Hours value);

	/**
	 * Returns the value of the '<em><b>Minimum Run Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum number of hours the unit must be operating before being allowed to shut down
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum Run Time</em>' attribute.
	 * @see #setMinimumRunTime(Hours)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartupModel_MinimumRunTime()
	 * @generated
	 */
	Hours getMinimumRunTime();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getMinimumRunTime <em>Minimum Run Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Run Time</em>' attribute.
	 * @see #getMinimumRunTime()
	 * @generated
	 */
	void setMinimumRunTime(Hours value);

	/**
	 * Returns the value of the '<em><b>Risk Factor Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The opportunity cost associated with the return in dollars. This represents the restart's "share" of the unit depreciation and risk of an event which would damage the unit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Risk Factor Cost</em>' attribute.
	 * @see #setRiskFactorCost(Money)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartupModel_RiskFactorCost()
	 * @generated
	 */
	Money getRiskFactorCost();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getRiskFactorCost <em>Risk Factor Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Risk Factor Cost</em>' attribute.
	 * @see #getRiskFactorCost()
	 * @generated
	 */
	void setRiskFactorCost(Money value);

	/**
	 * Returns the value of the '<em><b>Startup Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Total miscellaneous start up costs
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Startup Cost</em>' attribute.
	 * @see #setStartupCost(Money)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartupModel_StartupCost()
	 * @generated
	 */
	Money getStartupCost();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartupCost <em>Startup Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Cost</em>' attribute.
	 * @see #getStartupCost()
	 * @generated
	 */
	void setStartupCost(Money value);

	/**
	 * Returns the value of the '<em><b>Startup Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The date and time of the most recent generating unit startup
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Startup Date</em>' attribute.
	 * @see #setStartupDate(Date)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartupModel_StartupDate()
	 * @generated
	 */
	Date getStartupDate();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartupDate <em>Startup Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Date</em>' attribute.
	 * @see #getStartupDate()
	 * @generated
	 */
	void setStartupDate(Date value);

	/**
	 * Returns the value of the '<em><b>Startup Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Startup priority within control area where lower numbers indicate higher priorities.  More than one unit in an area may be assigned the same priority.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Startup Priority</em>' attribute.
	 * @see #setStartupPriority(Priority)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartupModel_StartupPriority()
	 * @generated
	 */
	Priority getStartupPriority();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartupPriority <em>Startup Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Priority</em>' attribute.
	 * @see #getStartupPriority()
	 * @generated
	 */
	void setStartupPriority(Priority value);

	/**
	 * Returns the value of the '<em><b>Stby Aux Power MW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The unit's auxiliary power consumption to maintain standby mode
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Stby Aux Power MW</em>' attribute.
	 * @see #setStbyAuxPowerMW(ActivePower)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartupModel_StbyAuxPowerMW()
	 * @generated
	 */
	ActivePower getStbyAuxPowerMW();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStbyAuxPowerMW <em>Stby Aux Power MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stby Aux Power MW</em>' attribute.
	 * @see #getStbyAuxPowerMW()
	 * @generated
	 */
	void setStbyAuxPowerMW(ActivePower value);

	/**
	 * Returns the value of the '<em><b>Start Ign Fuel Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The unit's startup model may have a startup ignition fuel curve
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start Ign Fuel Curve</em>' containment reference.
	 * @see #setStartIgnFuelCurve(StartIgnFuelCurve)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartupModel_StartIgnFuelCurve()
	 * @generated
	 */
	StartIgnFuelCurve getStartIgnFuelCurve();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartIgnFuelCurve <em>Start Ign Fuel Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Ign Fuel Curve</em>' containment reference.
	 * @see #getStartIgnFuelCurve()
	 * @generated
	 */
	void setStartIgnFuelCurve(StartIgnFuelCurve value);

	/**
	 * Returns the value of the '<em><b>Start Main Fuel Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The unit's startup model may have a startup main fuel curve
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start Main Fuel Curve</em>' containment reference.
	 * @see #setStartMainFuelCurve(StartMainFuelCurve)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartupModel_StartMainFuelCurve()
	 * @generated
	 */
	StartMainFuelCurve getStartMainFuelCurve();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartMainFuelCurve <em>Start Main Fuel Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Main Fuel Curve</em>' containment reference.
	 * @see #getStartMainFuelCurve()
	 * @generated
	 */
	void setStartMainFuelCurve(StartMainFuelCurve value);

	/**
	 * Returns the value of the '<em><b>Start Ramp Curve</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The unit's startup model may have a startup ramp curve
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start Ramp Curve</em>' containment reference.
	 * @see #setStartRampCurve(StartRampCurve)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getStartupModel_StartRampCurve()
	 * @generated
	 */
	StartRampCurve getStartRampCurve();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.StartupModel#getStartRampCurve <em>Start Ramp Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Ramp Curve</em>' containment reference.
	 * @see #getStartRampCurve()
	 * @generated
	 */
	void setStartRampCurve(StartRampCurve value);

} // StartupModel