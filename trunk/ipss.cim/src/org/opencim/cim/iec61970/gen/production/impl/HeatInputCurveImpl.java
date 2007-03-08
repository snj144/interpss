/**
 * <copyright>
 * </copyright>
 *
 * $Id: HeatInputCurveImpl.java,v 1.1 2007/03/02 14:01:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.gen.production.HeatInputCurve;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.HeatPerHour;
import org.opencim.datatype.real.PU;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Heat Input Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HeatInputCurveImpl#getAuxPowerOffset <em>Aux Power Offset</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HeatInputCurveImpl#getAuxPowerMult <em>Aux Power Mult</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HeatInputCurveImpl#getHeatInputEff <em>Heat Input Eff</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HeatInputCurveImpl#getHeatInputOffset <em>Heat Input Offset</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.HeatInputCurveImpl#getNetGrossMWFlag <em>Net Gross MW Flag</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HeatInputCurveImpl extends CurveScheduleImpl implements HeatInputCurve {
	/**
	 * The default value of the '{@link #getAuxPowerOffset() <em>Aux Power Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuxPowerOffset()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower AUX_POWER_OFFSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuxPowerOffset() <em>Aux Power Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuxPowerOffset()
	 * @generated
	 * @ordered
	 */
	protected ActivePower auxPowerOffset = AUX_POWER_OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuxPowerMult() <em>Aux Power Mult</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuxPowerMult()
	 * @generated
	 * @ordered
	 */
	protected static final PU AUX_POWER_MULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuxPowerMult() <em>Aux Power Mult</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuxPowerMult()
	 * @generated
	 * @ordered
	 */
	protected PU auxPowerMult = AUX_POWER_MULT_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeatInputEff() <em>Heat Input Eff</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeatInputEff()
	 * @generated
	 * @ordered
	 */
	protected static final PU HEAT_INPUT_EFF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeatInputEff() <em>Heat Input Eff</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeatInputEff()
	 * @generated
	 * @ordered
	 */
	protected PU heatInputEff = HEAT_INPUT_EFF_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeatInputOffset() <em>Heat Input Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeatInputOffset()
	 * @generated
	 * @ordered
	 */
	protected static final HeatPerHour HEAT_INPUT_OFFSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeatInputOffset() <em>Heat Input Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeatInputOffset()
	 * @generated
	 * @ordered
	 */
	protected HeatPerHour heatInputOffset = HEAT_INPUT_OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getNetGrossMWFlag() <em>Net Gross MW Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetGrossMWFlag()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean NET_GROSS_MW_FLAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNetGrossMWFlag() <em>Net Gross MW Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetGrossMWFlag()
	 * @generated
	 * @ordered
	 */
	protected Boolean netGrossMWFlag = NET_GROSS_MW_FLAG_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HeatInputCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.HEAT_INPUT_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getAuxPowerOffset() {
		return auxPowerOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuxPowerOffset(ActivePower newAuxPowerOffset) {
		ActivePower oldAuxPowerOffset = auxPowerOffset;
		auxPowerOffset = newAuxPowerOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HEAT_INPUT_CURVE__AUX_POWER_OFFSET, oldAuxPowerOffset, auxPowerOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getAuxPowerMult() {
		return auxPowerMult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuxPowerMult(PU newAuxPowerMult) {
		PU oldAuxPowerMult = auxPowerMult;
		auxPowerMult = newAuxPowerMult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HEAT_INPUT_CURVE__AUX_POWER_MULT, oldAuxPowerMult, auxPowerMult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getHeatInputEff() {
		return heatInputEff;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeatInputEff(PU newHeatInputEff) {
		PU oldHeatInputEff = heatInputEff;
		heatInputEff = newHeatInputEff;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HEAT_INPUT_CURVE__HEAT_INPUT_EFF, oldHeatInputEff, heatInputEff));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeatPerHour getHeatInputOffset() {
		return heatInputOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeatInputOffset(HeatPerHour newHeatInputOffset) {
		HeatPerHour oldHeatInputOffset = heatInputOffset;
		heatInputOffset = newHeatInputOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HEAT_INPUT_CURVE__HEAT_INPUT_OFFSET, oldHeatInputOffset, heatInputOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getNetGrossMWFlag() {
		return netGrossMWFlag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetGrossMWFlag(Boolean newNetGrossMWFlag) {
		Boolean oldNetGrossMWFlag = netGrossMWFlag;
		netGrossMWFlag = newNetGrossMWFlag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.HEAT_INPUT_CURVE__NET_GROSS_MW_FLAG, oldNetGrossMWFlag, netGrossMWFlag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProductionPackage.HEAT_INPUT_CURVE__AUX_POWER_OFFSET:
				return getAuxPowerOffset();
			case ProductionPackage.HEAT_INPUT_CURVE__AUX_POWER_MULT:
				return getAuxPowerMult();
			case ProductionPackage.HEAT_INPUT_CURVE__HEAT_INPUT_EFF:
				return getHeatInputEff();
			case ProductionPackage.HEAT_INPUT_CURVE__HEAT_INPUT_OFFSET:
				return getHeatInputOffset();
			case ProductionPackage.HEAT_INPUT_CURVE__NET_GROSS_MW_FLAG:
				return getNetGrossMWFlag();
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
			case ProductionPackage.HEAT_INPUT_CURVE__AUX_POWER_OFFSET:
				setAuxPowerOffset((ActivePower)newValue);
				return;
			case ProductionPackage.HEAT_INPUT_CURVE__AUX_POWER_MULT:
				setAuxPowerMult((PU)newValue);
				return;
			case ProductionPackage.HEAT_INPUT_CURVE__HEAT_INPUT_EFF:
				setHeatInputEff((PU)newValue);
				return;
			case ProductionPackage.HEAT_INPUT_CURVE__HEAT_INPUT_OFFSET:
				setHeatInputOffset((HeatPerHour)newValue);
				return;
			case ProductionPackage.HEAT_INPUT_CURVE__NET_GROSS_MW_FLAG:
				setNetGrossMWFlag((Boolean)newValue);
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
			case ProductionPackage.HEAT_INPUT_CURVE__AUX_POWER_OFFSET:
				setAuxPowerOffset(AUX_POWER_OFFSET_EDEFAULT);
				return;
			case ProductionPackage.HEAT_INPUT_CURVE__AUX_POWER_MULT:
				setAuxPowerMult(AUX_POWER_MULT_EDEFAULT);
				return;
			case ProductionPackage.HEAT_INPUT_CURVE__HEAT_INPUT_EFF:
				setHeatInputEff(HEAT_INPUT_EFF_EDEFAULT);
				return;
			case ProductionPackage.HEAT_INPUT_CURVE__HEAT_INPUT_OFFSET:
				setHeatInputOffset(HEAT_INPUT_OFFSET_EDEFAULT);
				return;
			case ProductionPackage.HEAT_INPUT_CURVE__NET_GROSS_MW_FLAG:
				setNetGrossMWFlag(NET_GROSS_MW_FLAG_EDEFAULT);
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
			case ProductionPackage.HEAT_INPUT_CURVE__AUX_POWER_OFFSET:
				return AUX_POWER_OFFSET_EDEFAULT == null ? auxPowerOffset != null : !AUX_POWER_OFFSET_EDEFAULT.equals(auxPowerOffset);
			case ProductionPackage.HEAT_INPUT_CURVE__AUX_POWER_MULT:
				return AUX_POWER_MULT_EDEFAULT == null ? auxPowerMult != null : !AUX_POWER_MULT_EDEFAULT.equals(auxPowerMult);
			case ProductionPackage.HEAT_INPUT_CURVE__HEAT_INPUT_EFF:
				return HEAT_INPUT_EFF_EDEFAULT == null ? heatInputEff != null : !HEAT_INPUT_EFF_EDEFAULT.equals(heatInputEff);
			case ProductionPackage.HEAT_INPUT_CURVE__HEAT_INPUT_OFFSET:
				return HEAT_INPUT_OFFSET_EDEFAULT == null ? heatInputOffset != null : !HEAT_INPUT_OFFSET_EDEFAULT.equals(heatInputOffset);
			case ProductionPackage.HEAT_INPUT_CURVE__NET_GROSS_MW_FLAG:
				return NET_GROSS_MW_FLAG_EDEFAULT == null ? netGrossMWFlag != null : !NET_GROSS_MW_FLAG_EDEFAULT.equals(netGrossMWFlag);
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
		result.append(" (auxPowerOffset: ");
		result.append(auxPowerOffset);
		result.append(", auxPowerMult: ");
		result.append(auxPowerMult);
		result.append(", heatInputEff: ");
		result.append(heatInputEff);
		result.append(", heatInputOffset: ");
		result.append(heatInputOffset);
		result.append(", netGrossMWFlag: ");
		result.append(netGrossMWFlag);
		result.append(')');
		return result.toString();
	}

} //HeatInputCurveImpl