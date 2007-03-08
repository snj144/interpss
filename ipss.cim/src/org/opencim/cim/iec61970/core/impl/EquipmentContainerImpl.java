/**
 * <copyright>
 * </copyright>
 *
 * $Id: EquipmentContainerImpl.java,v 1.2 2007/03/04 17:58:13 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.Equipment;
import org.opencim.cim.iec61970.core.EquipmentContainer;

import org.opencim.cim.iec61970.topology.ConnectivityNode;
import org.opencim.cim.iec61970.topology.TopologyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equipment Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.EquipmentContainerImpl#getConnectivityNodes <em>Connectivity Nodes</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.EquipmentContainerImpl#getEquipments <em>Equipments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquipmentContainerImpl extends PowerSystemResourceImpl implements EquipmentContainer {
	/**
	 * The cached value of the '{@link #getConnectivityNodes() <em>Connectivity Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectivityNodes()
	 * @generated
	 * @ordered
	 */
	protected EList connectivityNodes = null;

	/**
	 * The cached value of the '{@link #getEquipments() <em>Equipments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipments()
	 * @generated
	 * @ordered
	 */
	protected EList equipments = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquipmentContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.EQUIPMENT_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConnectivityNodes() {
		if (connectivityNodes == null) {
			connectivityNodes = new EObjectWithInverseResolvingEList(ConnectivityNode.class, this, CorePackage.EQUIPMENT_CONTAINER__CONNECTIVITY_NODES, TopologyPackage.CONNECTIVITY_NODE__EQUIPMENT_CONTAINER);
		}
		return connectivityNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEquipments() {
		if (equipments == null) {
			equipments = new EObjectContainmentWithInverseEList(Equipment.class, this, CorePackage.EQUIPMENT_CONTAINER__EQUIPMENTS, CorePackage.EQUIPMENT__EQUIPMENT_CONTAINER);
		}
		return equipments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.EQUIPMENT_CONTAINER__CONNECTIVITY_NODES:
				return ((InternalEList)getConnectivityNodes()).basicAdd(otherEnd, msgs);
			case CorePackage.EQUIPMENT_CONTAINER__EQUIPMENTS:
				return ((InternalEList)getEquipments()).basicAdd(otherEnd, msgs);
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
			case CorePackage.EQUIPMENT_CONTAINER__CONNECTIVITY_NODES:
				return ((InternalEList)getConnectivityNodes()).basicRemove(otherEnd, msgs);
			case CorePackage.EQUIPMENT_CONTAINER__EQUIPMENTS:
				return ((InternalEList)getEquipments()).basicRemove(otherEnd, msgs);
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
			case CorePackage.EQUIPMENT_CONTAINER__CONNECTIVITY_NODES:
				return getConnectivityNodes();
			case CorePackage.EQUIPMENT_CONTAINER__EQUIPMENTS:
				return getEquipments();
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
			case CorePackage.EQUIPMENT_CONTAINER__CONNECTIVITY_NODES:
				getConnectivityNodes().clear();
				getConnectivityNodes().addAll((Collection)newValue);
				return;
			case CorePackage.EQUIPMENT_CONTAINER__EQUIPMENTS:
				getEquipments().clear();
				getEquipments().addAll((Collection)newValue);
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
			case CorePackage.EQUIPMENT_CONTAINER__CONNECTIVITY_NODES:
				getConnectivityNodes().clear();
				return;
			case CorePackage.EQUIPMENT_CONTAINER__EQUIPMENTS:
				getEquipments().clear();
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
			case CorePackage.EQUIPMENT_CONTAINER__CONNECTIVITY_NODES:
				return connectivityNodes != null && !connectivityNodes.isEmpty();
			case CorePackage.EQUIPMENT_CONTAINER__EQUIPMENTS:
				return equipments != null && !equipments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EquipmentContainerImpl