/**
 * <copyright>
 * </copyright>
 *
 * $Id: HeatRateCurveImpl.java,v 1.1 2007/03/02 14:01:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.gen.production.HeatRateCurve;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Heat Rate Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HeatRateCurveImpl#getNetGrossMWFlag <em>Net Gross MW Flag</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HeatRateCurveImpl extends CurveScheduleImpl implements HeatRateCurve {
	/**
	 * The default value of the '{@link #getNetGrossMWFlag() <em>Net Gross MW Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetGrossMWFlag()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean NET_GROSS_MW_FLAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNetGrossMWFlag() <em>Net Gross MW Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetGrossMWFlag()
	 * @generated
	 * @ordered
	 */
	protected Boolean netGrossMWFlag = NET_GROSS_MW_FLAG_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HeatRateCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.HEAT_RATE_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getNetGrossMWFlag() {
		return netGrossMWFlag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetGrossMWFlag(Boolean newNetGrossMWFlag) {
		Boolean oldNetGrossMWFlag = netGrossMWFlag;
		netGrossMWFlag = newNetGrossMWFlag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HEAT_RATE_CURVE__NET_GROSS_MW_FLAG, oldNetGrossMWFlag, netGrossMWFlag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProductionPackage.HEAT_RATE_CURVE__NET_GROSS_MW_FLAG:
				return getNetGrossMWFlag();
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
			case ProductionPackage.HEAT_RATE_CURVE__NET_GROSS_MW_FLAG:
				setNetGrossMWFlag((Boolean)newValue);
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
			case ProductionPackage.HEAT_RATE_CURVE__NET_GROSS_MW_FLAG:
				setNetGrossMWFlag(NET_GROSS_MW_FLAG_EDEFAULT);
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
			case ProductionPackage.HEAT_RATE_CURVE__NET_GROSS_MW_FLAG:
				return NET_GROSS_MW_FLAG_EDEFAULT == null ? netGrossMWFlag != null : !NET_GROSS_MW_FLAG_EDEFAULT.equals(netGrossMWFlag);
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
		result.append(" (netGrossMWFlag: ");
		result.append(netGrossMWFlag);
		result.append(')');
		return result.toString();
	}

} //HeatRateCurveImpl