/**
 * <copyright>
 * </copyright>
 *
 * $Id: TopologicalIslandImpl.java,v 1.5 2007/03/07 05:14:04 mzhou Exp $
 */
package org.opencim.cim.iec61970.topology.impl;

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

import org.opencim.cim.SimulationModel;
import org.opencim.cim.cimPackage;

import org.opencim.cim.iec61970.core.impl.NamingImpl;

import org.opencim.cim.iec61970.topology.TopologicalIsland;
import org.opencim.cim.iec61970.topology.TopologicalNode;
import org.opencim.cim.impl.cimPackageImpl;

import org.opencim.cim.iec61970.topology.TopologyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Topological Island</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.topology.impl.TopologicalIslandImpl#getSimuModel <em>Simu Model</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.topology.impl.TopologicalIslandImpl#getTopologicalNodes <em>Topological Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopologicalIslandImpl extends NamingImpl implements TopologicalIsland {
	/**
	 * The cached value of the '{@link #getTopologicalNodes() <em>Topological Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopologicalNodes()
	 * @generated
	 * @ordered
	 */
	protected EList topologicalNodes = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopologicalIslandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.TOPOLOGICAL_ISLAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationModel getSimuModel() {
		if (eContainerFeatureID != TopologyPackage.TOPOLOGICAL_ISLAND__SIMU_MODEL) return null;
		return (SimulationModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimuModel(SimulationModel newSimuModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSimuModel, TopologyPackage.TOPOLOGICAL_ISLAND__SIMU_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimuModel(SimulationModel newSimuModel) {
		if (newSimuModel != eInternalContainer() || (eContainerFeatureID != TopologyPackage.TOPOLOGICAL_ISLAND__SIMU_MODEL && newSimuModel != null)) {
			if (EcoreUtil.isAncestor(this, newSimuModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSimuModel != null)
				msgs = ((InternalEObject)newSimuModel).eInverseAdd(this, cimPackage.SIMULATION_MODEL__TOPOLOGICAL_ISLANDS, SimulationModel.class, msgs);
			msgs = basicSetSimuModel(newSimuModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGICAL_ISLAND__SIMU_MODEL, newSimuModel, newSimuModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTopologicalNodes() {
		if (topologicalNodes == null) {
			topologicalNodes = new EObjectContainmentWithInverseEList(TopologicalNode.class, this, TopologyPackage.TOPOLOGICAL_ISLAND__TOPOLOGICAL_NODES, TopologyPackage.TOPOLOGICAL_NODE__TOPOLOGICAL_ISLAND);
		}
		return topologicalNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TopologyPackage.TOPOLOGICAL_ISLAND__SIMU_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSimuModel((SimulationModel)otherEnd, msgs);
			case TopologyPackage.TOPOLOGICAL_ISLAND__TOPOLOGICAL_NODES:
				return ((InternalEList)getTopologicalNodes()).basicAdd(otherEnd, msgs);
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
			case TopologyPackage.TOPOLOGICAL_ISLAND__SIMU_MODEL:
				return basicSetSimuModel(null, msgs);
			case TopologyPackage.TOPOLOGICAL_ISLAND__TOPOLOGICAL_NODES:
				return ((InternalEList)getTopologicalNodes()).basicRemove(otherEnd, msgs);
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
			case TopologyPackage.TOPOLOGICAL_ISLAND__SIMU_MODEL:
				return eInternalContainer().eInverseRemove(this, cimPackage.SIMULATION_MODEL__TOPOLOGICAL_ISLANDS, SimulationModel.class, msgs);
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
			case TopologyPackage.TOPOLOGICAL_ISLAND__SIMU_MODEL:
				return getSimuModel();
			case TopologyPackage.TOPOLOGICAL_ISLAND__TOPOLOGICAL_NODES:
				return getTopologicalNodes();
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
			case TopologyPackage.TOPOLOGICAL_ISLAND__SIMU_MODEL:
				setSimuModel((SimulationModel)newValue);
				return;
			case TopologyPackage.TOPOLOGICAL_ISLAND__TOPOLOGICAL_NODES:
				getTopologicalNodes().clear();
				getTopologicalNodes().addAll((Collection)newValue);
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
			case TopologyPackage.TOPOLOGICAL_ISLAND__SIMU_MODEL:
				setSimuModel((SimulationModel)null);
				return;
			case TopologyPackage.TOPOLOGICAL_ISLAND__TOPOLOGICAL_NODES:
				getTopologicalNodes().clear();
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
			case TopologyPackage.TOPOLOGICAL_ISLAND__SIMU_MODEL:
				return getSimuModel() != null;
			case TopologyPackage.TOPOLOGICAL_ISLAND__TOPOLOGICAL_NODES:
				return topologicalNodes != null && !topologicalNodes.isEmpty();
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
		result.append("TopologicalIsland: \n" + super.toString() + "\n");
		result.append(getTopologicalNodes().toString() + "\n");
		return result.toString();
	}	
} //TopologicalIslandImpl