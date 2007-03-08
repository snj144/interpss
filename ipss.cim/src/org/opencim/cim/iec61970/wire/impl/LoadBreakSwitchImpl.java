/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoadBreakSwitchImpl.java,v 1.1 2007/03/02 14:00:57 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.wire.LoadBreakSwitch;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.real.CurrentFlow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Load Break Switch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.LoadBreakSwitchImpl#getAmpRating <em>Amp Rating</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoadBreakSwitchImpl extends SwitchImpl implements LoadBreakSwitch {
	/**
	 * The default value of the '{@link #getAmpRating() <em>Amp Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmpRating()
	 * @generated
	 * @ordered
	 */
	protected static final CurrentFlow AMP_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAmpRating() <em>Amp Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmpRating()
	 * @generated
	 * @ordered
	 */
	protected CurrentFlow ampRating = AMP_RATING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoadBreakSwitchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.LOAD_BREAK_SWITCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurrentFlow getAmpRating() {
		return ampRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAmpRating(CurrentFlow newAmpRating) {
		CurrentFlow oldAmpRating = ampRating;
		ampRating = newAmpRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.LOAD_BREAK_SWITCH__AMP_RATING, oldAmpRating, ampRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WirePackage.LOAD_BREAK_SWITCH__AMP_RATING:
				return getAmpRating();
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
			case WirePackage.LOAD_BREAK_SWITCH__AMP_RATING:
				setAmpRating((CurrentFlow)newValue);
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
			case WirePackage.LOAD_BREAK_SWITCH__AMP_RATING:
				setAmpRating(AMP_RATING_EDEFAULT);
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
			case WirePackage.LOAD_BREAK_SWITCH__AMP_RATING:
				return AMP_RATING_EDEFAULT == null ? ampRating != null : !AMP_RATING_EDEFAULT.equals(ampRating);
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
		result.append(" (ampRating: ");
		result.append(ampRating);
		result.append(')');
		return result.toString();
	}

} //LoadBreakSwitchImpl