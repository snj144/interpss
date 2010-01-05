/**
 * <copyright>
 * </copyright>
 *
 * $Id: CustomerMeterImpl.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.load.impl;

import org.eclipse.emf.ecore.EClass;

import org.opencim.cim.iec61970.load.CustomerMeter;
import org.opencim.cim.iec61970.load.LoadPackage;

import org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer Meter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CustomerMeterImpl extends EnergyConsumerImpl implements CustomerMeter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomerMeterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LoadPackage.Literals.CUSTOMER_METER;
	}

} //CustomerMeterImpl