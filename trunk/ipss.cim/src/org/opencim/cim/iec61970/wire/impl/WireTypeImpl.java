/**
 * <copyright>
 * </copyright>
 *
 * $Id: WireTypeImpl.java,v 1.1 2007/03/02 14:00:57 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.impl.NamingImpl;

import org.opencim.cim.iec61970.wire.WireArrangement;
import org.opencim.cim.iec61970.wire.WirePackage;
import org.opencim.cim.iec61970.wire.WireType;

import org.opencim.datatype.integer.Counter;

import org.opencim.datatype.real.CurrentFlow;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.ShortLength;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WireTypeImpl#getPhaseConductorCount <em>Phase Conductor Count</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WireTypeImpl#getPhaseConductorSpacing <em>Phase Conductor Spacing</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WireTypeImpl#getAmpRating <em>Amp Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WireTypeImpl#getGMR <em>GMR</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WireTypeImpl#getRadius <em>Radius</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WireTypeImpl#getResistance <em>Resistance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WireTypeImpl#getWireArrangements <em>Wire Arrangements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WireTypeImpl extends NamingImpl implements WireType {
	/**
	 * The default value of the '{@link #getPhaseConductorCount() <em>Phase Conductor Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhaseConductorCount()
	 * @generated
	 * @ordered
	 */
	protected static final Counter PHASE_CONDUCTOR_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhaseConductorCount() <em>Phase Conductor Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhaseConductorCount()
	 * @generated
	 * @ordered
	 */
	protected Counter phaseConductorCount = PHASE_CONDUCTOR_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPhaseConductorSpacing() <em>Phase Conductor Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhaseConductorSpacing()
	 * @generated
	 * @ordered
	 */
	protected static final ShortLength PHASE_CONDUCTOR_SPACING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhaseConductorSpacing() <em>Phase Conductor Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhaseConductorSpacing()
	 * @generated
	 * @ordered
	 */
	protected ShortLength phaseConductorSpacing = PHASE_CONDUCTOR_SPACING_EDEFAULT;

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
	 * The default value of the '{@link #getGMR() <em>GMR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGMR()
	 * @generated
	 * @ordered
	 */
	protected static final ShortLength GMR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGMR() <em>GMR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGMR()
	 * @generated
	 * @ordered
	 */
	protected ShortLength gMR = GMR_EDEFAULT;

	/**
	 * The default value of the '{@link #getRadius() <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRadius()
	 * @generated
	 * @ordered
	 */
	protected static final ShortLength RADIUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRadius() <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRadius()
	 * @generated
	 * @ordered
	 */
	protected ShortLength radius = RADIUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getResistance() <em>Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResistance()
	 * @generated
	 * @ordered
	 */
	protected static final Resistance RESISTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResistance() <em>Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResistance()
	 * @generated
	 * @ordered
	 */
	protected Resistance resistance = RESISTANCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWireArrangements() <em>Wire Arrangements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWireArrangements()
	 * @generated
	 * @ordered
	 */
	protected EList wireArrangements = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WireTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.WIRE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Counter getPhaseConductorCount() {
		return phaseConductorCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhaseConductorCount(Counter newPhaseConductorCount) {
		Counter oldPhaseConductorCount = phaseConductorCount;
		phaseConductorCount = newPhaseConductorCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WIRE_TYPE__PHASE_CONDUCTOR_COUNT, oldPhaseConductorCount, phaseConductorCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShortLength getPhaseConductorSpacing() {
		return phaseConductorSpacing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhaseConductorSpacing(ShortLength newPhaseConductorSpacing) {
		ShortLength oldPhaseConductorSpacing = phaseConductorSpacing;
		phaseConductorSpacing = newPhaseConductorSpacing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WIRE_TYPE__PHASE_CONDUCTOR_SPACING, oldPhaseConductorSpacing, phaseConductorSpacing));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WIRE_TYPE__AMP_RATING, oldAmpRating, ampRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShortLength getGMR() {
		return gMR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGMR(ShortLength newGMR) {
		ShortLength oldGMR = gMR;
		gMR = newGMR;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WIRE_TYPE__GMR, oldGMR, gMR));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShortLength getRadius() {
		return radius;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRadius(ShortLength newRadius) {
		ShortLength oldRadius = radius;
		radius = newRadius;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WIRE_TYPE__RADIUS, oldRadius, radius));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance getResistance() {
		return resistance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResistance(Resistance newResistance) {
		Resistance oldResistance = resistance;
		resistance = newResistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WIRE_TYPE__RESISTANCE, oldResistance, resistance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getWireArrangements() {
		if (wireArrangements == null) {
			wireArrangements = new EObjectWithInverseResolvingEList(WireArrangement.class, this, WirePackage.WIRE_TYPE__WIRE_ARRANGEMENTS, WirePackage.WIRE_ARRANGEMENT__WIRE_TYPE);
		}
		return wireArrangements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.WIRE_TYPE__WIRE_ARRANGEMENTS:
				return ((InternalEList)getWireArrangements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.WIRE_TYPE__WIRE_ARRANGEMENTS:
				return ((InternalEList)getWireArrangements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WirePackage.WIRE_TYPE__PHASE_CONDUCTOR_COUNT:
				return getPhaseConductorCount();
			case WirePackage.WIRE_TYPE__PHASE_CONDUCTOR_SPACING:
				return getPhaseConductorSpacing();
			case WirePackage.WIRE_TYPE__AMP_RATING:
				return getAmpRating();
			case WirePackage.WIRE_TYPE__GMR:
				return getGMR();
			case WirePackage.WIRE_TYPE__RADIUS:
				return getRadius();
			case WirePackage.WIRE_TYPE__RESISTANCE:
				return getResistance();
			case WirePackage.WIRE_TYPE__WIRE_ARRANGEMENTS:
				return getWireArrangements();
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
			case WirePackage.WIRE_TYPE__PHASE_CONDUCTOR_COUNT:
				setPhaseConductorCount((Counter)newValue);
				return;
			case WirePackage.WIRE_TYPE__PHASE_CONDUCTOR_SPACING:
				setPhaseConductorSpacing((ShortLength)newValue);
				return;
			case WirePackage.WIRE_TYPE__AMP_RATING:
				setAmpRating((CurrentFlow)newValue);
				return;
			case WirePackage.WIRE_TYPE__GMR:
				setGMR((ShortLength)newValue);
				return;
			case WirePackage.WIRE_TYPE__RADIUS:
				setRadius((ShortLength)newValue);
				return;
			case WirePackage.WIRE_TYPE__RESISTANCE:
				setResistance((Resistance)newValue);
				return;
			case WirePackage.WIRE_TYPE__WIRE_ARRANGEMENTS:
				getWireArrangements().clear();
				getWireArrangements().addAll((Collection)newValue);
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
			case WirePackage.WIRE_TYPE__PHASE_CONDUCTOR_COUNT:
				setPhaseConductorCount(PHASE_CONDUCTOR_COUNT_EDEFAULT);
				return;
			case WirePackage.WIRE_TYPE__PHASE_CONDUCTOR_SPACING:
				setPhaseConductorSpacing(PHASE_CONDUCTOR_SPACING_EDEFAULT);
				return;
			case WirePackage.WIRE_TYPE__AMP_RATING:
				setAmpRating(AMP_RATING_EDEFAULT);
				return;
			case WirePackage.WIRE_TYPE__GMR:
				setGMR(GMR_EDEFAULT);
				return;
			case WirePackage.WIRE_TYPE__RADIUS:
				setRadius(RADIUS_EDEFAULT);
				return;
			case WirePackage.WIRE_TYPE__RESISTANCE:
				setResistance(RESISTANCE_EDEFAULT);
				return;
			case WirePackage.WIRE_TYPE__WIRE_ARRANGEMENTS:
				getWireArrangements().clear();
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
			case WirePackage.WIRE_TYPE__PHASE_CONDUCTOR_COUNT:
				return PHASE_CONDUCTOR_COUNT_EDEFAULT == null ? phaseConductorCount != null : !PHASE_CONDUCTOR_COUNT_EDEFAULT.equals(phaseConductorCount);
			case WirePackage.WIRE_TYPE__PHASE_CONDUCTOR_SPACING:
				return PHASE_CONDUCTOR_SPACING_EDEFAULT == null ? phaseConductorSpacing != null : !PHASE_CONDUCTOR_SPACING_EDEFAULT.equals(phaseConductorSpacing);
			case WirePackage.WIRE_TYPE__AMP_RATING:
				return AMP_RATING_EDEFAULT == null ? ampRating != null : !AMP_RATING_EDEFAULT.equals(ampRating);
			case WirePackage.WIRE_TYPE__GMR:
				return GMR_EDEFAULT == null ? gMR != null : !GMR_EDEFAULT.equals(gMR);
			case WirePackage.WIRE_TYPE__RADIUS:
				return RADIUS_EDEFAULT == null ? radius != null : !RADIUS_EDEFAULT.equals(radius);
			case WirePackage.WIRE_TYPE__RESISTANCE:
				return RESISTANCE_EDEFAULT == null ? resistance != null : !RESISTANCE_EDEFAULT.equals(resistance);
			case WirePackage.WIRE_TYPE__WIRE_ARRANGEMENTS:
				return wireArrangements != null && !wireArrangements.isEmpty();
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
		result.append(" (phaseConductorCount: ");
		result.append(phaseConductorCount);
		result.append(", phaseConductorSpacing: ");
		result.append(phaseConductorSpacing);
		result.append(", ampRating: ");
		result.append(ampRating);
		result.append(", gMR: ");
		result.append(gMR);
		result.append(", radius: ");
		result.append(radius);
		result.append(", resistance: ");
		result.append(resistance);
		result.append(')');
		return result.toString();
	}

} //WireTypeImpl