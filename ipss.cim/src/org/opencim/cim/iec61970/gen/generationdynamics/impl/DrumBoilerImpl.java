/**
 * <copyright>
 * </copyright>
 *
 * $Id: DrumBoilerImpl.java,v 1.1 2007/03/02 14:01:14 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.gen.generationdynamics.DrumBoiler;
import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Drum Boiler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.DrumBoilerImpl#getDrumBoilerRating <em>Drum Boiler Rating</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DrumBoilerImpl extends FossilSteamSupplyImpl implements DrumBoiler {
	/**
	 * The default value of the '{@link #getDrumBoilerRating() <em>Drum Boiler Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrumBoilerRating()
	 * @generated
	 * @ordered
	 */
	protected static final Float DRUM_BOILER_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDrumBoilerRating() <em>Drum Boiler Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrumBoilerRating()
	 * @generated
	 * @ordered
	 */
	protected Float drumBoilerRating = DRUM_BOILER_RATING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DrumBoilerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenerationdynamicsPackage.Literals.DRUM_BOILER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getDrumBoilerRating() {
		return drumBoilerRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDrumBoilerRating(Float newDrumBoilerRating) {
		Float oldDrumBoilerRating = drumBoilerRating;
		drumBoilerRating = newDrumBoilerRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.DRUM_BOILER__DRUM_BOILER_RATING, oldDrumBoilerRating, drumBoilerRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenerationdynamicsPackage.DRUM_BOILER__DRUM_BOILER_RATING:
				return getDrumBoilerRating();
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
			case GenerationdynamicsPackage.DRUM_BOILER__DRUM_BOILER_RATING:
				setDrumBoilerRating((Float)newValue);
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
			case GenerationdynamicsPackage.DRUM_BOILER__DRUM_BOILER_RATING:
				setDrumBoilerRating(DRUM_BOILER_RATING_EDEFAULT);
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
			case GenerationdynamicsPackage.DRUM_BOILER__DRUM_BOILER_RATING:
				return DRUM_BOILER_RATING_EDEFAULT == null ? drumBoilerRating != null : !DRUM_BOILER_RATING_EDEFAULT.equals(drumBoilerRating);
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
		result.append(" (drumBoilerRating: ");
		result.append(drumBoilerRating);
		result.append(')');
		return result.toString();
	}

} //DrumBoilerImpl