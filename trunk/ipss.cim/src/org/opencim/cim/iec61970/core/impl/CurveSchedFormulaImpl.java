/**
 * <copyright>
 * </copyright>
 *
 * $Id: CurveSchedFormulaImpl.java,v 1.2 2007/03/05 04:50:40 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.CurveSchedFormula;

import org.opencim.cim.iec61970.core.CurveSchedule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Curve Sched Formula</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveSchedFormulaImpl#getXLowerBound <em>XLower Bound</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveSchedFormulaImpl#getXUpperBound <em>XUpper Bound</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveSchedFormulaImpl#getYFunction <em>YFunction</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveSchedFormulaImpl#getCurveSchedule <em>Curve Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CurveSchedFormulaImpl extends NamingImpl implements CurveSchedFormula {
	/**
	 * The default value of the '{@link #getXLowerBound() <em>XLower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXLowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final Object XLOWER_BOUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXLowerBound() <em>XLower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXLowerBound()
	 * @generated
	 * @ordered
	 */
	protected Object xLowerBound = XLOWER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getXUpperBound() <em>XUpper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXUpperBound()
	 * @generated
	 * @ordered
	 */
	protected static final Object XUPPER_BOUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXUpperBound() <em>XUpper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXUpperBound()
	 * @generated
	 * @ordered
	 */
	protected Object xUpperBound = XUPPER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getYFunction() <em>YFunction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYFunction()
	 * @generated
	 * @ordered
	 */
	protected static final String YFUNCTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getYFunction() <em>YFunction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYFunction()
	 * @generated
	 * @ordered
	 */
	protected String yFunction = YFUNCTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CurveSchedFormulaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.CURVE_SCHED_FORMULA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getXLowerBound() {
		return xLowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXLowerBound(Object newXLowerBound) {
		Object oldXLowerBound = xLowerBound;
		xLowerBound = newXLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHED_FORMULA__XLOWER_BOUND, oldXLowerBound, xLowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getXUpperBound() {
		return xUpperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXUpperBound(Object newXUpperBound) {
		Object oldXUpperBound = xUpperBound;
		xUpperBound = newXUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHED_FORMULA__XUPPER_BOUND, oldXUpperBound, xUpperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYFunction() {
		return yFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYFunction(String newYFunction) {
		String oldYFunction = yFunction;
		yFunction = newYFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHED_FORMULA__YFUNCTION, oldYFunction, yFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurveSchedule getCurveSchedule() {
		if (eContainerFeatureID != CorePackage.CURVE_SCHED_FORMULA__CURVE_SCHEDULE) return null;
		return (CurveSchedule)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCurveSchedule(CurveSchedule newCurveSchedule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCurveSchedule, CorePackage.CURVE_SCHED_FORMULA__CURVE_SCHEDULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveSchedule(CurveSchedule newCurveSchedule) {
		if (newCurveSchedule != eInternalContainer() || (eContainerFeatureID != CorePackage.CURVE_SCHED_FORMULA__CURVE_SCHEDULE && newCurveSchedule != null)) {
			if (EcoreUtil.isAncestor(this, newCurveSchedule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCurveSchedule != null)
				msgs = ((InternalEObject)newCurveSchedule).eInverseAdd(this, CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA, CurveSchedule.class, msgs);
			msgs = basicSetCurveSchedule(newCurveSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHED_FORMULA__CURVE_SCHEDULE, newCurveSchedule, newCurveSchedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.CURVE_SCHED_FORMULA__CURVE_SCHEDULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCurveSchedule((CurveSchedule)otherEnd, msgs);
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
			case CorePackage.CURVE_SCHED_FORMULA__CURVE_SCHEDULE:
				return basicSetCurveSchedule(null, msgs);
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
			case CorePackage.CURVE_SCHED_FORMULA__CURVE_SCHEDULE:
				return eInternalContainer().eInverseRemove(this, CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA, CurveSchedule.class, msgs);
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
			case CorePackage.CURVE_SCHED_FORMULA__XLOWER_BOUND:
				return getXLowerBound();
			case CorePackage.CURVE_SCHED_FORMULA__XUPPER_BOUND:
				return getXUpperBound();
			case CorePackage.CURVE_SCHED_FORMULA__YFUNCTION:
				return getYFunction();
			case CorePackage.CURVE_SCHED_FORMULA__CURVE_SCHEDULE:
				return getCurveSchedule();
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
			case CorePackage.CURVE_SCHED_FORMULA__XLOWER_BOUND:
				setXLowerBound((Object)newValue);
				return;
			case CorePackage.CURVE_SCHED_FORMULA__XUPPER_BOUND:
				setXUpperBound((Object)newValue);
				return;
			case CorePackage.CURVE_SCHED_FORMULA__YFUNCTION:
				setYFunction((String)newValue);
				return;
			case CorePackage.CURVE_SCHED_FORMULA__CURVE_SCHEDULE:
				setCurveSchedule((CurveSchedule)newValue);
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
			case CorePackage.CURVE_SCHED_FORMULA__XLOWER_BOUND:
				setXLowerBound(XLOWER_BOUND_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHED_FORMULA__XUPPER_BOUND:
				setXUpperBound(XUPPER_BOUND_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHED_FORMULA__YFUNCTION:
				setYFunction(YFUNCTION_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHED_FORMULA__CURVE_SCHEDULE:
				setCurveSchedule((CurveSchedule)null);
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
			case CorePackage.CURVE_SCHED_FORMULA__XLOWER_BOUND:
				return XLOWER_BOUND_EDEFAULT == null ? xLowerBound != null : !XLOWER_BOUND_EDEFAULT.equals(xLowerBound);
			case CorePackage.CURVE_SCHED_FORMULA__XUPPER_BOUND:
				return XUPPER_BOUND_EDEFAULT == null ? xUpperBound != null : !XUPPER_BOUND_EDEFAULT.equals(xUpperBound);
			case CorePackage.CURVE_SCHED_FORMULA__YFUNCTION:
				return YFUNCTION_EDEFAULT == null ? yFunction != null : !YFUNCTION_EDEFAULT.equals(yFunction);
			case CorePackage.CURVE_SCHED_FORMULA__CURVE_SCHEDULE:
				return getCurveSchedule() != null;
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
		result.append(" (xLowerBound: ");
		result.append(xLowerBound);
		result.append(", xUpperBound: ");
		result.append(xUpperBound);
		result.append(", yFunction: ");
		result.append(yFunction);
		result.append(')');
		return result.toString();
	}

} //CurveSchedFormulaImpl