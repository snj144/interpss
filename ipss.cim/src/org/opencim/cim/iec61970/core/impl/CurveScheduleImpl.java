/**
 * <copyright>
 * </copyright>
 *
 * $Id: CurveScheduleImpl.java,v 1.2 2007/03/05 04:50:40 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.CurveSchedData;
import org.opencim.cim.iec61970.core.CurveSchedFormula;
import org.opencim.cim.iec61970.core.CurveSchedule;

import org.opencim.cim.iec61970.domain.AxisQuantity;
import org.opencim.cim.iec61970.domain.CurveStyle;
import org.opencim.cim.iec61970.domain.NumericType;
import org.opencim.cim.iec61970.domain.RampMethod;
import org.opencim.cim.iec61970.domain.RampStartMethod;
import org.opencim.cim.iec61970.domain.RampUnits;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Curve Schedule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveScheduleImpl#getCurveStyle <em>Curve Style</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveScheduleImpl#getRampMethod <em>Ramp Method</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveScheduleImpl#getRampStartMethod <em>Ramp Start Method</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveScheduleImpl#getRampUnits <em>Ramp Units</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveScheduleImpl#getXAxisType <em>XAxis Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveScheduleImpl#getXAxisQuantity <em>XAxis Quantity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveScheduleImpl#getY1AxisQuantity <em>Y1 Axis Quantity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveScheduleImpl#getY2AxisQuantity <em>Y2 Axis Quantity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveScheduleImpl#getYAxisType <em>YAxis Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveScheduleImpl#getCurveScheduleDatas <em>Curve Schedule Datas</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.CurveScheduleImpl#getCurveScheduleFormula <em>Curve Schedule Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CurveScheduleImpl extends NamingImpl implements CurveSchedule {
	/**
	 * The default value of the '{@link #getCurveStyle() <em>Curve Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurveStyle()
	 * @generated
	 * @ordered
	 */
	protected static final CurveStyle CURVE_STYLE_EDEFAULT = CurveStyle.CONSTANT_YVALUE_LITERAL;

	/**
	 * The cached value of the '{@link #getCurveStyle() <em>Curve Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurveStyle()
	 * @generated
	 * @ordered
	 */
	protected CurveStyle curveStyle = CURVE_STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRampMethod() <em>Ramp Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRampMethod()
	 * @generated
	 * @ordered
	 */
	protected static final RampMethod RAMP_METHOD_EDEFAULT = RampMethod.YUNITS_PER_MINUTE_LITERAL;

	/**
	 * The cached value of the '{@link #getRampMethod() <em>Ramp Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRampMethod()
	 * @generated
	 * @ordered
	 */
	protected RampMethod rampMethod = RAMP_METHOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getRampStartMethod() <em>Ramp Start Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRampStartMethod()
	 * @generated
	 * @ordered
	 */
	protected static final RampStartMethod RAMP_START_METHOD_EDEFAULT = RampStartMethod.ZERO_LITERAL;

	/**
	 * The cached value of the '{@link #getRampStartMethod() <em>Ramp Start Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRampStartMethod()
	 * @generated
	 * @ordered
	 */
	protected RampStartMethod rampStartMethod = RAMP_START_METHOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getRampUnits() <em>Ramp Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRampUnits()
	 * @generated
	 * @ordered
	 */
	protected static final RampUnits RAMP_UNITS_EDEFAULT = RampUnits.MW_PER_MINUTE_LITERAL;

	/**
	 * The cached value of the '{@link #getRampUnits() <em>Ramp Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRampUnits()
	 * @generated
	 * @ordered
	 */
	protected RampUnits rampUnits = RAMP_UNITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getXAxisType() <em>XAxis Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXAxisType()
	 * @generated
	 * @ordered
	 */
	protected static final NumericType XAXIS_TYPE_EDEFAULT = NumericType.INT_TYPE_LITERAL;

	/**
	 * The cached value of the '{@link #getXAxisType() <em>XAxis Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXAxisType()
	 * @generated
	 * @ordered
	 */
	protected NumericType xAxisType = XAXIS_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getXAxisQuantity() <em>XAxis Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXAxisQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final AxisQuantity XAXIS_QUANTITY_EDEFAULT = AxisQuantity.NONE_LITERAL;

	/**
	 * The cached value of the '{@link #getXAxisQuantity() <em>XAxis Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXAxisQuantity()
	 * @generated
	 * @ordered
	 */
	protected AxisQuantity xAxisQuantity = XAXIS_QUANTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getY1AxisQuantity() <em>Y1 Axis Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY1AxisQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final AxisQuantity Y1_AXIS_QUANTITY_EDEFAULT = AxisQuantity.NONE_LITERAL;

	/**
	 * The cached value of the '{@link #getY1AxisQuantity() <em>Y1 Axis Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY1AxisQuantity()
	 * @generated
	 * @ordered
	 */
	protected AxisQuantity y1AxisQuantity = Y1_AXIS_QUANTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getY2AxisQuantity() <em>Y2 Axis Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY2AxisQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final AxisQuantity Y2_AXIS_QUANTITY_EDEFAULT = AxisQuantity.NONE_LITERAL;

	/**
	 * The cached value of the '{@link #getY2AxisQuantity() <em>Y2 Axis Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY2AxisQuantity()
	 * @generated
	 * @ordered
	 */
	protected AxisQuantity y2AxisQuantity = Y2_AXIS_QUANTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getYAxisType() <em>YAxis Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYAxisType()
	 * @generated
	 * @ordered
	 */
	protected static final NumericType YAXIS_TYPE_EDEFAULT = NumericType.INT_TYPE_LITERAL;

	/**
	 * The cached value of the '{@link #getYAxisType() <em>YAxis Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYAxisType()
	 * @generated
	 * @ordered
	 */
	protected NumericType yAxisType = YAXIS_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCurveScheduleDatas() <em>Curve Schedule Datas</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurveScheduleDatas()
	 * @generated
	 * @ordered
	 */
	protected EList curveScheduleDatas;

	/**
	 * The cached value of the '{@link #getCurveScheduleFormula() <em>Curve Schedule Formula</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurveScheduleFormula()
	 * @generated
	 * @ordered
	 */
	protected EList curveScheduleFormula;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CurveScheduleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.CURVE_SCHEDULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurveStyle getCurveStyle() {
		return curveStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveStyle(CurveStyle newCurveStyle) {
		CurveStyle oldCurveStyle = curveStyle;
		curveStyle = newCurveStyle == null ? CURVE_STYLE_EDEFAULT : newCurveStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHEDULE__CURVE_STYLE, oldCurveStyle, curveStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RampMethod getRampMethod() {
		return rampMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRampMethod(RampMethod newRampMethod) {
		RampMethod oldRampMethod = rampMethod;
		rampMethod = newRampMethod == null ? RAMP_METHOD_EDEFAULT : newRampMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHEDULE__RAMP_METHOD, oldRampMethod, rampMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RampStartMethod getRampStartMethod() {
		return rampStartMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRampStartMethod(RampStartMethod newRampStartMethod) {
		RampStartMethod oldRampStartMethod = rampStartMethod;
		rampStartMethod = newRampStartMethod == null ? RAMP_START_METHOD_EDEFAULT : newRampStartMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD, oldRampStartMethod, rampStartMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RampUnits getRampUnits() {
		return rampUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRampUnits(RampUnits newRampUnits) {
		RampUnits oldRampUnits = rampUnits;
		rampUnits = newRampUnits == null ? RAMP_UNITS_EDEFAULT : newRampUnits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHEDULE__RAMP_UNITS, oldRampUnits, rampUnits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericType getXAxisType() {
		return xAxisType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXAxisType(NumericType newXAxisType) {
		NumericType oldXAxisType = xAxisType;
		xAxisType = newXAxisType == null ? XAXIS_TYPE_EDEFAULT : newXAxisType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHEDULE__XAXIS_TYPE, oldXAxisType, xAxisType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AxisQuantity getXAxisQuantity() {
		return xAxisQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXAxisQuantity(AxisQuantity newXAxisQuantity) {
		AxisQuantity oldXAxisQuantity = xAxisQuantity;
		xAxisQuantity = newXAxisQuantity == null ? XAXIS_QUANTITY_EDEFAULT : newXAxisQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY, oldXAxisQuantity, xAxisQuantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AxisQuantity getY1AxisQuantity() {
		return y1AxisQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY1AxisQuantity(AxisQuantity newY1AxisQuantity) {
		AxisQuantity oldY1AxisQuantity = y1AxisQuantity;
		y1AxisQuantity = newY1AxisQuantity == null ? Y1_AXIS_QUANTITY_EDEFAULT : newY1AxisQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY, oldY1AxisQuantity, y1AxisQuantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AxisQuantity getY2AxisQuantity() {
		return y2AxisQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY2AxisQuantity(AxisQuantity newY2AxisQuantity) {
		AxisQuantity oldY2AxisQuantity = y2AxisQuantity;
		y2AxisQuantity = newY2AxisQuantity == null ? Y2_AXIS_QUANTITY_EDEFAULT : newY2AxisQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY, oldY2AxisQuantity, y2AxisQuantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericType getYAxisType() {
		return yAxisType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYAxisType(NumericType newYAxisType) {
		NumericType oldYAxisType = yAxisType;
		yAxisType = newYAxisType == null ? YAXIS_TYPE_EDEFAULT : newYAxisType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CURVE_SCHEDULE__YAXIS_TYPE, oldYAxisType, yAxisType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCurveScheduleDatas() {
		if (curveScheduleDatas == null) {
			curveScheduleDatas = new EObjectContainmentWithInverseEList(CurveSchedData.class, this, CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS, CorePackage.CURVE_SCHED_DATA__CURVE_SCHEDULE);
		}
		return curveScheduleDatas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCurveScheduleFormula() {
		if (curveScheduleFormula == null) {
			curveScheduleFormula = new EObjectContainmentWithInverseEList(CurveSchedFormula.class, this, CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA, CorePackage.CURVE_SCHED_FORMULA__CURVE_SCHEDULE);
		}
		return curveScheduleFormula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS:
				return ((InternalEList)getCurveScheduleDatas()).basicAdd(otherEnd, msgs);
			case CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA:
				return ((InternalEList)getCurveScheduleFormula()).basicAdd(otherEnd, msgs);
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
			case CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS:
				return ((InternalEList)getCurveScheduleDatas()).basicRemove(otherEnd, msgs);
			case CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA:
				return ((InternalEList)getCurveScheduleFormula()).basicRemove(otherEnd, msgs);
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
			case CorePackage.CURVE_SCHEDULE__CURVE_STYLE:
				return getCurveStyle();
			case CorePackage.CURVE_SCHEDULE__RAMP_METHOD:
				return getRampMethod();
			case CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD:
				return getRampStartMethod();
			case CorePackage.CURVE_SCHEDULE__RAMP_UNITS:
				return getRampUnits();
			case CorePackage.CURVE_SCHEDULE__XAXIS_TYPE:
				return getXAxisType();
			case CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY:
				return getXAxisQuantity();
			case CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY:
				return getY1AxisQuantity();
			case CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY:
				return getY2AxisQuantity();
			case CorePackage.CURVE_SCHEDULE__YAXIS_TYPE:
				return getYAxisType();
			case CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS:
				return getCurveScheduleDatas();
			case CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA:
				return getCurveScheduleFormula();
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
			case CorePackage.CURVE_SCHEDULE__CURVE_STYLE:
				setCurveStyle((CurveStyle)newValue);
				return;
			case CorePackage.CURVE_SCHEDULE__RAMP_METHOD:
				setRampMethod((RampMethod)newValue);
				return;
			case CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD:
				setRampStartMethod((RampStartMethod)newValue);
				return;
			case CorePackage.CURVE_SCHEDULE__RAMP_UNITS:
				setRampUnits((RampUnits)newValue);
				return;
			case CorePackage.CURVE_SCHEDULE__XAXIS_TYPE:
				setXAxisType((NumericType)newValue);
				return;
			case CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY:
				setXAxisQuantity((AxisQuantity)newValue);
				return;
			case CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY:
				setY1AxisQuantity((AxisQuantity)newValue);
				return;
			case CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY:
				setY2AxisQuantity((AxisQuantity)newValue);
				return;
			case CorePackage.CURVE_SCHEDULE__YAXIS_TYPE:
				setYAxisType((NumericType)newValue);
				return;
			case CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS:
				getCurveScheduleDatas().clear();
				getCurveScheduleDatas().addAll((Collection)newValue);
				return;
			case CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA:
				getCurveScheduleFormula().clear();
				getCurveScheduleFormula().addAll((Collection)newValue);
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
			case CorePackage.CURVE_SCHEDULE__CURVE_STYLE:
				setCurveStyle(CURVE_STYLE_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHEDULE__RAMP_METHOD:
				setRampMethod(RAMP_METHOD_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD:
				setRampStartMethod(RAMP_START_METHOD_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHEDULE__RAMP_UNITS:
				setRampUnits(RAMP_UNITS_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHEDULE__XAXIS_TYPE:
				setXAxisType(XAXIS_TYPE_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY:
				setXAxisQuantity(XAXIS_QUANTITY_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY:
				setY1AxisQuantity(Y1_AXIS_QUANTITY_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY:
				setY2AxisQuantity(Y2_AXIS_QUANTITY_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHEDULE__YAXIS_TYPE:
				setYAxisType(YAXIS_TYPE_EDEFAULT);
				return;
			case CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS:
				getCurveScheduleDatas().clear();
				return;
			case CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA:
				getCurveScheduleFormula().clear();
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
			case CorePackage.CURVE_SCHEDULE__CURVE_STYLE:
				return curveStyle != CURVE_STYLE_EDEFAULT;
			case CorePackage.CURVE_SCHEDULE__RAMP_METHOD:
				return rampMethod != RAMP_METHOD_EDEFAULT;
			case CorePackage.CURVE_SCHEDULE__RAMP_START_METHOD:
				return rampStartMethod != RAMP_START_METHOD_EDEFAULT;
			case CorePackage.CURVE_SCHEDULE__RAMP_UNITS:
				return rampUnits != RAMP_UNITS_EDEFAULT;
			case CorePackage.CURVE_SCHEDULE__XAXIS_TYPE:
				return xAxisType != XAXIS_TYPE_EDEFAULT;
			case CorePackage.CURVE_SCHEDULE__XAXIS_QUANTITY:
				return xAxisQuantity != XAXIS_QUANTITY_EDEFAULT;
			case CorePackage.CURVE_SCHEDULE__Y1_AXIS_QUANTITY:
				return y1AxisQuantity != Y1_AXIS_QUANTITY_EDEFAULT;
			case CorePackage.CURVE_SCHEDULE__Y2_AXIS_QUANTITY:
				return y2AxisQuantity != Y2_AXIS_QUANTITY_EDEFAULT;
			case CorePackage.CURVE_SCHEDULE__YAXIS_TYPE:
				return yAxisType != YAXIS_TYPE_EDEFAULT;
			case CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_DATAS:
				return curveScheduleDatas != null && !curveScheduleDatas.isEmpty();
			case CorePackage.CURVE_SCHEDULE__CURVE_SCHEDULE_FORMULA:
				return curveScheduleFormula != null && !curveScheduleFormula.isEmpty();
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
		result.append(" (curveStyle: ");
		result.append(curveStyle);
		result.append(", rampMethod: ");
		result.append(rampMethod);
		result.append(", rampStartMethod: ");
		result.append(rampStartMethod);
		result.append(", rampUnits: ");
		result.append(rampUnits);
		result.append(", xAxisType: ");
		result.append(xAxisType);
		result.append(", xAxisQuantity: ");
		result.append(xAxisQuantity);
		result.append(", y1AxisQuantity: ");
		result.append(y1AxisQuantity);
		result.append(", y2AxisQuantity: ");
		result.append(y2AxisQuantity);
		result.append(", yAxisType: ");
		result.append(yAxisType);
		result.append(')');
		return result.toString();
	}

} //CurveScheduleImpl