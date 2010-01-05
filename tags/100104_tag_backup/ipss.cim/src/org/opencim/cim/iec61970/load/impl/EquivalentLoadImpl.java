/**
 * <copyright>
 * </copyright>
 *
 * $Id: EquivalentLoadImpl.java,v 1.1 2007/03/02 14:01:00 mzhou Exp $
 */
package org.opencim.cim.iec61970.load.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.load.EquivalentLoad;
import org.opencim.cim.iec61970.load.LoadPackage;

import org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl;

import org.opencim.datatype.real.CurrentFlow;
import org.opencim.datatype.real.PerCent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equivalent Load</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.EquivalentLoadImpl#getFeederLoadMgtFactor <em>Feeder Load Mgt Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.EquivalentLoadImpl#getMVArColdPickUpFactor <em>MV Ar Cold Pick Up Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.EquivalentLoadImpl#getMWColdPickUpFactor <em>MW Cold Pick Up Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.EquivalentLoadImpl#getPhaseAmpRating <em>Phase Amp Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.EquivalentLoadImpl#getLoadAllocationFactor <em>Load Allocation Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquivalentLoadImpl extends EnergyConsumerImpl implements EquivalentLoad {
	/**
	 * The default value of the '{@link #getFeederLoadMgtFactor() <em>Feeder Load Mgt Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeederLoadMgtFactor()
	 * @generated
	 * @ordered
	 */
	protected static final PerCent FEEDER_LOAD_MGT_FACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeederLoadMgtFactor() <em>Feeder Load Mgt Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeederLoadMgtFactor()
	 * @generated
	 * @ordered
	 */
	protected PerCent feederLoadMgtFactor = FEEDER_LOAD_MGT_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getMVArColdPickUpFactor() <em>MV Ar Cold Pick Up Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMVArColdPickUpFactor()
	 * @generated
	 * @ordered
	 */
	protected static final PerCent MV_AR_COLD_PICK_UP_FACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMVArColdPickUpFactor() <em>MV Ar Cold Pick Up Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMVArColdPickUpFactor()
	 * @generated
	 * @ordered
	 */
	protected PerCent mVArColdPickUpFactor = MV_AR_COLD_PICK_UP_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getMWColdPickUpFactor() <em>MW Cold Pick Up Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMWColdPickUpFactor()
	 * @generated
	 * @ordered
	 */
	protected static final PerCent MW_COLD_PICK_UP_FACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMWColdPickUpFactor() <em>MW Cold Pick Up Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMWColdPickUpFactor()
	 * @generated
	 * @ordered
	 */
	protected PerCent mWColdPickUpFactor = MW_COLD_PICK_UP_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getPhaseAmpRating() <em>Phase Amp Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhaseAmpRating()
	 * @generated
	 * @ordered
	 */
	protected static final CurrentFlow PHASE_AMP_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhaseAmpRating() <em>Phase Amp Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhaseAmpRating()
	 * @generated
	 * @ordered
	 */
	protected CurrentFlow phaseAmpRating = PHASE_AMP_RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getLoadAllocationFactor() <em>Load Allocation Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadAllocationFactor()
	 * @generated
	 * @ordered
	 */
	protected static final Float LOAD_ALLOCATION_FACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLoadAllocationFactor() <em>Load Allocation Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadAllocationFactor()
	 * @generated
	 * @ordered
	 */
	protected Float loadAllocationFactor = LOAD_ALLOCATION_FACTOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquivalentLoadImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LoadPackage.Literals.EQUIVALENT_LOAD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent getFeederLoadMgtFactor() {
		return feederLoadMgtFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeederLoadMgtFactor(PerCent newFeederLoadMgtFactor) {
		PerCent oldFeederLoadMgtFactor = feederLoadMgtFactor;
		feederLoadMgtFactor = newFeederLoadMgtFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.EQUIVALENT_LOAD__FEEDER_LOAD_MGT_FACTOR, oldFeederLoadMgtFactor, feederLoadMgtFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent getMVArColdPickUpFactor() {
		return mVArColdPickUpFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMVArColdPickUpFactor(PerCent newMVArColdPickUpFactor) {
		PerCent oldMVArColdPickUpFactor = mVArColdPickUpFactor;
		mVArColdPickUpFactor = newMVArColdPickUpFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.EQUIVALENT_LOAD__MV_AR_COLD_PICK_UP_FACTOR, oldMVArColdPickUpFactor, mVArColdPickUpFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent getMWColdPickUpFactor() {
		return mWColdPickUpFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMWColdPickUpFactor(PerCent newMWColdPickUpFactor) {
		PerCent oldMWColdPickUpFactor = mWColdPickUpFactor;
		mWColdPickUpFactor = newMWColdPickUpFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.EQUIVALENT_LOAD__MW_COLD_PICK_UP_FACTOR, oldMWColdPickUpFactor, mWColdPickUpFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurrentFlow getPhaseAmpRating() {
		return phaseAmpRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhaseAmpRating(CurrentFlow newPhaseAmpRating) {
		CurrentFlow oldPhaseAmpRating = phaseAmpRating;
		phaseAmpRating = newPhaseAmpRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.EQUIVALENT_LOAD__PHASE_AMP_RATING, oldPhaseAmpRating, phaseAmpRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getLoadAllocationFactor() {
		return loadAllocationFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadAllocationFactor(Float newLoadAllocationFactor) {
		Float oldLoadAllocationFactor = loadAllocationFactor;
		loadAllocationFactor = newLoadAllocationFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoadPackage.EQUIVALENT_LOAD__LOAD_ALLOCATION_FACTOR, oldLoadAllocationFactor, loadAllocationFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LoadPackage.EQUIVALENT_LOAD__FEEDER_LOAD_MGT_FACTOR:
				return getFeederLoadMgtFactor();
			case LoadPackage.EQUIVALENT_LOAD__MV_AR_COLD_PICK_UP_FACTOR:
				return getMVArColdPickUpFactor();
			case LoadPackage.EQUIVALENT_LOAD__MW_COLD_PICK_UP_FACTOR:
				return getMWColdPickUpFactor();
			case LoadPackage.EQUIVALENT_LOAD__PHASE_AMP_RATING:
				return getPhaseAmpRating();
			case LoadPackage.EQUIVALENT_LOAD__LOAD_ALLOCATION_FACTOR:
				return getLoadAllocationFactor();
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
			case LoadPackage.EQUIVALENT_LOAD__FEEDER_LOAD_MGT_FACTOR:
				setFeederLoadMgtFactor((PerCent)newValue);
				return;
			case LoadPackage.EQUIVALENT_LOAD__MV_AR_COLD_PICK_UP_FACTOR:
				setMVArColdPickUpFactor((PerCent)newValue);
				return;
			case LoadPackage.EQUIVALENT_LOAD__MW_COLD_PICK_UP_FACTOR:
				setMWColdPickUpFactor((PerCent)newValue);
				return;
			case LoadPackage.EQUIVALENT_LOAD__PHASE_AMP_RATING:
				setPhaseAmpRating((CurrentFlow)newValue);
				return;
			case LoadPackage.EQUIVALENT_LOAD__LOAD_ALLOCATION_FACTOR:
				setLoadAllocationFactor((Float)newValue);
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
			case LoadPackage.EQUIVALENT_LOAD__FEEDER_LOAD_MGT_FACTOR:
				setFeederLoadMgtFactor(FEEDER_LOAD_MGT_FACTOR_EDEFAULT);
				return;
			case LoadPackage.EQUIVALENT_LOAD__MV_AR_COLD_PICK_UP_FACTOR:
				setMVArColdPickUpFactor(MV_AR_COLD_PICK_UP_FACTOR_EDEFAULT);
				return;
			case LoadPackage.EQUIVALENT_LOAD__MW_COLD_PICK_UP_FACTOR:
				setMWColdPickUpFactor(MW_COLD_PICK_UP_FACTOR_EDEFAULT);
				return;
			case LoadPackage.EQUIVALENT_LOAD__PHASE_AMP_RATING:
				setPhaseAmpRating(PHASE_AMP_RATING_EDEFAULT);
				return;
			case LoadPackage.EQUIVALENT_LOAD__LOAD_ALLOCATION_FACTOR:
				setLoadAllocationFactor(LOAD_ALLOCATION_FACTOR_EDEFAULT);
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
			case LoadPackage.EQUIVALENT_LOAD__FEEDER_LOAD_MGT_FACTOR:
				return FEEDER_LOAD_MGT_FACTOR_EDEFAULT == null ? feederLoadMgtFactor != null : !FEEDER_LOAD_MGT_FACTOR_EDEFAULT.equals(feederLoadMgtFactor);
			case LoadPackage.EQUIVALENT_LOAD__MV_AR_COLD_PICK_UP_FACTOR:
				return MV_AR_COLD_PICK_UP_FACTOR_EDEFAULT == null ? mVArColdPickUpFactor != null : !MV_AR_COLD_PICK_UP_FACTOR_EDEFAULT.equals(mVArColdPickUpFactor);
			case LoadPackage.EQUIVALENT_LOAD__MW_COLD_PICK_UP_FACTOR:
				return MW_COLD_PICK_UP_FACTOR_EDEFAULT == null ? mWColdPickUpFactor != null : !MW_COLD_PICK_UP_FACTOR_EDEFAULT.equals(mWColdPickUpFactor);
			case LoadPackage.EQUIVALENT_LOAD__PHASE_AMP_RATING:
				return PHASE_AMP_RATING_EDEFAULT == null ? phaseAmpRating != null : !PHASE_AMP_RATING_EDEFAULT.equals(phaseAmpRating);
			case LoadPackage.EQUIVALENT_LOAD__LOAD_ALLOCATION_FACTOR:
				return LOAD_ALLOCATION_FACTOR_EDEFAULT == null ? loadAllocationFactor != null : !LOAD_ALLOCATION_FACTOR_EDEFAULT.equals(loadAllocationFactor);
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
		result.append(" (feederLoadMgtFactor: ");
		result.append(feederLoadMgtFactor);
		result.append(", mVArColdPickUpFactor: ");
		result.append(mVArColdPickUpFactor);
		result.append(", mWColdPickUpFactor: ");
		result.append(mWColdPickUpFactor);
		result.append(", phaseAmpRating: ");
		result.append(phaseAmpRating);
		result.append(", loadAllocationFactor: ");
		result.append(loadAllocationFactor);
		result.append(')');
		return result.toString();
	}

} //EquivalentLoadImpl