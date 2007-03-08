/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenerationdynamicsFactoryImpl.java,v 1.1 2007/03/02 14:01:14 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.opencim.cim.iec61970.gen.generationdynamics.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenerationdynamicsFactoryImpl extends EFactoryImpl implements GenerationdynamicsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GenerationdynamicsFactory init() {
		try {
			GenerationdynamicsFactory theGenerationdynamicsFactory = (GenerationdynamicsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///cim/generationdynamics.ecore"); 
			if (theGenerationdynamicsFactory != null) {
				return theGenerationdynamicsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GenerationdynamicsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenerationdynamicsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GenerationdynamicsPackage.SUPERCRITICAL: return createSupercritical();
			case GenerationdynamicsPackage.SUBCRITICAL: return createSubcritical();
			case GenerationdynamicsPackage.STEAM_TURBINE: return createSteamTurbine();
			case GenerationdynamicsPackage.STEAM_SUPPLY: return createSteamSupply();
			case GenerationdynamicsPackage.PWR_STEAM_SUPPLY: return createPWRSteamSupply();
			case GenerationdynamicsPackage.PRIME_MOVER: return createPrimeMover();
			case GenerationdynamicsPackage.HEAT_RECOVERY_BOILER: return createHeatRecoveryBoiler();
			case GenerationdynamicsPackage.HYDRO_TURBINE: return createHydroTurbine();
			case GenerationdynamicsPackage.FOSSIL_STEAM_SUPPLY: return createFossilSteamSupply();
			case GenerationdynamicsPackage.DRUM_BOILER: return createDrumBoiler();
			case GenerationdynamicsPackage.COMBUSTION_TURBINE: return createCombustionTurbine();
			case GenerationdynamicsPackage.BWR_STEAM_SUPPLY: return createBWRSteamSupply();
			case GenerationdynamicsPackage.CT_TEMP_MW_CURVE: return createCTTempMWCurve();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Supercritical createSupercritical() {
		SupercriticalImpl supercritical = new SupercriticalImpl();
		return supercritical;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subcritical createSubcritical() {
		SubcriticalImpl subcritical = new SubcriticalImpl();
		return subcritical;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SteamTurbine createSteamTurbine() {
		SteamTurbineImpl steamTurbine = new SteamTurbineImpl();
		return steamTurbine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SteamSupply createSteamSupply() {
		SteamSupplyImpl steamSupply = new SteamSupplyImpl();
		return steamSupply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PWRSteamSupply createPWRSteamSupply() {
		PWRSteamSupplyImpl pwrSteamSupply = new PWRSteamSupplyImpl();
		return pwrSteamSupply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimeMover createPrimeMover() {
		PrimeMoverImpl primeMover = new PrimeMoverImpl();
		return primeMover;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeatRecoveryBoiler createHeatRecoveryBoiler() {
		HeatRecoveryBoilerImpl heatRecoveryBoiler = new HeatRecoveryBoilerImpl();
		return heatRecoveryBoiler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HydroTurbine createHydroTurbine() {
		HydroTurbineImpl hydroTurbine = new HydroTurbineImpl();
		return hydroTurbine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FossilSteamSupply createFossilSteamSupply() {
		FossilSteamSupplyImpl fossilSteamSupply = new FossilSteamSupplyImpl();
		return fossilSteamSupply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DrumBoiler createDrumBoiler() {
		DrumBoilerImpl drumBoiler = new DrumBoilerImpl();
		return drumBoiler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombustionTurbine createCombustionTurbine() {
		CombustionTurbineImpl combustionTurbine = new CombustionTurbineImpl();
		return combustionTurbine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BWRSteamSupply createBWRSteamSupply() {
		BWRSteamSupplyImpl bwrSteamSupply = new BWRSteamSupplyImpl();
		return bwrSteamSupply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CTTempMWCurve createCTTempMWCurve() {
		CTTempMWCurveImpl ctTempMWCurve = new CTTempMWCurveImpl();
		return ctTempMWCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenerationdynamicsPackage getGenerationdynamicsPackage() {
		return (GenerationdynamicsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static GenerationdynamicsPackage getPackage() {
		return GenerationdynamicsPackage.eINSTANCE;
	}

} //GenerationdynamicsFactoryImpl
