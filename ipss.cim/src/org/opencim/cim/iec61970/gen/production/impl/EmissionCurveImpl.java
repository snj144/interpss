/**
 * <copyright>
 * </copyright>
 *
 * $Id: EmissionCurveImpl.java,v 1.1 2007/03/02 14:01:10 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.core.impl.CurveScheduleImpl;

import org.opencim.cim.iec61970.domain.EmissionType;

import org.opencim.cim.iec61970.gen.production.EmissionCurve;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;

import org.opencim.datatype.real.Emission;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Emission Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.EmissionCurveImpl#getEmissionContent <em>Emission Content</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.EmissionCurveImpl#getEmissionType <em>Emission Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.impl.EmissionCurveImpl#getNetGrossMWFlag <em>Net Gross MW Flag</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmissionCurveImpl extends CurveScheduleImpl implements EmissionCurve {
	/**
	 * The default value of the '{@link #getEmissionContent() <em>Emission Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmissionContent()
	 * @generated
	 * @ordered
	 */
	protected static final Emission EMISSION_CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmissionContent() <em>Emission Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmissionContent()
	 * @generated
	 * @ordered
	 */
	protected Emission emissionContent = EMISSION_CONTENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getEmissionType() <em>Emission Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmissionType()
	 * @generated
	 * @ordered
	 */
	protected static final EmissionType EMISSION_TYPE_EDEFAULT = EmissionType.SULFUR_DIOXIDE_LITERAL;

	/**
	 * The cached value of the '{@link #getEmissionType() <em>Emission Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmissionType()
	 * @generated
	 * @ordered
	 */
	protected EmissionType emissionType = EMISSION_TYPE_EDEFAULT;

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
	protected EmissionCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.EMISSION_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Emission getEmissionContent() {
		return emissionContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmissionContent(Emission newEmissionContent) {
		Emission oldEmissionContent = emissionContent;
		emissionContent = newEmissionContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.EMISSION_CURVE__EMISSION_CONTENT, oldEmissionContent, emissionContent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmissionType getEmissionType() {
		return emissionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmissionType(EmissionType newEmissionType) {
		EmissionType oldEmissionType = emissionType;
		emissionType = newEmissionType == null ? EMISSION_TYPE_EDEFAULT : newEmissionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.EMISSION_CURVE__EMISSION_TYPE, oldEmissionType, emissionType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProductionPackage.EMISSION_CURVE__NET_GROSS_MW_FLAG, oldNetGrossMWFlag, netGrossMWFlag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProductionPackage.EMISSION_CURVE__EMISSION_CONTENT:
				return getEmissionContent();
			case ProductionPackage.EMISSION_CURVE__EMISSION_TYPE:
				return getEmissionType();
			case ProductionPackage.EMISSION_CURVE__NET_GROSS_MW_FLAG:
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
			case ProductionPackage.EMISSION_CURVE__EMISSION_CONTENT:
				setEmissionContent((Emission)newValue);
				return;
			case ProductionPackage.EMISSION_CURVE__EMISSION_TYPE:
				setEmissionType((EmissionType)newValue);
				return;
			case ProductionPackage.EMISSION_CURVE__NET_GROSS_MW_FLAG:
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
			case ProductionPackage.EMISSION_CURVE__EMISSION_CONTENT:
				setEmissionContent(EMISSION_CONTENT_EDEFAULT);
				return;
			case ProductionPackage.EMISSION_CURVE__EMISSION_TYPE:
				setEmissionType(EMISSION_TYPE_EDEFAULT);
				return;
			case ProductionPackage.EMISSION_CURVE__NET_GROSS_MW_FLAG:
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
			case ProductionPackage.EMISSION_CURVE__EMISSION_CONTENT:
				return EMISSION_CONTENT_EDEFAULT == null ? emissionContent != null : !EMISSION_CONTENT_EDEFAULT.equals(emissionContent);
			case ProductionPackage.EMISSION_CURVE__EMISSION_TYPE:
				return emissionType != EMISSION_TYPE_EDEFAULT;
			case ProductionPackage.EMISSION_CURVE__NET_GROSS_MW_FLAG:
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
		result.append(" (emissionContent: ");
		result.append(emissionContent);
		result.append(", emissionType: ");
		result.append(emissionType);
		result.append(", netGrossMWFlag: ");
		result.append(netGrossMWFlag);
		result.append(')');
		return result.toString();
	}

} //EmissionCurveImpl