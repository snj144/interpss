/**
 * <copyright>
 * </copyright>
 *
 * $Id: TapChangerImpl.java,v 1.1 2007/03/02 14:00:57 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl;

import org.opencim.cim.iec61970.domain.TransformerControlMode;

import org.opencim.cim.iec61970.wire.RegulationSchedule;
import org.opencim.cim.iec61970.wire.TapChanger;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.integer.TapStep;

import org.opencim.datatype.real.AngleDegrees;
import org.opencim.datatype.real.PerCent;
import org.opencim.datatype.real.Seconds;
import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tap Changer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TapChangerImpl#getHighStep <em>High Step</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TapChangerImpl#getInitialDelay <em>Initial Delay</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TapChangerImpl#getLowStep <em>Low Step</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TapChangerImpl#getNeutralKV <em>Neutral KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TapChangerImpl#getNeutralStep <em>Neutral Step</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TapChangerImpl#getNormalStep <em>Normal Step</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TapChangerImpl#getStepPhaseShiftIncrement <em>Step Phase Shift Increment</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TapChangerImpl#getStepVoltageIncrement <em>Step Voltage Increment</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TapChangerImpl#getSubsequentDelay <em>Subsequent Delay</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TapChangerImpl#getTculControlMode <em>Tcul Control Mode</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TapChangerImpl#getRegulationSchedule <em>Regulation Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TapChangerImpl extends PowerSystemResourceImpl implements TapChanger {
	/**
	 * The default value of the '{@link #getHighStep() <em>High Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighStep()
	 * @generated
	 * @ordered
	 */
	protected static final TapStep HIGH_STEP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHighStep() <em>High Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighStep()
	 * @generated
	 * @ordered
	 */
	protected TapStep highStep = HIGH_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitialDelay() <em>Initial Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialDelay()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds INITIAL_DELAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitialDelay() <em>Initial Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialDelay()
	 * @generated
	 * @ordered
	 */
	protected Seconds initialDelay = INITIAL_DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowStep() <em>Low Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowStep()
	 * @generated
	 * @ordered
	 */
	protected static final TapStep LOW_STEP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLowStep() <em>Low Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowStep()
	 * @generated
	 * @ordered
	 */
	protected TapStep lowStep = LOW_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getNeutralKV() <em>Neutral KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeutralKV()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage NEUTRAL_KV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNeutralKV() <em>Neutral KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeutralKV()
	 * @generated
	 * @ordered
	 */
	protected Voltage neutralKV = NEUTRAL_KV_EDEFAULT;

	/**
	 * The default value of the '{@link #getNeutralStep() <em>Neutral Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeutralStep()
	 * @generated
	 * @ordered
	 */
	protected static final TapStep NEUTRAL_STEP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNeutralStep() <em>Neutral Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeutralStep()
	 * @generated
	 * @ordered
	 */
	protected TapStep neutralStep = NEUTRAL_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getNormalStep() <em>Normal Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalStep()
	 * @generated
	 * @ordered
	 */
	protected static final TapStep NORMAL_STEP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNormalStep() <em>Normal Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalStep()
	 * @generated
	 * @ordered
	 */
	protected TapStep normalStep = NORMAL_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getStepPhaseShiftIncrement() <em>Step Phase Shift Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepPhaseShiftIncrement()
	 * @generated
	 * @ordered
	 */
	protected static final AngleDegrees STEP_PHASE_SHIFT_INCREMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStepPhaseShiftIncrement() <em>Step Phase Shift Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepPhaseShiftIncrement()
	 * @generated
	 * @ordered
	 */
	protected AngleDegrees stepPhaseShiftIncrement = STEP_PHASE_SHIFT_INCREMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getStepVoltageIncrement() <em>Step Voltage Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepVoltageIncrement()
	 * @generated
	 * @ordered
	 */
	protected static final PerCent STEP_VOLTAGE_INCREMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStepVoltageIncrement() <em>Step Voltage Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepVoltageIncrement()
	 * @generated
	 * @ordered
	 */
	protected PerCent stepVoltageIncrement = STEP_VOLTAGE_INCREMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubsequentDelay() <em>Subsequent Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsequentDelay()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds SUBSEQUENT_DELAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubsequentDelay() <em>Subsequent Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsequentDelay()
	 * @generated
	 * @ordered
	 */
	protected Seconds subsequentDelay = SUBSEQUENT_DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTculControlMode() <em>Tcul Control Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTculControlMode()
	 * @generated
	 * @ordered
	 */
	protected static final TransformerControlMode TCUL_CONTROL_MODE_EDEFAULT = TransformerControlMode.OFF_LITERAL;

	/**
	 * The cached value of the '{@link #getTculControlMode() <em>Tcul Control Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTculControlMode()
	 * @generated
	 * @ordered
	 */
	protected TransformerControlMode tculControlMode = TCUL_CONTROL_MODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRegulationSchedule() <em>Regulation Schedule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegulationSchedule()
	 * @generated
	 * @ordered
	 */
	protected RegulationSchedule regulationSchedule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TapChangerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.TAP_CHANGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TapStep getHighStep() {
		return highStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHighStep(TapStep newHighStep) {
		TapStep oldHighStep = highStep;
		highStep = newHighStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TAP_CHANGER__HIGH_STEP, oldHighStep, highStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getInitialDelay() {
		return initialDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialDelay(Seconds newInitialDelay) {
		Seconds oldInitialDelay = initialDelay;
		initialDelay = newInitialDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TAP_CHANGER__INITIAL_DELAY, oldInitialDelay, initialDelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TapStep getLowStep() {
		return lowStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowStep(TapStep newLowStep) {
		TapStep oldLowStep = lowStep;
		lowStep = newLowStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TAP_CHANGER__LOW_STEP, oldLowStep, lowStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getNeutralKV() {
		return neutralKV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNeutralKV(Voltage newNeutralKV) {
		Voltage oldNeutralKV = neutralKV;
		neutralKV = newNeutralKV;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TAP_CHANGER__NEUTRAL_KV, oldNeutralKV, neutralKV));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TapStep getNeutralStep() {
		return neutralStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNeutralStep(TapStep newNeutralStep) {
		TapStep oldNeutralStep = neutralStep;
		neutralStep = newNeutralStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TAP_CHANGER__NEUTRAL_STEP, oldNeutralStep, neutralStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TapStep getNormalStep() {
		return normalStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormalStep(TapStep newNormalStep) {
		TapStep oldNormalStep = normalStep;
		normalStep = newNormalStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TAP_CHANGER__NORMAL_STEP, oldNormalStep, normalStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AngleDegrees getStepPhaseShiftIncrement() {
		return stepPhaseShiftIncrement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepPhaseShiftIncrement(AngleDegrees newStepPhaseShiftIncrement) {
		AngleDegrees oldStepPhaseShiftIncrement = stepPhaseShiftIncrement;
		stepPhaseShiftIncrement = newStepPhaseShiftIncrement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TAP_CHANGER__STEP_PHASE_SHIFT_INCREMENT, oldStepPhaseShiftIncrement, stepPhaseShiftIncrement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent getStepVoltageIncrement() {
		return stepVoltageIncrement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepVoltageIncrement(PerCent newStepVoltageIncrement) {
		PerCent oldStepVoltageIncrement = stepVoltageIncrement;
		stepVoltageIncrement = newStepVoltageIncrement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TAP_CHANGER__STEP_VOLTAGE_INCREMENT, oldStepVoltageIncrement, stepVoltageIncrement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getSubsequentDelay() {
		return subsequentDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubsequentDelay(Seconds newSubsequentDelay) {
		Seconds oldSubsequentDelay = subsequentDelay;
		subsequentDelay = newSubsequentDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TAP_CHANGER__SUBSEQUENT_DELAY, oldSubsequentDelay, subsequentDelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformerControlMode getTculControlMode() {
		return tculControlMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTculControlMode(TransformerControlMode newTculControlMode) {
		TransformerControlMode oldTculControlMode = tculControlMode;
		tculControlMode = newTculControlMode == null ? TCUL_CONTROL_MODE_EDEFAULT : newTculControlMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TAP_CHANGER__TCUL_CONTROL_MODE, oldTculControlMode, tculControlMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegulationSchedule getRegulationSchedule() {
		if (regulationSchedule != null && regulationSchedule.eIsProxy()) {
			InternalEObject oldRegulationSchedule = (InternalEObject)regulationSchedule;
			regulationSchedule = (RegulationSchedule)eResolveProxy(oldRegulationSchedule);
			if (regulationSchedule != oldRegulationSchedule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WirePackage.TAP_CHANGER__REGULATION_SCHEDULE, oldRegulationSchedule, regulationSchedule));
			}
		}
		return regulationSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegulationSchedule basicGetRegulationSchedule() {
		return regulationSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRegulationSchedule(RegulationSchedule newRegulationSchedule, NotificationChain msgs) {
		RegulationSchedule oldRegulationSchedule = regulationSchedule;
		regulationSchedule = newRegulationSchedule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WirePackage.TAP_CHANGER__REGULATION_SCHEDULE, oldRegulationSchedule, newRegulationSchedule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegulationSchedule(RegulationSchedule newRegulationSchedule) {
		if (newRegulationSchedule != regulationSchedule) {
			NotificationChain msgs = null;
			if (regulationSchedule != null)
				msgs = ((InternalEObject)regulationSchedule).eInverseRemove(this, WirePackage.REGULATION_SCHEDULE__TAP_CHANGERS, RegulationSchedule.class, msgs);
			if (newRegulationSchedule != null)
				msgs = ((InternalEObject)newRegulationSchedule).eInverseAdd(this, WirePackage.REGULATION_SCHEDULE__TAP_CHANGERS, RegulationSchedule.class, msgs);
			msgs = basicSetRegulationSchedule(newRegulationSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TAP_CHANGER__REGULATION_SCHEDULE, newRegulationSchedule, newRegulationSchedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.TAP_CHANGER__REGULATION_SCHEDULE:
				if (regulationSchedule != null)
					msgs = ((InternalEObject)regulationSchedule).eInverseRemove(this, WirePackage.REGULATION_SCHEDULE__TAP_CHANGERS, RegulationSchedule.class, msgs);
				return basicSetRegulationSchedule((RegulationSchedule)otherEnd, msgs);
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
			case WirePackage.TAP_CHANGER__REGULATION_SCHEDULE:
				return basicSetRegulationSchedule(null, msgs);
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
			case WirePackage.TAP_CHANGER__HIGH_STEP:
				return getHighStep();
			case WirePackage.TAP_CHANGER__INITIAL_DELAY:
				return getInitialDelay();
			case WirePackage.TAP_CHANGER__LOW_STEP:
				return getLowStep();
			case WirePackage.TAP_CHANGER__NEUTRAL_KV:
				return getNeutralKV();
			case WirePackage.TAP_CHANGER__NEUTRAL_STEP:
				return getNeutralStep();
			case WirePackage.TAP_CHANGER__NORMAL_STEP:
				return getNormalStep();
			case WirePackage.TAP_CHANGER__STEP_PHASE_SHIFT_INCREMENT:
				return getStepPhaseShiftIncrement();
			case WirePackage.TAP_CHANGER__STEP_VOLTAGE_INCREMENT:
				return getStepVoltageIncrement();
			case WirePackage.TAP_CHANGER__SUBSEQUENT_DELAY:
				return getSubsequentDelay();
			case WirePackage.TAP_CHANGER__TCUL_CONTROL_MODE:
				return getTculControlMode();
			case WirePackage.TAP_CHANGER__REGULATION_SCHEDULE:
				if (resolve) return getRegulationSchedule();
				return basicGetRegulationSchedule();
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
			case WirePackage.TAP_CHANGER__HIGH_STEP:
				setHighStep((TapStep)newValue);
				return;
			case WirePackage.TAP_CHANGER__INITIAL_DELAY:
				setInitialDelay((Seconds)newValue);
				return;
			case WirePackage.TAP_CHANGER__LOW_STEP:
				setLowStep((TapStep)newValue);
				return;
			case WirePackage.TAP_CHANGER__NEUTRAL_KV:
				setNeutralKV((Voltage)newValue);
				return;
			case WirePackage.TAP_CHANGER__NEUTRAL_STEP:
				setNeutralStep((TapStep)newValue);
				return;
			case WirePackage.TAP_CHANGER__NORMAL_STEP:
				setNormalStep((TapStep)newValue);
				return;
			case WirePackage.TAP_CHANGER__STEP_PHASE_SHIFT_INCREMENT:
				setStepPhaseShiftIncrement((AngleDegrees)newValue);
				return;
			case WirePackage.TAP_CHANGER__STEP_VOLTAGE_INCREMENT:
				setStepVoltageIncrement((PerCent)newValue);
				return;
			case WirePackage.TAP_CHANGER__SUBSEQUENT_DELAY:
				setSubsequentDelay((Seconds)newValue);
				return;
			case WirePackage.TAP_CHANGER__TCUL_CONTROL_MODE:
				setTculControlMode((TransformerControlMode)newValue);
				return;
			case WirePackage.TAP_CHANGER__REGULATION_SCHEDULE:
				setRegulationSchedule((RegulationSchedule)newValue);
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
			case WirePackage.TAP_CHANGER__HIGH_STEP:
				setHighStep(HIGH_STEP_EDEFAULT);
				return;
			case WirePackage.TAP_CHANGER__INITIAL_DELAY:
				setInitialDelay(INITIAL_DELAY_EDEFAULT);
				return;
			case WirePackage.TAP_CHANGER__LOW_STEP:
				setLowStep(LOW_STEP_EDEFAULT);
				return;
			case WirePackage.TAP_CHANGER__NEUTRAL_KV:
				setNeutralKV(NEUTRAL_KV_EDEFAULT);
				return;
			case WirePackage.TAP_CHANGER__NEUTRAL_STEP:
				setNeutralStep(NEUTRAL_STEP_EDEFAULT);
				return;
			case WirePackage.TAP_CHANGER__NORMAL_STEP:
				setNormalStep(NORMAL_STEP_EDEFAULT);
				return;
			case WirePackage.TAP_CHANGER__STEP_PHASE_SHIFT_INCREMENT:
				setStepPhaseShiftIncrement(STEP_PHASE_SHIFT_INCREMENT_EDEFAULT);
				return;
			case WirePackage.TAP_CHANGER__STEP_VOLTAGE_INCREMENT:
				setStepVoltageIncrement(STEP_VOLTAGE_INCREMENT_EDEFAULT);
				return;
			case WirePackage.TAP_CHANGER__SUBSEQUENT_DELAY:
				setSubsequentDelay(SUBSEQUENT_DELAY_EDEFAULT);
				return;
			case WirePackage.TAP_CHANGER__TCUL_CONTROL_MODE:
				setTculControlMode(TCUL_CONTROL_MODE_EDEFAULT);
				return;
			case WirePackage.TAP_CHANGER__REGULATION_SCHEDULE:
				setRegulationSchedule((RegulationSchedule)null);
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
			case WirePackage.TAP_CHANGER__HIGH_STEP:
				return HIGH_STEP_EDEFAULT == null ? highStep != null : !HIGH_STEP_EDEFAULT.equals(highStep);
			case WirePackage.TAP_CHANGER__INITIAL_DELAY:
				return INITIAL_DELAY_EDEFAULT == null ? initialDelay != null : !INITIAL_DELAY_EDEFAULT.equals(initialDelay);
			case WirePackage.TAP_CHANGER__LOW_STEP:
				return LOW_STEP_EDEFAULT == null ? lowStep != null : !LOW_STEP_EDEFAULT.equals(lowStep);
			case WirePackage.TAP_CHANGER__NEUTRAL_KV:
				return NEUTRAL_KV_EDEFAULT == null ? neutralKV != null : !NEUTRAL_KV_EDEFAULT.equals(neutralKV);
			case WirePackage.TAP_CHANGER__NEUTRAL_STEP:
				return NEUTRAL_STEP_EDEFAULT == null ? neutralStep != null : !NEUTRAL_STEP_EDEFAULT.equals(neutralStep);
			case WirePackage.TAP_CHANGER__NORMAL_STEP:
				return NORMAL_STEP_EDEFAULT == null ? normalStep != null : !NORMAL_STEP_EDEFAULT.equals(normalStep);
			case WirePackage.TAP_CHANGER__STEP_PHASE_SHIFT_INCREMENT:
				return STEP_PHASE_SHIFT_INCREMENT_EDEFAULT == null ? stepPhaseShiftIncrement != null : !STEP_PHASE_SHIFT_INCREMENT_EDEFAULT.equals(stepPhaseShiftIncrement);
			case WirePackage.TAP_CHANGER__STEP_VOLTAGE_INCREMENT:
				return STEP_VOLTAGE_INCREMENT_EDEFAULT == null ? stepVoltageIncrement != null : !STEP_VOLTAGE_INCREMENT_EDEFAULT.equals(stepVoltageIncrement);
			case WirePackage.TAP_CHANGER__SUBSEQUENT_DELAY:
				return SUBSEQUENT_DELAY_EDEFAULT == null ? subsequentDelay != null : !SUBSEQUENT_DELAY_EDEFAULT.equals(subsequentDelay);
			case WirePackage.TAP_CHANGER__TCUL_CONTROL_MODE:
				return tculControlMode != TCUL_CONTROL_MODE_EDEFAULT;
			case WirePackage.TAP_CHANGER__REGULATION_SCHEDULE:
				return regulationSchedule != null;
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
		result.append(" (highStep: ");
		result.append(highStep);
		result.append(", initialDelay: ");
		result.append(initialDelay);
		result.append(", lowStep: ");
		result.append(lowStep);
		result.append(", neutralKV: ");
		result.append(neutralKV);
		result.append(", neutralStep: ");
		result.append(neutralStep);
		result.append(", normalStep: ");
		result.append(normalStep);
		result.append(", stepPhaseShiftIncrement: ");
		result.append(stepPhaseShiftIncrement);
		result.append(", stepVoltageIncrement: ");
		result.append(stepVoltageIncrement);
		result.append(", subsequentDelay: ");
		result.append(subsequentDelay);
		result.append(", tculControlMode: ");
		result.append(tculControlMode);
		result.append(')');
		return result.toString();
	}

} //TapChangerImpl