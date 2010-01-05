/**
 * <copyright>
 * </copyright>
 *
 * $Id: CurveSchedDataImpl.java,v 1.2 2007/03/05 04:50:40 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.CurveSchedData;

import org.opencim.cim.iec61970.core.CurveSchedule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Curve Sched Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveSchedDataImpl#getRampData <em>Ramp Data</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveSchedDataImpl#getRampDataValue <em>Ramp Data Value</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveSchedDataImpl#getXAxisData <em>XAxis Data</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveSchedDataImpl#getY1AxisData <em>Y1 Axis Data</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveSchedDataImpl#getY2AxisData <em>Y2 Axis Data</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveSchedDataImpl#getCurveSchedule <em>Curve Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CurveSchedDataImpl extends NamingImpl implements CurveSchedData {
	/**
	 * The default value of the '{@link #getRampData() <em>Ramp Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRampData()
	 * @generated
	 * @ordered
	 */
	protected static final Object RAMP_DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRampData() <em>Ramp Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRampData()
	 * @generated
	 * @ordered
	 */
	protected Object rampData = RAMP_DATA_EDEFAULT;

	/**
	 * The default value of the '{@link #getRampDataValue() <em>Ramp Data Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRampDataValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object RAMP_DATA_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRampDataValue() <em>Ramp Data Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRampDataValue()
	 * @generated
	 * @ordered
	 */
	protected Object rampDataValue = RAMP_DATA_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getXAxisData() <em>XAxis Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXAxisData()
	 * @generated
	 * @ordered
	 */
	protected static final Object XAXIS_DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXAxisData() <em>XAxis Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXAxisData()
	 * @generated
	 * @ordered
	 */
	protected Object xAxisData = XAXIS_DATA_EDEFAULT;

	/**
	 * The default value of the '{@link #getY1AxisData() <em>Y1 Axis Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY1AxisData()
	 * @generated
	 * @ordered
	 */
	protected static final Object Y1_AXIS_DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getY1AxisData() <em>Y1 Axis Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY1AxisData()
	 * @generated
	 * @ordered
	 */
	protected Object y1AxisData = Y1_AXIS_DATA_EDEFAULT;

	/**
	 * The default value of the '{@link #getY2AxisData() <em>Y2 Axis Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY2AxisData()
	 * @generated
	 * @ordered
	 */
	protected static final Object Y2_AXIS_DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getY2AxisData() <em>Y2 Axis Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY2AxisData()
	 * @generated
	 * @ordered
	 */
	protected Object y2AxisData = Y2_AXIS_DATA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CurveSchedDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.CURVE_SCHED_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRampData() {
		return rampData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRampData(Object newRampData) {
		Object oldRampData = rampData;
		rampData = newRampData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHED_DATA__RAMP_DATA, oldRampData, rampData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRampDataValue() {
		return rampDataValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRampDataValue(Object newRampDataValue) {
		Object oldRampDataValue = rampDataValue;
		rampDataValue = newRampDataValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHED_DATA__RAMP_DATA_VALUE, oldRampDataValue, rampDataValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getXAxisData() {
		return xAxisData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXAxisData(Object newXAxisData) {
		Object oldXAxisData = xAxisData;
		xAxisData = newXAxisData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHED_DATA__XAXIS_DATA, oldXAxisData, xAxisData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getY1AxisData() {
		return y1AxisData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY1AxisData(Object newY1AxisData) {
		Object oldY1AxisData = y1AxisData;
		y1AxisData = newY1AxisData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHED_DATA__Y1_AXIS_DATA, oldY1AxisData, y1AxisData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getY2AxisData() {
		return y2AxisData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY2AxisData(Object newY2AxisData) {
		Object oldY2AxisData = y2AxisData;
		y2AxisData = newY2AxisData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHED_DATA__Y2_AXIS_DATA, oldY2AxisData, y2AxisData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurveSchedule getCurveSchedule() {
		if (eContainerFeatureID != CorePackage.CURVE_SCHED_DATA__CURVE_SCHEDULE) return null;
		return (CurveSchedule)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCurveSchedule(CurveSchedule newCurveSchedule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCurveSchedule, CorePackage.CURVE_SCHED_DATA__CURVE_SCHEDULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveSchedule(CurveSchedule newCurveSchedule) {
		if (newCurveSchedule != eInternalContainer() || (eContainerFeatureID != CorePackage.CURVE_SCHED_DATA__CURVE_SCHEDULE && newCurveSchedule != null)) {
			if (EcoreUtil.isAncestor(this, newCurveSchedule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCurveSchedule != null)
				msgs = ((InternalEObject)newCurveSchedule).eInverseAdd(this, CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS, CurveSchedule.class, msgs);
			msgs = basicSetCurveSchedule(newCurveSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHED_DATA__CURVE_SCHEDULE, newCurveSchedule, newCurveSchedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.CURVE_SCHED_DATA__CURVE_SCHEDULE:
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
			case CorePackage.CURVE_SCHED_DATA__CURVE_SCHEDULE:
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
			case CorePackage.CURVE_SCHED_DATA__CURVE_SCHEDULE:
				return eInternalContainer().eInverseRemove(this, CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS, CurveSchedule.class, msgs);
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
			case CorePackage.CURVE_SCHED_DATA__RAMP_DATA:
				return getRampData();
			case CorePackage.CURVE_SCHED_DATA__RAMP_DATA_VALUE:
				return getRampDataValue();
			case CorePackage.CURVE_SCHED_DATA__XAXIS_DATA:
				return getXAxisData();
			case CorePackage.CURVE_SCHED_DATA__Y1_AXIS_DATA:
				return getY1AxisData();
			case CorePackage.CURVE_SCHED_DATA__Y2_AXIS_DATA:
				return getY2AxisData();
			case CorePackage.CURVE_SCHED_DATA__CURVE_SCHEDULE:
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
			case CorePackage.CURVE_SCHED_DATA__RAMP_DATA:
				setRampData(newValue);
				return;
			case CorePackage.CURVE_SCHED_DATA__RAMP_DATA_VALUE:
				setRampDataValue(newValue);
				return;
			case CorePackage.CURVE_SCHED_DATA__XAXIS_DATA:
				setXAxisData(newValue);
				return;
			case CorePackage.CURVE_SCHED_DATA__Y1_AXIS_DATA:
				setY1AxisData(newValue);
				return;
			case CorePackage.CURVE_SCHED_DATA__Y2_AXIS_DATA:
				setY2AxisData(newValue);
				return;
			case CorePackage.CURVE_SCHED_DATA__CURVE_SCHEDULE:
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
			case CorePackage.CURVE_SCHED_DATA__RAMP_DATA:
				setRampData(RAMP_DATA_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHED_DATA__RAMP_DATA_VALUE:
				setRampDataValue(RAMP_DATA_VALUE_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHED_DATA__XAXIS_DATA:
				setXAxisData(XAXIS_DATA_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHED_DATA__Y1_AXIS_DATA:
				setY1AxisData(Y1_AXIS_DATA_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHED_DATA__Y2_AXIS_DATA:
				setY2AxisData(Y2_AXIS_DATA_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHED_DATA__CURVE_SCHEDULE:
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
			case CorePackage.CURVE_SCHED_DATA__RAMP_DATA:
				return RAMP_DATA_EDEFAULT == null ? rampData != null : !RAMP_DATA_EDEFAULT.equals(rampData);
			case CorePackage.CURVE_SCHED_DATA__RAMP_DATA_VALUE:
				return RAMP_DATA_VALUE_EDEFAULT == null ? rampDataValue != null : !RAMP_DATA_VALUE_EDEFAULT.equals(rampDataValue);
			case CorePackage.CURVE_SCHED_DATA__XAXIS_DATA:
				return XAXIS_DATA_EDEFAULT == null ? xAxisData != null : !XAXIS_DATA_EDEFAULT.equals(xAxisData);
			case CorePackage.CURVE_SCHED_DATA__Y1_AXIS_DATA:
				return Y1_AXIS_DATA_EDEFAULT == null ? y1AxisData != null : !Y1_AXIS_DATA_EDEFAULT.equals(y1AxisData);
			case CorePackage.CURVE_SCHED_DATA__Y2_AXIS_DATA:
				return Y2_AXIS_DATA_EDEFAULT == null ? y2AxisData != null : !Y2_AXIS_DATA_EDEFAULT.equals(y2AxisData);
			case CorePackage.CURVE_SCHED_DATA__CURVE_SCHEDULE:
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
		result.append(" (rampData: ");
		result.append(rampData);
		result.append(", rampDataValue: ");
		result.append(rampDataValue);
		result.append(", xAxisData: ");
		result.append(xAxisData);
		result.append(", y1AxisData: ");
		result.append(y1AxisData);
		result.append(", y2AxisData: ");
		result.append(y2AxisData);
		result.append(')');
		return result.toString();
	}

} //CurveSchedDataImpl