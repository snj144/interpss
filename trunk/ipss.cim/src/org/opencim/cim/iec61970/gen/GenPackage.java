/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenPackage.java,v 1.1 2007/03/02 14:01:12 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen;

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
 * <!-- begin-model-doc -->
 * This package contains packages that have information for Unit Commitment and Economic Dispatch of Hydro and Thermal Generating Units, Load Forecasting, Automatic Generation Control, and Unit Modeling for Dynamic Training Simulator.
 * <!-- end-model-doc -->
 * @see org.opencim.cim.iec61970.gen.GenFactory
 * @model kind="package"
 * @generated
 */
public interface GenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "gen";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.opencim.cim.iec61970.gen";

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
	GenPackage eINSTANCE = org.opencim.cim.iec61970.gen.impl.GenPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.opencim.cim.iec61970.gen.impl.GenerationVersionImpl <em>Generation Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.opencim.cim.iec61970.gen.impl.GenerationVersionImpl
	 * @see org.opencim.cim.iec61970.gen.impl.GenPackageImpl#getGenerationVersion()
	 * @generated
	 */
	int GENERATION_VERSION = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATION_VERSION__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATION_VERSION__DATE = 1;

	/**
	 * The number of structural features of the '<em>Generation Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATION_VERSION_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.opencim.cim.iec61970.gen.GenerationVersion <em>Generation Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generation Version</em>'.
	 * @see org.opencim.cim.iec61970.gen.GenerationVersion
	 * @generated
	 */
	EClass getGenerationVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.GenerationVersion#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.opencim.cim.iec61970.gen.GenerationVersion#getVersion()
	 * @see #getGenerationVersion()
	 * @generated
	 */
	EAttribute getGenerationVersion_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.opencim.cim.iec61970.gen.GenerationVersion#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.opencim.cim.iec61970.gen.GenerationVersion#getDate()
	 * @see #getGenerationVersion()
	 * @generated
	 */
	EAttribute getGenerationVersion_Date();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GenFactory getGenFactory();

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
		 * The meta object literal for the '{@link org.opencim.cim.iec61970.gen.impl.GenerationVersionImpl <em>Generation Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.opencim.cim.iec61970.gen.impl.GenerationVersionImpl
		 * @see org.opencim.cim.iec61970.gen.impl.GenPackageImpl#getGenerationVersion()
		 * @generated
		 */
		EClass GENERATION_VERSION = eINSTANCE.getGenerationVersion();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATION_VERSION__VERSION = eINSTANCE.getGenerationVersion_Version();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATION_VERSION__DATE = eINSTANCE.getGenerationVersion_Date();

	}

} //GenPackage
