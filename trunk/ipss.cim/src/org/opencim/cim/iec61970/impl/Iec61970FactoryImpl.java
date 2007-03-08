/**
 * <copyright>
 * </copyright>
 *
 * $Id: Iec61970FactoryImpl.java,v 1.1 2007/03/02 14:01:17 mzhou Exp $
 */
package org.opencim.cim.iec61970.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.opencim.cim.iec61970.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Iec61970FactoryImpl extends EFactoryImpl implements Iec61970Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Iec61970Factory init() {
		try {
			Iec61970Factory theIec61970Factory = (Iec61970Factory)EPackage.Registry.INSTANCE.getEFactory("org.opencim.cim.iec61970"); 
			if (theIec61970Factory != null) {
				return theIec61970Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Iec61970FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iec61970FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Iec61970Package.IEC61970_VERSION: return createIec61970Version();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iec61970Version createIec61970Version() {
		Iec61970VersionImpl iec61970Version = new Iec61970VersionImpl();
		return iec61970Version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iec61970Package getIec61970Package() {
		return (Iec61970Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static Iec61970Package getPackage() {
		return Iec61970Package.eINSTANCE;
	}

} //Iec61970FactoryImpl
