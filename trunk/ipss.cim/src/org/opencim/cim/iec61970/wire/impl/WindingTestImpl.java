/**
 * <copyright>
 * </copyright>
 *
 * $Id: WindingTestImpl.java,v 1.1 2007/03/02 14:00:56 mzhou Exp $
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

import org.opencim.cim.iec61970.core.impl.NamingImpl;

import org.opencim.cim.iec61970.wire.TransformerWinding;
import org.opencim.cim.iec61970.wire.WindingTest;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.integer.TapStep;

import org.opencim.datatype.real.AngleDegrees;
import org.opencim.datatype.real.ExcitingCurrent;
import org.opencim.datatype.real.Impedance;
import org.opencim.datatype.real.LoadLoss;
import org.opencim.datatype.real.NoLoadLoss;
import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Winding Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WindingTestImpl#getExcitingCurrent <em>Exciting Current</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WindingTestImpl#getFromTapStep <em>From Tap Step</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WindingTestImpl#getLeakageImpedance <em>Leakage Impedance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WindingTestImpl#getLoadLoss <em>Load Loss</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WindingTestImpl#getNoLoadLoss <em>No Load Loss</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WindingTestImpl#getPhaseShift <em>Phase Shift</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WindingTestImpl#getToTapStep <em>To Tap Step</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WindingTestImpl#getVoltage <em>Voltage</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WindingTestImpl#getFrom_TransformerWinding <em>From Transformer Winding</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.WindingTestImpl#getTo_TransformeWindings <em>To Transforme Windings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WindingTestImpl extends NamingImpl implements WindingTest {
	/**
	 * The default value of the '{@link #getExcitingCurrent() <em>Exciting Current</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExcitingCurrent()
	 * @generated
	 * @ordered
	 */
	protected static final ExcitingCurrent EXCITING_CURRENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExcitingCurrent() <em>Exciting Current</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExcitingCurrent()
	 * @generated
	 * @ordered
	 */
	protected ExcitingCurrent excitingCurrent = EXCITING_CURRENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFromTapStep() <em>From Tap Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromTapStep()
	 * @generated
	 * @ordered
	 */
	protected static final TapStep FROM_TAP_STEP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFromTapStep() <em>From Tap Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromTapStep()
	 * @generated
	 * @ordered
	 */
	protected TapStep fromTapStep = FROM_TAP_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getLeakageImpedance() <em>Leakage Impedance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeakageImpedance()
	 * @generated
	 * @ordered
	 */
	protected static final Impedance LEAKAGE_IMPEDANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLeakageImpedance() <em>Leakage Impedance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeakageImpedance()
	 * @generated
	 * @ordered
	 */
	protected Impedance leakageImpedance = LEAKAGE_IMPEDANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLoadLoss() <em>Load Loss</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadLoss()
	 * @generated
	 * @ordered
	 */
	protected static final LoadLoss LOAD_LOSS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLoadLoss() <em>Load Loss</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadLoss()
	 * @generated
	 * @ordered
	 */
	protected LoadLoss loadLoss = LOAD_LOSS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNoLoadLoss() <em>No Load Loss</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoLoadLoss()
	 * @generated
	 * @ordered
	 */
	protected static final NoLoadLoss NO_LOAD_LOSS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNoLoadLoss() <em>No Load Loss</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoLoadLoss()
	 * @generated
	 * @ordered
	 */
	protected NoLoadLoss noLoadLoss = NO_LOAD_LOSS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPhaseShift() <em>Phase Shift</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhaseShift()
	 * @generated
	 * @ordered
	 */
	protected static final AngleDegrees PHASE_SHIFT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhaseShift() <em>Phase Shift</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhaseShift()
	 * @generated
	 * @ordered
	 */
	protected AngleDegrees phaseShift = PHASE_SHIFT_EDEFAULT;

	/**
	 * The default value of the '{@link #getToTapStep() <em>To Tap Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToTapStep()
	 * @generated
	 * @ordered
	 */
	protected static final TapStep TO_TAP_STEP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToTapStep() <em>To Tap Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToTapStep()
	 * @generated
	 * @ordered
	 */
	protected TapStep toTapStep = TO_TAP_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getVoltage() <em>Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoltage()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage VOLTAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVoltage() <em>Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoltage()
	 * @generated
	 * @ordered
	 */
	protected Voltage voltage = VOLTAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFrom_TransformerWinding() <em>From Transformer Winding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom_TransformerWinding()
	 * @generated
	 * @ordered
	 */
	protected TransformerWinding from_TransformerWinding;

	/**
	 * The cached value of the '{@link #getTo_TransformeWindings() <em>To Transforme Windings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo_TransformeWindings()
	 * @generated
	 * @ordered
	 */
	protected EList to_TransformeWindings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WindingTestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.WINDING_TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExcitingCurrent getExcitingCurrent() {
		return excitingCurrent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExcitingCurrent(ExcitingCurrent newExcitingCurrent) {
		ExcitingCurrent oldExcitingCurrent = excitingCurrent;
		excitingCurrent = newExcitingCurrent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WINDING_TEST__EXCITING_CURRENT, oldExcitingCurrent, excitingCurrent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TapStep getFromTapStep() {
		return fromTapStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromTapStep(TapStep newFromTapStep) {
		TapStep oldFromTapStep = fromTapStep;
		fromTapStep = newFromTapStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WINDING_TEST__FROM_TAP_STEP, oldFromTapStep, fromTapStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Impedance getLeakageImpedance() {
		return leakageImpedance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeakageImpedance(Impedance newLeakageImpedance) {
		Impedance oldLeakageImpedance = leakageImpedance;
		leakageImpedance = newLeakageImpedance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WINDING_TEST__LEAKAGE_IMPEDANCE, oldLeakageImpedance, leakageImpedance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadLoss getLoadLoss() {
		return loadLoss;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadLoss(LoadLoss newLoadLoss) {
		LoadLoss oldLoadLoss = loadLoss;
		loadLoss = newLoadLoss;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WINDING_TEST__LOAD_LOSS, oldLoadLoss, loadLoss));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoLoadLoss getNoLoadLoss() {
		return noLoadLoss;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoLoadLoss(NoLoadLoss newNoLoadLoss) {
		NoLoadLoss oldNoLoadLoss = noLoadLoss;
		noLoadLoss = newNoLoadLoss;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WINDING_TEST__NO_LOAD_LOSS, oldNoLoadLoss, noLoadLoss));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AngleDegrees getPhaseShift() {
		return phaseShift;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhaseShift(AngleDegrees newPhaseShift) {
		AngleDegrees oldPhaseShift = phaseShift;
		phaseShift = newPhaseShift;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WINDING_TEST__PHASE_SHIFT, oldPhaseShift, phaseShift));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TapStep getToTapStep() {
		return toTapStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToTapStep(TapStep newToTapStep) {
		TapStep oldToTapStep = toTapStep;
		toTapStep = newToTapStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WINDING_TEST__TO_TAP_STEP, oldToTapStep, toTapStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getVoltage() {
		return voltage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVoltage(Voltage newVoltage) {
		Voltage oldVoltage = voltage;
		voltage = newVoltage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WINDING_TEST__VOLTAGE, oldVoltage, voltage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformerWinding getFrom_TransformerWinding() {
		if (from_TransformerWinding != null && from_TransformerWinding.eIsProxy()) {
			InternalEObject oldFrom_TransformerWinding = (InternalEObject)from_TransformerWinding;
			from_TransformerWinding = (TransformerWinding)eResolveProxy(oldFrom_TransformerWinding);
			if (from_TransformerWinding != oldFrom_TransformerWinding) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WirePackage.WINDING_TEST__FROM_TRANSFORMER_WINDING, oldFrom_TransformerWinding, from_TransformerWinding));
			}
		}
		return from_TransformerWinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformerWinding basicGetFrom_TransformerWinding() {
		return from_TransformerWinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFrom_TransformerWinding(TransformerWinding newFrom_TransformerWinding, NotificationChain msgs) {
		TransformerWinding oldFrom_TransformerWinding = from_TransformerWinding;
		from_TransformerWinding = newFrom_TransformerWinding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WirePackage.WINDING_TEST__FROM_TRANSFORMER_WINDING, oldFrom_TransformerWinding, newFrom_TransformerWinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom_TransformerWinding(TransformerWinding newFrom_TransformerWinding) {
		if (newFrom_TransformerWinding != from_TransformerWinding) {
			NotificationChain msgs = null;
			if (from_TransformerWinding != null)
				msgs = ((InternalEObject)from_TransformerWinding).eInverseRemove(this, WirePackage.TRANSFORMER_WINDING__FROM_WINDING_TESTS, TransformerWinding.class, msgs);
			if (newFrom_TransformerWinding != null)
				msgs = ((InternalEObject)newFrom_TransformerWinding).eInverseAdd(this, WirePackage.TRANSFORMER_WINDING__FROM_WINDING_TESTS, TransformerWinding.class, msgs);
			msgs = basicSetFrom_TransformerWinding(newFrom_TransformerWinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.WINDING_TEST__FROM_TRANSFORMER_WINDING, newFrom_TransformerWinding, newFrom_TransformerWinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTo_TransformeWindings() {
		if (to_TransformeWindings == null) {
			to_TransformeWindings = new EObjectWithInverseResolvingEList(TransformerWinding.class, this, WirePackage.WINDING_TEST__TO_TRANSFORME_WINDINGS, WirePackage.TRANSFORMER_WINDING__TO_WINDING_TEST);
		}
		return to_TransformeWindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.WINDING_TEST__FROM_TRANSFORMER_WINDING:
				if (from_TransformerWinding != null)
					msgs = ((InternalEObject)from_TransformerWinding).eInverseRemove(this, WirePackage.TRANSFORMER_WINDING__FROM_WINDING_TESTS, TransformerWinding.class, msgs);
				return basicSetFrom_TransformerWinding((TransformerWinding)otherEnd, msgs);
			case WirePackage.WINDING_TEST__TO_TRANSFORME_WINDINGS:
				return ((InternalEList)getTo_TransformeWindings()).basicAdd(otherEnd, msgs);
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
			case WirePackage.WINDING_TEST__FROM_TRANSFORMER_WINDING:
				return basicSetFrom_TransformerWinding(null, msgs);
			case WirePackage.WINDING_TEST__TO_TRANSFORME_WINDINGS:
				return ((InternalEList)getTo_TransformeWindings()).basicRemove(otherEnd, msgs);
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
			case WirePackage.WINDING_TEST__EXCITING_CURRENT:
				return getExcitingCurrent();
			case WirePackage.WINDING_TEST__FROM_TAP_STEP:
				return getFromTapStep();
			case WirePackage.WINDING_TEST__LEAKAGE_IMPEDANCE:
				return getLeakageImpedance();
			case WirePackage.WINDING_TEST__LOAD_LOSS:
				return getLoadLoss();
			case WirePackage.WINDING_TEST__NO_LOAD_LOSS:
				return getNoLoadLoss();
			case WirePackage.WINDING_TEST__PHASE_SHIFT:
				return getPhaseShift();
			case WirePackage.WINDING_TEST__TO_TAP_STEP:
				return getToTapStep();
			case WirePackage.WINDING_TEST__VOLTAGE:
				return getVoltage();
			case WirePackage.WINDING_TEST__FROM_TRANSFORMER_WINDING:
				if (resolve) return getFrom_TransformerWinding();
				return basicGetFrom_TransformerWinding();
			case WirePackage.WINDING_TEST__TO_TRANSFORME_WINDINGS:
				return getTo_TransformeWindings();
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
			case WirePackage.WINDING_TEST__EXCITING_CURRENT:
				setExcitingCurrent((ExcitingCurrent)newValue);
				return;
			case WirePackage.WINDING_TEST__FROM_TAP_STEP:
				setFromTapStep((TapStep)newValue);
				return;
			case WirePackage.WINDING_TEST__LEAKAGE_IMPEDANCE:
				setLeakageImpedance((Impedance)newValue);
				return;
			case WirePackage.WINDING_TEST__LOAD_LOSS:
				setLoadLoss((LoadLoss)newValue);
				return;
			case WirePackage.WINDING_TEST__NO_LOAD_LOSS:
				setNoLoadLoss((NoLoadLoss)newValue);
				return;
			case WirePackage.WINDING_TEST__PHASE_SHIFT:
				setPhaseShift((AngleDegrees)newValue);
				return;
			case WirePackage.WINDING_TEST__TO_TAP_STEP:
				setToTapStep((TapStep)newValue);
				return;
			case WirePackage.WINDING_TEST__VOLTAGE:
				setVoltage((Voltage)newValue);
				return;
			case WirePackage.WINDING_TEST__FROM_TRANSFORMER_WINDING:
				setFrom_TransformerWinding((TransformerWinding)newValue);
				return;
			case WirePackage.WINDING_TEST__TO_TRANSFORME_WINDINGS:
				getTo_TransformeWindings().clear();
				getTo_TransformeWindings().addAll((Collection)newValue);
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
			case WirePackage.WINDING_TEST__EXCITING_CURRENT:
				setExcitingCurrent(EXCITING_CURRENT_EDEFAULT);
				return;
			case WirePackage.WINDING_TEST__FROM_TAP_STEP:
				setFromTapStep(FROM_TAP_STEP_EDEFAULT);
				return;
			case WirePackage.WINDING_TEST__LEAKAGE_IMPEDANCE:
				setLeakageImpedance(LEAKAGE_IMPEDANCE_EDEFAULT);
				return;
			case WirePackage.WINDING_TEST__LOAD_LOSS:
				setLoadLoss(LOAD_LOSS_EDEFAULT);
				return;
			case WirePackage.WINDING_TEST__NO_LOAD_LOSS:
				setNoLoadLoss(NO_LOAD_LOSS_EDEFAULT);
				return;
			case WirePackage.WINDING_TEST__PHASE_SHIFT:
				setPhaseShift(PHASE_SHIFT_EDEFAULT);
				return;
			case WirePackage.WINDING_TEST__TO_TAP_STEP:
				setToTapStep(TO_TAP_STEP_EDEFAULT);
				return;
			case WirePackage.WINDING_TEST__VOLTAGE:
				setVoltage(VOLTAGE_EDEFAULT);
				return;
			case WirePackage.WINDING_TEST__FROM_TRANSFORMER_WINDING:
				setFrom_TransformerWinding((TransformerWinding)null);
				return;
			case WirePackage.WINDING_TEST__TO_TRANSFORME_WINDINGS:
				getTo_TransformeWindings().clear();
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
			case WirePackage.WINDING_TEST__EXCITING_CURRENT:
				return EXCITING_CURRENT_EDEFAULT == null ? excitingCurrent != null : !EXCITING_CURRENT_EDEFAULT.equals(excitingCurrent);
			case WirePackage.WINDING_TEST__FROM_TAP_STEP:
				return FROM_TAP_STEP_EDEFAULT == null ? fromTapStep != null : !FROM_TAP_STEP_EDEFAULT.equals(fromTapStep);
			case WirePackage.WINDING_TEST__LEAKAGE_IMPEDANCE:
				return LEAKAGE_IMPEDANCE_EDEFAULT == null ? leakageImpedance != null : !LEAKAGE_IMPEDANCE_EDEFAULT.equals(leakageImpedance);
			case WirePackage.WINDING_TEST__LOAD_LOSS:
				return LOAD_LOSS_EDEFAULT == null ? loadLoss != null : !LOAD_LOSS_EDEFAULT.equals(loadLoss);
			case WirePackage.WINDING_TEST__NO_LOAD_LOSS:
				return NO_LOAD_LOSS_EDEFAULT == null ? noLoadLoss != null : !NO_LOAD_LOSS_EDEFAULT.equals(noLoadLoss);
			case WirePackage.WINDING_TEST__PHASE_SHIFT:
				return PHASE_SHIFT_EDEFAULT == null ? phaseShift != null : !PHASE_SHIFT_EDEFAULT.equals(phaseShift);
			case WirePackage.WINDING_TEST__TO_TAP_STEP:
				return TO_TAP_STEP_EDEFAULT == null ? toTapStep != null : !TO_TAP_STEP_EDEFAULT.equals(toTapStep);
			case WirePackage.WINDING_TEST__VOLTAGE:
				return VOLTAGE_EDEFAULT == null ? voltage != null : !VOLTAGE_EDEFAULT.equals(voltage);
			case WirePackage.WINDING_TEST__FROM_TRANSFORMER_WINDING:
				return from_TransformerWinding != null;
			case WirePackage.WINDING_TEST__TO_TRANSFORME_WINDINGS:
				return to_TransformeWindings != null && !to_TransformeWindings.isEmpty();
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
		result.append(" (excitingCurrent: ");
		result.append(excitingCurrent);
		result.append(", fromTapStep: ");
		result.append(fromTapStep);
		result.append(", leakageImpedance: ");
		result.append(leakageImpedance);
		result.append(", loadLoss: ");
		result.append(loadLoss);
		result.append(", noLoadLoss: ");
		result.append(noLoadLoss);
		result.append(", phaseShift: ");
		result.append(phaseShift);
		result.append(", toTapStep: ");
		result.append(toTapStep);
		result.append(", voltage: ");
		result.append(voltage);
		result.append(')');
		return result.toString();
	}

} //WindingTestImpl