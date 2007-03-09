/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransformerWindingImpl.java,v 1.2 2007/03/08 00:05:30 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.impl.ConductingEquipmentImpl;

import org.opencim.cim.iec61970.domain.WindingConnection;
import org.opencim.cim.iec61970.domain.WindingType;

import org.opencim.cim.iec61970.wire.PowerTransformer;
import org.opencim.cim.iec61970.wire.TapChanger;
import org.opencim.cim.iec61970.wire.TransformerWinding;
import org.opencim.cim.iec61970.wire.WindingTest;
import org.opencim.cim.iec61970.wire.WirePackage;

import org.opencim.datatype.real.ApparentPower;
import org.opencim.datatype.real.Conductance;
import org.opencim.datatype.real.Reactance;
import org.opencim.datatype.real.Resistance;
import org.opencim.datatype.real.Susceptance;
import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformer Winding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getB <em>B</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getInsulationKV <em>Insulation KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getConnectionType <em>Connection Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getEmergencyMVA <em>Emergency MVA</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getG <em>G</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getGrounded <em>Grounded</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getR <em>R</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getR0 <em>R0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getRatedKV <em>Rated KV</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getRatedMVA <em>Rated MVA</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getRground <em>Rground</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getShortTermMVA <em>Short Term MVA</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getWindingType <em>Winding Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getX <em>X</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getX0 <em>X0</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getXground <em>Xground</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getPowerTransformer <em>Power Transformer</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getTapChangers <em>Tap Changers</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getFrom_WindingTests <em>From Winding Tests</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.TransformerWindingImpl#getTo_WindingTest <em>To Winding Test</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformerWindingImpl extends ConductingEquipmentImpl implements TransformerWinding {
	/**
	 * The default value of the '{@link #getB() <em>B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB()
	 * @generated
	 * @ordered
	 */
	protected static final Susceptance B_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getB() <em>B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB()
	 * @generated
	 * @ordered
	 */
	protected Susceptance b = B_EDEFAULT;

	/**
	 * The default value of the '{@link #getInsulationKV() <em>Insulation KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsulationKV()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage INSULATION_KV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInsulationKV() <em>Insulation KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsulationKV()
	 * @generated
	 * @ordered
	 */
	protected Voltage insulationKV = INSULATION_KV_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionType() <em>Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionType()
	 * @generated
	 * @ordered
	 */
	protected static final WindingConnection CONNECTION_TYPE_EDEFAULT = WindingConnection.D_LITERAL;

	/**
	 * The cached value of the '{@link #getConnectionType() <em>Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionType()
	 * @generated
	 * @ordered
	 */
	protected WindingConnection connectionType = CONNECTION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEmergencyMVA() <em>Emergency MVA</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmergencyMVA()
	 * @generated
	 * @ordered
	 */
	protected static final ApparentPower EMERGENCY_MVA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmergencyMVA() <em>Emergency MVA</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmergencyMVA()
	 * @generated
	 * @ordered
	 */
	protected ApparentPower emergencyMVA = EMERGENCY_MVA_EDEFAULT;

	/**
	 * The default value of the '{@link #getG() <em>G</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getG()
	 * @generated
	 * @ordered
	 */
	protected static final Conductance G_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getG() <em>G</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getG()
	 * @generated
	 * @ordered
	 */
	protected Conductance g = G_EDEFAULT;

	/**
	 * The default value of the '{@link #getGrounded() <em>Grounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrounded()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean GROUNDED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGrounded() <em>Grounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrounded()
	 * @generated
	 * @ordered
	 */
	protected Boolean grounded = GROUNDED_EDEFAULT;

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
	 * The default value of the '{@link #getRatedKV() <em>Rated KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatedKV()
	 * @generated
	 * @ordered
	 */
	protected static final Voltage RATED_KV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRatedKV() <em>Rated KV</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatedKV()
	 * @generated
	 * @ordered
	 */
	protected Voltage ratedKV = RATED_KV_EDEFAULT;

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
	 * The default value of the '{@link #getRground() <em>Rground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRground()
	 * @generated
	 * @ordered
	 */
	protected static final Resistance RGROUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRground() <em>Rground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRground()
	 * @generated
	 * @ordered
	 */
	protected Resistance rground = RGROUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getShortTermMVA() <em>Short Term MVA</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortTermMVA()
	 * @generated
	 * @ordered
	 */
	protected static final ApparentPower SHORT_TERM_MVA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShortTermMVA() <em>Short Term MVA</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortTermMVA()
	 * @generated
	 * @ordered
	 */
	protected ApparentPower shortTermMVA = SHORT_TERM_MVA_EDEFAULT;

	/**
	 * The default value of the '{@link #getWindingType() <em>Winding Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWindingType()
	 * @generated
	 * @ordered
	 */
	protected static final WindingType WINDING_TYPE_EDEFAULT = WindingType.PRIMARY_LITERAL;

	/**
	 * The cached value of the '{@link #getWindingType() <em>Winding Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWindingType()
	 * @generated
	 * @ordered
	 */
	protected WindingType windingType = WINDING_TYPE_EDEFAULT;

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
	 * The default value of the '{@link #getXground() <em>Xground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXground()
	 * @generated
	 * @ordered
	 */
	protected static final Reactance XGROUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXground() <em>Xground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXground()
	 * @generated
	 * @ordered
	 */
	protected Reactance xground = XGROUND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPowerTransformer() <em>Power Transformer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPowerTransformer()
	 * @generated
	 * @ordered
	 */
	protected PowerTransformer powerTransformer = null;

	/**
	 * The cached value of the '{@link #getTapChangers() <em>Tap Changers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTapChangers()
	 * @generated
	 * @ordered
	 */
	protected EList tapChangers = null;

	/**
	 * The cached value of the '{@link #getFrom_WindingTests() <em>From Winding Tests</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom_WindingTests()
	 * @generated
	 * @ordered
	 */
	protected EList from_WindingTests = null;

	/**
	 * The cached value of the '{@link #getTo_WindingTest() <em>To Winding Test</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo_WindingTest()
	 * @generated
	 * @ordered
	 */
	protected WindingTest to_WindingTest = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformerWindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.TRANSFORMER_WINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Susceptance getB() {
		return b;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setB(Susceptance newB) {
		Susceptance oldB = b;
		b = newB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__B, oldB, b));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getInsulationKV() {
		return insulationKV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInsulationKV(Voltage newInsulationKV) {
		Voltage oldInsulationKV = insulationKV;
		insulationKV = newInsulationKV;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__INSULATION_KV, oldInsulationKV, insulationKV));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindingConnection getConnectionType() {
		return connectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionType(WindingConnection newConnectionType) {
		WindingConnection oldConnectionType = connectionType;
		connectionType = newConnectionType == null ? CONNECTION_TYPE_EDEFAULT : newConnectionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__CONNECTION_TYPE, oldConnectionType, connectionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApparentPower getEmergencyMVA() {
		return emergencyMVA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmergencyMVA(ApparentPower newEmergencyMVA) {
		ApparentPower oldEmergencyMVA = emergencyMVA;
		emergencyMVA = newEmergencyMVA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__EMERGENCY_MVA, oldEmergencyMVA, emergencyMVA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Conductance getG() {
		return g;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setG(Conductance newG) {
		Conductance oldG = g;
		g = newG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__G, oldG, g));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getGrounded() {
		return grounded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrounded(Boolean newGrounded) {
		Boolean oldGrounded = grounded;
		grounded = newGrounded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__GROUNDED, oldGrounded, grounded));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__R, oldR, r));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__R0, oldR0, r0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voltage getRatedKV() {
		return ratedKV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRatedKV(Voltage newRatedKV) {
		Voltage oldRatedKV = ratedKV;
		ratedKV = newRatedKV;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__RATED_KV, oldRatedKV, ratedKV));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__RATED_MVA, oldRatedMVA, ratedMVA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resistance getRground() {
		return rground;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRground(Resistance newRground) {
		Resistance oldRground = rground;
		rground = newRground;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__RGROUND, oldRground, rground));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApparentPower getShortTermMVA() {
		return shortTermMVA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShortTermMVA(ApparentPower newShortTermMVA) {
		ApparentPower oldShortTermMVA = shortTermMVA;
		shortTermMVA = newShortTermMVA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__SHORT_TERM_MVA, oldShortTermMVA, shortTermMVA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindingType getWindingType() {
		return windingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWindingType(WindingType newWindingType) {
		WindingType oldWindingType = windingType;
		windingType = newWindingType == null ? WINDING_TYPE_EDEFAULT : newWindingType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__WINDING_TYPE, oldWindingType, windingType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__X, oldX, x));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__X0, oldX0, x0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactance getXground() {
		return xground;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXground(Reactance newXground) {
		Reactance oldXground = xground;
		xground = newXground;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__XGROUND, oldXground, xground));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerTransformer getPowerTransformer() {
		if (powerTransformer != null && powerTransformer.eIsProxy()) {
			InternalEObject oldPowerTransformer = (InternalEObject)powerTransformer;
			powerTransformer = (PowerTransformer)eResolveProxy(oldPowerTransformer);
			if (powerTransformer != oldPowerTransformer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WirePackage.TRANSFORMER_WINDING__POWER_TRANSFORMER, oldPowerTransformer, powerTransformer));
			}
		}
		return powerTransformer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerTransformer basicGetPowerTransformer() {
		return powerTransformer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPowerTransformer(PowerTransformer newPowerTransformer, NotificationChain msgs) {
		PowerTransformer oldPowerTransformer = powerTransformer;
		powerTransformer = newPowerTransformer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__POWER_TRANSFORMER, oldPowerTransformer, newPowerTransformer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPowerTransformer(PowerTransformer newPowerTransformer) {
		if (newPowerTransformer != powerTransformer) {
			NotificationChain msgs = null;
			if (powerTransformer != null)
				msgs = ((InternalEObject)powerTransformer).eInverseRemove(this, WirePackage.POWER_TRANSFORMER__TRANSFORMER_WINDINGS, PowerTransformer.class, msgs);
			if (newPowerTransformer != null)
				msgs = ((InternalEObject)newPowerTransformer).eInverseAdd(this, WirePackage.POWER_TRANSFORMER__TRANSFORMER_WINDINGS, PowerTransformer.class, msgs);
			msgs = basicSetPowerTransformer(newPowerTransformer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__POWER_TRANSFORMER, newPowerTransformer, newPowerTransformer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTapChangers() {
		if (tapChangers == null) {
			tapChangers = new EObjectContainmentEList(TapChanger.class, this, WirePackage.TRANSFORMER_WINDING__TAP_CHANGERS);
		}
		return tapChangers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFrom_WindingTests() {
		if (from_WindingTests == null) {
			from_WindingTests = new EObjectWithInverseResolvingEList(WindingTest.class, this, WirePackage.TRANSFORMER_WINDING__FROM_WINDING_TESTS, WirePackage.WINDING_TEST__FROM_TRANSFORMER_WINDING);
		}
		return from_WindingTests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindingTest getTo_WindingTest() {
		if (to_WindingTest != null && to_WindingTest.eIsProxy()) {
			InternalEObject oldTo_WindingTest = (InternalEObject)to_WindingTest;
			to_WindingTest = (WindingTest)eResolveProxy(oldTo_WindingTest);
			if (to_WindingTest != oldTo_WindingTest) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WirePackage.TRANSFORMER_WINDING__TO_WINDING_TEST, oldTo_WindingTest, to_WindingTest));
			}
		}
		return to_WindingTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindingTest basicGetTo_WindingTest() {
		return to_WindingTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTo_WindingTest(WindingTest newTo_WindingTest, NotificationChain msgs) {
		WindingTest oldTo_WindingTest = to_WindingTest;
		to_WindingTest = newTo_WindingTest;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__TO_WINDING_TEST, oldTo_WindingTest, newTo_WindingTest);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo_WindingTest(WindingTest newTo_WindingTest) {
		if (newTo_WindingTest != to_WindingTest) {
			NotificationChain msgs = null;
			if (to_WindingTest != null)
				msgs = ((InternalEObject)to_WindingTest).eInverseRemove(this, WirePackage.WINDING_TEST__TO_TRANSFORME_WINDINGS, WindingTest.class, msgs);
			if (newTo_WindingTest != null)
				msgs = ((InternalEObject)newTo_WindingTest).eInverseAdd(this, WirePackage.WINDING_TEST__TO_TRANSFORME_WINDINGS, WindingTest.class, msgs);
			msgs = basicSetTo_WindingTest(newTo_WindingTest, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WirePackage.TRANSFORMER_WINDING__TO_WINDING_TEST, newTo_WindingTest, newTo_WindingTest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.TRANSFORMER_WINDING__POWER_TRANSFORMER:
				if (powerTransformer != null)
					msgs = ((InternalEObject)powerTransformer).eInverseRemove(this, WirePackage.POWER_TRANSFORMER__TRANSFORMER_WINDINGS, PowerTransformer.class, msgs);
				return basicSetPowerTransformer((PowerTransformer)otherEnd, msgs);
			case WirePackage.TRANSFORMER_WINDING__FROM_WINDING_TESTS:
				return ((InternalEList)getFrom_WindingTests()).basicAdd(otherEnd, msgs);
			case WirePackage.TRANSFORMER_WINDING__TO_WINDING_TEST:
				if (to_WindingTest != null)
					msgs = ((InternalEObject)to_WindingTest).eInverseRemove(this, WirePackage.WINDING_TEST__TO_TRANSFORME_WINDINGS, WindingTest.class, msgs);
				return basicSetTo_WindingTest((WindingTest)otherEnd, msgs);
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
			case WirePackage.TRANSFORMER_WINDING__POWER_TRANSFORMER:
				return basicSetPowerTransformer(null, msgs);
			case WirePackage.TRANSFORMER_WINDING__TAP_CHANGERS:
				return ((InternalEList)getTapChangers()).basicRemove(otherEnd, msgs);
			case WirePackage.TRANSFORMER_WINDING__FROM_WINDING_TESTS:
				return ((InternalEList)getFrom_WindingTests()).basicRemove(otherEnd, msgs);
			case WirePackage.TRANSFORMER_WINDING__TO_WINDING_TEST:
				return basicSetTo_WindingTest(null, msgs);
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
			case WirePackage.TRANSFORMER_WINDING__B:
				return getB();
			case WirePackage.TRANSFORMER_WINDING__INSULATION_KV:
				return getInsulationKV();
			case WirePackage.TRANSFORMER_WINDING__CONNECTION_TYPE:
				return getConnectionType();
			case WirePackage.TRANSFORMER_WINDING__EMERGENCY_MVA:
				return getEmergencyMVA();
			case WirePackage.TRANSFORMER_WINDING__G:
				return getG();
			case WirePackage.TRANSFORMER_WINDING__GROUNDED:
				return getGrounded();
			case WirePackage.TRANSFORMER_WINDING__R:
				return getR();
			case WirePackage.TRANSFORMER_WINDING__R0:
				return getR0();
			case WirePackage.TRANSFORMER_WINDING__RATED_KV:
				return getRatedKV();
			case WirePackage.TRANSFORMER_WINDING__RATED_MVA:
				return getRatedMVA();
			case WirePackage.TRANSFORMER_WINDING__RGROUND:
				return getRground();
			case WirePackage.TRANSFORMER_WINDING__SHORT_TERM_MVA:
				return getShortTermMVA();
			case WirePackage.TRANSFORMER_WINDING__WINDING_TYPE:
				return getWindingType();
			case WirePackage.TRANSFORMER_WINDING__X:
				return getX();
			case WirePackage.TRANSFORMER_WINDING__X0:
				return getX0();
			case WirePackage.TRANSFORMER_WINDING__XGROUND:
				return getXground();
			case WirePackage.TRANSFORMER_WINDING__POWER_TRANSFORMER:
				if (resolve) return getPowerTransformer();
				return basicGetPowerTransformer();
			case WirePackage.TRANSFORMER_WINDING__TAP_CHANGERS:
				return getTapChangers();
			case WirePackage.TRANSFORMER_WINDING__FROM_WINDING_TESTS:
				return getFrom_WindingTests();
			case WirePackage.TRANSFORMER_WINDING__TO_WINDING_TEST:
				if (resolve) return getTo_WindingTest();
				return basicGetTo_WindingTest();
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
			case WirePackage.TRANSFORMER_WINDING__B:
				setB((Susceptance)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__INSULATION_KV:
				setInsulationKV((Voltage)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__CONNECTION_TYPE:
				setConnectionType((WindingConnection)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__EMERGENCY_MVA:
				setEmergencyMVA((ApparentPower)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__G:
				setG((Conductance)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__GROUNDED:
				setGrounded((Boolean)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__R:
				setR((Resistance)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__R0:
				setR0((Resistance)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__RATED_KV:
				setRatedKV((Voltage)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__RATED_MVA:
				setRatedMVA((ApparentPower)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__RGROUND:
				setRground((Resistance)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__SHORT_TERM_MVA:
				setShortTermMVA((ApparentPower)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__WINDING_TYPE:
				setWindingType((WindingType)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__X:
				setX((Reactance)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__X0:
				setX0((Reactance)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__XGROUND:
				setXground((Reactance)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__POWER_TRANSFORMER:
				setPowerTransformer((PowerTransformer)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__TAP_CHANGERS:
				getTapChangers().clear();
				getTapChangers().addAll((Collection)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__FROM_WINDING_TESTS:
				getFrom_WindingTests().clear();
				getFrom_WindingTests().addAll((Collection)newValue);
				return;
			case WirePackage.TRANSFORMER_WINDING__TO_WINDING_TEST:
				setTo_WindingTest((WindingTest)newValue);
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
			case WirePackage.TRANSFORMER_WINDING__B:
				setB(B_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__INSULATION_KV:
				setInsulationKV(INSULATION_KV_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__CONNECTION_TYPE:
				setConnectionType(CONNECTION_TYPE_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__EMERGENCY_MVA:
				setEmergencyMVA(EMERGENCY_MVA_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__G:
				setG(G_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__GROUNDED:
				setGrounded(GROUNDED_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__R:
				setR(R_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__R0:
				setR0(R0_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__RATED_KV:
				setRatedKV(RATED_KV_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__RATED_MVA:
				setRatedMVA(RATED_MVA_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__RGROUND:
				setRground(RGROUND_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__SHORT_TERM_MVA:
				setShortTermMVA(SHORT_TERM_MVA_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__WINDING_TYPE:
				setWindingType(WINDING_TYPE_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__X:
				setX(X_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__X0:
				setX0(X0_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__XGROUND:
				setXground(XGROUND_EDEFAULT);
				return;
			case WirePackage.TRANSFORMER_WINDING__POWER_TRANSFORMER:
				setPowerTransformer((PowerTransformer)null);
				return;
			case WirePackage.TRANSFORMER_WINDING__TAP_CHANGERS:
				getTapChangers().clear();
				return;
			case WirePackage.TRANSFORMER_WINDING__FROM_WINDING_TESTS:
				getFrom_WindingTests().clear();
				return;
			case WirePackage.TRANSFORMER_WINDING__TO_WINDING_TEST:
				setTo_WindingTest((WindingTest)null);
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
			case WirePackage.TRANSFORMER_WINDING__B:
				return B_EDEFAULT == null ? b != null : !B_EDEFAULT.equals(b);
			case WirePackage.TRANSFORMER_WINDING__INSULATION_KV:
				return INSULATION_KV_EDEFAULT == null ? insulationKV != null : !INSULATION_KV_EDEFAULT.equals(insulationKV);
			case WirePackage.TRANSFORMER_WINDING__CONNECTION_TYPE:
				return connectionType != CONNECTION_TYPE_EDEFAULT;
			case WirePackage.TRANSFORMER_WINDING__EMERGENCY_MVA:
				return EMERGENCY_MVA_EDEFAULT == null ? emergencyMVA != null : !EMERGENCY_MVA_EDEFAULT.equals(emergencyMVA);
			case WirePackage.TRANSFORMER_WINDING__G:
				return G_EDEFAULT == null ? g != null : !G_EDEFAULT.equals(g);
			case WirePackage.TRANSFORMER_WINDING__GROUNDED:
				return GROUNDED_EDEFAULT == null ? grounded != null : !GROUNDED_EDEFAULT.equals(grounded);
			case WirePackage.TRANSFORMER_WINDING__R:
				return R_EDEFAULT == null ? r != null : !R_EDEFAULT.equals(r);
			case WirePackage.TRANSFORMER_WINDING__R0:
				return R0_EDEFAULT == null ? r0 != null : !R0_EDEFAULT.equals(r0);
			case WirePackage.TRANSFORMER_WINDING__RATED_KV:
				return RATED_KV_EDEFAULT == null ? ratedKV != null : !RATED_KV_EDEFAULT.equals(ratedKV);
			case WirePackage.TRANSFORMER_WINDING__RATED_MVA:
				return RATED_MVA_EDEFAULT == null ? ratedMVA != null : !RATED_MVA_EDEFAULT.equals(ratedMVA);
			case WirePackage.TRANSFORMER_WINDING__RGROUND:
				return RGROUND_EDEFAULT == null ? rground != null : !RGROUND_EDEFAULT.equals(rground);
			case WirePackage.TRANSFORMER_WINDING__SHORT_TERM_MVA:
				return SHORT_TERM_MVA_EDEFAULT == null ? shortTermMVA != null : !SHORT_TERM_MVA_EDEFAULT.equals(shortTermMVA);
			case WirePackage.TRANSFORMER_WINDING__WINDING_TYPE:
				return windingType != WINDING_TYPE_EDEFAULT;
			case WirePackage.TRANSFORMER_WINDING__X:
				return X_EDEFAULT == null ? x != null : !X_EDEFAULT.equals(x);
			case WirePackage.TRANSFORMER_WINDING__X0:
				return X0_EDEFAULT == null ? x0 != null : !X0_EDEFAULT.equals(x0);
			case WirePackage.TRANSFORMER_WINDING__XGROUND:
				return XGROUND_EDEFAULT == null ? xground != null : !XGROUND_EDEFAULT.equals(xground);
			case WirePackage.TRANSFORMER_WINDING__POWER_TRANSFORMER:
				return powerTransformer != null;
			case WirePackage.TRANSFORMER_WINDING__TAP_CHANGERS:
				return tapChangers != null && !tapChangers.isEmpty();
			case WirePackage.TRANSFORMER_WINDING__FROM_WINDING_TESTS:
				return from_WindingTests != null && !from_WindingTests.isEmpty();
			case WirePackage.TRANSFORMER_WINDING__TO_WINDING_TEST:
				return to_WindingTest != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer result = new StringBuffer("\nTransformerWinding:\n" + super.toString());
		result.append(" (b: ");
		result.append(b);
		result.append(", insulationKV: ");
		result.append(insulationKV);
		result.append(", connectionType: ");
		result.append(connectionType);
		result.append(", emergencyMVA: ");
		result.append(emergencyMVA);
		result.append(", g: ");
		result.append(g);
		result.append(", grounded: ");
		result.append(grounded);
		result.append(", r: ");
		result.append(r);
		result.append(", r0: ");
		result.append(r0);
		result.append(", ratedKV: ");
		result.append(ratedKV);
		result.append(", ratedMVA: ");
		result.append(ratedMVA);
		result.append(", rground: ");
		result.append(rground);
		result.append(", shortTermMVA: ");
		result.append(shortTermMVA);
		result.append(", windingType: ");
		result.append(windingType);
		result.append(", x: ");
		result.append(x);
		result.append(", x0: ");
		result.append(x0);
		result.append(", xground: ");
		result.append(xground);
		result.append(')' + "\n");
		return result.toString();
	}

} //TransformerWindingImpl