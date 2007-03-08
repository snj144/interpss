/**
 * <copyright>
 * </copyright>
 *
 * $Id: DayType.java,v 1.1 2007/03/02 14:01:13 mzhou Exp $
 */
package org.opencim.cim.iec61970.load;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.Naming;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Day Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Group of similar days, e.g., Mon/Tue/Wed, Thu/Fri, Sat/Sun, Holiday1, Holiday2
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.DayType#getAreaLoadCurves <em>Area Load Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.DayType#getLoadDemandModels <em>Load Demand Models</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.load.LoadPackage#getDayType()
 * @model
 * @generated
 */
public interface DayType extends Naming {
	/**
	 * Returns the value of the '<em><b>Area Load Curves</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.load.AreaLoadCurve}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.AreaLoadCurve#getDayType <em>Day Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A load model may be classified by the day type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Area Load Curves</em>' reference list.
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getDayType_AreaLoadCurves()
	 * @see org.opencim.cim.iec61970.load.AreaLoadCurve#getDayType
	 * @model type="org.opencim.cim.iec61970.load.AreaLoadCurve" opposite="DayType"
	 * @generated
	 */
	EList getAreaLoadCurves();

	/**
	 * Returns the value of the '<em><b>Load Demand Models</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.load.LoadDemandModel}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.load.LoadDemandModel#getDayType <em>Day Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Load demand models can be based on day type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Load Demand Models</em>' reference list.
	 * @see org.opencim.cim.iec61970.load.LoadPackage#getDayType_LoadDemandModels()
	 * @see org.opencim.cim.iec61970.load.LoadDemandModel#getDayType
	 * @model type="org.opencim.cim.iec61970.load.LoadDemandModel" opposite="DayType"
	 * @generated
	 */
	EList getLoadDemandModels();

} // DayType