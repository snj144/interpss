/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConductorImpl.java,v 1.2 2007/03/08 00:05:30 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.ConductingEquipmentImpl;

import org.opencim.cim.iec61970.wire.Conductor;
import org.opencim.cim.iec61970.wire.ConductorType;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.real.Conductance;
import org.opencim.datatype.real.LongLength;
import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.Susceptance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conductor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.ConductorImpl#getB0ch <em>B0ch</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.ConductorImpl#getBch <em>Bch</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.ConductorImpl#getG0ch <em>G0ch</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.ConductorImpl#getGch <em>Gch</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.ConductorImpl#getLength <em>Length</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.ConductorImpl#getR <em>R</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.ConductorImpl#getR0 <em>R0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.ConductorImpl#getX <em>X</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.ConductorImpl#getX0 <em>X0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.ConductorImpl#getConductorType <em>Conductor Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConductorImpl extends ConductingEquipmentImpl implements Conductor {
	/**
	 * The default value of the '{@link #getB0ch() <em>B0ch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB0ch()
	 * @generated
	 * @ordered
	 */
	protected static final Susceptance B0CH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getB0ch() <em>B0ch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB0ch()
	 * @generated
	 * @ordered
	 */
	protected Susceptance b0ch = B0CH_EDEFAULT;

	/**
	 * The default value of the '{@link #getBch() <em>Bch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBch()
	 * @generated
	 * @ordered
	 */
	protected static final Susceptance BCH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBch() <em>Bch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBch()
	 * @generated
	 * @ordered
	 */
	protected Susceptance bch = BCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getG0ch() <em>G0ch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getG0ch()
	 * @generated
	 * @ordered
	 */
	protected static final Conductance G0CH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getG0ch() <em>G0ch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getG0ch()
	 * @generated
	 * @ordered
	 */
	protected Conductance g0ch = G0CH_EDEFAULT;

	/**
	 * The default value of the '{@link #getGch() <em>Gch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGch()
	 * @generated
	 * @ordered
	 */
	protected static final Conductance GCH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGch() <em>Gch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGch()
	 * @generated
	 * @ordered
	 */
	protected Conductance gch = GCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final LongLength LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected LongLength length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getR() <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR()
	 * @generated
	 * @ordered
	 */
	protected static final Resistance R_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getR() <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR()
	 * @generated
	 * @ordered
	 */
	protected Resistance r = R_EDEFAULT;

	/**
	 * The default value of the '{@link #getR0() <em>R0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR0()
	 * @generated
	 * @ordered
	 */
	protected static final Resistance R0_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getR0() <em>R0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR0()
	 * @generated
	 * @ordered
	 */
	protected Resistance r0 = R0_EDEFAULT;

	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance X_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected Reactance x = X_EDEFAULT;

	/**
	 * The default value of the '{@link #getX0() <em>X0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX0()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance X0_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getX0() <em>X0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX0()
	 * @generated
	 * @ordered
	 */
	protected Reactance x0 = X0_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConductorType() <em>Conductor Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConductorType()
	 * @generated
	 * @ordered
	 */
	protected ConductorType conductorType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConductorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.CONDUCTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Susceptance getB0ch() {
		return b0ch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setB0ch(Susceptance newB0ch) {
		Susceptance oldB0ch = b0ch;
		b0ch = newB0ch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.CONDUCTOR__B0CH, oldB0ch, b0ch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Susceptance getBch() {
		return bch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBch(Susceptance newBch) {
		Susceptance oldBch = bch;
		bch = newBch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.CONDUCTOR__BCH, oldBch, bch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Conductance getG0ch() {
		return g0ch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setG0ch(Conductance newG0ch) {
		Conductance oldG0ch = g0ch;
		g0ch = newG0ch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.CONDUCTOR__G0CH, oldG0ch, g0ch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Conductance getGch() {
		return gch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGch(Conductance newGch) {
		Conductance oldGch = gch;
		gch = newGch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.CONDUCTOR__GCH, oldGch, gch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongLength getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(LongLength newLength) {
		LongLength oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.CONDUCTOR__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance getR() {
		return r;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setR(Resistance newR) {
		Resistance oldR = r;
		r = newR;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.CONDUCTOR__R, oldR, r));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance getR0() {
		return r0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setR0(Resistance newR0) {
		Resistance oldR0 = r0;
		r0 = newR0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.CONDUCTOR__R0, oldR0, r0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(Reactance newX) {
		Reactance oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.CONDUCTOR__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getX0() {
		return x0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX0(Reactance newX0) {
		Reactance oldX0 = x0;
		x0 = newX0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.CONDUCTOR__X0, oldX0, x0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConductorType getConductorType() {
		if (conductorType != null && conductorType.eIsProxy()) {
			InternalEObject oldConductorType = (InternalEObject)conductorType;
			conductorType = (ConductorType)eResolveProxy(oldConductorType);
			if (conductorType != oldConductorType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WirePackage.CONDUCTOR__CONDUCTOR_TYPE, oldConductorType, conductorType));
			}
		}
		return conductorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConductorType basicGetConductorType() {
		return conductorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConductorType(ConductorType newConductorType, NotificationChain msgs) {
		ConductorType oldConductorType = conductorType;
		conductorType = newConductorType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WirePackage.CONDUCTOR__CONDUCTOR_TYPE, oldConductorType, newConductorType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConductorType(ConductorType newConductorType) {
		if (newConductorType != conductorType) {
			NotificationChain msgs = null;
			if (conductorType != null)
				msgs = ((InternalEObject)conductorType).eInverseRemove(this, WirePackage.CONDUCTOR_TYPE__CONDUCTORS, ConductorType.class, msgs);
			if (newConductorType != null)
				msgs = ((InternalEObject)newConductorType).eInverseAdd(this, WirePackage.CONDUCTOR_TYPE__CONDUCTORS, ConductorType.class, msgs);
			msgs = basicSetConductorType(newConductorType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.CONDUCTOR__CONDUCTOR_TYPE, newConductorType, newConductorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.CONDUCTOR__CONDUCTOR_TYPE:
				if (conductorType != null)
					msgs = ((InternalEObject)conductorType).eInverseRemove(this, WirePackage.CONDUCTOR_TYPE__CONDUCTORS, ConductorType.class, msgs);
				return basicSetConductorType((ConductorType)otherEnd, msgs);
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
			case WirePackage.CONDUCTOR__CONDUCTOR_TYPE:
				return basicSetConductorType(null, msgs);
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
			case WirePackage.CONDUCTOR__B0CH:
				return getB0ch();
			case WirePackage.CONDUCTOR__BCH:
				return getBch();
			case WirePackage.CONDUCTOR__G0CH:
				return getG0ch();
			case WirePackage.CONDUCTOR__GCH:
				return getGch();
			case WirePackage.CONDUCTOR__LENGTH:
				return getLength();
			case WirePackage.CONDUCTOR__R:
				return getR();
			case WirePackage.CONDUCTOR__R0:
				return getR0();
			case WirePackage.CONDUCTOR__X:
				return getX();
			case WirePackage.CONDUCTOR__X0:
				return getX0();
			case WirePackage.CONDUCTOR__CONDUCTOR_TYPE:
				if (resolve) return getConductorType();
				return basicGetConductorType();
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
			case WirePackage.CONDUCTOR__B0CH:
				setB0ch((Susceptance)newValue);
				return;
			case WirePackage.CONDUCTOR__BCH:
				setBch((Susceptance)newValue);
				return;
			case WirePackage.CONDUCTOR__G0CH:
				setG0ch((Conductance)newValue);
				return;
			case WirePackage.CONDUCTOR__GCH:
				setGch((Conductance)newValue);
				return;
			case WirePackage.CONDUCTOR__LENGTH:
				setLength((LongLength)newValue);
				return;
			case WirePackage.CONDUCTOR__R:
				setR((Resistance)newValue);
				return;
			case WirePackage.CONDUCTOR__R0:
				setR0((Resistance)newValue);
				return;
			case WirePackage.CONDUCTOR__X:
				setX((Reactance)newValue);
				return;
			case WirePackage.CONDUCTOR__X0:
				setX0((Reactance)newValue);
				return;
			case WirePackage.CONDUCTOR__CONDUCTOR_TYPE:
				setConductorType((ConductorType)newValue);
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
			case WirePackage.CONDUCTOR__B0CH:
				setB0ch(B0CH_EDEFAULT);
				return;
			case WirePackage.CONDUCTOR__BCH:
				setBch(BCH_EDEFAULT);
				return;
			case WirePackage.CONDUCTOR__G0CH:
				setG0ch(G0CH_EDEFAULT);
				return;
			case WirePackage.CONDUCTOR__GCH:
				setGch(GCH_EDEFAULT);
				return;
			case WirePackage.CONDUCTOR__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case WirePackage.CONDUCTOR__R:
				setR(R_EDEFAULT);
				return;
			case WirePackage.CONDUCTOR__R0:
				setR0(R0_EDEFAULT);
				return;
			case WirePackage.CONDUCTOR__X:
				setX(X_EDEFAULT);
				return;
			case WirePackage.CONDUCTOR__X0:
				setX0(X0_EDEFAULT);
				return;
			case WirePackage.CONDUCTOR__CONDUCTOR_TYPE:
				setConductorType((ConductorType)null);
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
			case WirePackage.CONDUCTOR__B0CH:
				return B0CH_EDEFAULT == null ? b0ch != null : !B0CH_EDEFAULT.equals(b0ch);
			case WirePackage.CONDUCTOR__BCH:
				return BCH_EDEFAULT == null ? bch != null : !BCH_EDEFAULT.equals(bch);
			case WirePackage.CONDUCTOR__G0CH:
				return G0CH_EDEFAULT == null ? g0ch != null : !G0CH_EDEFAULT.equals(g0ch);
			case WirePackage.CONDUCTOR__GCH:
				return GCH_EDEFAULT == null ? gch != null : !GCH_EDEFAULT.equals(gch);
			case WirePackage.CONDUCTOR__LENGTH:
				return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
			case WirePackage.CONDUCTOR__R:
				return R_EDEFAULT == null ? r != null : !R_EDEFAULT.equals(r);
			case WirePackage.CONDUCTOR__R0:
				return R0_EDEFAULT == null ? r0 != null : !R0_EDEFAULT.equals(r0);
			case WirePackage.CONDUCTOR__X:
				return X_EDEFAULT == null ? x != null : !X_EDEFAULT.equals(x);
			case WirePackage.CONDUCTOR__X0:
				return X0_EDEFAULT == null ? x0 != null : !X0_EDEFAULT.equals(x0);
			case WirePackage.CONDUCTOR__CONDUCTOR_TYPE:
				return conductorType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString() + "\n");
		result.append(" (b0ch: ");
		result.append(b0ch);
		result.append(", bch: ");
		result.append(bch);
		result.append(", g0ch: ");
		result.append(g0ch);
		result.append(", gch: ");
		result.append(gch);
		result.append(", length: ");
		result.append(length);
		result.append(", r: ");
		result.append(r);
		result.append(", r0: ");
		result.append(r0);
		result.append(", x: ");
		result.append(x);
		result.append(", x0: ");
		result.append(x0);
		result.append(')');
		return result.toString();
	}

} //ConductorImpl