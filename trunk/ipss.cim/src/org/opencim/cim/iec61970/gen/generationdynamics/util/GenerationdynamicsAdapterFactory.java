/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenerationdynamicsAdapterFactory.java,v 1.1 2007/03/02 14:01:17 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.opencim.cim.iec61970.core.CurveSchedule;
import org.opencim.cim.iec61970.core.Naming;
import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.cim.iec61970.gen.generationdynamics.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage
 * @generated
 */
public class GenerationdynamicsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GenerationdynamicsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenerationdynamicsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GenerationdynamicsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenerationdynamicsSwitch modelSwitch =
		new GenerationdynamicsSwitch() {
			public Object caseSupercritical(Supercritical object) {
				return createSupercriticalAdapter();
			}
			public Object caseSubcritical(Subcritical object) {
				return createSubcriticalAdapter();
			}
			public Object caseSteamTurbine(SteamTurbine object) {
				return createSteamTurbineAdapter();
			}
			public Object caseSteamSupply(SteamSupply object) {
				return createSteamSupplyAdapter();
			}
			public Object casePWRSteamSupply(PWRSteamSupply object) {
				return createPWRSteamSupplyAdapter();
			}
			public Object casePrimeMover(PrimeMover object) {
				return createPrimeMoverAdapter();
			}
			public Object caseHeatRecoveryBoiler(HeatRecoveryBoiler object) {
				return createHeatRecoveryBoilerAdapter();
			}
			public Object caseHydroTurbine(HydroTurbine object) {
				return createHydroTurbineAdapter();
			}
			public Object caseFossilSteamSupply(FossilSteamSupply object) {
				return createFossilSteamSupplyAdapter();
			}
			public Object caseDrumBoiler(DrumBoiler object) {
				return createDrumBoilerAdapter();
			}
			public Object caseCombustionTurbine(CombustionTurbine object) {
				return createCombustionTurbineAdapter();
			}
			public Object caseBWRSteamSupply(BWRSteamSupply object) {
				return createBWRSteamSupplyAdapter();
			}
			public Object caseCTTempMWCurve(CTTempMWCurve object) {
				return createCTTempMWCurveAdapter();
			}
			public Object caseNaming(Naming object) {
				return createNamingAdapter();
			}
			public Object casePowerSystemResource(PowerSystemResource object) {
				return createPowerSystemResourceAdapter();
			}
			public Object caseCurveSchedule(CurveSchedule object) {
				return createCurveScheduleAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.generationdynamics.Supercritical <em>Supercritical</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.Supercritical
	 * @generated
	 */
	public Adapter createSupercriticalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.generationdynamics.Subcritical <em>Subcritical</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.Subcritical
	 * @generated
	 */
	public Adapter createSubcriticalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine <em>Steam Turbine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.SteamTurbine
	 * @generated
	 */
	public Adapter createSteamTurbineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.generationdynamics.SteamSupply <em>Steam Supply</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.SteamSupply
	 * @generated
	 */
	public Adapter createSteamSupplyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply <em>PWR Steam Supply</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.PWRSteamSupply
	 * @generated
	 */
	public Adapter createPWRSteamSupplyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.generationdynamics.PrimeMover <em>Prime Mover</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.PrimeMover
	 * @generated
	 */
	public Adapter createPrimeMoverAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.generationdynamics.HeatRecoveryBoiler <em>Heat Recovery Boiler</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.HeatRecoveryBoiler
	 * @generated
	 */
	public Adapter createHeatRecoveryBoilerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine <em>Hydro Turbine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.HydroTurbine
	 * @generated
	 */
	public Adapter createHydroTurbineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply <em>Fossil Steam Supply</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.FossilSteamSupply
	 * @generated
	 */
	public Adapter createFossilSteamSupplyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.generationdynamics.DrumBoiler <em>Drum Boiler</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.DrumBoiler
	 * @generated
	 */
	public Adapter createDrumBoilerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine <em>Combustion Turbine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine
	 * @generated
	 */
	public Adapter createCombustionTurbineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply <em>BWR Steam Supply</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.BWRSteamSupply
	 * @generated
	 */
	public Adapter createBWRSteamSupplyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.gen.generationdynamics.CTTempMWCurve <em>CT Temp MW Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.gen.generationdynamics.CTTempMWCurve
	 * @generated
	 */
	public Adapter createCTTempMWCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.Naming <em>Naming</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.Naming
	 * @generated
	 */
	public Adapter createNamingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.PowerSystemResource <em>Power System Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.PowerSystemResource
	 * @generated
	 */
	public Adapter createPowerSystemResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.CurveSchedule <em>Curve Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule
	 * @generated
	 */
	public Adapter createCurveScheduleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GenerationdynamicsAdapterFactory
