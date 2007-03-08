/**
 * <copyright>
 * </copyright>
 *
 * $Id: DCLineSegmentImpl.java,v 1.3 2007/03/08 00:05:30 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.opencim.cim.iec61970.wire.DCLineSegment;
import org.opencim.cim.iec61970.wire.Line;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.real.Inductance;
import org.opencim.datatype.real.Resistance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DC Line Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.DCLineSegmentImpl#getDcSegmentInductance <em>Dc Segment Inductance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.DCLineSegmentImpl#getDcSegmentResistance <em>Dc Segment Resistance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.DCLineSegmentImpl#getLine <em>Line</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DCLineSegmentImpl extends ConductorImpl implements DCLineSegment {
	/**
	 * The default value of the '{@link #getDcSegmentInductance() <em>Dc Segment Inductance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDcSegmentInductance()
	 * @generated
	 * @ordered
	 */
	protected static final Inductance DC_SEGMENT_INDUCTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDcSegmentInductance() <em>Dc Segment Inductance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDcSegmentInductance()
	 * @generated
	 * @ordered
	 */
	protected Inductance dcSegmentInductance = DC_SEGMENT_INDUCTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDcSegmentResistance() <em>Dc Segment Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDcSegmentResistance()
	 * @generated
	 * @ordered
	 */
	protected static final Resistance DC_SEGMENT_RESISTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDcSegmentResistance() <em>Dc Segment Resistance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDcSegmentResistance()
	 * @generated
	 * @ordered
	 */
	protected Resistance dcSegmentResistance = DC_SEGMENT_RESISTANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DCLineSegmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.DC_LINE_SEGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inductance getDcSegmentInductance() {
		return dcSegmentInductance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDcSegmentInductance(Inductance newDcSegmentInductance) {
		Inductance oldDcSegmentInductance = dcSegmentInductance;
		dcSegmentInductance = newDcSegmentInductance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.DC_LINE_SEGMENT__DC_SEGMENT_INDUCTANCE, oldDcSegmentInductance, dcSegmentInductance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance getDcSegmentResistance() {
		return dcSegmentResistance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDcSegmentResistance(Resistance newDcSegmentResistance) {
		Resistance oldDcSegmentResistance = dcSegmentResistance;
		dcSegmentResistance = newDcSegmentResistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.DC_LINE_SEGMENT__DC_SEGMENT_RESISTANCE, oldDcSegmentResistance, dcSegmentResistance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Line getLine() {
		if (eContainerFeatureID != WirePackage.DC_LINE_SEGMENT__LINE) return null;
		return (Line)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLine(Line newLine, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLine, WirePackage.DC_LINE_SEGMENT__LINE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLine(Line newLine) {
		if (newLine != eInternalContainer() || (eContainerFeatureID != WirePackage.DC_LINE_SEGMENT__LINE && newLine != null)) {
			if (EcoreUtil.isAncestor(this, newLine))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLine != null)
				msgs = ((InternalEObject)newLine).eInverseAdd(this, WirePackage.LINE__DC_LINE_SEGMENTS, Line.class, msgs);
			msgs = basicSetLine(newLine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.DC_LINE_SEGMENT__LINE, newLine, newLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.DC_LINE_SEGMENT__LINE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLine((Line)otherEnd, msgs);
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
			case WirePackage.DC_LINE_SEGMENT__LINE:
				return basicSetLine(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case WirePackage.DC_LINE_SEGMENT__LINE:
				return eInternalContainer().eInverseRemove(this, WirePackage.LINE__DC_LINE_SEGMENTS, Line.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WirePackage.DC_LINE_SEGMENT__DC_SEGMENT_INDUCTANCE:
				return getDcSegmentInductance();
			case WirePackage.DC_LINE_SEGMENT__DC_SEGMENT_RESISTANCE:
				return getDcSegmentResistance();
			case WirePackage.DC_LINE_SEGMENT__LINE:
				return getLine();
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
			case WirePackage.DC_LINE_SEGMENT__DC_SEGMENT_INDUCTANCE:
				setDcSegmentInductance((Inductance)newValue);
				return;
			case WirePackage.DC_LINE_SEGMENT__DC_SEGMENT_RESISTANCE:
				setDcSegmentResistance((Resistance)newValue);
				return;
			case WirePackage.DC_LINE_SEGMENT__LINE:
				setLine((Line)newValue);
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
			case WirePackage.DC_LINE_SEGMENT__DC_SEGMENT_INDUCTANCE:
				setDcSegmentInductance(DC_SEGMENT_INDUCTANCE_EDEFAULT);
				return;
			case WirePackage.DC_LINE_SEGMENT__DC_SEGMENT_RESISTANCE:
				setDcSegmentResistance(DC_SEGMENT_RESISTANCE_EDEFAULT);
				return;
			case WirePackage.DC_LINE_SEGMENT__LINE:
				setLine((Line)null);
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
			case WirePackage.DC_LINE_SEGMENT__DC_SEGMENT_INDUCTANCE:
				return DC_SEGMENT_INDUCTANCE_EDEFAULT == null ? dcSegmentInductance != null : !DC_SEGMENT_INDUCTANCE_EDEFAULT.equals(dcSegmentInductance);
			case WirePackage.DC_LINE_SEGMENT__DC_SEGMENT_RESISTANCE:
				return DC_SEGMENT_RESISTANCE_EDEFAULT == null ? dcSegmentResistance != null : !DC_SEGMENT_RESISTANCE_EDEFAULT.equals(dcSegmentResistance);
			case WirePackage.DC_LINE_SEGMENT__LINE:
				return getLine() != null;
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
		result.append(" (dcSegmentInductance: ");
		result.append(dcSegmentInductance);
		result.append(", dcSegmentResistance: ");
		result.append(dcSegmentResistance);
		result.append(')');
		return result.toString();
	}

} //DCLineSegmentImpl