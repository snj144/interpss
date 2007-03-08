/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimulationModelImpl.java,v 1.7 2007/03/08 00:05:31 mzhou Exp $
 */
package org.opencim.cim.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.opencim.cim.SimulationModel;
import org.opencim.cim.cimPackage;
import org.opencim.cim.iec61970.core.BasePower;
import org.opencim.cim.iec61970.core.BaseVoltage;
import org.opencim.cim.iec61970.core.Bay;
import org.opencim.cim.iec61970.core.Company;
import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.Equipment;
import org.opencim.cim.iec61970.core.Naming;
import org.opencim.cim.iec61970.core.PowerSystemResource;
import org.opencim.cim.iec61970.core.SubControlArea;
import org.opencim.cim.iec61970.core.Substation;
import org.opencim.cim.iec61970.core.Terminal;
import org.opencim.cim.iec61970.core.VoltageLevel;
import org.opencim.cim.iec61970.core.impl.NamingImpl;
import org.opencim.cim.iec61970.gen.production.GeneratingUnit;
import org.opencim.cim.iec61970.load.LoadArea;
import org.opencim.cim.iec61970.topology.ConnectivityNode;
import org.opencim.cim.iec61970.topology.TopologicalIsland;
import org.opencim.cim.iec61970.topology.TopologicalNode;
import org.opencim.cim.iec61970.topology.TopologyPackage;
import org.opencim.cim.iec61970.wire.ACLineSegment;
import org.opencim.cim.iec61970.wire.Line;
import org.opencim.cim.iec61970.wire.SynchronousMachine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulation Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.impl.SimulationModelImpl#getBasePower <em>Base Power</em>}</li>
 *   <li>{@link org.opencim.cim.impl.SimulationModelImpl#getCompanies <em>Companies</em>}</li>
 *   <li>{@link org.opencim.cim.impl.SimulationModelImpl#getTopologicalIslands <em>Topological Islands</em>}</li>
 *   <li>{@link org.opencim.cim.impl.SimulationModelImpl#getPsResources <em>Ps Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimulationModelImpl extends NamingImpl implements SimulationModel {
	/**
	 * The cached value of the '{@link #getBasePower() <em>Base Power</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasePower()
	 * @generated
	 * @ordered
	 */
	protected BasePower basePower = null;

	/**
	 * The cached value of the '{@link #getCompanies() <em>Companies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompanies()
	 * @generated
	 * @ordered
	 */
	protected EList companies = null;

	/**
	 * The cached value of the '{@link #getTopologicalIslands() <em>Topological Islands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopologicalIslands()
	 * @generated
	 * @ordered
	 */
	protected EList topologicalIslands = null;

	/**
	 * The cached value of the '{@link #getPsResources() <em>Ps Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPsResources()
	 * @generated
	 * @ordered
	 */
	protected EList psResources = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return cimPackage.Literals.SIMULATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasePower getBasePower() {
		return basePower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBasePower(BasePower newBasePower, NotificationChain msgs) {
		BasePower oldBasePower = basePower;
		basePower = newBasePower;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, cimPackage.SIMULATION_MODEL__BASE_POWER, oldBasePower, newBasePower);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasePower(BasePower newBasePower) {
		if (newBasePower != basePower) {
			NotificationChain msgs = null;
			if (basePower != null)
				msgs = ((InternalEObject)basePower).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - cimPackage.SIMULATION_MODEL__BASE_POWER, null, msgs);
			if (newBasePower != null)
				msgs = ((InternalEObject)newBasePower).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - cimPackage.SIMULATION_MODEL__BASE_POWER, null, msgs);
			msgs = basicSetBasePower(newBasePower, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cimPackage.SIMULATION_MODEL__BASE_POWER, newBasePower, newBasePower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCompanies() {
		if (companies == null) {
			companies = new EObjectContainmentWithInverseEList(Company.class, this, cimPackage.SIMULATION_MODEL__COMPANIES, CorePackage.COMPANY__SIMU_MODEL);
		}
		return companies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTopologicalIslands() {
		if (topologicalIslands == null) {
			topologicalIslands = new EObjectContainmentWithInverseEList(TopologicalIsland.class, this, cimPackage.SIMULATION_MODEL__TOPOLOGICAL_ISLANDS, TopologyPackage.TOPOLOGICAL_ISLAND__SIMU_MODEL);
		}
		return topologicalIslands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPsResources() {
		if (psResources == null) {
			psResources = new EObjectContainmentWithInverseEList(PowerSystemResource.class, this, cimPackage.SIMULATION_MODEL__PS_RESOURCES, CorePackage.POWER_SYSTEM_RESOURCE__SIMU_MODEL);
		}
		return psResources;
	}

	private Object getElement(String mRID, EList list) {
		for (Object obj : list) {
			if (((Naming)obj).getMRID().equals(mRID))
				return obj;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BaseVoltage getBaseVoltage(String mRID) {
		return (BaseVoltage)getElement(mRID, getBasePower().getBaseVoltages());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Company getCompany(String mRID) {
		return (Company)getElement(mRID, getCompanies());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Naming getTopologicalObject(String mRID, Class klass) {
		if (klass == TopologicalIsland.class) {
			return (TopologicalIsland)getElement(mRID, getTopologicalIslands());
		}
		else if (klass == TopologicalNode.class) {
			for (Object obj : getTopologicalIslands()) {
				TopologicalNode tnode = (TopologicalNode)getElement(mRID, 
						((TopologicalIsland)obj).getTopologicalNodes());
				if (tnode != null) 
					return tnode;
			}
		}
		else if (klass == ConnectivityNode.class) {
			for (Object tIsland : getTopologicalIslands()) {
				for (Object tNode : ((TopologicalIsland)tIsland).getTopologicalNodes()) {
					ConnectivityNode cnode = (ConnectivityNode)getElement(mRID, 
						((TopologicalNode)tNode).getConnectivityNodes());
					if (cnode != null) 
						return cnode;
				}
			}
		}
		else if (klass == Terminal.class) {
			for (Object tIsland : getTopologicalIslands()) {
				for (Object tNode : ((TopologicalIsland)tIsland).getTopologicalNodes()) {
					for (Object cNode : ((TopologicalNode)tNode).getConnectivityNodes()) {
						Terminal t = (Terminal)getElement(mRID, 
								((ConnectivityNode)cNode).getTerminals());
						if (t != null) 
							return t;
					}
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Naming getTopologicalObject(String mRID, Class klass, Object parent) {
		if (klass == TopologicalNode.class) {
			return (TopologicalNode)getElement(mRID, ((TopologicalIsland)parent).getTopologicalNodes());
		}
		else if (klass == ConnectivityNode.class) {
			return (ConnectivityNode)getElement(mRID, ((TopologicalNode)parent).getConnectivityNodes());
		}
		else if (klass == Terminal.class) {
			return (Terminal)getElement(mRID, ((ConnectivityNode)parent).getTerminals());
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PowerSystemResource getPsResource(String mRID, Class klass, Object parent) {
		if (klass == Substation.class) {
			return (Substation)getElement(mRID, ((SubControlArea)parent).getSubstations());
		}
		else if (klass == VoltageLevel.class) {
			return (VoltageLevel)getElement(mRID, ((Substation)parent).getVoltageLevels());
		}
		else if (klass == Bay.class) {
			if (parent instanceof VoltageLevel) 
				return (Bay)getElement(mRID, ((VoltageLevel)parent).getBays());
			else if (parent instanceof Substation)
				return (Bay)getElement(mRID, ((Substation)parent).getBays());
		}
		else if (klass == Equipment.class) {
			if (parent instanceof Bay) 
				return (Equipment)getElement(mRID, ((Bay)parent).getEquipments());
			else if (parent instanceof VoltageLevel) 
				return (Equipment)getElement(mRID, ((VoltageLevel)parent).getEquipments());
			else if (parent instanceof Substation)
				return (Equipment)getElement(mRID, ((Substation)parent).getEquipments());
		}
		else if (klass == SynchronousMachine.class) {
			return (SynchronousMachine)getElement(mRID, ((GeneratingUnit)parent).getSynchronousMachines());
		}
		else if (klass == ACLineSegment.class) {
			return (ACLineSegment)getElement(mRID, ((Line)parent).getACLineSegments());
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PowerSystemResource getPsResource(String mRID, Class klass) {
		if (klass == SubControlArea.class) {
			return (SubControlArea)getElement(mRID, getPsResources());
		}
		else if (klass == Substation.class) {
			for (Object obj : getPsResources()) {
				if (obj instanceof SubControlArea) {
					Substation sub = (Substation)getElement(mRID, ((SubControlArea)obj).getSubstations());
					if (sub != null) 
						return sub;
				}
			}
		}
		else if (klass == VoltageLevel.class) {
			for (Object cArea : getPsResources()) {
				if (cArea instanceof SubControlArea) {
					for (Object sub : ((SubControlArea)cArea).getSubstations()) {
						VoltageLevel vlevel = (VoltageLevel)getElement(mRID, 
								((Substation)sub).getVoltageLevels());
						if (vlevel != null) 
							return vlevel;
					}
				}
			}
		}
		else if (klass == Bay.class) {
			for (Object cArea : getPsResources()) {
				if (cArea instanceof SubControlArea) {
					for (Object sub : ((SubControlArea)cArea).getSubstations()) {
						for (Object vlevel : ((Substation)sub).getVoltageLevels()) {
							Bay bay = (Bay)getElement(mRID, 
									((VoltageLevel)vlevel).getBays());
							if (bay != null) 
								return bay;
						}
						Bay bay = (Bay)getElement(mRID, ((Substation)sub).getBays());
						if (bay != null) 
							return bay;
					}
				}
			}
		}

		else if (klass == LoadArea.class) {
			return (LoadArea)getElement(mRID, getPsResources());
		}
		else if (klass == Equipment.class) {
			// search Equipment and its child class, Equipment could be contained by EquipmentContainer (Substation, VoltageLevel and Bay)
			for (Object cArea : getPsResources()) {
				if (cArea instanceof SubControlArea) {
					for (Object sub : ((SubControlArea)cArea).getSubstations()) {
						for (Object vlevel : ((Substation)sub).getVoltageLevels()) {
							for (Object bay : ((VoltageLevel)vlevel).getBays()) {
								Equipment equipment = (Equipment)getElement(mRID, ((Bay)bay).getEquipments());
								if (equipment != null) 
									return equipment;
							}
							Equipment equipment = (Equipment)getElement(mRID, ((VoltageLevel)vlevel).getEquipments());
							if (equipment != null) 
								return equipment;
						}
						Equipment equipment = (Equipment)getElement(mRID, ((Substation)sub).getEquipments());
						if (equipment != null) 
							return equipment;
					}
				}
			}
		}
		else if (klass == Line.class) {
			return (Line)getElement(mRID, getPsResources());
		}
		else if (klass == ACLineSegment.class) {
			for (Object obj : getPsResources()) {
				if (obj instanceof Line) {
					ACLineSegment seg = (ACLineSegment)getElement(mRID, ((Line)obj).getACLineSegments());
					if (seg != null) 
						return seg;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case cimPackage.SIMULATION_MODEL__COMPANIES:
				return ((InternalEList)getCompanies()).basicAdd(otherEnd, msgs);
			case cimPackage.SIMULATION_MODEL__TOPOLOGICAL_ISLANDS:
				return ((InternalEList)getTopologicalIslands()).basicAdd(otherEnd, msgs);
			case cimPackage.SIMULATION_MODEL__PS_RESOURCES:
				return ((InternalEList)getPsResources()).basicAdd(otherEnd, msgs);
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
			case cimPackage.SIMULATION_MODEL__BASE_POWER:
				return basicSetBasePower(null, msgs);
			case cimPackage.SIMULATION_MODEL__COMPANIES:
				return ((InternalEList)getCompanies()).basicRemove(otherEnd, msgs);
			case cimPackage.SIMULATION_MODEL__TOPOLOGICAL_ISLANDS:
				return ((InternalEList)getTopologicalIslands()).basicRemove(otherEnd, msgs);
			case cimPackage.SIMULATION_MODEL__PS_RESOURCES:
				return ((InternalEList)getPsResources()).basicRemove(otherEnd, msgs);
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
			case cimPackage.SIMULATION_MODEL__BASE_POWER:
				return getBasePower();
			case cimPackage.SIMULATION_MODEL__COMPANIES:
				return getCompanies();
			case cimPackage.SIMULATION_MODEL__TOPOLOGICAL_ISLANDS:
				return getTopologicalIslands();
			case cimPackage.SIMULATION_MODEL__PS_RESOURCES:
				return getPsResources();
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
			case cimPackage.SIMULATION_MODEL__BASE_POWER:
				setBasePower((BasePower)newValue);
				return;
			case cimPackage.SIMULATION_MODEL__COMPANIES:
				getCompanies().clear();
				getCompanies().addAll((Collection)newValue);
				return;
			case cimPackage.SIMULATION_MODEL__TOPOLOGICAL_ISLANDS:
				getTopologicalIslands().clear();
				getTopologicalIslands().addAll((Collection)newValue);
				return;
			case cimPackage.SIMULATION_MODEL__PS_RESOURCES:
				getPsResources().clear();
				getPsResources().addAll((Collection)newValue);
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
			case cimPackage.SIMULATION_MODEL__BASE_POWER:
				setBasePower((BasePower)null);
				return;
			case cimPackage.SIMULATION_MODEL__COMPANIES:
				getCompanies().clear();
				return;
			case cimPackage.SIMULATION_MODEL__TOPOLOGICAL_ISLANDS:
				getTopologicalIslands().clear();
				return;
			case cimPackage.SIMULATION_MODEL__PS_RESOURCES:
				getPsResources().clear();
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
			case cimPackage.SIMULATION_MODEL__BASE_POWER:
				return basePower != null;
			case cimPackage.SIMULATION_MODEL__COMPANIES:
				return companies != null && !companies.isEmpty();
			case cimPackage.SIMULATION_MODEL__TOPOLOGICAL_ISLANDS:
				return topologicalIslands != null && !topologicalIslands.isEmpty();
			case cimPackage.SIMULATION_MODEL__PS_RESOURCES:
				return psResources != null && !psResources.isEmpty();
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
		result.append("SimulationModel: \n" + super.toString() + "\n\n");

		result.append(getCompanies().toString() + "\n");

		result.append(getBasePower().toString());

		result.append(getTopologicalIslands().toString() + "\n\n");

		result.append(getPsResources().toString() + "\n\n");
		return result.toString();
	}
} //SimulationModelImpl