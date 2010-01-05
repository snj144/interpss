/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoadSwitch.java,v 1.1 2007/03/02 14:01:19 mzhou Exp $
 */
package org.opencim.cim.iec61970.load.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.opencim.cim.iec61970.core.ConductingEquipment;
import org.opencim.cim.iec61970.core.CurveSchedule;
import org.opencim.cim.iec61970.core.Equipment;
import org.opencim.cim.iec61970.core.Naming;
import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.cim.iec61970.load.*;

import org.opencim.cim.iec61970.load.impl.LoadPackageImpl;

import org.opencim.cim.iec61970.wire.EnergyConsumer;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.load.LoadPackage
 * @generated
 */
public class LoadSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LoadPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadSwitch() {
		if (modelPackage == null) {
			modelPackage = LoadPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case LoadPackage.AREA_LOAD_CURVE: {
				AreaLoadCurve areaLoadCurve = (AreaLoadCurve)theEObject;
				Object result = caseAreaLoadCurve(areaLoadCurve);
				if (result == null) result = caseCurveSchedule(areaLoadCurve);
				if (result == null) result = caseNaming(areaLoadCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoadPackage.AREA_LOSS_CURVE: {
				AreaLossCurve areaLossCurve = (AreaLossCurve)theEObject;
				Object result = caseAreaLossCurve(areaLossCurve);
				if (result == null) result = caseCurveSchedule(areaLossCurve);
				if (result == null) result = caseNaming(areaLossCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoadPackage.CUSTOMER_METER: {
				CustomerMeter customerMeter = (CustomerMeter)theEObject;
				Object result = caseCustomerMeter(customerMeter);
				if (result == null) result = caseEnergyConsumer(customerMeter);
				if (result == null) result = caseConductingEquipment(customerMeter);
				if (result == null) result = caseEquipment(customerMeter);
				if (result == null) result = casePowerSystemResource(customerMeter);
				if (result == null) result = caseNaming(customerMeter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoadPackage.DAY_TYPE: {
				DayType dayType = (DayType)theEObject;
				Object result = caseDayType(dayType);
				if (result == null) result = caseNaming(dayType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoadPackage.EQUIVALENT_LOAD: {
				EquivalentLoad equivalentLoad = (EquivalentLoad)theEObject;
				Object result = caseEquivalentLoad(equivalentLoad);
				if (result == null) result = caseEnergyConsumer(equivalentLoad);
				if (result == null) result = caseConductingEquipment(equivalentLoad);
				if (result == null) result = caseEquipment(equivalentLoad);
				if (result == null) result = casePowerSystemResource(equivalentLoad);
				if (result == null) result = caseNaming(equivalentLoad);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoadPackage.INDUCTION_MOTOR_LOAD: {
				InductionMotorLoad inductionMotorLoad = (InductionMotorLoad)theEObject;
				Object result = caseInductionMotorLoad(inductionMotorLoad);
				if (result == null) result = caseEnergyConsumer(inductionMotorLoad);
				if (result == null) result = caseConductingEquipment(inductionMotorLoad);
				if (result == null) result = caseEquipment(inductionMotorLoad);
				if (result == null) result = casePowerSystemResource(inductionMotorLoad);
				if (result == null) result = caseNaming(inductionMotorLoad);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoadPackage.LOAD_AREA: {
				LoadArea loadArea = (LoadArea)theEObject;
				Object result = caseLoadArea(loadArea);
				if (result == null) result = casePowerSystemResource(loadArea);
				if (result == null) result = caseNaming(loadArea);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoadPackage.LOAD_DEMAND_MODEL: {
				LoadDemandModel loadDemandModel = (LoadDemandModel)theEObject;
				Object result = caseLoadDemandModel(loadDemandModel);
				if (result == null) result = caseCurveSchedule(loadDemandModel);
				if (result == null) result = caseNaming(loadDemandModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoadPackage.NON_CONFORM_LOAD_SCHEDULE: {
				NonConformLoadSchedule nonConformLoadSchedule = (NonConformLoadSchedule)theEObject;
				Object result = caseNonConformLoadSchedule(nonConformLoadSchedule);
				if (result == null) result = caseCurveSchedule(nonConformLoadSchedule);
				if (result == null) result = caseNaming(nonConformLoadSchedule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoadPackage.SEASON: {
				Season season = (Season)theEObject;
				Object result = caseSeason(season);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoadPackage.STATION_SUPPLY: {
				StationSupply stationSupply = (StationSupply)theEObject;
				Object result = caseStationSupply(stationSupply);
				if (result == null) result = caseEnergyConsumer(stationSupply);
				if (result == null) result = caseConductingEquipment(stationSupply);
				if (result == null) result = caseEquipment(stationSupply);
				if (result == null) result = casePowerSystemResource(stationSupply);
				if (result == null) result = caseNaming(stationSupply);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoadPackage.POWER_CUT_ZONE: {
				PowerCutZone powerCutZone = (PowerCutZone)theEObject;
				Object result = casePowerCutZone(powerCutZone);
				if (result == null) result = casePowerSystemResource(powerCutZone);
				if (result == null) result = caseNaming(powerCutZone);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoadPackage.LOAD_MODEL_VERSION: {
				LoadModelVersion loadModelVersion = (LoadModelVersion)theEObject;
				Object result = caseLoadModelVersion(loadModelVersion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Area Load Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Area Load Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAreaLoadCurve(AreaLoadCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Area Loss Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Area Loss Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAreaLossCurve(AreaLossCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Customer Meter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Customer Meter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCustomerMeter(CustomerMeter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Day Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Day Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDayType(DayType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equivalent Load</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equivalent Load</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEquivalentLoad(EquivalentLoad object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Induction Motor Load</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Induction Motor Load</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInductionMotorLoad(InductionMotorLoad object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Area</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLoadArea(LoadArea object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Demand Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Demand Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLoadDemandModel(LoadDemandModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Conform Load Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Conform Load Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNonConformLoadSchedule(NonConformLoadSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Season</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Season</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSeason(Season object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Station Supply</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Station Supply</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStationSupply(StationSupply object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power Cut Zone</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power Cut Zone</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePowerCutZone(PowerCutZone object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Version</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Version</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLoadModelVersion(LoadModelVersion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Naming</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Naming</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNaming(Naming object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Curve Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Curve Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCurveSchedule(CurveSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power System Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power System Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePowerSystemResource(PowerSystemResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equipment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equipment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEquipment(Equipment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conducting Equipment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conducting Equipment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConductingEquipment(ConductingEquipment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Energy Consumer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Energy Consumer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEnergyConsumer(EnergyConsumer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //LoadSwitch
