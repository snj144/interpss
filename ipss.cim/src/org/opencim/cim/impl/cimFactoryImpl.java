/**
 * <copyright>
 * </copyright>
 *
 * $Id: cimFactoryImpl.java,v 1.2 2007/03/03 02:50:00 mzhou Exp $
 */
package org.opencim.cim.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.opencim.cim.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class cimFactoryImpl extends EFactoryImpl implements cimFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static cimFactory init() {
		try {
			cimFactory thecimFactory = (cimFactory)EPackage.Registry.INSTANCE.getEFactory("org.opencim"); 
			if (thecimFactory != null) {
				return thecimFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new cimFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public cimFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case cimPackage.COMBINED_VERSION: return createCombinedVersion();
			case cimPackage.SIMULATION_MODEL: return createSimulationModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombinedVersion createCombinedVersion() {
		CombinedVersionImpl combinedVersion = new CombinedVersionImpl();
		return combinedVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationModel createSimulationModel() {
		SimulationModelImpl simulationModel = new SimulationModelImpl();
		return simulationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public cimPackage getcimPackage() {
		return (cimPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static cimPackage getPackage() {
		return cimPackage.eINSTANCE;
	}

} //cimFactoryImpl
