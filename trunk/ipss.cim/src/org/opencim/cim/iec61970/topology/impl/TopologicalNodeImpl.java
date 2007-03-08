/**
 * <copyright>
 * </copyright>
 *
 * $Id: TopologicalNodeImpl.java,v 1.4 2007/03/07 05:14:04 mzhou Exp $
 */
package org.opencim.cim.iec61970.topology.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.impl.NamingImpl;

import org.opencim.cim.iec61970.topology.ConnectivityNode;
import org.opencim.cim.iec61970.topology.TopologicalIsland;
import org.opencim.cim.iec61970.topology.TopologicalNode;
import org.opencim.cim.iec61970.topology.TopologyPackage;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.AngleRadians;
import org.opencim.datatype.real.ReactivePower;
import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Topological Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.topology.impl.TopologicalNodeImpl#getEnergized <em>Energized</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.impl.TopologicalNodeImpl#getLoadCarrying <em>Load Carrying</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.impl.TopologicalNodeImpl#getNetInjectionMVar <em>Net Injection MVar</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.impl.TopologicalNodeImpl#getNetInjectionMW <em>Net Injection MW</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.impl.TopologicalNodeImpl#getObservabilityFlag <em>Observability Flag</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.impl.TopologicalNodeImpl#getPhaseAngle <em>Phase Angle</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.impl.TopologicalNodeImpl#getVoltage <em>Voltage</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.impl.TopologicalNodeImpl#getConnectivityNodes <em>Connectivity Nodes</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.impl.TopologicalNodeImpl#getTopologicalIsland <em>Topological Island</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopologicalNodeImpl extends NamingImpl implements TopologicalNode {
	/**
	 * The default value of the '{@link #getEnergized() <em>Energized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergized()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean ENERGIZED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnergized() <em>Energized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergized()
	 * @generated
	 * @ordered
	 */
	protected Boolean energized = ENERGIZED_EDEFAULT;

	/**
	 * The default value of the '{@link #getLoadCarrying() <em>Load Carrying</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadCarrying()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean LOAD_CARRYING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLoadCarrying() <em>Load Carrying</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadCarrying()
	 * @generated
	 * @ordered
	 */
	protected Boolean loadCarrying = LOAD_CARRYING_EDEFAULT;

	/**
	 * The default value of the '{@link #getNetInjectionMVar() <em>Net Injection MVar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetInjectionMVar()
	 * @generated
	 * @ordered
	 */
	protected static final ReactivePower NET_INJECTION_MVAR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNetInjectionMVar() <em>Net Injection MVar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetInjectionMVar()
	 * @generated
	 * @ordered
	 */
	protected ReactivePower netInjectionMVar = NET_INJECTION_MVAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getNetInjectionMW() <em>Net Injection MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetInjectionMW()
	 * @generated
	 * @ordered
	 */
	protected static final ActivePower NET_INJECTION_MW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNetInjectionMW() <em>Net Injection MW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetInjectionMW()
	 * @generated
	 * @ordered
	 */
	protected ActivePower netInjectionMW = NET_INJECTION_MW_EDEFAULT;

	/**
	 * The default value of the '{@link #getObservabilityFlag() <em>Observability Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObservabilityFlag()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean OBSERVABILITY_FLAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObservabilityFlag() <em>Observability Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObservabilityFlag()
	 * @generated
	 * @ordered
	 */
	protected Boolean observabilityFlag = OBSERVABILITY_FLAG_EDEFAULT;

	/**
	 * The default value of the '{@link #getPhaseAngle() <em>Phase Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhaseAngle()
	 * @generated
	 * @ordered
	 */
	protected static final AngleRadians PHASE_ANGLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhaseAngle() <em>Phase Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhaseAngle()
	 * @generated
	 * @ordered
	 */
	protected AngleRadians phaseAngle = PHASE_ANGLE_EDEFAULT;

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
	 * The cached value of the '{@link #getConnectivityNodes() <em>Connectivity Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectivityNodes()
	 * @generated
	 * @ordered
	 */
	protected EList connectivityNodes = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopologicalNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.TOPOLOGICAL_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getEnergized() {
		return energized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnergized(Boolean newEnergized) {
		Boolean oldEnergized = energized;
		energized = newEnergized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGICAL_NODE__ENERGIZED, oldEnergized, energized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getLoadCarrying() {
		return loadCarrying;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadCarrying(Boolean newLoadCarrying) {
		Boolean oldLoadCarrying = loadCarrying;
		loadCarrying = newLoadCarrying;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGICAL_NODE__LOAD_CARRYING, oldLoadCarrying, loadCarrying));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReactivePower getNetInjectionMVar() {
		return netInjectionMVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetInjectionMVar(ReactivePower newNetInjectionMVar) {
		ReactivePower oldNetInjectionMVar = netInjectionMVar;
		netInjectionMVar = newNetInjectionMVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGICAL_NODE__NET_INJECTION_MVAR, oldNetInjectionMVar, netInjectionMVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivePower getNetInjectionMW() {
		return netInjectionMW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetInjectionMW(ActivePower newNetInjectionMW) {
		ActivePower oldNetInjectionMW = netInjectionMW;
		netInjectionMW = newNetInjectionMW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGICAL_NODE__NET_INJECTION_MW, oldNetInjectionMW, netInjectionMW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getObservabilityFlag() {
		return observabilityFlag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObservabilityFlag(Boolean newObservabilityFlag) {
		Boolean oldObservabilityFlag = observabilityFlag;
		observabilityFlag = newObservabilityFlag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGICAL_NODE__OBSERVABILITY_FLAG, oldObservabilityFlag, observabilityFlag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AngleRadians getPhaseAngle() {
		return phaseAngle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhaseAngle(AngleRadians newPhaseAngle) {
		AngleRadians oldPhaseAngle = phaseAngle;
		phaseAngle = newPhaseAngle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGICAL_NODE__PHASE_ANGLE, oldPhaseAngle, phaseAngle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGICAL_NODE__VOLTAGE, oldVoltage, voltage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConnectivityNodes() {
		if (connectivityNodes == null) {
			connectivityNodes = new EObjectContainmentWithInverseEList(ConnectivityNode.class, this, TopologyPackage.TOPOLOGICAL_NODE__CONNECTIVITY_NODES, TopologyPackage.CONNECTIVITY_NODE__TOPOLOGICAL_NODE);
		}
		return connectivityNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopologicalIsland getTopologicalIsland() {
		if (eContainerFeatureID != TopologyPackage.TOPOLOGICAL_NODE__TOPOLOGICAL_ISLAND) return null;
		return (TopologicalIsland)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTopologicalIsland(TopologicalIsland newTopologicalIsland, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTopologicalIsland, TopologyPackage.TOPOLOGICAL_NODE__TOPOLOGICAL_ISLAND, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopologicalIsland(TopologicalIsland newTopologicalIsland) {
		if (newTopologicalIsland != eInternalContainer() || (eContainerFeatureID != TopologyPackage.TOPOLOGICAL_NODE__TOPOLOGICAL_ISLAND && newTopologicalIsland != null)) {
			if (EcoreUtil.isAncestor(this, newTopologicalIsland))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTopologicalIsland != null)
				msgs = ((InternalEObject)newTopologicalIsland).eInverseAdd(this, TopologyPackage.TOPOLOGICAL_ISLAND__TOPOLOGICAL_NODES, TopologicalIsland.class, msgs);
			msgs = basicSetTopologicalIsland(newTopologicalIsland, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGICAL_NODE__TOPOLOGICAL_ISLAND, newTopologicalIsland, newTopologicalIsland));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TopologyPackage.TOPOLOGICAL_NODE__CONNECTIVITY_NODES:
				return ((InternalEList)getConnectivityNodes()).basicAdd(otherEnd, msgs);
			case TopologyPackage.TOPOLOGICAL_NODE__TOPOLOGICAL_ISLAND:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTopologicalIsland((TopologicalIsland)otherEnd, msgs);
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
			case TopologyPackage.TOPOLOGICAL_NODE__CONNECTIVITY_NODES:
				return ((InternalEList)getConnectivityNodes()).basicRemove(otherEnd, msgs);
			case TopologyPackage.TOPOLOGICAL_NODE__TOPOLOGICAL_ISLAND:
				return basicSetTopologicalIsland(null, msgs);
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
			case TopologyPackage.TOPOLOGICAL_NODE__TOPOLOGICAL_ISLAND:
				return eInternalContainer().eInverseRemove(this, TopologyPackage.TOPOLOGICAL_ISLAND__TOPOLOGICAL_NODES, TopologicalIsland.class, msgs);
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
			case TopologyPackage.TOPOLOGICAL_NODE__ENERGIZED:
				return getEnergized();
			case TopologyPackage.TOPOLOGICAL_NODE__LOAD_CARRYING:
				return getLoadCarrying();
			case TopologyPackage.TOPOLOGICAL_NODE__NET_INJECTION_MVAR:
				return getNetInjectionMVar();
			case TopologyPackage.TOPOLOGICAL_NODE__NET_INJECTION_MW:
				return getNetInjectionMW();
			case TopologyPackage.TOPOLOGICAL_NODE__OBSERVABILITY_FLAG:
				return getObservabilityFlag();
			case TopologyPackage.TOPOLOGICAL_NODE__PHASE_ANGLE:
				return getPhaseAngle();
			case TopologyPackage.TOPOLOGICAL_NODE__VOLTAGE:
				return getVoltage();
			case TopologyPackage.TOPOLOGICAL_NODE__CONNECTIVITY_NODES:
				return getConnectivityNodes();
			case TopologyPackage.TOPOLOGICAL_NODE__TOPOLOGICAL_ISLAND:
				return getTopologicalIsland();
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
			case TopologyPackage.TOPOLOGICAL_NODE__ENERGIZED:
				setEnergized((Boolean)newValue);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__LOAD_CARRYING:
				setLoadCarrying((Boolean)newValue);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__NET_INJECTION_MVAR:
				setNetInjectionMVar((ReactivePower)newValue);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__NET_INJECTION_MW:
				setNetInjectionMW((ActivePower)newValue);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__OBSERVABILITY_FLAG:
				setObservabilityFlag((Boolean)newValue);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__PHASE_ANGLE:
				setPhaseAngle((AngleRadians)newValue);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__VOLTAGE:
				setVoltage((Voltage)newValue);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__CONNECTIVITY_NODES:
				getConnectivityNodes().clear();
				getConnectivityNodes().addAll((Collection)newValue);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__TOPOLOGICAL_ISLAND:
				setTopologicalIsland((TopologicalIsland)newValue);
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
			case TopologyPackage.TOPOLOGICAL_NODE__ENERGIZED:
				setEnergized(ENERGIZED_EDEFAULT);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__LOAD_CARRYING:
				setLoadCarrying(LOAD_CARRYING_EDEFAULT);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__NET_INJECTION_MVAR:
				setNetInjectionMVar(NET_INJECTION_MVAR_EDEFAULT);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__NET_INJECTION_MW:
				setNetInjectionMW(NET_INJECTION_MW_EDEFAULT);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__OBSERVABILITY_FLAG:
				setObservabilityFlag(OBSERVABILITY_FLAG_EDEFAULT);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__PHASE_ANGLE:
				setPhaseAngle(PHASE_ANGLE_EDEFAULT);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__VOLTAGE:
				setVoltage(VOLTAGE_EDEFAULT);
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__CONNECTIVITY_NODES:
				getConnectivityNodes().clear();
				return;
			case TopologyPackage.TOPOLOGICAL_NODE__TOPOLOGICAL_ISLAND:
				setTopologicalIsland((TopologicalIsland)null);
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
			case TopologyPackage.TOPOLOGICAL_NODE__ENERGIZED:
				return ENERGIZED_EDEFAULT == null ? energized != null : !ENERGIZED_EDEFAULT.equals(energized);
			case TopologyPackage.TOPOLOGICAL_NODE__LOAD_CARRYING:
				return LOAD_CARRYING_EDEFAULT == null ? loadCarrying != null : !LOAD_CARRYING_EDEFAULT.equals(loadCarrying);
			case TopologyPackage.TOPOLOGICAL_NODE__NET_INJECTION_MVAR:
				return NET_INJECTION_MVAR_EDEFAULT == null ? netInjectionMVar != null : !NET_INJECTION_MVAR_EDEFAULT.equals(netInjectionMVar);
			case TopologyPackage.TOPOLOGICAL_NODE__NET_INJECTION_MW:
				return NET_INJECTION_MW_EDEFAULT == null ? netInjectionMW != null : !NET_INJECTION_MW_EDEFAULT.equals(netInjectionMW);
			case TopologyPackage.TOPOLOGICAL_NODE__OBSERVABILITY_FLAG:
				return OBSERVABILITY_FLAG_EDEFAULT == null ? observabilityFlag != null : !OBSERVABILITY_FLAG_EDEFAULT.equals(observabilityFlag);
			case TopologyPackage.TOPOLOGICAL_NODE__PHASE_ANGLE:
				return PHASE_ANGLE_EDEFAULT == null ? phaseAngle != null : !PHASE_ANGLE_EDEFAULT.equals(phaseAngle);
			case TopologyPackage.TOPOLOGICAL_NODE__VOLTAGE:
				return VOLTAGE_EDEFAULT == null ? voltage != null : !VOLTAGE_EDEFAULT.equals(voltage);
			case TopologyPackage.TOPOLOGICAL_NODE__CONNECTIVITY_NODES:
				return connectivityNodes != null && !connectivityNodes.isEmpty();
			case TopologyPackage.TOPOLOGICAL_NODE__TOPOLOGICAL_ISLAND:
				return getTopologicalIsland() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer result = new StringBuffer("\nTopologicalNode: \n" + super.toString());
		result.append(" (energized: ");
		result.append(energized);
		result.append(", loadCarrying: ");
		result.append(loadCarrying);
		result.append(", netInjectionMVar: ");
		result.append(netInjectionMVar);
		result.append(", netInjectionMW: ");
		result.append(netInjectionMW);
		result.append(", observabilityFlag: ");
		result.append(observabilityFlag);
		result.append(", phaseAngle: ");
		result.append(phaseAngle);
		result.append(", voltage: ");
		result.append(voltage);
		result.append(')' + "\n");

		result.append(getConnectivityNodes().toString() + "\n");
		
		return result.toString();
	}

} //TopologicalNodeImpl