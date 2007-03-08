/**
 * <copyright>
 * </copyright>
 *
 * $Id: CombustionTurbineImpl.java,v 1.2 2007/03/04 17:58:11 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.generationdynamics.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opencim.cim.iec61970.gen.generationdynamics.CTTempMWCurve;
import org.opencim.cim.iec61970.gen.generationdynamics.CombustionTurbine;
import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;
import org.opencim.cim.iec61970.gen.generationdynamics.HeatRecoveryBoiler;

import org.opencim.cim.iec61970.gen.production.AirCompressor;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;

import org.opencim.datatype.real.PU;
import org.opencim.datatype.real.PowerVersusFrequency;
import org.opencim.datatype.real.PowerVersusVoltage;
import org.opencim.datatype.real.Seconds;
import org.opencim.datatype.real.Temperature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Combustion Turbine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.CombustionTurbineImpl#getAmbientTemp <em>Ambient Temp</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.CombustionTurbineImpl#getAuxPowerVersusFrequency <em>Aux Power Versus Frequency</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.CombustionTurbineImpl#getAuxPowerVersusVoltage <em>Aux Power Versus Voltage</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.CombustionTurbineImpl#getCapabilityVersusFrequency <em>Capability Versus Frequency</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.CombustionTurbineImpl#getHeatRecoveryFlag <em>Heat Recovery Flag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.CombustionTurbineImpl#getPowerVariationByTemp <em>Power Variation By Temp</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.CombustionTurbineImpl#getReferenceTemp <em>Reference Temp</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.CombustionTurbineImpl#getTimeConstant <em>Time Constant</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.CombustionTurbineImpl#getHeatRecoveryBoiler <em>Heat Recovery Boiler</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.CombustionTurbineImpl#getCTTempMWCurve <em>CT Temp MW Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.generationdynamics.impl.CombustionTurbineImpl#getAirCompressor <em>Air Compressor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CombustionTurbineImpl extends PrimeMoverImpl implements CombustionTurbine {
	/**
	 * The default value of the '{@link #getAmbientTemp() <em>Ambient Temp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmbientTemp()
	 * @generated
	 * @ordered
	 */
	protected static final Temperature AMBIENT_TEMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAmbientTemp() <em>Ambient Temp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmbientTemp()
	 * @generated
	 * @ordered
	 */
	protected Temperature ambientTemp = AMBIENT_TEMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuxPowerVersusFrequency() <em>Aux Power Versus Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuxPowerVersusFrequency()
	 * @generated
	 * @ordered
	 */
	protected static final PowerVersusFrequency AUX_POWER_VERSUS_FREQUENCY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuxPowerVersusFrequency() <em>Aux Power Versus Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuxPowerVersusFrequency()
	 * @generated
	 * @ordered
	 */
	protected PowerVersusFrequency auxPowerVersusFrequency = AUX_POWER_VERSUS_FREQUENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuxPowerVersusVoltage() <em>Aux Power Versus Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuxPowerVersusVoltage()
	 * @generated
	 * @ordered
	 */
	protected static final PowerVersusVoltage AUX_POWER_VERSUS_VOLTAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuxPowerVersusVoltage() <em>Aux Power Versus Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuxPowerVersusVoltage()
	 * @generated
	 * @ordered
	 */
	protected PowerVersusVoltage auxPowerVersusVoltage = AUX_POWER_VERSUS_VOLTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCapabilityVersusFrequency() <em>Capability Versus Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapabilityVersusFrequency()
	 * @generated
	 * @ordered
	 */
	protected static final PowerVersusFrequency CAPABILITY_VERSUS_FREQUENCY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCapabilityVersusFrequency() <em>Capability Versus Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapabilityVersusFrequency()
	 * @generated
	 * @ordered
	 */
	protected PowerVersusFrequency capabilityVersusFrequency = CAPABILITY_VERSUS_FREQUENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeatRecoveryFlag() <em>Heat Recovery Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeatRecoveryFlag()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean HEAT_RECOVERY_FLAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeatRecoveryFlag() <em>Heat Recovery Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeatRecoveryFlag()
	 * @generated
	 * @ordered
	 */
	protected Boolean heatRecoveryFlag = HEAT_RECOVERY_FLAG_EDEFAULT;

	/**
	 * The default value of the '{@link #getPowerVariationByTemp() <em>Power Variation By Temp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPowerVariationByTemp()
	 * @generated
	 * @ordered
	 */
	protected static final PU POWER_VARIATION_BY_TEMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPowerVariationByTemp() <em>Power Variation By Temp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPowerVariationByTemp()
	 * @generated
	 * @ordered
	 */
	protected PU powerVariationByTemp = POWER_VARIATION_BY_TEMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getReferenceTemp() <em>Reference Temp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceTemp()
	 * @generated
	 * @ordered
	 */
	protected static final Temperature REFERENCE_TEMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferenceTemp() <em>Reference Temp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceTemp()
	 * @generated
	 * @ordered
	 */
	protected Temperature referenceTemp = REFERENCE_TEMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeConstant() <em>Time Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeConstant()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds TIME_CONSTANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeConstant() <em>Time Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeConstant()
	 * @generated
	 * @ordered
	 */
	protected Seconds timeConstant = TIME_CONSTANT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHeatRecoveryBoiler() <em>Heat Recovery Boiler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeatRecoveryBoiler()
	 * @generated
	 * @ordered
	 */
	protected HeatRecoveryBoiler heatRecoveryBoiler = null;

	/**
	 * The cached value of the '{@link #getCTTempMWCurve() <em>CT Temp MW Curve</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCTTempMWCurve()
	 * @generated
	 * @ordered
	 */
	protected CTTempMWCurve ctTempMWCurve = null;

	/**
	 * The cached value of the '{@link #getAirCompressor() <em>Air Compressor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAirCompressor()
	 * @generated
	 * @ordered
	 */
	protected AirCompressor airCompressor = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CombustionTurbineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenerationdynamicsPackage.Literals.COMBUSTION_TURBINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Temperature getAmbientTemp() {
		return ambientTemp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAmbientTemp(Temperature newAmbientTemp) {
		Temperature oldAmbientTemp = ambientTemp;
		ambientTemp = newAmbientTemp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.COMBUSTION_TURBINE__AMBIENT_TEMP, oldAmbientTemp, ambientTemp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerVersusFrequency getAuxPowerVersusFrequency() {
		return auxPowerVersusFrequency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuxPowerVersusFrequency(PowerVersusFrequency newAuxPowerVersusFrequency) {
		PowerVersusFrequency oldAuxPowerVersusFrequency = auxPowerVersusFrequency;
		auxPowerVersusFrequency = newAuxPowerVersusFrequency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.COMBUSTION_TURBINE__AUX_POWER_VERSUS_FREQUENCY, oldAuxPowerVersusFrequency, auxPowerVersusFrequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerVersusVoltage getAuxPowerVersusVoltage() {
		return auxPowerVersusVoltage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuxPowerVersusVoltage(PowerVersusVoltage newAuxPowerVersusVoltage) {
		PowerVersusVoltage oldAuxPowerVersusVoltage = auxPowerVersusVoltage;
		auxPowerVersusVoltage = newAuxPowerVersusVoltage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.COMBUSTION_TURBINE__AUX_POWER_VERSUS_VOLTAGE, oldAuxPowerVersusVoltage, auxPowerVersusVoltage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerVersusFrequency getCapabilityVersusFrequency() {
		return capabilityVersusFrequency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVersusFrequency(PowerVersusFrequency newCapabilityVersusFrequency) {
		PowerVersusFrequency oldCapabilityVersusFrequency = capabilityVersusFrequency;
		capabilityVersusFrequency = newCapabilityVersusFrequency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.COMBUSTION_TURBINE__CAPABILITY_VERSUS_FREQUENCY, oldCapabilityVersusFrequency, capabilityVersusFrequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getHeatRecoveryFlag() {
		return heatRecoveryFlag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeatRecoveryFlag(Boolean newHeatRecoveryFlag) {
		Boolean oldHeatRecoveryFlag = heatRecoveryFlag;
		heatRecoveryFlag = newHeatRecoveryFlag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_FLAG, oldHeatRecoveryFlag, heatRecoveryFlag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PU getPowerVariationByTemp() {
		return powerVariationByTemp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPowerVariationByTemp(PU newPowerVariationByTemp) {
		PU oldPowerVariationByTemp = powerVariationByTemp;
		powerVariationByTemp = newPowerVariationByTemp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.COMBUSTION_TURBINE__POWER_VARIATION_BY_TEMP, oldPowerVariationByTemp, powerVariationByTemp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Temperature getReferenceTemp() {
		return referenceTemp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceTemp(Temperature newReferenceTemp) {
		Temperature oldReferenceTemp = referenceTemp;
		referenceTemp = newReferenceTemp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.COMBUSTION_TURBINE__REFERENCE_TEMP, oldReferenceTemp, referenceTemp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getTimeConstant() {
		return timeConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeConstant(Seconds newTimeConstant) {
		Seconds oldTimeConstant = timeConstant;
		timeConstant = newTimeConstant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.COMBUSTION_TURBINE__TIME_CONSTANT, oldTimeConstant, timeConstant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeatRecoveryBoiler getHeatRecoveryBoiler() {
		if (heatRecoveryBoiler != null && heatRecoveryBoiler.eIsProxy()) {
			InternalEObject oldHeatRecoveryBoiler = (InternalEObject)heatRecoveryBoiler;
			heatRecoveryBoiler = (HeatRecoveryBoiler)eResolveProxy(oldHeatRecoveryBoiler);
			if (heatRecoveryBoiler != oldHeatRecoveryBoiler) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_BOILER, oldHeatRecoveryBoiler, heatRecoveryBoiler));
			}
		}
		return heatRecoveryBoiler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeatRecoveryBoiler basicGetHeatRecoveryBoiler() {
		return heatRecoveryBoiler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeatRecoveryBoiler(HeatRecoveryBoiler newHeatRecoveryBoiler, NotificationChain msgs) {
		HeatRecoveryBoiler oldHeatRecoveryBoiler = heatRecoveryBoiler;
		heatRecoveryBoiler = newHeatRecoveryBoiler;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_BOILER, oldHeatRecoveryBoiler, newHeatRecoveryBoiler);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeatRecoveryBoiler(HeatRecoveryBoiler newHeatRecoveryBoiler) {
		if (newHeatRecoveryBoiler != heatRecoveryBoiler) {
			NotificationChain msgs = null;
			if (heatRecoveryBoiler != null)
				msgs = ((InternalEObject)heatRecoveryBoiler).eInverseRemove(this, GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__COMBUSTION_TURBINES, HeatRecoveryBoiler.class, msgs);
			if (newHeatRecoveryBoiler != null)
				msgs = ((InternalEObject)newHeatRecoveryBoiler).eInverseAdd(this, GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__COMBUSTION_TURBINES, HeatRecoveryBoiler.class, msgs);
			msgs = basicSetHeatRecoveryBoiler(newHeatRecoveryBoiler, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_BOILER, newHeatRecoveryBoiler, newHeatRecoveryBoiler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CTTempMWCurve getCTTempMWCurve() {
		return ctTempMWCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCTTempMWCurve(CTTempMWCurve newCTTempMWCurve, NotificationChain msgs) {
		CTTempMWCurve oldCTTempMWCurve = ctTempMWCurve;
		ctTempMWCurve = newCTTempMWCurve;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.COMBUSTION_TURBINE__CT_TEMP_MW_CURVE, oldCTTempMWCurve, newCTTempMWCurve);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCTTempMWCurve(CTTempMWCurve newCTTempMWCurve) {
		if (newCTTempMWCurve != ctTempMWCurve) {
			NotificationChain msgs = null;
			if (ctTempMWCurve != null)
				msgs = ((InternalEObject)ctTempMWCurve).eInverseRemove(this, GenerationdynamicsPackage.CT_TEMP_MW_CURVE__COMBUSTION_TURBINE, CTTempMWCurve.class, msgs);
			if (newCTTempMWCurve != null)
				msgs = ((InternalEObject)newCTTempMWCurve).eInverseAdd(this, GenerationdynamicsPackage.CT_TEMP_MW_CURVE__COMBUSTION_TURBINE, CTTempMWCurve.class, msgs);
			msgs = basicSetCTTempMWCurve(newCTTempMWCurve, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.COMBUSTION_TURBINE__CT_TEMP_MW_CURVE, newCTTempMWCurve, newCTTempMWCurve));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AirCompressor getAirCompressor() {
		if (airCompressor != null && airCompressor.eIsProxy()) {
			InternalEObject oldAirCompressor = (InternalEObject)airCompressor;
			airCompressor = (AirCompressor)eResolveProxy(oldAirCompressor);
			if (airCompressor != oldAirCompressor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenerationdynamicsPackage.COMBUSTION_TURBINE__AIR_COMPRESSOR, oldAirCompressor, airCompressor));
			}
		}
		return airCompressor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AirCompressor basicGetAirCompressor() {
		return airCompressor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAirCompressor(AirCompressor newAirCompressor, NotificationChain msgs) {
		AirCompressor oldAirCompressor = airCompressor;
		airCompressor = newAirCompressor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.COMBUSTION_TURBINE__AIR_COMPRESSOR, oldAirCompressor, newAirCompressor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAirCompressor(AirCompressor newAirCompressor) {
		if (newAirCompressor != airCompressor) {
			NotificationChain msgs = null;
			if (airCompressor != null)
				msgs = ((InternalEObject)airCompressor).eInverseRemove(this, ProductionPackage.AIR_COMPRESSOR__COMBUSTION_TURBINE, AirCompressor.class, msgs);
			if (newAirCompressor != null)
				msgs = ((InternalEObject)newAirCompressor).eInverseAdd(this, ProductionPackage.AIR_COMPRESSOR__COMBUSTION_TURBINE, AirCompressor.class, msgs);
			msgs = basicSetAirCompressor(newAirCompressor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenerationdynamicsPackage.COMBUSTION_TURBINE__AIR_COMPRESSOR, newAirCompressor, newAirCompressor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_BOILER:
				if (heatRecoveryBoiler != null)
					msgs = ((InternalEObject)heatRecoveryBoiler).eInverseRemove(this, GenerationdynamicsPackage.HEAT_RECOVERY_BOILER__COMBUSTION_TURBINES, HeatRecoveryBoiler.class, msgs);
				return basicSetHeatRecoveryBoiler((HeatRecoveryBoiler)otherEnd, msgs);
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__CT_TEMP_MW_CURVE:
				if (ctTempMWCurve != null)
					msgs = ((InternalEObject)ctTempMWCurve).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GenerationdynamicsPackage.COMBUSTION_TURBINE__CT_TEMP_MW_CURVE, null, msgs);
				return basicSetCTTempMWCurve((CTTempMWCurve)otherEnd, msgs);
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AIR_COMPRESSOR:
				if (airCompressor != null)
					msgs = ((InternalEObject)airCompressor).eInverseRemove(this, ProductionPackage.AIR_COMPRESSOR__COMBUSTION_TURBINE, AirCompressor.class, msgs);
				return basicSetAirCompressor((AirCompressor)otherEnd, msgs);
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
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_BOILER:
				return basicSetHeatRecoveryBoiler(null, msgs);
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__CT_TEMP_MW_CURVE:
				return basicSetCTTempMWCurve(null, msgs);
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AIR_COMPRESSOR:
				return basicSetAirCompressor(null, msgs);
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
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AMBIENT_TEMP:
				return getAmbientTemp();
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AUX_POWER_VERSUS_FREQUENCY:
				return getAuxPowerVersusFrequency();
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AUX_POWER_VERSUS_VOLTAGE:
				return getAuxPowerVersusVoltage();
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__CAPABILITY_VERSUS_FREQUENCY:
				return getCapabilityVersusFrequency();
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_FLAG:
				return getHeatRecoveryFlag();
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__POWER_VARIATION_BY_TEMP:
				return getPowerVariationByTemp();
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__REFERENCE_TEMP:
				return getReferenceTemp();
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__TIME_CONSTANT:
				return getTimeConstant();
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_BOILER:
				if (resolve) return getHeatRecoveryBoiler();
				return basicGetHeatRecoveryBoiler();
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__CT_TEMP_MW_CURVE:
				return getCTTempMWCurve();
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AIR_COMPRESSOR:
				if (resolve) return getAirCompressor();
				return basicGetAirCompressor();
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
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AMBIENT_TEMP:
				setAmbientTemp((Temperature)newValue);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AUX_POWER_VERSUS_FREQUENCY:
				setAuxPowerVersusFrequency((PowerVersusFrequency)newValue);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AUX_POWER_VERSUS_VOLTAGE:
				setAuxPowerVersusVoltage((PowerVersusVoltage)newValue);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__CAPABILITY_VERSUS_FREQUENCY:
				setCapabilityVersusFrequency((PowerVersusFrequency)newValue);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_FLAG:
				setHeatRecoveryFlag((Boolean)newValue);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__POWER_VARIATION_BY_TEMP:
				setPowerVariationByTemp((PU)newValue);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__REFERENCE_TEMP:
				setReferenceTemp((Temperature)newValue);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__TIME_CONSTANT:
				setTimeConstant((Seconds)newValue);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_BOILER:
				setHeatRecoveryBoiler((HeatRecoveryBoiler)newValue);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__CT_TEMP_MW_CURVE:
				setCTTempMWCurve((CTTempMWCurve)newValue);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AIR_COMPRESSOR:
				setAirCompressor((AirCompressor)newValue);
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
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AMBIENT_TEMP:
				setAmbientTemp(AMBIENT_TEMP_EDEFAULT);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AUX_POWER_VERSUS_FREQUENCY:
				setAuxPowerVersusFrequency(AUX_POWER_VERSUS_FREQUENCY_EDEFAULT);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AUX_POWER_VERSUS_VOLTAGE:
				setAuxPowerVersusVoltage(AUX_POWER_VERSUS_VOLTAGE_EDEFAULT);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__CAPABILITY_VERSUS_FREQUENCY:
				setCapabilityVersusFrequency(CAPABILITY_VERSUS_FREQUENCY_EDEFAULT);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_FLAG:
				setHeatRecoveryFlag(HEAT_RECOVERY_FLAG_EDEFAULT);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__POWER_VARIATION_BY_TEMP:
				setPowerVariationByTemp(POWER_VARIATION_BY_TEMP_EDEFAULT);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__REFERENCE_TEMP:
				setReferenceTemp(REFERENCE_TEMP_EDEFAULT);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__TIME_CONSTANT:
				setTimeConstant(TIME_CONSTANT_EDEFAULT);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_BOILER:
				setHeatRecoveryBoiler((HeatRecoveryBoiler)null);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__CT_TEMP_MW_CURVE:
				setCTTempMWCurve((CTTempMWCurve)null);
				return;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AIR_COMPRESSOR:
				setAirCompressor((AirCompressor)null);
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
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AMBIENT_TEMP:
				return AMBIENT_TEMP_EDEFAULT == null ? ambientTemp != null : !AMBIENT_TEMP_EDEFAULT.equals(ambientTemp);
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AUX_POWER_VERSUS_FREQUENCY:
				return AUX_POWER_VERSUS_FREQUENCY_EDEFAULT == null ? auxPowerVersusFrequency != null : !AUX_POWER_VERSUS_FREQUENCY_EDEFAULT.equals(auxPowerVersusFrequency);
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AUX_POWER_VERSUS_VOLTAGE:
				return AUX_POWER_VERSUS_VOLTAGE_EDEFAULT == null ? auxPowerVersusVoltage != null : !AUX_POWER_VERSUS_VOLTAGE_EDEFAULT.equals(auxPowerVersusVoltage);
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__CAPABILITY_VERSUS_FREQUENCY:
				return CAPABILITY_VERSUS_FREQUENCY_EDEFAULT == null ? capabilityVersusFrequency != null : !CAPABILITY_VERSUS_FREQUENCY_EDEFAULT.equals(capabilityVersusFrequency);
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_FLAG:
				return HEAT_RECOVERY_FLAG_EDEFAULT == null ? heatRecoveryFlag != null : !HEAT_RECOVERY_FLAG_EDEFAULT.equals(heatRecoveryFlag);
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__POWER_VARIATION_BY_TEMP:
				return POWER_VARIATION_BY_TEMP_EDEFAULT == null ? powerVariationByTemp != null : !POWER_VARIATION_BY_TEMP_EDEFAULT.equals(powerVariationByTemp);
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__REFERENCE_TEMP:
				return REFERENCE_TEMP_EDEFAULT == null ? referenceTemp != null : !REFERENCE_TEMP_EDEFAULT.equals(referenceTemp);
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__TIME_CONSTANT:
				return TIME_CONSTANT_EDEFAULT == null ? timeConstant != null : !TIME_CONSTANT_EDEFAULT.equals(timeConstant);
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__HEAT_RECOVERY_BOILER:
				return heatRecoveryBoiler != null;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__CT_TEMP_MW_CURVE:
				return ctTempMWCurve != null;
			case GenerationdynamicsPackage.COMBUSTION_TURBINE__AIR_COMPRESSOR:
				return airCompressor != null;
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
		result.append(" (ambientTemp: ");
		result.append(ambientTemp);
		result.append(", auxPowerVersusFrequency: ");
		result.append(auxPowerVersusFrequency);
		result.append(", auxPowerVersusVoltage: ");
		result.append(auxPowerVersusVoltage);
		result.append(", capabilityVersusFrequency: ");
		result.append(capabilityVersusFrequency);
		result.append(", heatRecoveryFlag: ");
		result.append(heatRecoveryFlag);
		result.append(", powerVariationByTemp: ");
		result.append(powerVariationByTemp);
		result.append(", referenceTemp: ");
		result.append(referenceTemp);
		result.append(", timeConstant: ");
		result.append(timeConstant);
		result.append(')');
		return result.toString();
	}

} //CombustionTurbineImpl