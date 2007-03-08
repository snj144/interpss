/**
 * <copyright>
 * </copyright>
 *
 * $Id: LineImpl.java,v 1.3 2007/03/08 00:05:30 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opencim.cim.iec61970.core.Substation;
import org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl;

import org.opencim.cim.iec61970.wire.ACLineSegment;
import org.opencim.cim.iec61970.wire.DCLineSegment;
import org.opencim.cim.iec61970.wire.EnergyConsumer;
import org.opencim.cim.iec61970.wire.Line;
import org.opencim.cim.iec61970.wire.WirePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.LineImpl#getACLineSegments <em>AC Line Segments</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.impl.LineImpl#getDCLineSegments <em>DC Line Segments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LineImpl extends PowerSystemResourceImpl implements Line {
	/**
	 * The cached value of the '{@link #getACLineSegments() <em>AC Line Segments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getACLineSegments()
	 * @generated
	 * @ordered
	 */
	protected EList acLineSegments = null;

	/**
	 * The cached value of the '{@link #getDCLineSegments() <em>DC Line Segments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDCLineSegments()
	 * @generated
	 * @ordered
	 */
	protected EList dcLineSegments = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WirePackage.Literals.LINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getACLineSegments() {
		if (acLineSegments == null) {
			acLineSegments = new EObjectContainmentWithInverseEList(ACLineSegment.class, this, WirePackage.LINE__AC_LINE_SEGMENTS, WirePackage.AC_LINE_SEGMENT__LINE);
		}
		return acLineSegments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDCLineSegments() {
		if (dcLineSegments == null) {
			dcLineSegments = new EObjectContainmentWithInverseEList(DCLineSegment.class, this, WirePackage.LINE__DC_LINE_SEGMENTS, WirePackage.DC_LINE_SEGMENT__LINE);
		}
		return dcLineSegments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WirePackage.LINE__AC_LINE_SEGMENTS:
				return ((InternalEList)getACLineSegments()).basicAdd(otherEnd, msgs);
			case WirePackage.LINE__DC_LINE_SEGMENTS:
				return ((InternalEList)getDCLineSegments()).basicAdd(otherEnd, msgs);
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
			case WirePackage.LINE__AC_LINE_SEGMENTS:
				return ((InternalEList)getACLineSegments()).basicRemove(otherEnd, msgs);
			case WirePackage.LINE__DC_LINE_SEGMENTS:
				return ((InternalEList)getDCLineSegments()).basicRemove(otherEnd, msgs);
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
			case WirePackage.LINE__AC_LINE_SEGMENTS:
				return getACLineSegments();
			case WirePackage.LINE__DC_LINE_SEGMENTS:
				return getDCLineSegments();
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
			case WirePackage.LINE__AC_LINE_SEGMENTS:
				getACLineSegments().clear();
				getACLineSegments().addAll((Collection)newValue);
				return;
			case WirePackage.LINE__DC_LINE_SEGMENTS:
				getDCLineSegments().clear();
				getDCLineSegments().addAll((Collection)newValue);
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
			case WirePackage.LINE__AC_LINE_SEGMENTS:
				getACLineSegments().clear();
				return;
			case WirePackage.LINE__DC_LINE_SEGMENTS:
				getDCLineSegments().clear();
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
			case WirePackage.LINE__AC_LINE_SEGMENTS:
				return acLineSegments != null && !acLineSegments.isEmpty();
			case WirePackage.LINE__DC_LINE_SEGMENTS:
				return dcLineSegments != null && !dcLineSegments.isEmpty();
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
		result.append("\nLine: \n" + super.toString() + "\n");

		for (Object line : this.getACLineSegments()) {
			result.append(line.toString() + "\n");
		}
		
		return result.toString();
	}	
} //LineImpl