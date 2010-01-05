/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoadAreaImpl.java,v 1.3 2007/03/07 05:14:05 mzhou Exp $
 */
package org.opencim.cim.iec61970.load.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.Substation;
import org.opencim.cim.iec61970.core.impl.CorePackageImpl;
import org.opencim.cim.iec61970.core.impl.PowerSystemResourceImpl;
import org.opencim.cim.iec61970.load.AreaLoadCurve;
import org.opencim.cim.iec61970.load.AreaLossCurve;
import org.opencim.cim.iec61970.load.LoadArea;
import org.opencim.cim.iec61970.load.LoadPackage;
import org.opencim.cim.iec61970.wire.EnergyConsumer;
import org.opencim.cim.iec61970.wire.impl.WirePackageImpl;

import org.opencim.cim.iec61970.wire.WirePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.LoadAreaImpl#getEnergyConsumers <em>Energy Consumers</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.LoadAreaImpl#getAreaLossCurves <em>Area Loss Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.LoadAreaImpl#getAreaLoadCurves <em>Area Load Curves</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.load.impl.LoadAreaImpl#getSubstations <em>Substations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoadAreaImpl extends PowerSystemResourceImpl implements LoadArea {
	/**
	 * The cached value of the '{@link #getEnergyConsumers() <em>Energy Consumers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergyConsumers()
	 * @generated
	 * @ordered
	 */
	protected EList energyConsumers;

	/**
	 * The cached value of the '{@link #getAreaLossCurves() <em>Area Loss Curves</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAreaLossCurves()
	 * @generated
	 * @ordered
	 */
	protected EList areaLossCurves;

	/**
	 * The cached value of the '{@link #getAreaLoadCurves() <em>Area Load Curves</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAreaLoadCurves()
	 * @generated
	 * @ordered
	 */
	protected EList areaLoadCurves;

	/**
	 * The cached value of the '{@link #getSubstations() <em>Substations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubstations()
	 * @generated
	 * @ordered
	 */
	protected EList substations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoadAreaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LoadPackage.Literals.LOAD_AREA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEnergyConsumers() {
		if (energyConsumers == null) {
			energyConsumers = new EObjectWithInverseResolvingEList(EnergyConsumer.class, this, LoadPackage.LOAD_AREA__ENERGY_CONSUMERS, WirePackage.ENERGY_CONSUMER__LOAD_AREA);
		}
		return energyConsumers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAreaLossCurves() {
		if (areaLossCurves == null) {
			areaLossCurves = new EObjectContainmentWithInverseEList(AreaLossCurve.class, this, LoadPackage.LOAD_AREA__AREA_LOSS_CURVES, LoadPackage.AREA_LOSS_CURVE__LOAD_AREA);
		}
		return areaLossCurves;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAreaLoadCurves() {
		if (areaLoadCurves == null) {
			areaLoadCurves = new EObjectContainmentWithInverseEList(AreaLoadCurve.class, this, LoadPackage.LOAD_AREA__AREA_LOAD_CURVES, LoadPackage.AREA_LOAD_CURVE__LOAD_AREA);
		}
		return areaLoadCurves;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSubstations() {
		if (substations == null) {
			substations = new EObjectWithInverseResolvingEList(Substation.class, this, LoadPackage.LOAD_AREA__SUBSTATIONS, CorePackage.SUBSTATION__LOAD_AREA);
		}
		return substations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LoadPackage.LOAD_AREA__ENERGY_CONSUMERS:
				return ((InternalEList)getEnergyConsumers()).basicAdd(otherEnd, msgs);
			case LoadPackage.LOAD_AREA__AREA_LOSS_CURVES:
				return ((InternalEList)getAreaLossCurves()).basicAdd(otherEnd, msgs);
			case LoadPackage.LOAD_AREA__AREA_LOAD_CURVES:
				return ((InternalEList)getAreaLoadCurves()).basicAdd(otherEnd, msgs);
			case LoadPackage.LOAD_AREA__SUBSTATIONS:
				return ((InternalEList)getSubstations()).basicAdd(otherEnd, msgs);
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
			case LoadPackage.LOAD_AREA__ENERGY_CONSUMERS:
				return ((InternalEList)getEnergyConsumers()).basicRemove(otherEnd, msgs);
			case LoadPackage.LOAD_AREA__AREA_LOSS_CURVES:
				return ((InternalEList)getAreaLossCurves()).basicRemove(otherEnd, msgs);
			case LoadPackage.LOAD_AREA__AREA_LOAD_CURVES:
				return ((InternalEList)getAreaLoadCurves()).basicRemove(otherEnd, msgs);
			case LoadPackage.LOAD_AREA__SUBSTATIONS:
				return ((InternalEList)getSubstations()).basicRemove(otherEnd, msgs);
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
			case LoadPackage.LOAD_AREA__ENERGY_CONSUMERS:
				return getEnergyConsumers();
			case LoadPackage.LOAD_AREA__AREA_LOSS_CURVES:
				return getAreaLossCurves();
			case LoadPackage.LOAD_AREA__AREA_LOAD_CURVES:
				return getAreaLoadCurves();
			case LoadPackage.LOAD_AREA__SUBSTATIONS:
				return getSubstations();
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
			case LoadPackage.LOAD_AREA__ENERGY_CONSUMERS:
				getEnergyConsumers().clear();
				getEnergyConsumers().addAll((Collection)newValue);
				return;
			case LoadPackage.LOAD_AREA__AREA_LOSS_CURVES:
				getAreaLossCurves().clear();
				getAreaLossCurves().addAll((Collection)newValue);
				return;
			case LoadPackage.LOAD_AREA__AREA_LOAD_CURVES:
				getAreaLoadCurves().clear();
				getAreaLoadCurves().addAll((Collection)newValue);
				return;
			case LoadPackage.LOAD_AREA__SUBSTATIONS:
				getSubstations().clear();
				getSubstations().addAll((Collection)newValue);
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
			case LoadPackage.LOAD_AREA__ENERGY_CONSUMERS:
				getEnergyConsumers().clear();
				return;
			case LoadPackage.LOAD_AREA__AREA_LOSS_CURVES:
				getAreaLossCurves().clear();
				return;
			case LoadPackage.LOAD_AREA__AREA_LOAD_CURVES:
				getAreaLoadCurves().clear();
				return;
			case LoadPackage.LOAD_AREA__SUBSTATIONS:
				getSubstations().clear();
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
			case LoadPackage.LOAD_AREA__ENERGY_CONSUMERS:
				return energyConsumers != null && !energyConsumers.isEmpty();
			case LoadPackage.LOAD_AREA__AREA_LOSS_CURVES:
				return areaLossCurves != null && !areaLossCurves.isEmpty();
			case LoadPackage.LOAD_AREA__AREA_LOAD_CURVES:
				return areaLoadCurves != null && !areaLoadCurves.isEmpty();
			case LoadPackage.LOAD_AREA__SUBSTATIONS:
				return substations != null && !substations.isEmpty();
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
		result.append("\nLoadArea: \n" + super.toString() + "\n");

		for (Object sub : this.getSubstations()) {
			result.append("     Belongs to Substations MRID: " + ((Substation)sub).getMRID() + "\n");
		}
		
		if (getEnergyConsumers().size() > 0)
			for (Object obj : getEnergyConsumers())
				result.append( "     Contains EnergyConsumer MRID: " + ((EnergyConsumer)obj).getMRID() + "\n");
		
		return result.toString();
	}	
} //LoadAreaImpl