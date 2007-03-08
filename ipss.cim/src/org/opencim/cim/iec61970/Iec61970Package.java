/**
 * <copyright>
 * </copyright>
 *
 * $Id: Iec61970Package.java,v 1.1 2007/03/02 14:01:18 mzhou Exp $
 */
package org.opencim.cim.iec61970;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.Iec61970Factory
 * @model kind="package"
 * @generated
 */
public interface Iec61970Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "iec61970";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.opencim.cim.iec61970";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cim";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Iec61970Package eINSTANCE = org.opencim.cim.iec61970.impl.Iec61970PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.impl.Iec61970VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.impl.Iec61970VersionImpl
	 * @see org.opencim.cim.iec61970.impl.Iec61970PackageImpl#getIec61970Version()
	 * @generated
	 */
	int IEC61970_VERSION = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IEC61970_VERSION__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IEC61970_VERSION__DATE = 1;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IEC61970_VERSION_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.Iec61970Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.opencim.cim.iec61970.Iec61970Version
	 * @generated
	 */
	EClass getIec61970Version();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.Iec61970Version#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.opencim.cim.iec61970.Iec61970Version#getVersion()
	 * @see #getIec61970Version()
	 * @generated
	 */
	EAttribute getIec61970Version_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.Iec61970Version#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.opencim.cim.iec61970.Iec61970Version#getDate()
	 * @see #getIec61970Version()
	 * @generated
	 */
	EAttribute getIec61970Version_Date();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Iec61970Factory getIec61970Factory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.impl.Iec61970VersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.impl.Iec61970VersionImpl
		 * @see org.opencim.cim.iec61970.impl.Iec61970PackageImpl#getIec61970Version()
		 * @generated
		 */
		EClass IEC61970_VERSION = eINSTANCE.getIec61970Version();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IEC61970_VERSION__VERSION = eINSTANCE.getIec61970Version_Version();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IEC61970_VERSION__DATE = eINSTANCE.getIec61970Version_Date();

	}

} //Iec61970Package
