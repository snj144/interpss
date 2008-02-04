/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimulationModel.java,v 1.6 2007/03/07 16:03:48 mzhou Exp $
 */
package org.opencim.cim;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.BasePower;
import org.opencim.cim.iec61970.core.BaseVoltage;
import org.opencim.cim.iec61970.core.Bay;
import org.opencim.cim.iec61970.core.Company;
import org.opencim.cim.iec61970.core.Naming;

import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.cim.iec61970.core.SubControlArea;

import org.opencim.cim.iec61970.core.Substation;
import org.opencim.cim.iec61970.core.VoltageLevel;

import org.opencim.cim.iec61970.topology.ConnectivityNode;
import org.opencim.cim.iec61970.topology.TopologicalIsland;

import org.opencim.cim.iec61970.topology.TopologicalNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A container of CIM objects for simulation purpose. Copyright www.opencim.org 2007
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.SimulationModel#getBasePower <em>Base Power</em>}</li>
 *   <li>{@link org.opencim.cim.SimulationModel#getCompanies <em>Companies</em>}</li>
 *   <li>{@link org.opencim.cim.SimulationModel#getTopologicalIslands <em>Topological Islands</em>}</li>
 *   <li>{@link org.opencim.cim.SimulationModel#getPsResources <em>Ps Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.cimPackage#getSimulationModel()
 * @generated
 */
public interface SimulationModel extends Naming {
	/**
	 * Returns the value of the '<em><b>Base Power</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Power</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * BasePower object for the simulation purpose. It also contains all BaseVoltage objects.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base Power</em>' containment reference.
	 * @see #setBasePower(BasePower)
	 * @see org.opencim.cim.cimPackage#getSimulationModel_BasePower()
	 * @generated
	 */
	BasePower getBasePower();

	/**
	 * Sets the value of the '{@link org.opencim.cim.SimulationModel#getBasePower <em>Base Power</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Power</em>' containment reference.
	 * @see #getBasePower()
	 * @generated
	 */
	void setBasePower(BasePower value);

	/**
	 * Returns the value of the '<em><b>Companies</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.Company}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.Company#getSimuModel <em>Simu Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Companies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Companies</em>' containment reference list.
	 * @see org.opencim.cim.cimPackage#getSimulationModel_Companies()
	 * @see org.opencim.cim.iec61970.core.Company#getSimuModel
	 * @generated
	 */
	EList getCompanies();

	/**
	 * Returns the value of the '<em><b>Topological Islands</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.topology.TopologicalIsland}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.topology.TopologicalIsland#getSimuModel <em>Simu Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topological Islands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topological Islands</em>' containment reference list.
	 * @see org.opencim.cim.cimPackage#getSimulationModel_TopologicalIslands()
	 * @see org.opencim.cim.iec61970.topology.TopologicalIsland#getSimuModel
	 * @generated
	 */
	EList getTopologicalIslands();

	/**
	 * Returns the value of the '<em><b>Ps Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.core.PowerSystemResource}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.core.PowerSystemResource#getSimuModel <em>Simu Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ps Resource</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ps Resources</em>' containment reference list.
	 * @see org.opencim.cim.cimPackage#getSimulationModel_PsResources()
	 * @see org.opencim.cim.iec61970.core.PowerSystemResource#getSimuModel
	 * @generated
	 */
	EList getPsResources();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get BaseVoltage object by MRID
	 * @param mRID MRID per CIM specification
	 * <!-- end-model-doc -->
	 * @generated
	 */
	BaseVoltage getBaseVoltage(String mRID);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get Company object by MRID
	 * @param mRID MRID for CIM specificaiton
	 * <!-- end-model-doc -->
	 * @generated
	 */
	Company getCompany(String mRID);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get Topological object (Island, Node, ConnectivityNode or Terminal) by MRID and Class type.
	 * @param mRID MRID per CIM specification
	 * @param klass Class type: TopologicalIsland, TopologicalNode, ConnectivityNode or Terminal
	 * <!-- end-model-doc -->
	 * @generated
	 */
	Naming getTopologicalObject(String mRID, Class klass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get a Topological object by MRID and its parent container for performance purpose. 
	 * @param mRID MRID per CIM specification
	 * @param klass Class type of the object to get
	 * @param parent Object parent container. For example, a ConnectivityNode is always contained by a TopologicalNode object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	Naming getTopologicalObject(String mRID, Class klass, Object parent);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get a PowerSystemResource object by MRID
	 * @param mRID MRID per CIM specification
	 * @param klass Class type of the object to get
	 * <!-- end-model-doc -->
	 * @generated
	 */
	PowerSystemResource getPsResource(String mRID, Class klass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get a PowerSystemResource object by MRID and its parement container for performance prupose.
	 * @param mRID MRID per CIM specification.
	 * @param klass Class type of the object to get
	 * @param parent Parent container containing the object to get
	 * <!-- end-model-doc -->
	 * @generated
	 */
	PowerSystemResource getPsResource(String mRID, Class klass, Object parent);

} // SimulationModel