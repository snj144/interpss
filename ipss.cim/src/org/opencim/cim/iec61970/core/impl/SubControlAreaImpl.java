/**
 * <copyright>
 * </copyright>
 *
 * $Id: SubControlAreaImpl.java,v 1.4 2007/03/07 05:14:03 mzhou Exp $
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
import org.opencim.cim.iec61970.core.SubControlArea;
import org.opencim.cim.iec61970.core.Substation;

import org.opencim.cim.iec61970.gen.production.GeneratingUnit;
import org.opencim.cim.iec61970.gen.production.ProductionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Control Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.SubControlAreaImpl#getSubstations <em>Substations</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.SubControlAreaImpl#getGeneratingUnits <em>Generating Units</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubControlAreaImpl extends PowerSystemResourceImpl implements SubControlArea {
	/**
	 * The cached value of the '{@link #getSubstations() <em>Substations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubstations()
	 * @generated
	 * @ordered
	 */
	protected EList substations = null;

	/**
	 * The cached value of the '{@link #getGeneratingUnits() <em>Generating Units</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratingUnits()
	 * @generated
	 * @ordered
	 */
	protected EList generatingUnits = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubControlAreaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.SUB_CONTROL_AREA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSubstations() {
		if (substations == null) {
			substations = new EObjectContainmentWithInverseEList(Substation.class, this, CorePackage.SUB_CONTROL_AREA__SUBSTATIONS, CorePackage.SUBSTATION__SUB_CONTROL_AREA);
		}
		return substations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getGeneratingUnits() {
		if (generatingUnits == null) {
			generatingUnits = new EObjectWithInverseResolvingEList(GeneratingUnit.class, this, CorePackage.SUB_CONTROL_AREA__GENERATING_UNITS, ProductionPackage.GENERATING_UNIT__SUB_CONTROL_AREA);
		}
		return generatingUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.SUB_CONTROL_AREA__SUBSTATIONS:
				return ((InternalEList)getSubstations()).basicAdd(otherEnd, msgs);
			case CorePackage.SUB_CONTROL_AREA__GENERATING_UNITS:
				return ((InternalEList)getGeneratingUnits()).basicAdd(otherEnd, msgs);
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
			case CorePackage.SUB_CONTROL_AREA__SUBSTATIONS:
				return ((InternalEList)getSubstations()).basicRemove(otherEnd, msgs);
			case CorePackage.SUB_CONTROL_AREA__GENERATING_UNITS:
				return ((InternalEList)getGeneratingUnits()).basicRemove(otherEnd, msgs);
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
			case CorePackage.SUB_CONTROL_AREA__SUBSTATIONS:
				return getSubstations();
			case CorePackage.SUB_CONTROL_AREA__GENERATING_UNITS:
				return getGeneratingUnits();
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
			case CorePackage.SUB_CONTROL_AREA__SUBSTATIONS:
				getSubstations().clear();
				getSubstations().addAll((Collection)newValue);
				return;
			case CorePackage.SUB_CONTROL_AREA__GENERATING_UNITS:
				getGeneratingUnits().clear();
				getGeneratingUnits().addAll((Collection)newValue);
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
			case CorePackage.SUB_CONTROL_AREA__SUBSTATIONS:
				getSubstations().clear();
				return;
			case CorePackage.SUB_CONTROL_AREA__GENERATING_UNITS:
				getGeneratingUnits().clear();
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
			case CorePackage.SUB_CONTROL_AREA__SUBSTATIONS:
				return substations != null && !substations.isEmpty();
			case CorePackage.SUB_CONTROL_AREA__GENERATING_UNITS:
				return generatingUnits != null && !generatingUnits.isEmpty();
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
		result.append("SubControlArea: \n" + super.toString() + "\n");
		result.append(getSubstations().toString() + "\n");
		return result.toString();
	}	
} //SubControlAreaImpl