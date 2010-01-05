/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoadFactoryImpl.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.load.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.opencim.cim.iec61970.load.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LoadFactoryImpl extends EFactoryImpl implements LoadFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LoadFactory init() {
		try {
			LoadFactory theLoadFactory = (LoadFactory)EPackage.Registry.INSTANCE.getEFactory("org.interpss.cim.iec61976.load"); 
			if (theLoadFactory != null) {
				return theLoadFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LoadFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LoadPackage.AREA_LOAD_CURVE: return createAreaLoadCurve();
			case LoadPackage.AREA_LOSS_CURVE: return createAreaLossCurve();
			case LoadPackage.CUSTOMER_METER: return createCustomerMeter();
			case LoadPackage.DAY_TYPE: return createDayType();
			case LoadPackage.EQUIVALENT_LOAD: return createEquivalentLoad();
			case LoadPackage.INDUCTION_MOTOR_LOAD: return createInductionMotorLoad();
			case LoadPackage.LOAD_AREA: return createLoadArea();
			case LoadPackage.LOAD_DEMAND_MODEL: return createLoadDemandModel();
			case LoadPackage.NON_CONFORM_LOAD_SCHEDULE: return createNonConformLoadSchedule();
			case LoadPackage.SEASON: return createSeason();
			case LoadPackage.STATION_SUPPLY: return createStationSupply();
			case LoadPackage.POWER_CUT_ZONE: return createPowerCutZone();
			case LoadPackage.LOAD_MODEL_VERSION: return createLoadModelVersion();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AreaLoadCurve createAreaLoadCurve() {
		AreaLoadCurveImpl areaLoadCurve = new AreaLoadCurveImpl();
		return areaLoadCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AreaLossCurve createAreaLossCurve() {
		AreaLossCurveImpl areaLossCurve = new AreaLossCurveImpl();
		return areaLossCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomerMeter createCustomerMeter() {
		CustomerMeterImpl customerMeter = new CustomerMeterImpl();
		return customerMeter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DayType createDayType() {
		DayTypeImpl dayType = new DayTypeImpl();
		return dayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquivalentLoad createEquivalentLoad() {
		EquivalentLoadImpl equivalentLoad = new EquivalentLoadImpl();
		return equivalentLoad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InductionMotorLoad createInductionMotorLoad() {
		InductionMotorLoadImpl inductionMotorLoad = new InductionMotorLoadImpl();
		return inductionMotorLoad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadArea createLoadArea() {
		LoadAreaImpl loadArea = new LoadAreaImpl();
		return loadArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadDemandModel createLoadDemandModel() {
		LoadDemandModelImpl loadDemandModel = new LoadDemandModelImpl();
		return loadDemandModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonConformLoadSchedule createNonConformLoadSchedule() {
		NonConformLoadScheduleImpl nonConformLoadSchedule = new NonConformLoadScheduleImpl();
		return nonConformLoadSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Season createSeason() {
		SeasonImpl season = new SeasonImpl();
		return season;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StationSupply createStationSupply() {
		StationSupplyImpl stationSupply = new StationSupplyImpl();
		return stationSupply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerCutZone createPowerCutZone() {
		PowerCutZoneImpl powerCutZone = new PowerCutZoneImpl();
		return powerCutZone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadModelVersion createLoadModelVersion() {
		LoadModelVersionImpl loadModelVersion = new LoadModelVersionImpl();
		return loadModelVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadPackage getLoadPackage() {
		return (LoadPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static LoadPackage getPackage() {
		return LoadPackage.eINSTANCE;
	}

} //LoadFactoryImpl
