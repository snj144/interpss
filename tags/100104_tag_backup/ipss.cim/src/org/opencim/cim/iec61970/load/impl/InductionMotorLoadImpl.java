/**
 * <copyright>
 * </copyright>
 *
 * $Id: InductionMotorLoadImpl.java,v 1.1 2007/03/02 14:01:01 mzhou Exp $
 */
package org.opencim.cim.iec61970.load.impl;

import org.eclipse.emf.ecore.EClass;

import org.opencim.cim.iec61970.load.InductionMotorLoad;
import org.opencim.cim.iec61970.load.LoadPackage;

import org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Induction Motor Load</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class InductionMotorLoadImpl extends EnergyConsumerImpl implements InductionMotorLoad {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InductionMotorLoadImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LoadPackage.Literals.INDUCTION_MOTOR_LOAD;
	}

} //InductionMotorLoadImpl