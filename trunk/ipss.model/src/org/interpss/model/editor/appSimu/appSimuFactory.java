/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.model.editor.appSimu;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.interpss.model.editor.appSimu.appSimuPackage
 * @generated
 */
public interface appSimuFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	appSimuFactory eINSTANCE = org.interpss.model.editor.appSimu.impl.appSimuFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>App Simu Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>App Simu Context</em>'.
	 * @generated
	 */
	<TSimuCtx> AppSimuContext<TSimuCtx> createAppSimuContext();

	/**
	 * Returns a new object of class '<em>Project Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Data</em>'.
	 * @generated
	 */
	ProjectData createProjectData();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	appSimuPackage getappSimuPackage();

} //appSimuFactory
