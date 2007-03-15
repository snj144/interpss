/**
 * <copyright>
 * </copyright>
 *
 * $Id: SynchronousMachineImpl.java,v 1.4 2007/03/07 16:03:49 mzhou Exp $
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.domain.CoolantType;
import org.opencim.cim.iec61970.domain.SynchronousMachineOperatingMode;
import org.opencim.cim.iec61970.domain.SynchronousMachineType;

import org.opencim.cim.iec61970.gen.generationdynamics.GenerationdynamicsPackage;
import org.opencim.cim.iec61970.gen.generationdynamics.PrimeMover;

import org.opencim.cim.iec61970.gen.generationdynamics.impl.GenerationdynamicsPackageImpl;

import org.opencim.cim.iec61970.gen.production.GeneratingUnit;
import org.opencim.cim.iec61970.gen.production.HydroPump;
import org.opencim.cim.iec61970.gen.production.impl.ProductionPackageImpl;

import org.opencim.cim.iec61970.gen.production.ProductionPackage;

import org.opencim.cim.iec61970.wire.MVArCapabilityCurve;
import org.opencim.cim.iec61970.wire.SynchronousMachine;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.ApparentPower;
import org.opencim.datatype.real.Damping;
import org.opencim.datatype.real.Inertia;
import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.ReactivePower;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.Seconds;
import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Synchronous Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getAVRToManualLag <em>AVR To Manual Lag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getAVRToManualLead <em>AVR To Manual Lead</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getBaseMVAr <em>Base MV Ar</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getCoolantCondition <em>Coolant Condition</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getCoolantType <em>Coolant Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getDamping <em>Damping</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getInertia <em>Inertia</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getManualToAVR <em>Manual To AVR</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getMaximumKV <em>Maximum KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getMaximumMVAr <em>Maximum MV Ar</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getMinimumKV <em>Minimum KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getMinimumMVAr <em>Minimum MV Ar</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getR <em>R</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getR0 <em>R0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getRatedMVA <em>Rated MVA</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getX <em>X</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getX0 <em>X0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getXDirectSubtrans <em>XDirect Subtrans</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getXDirectSync <em>XDirect Sync</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getXDirectTrans <em>XDirect Trans</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getXQuadSubtrans <em>XQuad Subtrans</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getXQuadSync <em>XQuad Sync</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getXQuadTrans <em>XQuad Trans</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getOperatingMode <em>Operating Mode</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getCondenserMW <em>Condenser MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getMVArCapabilityCurves <em>MV Ar Capability Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getDrives_HydroPump <em>Drives Hydro Pump</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getGeneratingUnit <em>Generating Unit</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.SynchronousMachineImpl#getPrimeMover <em>Prime Mover</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SynchronousMachineImpl extends RegulatingCondEqImpl implements SynchronousMachine {
	/**
	 * The default value of the '{@link #getAVRToManualLag() <em>AVR To Manual Lag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAVRToManualLag()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds AVR_TO_MANUAL_LAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAVRToManualLag() <em>AVR To Manual Lag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAVRToManualLag()
	 * @generated
	 * @ordered
	 */
	protected Seconds aVRToManualLag = AVR_TO_MANUAL_LAG_EDEFAULT;

	/**
	 * The default value of the '{@link #getAVRToManualLead() <em>AVR To Manual Lead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAVRToManualLead()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds AVR_TO_MANUAL_LEAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAVRToManualLead() <em>AVR To Manual Lead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAVRToManualLead()
	 * @generated
	 * @ordered
	 */
	protected Seconds aVRToManualLead = AVR_TO_MANUAL_LEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getBaseMVAr() <em>Base MV Ar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseMVAr()
	 * @generated
	 * @ordered
	 */
	protected static final ReactivePower BASE_MV_AR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseMVAr() <em>Base MV Ar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseMVAr()
	 * @generated
	 * @ordered
	 */
	protected ReactivePower baseMVAr = BASE_MV_AR_EDEFAULT;

	/**
	 * The default value of the '{@link #getCoolantCondition() <em>Coolant Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoolantCondition()
	 * @generated
	 * @ordered
	 */
	protected static final Float COOLANT_CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCoolantCondition() <em>Coolant Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoolantCondition()
	 * @generated
	 * @ordered
	 */
	protected Float coolantCondition = COOLANT_CONDITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCoolantType() <em>Coolant Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoolantType()
	 * @generated
	 * @ordered
	 */
	protected static final CoolantType COOLANT_TYPE_EDEFAULT = CoolantType.AIR_LITERAL;

	/**
	 * The cached value of the '{@link #getCoolantType() <em>Coolant Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoolantType()
	 * @generated
	 * @ordered
	 */
	protected CoolantType coolantType = COOLANT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDamping() <em>Damping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDamping()
	 * @generated
	 * @ordered
	 */
	protected static final Damping DAMPING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDamping() <em>Damping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDamping()
	 * @generated
	 * @ordered
	 */
	protected Damping damping = DAMPING_EDEFAULT;

	/**
	 * The default value of the '{@link #getInertia() <em>Inertia</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInertia()
	 * @generated
	 * @ordered
	 */
	protected static final Inertia INERTIA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInertia() <em>Inertia</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInertia()
	 * @generated
	 * @ordered
	 */
	protected Inertia inertia = INERTIA_EDEFAULT;

	/**
	 * The default value of the '{@link #getManualToAVR() <em>Manual To AVR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManualToAVR()
	 * @generated
	 * @ordered
	 */
	protected static final Seconds MANUAL_TO_AVR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManualToAVR() <em>Manual To AVR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManualToAVR()
	 * @generated
	 * @ordered
	 */
	protected Seconds manualToAVR = MANUAL_TO_AVR_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumKV() <em>Maximum KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumKV()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage MAXIMUM_KV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumKV() <em>Maximum KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumKV()
	 * @generated
	 * @ordered
	 */
	protected Voltage maximumKV = MAXIMUM_KV_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumMVAr() <em>Maximum MV Ar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumMVAr()
	 * @generated
	 * @ordered
	 */
	protected static final ReactivePower MAXIMUM_MV_AR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumMVAr() <em>Maximum MV Ar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumMVAr()
	 * @generated
	 * @ordered
	 */
	protected ReactivePower maximumMVAr = MAXIMUM_MV_AR_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumKV() <em>Minimum KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumKV()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage MINIMUM_KV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimumKV() <em>Minimum KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumKV()
	 * @generated
	 * @ordered
	 */
	protected Voltage minimumKV = MINIMUM_KV_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumMVAr() <em>Minimum MV Ar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumMVAr()
	 * @generated
	 * @ordered
	 */
	protected static final ReactivePower MINIMUM_MV_AR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimumMVAr() <em>Minimum MV Ar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumMVAr()
	 * @generated
	 * @ordered
	 */
	protected ReactivePower minimumMVAr = MINIMUM_MV_AR_EDEFAULT;

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
	 * The default value of the '{@link #getR0() <em>R0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR0()
	 * @generated
	 * @ordered
	 */
	protected static final Resistance R0_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getR0() <em>R0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR0()
	 * @generated
	 * @ordered
	 */
	protected Resistance r0 = R0_EDEFAULT;

	/**
	 * The default value of the '{@link #getRatedMVA() <em>Rated MVA</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatedMVA()
	 * @generated
	 * @ordered
	 */
	protected static final ApparentPower RATED_MVA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRatedMVA() <em>Rated MVA</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatedMVA()
	 * @generated
	 * @ordered
	 */
	protected ApparentPower ratedMVA = RATED_MVA_EDEFAULT;

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
	 * The default value of the '{@link #getX0() <em>X0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX0()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance X0_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getX0() <em>X0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX0()
	 * @generated
	 * @ordered
	 */
	protected Reactance x0 = X0_EDEFAULT;

	/**
	 * The default value of the '{@link #getXDirectSubtrans() <em>XDirect Subtrans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXDirectSubtrans()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance XDIRECT_SUBTRANS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXDirectSubtrans() <em>XDirect Subtrans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXDirectSubtrans()
	 * @generated
	 * @ordered
	 */
	protected Reactance xDirectSubtrans = XDIRECT_SUBTRANS_EDEFAULT;

	/**
	 * The default value of the '{@link #getXDirectSync() <em>XDirect Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXDirectSync()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance XDIRECT_SYNC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXDirectSync() <em>XDirect Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXDirectSync()
	 * @generated
	 * @ordered
	 */
	protected Reactance xDirectSync = XDIRECT_SYNC_EDEFAULT;

	/**
	 * The default value of the '{@link #getXDirectTrans() <em>XDirect Trans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXDirectTrans()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance XDIRECT_TRANS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXDirectTrans() <em>XDirect Trans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXDirectTrans()
	 * @generated
	 * @ordered
	 */
	protected Reactance xDirectTrans = XDIRECT_TRANS_EDEFAULT;

	/**
	 * The default value of the '{@link #getXQuadSubtrans() <em>XQuad Subtrans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXQuadSubtrans()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance XQUAD_SUBTRANS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXQuadSubtrans() <em>XQuad Subtrans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXQuadSubtrans()
	 * @generated
	 * @ordered
	 */
	protected Reactance xQuadSubtrans = XQUAD_SUBTRANS_EDEFAULT;

	/**
	 * The default value of the '{@link #getXQuadSync() <em>XQuad Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXQuadSync()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance XQUAD_SYNC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXQuadSync() <em>XQuad Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXQuadSync()
	 * @generated
	 * @ordered
	 */
	protected Reactance xQuadSync = XQUAD_SYNC_EDEFAULT;

	/**
	 * The default value of the '{@link #getXQuadTrans() <em>XQuad Trans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXQuadTrans()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance XQUAD_TRANS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXQuadTrans() <em>XQuad Trans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXQuadTrans()
	 * @generated
	 * @ordered
	 */
	protected Reactance xQuadTrans = XQUAD_TRANS_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperatingMode() <em>Operating Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatingMode()
	 * @generated
	 * @ordered
	 */
	protected static final SynchronousMachineOperatingMode OPERATING_MODE_EDEFAULT = SynchronousMachineOperatingMode.GENERATOR_LITERAL;

	/**
	 * The cached value of the '{@link #getOperatingMode() <em>Operating Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatingMode()
	 * @generated
	 * @ordered
	 */
	protected SynchronousMachineOperatingMode operatingMode = OPERATING_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final SynchronousMachineType TYPE_EDEFAULT = SynchronousMachineType.GENERATOR_LITERAL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected SynchronousMachineType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCondenserMW() <em>Condenser MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondenserMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower CONDENSER_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCondenserMW() <em>Condenser MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondenserMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower condenserMW = CONDENSER_MW_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMVArCapabilityCurves() <em>MV Ar Capability Curves</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMVArCapabilityCurves()
	 * @generated
	 * @ordered
	 */
	protected EList mvArCapabilityCurves = null;

	/**
	 * The cached value of the '{@link #getDrives_HydroPump() <em>Drives Hydro Pump</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrives_HydroPump()
	 * @generated
	 * @ordered
	 */
	protected HydroPump drives_HydroPump = null;

	/**
	 * The cached value of the '{@link #getGeneratingUnit() <em>Generating Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratingUnit()
	 * @generated
	 * @ordered
	 */
	protected GeneratingUnit generatingUnit = null;

	/**
	 * The cached value of the '{@link #getPrimeMover() <em>Prime Mover</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimeMover()
	 * @generated
	 * @ordered
	 */
	protected EList primeMover = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SynchronousMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.SYNCHRONOUS_MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getAVRToManualLag() {
		return aVRToManualLag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAVRToManualLag(Seconds newAVRToManualLag) {
		Seconds oldAVRToManualLag = aVRToManualLag;
		aVRToManualLag = newAVRToManualLag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LAG, oldAVRToManualLag, aVRToManualLag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getAVRToManualLead() {
		return aVRToManualLead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAVRToManualLead(Seconds newAVRToManualLead) {
		Seconds oldAVRToManualLead = aVRToManualLead;
		aVRToManualLead = newAVRToManualLead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LEAD, oldAVRToManualLead, aVRToManualLead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReactivePower getBaseMVAr() {
		return baseMVAr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseMVAr(ReactivePower newBaseMVAr) {
		ReactivePower oldBaseMVAr = baseMVAr;
		baseMVAr = newBaseMVAr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__BASE_MV_AR, oldBaseMVAr, baseMVAr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getCoolantCondition() {
		return coolantCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoolantCondition(Float newCoolantCondition) {
		Float oldCoolantCondition = coolantCondition;
		coolantCondition = newCoolantCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__COOLANT_CONDITION, oldCoolantCondition, coolantCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoolantType getCoolantType() {
		return coolantType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoolantType(CoolantType newCoolantType) {
		CoolantType oldCoolantType = coolantType;
		coolantType = newCoolantType == null ? COOLANT_TYPE_EDEFAULT : newCoolantType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__COOLANT_TYPE, oldCoolantType, coolantType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Damping getDamping() {
		return damping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDamping(Damping newDamping) {
		Damping oldDamping = damping;
		damping = newDamping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__DAMPING, oldDamping, damping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inertia getInertia() {
		return inertia;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInertia(Inertia newInertia) {
		Inertia oldInertia = inertia;
		inertia = newInertia;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__INERTIA, oldInertia, inertia));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seconds getManualToAVR() {
		return manualToAVR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManualToAVR(Seconds newManualToAVR) {
		Seconds oldManualToAVR = manualToAVR;
		manualToAVR = newManualToAVR;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__MANUAL_TO_AVR, oldManualToAVR, manualToAVR));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getMaximumKV() {
		return maximumKV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumKV(Voltage newMaximumKV) {
		Voltage oldMaximumKV = maximumKV;
		maximumKV = newMaximumKV;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__MAXIMUM_KV, oldMaximumKV, maximumKV));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReactivePower getMaximumMVAr() {
		return maximumMVAr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumMVAr(ReactivePower newMaximumMVAr) {
		ReactivePower oldMaximumMVAr = maximumMVAr;
		maximumMVAr = newMaximumMVAr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__MAXIMUM_MV_AR, oldMaximumMVAr, maximumMVAr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getMinimumKV() {
		return minimumKV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumKV(Voltage newMinimumKV) {
		Voltage oldMinimumKV = minimumKV;
		minimumKV = newMinimumKV;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__MINIMUM_KV, oldMinimumKV, minimumKV));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReactivePower getMinimumMVAr() {
		return minimumMVAr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumMVAr(ReactivePower newMinimumMVAr) {
		ReactivePower oldMinimumMVAr = minimumMVAr;
		minimumMVAr = newMinimumMVAr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__MINIMUM_MV_AR, oldMinimumMVAr, minimumMVAr));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__R, oldR, r));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance getR0() {
		return r0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setR0(Resistance newR0) {
		Resistance oldR0 = r0;
		r0 = newR0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__R0, oldR0, r0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApparentPower getRatedMVA() {
		return ratedMVA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRatedMVA(ApparentPower newRatedMVA) {
		ApparentPower oldRatedMVA = ratedMVA;
		ratedMVA = newRatedMVA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__RATED_MVA, oldRatedMVA, ratedMVA));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getX0() {
		return x0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX0(Reactance newX0) {
		Reactance oldX0 = x0;
		x0 = newX0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__X0, oldX0, x0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getXDirectSubtrans() {
		return xDirectSubtrans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXDirectSubtrans(Reactance newXDirectSubtrans) {
		Reactance oldXDirectSubtrans = xDirectSubtrans;
		xDirectSubtrans = newXDirectSubtrans;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_SUBTRANS, oldXDirectSubtrans, xDirectSubtrans));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getXDirectSync() {
		return xDirectSync;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXDirectSync(Reactance newXDirectSync) {
		Reactance oldXDirectSync = xDirectSync;
		xDirectSync = newXDirectSync;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_SYNC, oldXDirectSync, xDirectSync));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getXDirectTrans() {
		return xDirectTrans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXDirectTrans(Reactance newXDirectTrans) {
		Reactance oldXDirectTrans = xDirectTrans;
		xDirectTrans = newXDirectTrans;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_TRANS, oldXDirectTrans, xDirectTrans));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getXQuadSubtrans() {
		return xQuadSubtrans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXQuadSubtrans(Reactance newXQuadSubtrans) {
		Reactance oldXQuadSubtrans = xQuadSubtrans;
		xQuadSubtrans = newXQuadSubtrans;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__XQUAD_SUBTRANS, oldXQuadSubtrans, xQuadSubtrans));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getXQuadSync() {
		return xQuadSync;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXQuadSync(Reactance newXQuadSync) {
		Reactance oldXQuadSync = xQuadSync;
		xQuadSync = newXQuadSync;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__XQUAD_SYNC, oldXQuadSync, xQuadSync));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getXQuadTrans() {
		return xQuadTrans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXQuadTrans(Reactance newXQuadTrans) {
		Reactance oldXQuadTrans = xQuadTrans;
		xQuadTrans = newXQuadTrans;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__XQUAD_TRANS, oldXQuadTrans, xQuadTrans));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronousMachineOperatingMode getOperatingMode() {
		return operatingMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperatingMode(SynchronousMachineOperatingMode newOperatingMode) {
		SynchronousMachineOperatingMode oldOperatingMode = operatingMode;
		operatingMode = newOperatingMode == null ? OPERATING_MODE_EDEFAULT : newOperatingMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__OPERATING_MODE, oldOperatingMode, operatingMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronousMachineType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(SynchronousMachineType newType) {
		SynchronousMachineType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getCondenserMW() {
		return condenserMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondenserMW(ActivePower newCondenserMW) {
		ActivePower oldCondenserMW = condenserMW;
		condenserMW = newCondenserMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__CONDENSER_MW, oldCondenserMW, condenserMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getMVArCapabilityCurves() {
		if (mvArCapabilityCurves == null) {
			mvArCapabilityCurves = new EObjectWithInverseResolvingEList.ManyInverse(MVArCapabilityCurve.class, this, WirePackage.SYNCHRONOUS_MACHINE__MV_AR_CAPABILITY_CURVES, WirePackage.MV_AR_CAPABILITY_CURVE__SYNCHRONOUS_MACHINES);
		}
		return mvArCapabilityCurves;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HydroPump getDrives_HydroPump() {
		if (drives_HydroPump != null && drives_HydroPump.eIsProxy()) {
			InternalEObject oldDrives_HydroPump = (InternalEObject)drives_HydroPump;
			drives_HydroPump = (HydroPump)eResolveProxy(oldDrives_HydroPump);
			if (drives_HydroPump != oldDrives_HydroPump) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WirePackage.SYNCHRONOUS_MACHINE__DRIVES_HYDRO_PUMP, oldDrives_HydroPump, drives_HydroPump));
			}
		}
		return drives_HydroPump;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HydroPump basicGetDrives_HydroPump() {
		return drives_HydroPump;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDrives_HydroPump(HydroPump newDrives_HydroPump) {
		HydroPump oldDrives_HydroPump = drives_HydroPump;
		drives_HydroPump = newDrives_HydroPump;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__DRIVES_HYDRO_PUMP, oldDrives_HydroPump, drives_HydroPump));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratingUnit getGeneratingUnit() {
		if (generatingUnit != null && generatingUnit.eIsProxy()) {
			InternalEObject oldGeneratingUnit = (InternalEObject)generatingUnit;
			generatingUnit = (GeneratingUnit)eResolveProxy(oldGeneratingUnit);
			if (generatingUnit != oldGeneratingUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WirePackage.SYNCHRONOUS_MACHINE__GENERATING_UNIT, oldGeneratingUnit, generatingUnit));
			}
		}
		return generatingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratingUnit basicGetGeneratingUnit() {
		return generatingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGeneratingUnit(GeneratingUnit newGeneratingUnit, NotificationChain msgs) {
		GeneratingUnit oldGeneratingUnit = generatingUnit;
		generatingUnit = newGeneratingUnit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__GENERATING_UNIT, oldGeneratingUnit, newGeneratingUnit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneratingUnit(GeneratingUnit newGeneratingUnit) {
		if (newGeneratingUnit != generatingUnit) {
			NotificationChain msgs = null;
			if (generatingUnit != null)
				msgs = ((InternalEObject)generatingUnit).eInverseRemove(this, ProductionPackage.GENERATING_UNIT__SYNCHRONOUS_MACHINES, GeneratingUnit.class, msgs);
			if (newGeneratingUnit != null)
				msgs = ((InternalEObject)newGeneratingUnit).eInverseAdd(this, ProductionPackage.GENERATING_UNIT__SYNCHRONOUS_MACHINES, GeneratingUnit.class, msgs);
			msgs = basicSetGeneratingUnit(newGeneratingUnit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.SYNCHRONOUS_MACHINE__GENERATING_UNIT, newGeneratingUnit, newGeneratingUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPrimeMover() {
		if (primeMover == null) {
			primeMover = new EObjectWithInverseResolvingEList(PrimeMover.class, this, WirePackage.SYNCHRONOUS_MACHINE__PRIME_MOVER, GenerationdynamicsPackage.PRIME_MOVER__SYNCHRONOUS_MACHINES);
		}
		return primeMover;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.SYNCHRONOUS_MACHINE__MV_AR_CAPABILITY_CURVES:
				return ((InternalEList)getMVArCapabilityCurves()).basicAdd(otherEnd, msgs);
			case WirePackage.SYNCHRONOUS_MACHINE__GENERATING_UNIT:
				if (generatingUnit != null)
					msgs = ((InternalEObject)generatingUnit).eInverseRemove(this, ProductionPackage.GENERATING_UNIT__SYNCHRONOUS_MACHINES, GeneratingUnit.class, msgs);
				return basicSetGeneratingUnit((GeneratingUnit)otherEnd, msgs);
			case WirePackage.SYNCHRONOUS_MACHINE__PRIME_MOVER:
				return ((InternalEList)getPrimeMover()).basicAdd(otherEnd, msgs);
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
			case WirePackage.SYNCHRONOUS_MACHINE__MV_AR_CAPABILITY_CURVES:
				return ((InternalEList)getMVArCapabilityCurves()).basicRemove(otherEnd, msgs);
			case WirePackage.SYNCHRONOUS_MACHINE__GENERATING_UNIT:
				return basicSetGeneratingUnit(null, msgs);
			case WirePackage.SYNCHRONOUS_MACHINE__PRIME_MOVER:
				return ((InternalEList)getPrimeMover()).basicRemove(otherEnd, msgs);
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
			case WirePackage.SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LAG:
				return getAVRToManualLag();
			case WirePackage.SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LEAD:
				return getAVRToManualLead();
			case WirePackage.SYNCHRONOUS_MACHINE__BASE_MV_AR:
				return getBaseMVAr();
			case WirePackage.SYNCHRONOUS_MACHINE__COOLANT_CONDITION:
				return getCoolantCondition();
			case WirePackage.SYNCHRONOUS_MACHINE__COOLANT_TYPE:
				return getCoolantType();
			case WirePackage.SYNCHRONOUS_MACHINE__DAMPING:
				return getDamping();
			case WirePackage.SYNCHRONOUS_MACHINE__INERTIA:
				return getInertia();
			case WirePackage.SYNCHRONOUS_MACHINE__MANUAL_TO_AVR:
				return getManualToAVR();
			case WirePackage.SYNCHRONOUS_MACHINE__MAXIMUM_KV:
				return getMaximumKV();
			case WirePackage.SYNCHRONOUS_MACHINE__MAXIMUM_MV_AR:
				return getMaximumMVAr();
			case WirePackage.SYNCHRONOUS_MACHINE__MINIMUM_KV:
				return getMinimumKV();
			case WirePackage.SYNCHRONOUS_MACHINE__MINIMUM_MV_AR:
				return getMinimumMVAr();
			case WirePackage.SYNCHRONOUS_MACHINE__R:
				return getR();
			case WirePackage.SYNCHRONOUS_MACHINE__R0:
				return getR0();
			case WirePackage.SYNCHRONOUS_MACHINE__RATED_MVA:
				return getRatedMVA();
			case WirePackage.SYNCHRONOUS_MACHINE__X:
				return getX();
			case WirePackage.SYNCHRONOUS_MACHINE__X0:
				return getX0();
			case WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_SUBTRANS:
				return getXDirectSubtrans();
			case WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_SYNC:
				return getXDirectSync();
			case WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_TRANS:
				return getXDirectTrans();
			case WirePackage.SYNCHRONOUS_MACHINE__XQUAD_SUBTRANS:
				return getXQuadSubtrans();
			case WirePackage.SYNCHRONOUS_MACHINE__XQUAD_SYNC:
				return getXQuadSync();
			case WirePackage.SYNCHRONOUS_MACHINE__XQUAD_TRANS:
				return getXQuadTrans();
			case WirePackage.SYNCHRONOUS_MACHINE__OPERATING_MODE:
				return getOperatingMode();
			case WirePackage.SYNCHRONOUS_MACHINE__TYPE:
				return getType();
			case WirePackage.SYNCHRONOUS_MACHINE__CONDENSER_MW:
				return getCondenserMW();
			case WirePackage.SYNCHRONOUS_MACHINE__MV_AR_CAPABILITY_CURVES:
				return getMVArCapabilityCurves();
			case WirePackage.SYNCHRONOUS_MACHINE__DRIVES_HYDRO_PUMP:
				if (resolve) return getDrives_HydroPump();
				return basicGetDrives_HydroPump();
			case WirePackage.SYNCHRONOUS_MACHINE__GENERATING_UNIT:
				if (resolve) return getGeneratingUnit();
				return basicGetGeneratingUnit();
			case WirePackage.SYNCHRONOUS_MACHINE__PRIME_MOVER:
				return getPrimeMover();
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
			case WirePackage.SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LAG:
				setAVRToManualLag((Seconds)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LEAD:
				setAVRToManualLead((Seconds)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__BASE_MV_AR:
				setBaseMVAr((ReactivePower)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__COOLANT_CONDITION:
				setCoolantCondition((Float)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__COOLANT_TYPE:
				setCoolantType((CoolantType)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__DAMPING:
				setDamping((Damping)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__INERTIA:
				setInertia((Inertia)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__MANUAL_TO_AVR:
				setManualToAVR((Seconds)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__MAXIMUM_KV:
				setMaximumKV((Voltage)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__MAXIMUM_MV_AR:
				setMaximumMVAr((ReactivePower)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__MINIMUM_KV:
				setMinimumKV((Voltage)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__MINIMUM_MV_AR:
				setMinimumMVAr((ReactivePower)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__R:
				setR((Resistance)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__R0:
				setR0((Resistance)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__RATED_MVA:
				setRatedMVA((ApparentPower)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__X:
				setX((Reactance)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__X0:
				setX0((Reactance)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_SUBTRANS:
				setXDirectSubtrans((Reactance)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_SYNC:
				setXDirectSync((Reactance)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_TRANS:
				setXDirectTrans((Reactance)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__XQUAD_SUBTRANS:
				setXQuadSubtrans((Reactance)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__XQUAD_SYNC:
				setXQuadSync((Reactance)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__XQUAD_TRANS:
				setXQuadTrans((Reactance)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__OPERATING_MODE:
				setOperatingMode((SynchronousMachineOperatingMode)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__TYPE:
				setType((SynchronousMachineType)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__CONDENSER_MW:
				setCondenserMW((ActivePower)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__MV_AR_CAPABILITY_CURVES:
				getMVArCapabilityCurves().clear();
				getMVArCapabilityCurves().addAll((Collection)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__DRIVES_HYDRO_PUMP:
				setDrives_HydroPump((HydroPump)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__GENERATING_UNIT:
				setGeneratingUnit((GeneratingUnit)newValue);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__PRIME_MOVER:
				getPrimeMover().clear();
				getPrimeMover().addAll((Collection)newValue);
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
			case WirePackage.SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LAG:
				setAVRToManualLag(AVR_TO_MANUAL_LAG_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LEAD:
				setAVRToManualLead(AVR_TO_MANUAL_LEAD_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__BASE_MV_AR:
				setBaseMVAr(BASE_MV_AR_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__COOLANT_CONDITION:
				setCoolantCondition(COOLANT_CONDITION_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__COOLANT_TYPE:
				setCoolantType(COOLANT_TYPE_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__DAMPING:
				setDamping(DAMPING_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__INERTIA:
				setInertia(INERTIA_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__MANUAL_TO_AVR:
				setManualToAVR(MANUAL_TO_AVR_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__MAXIMUM_KV:
				setMaximumKV(MAXIMUM_KV_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__MAXIMUM_MV_AR:
				setMaximumMVAr(MAXIMUM_MV_AR_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__MINIMUM_KV:
				setMinimumKV(MINIMUM_KV_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__MINIMUM_MV_AR:
				setMinimumMVAr(MINIMUM_MV_AR_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__R:
				setR(R_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__R0:
				setR0(R0_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__RATED_MVA:
				setRatedMVA(RATED_MVA_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__X:
				setX(X_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__X0:
				setX0(X0_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_SUBTRANS:
				setXDirectSubtrans(XDIRECT_SUBTRANS_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_SYNC:
				setXDirectSync(XDIRECT_SYNC_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_TRANS:
				setXDirectTrans(XDIRECT_TRANS_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__XQUAD_SUBTRANS:
				setXQuadSubtrans(XQUAD_SUBTRANS_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__XQUAD_SYNC:
				setXQuadSync(XQUAD_SYNC_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__XQUAD_TRANS:
				setXQuadTrans(XQUAD_TRANS_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__OPERATING_MODE:
				setOperatingMode(OPERATING_MODE_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__CONDENSER_MW:
				setCondenserMW(CONDENSER_MW_EDEFAULT);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__MV_AR_CAPABILITY_CURVES:
				getMVArCapabilityCurves().clear();
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__DRIVES_HYDRO_PUMP:
				setDrives_HydroPump((HydroPump)null);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__GENERATING_UNIT:
				setGeneratingUnit((GeneratingUnit)null);
				return;
			case WirePackage.SYNCHRONOUS_MACHINE__PRIME_MOVER:
				getPrimeMover().clear();
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
			case WirePackage.SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LAG:
				return AVR_TO_MANUAL_LAG_EDEFAULT == null ? aVRToManualLag != null : !AVR_TO_MANUAL_LAG_EDEFAULT.equals(aVRToManualLag);
			case WirePackage.SYNCHRONOUS_MACHINE__AVR_TO_MANUAL_LEAD:
				return AVR_TO_MANUAL_LEAD_EDEFAULT == null ? aVRToManualLead != null : !AVR_TO_MANUAL_LEAD_EDEFAULT.equals(aVRToManualLead);
			case WirePackage.SYNCHRONOUS_MACHINE__BASE_MV_AR:
				return BASE_MV_AR_EDEFAULT == null ? baseMVAr != null : !BASE_MV_AR_EDEFAULT.equals(baseMVAr);
			case WirePackage.SYNCHRONOUS_MACHINE__COOLANT_CONDITION:
				return COOLANT_CONDITION_EDEFAULT == null ? coolantCondition != null : !COOLANT_CONDITION_EDEFAULT.equals(coolantCondition);
			case WirePackage.SYNCHRONOUS_MACHINE__COOLANT_TYPE:
				return coolantType != COOLANT_TYPE_EDEFAULT;
			case WirePackage.SYNCHRONOUS_MACHINE__DAMPING:
				return DAMPING_EDEFAULT == null ? damping != null : !DAMPING_EDEFAULT.equals(damping);
			case WirePackage.SYNCHRONOUS_MACHINE__INERTIA:
				return INERTIA_EDEFAULT == null ? inertia != null : !INERTIA_EDEFAULT.equals(inertia);
			case WirePackage.SYNCHRONOUS_MACHINE__MANUAL_TO_AVR:
				return MANUAL_TO_AVR_EDEFAULT == null ? manualToAVR != null : !MANUAL_TO_AVR_EDEFAULT.equals(manualToAVR);
			case WirePackage.SYNCHRONOUS_MACHINE__MAXIMUM_KV:
				return MAXIMUM_KV_EDEFAULT == null ? maximumKV != null : !MAXIMUM_KV_EDEFAULT.equals(maximumKV);
			case WirePackage.SYNCHRONOUS_MACHINE__MAXIMUM_MV_AR:
				return MAXIMUM_MV_AR_EDEFAULT == null ? maximumMVAr != null : !MAXIMUM_MV_AR_EDEFAULT.equals(maximumMVAr);
			case WirePackage.SYNCHRONOUS_MACHINE__MINIMUM_KV:
				return MINIMUM_KV_EDEFAULT == null ? minimumKV != null : !MINIMUM_KV_EDEFAULT.equals(minimumKV);
			case WirePackage.SYNCHRONOUS_MACHINE__MINIMUM_MV_AR:
				return MINIMUM_MV_AR_EDEFAULT == null ? minimumMVAr != null : !MINIMUM_MV_AR_EDEFAULT.equals(minimumMVAr);
			case WirePackage.SYNCHRONOUS_MACHINE__R:
				return R_EDEFAULT == null ? r != null : !R_EDEFAULT.equals(r);
			case WirePackage.SYNCHRONOUS_MACHINE__R0:
				return R0_EDEFAULT == null ? r0 != null : !R0_EDEFAULT.equals(r0);
			case WirePackage.SYNCHRONOUS_MACHINE__RATED_MVA:
				return RATED_MVA_EDEFAULT == null ? ratedMVA != null : !RATED_MVA_EDEFAULT.equals(ratedMVA);
			case WirePackage.SYNCHRONOUS_MACHINE__X:
				return X_EDEFAULT == null ? x != null : !X_EDEFAULT.equals(x);
			case WirePackage.SYNCHRONOUS_MACHINE__X0:
				return X0_EDEFAULT == null ? x0 != null : !X0_EDEFAULT.equals(x0);
			case WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_SUBTRANS:
				return XDIRECT_SUBTRANS_EDEFAULT == null ? xDirectSubtrans != null : !XDIRECT_SUBTRANS_EDEFAULT.equals(xDirectSubtrans);
			case WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_SYNC:
				return XDIRECT_SYNC_EDEFAULT == null ? xDirectSync != null : !XDIRECT_SYNC_EDEFAULT.equals(xDirectSync);
			case WirePackage.SYNCHRONOUS_MACHINE__XDIRECT_TRANS:
				return XDIRECT_TRANS_EDEFAULT == null ? xDirectTrans != null : !XDIRECT_TRANS_EDEFAULT.equals(xDirectTrans);
			case WirePackage.SYNCHRONOUS_MACHINE__XQUAD_SUBTRANS:
				return XQUAD_SUBTRANS_EDEFAULT == null ? xQuadSubtrans != null : !XQUAD_SUBTRANS_EDEFAULT.equals(xQuadSubtrans);
			case WirePackage.SYNCHRONOUS_MACHINE__XQUAD_SYNC:
				return XQUAD_SYNC_EDEFAULT == null ? xQuadSync != null : !XQUAD_SYNC_EDEFAULT.equals(xQuadSync);
			case WirePackage.SYNCHRONOUS_MACHINE__XQUAD_TRANS:
				return XQUAD_TRANS_EDEFAULT == null ? xQuadTrans != null : !XQUAD_TRANS_EDEFAULT.equals(xQuadTrans);
			case WirePackage.SYNCHRONOUS_MACHINE__OPERATING_MODE:
				return operatingMode != OPERATING_MODE_EDEFAULT;
			case WirePackage.SYNCHRONOUS_MACHINE__TYPE:
				return type != TYPE_EDEFAULT;
			case WirePackage.SYNCHRONOUS_MACHINE__CONDENSER_MW:
				return CONDENSER_MW_EDEFAULT == null ? condenserMW != null : !CONDENSER_MW_EDEFAULT.equals(condenserMW);
			case WirePackage.SYNCHRONOUS_MACHINE__MV_AR_CAPABILITY_CURVES:
				return mvArCapabilityCurves != null && !mvArCapabilityCurves.isEmpty();
			case WirePackage.SYNCHRONOUS_MACHINE__DRIVES_HYDRO_PUMP:
				return drives_HydroPump != null;
			case WirePackage.SYNCHRONOUS_MACHINE__GENERATING_UNIT:
				return generatingUnit != null;
			case WirePackage.SYNCHRONOUS_MACHINE__PRIME_MOVER:
				return primeMover != null && !primeMover.isEmpty();
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
		result.append(" (aVRToManualLag: ");
		result.append(aVRToManualLag);
		result.append(", aVRToManualLead: ");
		result.append(aVRToManualLead);
		result.append(", baseMVAr: ");
		result.append(baseMVAr);
		result.append(", coolantCondition: ");
		result.append(coolantCondition);
		result.append(", coolantType: ");
		result.append(coolantType);
		result.append(", damping: ");
		result.append(damping);
		result.append(", inertia: ");
		result.append(inertia);
		result.append(", manualToAVR: ");
		result.append(manualToAVR);
		result.append(", maximumKV: ");
		result.append(maximumKV);
		result.append(", maximumMVAr: ");
		result.append(maximumMVAr);
		result.append(", minimumKV: ");
		result.append(minimumKV);
		result.append(", minimumMVAr: ");
		result.append(minimumMVAr);
		result.append(", r: ");
		result.append(r);
		result.append(", r0: ");
		result.append(r0);
		result.append(", ratedMVA: ");
		result.append(ratedMVA);
		result.append(", x: ");
		result.append(x);
		result.append(", x0: ");
		result.append(x0);
		result.append(", xDirectSubtrans: ");
		result.append(xDirectSubtrans);
		result.append(", xDirectSync: ");
		result.append(xDirectSync);
		result.append(", xDirectTrans: ");
		result.append(xDirectTrans);
		result.append(", xQuadSubtrans: ");
		result.append(xQuadSubtrans);
		result.append(", xQuadSync: ");
		result.append(xQuadSync);
		result.append(", xQuadTrans: ");
		result.append(xQuadTrans);
		result.append(", operatingMode: ");
		result.append(operatingMode);
		result.append(", type: ");
		result.append(type);
		result.append(", condenserMW: ");
		result.append(condenserMW);
		result.append(')');
		return result.toString();
	}

} //SynchronousMachineImpl