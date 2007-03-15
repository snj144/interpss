/**
 * <copyright>
 * </copyright>
 *
 * $Id: EnergyConsumerImpl.java,v 1.3 2007/03/07 05:14:04 mzhou Exp $
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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.impl.ConductingEquipmentImpl;

import org.opencim.cim.iec61970.load.LoadArea;
import org.opencim.cim.iec61970.load.LoadDemandModel;
import org.opencim.cim.iec61970.load.LoadPackage;
import org.opencim.cim.iec61970.load.NonConformLoadSchedule;

import org.opencim.cim.iec61970.load.PowerCutZone;

import org.opencim.cim.iec61970.load.impl.LoadPackageImpl;

import org.opencim.cim.iec61970.wire.EnergyConsumer;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.integer.Counter;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.Exponent;
import org.opencim.datatype.real.PerCent;
import org.opencim.datatype.real.PowerFactor;
import org.opencim.datatype.real.ReactivePower;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Energy Consumer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getLoadDemandModels <em>Load Demand Models</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getNonConformLoadSchedules <em>Non Conform Load Schedules</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getLoadArea <em>Load Area</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getPowerCutZone <em>Power Cut Zone</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getConformingLoadFlag <em>Conforming Load Flag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getCustomerCount <em>Customer Count</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getPFexp <em>PFexp</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getPfixed <em>Pfixed</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getPfixedPct <em>Pfixed Pct</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getPnom <em>Pnom</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getPnomPct <em>Pnom Pct</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getPowerFactor <em>Power Factor</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getPVexp <em>PVexp</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getQFexp <em>QFexp</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getQfixed <em>Qfixed</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getQfixedPct <em>Qfixed Pct</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getQnom <em>Qnom</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getQnomPct <em>Qnom Pct</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.EnergyConsumerImpl#getQVexp <em>QVexp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnergyConsumerImpl extends ConductingEquipmentImpl implements EnergyConsumer {
	/**
	 * The cached value of the '{@link #getLoadDemandModels() <em>Load Demand Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadDemandModels()
	 * @generated
	 * @ordered
	 */
	protected EList loadDemandModels = null;

	/**
	 * The cached value of the '{@link #getNonConformLoadSchedules() <em>Non Conform Load Schedules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonConformLoadSchedules()
	 * @generated
	 * @ordered
	 */
	protected EList nonConformLoadSchedules = null;

	/**
	 * The cached value of the '{@link #getLoadArea() <em>Load Area</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadArea()
	 * @generated
	 * @ordered
	 */
	protected LoadArea loadArea = null;

	/**
	 * The default value of the '{@link #getConformingLoadFlag() <em>Conforming Load Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConformingLoadFlag()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean CONFORMING_LOAD_FLAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConformingLoadFlag() <em>Conforming Load Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConformingLoadFlag()
	 * @generated
	 * @ordered
	 */
	protected Boolean conformingLoadFlag = CONFORMING_LOAD_FLAG_EDEFAULT;

	/**
	 * The default value of the '{@link #getCustomerCount() <em>Customer Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerCount()
	 * @generated
	 * @ordered
	 */
	protected static final Counter CUSTOMER_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCustomerCount() <em>Customer Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerCount()
	 * @generated
	 * @ordered
	 */
	protected Counter customerCount = CUSTOMER_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPFexp() <em>PFexp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPFexp()
	 * @generated
	 * @ordered
	 */
	protected static final Exponent PFEXP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPFexp() <em>PFexp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPFexp()
	 * @generated
	 * @ordered
	 */
	protected Exponent pFexp = PFEXP_EDEFAULT;

	/**
	 * The default value of the '{@link #getPfixed() <em>Pfixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPfixed()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower PFIXED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPfixed() <em>Pfixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPfixed()
	 * @generated
	 * @ordered
	 */
	protected ActivePower pfixed = PFIXED_EDEFAULT;

	/**
	 * The default value of the '{@link #getPfixedPct() <em>Pfixed Pct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPfixedPct()
	 * @generated
	 * @ordered
	 */
	protected static final PerCent PFIXED_PCT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPfixedPct() <em>Pfixed Pct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPfixedPct()
	 * @generated
	 * @ordered
	 */
	protected PerCent pfixedPct = PFIXED_PCT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPnom() <em>Pnom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPnom()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower PNOM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPnom() <em>Pnom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPnom()
	 * @generated
	 * @ordered
	 */
	protected ActivePower pnom = PNOM_EDEFAULT;

	/**
	 * The default value of the '{@link #getPnomPct() <em>Pnom Pct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPnomPct()
	 * @generated
	 * @ordered
	 */
	protected static final PerCent PNOM_PCT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPnomPct() <em>Pnom Pct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPnomPct()
	 * @generated
	 * @ordered
	 */
	protected PerCent pnomPct = PNOM_PCT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPowerFactor() <em>Power Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPowerFactor()
	 * @generated
	 * @ordered
	 */
	protected static final PowerFactor POWER_FACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPowerFactor() <em>Power Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPowerFactor()
	 * @generated
	 * @ordered
	 */
	protected PowerFactor powerFactor = POWER_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getPVexp() <em>PVexp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPVexp()
	 * @generated
	 * @ordered
	 */
	protected static final Exponent PVEXP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPVexp() <em>PVexp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPVexp()
	 * @generated
	 * @ordered
	 */
	protected Exponent pVexp = PVEXP_EDEFAULT;

	/**
	 * The default value of the '{@link #getQFexp() <em>QFexp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQFexp()
	 * @generated
	 * @ordered
	 */
	protected static final Exponent QFEXP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQFexp() <em>QFexp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQFexp()
	 * @generated
	 * @ordered
	 */
	protected Exponent qFexp = QFEXP_EDEFAULT;

	/**
	 * The default value of the '{@link #getQfixed() <em>Qfixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQfixed()
	 * @generated
	 * @ordered
	 */
	protected static final ReactivePower QFIXED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQfixed() <em>Qfixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQfixed()
	 * @generated
	 * @ordered
	 */
	protected ReactivePower qfixed = QFIXED_EDEFAULT;

	/**
	 * The default value of the '{@link #getQfixedPct() <em>Qfixed Pct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQfixedPct()
	 * @generated
	 * @ordered
	 */
	protected static final PerCent QFIXED_PCT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQfixedPct() <em>Qfixed Pct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQfixedPct()
	 * @generated
	 * @ordered
	 */
	protected PerCent qfixedPct = QFIXED_PCT_EDEFAULT;

	/**
	 * The default value of the '{@link #getQnom() <em>Qnom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQnom()
	 * @generated
	 * @ordered
	 */
	protected static final ReactivePower QNOM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQnom() <em>Qnom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQnom()
	 * @generated
	 * @ordered
	 */
	protected ReactivePower qnom = QNOM_EDEFAULT;

	/**
	 * The default value of the '{@link #getQnomPct() <em>Qnom Pct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQnomPct()
	 * @generated
	 * @ordered
	 */
	protected static final PerCent QNOM_PCT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQnomPct() <em>Qnom Pct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQnomPct()
	 * @generated
	 * @ordered
	 */
	protected PerCent qnomPct = QNOM_PCT_EDEFAULT;

	/**
	 * The default value of the '{@link #getQVexp() <em>QVexp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQVexp()
	 * @generated
	 * @ordered
	 */
	protected static final Exponent QVEXP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQVexp() <em>QVexp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQVexp()
	 * @generated
	 * @ordered
	 */
	protected Exponent qVexp = QVEXP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnergyConsumerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.ENERGY_CONSUMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLoadDemandModels() {
		if (loadDemandModels == null) {
			loadDemandModels = new EObjectContainmentWithInverseEList(LoadDemandModel.class, this, WirePackage.ENERGY_CONSUMER__LOAD_DEMAND_MODELS, LoadPackage.LOAD_DEMAND_MODEL__ENERGY_CONSUMER);
		}
		return loadDemandModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNonConformLoadSchedules() {
		if (nonConformLoadSchedules == null) {
			nonConformLoadSchedules = new EObjectContainmentWithInverseEList(NonConformLoadSchedule.class, this, WirePackage.ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES, LoadPackage.NON_CONFORM_LOAD_SCHEDULE__ENERGY_CONSUMER);
		}
		return nonConformLoadSchedules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadArea getLoadArea() {
		if (loadArea != null && loadArea.eIsProxy()) {
			InternalEObject oldLoadArea = (InternalEObject)loadArea;
			loadArea = (LoadArea)eResolveProxy(oldLoadArea);
			if (loadArea != oldLoadArea) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WirePackage.ENERGY_CONSUMER__LOAD_AREA, oldLoadArea, loadArea));
			}
		}
		return loadArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadArea basicGetLoadArea() {
		return loadArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoadArea(LoadArea newLoadArea, NotificationChain msgs) {
		LoadArea oldLoadArea = loadArea;
		loadArea = newLoadArea;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__LOAD_AREA, oldLoadArea, newLoadArea);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadArea(LoadArea newLoadArea) {
		if (newLoadArea != loadArea) {
			NotificationChain msgs = null;
			if (loadArea != null)
				msgs = ((InternalEObject)loadArea).eInverseRemove(this, LoadPackage.LOAD_AREA__ENERGY_CONSUMERS, LoadArea.class, msgs);
			if (newLoadArea != null)
				msgs = ((InternalEObject)newLoadArea).eInverseAdd(this, LoadPackage.LOAD_AREA__ENERGY_CONSUMERS, LoadArea.class, msgs);
			msgs = basicSetLoadArea(newLoadArea, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__LOAD_AREA, newLoadArea, newLoadArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerCutZone getPowerCutZone() {
		if (eContainerFeatureID != WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE) return null;
		return (PowerCutZone)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPowerCutZone(PowerCutZone newPowerCutZone, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPowerCutZone, WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPowerCutZone(PowerCutZone newPowerCutZone) {
		if (newPowerCutZone != eInternalContainer() || (eContainerFeatureID != WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE && newPowerCutZone != null)) {
			if (EcoreUtil.isAncestor(this, newPowerCutZone))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPowerCutZone != null)
				msgs = ((InternalEObject)newPowerCutZone).eInverseAdd(this, LoadPackage.POWER_CUT_ZONE__ENERGY_CONSUMERS, PowerCutZone.class, msgs);
			msgs = basicSetPowerCutZone(newPowerCutZone, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE, newPowerCutZone, newPowerCutZone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getConformingLoadFlag() {
		return conformingLoadFlag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConformingLoadFlag(Boolean newConformingLoadFlag) {
		Boolean oldConformingLoadFlag = conformingLoadFlag;
		conformingLoadFlag = newConformingLoadFlag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__CONFORMING_LOAD_FLAG, oldConformingLoadFlag, conformingLoadFlag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Counter getCustomerCount() {
		return customerCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomerCount(Counter newCustomerCount) {
		Counter oldCustomerCount = customerCount;
		customerCount = newCustomerCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__CUSTOMER_COUNT, oldCustomerCount, customerCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exponent getPFexp() {
		return pFexp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPFexp(Exponent newPFexp) {
		Exponent oldPFexp = pFexp;
		pFexp = newPFexp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__PFEXP, oldPFexp, pFexp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getPfixed() {
		return pfixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPfixed(ActivePower newPfixed) {
		ActivePower oldPfixed = pfixed;
		pfixed = newPfixed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__PFIXED, oldPfixed, pfixed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent getPfixedPct() {
		return pfixedPct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPfixedPct(PerCent newPfixedPct) {
		PerCent oldPfixedPct = pfixedPct;
		pfixedPct = newPfixedPct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__PFIXED_PCT, oldPfixedPct, pfixedPct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getPnom() {
		return pnom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPnom(ActivePower newPnom) {
		ActivePower oldPnom = pnom;
		pnom = newPnom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__PNOM, oldPnom, pnom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent getPnomPct() {
		return pnomPct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPnomPct(PerCent newPnomPct) {
		PerCent oldPnomPct = pnomPct;
		pnomPct = newPnomPct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__PNOM_PCT, oldPnomPct, pnomPct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerFactor getPowerFactor() {
		return powerFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPowerFactor(PowerFactor newPowerFactor) {
		PowerFactor oldPowerFactor = powerFactor;
		powerFactor = newPowerFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__POWER_FACTOR, oldPowerFactor, powerFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exponent getPVexp() {
		return pVexp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPVexp(Exponent newPVexp) {
		Exponent oldPVexp = pVexp;
		pVexp = newPVexp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__PVEXP, oldPVexp, pVexp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exponent getQFexp() {
		return qFexp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQFexp(Exponent newQFexp) {
		Exponent oldQFexp = qFexp;
		qFexp = newQFexp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__QFEXP, oldQFexp, qFexp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReactivePower getQfixed() {
		return qfixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQfixed(ReactivePower newQfixed) {
		ReactivePower oldQfixed = qfixed;
		qfixed = newQfixed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__QFIXED, oldQfixed, qfixed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent getQfixedPct() {
		return qfixedPct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQfixedPct(PerCent newQfixedPct) {
		PerCent oldQfixedPct = qfixedPct;
		qfixedPct = newQfixedPct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__QFIXED_PCT, oldQfixedPct, qfixedPct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReactivePower getQnom() {
		return qnom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQnom(ReactivePower newQnom) {
		ReactivePower oldQnom = qnom;
		qnom = newQnom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__QNOM, oldQnom, qnom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerCent getQnomPct() {
		return qnomPct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQnomPct(PerCent newQnomPct) {
		PerCent oldQnomPct = qnomPct;
		qnomPct = newQnomPct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__QNOM_PCT, oldQnomPct, qnomPct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exponent getQVexp() {
		return qVexp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQVexp(Exponent newQVexp) {
		Exponent oldQVexp = qVexp;
		qVexp = newQVexp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.ENERGY_CONSUMER__QVEXP, oldQVexp, qVexp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.ENERGY_CONSUMER__LOAD_DEMAND_MODELS:
				return ((InternalEList)getLoadDemandModels()).basicAdd(otherEnd, msgs);
			case WirePackage.ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES:
				return ((InternalEList)getNonConformLoadSchedules()).basicAdd(otherEnd, msgs);
			case WirePackage.ENERGY_CONSUMER__LOAD_AREA:
				if (loadArea != null)
					msgs = ((InternalEObject)loadArea).eInverseRemove(this, LoadPackage.LOAD_AREA__ENERGY_CONSUMERS, LoadArea.class, msgs);
				return basicSetLoadArea((LoadArea)otherEnd, msgs);
			case WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPowerCutZone((PowerCutZone)otherEnd, msgs);
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
			case WirePackage.ENERGY_CONSUMER__LOAD_DEMAND_MODELS:
				return ((InternalEList)getLoadDemandModels()).basicRemove(otherEnd, msgs);
			case WirePackage.ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES:
				return ((InternalEList)getNonConformLoadSchedules()).basicRemove(otherEnd, msgs);
			case WirePackage.ENERGY_CONSUMER__LOAD_AREA:
				return basicSetLoadArea(null, msgs);
			case WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE:
				return basicSetPowerCutZone(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE:
				return eInternalContainer().eInverseRemove(this, LoadPackage.POWER_CUT_ZONE__ENERGY_CONSUMERS, PowerCutZone.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WirePackage.ENERGY_CONSUMER__LOAD_DEMAND_MODELS:
				return getLoadDemandModels();
			case WirePackage.ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES:
				return getNonConformLoadSchedules();
			case WirePackage.ENERGY_CONSUMER__LOAD_AREA:
				if (resolve) return getLoadArea();
				return basicGetLoadArea();
			case WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE:
				return getPowerCutZone();
			case WirePackage.ENERGY_CONSUMER__CONFORMING_LOAD_FLAG:
				return getConformingLoadFlag();
			case WirePackage.ENERGY_CONSUMER__CUSTOMER_COUNT:
				return getCustomerCount();
			case WirePackage.ENERGY_CONSUMER__PFEXP:
				return getPFexp();
			case WirePackage.ENERGY_CONSUMER__PFIXED:
				return getPfixed();
			case WirePackage.ENERGY_CONSUMER__PFIXED_PCT:
				return getPfixedPct();
			case WirePackage.ENERGY_CONSUMER__PNOM:
				return getPnom();
			case WirePackage.ENERGY_CONSUMER__PNOM_PCT:
				return getPnomPct();
			case WirePackage.ENERGY_CONSUMER__POWER_FACTOR:
				return getPowerFactor();
			case WirePackage.ENERGY_CONSUMER__PVEXP:
				return getPVexp();
			case WirePackage.ENERGY_CONSUMER__QFEXP:
				return getQFexp();
			case WirePackage.ENERGY_CONSUMER__QFIXED:
				return getQfixed();
			case WirePackage.ENERGY_CONSUMER__QFIXED_PCT:
				return getQfixedPct();
			case WirePackage.ENERGY_CONSUMER__QNOM:
				return getQnom();
			case WirePackage.ENERGY_CONSUMER__QNOM_PCT:
				return getQnomPct();
			case WirePackage.ENERGY_CONSUMER__QVEXP:
				return getQVexp();
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
			case WirePackage.ENERGY_CONSUMER__LOAD_DEMAND_MODELS:
				getLoadDemandModels().clear();
				getLoadDemandModels().addAll((Collection)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES:
				getNonConformLoadSchedules().clear();
				getNonConformLoadSchedules().addAll((Collection)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__LOAD_AREA:
				setLoadArea((LoadArea)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE:
				setPowerCutZone((PowerCutZone)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__CONFORMING_LOAD_FLAG:
				setConformingLoadFlag((Boolean)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__CUSTOMER_COUNT:
				setCustomerCount((Counter)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__PFEXP:
				setPFexp((Exponent)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__PFIXED:
				setPfixed((ActivePower)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__PFIXED_PCT:
				setPfixedPct((PerCent)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__PNOM:
				setPnom((ActivePower)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__PNOM_PCT:
				setPnomPct((PerCent)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__POWER_FACTOR:
				setPowerFactor((PowerFactor)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__PVEXP:
				setPVexp((Exponent)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__QFEXP:
				setQFexp((Exponent)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__QFIXED:
				setQfixed((ReactivePower)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__QFIXED_PCT:
				setQfixedPct((PerCent)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__QNOM:
				setQnom((ReactivePower)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__QNOM_PCT:
				setQnomPct((PerCent)newValue);
				return;
			case WirePackage.ENERGY_CONSUMER__QVEXP:
				setQVexp((Exponent)newValue);
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
			case WirePackage.ENERGY_CONSUMER__LOAD_DEMAND_MODELS:
				getLoadDemandModels().clear();
				return;
			case WirePackage.ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES:
				getNonConformLoadSchedules().clear();
				return;
			case WirePackage.ENERGY_CONSUMER__LOAD_AREA:
				setLoadArea((LoadArea)null);
				return;
			case WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE:
				setPowerCutZone((PowerCutZone)null);
				return;
			case WirePackage.ENERGY_CONSUMER__CONFORMING_LOAD_FLAG:
				setConformingLoadFlag(CONFORMING_LOAD_FLAG_EDEFAULT);
				return;
			case WirePackage.ENERGY_CONSUMER__CUSTOMER_COUNT:
				setCustomerCount(CUSTOMER_COUNT_EDEFAULT);
				return;
			case WirePackage.ENERGY_CONSUMER__PFEXP:
				setPFexp(PFEXP_EDEFAULT);
				return;
			case WirePackage.ENERGY_CONSUMER__PFIXED:
				setPfixed(PFIXED_EDEFAULT);
				return;
			case WirePackage.ENERGY_CONSUMER__PFIXED_PCT:
				setPfixedPct(PFIXED_PCT_EDEFAULT);
				return;
			case WirePackage.ENERGY_CONSUMER__PNOM:
				setPnom(PNOM_EDEFAULT);
				return;
			case WirePackage.ENERGY_CONSUMER__PNOM_PCT:
				setPnomPct(PNOM_PCT_EDEFAULT);
				return;
			case WirePackage.ENERGY_CONSUMER__POWER_FACTOR:
				setPowerFactor(POWER_FACTOR_EDEFAULT);
				return;
			case WirePackage.ENERGY_CONSUMER__PVEXP:
				setPVexp(PVEXP_EDEFAULT);
				return;
			case WirePackage.ENERGY_CONSUMER__QFEXP:
				setQFexp(QFEXP_EDEFAULT);
				return;
			case WirePackage.ENERGY_CONSUMER__QFIXED:
				setQfixed(QFIXED_EDEFAULT);
				return;
			case WirePackage.ENERGY_CONSUMER__QFIXED_PCT:
				setQfixedPct(QFIXED_PCT_EDEFAULT);
				return;
			case WirePackage.ENERGY_CONSUMER__QNOM:
				setQnom(QNOM_EDEFAULT);
				return;
			case WirePackage.ENERGY_CONSUMER__QNOM_PCT:
				setQnomPct(QNOM_PCT_EDEFAULT);
				return;
			case WirePackage.ENERGY_CONSUMER__QVEXP:
				setQVexp(QVEXP_EDEFAULT);
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
			case WirePackage.ENERGY_CONSUMER__LOAD_DEMAND_MODELS:
				return loadDemandModels != null && !loadDemandModels.isEmpty();
			case WirePackage.ENERGY_CONSUMER__NON_CONFORM_LOAD_SCHEDULES:
				return nonConformLoadSchedules != null && !nonConformLoadSchedules.isEmpty();
			case WirePackage.ENERGY_CONSUMER__LOAD_AREA:
				return loadArea != null;
			case WirePackage.ENERGY_CONSUMER__POWER_CUT_ZONE:
				return getPowerCutZone() != null;
			case WirePackage.ENERGY_CONSUMER__CONFORMING_LOAD_FLAG:
				return CONFORMING_LOAD_FLAG_EDEFAULT == null ? conformingLoadFlag != null : !CONFORMING_LOAD_FLAG_EDEFAULT.equals(conformingLoadFlag);
			case WirePackage.ENERGY_CONSUMER__CUSTOMER_COUNT:
				return CUSTOMER_COUNT_EDEFAULT == null ? customerCount != null : !CUSTOMER_COUNT_EDEFAULT.equals(customerCount);
			case WirePackage.ENERGY_CONSUMER__PFEXP:
				return PFEXP_EDEFAULT == null ? pFexp != null : !PFEXP_EDEFAULT.equals(pFexp);
			case WirePackage.ENERGY_CONSUMER__PFIXED:
				return PFIXED_EDEFAULT == null ? pfixed != null : !PFIXED_EDEFAULT.equals(pfixed);
			case WirePackage.ENERGY_CONSUMER__PFIXED_PCT:
				return PFIXED_PCT_EDEFAULT == null ? pfixedPct != null : !PFIXED_PCT_EDEFAULT.equals(pfixedPct);
			case WirePackage.ENERGY_CONSUMER__PNOM:
				return PNOM_EDEFAULT == null ? pnom != null : !PNOM_EDEFAULT.equals(pnom);
			case WirePackage.ENERGY_CONSUMER__PNOM_PCT:
				return PNOM_PCT_EDEFAULT == null ? pnomPct != null : !PNOM_PCT_EDEFAULT.equals(pnomPct);
			case WirePackage.ENERGY_CONSUMER__POWER_FACTOR:
				return POWER_FACTOR_EDEFAULT == null ? powerFactor != null : !POWER_FACTOR_EDEFAULT.equals(powerFactor);
			case WirePackage.ENERGY_CONSUMER__PVEXP:
				return PVEXP_EDEFAULT == null ? pVexp != null : !PVEXP_EDEFAULT.equals(pVexp);
			case WirePackage.ENERGY_CONSUMER__QFEXP:
				return QFEXP_EDEFAULT == null ? qFexp != null : !QFEXP_EDEFAULT.equals(qFexp);
			case WirePackage.ENERGY_CONSUMER__QFIXED:
				return QFIXED_EDEFAULT == null ? qfixed != null : !QFIXED_EDEFAULT.equals(qfixed);
			case WirePackage.ENERGY_CONSUMER__QFIXED_PCT:
				return QFIXED_PCT_EDEFAULT == null ? qfixedPct != null : !QFIXED_PCT_EDEFAULT.equals(qfixedPct);
			case WirePackage.ENERGY_CONSUMER__QNOM:
				return QNOM_EDEFAULT == null ? qnom != null : !QNOM_EDEFAULT.equals(qnom);
			case WirePackage.ENERGY_CONSUMER__QNOM_PCT:
				return QNOM_PCT_EDEFAULT == null ? qnomPct != null : !QNOM_PCT_EDEFAULT.equals(qnomPct);
			case WirePackage.ENERGY_CONSUMER__QVEXP:
				return QVEXP_EDEFAULT == null ? qVexp != null : !QVEXP_EDEFAULT.equals(qVexp);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString() + "\n");
		result.append(" (conformingLoadFlag: ");
		result.append(conformingLoadFlag);
		result.append(", customerCount: ");
		result.append(customerCount);
		result.append(", pFexp: ");
		result.append(pFexp);
		result.append(", pfixed: ");
		result.append(pfixed);
		result.append(", pfixedPct: ");
		result.append(pfixedPct);
		result.append(", pnom: ");
		result.append(pnom);
		result.append(", pnomPct: ");
		result.append(pnomPct);
		result.append(", powerFactor: ");
		result.append(powerFactor);
		result.append(", pVexp: ");
		result.append(pVexp);
		result.append(", qFexp: ");
		result.append(qFexp);
		result.append(", qfixed: ");
		result.append(qfixed);
		result.append(", qfixedPct: ");
		result.append(qfixedPct);
		result.append(", qnom: ");
		result.append(qnom);
		result.append(", qnomPct: ");
		result.append(qnomPct);
		result.append(", qVexp: ");
		result.append(qVexp);
		result.append(')');
		return result.toString();
	}

} //EnergyConsumerImpl