/**
 * <copyright>
 * </copyright>
 *
 * $Id: Season.java,v 1.1 2007/03/02 14:01:12 mzhou Exp $
 */
package org.opencim.cim.iec61970.load;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.opencim.cim.iec61970.domain.SeasonName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Season</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A specified time period of the year, e.g., Spring, Summer, Fall, Winter
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.Season#getName <em>Name</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.Season#getEndDate <em>End Date</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.Season#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.Season#getAreaLoadCurves <em>Area Load Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.Season#getLoadDemandModels <em>Load Demand Models</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.load.LoadPackage#getSeason()
 * @generated
 */
public interface Season extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.SeasonName}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of the Season
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.SeasonName
	 * @see #setName(SeasonName)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getSeason_Name()
	 * @generated
	 */
	SeasonName getName();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.Season#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.SeasonName
	 * @see #getName()
	 * @generated
	 */
	void setName(SeasonName value);

	/**
	 * Returns the value of the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Date season ends
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>End Date</em>' attribute.
	 * @see #setEndDate(Date)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getSeason_EndDate()
	 * @generated
	 */
	Date getEndDate();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.Season#getEndDate <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Date</em>' attribute.
	 * @see #getEndDate()
	 * @generated
	 */
	void setEndDate(Date value);

	/**
	 * Returns the value of the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Date season starts
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start Date</em>' attribute.
	 * @see #setStartDate(Date)
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getSeason_StartDate()
	 * @generated
	 */
	Date getStartDate();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.load.Season#getStartDate <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Date</em>' attribute.
	 * @see #getStartDate()
	 * @generated
	 */
	void setStartDate(Date value);

	/**
	 * Returns the value of the '<em><b>Area Load Curves</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.load.AreaLoadCurve}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.AreaLoadCurve#getSeason <em>Season</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A system load model may be classified as seasonal
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Area Load Curves</em>' reference list.
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getSeason_AreaLoadCurves()
	 * @see org.opencim.cim.iec61970.load.AreaLoadCurve#getSeason
	 * @generated
	 */
	EList getAreaLoadCurves();

	/**
	 * Returns the value of the '<em><b>Load Demand Models</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.load.LoadDemandModel}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.LoadDemandModel#getBasisFor <em>Basis For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Load demand models can be based on seasons
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Load Demand Models</em>' reference list.
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getSeason_LoadDemandModels()
	 * @see org.opencim.cim.iec61970.load.LoadDemandModel#getBasisFor
	 * @generated
	 */
	EList getLoadDemandModels();

} // Season