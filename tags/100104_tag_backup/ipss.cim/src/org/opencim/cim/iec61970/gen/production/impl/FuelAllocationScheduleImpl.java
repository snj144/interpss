/**
 * <copyright>
 * </copyright>
 *
 * $Id: FuelAllocationScheduleImpl.java,v 1.1 2007/03/02 14:01:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.domain.FuelType;

import org.opencim.cim.iec61970.gen.production.FossilFuel;
import org.opencim.cim.iec61970.gen.production.FuelAllocationSchedule;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fuel Allocation Schedule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FuelAllocationScheduleImpl#getFuelAllocationEndDate <em>Fuel Allocation End Date</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FuelAllocationScheduleImpl#getFuelAllocationStartDate <em>Fuel Allocation Start Date</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FuelAllocationScheduleImpl#getFuelType <em>Fuel Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FuelAllocationScheduleImpl#getMaxFuelAllocation <em>Max Fuel Allocation</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FuelAllocationScheduleImpl#getMinFuelAllocation <em>Min Fuel Allocation</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.FuelAllocationScheduleImpl#getFossilFuel <em>Fossil Fuel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FuelAllocationScheduleImpl extends CurveScheduleImpl implements FuelAllocationSchedule {
	/**
	 * The default value of the '{@link #getFuelAllocationEndDate() <em>Fuel Allocation End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelAllocationEndDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date FUEL_ALLOCATION_END_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFuelAllocationEndDate() <em>Fuel Allocation End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelAllocationEndDate()
	 * @generated
	 * @ordered
	 */
	protected Date fuelAllocationEndDate = FUEL_ALLOCATION_END_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFuelAllocationStartDate() <em>Fuel Allocation Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelAllocationStartDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date FUEL_ALLOCATION_START_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFuelAllocationStartDate() <em>Fuel Allocation Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelAllocationStartDate()
	 * @generated
	 * @ordered
	 */
	protected Date fuelAllocationStartDate = FUEL_ALLOCATION_START_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFuelType() <em>Fuel Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelType()
	 * @generated
	 * @ordered
	 */
	protected static final FuelType FUEL_TYPE_EDEFAULT = FuelType.COAL_LITERAL;

	/**
	 * The cached value of the '{@link #getFuelType() <em>Fuel Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuelType()
	 * @generated
	 * @ordered
	 */
	protected FuelType fuelType = FUEL_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxFuelAllocation() <em>Max Fuel Allocation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxFuelAllocation()
	 * @generated
	 * @ordered
	 */
	protected static final Float MAX_FUEL_ALLOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxFuelAllocation() <em>Max Fuel Allocation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxFuelAllocation()
	 * @generated
	 * @ordered
	 */
	protected Float maxFuelAllocation = MAX_FUEL_ALLOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinFuelAllocation() <em>Min Fuel Allocation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinFuelAllocation()
	 * @generated
	 * @ordered
	 */
	protected static final Float MIN_FUEL_ALLOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinFuelAllocation() <em>Min Fuel Allocation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinFuelAllocation()
	 * @generated
	 * @ordered
	 */
	protected Float minFuelAllocation = MIN_FUEL_ALLOCATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFossilFuel() <em>Fossil Fuel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFossilFuel()
	 * @generated
	 * @ordered
	 */
	protected FossilFuel fossilFuel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FuelAllocationScheduleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.FUEL_ALLOCATION_SCHEDULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getFuelAllocationEndDate() {
		return fuelAllocationEndDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuelAllocationEndDate(Date newFuelAllocationEndDate) {
		Date oldFuelAllocationEndDate = fuelAllocationEndDate;
		fuelAllocationEndDate = newFuelAllocationEndDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_END_DATE, oldFuelAllocationEndDate, fuelAllocationEndDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getFuelAllocationStartDate() {
		return fuelAllocationStartDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuelAllocationStartDate(Date newFuelAllocationStartDate) {
		Date oldFuelAllocationStartDate = fuelAllocationStartDate;
		fuelAllocationStartDate = newFuelAllocationStartDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_START_DATE, oldFuelAllocationStartDate, fuelAllocationStartDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuelType getFuelType() {
		return fuelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuelType(FuelType newFuelType) {
		FuelType oldFuelType = fuelType;
		fuelType = newFuelType == null ? FUEL_TYPE_EDEFAULT : newFuelType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_TYPE, oldFuelType, fuelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getMaxFuelAllocation() {
		return maxFuelAllocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxFuelAllocation(Float newMaxFuelAllocation) {
		Float oldMaxFuelAllocation = maxFuelAllocation;
		maxFuelAllocation = newMaxFuelAllocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FUEL_ALLOCATION_SCHEDULE__MAX_FUEL_ALLOCATION, oldMaxFuelAllocation, maxFuelAllocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getMinFuelAllocation() {
		return minFuelAllocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinFuelAllocation(Float newMinFuelAllocation) {
		Float oldMinFuelAllocation = minFuelAllocation;
		minFuelAllocation = newMinFuelAllocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FUEL_ALLOCATION_SCHEDULE__MIN_FUEL_ALLOCATION, oldMinFuelAllocation, minFuelAllocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FossilFuel getFossilFuel() {
		if (fossilFuel != null && fossilFuel.eIsProxy()) {
			InternalEObject oldFossilFuel = (InternalEObject)fossilFuel;
			fossilFuel = (FossilFuel)eResolveProxy(oldFossilFuel);
			if (fossilFuel != oldFossilFuel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FOSSIL_FUEL, oldFossilFuel, fossilFuel));
			}
		}
		return fossilFuel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FossilFuel basicGetFossilFuel() {
		return fossilFuel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFossilFuel(FossilFuel newFossilFuel, NotificationChain msgs) {
		FossilFuel oldFossilFuel = fossilFuel;
		fossilFuel = newFossilFuel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FOSSIL_FUEL, oldFossilFuel, newFossilFuel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFossilFuel(FossilFuel newFossilFuel) {
		if (newFossilFuel != fossilFuel) {
			NotificationChain msgs = null;
			if (fossilFuel != null)
				msgs = ((InternalEObject)fossilFuel).eInverseRemove(this, ProductionPackage.FOSSIL_FUEL__FUEL_ALLOCATION_SCHEDULE, FossilFuel.class, msgs);
			if (newFossilFuel != null)
				msgs = ((InternalEObject)newFossilFuel).eInverseAdd(this, ProductionPackage.FOSSIL_FUEL__FUEL_ALLOCATION_SCHEDULE, FossilFuel.class, msgs);
			msgs = basicSetFossilFuel(newFossilFuel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FOSSIL_FUEL, newFossilFuel, newFossilFuel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FOSSIL_FUEL:
				if (fossilFuel != null)
					msgs = ((InternalEObject)fossilFuel).eInverseRemove(this, ProductionPackage.FOSSIL_FUEL__FUEL_ALLOCATION_SCHEDULE, FossilFuel.class, msgs);
				return basicSetFossilFuel((FossilFuel)otherEnd, msgs);
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
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FOSSIL_FUEL:
				return basicSetFossilFuel(null, msgs);
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
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_END_DATE:
				return getFuelAllocationEndDate();
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_START_DATE:
				return getFuelAllocationStartDate();
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_TYPE:
				return getFuelType();
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__MAX_FUEL_ALLOCATION:
				return getMaxFuelAllocation();
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__MIN_FUEL_ALLOCATION:
				return getMinFuelAllocation();
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FOSSIL_FUEL:
				if (resolve) return getFossilFuel();
				return basicGetFossilFuel();
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
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_END_DATE:
				setFuelAllocationEndDate((Date)newValue);
				return;
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_START_DATE:
				setFuelAllocationStartDate((Date)newValue);
				return;
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_TYPE:
				setFuelType((FuelType)newValue);
				return;
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__MAX_FUEL_ALLOCATION:
				setMaxFuelAllocation((Float)newValue);
				return;
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__MIN_FUEL_ALLOCATION:
				setMinFuelAllocation((Float)newValue);
				return;
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FOSSIL_FUEL:
				setFossilFuel((FossilFuel)newValue);
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
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_END_DATE:
				setFuelAllocationEndDate(FUEL_ALLOCATION_END_DATE_EDEFAULT);
				return;
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_START_DATE:
				setFuelAllocationStartDate(FUEL_ALLOCATION_START_DATE_EDEFAULT);
				return;
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_TYPE:
				setFuelType(FUEL_TYPE_EDEFAULT);
				return;
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__MAX_FUEL_ALLOCATION:
				setMaxFuelAllocation(MAX_FUEL_ALLOCATION_EDEFAULT);
				return;
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__MIN_FUEL_ALLOCATION:
				setMinFuelAllocation(MIN_FUEL_ALLOCATION_EDEFAULT);
				return;
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FOSSIL_FUEL:
				setFossilFuel((FossilFuel)null);
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
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_END_DATE:
				return FUEL_ALLOCATION_END_DATE_EDEFAULT == null ? fuelAllocationEndDate != null : !FUEL_ALLOCATION_END_DATE_EDEFAULT.equals(fuelAllocationEndDate);
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_ALLOCATION_START_DATE:
				return FUEL_ALLOCATION_START_DATE_EDEFAULT == null ? fuelAllocationStartDate != null : !FUEL_ALLOCATION_START_DATE_EDEFAULT.equals(fuelAllocationStartDate);
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FUEL_TYPE:
				return fuelType != FUEL_TYPE_EDEFAULT;
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__MAX_FUEL_ALLOCATION:
				return MAX_FUEL_ALLOCATION_EDEFAULT == null ? maxFuelAllocation != null : !MAX_FUEL_ALLOCATION_EDEFAULT.equals(maxFuelAllocation);
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__MIN_FUEL_ALLOCATION:
				return MIN_FUEL_ALLOCATION_EDEFAULT == null ? minFuelAllocation != null : !MIN_FUEL_ALLOCATION_EDEFAULT.equals(minFuelAllocation);
			case ProductionPackage.FUEL_ALLOCATION_SCHEDULE__FOSSIL_FUEL:
				return fossilFuel != null;
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
		result.append(" (fuelAllocationEndDate: ");
		result.append(fuelAllocationEndDate);
		result.append(", fuelAllocationStartDate: ");
		result.append(fuelAllocationStartDate);
		result.append(", fuelType: ");
		result.append(fuelType);
		result.append(", maxFuelAllocation: ");
		result.append(maxFuelAllocation);
		result.append(", minFuelAllocation: ");
		result.append(minFuelAllocation);
		result.append(')');
		return result.toString();
	}

} //FuelAllocationScheduleImpl