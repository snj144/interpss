/**
 * <copyright>
 * </copyright>
 *
 * $Id: WireAdapterFactory.java,v 1.1 2007/03/02 14:01:18 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.opencim.cim.iec61970.core.ConductingEquipment;
import org.opencim.cim.iec61970.core.CurveSchedule;
import org.opencim.cim.iec61970.core.Equipment;
import org.opencim.cim.iec61970.core.EquipmentContainer;
import org.opencim.cim.iec61970.core.Naming;
import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.cim.iec61970.wire.*;

import org.opencim.cim.iec61970.wire.impl.WirePackageImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.wire.WirePackage
 * @generated
 */
public class WireAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WirePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WireAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = WirePackage.eINSTANCE;
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
	protected WireSwitch modelSwitch =
		new WireSwitch() {
			public Object caseACLineSegment(ACLineSegment object) {
				return createACLineSegmentAdapter();
			}
			public Object caseBreaker(Breaker object) {
				return createBreakerAdapter();
			}
			public Object caseBusbarSection(BusbarSection object) {
				return createBusbarSectionAdapter();
			}
			public Object caseCompensator(Compensator object) {
				return createCompensatorAdapter();
			}
			public Object caseConductor(Conductor object) {
				return createConductorAdapter();
			}
			public Object caseConductorType(ConductorType object) {
				return createConductorTypeAdapter();
			}
			public Object caseDCLineSegment(DCLineSegment object) {
				return createDCLineSegmentAdapter();
			}
			public Object caseDisconnector(Disconnector object) {
				return createDisconnectorAdapter();
			}
			public Object caseFuse(Fuse object) {
				return createFuseAdapter();
			}
			public Object caseGround(Ground object) {
				return createGroundAdapter();
			}
			public Object caseHeatExchanger(HeatExchanger object) {
				return createHeatExchangerAdapter();
			}
			public Object caseJumper(Jumper object) {
				return createJumperAdapter();
			}
			public Object caseRectifierInverter(RectifierInverter object) {
				return createRectifierInverterAdapter();
			}
			public Object caseRegulationSchedule(RegulationSchedule object) {
				return createRegulationScheduleAdapter();
			}
			public Object caseStaticVarCompensator(StaticVarCompensator object) {
				return createStaticVarCompensatorAdapter();
			}
			public Object caseSwitch(Switch object) {
				return createSwitchAdapter();
			}
			public Object caseTapChanger(TapChanger object) {
				return createTapChangerAdapter();
			}
			public Object casePowerTransformer(PowerTransformer object) {
				return createPowerTransformerAdapter();
			}
			public Object caseTransformerWinding(TransformerWinding object) {
				return createTransformerWindingAdapter();
			}
			public Object caseLine(Line object) {
				return createLineAdapter();
			}
			public Object caseVoltageControlZone(VoltageControlZone object) {
				return createVoltageControlZoneAdapter();
			}
			public Object caseWindingTest(WindingTest object) {
				return createWindingTestAdapter();
			}
			public Object caseSynchronousMachine(SynchronousMachine object) {
				return createSynchronousMachineAdapter();
			}
			public Object caseMVArCapabilityCurve(MVArCapabilityCurve object) {
				return createMVArCapabilityCurveAdapter();
			}
			public Object caseEquivalentSource(EquivalentSource object) {
				return createEquivalentSourceAdapter();
			}
			public Object caseWireType(WireType object) {
				return createWireTypeAdapter();
			}
			public Object caseWireArrangement(WireArrangement object) {
				return createWireArrangementAdapter();
			}
			public Object caseLoadBreakSwitch(LoadBreakSwitch object) {
				return createLoadBreakSwitchAdapter();
			}
			public Object caseJunction(Junction object) {
				return createJunctionAdapter();
			}
			public Object caseEnergyConsumer(EnergyConsumer object) {
				return createEnergyConsumerAdapter();
			}
			public Object caseConnector(Connector object) {
				return createConnectorAdapter();
			}
			public Object caseRegulatingCondEq(RegulatingCondEq object) {
				return createRegulatingCondEqAdapter();
			}
			public Object caseGroundDisconnector(GroundDisconnector object) {
				return createGroundDisconnectorAdapter();
			}
			public Object caseCompositeSwitch(CompositeSwitch object) {
				return createCompositeSwitchAdapter();
			}
			public Object caseWiresVersion(WiresVersion object) {
				return createWiresVersionAdapter();
			}
			public Object caseFrequencyConverter(FrequencyConverter object) {
				return createFrequencyConverterAdapter();
			}
			public Object caseNaming(Naming object) {
				return createNamingAdapter();
			}
			public Object casePowerSystemResource(PowerSystemResource object) {
				return createPowerSystemResourceAdapter();
			}
			public Object caseEquipment(Equipment object) {
				return createEquipmentAdapter();
			}
			public Object caseConductingEquipment(ConductingEquipment object) {
				return createConductingEquipmentAdapter();
			}
			public Object caseCurveSchedule(CurveSchedule object) {
				return createCurveScheduleAdapter();
			}
			public Object caseEquipmentContainer(EquipmentContainer object) {
				return createEquipmentContainerAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.ACLineSegment <em>AC Line Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.ACLineSegment
	 * @generated
	 */
	public Adapter createACLineSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.Breaker <em>Breaker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.Breaker
	 * @generated
	 */
	public Adapter createBreakerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.BusbarSection <em>Busbar Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.BusbarSection
	 * @generated
	 */
	public Adapter createBusbarSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.Compensator <em>Compensator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.Compensator
	 * @generated
	 */
	public Adapter createCompensatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.Conductor <em>Conductor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.Conductor
	 * @generated
	 */
	public Adapter createConductorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.ConductorType <em>Conductor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.ConductorType
	 * @generated
	 */
	public Adapter createConductorTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.DCLineSegment <em>DC Line Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.DCLineSegment
	 * @generated
	 */
	public Adapter createDCLineSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.Disconnector <em>Disconnector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.Disconnector
	 * @generated
	 */
	public Adapter createDisconnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.Fuse <em>Fuse</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.Fuse
	 * @generated
	 */
	public Adapter createFuseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.Ground <em>Ground</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.Ground
	 * @generated
	 */
	public Adapter createGroundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.HeatExchanger <em>Heat Exchanger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.HeatExchanger
	 * @generated
	 */
	public Adapter createHeatExchangerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.Jumper <em>Jumper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.Jumper
	 * @generated
	 */
	public Adapter createJumperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.RectifierInverter <em>Rectifier Inverter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.RectifierInverter
	 * @generated
	 */
	public Adapter createRectifierInverterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.RegulationSchedule <em>Regulation Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.RegulationSchedule
	 * @generated
	 */
	public Adapter createRegulationScheduleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.StaticVarCompensator <em>Static Var Compensator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.StaticVarCompensator
	 * @generated
	 */
	public Adapter createStaticVarCompensatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.Switch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.Switch
	 * @generated
	 */
	public Adapter createSwitchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.TapChanger <em>Tap Changer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.TapChanger
	 * @generated
	 */
	public Adapter createTapChangerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.PowerTransformer <em>Power Transformer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.PowerTransformer
	 * @generated
	 */
	public Adapter createPowerTransformerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.TransformerWinding <em>Transformer Winding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding
	 * @generated
	 */
	public Adapter createTransformerWindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.Line <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.Line
	 * @generated
	 */
	public Adapter createLineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.VoltageControlZone <em>Voltage Control Zone</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.VoltageControlZone
	 * @generated
	 */
	public Adapter createVoltageControlZoneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.WindingTest <em>Winding Test</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.WindingTest
	 * @generated
	 */
	public Adapter createWindingTestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.SynchronousMachine <em>Synchronous Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.SynchronousMachine
	 * @generated
	 */
	public Adapter createSynchronousMachineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.MVArCapabilityCurve <em>MV Ar Capability Curve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.MVArCapabilityCurve
	 * @generated
	 */
	public Adapter createMVArCapabilityCurveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.EquivalentSource <em>Equivalent Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.EquivalentSource
	 * @generated
	 */
	public Adapter createEquivalentSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.WireType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.WireType
	 * @generated
	 */
	public Adapter createWireTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.WireArrangement <em>Arrangement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.WireArrangement
	 * @generated
	 */
	public Adapter createWireArrangementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.LoadBreakSwitch <em>Load Break Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.LoadBreakSwitch
	 * @generated
	 */
	public Adapter createLoadBreakSwitchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.Junction <em>Junction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.Junction
	 * @generated
	 */
	public Adapter createJunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.EnergyConsumer <em>Energy Consumer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.EnergyConsumer
	 * @generated
	 */
	public Adapter createEnergyConsumerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.Connector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.Connector
	 * @generated
	 */
	public Adapter createConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.RegulatingCondEq <em>Regulating Cond Eq</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.RegulatingCondEq
	 * @generated
	 */
	public Adapter createRegulatingCondEqAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.GroundDisconnector <em>Ground Disconnector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.GroundDisconnector
	 * @generated
	 */
	public Adapter createGroundDisconnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.CompositeSwitch <em>Composite Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.CompositeSwitch
	 * @generated
	 */
	public Adapter createCompositeSwitchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.WiresVersion <em>Wires Version</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.WiresVersion
	 * @generated
	 */
	public Adapter createWiresVersionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opencim.cim.iec61970.wire.FrequencyConverter <em>Frequency Converter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opencim.cim.iec61970.wire.FrequencyConverter
	 * @generated
	 */
	public Adapter createFrequencyConverterAdapter() {
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

} //WireAdapterFactory
