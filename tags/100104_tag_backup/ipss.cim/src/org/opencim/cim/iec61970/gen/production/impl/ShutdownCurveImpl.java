/**
 * <copyright>
 * </copyright>
 *
 * $Id: ShutdownCurveImpl.java,v 1.1 2007/03/02 14:01:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.gen.production.ProductionPackage;
import org.opencim.cim.iec61970.gen.production.ShutdownCurve;

import org.opencim.datatype.real.Money;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shutdown Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ShutdownCurveImpl#getShutdownCost <em>Shutdown Cost</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.ShutdownCurveImpl#getShutdownDate <em>Shutdown Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ShutdownCurveImpl extends CurveScheduleImpl implements ShutdownCurve {
	/**
	 * The default value of the '{@link #getShutdownCost() <em>Shutdown Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShutdownCost()
	 * @generated
	 * @ordered
	 */
	protected static final Money SHUTDOWN_COST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShutdownCost() <em>Shutdown Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShutdownCost()
	 * @generated
	 * @ordered
	 */
	protected Money shutdownCost = SHUTDOWN_COST_EDEFAULT;

	/**
	 * The default value of the '{@link #getShutdownDate() <em>Shutdown Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShutdownDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date SHUTDOWN_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShutdownDate() <em>Shutdown Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShutdownDate()
	 * @generated
	 * @ordered
	 */
	protected Date shutdownDate = SHUTDOWN_DATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShutdownCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.SHUTDOWN_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Money getShutdownCost() {
		return shutdownCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShutdownCost(Money newShutdownCost) {
		Money oldShutdownCost = shutdownCost;
		shutdownCost = newShutdownCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.SHUTDOWN_CURVE__SHUTDOWN_COST, oldShutdownCost, shutdownCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getShutdownDate() {
		return shutdownDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShutdownDate(Date newShutdownDate) {
		Date oldShutdownDate = shutdownDate;
		shutdownDate = newShutdownDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.SHUTDOWN_CURVE__SHUTDOWN_DATE, oldShutdownDate, shutdownDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProductionPackage.SHUTDOWN_CURVE__SHUTDOWN_COST:
				return getShutdownCost();
			case ProductionPackage.SHUTDOWN_CURVE__SHUTDOWN_DATE:
				return getShutdownDate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProductionPackage.SHUTDOWN_CURVE__SHUTDOWN_COST:
				setShutdownCost((Money)newValue);
				return;
			case ProductionPackage.SHUTDOWN_CURVE__SHUTDOWN_DATE:
				setShutdownDate((Date)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ProductionPackage.SHUTDOWN_CURVE__SHUTDOWN_COST:
				setShutdownCost(SHUTDOWN_COST_EDEFAULT);
				return;
			case ProductionPackage.SHUTDOWN_CURVE__SHUTDOWN_DATE:
				setShutdownDate(SHUTDOWN_DATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ProductionPackage.SHUTDOWN_CURVE__SHUTDOWN_COST:
				return SHUTDOWN_COST_EDEFAULT == null ? shutdownCost != null : !SHUTDOWN_COST_EDEFAULT.equals(shutdownCost);
			case ProductionPackage.SHUTDOWN_CURVE__SHUTDOWN_DATE:
				return SHUTDOWN_DATE_EDEFAULT == null ? shutdownDate != null : !SHUTDOWN_DATE_EDEFAULT.equals(shutdownDate);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (shutdownCost: ");
		result.append(shutdownCost);
		result.append(", shutdownDate: ");
		result.append(shutdownDate);
		result.append(')');
		return result.toString();
	}

} //ShutdownCurveImpl