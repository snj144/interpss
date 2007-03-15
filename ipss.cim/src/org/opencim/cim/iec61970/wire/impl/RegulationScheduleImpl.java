/**
 * <copyright>
 * </copyright>
 *
 * $Id: RegulationScheduleImpl.java,v 1.1 2007/03/02 14:00:58 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.wire.RegulatingCondEq;
import org.opencim.cim.iec61970.wire.RegulationSchedule;
import org.opencim.cim.iec61970.wire.TapChanger;
import org.opencim.cim.iec61970.wire.VoltageControlZone;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Resistance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Regulation Schedule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RegulationScheduleImpl#getLineDropCompensation <em>Line Drop Compensation</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RegulationScheduleImpl#getLineDropR <em>Line Drop R</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RegulationScheduleImpl#getLineDropX <em>Line Drop X</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RegulationScheduleImpl#getVoltageControlZones <em>Voltage Control Zones</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RegulationScheduleImpl#getRegulatingCondEqs <em>Regulating Cond Eqs</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.RegulationScheduleImpl#getTapChangers <em>Tap Changers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegulationScheduleImpl extends CurveScheduleImpl implements RegulationSchedule {
	/**
	 * The default value of the '{@link #getLineDropCompensation() <em>Line Drop Compensation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineDropCompensation()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean LINE_DROP_COMPENSATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLineDropCompensation() <em>Line Drop Compensation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineDropCompensation()
	 * @generated
	 * @ordered
	 */
	protected Boolean lineDropCompensation = LINE_DROP_COMPENSATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLineDropR() <em>Line Drop R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineDropR()
	 * @generated
	 * @ordered
	 */
	protected static final Resistance LINE_DROP_R_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLineDropR() <em>Line Drop R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineDropR()
	 * @generated
	 * @ordered
	 */
	protected Resistance lineDropR = LINE_DROP_R_EDEFAULT;

	/**
	 * The default value of the '{@link #getLineDropX() <em>Line Drop X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineDropX()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance LINE_DROP_X_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLineDropX() <em>Line Drop X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineDropX()
	 * @generated
	 * @ordered
	 */
	protected Reactance lineDropX = LINE_DROP_X_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVoltageControlZones() <em>Voltage Control Zones</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoltageControlZones()
	 * @generated
	 * @ordered
	 */
	protected EList voltageControlZones = null;

	/**
	 * The cached value of the '{@link #getRegulatingCondEqs() <em>Regulating Cond Eqs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegulatingCondEqs()
	 * @generated
	 * @ordered
	 */
	protected EList regulatingCondEqs = null;

	/**
	 * The cached value of the '{@link #getTapChangers() <em>Tap Changers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTapChangers()
	 * @generated
	 * @ordered
	 */
	protected EList tapChangers = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegulationScheduleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.REGULATION_SCHEDULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getLineDropCompensation() {
		return lineDropCompensation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineDropCompensation(Boolean newLineDropCompensation) {
		Boolean oldLineDropCompensation = lineDropCompensation;
		lineDropCompensation = newLineDropCompensation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.REGULATION_SCHEDULE__LINE_DROP_COMPENSATION, oldLineDropCompensation, lineDropCompensation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance getLineDropR() {
		return lineDropR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineDropR(Resistance newLineDropR) {
		Resistance oldLineDropR = lineDropR;
		lineDropR = newLineDropR;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.REGULATION_SCHEDULE__LINE_DROP_R, oldLineDropR, lineDropR));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getLineDropX() {
		return lineDropX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineDropX(Reactance newLineDropX) {
		Reactance oldLineDropX = lineDropX;
		lineDropX = newLineDropX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.REGULATION_SCHEDULE__LINE_DROP_X, oldLineDropX, lineDropX));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getVoltageControlZones() {
		if (voltageControlZones == null) {
			voltageControlZones = new EObjectWithInverseResolvingEList(VoltageControlZone.class, this, WirePackage.REGULATION_SCHEDULE__VOLTAGE_CONTROL_ZONES, WirePackage.VOLTAGE_CONTROL_ZONE__REGULATION_SCHEDULE);
		}
		return voltageControlZones;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRegulatingCondEqs() {
		if (regulatingCondEqs == null) {
			regulatingCondEqs = new EObjectWithInverseResolvingEList(RegulatingCondEq.class, this, WirePackage.REGULATION_SCHEDULE__REGULATING_COND_EQS, WirePackage.REGULATING_COND_EQ__REGULATION_SCHEDULE);
		}
		return regulatingCondEqs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTapChangers() {
		if (tapChangers == null) {
			tapChangers = new EObjectWithInverseResolvingEList(TapChanger.class, this, WirePackage.REGULATION_SCHEDULE__TAP_CHANGERS, WirePackage.TAP_CHANGER__REGULATION_SCHEDULE);
		}
		return tapChangers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.REGULATION_SCHEDULE__VOLTAGE_CONTROL_ZONES:
				return ((InternalEList)getVoltageControlZones()).basicAdd(otherEnd, msgs);
			case WirePackage.REGULATION_SCHEDULE__REGULATING_COND_EQS:
				return ((InternalEList)getRegulatingCondEqs()).basicAdd(otherEnd, msgs);
			case WirePackage.REGULATION_SCHEDULE__TAP_CHANGERS:
				return ((InternalEList)getTapChangers()).basicAdd(otherEnd, msgs);
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
			case WirePackage.REGULATION_SCHEDULE__VOLTAGE_CONTROL_ZONES:
				return ((InternalEList)getVoltageControlZones()).basicRemove(otherEnd, msgs);
			case WirePackage.REGULATION_SCHEDULE__REGULATING_COND_EQS:
				return ((InternalEList)getRegulatingCondEqs()).basicRemove(otherEnd, msgs);
			case WirePackage.REGULATION_SCHEDULE__TAP_CHANGERS:
				return ((InternalEList)getTapChangers()).basicRemove(otherEnd, msgs);
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
			case WirePackage.REGULATION_SCHEDULE__LINE_DROP_COMPENSATION:
				return getLineDropCompensation();
			case WirePackage.REGULATION_SCHEDULE__LINE_DROP_R:
				return getLineDropR();
			case WirePackage.REGULATION_SCHEDULE__LINE_DROP_X:
				return getLineDropX();
			case WirePackage.REGULATION_SCHEDULE__VOLTAGE_CONTROL_ZONES:
				return getVoltageControlZones();
			case WirePackage.REGULATION_SCHEDULE__REGULATING_COND_EQS:
				return getRegulatingCondEqs();
			case WirePackage.REGULATION_SCHEDULE__TAP_CHANGERS:
				return getTapChangers();
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
			case WirePackage.REGULATION_SCHEDULE__LINE_DROP_COMPENSATION:
				setLineDropCompensation((Boolean)newValue);
				return;
			case WirePackage.REGULATION_SCHEDULE__LINE_DROP_R:
				setLineDropR((Resistance)newValue);
				return;
			case WirePackage.REGULATION_SCHEDULE__LINE_DROP_X:
				setLineDropX((Reactance)newValue);
				return;
			case WirePackage.REGULATION_SCHEDULE__VOLTAGE_CONTROL_ZONES:
				getVoltageControlZones().clear();
				getVoltageControlZones().addAll((Collection)newValue);
				return;
			case WirePackage.REGULATION_SCHEDULE__REGULATING_COND_EQS:
				getRegulatingCondEqs().clear();
				getRegulatingCondEqs().addAll((Collection)newValue);
				return;
			case WirePackage.REGULATION_SCHEDULE__TAP_CHANGERS:
				getTapChangers().clear();
				getTapChangers().addAll((Collection)newValue);
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
			case WirePackage.REGULATION_SCHEDULE__LINE_DROP_COMPENSATION:
				setLineDropCompensation(LINE_DROP_COMPENSATION_EDEFAULT);
				return;
			case WirePackage.REGULATION_SCHEDULE__LINE_DROP_R:
				setLineDropR(LINE_DROP_R_EDEFAULT);
				return;
			case WirePackage.REGULATION_SCHEDULE__LINE_DROP_X:
				setLineDropX(LINE_DROP_X_EDEFAULT);
				return;
			case WirePackage.REGULATION_SCHEDULE__VOLTAGE_CONTROL_ZONES:
				getVoltageControlZones().clear();
				return;
			case WirePackage.REGULATION_SCHEDULE__REGULATING_COND_EQS:
				getRegulatingCondEqs().clear();
				return;
			case WirePackage.REGULATION_SCHEDULE__TAP_CHANGERS:
				getTapChangers().clear();
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
			case WirePackage.REGULATION_SCHEDULE__LINE_DROP_COMPENSATION:
				return LINE_DROP_COMPENSATION_EDEFAULT == null ? lineDropCompensation != null : !LINE_DROP_COMPENSATION_EDEFAULT.equals(lineDropCompensation);
			case WirePackage.REGULATION_SCHEDULE__LINE_DROP_R:
				return LINE_DROP_R_EDEFAULT == null ? lineDropR != null : !LINE_DROP_R_EDEFAULT.equals(lineDropR);
			case WirePackage.REGULATION_SCHEDULE__LINE_DROP_X:
				return LINE_DROP_X_EDEFAULT == null ? lineDropX != null : !LINE_DROP_X_EDEFAULT.equals(lineDropX);
			case WirePackage.REGULATION_SCHEDULE__VOLTAGE_CONTROL_ZONES:
				return voltageControlZones != null && !voltageControlZones.isEmpty();
			case WirePackage.REGULATION_SCHEDULE__REGULATING_COND_EQS:
				return regulatingCondEqs != null && !regulatingCondEqs.isEmpty();
			case WirePackage.REGULATION_SCHEDULE__TAP_CHANGERS:
				return tapChangers != null && !tapChangers.isEmpty();
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
		result.append(" (lineDropCompensation: ");
		result.append(lineDropCompensation);
		result.append(", lineDropR: ");
		result.append(lineDropR);
		result.append(", lineDropX: ");
		result.append(lineDropX);
		result.append(')');
		return result.toString();
	}

} //RegulationScheduleImpl