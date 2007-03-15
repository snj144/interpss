/**
 * <copyright>
 * </copyright>
 *
 * $Id: CoreSwitch.java,v 1.2 2007/03/07 16:03:49 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.opencim.cim.iec61970.core.*;

import org.opencim.cim.iec61970.core.impl.CorePackageImpl;

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
 * @see org.opencim.cim.iec61970.core.CorePackage
 * @generated
 */
public class CoreSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CorePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreSwitch() {
		if (modelPackage == null) {
			modelPackage = CorePackage.eINSTANCE;
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
			case CorePackage.BAY: {
				Bay bay = (Bay)theEObject;
				Object result = caseBay(bay);
				if (result == null) result = caseEquipmentContainer(bay);
				if (result == null) result = casePowerSystemResource(bay);
				if (result == null) result = caseNaming(bay);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CONDUCTING_EQUIPMENT: {
				ConductingEquipment conductingEquipment = (ConductingEquipment)theEObject;
				Object result = caseConductingEquipment(conductingEquipment);
				if (result == null) result = caseEquipment(conductingEquipment);
				if (result == null) result = casePowerSystemResource(conductingEquipment);
				if (result == null) result = caseNaming(conductingEquipment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CONTROL_HOUSE_EQUIPMENT: {
				ControlHouseEquipment controlHouseEquipment = (ControlHouseEquipment)theEObject;
				Object result = caseControlHouseEquipment(controlHouseEquipment);
				if (result == null) result = casePowerSystemResource(controlHouseEquipment);
				if (result == null) result = caseNaming(controlHouseEquipment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.POWER_SYSTEM_RESOURCE: {
				PowerSystemResource powerSystemResource = (PowerSystemResource)theEObject;
				Object result = casePowerSystemResource(powerSystemResource);
				if (result == null) result = caseNaming(powerSystemResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.SUBSTATION: {
				Substation substation = (Substation)theEObject;
				Object result = caseSubstation(substation);
				if (result == null) result = caseEquipmentContainer(substation);
				if (result == null) result = casePowerSystemResource(substation);
				if (result == null) result = caseNaming(substation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.TERMINAL: {
				Terminal terminal = (Terminal)theEObject;
				Object result = caseTerminal(terminal);
				if (result == null) result = caseNaming(terminal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.SUB_CONTROL_AREA: {
				SubControlArea subControlArea = (SubControlArea)theEObject;
				Object result = caseSubControlArea(subControlArea);
				if (result == null) result = casePowerSystemResource(subControlArea);
				if (result == null) result = caseNaming(subControlArea);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CURVE_SCHEDULE: {
				CurveSchedule curveSchedule = (CurveSchedule)theEObject;
				Object result = caseCurveSchedule(curveSchedule);
				if (result == null) result = caseNaming(curveSchedule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CURVE_SCHED_DATA: {
				CurveSchedData curveSchedData = (CurveSchedData)theEObject;
				Object result = caseCurveSchedData(curveSchedData);
				if (result == null) result = caseNaming(curveSchedData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CURVE_SCHED_FORMULA: {
				CurveSchedFormula curveSchedFormula = (CurveSchedFormula)theEObject;
				Object result = caseCurveSchedFormula(curveSchedFormula);
				if (result == null) result = caseNaming(curveSchedFormula);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.BASE_VOLTAGE: {
				BaseVoltage baseVoltage = (BaseVoltage)theEObject;
				Object result = caseBaseVoltage(baseVoltage);
				if (result == null) result = caseNaming(baseVoltage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.BASE_POWER: {
				BasePower basePower = (BasePower)theEObject;
				Object result = caseBasePower(basePower);
				if (result == null) result = caseNaming(basePower);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.VOLTAGE_LEVEL: {
				VoltageLevel voltageLevel = (VoltageLevel)theEObject;
				Object result = caseVoltageLevel(voltageLevel);
				if (result == null) result = caseEquipmentContainer(voltageLevel);
				if (result == null) result = casePowerSystemResource(voltageLevel);
				if (result == null) result = caseNaming(voltageLevel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.NAMING: {
				Naming naming = (Naming)theEObject;
				Object result = caseNaming(naming);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.EQUIPMENT: {
				Equipment equipment = (Equipment)theEObject;
				Object result = caseEquipment(equipment);
				if (result == null) result = casePowerSystemResource(equipment);
				if (result == null) result = caseNaming(equipment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.UNIT: {
				Unit unit = (Unit)theEObject;
				Object result = caseUnit(unit);
				if (result == null) result = caseNaming(unit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.EQUIPMENT_CONTAINER: {
				EquipmentContainer equipmentContainer = (EquipmentContainer)theEObject;
				Object result = caseEquipmentContainer(equipmentContainer);
				if (result == null) result = casePowerSystemResource(equipmentContainer);
				if (result == null) result = caseNaming(equipmentContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.PSR_TYPE: {
				PSRType psrType = (PSRType)theEObject;
				Object result = casePSRType(psrType);
				if (result == null) result = caseNaming(psrType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CORE_VERSION: {
				CoreVersion coreVersion = (CoreVersion)theEObject;
				Object result = caseCoreVersion(coreVersion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMPANY: {
				Company company = (Company)theEObject;
				Object result = caseCompany(company);
				if (result == null) result = caseNaming(company);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Bay</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Bay</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBay(Bay object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Company</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Company</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCompany(Company object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Conducting Equipment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Conducting Equipment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConductingEquipment(ConductingEquipment object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Control House Equipment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Control House Equipment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseControlHouseEquipment(ControlHouseEquipment object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Power System Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Power System Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePowerSystemResource(PowerSystemResource object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Substation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Substation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSubstation(Substation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Terminal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTerminal(Terminal object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Sub Control Area</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Sub Control Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSubControlArea(SubControlArea object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Curve Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Curve Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCurveSchedule(CurveSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Curve Sched Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Curve Sched Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCurveSchedData(CurveSchedData object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Curve Sched Formula</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Curve Sched Formula</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCurveSchedFormula(CurveSchedFormula object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Base Voltage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Base Voltage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBaseVoltage(BaseVoltage object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Base Power</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Base Power</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBasePower(BasePower object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Voltage Level</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Voltage Level</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVoltageLevel(VoltageLevel object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Naming</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Naming</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNaming(Naming object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Equipment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Equipment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEquipment(Equipment object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Equipment Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Equipment Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEquipmentContainer(EquipmentContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>PSR Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>PSR Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePSRType(PSRType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Version</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Version</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCoreVersion(CoreVersion object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //CoreSwitch
