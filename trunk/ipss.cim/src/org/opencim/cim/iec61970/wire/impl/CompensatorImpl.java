/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompensatorImpl.java,v 1.1 2007/03/02 14:00:57 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.domain.CompensatorType;

import org.opencim.cim.iec61970.wire.Compensator;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.integer.Counter;

import org.opencim.datatype.real.Admittance;
import org.opencim.datatype.real.Impedance;
import org.opencim.datatype.real.PUkVPerMVAr;
import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.ReactivePower;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.Seconds;
import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compensator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getAVRDelay <em>AVR Delay</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getImpedance <em>Impedance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getMaximumkV <em>Maximumk V</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getMaximumSections <em>Maximum Sections</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getMinimumkV <em>Minimumk V</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getMVArPerSection <em>MV Ar Per Section</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getNominalkV <em>Nominalk V</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getNominalMVAr <em>Nominal MV Ar</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getNormalSections <em>Normal Sections</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getR <em>R</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getSwitchOnCount <em>Switch On Count</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getSwitchOnDate <em>Switch On Date</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getVoltSensitivity <em>Volt Sensitivity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getX <em>X</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getYPerSection <em>YPer Section</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.CompensatorImpl#getCompensatorType <em>Compensator Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompensatorImpl extends RegulatingCondEqImpl implements Compensator {
	/**
	 * The default value of the '{@link #getAVRDelay() <em>AVR Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAVRDelay()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds AVR_DELAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAVRDelay() <em>AVR Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAVRDelay()
	 * @generated
	 * @ordered
	 */
	protected Seconds aVRDelay = AVR_DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getImpedance() <em>Impedance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpedance()
	 * @generated
	 * @ordered
	 */
	protected static final Impedance IMPEDANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImpedance() <em>Impedance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpedance()
	 * @generated
	 * @ordered
	 */
	protected Impedance impedance = IMPEDANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumkV() <em>Maximumk V</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumkV()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage MAXIMUMK_V_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumkV() <em>Maximumk V</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumkV()
	 * @generated
	 * @ordered
	 */
	protected Voltage maximumkV = MAXIMUMK_V_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumSections() <em>Maximum Sections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumSections()
	 * @generated
	 * @ordered
	 */
	protected static final Counter MAXIMUM_SECTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumSections() <em>Maximum Sections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumSections()
	 * @generated
	 * @ordered
	 */
	protected Counter maximumSections = MAXIMUM_SECTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumkV() <em>Minimumk V</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumkV()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage MINIMUMK_V_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimumkV() <em>Minimumk V</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumkV()
	 * @generated
	 * @ordered
	 */
	protected Voltage minimumkV = MINIMUMK_V_EDEFAULT;

	/**
	 * The default value of the '{@link #getMVArPerSection() <em>MV Ar Per Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMVArPerSection()
	 * @generated
	 * @ordered
	 */
	protected static final ReactivePower MV_AR_PER_SECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMVArPerSection() <em>MV Ar Per Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMVArPerSection()
	 * @generated
	 * @ordered
	 */
	protected ReactivePower mVArPerSection = MV_AR_PER_SECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getNominalkV() <em>Nominalk V</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNominalkV()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage NOMINALK_V_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNominalkV() <em>Nominalk V</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNominalkV()
	 * @generated
	 * @ordered
	 */
	protected Voltage nominalkV = NOMINALK_V_EDEFAULT;

	/**
	 * The default value of the '{@link #getNominalMVAr() <em>Nominal MV Ar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNominalMVAr()
	 * @generated
	 * @ordered
	 */
	protected static final ReactivePower NOMINAL_MV_AR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNominalMVAr() <em>Nominal MV Ar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNominalMVAr()
	 * @generated
	 * @ordered
	 */
	protected ReactivePower nominalMVAr = NOMINAL_MV_AR_EDEFAULT;

	/**
	 * The default value of the '{@link #getNormalSections() <em>Normal Sections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalSections()
	 * @generated
	 * @ordered
	 */
	protected static final Counter NORMAL_SECTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNormalSections() <em>Normal Sections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalSections()
	 * @generated
	 * @ordered
	 */
	protected Counter normalSections = NORMAL_SECTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getR() <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR()
	 * @generated
	 * @ordered
	 */
	protected static final Resistance R_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getR() <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR()
	 * @generated
	 * @ordered
	 */
	protected Resistance r = R_EDEFAULT;

	/**
	 * The default value of the '{@link #getSwitchOnCount() <em>Switch On Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitchOnCount()
	 * @generated
	 * @ordered
	 */
	protected static final Counter SWITCH_ON_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSwitchOnCount() <em>Switch On Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitchOnCount()
	 * @generated
	 * @ordered
	 */
	protected Counter switchOnCount = SWITCH_ON_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSwitchOnDate() <em>Switch On Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitchOnDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date SWITCH_ON_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSwitchOnDate() <em>Switch On Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitchOnDate()
	 * @generated
	 * @ordered
	 */
	protected Date switchOnDate = SWITCH_ON_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVoltSensitivity() <em>Volt Sensitivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoltSensitivity()
	 * @generated
	 * @ordered
	 */
	protected static final PUkVPerMVAr VOLT_SENSITIVITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVoltSensitivity() <em>Volt Sensitivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoltSensitivity()
	 * @generated
	 * @ordered
	 */
	protected PUkVPerMVAr voltSensitivity = VOLT_SENSITIVITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance X_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected Reactance x = X_EDEFAULT;

	/**
	 * The default value of the '{@link #getYPerSection() <em>YPer Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYPerSection()
	 * @generated
	 * @ordered
	 */
	protected static final Admittance YPER_SECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getYPerSection() <em>YPer Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYPerSection()
	 * @generated
	 * @ordered
	 */
	protected Admittance yPerSection = YPER_SECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompensatorType() <em>Compensator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompensatorType()
	 * @generated
	 * @ordered
	 */
	protected static final CompensatorType COMPENSATOR_TYPE_EDEFAULT = CompensatorType.SHUNT_LITERAL;

	/**
	 * The cached value of the '{@link #getCompensatorType() <em>Compensator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompensatorType()
	 * @generated
	 * @ordered
	 */
	protected CompensatorType compensatorType = COMPENSATOR_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompensatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.COMPENSATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getAVRDelay() {
		return aVRDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAVRDelay(Seconds newAVRDelay) {
		Seconds oldAVRDelay = aVRDelay;
		aVRDelay = newAVRDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__AVR_DELAY, oldAVRDelay, aVRDelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Impedance getImpedance() {
		return impedance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImpedance(Impedance newImpedance) {
		Impedance oldImpedance = impedance;
		impedance = newImpedance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__IMPEDANCE, oldImpedance, impedance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getMaximumkV() {
		return maximumkV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumkV(Voltage newMaximumkV) {
		Voltage oldMaximumkV = maximumkV;
		maximumkV = newMaximumkV;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__MAXIMUMK_V, oldMaximumkV, maximumkV));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Counter getMaximumSections() {
		return maximumSections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumSections(Counter newMaximumSections) {
		Counter oldMaximumSections = maximumSections;
		maximumSections = newMaximumSections;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__MAXIMUM_SECTIONS, oldMaximumSections, maximumSections));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getMinimumkV() {
		return minimumkV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumkV(Voltage newMinimumkV) {
		Voltage oldMinimumkV = minimumkV;
		minimumkV = newMinimumkV;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__MINIMUMK_V, oldMinimumkV, minimumkV));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReactivePower getMVArPerSection() {
		return mVArPerSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMVArPerSection(ReactivePower newMVArPerSection) {
		ReactivePower oldMVArPerSection = mVArPerSection;
		mVArPerSection = newMVArPerSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__MV_AR_PER_SECTION, oldMVArPerSection, mVArPerSection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getNominalkV() {
		return nominalkV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalkV(Voltage newNominalkV) {
		Voltage oldNominalkV = nominalkV;
		nominalkV = newNominalkV;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__NOMINALK_V, oldNominalkV, nominalkV));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReactivePower getNominalMVAr() {
		return nominalMVAr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalMVAr(ReactivePower newNominalMVAr) {
		ReactivePower oldNominalMVAr = nominalMVAr;
		nominalMVAr = newNominalMVAr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__NOMINAL_MV_AR, oldNominalMVAr, nominalMVAr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Counter getNormalSections() {
		return normalSections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormalSections(Counter newNormalSections) {
		Counter oldNormalSections = normalSections;
		normalSections = newNormalSections;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__NORMAL_SECTIONS, oldNormalSections, normalSections));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance getR() {
		return r;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setR(Resistance newR) {
		Resistance oldR = r;
		r = newR;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__R, oldR, r));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Counter getSwitchOnCount() {
		return switchOnCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwitchOnCount(Counter newSwitchOnCount) {
		Counter oldSwitchOnCount = switchOnCount;
		switchOnCount = newSwitchOnCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__SWITCH_ON_COUNT, oldSwitchOnCount, switchOnCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getSwitchOnDate() {
		return switchOnDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwitchOnDate(Date newSwitchOnDate) {
		Date oldSwitchOnDate = switchOnDate;
		switchOnDate = newSwitchOnDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__SWITCH_ON_DATE, oldSwitchOnDate, switchOnDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PUkVPerMVAr getVoltSensitivity() {
		return voltSensitivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVoltSensitivity(PUkVPerMVAr newVoltSensitivity) {
		PUkVPerMVAr oldVoltSensitivity = voltSensitivity;
		voltSensitivity = newVoltSensitivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__VOLT_SENSITIVITY, oldVoltSensitivity, voltSensitivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(Reactance newX) {
		Reactance oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Admittance getYPerSection() {
		return yPerSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYPerSection(Admittance newYPerSection) {
		Admittance oldYPerSection = yPerSection;
		yPerSection = newYPerSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__YPER_SECTION, oldYPerSection, yPerSection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompensatorType getCompensatorType() {
		return compensatorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompensatorType(CompensatorType newCompensatorType) {
		CompensatorType oldCompensatorType = compensatorType;
		compensatorType = newCompensatorType == null ? COMPENSATOR_TYPE_EDEFAULT : newCompensatorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.COMPENSATOR__COMPENSATOR_TYPE, oldCompensatorType, compensatorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WirePackage.COMPENSATOR__AVR_DELAY:
				return getAVRDelay();
			case WirePackage.COMPENSATOR__IMPEDANCE:
				return getImpedance();
			case WirePackage.COMPENSATOR__MAXIMUMK_V:
				return getMaximumkV();
			case WirePackage.COMPENSATOR__MAXIMUM_SECTIONS:
				return getMaximumSections();
			case WirePackage.COMPENSATOR__MINIMUMK_V:
				return getMinimumkV();
			case WirePackage.COMPENSATOR__MV_AR_PER_SECTION:
				return getMVArPerSection();
			case WirePackage.COMPENSATOR__NOMINALK_V:
				return getNominalkV();
			case WirePackage.COMPENSATOR__NOMINAL_MV_AR:
				return getNominalMVAr();
			case WirePackage.COMPENSATOR__NORMAL_SECTIONS:
				return getNormalSections();
			case WirePackage.COMPENSATOR__R:
				return getR();
			case WirePackage.COMPENSATOR__SWITCH_ON_COUNT:
				return getSwitchOnCount();
			case WirePackage.COMPENSATOR__SWITCH_ON_DATE:
				return getSwitchOnDate();
			case WirePackage.COMPENSATOR__VOLT_SENSITIVITY:
				return getVoltSensitivity();
			case WirePackage.COMPENSATOR__X:
				return getX();
			case WirePackage.COMPENSATOR__YPER_SECTION:
				return getYPerSection();
			case WirePackage.COMPENSATOR__COMPENSATOR_TYPE:
				return getCompensatorType();
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
			case WirePackage.COMPENSATOR__AVR_DELAY:
				setAVRDelay((Seconds)newValue);
				return;
			case WirePackage.COMPENSATOR__IMPEDANCE:
				setImpedance((Impedance)newValue);
				return;
			case WirePackage.COMPENSATOR__MAXIMUMK_V:
				setMaximumkV((Voltage)newValue);
				return;
			case WirePackage.COMPENSATOR__MAXIMUM_SECTIONS:
				setMaximumSections((Counter)newValue);
				return;
			case WirePackage.COMPENSATOR__MINIMUMK_V:
				setMinimumkV((Voltage)newValue);
				return;
			case WirePackage.COMPENSATOR__MV_AR_PER_SECTION:
				setMVArPerSection((ReactivePower)newValue);
				return;
			case WirePackage.COMPENSATOR__NOMINALK_V:
				setNominalkV((Voltage)newValue);
				return;
			case WirePackage.COMPENSATOR__NOMINAL_MV_AR:
				setNominalMVAr((ReactivePower)newValue);
				return;
			case WirePackage.COMPENSATOR__NORMAL_SECTIONS:
				setNormalSections((Counter)newValue);
				return;
			case WirePackage.COMPENSATOR__R:
				setR((Resistance)newValue);
				return;
			case WirePackage.COMPENSATOR__SWITCH_ON_COUNT:
				setSwitchOnCount((Counter)newValue);
				return;
			case WirePackage.COMPENSATOR__SWITCH_ON_DATE:
				setSwitchOnDate((Date)newValue);
				return;
			case WirePackage.COMPENSATOR__VOLT_SENSITIVITY:
				setVoltSensitivity((PUkVPerMVAr)newValue);
				return;
			case WirePackage.COMPENSATOR__X:
				setX((Reactance)newValue);
				return;
			case WirePackage.COMPENSATOR__YPER_SECTION:
				setYPerSection((Admittance)newValue);
				return;
			case WirePackage.COMPENSATOR__COMPENSATOR_TYPE:
				setCompensatorType((CompensatorType)newValue);
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
			case WirePackage.COMPENSATOR__AVR_DELAY:
				setAVRDelay(AVR_DELAY_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__IMPEDANCE:
				setImpedance(IMPEDANCE_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__MAXIMUMK_V:
				setMaximumkV(MAXIMUMK_V_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__MAXIMUM_SECTIONS:
				setMaximumSections(MAXIMUM_SECTIONS_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__MINIMUMK_V:
				setMinimumkV(MINIMUMK_V_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__MV_AR_PER_SECTION:
				setMVArPerSection(MV_AR_PER_SECTION_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__NOMINALK_V:
				setNominalkV(NOMINALK_V_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__NOMINAL_MV_AR:
				setNominalMVAr(NOMINAL_MV_AR_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__NORMAL_SECTIONS:
				setNormalSections(NORMAL_SECTIONS_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__R:
				setR(R_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__SWITCH_ON_COUNT:
				setSwitchOnCount(SWITCH_ON_COUNT_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__SWITCH_ON_DATE:
				setSwitchOnDate(SWITCH_ON_DATE_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__VOLT_SENSITIVITY:
				setVoltSensitivity(VOLT_SENSITIVITY_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__X:
				setX(X_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__YPER_SECTION:
				setYPerSection(YPER_SECTION_EDEFAULT);
				return;
			case WirePackage.COMPENSATOR__COMPENSATOR_TYPE:
				setCompensatorType(COMPENSATOR_TYPE_EDEFAULT);
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
			case WirePackage.COMPENSATOR__AVR_DELAY:
				return AVR_DELAY_EDEFAULT == null ? aVRDelay != null : !AVR_DELAY_EDEFAULT.equals(aVRDelay);
			case WirePackage.COMPENSATOR__IMPEDANCE:
				return IMPEDANCE_EDEFAULT == null ? impedance != null : !IMPEDANCE_EDEFAULT.equals(impedance);
			case WirePackage.COMPENSATOR__MAXIMUMK_V:
				return MAXIMUMK_V_EDEFAULT == null ? maximumkV != null : !MAXIMUMK_V_EDEFAULT.equals(maximumkV);
			case WirePackage.COMPENSATOR__MAXIMUM_SECTIONS:
				return MAXIMUM_SECTIONS_EDEFAULT == null ? maximumSections != null : !MAXIMUM_SECTIONS_EDEFAULT.equals(maximumSections);
			case WirePackage.COMPENSATOR__MINIMUMK_V:
				return MINIMUMK_V_EDEFAULT == null ? minimumkV != null : !MINIMUMK_V_EDEFAULT.equals(minimumkV);
			case WirePackage.COMPENSATOR__MV_AR_PER_SECTION:
				return MV_AR_PER_SECTION_EDEFAULT == null ? mVArPerSection != null : !MV_AR_PER_SECTION_EDEFAULT.equals(mVArPerSection);
			case WirePackage.COMPENSATOR__NOMINALK_V:
				return NOMINALK_V_EDEFAULT == null ? nominalkV != null : !NOMINALK_V_EDEFAULT.equals(nominalkV);
			case WirePackage.COMPENSATOR__NOMINAL_MV_AR:
				return NOMINAL_MV_AR_EDEFAULT == null ? nominalMVAr != null : !NOMINAL_MV_AR_EDEFAULT.equals(nominalMVAr);
			case WirePackage.COMPENSATOR__NORMAL_SECTIONS:
				return NORMAL_SECTIONS_EDEFAULT == null ? normalSections != null : !NORMAL_SECTIONS_EDEFAULT.equals(normalSections);
			case WirePackage.COMPENSATOR__R:
				return R_EDEFAULT == null ? r != null : !R_EDEFAULT.equals(r);
			case WirePackage.COMPENSATOR__SWITCH_ON_COUNT:
				return SWITCH_ON_COUNT_EDEFAULT == null ? switchOnCount != null : !SWITCH_ON_COUNT_EDEFAULT.equals(switchOnCount);
			case WirePackage.COMPENSATOR__SWITCH_ON_DATE:
				return SWITCH_ON_DATE_EDEFAULT == null ? switchOnDate != null : !SWITCH_ON_DATE_EDEFAULT.equals(switchOnDate);
			case WirePackage.COMPENSATOR__VOLT_SENSITIVITY:
				return VOLT_SENSITIVITY_EDEFAULT == null ? voltSensitivity != null : !VOLT_SENSITIVITY_EDEFAULT.equals(voltSensitivity);
			case WirePackage.COMPENSATOR__X:
				return X_EDEFAULT == null ? x != null : !X_EDEFAULT.equals(x);
			case WirePackage.COMPENSATOR__YPER_SECTION:
				return YPER_SECTION_EDEFAULT == null ? yPerSection != null : !YPER_SECTION_EDEFAULT.equals(yPerSection);
			case WirePackage.COMPENSATOR__COMPENSATOR_TYPE:
				return compensatorType != COMPENSATOR_TYPE_EDEFAULT;
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
		result.append(" (aVRDelay: ");
		result.append(aVRDelay);
		result.append(", impedance: ");
		result.append(impedance);
		result.append(", maximumkV: ");
		result.append(maximumkV);
		result.append(", maximumSections: ");
		result.append(maximumSections);
		result.append(", minimumkV: ");
		result.append(minimumkV);
		result.append(", mVArPerSection: ");
		result.append(mVArPerSection);
		result.append(", nominalkV: ");
		result.append(nominalkV);
		result.append(", nominalMVAr: ");
		result.append(nominalMVAr);
		result.append(", normalSections: ");
		result.append(normalSections);
		result.append(", r: ");
		result.append(r);
		result.append(", switchOnCount: ");
		result.append(switchOnCount);
		result.append(", switchOnDate: ");
		result.append(switchOnDate);
		result.append(", voltSensitivity: ");
		result.append(voltSensitivity);
		result.append(", x: ");
		result.append(x);
		result.append(", yPerSection: ");
		result.append(yPerSection);
		result.append(", compensatorType: ");
		result.append(compensatorType);
		result.append(')');
		return result.toString();
	}

} //CompensatorImpl