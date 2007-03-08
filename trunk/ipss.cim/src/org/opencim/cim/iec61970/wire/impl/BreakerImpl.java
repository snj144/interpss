/**
 * <copyright>
 * </copyright>
 *
 * $Id: BreakerImpl.java,v 1.1 2007/03/02 14:00:56 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.wire.Breaker;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.real.CurrentFlow;
import org.opencim.datatype.real.Seconds;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Breaker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.BreakerImpl#getAmpRating <em>Amp Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.BreakerImpl#getInTransitTime <em>In Transit Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BreakerImpl extends SwitchImpl implements Breaker {
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
	 * The default value of the '{@link #getInTransitTime() <em>In Transit Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInTransitTime()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds IN_TRANSIT_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInTransitTime() <em>In Transit Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInTransitTime()
	 * @generated
	 * @ordered
	 */
	protected Seconds inTransitTime = IN_TRANSIT_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BreakerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.BREAKER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.BREAKER__AMP_RATING, oldAmpRating, ampRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getInTransitTime() {
		return inTransitTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInTransitTime(Seconds newInTransitTime) {
		Seconds oldInTransitTime = inTransitTime;
		inTransitTime = newInTransitTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.BREAKER__IN_TRANSIT_TIME, oldInTransitTime, inTransitTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WirePackage.BREAKER__AMP_RATING:
				return getAmpRating();
			case WirePackage.BREAKER__IN_TRANSIT_TIME:
				return getInTransitTime();
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
			case WirePackage.BREAKER__AMP_RATING:
				setAmpRating((CurrentFlow)newValue);
				return;
			case WirePackage.BREAKER__IN_TRANSIT_TIME:
				setInTransitTime((Seconds)newValue);
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
			case WirePackage.BREAKER__AMP_RATING:
				setAmpRating(AMP_RATING_EDEFAULT);
				return;
			case WirePackage.BREAKER__IN_TRANSIT_TIME:
				setInTransitTime(IN_TRANSIT_TIME_EDEFAULT);
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
			case WirePackage.BREAKER__AMP_RATING:
				return AMP_RATING_EDEFAULT == null ? ampRating != null : !AMP_RATING_EDEFAULT.equals(ampRating);
			case WirePackage.BREAKER__IN_TRANSIT_TIME:
				return IN_TRANSIT_TIME_EDEFAULT == null ? inTransitTime != null : !IN_TRANSIT_TIME_EDEFAULT.equals(inTransitTime);
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
		result.append(", inTransitTime: ");
		result.append(inTransitTime);
		result.append(')');
		return result.toString();
	}

} //BreakerImpl