/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenerationdynamicsSwitch.java,v 1.1 2007/03/02 14:01:17 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.opencim.cim.iec61970.core.CurveSchedule;
import org.opencim.cim.iec61970.core.Naming;
import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.cim.iec61970.gen.generationdynamics.*;

import org.opencim.cim.iec61970.gen.generationdynamics.impl.GenerationdynamicsPackageImpl;

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
 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage
 * @generated
 */
public class GenerationdynamicsSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GenerationdynamicsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenerationdynamicsSwitch() {
		if (modelPackage == null) {
			modelPackage = GenerationdynamicsPackage.eINSTANCE;
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
			case GenerationdynamicsPackage.SUPERCRITICAL: {
				Supercritical supercritical = (Supercritical)theEObject;
				Object result = caseSupercritical(supercritical);
				if (result == null) result = caseFossilSteamSupply(supercritical);
				if (result == null) result = caseSteamSupply(supercritical);
				if (result == null) result = casePowerSystemResource(supercritical);
				if (result == null) result = caseNaming(supercritical);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenerationdynamicsPackage.SUBCRITICAL: {
				Subcritical subcritical = (Subcritical)theEObject;
				Object result = caseSubcritical(subcritical);
				if (result == null) result = caseFossilSteamSupply(subcritical);
				if (result == null) result = caseSteamSupply(subcritical);
				if (result == null) result = casePowerSystemResource(subcritical);
				if (result == null) result = caseNaming(subcritical);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenerationdynamicsPackage.STEAM_TURBINE: {
				SteamTurbine steamTurbine = (SteamTurbine)theEObject;
				Object result = caseSteamTurbine(steamTurbine);
				if (result == null) result = casePrimeMover(steamTurbine);
				if (result == null) result = casePowerSystemResource(steamTurbine);
				if (result == null) result = caseNaming(steamTurbine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenerationdynamicsPackage.STEAM_SUPPLY: {
				SteamSupply steamSupply = (SteamSupply)theEObject;
				Object result = caseSteamSupply(steamSupply);
				if (result == null) result = casePowerSystemResource(steamSupply);
				if (result == null) result = caseNaming(steamSupply);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY: {
				PWRSteamSupply pwrSteamSupply = (PWRSteamSupply)theEObject;
				Object result = casePWRSteamSupply(pwrSteamSupply);
				if (result == null) result = caseSteamSupply(pwrSteamSupply);
				if (result == null) result = casePowerSystemResource(pwrSteamSupply);
				if (result == null) result = caseNaming(pwrSteamSupply);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenerationdynamicsPackage.PRIME_MOVER: {
				PrimeMover primeMover = (PrimeMover)theEObject;
				Object result = casePrimeMover(primeMover);
				if (result == null) result = casePowerSystemResource(primeMover);
				if (result == null) result = caseNaming(primeMover);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenerationdynamicsPackage.HEAT_RECOVERY_BOILER: {
				HeatRecoveryBoiler heatRecoveryBoiler = (HeatRecoveryBoiler)theEObject;
				Object result = caseHeatRecoveryBoiler(heatRecoveryBoiler);
				if (result == null) result = caseFossilSteamSupply(heatRecoveryBoiler);
				if (result == null) result = caseSteamSupply(heatRecoveryBoiler);
				if (result == null) result = casePowerSystemResource(heatRecoveryBoiler);
				if (result == null) result = caseNaming(heatRecoveryBoiler);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenerationdynamicsPackage.HYDRO_TURBINE: {
				HydroTurbine hydroTurbine = (HydroTurbine)theEObject;
				Object result = caseHydroTurbine(hydroTurbine);
				if (result == null) result = casePrimeMover(hydroTurbine);
				if (result == null) result = casePowerSystemResource(hydroTurbine);
				if (result == null) result = caseNaming(hydroTurbine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY: {
				FossilSteamSupply fossilSteamSupply = (FossilSteamSupply)theEObject;
				Object result = caseFossilSteamSupply(fossilSteamSupply);
				if (result == null) result = caseSteamSupply(fossilSteamSupply);
				if (result == null) result = casePowerSystemResource(fossilSteamSupply);
				if (result == null) result = caseNaming(fossilSteamSupply);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenerationdynamicsPackage.DRUM_BOILER: {
				DrumBoiler drumBoiler = (DrumBoiler)theEObject;
				Object result = caseDrumBoiler(drumBoiler);
				if (result == null) result = caseFossilSteamSupply(drumBoiler);
				if (result == null) result = caseSteamSupply(drumBoiler);
				if (result == null) result = casePowerSystemResource(drumBoiler);
				if (result == null) result = caseNaming(drumBoiler);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenerationdynamicsPackage.COMBUSTION_TURBINE: {
				CombustionTurbine combustionTurbine = (CombustionTurbine)theEObject;
				Object result = caseCombustionTurbine(combustionTurbine);
				if (result == null) result = casePrimeMover(combustionTurbine);
				if (result == null) result = casePowerSystemResource(combustionTurbine);
				if (result == null) result = caseNaming(combustionTurbine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenerationdynamicsPackage.BWR_STEAM_SUPPLY: {
				BWRSteamSupply bwrSteamSupply = (BWRSteamSupply)theEObject;
				Object result = caseBWRSteamSupply(bwrSteamSupply);
				if (result == null) result = caseSteamSupply(bwrSteamSupply);
				if (result == null) result = casePowerSystemResource(bwrSteamSupply);
				if (result == null) result = caseNaming(bwrSteamSupply);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenerationdynamicsPackage.CT_TEMP_MW_CURVE: {
				CTTempMWCurve ctTempMWCurve = (CTTempMWCurve)theEObject;
				Object result = caseCTTempMWCurve(ctTempMWCurve);
				if (result == null) result = caseCurveSchedule(ctTempMWCurve);
				if (result == null) result = caseNaming(ctTempMWCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Supercritical</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Supercritical</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSupercritical(Supercritical object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subcritical</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subcritical</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSubcritical(Subcritical object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Steam Turbine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Steam Turbine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSteamTurbine(SteamTurbine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Steam Supply</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Steam Supply</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSteamSupply(SteamSupply object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PWR Steam Supply</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PWR Steam Supply</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePWRSteamSupply(PWRSteamSupply object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prime Mover</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prime Mover</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimeMover(PrimeMover object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Heat Recovery Boiler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Heat Recovery Boiler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHeatRecoveryBoiler(HeatRecoveryBoiler object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hydro Turbine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hydro Turbine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHydroTurbine(HydroTurbine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fossil Steam Supply</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fossil Steam Supply</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFossilSteamSupply(FossilSteamSupply object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Drum Boiler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Drum Boiler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDrumBoiler(DrumBoiler object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Combustion Turbine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Combustion Turbine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCombustionTurbine(CombustionTurbine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BWR Steam Supply</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BWR Steam Supply</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBWRSteamSupply(BWRSteamSupply object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CT Temp MW Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CT Temp MW Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCTTempMWCurve(CTTempMWCurve object) {
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

} //GenerationdynamicsSwitch
