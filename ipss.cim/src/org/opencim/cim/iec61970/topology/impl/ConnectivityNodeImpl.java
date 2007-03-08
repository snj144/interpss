/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConnectivityNodeImpl.java,v 1.4 2007/03/07 05:14:04 mzhou Exp $
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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.EquipmentContainer;
import org.opencim.cim.iec61970.core.Terminal;

import org.opencim.cim.iec61970.core.impl.NamingImpl;

import org.opencim.cim.iec61970.topology.ConnectivityNode;
import org.opencim.cim.iec61970.topology.TopologicalNode;
import org.opencim.cim.iec61970.topology.TopologyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connectivity Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.topology.impl.ConnectivityNodeImpl#getTopologicalNode <em>Topological Node</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.impl.ConnectivityNodeImpl#getTerminals <em>Terminals</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.impl.ConnectivityNodeImpl#getEquipmentContainer <em>Equipment Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectivityNodeImpl extends NamingImpl implements ConnectivityNode {
	/**
	 * The cached value of the '{@link #getTerminals() <em>Terminals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminals()
	 * @generated
	 * @ordered
	 */
	protected EList terminals = null;

	/**
	 * The cached value of the '{@link #getEquipmentContainer() <em>Equipment Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentContainer()
	 * @generated
	 * @ordered
	 */
	protected EquipmentContainer equipmentContainer = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectivityNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.CONNECTIVITY_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopologicalNode getTopologicalNode() {
		if (eContainerFeatureID != TopologyPackage.CONNECTIVITY_NODE__TOPOLOGICAL_NODE) return null;
		return (TopologicalNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTopologicalNode(TopologicalNode newTopologicalNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTopologicalNode, TopologyPackage.CONNECTIVITY_NODE__TOPOLOGICAL_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopologicalNode(TopologicalNode newTopologicalNode) {
		if (newTopologicalNode != eInternalContainer() || (eContainerFeatureID != TopologyPackage.CONNECTIVITY_NODE__TOPOLOGICAL_NODE && newTopologicalNode != null)) {
			if (EcoreUtil.isAncestor(this, newTopologicalNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTopologicalNode != null)
				msgs = ((InternalEObject)newTopologicalNode).eInverseAdd(this, TopologyPackage.TOPOLOGICAL_NODE__CONNECTIVITY_NODES, TopologicalNode.class, msgs);
			msgs = basicSetTopologicalNode(newTopologicalNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.CONNECTIVITY_NODE__TOPOLOGICAL_NODE, newTopologicalNode, newTopologicalNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTerminals() {
		if (terminals == null) {
			terminals = new EObjectContainmentWithInverseEList(Terminal.class, this, TopologyPackage.CONNECTIVITY_NODE__TERMINALS, CorePackage.TERMINAL__CONNECTIVITY_NODE);
		}
		return terminals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquipmentContainer getEquipmentContainer() {
		if (equipmentContainer != null && equipmentContainer.eIsProxy()) {
			InternalEObject oldEquipmentContainer = (InternalEObject)equipmentContainer;
			equipmentContainer = (EquipmentContainer)eResolveProxy(oldEquipmentContainer);
			if (equipmentContainer != oldEquipmentContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TopologyPackage.CONNECTIVITY_NODE__EQUIPMENT_CONTAINER, oldEquipmentContainer, equipmentContainer));
			}
		}
		return equipmentContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquipmentContainer basicGetEquipmentContainer() {
		return equipmentContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEquipmentContainer(EquipmentContainer newEquipmentContainer, NotificationChain msgs) {
		EquipmentContainer oldEquipmentContainer = equipmentContainer;
		equipmentContainer = newEquipmentContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TopologyPackage.CONNECTIVITY_NODE__EQUIPMENT_CONTAINER, oldEquipmentContainer, newEquipmentContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquipmentContainer(EquipmentContainer newEquipmentContainer) {
		if (newEquipmentContainer != equipmentContainer) {
			NotificationChain msgs = null;
			if (equipmentContainer != null)
				msgs = ((InternalEObject)equipmentContainer).eInverseRemove(this, CorePackage.EQUIPMENT_CONTAINER__CONNECTIVITY_NODES, EquipmentContainer.class, msgs);
			if (newEquipmentContainer != null)
				msgs = ((InternalEObject)newEquipmentContainer).eInverseAdd(this, CorePackage.EQUIPMENT_CONTAINER__CONNECTIVITY_NODES, EquipmentContainer.class, msgs);
			msgs = basicSetEquipmentContainer(newEquipmentContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.CONNECTIVITY_NODE__EQUIPMENT_CONTAINER, newEquipmentContainer, newEquipmentContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TopologyPackage.CONNECTIVITY_NODE__TOPOLOGICAL_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTopologicalNode((TopologicalNode)otherEnd, msgs);
			case TopologyPackage.CONNECTIVITY_NODE__TERMINALS:
				return ((InternalEList)getTerminals()).basicAdd(otherEnd, msgs);
			case TopologyPackage.CONNECTIVITY_NODE__EQUIPMENT_CONTAINER:
				if (equipmentContainer != null)
					msgs = ((InternalEObject)equipmentContainer).eInverseRemove(this, CorePackage.EQUIPMENT_CONTAINER__CONNECTIVITY_NODES, EquipmentContainer.class, msgs);
				return basicSetEquipmentContainer((EquipmentContainer)otherEnd, msgs);
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
			case TopologyPackage.CONNECTIVITY_NODE__TOPOLOGICAL_NODE:
				return basicSetTopologicalNode(null, msgs);
			case TopologyPackage.CONNECTIVITY_NODE__TERMINALS:
				return ((InternalEList)getTerminals()).basicRemove(otherEnd, msgs);
			case TopologyPackage.CONNECTIVITY_NODE__EQUIPMENT_CONTAINER:
				return basicSetEquipmentContainer(null, msgs);
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
			case TopologyPackage.CONNECTIVITY_NODE__TOPOLOGICAL_NODE:
				return eInternalContainer().eInverseRemove(this, TopologyPackage.TOPOLOGICAL_NODE__CONNECTIVITY_NODES, TopologicalNode.class, msgs);
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
			case TopologyPackage.CONNECTIVITY_NODE__TOPOLOGICAL_NODE:
				return getTopologicalNode();
			case TopologyPackage.CONNECTIVITY_NODE__TERMINALS:
				return getTerminals();
			case TopologyPackage.CONNECTIVITY_NODE__EQUIPMENT_CONTAINER:
				if (resolve) return getEquipmentContainer();
				return basicGetEquipmentContainer();
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
			case TopologyPackage.CONNECTIVITY_NODE__TOPOLOGICAL_NODE:
				setTopologicalNode((TopologicalNode)newValue);
				return;
			case TopologyPackage.CONNECTIVITY_NODE__TERMINALS:
				getTerminals().clear();
				getTerminals().addAll((Collection)newValue);
				return;
			case TopologyPackage.CONNECTIVITY_NODE__EQUIPMENT_CONTAINER:
				setEquipmentContainer((EquipmentContainer)newValue);
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
			case TopologyPackage.CONNECTIVITY_NODE__TOPOLOGICAL_NODE:
				setTopologicalNode((TopologicalNode)null);
				return;
			case TopologyPackage.CONNECTIVITY_NODE__TERMINALS:
				getTerminals().clear();
				return;
			case TopologyPackage.CONNECTIVITY_NODE__EQUIPMENT_CONTAINER:
				setEquipmentContainer((EquipmentContainer)null);
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
			case TopologyPackage.CONNECTIVITY_NODE__TOPOLOGICAL_NODE:
				return getTopologicalNode() != null;
			case TopologyPackage.CONNECTIVITY_NODE__TERMINALS:
				return terminals != null && !terminals.isEmpty();
			case TopologyPackage.CONNECTIVITY_NODE__EQUIPMENT_CONTAINER:
				return equipmentContainer != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("ConnectivityNode: \n" + super.toString() + "\n");
		
		if (getTerminals().size() > 0) 
			result.append(getTerminals().toString() + "\n");
		
		return result.toString();
	}	
} //ConnectivityNodeImpl