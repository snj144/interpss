/**
 * <copyright>
 * </copyright>
 *
 * $Id: CoreAdapterFactory.java,v 1.2 2007/03/07 16:03:49 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.opencim.cim.iec61970.core.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.core.CorePackage
 * @generated
 */
public class CoreAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CorePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CorePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreSwitch modelSwitch =
		new CoreSwitch() {
			public Object caseBay(Bay object) {
				return createBayAdapter();
			}
			public Object caseConductingEquipment(ConductingEquipment object) {
				return createConductingEquipmentAdapter();
			}
			public Object caseControlHouseEquipment(ControlHouseEquipment object) {
				return createControlHouseEquipmentAdapter();
			}
			public Object casePowerSystemResource(PowerSystemResource object) {
				return createPowerSystemResourceAdapter();
			}
			public Object caseSubstation(Substation object) {
				return createSubstationAdapter();
			}
			public Object caseTerminal(Terminal object) {
				return createTerminalAdapter();
			}
			public Object caseSubControlArea(SubControlArea object) {
				return createSubControlAreaAdapter();
			}
			public Object caseCurveSchedule(CurveSchedule object) {
				return createCurveScheduleAdapter();
			}
			public Object caseCurveSchedData(CurveSchedData object) {
				return createCurveSchedDataAdapter();
			}
			public Object caseCurveSchedFormula(CurveSchedFormula object) {
				return createCurveSchedFormulaAdapter();
			}
			public Object caseBaseVoltage(BaseVoltage object) {
				return createBaseVoltageAdapter();
			}
			public Object caseBasePower(BasePower object) {
				return createBasePowerAdapter();
			}
			public Object caseVoltageLevel(VoltageLevel object) {
				return createVoltageLevelAdapter();
			}
			public Object caseNaming(Naming object) {
				return createNamingAdapter();
			}
			public Object caseEquipment(Equipment object) {
				return createEquipmentAdapter();
			}
			public Object caseUnit(Unit object) {
				return createUnitAdapter();
			}
			public Object caseEquipmentContainer(EquipmentContainer object) {
				return createEquipmentContainerAdapter();
			}
			public Object casePSRType(PSRType object) {
				return createPSRTypeAdapter();
			}
			public Object caseCoreVersion(CoreVersion object) {
				return createCoreVersionAdapter();
			}
			public Object caseCompany(Company object) {
				return createCompanyAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.Bay <em>Bay</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.Bay
	 * @generated
	 */
	public Adapter createBayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.Company <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.Company
	 * @generated
	 */
	public Adapter createCompanyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.ConductingEquipment <em>Conducting Equipment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.ConductingEquipment
	 * @generated
	 */
	public Adapter createConductingEquipmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.ControlHouseEquipment <em>Control House Equipment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.ControlHouseEquipment
	 * @generated
	 */
	public Adapter createControlHouseEquipmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.PowerSystemResource <em>Power System Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.PowerSystemResource
	 * @generated
	 */
	public Adapter createPowerSystemResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.Substation <em>Substation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.Substation
	 * @generated
	 */
	public Adapter createSubstationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.Terminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.Terminal
	 * @generated
	 */
	public Adapter createTerminalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.SubControlArea <em>Sub Control Area</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.SubControlArea
	 * @generated
	 */
	public Adapter createSubControlAreaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.CurveSchedule <em>Curve Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.CurveSchedule
	 * @generated
	 */
	public Adapter createCurveScheduleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.CurveSchedData <em>Curve Sched Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.CurveSchedData
	 * @generated
	 */
	public Adapter createCurveSchedDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.CurveSchedFormula <em>Curve Sched Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.CurveSchedFormula
	 * @generated
	 */
	public Adapter createCurveSchedFormulaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.BaseVoltage <em>Base Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.BaseVoltage
	 * @generated
	 */
	public Adapter createBaseVoltageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.BasePower <em>Base Power</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.BasePower
	 * @generated
	 */
	public Adapter createBasePowerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.VoltageLevel <em>Voltage Level</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.VoltageLevel
	 * @generated
	 */
	public Adapter createVoltageLevelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.Naming <em>Naming</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.Naming
	 * @generated
	 */
	public Adapter createNamingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.Equipment <em>Equipment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.Equipment
	 * @generated
	 */
	public Adapter createEquipmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.Unit
	 * @generated
	 */
	public Adapter createUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.EquipmentContainer <em>Equipment Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.EquipmentContainer
	 * @generated
	 */
	public Adapter createEquipmentContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.PSRType <em>PSR Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.PSRType
	 * @generated
	 */
	public Adapter createPSRTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.core.CoreVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.core.CoreVersion
	 * @generated
	 */
	public Adapter createCoreVersionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CoreAdapterFactory
